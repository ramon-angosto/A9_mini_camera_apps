package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.iq */
public class C1897iq implements C1906iz<C1897iq, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3333a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f3334a = new C1925jp("XmPushActionSendFeedbackResult");

    /* renamed from: b */
    private static final C1917jh f3335b = new C1917jh("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1917jh f3336c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3337d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3338e = new C1917jh("", (byte) 10, 6);

    /* renamed from: f */
    private static final C1917jh f3339f = new C1917jh("", (byte) 11, 7);

    /* renamed from: g */
    private static final C1917jh f3340g = new C1917jh("", (byte) 11, 8);

    /* renamed from: a */
    public long f3341a;

    /* renamed from: a */
    public C1884id f3342a;

    /* renamed from: a */
    public String f3343a;

    /* renamed from: a */
    private BitSet f3344a = new BitSet(1);

    /* renamed from: b */
    public String f3345b;

    /* renamed from: c */
    public String f3346c;

    /* renamed from: d */
    public String f3347d;

    /* renamed from: e */
    public String f3348e;

    /* renamed from: a */
    public int compareTo(C1897iq iqVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!getClass().equals(iqVar.getClass())) {
            return getClass().getName().compareTo(iqVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18191a()).compareTo(Boolean.valueOf(iqVar.mo18191a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18191a() && (a7 = C1908ja.m4589a(this.f3343a, iqVar.f3343a)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(mo18193b()).compareTo(Boolean.valueOf(iqVar.mo18193b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo18193b() && (a6 = C1908ja.m4588a((Comparable) this.f3342a, (Comparable) iqVar.f3342a)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(mo18194c()).compareTo(Boolean.valueOf(iqVar.mo18194c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo18194c() && (a5 = C1908ja.m4589a(this.f3345b, iqVar.f3345b)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(mo18196d()).compareTo(Boolean.valueOf(iqVar.mo18196d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo18196d() && (a4 = C1908ja.m4589a(this.f3346c, iqVar.f3346c)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(mo18197e()).compareTo(Boolean.valueOf(iqVar.mo18197e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo18197e() && (a3 = C1908ja.m4587a(this.f3341a, iqVar.f3341a)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(mo18199f()).compareTo(Boolean.valueOf(iqVar.mo18199f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo18199f() && (a2 = C1908ja.m4589a(this.f3347d, iqVar.f3347d)) != 0) {
            return a2;
        }
        int compareTo7 = Boolean.valueOf(mo18200g()).compareTo(Boolean.valueOf(iqVar.mo18200g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!mo18200g() || (a = C1908ja.m4589a(this.f3348e, iqVar.f3348e)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public void mo18191a() {
        if (this.f3345b == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3346c == null) {
            throw new C1921jl("Required field 'appId' was not present! Struct: " + toString());
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
            if (r1 != 0) goto L_0x0033
            r4.mo18350f()
            boolean r4 = r3.mo18197e()
            if (r4 == 0) goto L_0x0018
            r3.mo18191a()
            return
        L_0x0018:
            com.xiaomi.push.jl r4 = new com.xiaomi.push.jl
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'errorCode' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r3.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L_0x0033:
            short r1 = r0.f3528a
            r2 = 11
            switch(r1) {
                case 1: goto L_0x0090;
                case 2: goto L_0x007d;
                case 3: goto L_0x0072;
                case 4: goto L_0x0067;
                case 5: goto L_0x003a;
                case 6: goto L_0x0056;
                case 7: goto L_0x004b;
                case 8: goto L_0x0040;
                default: goto L_0x003a;
            }
        L_0x003a:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r4, r0)
            goto L_0x009a
        L_0x0040:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x003a
            java.lang.String r0 = r4.mo18332a()
            r3.f3348e = r0
            goto L_0x009a
        L_0x004b:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x003a
            java.lang.String r0 = r4.mo18332a()
            r3.f3347d = r0
            goto L_0x009a
        L_0x0056:
            byte r1 = r0.f3526a
            r2 = 10
            if (r1 != r2) goto L_0x003a
            long r0 = r4.mo18332a()
            r3.f3341a = r0
            r0 = 1
            r3.mo18192a((boolean) r0)
            goto L_0x009a
        L_0x0067:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x003a
            java.lang.String r0 = r4.mo18332a()
            r3.f3346c = r0
            goto L_0x009a
        L_0x0072:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x003a
            java.lang.String r0 = r4.mo18332a()
            r3.f3345b = r0
            goto L_0x009a
        L_0x007d:
            byte r1 = r0.f3526a
            r2 = 12
            if (r1 != r2) goto L_0x003a
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r3.f3342a = r0
            com.xiaomi.push.id r0 = r3.f3342a
            r0.mo17579a((com.xiaomi.push.C1920jk) r4)
            goto L_0x009a
        L_0x0090:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x003a
            java.lang.String r0 = r4.mo18332a()
            r3.f3343a = r0
        L_0x009a:
            r4.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1897iq.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo18192a(boolean z) {
        this.f3344a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4393a() {
        return this.f3343a != null;
    }

    /* renamed from: a */
    public boolean m4394a(C1897iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean a = mo18191a();
        boolean a2 = iqVar.mo18191a();
        if ((a || a2) && (!a || !a2 || !this.f3343a.equals(iqVar.f3343a))) {
            return false;
        }
        boolean b = mo18193b();
        boolean b2 = iqVar.mo18193b();
        if ((b || b2) && (!b || !b2 || !this.f3342a.compareTo(iqVar.f3342a))) {
            return false;
        }
        boolean c = mo18194c();
        boolean c2 = iqVar.mo18194c();
        if ((c || c2) && (!c || !c2 || !this.f3345b.equals(iqVar.f3345b))) {
            return false;
        }
        boolean d = mo18196d();
        boolean d2 = iqVar.mo18196d();
        if (((d || d2) && (!d || !d2 || !this.f3346c.equals(iqVar.f3346c))) || this.f3341a != iqVar.f3341a) {
            return false;
        }
        boolean f = mo18199f();
        boolean f2 = iqVar.mo18199f();
        if ((f || f2) && (!f || !f2 || !this.f3347d.equals(iqVar.f3347d))) {
            return false;
        }
        boolean g = mo18200g();
        boolean g2 = iqVar.mo18200g();
        if (g || g2) {
            return g && g2 && this.f3348e.equals(iqVar.f3348e);
        }
        return true;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18191a();
        jkVar.mo18339a(f3334a);
        if (this.f3343a != null && mo18191a()) {
            jkVar.mo18336a(f3333a);
            jkVar.mo18340a(this.f3343a);
            jkVar.mo18344b();
        }
        if (this.f3342a != null && mo18193b()) {
            jkVar.mo18336a(f3335b);
            this.f3342a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3345b != null) {
            jkVar.mo18336a(f3336c);
            jkVar.mo18340a(this.f3345b);
            jkVar.mo18344b();
        }
        if (this.f3346c != null) {
            jkVar.mo18336a(f3337d);
            jkVar.mo18340a(this.f3346c);
            jkVar.mo18344b();
        }
        jkVar.mo18336a(f3338e);
        jkVar.mo18335a(this.f3341a);
        jkVar.mo18344b();
        if (this.f3347d != null && mo18199f()) {
            jkVar.mo18336a(f3339f);
            jkVar.mo18340a(this.f3347d);
            jkVar.mo18344b();
        }
        if (this.f3348e != null && mo18200g()) {
            jkVar.mo18336a(f3340g);
            jkVar.mo18340a(this.f3348e);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public boolean mo18193b() {
        return this.f3342a != null;
    }

    /* renamed from: c */
    public boolean mo18194c() {
        return this.f3345b != null;
    }

    /* renamed from: d */
    public boolean mo18196d() {
        return this.f3346c != null;
    }

    /* renamed from: e */
    public boolean mo18197e() {
        return this.f3344a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1897iq)) {
            return compareTo((C1897iq) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo18199f() {
        return this.f3347d != null;
    }

    /* renamed from: g */
    public boolean mo18200g() {
        return this.f3348e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        if (mo18191a()) {
            sb.append("debug:");
            String str = this.f3343a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (mo18193b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1884id idVar = this.f3342a;
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
        String str2 = this.f3345b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f3346c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f3341a);
        if (mo18199f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f3347d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo18200g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f3348e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
