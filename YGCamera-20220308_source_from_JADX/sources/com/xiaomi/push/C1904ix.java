package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.ix */
public class C1904ix implements C1906iz<C1904ix, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3475a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f3476a = new C1925jp("XmPushActionUnSubscriptionResult");

    /* renamed from: b */
    private static final C1917jh f3477b = new C1917jh("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1917jh f3478c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3479d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3480e = new C1917jh("", (byte) 10, 6);

    /* renamed from: f */
    private static final C1917jh f3481f = new C1917jh("", (byte) 11, 7);

    /* renamed from: g */
    private static final C1917jh f3482g = new C1917jh("", (byte) 11, 8);

    /* renamed from: h */
    private static final C1917jh f3483h = new C1917jh("", (byte) 11, 9);

    /* renamed from: i */
    private static final C1917jh f3484i = new C1917jh("", (byte) 11, 10);

    /* renamed from: a */
    public long f3485a;

    /* renamed from: a */
    public C1884id f3486a;

    /* renamed from: a */
    public String f3487a;

    /* renamed from: a */
    private BitSet f3488a = new BitSet(1);

    /* renamed from: b */
    public String f3489b;

    /* renamed from: c */
    public String f3490c;

    /* renamed from: d */
    public String f3491d;

    /* renamed from: e */
    public String f3492e;

    /* renamed from: f */
    public String f3493f;

    /* renamed from: g */
    public String f3494g;

    /* renamed from: a */
    public int compareTo(C1904ix ixVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(ixVar.getClass())) {
            return getClass().getName().compareTo(ixVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18314a()).compareTo(Boolean.valueOf(ixVar.mo18314a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18314a() && (a9 = C1908ja.m4589a(this.f3487a, ixVar.f3487a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(mo18316b()).compareTo(Boolean.valueOf(ixVar.mo18316b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo18316b() && (a8 = C1908ja.m4588a((Comparable) this.f3486a, (Comparable) ixVar.f3486a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(mo18317c()).compareTo(Boolean.valueOf(ixVar.mo18317c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo18317c() && (a7 = C1908ja.m4589a(this.f3489b, ixVar.f3489b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(mo18319d()).compareTo(Boolean.valueOf(ixVar.mo18319d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo18319d() && (a6 = C1908ja.m4589a(this.f3490c, ixVar.f3490c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(mo18320e()).compareTo(Boolean.valueOf(ixVar.mo18320e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo18320e() && (a5 = C1908ja.m4587a(this.f3485a, ixVar.f3485a)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(mo18322f()).compareTo(Boolean.valueOf(ixVar.mo18322f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo18322f() && (a4 = C1908ja.m4589a(this.f3491d, ixVar.f3491d)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(mo18323g()).compareTo(Boolean.valueOf(ixVar.mo18323g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo18323g() && (a3 = C1908ja.m4589a(this.f3492e, ixVar.f3492e)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(mo18324h()).compareTo(Boolean.valueOf(ixVar.mo18324h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo18324h() && (a2 = C1908ja.m4589a(this.f3493f, ixVar.f3493f)) != 0) {
            return a2;
        }
        int compareTo9 = Boolean.valueOf(mo18326i()).compareTo(Boolean.valueOf(ixVar.mo18326i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!mo18326i() || (a = C1908ja.m4589a(this.f3494g, ixVar.f3494g)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public String mo18314a() {
        return this.f3489b;
    }

    /* renamed from: a */
    public void m4525a() {
        if (this.f3489b == null) {
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
            r3.mo18314a()
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
            r3.f3494g = r0
            goto L_0x0090
        L_0x002b:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3493f = r0
            goto L_0x0090
        L_0x0036:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3492e = r0
            goto L_0x0090
        L_0x0041:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3491d = r0
            goto L_0x0090
        L_0x004c:
            byte r1 = r0.f3526a
            r2 = 10
            if (r1 != r2) goto L_0x0019
            long r0 = r4.mo18332a()
            r3.f3485a = r0
            r0 = 1
            r3.mo18315a((boolean) r0)
            goto L_0x0090
        L_0x005d:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3490c = r0
            goto L_0x0090
        L_0x0068:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3489b = r0
            goto L_0x0090
        L_0x0073:
            byte r1 = r0.f3526a
            r2 = 12
            if (r1 != r2) goto L_0x0019
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r3.f3486a = r0
            com.xiaomi.push.id r0 = r3.f3486a
            r0.mo17579a((com.xiaomi.push.C1920jk) r4)
            goto L_0x0090
        L_0x0086:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.mo18332a()
            r3.f3487a = r0
        L_0x0090:
            r4.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1904ix.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo18315a(boolean z) {
        this.f3488a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4528a() {
        return this.f3487a != null;
    }

    /* renamed from: a */
    public boolean m4529a(C1904ix ixVar) {
        if (ixVar == null) {
            return false;
        }
        boolean a = mo18314a();
        boolean a2 = ixVar.mo18314a();
        if ((a || a2) && (!a || !a2 || !this.f3487a.equals(ixVar.f3487a))) {
            return false;
        }
        boolean b = mo18316b();
        boolean b2 = ixVar.mo18316b();
        if ((b || b2) && (!b || !b2 || !this.f3486a.compareTo(ixVar.f3486a))) {
            return false;
        }
        boolean c = mo18317c();
        boolean c2 = ixVar.mo18317c();
        if ((c || c2) && (!c || !c2 || !this.f3489b.equals(ixVar.f3489b))) {
            return false;
        }
        boolean d = mo18319d();
        boolean d2 = ixVar.mo18319d();
        if ((d || d2) && (!d || !d2 || !this.f3490c.equals(ixVar.f3490c))) {
            return false;
        }
        boolean e = mo18320e();
        boolean e2 = ixVar.mo18320e();
        if ((e || e2) && (!e || !e2 || this.f3485a != ixVar.f3485a)) {
            return false;
        }
        boolean f = mo18322f();
        boolean f2 = ixVar.mo18322f();
        if ((f || f2) && (!f || !f2 || !this.f3491d.equals(ixVar.f3491d))) {
            return false;
        }
        boolean g = mo18323g();
        boolean g2 = ixVar.mo18323g();
        if ((g || g2) && (!g || !g2 || !this.f3492e.equals(ixVar.f3492e))) {
            return false;
        }
        boolean h = mo18324h();
        boolean h2 = ixVar.mo18324h();
        if ((h || h2) && (!h || !h2 || !this.f3493f.equals(ixVar.f3493f))) {
            return false;
        }
        boolean i = mo18326i();
        boolean i2 = ixVar.mo18326i();
        if (i || i2) {
            return i && i2 && this.f3494g.equals(ixVar.f3494g);
        }
        return true;
    }

    /* renamed from: b */
    public String mo18316b() {
        return this.f3492e;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18314a();
        jkVar.mo18339a(f3476a);
        if (this.f3487a != null && mo18314a()) {
            jkVar.mo18336a(f3475a);
            jkVar.mo18340a(this.f3487a);
            jkVar.mo18344b();
        }
        if (this.f3486a != null && mo18316b()) {
            jkVar.mo18336a(f3477b);
            this.f3486a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3489b != null) {
            jkVar.mo18336a(f3478c);
            jkVar.mo18340a(this.f3489b);
            jkVar.mo18344b();
        }
        if (this.f3490c != null && mo18319d()) {
            jkVar.mo18336a(f3479d);
            jkVar.mo18340a(this.f3490c);
            jkVar.mo18344b();
        }
        if (mo18320e()) {
            jkVar.mo18336a(f3480e);
            jkVar.mo18335a(this.f3485a);
            jkVar.mo18344b();
        }
        if (this.f3491d != null && mo18322f()) {
            jkVar.mo18336a(f3481f);
            jkVar.mo18340a(this.f3491d);
            jkVar.mo18344b();
        }
        if (this.f3492e != null && mo18323g()) {
            jkVar.mo18336a(f3482g);
            jkVar.mo18340a(this.f3492e);
            jkVar.mo18344b();
        }
        if (this.f3493f != null && mo18324h()) {
            jkVar.mo18336a(f3483h);
            jkVar.mo18340a(this.f3493f);
            jkVar.mo18344b();
        }
        if (this.f3494g != null && mo18326i()) {
            jkVar.mo18336a(f3484i);
            jkVar.mo18340a(this.f3494g);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public boolean m4532b() {
        return this.f3486a != null;
    }

    /* renamed from: c */
    public String mo18317c() {
        return this.f3494g;
    }

    /* renamed from: c */
    public boolean m4534c() {
        return this.f3489b != null;
    }

    /* renamed from: d */
    public boolean mo18319d() {
        return this.f3490c != null;
    }

    /* renamed from: e */
    public boolean mo18320e() {
        return this.f3488a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1904ix)) {
            return compareTo((C1904ix) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo18322f() {
        return this.f3491d != null;
    }

    /* renamed from: g */
    public boolean mo18323g() {
        return this.f3492e != null;
    }

    /* renamed from: h */
    public boolean mo18324h() {
        return this.f3493f != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo18326i() {
        return this.f3494g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        if (mo18314a()) {
            sb.append("debug:");
            String str = this.f3487a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (mo18316b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1884id idVar = this.f3486a;
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
        String str2 = this.f3489b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (mo18319d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f3490c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (mo18320e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f3485a);
        }
        if (mo18322f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f3491d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo18323g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f3492e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo18324h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f3493f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (mo18326i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f3494g;
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
