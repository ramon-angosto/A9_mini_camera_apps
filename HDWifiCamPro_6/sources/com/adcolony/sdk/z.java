package com.adcolony.sdk;

import com.adcolony.sdk.e0;
import com.adcolony.sdk.z0;
import java.util.Date;

class z {
    private boolean a = true;
    /* access modifiers changed from: private */
    public final Runnable b = new a();
    /* access modifiers changed from: private */
    public Runnable c;
    /* access modifiers changed from: private */
    public c d;

    class a implements Runnable {
        a() {
        }

        public void run() {
            new h0("AdColony.heartbeat", 1).c();
            z.this.c();
        }
    }

    class b implements Runnable {
        final /* synthetic */ z0.c a;

        b(z0.c cVar) {
            this.a = cVar;
        }

        public void run() {
            Runnable unused = z.this.c = null;
            if (a.d()) {
                k b2 = a.b();
                if (this.a.a() && b2.I()) {
                    b2.a();
                    e0.a a2 = new e0.a().a("Controller heartbeat timeout occurred. ");
                    e0.a a3 = a2.a("Timeout set to: " + this.a.b() + " ms. ");
                    a3.a("Interval set to: " + b2.h() + " ms. ").a("Heartbeat last reply: ").a((Object) z.this.d).a(e0.i);
                    z.this.a();
                } else if (b2.F()) {
                    z.this.a();
                } else {
                    z0.a(z.this.b, b2.h());
                }
            }
        }
    }

    private static class c {
        private final f1 a;

        /* synthetic */ c(f1 f1Var, a aVar) {
            this(f1Var);
        }

        public String toString() {
            return this.a.toString();
        }

        private c(f1 f1Var) {
            f1 m = f1Var != null ? f1Var.m("payload") : c0.b();
            this.a = m;
            c0.a(m, "heartbeatLastTimestamp", f0.e.format(new Date()));
        }
    }

    z() {
    }

    /* access modifiers changed from: private */
    public void c() {
        if (a.d()) {
            z0.c cVar = new z0.c(a.b().i());
            b bVar = new b(cVar);
            this.c = bVar;
            z0.a((Runnable) bVar, cVar.d());
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a();
        this.a = false;
        z0.a(this.b, a.b().h());
    }

    /* access modifiers changed from: private */
    public void a() {
        this.a = true;
        z0.c(this.b);
        z0.c(this.c);
        this.c = null;
    }

    /* access modifiers changed from: package-private */
    public void a(h0 h0Var) {
        if (a.d() && !this.a) {
            this.d = new c(h0Var.a(), (a) null);
            Runnable runnable = this.c;
            if (runnable != null) {
                z0.c(runnable);
                z0.b(this.c);
                return;
            }
            z0.c(this.b);
            z0.a(this.b, a.b().h());
        }
    }
}
