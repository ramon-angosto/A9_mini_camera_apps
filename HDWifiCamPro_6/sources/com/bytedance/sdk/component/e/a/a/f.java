package com.bytedance.sdk.component.e.a.a;

import com.bytedance.sdk.component.e.a.a.b.a;
import com.bytedance.sdk.component.e.a.a.b.b;
import com.bytedance.sdk.component.e.a.a.b.c;
import com.bytedance.sdk.component.e.a.a.b.e;
import com.bytedance.sdk.component.e.a.a.b.g;
import com.bytedance.sdk.component.e.a.b.d;
import com.bytedance.sdk.component.e.a.i;
import java.util.List;
import java.util.Queue;

/* compiled from: RealTimeMemoryCacheStrategy */
public class f implements d {
    e a = i.e().b();
    private e b;
    private a c;
    private b d;
    private g e;
    private c f;
    private com.bytedance.sdk.component.e.a.a.b.f g;
    private com.bytedance.sdk.component.e.a.d.b.a h;
    private com.bytedance.sdk.component.e.a.d.b.a i;
    private com.bytedance.sdk.component.e.a.d.b.a j;
    private com.bytedance.sdk.component.e.a.d.b.a k;
    private com.bytedance.sdk.component.e.a.d.b.a l;
    private com.bytedance.sdk.component.e.a.d.b.a m;
    private Queue<String> n;

    public f(Queue<String> queue) {
        this.n = queue;
        if (com.bytedance.sdk.component.e.a.b.a.a()) {
            this.h = i.e().i();
            this.b = new e(this.h, queue);
        }
        if (com.bytedance.sdk.component.e.a.b.a.b()) {
            this.i = i.e().j();
            this.c = new a(this.i, queue);
        }
        if (com.bytedance.sdk.component.e.a.b.a.e()) {
            this.j = i.e().j();
            this.d = new b(this.j, queue);
        }
        if (com.bytedance.sdk.component.e.a.b.a.c()) {
            this.k = i.e().j();
            this.e = new g(this.k, queue);
        }
        if (com.bytedance.sdk.component.e.a.b.a.d()) {
            this.l = i.e().k();
            this.f = new c(this.l, queue);
        }
        if (com.bytedance.sdk.component.e.a.b.a.f()) {
            this.m = i.e().l();
            this.g = new com.bytedance.sdk.component.e.a.a.b.f(this.m, queue);
        }
    }

