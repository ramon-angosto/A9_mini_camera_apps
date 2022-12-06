package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.hf */
public class C1856hf implements C1813fx {

    /* renamed from: a */
    private int f2620a;

    /* renamed from: a */
    private long f2621a = 0;

    /* renamed from: a */
    C1809fu f2622a;

    /* renamed from: a */
    XMPushService f2623a;

    /* renamed from: a */
    private Exception f2624a;

    /* renamed from: a */
    private String f2625a;

    /* renamed from: b */
    private long f2626b = 0;

    /* renamed from: c */
    private long f2627c = 0;

    /* renamed from: d */
    private long f2628d = 0;

    /* renamed from: e */
    private long f2629e = 0;

    /* renamed from: f */
    private long f2630f = 0;

    C1856hf(XMPushService xMPushService) {
        this.f2623a = xMPushService;
        this.f2625a = "";
        m3839b();
        int myUid = Process.myUid();
        try {
            this.f2630f = TrafficStats.getUidRxBytes(myUid);
            this.f2629e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            C1524b.m2141a("Failed to obtain traffic data during initialization: " + e);
            this.f2630f = -1;
            this.f2629e = -1;
        }
    }

    /* renamed from: b */
    private void m3839b() {
        this.f2626b = 0;
        this.f2628d = 0;
        this.f2621a = 0;
        this.f2627c = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C1653bi.m2685b(this.f2623a)) {
            this.f2621a = elapsedRealtime;
        }
        if (this.f2623a.mo18423c()) {
            this.f2627c = elapsedRealtime;
        }
    }

    /* renamed from: c */
    private synchronized void m3840c() {
        C1524b.m2159c("stat connpt = " + this.f2625a + " netDuration = " + this.f2626b + " ChannelDuration = " + this.f2628d + " channelConnectedTime = " + this.f2627c);
        C1790fg fgVar = new C1790fg();
        fgVar.f2363a = 0;
        fgVar.mo17576a(C1789ff.CHANNEL_ONLINE_RATE.mo17573a());
        fgVar.mo17577a(this.f2625a);
        fgVar.mo17591d((int) (System.currentTimeMillis() / 1000));
        fgVar.mo17581b((int) (this.f2626b / 1000));
        fgVar.mo17586c((int) (this.f2628d / 1000));
        C1857hg.mo17753a().mo17755a(fgVar);
        m3839b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Exception mo17752a() {
        return this.f2624a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m3842a() {
        /*
            r10 = this;
            monitor-enter(r10)
            com.xiaomi.push.service.XMPushService r0 = r10.f2623a     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r10)
            return
        L_0x0007:
            com.xiaomi.push.service.XMPushService r0 = r10.f2623a     // Catch:{ all -> 0x006f }
            java.lang.String r0 = com.xiaomi.push.C1653bi.m2669a((android.content.Context) r0)     // Catch:{ all -> 0x006f }
            com.xiaomi.push.service.XMPushService r1 = r10.f2623a     // Catch:{ all -> 0x006f }
            boolean r1 = com.xiaomi.push.C1653bi.m2686c(r1)     // Catch:{ all -> 0x006f }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x006f }
            long r4 = r10.f2621a     // Catch:{ all -> 0x006f }
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x002a
            long r4 = r10.f2626b     // Catch:{ all -> 0x006f }
            long r8 = r10.f2621a     // Catch:{ all -> 0x006f }
            long r8 = r2 - r8
            long r4 = r4 + r8
            r10.f2626b = r4     // Catch:{ all -> 0x006f }
            r10.f2621a = r6     // Catch:{ all -> 0x006f }
        L_0x002a:
            long r4 = r10.f2627c     // Catch:{ all -> 0x006f }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x003b
            long r4 = r10.f2628d     // Catch:{ all -> 0x006f }
            long r8 = r10.f2627c     // Catch:{ all -> 0x006f }
            long r8 = r2 - r8
            long r4 = r4 + r8
            r10.f2628d = r4     // Catch:{ all -> 0x006f }
            r10.f2627c = r6     // Catch:{ all -> 0x006f }
        L_0x003b:
            if (r1 == 0) goto L_0x006d
            java.lang.String r1 = r10.f2625a     // Catch:{ all -> 0x006f }
            boolean r1 = android.text.TextUtils.equals(r1, r0)     // Catch:{ all -> 0x006f }
            if (r1 != 0) goto L_0x004d
            long r4 = r10.f2626b     // Catch:{ all -> 0x006f }
            r8 = 30000(0x7530, double:1.4822E-319)
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 > 0) goto L_0x0056
        L_0x004d:
            long r4 = r10.f2626b     // Catch:{ all -> 0x006f }
            r8 = 5400000(0x5265c0, double:2.6679545E-317)
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0059
        L_0x0056:
            r10.m3840c()     // Catch:{ all -> 0x006f }
        L_0x0059:
            r10.f2625a = r0     // Catch:{ all -> 0x006f }
            long r0 = r10.f2621a     // Catch:{ all -> 0x006f }
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0063
            r10.f2621a = r2     // Catch:{ all -> 0x006f }
        L_0x0063:
            com.xiaomi.push.service.XMPushService r0 = r10.f2623a     // Catch:{ all -> 0x006f }
            boolean r0 = r0.mo18423c()     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x006d
            r10.f2627c = r2     // Catch:{ all -> 0x006f }
        L_0x006d:
            monitor-exit(r10)
            return
        L_0x006f:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1856hf.m3842a():void");
    }

    /* renamed from: a */
    public void mo17652a(C1809fu fuVar) {
        this.f2620a = 0;
        this.f2624a = null;
        this.f2622a = fuVar;
        this.f2625a = C1653bi.m2669a((Context) this.f2623a);
        C1860hi.m3862a(0, C1789ff.CONN_SUCCESS.mo17573a());
    }

    /* renamed from: a */
    public void mo17653a(C1809fu fuVar, int i, Exception exc) {
        long j;
        if (this.f2620a == 0 && this.f2624a == null) {
            this.f2620a = i;
            this.f2624a = exc;
            C1860hi.m3870b(fuVar.mo17639a(), exc);
        }
        if (i == 22 && this.f2627c != 0) {
            long a = fuVar.mo17639a() - this.f2627c;
            if (a < 0) {
                a = 0;
            }
            this.f2628d += a + ((long) (C1818ga.m3681b() / 2));
            this.f2627c = 0;
        }
        mo17752a();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            C1524b.m2141a("Failed to obtain traffic data: " + e);
            j = -1;
        }
        C1524b.m2159c("Stats rx=" + (j2 - this.f2630f) + ", tx=" + (j - this.f2629e));
        this.f2630f = j2;
        this.f2629e = j;
    }

    /* renamed from: a */
    public void mo17654a(C1809fu fuVar, Exception exc) {
        C1860hi.m3863a(0, C1789ff.CHANNEL_CON_FAIL.mo17573a(), 1, fuVar.mo17639a(), C1653bi.m2686c(this.f2623a) ? 1 : 0);
        mo17752a();
    }

    /* renamed from: b */
    public void mo17655b(C1809fu fuVar) {
        mo17752a();
        this.f2627c = SystemClock.elapsedRealtime();
        C1860hi.m3864a(0, C1789ff.CONN_SUCCESS.mo17573a(), fuVar.mo17639a(), fuVar.mo17639a());
    }
}
