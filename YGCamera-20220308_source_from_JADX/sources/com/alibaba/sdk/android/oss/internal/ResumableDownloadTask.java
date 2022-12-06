package com.alibaba.sdk.android.oss.internal;

import android.util.Log;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.exception.InconsistentException;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.Range;
import com.alibaba.sdk.android.oss.model.ResumableDownloadRequest;
import com.alibaba.sdk.android.oss.model.ResumableDownloadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ResumableDownloadTask<Requst extends ResumableDownloadRequest, Result extends ResumableDownloadResult> implements Callable<Result> {
    protected final int CPU_SIZE = (Runtime.getRuntime().availableProcessors() * 2);
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected String checkpointPath;
    protected long completedPartSize;
    protected long downloadPartSize;
    private CheckPoint mCheckPoint;
    private OSSCompletedCallback mCompletedCallback;
    private ExecutionContext mContext;
    protected Exception mDownloadException;
    protected Object mLock;
    private InternalRequestOperation mOperation;
    protected long mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    private OSSProgressCallback mProgressCallback;
    private ResumableDownloadRequest mRequest;

    ResumableDownloadTask(InternalRequestOperation internalRequestOperation, ResumableDownloadRequest resumableDownloadRequest, OSSCompletedCallback oSSCompletedCallback, ExecutionContext executionContext) {
        int i = this.CPU_SIZE;
        this.MAX_CORE_POOL_SIZE = i >= 5 ? 5 : i;
        this.MAX_IMUM_POOL_SIZE = this.CPU_SIZE;
        this.KEEP_ALIVE_TIME = PathInterpolatorCompat.MAX_NUM_POINTS;
        this.MAX_QUEUE_SIZE = 5000;
        this.mPoolExecutor = new ThreadPoolExecutor(this.MAX_CORE_POOL_SIZE, this.MAX_IMUM_POOL_SIZE, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mLock = new Object();
        this.mRequest = resumableDownloadRequest;
        this.mOperation = internalRequestOperation;
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mProgressCallback = resumableDownloadRequest.getProgressListener();
    }

    public Result call() throws Exception {
        ClientException clientException;
        try {
            checkInitData();
            Result doMultipartDownload = doMultipartDownload();
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onSuccess(this.mRequest, doMultipartDownload);
            }
            return doMultipartDownload;
        } catch (ServiceException e) {
            OSSCompletedCallback oSSCompletedCallback = this.mCompletedCallback;
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
            OSSCompletedCallback oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, clientException, (ServiceException) null);
            }
            throw clientException;
        }
    }

    /* access modifiers changed from: protected */
    public void checkInitData() throws ClientException, ServiceException, IOException {
        if (this.mRequest.getRange() == null || this.mRequest.getRange().checkIsValid()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mRequest.getBucketName());
            sb.append(this.mRequest.getObjectKey());
            sb.append(String.valueOf(this.mRequest.getPartSize()));
            sb.append(this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES ? "-crc64" : "");
            String calculateMd5Str = BinaryUtil.calculateMd5Str(sb.toString().getBytes());
            this.checkpointPath = this.mRequest.getCheckPointFilePath() + File.separator + calculateMd5Str;
            this.mCheckPoint = new CheckPoint();
            if (this.mRequest.getEnableCheckPoint().booleanValue()) {
                try {
                    this.mCheckPoint.load(this.checkpointPath);
                } catch (Exception unused) {
                    removeFile(this.checkpointPath);
                    removeFile(this.mRequest.getTempFilePath());
                }
                if (!this.mCheckPoint.isValid(this.mOperation)) {
                    removeFile(this.checkpointPath);
                    removeFile(this.mRequest.getTempFilePath());
                    initCheckPoint();
                    return;
                }
                return;
            }
            initCheckPoint();
            return;
        }
        throw new ClientException("Range is invalid");
    }

    /* access modifiers changed from: protected */
    public boolean removeFile(String str) {
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    private void initCheckPoint() throws ClientException, ServiceException, IOException {
        FileStat fileStat = FileStat.getFileStat(this.mOperation, this.mRequest.getBucketName(), this.mRequest.getObjectKey());
        Range correctRange = correctRange(this.mRequest.getRange(), fileStat.fileLength);
        createFile(this.mRequest.getTempFilePath(), correctRange.getEnd() - correctRange.getBegin());
        this.mCheckPoint.bucketName = this.mRequest.getBucketName();
        this.mCheckPoint.objectKey = this.mRequest.getObjectKey();
        CheckPoint checkPoint = this.mCheckPoint;
        checkPoint.fileStat = fileStat;
        checkPoint.parts = splitFile(correctRange, checkPoint.fileStat.fileLength, this.mRequest.getPartSize());
    }

    /* access modifiers changed from: protected */
    public ResumableDownloadResult doMultipartDownload() throws ClientException, ServiceException, IOException, InterruptedException {
        checkCancel();
        ResumableDownloadResult resumableDownloadResult = new ResumableDownloadResult();
        final DownloadFileResult downloadFileResult = new DownloadFileResult();
        downloadFileResult.partResults = new ArrayList<>();
        Iterator<DownloadPart> it = this.mCheckPoint.parts.iterator();
        while (it.hasNext()) {
            final DownloadPart next = it.next();
            checkException();
            if (this.mPoolExecutor == null || next.isCompleted) {
                DownloadPartResult downloadPartResult = new DownloadPartResult();
                downloadPartResult.partNumber = next.partNumber;
                downloadPartResult.requestId = this.mCheckPoint.fileStat.requestId;
                downloadPartResult.length = next.length;
                if (this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES) {
                    downloadPartResult.clientCRC = Long.valueOf(next.crc);
                }
                downloadFileResult.partResults.add(downloadPartResult);
                this.downloadPartSize++;
                this.completedPartSize++;
            } else {
                this.mPoolExecutor.execute(new Runnable() {
                    public void run() {
                        ResumableDownloadTask.this.downloadPart(downloadFileResult, next);
                        Log.i("partResults", "start: " + next.start + ", end: " + next.end);
                    }
                });
            }
        }
        if (checkWaitCondition(this.mCheckPoint.parts.size())) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        Collections.sort(downloadFileResult.partResults, new Comparator<DownloadPartResult>() {
            public int compare(DownloadPartResult downloadPartResult, DownloadPartResult downloadPartResult2) {
                return downloadPartResult.partNumber - downloadPartResult2.partNumber;
            }
        });
        if (this.mRequest.getCRC64() == OSSRequest.CRC64Config.YES && this.mRequest.getRange() == null) {
            Long calcObjectCRCFromParts = calcObjectCRCFromParts(downloadFileResult.partResults);
            resumableDownloadResult.setClientCRC(calcObjectCRCFromParts);
            try {
                OSSUtils.checkChecksum(calcObjectCRCFromParts, this.mCheckPoint.fileStat.serverCRC, downloadFileResult.partResults.get(0).requestId);
            } catch (InconsistentException e) {
                removeFile(this.checkpointPath);
                removeFile(this.mRequest.getTempFilePath());
                throw e;
            }
        }
        removeFile(this.checkpointPath);
        moveFile(new File(this.mRequest.getTempFilePath()), new File(this.mRequest.getDownloadToFilePath()));
        resumableDownloadResult.setServerCRC(this.mCheckPoint.fileStat.serverCRC);
        resumableDownloadResult.setMetadata(downloadFileResult.metadata);
        resumableDownloadResult.setRequestId(downloadFileResult.partResults.get(0).requestId);
        resumableDownloadResult.setStatusCode(200);
        return resumableDownloadResult;
    }

    private static Long calcObjectCRCFromParts(List<DownloadPartResult> list) {
        long j = 0;
        for (DownloadPartResult next : list) {
            if (next.clientCRC == null || next.length <= 0) {
                return null;
            }
            j = CRC64.combine(j, next.clientCRC.longValue(), next.length);
        }
        return new Long(j);
    }

    private ArrayList<DownloadPart> splitFile(Range range, long j, long j2) {
        int i = 0;
        if (j <= 0) {
            DownloadPart downloadPart = new DownloadPart();
            downloadPart.start = 0;
            downloadPart.end = -1;
            downloadPart.length = 0;
            downloadPart.partNumber = 0;
            ArrayList<DownloadPart> arrayList = new ArrayList<>();
            arrayList.add(downloadPart);
            return arrayList;
        }
        long begin = range.getBegin();
        long end = range.getEnd() - range.getBegin();
        long j3 = end / j2;
        if (end % j2 > 0) {
            j3++;
        }
        ArrayList<DownloadPart> arrayList2 = new ArrayList<>();
        while (true) {
            long j4 = (long) i;
            if (j4 >= j3) {
                return arrayList2;
            }
            DownloadPart downloadPart2 = new DownloadPart();
            long j5 = j4 * j2;
            downloadPart2.start = begin + j5;
            int i2 = i + 1;
            downloadPart2.end = ((((long) i2) * j2) + begin) - 1;
            int i3 = i2;
            downloadPart2.length = (downloadPart2.end - downloadPart2.start) + 1;
            long j6 = begin + end;
            if (downloadPart2.end >= j6) {
                downloadPart2.end = -1;
                downloadPart2.length = j6 - downloadPart2.start;
            }
            downloadPart2.partNumber = i;
            downloadPart2.fileStart = j5;
            arrayList2.add(downloadPart2);
            i = i3;
        }
    }

    private Range correctRange(Range range, long j) {
        long j2 = 0;
        if (range != null) {
            long begin = range.getBegin();
            if (range.getBegin() != -1) {
                j2 = begin;
            }
            j = range.getEnd() == -1 ? j - j2 : range.getEnd() - range.getBegin();
        }
        return new Range(j2, j + j2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.util.zip.CheckedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.util.zip.CheckedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.util.zip.CheckedInputStream} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0183 A[SYNTHETIC, Splitter:B:66:0x0183] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x018b A[Catch:{ IOException -> 0x0187 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void downloadPart(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask<Requst, Result>.DownloadFileResult r13, com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart r14) {
        /*
            r12 = this;
            r0 = 0
            com.alibaba.sdk.android.oss.network.ExecutionContext r1 = r12.mContext     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
            com.alibaba.sdk.android.oss.network.CancellationHandler r1 = r1.getCancellationHandler()     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
            boolean r1 = r1.isCancelled()     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
            if (r1 == 0) goto L_0x0016
            java.util.concurrent.ThreadPoolExecutor r1 = r12.mPoolExecutor     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
            java.util.concurrent.BlockingQueue r1 = r1.getQueue()     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
            r1.clear()     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
        L_0x0016:
            long r1 = r12.downloadPartSize     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
            r3 = 1
            long r1 = r1 + r3
            r12.downloadPartSize = r1     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
            com.alibaba.sdk.android.oss.model.ResumableDownloadRequest r2 = r12.mRequest     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
            java.lang.String r2 = r2.getTempFilePath()     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
            java.lang.String r5 = "rw"
            r1.<init>(r2, r5)     // Catch:{ Exception -> 0x0167, all -> 0x0164 }
            long r5 = r14.fileStart     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            r1.seek(r5)     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.model.ResumableDownloadRequest r2 = r12.mRequest     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            java.util.Map r2 = r2.getRequestHeader()     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.model.GetObjectRequest r5 = new com.alibaba.sdk.android.oss.model.GetObjectRequest     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.model.ResumableDownloadRequest r6 = r12.mRequest     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            java.lang.String r6 = r6.getBucketName()     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.model.ResumableDownloadRequest r7 = r12.mRequest     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            java.lang.String r7 = r7.getObjectKey()     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            r5.<init>(r6, r7)     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.model.Range r6 = new com.alibaba.sdk.android.oss.model.Range     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            long r7 = r14.start     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            long r9 = r14.end     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            r6.<init>(r7, r9)     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            r5.setRange(r6)     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            r5.setRequestHeaders(r2)     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r2 = r12.mOperation     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.internal.OSSAsyncTask r2 = r2.getObject(r5, r0)     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.model.OSSResult r2 = r2.getResult()     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.model.GetObjectResult r2 = (com.alibaba.sdk.android.oss.model.GetObjectResult) r2     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            java.io.InputStream r0 = r2.getObjectContent()     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            long r5 = r14.length     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            int r6 = (int) r5     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            byte[] r5 = new byte[r6]     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.model.ResumableDownloadRequest r6 = r12.mRequest     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            java.lang.Enum r6 = r6.getCRC64()     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.model.OSSRequest$CRC64Config r7 = com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            if (r6 != r7) goto L_0x007f
            java.util.zip.CheckedInputStream r6 = new java.util.zip.CheckedInputStream     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.common.utils.CRC64 r7 = new com.alibaba.sdk.android.oss.common.utils.CRC64     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            r7.<init>()     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            r6.<init>(r0, r7)     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            r0 = r6
        L_0x007f:
            int r6 = r0.read(r5)     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            long r6 = (long) r6     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            r8 = -1
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0090
            r8 = 0
            int r7 = (int) r6     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            r1.write(r5, r8, r7)     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            goto L_0x007f
        L_0x0090:
            java.lang.Object r5 = r12.mLock     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            monitor-enter(r5)     // Catch:{ Exception -> 0x0160, all -> 0x015e }
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadPartResult r6 = new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadPartResult     // Catch:{ all -> 0x015b }
            r6.<init>()     // Catch:{ all -> 0x015b }
            int r7 = r14.partNumber     // Catch:{ all -> 0x015b }
            r6.partNumber = r7     // Catch:{ all -> 0x015b }
            java.lang.String r7 = r2.getRequestId()     // Catch:{ all -> 0x015b }
            r6.requestId = r7     // Catch:{ all -> 0x015b }
            long r7 = r2.getContentLength()     // Catch:{ all -> 0x015b }
            r6.length = r7     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.model.ResumableDownloadRequest r7 = r12.mRequest     // Catch:{ all -> 0x015b }
            java.lang.Enum r7 = r7.getCRC64()     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.model.OSSRequest$CRC64Config r8 = com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES     // Catch:{ all -> 0x015b }
            if (r7 != r8) goto L_0x00c9
            r7 = r0
            java.util.zip.CheckedInputStream r7 = (java.util.zip.CheckedInputStream) r7     // Catch:{ all -> 0x015b }
            java.util.zip.Checksum r7 = r7.getChecksum()     // Catch:{ all -> 0x015b }
            long r7 = r7.getValue()     // Catch:{ all -> 0x015b }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x015b }
            r6.clientCRC = r7     // Catch:{ all -> 0x015b }
            long r7 = r7.longValue()     // Catch:{ all -> 0x015b }
            r14.crc = r7     // Catch:{ all -> 0x015b }
        L_0x00c9:
            java.util.ArrayList<com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadPartResult> r7 = r13.partResults     // Catch:{ all -> 0x015b }
            r7.add(r6)     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.model.ObjectMetadata r6 = r13.metadata     // Catch:{ all -> 0x015b }
            if (r6 != 0) goto L_0x00d8
            com.alibaba.sdk.android.oss.model.ObjectMetadata r2 = r2.getMetadata()     // Catch:{ all -> 0x015b }
            r13.metadata = r2     // Catch:{ all -> 0x015b }
        L_0x00d8:
            long r6 = r12.completedPartSize     // Catch:{ all -> 0x015b }
            long r6 = r6 + r3
            r12.completedPartSize = r6     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.network.ExecutionContext r13 = r12.mContext     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.network.CancellationHandler r13 = r13.getCancellationHandler()     // Catch:{ all -> 0x015b }
            boolean r13 = r13.isCancelled()     // Catch:{ all -> 0x015b }
            if (r13 == 0) goto L_0x00f8
            long r13 = r12.downloadPartSize     // Catch:{ all -> 0x015b }
            long r2 = r12.completedPartSize     // Catch:{ all -> 0x015b }
            long r6 = r12.mPartExceptionCount     // Catch:{ all -> 0x015b }
            long r2 = r2 - r6
            int r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0151
            r12.checkCancel()     // Catch:{ all -> 0x015b }
            goto L_0x0151
        L_0x00f8:
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$CheckPoint r13 = r12.mCheckPoint     // Catch:{ all -> 0x015b }
            java.util.ArrayList<com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadPart> r13 = r13.parts     // Catch:{ all -> 0x015b }
            int r13 = r13.size()     // Catch:{ all -> 0x015b }
            long r2 = (long) r13     // Catch:{ all -> 0x015b }
            long r6 = r12.completedPartSize     // Catch:{ all -> 0x015b }
            long r8 = r12.mPartExceptionCount     // Catch:{ all -> 0x015b }
            long r6 = r6 - r8
            int r13 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r13 != 0) goto L_0x010d
            r12.notifyMultipartThread()     // Catch:{ all -> 0x015b }
        L_0x010d:
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$CheckPoint r13 = r12.mCheckPoint     // Catch:{ all -> 0x015b }
            int r14 = r14.partNumber     // Catch:{ all -> 0x015b }
            r2 = 1
            r13.update(r14, r2)     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.model.ResumableDownloadRequest r13 = r12.mRequest     // Catch:{ all -> 0x015b }
            java.lang.Boolean r13 = r13.getEnableCheckPoint()     // Catch:{ all -> 0x015b }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x015b }
            if (r13 == 0) goto L_0x0128
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$CheckPoint r13 = r12.mCheckPoint     // Catch:{ all -> 0x015b }
            java.lang.String r14 = r12.checkpointPath     // Catch:{ all -> 0x015b }
            r13.dump(r14)     // Catch:{ all -> 0x015b }
        L_0x0128:
            com.alibaba.sdk.android.oss.model.ResumableDownloadRequest r13 = r12.mRequest     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.model.Range r13 = r13.getRange()     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$CheckPoint r14 = r12.mCheckPoint     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$FileStat r14 = r14.fileStat     // Catch:{ all -> 0x015b }
            long r2 = r14.fileLength     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.model.Range r13 = r12.correctRange(r13, r2)     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.callback.OSSProgressCallback r14 = r12.mProgressCallback     // Catch:{ all -> 0x015b }
            if (r14 == 0) goto L_0x0151
            com.alibaba.sdk.android.oss.callback.OSSProgressCallback r6 = r12.mProgressCallback     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.model.ResumableDownloadRequest r7 = r12.mRequest     // Catch:{ all -> 0x015b }
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$CheckPoint r14 = r12.mCheckPoint     // Catch:{ all -> 0x015b }
            long r8 = r14.downloadLength     // Catch:{ all -> 0x015b }
            long r2 = r13.getEnd()     // Catch:{ all -> 0x015b }
            long r13 = r13.getBegin()     // Catch:{ all -> 0x015b }
            long r10 = r2 - r13
            r6.onProgress(r7, r8, r10)     // Catch:{ all -> 0x015b }
        L_0x0151:
            monitor-exit(r5)     // Catch:{ all -> 0x015b }
            r1.close()     // Catch:{ IOException -> 0x0172 }
            if (r0 == 0) goto L_0x017d
            r0.close()     // Catch:{ IOException -> 0x0172 }
            goto L_0x017d
        L_0x015b:
            r13 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x015b }
            throw r13     // Catch:{ Exception -> 0x0160, all -> 0x015e }
        L_0x015e:
            r13 = move-exception
            goto L_0x0181
        L_0x0160:
            r13 = move-exception
            r14 = r0
            r0 = r1
            goto L_0x0169
        L_0x0164:
            r13 = move-exception
            r1 = r0
            goto L_0x0181
        L_0x0167:
            r13 = move-exception
            r14 = r0
        L_0x0169:
            r12.processException(r13)     // Catch:{ all -> 0x017e }
            if (r0 == 0) goto L_0x0174
            r0.close()     // Catch:{ IOException -> 0x0172 }
            goto L_0x0174
        L_0x0172:
            r13 = move-exception
            goto L_0x017a
        L_0x0174:
            if (r14 == 0) goto L_0x017d
            r14.close()     // Catch:{ IOException -> 0x0172 }
            goto L_0x017d
        L_0x017a:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r13)
        L_0x017d:
            return
        L_0x017e:
            r13 = move-exception
            r1 = r0
            r0 = r14
        L_0x0181:
            if (r1 == 0) goto L_0x0189
            r1.close()     // Catch:{ IOException -> 0x0187 }
            goto L_0x0189
        L_0x0187:
            r14 = move-exception
            goto L_0x018f
        L_0x0189:
            if (r0 == 0) goto L_0x0192
            r0.close()     // Catch:{ IOException -> 0x0187 }
            goto L_0x0192
        L_0x018f:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r14)
        L_0x0192:
            goto L_0x0194
        L_0x0193:
            throw r13
        L_0x0194:
            goto L_0x0193
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.downloadPart(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadFileResult, com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$DownloadPart):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createFile(java.lang.String r4, long r5) throws java.io.IOException {
        /*
            r3 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            r4 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "rw"
            r1.<init>(r0, r2)     // Catch:{ all -> 0x0018 }
            r1.setLength(r5)     // Catch:{ all -> 0x0014 }
            r1.close()
            return
        L_0x0014:
            r4 = move-exception
            r5 = r4
            r4 = r1
            goto L_0x0019
        L_0x0018:
            r5 = move-exception
        L_0x0019:
            if (r4 == 0) goto L_0x001e
            r4.close()
        L_0x001e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.createFile(java.lang.String, long):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void moveFile(java.io.File r5, java.io.File r6) throws java.io.IOException {
        /*
            r4 = this;
            boolean r0 = r5.renameTo(r6)
            if (r0 != 0) goto L_0x0063
            java.lang.String r0 = "moveFile"
            java.lang.String r1 = "rename"
            android.util.Log.i(r0, r1)
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0053, all -> 0x004f }
            r1.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0053, all -> 0x004f }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0048 }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x004b, all -> 0x0048 }
            r4.copyFile(r1, r2)     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
            boolean r6 = r5.delete()     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
            if (r6 == 0) goto L_0x0028
            r1.close()
            r2.close()
            goto L_0x0063
        L_0x0028:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
            java.lang.String r3 = "Failed to delete original file '"
            r0.append(r3)     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
            r0.append(r5)     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
            java.lang.String r5 = "'"
            r0.append(r5)     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
            java.lang.String r5 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
            r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
            throw r6     // Catch:{ FileNotFoundException -> 0x0046, all -> 0x0044 }
        L_0x0044:
            r5 = move-exception
            goto L_0x0058
        L_0x0046:
            r5 = move-exception
            goto L_0x004d
        L_0x0048:
            r5 = move-exception
            r2 = r0
            goto L_0x0058
        L_0x004b:
            r5 = move-exception
            r2 = r0
        L_0x004d:
            r0 = r1
            goto L_0x0055
        L_0x004f:
            r5 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x0058
        L_0x0053:
            r5 = move-exception
            r2 = r0
        L_0x0055:
            throw r5     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r5 = move-exception
            r1 = r0
        L_0x0058:
            if (r1 == 0) goto L_0x005d
            r1.close()
        L_0x005d:
            if (r2 == 0) goto L_0x0062
            r2.close()
        L_0x0062:
            throw r5
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.moveFile(java.io.File, java.io.File):void");
    }

    private void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    /* access modifiers changed from: protected */
    public void processException(Exception exc) {
        synchronized (this.mLock) {
            this.mPartExceptionCount++;
            if (this.mDownloadException == null) {
                this.mDownloadException = exc;
                this.mLock.notify();
            }
        }
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
        if (this.mDownloadException != null) {
            releasePool();
            Exception exc = this.mDownloadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            } else if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            } else if (exc instanceof ClientException) {
                throw ((ClientException) exc);
            } else {
                throw new ClientException(exc.getMessage(), this.mDownloadException);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkWaitCondition(int i) {
        return this.completedPartSize != ((long) i);
    }

    /* access modifiers changed from: protected */
    public void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("Resumable download cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
        }
    }

    static class DownloadPart implements Serializable {
        private static final long serialVersionUID = -3506020776131733942L;
        public long crc;
        public long end;
        public long fileStart;
        public boolean isCompleted;
        public long length;
        public int partNumber;
        public long start;

        DownloadPart() {
        }

        public int hashCode() {
            int i = (this.partNumber + 31) * 31;
            int i2 = this.isCompleted ? 1231 : 1237;
            long j = this.end;
            long j2 = this.start;
            long j3 = this.crc;
            return ((((((i + i2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }
    }

    static class CheckPoint implements Serializable {
        private static final long serialVersionUID = -8470273912385636504L;
        public String bucketName;
        public String downloadFile;
        public long downloadLength;
        public FileStat fileStat;
        public int md5;
        public String objectKey;
        public ArrayList<DownloadPart> parts;

        CheckPoint() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0028 A[SYNTHETIC, Splitter:B:18:0x0028] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0030 A[Catch:{ all -> 0x002c }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void load(java.lang.String r4) throws java.io.IOException, java.lang.ClassNotFoundException {
            /*
                r3 = this;
                monitor-enter(r3)
                r0 = 0
                java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0024 }
                r1.<init>(r4)     // Catch:{ all -> 0x0024 }
                java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0022 }
                r4.<init>(r1)     // Catch:{ all -> 0x0022 }
                java.lang.Object r0 = r4.readObject()     // Catch:{ all -> 0x001d }
                com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$CheckPoint r0 = (com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.CheckPoint) r0     // Catch:{ all -> 0x001d }
                r3.assign(r0)     // Catch:{ all -> 0x001d }
                r4.close()     // Catch:{ all -> 0x002c }
                r1.close()     // Catch:{ all -> 0x002c }
                monitor-exit(r3)
                return
            L_0x001d:
                r0 = move-exception
                r2 = r0
                r0 = r4
                r4 = r2
                goto L_0x0026
            L_0x0022:
                r4 = move-exception
                goto L_0x0026
            L_0x0024:
                r4 = move-exception
                r1 = r0
            L_0x0026:
                if (r0 == 0) goto L_0x002e
                r0.close()     // Catch:{ all -> 0x002c }
                goto L_0x002e
            L_0x002c:
                r4 = move-exception
                goto L_0x0034
            L_0x002e:
                if (r1 == 0) goto L_0x0033
                r1.close()     // Catch:{ all -> 0x002c }
            L_0x0033:
                throw r4     // Catch:{ all -> 0x002c }
            L_0x0034:
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.CheckPoint.load(java.lang.String):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0028 A[SYNTHETIC, Splitter:B:20:0x0028] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x002d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void dump(java.lang.String r4) throws java.io.IOException {
            /*
                r3 = this;
                monitor-enter(r3)
                int r0 = r3.hashCode()     // Catch:{ all -> 0x0031 }
                r3.md5 = r0     // Catch:{ all -> 0x0031 }
                r0 = 0
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0024 }
                r1.<init>(r4)     // Catch:{ all -> 0x0024 }
                java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0022 }
                r4.<init>(r1)     // Catch:{ all -> 0x0022 }
                r4.writeObject(r3)     // Catch:{ all -> 0x001d }
                r4.close()     // Catch:{ all -> 0x0031 }
                r1.close()     // Catch:{ all -> 0x0031 }
                monitor-exit(r3)
                return
            L_0x001d:
                r0 = move-exception
                r2 = r0
                r0 = r4
                r4 = r2
                goto L_0x0026
            L_0x0022:
                r4 = move-exception
                goto L_0x0026
            L_0x0024:
                r4 = move-exception
                r1 = r0
            L_0x0026:
                if (r0 == 0) goto L_0x002b
                r0.close()     // Catch:{ all -> 0x0031 }
            L_0x002b:
                if (r1 == 0) goto L_0x0030
                r1.close()     // Catch:{ all -> 0x0031 }
            L_0x0030:
                throw r4     // Catch:{ all -> 0x0031 }
            L_0x0031:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.CheckPoint.dump(java.lang.String):void");
        }

        public synchronized void update(int i, boolean z) throws IOException {
            this.parts.get(i).isCompleted = z;
            this.downloadLength += this.parts.get(i).length;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0059, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean isValid(com.alibaba.sdk.android.oss.internal.InternalRequestOperation r7) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
            /*
                r6 = this;
                monitor-enter(r6)
                int r0 = r6.md5     // Catch:{ all -> 0x005a }
                int r1 = r6.hashCode()     // Catch:{ all -> 0x005a }
                r2 = 0
                if (r0 == r1) goto L_0x000c
                monitor-exit(r6)
                return r2
            L_0x000c:
                java.lang.String r0 = r6.bucketName     // Catch:{ all -> 0x005a }
                java.lang.String r1 = r6.objectKey     // Catch:{ all -> 0x005a }
                com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$FileStat r7 = com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.FileStat.getFileStat(r7, r0, r1)     // Catch:{ all -> 0x005a }
                com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$FileStat r0 = r6.fileStat     // Catch:{ all -> 0x005a }
                java.util.Date r0 = r0.lastModified     // Catch:{ all -> 0x005a }
                if (r0 != 0) goto L_0x0032
                com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$FileStat r0 = r6.fileStat     // Catch:{ all -> 0x005a }
                long r0 = r0.fileLength     // Catch:{ all -> 0x005a }
                long r3 = r7.fileLength     // Catch:{ all -> 0x005a }
                int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r5 != 0) goto L_0x0030
                com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$FileStat r0 = r6.fileStat     // Catch:{ all -> 0x005a }
                java.lang.String r0 = r0.etag     // Catch:{ all -> 0x005a }
                java.lang.String r7 = r7.etag     // Catch:{ all -> 0x005a }
                boolean r7 = r0.equals(r7)     // Catch:{ all -> 0x005a }
                if (r7 != 0) goto L_0x0055
            L_0x0030:
                monitor-exit(r6)
                return r2
            L_0x0032:
                com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$FileStat r0 = r6.fileStat     // Catch:{ all -> 0x005a }
                long r0 = r0.fileLength     // Catch:{ all -> 0x005a }
                long r3 = r7.fileLength     // Catch:{ all -> 0x005a }
                int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r5 != 0) goto L_0x0058
                com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$FileStat r0 = r6.fileStat     // Catch:{ all -> 0x005a }
                java.util.Date r0 = r0.lastModified     // Catch:{ all -> 0x005a }
                java.util.Date r1 = r7.lastModified     // Catch:{ all -> 0x005a }
                boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x005a }
                if (r0 == 0) goto L_0x0058
                com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$FileStat r0 = r6.fileStat     // Catch:{ all -> 0x005a }
                java.lang.String r0 = r0.etag     // Catch:{ all -> 0x005a }
                java.lang.String r7 = r7.etag     // Catch:{ all -> 0x005a }
                boolean r7 = r0.equals(r7)     // Catch:{ all -> 0x005a }
                if (r7 != 0) goto L_0x0055
                goto L_0x0058
            L_0x0055:
                r7 = 1
                monitor-exit(r6)
                return r7
            L_0x0058:
                monitor-exit(r6)
                return r2
            L_0x005a:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.CheckPoint.isValid(com.alibaba.sdk.android.oss.internal.InternalRequestOperation):boolean");
        }

        public int hashCode() {
            String str = this.bucketName;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.downloadFile;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.objectKey;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            FileStat fileStat2 = this.fileStat;
            int hashCode4 = (hashCode3 + (fileStat2 == null ? 0 : fileStat2.hashCode())) * 31;
            ArrayList<DownloadPart> arrayList = this.parts;
            if (arrayList != null) {
                i = arrayList.hashCode();
            }
            long j = this.downloadLength;
            return ((hashCode4 + i) * 31) + ((int) (j ^ (j >>> 32)));
        }

        private void assign(CheckPoint checkPoint) {
            this.md5 = checkPoint.md5;
            this.downloadFile = checkPoint.downloadFile;
            this.bucketName = checkPoint.bucketName;
            this.objectKey = checkPoint.objectKey;
            this.fileStat = checkPoint.fileStat;
            this.parts = checkPoint.parts;
            this.downloadLength = checkPoint.downloadLength;
        }
    }

    static class FileStat implements Serializable {
        private static final long serialVersionUID = 3896323364904643963L;
        public String etag;
        public long fileLength;
        public Date lastModified;
        public String md5;
        public String requestId;
        public Long serverCRC;

        FileStat() {
        }

        public static FileStat getFileStat(InternalRequestOperation internalRequestOperation, String str, String str2) throws ClientException, ServiceException {
            HeadObjectResult result = internalRequestOperation.headObject(new HeadObjectRequest(str, str2), (OSSCompletedCallback<HeadObjectRequest, HeadObjectResult>) null).getResult();
            FileStat fileStat = new FileStat();
            fileStat.fileLength = result.getMetadata().getContentLength();
            fileStat.etag = result.getMetadata().getETag();
            fileStat.lastModified = result.getMetadata().getLastModified();
            fileStat.serverCRC = result.getServerCRC();
            fileStat.requestId = result.getRequestId();
            return fileStat;
        }

        public int hashCode() {
            String str = this.etag;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Date date = this.lastModified;
            if (date != null) {
                i = date.hashCode();
            }
            long j = this.fileLength;
            return ((hashCode + i) * 31) + ((int) (j ^ (j >>> 32)));
        }
    }

    static class DownloadPartResult {
        public Long clientCRC;
        public long length;
        public int partNumber;
        public String requestId;

        DownloadPartResult() {
        }
    }

    class DownloadFileResult extends OSSResult {
        public ObjectMetadata metadata;
        public ArrayList<DownloadPartResult> partResults;

        DownloadFileResult() {
        }
    }
}
