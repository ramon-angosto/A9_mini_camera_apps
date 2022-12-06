package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.IOUtils;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.ListPartsRequest;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.PartSummary;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExtensionRequestOperation {
    private static final ExecutorService executor = Executors.newFixedThreadPool(3);
    /* access modifiers changed from: private */
    public InternalRequestOperation apiOperation;

    public ExtensionRequestOperation(InternalRequestOperation internalRequestOperation) {
        this.apiOperation = internalRequestOperation;
    }

    public boolean doesObjectExist(String str, String str2) throws ClientException, ServiceException {
        try {
            this.apiOperation.headObject(new HeadObjectRequest(str, str2), (OSSCompletedCallback<HeadObjectRequest, HeadObjectResult>) null).getResult();
            return true;
        } catch (ServiceException e) {
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }

    public OSSAsyncTask<ResumableUploadResult> resumableUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback) {
        ExecutionContext executionContext = new ExecutionContext(this.apiOperation.getInnerClient(), resumableUploadRequest);
        return OSSAsyncTask.wrapRequestTask(executor.submit(new ResumableUploadTask(resumableUploadRequest, oSSCompletedCallback, executionContext)), executionContext);
    }

    class ResumableUploadTask implements Callable<ResumableUploadResult> {
        private OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> completedCallback;
        private ExecutionContext context;
        /* access modifiers changed from: private */
        public long currentUploadLength;
        /* access modifiers changed from: private */
        public long fileLength;
        private List<PartETag> partETags = new ArrayList();
        private File recordFile;
        /* access modifiers changed from: private */
        public ResumableUploadRequest request;
        private String uploadId;

        public ResumableUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext) {
            this.request = resumableUploadRequest;
            this.completedCallback = oSSCompletedCallback;
            this.context = executionContext;
        }

        public ResumableUploadResult call() throws Exception {
            try {
                initUploadId();
                ResumableUploadResult doMultipartUpload = doMultipartUpload();
                if (this.completedCallback != null) {
                    this.completedCallback.onSuccess(this.request, doMultipartUpload);
                }
                return doMultipartUpload;
            } catch (ServiceException e) {
                OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback = this.completedCallback;
                if (oSSCompletedCallback != null) {
                    oSSCompletedCallback.onFailure(this.request, (ClientException) null, e);
                }
                throw e;
            } catch (ClientException e2) {
                OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback2 = this.completedCallback;
                if (oSSCompletedCallback2 != null) {
                    oSSCompletedCallback2.onFailure(this.request, e2, (ServiceException) null);
                }
                throw e2;
            } catch (IOException e3) {
                ClientException clientException = new ClientException(e3.toString(), e3);
                OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback3 = this.completedCallback;
                if (oSSCompletedCallback3 != null) {
                    oSSCompletedCallback3.onFailure(this.request, clientException, (ServiceException) null);
                }
                throw clientException;
            }
        }

        private void initUploadId() throws IOException, ServiceException, ClientException {
            String uploadFilePath = this.request.getUploadFilePath();
            if (this.request.getRecordDirectory() != null) {
                String calculateMd5Str = BinaryUtil.calculateMd5Str(uploadFilePath);
                String calculateMd5Str2 = BinaryUtil.calculateMd5Str((calculateMd5Str + this.request.getBucketName() + this.request.getObjectKey() + String.valueOf(this.request.getPartSize())).getBytes());
                StringBuilder sb = new StringBuilder();
                sb.append(this.request.getRecordDirectory());
                sb.append("/");
                sb.append(calculateMd5Str2);
                this.recordFile = new File(sb.toString());
                if (this.recordFile.exists()) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(this.recordFile));
                    this.uploadId = bufferedReader.readLine();
                    bufferedReader.close();
                    OSSLog.logD("[initUploadId] - Found record file, uploadid: " + this.uploadId);
                    try {
                        for (PartSummary next : ExtensionRequestOperation.this.apiOperation.listParts(new ListPartsRequest(this.request.getBucketName(), this.request.getObjectKey(), this.uploadId), (OSSCompletedCallback<ListPartsRequest, ListPartsResult>) null).getResult().getParts()) {
                            this.partETags.add(new PartETag(next.getPartNumber(), next.getETag()));
                        }
                        return;
                    } catch (ServiceException e) {
                        if (e.getStatusCode() == 404) {
                            this.uploadId = null;
                        } else {
                            throw e;
                        }
                    } catch (ClientException e2) {
                        throw e2;
                    }
                }
                if (!this.recordFile.exists() && !this.recordFile.createNewFile()) {
                    throw new ClientException("Can't create file at path: " + this.recordFile.getAbsolutePath() + "\nPlease make sure the directory exist!");
                }
            }
            this.uploadId = ExtensionRequestOperation.this.apiOperation.initMultipartUpload(new InitiateMultipartUploadRequest(this.request.getBucketName(), this.request.getObjectKey(), this.request.getMetadata()), (OSSCompletedCallback<InitiateMultipartUploadRequest, InitiateMultipartUploadResult>) null).getResult().getUploadId();
            File file = this.recordFile;
            if (file != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(this.uploadId);
                bufferedWriter.close();
            }
        }

        private ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException {
            if (this.context.getCancellationHandler().isCancelled()) {
                abortThisResumableUpload();
                File file = this.recordFile;
                if (file != null) {
                    file.delete();
                }
                throwOutInterruptClientException();
            }
            long partSize = this.request.getPartSize();
            int i = 1;
            int size = this.partETags.size() + 1;
            File file2 = new File(this.request.getUploadFilePath());
            this.fileLength = file2.length();
            final OSSProgressCallback<ResumableUploadRequest> progressCallback = this.request.getProgressCallback();
            long j = this.fileLength;
            int i2 = (int) (j / partSize);
            long j2 = 0;
            if (j % partSize == 0) {
                i = 0;
            }
            int i3 = i2 + i;
            if (size <= i3) {
                this.currentUploadLength = ((long) (size - 1)) * partSize;
            } else {
                this.currentUploadLength = this.fileLength;
            }
            FileInputStream fileInputStream = new FileInputStream(file2);
            while (true) {
                long j3 = this.currentUploadLength;
                if (j2 < j3) {
                    long skip = fileInputStream.skip(j3 - j2);
                    if (skip != -1) {
                        j2 += skip;
                    } else {
                        throw new IOException("Skip failed! [fileLength]: " + this.fileLength + " [needSkip]: " + this.currentUploadLength);
                    }
                } else {
                    while (size <= i3) {
                        UploadPartRequest uploadPartRequest = new UploadPartRequest(this.request.getBucketName(), this.request.getObjectKey(), this.uploadId, size);
                        uploadPartRequest.setProgressCallback(new OSSProgressCallback<UploadPartRequest>() {
                            public void onProgress(UploadPartRequest uploadPartRequest, long j, long j2) {
                                OSSProgressCallback oSSProgressCallback = progressCallback;
                                if (oSSProgressCallback != null) {
                                    oSSProgressCallback.onProgress(ResumableUploadTask.this.request, ResumableUploadTask.this.currentUploadLength + j, ResumableUploadTask.this.fileLength);
                                }
                            }
                        });
                        int min = (int) Math.min(partSize, this.fileLength - this.currentUploadLength);
                        byte[] readStreamAsBytesArray = IOUtils.readStreamAsBytesArray(fileInputStream, min);
                        uploadPartRequest.setPartContent(readStreamAsBytesArray);
                        uploadPartRequest.setMd5Digest(BinaryUtil.calculateBase64Md5(readStreamAsBytesArray));
                        this.partETags.add(new PartETag(size, ExtensionRequestOperation.this.apiOperation.uploadPart(uploadPartRequest, (OSSCompletedCallback<UploadPartRequest, UploadPartResult>) null).getResult().getETag()));
                        this.currentUploadLength += (long) min;
                        size++;
                        if (this.context.getCancellationHandler().isCancelled()) {
                            abortThisResumableUpload();
                            File file3 = this.recordFile;
                            if (file3 != null) {
                                file3.delete();
                            }
                            throwOutInterruptClientException();
                        }
                    }
                    CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.request.getBucketName(), this.request.getObjectKey(), this.uploadId, this.partETags);
                    if (this.request.getCallbackParam() != null) {
                        completeMultipartUploadRequest.setCallbackParam(this.request.getCallbackParam());
                    }
                    if (this.request.getCallbackVars() != null) {
                        completeMultipartUploadRequest.setCallbackVars(this.request.getCallbackVars());
                    }
                    CompleteMultipartUploadResult result = ExtensionRequestOperation.this.apiOperation.completeMultipartUpload(completeMultipartUploadRequest, (OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult>) null).getResult();
                    File file4 = this.recordFile;
                    if (file4 != null) {
                        file4.delete();
                    }
                    return new ResumableUploadResult(result);
                }
            }
        }

        private void abortThisResumableUpload() {
            if (this.uploadId != null) {
                ExtensionRequestOperation.this.apiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(this.request.getBucketName(), this.request.getObjectKey(), this.uploadId), (OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult>) null).waitUntilFinished();
            }
        }

        private void throwOutInterruptClientException() throws ClientException {
            IOException iOException = new IOException();
            throw new ClientException(iOException.getMessage(), iOException);
        }
    }
}
