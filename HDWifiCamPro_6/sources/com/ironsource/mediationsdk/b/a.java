package com.ironsource.mediationsdk.b;

import java.util.Timer;
import java.util.TimerTask;

public abstract class a<T> {
    protected T a;
    private Timer b;
    private long c;

    public a(long j) {
        this.c = j;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public final void a(T t) {
        if (!(this.c <= 0) && t != null) {
            this.a = t;
            b();
            this.b = new Timer();
            this.b.schedule(new TimerTask() {
                public final void run() {
                    a.this.a();
                }
            }, this.c);
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        Timer timer = this.b;
        if (timer != null) {
            timer.cancel();
            this.b = null;
        }
    }

    public final void c() {
        this.a = null;
    }
}
