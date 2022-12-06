package com.ironsource.mediationsdk.adunit.c;

import com.ironsource.mediationsdk.adunit.c.b.a;
import com.ironsource.mediationsdk.ae;
import java.util.Timer;
import java.util.TimerTask;

public final class c {
    a a;
    ae b;
    private Timer c;

    public c(a aVar, ae aeVar) {
        this.a = aVar;
        this.b = aeVar;
    }

    private void c() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
    }

    public final void a() {
        if (this.a.a != a.C0091a.MANUAL) {
            a(this.a.c);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        c();
        this.c = new Timer();
        this.c.schedule(new TimerTask() {
            public final void run() {
                c.this.b.d();
            }
        }, j);
    }

    public final void b() {
        if (this.a.a != a.C0091a.MANUAL) {
            a(0);
        }
    }
}
