package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.ia */
public class C1881ia implements C1906iz<C1881ia, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f2977a = new C1917jh("", (byte) 12, 1);

    /* renamed from: a */
    private static final C1925jp f2978a = new C1925jp("PushMessage");

    /* renamed from: b */
    private static final C1917jh f2979b = new C1917jh("", (byte) 11, 2);

    /* renamed from: c */
    private static final C1917jh f2980c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f2981d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f2982e = new C1917jh("", (byte) 10, 5);

    /* renamed from: f */
    private static final C1917jh f2983f = new C1917jh("", (byte) 10, 6);

    /* renamed from: g */
    private static final C1917jh f2984g = new C1917jh("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1917jh f2985h = new C1917jh("", (byte) 11, 8);

    /* renamed from: i */
    private static final C1917jh f2986i = new C1917jh("", (byte) 11, 9);

    /* renamed from: j */
    private static final C1917jh f2987j = new C1917jh("", (byte) 11, 10);

    /* renamed from: k */
    private static final C1917jh f2988k = new C1917jh("", (byte) 11, 11);

    /* renamed from: l */
    private static final C1917jh f2989l = new C1917jh("", (byte) 12, 12);

    /* renamed from: m */
    private static final C1917jh f2990m = new C1917jh("", (byte) 11, 13);

    /* renamed from: n */
    private static final C1917jh f2991n = new C1917jh("", (byte) 2, 14);

    /* renamed from: o */
    private static final C1917jh f2992o = new C1917jh("", (byte) 11, 15);

    /* renamed from: p */
    private static final C1917jh f2993p = new C1917jh("", (byte) 10, 16);

    /* renamed from: q */
    private static final C1917jh f2994q = new C1917jh("", (byte) 11, 20);

    /* renamed from: r */
    private static final C1917jh f2995r = new C1917jh("", (byte) 11, 21);

    /* renamed from: a */
    public long f2996a;

    /* renamed from: a */
    public C1882ib f2997a;

    /* renamed from: a */
    public C1884id f2998a;

    /* renamed from: a */
    public String f2999a;

    /* renamed from: a */
    private BitSet f3000a = new BitSet(4);

    /* renamed from: a */
    public boolean f3001a = false;

    /* renamed from: b */
    public long f3002b;

    /* renamed from: b */
    public String f3003b;

    /* renamed from: c */
    public long f3004c;

    /* renamed from: c */
    public String f3005c;

    /* renamed from: d */
    public String f3006d;

    /* renamed from: e */
    public String f3007e;

    /* renamed from: f */
    public String f3008f;

    /* renamed from: g */
    public String f3009g;

    /* renamed from: h */
    public String f3010h;

    /* renamed from: i */
    public String f3011i;

    /* renamed from: j */
    public String f3012j;

    /* renamed from: k */
    public String f3013k;

    /* renamed from: l */
    public String f3014l;

    /* renamed from: a */
    public int compareTo(C1881ia iaVar) {
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
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        if (!getClass().equals(iaVar.getClass())) {
            return getClass().getName().compareTo(iaVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17850a()).compareTo(Boolean.valueOf(iaVar.mo17850a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17850a() && (a18 = C1908ja.m4588a((Comparable) this.f2998a, (Comparable) iaVar.f2998a)) != 0) {
            return a18;
        }
        int compareTo2 = Boolean.valueOf(mo17852b()).compareTo(Boolean.valueOf(iaVar.mo17852b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo17852b() && (a17 = C1908ja.m4589a(this.f2999a, iaVar.f2999a)) != 0) {
            return a17;
        }
        int compareTo3 = Boolean.valueOf(mo17854c()).compareTo(Boolean.valueOf(iaVar.mo17854c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo17854c() && (a16 = C1908ja.m4589a(this.f3003b, iaVar.f3003b)) != 0) {
            return a16;
        }
        int compareTo4 = Boolean.valueOf(mo17858d()).compareTo(Boolean.valueOf(iaVar.mo17858d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo17858d() && (a15 = C1908ja.m4589a(this.f3005c, iaVar.f3005c)) != 0) {
            return a15;
        }
        int compareTo5 = Boolean.valueOf(mo17859e()).compareTo(Boolean.valueOf(iaVar.mo17859e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo17859e() && (a14 = C1908ja.m4587a(this.f2996a, iaVar.f2996a)) != 0) {
            return a14;
        }
        int compareTo6 = Boolean.valueOf(mo17861f()).compareTo(Boolean.valueOf(iaVar.mo17861f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo17861f() && (a13 = C1908ja.m4587a(this.f3002b, iaVar.f3002b)) != 0) {
            return a13;
        }
        int compareTo7 = Boolean.valueOf(mo17862g()).compareTo(Boolean.valueOf(iaVar.mo17862g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo17862g() && (a12 = C1908ja.m4589a(this.f3006d, iaVar.f3006d)) != 0) {
            return a12;
        }
        int compareTo8 = Boolean.valueOf(mo17863h()).compareTo(Boolean.valueOf(iaVar.mo17863h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo17863h() && (a11 = C1908ja.m4589a(this.f3007e, iaVar.f3007e)) != 0) {
            return a11;
        }
        int compareTo9 = Boolean.valueOf(mo17865i()).compareTo(Boolean.valueOf(iaVar.mo17865i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo17865i() && (a10 = C1908ja.m4589a(this.f3008f, iaVar.f3008f)) != 0) {
            return a10;
        }
        int compareTo10 = Boolean.valueOf(mo17866j()).compareTo(Boolean.valueOf(iaVar.mo17866j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (mo17866j() && (a9 = C1908ja.m4589a(this.f3009g, iaVar.f3009g)) != 0) {
            return a9;
        }
        int compareTo11 = Boolean.valueOf(mo17867k()).compareTo(Boolean.valueOf(iaVar.mo17867k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (mo17867k() && (a8 = C1908ja.m4589a(this.f3010h, iaVar.f3010h)) != 0) {
            return a8;
        }
        int compareTo12 = Boolean.valueOf(mo17868l()).compareTo(Boolean.valueOf(iaVar.mo17868l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (mo17868l() && (a7 = C1908ja.m4588a((Comparable) this.f2997a, (Comparable) iaVar.f2997a)) != 0) {
            return a7;
        }
        int compareTo13 = Boolean.valueOf(mo17869m()).compareTo(Boolean.valueOf(iaVar.mo17869m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (mo17869m() && (a6 = C1908ja.m4589a(this.f3011i, iaVar.f3011i)) != 0) {
            return a6;
        }
        int compareTo14 = Boolean.valueOf(mo17870n()).compareTo(Boolean.valueOf(iaVar.mo17870n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (mo17870n() && (a5 = C1908ja.m4595a(this.f3001a, iaVar.f3001a)) != 0) {
            return a5;
        }
        int compareTo15 = Boolean.valueOf(mo17871o()).compareTo(Boolean.valueOf(iaVar.mo17871o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (mo17871o() && (a4 = C1908ja.m4589a(this.f3012j, iaVar.f3012j)) != 0) {
            return a4;
        }
        int compareTo16 = Boolean.valueOf(mo17872p()).compareTo(Boolean.valueOf(iaVar.mo17872p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (mo17872p() && (a3 = C1908ja.m4587a(this.f3004c, iaVar.f3004c)) != 0) {
            return a3;
        }
        int compareTo17 = Boolean.valueOf(mo17873q()).compareTo(Boolean.valueOf(iaVar.mo17873q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (mo17873q() && (a2 = C1908ja.m4589a(this.f3013k, iaVar.f3013k)) != 0) {
            return a2;
        }
        int compareTo18 = Boolean.valueOf(mo17874r()).compareTo(Boolean.valueOf(iaVar.mo17874r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!mo17874r() || (a = C1908ja.m4589a(this.f3014l, iaVar.f3014l)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public long mo17850a() {
        return this.f2996a;
    }

    /* renamed from: a */
    public String m4003a() {
        return this.f2999a;
    }

    /* renamed from: a */
    public void m4004a() {
        if (this.f2999a == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3003b == null) {
            throw new C1921jl("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f3005c == null) {
            throw new C1921jl("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17579a(com.xiaomi.push.C1920jk r7) {
        /*
            r6 = this;
            r7.mo18332a()
        L_0x0003:
            com.xiaomi.push.jh r0 = r7.mo18332a()
            byte r1 = r0.f3526a
            if (r1 != 0) goto L_0x0012
            r7.mo18350f()
            r6.mo17850a()
            return
        L_0x0012:
            short r1 = r0.f3528a
            r2 = 20
            r3 = 11
            if (r1 == r2) goto L_0x010a
            r2 = 21
            if (r1 == r2) goto L_0x00ff
            r2 = 12
            r4 = 10
            r5 = 1
            switch(r1) {
                case 1: goto L_0x00ee;
                case 2: goto L_0x00e3;
                case 3: goto L_0x00d8;
                case 4: goto L_0x00cd;
                case 5: goto L_0x00bf;
                case 6: goto L_0x00b1;
                case 7: goto L_0x00a6;
                case 8: goto L_0x009a;
                case 9: goto L_0x008e;
                case 10: goto L_0x0082;
                case 11: goto L_0x0076;
                case 12: goto L_0x0064;
                case 13: goto L_0x0058;
                case 14: goto L_0x0048;
                case 15: goto L_0x003c;
                case 16: goto L_0x002d;
                default: goto L_0x0026;
            }
        L_0x0026:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r7, r0)
            goto L_0x0114
        L_0x002d:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x0026
            long r0 = r7.mo18332a()
            r6.f3004c = r0
            r6.mo17857d(r5)
            goto L_0x0114
        L_0x003c:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f3012j = r0
            goto L_0x0114
        L_0x0048:
            byte r1 = r0.f3526a
            r2 = 2
            if (r1 != r2) goto L_0x0026
            boolean r0 = r7.mo18332a()
            r6.f3001a = r0
            r6.mo17855c(r5)
            goto L_0x0114
        L_0x0058:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f3011i = r0
            goto L_0x0114
        L_0x0064:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0026
            com.xiaomi.push.ib r0 = new com.xiaomi.push.ib
            r0.<init>()
            r6.f2997a = r0
            com.xiaomi.push.ib r0 = r6.f2997a
            r0.mo17579a((com.xiaomi.push.C1920jk) r7)
            goto L_0x0114
        L_0x0076:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f3010h = r0
            goto L_0x0114
        L_0x0082:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f3009g = r0
            goto L_0x0114
        L_0x008e:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f3008f = r0
            goto L_0x0114
        L_0x009a:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f3007e = r0
            goto L_0x0114
        L_0x00a6:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f3006d = r0
            goto L_0x0114
        L_0x00b1:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x0026
            long r0 = r7.mo18332a()
            r6.f3002b = r0
            r6.mo17853b((boolean) r5)
            goto L_0x0114
        L_0x00bf:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x0026
            long r0 = r7.mo18332a()
            r6.f2996a = r0
            r6.mo17851a((boolean) r5)
            goto L_0x0114
        L_0x00cd:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f3005c = r0
            goto L_0x0114
        L_0x00d8:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f3003b = r0
            goto L_0x0114
        L_0x00e3:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f2999a = r0
            goto L_0x0114
        L_0x00ee:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0026
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r6.f2998a = r0
            com.xiaomi.push.id r0 = r6.f2998a
            r0.mo17579a((com.xiaomi.push.C1920jk) r7)
            goto L_0x0114
        L_0x00ff:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f3014l = r0
            goto L_0x0114
        L_0x010a:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.mo18332a()
            r6.f3013k = r0
        L_0x0114:
            r7.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1881ia.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo17851a(boolean z) {
        this.f3000a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4007a() {
        return this.f2998a != null;
    }

    /* renamed from: a */
    public boolean m4008a(C1881ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean a = mo17850a();
        boolean a2 = iaVar.mo17850a();
        if ((a || a2) && (!a || !a2 || !this.f2998a.compareTo(iaVar.f2998a))) {
            return false;
        }
        boolean b = mo17852b();
        boolean b2 = iaVar.mo17852b();
        if ((b || b2) && (!b || !b2 || !this.f2999a.equals(iaVar.f2999a))) {
            return false;
        }
        boolean c = mo17854c();
        boolean c2 = iaVar.mo17854c();
        if ((c || c2) && (!c || !c2 || !this.f3003b.equals(iaVar.f3003b))) {
            return false;
        }
        boolean d = mo17858d();
        boolean d2 = iaVar.mo17858d();
        if ((d || d2) && (!d || !d2 || !this.f3005c.equals(iaVar.f3005c))) {
            return false;
        }
        boolean e = mo17859e();
        boolean e2 = iaVar.mo17859e();
        if ((e || e2) && (!e || !e2 || this.f2996a != iaVar.f2996a)) {
            return false;
        }
        boolean f = mo17861f();
        boolean f2 = iaVar.mo17861f();
        if ((f || f2) && (!f || !f2 || this.f3002b != iaVar.f3002b)) {
            return false;
        }
        boolean g = mo17862g();
        boolean g2 = iaVar.mo17862g();
        if ((g || g2) && (!g || !g2 || !this.f3006d.equals(iaVar.f3006d))) {
            return false;
        }
        boolean h = mo17863h();
        boolean h2 = iaVar.mo17863h();
        if ((h || h2) && (!h || !h2 || !this.f3007e.equals(iaVar.f3007e))) {
            return false;
        }
        boolean i = mo17865i();
        boolean i2 = iaVar.mo17865i();
        if ((i || i2) && (!i || !i2 || !this.f3008f.equals(iaVar.f3008f))) {
            return false;
        }
        boolean j = mo17866j();
        boolean j2 = iaVar.mo17866j();
        if ((j || j2) && (!j || !j2 || !this.f3009g.equals(iaVar.f3009g))) {
            return false;
        }
        boolean k = mo17867k();
        boolean k2 = iaVar.mo17867k();
        if ((k || k2) && (!k || !k2 || !this.f3010h.equals(iaVar.f3010h))) {
            return false;
        }
        boolean l = mo17868l();
        boolean l2 = iaVar.mo17868l();
        if ((l || l2) && (!l || !l2 || !this.f2997a.compareTo(iaVar.f2997a))) {
            return false;
        }
        boolean m = mo17869m();
        boolean m2 = iaVar.mo17869m();
        if ((m || m2) && (!m || !m2 || !this.f3011i.equals(iaVar.f3011i))) {
            return false;
        }
        boolean n = mo17870n();
        boolean n2 = iaVar.mo17870n();
        if ((n || n2) && (!n || !n2 || this.f3001a != iaVar.f3001a)) {
            return false;
        }
        boolean o = mo17871o();
        boolean o2 = iaVar.mo17871o();
        if ((o || o2) && (!o || !o2 || !this.f3012j.equals(iaVar.f3012j))) {
            return false;
        }
        boolean p = mo17872p();
        boolean p2 = iaVar.mo17872p();
        if ((p || p2) && (!p || !p2 || this.f3004c != iaVar.f3004c)) {
            return false;
        }
        boolean q = mo17873q();
        boolean q2 = iaVar.mo17873q();
        if ((q || q2) && (!q || !q2 || !this.f3013k.equals(iaVar.f3013k))) {
            return false;
        }
        boolean r = mo17874r();
        boolean r2 = iaVar.mo17874r();
        if (r || r2) {
            return r && r2 && this.f3014l.equals(iaVar.f3014l);
        }
        return true;
    }

    /* renamed from: b */
    public String mo17852b() {
        return this.f3003b;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17850a();
        jkVar.mo18339a(f2978a);
        if (this.f2998a != null && mo17850a()) {
            jkVar.mo18336a(f2977a);
            this.f2998a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f2999a != null) {
            jkVar.mo18336a(f2979b);
            jkVar.mo18340a(this.f2999a);
            jkVar.mo18344b();
        }
        if (this.f3003b != null) {
            jkVar.mo18336a(f2980c);
            jkVar.mo18340a(this.f3003b);
            jkVar.mo18344b();
        }
        if (this.f3005c != null) {
            jkVar.mo18336a(f2981d);
            jkVar.mo18340a(this.f3005c);
            jkVar.mo18344b();
        }
        if (mo17859e()) {
            jkVar.mo18336a(f2982e);
            jkVar.mo18335a(this.f2996a);
            jkVar.mo18344b();
        }
        if (mo17861f()) {
            jkVar.mo18336a(f2983f);
            jkVar.mo18335a(this.f3002b);
            jkVar.mo18344b();
        }
        if (this.f3006d != null && mo17862g()) {
            jkVar.mo18336a(f2984g);
            jkVar.mo18340a(this.f3006d);
            jkVar.mo18344b();
        }
        if (this.f3007e != null && mo17863h()) {
            jkVar.mo18336a(f2985h);
            jkVar.mo18340a(this.f3007e);
            jkVar.mo18344b();
        }
        if (this.f3008f != null && mo17865i()) {
            jkVar.mo18336a(f2986i);
            jkVar.mo18340a(this.f3008f);
            jkVar.mo18344b();
        }
        if (this.f3009g != null && mo17866j()) {
            jkVar.mo18336a(f2987j);
            jkVar.mo18340a(this.f3009g);
            jkVar.mo18344b();
        }
        if (this.f3010h != null && mo17867k()) {
            jkVar.mo18336a(f2988k);
            jkVar.mo18340a(this.f3010h);
            jkVar.mo18344b();
        }
        if (this.f2997a != null && mo17868l()) {
            jkVar.mo18336a(f2989l);
            this.f2997a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3011i != null && mo17869m()) {
            jkVar.mo18336a(f2990m);
            jkVar.mo18340a(this.f3011i);
            jkVar.mo18344b();
        }
        if (mo17870n()) {
            jkVar.mo18336a(f2991n);
            jkVar.mo18343a(this.f3001a);
            jkVar.mo18344b();
        }
        if (this.f3012j != null && mo17871o()) {
            jkVar.mo18336a(f2992o);
            jkVar.mo18340a(this.f3012j);
            jkVar.mo18344b();
        }
        if (mo17872p()) {
            jkVar.mo18336a(f2993p);
            jkVar.mo18335a(this.f3004c);
            jkVar.mo18344b();
        }
        if (this.f3013k != null && mo17873q()) {
            jkVar.mo18336a(f2994q);
            jkVar.mo18340a(this.f3013k);
            jkVar.mo18344b();
        }
        if (this.f3014l != null && mo17874r()) {
            jkVar.mo18336a(f2995r);
            jkVar.mo18340a(this.f3014l);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo17853b(boolean z) {
        this.f3000a.set(1, z);
    }

    /* renamed from: b */
    public boolean m4012b() {
        return this.f2999a != null;
    }

    /* renamed from: c */
    public String mo17854c() {
        return this.f3005c;
    }

    /* renamed from: c */
    public void mo17855c(boolean z) {
        this.f3000a.set(2, z);
    }

    /* renamed from: c */
    public boolean m4015c() {
        return this.f3003b != null;
    }

    /* renamed from: d */
    public void mo17857d(boolean z) {
        this.f3000a.set(3, z);
    }

    /* renamed from: d */
    public boolean mo17858d() {
        return this.f3005c != null;
    }

    /* renamed from: e */
    public boolean mo17859e() {
        return this.f3000a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1881ia)) {
            return compareTo((C1881ia) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo17861f() {
        return this.f3000a.get(1);
    }

    /* renamed from: g */
    public boolean mo17862g() {
        return this.f3006d != null;
    }

    /* renamed from: h */
    public boolean mo17863h() {
        return this.f3007e != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo17865i() {
        return this.f3008f != null;
    }

    /* renamed from: j */
    public boolean mo17866j() {
        return this.f3009g != null;
    }

    /* renamed from: k */
    public boolean mo17867k() {
        return this.f3010h != null;
    }

    /* renamed from: l */
    public boolean mo17868l() {
        return this.f2997a != null;
    }

    /* renamed from: m */
    public boolean mo17869m() {
        return this.f3011i != null;
    }

    /* renamed from: n */
    public boolean mo17870n() {
        return this.f3000a.get(2);
    }

    /* renamed from: o */
    public boolean mo17871o() {
        return this.f3012j != null;
    }

    /* renamed from: p */
    public boolean mo17872p() {
        return this.f3000a.get(3);
    }

    /* renamed from: q */
    public boolean mo17873q() {
        return this.f3013k != null;
    }

    /* renamed from: r */
    public boolean mo17874r() {
        return this.f3014l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (mo17850a()) {
            sb.append("to:");
            C1884id idVar = this.f2998a;
            if (idVar == null) {
                sb.append("null");
            } else {
                sb.append(idVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f2999a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f3003b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f3005c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (mo17859e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f2996a);
        }
        if (mo17861f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f3002b);
        }
        if (mo17862g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f3006d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo17863h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f3007e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo17865i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f3008f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (mo17866j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f3009g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (mo17867k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f3010h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (mo17868l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            C1882ib ibVar = this.f2997a;
            if (ibVar == null) {
                sb.append("null");
            } else {
                sb.append(ibVar);
            }
        }
        if (mo17869m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f3011i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (mo17870n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f3001a);
        }
        if (mo17871o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f3012j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (mo17872p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f3004c);
        }
        if (mo17873q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f3013k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (mo17874r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f3014l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
