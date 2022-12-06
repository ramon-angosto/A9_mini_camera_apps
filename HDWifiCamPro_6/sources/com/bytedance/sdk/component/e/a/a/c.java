package com.bytedance.sdk.component.e.a.a;

import android.content.Context;
import com.bytedance.sdk.component.e.a.a.a.a.a;
import com.bytedance.sdk.component.e.a.a.a.a.b;
import com.bytedance.sdk.component.e.a.a.a.a.d;
import com.bytedance.sdk.component.e.a.a.a.a.e;
import com.bytedance.sdk.component.e.a.a.a.a.f;
import com.bytedance.sdk.component.e.a.i;
import java.util.List;

/* compiled from: DBCacheStrategy */
public class c implements d {
    private com.bytedance.sdk.component.e.a.a.a.a.c a;
    private a b;
    private b c;
    private f d;
    private e e;
    private d f;
    private com.bytedance.sdk.component.e.a.d.b.a g;
    private com.bytedance.sdk.component.e.a.d.b.a h;
    private com.bytedance.sdk.component.e.a.d.b.a i;
    private com.bytedance.sdk.component.e.a.d.b.a j;
    private com.bytedance.sdk.component.e.a.d.b.a k;
    private com.bytedance.sdk.component.e.a.d.b.a l;

    public c() {
        Context d2 = i.e().d();
        if (com.bytedance.sdk.component.e.a.b.a.a()) {
            this.g = i.e().i();
            this.a = new com.bytedance.sdk.component.e.a.a.a.a.c(d2, this.g);
        }
        if (com.bytedance.sdk.component.e.a.b.a.b()) {
            this.h = i.e().j();
            this.b = new a(d2, this.h);
        }
        if (com.bytedance.sdk.component.e.a.b.a.e()) {
            this.i = i.e().j();
            this.c = new b(d2, this.i);
        }
        if (com.bytedance.sdk.component.e.a.b.a.c()) {
            this.j = i.e().j();
            this.d = new f(d2, this.j);
        }
        if (com.bytedance.sdk.component.e.a.b.a.d()) {
            this.k = i.e().k();
            this.e = new e(d2, this.k);
        }
        if (com.bytedance.sdk.component.e.a.b.a.f()) {
            this.l = i.e().l();
            this.f = new d(d2, this.l);
        }
    }

