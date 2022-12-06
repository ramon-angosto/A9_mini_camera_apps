package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class OkHTTPFileDownloadTask implements IDownloadTask {
    private final IDatabaseHelper databaseHelper;
    private volatile DownloadMessage downloadMessage;
    private DownloadModel downloadModel;
    private final DownloadRequest downloadRequest;
    private DownloadResponse downloadResponse;
    private String etag = "";
    private InputStream inputStream;
    private DownloadFileOutputStream outputStream;
    private ResponseBody responseBody;

    private OkHTTPFileDownloadTask(DownloadRequest downloadRequest2, DownloadModel downloadModel2, IDatabaseHelper iDatabaseHelper, DownloadMessage downloadMessage2) {
        this.downloadRequest = downloadRequest2;
        this.downloadModel = downloadModel2;
        this.databaseHelper = iDatabaseHelper;
        this.downloadMessage = downloadMessage2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x025a, code lost:
        if (r10.isCanceled() == false) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x029f, code lost:
        if (r10.isCanceled() == false) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02e3, code lost:
        if (r10.isCanceled() == false) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02e5, code lost:
        r10.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02ea, code lost:
        return r12.downloadResponse;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0177, code lost:
        if (r10.isCanceled() != false) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01d0, code lost:
        if (r10.isCanceled() == false) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0215, code lost:
        if (r10.isCanceled() == false) goto L_0x02e5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0227 A[SYNTHETIC, Splitter:B:100:0x0227] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0234 A[SYNTHETIC, Splitter:B:105:0x0234] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x023f A[SYNTHETIC, Splitter:B:110:0x023f] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026c A[SYNTHETIC, Splitter:B:124:0x026c] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0279 A[SYNTHETIC, Splitter:B:129:0x0279] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0284 A[SYNTHETIC, Splitter:B:134:0x0284] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02b0 A[SYNTHETIC, Splitter:B:148:0x02b0] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02bd A[SYNTHETIC, Splitter:B:153:0x02bd] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02c8 A[SYNTHETIC, Splitter:B:158:0x02c8] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x02f3 A[SYNTHETIC, Splitter:B:171:0x02f3] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0300 A[SYNTHETIC, Splitter:B:176:0x0300] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x030b A[SYNTHETIC, Splitter:B:181:0x030b] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0144 A[SYNTHETIC, Splitter:B:20:0x0144] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0151 A[SYNTHETIC, Splitter:B:25:0x0151] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x015c A[SYNTHETIC, Splitter:B:30:0x015c] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x019d A[SYNTHETIC, Splitter:B:52:0x019d] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01aa A[SYNTHETIC, Splitter:B:57:0x01aa] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01b5 A[SYNTHETIC, Splitter:B:62:0x01b5] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01e2 A[SYNTHETIC, Splitter:B:76:0x01e2] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ef A[SYNTHETIC, Splitter:B:81:0x01ef] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01fa A[SYNTHETIC, Splitter:B:86:0x01fa] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x020c  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:120:0x0261=Splitter:B:120:0x0261, B:48:0x0192=Splitter:B:48:0x0192, B:144:0x02a5=Splitter:B:144:0x02a5, B:72:0x01d7=Splitter:B:72:0x01d7, B:96:0x021c=Splitter:B:96:0x021c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mbridge.msdk.foundation.download.DownloadResponse run() {
        /*
            r12 = this;
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = new com.mbridge.msdk.foundation.download.DownloadResponse
            r0.<init>()
            r12.downloadResponse = r0
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = r12.downloadMessage
            java.lang.String r0 = r0.getSaveFileName()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r1 = r12.downloadRequest
            java.lang.String r7 = r1.getCacheDirectoryPath()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r1 = r12.downloadRequest
            java.lang.String r8 = r1.getDownloadId()
            com.mbridge.msdk.foundation.download.core.GlobalComponent r1 = com.mbridge.msdk.foundation.download.core.GlobalComponent.getInstance()
            com.mbridge.msdk.thrid.okhttp.OkHttpClient r1 = r1.getOkHttpClient()
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r1 = r1.newBuilder()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r12.downloadRequest
            long r2 = r2.getConnectTimeout()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r1 = r1.connectTimeout(r2, r4)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r12.downloadRequest
            long r2 = r2.getReadTimeout()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r1 = r1.readTimeout(r2, r4)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r12.downloadRequest
            long r2 = r2.getWriteTimeout()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r1 = r1.writeTimeout(r2, r4)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r12.downloadRequest
            long r2 = r2.getTimeout()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r1 = r1.callTimeout(r2, r4)
            r2 = 1
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r1 = r1.retryOnConnectionFailure(r2)
            com.mbridge.msdk.thrid.okhttp.OkHttpClient r1 = r1.build()
            com.mbridge.msdk.thrid.okhttp.CacheControl$Builder r3 = new com.mbridge.msdk.thrid.okhttp.CacheControl$Builder
            r3.<init>()
            com.mbridge.msdk.thrid.okhttp.CacheControl$Builder r3 = r3.noCache()
            com.mbridge.msdk.thrid.okhttp.CacheControl r3 = r3.build()
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.Object[] r5 = new java.lang.Object[r2]
            com.mbridge.msdk.foundation.download.core.DownloadRequest r6 = r12.downloadRequest
            long r9 = r6.getDownloadedBytes()
            java.lang.Long r6 = java.lang.Long.valueOf(r9)
            r9 = 0
            r5[r9] = r6
            java.lang.String r6 = "bytes=%d-"
            java.lang.String r4 = java.lang.String.format(r4, r6, r5)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r5 = r12.downloadRequest
            com.mbridge.msdk.foundation.download.DownloadStatus r5 = r5.getStatus()
            com.mbridge.msdk.foundation.download.DownloadStatus r6 = com.mbridge.msdk.foundation.download.DownloadStatus.CANCELLED
            if (r5 != r6) goto L_0x0094
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r12.downloadResponse
            r0.setCancelled(r2)
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r12.downloadResponse
            return r0
        L_0x0094:
            com.mbridge.msdk.thrid.okhttp.Request$Builder r2 = new com.mbridge.msdk.thrid.okhttp.Request$Builder
            r2.<init>()
            com.mbridge.msdk.foundation.download.DownloadMessage r5 = r12.downloadMessage
            java.lang.String r5 = r5.getDownloadUrl()
            com.mbridge.msdk.thrid.okhttp.Request$Builder r2 = r2.url((java.lang.String) r5)
            com.mbridge.msdk.thrid.okhttp.Request$Builder r2 = r2.cacheControl(r3)
            java.lang.String r3 = "Connection"
            java.lang.String r5 = "close"
            com.mbridge.msdk.thrid.okhttp.Request$Builder r2 = r2.addHeader(r3, r5)
            java.lang.String r3 = "Range"
            com.mbridge.msdk.thrid.okhttp.Request$Builder r2 = r2.addHeader(r3, r4)
            com.mbridge.msdk.thrid.okhttp.Request r2 = r2.build()
            com.mbridge.msdk.thrid.okhttp.Call r10 = r1.newCall(r2)
            r1 = 0
            com.mbridge.msdk.thrid.okhttp.Response r11 = r10.execute()     // Catch:{ SocketTimeoutException -> 0x02a2, UnknownHostException -> 0x025e, IOException -> 0x0219, IllegalAccessException -> 0x01d4, Exception -> 0x018f, all -> 0x018b }
            boolean r1 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r11)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            if (r1 != 0) goto L_0x0126
            com.mbridge.msdk.thrid.okhttp.ResponseBody r1 = r11.body()     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            boolean r1 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r1)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            if (r1 == 0) goto L_0x00d3
            goto L_0x0126
        L_0x00d3:
            int r6 = r11.code()     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            boolean r1 = r11.isSuccessful()     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            if (r1 != 0) goto L_0x0113
            com.mbridge.msdk.foundation.download.DownloadError r1 = new com.mbridge.msdk.foundation.download.DownloadError     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r3.<init>()     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            java.lang.String r4 = "responseCode "
            r3.append(r4)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r3.append(r6)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            java.lang.String r4 = "\n"
            r3.append(r4)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            com.mbridge.msdk.thrid.okhttp.ResponseBody r4 = r11.body()     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            java.lang.String r4 = r4.string()     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r3.append(r4)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            java.lang.String r3 = r3.toString()     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r2.<init>(r3)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r1.<init>(r2)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            com.mbridge.msdk.foundation.download.DownloadResponse r2 = r12.downloadResponse     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r2.setError(r1)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            com.mbridge.msdk.foundation.download.DownloadResponse r1 = r12.downloadResponse     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r1.setSuccessful(r9)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            goto L_0x013c
        L_0x0113:
            java.lang.String r1 = "ETag"
            java.lang.String r2 = ""
            java.lang.String r1 = r11.header(r1, r2)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r12.etag = r1     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r1 = r12
            r2 = r0
            r3 = r7
            r4 = r8
            r5 = r11
            r1.handlerRequestSuccessful(r2, r3, r4, r5, r6)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            goto L_0x013c
        L_0x0126:
            com.mbridge.msdk.foundation.download.DownloadError r1 = new com.mbridge.msdk.foundation.download.DownloadError     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            java.lang.String r3 = "response is null"
            r2.<init>(r3)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r1.<init>(r2)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            com.mbridge.msdk.foundation.download.DownloadResponse r2 = r12.downloadResponse     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r2.setError(r1)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            com.mbridge.msdk.foundation.download.DownloadResponse r1 = r12.downloadResponse     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
            r1.setSuccessful(r9)     // Catch:{ SocketTimeoutException -> 0x0188, UnknownHostException -> 0x0185, IOException -> 0x0182, IllegalAccessException -> 0x0180, Exception -> 0x017e }
        L_0x013c:
            java.io.InputStream r0 = r12.inputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x0149
            java.io.InputStream r0 = r12.inputStream     // Catch:{ IOException -> 0x0149 }
            r0.close()     // Catch:{ IOException -> 0x0149 }
        L_0x0149:
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x0156
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream     // Catch:{ IOException -> 0x0156 }
            r0.close()     // Catch:{ IOException -> 0x0156 }
        L_0x0156:
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r11)
            if (r0 == 0) goto L_0x0166
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r11.body()     // Catch:{ Exception -> 0x0166 }
            r0.close()     // Catch:{ Exception -> 0x0166 }
            r11.close()     // Catch:{ Exception -> 0x0166 }
        L_0x0166:
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x0173
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            r0.close()
        L_0x0173:
            boolean r0 = r10.isCanceled()
            if (r0 != 0) goto L_0x02e8
            goto L_0x02e5
        L_0x017b:
            r0 = move-exception
            goto L_0x02eb
        L_0x017e:
            r1 = move-exception
            goto L_0x0192
        L_0x0180:
            r1 = move-exception
            goto L_0x01d7
        L_0x0182:
            r1 = move-exception
            goto L_0x021c
        L_0x0185:
            r1 = move-exception
            goto L_0x0261
        L_0x0188:
            r1 = move-exception
            goto L_0x02a5
        L_0x018b:
            r0 = move-exception
            r11 = r1
            goto L_0x02eb
        L_0x018f:
            r2 = move-exception
            r11 = r1
            r1 = r2
        L_0x0192:
            r12.handlerException(r0, r7, r8, r1)     // Catch:{ all -> 0x017b }
            java.io.InputStream r0 = r12.inputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x01a2
            java.io.InputStream r0 = r12.inputStream     // Catch:{ IOException -> 0x01a2 }
            r0.close()     // Catch:{ IOException -> 0x01a2 }
        L_0x01a2:
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x01af
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream     // Catch:{ IOException -> 0x01af }
            r0.close()     // Catch:{ IOException -> 0x01af }
        L_0x01af:
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r11)
            if (r0 == 0) goto L_0x01bf
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r11.body()     // Catch:{ Exception -> 0x01bf }
            r0.close()     // Catch:{ Exception -> 0x01bf }
            r11.close()     // Catch:{ Exception -> 0x01bf }
        L_0x01bf:
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x01cc
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            r0.close()
        L_0x01cc:
            boolean r0 = r10.isCanceled()
            if (r0 != 0) goto L_0x02e8
            goto L_0x02e5
        L_0x01d4:
            r2 = move-exception
            r11 = r1
            r1 = r2
        L_0x01d7:
            r12.handlerException(r0, r7, r8, r1)     // Catch:{ all -> 0x017b }
            java.io.InputStream r0 = r12.inputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x01e7
            java.io.InputStream r0 = r12.inputStream     // Catch:{ IOException -> 0x01e7 }
            r0.close()     // Catch:{ IOException -> 0x01e7 }
        L_0x01e7:
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x01f4
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream     // Catch:{ IOException -> 0x01f4 }
            r0.close()     // Catch:{ IOException -> 0x01f4 }
        L_0x01f4:
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r11)
            if (r0 == 0) goto L_0x0204
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r11.body()     // Catch:{ Exception -> 0x0204 }
            r0.close()     // Catch:{ Exception -> 0x0204 }
            r11.close()     // Catch:{ Exception -> 0x0204 }
        L_0x0204:
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x0211
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            r0.close()
        L_0x0211:
            boolean r0 = r10.isCanceled()
            if (r0 != 0) goto L_0x02e8
            goto L_0x02e5
        L_0x0219:
            r2 = move-exception
            r11 = r1
            r1 = r2
        L_0x021c:
            r12.handlerException(r0, r7, r8, r1)     // Catch:{ all -> 0x017b }
            java.io.InputStream r0 = r12.inputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x022c
            java.io.InputStream r0 = r12.inputStream     // Catch:{ IOException -> 0x022c }
            r0.close()     // Catch:{ IOException -> 0x022c }
        L_0x022c:
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x0239
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream     // Catch:{ IOException -> 0x0239 }
            r0.close()     // Catch:{ IOException -> 0x0239 }
        L_0x0239:
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r11)
            if (r0 == 0) goto L_0x0249
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r11.body()     // Catch:{ Exception -> 0x0249 }
            r0.close()     // Catch:{ Exception -> 0x0249 }
            r11.close()     // Catch:{ Exception -> 0x0249 }
        L_0x0249:
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x0256
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            r0.close()
        L_0x0256:
            boolean r0 = r10.isCanceled()
            if (r0 != 0) goto L_0x02e8
            goto L_0x02e5
        L_0x025e:
            r2 = move-exception
            r11 = r1
            r1 = r2
        L_0x0261:
            r12.handlerException(r0, r7, r8, r1)     // Catch:{ all -> 0x017b }
            java.io.InputStream r0 = r12.inputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x0271
            java.io.InputStream r0 = r12.inputStream     // Catch:{ IOException -> 0x0271 }
            r0.close()     // Catch:{ IOException -> 0x0271 }
        L_0x0271:
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x027e
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream     // Catch:{ IOException -> 0x027e }
            r0.close()     // Catch:{ IOException -> 0x027e }
        L_0x027e:
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r11)
            if (r0 == 0) goto L_0x028e
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r11.body()     // Catch:{ Exception -> 0x028e }
            r0.close()     // Catch:{ Exception -> 0x028e }
            r11.close()     // Catch:{ Exception -> 0x028e }
        L_0x028e:
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x029b
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            r0.close()
        L_0x029b:
            boolean r0 = r10.isCanceled()
            if (r0 != 0) goto L_0x02e8
            goto L_0x02e5
        L_0x02a2:
            r2 = move-exception
            r11 = r1
            r1 = r2
        L_0x02a5:
            r12.handlerException(r0, r7, r8, r1)     // Catch:{ all -> 0x017b }
            java.io.InputStream r0 = r12.inputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x02b5
            java.io.InputStream r0 = r12.inputStream     // Catch:{ IOException -> 0x02b5 }
            r0.close()     // Catch:{ IOException -> 0x02b5 }
        L_0x02b5:
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x02c2
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r12.outputStream     // Catch:{ IOException -> 0x02c2 }
            r0.close()     // Catch:{ IOException -> 0x02c2 }
        L_0x02c2:
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r11)
            if (r0 == 0) goto L_0x02d2
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r11.body()     // Catch:{ Exception -> 0x02d2 }
            r0.close()     // Catch:{ Exception -> 0x02d2 }
            r11.close()     // Catch:{ Exception -> 0x02d2 }
        L_0x02d2:
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
            if (r0 == 0) goto L_0x02df
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r12.responseBody
            r0.close()
        L_0x02df:
            boolean r0 = r10.isCanceled()
            if (r0 != 0) goto L_0x02e8
        L_0x02e5:
            r10.cancel()
        L_0x02e8:
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r12.downloadResponse
            return r0
        L_0x02eb:
            java.io.InputStream r1 = r12.inputStream
            boolean r1 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r1)
            if (r1 == 0) goto L_0x02f8
            java.io.InputStream r1 = r12.inputStream     // Catch:{ IOException -> 0x02f8 }
            r1.close()     // Catch:{ IOException -> 0x02f8 }
        L_0x02f8:
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r1 = r12.outputStream
            boolean r1 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r1)
            if (r1 == 0) goto L_0x0305
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r1 = r12.outputStream     // Catch:{ IOException -> 0x0305 }
            r1.close()     // Catch:{ IOException -> 0x0305 }
        L_0x0305:
            boolean r1 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r11)
            if (r1 == 0) goto L_0x0315
            com.mbridge.msdk.thrid.okhttp.ResponseBody r1 = r11.body()     // Catch:{ Exception -> 0x0315 }
            r1.close()     // Catch:{ Exception -> 0x0315 }
            r11.close()     // Catch:{ Exception -> 0x0315 }
        L_0x0315:
            com.mbridge.msdk.thrid.okhttp.ResponseBody r1 = r12.responseBody
            boolean r1 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r1)
            if (r1 == 0) goto L_0x0322
            com.mbridge.msdk.thrid.okhttp.ResponseBody r1 = r12.responseBody
            r1.close()
        L_0x0322:
            boolean r1 = r10.isCanceled()
            if (r1 != 0) goto L_0x032b
            r10.cancel()
        L_0x032b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.core.OkHTTPFileDownloadTask.run():com.mbridge.msdk.foundation.download.DownloadResponse");
    }

    private void handlerRequestSuccessful(String str, String str2, String str3, Response response, int i) throws IOException, IllegalAccessException {
        boolean z = !isSupportResume(i, this.downloadModel);
        if (!(!z || response == null || this.downloadRequest == null || i != 206 || response.body() == null || response.body().contentLength() == this.downloadRequest.getTotalBytes() - this.downloadRequest.getDownloadedBytes())) {
            ILogger logger = GlobalComponent.getInstance().getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("移除： handlerRequestSuccessful： isSupportResume ");
            sb.append(z);
            sb.append(" etag: ");
            sb.append(this.etag);
            sb.append(" etag: ");
            DownloadModel downloadModel2 = this.downloadModel;
            sb.append(downloadModel2 == null ? "null" : downloadModel2.getEtag());
            sb.append(" responseCode: ");
            sb.append(i);
            logger.log(IDownloadTask.TAG, sb.toString());
            this.downloadRequest.setDownloadedBytes(0);
            this.downloadRequest.setTotalBytes(0);
            if (Objects.isNotNull(this.databaseHelper)) {
                this.databaseHelper.remove(str3, str2);
            }
            this.downloadModel = null;
            MBResourceManager.getInstance().deleteFile(new File(this.downloadRequest.getCacheDirectoryPath() + this.downloadMessage.getSaveFileName()));
        }
        this.responseBody = response.body();
        if (Objects.isNull(this.responseBody)) {
            this.downloadResponse.setError(new DownloadError(new IOException("response body is null")));
            this.downloadRequest.setTotalBytes(0);
            this.downloadRequest.setDownloadedBytes(0);
            this.downloadResponse.setSuccessful(false);
            return;
        }
        long contentLength = this.responseBody.contentLength();
        if (this.downloadRequest.getTotalBytes() == 0) {
            this.downloadRequest.setTotalBytes(contentLength);
        }
        this.inputStream = this.responseBody.byteStream();
        if (Objects.isNotNull(this.inputStream)) {
            handleInputStream(str, str2, str3, this.etag);
            return;
        }
        this.downloadResponse.setError(new DownloadError(new IOException("response inputStream is null")));
        this.downloadResponse.setSuccessful(false);
    }

    private void handleInputStream(String str, String str2, String str3, String str4) throws IOException, IllegalAccessException {
        boolean z;
        String str5;
        String str6 = str2;
        boolean z2 = true;
        if (Objects.isNull(this.downloadModel)) {
            this.downloadModel = DownloadModel.create(this.downloadRequest.getDownloadId(), this.downloadMessage.getDownloadUrl(), this.downloadMessage.getResourceUrl(), str4, str2, this.downloadMessage.getSaveFileName(), this.downloadRequest.getTotalBytes(), 0, this.downloadMessage.getDownloadRate(), 1, this.downloadMessage.getDownloadResourceType());
            this.databaseHelper.insert(this.downloadModel);
        } else {
            this.downloadModel = DownloadModel.create(this.downloadModel.getDownloadId(), this.downloadModel.getDownloadUrl(), this.downloadMessage.getResourceUrl(), this.downloadModel.getEtag(), this.downloadModel.getSaveDirectorPath(), this.downloadModel.getSaveFileName(), this.downloadRequest.getTotalBytes(), this.downloadModel.getDownloadedBytes(), this.downloadMessage.getDownloadRate(), this.downloadModel.getUsageCounter() + 1, this.downloadMessage.getDownloadResourceType());
            this.databaseHelper.update(this.downloadModel, str6);
        }
        this.outputStream = MBResourceManager.getInstance().getDownloadFileOutputStream(new File(str6, str));
        this.outputStream.seek(this.downloadRequest.getDownloadedBytes());
        byte[] bArr = new byte[GlobalComponent.getInstance().getByteBufferSize()];
        while (true) {
            int read = this.inputStream.read(bArr);
            if (read == -1) {
                z = z2;
                str5 = str6;
                break;
            }
            this.outputStream.write(bArr, 0, read);
            DownloadRequest downloadRequest2 = this.downloadRequest;
            downloadRequest2.setDownloadedBytes(downloadRequest2.getDownloadedBytes() + ((long) read));
            this.outputStream.flushAndSync();
            int downloadRate = Utils.getDownloadRate(this.downloadRequest.getTotalBytes(), this.downloadRequest.getDownloadedBytes());
            z = z2;
            str5 = str6;
            sendProgress(this.downloadRequest, this.downloadMessage, this.downloadRequest.getDownloadedBytes(), this.downloadRequest.getTotalBytes(), downloadRate);
            if (this.downloadMessage.getDownloadRate() != 100 && downloadRate >= this.downloadMessage.getDownloadRate()) {
                break;
            } else if (this.downloadRequest.getStatus() == DownloadStatus.CANCELLED) {
                this.downloadResponse.setCancelled(z);
                break;
            } else {
                str6 = str5;
                z2 = z;
            }
        }
        IDatabaseHelper databaseHelper2 = GlobalComponent.getInstance().getDatabaseHelper();
        String downloadUrl = this.downloadMessage.getDownloadUrl();
        String resourceUrl = this.downloadMessage.getResourceUrl();
        String saveFileName = this.downloadMessage.getSaveFileName();
        String str7 = str5;
        String str8 = saveFileName;
        boolean z3 = z;
        String str9 = str3;
        databaseHelper2.updateProgress(str9, str7, DownloadModel.create(str3, downloadUrl, resourceUrl, str4, str2, str8, this.downloadRequest.getTotalBytes(), this.downloadRequest.getDownloadedBytes(), this.downloadMessage.getDownloadRate(), this.downloadModel.getUsageCounter(), this.downloadMessage.getDownloadResourceType()));
        if (!this.downloadResponse.isCancelled()) {
            this.downloadResponse.setSuccessful(z3);
        }
    }

    private void handlerException(String str, String str2, String str3, Exception exc) {
        try {
            if (Objects.isNotNull(this.databaseHelper) && Objects.isNotNull(this.downloadRequest)) {
                GlobalComponent.getInstance().getLogger().log(IDownloadTask.TAG, "移除：handlerException");
                this.databaseHelper.remove(str3, str2);
                MBResourceManager instance = MBResourceManager.getInstance();
                instance.deleteFile(new File(this.downloadRequest.getCacheDirectoryPath() + this.downloadMessage.getSaveFileName()));
                this.downloadRequest.setDownloadedBytes(0);
                this.downloadRequest.setTotalBytes(0);
            }
        } catch (Exception unused) {
        }
        this.downloadResponse.setError(new DownloadError(exc));
        this.downloadResponse.setSuccessful(false);
    }

    public static IDownloadTask create(DownloadRequest downloadRequest2, DownloadModel downloadModel2, IDatabaseHelper iDatabaseHelper, DownloadMessage downloadMessage2) {
        return new OkHTTPFileDownloadTask(downloadRequest2, downloadModel2, iDatabaseHelper, downloadMessage2);
    }

    private boolean isSupportResume(int i, DownloadModel downloadModel2) {
        return i == 206 && !TextUtils.isEmpty(this.etag) && (downloadModel2 == null || TextUtils.equals(this.etag, downloadModel2.getEtag()));
    }

    private void sendProgress(DownloadRequest downloadRequest2, DownloadMessage downloadMessage2, long j, long j2, int i) {
        if (downloadRequest2.getStatus() != DownloadStatus.CANCELLED) {
            downloadRequest2.handlerProcessEvent(downloadMessage2, new DownloadProgress(j, j2, i));
        }
    }
}
