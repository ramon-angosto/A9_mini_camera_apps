package com.ironsource.mediationsdk.utils;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.sdk.a.e;

public final class o {
    private static o f;
    private int a = 1;
    private int b = 1;
    private int c = 1;
    private int d = 1;
    private e e = new e();

    /* renamed from: com.ironsource.mediationsdk.utils.o$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[IronSource.AD_UNIT.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.ironsource.mediationsdk.IronSource$AD_UNIT[] r0 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.o.AnonymousClass1.<clinit>():void");
        }
    }

    private o() {
        d(this.a);
        e(this.b);
        f(this.d);
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (f == null) {
                f = new o();
            }
            oVar = f;
        }
        return oVar;
    }

    private static IronSource.AD_UNIT c(int i) {
        if (i == 0) {
            return IronSource.AD_UNIT.OFFERWALL;
        }
        if (i == 1) {
            return IronSource.AD_UNIT.REWARDED_VIDEO;
        }
        if (i == 2) {
            return IronSource.AD_UNIT.INTERSTITIAL;
        }
        if (i != 3) {
            return null;
        }
        return IronSource.AD_UNIT.BANNER;
    }

    private void d(int i) {
        this.a = i;
        this.e.b(i);
    }

    private void e(int i) {
        this.b = i;
        this.e.a(i);
    }

    private void f(int i) {
        this.d = i;
        this.e.c(i);
    }

    public final synchronized void a(int i) {
        a(c(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.ironsource.mediationsdk.IronSource.AD_UNIT r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            int[] r0 = com.ironsource.mediationsdk.utils.o.AnonymousClass1.a     // Catch:{ all -> 0x0039 }
            int r3 = r3.ordinal()     // Catch:{ all -> 0x0039 }
            r3 = r0[r3]     // Catch:{ all -> 0x0039 }
            r0 = 1
            if (r3 == r0) goto L_0x0032
            r1 = 2
            if (r3 == r1) goto L_0x002a
            r1 = 3
            if (r3 == r1) goto L_0x0022
            r1 = 4
            if (r3 == r1) goto L_0x001a
            goto L_0x0020
        L_0x001a:
            int r3 = r2.d     // Catch:{ all -> 0x0039 }
            int r3 = r3 + r0
            r2.f(r3)     // Catch:{ all -> 0x0039 }
        L_0x0020:
            monitor-exit(r2)
            return
        L_0x0022:
            int r3 = r2.b     // Catch:{ all -> 0x0039 }
            int r3 = r3 + r0
            r2.e(r3)     // Catch:{ all -> 0x0039 }
            monitor-exit(r2)
            return
        L_0x002a:
            int r3 = r2.a     // Catch:{ all -> 0x0039 }
            int r3 = r3 + r0
            r2.d(r3)     // Catch:{ all -> 0x0039 }
            monitor-exit(r2)
            return
        L_0x0032:
            int r3 = r2.c     // Catch:{ all -> 0x0039 }
            int r3 = r3 + r0
            r2.c = r3     // Catch:{ all -> 0x0039 }
            monitor-exit(r2)
            return
        L_0x0039:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.o.a(com.ironsource.mediationsdk.IronSource$AD_UNIT):void");
    }

    public final synchronized int b(int i) {
        return b(c(i));
    }

    public final synchronized int b(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == null) {
            return -1;
        }
        int i = AnonymousClass1.a[ad_unit.ordinal()];
        if (i == 1) {
            return this.c;
        } else if (i == 2) {
            return this.a;
        } else if (i == 3) {
            return this.b;
        } else if (i != 4) {
            return -1;
        } else {
            return this.d;
        }
    }
}