    public void a(com.bytedance.sdk.component.e.a.d.a aVar, int i2) {
        if (aVar != null) {
            try {
                aVar.b(System.currentTimeMillis());
                if (aVar.d() == 0 && aVar.e() == 1) {
                    if (com.bytedance.sdk.component.e.a.b.a.a()) {
                        this.a.a(aVar);
                    }
                } else if (aVar.d() == 0 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.b()) {
                        this.b.a(aVar);
                    }
                } else if (aVar.d() == 3 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.e()) {
                        this.c.a(aVar);
                    }
                } else if (aVar.d() == 1 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.c()) {
                        this.d.a(aVar);
                    }
                } else if (aVar.d() == 1 && aVar.e() == 3) {
                    if (com.bytedance.sdk.component.e.a.b.a.d()) {
                        this.e.a(aVar);
                    }
                } else if (aVar.d() == 2 && aVar.e() == 3 && com.bytedance.sdk.component.e.a.b.a.f()) {
                    this.f.a(aVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.G(), 1);
            }
        }
    }

    public void a(int i2, List<com.bytedance.sdk.component.e.a.d.a> list) {
        com.bytedance.sdk.component.e.a.c.c.a("dbCache handleResult start");
        if (!(list == null || list.size() == 0 || list.get(0) == null)) {
            com.bytedance.sdk.component.e.a.d.a aVar = list.get(0);
            if (i2 == 200 || i2 == -1) {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.X(), list.size());
                if (i2 != 200) {
                    com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.Z(), list.size());
                }
                if (aVar.d() == 0 && aVar.e() == 1) {
                    if (com.bytedance.sdk.component.e.a.b.a.a()) {
                        this.a.b(list);
                    }
                } else if (aVar.d() == 0 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.b()) {
                        this.b.b(list);
                    }
                } else if (aVar.d() == 3 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.e()) {
                        this.c.b(list);
                    }
                } else if (aVar.d() == 1 && aVar.e() == 2) {
                    if (com.bytedance.sdk.component.e.a.b.a.c()) {
                        this.d.b(list);
                    }
                } else if (aVar.d() == 1 && aVar.e() == 3) {
                    if (com.bytedance.sdk.component.e.a.b.a.d()) {
                        this.e.b(list);
                    }
                } else if (aVar.d() == 2 && aVar.e() == 3 && com.bytedance.sdk.component.e.a.b.a.f()) {
                    this.f.b(list);
                }
            }
        }
        com.bytedance.sdk.component.e.a.c.c.a("dbCache handleResult end");
    }

    public List<com.bytedance.sdk.component.e.a.d.a> b(com.bytedance.sdk.component.e.a.d.a aVar, int i2) {
        if (aVar.d() != 0 || aVar.e() != 1 || !com.bytedance.sdk.component.e.a.b.a.a()) {
            if (aVar.d() == 0 && aVar.e() == 2 && com.bytedance.sdk.component.e.a.b.a.b()) {
                if (this.h.b() > i2) {
                    List<com.bytedance.sdk.component.e.a.d.a> a2 = this.b.a(this.h.b() - i2, "_id");
                    if (!(a2 == null || a2.size() == 0)) {
                        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.B(), 1);
                    }
                    return a2;
                }
            } else if (aVar.d() == 3 && aVar.e() == 2 && com.bytedance.sdk.component.e.a.b.a.e()) {
                if (this.i.b() > i2) {
                    return this.c.a(this.i.b() - i2, "_id");
                }
            } else if (aVar.d() == 1 && aVar.e() == 2 && com.bytedance.sdk.component.e.a.b.a.c()) {
                if (this.j.b() > i2) {
                    List<com.bytedance.sdk.component.e.a.d.a> a3 = this.d.a(this.j.b() - i2, "_id");
                    if (!(a3 == null || a3.size() == 0)) {
                        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.C(), 1);
                    }
                    return a3;
                }
            } else if (aVar.d() == 1 && aVar.e() == 3 && com.bytedance.sdk.component.e.a.b.a.d()) {
                if (this.k.b() > i2) {
                    List<com.bytedance.sdk.component.e.a.d.a> a4 = this.e.a(this.k.b() - i2, "_id");
                    if (!(a4 == null || a4.size() == 0)) {
                        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.D(), 1);
                    }
                    return a4;
                }
            } else if (aVar.d() == 2 && aVar.e() == 3 && com.bytedance.sdk.component.e.a.b.a.f() && this.l.b() > i2) {
                return this.f.a(this.l.b() - i2, "_id");
            }
            return null;
        } else if (this.g.b() <= i2) {
            return null;
        } else {
            List<com.bytedance.sdk.component.e.a.d.a> a5 = this.a.a(this.g.b() - i2, "_id");
            if (!(a5 == null || a5.size() == 0)) {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.A(), 1);
            }
            return a5;
        }
    }

    public List<com.bytedance.sdk.component.e.a.d.a> a(int i2, int i3) {
        List<com.bytedance.sdk.component.e.a.d.a> a2;
        List<com.bytedance.sdk.component.e.a.d.a> a3;
        List<com.bytedance.sdk.component.e.a.d.a> a4;
        List<com.bytedance.sdk.component.e.a.d.a> a5;
        List<com.bytedance.sdk.component.e.a.d.a> a6;
        List<com.bytedance.sdk.component.e.a.d.a> a7;
        if (com.bytedance.sdk.component.e.a.b.a.a() && (a7 = this.a.a("_id")) != null && a7.size() != 0) {
            com.bytedance.sdk.component.e.a.c.c.a("high db list size:" + a7.size());
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.w(), 1);
            return a7;
        } else if (com.bytedance.sdk.component.e.a.b.a.b() && (a6 = this.b.a("_id")) != null && a6.size() != 0) {
            com.bytedance.sdk.component.e.a.c.c.a("realad db list size:" + a6.size());
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.x(), 1);
            return a6;
        } else if (com.bytedance.sdk.component.e.a.b.a.e() && (a5 = this.c.a("_id")) != null && a5.size() != 0) {
            com.bytedance.sdk.component.e.a.c.c.a("v3ad db list size:" + a5.size());
            return a5;
        } else if (com.bytedance.sdk.component.e.a.b.a.c() && (a4 = this.d.a("_id")) != null && a4.size() != 0) {
            com.bytedance.sdk.component.e.a.c.c.a("real stats db list size:" + a4.size());
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.y(), 1);
            return a4;
        } else if (com.bytedance.sdk.component.e.a.b.a.d() && (a3 = this.e.a("_id")) != null && a3.size() != 0) {
            com.bytedance.sdk.component.e.a.c.c.a("batch db list size:" + a3.size());
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.z(), 1);
            return a3;
        } else if (!com.bytedance.sdk.component.e.a.b.a.f() || (a2 = this.f.a("_id")) == null || a2.size() == 0) {
            return null;
        } else {
            com.bytedance.sdk.component.e.a.c.c.a("other db list size:" + a2.size());
            return a2;
        }
    }

    public boolean a(int i2, boolean z) {
        d dVar;
        e eVar;
        f fVar;
        b bVar;
        a aVar;
        com.bytedance.sdk.component.e.a.a.a.a.c cVar;
        if (com.bytedance.sdk.component.e.a.b.a.a() && (cVar = this.a) != null && cVar.a(i2)) {
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.n(), 1);
            return true;
        } else if (com.bytedance.sdk.component.e.a.b.a.b() && (aVar = this.b) != null && aVar.a(i2)) {
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.o(), 1);
            return true;
        } else if (com.bytedance.sdk.component.e.a.b.a.e() && (bVar = this.c) != null && bVar.a(i2)) {
            return true;
        } else {
            if (com.bytedance.sdk.component.e.a.b.a.c() && (fVar = this.d) != null && fVar.a(i2)) {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.p(), 1);
                return true;
            } else if (com.bytedance.sdk.component.e.a.b.a.d() && (eVar = this.e) != null && eVar.a(i2)) {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.q(), 1);
                return true;
            } else if (!com.bytedance.sdk.component.e.a.b.a.f() || (dVar = this.f) == null || !dVar.a(i2)) {
                return false;
            } else {
                return true;
            }
        }
    }
}
