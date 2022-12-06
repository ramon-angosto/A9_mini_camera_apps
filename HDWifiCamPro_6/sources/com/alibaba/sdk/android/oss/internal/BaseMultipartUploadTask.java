package com.alibaba.sdk.android.oss.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class BaseMultipartUploadTask<Request extends MultipartUploadRequest, Result extends CompleteMultipartUploadResult> implements Callable<Result> {
    protected final int CPU_SIZE = (Runtime.getRuntime().availableProcessors() * 2);
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected final int PART_SIZE_ALIGN_NUM;
    protected InternalRequestOperation mApiOperation;
    protected boolean mCheckCRC64;
    protected OSSCompletedCallback<Request, Result> mCompletedCallback;
    protected ExecutionContext mContext;
    protected long mFileLength;
    protected boolean mIsCancel;
    protected long mLastPartSize;
    protected Object mLock;
    protected int[] mPartAttr;
    protected List<PartETag> mPartETags;
    protected int mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    protected OSSProgressCallback<Request> mProgressCallback;
    protected Request mRequest;
    protected int mRunPartTaskCount;
    protected Exception mUploadException;
    protected File mUploadFile;
    protected String mUploadFilePath;
    protected String mUploadId;
    protected Uri mUploadUri;
    protected long mUploadedLength;

    /* access modifiers changed from: protected */
    public abstract void abortThisUpload();

    /* access modifiers changed from: protected */
    public abstract Result doMultipartUpload() throws IOException, ServiceException, ClientException, InterruptedException;

    /* access modifiers changed from: protected */
    public abstract void initMultipartUploadId() throws IOException, ClientException, ServiceException;

    /* access modifiers changed from: protected */
    public void preUploadPart(int i, int i2, int i3) throws Exception {
    }

    /* access modifiers changed from: protected */
    public abstract void processException(Exception exc);

    /* access modifiers changed from: protected */
    public void uploadPartFinish(PartETag partETag) throws Exception {
    }

    public BaseMultipartUploadTask(InternalRequestOperation internalRequestOperation, Request request, OSSCompletedCallback<Request, Result> oSSCompletedCallback, ExecutionContext executionContext) {
        int i = this.CPU_SIZE;
        this.MAX_CORE_POOL_SIZE = i >= 5 ? 5 : i;
        this.MAX_IMUM_POOL_SIZE = this.CPU_SIZE;
        this.KEEP_ALIVE_TIME = PathInterpolatorCompat.MAX_NUM_POINTS;
        this.MAX_QUEUE_SIZE = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
        this.PART_SIZE_ALIGN_NUM = 4096;
        this.mPoolExecutor = new ThreadPoolExecutor(this.MAX_CORE_POOL_SIZE, this.MAX_IMUM_POOL_SIZE, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mPartETags = new ArrayList();
        this.mLock = new Object();
        this.mUploadedLength = 0;
        boolean z = false;
        this.mCheckCRC64 = false;
        this.mPartAttr = new int[2];
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mCheckCRC64 = request.getCRC64() == OSSRequest.CRC64Config.YES ? true : z;
    }

    /* access modifiers changed from: protected */
    public void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
        }
    }

    public Result call() throws Exception {
        ClientException clientException;
        try {
            checkInitData();
            initMultipartUploadId();
            Result doMultipartUpload = doMultipartUpload();
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onSuccess(this.mRequest, doMultipartUpload);
            }
            return doMultipartUpload;
        } catch (ServiceException e) {
            OSSCompletedCallback<Request, Result> oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onFailure(this.mRequest, (ClientException) null, e);
            }
            throw e;
        } catch (Exception e2) {
            if (e2 instanceof ClientException) {
                clientException = (ClientException) e2;
            } else {
                clientException = new ClientException(e2.toString(), e2);
            }
            OSSCompletedCallback<Request, Result> oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, clientException, (ServiceException) null);
            }
            throw clientException;
        }
    }

    /* access modifiers changed from: protected */
    public void checkInitData() throws ClientException {
        if (this.mRequest.getUploadFilePath() != null) {
            this.mUploadFilePath = this.mRequest.getUploadFilePath();
            this.mUploadedLength = 0;
            this.mUploadFile = new File(this.mUploadFilePath);
            this.mFileLength = this.mUploadFile.length();
        } else if (this.mRequest.getUploadUri() != null) {
            this.mUploadUri = this.mRequest.getUploadUri();
            ParcelFileDescriptor parcelFileDescriptor = null;
            try {
                parcelFileDescriptor = this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, CampaignEx.JSON_KEY_AD_R);
                this.mFileLength = parcelFileDescriptor.getStatSize();
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e) {
                        OSSLog.logThrowable2Local(e);
                    }
                }
            } catch (IOException e2) {
                throw new ClientException(e2.getMessage(), e2, true);
            } catch (Throwable th) {
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e3) {
                        OSSLog.logThrowable2Local(e3);
                    }
                }
                throw th;
            }
        }
        if (this.mFileLength != 0) {
            checkPartSize(this.mPartAttr);
            long partSize = this.mRequest.getPartSize();
            int i = this.mPartAttr[1];
            OSSLog.logDebug("[checkInitData] - partNumber : " + i);
            OSSLog.logDebug("[checkInitData] - partSize : " + partSize);
            if (i > 1 && partSize < OSSConstants.MIN_PART_SIZE_LIMIT) {
                throw new ClientException("Part size must be greater than or equal to 100KB!");
            }
            return;
        }
        throw new ClientException("file length must not be 0");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0173 A[Catch:{ IOException -> 0x016f }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0178 A[Catch:{ IOException -> 0x016f }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0152 A[SYNTHETIC, Splitter:B:85:0x0152] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x015a A[Catch:{ IOException -> 0x0156 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x015f A[Catch:{ IOException -> 0x0156 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x016b A[SYNTHETIC, Splitter:B:97:0x016b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadPart(int r15, int r16, int r17) {
        /*
            r14 = this;
            r7 = r14
            r0 = r15
            r1 = r16
            r2 = 0
            com.alibaba.sdk.android.oss.network.ExecutionContext r3 = r7.mContext     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            com.alibaba.sdk.android.oss.network.CancellationHandler r3 = r3.getCancellationHandler()     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            boolean r3 = r3.isCancelled()     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            if (r3 == 0) goto L_0x001b
            java.util.concurrent.ThreadPoolExecutor r0 = r7.mPoolExecutor     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            java.util.concurrent.BlockingQueue r0 = r0.getQueue()     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            r0.clear()     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            return
        L_0x001b:
            java.lang.Object r3 = r7.mLock     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            monitor-enter(r3)     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            int r4 = r7.mRunPartTaskCount     // Catch:{ all -> 0x0142 }
            r5 = 1
            int r4 = r4 + r5
            r7.mRunPartTaskCount = r4     // Catch:{ all -> 0x0142 }
            monitor-exit(r3)     // Catch:{ all -> 0x0142 }
            r14.preUploadPart(r15, r16, r17)     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            byte[] r3 = new byte[r1]     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            long r8 = (long) r0     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            Request r4 = r7.mRequest     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            long r10 = r4.getPartSize()     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            long r8 = r8 * r10
            android.net.Uri r4 = r7.mUploadUri     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            r6 = 0
            if (r4 == 0) goto L_0x0065
            com.alibaba.sdk.android.oss.network.ExecutionContext r4 = r7.mContext     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            android.net.Uri r10 = r7.mUploadUri     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            java.io.InputStream r4 = r4.openInputStream(r10)     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0060, all -> 0x005a }
            r10.<init>(r4)     // Catch:{ Exception -> 0x0060, all -> 0x005a }
            r10.skip(r8)     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            r10.read(r3, r6, r1)     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            r8 = r2
            r9 = r4
            goto L_0x0077
        L_0x0055:
            r0 = move-exception
            r1 = r0
            goto L_0x005d
        L_0x0058:
            r0 = move-exception
            goto L_0x0062
        L_0x005a:
            r0 = move-exception
            r1 = r0
            r10 = r2
        L_0x005d:
            r9 = r4
            goto L_0x0169
        L_0x0060:
            r0 = move-exception
            r10 = r2
        L_0x0062:
            r9 = r4
            goto L_0x014d
        L_0x0065:
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            java.io.File r10 = r7.mUploadFile     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            java.lang.String r11 = "r"
            r4.<init>(r10, r11)     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
            r4.seek(r8)     // Catch:{ Exception -> 0x013d, all -> 0x0137 }
            r4.readFully(r3, r6, r1)     // Catch:{ Exception -> 0x013d, all -> 0x0137 }
            r9 = r2
            r10 = r9
            r8 = r4
        L_0x0077:
            com.alibaba.sdk.android.oss.model.UploadPartRequest r2 = new com.alibaba.sdk.android.oss.model.UploadPartRequest     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            Request r4 = r7.mRequest     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            java.lang.String r4 = r4.getBucketName()     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            Request r6 = r7.mRequest     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            java.lang.String r6 = r6.getObjectKey()     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            java.lang.String r11 = r7.mUploadId     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            int r0 = r0 + r5
            r2.<init>(r4, r6, r11, r0)     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            r2.setPartContent(r3)     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            java.lang.String r0 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5((byte[]) r3)     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            r2.setMd5Digest(r0)     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            Request r0 = r7.mRequest     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            java.lang.Enum r0 = r0.getCRC64()     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            r2.setCRC64(r0)     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r0 = r7.mApiOperation     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            com.alibaba.sdk.android.oss.model.UploadPartResult r0 = r0.syncUploadPart(r2)     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            java.lang.Object r11 = r7.mLock     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            monitor-enter(r11)     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
            com.alibaba.sdk.android.oss.model.PartETag r3 = new com.alibaba.sdk.android.oss.model.PartETag     // Catch:{ all -> 0x012d }
            int r2 = r2.getPartNumber()     // Catch:{ all -> 0x012d }
            java.lang.String r4 = r0.getETag()     // Catch:{ all -> 0x012d }
            r3.<init>(r2, r4)     // Catch:{ all -> 0x012d }
            long r1 = (long) r1     // Catch:{ all -> 0x012d }
            r3.setPartSize(r1)     // Catch:{ all -> 0x012d }
            boolean r4 = r7.mCheckCRC64     // Catch:{ all -> 0x012d }
            if (r4 == 0) goto L_0x00c7
            java.lang.Long r0 = r0.getClientCRC()     // Catch:{ all -> 0x012d }
            long r12 = r0.longValue()     // Catch:{ all -> 0x012d }
            r3.setCRC64(r12)     // Catch:{ all -> 0x012d }
        L_0x00c7:
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r0 = r7.mPartETags     // Catch:{ all -> 0x012d }
            r0.add(r3)     // Catch:{ all -> 0x012d }
            long r12 = r7.mUploadedLength     // Catch:{ all -> 0x012d }
            long r12 = r12 + r1
            r7.mUploadedLength = r12     // Catch:{ all -> 0x012d }
            r14.uploadPartFinish(r3)     // Catch:{ all -> 0x012d }
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r7.mContext     // Catch:{ all -> 0x012d }
            com.alibaba.sdk.android.oss.network.CancellationHandler r0 = r0.getCancellationHandler()     // Catch:{ all -> 0x012d }
            boolean r0 = r0.isCancelled()     // Catch:{ all -> 0x012d }
            if (r0 == 0) goto L_0x0103
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r0 = r7.mPartETags     // Catch:{ all -> 0x012d }
            int r0 = r0.size()     // Catch:{ all -> 0x012d }
            int r1 = r7.mRunPartTaskCount     // Catch:{ all -> 0x012d }
            int r2 = r7.mPartExceptionCount     // Catch:{ all -> 0x012d }
            int r1 = r1 - r2
            if (r0 == r1) goto L_0x00ee
            goto L_0x011c
        L_0x00ee:
            com.alibaba.sdk.android.oss.TaskCancelException r0 = new com.alibaba.sdk.android.oss.TaskCancelException     // Catch:{ all -> 0x012d }
            java.lang.String r1 = "multipart cancel"
            r0.<init>((java.lang.String) r1)     // Catch:{ all -> 0x012d }
            com.alibaba.sdk.android.oss.ClientException r1 = new com.alibaba.sdk.android.oss.ClientException     // Catch:{ all -> 0x012d }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x012d }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x012d }
            r1.<init>(r2, r0, r3)     // Catch:{ all -> 0x012d }
            throw r1     // Catch:{ all -> 0x012d }
        L_0x0103:
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r0 = r7.mPartETags     // Catch:{ all -> 0x012d }
            int r0 = r0.size()     // Catch:{ all -> 0x012d }
            int r1 = r7.mPartExceptionCount     // Catch:{ all -> 0x012d }
            int r1 = r17 - r1
            if (r0 != r1) goto L_0x0112
            r14.notifyMultipartThread()     // Catch:{ all -> 0x012d }
        L_0x0112:
            Request r2 = r7.mRequest     // Catch:{ all -> 0x012d }
            long r3 = r7.mUploadedLength     // Catch:{ all -> 0x012d }
            long r5 = r7.mFileLength     // Catch:{ all -> 0x012d }
            r1 = r14
            r1.onProgressCallback(r2, r3, r5)     // Catch:{ all -> 0x012d }
        L_0x011c:
            monitor-exit(r11)     // Catch:{ all -> 0x012d }
            if (r8 == 0) goto L_0x0122
            r8.close()     // Catch:{ IOException -> 0x0156 }
        L_0x0122:
            if (r10 == 0) goto L_0x0127
            r10.close()     // Catch:{ IOException -> 0x0156 }
        L_0x0127:
            if (r9 == 0) goto L_0x0166
            r9.close()     // Catch:{ IOException -> 0x0156 }
            goto L_0x0166
        L_0x012d:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x012d }
            throw r0     // Catch:{ Exception -> 0x0134, all -> 0x0130 }
        L_0x0130:
            r0 = move-exception
            r1 = r0
            r2 = r8
            goto L_0x0169
        L_0x0134:
            r0 = move-exception
            r2 = r8
            goto L_0x014d
        L_0x0137:
            r0 = move-exception
            r1 = r0
            r9 = r2
            r10 = r9
            r2 = r4
            goto L_0x0169
        L_0x013d:
            r0 = move-exception
            r9 = r2
            r10 = r9
            r2 = r4
            goto L_0x014d
        L_0x0142:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0142 }
            throw r0     // Catch:{ Exception -> 0x014a, all -> 0x0145 }
        L_0x0145:
            r0 = move-exception
            r1 = r0
            r9 = r2
            r10 = r9
            goto L_0x0169
        L_0x014a:
            r0 = move-exception
            r9 = r2
            r10 = r9
        L_0x014d:
            r14.processException(r0)     // Catch:{ all -> 0x0167 }
            if (r2 == 0) goto L_0x0158
            r2.close()     // Catch:{ IOException -> 0x0156 }
            goto L_0x0158
        L_0x0156:
            r0 = move-exception
            goto L_0x0163
        L_0x0158:
            if (r10 == 0) goto L_0x015d
            r10.close()     // Catch:{ IOException -> 0x0156 }
        L_0x015d:
            if (r9 == 0) goto L_0x0166
            r9.close()     // Catch:{ IOException -> 0x0156 }
            goto L_0x0166
        L_0x0163:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)
        L_0x0166:
            return
        L_0x0167:
            r0 = move-exception
            r1 = r0
        L_0x0169:
            if (r2 == 0) goto L_0x0171
            r2.close()     // Catch:{ IOException -> 0x016f }
            goto L_0x0171
        L_0x016f:
            r0 = move-exception
            goto L_0x017c
        L_0x0171:
            if (r10 == 0) goto L_0x0176
            r10.close()     // Catch:{ IOException -> 0x016f }
        L_0x0176:
            if (r9 == 0) goto L_0x017f
            r9.close()     // Catch:{ IOException -> 0x016f }
            goto L_0x017f
        L_0x017c:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)
        L_0x017f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.uploadPart(int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public CompleteMultipartUploadResult completeMultipartUploadResult() throws ClientException, ServiceException {
        CompleteMultipartUploadResult completeMultipartUploadResult;
        if (this.mPartETags.size() > 0) {
            Collections.sort(this.mPartETags, new Comparator<PartETag>() {
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            if (this.mRequest.getMetadata() != null) {
                ObjectMetadata objectMetadata = new ObjectMetadata();
                for (String next : this.mRequest.getMetadata().getRawMetadata().keySet()) {
                    if (!next.equals(OSSHeaders.STORAGE_CLASS)) {
                        objectMetadata.setHeader(next, this.mRequest.getMetadata().getRawMetadata().get(next));
                    }
                }
                completeMultipartUploadRequest.setMetadata(objectMetadata);
            }
            completeMultipartUploadRequest.setCRC64(this.mRequest.getCRC64());
            completeMultipartUploadResult = this.mApiOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
        } else {
            completeMultipartUploadResult = null;
        }
        this.mUploadedLength = 0;
        return completeMultipartUploadResult;
    }

    /* access modifiers changed from: protected */
    public void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    /* access modifiers changed from: protected */
    public void checkException() throws IOException, ServiceException, ClientException {
        if (this.mUploadException != null) {
            releasePool();
            Exception exc = this.mUploadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            } else if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            } else if (exc instanceof ClientException) {
                throw ((ClientException) exc);
            } else {
                throw new ClientException(exc.getMessage(), this.mUploadException);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkWaitCondition(int i) {
        return this.mPartETags.size() != i;
    }

    /* access modifiers changed from: protected */
    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    /* access modifiers changed from: protected */
    public void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        OSSLog.logDebug("[checkPartSize] - mFileLength : " + this.mFileLength);
        OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j = this.mFileLength;
        long j2 = j / partSize;
        int i = ((j % partSize) > 0 ? 1 : ((j % partSize) == 0 ? 0 : -1));
        long j3 = 1;
        if (i != 0) {
            j2++;
        }
        if (j2 == 1) {
            partSize = this.mFileLength;
        } else if (j2 > ((long) DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS)) {
            partSize = ceilPartSize(this.mFileLength / ((long) 4999));
            long j4 = this.mFileLength;
            long j5 = j4 / partSize;
            if (j4 % partSize == 0) {
                j3 = 0;
            }
            j2 = j5 + j3;
        }
        int i2 = (int) partSize;
        iArr[0] = i2;
        iArr[1] = (int) j2;
        this.mRequest.setPartSize((long) i2);
        OSSLog.logDebug("[checkPartSize] - partNumber : " + j2);
        OSSLog.logDebug("[checkPartSize] - partSize : " + i2);
        long j6 = this.mFileLength % partSize;
        if (j6 != 0) {
            partSize = j6;
        }
        this.mLastPartSize = partSize;
    }

    /* access modifiers changed from: protected */
    public long ceilPartSize(long j) {
        return ((j + 4095) / 4096) * 4096;
    }

    /* access modifiers changed from: protected */
    public void onProgressCallback(Request request, long j, long j2) {
        OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
        if (oSSProgressCallback != null) {
            oSSProgressCallback.onProgress(request, j, j2);
        }
    }
}
