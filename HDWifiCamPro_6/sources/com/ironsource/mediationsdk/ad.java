package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.utils.c;
import java.util.Timer;
import java.util.TimerTask;

public final class ad {
    ae a;
    private c b;
    private Timer c = null;

    public ad(c cVar, ae aeVar) {
        this.b = cVar;
        this.a = aeVar;
    }

    private void e() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
    }

    public final synchronized void a() {
        if (this.b.m) {
            e();
            this.c = new Timer();
            this.c.schedule(new TimerTask() {
                public final void run() {
                    ad.this.a.d();
                }
            }, this.b.k);
        }
    }

    public final synchronized void b() {
        if (!this.b.m) {
            e();
            this.c = new Timer();
            this.c.schedule(new TimerTask() {
                public final void run() {
                    ad.this.a.d();
                }
            }, this.b.k);
        }
    }

    public final void c() {
        synchronized (this) {
            e();
        }
        this.a.d();
    }

    public final synchronized void d() {
        e();
        this.c = new Timer();
        this.c.schedule(new TimerTask() {
            public final void run() {
                ad.this.a.d();
            }
        }, this.b.j);
    }
}
