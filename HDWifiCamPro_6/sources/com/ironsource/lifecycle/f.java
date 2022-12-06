package com.ironsource.lifecycle;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public final class f implements c {
    Runnable a;
    private String b = "INTERNAL";
    private Timer c;
    private boolean d;
    private Long e;
    private long f;

    public f(long j, Runnable runnable, boolean z) {
        this.f = j;
        this.a = runnable;
        this.d = false;
        this.e = null;
        if (!this.d) {
            this.d = true;
            d.a().a((c) this);
            this.e = Long.valueOf(System.currentTimeMillis() + this.f);
            if (!d.a().b()) {
                d();
            }
        }
    }

    private void d() {
        if (this.c == null) {
            this.c = new Timer();
            this.c.schedule(new TimerTask() {
                public final void run() {
                    f.this.a.run();
                }
            }, this.f);
            Calendar.getInstance().setTimeInMillis(this.e.longValue());
        }
    }

    private void e() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
    }

    public final void a() {
        Long l;
        if (this.c == null && (l = this.e) != null) {
            this.f = l.longValue() - System.currentTimeMillis();
            if (this.f <= 0) {
                c();
                this.a.run();
                return;
            }
            d();
        }
    }

    public final void b() {
        if (this.c != null) {
            e();
        }
    }

    public final void c() {
        e();
        this.d = false;
        this.e = null;
        d a2 = d.a();
        if (a2.g.contains(this)) {
            a2.g.remove(this);
        }
    }
}
