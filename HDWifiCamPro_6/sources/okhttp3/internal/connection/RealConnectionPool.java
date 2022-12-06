package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Address;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.platform.Platform;

public final class RealConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final Runnable cleanupRunnable = new Runnable() {
        public final void run() {
            RealConnectionPool.this.lambda$new$0$RealConnectionPool();
        }
    };
    boolean cleanupRunning;
    private final Deque<RealConnection> connections = new ArrayDeque();
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final RouteDatabase routeDatabase = new RouteDatabase();

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$new$0$RealConnectionPool() {
        /*
            r6 = this;
        L_0x0000:
            long r0 = java.lang.System.nanoTime()
            long r0 = r6.cleanup(r0)
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x000f
            return
        L_0x000f:
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0000
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r0 / r2
            long r2 = r2 * r4
            long r0 = r0 - r2
            monitor-enter(r6)
            int r0 = (int) r0
            r6.wait(r4, r0)     // Catch:{ InterruptedException -> 0x0024 }
            goto L_0x0024
        L_0x0022:
            r0 = move-exception
            goto L_0x0026
        L_0x0024:
            monitor-exit(r6)     // Catch:{ all -> 0x0022 }
            goto L_0x0000
        L_0x0026:
            monitor-exit(r6)     // Catch:{ all -> 0x0022 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnectionPool.lambda$new$0$RealConnectionPool():void");
    }

    public RealConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
        }
    }

    public synchronized int idleConnectionCount() {
        int i;
        i = 0;
        for (RealConnection realConnection : this.connections) {
            if (realConnection.transmitters.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    public synchronized int connectionCount() {
        return this.connections.size();
    }

    /* access modifiers changed from: package-private */
    public boolean transmitterAcquirePooledConnection(Address address, Transmitter transmitter, @Nullable List<Route> list, boolean z) {
        for (RealConnection next : this.connections) {
            if ((!z || next.isMultiplexed()) && next.isEligible(address, list)) {
                transmitter.acquireConnectionNoEvents(next);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void put(RealConnection realConnection) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(realConnection);
    }

    /* access modifiers changed from: package-private */
    public boolean connectionBecameIdle(RealConnection realConnection) {
        if (realConnection.noNewExchanges || this.maxIdleConnections == 0) {
            this.connections.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public void evictAll() {
        ArrayList<RealConnection> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator<RealConnection> it = this.connections.iterator();
            while (it.hasNext()) {
                RealConnection next = it.next();
                if (next.transmitters.isEmpty()) {
                    next.noNewExchanges = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        for (RealConnection socket : arrayList) {
            Util.closeQuietly(socket.socket());
        }
    }

    /* access modifiers changed from: package-private */
    public long cleanup(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            int i = 0;
            RealConnection realConnection = null;
            int i2 = 0;
            for (RealConnection next : this.connections) {
                if (pruneAndGetAllocationCount(next, j) > 0) {
                    i++;
                } else {
                    i2++;
                    long j3 = j - next.idleAtNanos;
                    if (j3 > j2) {
                        realConnection = next;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.keepAliveDurationNs) {
                if (i2 <= this.maxIdleConnections) {
                    if (i2 > 0) {
                        long j4 = this.keepAliveDurationNs - j2;
                        return j4;
                    } else if (i > 0) {
                        long j5 = this.keepAliveDurationNs;
                        return j5;
                    } else {
                        this.cleanupRunning = false;
                        return -1;
                    }
                }
            }
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            return 0;
        }
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        List<Reference<Transmitter>> list = realConnection.transmitters;
        int i = 0;
        while (i < list.size()) {
            Reference reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Platform.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((Transmitter.TransmitterReference) reference).callStackTrace);
                list.remove(i);
                realConnection.noNewExchanges = true;
                if (list.isEmpty()) {
                    realConnection.idleAtNanos = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public void connectFailed(Route route, IOException iOException) {
        if (route.proxy().type() != Proxy.Type.DIRECT) {
            Address address = route.address();
            address.proxySelector().connectFailed(address.url().uri(), route.proxy().address(), iOException);
        }
        this.routeDatabase.failed(route);
    }
}
