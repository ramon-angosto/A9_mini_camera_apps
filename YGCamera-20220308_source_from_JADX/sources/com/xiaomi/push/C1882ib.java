package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.ib */
public class C1882ib implements C1906iz<C1882ib, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3015a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f3016a = new C1925jp("PushMetaInfo");

    /* renamed from: b */
    private static final C1917jh f3017b = new C1917jh("", (byte) 10, 2);

    /* renamed from: c */
    private static final C1917jh f3018c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3019d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3020e = new C1917jh("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1917jh f3021f = new C1917jh("", (byte) 8, 6);

    /* renamed from: g */
    private static final C1917jh f3022g = new C1917jh("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1917jh f3023h = new C1917jh("", (byte) 8, 8);

    /* renamed from: i */
    private static final C1917jh f3024i = new C1917jh("", (byte) 8, 9);

    /* renamed from: j */
    private static final C1917jh f3025j = new C1917jh("", (byte) 13, 10);

    /* renamed from: k */
    private static final C1917jh f3026k = new C1917jh("", (byte) 13, 11);

    /* renamed from: l */
    private static final C1917jh f3027l = new C1917jh("", (byte) 2, 12);

    /* renamed from: m */
    private static final C1917jh f3028m = new C1917jh("", (byte) 13, 13);

    /* renamed from: a */
    public int f3029a;

    /* renamed from: a */
    public long f3030a;

    /* renamed from: a */
    public String f3031a;

    /* renamed from: a */
    private BitSet f3032a;

    /* renamed from: a */
    public Map<String, String> f3033a;

    /* renamed from: a */
    public boolean f3034a;

    /* renamed from: b */
    public int f3035b;

    /* renamed from: b */
    public String f3036b;

    /* renamed from: b */
    public Map<String, String> f3037b;

    /* renamed from: c */
    public int f3038c;

    /* renamed from: c */
    public String f3039c;

    /* renamed from: c */
    public Map<String, String> f3040c;

    /* renamed from: d */
    public String f3041d;

    /* renamed from: e */
    public String f3042e;

    public C1882ib() {
        this.f3032a = new BitSet(5);
        this.f3034a = false;
    }

    public C1882ib(C1882ib ibVar) {
        this.f3032a = new BitSet(5);
        this.f3032a.clear();
        this.f3032a.or(ibVar.f3032a);
        if (ibVar.mo17876a()) {
            this.f3031a = ibVar.f3031a;
        }
        this.f3030a = ibVar.f3030a;
        if (ibVar.mo17888c()) {
            this.f3036b = ibVar.f3036b;
        }
        if (ibVar.mo17894d()) {
            this.f3039c = ibVar.f3039c;
        }
        if (ibVar.mo17897e()) {
            this.f3041d = ibVar.f3041d;
        }
        this.f3029a = ibVar.f3029a;
        if (ibVar.mo17900g()) {
            this.f3042e = ibVar.f3042e;
        }
        this.f3035b = ibVar.f3035b;
        this.f3038c = ibVar.f3038c;
        if (ibVar.mo17904j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : ibVar.f3033a.entrySet()) {
                hashMap.put((String) next.getKey(), (String) next.getValue());
            }
            this.f3033a = hashMap;
        }
        if (ibVar.mo17905k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry next2 : ibVar.f3037b.entrySet()) {
                hashMap2.put((String) next2.getKey(), (String) next2.getValue());
            }
            this.f3037b = hashMap2;
        }
        this.f3034a = ibVar.f3034a;
        if (ibVar.mo17908n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry next3 : ibVar.f3040c.entrySet()) {
                hashMap3.put((String) next3.getKey(), (String) next3.getValue());
            }
            this.f3040c = hashMap3;
        }
    }

    /* renamed from: a */
    public int mo17876a() {
        return this.f3029a;
    }

    /* renamed from: a */
    public int compareTo(C1882ib ibVar) {
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
        if (!getClass().equals(ibVar.getClass())) {
            return getClass().getName().compareTo(ibVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17876a()).compareTo(Boolean.valueOf(ibVar.mo17876a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17876a() && (a13 = C1908ja.m4589a(this.f3031a, ibVar.f3031a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(mo17883b()).compareTo(Boolean.valueOf(ibVar.mo17883b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo17883b() && (a12 = C1908ja.m4587a(this.f3030a, ibVar.f3030a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(mo17888c()).compareTo(Boolean.valueOf(ibVar.mo17888c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo17888c() && (a11 = C1908ja.m4589a(this.f3036b, ibVar.f3036b)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(mo17894d()).compareTo(Boolean.valueOf(ibVar.mo17894d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo17894d() && (a10 = C1908ja.m4589a(this.f3039c, ibVar.f3039c)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(mo17897e()).compareTo(Boolean.valueOf(ibVar.mo17897e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo17897e() && (a9 = C1908ja.m4589a(this.f3041d, ibVar.f3041d)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(mo17899f()).compareTo(Boolean.valueOf(ibVar.mo17899f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo17899f() && (a8 = C1908ja.m4586a(this.f3029a, ibVar.f3029a)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(mo17900g()).compareTo(Boolean.valueOf(ibVar.mo17900g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo17900g() && (a7 = C1908ja.m4589a(this.f3042e, ibVar.f3042e)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(mo17901h()).compareTo(Boolean.valueOf(ibVar.mo17901h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo17901h() && (a6 = C1908ja.m4586a(this.f3035b, ibVar.f3035b)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(mo17903i()).compareTo(Boolean.valueOf(ibVar.mo17903i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo17903i() && (a5 = C1908ja.m4586a(this.f3038c, ibVar.f3038c)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(mo17904j()).compareTo(Boolean.valueOf(ibVar.mo17904j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (mo17904j() && (a4 = C1908ja.m4592a((Map) this.f3033a, (Map) ibVar.f3033a)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(mo17905k()).compareTo(Boolean.valueOf(ibVar.mo17905k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (mo17905k() && (a3 = C1908ja.m4592a((Map) this.f3037b, (Map) ibVar.f3037b)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(mo17907m()).compareTo(Boolean.valueOf(ibVar.mo17907m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (mo17907m() && (a2 = C1908ja.m4595a(this.f3034a, ibVar.f3034a)) != 0) {
            return a2;
        }
        int compareTo13 = Boolean.valueOf(mo17908n()).compareTo(Boolean.valueOf(ibVar.mo17908n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!mo17908n() || (a = C1908ja.m4592a((Map) this.f3040c, (Map) ibVar.f3040c)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public long m4034a() {
        return this.f3030a;
    }

    /* renamed from: a */
    public C1882ib m4035a() {
        return new C1882ib(this);
    }

    /* renamed from: a */
    public C1882ib mo17878a(int i) {
        this.f3029a = i;
        mo17887b(true);
        return this;
    }

    /* renamed from: a */
    public C1882ib mo17879a(String str) {
        this.f3031a = str;
        return this;
    }

    /* renamed from: a */
    public C1882ib mo17880a(Map<String, String> map) {
        this.f3033a = map;
        return this;
    }

    /* renamed from: a */
    public String m4039a() {
        return this.f3031a;
    }

    /* renamed from: a */
    public Map<String, String> m4040a() {
        return this.f3033a;
    }

    /* renamed from: a */
    public void m4041a() {
        if (this.f3031a == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cc, code lost:
        r9.mo18352h();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17579a(com.xiaomi.push.C1920jk r9) {
        /*
            r8 = this;
            r9.mo18332a()
        L_0x0003:
            com.xiaomi.push.jh r0 = r9.mo18332a()
            byte r1 = r0.f3526a
            if (r1 != 0) goto L_0x0033
            r9.mo18350f()
            boolean r9 = r8.mo17883b()
            if (r9 == 0) goto L_0x0018
            r8.mo17876a()
            return
        L_0x0018:
            com.xiaomi.push.jl r9 = new com.xiaomi.push.jl
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'messageTs' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r8.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x0033:
            short r1 = r0.f3528a
            r2 = 0
            r3 = 13
            r4 = 8
            r5 = 2
            r6 = 11
            r7 = 1
            switch(r1) {
                case 1: goto L_0x0137;
                case 2: goto L_0x0127;
                case 3: goto L_0x011c;
                case 4: goto L_0x0111;
                case 5: goto L_0x0106;
                case 6: goto L_0x00f8;
                case 7: goto L_0x00ed;
                case 8: goto L_0x00df;
                case 9: goto L_0x00d1;
                case 10: goto L_0x00a5;
                case 11: goto L_0x007e;
                case 12: goto L_0x006f;
                case 13: goto L_0x0048;
                default: goto L_0x0041;
            }
        L_0x0041:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r9, r0)
            goto L_0x0141
        L_0x0048:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0041
            com.xiaomi.push.jj r0 = r9.mo18332a()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.f3532a
            int r3 = r3 * 2
            r1.<init>(r3)
            r8.f3040c = r1
        L_0x005b:
            int r1 = r0.f3532a
            if (r2 >= r1) goto L_0x00cc
            java.lang.String r1 = r9.mo18332a()
            java.lang.String r3 = r9.mo18332a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r8.f3040c
            r4.put(r1, r3)
            int r2 = r2 + 1
            goto L_0x005b
        L_0x006f:
            byte r1 = r0.f3526a
            if (r1 != r5) goto L_0x0041
            boolean r0 = r9.mo18332a()
            r8.f3034a = r0
            r8.mo17896e(r7)
            goto L_0x0141
        L_0x007e:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0041
            com.xiaomi.push.jj r0 = r9.mo18332a()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.f3532a
            int r3 = r3 * 2
            r1.<init>(r3)
            r8.f3037b = r1
        L_0x0091:
            int r1 = r0.f3532a
            if (r2 >= r1) goto L_0x00cc
            java.lang.String r1 = r9.mo18332a()
            java.lang.String r3 = r9.mo18332a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r8.f3037b
            r4.put(r1, r3)
            int r2 = r2 + 1
            goto L_0x0091
        L_0x00a5:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x0041
            com.xiaomi.push.jj r0 = r9.mo18332a()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.f3532a
            int r3 = r3 * 2
            r1.<init>(r3)
            r8.f3033a = r1
        L_0x00b8:
            int r1 = r0.f3532a
            if (r2 >= r1) goto L_0x00cc
            java.lang.String r1 = r9.mo18332a()
            java.lang.String r3 = r9.mo18332a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r8.f3033a
            r4.put(r1, r3)
            int r2 = r2 + 1
            goto L_0x00b8
        L_0x00cc:
            r9.mo18352h()
            goto L_0x0141
        L_0x00d1:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x0041
            int r0 = r9.mo18332a()
            r8.f3038c = r0
            r8.mo17895d((boolean) r7)
            goto L_0x0141
        L_0x00df:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x0041
            int r0 = r9.mo18332a()
            r8.f3035b = r0
            r8.mo17891c((boolean) r7)
            goto L_0x0141
        L_0x00ed:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x0041
            java.lang.String r0 = r9.mo18332a()
            r8.f3042e = r0
            goto L_0x0141
        L_0x00f8:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x0041
            int r0 = r9.mo18332a()
            r8.f3029a = r0
            r8.mo17887b((boolean) r7)
            goto L_0x0141
        L_0x0106:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x0041
            java.lang.String r0 = r9.mo18332a()
            r8.f3041d = r0
            goto L_0x0141
        L_0x0111:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x0041
            java.lang.String r0 = r9.mo18332a()
            r8.f3039c = r0
            goto L_0x0141
        L_0x011c:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x0041
            java.lang.String r0 = r9.mo18332a()
            r8.f3036b = r0
            goto L_0x0141
        L_0x0127:
            byte r1 = r0.f3526a
            r2 = 10
            if (r1 != r2) goto L_0x0041
            long r0 = r9.mo18332a()
            r8.f3030a = r0
            r8.mo17882a((boolean) r7)
            goto L_0x0141
        L_0x0137:
            byte r1 = r0.f3526a
            if (r1 != r6) goto L_0x0041
            java.lang.String r0 = r9.mo18332a()
            r8.f3031a = r0
        L_0x0141:
            r9.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1882ib.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo17881a(String str, String str2) {
        if (this.f3033a == null) {
            this.f3033a = new HashMap();
        }
        this.f3033a.put(str, str2);
    }

    /* renamed from: a */
    public void mo17882a(boolean z) {
        this.f3032a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4045a() {
        return this.f3031a != null;
    }

    /* renamed from: a */
    public boolean m4046a(C1882ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean a = mo17876a();
        boolean a2 = ibVar.mo17876a();
        if (((a || a2) && (!a || !a2 || !this.f3031a.equals(ibVar.f3031a))) || this.f3030a != ibVar.f3030a) {
            return false;
        }
        boolean c = mo17888c();
        boolean c2 = ibVar.mo17888c();
        if ((c || c2) && (!c || !c2 || !this.f3036b.equals(ibVar.f3036b))) {
            return false;
        }
        boolean d = mo17894d();
        boolean d2 = ibVar.mo17894d();
        if ((d || d2) && (!d || !d2 || !this.f3039c.equals(ibVar.f3039c))) {
            return false;
        }
        boolean e = mo17897e();
        boolean e2 = ibVar.mo17897e();
        if ((e || e2) && (!e || !e2 || !this.f3041d.equals(ibVar.f3041d))) {
            return false;
        }
        boolean f = mo17899f();
        boolean f2 = ibVar.mo17899f();
        if ((f || f2) && (!f || !f2 || this.f3029a != ibVar.f3029a)) {
            return false;
        }
        boolean g = mo17900g();
        boolean g2 = ibVar.mo17900g();
        if ((g || g2) && (!g || !g2 || !this.f3042e.equals(ibVar.f3042e))) {
            return false;
        }
        boolean h = mo17901h();
        boolean h2 = ibVar.mo17901h();
        if ((h || h2) && (!h || !h2 || this.f3035b != ibVar.f3035b)) {
            return false;
        }
        boolean i = mo17903i();
        boolean i2 = ibVar.mo17903i();
        if ((i || i2) && (!i || !i2 || this.f3038c != ibVar.f3038c)) {
            return false;
        }
        boolean j = mo17904j();
        boolean j2 = ibVar.mo17904j();
        if ((j || j2) && (!j || !j2 || !this.f3033a.equals(ibVar.f3033a))) {
            return false;
        }
        boolean k = mo17905k();
        boolean k2 = ibVar.mo17905k();
        if ((k || k2) && (!k || !k2 || !this.f3037b.equals(ibVar.f3037b))) {
            return false;
        }
        boolean m = mo17907m();
        boolean m2 = ibVar.mo17907m();
        if ((m || m2) && (!m || !m2 || this.f3034a != ibVar.f3034a)) {
            return false;
        }
        boolean n = mo17908n();
        boolean n2 = ibVar.mo17908n();
        if (n || n2) {
            return n && n2 && this.f3040c.equals(ibVar.f3040c);
        }
        return true;
    }

    /* renamed from: b */
    public int mo17883b() {
        return this.f3035b;
    }

    /* renamed from: b */
    public C1882ib mo17884b(int i) {
        this.f3035b = i;
        mo17891c(true);
        return this;
    }

    /* renamed from: b */
    public C1882ib mo17885b(String str) {
        this.f3036b = str;
        return this;
    }

    /* renamed from: b */
    public String m4050b() {
        return this.f3036b;
    }

    /* renamed from: b */
    public Map<String, String> m4051b() {
        return this.f3037b;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17876a();
        jkVar.mo18339a(f3016a);
        if (this.f3031a != null) {
            jkVar.mo18336a(f3015a);
            jkVar.mo18340a(this.f3031a);
            jkVar.mo18344b();
        }
        jkVar.mo18336a(f3017b);
        jkVar.mo18335a(this.f3030a);
        jkVar.mo18344b();
        if (this.f3036b != null && mo17888c()) {
            jkVar.mo18336a(f3018c);
            jkVar.mo18340a(this.f3036b);
            jkVar.mo18344b();
        }
        if (this.f3039c != null && mo17894d()) {
            jkVar.mo18336a(f3019d);
            jkVar.mo18340a(this.f3039c);
            jkVar.mo18344b();
        }
        if (this.f3041d != null && mo17897e()) {
            jkVar.mo18336a(f3020e);
            jkVar.mo18340a(this.f3041d);
            jkVar.mo18344b();
        }
        if (mo17899f()) {
            jkVar.mo18336a(f3021f);
            jkVar.mo18333a(this.f3029a);
            jkVar.mo18344b();
        }
        if (this.f3042e != null && mo17900g()) {
            jkVar.mo18336a(f3022g);
            jkVar.mo18340a(this.f3042e);
            jkVar.mo18344b();
        }
        if (mo17901h()) {
            jkVar.mo18336a(f3023h);
            jkVar.mo18333a(this.f3035b);
            jkVar.mo18344b();
        }
        if (mo17903i()) {
            jkVar.mo18336a(f3024i);
            jkVar.mo18333a(this.f3038c);
            jkVar.mo18344b();
        }
        if (this.f3033a != null && mo17904j()) {
            jkVar.mo18336a(f3025j);
            jkVar.mo18338a(new C1919jj((byte) 11, (byte) 11, this.f3033a.size()));
            for (Map.Entry next : this.f3033a.entrySet()) {
                jkVar.mo18340a((String) next.getKey());
                jkVar.mo18340a((String) next.getValue());
            }
            jkVar.mo18348d();
            jkVar.mo18344b();
        }
        if (this.f3037b != null && mo17905k()) {
            jkVar.mo18336a(f3026k);
            jkVar.mo18338a(new C1919jj((byte) 11, (byte) 11, this.f3037b.size()));
            for (Map.Entry next2 : this.f3037b.entrySet()) {
                jkVar.mo18340a((String) next2.getKey());
                jkVar.mo18340a((String) next2.getValue());
            }
            jkVar.mo18348d();
            jkVar.mo18344b();
        }
        if (mo17907m()) {
            jkVar.mo18336a(f3027l);
            jkVar.mo18343a(this.f3034a);
            jkVar.mo18344b();
        }
        if (this.f3040c != null && mo17908n()) {
            jkVar.mo18336a(f3028m);
            jkVar.mo18338a(new C1919jj((byte) 11, (byte) 11, this.f3040c.size()));
            for (Map.Entry next3 : this.f3040c.entrySet()) {
                jkVar.mo18340a((String) next3.getKey());
                jkVar.mo18340a((String) next3.getValue());
            }
            jkVar.mo18348d();
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo17886b(String str, String str2) {
        if (this.f3037b == null) {
            this.f3037b = new HashMap();
        }
        this.f3037b.put(str, str2);
    }

    /* renamed from: b */
    public void mo17887b(boolean z) {
        this.f3032a.set(1, z);
    }

    /* renamed from: b */
    public boolean m4055b() {
        return this.f3032a.get(0);
    }

    /* renamed from: c */
    public int mo17888c() {
        return this.f3038c;
    }

    /* renamed from: c */
    public C1882ib mo17889c(int i) {
        this.f3038c = i;
        mo17895d(true);
        return this;
    }

    /* renamed from: c */
    public C1882ib mo17890c(String str) {
        this.f3039c = str;
        return this;
    }

    /* renamed from: c */
    public String m4059c() {
        return this.f3039c;
    }

    /* renamed from: c */
    public void mo17891c(boolean z) {
        this.f3032a.set(2, z);
    }

    /* renamed from: c */
    public boolean m4061c() {
        return this.f3036b != null;
    }

    /* renamed from: d */
    public C1882ib mo17893d(String str) {
        this.f3041d = str;
        return this;
    }

    /* renamed from: d */
    public String mo17894d() {
        return this.f3041d;
    }

    /* renamed from: d */
    public void mo17895d(boolean z) {
        this.f3032a.set(3, z);
    }

    /* renamed from: d */
    public boolean m4065d() {
        return this.f3039c != null;
    }

    /* renamed from: e */
    public void mo17896e(boolean z) {
        this.f3032a.set(4, z);
    }

    /* renamed from: e */
    public boolean mo17897e() {
        return this.f3041d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1882ib)) {
            return compareTo((C1882ib) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo17899f() {
        return this.f3032a.get(1);
    }

    /* renamed from: g */
    public boolean mo17900g() {
        return this.f3042e != null;
    }

    /* renamed from: h */
    public boolean mo17901h() {
        return this.f3032a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo17903i() {
        return this.f3032a.get(3);
    }

    /* renamed from: j */
    public boolean mo17904j() {
        return this.f3033a != null;
    }

    /* renamed from: k */
    public boolean mo17905k() {
        return this.f3037b != null;
    }

    /* renamed from: l */
    public boolean mo17906l() {
        return this.f3034a;
    }

    /* renamed from: m */
    public boolean mo17907m() {
        return this.f3032a.get(4);
    }

    /* renamed from: n */
    public boolean mo17908n() {
        return this.f3040c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f3031a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f3030a);
        if (mo17888c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f3036b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (mo17894d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f3039c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (mo17897e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f3041d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo17899f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f3029a);
        }
        if (mo17900g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f3042e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo17901h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f3035b);
        }
        if (mo17903i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f3038c);
        }
        if (mo17904j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f3033a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (mo17905k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f3037b;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (mo17907m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f3034a);
        }
        if (mo17908n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f3040c;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