    public void a(com.bytedance.sdk.component.e.a.d.a aVar, int i2) {
        try {
            byte d2 = aVar.d();
            byte e2 = aVar.e();
            if (d2 == 0 && e2 == 1 && com.bytedance.sdk.component.e.a.b.a.a()) {
                this.b.a(aVar);
            } else if (d2 == 0 && e2 == 2 && com.bytedance.sdk.component.e.a.b.a.b()) {
                this.c.a(aVar);
            } else if (d2 == 3 && e2 == 2 && com.bytedance.sdk.component.e.a.b.a.e()) {
                this.d.a(aVar);
            } else if (d2 == 1 && e2 == 2 && com.bytedance.sdk.component.e.a.b.a.c()) {
                this.e.a(aVar);
            } else if (d2 == 1 && e2 == 3 && com.bytedance.sdk.component.e.a.b.a.d()) {
                this.f.a(aVar);
            } else if (d2 == 2 && e2 == 3 && com.bytedance.sdk.component.e.a.b.a.f()) {
                this.g.a(aVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(int i2, List<com.bytedance.sdk.component.e.a.d.a> list) {
        if (list != null && list.size() != 0 && list.get(0) != null) {
            com.bytedance.sdk.component.e.a.d.a aVar = list.get(0);
            byte e2 = aVar.e();
            byte d2 = aVar.d();
            if (d2 == 0 && e2 == 1 && com.bytedance.sdk.component.e.a.b.a.a()) {
                this.b.a(i2, list);
            } else if (d2 == 0 && e2 == 2 && com.bytedance.sdk.component.e.a.b.a.b()) {
                this.c.a(i2, list);
            } else if (d2 == 3 && e2 == 2 && com.bytedance.sdk.component.e.a.b.a.e()) {
                this.d.a(i2, list);
            } else if (d2 == 1 && e2 == 2 && com.bytedance.sdk.component.e.a.b.a.c()) {
                this.e.a(i2, list);
            } else if (d2 == 1 && e2 == 3 && com.bytedance.sdk.component.e.a.b.a.d()) {
                this.f.a(i2, list);
            } else if (d2 == 2 && e2 == 3 && com.bytedance.sdk.component.e.a.b.a.f()) {
                this.g.a(i2, list);
            }
        }
    }

    public List<com.bytedance.sdk.component.e.a.d.a> a(int i2, int i3) {
        List<com.bytedance.sdk.component.e.a.d.a> a2;
        List<com.bytedance.sdk.component.e.a.d.a> a3;
        List<com.bytedance.sdk.component.e.a.d.a> a4;
        List<com.bytedance.sdk.component.e.a.d.a> a5;
        List<com.bytedance.sdk.component.e.a.d.a> a6;
        List<com.bytedance.sdk.component.e.a.d.a> a7;
        if (com.bytedance.sdk.component.e.a.b.a.a() && this.b.b(i2, i3) && (a7 = this.b.a(i2, i3)) != null && a7.size() != 0) {
            com.bytedance.sdk.component.e.a.c.b.a(d.d.r(), 1);
            return a7;
        } else if (com.bytedance.sdk.component.e.a.b.a.b() && this.c.b(i2, i3) && (a6 = this.c.a(i2, i3)) != null && a6.size() != 0) {
            com.bytedance.sdk.component.e.a.c.b.a(d.d.s(), 1);
            return a6;
        } else if (com.bytedance.sdk.component.e.a.b.a.e() && this.d.b(i2, i3) && (a5 = this.d.a(i2, i3)) != null && a5.size() != 0) {
            return a5;
        } else {
            if (com.bytedance.sdk.component.e.a.b.a.c() && this.e.b(i2, i3) && (a4 = this.e.a(i2, i3)) != null && a4.size() != 0) {
                com.bytedance.sdk.component.e.a.c.b.a(d.d.t(), 1);
                return a4;
            } else if (com.bytedance.sdk.component.e.a.b.a.d() && this.f.b(i2, i3) && (a3 = this.f.a(i2, i3)) != null && a3.size() != 0) {
                com.bytedance.sdk.component.e.a.c.b.a(d.d.u(), 1);
                return a3;
            } else if (!com.bytedance.sdk.component.e.a.b.a.f() || !this.g.b(i2, i3) || (a2 = this.g.a(i2, i3)) == null || a2.size() == 0) {
                return null;
            } else {
                return a2;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r3 = r1.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r0 = r1.i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        r3 = r1.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        r0 = r1.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
        r3 = r1.e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        r0 = r1.k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = r1.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
        r3 = r1.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
        r0 = r1.l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007e, code lost:
        r3 = r1.g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0082, code lost:
        r0 = r1.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r2, boolean r3) {
        /*
            r1 = this;
            boolean r3 = com.bytedance.sdk.component.e.a.b.a.a()
            if (r3 == 0) goto L_0x0018
            com.bytedance.sdk.component.e.a.a.b.e r3 = r1.b
            if (r3 == 0) goto L_0x0018
            com.bytedance.sdk.component.e.a.d.b.a r0 = r1.h
            if (r0 == 0) goto L_0x0018
            int r0 = r0.a()
            boolean r3 = r3.b(r2, r0)
            if (r3 != 0) goto L_0x0090
        L_0x0018:
            boolean r3 = com.bytedance.sdk.component.e.a.b.a.b()
            if (r3 == 0) goto L_0x0030
            com.bytedance.sdk.component.e.a.a.b.a r3 = r1.c
            if (r3 == 0) goto L_0x0030
            com.bytedance.sdk.component.e.a.d.b.a r0 = r1.i
            if (r0 == 0) goto L_0x0030
            int r0 = r0.a()
            boolean r3 = r3.b(r2, r0)
            if (r3 != 0) goto L_0x0090
        L_0x0030:
            boolean r3 = com.bytedance.sdk.component.e.a.b.a.e()
            if (r3 == 0) goto L_0x0048
            com.bytedance.sdk.component.e.a.a.b.b r3 = r1.d
            if (r3 == 0) goto L_0x0048
            com.bytedance.sdk.component.e.a.d.b.a r0 = r1.j
            if (r0 == 0) goto L_0x0048
            int r0 = r0.a()
            boolean r3 = r3.b(r2, r0)
            if (r3 != 0) goto L_0x0090
        L_0x0048:
            boolean r3 = com.bytedance.sdk.component.e.a.b.a.c()
            if (r3 == 0) goto L_0x0060
            com.bytedance.sdk.component.e.a.a.b.g r3 = r1.e
            if (r3 == 0) goto L_0x0060
            com.bytedance.sdk.component.e.a.d.b.a r0 = r1.k
            if (r0 == 0) goto L_0x0060
            int r0 = r0.a()
            boolean r3 = r3.b(r2, r0)
            if (r3 != 0) goto L_0x0090
        L_0x0060:
            boolean r3 = com.bytedance.sdk.component.e.a.b.a.d()
            if (r3 == 0) goto L_0x0078
            com.bytedance.sdk.component.e.a.a.b.c r3 = r1.f
            if (r3 == 0) goto L_0x0078
            com.bytedance.sdk.component.e.a.d.b.a r0 = r1.l
            if (r0 == 0) goto L_0x0078
            int r0 = r0.a()
            boolean r3 = r3.b(r2, r0)
            if (r3 != 0) goto L_0x0090
        L_0x0078:
            boolean r3 = com.bytedance.sdk.component.e.a.b.a.f()
            if (r3 == 0) goto L_0x0092
            com.bytedance.sdk.component.e.a.a.b.f r3 = r1.g
            if (r3 == 0) goto L_0x0092
            com.bytedance.sdk.component.e.a.d.b.a r0 = r1.m
            if (r0 == 0) goto L_0x0092
            int r0 = r0.a()
            boolean r2 = r3.b(r2, r0)
            if (r2 == 0) goto L_0x0092
        L_0x0090:
            r2 = 1
            goto L_0x0093
        L_0x0092:
            r2 = 0
        L_0x0093:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.f.a(int, boolean):boolean");
    }
}
