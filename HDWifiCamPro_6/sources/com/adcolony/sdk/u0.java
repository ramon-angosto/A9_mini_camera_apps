package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.e0;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class u0 {
    private final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */
    public ScheduledFuture<?> b;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> c;
    /* access modifiers changed from: private */
    public final t0 d;

    class a implements Runnable {
        a() {
        }

        public void run() {
            ScheduledFuture unused = u0.this.b = null;
            u0.this.e();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (u0.this.d.g()) {
                a.b().r().i();
                ScheduledFuture unused = u0.this.c = null;
            }
        }
    }

    u0(t0 t0Var) {
        this.d = t0Var;
    }

    private void d() {
        if (this.b == null) {
            try {
                this.b = this.a.schedule(new a(), this.d.a(), TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                new e0.a().a("RejectedExecutionException when scheduling session stop ").a(e.toString()).a(e0.i);
            }
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        new e0.a().a("AdColony session ending, releasing Context.").a(e0.d);
        a.b().c(true);
        a.a((Context) null);
        this.d.f(true);
        this.d.g(true);
        this.d.j();
        if (a.b().r().f()) {
            ScheduledFuture<?> scheduledFuture = this.c;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.c.cancel(false);
            }
            try {
                this.c = this.a.schedule(new b(), 10, TimeUnit.SECONDS);
            } catch (RejectedExecutionException e) {
                new e0.a().a("RejectedExecutionException when scheduling message pumping stop ").a(e.toString()).a(e0.i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        a();
    }

    private void a() {
        ScheduledFuture<?> scheduledFuture = this.b;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.b.cancel(false);
            this.b = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        d();
    }
}
