package com.xiaomi.push;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.xiaomi.push.is */
public class C1899is implements C1906iz<C1899is, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3375a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f3376a = new C1925jp("XmPushActionSubscription");

    /* renamed from: b */
    private static final C1917jh f3377b = new C1917jh("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1917jh f3378c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3379d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3380e = new C1917jh("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1917jh f3381f = new C1917jh("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1917jh f3382g = new C1917jh("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1917jh f3383h = new C1917jh("", (byte) 15, 8);

    /* renamed from: a */
    public C1884id f3384a;

    /* renamed from: a */
    public String f3385a;

    /* renamed from: a */
    public List<String> f3386a;

    /* renamed from: b */
    public String f3387b;

    /* renamed from: c */
    public String f3388c;

    /* renamed from: d */
    public String f3389d;

    /* renamed from: e */
    public String f3390e;

    /* renamed from: f */
    public String f3391f;

    /* renamed from: a */
    public int compareTo(C1899is isVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(isVar.getClass())) {
            return getClass().getName().compareTo(isVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18223a()).compareTo(Boolean.valueOf(isVar.mo18223a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18223a() && (a8 = C1908ja.m4589a(this.f3385a, isVar.f3385a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(mo18225b()).compareTo(Boolean.valueOf(isVar.mo18225b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo18225b() && (a7 = C1908ja.m4588a((Comparable) this.f3384a, (Comparable) isVar.f3384a)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(mo18227c()).compareTo(Boolean.valueOf(isVar.mo18227c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo18227c() && (a6 = C1908ja.m4589a(this.f3387b, isVar.f3387b)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(mo18230d()).compareTo(Boolean.valueOf(isVar.mo18230d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo18230d() && (a5 = C1908ja.m4589a(this.f3388c, isVar.f3388c)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(mo18232e()).compareTo(Boolean.valueOf(isVar.mo18232e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo18232e() && (a4 = C1908ja.m4589a(this.f3389d, isVar.f3389d)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(mo18234f()).compareTo(Boolean.valueOf(isVar.mo18234f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo18234f() && (a3 = C1908ja.m4589a(this.f3390e, isVar.f3390e)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(mo18235g()).compareTo(Boolean.valueOf(isVar.mo18235g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo18235g() && (a2 = C1908ja.m4589a(this.f3391f, isVar.f3391f)) != 0) {
            return a2;
        }
        int compareTo8 = Boolean.valueOf(mo18236h()).compareTo(Boolean.valueOf(isVar.mo18236h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!mo18236h() || (a = C1908ja.m4591a((List) this.f3386a, (List) isVar.f3386a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1899is mo18222a(String str) {
        this.f3387b = str;
        return this;
    }

    /* renamed from: a */
    public void mo18223a() {
        if (this.f3387b == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3388c == null) {
            throw new C1921jl("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f3389d == null) {
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
            r4.mo18223a()
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
            r4.f3386a = r1
            r1 = 0
        L_0x0034:
            int r2 = r0.f3530a
            if (r1 >= r2) goto L_0x0044
            java.lang.String r2 = r5.mo18332a()
            java.util.List<java.lang.String> r3 = r4.f3386a
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
            r4.f3391f = r0
            goto L_0x009c
        L_0x0053:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.mo18332a()
            r4.f3390e = r0
            goto L_0x009c
        L_0x005e:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.mo18332a()
            r4.f3389d = r0
            goto L_0x009c
        L_0x0069:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.mo18332a()
            r4.f3388c = r0
            goto L_0x009c
        L_0x0074:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.mo18332a()
            r4.f3387b = r0
            goto L_0x009c
        L_0x007f:
            byte r1 = r0.f3526a
            r2 = 12
            if (r1 != r2) goto L_0x0019
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r4.f3384a = r0
            com.xiaomi.push.id r0 = r4.f3384a
            r0.mo17579a((com.xiaomi.push.C1920jk) r5)
            goto L_0x009c
        L_0x0092:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.mo18332a()
            r4.f3385a = r0
        L_0x009c:
            r5.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1899is.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public boolean m4431a() {
        return this.f3385a != null;
    }

    /* renamed from: a */
    public boolean m4432a(C1899is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean a = mo18223a();
        boolean a2 = isVar.mo18223a();
        if ((a || a2) && (!a || !a2 || !this.f3385a.equals(isVar.f3385a))) {
            return false;
        }
        boolean b = mo18225b();
        boolean b2 = isVar.mo18225b();
        if ((b || b2) && (!b || !b2 || !this.f3384a.compareTo(isVar.f3384a))) {
            return false;
        }
        boolean c = mo18227c();
        boolean c2 = isVar.mo18227c();
        if ((c || c2) && (!c || !c2 || !this.f3387b.equals(isVar.f3387b))) {
            return false;
        }
        boolean d = mo18230d();
        boolean d2 = isVar.mo18230d();
        if ((d || d2) && (!d || !d2 || !this.f3388c.equals(isVar.f3388c))) {
            return false;
        }
        boolean e = mo18232e();
        boolean e2 = isVar.mo18232e();
        if ((e || e2) && (!e || !e2 || !this.f3389d.equals(isVar.f3389d))) {
            return false;
        }
        boolean f = mo18234f();
        boolean f2 = isVar.mo18234f();
        if ((f || f2) && (!f || !f2 || !this.f3390e.equals(isVar.f3390e))) {
            return false;
        }
        boolean g = mo18235g();
        boolean g2 = isVar.mo18235g();
        if ((g || g2) && (!g || !g2 || !this.f3391f.equals(isVar.f3391f))) {
            return false;
        }
        boolean h = mo18236h();
        boolean h2 = isVar.mo18236h();
        if (h || h2) {
            return h && h2 && this.f3386a.equals(isVar.f3386a);
        }
        return true;
    }

    /* renamed from: b */
    public C1899is mo18224b(String str) {
        this.f3388c = str;
        return this;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18223a();
        jkVar.mo18339a(f3376a);
        if (this.f3385a != null && mo18223a()) {
            jkVar.mo18336a(f3375a);
            jkVar.mo18340a(this.f3385a);
            jkVar.mo18344b();
        }
        if (this.f3384a != null && mo18225b()) {
            jkVar.mo18336a(f3377b);
            this.f3384a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3387b != null) {
            jkVar.mo18336a(f3378c);
            jkVar.mo18340a(this.f3387b);
            jkVar.mo18344b();
        }
        if (this.f3388c != null) {
            jkVar.mo18336a(f3379d);
            jkVar.mo18340a(this.f3388c);
            jkVar.mo18344b();
        }
        if (this.f3389d != null) {
            jkVar.mo18336a(f3380e);
            jkVar.mo18340a(this.f3389d);
            jkVar.mo18344b();
        }
        if (this.f3390e != null && mo18234f()) {
            jkVar.mo18336a(f3381f);
            jkVar.mo18340a(this.f3390e);
            jkVar.mo18344b();
        }
        if (this.f3391f != null && mo18235g()) {
            jkVar.mo18336a(f3382g);
            jkVar.mo18340a(this.f3391f);
            jkVar.mo18344b();
        }
        if (this.f3386a != null && mo18236h()) {
            jkVar.mo18336a(f3383h);
            jkVar.mo18337a(new C1918ji((byte) 11, this.f3386a.size()));
            for (String a : this.f3386a) {
                jkVar.mo18340a(a);
            }
            jkVar.mo18349e();
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public boolean mo18225b() {
        return this.f3384a != null;
    }

    /* renamed from: c */
    public C1899is mo18226c(String str) {
        this.f3389d = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo18227c() {
        return this.f3387b != null;
    }

    /* renamed from: d */
    public C1899is mo18229d(String str) {
        this.f3390e = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo18230d() {
        return this.f3388c != null;
    }

    /* renamed from: e */
    public C1899is mo18231e(String str) {
        this.f3391f = str;
        return this;
    }

    /* renamed from: e */
    public boolean mo18232e() {
        return this.f3389d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1899is)) {
            return compareTo((C1899is) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo18234f() {
        return this.f3390e != null;
    }

    /* renamed from: g */
    public boolean mo18235g() {
        return this.f3391f != null;
    }

    /* renamed from: h */
    public boolean mo18236h() {
        return this.f3386a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        if (mo18223a()) {
            sb.append("debug:");
            String str = this.f3385a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (mo18225b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1884id idVar = this.f3384a;
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
        String str2 = this.f3387b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f3388c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f3389d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (mo18234f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f3390e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo18235g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f3391f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (mo18236h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f3386a;
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
