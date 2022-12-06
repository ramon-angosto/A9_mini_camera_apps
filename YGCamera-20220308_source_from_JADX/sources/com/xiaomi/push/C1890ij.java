package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.List;

/* renamed from: com.xiaomi.push.ij */
public class C1890ij implements C1906iz<C1890ij, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3157a = new C1917jh("", (byte) 12, 2);

    /* renamed from: a */
    private static final C1925jp f3158a = new C1925jp("XmPushActionCommandResult");

    /* renamed from: b */
    private static final C1917jh f3159b = new C1917jh("", (byte) 11, 3);

    /* renamed from: c */
    private static final C1917jh f3160c = new C1917jh("", (byte) 11, 4);

    /* renamed from: d */
    private static final C1917jh f3161d = new C1917jh("", (byte) 11, 5);

    /* renamed from: e */
    private static final C1917jh f3162e = new C1917jh("", (byte) 10, 7);

    /* renamed from: f */
    private static final C1917jh f3163f = new C1917jh("", (byte) 11, 8);

    /* renamed from: g */
    private static final C1917jh f3164g = new C1917jh("", (byte) 11, 9);

    /* renamed from: h */
    private static final C1917jh f3165h = new C1917jh("", (byte) 15, 10);

    /* renamed from: i */
    private static final C1917jh f3166i = new C1917jh("", (byte) 11, 12);

    /* renamed from: j */
    private static final C1917jh f3167j = new C1917jh("", (byte) 2, 13);

    /* renamed from: a */
    public long f3168a;

    /* renamed from: a */
    public C1884id f3169a;

    /* renamed from: a */
    public String f3170a;

    /* renamed from: a */
    private BitSet f3171a = new BitSet(2);

    /* renamed from: a */
    public List<String> f3172a;

    /* renamed from: a */
    public boolean f3173a = true;

    /* renamed from: b */
    public String f3174b;

    /* renamed from: c */
    public String f3175c;

    /* renamed from: d */
    public String f3176d;

    /* renamed from: e */
    public String f3177e;

    /* renamed from: f */
    public String f3178f;

    /* renamed from: a */
    public int compareTo(C1890ij ijVar) {
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
        if (!getClass().equals(ijVar.getClass())) {
            return getClass().getName().compareTo(ijVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18026a()).compareTo(Boolean.valueOf(ijVar.mo18026a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18026a() && (a10 = C1908ja.m4588a((Comparable) this.f3169a, (Comparable) ijVar.f3169a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo18028b()).compareTo(Boolean.valueOf(ijVar.mo18028b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo18028b() && (a9 = C1908ja.m4589a(this.f3170a, ijVar.f3170a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo18030c()).compareTo(Boolean.valueOf(ijVar.mo18030c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo18030c() && (a8 = C1908ja.m4589a(this.f3174b, ijVar.f3174b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo18032d()).compareTo(Boolean.valueOf(ijVar.mo18032d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo18032d() && (a7 = C1908ja.m4589a(this.f3175c, ijVar.f3175c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo18033e()).compareTo(Boolean.valueOf(ijVar.mo18033e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo18033e() && (a6 = C1908ja.m4587a(this.f3168a, ijVar.f3168a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo18035f()).compareTo(Boolean.valueOf(ijVar.mo18035f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo18035f() && (a5 = C1908ja.m4589a(this.f3176d, ijVar.f3176d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo18036g()).compareTo(Boolean.valueOf(ijVar.mo18036g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo18036g() && (a4 = C1908ja.m4589a(this.f3177e, ijVar.f3177e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo18037h()).compareTo(Boolean.valueOf(ijVar.mo18037h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo18037h() && (a3 = C1908ja.m4591a((List) this.f3172a, (List) ijVar.f3172a)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo18039i()).compareTo(Boolean.valueOf(ijVar.mo18039i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo18039i() && (a2 = C1908ja.m4589a(this.f3178f, ijVar.f3178f)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo18040j()).compareTo(Boolean.valueOf(ijVar.mo18040j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo18040j() || (a = C1908ja.m4595a(this.f3173a, ijVar.f3173a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public String mo18026a() {
        return this.f3170a;
    }

    /* renamed from: a */
    public List<String> m4200a() {
        return this.f3172a;
    }

    /* renamed from: a */
    public void m4201a() {
        if (this.f3170a == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3174b == null) {
            throw new C1921jl("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f3175c == null) {
            throw new C1921jl("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17579a(com.xiaomi.push.C1920jk r5) {
        /*
            r4 = this;
            r5.mo18332a()
        L_0x0003:
            com.xiaomi.push.jh r0 = r5.mo18332a()
            byte r1 = r0.f3526a
            if (r1 != 0) goto L_0x0033
            r5.mo18350f()
            boolean r5 = r4.mo18033e()
            if (r5 == 0) goto L_0x0018
            r4.mo18026a()
            return
        L_0x0018:
            com.xiaomi.push.jl r5 = new com.xiaomi.push.jl
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'errorCode' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r4.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0033:
            short r1 = r0.f3528a
            r2 = 1
            r3 = 11
            switch(r1) {
                case 2: goto L_0x00cd;
                case 3: goto L_0x00c2;
                case 4: goto L_0x00b7;
                case 5: goto L_0x00ac;
                case 6: goto L_0x003b;
                case 7: goto L_0x009c;
                case 8: goto L_0x0091;
                case 9: goto L_0x0086;
                case 10: goto L_0x005e;
                case 11: goto L_0x003b;
                case 12: goto L_0x0052;
                case 13: goto L_0x0042;
                default: goto L_0x003b;
            }
        L_0x003b:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r5, r0)
            goto L_0x00df
        L_0x0042:
            byte r1 = r0.f3526a
            r3 = 2
            if (r1 != r3) goto L_0x003b
            boolean r0 = r5.mo18332a()
            r4.f3173a = r0
            r4.mo18029b((boolean) r2)
            goto L_0x00df
        L_0x0052:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x003b
            java.lang.String r0 = r5.mo18332a()
            r4.f3178f = r0
            goto L_0x00df
        L_0x005e:
            byte r1 = r0.f3526a
            r2 = 15
            if (r1 != r2) goto L_0x003b
            com.xiaomi.push.ji r0 = r5.mo18332a()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.f3530a
            r1.<init>(r2)
            r4.f3172a = r1
            r1 = 0
        L_0x0072:
            int r2 = r0.f3530a
            if (r1 >= r2) goto L_0x0082
            java.lang.String r2 = r5.mo18332a()
            java.util.List<java.lang.String> r3 = r4.f3172a
            r3.add(r2)
            int r1 = r1 + 1
            goto L_0x0072
        L_0x0082:
            r5.mo18353i()
            goto L_0x00df
        L_0x0086:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x003b
            java.lang.String r0 = r5.mo18332a()
            r4.f3177e = r0
            goto L_0x00df
        L_0x0091:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x003b
            java.lang.String r0 = r5.mo18332a()
            r4.f3176d = r0
            goto L_0x00df
        L_0x009c:
            byte r1 = r0.f3526a
            r3 = 10
            if (r1 != r3) goto L_0x003b
            long r0 = r5.mo18332a()
            r4.f3168a = r0
            r4.mo18027a((boolean) r2)
            goto L_0x00df
        L_0x00ac:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x003b
            java.lang.String r0 = r5.mo18332a()
            r4.f3175c = r0
            goto L_0x00df
        L_0x00b7:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x003b
            java.lang.String r0 = r5.mo18332a()
            r4.f3174b = r0
            goto L_0x00df
        L_0x00c2:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x003b
            java.lang.String r0 = r5.mo18332a()
            r4.f3170a = r0
            goto L_0x00df
        L_0x00cd:
            byte r1 = r0.f3526a
            r2 = 12
            if (r1 != r2) goto L_0x003b
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r4.f3169a = r0
            com.xiaomi.push.id r0 = r4.f3169a
            r0.mo17579a((com.xiaomi.push.C1920jk) r5)
        L_0x00df:
            r5.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1890ij.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo18027a(boolean z) {
        this.f3171a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4204a() {
        return this.f3169a != null;
    }

    /* renamed from: a */
    public boolean m4205a(C1890ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean a = mo18026a();
        boolean a2 = ijVar.mo18026a();
        if ((a || a2) && (!a || !a2 || !this.f3169a.compareTo(ijVar.f3169a))) {
            return false;
        }
        boolean b = mo18028b();
        boolean b2 = ijVar.mo18028b();
        if ((b || b2) && (!b || !b2 || !this.f3170a.equals(ijVar.f3170a))) {
            return false;
        }
        boolean c = mo18030c();
        boolean c2 = ijVar.mo18030c();
        if ((c || c2) && (!c || !c2 || !this.f3174b.equals(ijVar.f3174b))) {
            return false;
        }
        boolean d = mo18032d();
        boolean d2 = ijVar.mo18032d();
        if (((d || d2) && (!d || !d2 || !this.f3175c.equals(ijVar.f3175c))) || this.f3168a != ijVar.f3168a) {
            return false;
        }
        boolean f = mo18035f();
        boolean f2 = ijVar.mo18035f();
        if ((f || f2) && (!f || !f2 || !this.f3176d.equals(ijVar.f3176d))) {
            return false;
        }
        boolean g = mo18036g();
        boolean g2 = ijVar.mo18036g();
        if ((g || g2) && (!g || !g2 || !this.f3177e.equals(ijVar.f3177e))) {
            return false;
        }
        boolean h = mo18037h();
        boolean h2 = ijVar.mo18037h();
        if ((h || h2) && (!h || !h2 || !this.f3172a.equals(ijVar.f3172a))) {
            return false;
        }
        boolean i = mo18039i();
        boolean i2 = ijVar.mo18039i();
        if ((i || i2) && (!i || !i2 || !this.f3178f.equals(ijVar.f3178f))) {
            return false;
        }
        boolean j = mo18040j();
        boolean j2 = ijVar.mo18040j();
        if (j || j2) {
            return j && j2 && this.f3173a == ijVar.f3173a;
        }
        return true;
    }

    /* renamed from: b */
    public String mo18028b() {
        return this.f3175c;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18026a();
        jkVar.mo18339a(f3158a);
        if (this.f3169a != null && mo18026a()) {
            jkVar.mo18336a(f3157a);
            this.f3169a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3170a != null) {
            jkVar.mo18336a(f3159b);
            jkVar.mo18340a(this.f3170a);
            jkVar.mo18344b();
        }
        if (this.f3174b != null) {
            jkVar.mo18336a(f3160c);
            jkVar.mo18340a(this.f3174b);
            jkVar.mo18344b();
        }
        if (this.f3175c != null) {
            jkVar.mo18336a(f3161d);
            jkVar.mo18340a(this.f3175c);
            jkVar.mo18344b();
        }
        jkVar.mo18336a(f3162e);
        jkVar.mo18335a(this.f3168a);
        jkVar.mo18344b();
        if (this.f3176d != null && mo18035f()) {
            jkVar.mo18336a(f3163f);
            jkVar.mo18340a(this.f3176d);
            jkVar.mo18344b();
        }
        if (this.f3177e != null && mo18036g()) {
            jkVar.mo18336a(f3164g);
            jkVar.mo18340a(this.f3177e);
            jkVar.mo18344b();
        }
        if (this.f3172a != null && mo18037h()) {
            jkVar.mo18336a(f3165h);
            jkVar.mo18337a(new C1918ji((byte) 11, this.f3172a.size()));
            for (String a : this.f3172a) {
                jkVar.mo18340a(a);
            }
            jkVar.mo18349e();
            jkVar.mo18344b();
        }
        if (this.f3178f != null && mo18039i()) {
            jkVar.mo18336a(f3166i);
            jkVar.mo18340a(this.f3178f);
            jkVar.mo18344b();
        }
        if (mo18040j()) {
            jkVar.mo18336a(f3167j);
            jkVar.mo18343a(this.f3173a);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo18029b(boolean z) {
        this.f3171a.set(1, z);
    }

    /* renamed from: b */
    public boolean m4209b() {
        return this.f3170a != null;
    }

    /* renamed from: c */
    public String mo18030c() {
        return this.f3178f;
    }

    /* renamed from: c */
    public boolean m4211c() {
        return this.f3174b != null;
    }

    /* renamed from: d */
    public boolean mo18032d() {
        return this.f3175c != null;
    }

    /* renamed from: e */
    public boolean mo18033e() {
        return this.f3171a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1890ij)) {
            return compareTo((C1890ij) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo18035f() {
        return this.f3176d != null;
    }

    /* renamed from: g */
    public boolean mo18036g() {
        return this.f3177e != null;
    }

    /* renamed from: h */
    public boolean mo18037h() {
        return this.f3172a != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo18039i() {
        return this.f3178f != null;
    }

    /* renamed from: j */
    public boolean mo18040j() {
        return this.f3171a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (mo18026a()) {
            sb.append("target:");
            C1884id idVar = this.f3169a;
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
        String str = this.f3170a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f3174b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f3175c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f3168a);
        if (mo18035f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f3176d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo18036g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f3177e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo18037h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f3172a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (mo18039i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f3178f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (mo18040j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f3173a);
        }
        sb.append(")");
        return sb.toString();
    }
}
