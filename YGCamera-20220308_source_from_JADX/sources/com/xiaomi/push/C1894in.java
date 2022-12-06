package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.in */
public class C1894in implements C1906iz<C1894in, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3203a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f3204a = new C1925jp("XmPushActionNotification");

    /* renamed from: b */
    private static final C1917jh f3205b = new C1917jh("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1917jh f3206c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3207d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3208e = new C1917jh("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1917jh f3209f = new C1917jh("", (byte) 2, 6);

    /* renamed from: g */
    private static final C1917jh f3210g = new C1917jh("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1917jh f3211h = new C1917jh("", (byte) 13, 8);

    /* renamed from: i */
    private static final C1917jh f3212i = new C1917jh("", (byte) 11, 9);

    /* renamed from: j */
    private static final C1917jh f3213j = new C1917jh("", (byte) 11, 10);

    /* renamed from: k */
    private static final C1917jh f3214k = new C1917jh("", (byte) 11, 12);

    /* renamed from: l */
    private static final C1917jh f3215l = new C1917jh("", (byte) 11, 13);

    /* renamed from: m */
    private static final C1917jh f3216m = new C1917jh("", (byte) 11, 14);

    /* renamed from: n */
    private static final C1917jh f3217n = new C1917jh("", (byte) 10, 15);

    /* renamed from: o */
    private static final C1917jh f3218o = new C1917jh("", (byte) 2, 20);

    /* renamed from: a */
    public long f3219a;

    /* renamed from: a */
    public C1884id f3220a;

    /* renamed from: a */
    public String f3221a;

    /* renamed from: a */
    public ByteBuffer f3222a;

    /* renamed from: a */
    private BitSet f3223a;

    /* renamed from: a */
    public Map<String, String> f3224a;

    /* renamed from: a */
    public boolean f3225a;

    /* renamed from: b */
    public String f3226b;

    /* renamed from: b */
    public boolean f3227b;

    /* renamed from: c */
    public String f3228c;

    /* renamed from: d */
    public String f3229d;

    /* renamed from: e */
    public String f3230e;

    /* renamed from: f */
    public String f3231f;

    /* renamed from: g */
    public String f3232g;

    /* renamed from: h */
    public String f3233h;

    /* renamed from: i */
    public String f3234i;

    public C1894in() {
        this.f3223a = new BitSet(3);
        this.f3225a = true;
        this.f3227b = false;
    }

    public C1894in(String str, boolean z) {
        this();
        this.f3226b = str;
        this.f3225a = z;
        mo18081a(true);
    }

    /* renamed from: a */
    public int compareTo(C1894in inVar) {
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
        if (!getClass().equals(inVar.getClass())) {
            return getClass().getName().compareTo(inVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18077a()).compareTo(Boolean.valueOf(inVar.mo18077a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18077a() && (a15 = C1908ja.m4589a(this.f3221a, inVar.f3221a)) != 0) {
            return a15;
        }
        int compareTo2 = Boolean.valueOf(mo18085b()).compareTo(Boolean.valueOf(inVar.mo18085b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo18085b() && (a14 = C1908ja.m4588a((Comparable) this.f3220a, (Comparable) inVar.f3220a)) != 0) {
            return a14;
        }
        int compareTo3 = Boolean.valueOf(mo18088c()).compareTo(Boolean.valueOf(inVar.mo18088c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo18088c() && (a13 = C1908ja.m4589a(this.f3226b, inVar.f3226b)) != 0) {
            return a13;
        }
        int compareTo4 = Boolean.valueOf(mo18092d()).compareTo(Boolean.valueOf(inVar.mo18092d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo18092d() && (a12 = C1908ja.m4589a(this.f3228c, inVar.f3228c)) != 0) {
            return a12;
        }
        int compareTo5 = Boolean.valueOf(mo18093e()).compareTo(Boolean.valueOf(inVar.mo18093e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo18093e() && (a11 = C1908ja.m4589a(this.f3229d, inVar.f3229d)) != 0) {
            return a11;
        }
        int compareTo6 = Boolean.valueOf(mo18095f()).compareTo(Boolean.valueOf(inVar.mo18095f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo18095f() && (a10 = C1908ja.m4595a(this.f3225a, inVar.f3225a)) != 0) {
            return a10;
        }
        int compareTo7 = Boolean.valueOf(mo18096g()).compareTo(Boolean.valueOf(inVar.mo18096g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo18096g() && (a9 = C1908ja.m4589a(this.f3230e, inVar.f3230e)) != 0) {
            return a9;
        }
        int compareTo8 = Boolean.valueOf(mo18097h()).compareTo(Boolean.valueOf(inVar.mo18097h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo18097h() && (a8 = C1908ja.m4592a((Map) this.f3224a, (Map) inVar.f3224a)) != 0) {
            return a8;
        }
        int compareTo9 = Boolean.valueOf(mo18099i()).compareTo(Boolean.valueOf(inVar.mo18099i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo18099i() && (a7 = C1908ja.m4589a(this.f3231f, inVar.f3231f)) != 0) {
            return a7;
        }
        int compareTo10 = Boolean.valueOf(mo18100j()).compareTo(Boolean.valueOf(inVar.mo18100j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (mo18100j() && (a6 = C1908ja.m4589a(this.f3232g, inVar.f3232g)) != 0) {
            return a6;
        }
        int compareTo11 = Boolean.valueOf(mo18101k()).compareTo(Boolean.valueOf(inVar.mo18101k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (mo18101k() && (a5 = C1908ja.m4589a(this.f3233h, inVar.f3233h)) != 0) {
            return a5;
        }
        int compareTo12 = Boolean.valueOf(mo18102l()).compareTo(Boolean.valueOf(inVar.mo18102l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (mo18102l() && (a4 = C1908ja.m4589a(this.f3234i, inVar.f3234i)) != 0) {
            return a4;
        }
        int compareTo13 = Boolean.valueOf(mo18103m()).compareTo(Boolean.valueOf(inVar.mo18103m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (mo18103m() && (a3 = C1908ja.m4588a((Comparable) this.f3222a, (Comparable) inVar.f3222a)) != 0) {
            return a3;
        }
        int compareTo14 = Boolean.valueOf(mo18104n()).compareTo(Boolean.valueOf(inVar.mo18104n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (mo18104n() && (a2 = C1908ja.m4587a(this.f3219a, inVar.f3219a)) != 0) {
            return a2;
        }
        int compareTo15 = Boolean.valueOf(mo18105o()).compareTo(Boolean.valueOf(inVar.mo18105o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!mo18105o() || (a = C1908ja.m4595a(this.f3227b, inVar.f3227b)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1884id mo18077a() {
        return this.f3220a;
    }

    /* renamed from: a */
    public C1894in mo18078a(String str) {
        this.f3226b = str;
        return this;
    }

    /* renamed from: a */
    public C1894in mo18079a(ByteBuffer byteBuffer) {
        this.f3222a = byteBuffer;
        return this;
    }

    /* renamed from: a */
    public C1894in mo18080a(Map<String, String> map) {
        this.f3224a = map;
        return this;
    }

    /* renamed from: a */
    public C1894in mo18081a(boolean z) {
        this.f3225a = z;
        mo18081a(true);
        return this;
    }

    /* renamed from: a */
    public C1894in mo18082a(byte[] bArr) {
        mo18079a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a */
    public String m4269a() {
        return this.f3226b;
    }

    /* renamed from: a */
    public Map<String, String> m4270a() {
        return this.f3224a;
    }

    /* renamed from: a */
    public void m4271a() {
        if (this.f3226b == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
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
            boolean r6 = r5.mo18095f()
            if (r6 == 0) goto L_0x0018
            r5.mo18077a()
            return
        L_0x0018:
            com.xiaomi.push.jl r6 = new com.xiaomi.push.jl
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'requireAck' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x0033:
            short r1 = r0.f3528a
            r2 = 2
            r3 = 1
            r4 = 11
            switch(r1) {
                case 1: goto L_0x011a;
                case 2: goto L_0x0107;
                case 3: goto L_0x00fc;
                case 4: goto L_0x00f1;
                case 5: goto L_0x00e6;
                case 6: goto L_0x00d8;
                case 7: goto L_0x00cd;
                case 8: goto L_0x009f;
                case 9: goto L_0x0093;
                case 10: goto L_0x0087;
                case 11: goto L_0x003c;
                case 12: goto L_0x007b;
                case 13: goto L_0x006f;
                case 14: goto L_0x0063;
                case 15: goto L_0x0052;
                case 16: goto L_0x003c;
                case 17: goto L_0x003c;
                case 18: goto L_0x003c;
                case 19: goto L_0x003c;
                case 20: goto L_0x0043;
                default: goto L_0x003c;
            }
        L_0x003c:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r6, r0)
            goto L_0x0124
        L_0x0043:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x003c
            boolean r0 = r6.mo18332a()
            r5.f3227b = r0
            r5.mo18089c((boolean) r3)
            goto L_0x0124
        L_0x0052:
            byte r1 = r0.f3526a
            r2 = 10
            if (r1 != r2) goto L_0x003c
            long r0 = r6.mo18332a()
            r5.f3219a = r0
            r5.mo18086b((boolean) r3)
            goto L_0x0124
        L_0x0063:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003c
            java.nio.ByteBuffer r0 = r6.mo18332a()
            r5.f3222a = r0
            goto L_0x0124
        L_0x006f:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003c
            java.lang.String r0 = r6.mo18332a()
            r5.f3234i = r0
            goto L_0x0124
        L_0x007b:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003c
            java.lang.String r0 = r6.mo18332a()
            r5.f3233h = r0
            goto L_0x0124
        L_0x0087:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003c
            java.lang.String r0 = r6.mo18332a()
            r5.f3232g = r0
            goto L_0x0124
        L_0x0093:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003c
            java.lang.String r0 = r6.mo18332a()
            r5.f3231f = r0
            goto L_0x0124
        L_0x009f:
            byte r1 = r0.f3526a
            r3 = 13
            if (r1 != r3) goto L_0x003c
            com.xiaomi.push.jj r0 = r6.mo18332a()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.f3532a
            int r3 = r3 * 2
            r1.<init>(r3)
            r5.f3224a = r1
            r1 = 0
        L_0x00b5:
            int r2 = r0.f3532a
            if (r1 >= r2) goto L_0x00c9
            java.lang.String r2 = r6.mo18332a()
            java.lang.String r3 = r6.mo18332a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.f3224a
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x00b5
        L_0x00c9:
            r6.mo18352h()
            goto L_0x0124
        L_0x00cd:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003c
            java.lang.String r0 = r6.mo18332a()
            r5.f3230e = r0
            goto L_0x0124
        L_0x00d8:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x003c
            boolean r0 = r6.mo18332a()
            r5.f3225a = r0
            r5.mo18081a((boolean) r3)
            goto L_0x0124
        L_0x00e6:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003c
            java.lang.String r0 = r6.mo18332a()
            r5.f3229d = r0
            goto L_0x0124
        L_0x00f1:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003c
            java.lang.String r0 = r6.mo18332a()
            r5.f3228c = r0
            goto L_0x0124
        L_0x00fc:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003c
            java.lang.String r0 = r6.mo18332a()
            r5.f3226b = r0
            goto L_0x0124
        L_0x0107:
            byte r1 = r0.f3526a
            r2 = 12
            if (r1 != r2) goto L_0x003c
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r5.f3220a = r0
            com.xiaomi.push.id r0 = r5.f3220a
            r0.mo17579a((com.xiaomi.push.C1920jk) r6)
            goto L_0x0124
        L_0x011a:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x003c
            java.lang.String r0 = r6.mo18332a()
            r5.f3221a = r0
        L_0x0124:
            r6.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1894in.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo18083a(String str, String str2) {
        if (this.f3224a == null) {
            this.f3224a = new HashMap();
        }
        this.f3224a.put(str, str2);
    }

    /* renamed from: a */
    public void m4274a(boolean z) {
        this.f3223a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4275a() {
        return this.f3221a != null;
    }

    /* renamed from: a */
    public boolean m4276a(C1894in inVar) {
        if (inVar == null) {
            return false;
        }
        boolean a = mo18077a();
        boolean a2 = inVar.mo18077a();
        if ((a || a2) && (!a || !a2 || !this.f3221a.equals(inVar.f3221a))) {
            return false;
        }
        boolean b = mo18085b();
        boolean b2 = inVar.mo18085b();
        if ((b || b2) && (!b || !b2 || !this.f3220a.compareTo(inVar.f3220a))) {
            return false;
        }
        boolean c = mo18088c();
        boolean c2 = inVar.mo18088c();
        if ((c || c2) && (!c || !c2 || !this.f3226b.equals(inVar.f3226b))) {
            return false;
        }
        boolean d = mo18092d();
        boolean d2 = inVar.mo18092d();
        if ((d || d2) && (!d || !d2 || !this.f3228c.equals(inVar.f3228c))) {
            return false;
        }
        boolean e = mo18093e();
        boolean e2 = inVar.mo18093e();
        if (((e || e2) && (!e || !e2 || !this.f3229d.equals(inVar.f3229d))) || this.f3225a != inVar.f3225a) {
            return false;
        }
        boolean g = mo18096g();
        boolean g2 = inVar.mo18096g();
        if ((g || g2) && (!g || !g2 || !this.f3230e.equals(inVar.f3230e))) {
            return false;
        }
        boolean h = mo18097h();
        boolean h2 = inVar.mo18097h();
        if ((h || h2) && (!h || !h2 || !this.f3224a.equals(inVar.f3224a))) {
            return false;
        }
        boolean i = mo18099i();
        boolean i2 = inVar.mo18099i();
        if ((i || i2) && (!i || !i2 || !this.f3231f.equals(inVar.f3231f))) {
            return false;
        }
        boolean j = mo18100j();
        boolean j2 = inVar.mo18100j();
        if ((j || j2) && (!j || !j2 || !this.f3232g.equals(inVar.f3232g))) {
            return false;
        }
        boolean k = mo18101k();
        boolean k2 = inVar.mo18101k();
        if ((k || k2) && (!k || !k2 || !this.f3233h.equals(inVar.f3233h))) {
            return false;
        }
        boolean l = mo18102l();
        boolean l2 = inVar.mo18102l();
        if ((l || l2) && (!l || !l2 || !this.f3234i.equals(inVar.f3234i))) {
            return false;
        }
        boolean m = mo18103m();
        boolean m2 = inVar.mo18103m();
        if ((m || m2) && (!m || !m2 || !this.f3222a.equals(inVar.f3222a))) {
            return false;
        }
        boolean n = mo18104n();
        boolean n2 = inVar.mo18104n();
        if ((n || n2) && (!n || !n2 || this.f3219a != inVar.f3219a)) {
            return false;
        }
        boolean o = mo18105o();
        boolean o2 = inVar.mo18105o();
        if (o || o2) {
            return o && o2 && this.f3227b == inVar.f3227b;
        }
        return true;
    }

    /* renamed from: a */
    public byte[] m4277a() {
        mo18079a(C1908ja.m4598a(this.f3222a));
        return this.f3222a.array();
    }

    /* renamed from: b */
    public C1894in mo18084b(String str) {
        this.f3228c = str;
        return this;
    }

    /* renamed from: b */
    public String mo18085b() {
        return this.f3228c;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18077a();
        jkVar.mo18339a(f3204a);
        if (this.f3221a != null && mo18077a()) {
            jkVar.mo18336a(f3203a);
            jkVar.mo18340a(this.f3221a);
            jkVar.mo18344b();
        }
        if (this.f3220a != null && mo18085b()) {
            jkVar.mo18336a(f3205b);
            this.f3220a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3226b != null) {
            jkVar.mo18336a(f3206c);
            jkVar.mo18340a(this.f3226b);
            jkVar.mo18344b();
        }
        if (this.f3228c != null && mo18092d()) {
            jkVar.mo18336a(f3207d);
            jkVar.mo18340a(this.f3228c);
            jkVar.mo18344b();
        }
        if (this.f3229d != null && mo18093e()) {
            jkVar.mo18336a(f3208e);
            jkVar.mo18340a(this.f3229d);
            jkVar.mo18344b();
        }
        jkVar.mo18336a(f3209f);
        jkVar.mo18343a(this.f3225a);
        jkVar.mo18344b();
        if (this.f3230e != null && mo18096g()) {
            jkVar.mo18336a(f3210g);
            jkVar.mo18340a(this.f3230e);
            jkVar.mo18344b();
        }
        if (this.f3224a != null && mo18097h()) {
            jkVar.mo18336a(f3211h);
            jkVar.mo18338a(new C1919jj((byte) 11, (byte) 11, this.f3224a.size()));
            for (Map.Entry next : this.f3224a.entrySet()) {
                jkVar.mo18340a((String) next.getKey());
                jkVar.mo18340a((String) next.getValue());
            }
            jkVar.mo18348d();
            jkVar.mo18344b();
        }
        if (this.f3231f != null && mo18099i()) {
            jkVar.mo18336a(f3212i);
            jkVar.mo18340a(this.f3231f);
            jkVar.mo18344b();
        }
        if (this.f3232g != null && mo18100j()) {
            jkVar.mo18336a(f3213j);
            jkVar.mo18340a(this.f3232g);
            jkVar.mo18344b();
        }
        if (this.f3233h != null && mo18101k()) {
            jkVar.mo18336a(f3214k);
            jkVar.mo18340a(this.f3233h);
            jkVar.mo18344b();
        }
        if (this.f3234i != null && mo18102l()) {
            jkVar.mo18336a(f3215l);
            jkVar.mo18340a(this.f3234i);
            jkVar.mo18344b();
        }
        if (this.f3222a != null && mo18103m()) {
            jkVar.mo18336a(f3216m);
            jkVar.mo18341a(this.f3222a);
            jkVar.mo18344b();
        }
        if (mo18104n()) {
            jkVar.mo18336a(f3217n);
            jkVar.mo18335a(this.f3219a);
            jkVar.mo18344b();
        }
        if (mo18105o()) {
            jkVar.mo18336a(f3218o);
            jkVar.mo18343a(this.f3227b);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo18086b(boolean z) {
        this.f3223a.set(1, z);
    }

    /* renamed from: b */
    public boolean m4282b() {
        return this.f3220a != null;
    }

    /* renamed from: c */
    public C1894in mo18087c(String str) {
        this.f3229d = str;
        return this;
    }

    /* renamed from: c */
    public String mo18088c() {
        return this.f3231f;
    }

    /* renamed from: c */
    public void mo18089c(boolean z) {
        this.f3223a.set(2, z);
    }

    /* renamed from: c */
    public boolean m4286c() {
        return this.f3226b != null;
    }

    /* renamed from: d */
    public C1894in mo18091d(String str) {
        this.f3231f = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo18092d() {
        return this.f3228c != null;
    }

    /* renamed from: e */
    public boolean mo18093e() {
        return this.f3229d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1894in)) {
            return compareTo((C1894in) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo18095f() {
        return this.f3223a.get(0);
    }

    /* renamed from: g */
    public boolean mo18096g() {
        return this.f3230e != null;
    }

    /* renamed from: h */
    public boolean mo18097h() {
        return this.f3224a != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo18099i() {
        return this.f3231f != null;
    }

    /* renamed from: j */
    public boolean mo18100j() {
        return this.f3232g != null;
    }

    /* renamed from: k */
    public boolean mo18101k() {
        return this.f3233h != null;
    }

    /* renamed from: l */
    public boolean mo18102l() {
        return this.f3234i != null;
    }

    /* renamed from: m */
    public boolean mo18103m() {
        return this.f3222a != null;
    }

    /* renamed from: n */
    public boolean mo18104n() {
        return this.f3223a.get(1);
    }

    /* renamed from: o */
    public boolean mo18105o() {
        return this.f3223a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        if (mo18077a()) {
            sb.append("debug:");
            String str = this.f3221a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (mo18085b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1884id idVar = this.f3220a;
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
        String str2 = this.f3226b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (mo18092d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f3228c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (mo18093e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f3229d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f3225a);
        if (mo18096g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f3230e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo18097h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f3224a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (mo18099i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f3231f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (mo18100j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f3232g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (mo18101k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f3233h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (mo18102l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f3234i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (mo18103m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f3222a;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                C1908ja.m4599a(byteBuffer, sb);
            }
        }
        if (mo18104n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f3219a);
        }
        if (mo18105o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f3227b);
        }
        sb.append(")");
        return sb.toString();
    }
}
