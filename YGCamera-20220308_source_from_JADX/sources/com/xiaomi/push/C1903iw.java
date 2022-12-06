package com.xiaomi.push;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.xiaomi.push.iw */
public class C1903iw implements C1906iz<C1903iw, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3458a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f3459a = new C1925jp("XmPushActionUnSubscription");

    /* renamed from: b */
    private static final C1917jh f3460b = new C1917jh("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1917jh f3461c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3462d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3463e = new C1917jh("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1917jh f3464f = new C1917jh("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1917jh f3465g = new C1917jh("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1917jh f3466h = new C1917jh("", (byte) 15, 8);

    /* renamed from: a */
    public C1884id f3467a;

    /* renamed from: a */
    public String f3468a;

    /* renamed from: a */
    public List<String> f3469a;

    /* renamed from: b */
    public String f3470b;

    /* renamed from: c */
    public String f3471c;

    /* renamed from: d */
    public String f3472d;

    /* renamed from: e */
    public String f3473e;

    /* renamed from: f */
    public String f3474f;

    /* renamed from: a */
    public int compareTo(C1903iw iwVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(iwVar.getClass())) {
            return getClass().getName().compareTo(iwVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18297a()).compareTo(Boolean.valueOf(iwVar.mo18297a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18297a() && (a8 = C1908ja.m4589a(this.f3468a, iwVar.f3468a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(mo18299b()).compareTo(Boolean.valueOf(iwVar.mo18299b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo18299b() && (a7 = C1908ja.m4588a((Comparable) this.f3467a, (Comparable) iwVar.f3467a)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(mo18301c()).compareTo(Boolean.valueOf(iwVar.mo18301c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo18301c() && (a6 = C1908ja.m4589a(this.f3470b, iwVar.f3470b)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(mo18304d()).compareTo(Boolean.valueOf(iwVar.mo18304d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo18304d() && (a5 = C1908ja.m4589a(this.f3471c, iwVar.f3471c)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(mo18306e()).compareTo(Boolean.valueOf(iwVar.mo18306e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo18306e() && (a4 = C1908ja.m4589a(this.f3472d, iwVar.f3472d)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(mo18308f()).compareTo(Boolean.valueOf(iwVar.mo18308f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo18308f() && (a3 = C1908ja.m4589a(this.f3473e, iwVar.f3473e)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(mo18309g()).compareTo(Boolean.valueOf(iwVar.mo18309g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo18309g() && (a2 = C1908ja.m4589a(this.f3474f, iwVar.f3474f)) != 0) {
            return a2;
        }
        int compareTo8 = Boolean.valueOf(mo18310h()).compareTo(Boolean.valueOf(iwVar.mo18310h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!mo18310h() || (a = C1908ja.m4591a((List) this.f3469a, (List) iwVar.f3469a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1903iw mo18296a(String str) {
        this.f3470b = str;
        return this;
    }

    /* renamed from: a */
    public void mo18297a() {
        if (this.f3470b == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3471c == null) {
            throw new C1921jl("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f3472d == null) {
            throw new C1921jl("Required field 'topic' was not present! Struct: " + toString());
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
            r4.mo18297a()
            return
        L_0x0012:
            short r1 = r0.f3528a
            r2 = 11
            switch(r1) {
                case 1: goto L_0x0092;
                case 2: goto L_0x007f;
                case 3: goto L_0x0074;
                case 4: goto L_0x0069;
                case 5: goto L_0x005e;
                case 6: goto L_0x0053;
                case 7: goto L_0x0048;
                case 8: goto L_0x0020;
                default: goto L_0x0019;
            }
        L_0x0019:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r5, r0)
            goto L_0x009c
        L_0x0020:
            byte r1 = r0.f3526a
            r2 = 15
            if (r1 != r2) goto L_0x0019
            com.xiaomi.push.ji r0 = r5.mo18332a()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.f3530a
            r1.<init>(r2)
            r4.f3469a = r1
            r1 = 0
        L_0x0034:
            int r2 = r0.f3530a
            if (r1 >= r2) goto L_0x0044
            java.lang.String r2 = r5.mo18332a()
            java.util.List<java.lang.String> r3 = r4.f3469a
            r3.add(r2)
            int r1 = r1 + 1
            goto L_0x0034
        L_0x0044:
            r5.mo18353i()
            goto L_0x009c
        L_0x0048:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.mo18332a()
            r4.f3474f = r0
            goto L_0x009c
        L_0x0053:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.mo18332a()
            r4.f3473e = r0
            goto L_0x009c
        L_0x005e:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.mo18332a()
            r4.f3472d = r0
            goto L_0x009c
        L_0x0069:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.mo18332a()
            r4.f3471c = r0
            goto L_0x009c
        L_0x0074:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.mo18332a()
            r4.f3470b = r0
            goto L_0x009c
        L_0x007f:
            byte r1 = r0.f3526a
            r2 = 12
            if (r1 != r2) goto L_0x0019
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r4.f3467a = r0
            com.xiaomi.push.id r0 = r4.f3467a
            r0.mo17579a((com.xiaomi.push.C1920jk) r5)
            goto L_0x009c
        L_0x0092:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.mo18332a()
            r4.f3468a = r0
        L_0x009c:
            r5.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1903iw.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public boolean m4509a() {
        return this.f3468a != null;
    }

    /* renamed from: a */
    public boolean m4510a(C1903iw iwVar) {
        if (iwVar == null) {
            return false;
        }
        boolean a = mo18297a();
        boolean a2 = iwVar.mo18297a();
        if ((a || a2) && (!a || !a2 || !this.f3468a.equals(iwVar.f3468a))) {
            return false;
        }
        boolean b = mo18299b();
        boolean b2 = iwVar.mo18299b();
        if ((b || b2) && (!b || !b2 || !this.f3467a.compareTo(iwVar.f3467a))) {
            return false;
        }
        boolean c = mo18301c();
        boolean c2 = iwVar.mo18301c();
        if ((c || c2) && (!c || !c2 || !this.f3470b.equals(iwVar.f3470b))) {
            return false;
        }
        boolean d = mo18304d();
        boolean d2 = iwVar.mo18304d();
        if ((d || d2) && (!d || !d2 || !this.f3471c.equals(iwVar.f3471c))) {
            return false;
        }
        boolean e = mo18306e();
        boolean e2 = iwVar.mo18306e();
        if ((e || e2) && (!e || !e2 || !this.f3472d.equals(iwVar.f3472d))) {
            return false;
        }
        boolean f = mo18308f();
        boolean f2 = iwVar.mo18308f();
        if ((f || f2) && (!f || !f2 || !this.f3473e.equals(iwVar.f3473e))) {
            return false;
        }
        boolean g = mo18309g();
        boolean g2 = iwVar.mo18309g();
        if ((g || g2) && (!g || !g2 || !this.f3474f.equals(iwVar.f3474f))) {
            return false;
        }
        boolean h = mo18310h();
        boolean h2 = iwVar.mo18310h();
        if (h || h2) {
            return h && h2 && this.f3469a.equals(iwVar.f3469a);
        }
        return true;
    }

    /* renamed from: b */
    public C1903iw mo18298b(String str) {
        this.f3471c = str;
        return this;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18297a();
        jkVar.mo18339a(f3459a);
        if (this.f3468a != null && mo18297a()) {
            jkVar.mo18336a(f3458a);
            jkVar.mo18340a(this.f3468a);
            jkVar.mo18344b();
        }
        if (this.f3467a != null && mo18299b()) {
            jkVar.mo18336a(f3460b);
            this.f3467a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3470b != null) {
            jkVar.mo18336a(f3461c);
            jkVar.mo18340a(this.f3470b);
            jkVar.mo18344b();
        }
        if (this.f3471c != null) {
            jkVar.mo18336a(f3462d);
            jkVar.mo18340a(this.f3471c);
            jkVar.mo18344b();
        }
        if (this.f3472d != null) {
            jkVar.mo18336a(f3463e);
            jkVar.mo18340a(this.f3472d);
            jkVar.mo18344b();
        }
        if (this.f3473e != null && mo18308f()) {
            jkVar.mo18336a(f3464f);
            jkVar.mo18340a(this.f3473e);
            jkVar.mo18344b();
        }
        if (this.f3474f != null && mo18309g()) {
            jkVar.mo18336a(f3465g);
            jkVar.mo18340a(this.f3474f);
            jkVar.mo18344b();
        }
        if (this.f3469a != null && mo18310h()) {
            jkVar.mo18336a(f3466h);
            jkVar.mo18337a(new C1918ji((byte) 11, this.f3469a.size()));
            for (String a : this.f3469a) {
                jkVar.mo18340a(a);
            }
            jkVar.mo18349e();
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public boolean mo18299b() {
        return this.f3467a != null;
    }

    /* renamed from: c */
    public C1903iw mo18300c(String str) {
        this.f3472d = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo18301c() {
        return this.f3470b != null;
    }

    /* renamed from: d */
    public C1903iw mo18303d(String str) {
        this.f3473e = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo18304d() {
        return this.f3471c != null;
    }

    /* renamed from: e */
    public C1903iw mo18305e(String str) {
        this.f3474f = str;
        return this;
    }

    /* renamed from: e */
    public boolean mo18306e() {
        return this.f3472d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1903iw)) {
            return compareTo((C1903iw) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo18308f() {
        return this.f3473e != null;
    }

    /* renamed from: g */
    public boolean mo18309g() {
        return this.f3474f != null;
    }

    /* renamed from: h */
    public boolean mo18310h() {
        return this.f3469a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        if (mo18297a()) {
            sb.append("debug:");
            String str = this.f3468a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (mo18299b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1884id idVar = this.f3467a;
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
        String str2 = this.f3470b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f3471c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f3472d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (mo18308f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f3473e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo18309g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f3474f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (mo18310h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f3469a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
