package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

public final class Transmitter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Call call;
    @Nullable
    private Object callStackTrace;
    private boolean canceled;
    private final OkHttpClient client;
    public RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    @Nullable
    private Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private boolean exchangeRequestDone;
    private boolean exchangeResponseDone;
    private boolean noMoreExchanges;
    private Request request;
    private final AsyncTimeout timeout = new AsyncTimeout() {
        /* access modifiers changed from: protected */
        public void timedOut() {
            Transmitter.this.cancel();
        }
    };
    private boolean timeoutEarlyExit;

    public Transmitter(OkHttpClient okHttpClient, Call call2) {
        this.client = okHttpClient;
        this.connectionPool = Internal.instance.realConnectionPool(okHttpClient.connectionPool());
        this.call = call2;
        this.eventListener = okHttpClient.eventListenerFactory().create(call2);
        this.timeout.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public void timeoutEnter() {
        this.timeout.enter();
    }

    public void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            this.timeout.exit();
            return;
        }
        throw new IllegalStateException();
    }

    @Nullable
    private IOException timeoutExit(@Nullable IOException iOException) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void callStart() {
        this.callStackTrace = Platform.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this.call);
    }

    public void prepareToConnect(Request request2) {
        Request request3 = this.request;
        if (request3 != null) {
            if (Util.sameConnection(request3.url(), request2.url()) && this.exchangeFinder.hasRouteToTry()) {
                return;
            }
            if (this.exchange != null) {
                throw new IllegalStateException();
            } else if (this.exchangeFinder != null) {
                maybeReleaseConnection((IOException) null, true);
                this.exchangeFinder = null;
            }
        }
        this.request = request2;
        this.exchangeFinder = new ExchangeFinder(this, this.connectionPool, createAddress(request2.url()), this.call, this.eventListener);
    }

    private Address createAddress(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    /* access modifiers changed from: package-private */
    public Exchange newExchange(Interceptor.Chain chain, boolean z) {
        synchronized (this.connectionPool) {
            if (this.noMoreExchanges) {
                throw new IllegalStateException("released");
            } else if (this.exchange != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        Exchange exchange2 = new Exchange(this, this.call, this.eventListener, this.exchangeFinder, this.exchangeFinder.find(this.client, chain, z));
        synchronized (this.connectionPool) {
            this.exchange = exchange2;
            this.exchangeRequestDone = false;
            this.exchangeResponseDone = false;
        }
        return exchange2;
    }

    /* access modifiers changed from: package-private */
    public void acquireConnectionNoEvents(RealConnection realConnection) {
        if (this.connection == null) {
            this.connection = realConnection;
            realConnection.transmitters.add(new TransmitterReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Socket releaseConnectionNoEvents() {
        int i = 0;
        int size = this.connection.transmitters.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (this.connection.transmitters.get(i).get() == this) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            RealConnection realConnection = this.connection;
            realConnection.transmitters.remove(i);
            this.connection = null;
            if (!realConnection.transmitters.isEmpty()) {
                return null;
            }
            realConnection.idleAtNanos = System.nanoTime();
            if (this.connectionPool.connectionBecameIdle(realConnection)) {
                return realConnection.socket();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    public void exchangeDoneDueToException() {
        synchronized (this.connectionPool) {
            if (!this.noMoreExchanges) {
                this.exchange = null;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        if (r1 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return maybeReleaseConnection(r6, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return r6;
     */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.IOException exchangeMessageDone(okhttp3.internal.connection.Exchange r3, boolean r4, boolean r5, @javax.annotation.Nullable java.io.IOException r6) {
        /*
            r2 = this;
            okhttp3.internal.connection.RealConnectionPool r0 = r2.connectionPool
            monitor-enter(r0)
            okhttp3.internal.connection.Exchange r1 = r2.exchange     // Catch:{ all -> 0x003f }
            if (r3 == r1) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return r6
        L_0x0009:
            r3 = 0
            r1 = 1
            if (r4 == 0) goto L_0x0013
            boolean r4 = r2.exchangeRequestDone     // Catch:{ all -> 0x003f }
            r4 = r4 ^ r1
            r2.exchangeRequestDone = r1     // Catch:{ all -> 0x003f }
            goto L_0x0014
        L_0x0013:
            r4 = r3
        L_0x0014:
            if (r5 == 0) goto L_0x001d
            boolean r5 = r2.exchangeResponseDone     // Catch:{ all -> 0x003f }
            if (r5 != 0) goto L_0x001b
            r4 = r1
        L_0x001b:
            r2.exchangeResponseDone = r1     // Catch:{ all -> 0x003f }
        L_0x001d:
            boolean r5 = r2.exchangeRequestDone     // Catch:{ all -> 0x003f }
            if (r5 == 0) goto L_0x0036
            boolean r5 = r2.exchangeResponseDone     // Catch:{ all -> 0x003f }
            if (r5 == 0) goto L_0x0036
            if (r4 == 0) goto L_0x0036
            okhttp3.internal.connection.Exchange r4 = r2.exchange     // Catch:{ all -> 0x003f }
            okhttp3.internal.connection.RealConnection r4 = r4.connection()     // Catch:{ all -> 0x003f }
            int r5 = r4.successCount     // Catch:{ all -> 0x003f }
            int r5 = r5 + r1
            r4.successCount = r5     // Catch:{ all -> 0x003f }
            r4 = 0
            r2.exchange = r4     // Catch:{ all -> 0x003f }
            goto L_0x0037
        L_0x0036:
            r1 = r3
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003e
            java.io.IOException r6 = r2.maybeReleaseConnection(r6, r3)
        L_0x003e:
            return r6
        L_0x003f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.Transmitter.exchangeMessageDone(okhttp3.internal.connection.Exchange, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    @Nullable
    public IOException noMoreExchanges(@Nullable IOException iOException) {
        synchronized (this.connectionPool) {
            this.noMoreExchanges = true;
        }
        return maybeReleaseConnection(iOException, false);
    }

    @Nullable
    private IOException maybeReleaseConnection(@Nullable IOException iOException, boolean z) {
        RealConnection realConnection;
        Socket releaseConnectionNoEvents;
        boolean z2;
        boolean z3;
        synchronized (this.connectionPool) {
            if (z) {
                if (this.exchange != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            realConnection = this.connection;
            releaseConnectionNoEvents = (this.connection == null || this.exchange != null || (!z && !this.noMoreExchanges)) ? null : releaseConnectionNoEvents();
            if (this.connection != null) {
                realConnection = null;
            }
            z2 = true;
            z3 = this.noMoreExchanges && this.exchange == null;
        }
        Util.closeQuietly(releaseConnectionNoEvents);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z3) {
            if (iOException == null) {
                z2 = false;
            }
            iOException = timeoutExit(iOException);
            if (z2) {
                this.eventListener.callFailed(this.call, iOException);
            } else {
                this.eventListener.callEnd(this.call);
            }
        }
        return iOException;
    }

    public boolean canRetry() {
        return this.exchangeFinder.hasStreamFailure() && this.exchangeFinder.hasRouteToTry();
    }

    public boolean hasExchange() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.exchange != null;
        }
        return z;
    }

    public void cancel() {
        Exchange exchange2;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            exchange2 = this.exchange;
            if (this.exchangeFinder == null || this.exchangeFinder.connectingConnection() == null) {
                realConnection = this.connection;
            } else {
                realConnection = this.exchangeFinder.connectingConnection();
            }
        }
        if (exchange2 != null) {
            exchange2.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.canceled;
        }
        return z;
    }

    static final class TransmitterReference extends WeakReference<Transmitter> {
        final Object callStackTrace;

        TransmitterReference(Transmitter transmitter, Object obj) {
            super(transmitter);
            this.callStackTrace = obj;
        }
    }
}
