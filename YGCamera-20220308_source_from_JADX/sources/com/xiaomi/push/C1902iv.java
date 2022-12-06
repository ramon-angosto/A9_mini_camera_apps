package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.iv */
public class C1902iv implements C1906iz<C1902iv, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3438a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f3439a = new C1925jp("XmPushActionUnRegistrationResult");

    /* renamed from: b */
    private static final C1917jh f3440b = new C1917jh("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1917jh f3441c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3442d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3443e = new C1917jh("", (byte) 10, 6);

    /* renamed from: f */
    private static final C1917jh f3444f = new C1917jh("", (byte) 11, 7);

    /* renamed from: g */
    private static final C1917jh f3445g = new C1917jh("", (byte) 11, 8);

    /* renamed from: h */
    private static final C1917jh f3446h = new C1917jh("", (byte) 10, 9);

    /* renamed from: i */
    private static final C1917jh f3447i = new C1917jh("", (byte) 10, 10);

    /* renamed from: a */
    public long f3448a;

    /* renamed from: a */
    public C1884id f3449a;

    /* renamed from: a */
    public String f3450a;

    /* renamed from: a */
    private BitSet f3451a = new BitSet(3);

    /* renamed from: b */
    public long f3452b;

    /* renamed from: b */
    public String f3453b;

    /* renamed from: c */
    public long f3454c;

    /* renamed from: c */
    public String f3455c;

    /* renamed from: d */
    public String f3456d;

    /* renamed from: e */
    public String f3457e;

    /* renamed from: a */
    public int compareTo(C1902iv ivVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(ivVar.getClass())) {
            return getClass().getName().compareTo(ivVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18279a()).compareTo(Boolean.valueOf(ivVar.mo18279a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18279a() && (a9 = C1908ja.m4589a(this.f3450a, ivVar.f3450a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(mo18282b()).compareTo(Boolean.valueOf(ivVar.mo18282b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo18282b() && (a8 = C1908ja.m4588a((Comparable) this.f3449a, (Comparable) ivVar.f3449a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(mo18284c()).compareTo(Boolean.valueOf(ivVar.mo18284c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo18284c() && (a7 = C1908ja.m4589a(this.f3453b, ivVar.f3453b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(mo18286d()).compareTo(Boolean.valueOf(ivVar.mo18286d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo18286d() && (a6 = C1908ja.m4589a(this.f3455c, ivVar.f3455c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(mo18287e()).compareTo(Boolean.valueOf(ivVar.mo18287e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo18287e() && (a5 = C1908ja.m4587a(this.f3448a, ivVar.f3448a)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(mo18289f()).compareTo(Boolean.valueOf(ivVar.mo18289f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo18289f() && (a4 = C1908ja.m4589a(this.f3456d, ivVar.f3456d)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(mo18290g()).compareTo(Boolean.valueOf(ivVar.mo18290g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo18290g() && (a3 = C1908ja.m4589a(this.f3457e, ivVar.f3457e)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(mo18291h()).compareTo(Boolean.valueOf(ivVar.mo18291h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo18291h() && (a2 = C1908ja.m4587a(this.f3452b, ivVar.f3452b)) != 0) {
            return a2;
        }
        int compareTo9 = Boolean.valueOf(mo18293i()).compareTo(Boolean.valueOf(ivVar.mo18293i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!mo18293i() || (a = C1908ja.m4587a(this.f3454c, ivVar.f3454c)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public String mo18279a() {
        return this.f3457e;
    }

    /* renamed from: a */
    public void m4489a() {
        if (this.f3453b == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3455c == null) {
            throw new C1921jl("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17579a(com.xiaomi.push.C1920jk r6) {
        /*
            r5 = this;
            r6.mo18332a()
        L_0x0003:
            com.xiaomi.push.jh r0 = r6.mo18332a()
            byte r1 = r0.f3526a
            if (r1 != 0) goto L_0x0033
            r6.mo18350f()
            boolean r6 = r5.mo18287e()
            if (r6 == 0) goto L_0x0018
            r5.mo18279a()
            return
        L_0x0018:
            com.xiaomi.push.jl r6 = new com.xiaomi.push.jl
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'errorCode' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x0033:
            short r1 = r0.f3528a
            r2 = 1
            r3 = 10
            r4 = 11
            switch(r1) {
                case 1: goto L_0x00ad;
                case 2: goto L_0x009a;
                case 3: goto L_0x008f;
                case 4: goto L_0x0084;
                case 5: goto L_0x003d;
                case 6: goto L_0x0076;
                case 7: goto L_0x006b;
                case 8: goto L_0x0060;
                case 9: goto L_0x0052;
                case 10: goto L_0x0044;
                default: goto L_0x003d;
            }
        L_0x003d:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r6, r0)
            goto L_0x00b7
        L_0x0044:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x003d
            long r0 = r6.mo18332a()
            r5.f3454c = r0
            r5.mo18283c(r2)
            goto L_0x00b7
        L_0x0052:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x003d
            long r0 = r6.mo18332a()
            r5.f3452b = r0
            r5.mo18281b((boolean) r2)
            goto L_0x00b7
        L_0x0060:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003d
            java.lang.String r0 = r6.mo18332a()
            r5.f3457e = r0
            goto L_0x00b7
        L_0x006b:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003d
            java.lang.String r0 = r6.mo18332a()
            r5.f3456d = r0
            goto L_0x00b7
        L_0x0076:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x003d
            long r0 = r6.mo18332a()
            r5.f3448a = r0
            r5.mo18280a((boolean) r2)
            goto L_0x00b7
        L_0x0084:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003d
            java.lang.String r0 = r6.mo18332a()
            r5.f3455c = r0
            goto L_0x00b7
        L_0x008f:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003d
            java.lang.String r0 = r6.mo18332a()
            r5.f3453b = r0
            goto L_0x00b7
        L_0x009a:
            byte r1 = r0.f3526a
            r2 = 12
            if (r1 != r2) goto L_0x003d
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r5.f3449a = r0
            com.xiaomi.push.id r0 = r5.f3449a
            r0.mo17579a((com.xiaomi.push.C1920jk) r6)
            goto L_0x00b7
        L_0x00ad:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003d
            java.lang.String r0 = r6.mo18332a()
            r5.f3450a = r0
        L_0x00b7:
            r6.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1902iv.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo18280a(boolean z) {
        this.f3451a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4492a() {
        return this.f3450a != null;
    }

    /* renamed from: a */
    public boolean m4493a(C1902iv ivVar) {
        if (ivVar == null) {
            return false;
        }
        boolean a = mo18279a();
        boolean a2 = ivVar.mo18279a();
        if ((a || a2) && (!a || !a2 || !this.f3450a.equals(ivVar.f3450a))) {
            return false;
        }
        boolean b = mo18282b();
        boolean b2 = ivVar.mo18282b();
        if ((b || b2) && (!b || !b2 || !this.f3449a.compareTo(ivVar.f3449a))) {
            return false;
        }
        boolean c = mo18284c();
        boolean c2 = ivVar.mo18284c();
        if ((c || c2) && (!c || !c2 || !this.f3453b.equals(ivVar.f3453b))) {
            return false;
        }
        boolean d = mo18286d();
        boolean d2 = ivVar.mo18286d();
        if (((d || d2) && (!d || !d2 || !this.f3455c.equals(ivVar.f3455c))) || this.f3448a != ivVar.f3448a) {
            return false;
        }
        boolean f = mo18289f();
        boolean f2 = ivVar.mo18289f();
        if ((f || f2) && (!f || !f2 || !this.f3456d.equals(ivVar.f3456d))) {
            return false;
        }
        boolean g = mo18290g();
        boolean g2 = ivVar.mo18290g();
        if ((g || g2) && (!g || !g2 || !this.f3457e.equals(ivVar.f3457e))) {
            return false;
        }
        boolean h = mo18291h();
        boolean h2 = ivVar.mo18291h();
        if ((h || h2) && (!h || !h2 || this.f3452b != ivVar.f3452b)) {
            return false;
        }
        boolean i = mo18293i();
        boolean i2 = ivVar.mo18293i();
        if (i || i2) {
            return i && i2 && this.f3454c == ivVar.f3454c;
        }
        return true;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18279a();
        jkVar.mo18339a(f3439a);
        if (this.f3450a != null && mo18279a()) {
            jkVar.mo18336a(f3438a);
            jkVar.mo18340a(this.f3450a);
            jkVar.mo18344b();
        }
        if (this.f3449a != null && mo18282b()) {
            jkVar.mo18336a(f3440b);
            this.f3449a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3453b != null) {
            jkVar.mo18336a(f3441c);
            jkVar.mo18340a(this.f3453b);
            jkVar.mo18344b();
        }
        if (this.f3455c != null) {
            jkVar.mo18336a(f3442d);
            jkVar.mo18340a(this.f3455c);
            jkVar.mo18344b();
        }
        jkVar.mo18336a(f3443e);
        jkVar.mo18335a(this.f3448a);
        jkVar.mo18344b();
        if (this.f3456d != null && mo18289f()) {
            jkVar.mo18336a(f3444f);
            jkVar.mo18340a(this.f3456d);
            jkVar.mo18344b();
        }
        if (this.f3457e != null && mo18290g()) {
            jkVar.mo18336a(f3445g);
            jkVar.mo18340a(this.f3457e);
            jkVar.mo18344b();
        }
        if (mo18291h()) {
            jkVar.mo18336a(f3446h);
            jkVar.mo18335a(this.f3452b);
            jkVar.mo18344b();
        }
        if (mo18293i()) {
            jkVar.mo18336a(f3447i);
            jkVar.mo18335a(this.f3454c);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo18281b(boolean z) {
        this.f3451a.set(1, z);
    }

    /* renamed from: b */
    public boolean mo18282b() {
        return this.f3449a != null;
    }

    /* renamed from: c */
    public void mo18283c(boolean z) {
        this.f3451a.set(2, z);
    }

    /* renamed from: c */
    public boolean mo18284c() {
        return this.f3453b != null;
    }

    /* renamed from: d */
    public boolean mo18286d() {
        return this.f3455c != null;
    }

    /* renamed from: e */
    public boolean mo18287e() {
        return this.f3451a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1902iv)) {
            return compareTo((C1902iv) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo18289f() {
        return this.f3456d != null;
    }

    /* renamed from: g */
    public boolean mo18290g() {
        return this.f3457e != null;
    }

    /* renamed from: h */
    public boolean mo18291h() {
        return this.f3451a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo18293i() {
        return this.f3451a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        if (mo18279a()) {
            sb.append("debug:");
            String str = this.f3450a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (mo18282b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1884id idVar = this.f3449a;
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
        String str2 = this.f3453b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f3455c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f3448a);
        if (mo18289f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f3456d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo18290g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f3457e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo18291h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f3452b);
        }
        if (mo18293i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f3454c);
        }
        sb.append(")");
        return sb.toString();
    }
}
