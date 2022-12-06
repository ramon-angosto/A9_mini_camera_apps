package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.connection.Transmitter;
import okio.Timeout;

final class RealCall implements Call {
    final OkHttpClient client;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    /* access modifiers changed from: private */
    public Transmitter transmitter;

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.transmitter = new Transmitter(okHttpClient, realCall);
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
        this.transmitter.timeoutEnter();
        this.transmitter.callStart();
        try {
            this.client.dispatcher().executed(this);
            return getResponseWithInterceptorChain();
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.transmitter.callStart();
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    public void cancel() {
        this.transmitter.cancel();
    }

    public Timeout timeout() {
        return this.transmitter.timeout();
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public boolean isCanceled() {
        return this.transmitter.isCanceled();
    }

    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        private final Callback responseCallback;

        static {
            Class<RealCall> cls = RealCall.class;
        }

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        /* access modifiers changed from: package-private */
        public AtomicInteger callsPerHost() {
            return this.callsPerHost;
        }

        /* access modifiers changed from: package-private */
        public void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            this.callsPerHost = asyncCall.callsPerHost;
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
                RealCall.this.transmitter.noMoreExchanges(interruptedIOException);
                this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                RealCall.this.client.dispatcher().finished(this);
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0033 A[Catch:{ IOException -> 0x0056, all -> 0x0028, all -> 0x0054 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[Catch:{ IOException -> 0x0056, all -> 0x0028, all -> 0x0054 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x007c A[Catch:{ IOException -> 0x0056, all -> 0x0028, all -> 0x0054 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r6 = this;
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okhttp3.internal.connection.Transmitter r0 = r0.transmitter
                r0.timeoutEnter()
                r0 = 0
                okhttp3.RealCall r1 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x0056, all -> 0x0028 }
                okhttp3.Response r0 = r1.getResponseWithInterceptorChain()     // Catch:{ IOException -> 0x0056, all -> 0x0028 }
                r1 = 1
                okhttp3.Callback r2 = r6.responseCallback     // Catch:{ IOException -> 0x0026, all -> 0x0024 }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x0026, all -> 0x0024 }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0026, all -> 0x0024 }
            L_0x0018:
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r0 = r0.client
                okhttp3.Dispatcher r0 = r0.dispatcher()
                r0.finished((okhttp3.RealCall.AsyncCall) r6)
                goto L_0x0084
            L_0x0024:
                r0 = move-exception
                goto L_0x002c
            L_0x0026:
                r0 = move-exception
                goto L_0x005a
            L_0x0028:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L_0x002c:
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x0054 }
                r2.cancel()     // Catch:{ all -> 0x0054 }
                if (r1 != 0) goto L_0x0053
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0054 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
                r2.<init>()     // Catch:{ all -> 0x0054 }
                java.lang.String r3 = "canceled due to "
                r2.append(r3)     // Catch:{ all -> 0x0054 }
                r2.append(r0)     // Catch:{ all -> 0x0054 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0054 }
                r1.<init>(r2)     // Catch:{ all -> 0x0054 }
                r1.addSuppressed(r0)     // Catch:{ all -> 0x0054 }
                okhttp3.Callback r2 = r6.responseCallback     // Catch:{ all -> 0x0054 }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ all -> 0x0054 }
                r2.onFailure(r3, r1)     // Catch:{ all -> 0x0054 }
            L_0x0053:
                throw r0     // Catch:{ all -> 0x0054 }
            L_0x0054:
                r0 = move-exception
                goto L_0x0085
            L_0x0056:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L_0x005a:
                if (r1 == 0) goto L_0x007c
                okhttp3.internal.platform.Platform r1 = okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x0054 }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
                r3.<init>()     // Catch:{ all -> 0x0054 }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x0054 }
                okhttp3.RealCall r4 = okhttp3.RealCall.this     // Catch:{ all -> 0x0054 }
                java.lang.String r4 = r4.toLoggableString()     // Catch:{ all -> 0x0054 }
                r3.append(r4)     // Catch:{ all -> 0x0054 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0054 }
                r1.log(r2, r3, r0)     // Catch:{ all -> 0x0054 }
                goto L_0x0018
            L_0x007c:
                okhttp3.Callback r1 = r6.responseCallback     // Catch:{ all -> 0x0054 }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x0054 }
                r1.onFailure(r2, r0)     // Catch:{ all -> 0x0054 }
                goto L_0x0018
            L_0x0084:
                return
            L_0x0085:
                okhttp3.RealCall r1 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r1 = r1.client
                okhttp3.Dispatcher r1 = r1.dispatcher()
                r1.finished((okhttp3.RealCall.AsyncCall) r6)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall.AsyncCall.execute():void");
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
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response getResponseWithInterceptorChain() throws java.io.IOException {
        /*
            r12 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            okhttp3.OkHttpClient r0 = r12.client
            java.util.List r0 = r0.interceptors()
            r1.addAll(r0)
            okhttp3.internal.http.RetryAndFollowUpInterceptor r0 = new okhttp3.internal.http.RetryAndFollowUpInterceptor
            okhttp3.OkHttpClient r2 = r12.client
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.http.BridgeInterceptor r0 = new okhttp3.internal.http.BridgeInterceptor
            okhttp3.OkHttpClient r2 = r12.client
            okhttp3.CookieJar r2 = r2.cookieJar()
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.cache.CacheInterceptor r0 = new okhttp3.internal.cache.CacheInterceptor
            okhttp3.OkHttpClient r2 = r12.client
            okhttp3.internal.cache.InternalCache r2 = r2.internalCache()
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.connection.ConnectInterceptor r0 = new okhttp3.internal.connection.ConnectInterceptor
            okhttp3.OkHttpClient r2 = r12.client
            r0.<init>(r2)
            r1.add(r0)
            boolean r0 = r12.forWebSocket
            if (r0 != 0) goto L_0x004b
            okhttp3.OkHttpClient r0 = r12.client
            java.util.List r0 = r0.networkInterceptors()
            r1.addAll(r0)
        L_0x004b:
            okhttp3.internal.http.CallServerInterceptor r0 = new okhttp3.internal.http.CallServerInterceptor
            boolean r2 = r12.forWebSocket
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.http.RealInterceptorChain r10 = new okhttp3.internal.http.RealInterceptorChain
            okhttp3.internal.connection.Transmitter r2 = r12.transmitter
            r3 = 0
            r4 = 0
            okhttp3.Request r5 = r12.originalRequest
            okhttp3.OkHttpClient r0 = r12.client
            int r7 = r0.connectTimeoutMillis()
            okhttp3.OkHttpClient r0 = r12.client
            int r8 = r0.readTimeoutMillis()
            okhttp3.OkHttpClient r0 = r12.client
            int r9 = r0.writeTimeoutMillis()
            r0 = r10
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 0
            r1 = 0
            okhttp3.Request r2 = r12.originalRequest     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            okhttp3.Response r2 = r10.proceed(r2)     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            okhttp3.internal.connection.Transmitter r3 = r12.transmitter     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            boolean r3 = r3.isCanceled()     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            if (r3 != 0) goto L_0x008a
            okhttp3.internal.connection.Transmitter r0 = r12.transmitter
            r0.noMoreExchanges(r1)
            return r2
        L_0x008a:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            throw r2     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
        L_0x0095:
            r2 = move-exception
            goto L_0x00a4
        L_0x0097:
            r0 = move-exception
            r2 = 1
            okhttp3.internal.connection.Transmitter r3 = r12.transmitter     // Catch:{ all -> 0x00a0 }
            java.io.IOException r0 = r3.noMoreExchanges(r0)     // Catch:{ all -> 0x00a0 }
            throw r0     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r0 = move-exception
            r11 = r2
            r2 = r0
            r0 = r11
        L_0x00a4:
            if (r0 != 0) goto L_0x00ab
            okhttp3.internal.connection.Transmitter r0 = r12.transmitter
            r0.noMoreExchanges(r1)
        L_0x00ab:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall.getResponseWithInterceptorChain():okhttp3.Response");
    }
}
