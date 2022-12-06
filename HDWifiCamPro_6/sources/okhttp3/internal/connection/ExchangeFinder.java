package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;

final class ExchangeFinder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Address address;
    private final Call call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private boolean hasStreamFailure;
    private Route nextRouteToTry;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;
    private final Transmitter transmitter;

    ExchangeFinder(Transmitter transmitter2, RealConnectionPool realConnectionPool, Address address2, Call call2, EventListener eventListener2) {
        this.transmitter = transmitter2;
        this.connectionPool = realConnectionPool;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.routeSelector = new RouteSelector(address2, realConnectionPool.routeDatabase, call2, eventListener2);
    }

    public ExchangeCodec find(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            return findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain);
        } catch (RouteException e) {
            trackFailure();
            throw e;
        } catch (IOException e2) {
            trackFailure();
            throw new RouteException(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r0.isHealthy(r9) != false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.RealConnection findHealthyConnection(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.RealConnection r0 = r3.findConnection(r4, r5, r6, r7, r8)
            okhttp3.internal.connection.RealConnectionPool r1 = r3.connectionPool
            monitor-enter(r1)
            int r2 = r0.successCount     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0013
            boolean r2 = r0.isMultiplexed()     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0013
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            return r0
        L_0x0013:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            boolean r1 = r0.isHealthy(r9)
            if (r1 != 0) goto L_0x001e
            r0.noNewExchanges()
            goto L_0x0000
        L_0x001e:
            return r0
        L_0x001f:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findHealthyConnection(int, int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    private RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket socket;
        Socket releaseConnectionNoEvents;
        RealConnection realConnection;
        RealConnection realConnection2;
        Route route;
        RealConnection realConnection3;
        boolean z2;
        boolean z3;
        List<Route> list;
        RouteSelector.Selection selection;
        Route route2;
        synchronized (this.connectionPool) {
            if (!this.transmitter.isCanceled()) {
                this.hasStreamFailure = false;
                RealConnection realConnection4 = this.transmitter.connection;
                socket = null;
                releaseConnectionNoEvents = (this.transmitter.connection == null || !this.transmitter.connection.noNewExchanges) ? null : this.transmitter.releaseConnectionNoEvents();
                if (this.transmitter.connection != null) {
                    realConnection2 = this.transmitter.connection;
                    realConnection = null;
                } else {
                    realConnection = realConnection4;
                    realConnection2 = null;
                }
                if (realConnection2 == null) {
                    if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, (List<Route>) null, false)) {
                        realConnection3 = this.transmitter.connection;
                        route = null;
                        z2 = true;
                    } else {
                        if (this.nextRouteToTry != null) {
                            route2 = this.nextRouteToTry;
                            this.nextRouteToTry = null;
                        } else if (retryCurrentRoute()) {
                            route2 = this.transmitter.connection.route();
                        }
                        route = route2;
                        realConnection3 = realConnection2;
                        z2 = false;
                    }
                }
                realConnection3 = realConnection2;
                route = null;
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        Util.closeQuietly(releaseConnectionNoEvents);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection3);
        }
        if (realConnection3 != null) {
            return realConnection3;
        }
        if (route != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z3 = true;
        }
        synchronized (this.connectionPool) {
            if (!this.transmitter.isCanceled()) {
                if (z3) {
                    list = this.routeSelection.getAll();
                    if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, list, false)) {
                        realConnection3 = this.transmitter.connection;
                        z2 = true;
                    }
                } else {
                    list = null;
                }
                if (!z2) {
                    if (route == null) {
                        route = this.routeSelection.next();
                    }
                    realConnection3 = new RealConnection(this.connectionPool, route);
                    this.connectingConnection = realConnection3;
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection3);
            return realConnection3;
        }
        realConnection3.connect(i, i2, i3, i4, z, this.call, this.eventListener);
        this.connectionPool.routeDatabase.connected(realConnection3.route());
        synchronized (this.connectionPool) {
            this.connectingConnection = null;
            if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, list, true)) {
                realConnection3.noNewExchanges = true;
                socket = realConnection3.socket();
                realConnection3 = this.transmitter.connection;
                this.nextRouteToTry = route;
            } else {
                this.connectionPool.put(realConnection3);
                this.transmitter.acquireConnectionNoEvents(realConnection3);
            }
        }
        Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, realConnection3);
        return realConnection3;
    }

    /* access modifiers changed from: package-private */
    public RealConnection connectingConnection() {
        return this.connectingConnection;
    }

    /* access modifiers changed from: package-private */
    public void trackFailure() {
        synchronized (this.connectionPool) {
            this.hasStreamFailure = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasStreamFailure() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.hasStreamFailure;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasRouteToTry() {
        /*
            r3 = this;
            okhttp3.internal.connection.RealConnectionPool r0 = r3.connectionPool
            monitor-enter(r0)
            okhttp3.Route r1 = r3.nextRouteToTry     // Catch:{ all -> 0x0034 }
            r2 = 1
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return r2
        L_0x000a:
            boolean r1 = r3.retryCurrentRoute()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x001c
            okhttp3.internal.connection.Transmitter r1 = r3.transmitter     // Catch:{ all -> 0x0034 }
            okhttp3.internal.connection.RealConnection r1 = r1.connection     // Catch:{ all -> 0x0034 }
            okhttp3.Route r1 = r1.route()     // Catch:{ all -> 0x0034 }
            r3.nextRouteToTry = r1     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return r2
        L_0x001c:
            okhttp3.internal.connection.RouteSelector$Selection r1 = r3.routeSelection     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0028
            okhttp3.internal.connection.RouteSelector$Selection r1 = r3.routeSelection     // Catch:{ all -> 0x0034 }
            boolean r1 = r1.hasNext()     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0032
        L_0x0028:
            okhttp3.internal.connection.RouteSelector r1 = r3.routeSelector     // Catch:{ all -> 0x0034 }
            boolean r1 = r1.hasNext()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r2 = 0
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            return r2
        L_0x0034:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.hasRouteToTry():boolean");
    }

    private boolean retryCurrentRoute() {
        return this.transmitter.connection != null && this.transmitter.connection.routeFailureCount == 0 && Util.sameConnection(this.transmitter.connection.route().address().url(), this.address.url());
    }
}
