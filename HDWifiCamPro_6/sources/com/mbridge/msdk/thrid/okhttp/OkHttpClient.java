package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.WebSocket;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.cache.InternalCache;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RouteDatabase;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okhttp.internal.platform.Platform;
import com.mbridge.msdk.thrid.okhttp.internal.proxy.NullProxySelector;
import com.mbridge.msdk.thrid.okhttp.internal.tls.CertificateChainCleaner;
import com.mbridge.msdk.thrid.okhttp.internal.tls.OkHostnameVerifier;
import com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableList((T[]) new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});
    static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
    final Authenticator authenticator;
    @Nullable
    final Cache cache;
    final int callTimeout;
    final CertificateChainCleaner certificateChainCleaner;
    final CertificatePinner certificatePinner;
    final int connectTimeout;
    final ConnectionPool connectionPool;
    final List<ConnectionSpec> connectionSpecs;
    final CookieJar cookieJar;
    final Dispatcher dispatcher;
    final Dns dns;
    final EventListener.Factory eventListenerFactory;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors;
    @Nullable
    final InternalCache internalCache;
    final List<Interceptor> networkInterceptors;
    final int pingInterval;
    final List<Protocol> protocols;
    @Nullable
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final int writeTimeout;

    static {
        Internal.instance = new Internal() {
            public void addLenient(Headers.Builder builder, String str) {
                builder.addLenient(str);
            }

            public void addLenient(Headers.Builder builder, String str, String str2) {
                builder.addLenient(str, str2);
            }

            public void setCache(Builder builder, InternalCache internalCache) {
                builder.setInternalCache(internalCache);
            }

            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.connectionBecameIdle(realConnection);
            }

            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                return connectionPool.get(address, streamAllocation, route);
            }

            public boolean equalsNonHost(Address address, Address address2) {
                return address.equalsNonHost(address2);
            }

            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.deduplicate(address, streamAllocation);
            }

            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.put(realConnection);
            }

            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.routeDatabase;
            }

            public int code(Response.Builder builder) {
                return builder.code;
            }

            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.apply(sSLSocket, z);
            }

            public boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                return illegalArgumentException.getMessage().startsWith("Invalid URL host");
            }

            public StreamAllocation streamAllocation(Call call) {
                return ((RealCall) call).streamAllocation();
            }

            @Nullable
            public IOException timeoutExit(Call call, @Nullable IOException iOException) {
                return ((RealCall) call).timeoutExit(iOException);
            }

            public Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
                return RealCall.newRealCall(okHttpClient, request, true);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    OkHttpClient(Builder builder) {
        boolean z;
        this.dispatcher = builder.dispatcher;
        this.proxy = builder.proxy;
        this.protocols = builder.protocols;
        this.connectionSpecs = builder.connectionSpecs;
        this.interceptors = Util.immutableList(builder.interceptors);
        this.networkInterceptors = Util.immutableList(builder.networkInterceptors);
        this.eventListenerFactory = builder.eventListenerFactory;
        this.proxySelector = builder.proxySelector;
        this.cookieJar = builder.cookieJar;
        this.cache = builder.cache;
        this.internalCache = builder.internalCache;
        this.socketFactory = builder.socketFactory;
        Iterator<ConnectionSpec> it = this.connectionSpecs.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                ConnectionSpec next = it.next();
                if (z || next.isTls()) {
                    z = true;
                }
            }
        }
        if (builder.sslSocketFactory != null || !z) {
            this.sslSocketFactory = builder.sslSocketFactory;
            this.certificateChainCleaner = builder.certificateChainCleaner;
        } else {
            X509TrustManager platformTrustManager = Util.platformTrustManager();
            this.sslSocketFactory = newSslSocketFactory(platformTrustManager);
            this.certificateChainCleaner = CertificateChainCleaner.get(platformTrustManager);
        }
        if (this.sslSocketFactory != null) {
            Platform.get().configureSslSocketFactory(this.sslSocketFactory);
        }
        this.hostnameVerifier = builder.hostnameVerifier;
        this.certificatePinner = builder.certificatePinner.withCertificateChainCleaner(this.certificateChainCleaner);
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.authenticator = builder.authenticator;
        this.connectionPool = builder.connectionPool;
        this.dns = builder.dns;
        this.followSslRedirects = builder.followSslRedirects;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.callTimeout = builder.callTimeout;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.pingInterval = builder.pingInterval;
        if (this.interceptors.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.interceptors);
        } else if (this.networkInterceptors.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
        }
    }

    private static SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw Util.assertionError("No System TLS", e);
        }
    }

    public int callTimeoutMillis() {
        return this.callTimeout;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public int pingIntervalMillis() {
        return this.pingInterval;
    }

    @Nullable
    public Proxy proxy() {
        return this.proxy;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public CookieJar cookieJar() {
        return this.cookieJar;
    }

    @Nullable
    public Cache cache() {
        return this.cache;
    }

    /* access modifiers changed from: package-private */
    public InternalCache internalCache() {
        Cache cache2 = this.cache;
        return cache2 != null ? cache2.internalCache : this.internalCache;
    }

    public Dns dns() {
        return this.dns;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public Authenticator authenticator() {
        return this.authenticator;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public Call newCall(Request request) {
        return RealCall.newRealCall(this, request, false);
    }

    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), (long) this.pingInterval);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {
        Authenticator authenticator;
        @Nullable
        Cache cache;
        int callTimeout;
        @Nullable
        CertificateChainCleaner certificateChainCleaner;
        CertificatePinner certificatePinner;
        int connectTimeout;
        ConnectionPool connectionPool;
        List<ConnectionSpec> connectionSpecs;
        CookieJar cookieJar;
        Dispatcher dispatcher;
        Dns dns;
        EventListener.Factory eventListenerFactory;
        boolean followRedirects;
        boolean followSslRedirects;
        HostnameVerifier hostnameVerifier;
        final List<Interceptor> interceptors;
        @Nullable
        InternalCache internalCache;
        final List<Interceptor> networkInterceptors;
        int pingInterval;
        List<Protocol> protocols;
        @Nullable
        Proxy proxy;
        Authenticator proxyAuthenticator;
        ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SocketFactory socketFactory;
        @Nullable
        SSLSocketFactory sslSocketFactory;
        int writeTimeout;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.eventListenerFactory = EventListener.factory(EventListener.NONE);
            this.proxySelector = ProxySelector.getDefault();
            if (this.proxySelector == null) {
                this.proxySelector = new NullProxySelector();
            }
            this.cookieJar = CookieJar.NO_COOKIES;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.proxyAuthenticator = Authenticator.NONE;
            this.authenticator = Authenticator.NONE;
            this.connectionPool = new ConnectionPool();
            this.dns = Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.callTimeout = 0;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
        }

        Builder(OkHttpClient okHttpClient) {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = okHttpClient.dispatcher;
            this.proxy = okHttpClient.proxy;
            this.protocols = okHttpClient.protocols;
            this.connectionSpecs = okHttpClient.connectionSpecs;
            this.interceptors.addAll(okHttpClient.interceptors);
            this.networkInterceptors.addAll(okHttpClient.networkInterceptors);
            this.eventListenerFactory = okHttpClient.eventListenerFactory;
            this.proxySelector = okHttpClient.proxySelector;
            this.cookieJar = okHttpClient.cookieJar;
            this.internalCache = okHttpClient.internalCache;
            this.cache = okHttpClient.cache;
            this.socketFactory = okHttpClient.socketFactory;
            this.sslSocketFactory = okHttpClient.sslSocketFactory;
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner;
            this.hostnameVerifier = okHttpClient.hostnameVerifier;
            this.certificatePinner = okHttpClient.certificatePinner;
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator;
            this.authenticator = okHttpClient.authenticator;
            this.connectionPool = okHttpClient.connectionPool;
            this.dns = okHttpClient.dns;
            this.followSslRedirects = okHttpClient.followSslRedirects;
            this.followRedirects = okHttpClient.followRedirects;
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
            this.callTimeout = okHttpClient.callTimeout;
            this.connectTimeout = okHttpClient.connectTimeout;
            this.readTimeout = okHttpClient.readTimeout;
            this.writeTimeout = okHttpClient.writeTimeout;
            this.pingInterval = okHttpClient.pingInterval;
        }

        public Builder callTimeout(long j, TimeUnit timeUnit) {
            this.callTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder callTimeout(Duration duration) {
            this.callTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.connectTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder connectTimeout(Duration duration) {
            this.connectTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder readTimeout(Duration duration) {
            this.readTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.writeTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder writeTimeout(Duration duration) {
            this.writeTimeout = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder pingInterval(long j, TimeUnit timeUnit) {
            this.pingInterval = Util.checkDuration("interval", j, timeUnit);
            return this;
        }

        public Builder pingInterval(Duration duration) {
            this.pingInterval = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder proxy(@Nullable Proxy proxy2) {
            this.proxy = proxy2;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector2) {
            if (proxySelector2 != null) {
                this.proxySelector = proxySelector2;
                return this;
            }
            throw new NullPointerException("proxySelector == null");
        }

        public Builder cookieJar(CookieJar cookieJar2) {
            if (cookieJar2 != null) {
                this.cookieJar = cookieJar2;
                return this;
            }
            throw new NullPointerException("cookieJar == null");
        }

        /* access modifiers changed from: package-private */
        public void setInternalCache(@Nullable InternalCache internalCache2) {
            this.internalCache = internalCache2;
            this.cache = null;
        }

        public Builder cache(@Nullable Cache cache2) {
            this.cache = cache2;
            this.internalCache = null;
            return this;
        }

        public Builder dns(Dns dns2) {
            if (dns2 != null) {
                this.dns = dns2;
                return this;
            }
            throw new NullPointerException("dns == null");
        }

        public Builder socketFactory(SocketFactory socketFactory2) {
            if (socketFactory2 != null) {
                this.socketFactory = socketFactory2;
                return this;
            }
            throw new NullPointerException("socketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                this.sslSocketFactory = sSLSocketFactory;
                this.certificateChainCleaner = Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
                return this;
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            } else if (x509TrustManager != null) {
                this.sslSocketFactory = sSLSocketFactory;
                this.certificateChainCleaner = CertificateChainCleaner.get(x509TrustManager);
                return this;
            } else {
                throw new NullPointerException("trustManager == null");
            }
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier2) {
            if (hostnameVerifier2 != null) {
                this.hostnameVerifier = hostnameVerifier2;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public Builder certificatePinner(CertificatePinner certificatePinner2) {
            if (certificatePinner2 != null) {
                this.certificatePinner = certificatePinner2;
                return this;
            }
            throw new NullPointerException("certificatePinner == null");
        }

        public Builder authenticator(Authenticator authenticator2) {
            if (authenticator2 != null) {
                this.authenticator = authenticator2;
                return this;
            }
            throw new NullPointerException("authenticator == null");
        }

        public Builder proxyAuthenticator(Authenticator authenticator2) {
            if (authenticator2 != null) {
                this.proxyAuthenticator = authenticator2;
                return this;
            }
            throw new NullPointerException("proxyAuthenticator == null");
        }

        public Builder connectionPool(ConnectionPool connectionPool2) {
            if (connectionPool2 != null) {
                this.connectionPool = connectionPool2;
                return this;
            }
            throw new NullPointerException("connectionPool == null");
        }

        public Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher2) {
            if (dispatcher2 != null) {
                this.dispatcher = dispatcher2;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public Builder protocols(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            } else if (arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            } else if (!arrayList.contains((Object) null)) {
                arrayList.remove(Protocol.SPDY_3);
                this.protocols = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.connectionSpecs = Util.immutableList(list);
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.interceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.networkInterceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder eventListener(EventListener eventListener) {
            if (eventListener != null) {
                this.eventListenerFactory = EventListener.factory(eventListener);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            if (factory != null) {
                this.eventListenerFactory = factory;
                return this;
            }
            throw new NullPointerException("eventListenerFactory == null");
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }
    }
}
