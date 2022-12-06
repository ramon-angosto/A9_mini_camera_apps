package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Map;

/* renamed from: com.xiaomi.push.ie */
public class C1885ie implements C1906iz<C1885ie, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3062a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f3063a = new C1925jp("XmPushActionAckMessage");

    /* renamed from: b */
    private static final C1917jh f3064b = new C1917jh("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1917jh f3065c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3066d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3067e = new C1917jh("", (byte) 10, 5);

    /* renamed from: f */
    private static final C1917jh f3068f = new C1917jh("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1917jh f3069g = new C1917jh("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1917jh f3070h = new C1917jh("", (byte) 12, 8);

    /* renamed from: i */
    private static final C1917jh f3071i = new C1917jh("", (byte) 11, 9);

    /* renamed from: j */
    private static final C1917jh f3072j = new C1917jh("", (byte) 11, 10);

    /* renamed from: k */
    private static final C1917jh f3073k = new C1917jh("", (byte) 2, 11);

    /* renamed from: l */
    private static final C1917jh f3074l = new C1917jh("", (byte) 11, 12);

    /* renamed from: m */
    private static final C1917jh f3075m = new C1917jh("", (byte) 11, 13);

    /* renamed from: n */
    private static final C1917jh f3076n = new C1917jh("", (byte) 11, 14);

    /* renamed from: o */
    private static final C1917jh f3077o = new C1917jh("", (byte) 6, 15);

    /* renamed from: p */
    private static final C1917jh f3078p = new C1917jh("", (byte) 6, 16);

    /* renamed from: q */
    private static final C1917jh f3079q = new C1917jh("", (byte) 11, 20);

    /* renamed from: r */
    private static final C1917jh f3080r = new C1917jh("", (byte) 11, 21);

    /* renamed from: s */
    private static final C1917jh f3081s = new C1917jh("", (byte) 8, 22);

    /* renamed from: t */
    private static final C1917jh f3082t = new C1917jh("", (byte) 13, 23);

    /* renamed from: a */
    public int f3083a;

    /* renamed from: a */
    public long f3084a;

    /* renamed from: a */
    public C1884id f3085a;

    /* renamed from: a */
    public C1898ir f3086a;

    /* renamed from: a */
    public String f3087a;

    /* renamed from: a */
    private BitSet f3088a = new BitSet(5);

    /* renamed from: a */
    public Map<String, String> f3089a;

    /* renamed from: a */
    public short f3090a;

    /* renamed from: a */
    public boolean f3091a = false;

    /* renamed from: b */
    public String f3092b;

    /* renamed from: b */
    public short f3093b;

    /* renamed from: c */
    public String f3094c;

    /* renamed from: d */
    public String f3095d;

    /* renamed from: e */
    public String f3096e;

    /* renamed from: f */
    public String f3097f;

    /* renamed from: g */
    public String f3098g;

    /* renamed from: h */
    public String f3099h;

    /* renamed from: i */
    public String f3100i;

    /* renamed from: j */
    public String f3101j;

    /* renamed from: k */
    public String f3102k;

    /* renamed from: l */
    public String f3103l;

    /* renamed from: a */
    public int compareTo(C1885ie ieVar) {
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
        int a19;
        int a20;
        if (!getClass().equals(ieVar.getClass())) {
            return getClass().getName().compareTo(ieVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17928a()).compareTo(Boolean.valueOf(ieVar.mo17928a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17928a() && (a20 = C1908ja.m4589a(this.f3087a, ieVar.f3087a)) != 0) {
            return a20;
        }
        int compareTo2 = Boolean.valueOf(mo17932b()).compareTo(Boolean.valueOf(ieVar.mo17932b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo17932b() && (a19 = C1908ja.m4588a((Comparable) this.f3085a, (Comparable) ieVar.f3085a)) != 0) {
            return a19;
        }
        int compareTo3 = Boolean.valueOf(mo17935c()).compareTo(Boolean.valueOf(ieVar.mo17935c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo17935c() && (a18 = C1908ja.m4589a(this.f3092b, ieVar.f3092b)) != 0) {
            return a18;
        }
        int compareTo4 = Boolean.valueOf(mo17939d()).compareTo(Boolean.valueOf(ieVar.mo17939d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo17939d() && (a17 = C1908ja.m4589a(this.f3094c, ieVar.f3094c)) != 0) {
            return a17;
        }
        int compareTo5 = Boolean.valueOf(mo17941e()).compareTo(Boolean.valueOf(ieVar.mo17941e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo17941e() && (a16 = C1908ja.m4587a(this.f3084a, ieVar.f3084a)) != 0) {
            return a16;
        }
        int compareTo6 = Boolean.valueOf(mo17943f()).compareTo(Boolean.valueOf(ieVar.mo17943f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo17943f() && (a15 = C1908ja.m4589a(this.f3095d, ieVar.f3095d)) != 0) {
            return a15;
        }
        int compareTo7 = Boolean.valueOf(mo17944g()).compareTo(Boolean.valueOf(ieVar.mo17944g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo17944g() && (a14 = C1908ja.m4589a(this.f3096e, ieVar.f3096e)) != 0) {
            return a14;
        }
        int compareTo8 = Boolean.valueOf(mo17945h()).compareTo(Boolean.valueOf(ieVar.mo17945h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo17945h() && (a13 = C1908ja.m4588a((Comparable) this.f3086a, (Comparable) ieVar.f3086a)) != 0) {
            return a13;
        }
        int compareTo9 = Boolean.valueOf(mo17947i()).compareTo(Boolean.valueOf(ieVar.mo17947i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo17947i() && (a12 = C1908ja.m4589a(this.f3097f, ieVar.f3097f)) != 0) {
            return a12;
        }
        int compareTo10 = Boolean.valueOf(mo17948j()).compareTo(Boolean.valueOf(ieVar.mo17948j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (mo17948j() && (a11 = C1908ja.m4589a(this.f3098g, ieVar.f3098g)) != 0) {
            return a11;
        }
        int compareTo11 = Boolean.valueOf(mo17949k()).compareTo(Boolean.valueOf(ieVar.mo17949k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (mo17949k() && (a10 = C1908ja.m4595a(this.f3091a, ieVar.f3091a)) != 0) {
            return a10;
        }
        int compareTo12 = Boolean.valueOf(mo17950l()).compareTo(Boolean.valueOf(ieVar.mo17950l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (mo17950l() && (a9 = C1908ja.m4589a(this.f3099h, ieVar.f3099h)) != 0) {
            return a9;
        }
        int compareTo13 = Boolean.valueOf(mo17951m()).compareTo(Boolean.valueOf(ieVar.mo17951m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (mo17951m() && (a8 = C1908ja.m4589a(this.f3100i, ieVar.f3100i)) != 0) {
            return a8;
        }
        int compareTo14 = Boolean.valueOf(mo17952n()).compareTo(Boolean.valueOf(ieVar.mo17952n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (mo17952n() && (a7 = C1908ja.m4589a(this.f3101j, ieVar.f3101j)) != 0) {
            return a7;
        }
        int compareTo15 = Boolean.valueOf(mo17953o()).compareTo(Boolean.valueOf(ieVar.mo17953o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (mo17953o() && (a6 = C1908ja.m4594a(this.f3090a, ieVar.f3090a)) != 0) {
            return a6;
        }
        int compareTo16 = Boolean.valueOf(mo17954p()).compareTo(Boolean.valueOf(ieVar.mo17954p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (mo17954p() && (a5 = C1908ja.m4594a(this.f3093b, ieVar.f3093b)) != 0) {
            return a5;
        }
        int compareTo17 = Boolean.valueOf(mo17955q()).compareTo(Boolean.valueOf(ieVar.mo17955q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (mo17955q() && (a4 = C1908ja.m4589a(this.f3102k, ieVar.f3102k)) != 0) {
            return a4;
        }
        int compareTo18 = Boolean.valueOf(mo17956r()).compareTo(Boolean.valueOf(ieVar.mo17956r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (mo17956r() && (a3 = C1908ja.m4589a(this.f3103l, ieVar.f3103l)) != 0) {
            return a3;
        }
        int compareTo19 = Boolean.valueOf(mo17957s()).compareTo(Boolean.valueOf(ieVar.mo17957s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (mo17957s() && (a2 = C1908ja.m4586a(this.f3083a, ieVar.f3083a)) != 0) {
            return a2;
        }
        int compareTo20 = Boolean.valueOf(mo17958t()).compareTo(Boolean.valueOf(ieVar.mo17958t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!mo17958t() || (a = C1908ja.m4592a((Map) this.f3089a, (Map) ieVar.f3089a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1885ie mo17925a(long j) {
        this.f3084a = j;
        mo17929a(true);
        return this;
    }

    /* renamed from: a */
    public C1885ie mo17926a(String str) {
        this.f3092b = str;
        return this;
    }

    /* renamed from: a */
    public C1885ie mo17927a(short s) {
        this.f3090a = s;
        mo17934c(true);
        return this;
    }

    /* renamed from: a */
    public void mo17928a() {
        if (this.f3092b == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3094c == null) {
            throw new C1921jl("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17579a(com.xiaomi.push.C1920jk r8) {
        /*
            r7 = this;
            r8.mo18332a()
        L_0x0003:
            com.xiaomi.push.jh r0 = r8.mo18332a()
            byte r1 = r0.f3526a
            if (r1 != 0) goto L_0x0033
            r8.mo18350f()
            boolean r8 = r7.mo17941e()
            if (r8 == 0) goto L_0x0018
            r7.mo17928a()
            return
        L_0x0018:
            com.xiaomi.push.jl r8 = new com.xiaomi.push.jl
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'messageTs' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r7.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x0033:
            short r1 = r0.f3528a
            r2 = 6
            r3 = 2
            r4 = 12
            r5 = 1
            r6 = 11
            switch(r1) {
                case 1: goto L_0x0165;
                case 2: goto L_0x0154;
                case 3: goto L_0x0149;
                case 4: goto L_0x013e;
                case 5: goto L_0x012e;
                case 6: goto L_0x0123;
                case 7: goto L_0x0118;
                case 8: goto L_0x0107;
                case 9: goto L_0x00fb;
                case 10: goto L_0x00ef;
                case 11: goto L_0x00e0;
                case 12: goto L_0x00d4;
                case 13: goto L_0x00c8;
                case 14: goto L_0x00bc;
                case 15: goto L_0x00ad;
                case 16: goto L_0x009e;
                case 17: goto L_0x003f;
                case 18: goto L_0x003f;
                case 19: goto L_0x003f;
                case 20: goto L_0x0092;
                case 21: goto L_0x0086;
                case 22: goto L_0x0075;
                case 23: goto L_0x0046;
                default: goto L_0x003f;
            }
        L_0x003f:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r8, r0)
            goto L_0x016f
        L_0x0046:
            byte r1 = r0.f3526a
            r2 = 13
            if (r1 != r2) goto L_0x003f
            com.xiaomi.push.jj r0 = r8.mo18332a()
            java.util.HashMap r1 = new java.util.HashMap
            int r2 = r0.f3532a
            int r2 = r2 * 2
            r1.<init>(r2)
            r7.f3089a = r1
            r1 = 0
        L_0x005c:
            int r2 = r0.f3532a
            if (r1 >= r2) goto L_0x0070
            java.lang.String r2 = r8.mo18332a()
            java.lang.String r3 = r8.mo18332a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r7.f3089a
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x005c
        L_0x0070:
            r8.mo18352h()
            goto L_0x016f
        L_0x0075:
            byte r1 = r0.f3526a
            r2 = 8
            if (r1 != r2) goto L_0x003f
            int r0 = r8.mo18332a()
            r7.f3083a = r0
            r7.mo17940e(r5)
            goto L_0x016f
        L_0x0086:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3103l = r0
            goto L_0x016f
        L_0x0092:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3102k = r0
            goto L_0x016f
        L_0x009e:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x003f
            short r0 = r8.mo18332a()
            r7.f3093b = r0
            r7.mo17938d((boolean) r5)
            goto L_0x016f
        L_0x00ad:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x003f
            short r0 = r8.mo18332a()
            r7.f3090a = r0
            r7.mo17934c((boolean) r5)
            goto L_0x016f
        L_0x00bc:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3101j = r0
            goto L_0x016f
        L_0x00c8:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3100i = r0
            goto L_0x016f
        L_0x00d4:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3099h = r0
            goto L_0x016f
        L_0x00e0:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x003f
            boolean r0 = r8.mo18332a()
            r7.f3091a = r0
            r7.mo17931b((boolean) r5)
            goto L_0x016f
        L_0x00ef:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3098g = r0
            goto L_0x016f
        L_0x00fb:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3097f = r0
            goto L_0x016f
        L_0x0107:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003f
            com.xiaomi.push.ir r0 = new com.xiaomi.push.ir
            r0.<init>()
            r7.f3086a = r0
            com.xiaomi.push.ir r0 = r7.f3086a
            r0.mo17579a((com.xiaomi.push.C1920jk) r8)
            goto L_0x016f
        L_0x0118:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3096e = r0
            goto L_0x016f
        L_0x0123:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3095d = r0
            goto L_0x016f
        L_0x012e:
            byte r1 = r0.f3526a
            r2 = 10
            if (r1 != r2) goto L_0x003f
            long r0 = r8.mo18332a()
            r7.f3084a = r0
            r7.mo17929a((boolean) r5)
            goto L_0x016f
        L_0x013e:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3094c = r0
            goto L_0x016f
        L_0x0149:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3092b = r0
            goto L_0x016f
        L_0x0154:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003f
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r7.f3085a = r0
            com.xiaomi.push.id r0 = r7.f3085a
            r0.mo17579a((com.xiaomi.push.C1920jk) r8)
            goto L_0x016f
        L_0x0165:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x003f
            java.lang.String r0 = r8.mo18332a()
            r7.f3087a = r0
        L_0x016f:
            r8.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1885ie.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo17929a(boolean z) {
        this.f3088a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4099a() {
        return this.f3087a != null;
    }

    /* renamed from: a */
    public boolean m4100a(C1885ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean a = mo17928a();
        boolean a2 = ieVar.mo17928a();
        if ((a || a2) && (!a || !a2 || !this.f3087a.equals(ieVar.f3087a))) {
            return false;
        }
        boolean b = mo17932b();
        boolean b2 = ieVar.mo17932b();
        if ((b || b2) && (!b || !b2 || !this.f3085a.compareTo(ieVar.f3085a))) {
            return false;
        }
        boolean c = mo17935c();
        boolean c2 = ieVar.mo17935c();
        if ((c || c2) && (!c || !c2 || !this.f3092b.equals(ieVar.f3092b))) {
            return false;
        }
        boolean d = mo17939d();
        boolean d2 = ieVar.mo17939d();
        if (((d || d2) && (!d || !d2 || !this.f3094c.equals(ieVar.f3094c))) || this.f3084a != ieVar.f3084a) {
            return false;
        }
        boolean f = mo17943f();
        boolean f2 = ieVar.mo17943f();
        if ((f || f2) && (!f || !f2 || !this.f3095d.equals(ieVar.f3095d))) {
            return false;
        }
        boolean g = mo17944g();
        boolean g2 = ieVar.mo17944g();
        if ((g || g2) && (!g || !g2 || !this.f3096e.equals(ieVar.f3096e))) {
            return false;
        }
        boolean h = mo17945h();
        boolean h2 = ieVar.mo17945h();
        if ((h || h2) && (!h || !h2 || !this.f3086a.compareTo(ieVar.f3086a))) {
            return false;
        }
        boolean i = mo17947i();
        boolean i2 = ieVar.mo17947i();
        if ((i || i2) && (!i || !i2 || !this.f3097f.equals(ieVar.f3097f))) {
            return false;
        }
        boolean j = mo17948j();
        boolean j2 = ieVar.mo17948j();
        if ((j || j2) && (!j || !j2 || !this.f3098g.equals(ieVar.f3098g))) {
            return false;
        }
        boolean k = mo17949k();
        boolean k2 = ieVar.mo17949k();
        if ((k || k2) && (!k || !k2 || this.f3091a != ieVar.f3091a)) {
            return false;
        }
        boolean l = mo17950l();
        boolean l2 = ieVar.mo17950l();
        if ((l || l2) && (!l || !l2 || !this.f3099h.equals(ieVar.f3099h))) {
            return false;
        }
        boolean m = mo17951m();
        boolean m2 = ieVar.mo17951m();
        if ((m || m2) && (!m || !m2 || !this.f3100i.equals(ieVar.f3100i))) {
            return false;
        }
        boolean n = mo17952n();
        boolean n2 = ieVar.mo17952n();
        if ((n || n2) && (!n || !n2 || !this.f3101j.equals(ieVar.f3101j))) {
            return false;
        }
        boolean o = mo17953o();
        boolean o2 = ieVar.mo17953o();
        if ((o || o2) && (!o || !o2 || this.f3090a != ieVar.f3090a)) {
            return false;
        }
        boolean p = mo17954p();
        boolean p2 = ieVar.mo17954p();
        if ((p || p2) && (!p || !p2 || this.f3093b != ieVar.f3093b)) {
            return false;
        }
        boolean q = mo17955q();
        boolean q2 = ieVar.mo17955q();
        if ((q || q2) && (!q || !q2 || !this.f3102k.equals(ieVar.f3102k))) {
            return false;
        }
        boolean r = mo17956r();
        boolean r2 = ieVar.mo17956r();
        if ((r || r2) && (!r || !r2 || !this.f3103l.equals(ieVar.f3103l))) {
            return false;
        }
        boolean s = mo17957s();
        boolean s2 = ieVar.mo17957s();
        if ((s || s2) && (!s || !s2 || this.f3083a != ieVar.f3083a)) {
            return false;
        }
        boolean t = mo17958t();
        boolean t2 = ieVar.mo17958t();
        if (t || t2) {
            return t && t2 && this.f3089a.equals(ieVar.f3089a);
        }
        return true;
    }

    /* renamed from: b */
    public C1885ie mo17930b(String str) {
        this.f3094c = str;
        return this;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17928a();
        jkVar.mo18339a(f3063a);
        if (this.f3087a != null && mo17928a()) {
            jkVar.mo18336a(f3062a);
            jkVar.mo18340a(this.f3087a);
            jkVar.mo18344b();
        }
        if (this.f3085a != null && mo17932b()) {
            jkVar.mo18336a(f3064b);
            this.f3085a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3092b != null) {
            jkVar.mo18336a(f3065c);
            jkVar.mo18340a(this.f3092b);
            jkVar.mo18344b();
        }
        if (this.f3094c != null) {
            jkVar.mo18336a(f3066d);
            jkVar.mo18340a(this.f3094c);
            jkVar.mo18344b();
        }
        jkVar.mo18336a(f3067e);
        jkVar.mo18335a(this.f3084a);
        jkVar.mo18344b();
        if (this.f3095d != null && mo17943f()) {
            jkVar.mo18336a(f3068f);
            jkVar.mo18340a(this.f3095d);
            jkVar.mo18344b();
        }
        if (this.f3096e != null && mo17944g()) {
            jkVar.mo18336a(f3069g);
            jkVar.mo18340a(this.f3096e);
            jkVar.mo18344b();
        }
        if (this.f3086a != null && mo17945h()) {
            jkVar.mo18336a(f3070h);
            this.f3086a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3097f != null && mo17947i()) {
            jkVar.mo18336a(f3071i);
            jkVar.mo18340a(this.f3097f);
            jkVar.mo18344b();
        }
        if (this.f3098g != null && mo17948j()) {
            jkVar.mo18336a(f3072j);
            jkVar.mo18340a(this.f3098g);
            jkVar.mo18344b();
        }
        if (mo17949k()) {
            jkVar.mo18336a(f3073k);
            jkVar.mo18343a(this.f3091a);
            jkVar.mo18344b();
        }
        if (this.f3099h != null && mo17950l()) {
            jkVar.mo18336a(f3074l);
            jkVar.mo18340a(this.f3099h);
            jkVar.mo18344b();
        }
        if (this.f3100i != null && mo17951m()) {
            jkVar.mo18336a(f3075m);
            jkVar.mo18340a(this.f3100i);
            jkVar.mo18344b();
        }
        if (this.f3101j != null && mo17952n()) {
            jkVar.mo18336a(f3076n);
            jkVar.mo18340a(this.f3101j);
            jkVar.mo18344b();
        }
        if (mo17953o()) {
            jkVar.mo18336a(f3077o);
            jkVar.mo18342a(this.f3090a);
            jkVar.mo18344b();
        }
        if (mo17954p()) {
            jkVar.mo18336a(f3078p);
            jkVar.mo18342a(this.f3093b);
            jkVar.mo18344b();
        }
        if (this.f3102k != null && mo17955q()) {
            jkVar.mo18336a(f3079q);
            jkVar.mo18340a(this.f3102k);
            jkVar.mo18344b();
        }
        if (this.f3103l != null && mo17956r()) {
            jkVar.mo18336a(f3080r);
            jkVar.mo18340a(this.f3103l);
            jkVar.mo18344b();
        }
        if (mo17957s()) {
            jkVar.mo18336a(f3081s);
            jkVar.mo18333a(this.f3083a);
            jkVar.mo18344b();
        }
        if (this.f3089a != null && mo17958t()) {
            jkVar.mo18336a(f3082t);
            jkVar.mo18338a(new C1919jj((byte) 11, (byte) 11, this.f3089a.size()));
            for (Map.Entry next : this.f3089a.entrySet()) {
                jkVar.mo18340a((String) next.getKey());
                jkVar.mo18340a((String) next.getValue());
            }
            jkVar.mo18348d();
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo17931b(boolean z) {
        this.f3088a.set(1, z);
    }

    /* renamed from: b */
    public boolean mo17932b() {
        return this.f3085a != null;
    }

    /* renamed from: c */
    public C1885ie mo17933c(String str) {
        this.f3095d = str;
        return this;
    }

    /* renamed from: c */
    public void mo17934c(boolean z) {
        this.f3088a.set(2, z);
    }

    /* renamed from: c */
    public boolean mo17935c() {
        return this.f3092b != null;
    }

    /* renamed from: d */
    public C1885ie mo17937d(String str) {
        this.f3096e = str;
        return this;
    }

    /* renamed from: d */
    public void mo17938d(boolean z) {
        this.f3088a.set(3, z);
    }

    /* renamed from: d */
    public boolean mo17939d() {
        return this.f3094c != null;
    }

    /* renamed from: e */
    public void mo17940e(boolean z) {
        this.f3088a.set(4, z);
    }

    /* renamed from: e */
    public boolean mo17941e() {
        return this.f3088a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1885ie)) {
            return compareTo((C1885ie) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo17943f() {
        return this.f3095d != null;
    }

    /* renamed from: g */
    public boolean mo17944g() {
        return this.f3096e != null;
    }

    /* renamed from: h */
    public boolean mo17945h() {
        return this.f3086a != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo17947i() {
        return this.f3097f != null;
    }

    /* renamed from: j */
    public boolean mo17948j() {
        return this.f3098g != null;
    }

    /* renamed from: k */
    public boolean mo17949k() {
        return this.f3088a.get(1);
    }

    /* renamed from: l */
    public boolean mo17950l() {
        return this.f3099h != null;
    }

    /* renamed from: m */
    public boolean mo17951m() {
        return this.f3100i != null;
    }

    /* renamed from: n */
    public boolean mo17952n() {
        return this.f3101j != null;
    }

    /* renamed from: o */
    public boolean mo17953o() {
        return this.f3088a.get(2);
    }

    /* renamed from: p */
    public boolean mo17954p() {
        return this.f3088a.get(3);
    }

    /* renamed from: q */
    public boolean mo17955q() {
        return this.f3102k != null;
    }

    /* renamed from: r */
    public boolean mo17956r() {
        return this.f3103l != null;
    }

    /* renamed from: s */
    public boolean mo17957s() {
        return this.f3088a.get(4);
    }

    /* renamed from: t */
    public boolean mo17958t() {
        return this.f3089a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        if (mo17928a()) {
            sb.append("debug:");
            String str = this.f3087a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (mo17932b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1884id idVar = this.f3085a;
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
        String str2 = this.f3092b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f3094c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f3084a);
        if (mo17943f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f3095d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo17944g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f3096e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo17945h()) {
            sb.append(", ");
            sb.append("request:");
            C1898ir irVar = this.f3086a;
            if (irVar == null) {
                sb.append("null");
            } else {
                sb.append(irVar);
            }
        }
        if (mo17947i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f3097f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (mo17948j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f3098g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (mo17949k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f3091a);
        }
        if (mo17950l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f3099h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (mo17951m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f3100i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (mo17952n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f3101j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (mo17953o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append(this.f3090a);
        }
        if (mo17954p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append(this.f3093b);
        }
        if (mo17955q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f3102k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (mo17956r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f3103l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (mo17957s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f3083a);
        }
        if (mo17958t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f3089a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
