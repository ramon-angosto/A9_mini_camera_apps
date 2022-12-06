package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.ik */
public class C1891ik implements C1906iz<C1891ik, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3179a = new C1917jh("", (byte) 8, 1);

    /* renamed from: a */
    private static final C1925jp f3180a = new C1925jp("XmPushActionContainer");

    /* renamed from: b */
    private static final C1917jh f3181b = new C1917jh("", (byte) 2, 2);

    /* renamed from: c */
    private static final C1917jh f3182c = new C1917jh("", (byte) 2, 3);

    /* renamed from: d */
    private static final C1917jh f3183d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3184e = new C1917jh("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1917jh f3185f = new C1917jh("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1917jh f3186g = new C1917jh("", (byte) 12, 7);

    /* renamed from: h */
    private static final C1917jh f3187h = new C1917jh("", (byte) 12, 8);

    /* renamed from: a */
    public C1868ho f3188a;

    /* renamed from: a */
    public C1882ib f3189a;

    /* renamed from: a */
    public C1884id f3190a;

    /* renamed from: a */
    public String f3191a;

    /* renamed from: a */
    public ByteBuffer f3192a;

    /* renamed from: a */
    private BitSet f3193a = new BitSet(2);

    /* renamed from: a */
    public boolean f3194a = true;

    /* renamed from: b */
    public String f3195b;

    /* renamed from: b */
    public boolean f3196b = true;

    /* renamed from: a */
    public int compareTo(C1891ik ikVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(ikVar.getClass())) {
            return getClass().getName().compareTo(ikVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18043a()).compareTo(Boolean.valueOf(ikVar.mo18043a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18043a() && (a8 = C1908ja.m4588a((Comparable) this.f3188a, (Comparable) ikVar.f3188a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(mo18053c()).compareTo(Boolean.valueOf(ikVar.mo18053c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo18053c() && (a7 = C1908ja.m4595a(this.f3194a, ikVar.f3194a)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(mo18055d()).compareTo(Boolean.valueOf(ikVar.mo18055d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo18055d() && (a6 = C1908ja.m4595a(this.f3196b, ikVar.f3196b)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(mo18056e()).compareTo(Boolean.valueOf(ikVar.mo18056e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo18056e() && (a5 = C1908ja.m4588a((Comparable) this.f3192a, (Comparable) ikVar.f3192a)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(mo18058f()).compareTo(Boolean.valueOf(ikVar.mo18058f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo18058f() && (a4 = C1908ja.m4589a(this.f3191a, ikVar.f3191a)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(mo18059g()).compareTo(Boolean.valueOf(ikVar.mo18059g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo18059g() && (a3 = C1908ja.m4589a(this.f3195b, ikVar.f3195b)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(mo18060h()).compareTo(Boolean.valueOf(ikVar.mo18060h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo18060h() && (a2 = C1908ja.m4588a((Comparable) this.f3190a, (Comparable) ikVar.f3190a)) != 0) {
            return a2;
        }
        int compareTo8 = Boolean.valueOf(mo18062i()).compareTo(Boolean.valueOf(ikVar.mo18062i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!mo18062i() || (a = C1908ja.m4588a((Comparable) this.f3189a, (Comparable) ikVar.f3189a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1868ho mo18043a() {
        return this.f3188a;
    }

    /* renamed from: a */
    public C1882ib m4221a() {
        return this.f3189a;
    }

    /* renamed from: a */
    public C1891ik mo18044a(C1868ho hoVar) {
        this.f3188a = hoVar;
        return this;
    }

    /* renamed from: a */
    public C1891ik mo18045a(C1882ib ibVar) {
        this.f3189a = ibVar;
        return this;
    }

    /* renamed from: a */
    public C1891ik mo18046a(C1884id idVar) {
        this.f3190a = idVar;
        return this;
    }

    /* renamed from: a */
    public C1891ik mo18047a(String str) {
        this.f3191a = str;
        return this;
    }

    /* renamed from: a */
    public C1891ik mo18048a(ByteBuffer byteBuffer) {
        this.f3192a = byteBuffer;
        return this;
    }

    /* renamed from: a */
    public C1891ik mo18049a(boolean z) {
        this.f3194a = z;
        mo18049a(true);
        return this;
    }

    /* renamed from: a */
    public String m4228a() {
        return this.f3191a;
    }

    /* renamed from: a */
    public void m4229a() {
        if (this.f3188a == null) {
            throw new C1921jl("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f3192a == null) {
            throw new C1921jl("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f3190a == null) {
            throw new C1921jl("Required field 'target' was not present! Struct: " + toString());
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
            if (r1 != 0) goto L_0x0054
            r7.mo18350f()
            boolean r7 = r6.mo18053c()
            if (r7 == 0) goto L_0x0039
            boolean r7 = r6.mo18055d()
            if (r7 == 0) goto L_0x001e
            r6.mo18043a()
            return
        L_0x001e:
            com.xiaomi.push.jl r7 = new com.xiaomi.push.jl
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'isRequest' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x0039:
            com.xiaomi.push.jl r7 = new com.xiaomi.push.jl
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'encryptAction' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x0054:
            short r1 = r0.f3528a
            r2 = 1
            r3 = 12
            r4 = 2
            r5 = 11
            switch(r1) {
                case 1: goto L_0x00c5;
                case 2: goto L_0x00b7;
                case 3: goto L_0x00a9;
                case 4: goto L_0x009e;
                case 5: goto L_0x0093;
                case 6: goto L_0x0088;
                case 7: goto L_0x0077;
                case 8: goto L_0x0066;
                default: goto L_0x005f;
            }
        L_0x005f:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r7, r0)
            goto L_0x00d5
        L_0x0066:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x005f
            com.xiaomi.push.ib r0 = new com.xiaomi.push.ib
            r0.<init>()
            r6.f3189a = r0
            com.xiaomi.push.ib r0 = r6.f3189a
            r0.mo17579a((com.xiaomi.push.C1920jk) r7)
            goto L_0x00d5
        L_0x0077:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x005f
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r6.f3190a = r0
            com.xiaomi.push.id r0 = r6.f3190a
            r0.mo17579a((com.xiaomi.push.C1920jk) r7)
            goto L_0x00d5
        L_0x0088:
            byte r1 = r0.f3526a
            if (r1 != r5) goto L_0x005f
            java.lang.String r0 = r7.mo18332a()
            r6.f3195b = r0
            goto L_0x00d5
        L_0x0093:
            byte r1 = r0.f3526a
            if (r1 != r5) goto L_0x005f
            java.lang.String r0 = r7.mo18332a()
            r6.f3191a = r0
            goto L_0x00d5
        L_0x009e:
            byte r1 = r0.f3526a
            if (r1 != r5) goto L_0x005f
            java.nio.ByteBuffer r0 = r7.mo18332a()
            r6.f3192a = r0
            goto L_0x00d5
        L_0x00a9:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x005f
            boolean r0 = r7.mo18332a()
            r6.f3196b = r0
            r6.mo18051b((boolean) r2)
            goto L_0x00d5
        L_0x00b7:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x005f
            boolean r0 = r7.mo18332a()
            r6.f3194a = r0
            r6.mo18049a((boolean) r2)
            goto L_0x00d5
        L_0x00c5:
            byte r1 = r0.f3526a
            r2 = 8
            if (r1 != r2) goto L_0x005f
            int r0 = r7.mo18332a()
            com.xiaomi.push.ho r0 = com.xiaomi.push.C1868ho.m3895a(r0)
            r6.f3188a = r0
        L_0x00d5:
            r7.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1891ik.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void m4231a(boolean z) {
        this.f3193a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4232a() {
        return this.f3188a != null;
    }

    /* renamed from: a */
    public boolean m4233a(C1891ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean a = mo18043a();
        boolean a2 = ikVar.mo18043a();
        if (((a || a2) && (!a || !a2 || !this.f3188a.equals(ikVar.f3188a))) || this.f3194a != ikVar.f3194a || this.f3196b != ikVar.f3196b) {
            return false;
        }
        boolean e = mo18056e();
        boolean e2 = ikVar.mo18056e();
        if ((e || e2) && (!e || !e2 || !this.f3192a.equals(ikVar.f3192a))) {
            return false;
        }
        boolean f = mo18058f();
        boolean f2 = ikVar.mo18058f();
        if ((f || f2) && (!f || !f2 || !this.f3191a.equals(ikVar.f3191a))) {
            return false;
        }
        boolean g = mo18059g();
        boolean g2 = ikVar.mo18059g();
        if ((g || g2) && (!g || !g2 || !this.f3195b.equals(ikVar.f3195b))) {
            return false;
        }
        boolean h = mo18060h();
        boolean h2 = ikVar.mo18060h();
        if ((h || h2) && (!h || !h2 || !this.f3190a.compareTo(ikVar.f3190a))) {
            return false;
        }
        boolean i = mo18062i();
        boolean i2 = ikVar.mo18062i();
        if (i || i2) {
            return i && i2 && this.f3189a.compareTo(ikVar.f3189a);
        }
        return true;
    }

    /* renamed from: a */
    public byte[] m4234a() {
        mo18048a(C1908ja.m4598a(this.f3192a));
        return this.f3192a.array();
    }

    /* renamed from: b */
    public C1891ik mo18050b(String str) {
        this.f3195b = str;
        return this;
    }

    /* renamed from: b */
    public C1891ik mo18051b(boolean z) {
        this.f3196b = z;
        mo18051b(true);
        return this;
    }

    /* renamed from: b */
    public String mo18052b() {
        return this.f3195b;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18043a();
        jkVar.mo18339a(f3180a);
        if (this.f3188a != null) {
            jkVar.mo18336a(f3179a);
            jkVar.mo18333a(this.f3188a.mo17766a());
            jkVar.mo18344b();
        }
        jkVar.mo18336a(f3181b);
        jkVar.mo18343a(this.f3194a);
        jkVar.mo18344b();
        jkVar.mo18336a(f3182c);
        jkVar.mo18343a(this.f3196b);
        jkVar.mo18344b();
        if (this.f3192a != null) {
            jkVar.mo18336a(f3183d);
            jkVar.mo18341a(this.f3192a);
            jkVar.mo18344b();
        }
        if (this.f3191a != null && mo18058f()) {
            jkVar.mo18336a(f3184e);
            jkVar.mo18340a(this.f3191a);
            jkVar.mo18344b();
        }
        if (this.f3195b != null && mo18059g()) {
            jkVar.mo18336a(f3185f);
            jkVar.mo18340a(this.f3195b);
            jkVar.mo18344b();
        }
        if (this.f3190a != null) {
            jkVar.mo18336a(f3186g);
            this.f3190a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3189a != null && mo18062i()) {
            jkVar.mo18336a(f3187h);
            this.f3189a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void m4239b(boolean z) {
        this.f3193a.set(1, z);
    }

    /* renamed from: b */
    public boolean m4240b() {
        return this.f3194a;
    }

    /* renamed from: c */
    public boolean mo18053c() {
        return this.f3193a.get(0);
    }

    /* renamed from: d */
    public boolean mo18055d() {
        return this.f3193a.get(1);
    }

    /* renamed from: e */
    public boolean mo18056e() {
        return this.f3192a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1891ik)) {
            return compareTo((C1891ik) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo18058f() {
        return this.f3191a != null;
    }

    /* renamed from: g */
    public boolean mo18059g() {
        return this.f3195b != null;
    }

    /* renamed from: h */
    public boolean mo18060h() {
        return this.f3190a != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo18062i() {
        return this.f3189a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        C1868ho hoVar = this.f3188a;
        if (hoVar == null) {
            sb.append("null");
        } else {
            sb.append(hoVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f3194a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f3196b);
        sb.append(", ");
        sb.append("pushAction:");
        ByteBuffer byteBuffer = this.f3192a;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            C1908ja.m4599a(byteBuffer, sb);
        }
        if (mo18058f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f3191a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (mo18059g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f3195b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        C1884id idVar = this.f3190a;
        if (idVar == null) {
            sb.append("null");
        } else {
            sb.append(idVar);
        }
        if (mo18062i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            C1882ib ibVar = this.f3189a;
            if (ibVar == null) {
                sb.append("null");
            } else {
                sb.append(ibVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
