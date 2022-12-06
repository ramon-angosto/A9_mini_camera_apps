package com.meizu.cloud.pushsdk.a.f;

import com.meizu.cloud.pushsdk.a.a.a;
import com.meizu.cloud.pushsdk.a.a.b;
import com.meizu.cloud.pushsdk.a.a.d;
import com.meizu.cloud.pushsdk.a.a.e;
import com.meizu.cloud.pushsdk.a.d.k;

public class c implements Runnable {
    public final int a;
    public final b b;
    private final d c;

    public c(b bVar) {
        this.b = bVar;
        this.a = bVar.f();
        this.c = bVar.d();
    }

    public void run() {
        a.a("execution started : " + this.b.toString());
        int h = this.b.h();
        if (h == 0) {
            b();
        } else if (h == 1) {
            c();
        } else if (h == 2) {
            d();
        }
        a.a("execution done : " + this.b.toString());
    }

    private void b() {
        k kVar = null;
        try {
            kVar = b.a(this.b);
            if (kVar == null) {
                a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a()));
            } else if (this.b.g() == e.OK_HTTP_RESPONSE) {
                this.b.b(kVar);
            } else if (kVar.a() >= 400) {
                a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(kVar), this.b, kVar.a()));
            } else {
                com.meizu.cloud.pushsdk.a.a.c a2 = this.b.a(kVar);
                if (!a2.b()) {
                    a(this.b, a2.c());
                } else {
                    a2.a(kVar);
                    this.b.a(a2);
                    com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                    return;
                }
            }
            com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
        } catch (Exception e) {
            a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a((Throwable) e)));
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
            throw th;
        }
    }

    private void c() {
        try {
            k b2 = b.b(this.b);
            if (b2 == null) {
                a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a()));
            } else if (b2.a() >= 400) {
                a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(b2), this.b, b2.a()));
            } else {
                this.b.j();
            }
        } catch (Exception e) {
            a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a((Throwable) e)));
        }
    }

    private void d() {
        k kVar = null;
        try {
            kVar = b.c(this.b);
            if (kVar == null) {
                a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a()));
            } else if (this.b.g() == e.OK_HTTP_RESPONSE) {
                this.b.b(kVar);
            } else if (kVar.a() >= 400) {
                a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a(kVar), this.b, kVar.a()));
            } else {
                com.meizu.cloud.pushsdk.a.a.c a2 = this.b.a(kVar);
                if (!a2.b()) {
                    a(this.b, a2.c());
                } else {
                    a2.a(kVar);
                    this.b.a(a2);
                    com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
                    return;
                }
            }
            com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
        } catch (Exception e) {
            a(this.b, com.meizu.cloud.pushsdk.a.i.b.a(new com.meizu.cloud.pushsdk.a.c.a((Throwable) e)));
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.a.i.a.a(kVar, this.b);
            throw th;
        }
    }

    public d a() {
        return this.c;
    }

    private void a(final b bVar, final com.meizu.cloud.pushsdk.a.c.a aVar) {
        com.meizu.cloud.pushsdk.a.b.b.a().b().c().execute(new Runnable() {
            public void run() {
                bVar.b(aVar);
                bVar.p();
            }
        });
    }
}
