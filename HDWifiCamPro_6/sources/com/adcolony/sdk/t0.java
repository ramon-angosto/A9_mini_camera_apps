package com.adcolony.sdk;

import android.os.SystemClock;
import com.adcolony.sdk.e0;
import java.util.LinkedHashMap;

class t0 {
    private long a = 1800000;
    private int b;
    private long c;
    private boolean d = true;
    private boolean e = true;
    private boolean f;
    /* access modifiers changed from: private */
    public boolean g = false;
    /* access modifiers changed from: private */
    public boolean h = false;
    private boolean i;
    /* access modifiers changed from: private */
    public boolean j;
    private boolean k;
    private u0 l;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            boolean unused = t0.this.j = true;
        }
    }

    class b implements Runnable {
        final /* synthetic */ l a;
        final /* synthetic */ k b;

        b(t0 t0Var, l lVar, k kVar) {
            this.a = lVar;
            this.b = kVar;
        }

        public void run() {
            this.a.b();
            this.b.q().d();
        }
    }

    class c implements Runnable {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        public void run() {
            LinkedHashMap<Integer, k0> d = a.b().r().d();
            synchronized (d) {
                for (k0 next : d.values()) {
                    f1 b2 = c0.b();
                    c0.b(b2, "from_window_focus", this.a);
                    if (t0.this.h && !t0.this.g) {
                        c0.b(b2, "app_in_foreground", false);
                        boolean unused = t0.this.h = false;
                    }
                    new h0("SessionInfo.on_pause", next.getModuleId(), b2).c();
                }
            }
            a.f();
        }
    }

    class d implements Runnable {
        final /* synthetic */ boolean a;

        d(boolean z) {
            this.a = z;
        }

        public void run() {
            k b2 = a.b();
            LinkedHashMap<Integer, k0> d = b2.r().d();
            synchronized (d) {
                for (k0 next : d.values()) {
                    f1 b3 = c0.b();
                    c0.b(b3, "from_window_focus", this.a);
                    if (t0.this.h && t0.this.g) {
                        c0.b(b3, "app_in_foreground", true);
                        boolean unused = t0.this.h = false;
                    }
                    new h0("SessionInfo.on_resume", next.getModuleId(), b3).c();
                }
            }
            b2.q().d();
        }
    }

    t0() {
    }

    private void h() {
        a(false);
    }

    private void i() {
        b(false);
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z) {
        k b2 = a.b();
        if (!this.f) {
            if (this.i) {
                b2.c(false);
                this.i = false;
            }
            this.b = 0;
            this.c = SystemClock.uptimeMillis();
            this.d = true;
            this.f = true;
            this.g = true;
            this.h = false;
            AdColony.c();
            if (z) {
                f1 b3 = c0.b();
                c0.a(b3, "id", z0.a());
                new h0("SessionInfo.on_start", 1, b3).c();
                l c2 = a.b().r().c();
                if (c2 != null && !AdColony.a((Runnable) new b(this, c2, b2))) {
                    new e0.a().a("RejectedExecutionException on controller update.").a(e0.i);
                }
            }
            b2.r().h();
            v.a().b();
        }
    }

    public void d() {
        a.a("SessionInfo.stopped", (j0) new a());
        this.l = new u0(this);
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.d;
    }

    public void f(boolean z) {
        this.i = z;
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z) {
        this.k = z;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        s0 a2 = a.b().q().a();
        this.f = false;
        this.d = false;
        if (a2 != null) {
            a2.b();
        }
        f1 b2 = c0.b();
        c0.a(b2, "session_length", ((double) (SystemClock.uptimeMillis() - this.c)) / 1000.0d);
        new h0("SessionInfo.on_stop", 1, b2).c();
        a.f();
        AdColony.g();
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z) {
        if (this.g != z) {
            this.g = z;
            this.h = true;
            if (!z) {
                h();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.e = true;
        this.l.b();
        if (!AdColony.a((Runnable) new c(z))) {
            new e0.a().a("RejectedExecutionException on session pause.").a(e0.i);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        this.e = false;
        this.l.c();
        if (!AdColony.a((Runnable) new d(z))) {
            new e0.a().a("RejectedExecutionException on session resume.").a(e0.i);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(boolean z) {
        if (z && this.e) {
            i();
        } else if (!z && !this.e) {
            h();
        }
        this.d = z;
    }

    /* access modifiers changed from: package-private */
    public long a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.a = i2 <= 0 ? this.a : (long) (i2 * 1000);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.b++;
    }
}
