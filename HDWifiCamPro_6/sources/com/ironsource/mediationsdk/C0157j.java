package com.ironsource.mediationsdk;

import com.ironsource.environment.e.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* renamed from: com.ironsource.mediationsdk.j  reason: case insensitive filesystem */
public final class C0157j {
    private static C0157j b;
    int a;
    private long c = 0;
    private boolean d = false;

    private C0157j() {
    }

    public static synchronized C0157j a() {
        C0157j jVar;
        synchronized (C0157j.class) {
            if (b == null) {
                b = new C0157j();
            }
            jVar = b;
        }
        return jVar;
    }

    public final void a(final IronSourceBannerLayout ironSourceBannerLayout, final IronSourceError ironSourceError) {
        synchronized (this) {
            if (!this.d) {
                long currentTimeMillis = System.currentTimeMillis() - this.c;
                if (currentTimeMillis > ((long) (this.a * 1000))) {
                    b(ironSourceBannerLayout, ironSourceError);
                    return;
                }
                this.d = true;
                long j = ((long) (this.a * 1000)) - currentTimeMillis;
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("delaying callback by " + j);
                c cVar = c.a;
                c.b(new Runnable() {
                    public final void run() {
                        C0157j.this.b(ironSourceBannerLayout, ironSourceError);
                    }
                }, j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(IronSourceBannerLayout ironSourceBannerLayout, IronSourceError ironSourceError) {
        if (ironSourceBannerLayout != null) {
            this.c = System.currentTimeMillis();
            this.d = false;
            ironSourceBannerLayout.a(ironSourceError);
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this) {
            z = this.d;
        }
        return z;
    }
}
