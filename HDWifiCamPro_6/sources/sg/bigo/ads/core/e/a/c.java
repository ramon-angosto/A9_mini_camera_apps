package sg.bigo.ads.core.e.a;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.k.a;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.core.e.a.f;

public final class c {
    /* access modifiers changed from: private */
    public static boolean d = false;
    private static final c e = new c();
    public final Set<e> a = n.a(50);
    public final AtomicBoolean b = new AtomicBoolean(false);
    public o c;
    /* access modifiers changed from: private */
    public final Runnable f = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00af  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0135  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x013d  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x01bb  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x01c2  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0270  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0272  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0275  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0299  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r16 = this;
                r0 = r16
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "mRetryTrackerRunnable. maybe trackInfoNum="
                r1.<init>(r2)
                sg.bigo.ads.core.e.a.c r2 = sg.bigo.ads.core.e.a.c.this
                java.util.Set r2 = r2.a
                int r2 = r2.size()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "RetryTrackerManager"
                r3 = 3
                r4 = 0
                sg.bigo.ads.common.k.a.a(r4, r3, r2, r1)
                sg.bigo.ads.core.e.a.c r1 = sg.bigo.ads.core.e.a.c.this
                java.util.Set r1 = r1.a
                java.util.Iterator r1 = r1.iterator()
                r5 = r4
                r6 = r5
            L_0x002d:
                boolean r7 = r1.hasNext()
                r8 = 1
                if (r7 == 0) goto L_0x02ae
                java.lang.Object r5 = r1.next()
                sg.bigo.ads.core.e.a.e r5 = (sg.bigo.ads.core.e.a.e) r5
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r7 = r5.r
                java.lang.String r9 = "TrackerInfo"
                if (r7 != 0) goto L_0x0047
                java.lang.String r7 = "retryThirdTrackImpl mThirdImpressionTrack is error."
                sg.bigo.ads.common.k.a.b(r9, r7)
            L_0x0045:
                r7 = r4
                goto L_0x00ab
            L_0x0047:
                int r7 = r5.i
                boolean r7 = r5.a((int) r7)
                if (r7 != 0) goto L_0x0063
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r10 = "retryThirdTrackImpl times limit. mTrytimes = "
                r7.<init>(r10)
                int r10 = r5.i
                r7.append(r10)
                java.lang.String r7 = r7.toString()
            L_0x005f:
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r7)
                goto L_0x0045
            L_0x0063:
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r7 = r5.r
                int r7 = r7.size()
                java.lang.String r10 = java.lang.String.valueOf(r7)
                java.lang.String r11 = "retryThirdTrackImpl implTrackNum = "
                java.lang.String r10 = r11.concat(r10)
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r10)
                if (r7 != 0) goto L_0x0079
                goto L_0x0045
            L_0x0079:
                sg.bigo.ads.api.core.o r10 = r5.q
                long r11 = r5.j
                long r13 = java.lang.System.currentTimeMillis()
                boolean r10 = r10.a(r11, r13)
                if (r10 != 0) goto L_0x008a
                java.lang.String r7 = "retryThirdTrackImpl interval limit"
                goto L_0x005f
            L_0x008a:
                long r10 = java.lang.System.currentTimeMillis()
                r5.j = r10
                int r10 = r5.i
                int r10 = r10 + r8
                r5.i = r10
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                java.lang.String r11 = "retryThirdTrackImpl mTrytimes = "
                r10.<init>(r11)
                int r11 = r5.i
                r10.append(r11)
                java.lang.String r10 = r10.toString()
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r10)
                r5.h()
            L_0x00ab:
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r10 = r5.s
                if (r10 != 0) goto L_0x00b7
                java.lang.String r10 = "retryThirdTrackClick not perform trackThirdClick"
            L_0x00b1:
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r10)
            L_0x00b4:
                r10 = r4
                goto L_0x0131
            L_0x00b7:
                int r10 = r5.k
                boolean r10 = r5.a((int) r10)
                if (r10 != 0) goto L_0x00d0
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                java.lang.String r11 = "retryThirdTrackClick times limit. mTrytimes = "
                r10.<init>(r11)
                int r11 = r5.k
                r10.append(r11)
                java.lang.String r10 = r10.toString()
                goto L_0x00b1
            L_0x00d0:
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r10 = r5.s
                int r10 = r10.size()
                java.lang.String r11 = java.lang.String.valueOf(r10)
                java.lang.String r12 = "retryThirdTrackClick clickTrackNum = "
                java.lang.String r11 = r12.concat(r11)
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r11)
                if (r10 != 0) goto L_0x00e6
                goto L_0x00b4
            L_0x00e6:
                sg.bigo.ads.api.core.o r10 = r5.q
                long r11 = r5.l
                long r13 = java.lang.System.currentTimeMillis()
                boolean r10 = r10.a(r11, r13)
                if (r10 != 0) goto L_0x00f7
                java.lang.String r10 = "retryThirdTrackClick interval limit"
                goto L_0x00b1
            L_0x00f7:
                long r10 = java.lang.System.currentTimeMillis()
                r5.l = r10
                int r10 = r5.k
                int r10 = r10 + r8
                r5.k = r10
                int r10 = r5.i()
                if (r10 != 0) goto L_0x0111
                int r11 = r5.k
                if (r11 <= 0) goto L_0x0111
                int r11 = r5.k
                int r11 = r11 - r8
                r5.k = r11
            L_0x0111:
                java.lang.String r11 = java.lang.String.valueOf(r10)
                java.lang.String r12 = "retryThirdTrackClick Real clickTrackNum = "
                java.lang.String r11 = r12.concat(r11)
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r11)
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                java.lang.String r12 = "retryThirdTrackClick mTrytimes = "
                r11.<init>(r12)
                int r12 = r5.k
                r11.append(r12)
                java.lang.String r11 = r11.toString()
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r11)
            L_0x0131:
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r11 = r5.t
                if (r11 != 0) goto L_0x013d
                java.lang.String r11 = "retryBiddingNUrl not perform."
            L_0x0137:
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r11)
            L_0x013a:
                r11 = r4
                goto L_0x01b7
            L_0x013d:
                int r11 = r5.m
                boolean r11 = r5.a((int) r11)
                if (r11 != 0) goto L_0x0156
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                java.lang.String r12 = "retryBiddingNUrl times limit. mTrytimes = "
                r11.<init>(r12)
                int r12 = r5.m
                r11.append(r12)
                java.lang.String r11 = r11.toString()
                goto L_0x0137
            L_0x0156:
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r11 = r5.t
                int r11 = r11.size()
                java.lang.String r12 = java.lang.String.valueOf(r11)
                java.lang.String r13 = "retryBiddingNUrl trackNum = "
                java.lang.String r12 = r13.concat(r12)
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r12)
                if (r11 != 0) goto L_0x016c
                goto L_0x013a
            L_0x016c:
                sg.bigo.ads.api.core.o r11 = r5.q
                long r12 = r5.n
                long r14 = java.lang.System.currentTimeMillis()
                boolean r11 = r11.a(r12, r14)
                if (r11 != 0) goto L_0x017d
                java.lang.String r11 = "retryBiddingNUrl interval limit"
                goto L_0x0137
            L_0x017d:
                long r11 = java.lang.System.currentTimeMillis()
                r5.n = r11
                int r11 = r5.m
                int r11 = r11 + r8
                r5.m = r11
                int r11 = r5.j()
                if (r11 != 0) goto L_0x0197
                int r12 = r5.m
                if (r12 <= 0) goto L_0x0197
                int r12 = r5.m
                int r12 = r12 - r8
                r5.m = r12
            L_0x0197:
                java.lang.String r12 = java.lang.String.valueOf(r11)
                java.lang.String r13 = "retryBiddingNUrl Real trackNum = "
                java.lang.String r12 = r13.concat(r12)
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r12)
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                java.lang.String r13 = "retryBiddingNUrl mTrytimes = "
                r12.<init>(r13)
                int r13 = r5.m
                r12.append(r13)
                java.lang.String r12 = r12.toString()
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r12)
            L_0x01b7:
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r12 = r5.u
                if (r12 != 0) goto L_0x01c2
                java.lang.String r12 = "retryBiddingLUrl not perform."
            L_0x01bd:
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r12)
                goto L_0x0244
            L_0x01c2:
                int r12 = r5.o
                boolean r12 = r5.a((int) r12)
                if (r12 != 0) goto L_0x01db
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                java.lang.String r13 = "retryBiddingLUrl times limit. mTrytimes = "
                r12.<init>(r13)
                int r13 = r5.o
                r12.append(r13)
                java.lang.String r12 = r12.toString()
                goto L_0x01bd
            L_0x01db:
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r12 = r5.u
                int r12 = r12.size()
                java.lang.String r13 = java.lang.String.valueOf(r12)
                java.lang.String r14 = "retryBiddingLUrl trackNum = "
                java.lang.String r13 = r14.concat(r13)
                sg.bigo.ads.common.k.a.a(r4, r3, r9, r13)
                if (r12 != 0) goto L_0x01f1
                goto L_0x0244
            L_0x01f1:
                sg.bigo.ads.api.core.o r12 = r5.q
                long r13 = r5.p
                long r3 = java.lang.System.currentTimeMillis()
                boolean r3 = r12.a(r13, r3)
                if (r3 != 0) goto L_0x0208
                java.lang.String r3 = "retryBiddingLUrl interval limit"
                r4 = 3
                r12 = 0
                sg.bigo.ads.common.k.a.a(r12, r4, r9, r3)
                r4 = 0
                goto L_0x0244
            L_0x0208:
                long r3 = java.lang.System.currentTimeMillis()
                r5.p = r3
                int r3 = r5.o
                int r3 = r3 + r8
                r5.o = r3
                int r4 = r5.k()
                if (r4 != 0) goto L_0x0222
                int r3 = r5.o
                if (r3 <= 0) goto L_0x0222
                int r3 = r5.o
                int r3 = r3 - r8
                r5.o = r3
            L_0x0222:
                java.lang.String r3 = java.lang.String.valueOf(r4)
                java.lang.String r12 = "retryBiddingLUrl Real trackNum = "
                java.lang.String r3 = r12.concat(r3)
                r12 = 3
                r13 = 0
                sg.bigo.ads.common.k.a.a(r13, r12, r9, r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r14 = "retryBiddingLUrl mTrytimes = "
                r3.<init>(r14)
                int r14 = r5.o
                r3.append(r14)
                java.lang.String r3 = r3.toString()
                sg.bigo.ads.common.k.a.a(r13, r12, r9, r3)
            L_0x0244:
                int r7 = r7 + r10
                int r7 = r7 + r11
                int r3 = r7 + r4
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r4 = r5.r
                int r7 = r5.i
                boolean r4 = r5.a((java.util.List<sg.bigo.ads.core.e.a.d>) r4, (int) r7)
                if (r4 == 0) goto L_0x0272
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r4 = r5.s
                int r7 = r5.k
                boolean r4 = r5.a((java.util.List<sg.bigo.ads.core.e.a.d>) r4, (int) r7)
                if (r4 == 0) goto L_0x0272
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r4 = r5.t
                int r7 = r5.m
                boolean r4 = r5.a((java.util.List<sg.bigo.ads.core.e.a.d>) r4, (int) r7)
                if (r4 == 0) goto L_0x0272
                java.util.concurrent.CopyOnWriteArrayList<sg.bigo.ads.core.e.a.d> r4 = r5.u
                int r7 = r5.o
                boolean r4 = r5.a((java.util.List<sg.bigo.ads.core.e.a.d>) r4, (int) r7)
                if (r4 == 0) goto L_0x0272
                r4 = r8
                goto L_0x0273
            L_0x0272:
                r4 = 0
            L_0x0273:
                if (r4 == 0) goto L_0x0299
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r7 = "allThirdTrackDone trackInfo="
                r4.<init>(r7)
                java.lang.String r7 = r5.toString()
                r4.append(r7)
                java.lang.String r4 = r4.toString()
                r7 = 3
                r9 = 0
                sg.bigo.ads.common.k.a.a(r9, r7, r2, r4)
                sg.bigo.ads.core.e.a.f r4 = sg.bigo.ads.core.e.a.f.a.a
                sg.bigo.ads.core.e.a.f.b(r5)
                r1.remove()
            L_0x0294:
                r5 = r3
                r3 = r7
                r4 = r9
                goto L_0x002d
            L_0x0299:
                r7 = 3
                r9 = 0
                int r6 = r6 + r3
                r4 = 20
                if (r6 <= r4) goto L_0x0294
                java.lang.String r1 = java.lang.String.valueOf(r6)
                java.lang.String r4 = "track num exceeded the limit. trackNum="
                java.lang.String r1 = r4.concat(r1)
                sg.bigo.ads.common.k.a.a(r9, r7, r2, r1)
                goto L_0x02b1
            L_0x02ae:
                r7 = r3
                r9 = r4
                r3 = r5
            L_0x02b1:
                java.lang.String r1 = java.lang.String.valueOf(r3)
                java.lang.String r3 = "mRetryTrackerRunnable. actually trackNum="
                java.lang.String r1 = r3.concat(r1)
                sg.bigo.ads.common.k.a.a(r9, r7, r2, r1)
                sg.bigo.ads.core.e.a.c r1 = sg.bigo.ads.core.e.a.c.this
                java.util.Set r1 = r1.a
                int r1 = r1.size()
                if (r1 != 0) goto L_0x0300
                sg.bigo.ads.core.e.a.c r1 = sg.bigo.ads.core.e.a.c.this
                java.util.Set r1 = r1.a
                sg.bigo.ads.core.e.a.f r3 = sg.bigo.ads.core.e.a.f.a.a
                r3 = 1800000(0x1b7740, double:8.89318E-318)
                sg.bigo.ads.core.e.a.c r5 = sg.bigo.ads.core.e.a.c.this
                sg.bigo.ads.api.core.o r5 = r5.c
                java.util.List r3 = sg.bigo.ads.core.e.a.f.a(r3, r5)
                r1.addAll(r3)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r3 = "mRetryTrackerRunnable. append, trackers="
                r1.<init>(r3)
                sg.bigo.ads.core.e.a.c r3 = sg.bigo.ads.core.e.a.c.this
                java.util.Set r3 = r3.a
                int r3 = r3.size()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                r3 = 3
                r4 = 0
                sg.bigo.ads.common.k.a.a(r4, r3, r2, r1)
                goto L_0x0302
            L_0x0300:
                r3 = 3
                r4 = 0
            L_0x0302:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r5 = "mRetryTrackerRunnable.trackers="
                r1.<init>(r5)
                sg.bigo.ads.core.e.a.c r5 = sg.bigo.ads.core.e.a.c.this
                java.util.Set r5 = r5.a
                int r5 = r5.size()
                r1.append(r5)
                java.lang.String r1 = r1.toString()
                sg.bigo.ads.common.k.a.a(r4, r3, r2, r1)
                sg.bigo.ads.core.e.a.c r1 = sg.bigo.ads.core.e.a.c.this
                java.util.Set r1 = r1.a
                int r1 = r1.size()
                if (r1 <= 0) goto L_0x0335
                sg.bigo.ads.core.e.a.c r1 = sg.bigo.ads.core.e.a.c.this
                java.lang.Runnable r1 = r1.f
                r2 = 20000(0x4e20, double:9.8813E-320)
                sg.bigo.ads.common.f.c.a(r8, r1, r2)
                return
            L_0x0335:
                java.lang.String r1 = "mRetryTrackerRunnable. stop looping"
                sg.bigo.ads.common.k.a.a(r4, r3, r2, r1)
                boolean unused = sg.bigo.ads.core.e.a.c.d = false
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.e.a.c.AnonymousClass2.run():void");
        }
    };

    public static c a() {
        return e;
    }

    /* access modifiers changed from: private */
    public void d() {
        d = true;
        b();
        a.a(0, 3, "RetryTrackerManager", "startCheckRetryTrack");
        sg.bigo.ads.common.f.c.a(1, this.f, 20000);
    }

    public final void a(e eVar) {
        if (!d) {
            d();
        }
        this.a.add(eVar);
        f fVar = f.a.a;
        f.a(eVar);
    }

    public final void b() {
        a.a(0, 3, "RetryTrackerManager", "stopCheckRetryTrack");
        sg.bigo.ads.common.f.c.a(this.f);
    }

    public final void b(final e eVar) {
        sg.bigo.ads.common.f.c.a(1, new Runnable() {
            public final void run() {
                f fVar = f.a.a;
                f.b(eVar);
            }
        });
    }
}
