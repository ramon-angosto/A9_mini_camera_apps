package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SequenceUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex = new ArrayList();
    private File mCRC64RecordFile;
    private long mFirstPartSize;
    private File mRecordFile;
    private OSSSharedPreferences mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());

    public SequenceUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0182 A[Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initMultipartUploadId() throws java.io.IOException, com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        /*
            r13 = this;
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getRecordDirectory()
            boolean r0 = com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0235
            android.net.Uri r0 = r13.mUploadUri
            if (r0 == 0) goto L_0x003a
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r13.mContext
            android.content.Context r0 = r0.getApplicationContext()
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r2 = r13.mUploadUri
            java.lang.String r3 = "r"
            android.os.ParcelFileDescriptor r0 = r0.openFileDescriptor(r2, r3)
            java.io.FileDescriptor r2 = r0.getFileDescriptor()     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str((java.io.FileDescriptor) r2)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0040
            r0.close()
            goto L_0x0040
        L_0x0033:
            r1 = move-exception
            if (r0 == 0) goto L_0x0039
            r0.close()
        L_0x0039:
            throw r1
        L_0x003a:
            java.lang.String r0 = r13.mUploadFilePath
            java.lang.String r2 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str((java.lang.String) r0)
        L_0x0040:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r2 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r2 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r2
            java.lang.String r2 = r2.getBucketName()
            r0.append(r2)
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r2 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r2 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r2
            java.lang.String r2 = r2.getObjectKey()
            r0.append(r2)
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r2 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r2 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r2
            long r2 = r2.getPartSize()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.append(r2)
            boolean r2 = r13.mCheckCRC64
            if (r2 == 0) goto L_0x0074
            java.lang.String r2 = "-crc64"
            goto L_0x0076
        L_0x0074:
            java.lang.String r2 = ""
        L_0x0076:
            r0.append(r2)
            java.lang.String r2 = "-sequence"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            byte[] r0 = r0.getBytes()
            java.lang.String r0 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str((byte[]) r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r3 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r3 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r3
            java.lang.String r3 = r3.getRecordDirectory()
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            r13.mRecordFile = r2
            java.io.File r0 = r13.mRecordFile
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x00e0
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.FileReader r2 = new java.io.FileReader
            java.io.File r3 = r13.mRecordFile
            r2.<init>(r3)
            r0.<init>(r2)
            java.lang.String r2 = r0.readLine()
            r13.mUploadId = r2
            r0.close()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "sequence [initUploadId] - Found record file, uploadid: "
            r0.append(r2)
            java.lang.String r2 = r13.mUploadId
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r0)
        L_0x00e0:
            java.lang.String r0 = r13.mUploadId
            boolean r0 = com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            if (r0 != 0) goto L_0x0202
            boolean r0 = r13.mCheckCRC64
            if (r0 == 0) goto L_0x0140
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r2 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r2 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r2
            java.lang.String r2 = r2.getRecordDirectory()
            r0.append(r2)
            java.lang.String r2 = java.io.File.separator
            r0.append(r2)
            java.lang.String r2 = r13.mUploadId
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r0)
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x0140
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r2)
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream
            r3.<init>(r0)
            java.lang.Object r0 = r3.readObject()     // Catch:{ ClassNotFoundException -> 0x012d }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ ClassNotFoundException -> 0x012d }
            r2.delete()     // Catch:{ ClassNotFoundException -> 0x0129 }
            goto L_0x0132
        L_0x0129:
            r4 = move-exception
            goto L_0x012f
        L_0x012b:
            r0 = move-exception
            goto L_0x0139
        L_0x012d:
            r4 = move-exception
            r0 = r1
        L_0x012f:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r4)     // Catch:{ all -> 0x012b }
        L_0x0132:
            r3.close()
            r2.delete()
            goto L_0x0141
        L_0x0139:
            r3.close()
            r2.delete()
            throw r0
        L_0x0140:
            r0 = r1
        L_0x0141:
            r2 = 0
            r3 = 0
        L_0x0143:
            com.alibaba.sdk.android.oss.model.ListPartsRequest r4 = new com.alibaba.sdk.android.oss.model.ListPartsRequest
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r5 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r5 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r5
            java.lang.String r5 = r5.getBucketName()
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r6 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r6 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r6
            java.lang.String r6 = r6.getObjectKey()
            java.lang.String r7 = r13.mUploadId
            r4.<init>(r5, r6, r7)
            if (r3 <= 0) goto L_0x0163
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r4.setPartNumberMarker(r5)
        L_0x0163:
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r5 = r13.mApiOperation
            com.alibaba.sdk.android.oss.internal.OSSAsyncTask r4 = r5.listParts(r4, r1)
            com.alibaba.sdk.android.oss.model.OSSResult r5 = r4.getResult()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            com.alibaba.sdk.android.oss.model.ListPartsResult r5 = (com.alibaba.sdk.android.oss.model.ListPartsResult) r5     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            boolean r6 = r5.isTruncated()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            int r3 = r5.getNextPartNumberMarker()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            java.util.List r5 = r5.getParts()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            r7 = 0
        L_0x017c:
            int r8 = r5.size()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            if (r7 >= r8) goto L_0x01fb
            java.lang.Object r8 = r5.get(r7)     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            com.alibaba.sdk.android.oss.model.PartSummary r8 = (com.alibaba.sdk.android.oss.model.PartSummary) r8     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            com.alibaba.sdk.android.oss.model.PartETag r9 = new com.alibaba.sdk.android.oss.model.PartETag     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            int r10 = r8.getPartNumber()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            java.lang.String r11 = r8.getETag()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            r9.<init>(r10, r11)     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            long r10 = r8.getSize()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            r9.setPartSize(r10)     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            if (r0 == 0) goto L_0x01c7
            int r10 = r0.size()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            if (r10 <= 0) goto L_0x01c7
            int r10 = r9.getPartNumber()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            boolean r10 = r0.containsKey(r10)     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            if (r10 == 0) goto L_0x01c7
            int r10 = r9.getPartNumber()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            java.lang.Object r10 = r0.get(r10)     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            long r10 = r10.longValue()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            r9.setCRC64(r10)     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
        L_0x01c7:
            java.util.List r10 = r13.mPartETags     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            r10.add(r9)     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            long r9 = r13.mUploadedLength     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            long r11 = r8.getSize()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            long r9 = r9 + r11
            r13.mUploadedLength = r9     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            java.util.List<java.lang.Integer> r9 = r13.mAlreadyUploadIndex     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            int r10 = r8.getPartNumber()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            r9.add(r10)     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            if (r7 != 0) goto L_0x01ea
            long r8 = r8.getSize()     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
            r13.mFirstPartSize = r8     // Catch:{ ServiceException -> 0x01ef, ClientException -> 0x01ed }
        L_0x01ea:
            int r7 = r7 + 1
            goto L_0x017c
        L_0x01ed:
            r0 = move-exception
            throw r0
        L_0x01ef:
            r5 = move-exception
            int r6 = r5.getStatusCode()
            r7 = 404(0x194, float:5.66E-43)
            if (r6 != r7) goto L_0x0201
            r13.mUploadId = r1
            r6 = 0
        L_0x01fb:
            r4.waitUntilFinished()
            if (r6 != 0) goto L_0x0143
            goto L_0x0202
        L_0x0201:
            throw r5
        L_0x0202:
            java.io.File r0 = r13.mRecordFile
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0235
            java.io.File r0 = r13.mRecordFile
            boolean r0 = r0.createNewFile()
            if (r0 == 0) goto L_0x0213
            goto L_0x0235
        L_0x0213:
            com.alibaba.sdk.android.oss.ClientException r0 = new com.alibaba.sdk.android.oss.ClientException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Can't create file at path: "
            r1.append(r2)
            java.io.File r2 = r13.mRecordFile
            java.lang.String r2 = r2.getAbsolutePath()
            r1.append(r2)
            java.lang.String r2 = "\nPlease make sure the directory exist!"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0235:
            java.lang.String r0 = r13.mUploadId
            boolean r0 = com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            if (r0 == 0) goto L_0x0285
            com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest r0 = new com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r2 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r2 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r2
            java.lang.String r2 = r2.getBucketName()
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r3 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r3 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r3
            java.lang.String r3 = r3.getObjectKey()
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r4 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r4 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r4
            com.alibaba.sdk.android.oss.model.ObjectMetadata r4 = r4.getMetadata()
            r0.<init>(r2, r3, r4)
            r2 = 1
            r0.isSequential = r2
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r2 = r13.mApiOperation
            com.alibaba.sdk.android.oss.internal.OSSAsyncTask r0 = r2.initMultipartUpload(r0, r1)
            com.alibaba.sdk.android.oss.model.OSSResult r0 = r0.getResult()
            com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult r0 = (com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult) r0
            java.lang.String r0 = r0.getUploadId()
            r13.mUploadId = r0
            java.io.File r0 = r13.mRecordFile
            if (r0 == 0) goto L_0x0285
            java.io.BufferedWriter r1 = new java.io.BufferedWriter
            java.io.FileWriter r2 = new java.io.FileWriter
            r2.<init>(r0)
            r1.<init>(r2)
            java.lang.String r0 = r13.mUploadId
            r1.write(r0)
            r1.close()
        L_0x0285:
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r13.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r1 = r13.mUploadId
            r0.setUploadId(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.initMultipartUploadId():void");
    }

    /* access modifiers changed from: protected */
    public ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException, InterruptedException {
        long j = this.mUploadedLength;
        checkCancel();
        int i = this.mPartAttr[0];
        int i2 = this.mPartAttr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            if (this.mUploadedLength > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            } else if (this.mFirstPartSize == ((long) i)) {
                long j2 = this.mUploadedLength;
                if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                    j2 = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
                }
                long j3 = j2;
                if (this.mProgressCallback != null) {
                    this.mProgressCallback.onProgress(this.mRequest, j3, this.mFileLength);
                }
                this.mSp.removeKey(this.mUploadId);
            } else {
                throw new ClientException("The part size setting is inconsistent with before");
            }
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i3 + 1))) {
                if (i3 == i2 - 1) {
                    i = (int) (this.mFileLength - j);
                }
                OSSLog.logDebug("upload part readByte : " + i);
                j += (long) i;
                uploadPart(i3, i, i2);
                if (this.mUploadException != null) {
                    break;
                }
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = null;
        if (completeMultipartUploadResult != null) {
            resumableUploadResult = new ResumableUploadResult(completeMultipartUploadResult);
        }
        File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        return resumableUploadResult;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011f, code lost:
        r1 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0121, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0122, code lost:
        r12 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01c2 A[SYNTHETIC, Splitter:B:101:0x01c2] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01ca A[Catch:{ IOException -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01cf A[Catch:{ IOException -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:32:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011e A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:32:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0144 A[SYNTHETIC, Splitter:B:72:0x0144] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x014c A[Catch:{ IOException -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0151 A[Catch:{ IOException -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0165 A[Catch:{ all -> 0x01bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0169 A[Catch:{ all -> 0x01bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01ae A[SYNTHETIC, Splitter:B:92:0x01ae] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01b3 A[Catch:{ IOException -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01b8 A[Catch:{ IOException -> 0x0148 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:83:0x015d=Splitter:B:83:0x015d, B:69:0x013f=Splitter:B:69:0x013f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadPart(int r16, int r17, int r18) {
        /*
            r15 = this;
            r7 = r15
            r0 = r16
            r8 = r17
            r1 = 0
            com.alibaba.sdk.android.oss.network.ExecutionContext r2 = r7.mContext     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            com.alibaba.sdk.android.oss.network.CancellationHandler r2 = r2.getCancellationHandler()     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            boolean r2 = r2.isCancelled()     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            if (r2 == 0) goto L_0x0013
            return
        L_0x0013:
            int r2 = r7.mRunPartTaskCount     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            r3 = 1
            int r2 = r2 + r3
            r7.mRunPartTaskCount = r2     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            r15.preUploadPart(r16, r17, r18)     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            long r4 = (long) r0     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r2 = r7.mRequest     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r2 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r2     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            long r9 = r2.getPartSize()     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            long r4 = r4 * r9
            byte[] r2 = new byte[r8]     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            android.net.Uri r6 = r7.mUploadUri     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            r9 = 0
            if (r6 == 0) goto L_0x006c
            com.alibaba.sdk.android.oss.network.ExecutionContext r6 = r7.mContext     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            android.content.Context r6 = r6.getApplicationContext()     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            android.net.Uri r10 = r7.mUploadUri     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            java.io.InputStream r6 = r6.openInputStream(r10)     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ ServiceException -> 0x0066, Exception -> 0x0061, all -> 0x005b }
            r10.<init>(r6)     // Catch:{ ServiceException -> 0x0066, Exception -> 0x0061, all -> 0x005b }
            r10.skip(r4)     // Catch:{ ServiceException -> 0x0057, Exception -> 0x0054, all -> 0x004d }
            r10.read(r2, r9, r8)     // Catch:{ ServiceException -> 0x0057, Exception -> 0x0054, all -> 0x004d }
            r9 = r1
            r11 = r10
            r10 = r6
            goto L_0x007e
        L_0x004d:
            r0 = move-exception
            r9 = r1
            r11 = r10
            r1 = r0
            r10 = r6
            goto L_0x01c0
        L_0x0054:
            r0 = move-exception
            r11 = r10
            goto L_0x0063
        L_0x0057:
            r0 = move-exception
            r12 = r1
            r11 = r10
            goto L_0x0069
        L_0x005b:
            r0 = move-exception
            r9 = r1
            r11 = r9
            r10 = r6
            goto L_0x0139
        L_0x0061:
            r0 = move-exception
            r11 = r1
        L_0x0063:
            r10 = r6
            goto L_0x013f
        L_0x0066:
            r0 = move-exception
            r11 = r1
            r12 = r11
        L_0x0069:
            r10 = r6
            goto L_0x015d
        L_0x006c:
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            java.io.File r10 = r7.mUploadFile     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            java.lang.String r11 = "r"
            r6.<init>(r10, r11)     // Catch:{ ServiceException -> 0x0159, Exception -> 0x013c, all -> 0x0135 }
            r6.seek(r4)     // Catch:{ ServiceException -> 0x012f, Exception -> 0x012a, all -> 0x0125 }
            r6.readFully(r2, r9, r8)     // Catch:{ ServiceException -> 0x012f, Exception -> 0x012a, all -> 0x0125 }
            r10 = r1
            r11 = r10
            r9 = r6
        L_0x007e:
            com.alibaba.sdk.android.oss.model.UploadPartRequest r12 = new com.alibaba.sdk.android.oss.model.UploadPartRequest     // Catch:{ ServiceException -> 0x0121, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r4 = r7.mRequest     // Catch:{ ServiceException -> 0x0121, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r4 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r4     // Catch:{ ServiceException -> 0x0121, Exception -> 0x011e, all -> 0x011c }
            java.lang.String r4 = r4.getBucketName()     // Catch:{ ServiceException -> 0x0121, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r5 = r7.mRequest     // Catch:{ ServiceException -> 0x0121, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r5 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r5     // Catch:{ ServiceException -> 0x0121, Exception -> 0x011e, all -> 0x011c }
            java.lang.String r5 = r5.getObjectKey()     // Catch:{ ServiceException -> 0x0121, Exception -> 0x011e, all -> 0x011c }
            java.lang.String r6 = r7.mUploadId     // Catch:{ ServiceException -> 0x0121, Exception -> 0x011e, all -> 0x011c }
            int r0 = r0 + r3
            r12.<init>(r4, r5, r6, r0)     // Catch:{ ServiceException -> 0x0121, Exception -> 0x011e, all -> 0x011c }
            r12.setPartContent(r2)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            java.lang.String r0 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5((byte[]) r2)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            r12.setMd5Digest(r0)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r7.mRequest     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            java.lang.Enum r0 = r0.getCRC64()     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            r12.setCRC64(r0)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r0 = r7.mApiOperation     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.model.UploadPartResult r0 = r0.syncUploadPart(r12)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.model.PartETag r1 = new com.alibaba.sdk.android.oss.model.PartETag     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            int r2 = r12.getPartNumber()     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            java.lang.String r4 = r0.getETag()     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            r1.<init>(r2, r4)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            long r4 = (long) r8     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            r1.setPartSize(r4)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            boolean r2 = r7.mCheckCRC64     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            if (r2 == 0) goto L_0x00d1
            java.lang.Long r0 = r0.getClientCRC()     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            long r13 = r0.longValue()     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            r1.setCRC64(r13)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
        L_0x00d1:
            java.util.List r0 = r7.mPartETags     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            r0.add(r1)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            long r13 = r7.mUploadedLength     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            long r13 = r13 + r4
            r7.mUploadedLength = r13     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            r15.uploadPartFinish(r1)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r7.mContext     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.network.CancellationHandler r0 = r0.getCancellationHandler()     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            boolean r0 = r0.isCancelled()     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            if (r0 != 0) goto L_0x0105
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r2 = r7.mRequest     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            long r3 = r7.mUploadedLength     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            long r5 = r7.mFileLength     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            r1 = r15
            r1.onProgressCallback(r2, r3, r5)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            if (r9 == 0) goto L_0x00f9
            r9.close()     // Catch:{ IOException -> 0x0148 }
        L_0x00f9:
            if (r10 == 0) goto L_0x00fe
            r10.close()     // Catch:{ IOException -> 0x0148 }
        L_0x00fe:
            if (r11 == 0) goto L_0x01bb
            r11.close()     // Catch:{ IOException -> 0x0148 }
            goto L_0x01bb
        L_0x0105:
            com.alibaba.sdk.android.oss.TaskCancelException r0 = new com.alibaba.sdk.android.oss.TaskCancelException     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            java.lang.String r1 = "sequence upload task cancel"
            r0.<init>((java.lang.String) r1)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            com.alibaba.sdk.android.oss.ClientException r1 = new com.alibaba.sdk.android.oss.ClientException     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            java.lang.String r2 = r0.getMessage()     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            r1.<init>(r2, r0, r3)     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
            throw r1     // Catch:{ ServiceException -> 0x011a, Exception -> 0x011e, all -> 0x011c }
        L_0x011a:
            r0 = move-exception
            goto L_0x0123
        L_0x011c:
            r0 = move-exception
            goto L_0x0139
        L_0x011e:
            r0 = move-exception
            r1 = r9
            goto L_0x013f
        L_0x0121:
            r0 = move-exception
            r12 = r1
        L_0x0123:
            r1 = r9
            goto L_0x015d
        L_0x0125:
            r0 = move-exception
            r10 = r1
            r11 = r10
            r9 = r6
            goto L_0x0139
        L_0x012a:
            r0 = move-exception
            r10 = r1
            r11 = r10
            r1 = r6
            goto L_0x013f
        L_0x012f:
            r0 = move-exception
            r10 = r1
            r11 = r10
            r12 = r11
            r1 = r6
            goto L_0x015d
        L_0x0135:
            r0 = move-exception
            r9 = r1
            r10 = r9
            r11 = r10
        L_0x0139:
            r1 = r0
            goto L_0x01c0
        L_0x013c:
            r0 = move-exception
            r10 = r1
            r11 = r10
        L_0x013f:
            r15.processException(r0)     // Catch:{ all -> 0x01bc }
            if (r1 == 0) goto L_0x014a
            r1.close()     // Catch:{ IOException -> 0x0148 }
            goto L_0x014a
        L_0x0148:
            r0 = move-exception
            goto L_0x0155
        L_0x014a:
            if (r10 == 0) goto L_0x014f
            r10.close()     // Catch:{ IOException -> 0x0148 }
        L_0x014f:
            if (r11 == 0) goto L_0x01bb
            r11.close()     // Catch:{ IOException -> 0x0148 }
            goto L_0x01bb
        L_0x0155:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)
            goto L_0x01bb
        L_0x0159:
            r0 = move-exception
            r10 = r1
            r11 = r10
            r12 = r11
        L_0x015d:
            int r2 = r0.getStatusCode()     // Catch:{ all -> 0x01bc }
            r3 = 409(0x199, float:5.73E-43)
            if (r2 == r3) goto L_0x0169
            r15.processException(r0)     // Catch:{ all -> 0x01bc }
            goto L_0x01ac
        L_0x0169:
            com.alibaba.sdk.android.oss.model.PartETag r2 = new com.alibaba.sdk.android.oss.model.PartETag     // Catch:{ all -> 0x01bc }
            int r3 = r12.getPartNumber()     // Catch:{ all -> 0x01bc }
            java.lang.String r0 = r0.getPartEtag()     // Catch:{ all -> 0x01bc }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x01bc }
            byte[] r0 = r12.getPartContent()     // Catch:{ all -> 0x01bc }
            int r0 = r0.length     // Catch:{ all -> 0x01bc }
            long r3 = (long) r0     // Catch:{ all -> 0x01bc }
            r2.setPartSize(r3)     // Catch:{ all -> 0x01bc }
            boolean r0 = r7.mCheckCRC64     // Catch:{ all -> 0x01bc }
            if (r0 == 0) goto L_0x01a1
            byte[] r0 = r12.getPartContent()     // Catch:{ all -> 0x01bc }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x01bc }
            r3.<init>(r0)     // Catch:{ all -> 0x01bc }
            java.util.zip.CheckedInputStream r0 = new java.util.zip.CheckedInputStream     // Catch:{ all -> 0x01bc }
            com.alibaba.sdk.android.oss.common.utils.CRC64 r4 = new com.alibaba.sdk.android.oss.common.utils.CRC64     // Catch:{ all -> 0x01bc }
            r4.<init>()     // Catch:{ all -> 0x01bc }
            r0.<init>(r3, r4)     // Catch:{ all -> 0x01bc }
            java.util.zip.Checksum r0 = r0.getChecksum()     // Catch:{ all -> 0x01bc }
            long r3 = r0.getValue()     // Catch:{ all -> 0x01bc }
            r2.setCRC64(r3)     // Catch:{ all -> 0x01bc }
        L_0x01a1:
            java.util.List r0 = r7.mPartETags     // Catch:{ all -> 0x01bc }
            r0.add(r2)     // Catch:{ all -> 0x01bc }
            long r2 = r7.mUploadedLength     // Catch:{ all -> 0x01bc }
            long r4 = (long) r8     // Catch:{ all -> 0x01bc }
            long r2 = r2 + r4
            r7.mUploadedLength = r2     // Catch:{ all -> 0x01bc }
        L_0x01ac:
            if (r1 == 0) goto L_0x01b1
            r1.close()     // Catch:{ IOException -> 0x0148 }
        L_0x01b1:
            if (r10 == 0) goto L_0x01b6
            r10.close()     // Catch:{ IOException -> 0x0148 }
        L_0x01b6:
            if (r11 == 0) goto L_0x01bb
            r11.close()     // Catch:{ IOException -> 0x0148 }
        L_0x01bb:
            return
        L_0x01bc:
            r0 = move-exception
            r9 = r1
            goto L_0x0139
        L_0x01c0:
            if (r9 == 0) goto L_0x01c8
            r9.close()     // Catch:{ IOException -> 0x01c6 }
            goto L_0x01c8
        L_0x01c6:
            r0 = move-exception
            goto L_0x01d3
        L_0x01c8:
            if (r10 == 0) goto L_0x01cd
            r10.close()     // Catch:{ IOException -> 0x01c6 }
        L_0x01cd:
            if (r11 == 0) goto L_0x01d6
            r11.close()     // Catch:{ IOException -> 0x01c6 }
            goto L_0x01d6
        L_0x01d3:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)
        L_0x01d6:
            goto L_0x01d8
        L_0x01d7:
            throw r1
        L_0x01d8:
            goto L_0x01d7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.uploadPart(int, int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkException() throws java.io.IOException, com.alibaba.sdk.android.oss.ServiceException, com.alibaba.sdk.android.oss.ClientException {
        /*
            r6 = this;
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r6.mContext
            com.alibaba.sdk.android.oss.network.CancellationHandler r0 = r0.getCancellationHandler()
            boolean r0 = r0.isCancelled()
            if (r0 == 0) goto L_0x00c9
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r6.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.Boolean r0 = r0.deleteUploadOnCancelling()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0026
            r6.abortThisUpload()
            java.io.File r0 = r6.mRecordFile
            if (r0 == 0) goto L_0x00c9
            r0.delete()
            goto L_0x00c9
        L_0x0026:
            java.util.List r0 = r6.mPartETags
            if (r0 == 0) goto L_0x00c9
            java.util.List r0 = r6.mPartETags
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00c9
            boolean r0 = r6.mCheckCRC64
            if (r0 == 0) goto L_0x00c9
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r6.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getRecordDirectory()
            if (r0 == 0) goto L_0x00c9
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.List r1 = r6.mPartETags
            java.util.Iterator r1 = r1.iterator()
        L_0x004b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x006b
            java.lang.Object r2 = r1.next()
            com.alibaba.sdk.android.oss.model.PartETag r2 = (com.alibaba.sdk.android.oss.model.PartETag) r2
            int r3 = r2.getPartNumber()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            long r4 = r2.getCRC64()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r0.put(r3, r2)
            goto L_0x004b
        L_0x006b:
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b9 }
            r2.<init>()     // Catch:{ IOException -> 0x00b9 }
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r3 = r6.mRequest     // Catch:{ IOException -> 0x00b9 }
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r3 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r3     // Catch:{ IOException -> 0x00b9 }
            java.lang.String r3 = r3.getRecordDirectory()     // Catch:{ IOException -> 0x00b9 }
            r2.append(r3)     // Catch:{ IOException -> 0x00b9 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ IOException -> 0x00b9 }
            r2.append(r3)     // Catch:{ IOException -> 0x00b9 }
            java.lang.String r3 = r6.mUploadId     // Catch:{ IOException -> 0x00b9 }
            r2.append(r3)     // Catch:{ IOException -> 0x00b9 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00b9 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x00b9 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x00b9 }
            r6.mCRC64RecordFile = r3     // Catch:{ IOException -> 0x00b9 }
            java.io.File r2 = r6.mCRC64RecordFile     // Catch:{ IOException -> 0x00b9 }
            boolean r2 = r2.exists()     // Catch:{ IOException -> 0x00b9 }
            if (r2 != 0) goto L_0x009e
            java.io.File r2 = r6.mCRC64RecordFile     // Catch:{ IOException -> 0x00b9 }
            r2.createNewFile()     // Catch:{ IOException -> 0x00b9 }
        L_0x009e:
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x00b9 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00b9 }
            java.io.File r4 = r6.mCRC64RecordFile     // Catch:{ IOException -> 0x00b9 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00b9 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00b9 }
            r2.writeObject(r0)     // Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
            r2.close()
            goto L_0x00c9
        L_0x00b1:
            r0 = move-exception
            r1 = r2
            goto L_0x00c3
        L_0x00b4:
            r0 = move-exception
            r1 = r2
            goto L_0x00ba
        L_0x00b7:
            r0 = move-exception
            goto L_0x00c3
        L_0x00b9:
            r0 = move-exception
        L_0x00ba:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)     // Catch:{ all -> 0x00b7 }
            if (r1 == 0) goto L_0x00c9
            r1.close()
            goto L_0x00c9
        L_0x00c3:
            if (r1 == 0) goto L_0x00c8
            r1.close()
        L_0x00c8:
            throw r0
        L_0x00c9:
            super.checkException()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.SequenceUploadTask.checkException():void");
    }

    /* access modifiers changed from: protected */
    public void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), (OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult>) null).waitUntilFinished();
        }
    }

    /* access modifiers changed from: protected */
    public void processException(Exception exc) {
        if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
            this.mUploadException = exc;
        }
        OSSLog.logThrowable2Local(exc);
        if (this.mContext.getCancellationHandler().isCancelled() && !this.mIsCancel) {
            this.mIsCancel = true;
        }
    }

    /* access modifiers changed from: protected */
    public void uploadPartFinish(PartETag partETag) throws Exception {
        if (this.mContext.getCancellationHandler().isCancelled() && !this.mSp.contains(this.mUploadId)) {
            this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
            onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
        }
    }
}
