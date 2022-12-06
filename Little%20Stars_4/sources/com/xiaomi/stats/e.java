package com.xiaomi.stats;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.a;
import com.xiaomi.smack.d;
import com.xiaomi.smack.j;

public class e implements d {
    XMPushService a;
    a b;
    private int c;
    private Exception d;
    private String e;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private long i = 0;

    e(XMPushService xMPushService) {
        this.a = xMPushService;
        this.e = com.xiaomi.channel.commonutils.network.d.g(xMPushService);
        c();
    }

    private void c() {
        this.g = 0;
        this.i = 0;
        this.f = 0;
        this.h = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.xiaomi.channel.commonutils.network.d.d(this.a)) {
            this.f = elapsedRealtime;
        }
        if (this.a.e()) {
            this.h = elapsedRealtime;
        }
    }

    private synchronized void d() {
        b.c("stat connpt = " + this.e + " netDuration = " + this.g + " ChannelDuration = " + this.i + " channelConnectedTime = " + this.h);
        com.xiaomi.push.thrift.b bVar = new com.xiaomi.push.thrift.b();
        bVar.a = 0;
        bVar.a(com.xiaomi.push.thrift.a.CHANNEL_ONLINE_RATE.a());
        bVar.a(this.e);
        bVar.d((int) (System.currentTimeMillis() / 1000));
        bVar.b((int) (this.g / 1000));
        bVar.c((int) (this.i / 1000));
        f.a().a(bVar);
        c();
    }

    /* access modifiers changed from: package-private */
    public Exception a() {
        return this.d;
    }

    public void a(a aVar) {
        b();
        this.h = SystemClock.elapsedRealtime();
        h.a(0, com.xiaomi.push.thrift.a.CONN_SUCCESS.a(), aVar.c(), aVar.j());
    }

    public void a(a aVar, int i2, Exception exc) {
        if (this.c == 0 && this.d == null) {
            this.c = i2;
            this.d = exc;
            h.b(aVar.c(), exc);
        }
        if (i2 == 22 && this.h != 0) {
            long f2 = aVar.f() - this.h;
            if (f2 < 0) {
                f2 = 0;
            }
            this.i += f2 + ((long) (j.c() / 2));
            this.h = 0;
        }
        b();
    }

    public void a(a aVar, Exception exc) {
        h.a(0, com.xiaomi.push.thrift.a.CHANNEL_CON_FAIL.a(), 1, aVar.c(), com.xiaomi.channel.commonutils.network.d.d(this.a) ? 1 : 0);
        b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b() {
        /*
            r10 = this;
            monitor-enter(r10)
            com.xiaomi.push.service.XMPushService r0 = r10.a     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r10)
            return
        L_0x0007:
            com.xiaomi.push.service.XMPushService r0 = r10.a     // Catch:{ all -> 0x006f }
            java.lang.String r0 = com.xiaomi.channel.commonutils.network.d.g(r0)     // Catch:{ all -> 0x006f }
            com.xiaomi.push.service.XMPushService r1 = r10.a     // Catch:{ all -> 0x006f }
            boolean r1 = com.xiaomi.channel.commonutils.network.d.d(r1)     // Catch:{ all -> 0x006f }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x006f }
            long r4 = r10.f     // Catch:{ all -> 0x006f }
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x002a
            long r4 = r10.g     // Catch:{ all -> 0x006f }
            long r8 = r10.f     // Catch:{ all -> 0x006f }
            long r8 = r2 - r8
            long r4 = r4 + r8
            r10.g = r4     // Catch:{ all -> 0x006f }
            r10.f = r6     // Catch:{ all -> 0x006f }
        L_0x002a:
            long r4 = r10.h     // Catch:{ all -> 0x006f }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x003b
            long r4 = r10.i     // Catch:{ all -> 0x006f }
            long r8 = r10.h     // Catch:{ all -> 0x006f }
            long r8 = r2 - r8
            long r4 = r4 + r8
            r10.i = r4     // Catch:{ all -> 0x006f }
            r10.h = r6     // Catch:{ all -> 0x006f }
        L_0x003b:
            if (r1 == 0) goto L_0x006d
            java.lang.String r1 = r10.e     // Catch:{ all -> 0x006f }
            boolean r1 = android.text.TextUtils.equals(r1, r0)     // Catch:{ all -> 0x006f }
            if (r1 != 0) goto L_0x004d
            long r4 = r10.g     // Catch:{ all -> 0x006f }
            r8 = 30000(0x7530, double:1.4822E-319)
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 > 0) goto L_0x0056
        L_0x004d:
            long r4 = r10.g     // Catch:{ all -> 0x006f }
            r8 = 5400000(0x5265c0, double:2.6679545E-317)
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0059
        L_0x0056:
            r10.d()     // Catch:{ all -> 0x006f }
        L_0x0059:
            r10.e = r0     // Catch:{ all -> 0x006f }
            long r0 = r10.f     // Catch:{ all -> 0x006f }
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0063
            r10.f = r2     // Catch:{ all -> 0x006f }
        L_0x0063:
            com.xiaomi.push.service.XMPushService r0 = r10.a     // Catch:{ all -> 0x006f }
            boolean r0 = r0.e()     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x006d
            r10.h = r2     // Catch:{ all -> 0x006f }
        L_0x006d:
            monitor-exit(r10)
            return
        L_0x006f:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.stats.e.b():void");
    }

    public void b(a aVar) {
        this.c = 0;
        this.d = null;
        this.b = aVar;
        h.a(0, com.xiaomi.push.thrift.a.CONN_SUCCESS.a());
    }
}
