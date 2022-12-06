package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.iu */
public class C1901iu implements C1906iz<C1901iu, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3412a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f3413a = new C1925jp("XmPushActionUnRegistration");

    /* renamed from: b */
    private static final C1917jh f3414b = new C1917jh("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1917jh f3415c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3416d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3417e = new C1917jh("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1917jh f3418f = new C1917jh("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1917jh f3419g = new C1917jh("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1917jh f3420h = new C1917jh("", (byte) 11, 8);

    /* renamed from: i */
    private static final C1917jh f3421i = new C1917jh("", (byte) 11, 9);

    /* renamed from: j */
    private static final C1917jh f3422j = new C1917jh("", (byte) 11, 10);

    /* renamed from: k */
    private static final C1917jh f3423k = new C1917jh("", (byte) 2, 11);

    /* renamed from: l */
    private static final C1917jh f3424l = new C1917jh("", (byte) 10, 12);

    /* renamed from: a */
    public long f3425a;

    /* renamed from: a */
    public C1884id f3426a;

    /* renamed from: a */
    public String f3427a;

    /* renamed from: a */
    private BitSet f3428a = new BitSet(2);

    /* renamed from: a */
    public boolean f3429a = true;

    /* renamed from: b */
    public String f3430b;

    /* renamed from: c */
    public String f3431c;

    /* renamed from: d */
    public String f3432d;

    /* renamed from: e */
    public String f3433e;

    /* renamed from: f */
    public String f3434f;

    /* renamed from: g */
    public String f3435g;

    /* renamed from: h */
    public String f3436h;

    /* renamed from: i */
    public String f3437i;

    /* renamed from: a */
    public int compareTo(C1901iu iuVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        if (!getClass().equals(iuVar.getClass())) {
            return getClass().getName().compareTo(iuVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18256a()).compareTo(Boolean.valueOf(iuVar.mo18256a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18256a() && (a12 = C1908ja.m4589a(this.f3427a, iuVar.f3427a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(mo18260b()).compareTo(Boolean.valueOf(iuVar.mo18260b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo18260b() && (a11 = C1908ja.m4588a((Comparable) this.f3426a, (Comparable) iuVar.f3426a)) != 0) {
            return a11;
        }
        int compareTo3 = Boolean.valueOf(mo18262c()).compareTo(Boolean.valueOf(iuVar.mo18262c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo18262c() && (a10 = C1908ja.m4589a(this.f3430b, iuVar.f3430b)) != 0) {
            return a10;
        }
        int compareTo4 = Boolean.valueOf(mo18265d()).compareTo(Boolean.valueOf(iuVar.mo18265d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo18265d() && (a9 = C1908ja.m4589a(this.f3431c, iuVar.f3431c)) != 0) {
            return a9;
        }
        int compareTo5 = Boolean.valueOf(mo18267e()).compareTo(Boolean.valueOf(iuVar.mo18267e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo18267e() && (a8 = C1908ja.m4589a(this.f3432d, iuVar.f3432d)) != 0) {
            return a8;
        }
        int compareTo6 = Boolean.valueOf(mo18269f()).compareTo(Boolean.valueOf(iuVar.mo18269f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo18269f() && (a7 = C1908ja.m4589a(this.f3433e, iuVar.f3433e)) != 0) {
            return a7;
        }
        int compareTo7 = Boolean.valueOf(mo18270g()).compareTo(Boolean.valueOf(iuVar.mo18270g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo18270g() && (a6 = C1908ja.m4589a(this.f3434f, iuVar.f3434f)) != 0) {
            return a6;
        }
        int compareTo8 = Boolean.valueOf(mo18271h()).compareTo(Boolean.valueOf(iuVar.mo18271h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo18271h() && (a5 = C1908ja.m4589a(this.f3435g, iuVar.f3435g)) != 0) {
            return a5;
        }
        int compareTo9 = Boolean.valueOf(mo18273i()).compareTo(Boolean.valueOf(iuVar.mo18273i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo18273i() && (a4 = C1908ja.m4589a(this.f3436h, iuVar.f3436h)) != 0) {
            return a4;
        }
        int compareTo10 = Boolean.valueOf(mo18274j()).compareTo(Boolean.valueOf(iuVar.mo18274j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (mo18274j() && (a3 = C1908ja.m4589a(this.f3437i, iuVar.f3437i)) != 0) {
            return a3;
        }
        int compareTo11 = Boolean.valueOf(mo18275k()).compareTo(Boolean.valueOf(iuVar.mo18275k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (mo18275k() && (a2 = C1908ja.m4595a(this.f3429a, iuVar.f3429a)) != 0) {
            return a2;
        }
        int compareTo12 = Boolean.valueOf(mo18276l()).compareTo(Boolean.valueOf(iuVar.mo18276l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!mo18276l() || (a = C1908ja.m4587a(this.f3425a, iuVar.f3425a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1901iu mo18255a(String str) {
        this.f3430b = str;
        return this;
    }

    /* renamed from: a */
    public void mo18256a() {
        if (this.f3430b == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3431c == null) {
            throw new C1921jl("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17579a(com.xiaomi.push.C1920jk r5) {
        /*
            r4 = this;
            r5.mo18332a()
        L_0x0003:
            com.xiaomi.push.jh r0 = r5.mo18332a()
            byte r1 = r0.f3526a
            if (r1 != 0) goto L_0x0012
            r5.mo18350f()
            r4.mo18256a()
            return
        L_0x0012:
            short r1 = r0.f3528a
            r2 = 1
            r3 = 11
            switch(r1) {
                case 1: goto L_0x00ae;
                case 2: goto L_0x009b;
                case 3: goto L_0x0090;
                case 4: goto L_0x0085;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x0064;
                case 8: goto L_0x0059;
                case 9: goto L_0x004e;
                case 10: goto L_0x0042;
                case 11: goto L_0x0032;
                case 12: goto L_0x0021;
                default: goto L_0x001a;
            }
        L_0x001a:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r5, r0)
            goto L_0x00b8
        L_0x0021:
            byte r1 = r0.f3526a
            r3 = 10
            if (r1 != r3) goto L_0x001a
            long r0 = r5.mo18332a()
            r4.f3425a = r0
            r4.mo18259b((boolean) r2)
            goto L_0x00b8
        L_0x0032:
            byte r1 = r0.f3526a
            r3 = 2
            if (r1 != r3) goto L_0x001a
            boolean r0 = r5.mo18332a()
            r4.f3429a = r0
            r4.mo18257a((boolean) r2)
            goto L_0x00b8
        L_0x0042:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001a
            java.lang.String r0 = r5.mo18332a()
            r4.f3437i = r0
            goto L_0x00b8
        L_0x004e:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001a
            java.lang.String r0 = r5.mo18332a()
            r4.f3436h = r0
            goto L_0x00b8
        L_0x0059:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001a
            java.lang.String r0 = r5.mo18332a()
            r4.f3435g = r0
            goto L_0x00b8
        L_0x0064:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001a
            java.lang.String r0 = r5.mo18332a()
            r4.f3434f = r0
            goto L_0x00b8
        L_0x006f:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001a
            java.lang.String r0 = r5.mo18332a()
            r4.f3433e = r0
            goto L_0x00b8
        L_0x007a:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001a
            java.lang.String r0 = r5.mo18332a()
            r4.f3432d = r0
            goto L_0x00b8
        L_0x0085:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001a
            java.lang.String r0 = r5.mo18332a()
            r4.f3431c = r0
            goto L_0x00b8
        L_0x0090:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001a
            java.lang.String r0 = r5.mo18332a()
            r4.f3430b = r0
            goto L_0x00b8
        L_0x009b:
            byte r1 = r0.f3526a
            r2 = 12
            if (r1 != r2) goto L_0x001a
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r4.f3426a = r0
            com.xiaomi.push.id r0 = r4.f3426a
            r0.mo17579a((com.xiaomi.push.C1920jk) r5)
            goto L_0x00b8
        L_0x00ae:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001a
            java.lang.String r0 = r5.mo18332a()
            r4.f3427a = r0
        L_0x00b8:
            r5.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1901iu.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo18257a(boolean z) {
        this.f3428a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4468a() {
        return this.f3427a != null;
    }

    /* renamed from: a */
    public boolean m4469a(C1901iu iuVar) {
        if (iuVar == null) {
            return false;
        }
        boolean a = mo18256a();
        boolean a2 = iuVar.mo18256a();
        if ((a || a2) && (!a || !a2 || !this.f3427a.equals(iuVar.f3427a))) {
            return false;
        }
        boolean b = mo18260b();
        boolean b2 = iuVar.mo18260b();
        if ((b || b2) && (!b || !b2 || !this.f3426a.compareTo(iuVar.f3426a))) {
            return false;
        }
        boolean c = mo18262c();
        boolean c2 = iuVar.mo18262c();
        if ((c || c2) && (!c || !c2 || !this.f3430b.equals(iuVar.f3430b))) {
            return false;
        }
        boolean d = mo18265d();
        boolean d2 = iuVar.mo18265d();
        if ((d || d2) && (!d || !d2 || !this.f3431c.equals(iuVar.f3431c))) {
            return false;
        }
        boolean e = mo18267e();
        boolean e2 = iuVar.mo18267e();
        if ((e || e2) && (!e || !e2 || !this.f3432d.equals(iuVar.f3432d))) {
            return false;
        }
        boolean f = mo18269f();
        boolean f2 = iuVar.mo18269f();
        if ((f || f2) && (!f || !f2 || !this.f3433e.equals(iuVar.f3433e))) {
            return false;
        }
        boolean g = mo18270g();
        boolean g2 = iuVar.mo18270g();
        if ((g || g2) && (!g || !g2 || !this.f3434f.equals(iuVar.f3434f))) {
            return false;
        }
        boolean h = mo18271h();
        boolean h2 = iuVar.mo18271h();
        if ((h || h2) && (!h || !h2 || !this.f3435g.equals(iuVar.f3435g))) {
            return false;
        }
        boolean i = mo18273i();
        boolean i2 = iuVar.mo18273i();
        if ((i || i2) && (!i || !i2 || !this.f3436h.equals(iuVar.f3436h))) {
            return false;
        }
        boolean j = mo18274j();
        boolean j2 = iuVar.mo18274j();
        if ((j || j2) && (!j || !j2 || !this.f3437i.equals(iuVar.f3437i))) {
            return false;
        }
        boolean k = mo18275k();
        boolean k2 = iuVar.mo18275k();
        if ((k || k2) && (!k || !k2 || this.f3429a != iuVar.f3429a)) {
            return false;
        }
        boolean l = mo18276l();
        boolean l2 = iuVar.mo18276l();
        if (l || l2) {
            return l && l2 && this.f3425a == iuVar.f3425a;
        }
        return true;
    }

    /* renamed from: b */
    public C1901iu mo18258b(String str) {
        this.f3431c = str;
        return this;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18256a();
        jkVar.mo18339a(f3413a);
        if (this.f3427a != null && mo18256a()) {
            jkVar.mo18336a(f3412a);
            jkVar.mo18340a(this.f3427a);
            jkVar.mo18344b();
        }
        if (this.f3426a != null && mo18260b()) {
            jkVar.mo18336a(f3414b);
            this.f3426a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3430b != null) {
            jkVar.mo18336a(f3415c);
            jkVar.mo18340a(this.f3430b);
            jkVar.mo18344b();
        }
        if (this.f3431c != null) {
            jkVar.mo18336a(f3416d);
            jkVar.mo18340a(this.f3431c);
            jkVar.mo18344b();
        }
        if (this.f3432d != null && mo18267e()) {
            jkVar.mo18336a(f3417e);
            jkVar.mo18340a(this.f3432d);
            jkVar.mo18344b();
        }
        if (this.f3433e != null && mo18269f()) {
            jkVar.mo18336a(f3418f);
            jkVar.mo18340a(this.f3433e);
            jkVar.mo18344b();
        }
        if (this.f3434f != null && mo18270g()) {
            jkVar.mo18336a(f3419g);
            jkVar.mo18340a(this.f3434f);
            jkVar.mo18344b();
        }
        if (this.f3435g != null && mo18271h()) {
            jkVar.mo18336a(f3420h);
            jkVar.mo18340a(this.f3435g);
            jkVar.mo18344b();
        }
        if (this.f3436h != null && mo18273i()) {
            jkVar.mo18336a(f3421i);
            jkVar.mo18340a(this.f3436h);
            jkVar.mo18344b();
        }
        if (this.f3437i != null && mo18274j()) {
            jkVar.mo18336a(f3422j);
            jkVar.mo18340a(this.f3437i);
            jkVar.mo18344b();
        }
        if (mo18275k()) {
            jkVar.mo18336a(f3423k);
            jkVar.mo18343a(this.f3429a);
            jkVar.mo18344b();
        }
        if (mo18276l()) {
            jkVar.mo18336a(f3424l);
            jkVar.mo18335a(this.f3425a);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo18259b(boolean z) {
        this.f3428a.set(1, z);
    }

    /* renamed from: b */
    public boolean mo18260b() {
        return this.f3426a != null;
    }

    /* renamed from: c */
    public C1901iu mo18261c(String str) {
        this.f3432d = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo18262c() {
        return this.f3430b != null;
    }

    /* renamed from: d */
    public C1901iu mo18264d(String str) {
        this.f3434f = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo18265d() {
        return this.f3431c != null;
    }

    /* renamed from: e */
    public C1901iu mo18266e(String str) {
        this.f3435g = str;
        return this;
    }

    /* renamed from: e */
    public boolean mo18267e() {
        return this.f3432d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1901iu)) {
            return compareTo((C1901iu) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo18269f() {
        return this.f3433e != null;
    }

    /* renamed from: g */
    public boolean mo18270g() {
        return this.f3434f != null;
    }

    /* renamed from: h */
    public boolean mo18271h() {
        return this.f3435g != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo18273i() {
        return this.f3436h != null;
    }

    /* renamed from: j */
    public boolean mo18274j() {
        return this.f3437i != null;
    }

    /* renamed from: k */
    public boolean mo18275k() {
        return this.f3428a.get(0);
    }

    /* renamed from: l */
    public boolean mo18276l() {
        return this.f3428a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        if (mo18256a()) {
            sb.append("debug:");
            String str = this.f3427a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (mo18260b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1884id idVar = this.f3426a;
            if (idVar == null) {
                sb.append("null");
            } else {
                sb.append(idVar);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f3430b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f3431c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (mo18267e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f3432d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo18269f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f3433e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo18270g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f3434f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (mo18271h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f3435g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (mo18273i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f3436h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (mo18274j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f3437i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (mo18275k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f3429a);
        }
        if (mo18276l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f3425a);
        }
        sb.append(")");
        return sb.toString();
    }
}
