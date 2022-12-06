package com.mbridge.msdk.thrid.okhttp;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.cache.CacheInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.connection.ConnectInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okhttp.internal.http.BridgeInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.http.CallServerInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpCodec;
import com.mbridge.msdk.thrid.okhttp.internal.http.RealInterceptorChain;
import com.mbridge.msdk.thrid.okhttp.internal.http.RetryAndFollowUpInterceptor;
import com.mbridge.msdk.thrid.okhttp.internal.platform.Platform;
import com.mbridge.msdk.thrid.okio.AsyncTimeout;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

final class RealCall implements Call {
    final OkHttpClient client;
    /* access modifiers changed from: private */
    @Nullable
    public EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final AsyncTimeout timeout = new AsyncTimeout() {
        /* access modifiers changed from: protected */
        public void timedOut() {
            RealCall.this.cancel();
        }
    };

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z);
        this.timeout.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    public Request request() {
        return this.originalRequest;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            this.client.dispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain != null) {
                this.client.dispatcher().finished(this);
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } catch (IOException e) {
            IOException timeoutExit = timeoutExit(e);
            this.eventListener.callFailed(this, timeoutExit);
            throw timeoutExit;
        } catch (Throwable th) {
            this.client.dispatcher().finished(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public IOException timeoutExit(@Nullable IOException iOException) {
        if (!this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    public void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    /* access modifiers changed from: package-private */
    public StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        static {
            Class<RealCall> cls = RealCall.class;
        }

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        /* access modifiers changed from: package-private */
        public String host() {
            return RealCall.this.originalRequest.url().host();
        }

        /* access modifiers changed from: package-private */
        public Request request() {
            return RealCall.this.originalRequest;
        }

        /* access modifiers changed from: package-private */
        public RealCall get() {
            return RealCall.this;
        }

        /* access modifiers changed from: package-private */
        public void executeOn(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                RealCall.this.eventListener.callFailed(RealCall.this, interruptedIOException);
                this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                RealCall.this.client.dispatcher().finished(this);
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A[Catch:{ IOException -> 0x0050, all -> 0x0027, all -> 0x0090 }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005c A[Catch:{ IOException -> 0x0050, all -> 0x0027, all -> 0x0090 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x007c A[Catch:{ IOException -> 0x0050, all -> 0x0027, all -> 0x0090 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r6 = this;
                com.mbridge.msdk.thrid.okhttp.RealCall r0 = com.mbridge.msdk.thrid.okhttp.RealCall.this
                com.mbridge.msdk.thrid.okio.AsyncTimeout r0 = r0.timeout
                r0.enter()
                r0 = 0
                com.mbridge.msdk.thrid.okhttp.RealCall r1 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ IOException -> 0x0050, all -> 0x0027 }
                com.mbridge.msdk.thrid.okhttp.Response r0 = r1.getResponseWithInterceptorChain()     // Catch:{ IOException -> 0x0050, all -> 0x0027 }
                r1 = 1
                com.mbridge.msdk.thrid.okhttp.Callback r2 = r6.responseCallback     // Catch:{ IOException -> 0x0025, all -> 0x0023 }
                com.mbridge.msdk.thrid.okhttp.RealCall r3 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ IOException -> 0x0025, all -> 0x0023 }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0025, all -> 0x0023 }
            L_0x0016:
                com.mbridge.msdk.thrid.okhttp.RealCall r0 = com.mbridge.msdk.thrid.okhttp.RealCall.this
                com.mbridge.msdk.thrid.okhttp.OkHttpClient r0 = r0.client
                com.mbridge.msdk.thrid.okhttp.Dispatcher r0 = r0.dispatcher()
                r0.finished((com.mbridge.msdk.thrid.okhttp.RealCall.AsyncCall) r6)
                goto L_0x008f
            L_0x0023:
                r0 = move-exception
                goto L_0x002b
            L_0x0025:
                r0 = move-exception
                goto L_0x0054
            L_0x0027:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L_0x002b:
                com.mbridge.msdk.thrid.okhttp.RealCall r2 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0090 }
                r2.cancel()     // Catch:{ all -> 0x0090 }
                if (r1 != 0) goto L_0x004f
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0090 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
                r2.<init>()     // Catch:{ all -> 0x0090 }
                java.lang.String r3 = "canceled due to "
                r2.append(r3)     // Catch:{ all -> 0x0090 }
                r2.append(r0)     // Catch:{ all -> 0x0090 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0090 }
                r1.<init>(r2)     // Catch:{ all -> 0x0090 }
                com.mbridge.msdk.thrid.okhttp.Callback r2 = r6.responseCallback     // Catch:{ all -> 0x0090 }
                com.mbridge.msdk.thrid.okhttp.RealCall r3 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0090 }
                r2.onFailure(r3, r1)     // Catch:{ all -> 0x0090 }
            L_0x004f:
                throw r0     // Catch:{ all -> 0x0090 }
            L_0x0050:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L_0x0054:
                com.mbridge.msdk.thrid.okhttp.RealCall r2 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0090 }
                java.io.IOException r0 = r2.timeoutExit(r0)     // Catch:{ all -> 0x0090 }
                if (r1 == 0) goto L_0x007c
                com.mbridge.msdk.thrid.okhttp.internal.platform.Platform r1 = com.mbridge.msdk.thrid.okhttp.internal.platform.Platform.get()     // Catch:{ all -> 0x0090 }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
                r3.<init>()     // Catch:{ all -> 0x0090 }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x0090 }
                com.mbridge.msdk.thrid.okhttp.RealCall r4 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0090 }
                java.lang.String r4 = r4.toLoggableString()     // Catch:{ all -> 0x0090 }
                r3.append(r4)     // Catch:{ all -> 0x0090 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0090 }
                r1.log(r2, r3, r0)     // Catch:{ all -> 0x0090 }
                goto L_0x0016
            L_0x007c:
                com.mbridge.msdk.thrid.okhttp.RealCall r1 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0090 }
                com.mbridge.msdk.thrid.okhttp.EventListener r1 = r1.eventListener     // Catch:{ all -> 0x0090 }
                com.mbridge.msdk.thrid.okhttp.RealCall r2 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0090 }
                r1.callFailed(r2, r0)     // Catch:{ all -> 0x0090 }
                com.mbridge.msdk.thrid.okhttp.Callback r1 = r6.responseCallback     // Catch:{ all -> 0x0090 }
                com.mbridge.msdk.thrid.okhttp.RealCall r2 = com.mbridge.msdk.thrid.okhttp.RealCall.this     // Catch:{ all -> 0x0090 }
                r1.onFailure(r2, r0)     // Catch:{ all -> 0x0090 }
                goto L_0x0016
            L_0x008f:
                return
            L_0x0090:
                r0 = move-exception
                com.mbridge.msdk.thrid.okhttp.RealCall r1 = com.mbridge.msdk.thrid.okhttp.RealCall.this
                com.mbridge.msdk.thrid.okhttp.OkHttpClient r1 = r1.client
                com.mbridge.msdk.thrid.okhttp.Dispatcher r1 = r1.dispatcher()
                r1.finished((com.mbridge.msdk.thrid.okhttp.RealCall.AsyncCall) r6)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.RealCall.AsyncCall.execute():void");
        }
    }

    /* access modifiers changed from: package-private */
    public String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    /* access modifiers changed from: package-private */
    public Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        Response proceed = new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
        if (!this.retryAndFollowUpInterceptor.isCanceled()) {
            return proceed;
        }
        Util.closeQuietly((Closeable) proceed);
        throw new IOException("Canceled");
    }
}
