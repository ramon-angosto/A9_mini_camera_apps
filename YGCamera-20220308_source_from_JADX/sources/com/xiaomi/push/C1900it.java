package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.it */
public class C1900it implements C1906iz<C1900it, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3392a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f3393a = new C1925jp("XmPushActionSubscriptionResult");

    /* renamed from: b */
    private static final C1917jh f3394b = new C1917jh("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1917jh f3395c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3396d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3397e = new C1917jh("", (byte) 10, 6);

    /* renamed from: f */
    private static final C1917jh f3398f = new C1917jh("", (byte) 11, 7);

    /* renamed from: g */
    private static final C1917jh f3399g = new C1917jh("", (byte) 11, 8);

    /* renamed from: h */
    private static final C1917jh f3400h = new C1917jh("", (byte) 11, 9);

    /* renamed from: i */
    private static final C1917jh f3401i = new C1917jh("", (byte) 11, 10);

    /* renamed from: a */
    public long f3402a;

    /* renamed from: a */
    public C1884id f3403a;

    /* renamed from: a */
    public String f3404a;

    /* renamed from: a */
    private BitSet f3405a = new BitSet(1);

    /* renamed from: b */
    public String f3406b;

    /* renamed from: c */
    public String f3407c;

    /* renamed from: d */
    public String f3408d;

    /* renamed from: e */
    public String f3409e;

    /* renamed from: f */
    public String f3410f;

    /* renamed from: g */
    public String f3411g;

    /* renamed from: a */
    public int compareTo(C1900it itVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(itVar.getClass())) {
            return getClass().getName().compareTo(itVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18240a()).compareTo(Boolean.valueOf(itVar.mo18240a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18240a() && (a9 = C1908ja.m4589a(this.f3404a, itVar.f3404a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(mo18242b()).compareTo(Boolean.valueOf(itVar.mo18242b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo18242b() && (a8 = C1908ja.m4588a((Comparable) this.f3403a, (Comparable) itVar.f3403a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(mo18243c()).compareTo(Boolean.valueOf(itVar.mo18243c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo18243c() && (a7 = C1908ja.m4589a(this.f3406b, itVar.f3406b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(mo18245d()).compareTo(Boolean.valueOf(itVar.mo18245d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo18245d() && (a6 = C1908ja.m4589a(this.f3407c, itVar.f3407c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(mo18246e()).compareTo(Boolean.valueOf(itVar.mo18246e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo18246e() && (a5 = C1908ja.m4587a(this.f3402a, itVar.f3402a)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(mo18248f()).compareTo(Boolean.valueOf(itVar.mo18248f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo18248f() && (a4 = C1908ja.m4589a(this.f3408d, itVar.f3408d)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(mo18249g()).compareTo(Boolean.valueOf(itVar.mo18249g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo18249g() && (a3 = C1908ja.m4589a(this.f3409e, itVar.f3409e)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(mo18250h()).compareTo(Boolean.valueOf(itVar.mo18250h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo18250h() && (a2 = C1908ja.m4589a(this.f3410f, itVar.f3410f)) != 0) {
            return a2;
        }
        int compareTo9 = Boolean.valueOf(mo18252i()).compareTo(Boolean.valueOf(itVar.mo18252i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!mo18252i() || (a = C1908ja.m4589a(this.f3411g, itVar.f3411g)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public String mo18240a() {
        return this.f3406b;
    }

    /* renamed from: a */
    public void m4447a() {
        if (this.f3406b == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17579a(com.xiaomi.push.C1920jk r4) {
        /*
            r3 = this;
            r4.mo18332a()
        L_0x0003:
            com.xiaomi.push.jh r0 = r4.mo18332a()
            byte r1 = r0.f3526a
            if (r1 != 0) goto L_0x0012
            r4.mo18350f()
            r3.mo18240a()
            return
        L_0x0012:
            short r1 = r0.f3528a
            r2 = 11
            switch(r1) {
                case 1: goto L_0x0086;
                case 2: goto L_0x0073;
                case 3: goto L_0x0068;
                case 4: goto L_0x005d;
                case 5: goto L_0x0019;
                case 6: goto L_0x004c;
                case 7: goto L_0x0041;
                case 8: goto L_0x0036;
                case 9: goto L_0x002b;
                case 10: goto L_0x0020;
                default: goto L_0x0019;
            }
        L_0x0019:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r4, r0)
            goto L_0x0090
        L_0x0020:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3411g = r0
            goto L_0x0090
        L_0x002b:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3410f = r0
            goto L_0x0090
        L_0x0036:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3409e = r0
            goto L_0x0090
        L_0x0041:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3408d = r0
            goto L_0x0090
        L_0x004c:
            byte r1 = r0.f3526a
            r2 = 10
            if (r1 != r2) goto L_0x0019
            long r0 = r4.mo18332a()
            r3.f3402a = r0
            r0 = 1
            r3.mo18241a((boolean) r0)
            goto L_0x0090
        L_0x005d:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3407c = r0
            goto L_0x0090
        L_0x0068:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3406b = r0
            goto L_0x0090
        L_0x0073:
            byte r1 = r0.f3526a
            r2 = 12
            if (r1 != r2) goto L_0x0019
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r3.f3403a = r0
            com.xiaomi.push.id r0 = r3.f3403a
            r0.mo17579a((com.xiaomi.push.C1920jk) r4)
            goto L_0x0090
        L_0x0086:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3404a = r0
        L_0x0090:
            r4.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1900it.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo18241a(boolean z) {
        this.f3405a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4450a() {
        return this.f3404a != null;
    }

    /* renamed from: a */
    public boolean m4451a(C1900it itVar) {
        if (itVar == null) {
            return false;
        }
        boolean a = mo18240a();
        boolean a2 = itVar.mo18240a();
        if ((a || a2) && (!a || !a2 || !this.f3404a.equals(itVar.f3404a))) {
            return false;
        }
        boolean b = mo18242b();
        boolean b2 = itVar.mo18242b();
        if ((b || b2) && (!b || !b2 || !this.f3403a.compareTo(itVar.f3403a))) {
            return false;
        }
        boolean c = mo18243c();
        boolean c2 = itVar.mo18243c();
        if ((c || c2) && (!c || !c2 || !this.f3406b.equals(itVar.f3406b))) {
            return false;
        }
        boolean d = mo18245d();
        boolean d2 = itVar.mo18245d();
        if ((d || d2) && (!d || !d2 || !this.f3407c.equals(itVar.f3407c))) {
            return false;
        }
        boolean e = mo18246e();
        boolean e2 = itVar.mo18246e();
        if ((e || e2) && (!e || !e2 || this.f3402a != itVar.f3402a)) {
            return false;
        }
        boolean f = mo18248f();
        boolean f2 = itVar.mo18248f();
        if ((f || f2) && (!f || !f2 || !this.f3408d.equals(itVar.f3408d))) {
            return false;
        }
        boolean g = mo18249g();
        boolean g2 = itVar.mo18249g();
        if ((g || g2) && (!g || !g2 || !this.f3409e.equals(itVar.f3409e))) {
            return false;
        }
        boolean h = mo18250h();
        boolean h2 = itVar.mo18250h();
        if ((h || h2) && (!h || !h2 || !this.f3410f.equals(itVar.f3410f))) {
            return false;
        }
        boolean i = mo18252i();
        boolean i2 = itVar.mo18252i();
        if (i || i2) {
            return i && i2 && this.f3411g.equals(itVar.f3411g);
        }
        return true;
    }

    /* renamed from: b */
    public String mo18242b() {
        return this.f3409e;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18240a();
        jkVar.mo18339a(f3393a);
        if (this.f3404a != null && mo18240a()) {
            jkVar.mo18336a(f3392a);
            jkVar.mo18340a(this.f3404a);
            jkVar.mo18344b();
        }
        if (this.f3403a != null && mo18242b()) {
            jkVar.mo18336a(f3394b);
            this.f3403a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3406b != null) {
            jkVar.mo18336a(f3395c);
            jkVar.mo18340a(this.f3406b);
            jkVar.mo18344b();
        }
        if (this.f3407c != null && mo18245d()) {
            jkVar.mo18336a(f3396d);
            jkVar.mo18340a(this.f3407c);
            jkVar.mo18344b();
        }
        if (mo18246e()) {
            jkVar.mo18336a(f3397e);
            jkVar.mo18335a(this.f3402a);
            jkVar.mo18344b();
        }
        if (this.f3408d != null && mo18248f()) {
            jkVar.mo18336a(f3398f);
            jkVar.mo18340a(this.f3408d);
            jkVar.mo18344b();
        }
        if (this.f3409e != null && mo18249g()) {
            jkVar.mo18336a(f3399g);
            jkVar.mo18340a(this.f3409e);
            jkVar.mo18344b();
        }
        if (this.f3410f != null && mo18250h()) {
            jkVar.mo18336a(f3400h);
            jkVar.mo18340a(this.f3410f);
            jkVar.mo18344b();
        }
        if (this.f3411g != null && mo18252i()) {
            jkVar.mo18336a(f3401i);
            jkVar.mo18340a(this.f3411g);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public boolean m4454b() {
        return this.f3403a != null;
    }

    /* renamed from: c */
    public String mo18243c() {
        return this.f3411g;
    }

    /* renamed from: c */
    public boolean m4456c() {
        return this.f3406b != null;
    }

    /* renamed from: d */
    public boolean mo18245d() {
        return this.f3407c != null;
    }

    /* renamed from: e */
    public boolean mo18246e() {
        return this.f3405a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1900it)) {
            return compareTo((C1900it) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo18248f() {
        return this.f3408d != null;
    }

    /* renamed from: g */
    public boolean mo18249g() {
        return this.f3409e != null;
    }

    /* renamed from: h */
    public boolean mo18250h() {
        return this.f3410f != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo18252i() {
        return this.f3411g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        if (mo18240a()) {
            sb.append("debug:");
            String str = this.f3404a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (mo18242b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1884id idVar = this.f3403a;
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
        String str2 = this.f3406b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (mo18245d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f3407c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (mo18246e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f3402a);
        }
        if (mo18248f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f3408d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo18249g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f3409e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo18250h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f3410f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (mo18252i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f3411g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
