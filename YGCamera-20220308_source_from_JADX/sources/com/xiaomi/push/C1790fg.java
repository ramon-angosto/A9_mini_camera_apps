package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.fg */
public class C1790fg implements C1906iz<C1790fg, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f2352a = new C1917jh("", (byte) 3, 1);

    /* renamed from: a */
    private static final C1925jp f2353a = new C1925jp("StatsEvent");

    /* renamed from: b */
    private static final C1917jh f2354b = new C1917jh("", (byte) 8, 2);

    /* renamed from: c */
    private static final C1917jh f2355c = new C1917jh("", (byte) 8, 3);

    /* renamed from: d */
    private static final C1917jh f2356d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f2357e = new C1917jh("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1917jh f2358f = new C1917jh("", (byte) 8, 6);

    /* renamed from: g */
    private static final C1917jh f2359g = new C1917jh("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1917jh f2360h = new C1917jh("", (byte) 11, 8);

    /* renamed from: i */
    private static final C1917jh f2361i = new C1917jh("", (byte) 8, 9);

    /* renamed from: j */
    private static final C1917jh f2362j = new C1917jh("", (byte) 8, 10);

    /* renamed from: a */
    public byte f2363a;

    /* renamed from: a */
    public int f2364a;

    /* renamed from: a */
    public String f2365a;

    /* renamed from: a */
    private BitSet f2366a = new BitSet(6);

    /* renamed from: b */
    public int f2367b;

    /* renamed from: b */
    public String f2368b;

    /* renamed from: c */
    public int f2369c;

    /* renamed from: c */
    public String f2370c;

    /* renamed from: d */
    public int f2371d;

    /* renamed from: d */
    public String f2372d;

    /* renamed from: e */
    public int f2373e;

    /* renamed from: a */
    public int compareTo(C1790fg fgVar) {
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
        if (!getClass().equals(fgVar.getClass())) {
            return getClass().getName().compareTo(fgVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17578a()).compareTo(Boolean.valueOf(fgVar.mo17578a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17578a() && (a10 = C1908ja.m4585a(this.f2363a, fgVar.f2363a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo17585b()).compareTo(Boolean.valueOf(fgVar.mo17585b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo17585b() && (a9 = C1908ja.m4586a(this.f2364a, fgVar.f2364a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo17589c()).compareTo(Boolean.valueOf(fgVar.mo17589c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo17589c() && (a8 = C1908ja.m4586a(this.f2367b, fgVar.f2367b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo17594d()).compareTo(Boolean.valueOf(fgVar.mo17594d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo17594d() && (a7 = C1908ja.m4589a(this.f2365a, fgVar.f2365a)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo17596e()).compareTo(Boolean.valueOf(fgVar.mo17596e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo17596e() && (a6 = C1908ja.m4589a(this.f2368b, fgVar.f2368b)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo17599f()).compareTo(Boolean.valueOf(fgVar.mo17599f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo17599f() && (a5 = C1908ja.m4586a(this.f2369c, fgVar.f2369c)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo17600g()).compareTo(Boolean.valueOf(fgVar.mo17600g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo17600g() && (a4 = C1908ja.m4589a(this.f2370c, fgVar.f2370c)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo17601h()).compareTo(Boolean.valueOf(fgVar.mo17601h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo17601h() && (a3 = C1908ja.m4589a(this.f2372d, fgVar.f2372d)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo17603i()).compareTo(Boolean.valueOf(fgVar.mo17603i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo17603i() && (a2 = C1908ja.m4586a(this.f2371d, fgVar.f2371d)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo17604j()).compareTo(Boolean.valueOf(fgVar.mo17604j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo17604j() || (a = C1908ja.m4586a(this.f2373e, fgVar.f2373e)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1790fg mo17575a(byte b) {
        this.f2363a = b;
        mo17580a(true);
        return this;
    }

    /* renamed from: a */
    public C1790fg mo17576a(int i) {
        this.f2364a = i;
        mo17584b(true);
        return this;
    }

    /* renamed from: a */
    public C1790fg mo17577a(String str) {
        this.f2365a = str;
        return this;
    }

    /* renamed from: a */
    public void mo17578a() {
        if (this.f2365a == null) {
            throw new C1921jl("Required field 'connpt' was not present! Struct: " + toString());
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
            if (r1 != 0) goto L_0x0075
            r6.mo18350f()
            boolean r6 = r5.mo17578a()
            if (r6 == 0) goto L_0x005a
            boolean r6 = r5.mo17585b()
            if (r6 == 0) goto L_0x003f
            boolean r6 = r5.mo17589c()
            if (r6 == 0) goto L_0x0024
            r5.mo17578a()
            return
        L_0x0024:
            com.xiaomi.push.jl r6 = new com.xiaomi.push.jl
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'value' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x003f:
            com.xiaomi.push.jl r6 = new com.xiaomi.push.jl
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'type' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x005a:
            com.xiaomi.push.jl r6 = new com.xiaomi.push.jl
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'chid' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x0075:
            short r1 = r0.f3528a
            r2 = 11
            r3 = 8
            r4 = 1
            switch(r1) {
                case 1: goto L_0x00f9;
                case 2: goto L_0x00eb;
                case 3: goto L_0x00dd;
                case 4: goto L_0x00d2;
                case 5: goto L_0x00c7;
                case 6: goto L_0x00b9;
                case 7: goto L_0x00ae;
                case 8: goto L_0x00a3;
                case 9: goto L_0x0095;
                case 10: goto L_0x0086;
                default: goto L_0x007f;
            }
        L_0x007f:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r6, r0)
            goto L_0x0107
        L_0x0086:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x007f
            int r0 = r6.mo18332a()
            r5.f2373e = r0
            r5.mo17598f(r4)
            goto L_0x0107
        L_0x0095:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x007f
            int r0 = r6.mo18332a()
            r5.f2371d = r0
            r5.mo17595e(r4)
            goto L_0x0107
        L_0x00a3:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x007f
            java.lang.String r0 = r6.mo18332a()
            r5.f2372d = r0
            goto L_0x0107
        L_0x00ae:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x007f
            java.lang.String r0 = r6.mo18332a()
            r5.f2370c = r0
            goto L_0x0107
        L_0x00b9:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x007f
            int r0 = r6.mo18332a()
            r5.f2369c = r0
            r5.mo17593d((boolean) r4)
            goto L_0x0107
        L_0x00c7:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x007f
            java.lang.String r0 = r6.mo18332a()
            r5.f2368b = r0
            goto L_0x0107
        L_0x00d2:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x007f
            java.lang.String r0 = r6.mo18332a()
            r5.f2365a = r0
            goto L_0x0107
        L_0x00dd:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x007f
            int r0 = r6.mo18332a()
            r5.f2367b = r0
            r5.mo17588c((boolean) r4)
            goto L_0x0107
        L_0x00eb:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x007f
            int r0 = r6.mo18332a()
            r5.f2364a = r0
            r5.mo17584b((boolean) r4)
            goto L_0x0107
        L_0x00f9:
            byte r1 = r0.f3526a
            r2 = 3
            if (r1 != r2) goto L_0x007f
            byte r0 = r6.mo18332a()
            r5.f2363a = r0
            r5.mo17580a((boolean) r4)
        L_0x0107:
            r6.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1790fg.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo17580a(boolean z) {
        this.f2366a.set(0, z);
    }

    /* renamed from: a */
    public boolean m3498a() {
        return this.f2366a.get(0);
    }

    /* renamed from: a */
    public boolean m3499a(C1790fg fgVar) {
        if (fgVar == null || this.f2363a != fgVar.f2363a || this.f2364a != fgVar.f2364a || this.f2367b != fgVar.f2367b) {
            return false;
        }
        boolean d = mo17594d();
        boolean d2 = fgVar.mo17594d();
        if ((d || d2) && (!d || !d2 || !this.f2365a.equals(fgVar.f2365a))) {
            return false;
        }
        boolean e = mo17596e();
        boolean e2 = fgVar.mo17596e();
        if ((e || e2) && (!e || !e2 || !this.f2368b.equals(fgVar.f2368b))) {
            return false;
        }
        boolean f = mo17599f();
        boolean f2 = fgVar.mo17599f();
        if ((f || f2) && (!f || !f2 || this.f2369c != fgVar.f2369c)) {
            return false;
        }
        boolean g = mo17600g();
        boolean g2 = fgVar.mo17600g();
        if ((g || g2) && (!g || !g2 || !this.f2370c.equals(fgVar.f2370c))) {
            return false;
        }
        boolean h = mo17601h();
        boolean h2 = fgVar.mo17601h();
        if ((h || h2) && (!h || !h2 || !this.f2372d.equals(fgVar.f2372d))) {
            return false;
        }
        boolean i = mo17603i();
        boolean i2 = fgVar.mo17603i();
        if ((i || i2) && (!i || !i2 || this.f2371d != fgVar.f2371d)) {
            return false;
        }
        boolean j = mo17604j();
        boolean j2 = fgVar.mo17604j();
        if (j || j2) {
            return j && j2 && this.f2373e == fgVar.f2373e;
        }
        return true;
    }

    /* renamed from: b */
    public C1790fg mo17581b(int i) {
        this.f2367b = i;
        mo17588c(true);
        return this;
    }

    /* renamed from: b */
    public C1790fg mo17582b(String str) {
        this.f2368b = str;
        return this;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17578a();
        jkVar.mo18339a(f2353a);
        jkVar.mo18336a(f2352a);
        jkVar.mo18334a(this.f2363a);
        jkVar.mo18344b();
        jkVar.mo18336a(f2354b);
        jkVar.mo18333a(this.f2364a);
        jkVar.mo18344b();
        jkVar.mo18336a(f2355c);
        jkVar.mo18333a(this.f2367b);
        jkVar.mo18344b();
        if (this.f2365a != null) {
            jkVar.mo18336a(f2356d);
            jkVar.mo18340a(this.f2365a);
            jkVar.mo18344b();
        }
        if (this.f2368b != null && mo17596e()) {
            jkVar.mo18336a(f2357e);
            jkVar.mo18340a(this.f2368b);
            jkVar.mo18344b();
        }
        if (mo17599f()) {
            jkVar.mo18336a(f2358f);
            jkVar.mo18333a(this.f2369c);
            jkVar.mo18344b();
        }
        if (this.f2370c != null && mo17600g()) {
            jkVar.mo18336a(f2359g);
            jkVar.mo18340a(this.f2370c);
            jkVar.mo18344b();
        }
        if (this.f2372d != null && mo17601h()) {
            jkVar.mo18336a(f2360h);
            jkVar.mo18340a(this.f2372d);
            jkVar.mo18344b();
        }
        if (mo17603i()) {
            jkVar.mo18336a(f2361i);
            jkVar.mo18333a(this.f2371d);
            jkVar.mo18344b();
        }
        if (mo17604j()) {
            jkVar.mo18336a(f2362j);
            jkVar.mo18333a(this.f2373e);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo17584b(boolean z) {
        this.f2366a.set(1, z);
    }

    /* renamed from: b */
    public boolean mo17585b() {
        return this.f2366a.get(1);
    }

    /* renamed from: c */
    public C1790fg mo17586c(int i) {
        this.f2369c = i;
        mo17593d(true);
        return this;
    }

    /* renamed from: c */
    public C1790fg mo17587c(String str) {
        this.f2370c = str;
        return this;
    }

    /* renamed from: c */
    public void mo17588c(boolean z) {
        this.f2366a.set(2, z);
    }

    /* renamed from: c */
    public boolean mo17589c() {
        return this.f2366a.get(2);
    }

    /* renamed from: d */
    public C1790fg mo17591d(int i) {
        this.f2371d = i;
        mo17595e(true);
        return this;
    }

    /* renamed from: d */
    public C1790fg mo17592d(String str) {
        this.f2372d = str;
        return this;
    }

    /* renamed from: d */
    public void mo17593d(boolean z) {
        this.f2366a.set(3, z);
    }

    /* renamed from: d */
    public boolean mo17594d() {
        return this.f2365a != null;
    }

    /* renamed from: e */
    public void mo17595e(boolean z) {
        this.f2366a.set(4, z);
    }

    /* renamed from: e */
    public boolean mo17596e() {
        return this.f2368b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1790fg)) {
            return compareTo((C1790fg) obj);
        }
        return false;
    }

    /* renamed from: f */
    public void mo17598f(boolean z) {
        this.f2366a.set(5, z);
    }

    /* renamed from: f */
    public boolean mo17599f() {
        return this.f2366a.get(3);
    }

    /* renamed from: g */
    public boolean mo17600g() {
        return this.f2370c != null;
    }

    /* renamed from: h */
    public boolean mo17601h() {
        return this.f2372d != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo17603i() {
        return this.f2366a.get(4);
    }

    /* renamed from: j */
    public boolean mo17604j() {
        return this.f2366a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append(this.f2363a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f2364a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f2367b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f2365a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (mo17596e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f2368b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (mo17599f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f2369c);
        }
        if (mo17600g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f2370c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (mo17601h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f2372d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo17603i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f2371d);
        }
        if (mo17604j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f2373e);
        }
        sb.append(")");
        return sb.toString();
    }
}
