package com.alibaba.sdk.android.oss.network;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.internal.OSSRetryHandler;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParser;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class OSSRequestTask<T extends OSSResult> implements Callable<T> {
    private OkHttpClient clone;
    /* access modifiers changed from: private */
    public ExecutionContext context;
    private int currentRetryCount = 0;
    private RequestMessage message;
    private ResponseParser<T> responseParser;
    private OSSRetryHandler retryHandler;

    class ProgressTouchableRequestBody extends RequestBody {
        private static final int SEGMENT_SIZE = 2048;
        private BufferedSink bufferedSink;
        private OSSProgressCallback callback;
        private long contentLength;
        private String contentType;
        private byte[] data;
        private File file;
        private InputStream inputStream;

        public ProgressTouchableRequestBody(File file2, String str, OSSProgressCallback oSSProgressCallback) {
            this.file = file2;
            this.contentType = str;
            this.contentLength = file2.length();
            this.callback = oSSProgressCallback;
        }

        public ProgressTouchableRequestBody(byte[] bArr, String str, OSSProgressCallback oSSProgressCallback) {
            this.data = bArr;
            this.contentType = str;
            this.contentLength = (long) bArr.length;
            this.callback = oSSProgressCallback;
        }

        public ProgressTouchableRequestBody(InputStream inputStream2, long j, String str, OSSProgressCallback oSSProgressCallback) {
            this.inputStream = inputStream2;
            this.contentType = str;
            this.contentLength = j;
            this.callback = oSSProgressCallback;
        }

        public MediaType contentType() {
            return MediaType.parse(this.contentType);
        }

        public long contentLength() throws IOException {
            return this.contentLength;
        }

        public void writeTo(BufferedSink bufferedSink2) throws IOException {
            Source source;
            File file2 = this.file;
            if (file2 != null) {
                source = Okio.source(file2);
            } else {
                byte[] bArr = this.data;
                if (bArr != null) {
                    source = Okio.source((InputStream) new ByteArrayInputStream(bArr));
                } else {
                    InputStream inputStream2 = this.inputStream;
                    source = inputStream2 != null ? Okio.source(inputStream2) : null;
                }
            }
            long j = 0;
            while (true) {
                long j2 = this.contentLength;
                if (j >= j2) {
                    break;
                }
                long read = source.read(bufferedSink2.buffer(), Math.min(j2 - j, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH));
                if (read == -1) {
                    break;
                }
                j += read;
                bufferedSink2.flush();
                OSSProgressCallback oSSProgressCallback = this.callback;
                if (oSSProgressCallback != null) {
                    oSSProgressCallback.onProgress(OSSRequestTask.this.context.getRequest(), j, this.contentLength);
                }
            }
            if (source != null) {
                source.close();
            }
        }
    }

    public class ProgressTouchableResponseBody extends ResponseBody {
        private BufferedSource bufferedSource;
        /* access modifiers changed from: private */
        public OSSProgressCallback callback;
        /* access modifiers changed from: private */
        public ResponseBody responseBody;

        public ProgressTouchableResponseBody(ResponseBody responseBody2, OSSProgressCallback oSSProgressCallback) {
            this.responseBody = responseBody2;
            this.callback = oSSProgressCallback;
        }

        public MediaType contentType() {
            return this.responseBody.contentType();
        }

        public long contentLength() throws IOException {
            return this.responseBody.contentLength();
        }

        public BufferedSource source() throws IOException {
            if (this.bufferedSource == null) {
                this.bufferedSource = Okio.buffer(source(this.responseBody.source()));
            }
            return this.bufferedSource;
        }

        private Source source(Source source) {
            return new ForwardingSource(source) {
                long totalBytesRead = 0;

                public long read(Buffer buffer, long j) throws IOException {
                    long read = super.read(buffer, j);
                    this.totalBytesRead += read != -1 ? read : 0;
                    if (ProgressTouchableResponseBody.this.callback != null) {
                        ProgressTouchableResponseBody.this.callback.onProgress(OSSRequestTask.this.context.getRequest(), this.totalBytesRead, ProgressTouchableResponseBody.this.responseBody.contentLength());
                    }
                    return read;
                }
            };
        }
    }

    public OSSRequestTask(RequestMessage requestMessage, ResponseParser responseParser2, ExecutionContext executionContext, int i) {
        this.responseParser = responseParser2;
        this.message = requestMessage;
        this.context = executionContext;
        this.clone = executionContext.getClient();
        this.retryHandler = new OSSRetryHandler(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x028c A[SYNTHETIC, Splitter:B:72:0x028c] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T call() throws java.lang.Exception {
        /*
            r14 = this;
            r0 = 1
            r1 = 0
            java.lang.String r2 = "[call] - "
            com.alibaba.sdk.android.oss.common.OSSLog.logD(r2)     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.network.ExecutionContext r2 = r14.context     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.model.OSSRequest r2 = r2.getRequest()     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.common.utils.OSSUtils.ensureRequestValid(r2, r3)     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.internal.RequestMessage r2 = r14.message     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.common.utils.OSSUtils.signRequest(r2)     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.network.ExecutionContext r2 = r14.context     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.network.CancellationHandler r2 = r2.getCancellationHandler()     // Catch:{ Exception -> 0x024b }
            boolean r2 = r2.isCancelled()     // Catch:{ Exception -> 0x024b }
            if (r2 != 0) goto L_0x0243
            com.squareup.okhttp.Request$Builder r2 = new com.squareup.okhttp.Request$Builder     // Catch:{ Exception -> 0x024b }
            r2.<init>()     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message     // Catch:{ Exception -> 0x024b }
            java.lang.String r3 = r3.buildCanonicalURL()     // Catch:{ Exception -> 0x024b }
            com.squareup.okhttp.Request$Builder r2 = r2.url((java.lang.String) r3)     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message     // Catch:{ Exception -> 0x024b }
            java.util.Map r3 = r3.getHeaders()     // Catch:{ Exception -> 0x024b }
            java.util.Set r3 = r3.keySet()     // Catch:{ Exception -> 0x024b }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x024b }
        L_0x0040:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x024b }
            if (r4 == 0) goto L_0x005d
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x024b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.internal.RequestMessage r5 = r14.message     // Catch:{ Exception -> 0x024b }
            java.util.Map r5 = r5.getHeaders()     // Catch:{ Exception -> 0x024b }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x024b }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x024b }
            com.squareup.okhttp.Request$Builder r2 = r2.addHeader(r4, r5)     // Catch:{ Exception -> 0x024b }
            goto L_0x0040
        L_0x005d:
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message     // Catch:{ Exception -> 0x024b }
            java.util.Map r3 = r3.getHeaders()     // Catch:{ Exception -> 0x024b }
            java.lang.String r4 = "Content-Type"
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x024b }
            r9 = r3
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x024b }
            int[] r3 = com.alibaba.sdk.android.oss.network.OSSRequestTask.AnonymousClass2.$SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.internal.RequestMessage r4 = r14.message     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.common.HttpMethod r4 = r4.getMethod()     // Catch:{ Exception -> 0x024b }
            int r4 = r4.ordinal()     // Catch:{ Exception -> 0x024b }
            r3 = r3[r4]     // Catch:{ Exception -> 0x024b }
            r11 = 0
            if (r3 == r0) goto L_0x009d
            r4 = 2
            if (r3 == r4) goto L_0x009d
            r4 = 3
            if (r3 == r4) goto L_0x0097
            r4 = 4
            if (r3 == r4) goto L_0x0091
            r4 = 5
            if (r3 == r4) goto L_0x008b
            goto L_0x0140
        L_0x008b:
            com.squareup.okhttp.Request$Builder r2 = r2.delete()     // Catch:{ Exception -> 0x024b }
            goto L_0x0140
        L_0x0091:
            com.squareup.okhttp.Request$Builder r2 = r2.head()     // Catch:{ Exception -> 0x024b }
            goto L_0x0140
        L_0x0097:
            com.squareup.okhttp.Request$Builder r2 = r2.get()     // Catch:{ Exception -> 0x024b }
            goto L_0x0140
        L_0x009d:
            if (r9 == 0) goto L_0x00a1
            r3 = 1
            goto L_0x00a2
        L_0x00a1:
            r3 = 0
        L_0x00a2:
            java.lang.String r4 = "Content type can't be null when upload!"
            com.alibaba.sdk.android.oss.common.utils.OSSUtils.assertTrue(r3, r4)     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message     // Catch:{ Exception -> 0x024b }
            byte[] r3 = r3.getUploadData()     // Catch:{ Exception -> 0x024b }
            if (r3 == 0) goto L_0x00cf
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.common.HttpMethod r3 = r3.getMethod()     // Catch:{ Exception -> 0x024b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.network.OSSRequestTask$ProgressTouchableRequestBody r4 = new com.alibaba.sdk.android.oss.network.OSSRequestTask$ProgressTouchableRequestBody     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.internal.RequestMessage r5 = r14.message     // Catch:{ Exception -> 0x024b }
            byte[] r5 = r5.getUploadData()     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.network.ExecutionContext r6 = r14.context     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.callback.OSSProgressCallback r6 = r6.getProgressCallback()     // Catch:{ Exception -> 0x024b }
            r4.<init>((byte[]) r5, (java.lang.String) r9, (com.alibaba.sdk.android.oss.callback.OSSProgressCallback) r6)     // Catch:{ Exception -> 0x024b }
            com.squareup.okhttp.Request$Builder r2 = r2.method(r3, r4)     // Catch:{ Exception -> 0x024b }
            goto L_0x0140
        L_0x00cf:
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message     // Catch:{ Exception -> 0x024b }
            java.lang.String r3 = r3.getUploadFilePath()     // Catch:{ Exception -> 0x024b }
            if (r3 == 0) goto L_0x00fc
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.common.HttpMethod r3 = r3.getMethod()     // Catch:{ Exception -> 0x024b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.network.OSSRequestTask$ProgressTouchableRequestBody r4 = new com.alibaba.sdk.android.oss.network.OSSRequestTask$ProgressTouchableRequestBody     // Catch:{ Exception -> 0x024b }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.internal.RequestMessage r6 = r14.message     // Catch:{ Exception -> 0x024b }
            java.lang.String r6 = r6.getUploadFilePath()     // Catch:{ Exception -> 0x024b }
            r5.<init>(r6)     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.network.ExecutionContext r6 = r14.context     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.callback.OSSProgressCallback r6 = r6.getProgressCallback()     // Catch:{ Exception -> 0x024b }
            r4.<init>((java.io.File) r5, (java.lang.String) r9, (com.alibaba.sdk.android.oss.callback.OSSProgressCallback) r6)     // Catch:{ Exception -> 0x024b }
            com.squareup.okhttp.Request$Builder r2 = r2.method(r3, r4)     // Catch:{ Exception -> 0x024b }
            goto L_0x0140
        L_0x00fc:
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message     // Catch:{ Exception -> 0x024b }
            java.io.InputStream r3 = r3.getUploadInputStream()     // Catch:{ Exception -> 0x024b }
            if (r3 == 0) goto L_0x012c
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.common.HttpMethod r3 = r3.getMethod()     // Catch:{ Exception -> 0x024b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.network.OSSRequestTask$ProgressTouchableRequestBody r12 = new com.alibaba.sdk.android.oss.network.OSSRequestTask$ProgressTouchableRequestBody     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.internal.RequestMessage r4 = r14.message     // Catch:{ Exception -> 0x024b }
            java.io.InputStream r6 = r4.getUploadInputStream()     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.internal.RequestMessage r4 = r14.message     // Catch:{ Exception -> 0x024b }
            long r7 = r4.getReadStreamLength()     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.network.ExecutionContext r4 = r14.context     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.callback.OSSProgressCallback r10 = r4.getProgressCallback()     // Catch:{ Exception -> 0x024b }
            r4 = r12
            r5 = r14
            r4.<init>(r6, r7, r9, r10)     // Catch:{ Exception -> 0x024b }
            com.squareup.okhttp.Request$Builder r2 = r2.method(r3, r12)     // Catch:{ Exception -> 0x024b }
            goto L_0x0140
        L_0x012c:
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.common.HttpMethod r3 = r3.getMethod()     // Catch:{ Exception -> 0x024b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x024b }
            byte[] r4 = new byte[r11]     // Catch:{ Exception -> 0x024b }
            com.squareup.okhttp.RequestBody r4 = com.squareup.okhttp.RequestBody.create((com.squareup.okhttp.MediaType) r1, (byte[]) r4)     // Catch:{ Exception -> 0x024b }
            com.squareup.okhttp.Request$Builder r2 = r2.method(r3, r4)     // Catch:{ Exception -> 0x024b }
        L_0x0140:
            com.squareup.okhttp.OkHttpClient r3 = r14.clone     // Catch:{ Exception -> 0x024b }
            java.util.List r3 = r3.networkInterceptors()     // Catch:{ Exception -> 0x024b }
            com.alibaba.sdk.android.oss.network.OSSRequestTask$1 r4 = new com.alibaba.sdk.android.oss.network.OSSRequestTask$1     // Catch:{ Exception -> 0x024b }
            r4.<init>()     // Catch:{ Exception -> 0x024b }
            r3.add(r4)     // Catch:{ Exception -> 0x024b }
            com.squareup.okhttp.Request r2 = r2.build()     // Catch:{ Exception -> 0x024b }
            boolean r3 = com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()     // Catch:{ Exception -> 0x023d }
            java.lang.String r4 = ": "
            if (r3 == 0) goto L_0x01b5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023d }
            r3.<init>()     // Catch:{ Exception -> 0x023d }
            java.lang.String r5 = "request url: "
            r3.append(r5)     // Catch:{ Exception -> 0x023d }
            java.net.URL r5 = r2.url()     // Catch:{ Exception -> 0x023d }
            r3.append(r5)     // Catch:{ Exception -> 0x023d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x023d }
            com.alibaba.sdk.android.oss.common.OSSLog.logD(r3)     // Catch:{ Exception -> 0x023d }
            com.squareup.okhttp.Headers r3 = r2.headers()     // Catch:{ Exception -> 0x023d }
            java.util.Map r3 = r3.toMultimap()     // Catch:{ Exception -> 0x023d }
            java.util.Set r5 = r3.keySet()     // Catch:{ Exception -> 0x023d }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x023d }
        L_0x0182:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x023d }
            if (r6 == 0) goto L_0x01b5
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x023d }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x023d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023d }
            r7.<init>()     // Catch:{ Exception -> 0x023d }
            java.lang.String r8 = "requestHeader "
            r7.append(r8)     // Catch:{ Exception -> 0x023d }
            r7.append(r6)     // Catch:{ Exception -> 0x023d }
            r7.append(r4)     // Catch:{ Exception -> 0x023d }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ Exception -> 0x023d }
            java.util.List r6 = (java.util.List) r6     // Catch:{ Exception -> 0x023d }
            java.lang.Object r6 = r6.get(r11)     // Catch:{ Exception -> 0x023d }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x023d }
            r7.append(r6)     // Catch:{ Exception -> 0x023d }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x023d }
            com.alibaba.sdk.android.oss.common.OSSLog.logD(r6)     // Catch:{ Exception -> 0x023d }
            goto L_0x0182
        L_0x01b5:
            com.squareup.okhttp.OkHttpClient r3 = r14.clone     // Catch:{ Exception -> 0x023d }
            com.squareup.okhttp.Call r3 = r3.newCall(r2)     // Catch:{ Exception -> 0x023d }
            com.alibaba.sdk.android.oss.network.ExecutionContext r5 = r14.context     // Catch:{ Exception -> 0x023d }
            com.alibaba.sdk.android.oss.network.CancellationHandler r5 = r5.getCancellationHandler()     // Catch:{ Exception -> 0x023d }
            r5.setCall(r3)     // Catch:{ Exception -> 0x023d }
            com.squareup.okhttp.Response r3 = r3.execute()     // Catch:{ Exception -> 0x023d }
            boolean r5 = com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()     // Catch:{ Exception -> 0x0237 }
            if (r5 == 0) goto L_0x0235
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0237 }
            r5.<init>()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r6 = "response code: "
            r5.append(r6)     // Catch:{ Exception -> 0x0237 }
            int r6 = r3.code()     // Catch:{ Exception -> 0x0237 }
            r5.append(r6)     // Catch:{ Exception -> 0x0237 }
            java.lang.String r6 = " for url: "
            r5.append(r6)     // Catch:{ Exception -> 0x0237 }
            java.net.URL r6 = r2.url()     // Catch:{ Exception -> 0x0237 }
            r5.append(r6)     // Catch:{ Exception -> 0x0237 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0237 }
            com.alibaba.sdk.android.oss.common.OSSLog.logD(r5)     // Catch:{ Exception -> 0x0237 }
            com.squareup.okhttp.Headers r5 = r3.headers()     // Catch:{ Exception -> 0x0237 }
            java.util.Map r5 = r5.toMultimap()     // Catch:{ Exception -> 0x0237 }
            java.util.Set r6 = r5.keySet()     // Catch:{ Exception -> 0x0237 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x0237 }
        L_0x0202:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x0237 }
            if (r7 == 0) goto L_0x0235
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0237 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0237 }
            r8.<init>()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r9 = "responseHeader "
            r8.append(r9)     // Catch:{ Exception -> 0x0237 }
            r8.append(r7)     // Catch:{ Exception -> 0x0237 }
            r8.append(r4)     // Catch:{ Exception -> 0x0237 }
            java.lang.Object r7 = r5.get(r7)     // Catch:{ Exception -> 0x0237 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x0237 }
            java.lang.Object r7 = r7.get(r11)     // Catch:{ Exception -> 0x0237 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0237 }
            r8.append(r7)     // Catch:{ Exception -> 0x0237 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x0237 }
            com.alibaba.sdk.android.oss.common.OSSLog.logD(r7)     // Catch:{ Exception -> 0x0237 }
            goto L_0x0202
        L_0x0235:
            r5 = r1
            goto L_0x027a
        L_0x0237:
            r4 = move-exception
            r13 = r3
            r3 = r2
            r2 = r4
            r4 = r13
            goto L_0x024e
        L_0x023d:
            r3 = move-exception
            r4 = r1
            r13 = r3
            r3 = r2
            r2 = r13
            goto L_0x024e
        L_0x0243:
            java.io.InterruptedIOException r2 = new java.io.InterruptedIOException     // Catch:{ Exception -> 0x024b }
            java.lang.String r3 = "This task is cancelled!"
            r2.<init>(r3)     // Catch:{ Exception -> 0x024b }
            throw r2     // Catch:{ Exception -> 0x024b }
        L_0x024b:
            r2 = move-exception
            r3 = r1
            r4 = r3
        L_0x024e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Encounter local execpiton: "
            r5.append(r6)
            java.lang.String r6 = r2.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logE(r5)
            boolean r5 = com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()
            if (r5 == 0) goto L_0x026f
            r2.printStackTrace()
        L_0x026f:
            com.alibaba.sdk.android.oss.ClientException r5 = new com.alibaba.sdk.android.oss.ClientException
            java.lang.String r6 = r2.getMessage()
            r5.<init>(r6, r2)
            r2 = r3
            r3 = r4
        L_0x027a:
            if (r5 != 0) goto L_0x02a6
            int r4 = r3.code()
            r6 = 203(0xcb, float:2.84E-43)
            if (r4 == r6) goto L_0x028c
            int r4 = r3.code()
            r6 = 300(0x12c, float:4.2E-43)
            if (r4 < r6) goto L_0x02a6
        L_0x028c:
            java.lang.String r2 = r2.method()     // Catch:{ IOException -> 0x029b }
            java.lang.String r4 = "HEAD"
            boolean r2 = r2.equals(r4)     // Catch:{ IOException -> 0x029b }
            com.alibaba.sdk.android.oss.ServiceException r5 = com.alibaba.sdk.android.oss.internal.ResponseParsers.parseResponseErrorXML(r3, r2)     // Catch:{ IOException -> 0x029b }
            goto L_0x02d2
        L_0x029b:
            r2 = move-exception
            com.alibaba.sdk.android.oss.ClientException r5 = new com.alibaba.sdk.android.oss.ClientException
            java.lang.String r4 = r2.getMessage()
            r5.<init>(r4, r2)
            goto L_0x02d2
        L_0x02a6:
            if (r5 != 0) goto L_0x02d2
            com.alibaba.sdk.android.oss.internal.ResponseParser<T> r2 = r14.responseParser     // Catch:{ IOException -> 0x02c8 }
            java.lang.Object r2 = r2.parse(r3)     // Catch:{ IOException -> 0x02c8 }
            com.alibaba.sdk.android.oss.model.OSSResult r2 = (com.alibaba.sdk.android.oss.model.OSSResult) r2     // Catch:{ IOException -> 0x02c8 }
            com.alibaba.sdk.android.oss.network.ExecutionContext r4 = r14.context     // Catch:{ IOException -> 0x02c8 }
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r4 = r4.getCompletedCallback()     // Catch:{ IOException -> 0x02c8 }
            if (r4 == 0) goto L_0x02c7
            com.alibaba.sdk.android.oss.network.ExecutionContext r4 = r14.context     // Catch:{ IOException -> 0x02c8 }
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r4 = r4.getCompletedCallback()     // Catch:{ IOException -> 0x02c8 }
            com.alibaba.sdk.android.oss.network.ExecutionContext r5 = r14.context     // Catch:{ IOException -> 0x02c8 }
            com.alibaba.sdk.android.oss.model.OSSRequest r5 = r5.getRequest()     // Catch:{ IOException -> 0x02c8 }
            r4.onSuccess(r5, r2)     // Catch:{ IOException -> 0x02c8 }
        L_0x02c7:
            return r2
        L_0x02c8:
            r2 = move-exception
            com.alibaba.sdk.android.oss.ClientException r5 = new com.alibaba.sdk.android.oss.ClientException
            java.lang.String r4 = r2.getMessage()
            r5.<init>(r4, r2)
        L_0x02d2:
            com.alibaba.sdk.android.oss.internal.OSSRetryHandler r2 = r14.retryHandler
            int r4 = r14.currentRetryCount
            com.alibaba.sdk.android.oss.internal.OSSRetryType r2 = r2.shouldRetry(r5, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "[run] - retry, retry type: "
            r4.append(r6)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logE(r4)
            com.alibaba.sdk.android.oss.internal.OSSRetryType r4 = com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldRetry
            if (r2 != r4) goto L_0x02fc
            int r1 = r14.currentRetryCount
            int r1 = r1 + r0
            r14.currentRetryCount = r1
            com.alibaba.sdk.android.oss.model.OSSResult r0 = r14.call()
            return r0
        L_0x02fc:
            com.alibaba.sdk.android.oss.internal.OSSRetryType r4 = com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry
            if (r2 != r4) goto L_0x0324
            java.lang.String r1 = "Date"
            java.lang.String r2 = r3.header(r1)
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r14.message
            java.util.Map r3 = r3.getHeaders()
            r3.put(r1, r2)
            java.util.Date r1 = com.alibaba.sdk.android.oss.common.utils.DateUtil.parseRfc822Date(r2)
            long r1 = r1.getTime()
            com.alibaba.sdk.android.oss.common.utils.DateUtil.setCurrentServerTime(r1)
            int r1 = r14.currentRetryCount
            int r1 = r1 + r0
            r14.currentRetryCount = r1
            com.alibaba.sdk.android.oss.model.OSSResult r0 = r14.call()
            return r0
        L_0x0324:
            boolean r0 = r5 instanceof com.alibaba.sdk.android.oss.ClientException
            if (r0 == 0) goto L_0x0343
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r14.context
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            if (r0 == 0) goto L_0x035d
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r14.context
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            com.alibaba.sdk.android.oss.network.ExecutionContext r2 = r14.context
            com.alibaba.sdk.android.oss.model.OSSRequest r2 = r2.getRequest()
            r3 = r5
            com.alibaba.sdk.android.oss.ClientException r3 = (com.alibaba.sdk.android.oss.ClientException) r3
            r0.onFailure(r2, r3, r1)
            goto L_0x035d
        L_0x0343:
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r14.context
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            if (r0 == 0) goto L_0x035d
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r14.context
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            com.alibaba.sdk.android.oss.network.ExecutionContext r2 = r14.context
            com.alibaba.sdk.android.oss.model.OSSRequest r2 = r2.getRequest()
            r3 = r5
            com.alibaba.sdk.android.oss.ServiceException r3 = (com.alibaba.sdk.android.oss.ServiceException) r3
            r0.onFailure(r2, r1, r3)
        L_0x035d:
            goto L_0x035f
        L_0x035e:
            throw r5
        L_0x035f:
            goto L_0x035e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.network.OSSRequestTask.call():com.alibaba.sdk.android.oss.model.OSSResult");
    }

    /* renamed from: com.alibaba.sdk.android.oss.network.OSSRequestTask$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod = new int[HttpMethod.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.alibaba.sdk.android.oss.common.HttpMethod[] r0 = com.alibaba.sdk.android.oss.common.HttpMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod = r0
                int[] r0 = $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.alibaba.sdk.android.oss.common.HttpMethod r1 = com.alibaba.sdk.android.oss.common.HttpMethod.POST     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod     // Catch:{ NoSuchFieldError -> 0x001f }
                com.alibaba.sdk.android.oss.common.HttpMethod r1 = com.alibaba.sdk.android.oss.common.HttpMethod.PUT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod     // Catch:{ NoSuchFieldError -> 0x002a }
                com.alibaba.sdk.android.oss.common.HttpMethod r1 = com.alibaba.sdk.android.oss.common.HttpMethod.GET     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.alibaba.sdk.android.oss.common.HttpMethod r1 = com.alibaba.sdk.android.oss.common.HttpMethod.HEAD     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.alibaba.sdk.android.oss.common.HttpMethod r1 = com.alibaba.sdk.android.oss.common.HttpMethod.DELETE     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.network.OSSRequestTask.AnonymousClass2.<clinit>():void");
        }
    }
}
