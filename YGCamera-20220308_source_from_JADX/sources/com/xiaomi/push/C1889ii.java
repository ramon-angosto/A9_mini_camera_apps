package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* renamed from: com.xiaomi.push.ii */
public class C1889ii implements C1906iz<C1889ii, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3135a = new C1917jh("", (byte) 12, 2);

    /* renamed from: a */
    private static final C1925jp f3136a = new C1925jp("XmPushActionCommand");

    /* renamed from: b */
    private static final C1917jh f3137b = new C1917jh("", (byte) 11, 3);

    /* renamed from: c */
    private static final C1917jh f3138c = new C1917jh("", (byte) 11, 4);

    /* renamed from: d */
    private static final C1917jh f3139d = new C1917jh("", (byte) 11, 5);

    /* renamed from: e */
    private static final C1917jh f3140e = new C1917jh("", (byte) 15, 6);

    /* renamed from: f */
    private static final C1917jh f3141f = new C1917jh("", (byte) 11, 7);

    /* renamed from: g */
    private static final C1917jh f3142g = new C1917jh("", (byte) 11, 9);

    /* renamed from: h */
    private static final C1917jh f3143h = new C1917jh("", (byte) 2, 10);

    /* renamed from: i */
    private static final C1917jh f3144i = new C1917jh("", (byte) 2, 11);

    /* renamed from: j */
    private static final C1917jh f3145j = new C1917jh("", (byte) 10, 12);

    /* renamed from: a */
    public long f3146a;

    /* renamed from: a */
    public C1884id f3147a;

    /* renamed from: a */
    public String f3148a;

    /* renamed from: a */
    private BitSet f3149a = new BitSet(3);

    /* renamed from: a */
    public List<String> f3150a;

    /* renamed from: a */
    public boolean f3151a = false;

    /* renamed from: b */
    public String f3152b;

    /* renamed from: b */
    public boolean f3153b = true;

    /* renamed from: c */
    public String f3154c;

    /* renamed from: d */
    public String f3155d;

    /* renamed from: e */
    public String f3156e;

    /* renamed from: a */
    public int compareTo(C1889ii iiVar) {
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
        if (!getClass().equals(iiVar.getClass())) {
            return getClass().getName().compareTo(iiVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18004a()).compareTo(Boolean.valueOf(iiVar.mo18004a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18004a() && (a10 = C1908ja.m4588a((Comparable) this.f3147a, (Comparable) iiVar.f3147a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo18008b()).compareTo(Boolean.valueOf(iiVar.mo18008b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo18008b() && (a9 = C1908ja.m4589a(this.f3148a, iiVar.f3148a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo18011c()).compareTo(Boolean.valueOf(iiVar.mo18011c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo18011c() && (a8 = C1908ja.m4589a(this.f3152b, iiVar.f3152b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo18014d()).compareTo(Boolean.valueOf(iiVar.mo18014d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo18014d() && (a7 = C1908ja.m4589a(this.f3154c, iiVar.f3154c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo18016e()).compareTo(Boolean.valueOf(iiVar.mo18016e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo18016e() && (a6 = C1908ja.m4591a((List) this.f3150a, (List) iiVar.f3150a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo18018f()).compareTo(Boolean.valueOf(iiVar.mo18018f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo18018f() && (a5 = C1908ja.m4589a(this.f3155d, iiVar.f3155d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo18019g()).compareTo(Boolean.valueOf(iiVar.mo18019g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo18019g() && (a4 = C1908ja.m4589a(this.f3156e, iiVar.f3156e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo18020h()).compareTo(Boolean.valueOf(iiVar.mo18020h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo18020h() && (a3 = C1908ja.m4595a(this.f3151a, iiVar.f3151a)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo18022i()).compareTo(Boolean.valueOf(iiVar.mo18022i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo18022i() && (a2 = C1908ja.m4595a(this.f3153b, iiVar.f3153b)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo18023j()).compareTo(Boolean.valueOf(iiVar.mo18023j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo18023j() || (a = C1908ja.m4587a(this.f3146a, iiVar.f3146a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1889ii mo18002a(String str) {
        this.f3148a = str;
        return this;
    }

    /* renamed from: a */
    public C1889ii mo18003a(List<String> list) {
        this.f3150a = list;
        return this;
    }

    /* renamed from: a */
    public String mo18004a() {
        return this.f3154c;
    }

    /* renamed from: a */
    public void m4176a() {
        if (this.f3148a == null) {
            throw new C1921jl("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f3152b == null) {
            throw new C1921jl("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f3154c == null) {
            throw new C1921jl("Required field 'cmdName' was not present! Struct: " + toString());
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
            if (r1 != 0) goto L_0x0012
            r6.mo18350f()
            r5.mo18004a()
            return
        L_0x0012:
            short r1 = r0.f3528a
            r2 = 2
            r3 = 1
            r4 = 11
            switch(r1) {
                case 2: goto L_0x00b0;
                case 3: goto L_0x00a5;
                case 4: goto L_0x009a;
                case 5: goto L_0x008f;
                case 6: goto L_0x0067;
                case 7: goto L_0x005c;
                case 8: goto L_0x001b;
                case 9: goto L_0x0051;
                case 10: goto L_0x0042;
                case 11: goto L_0x0033;
                case 12: goto L_0x0022;
                default: goto L_0x001b;
            }
        L_0x001b:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r6, r0)
            goto L_0x00c2
        L_0x0022:
            byte r1 = r0.f3526a
            r2 = 10
            if (r1 != r2) goto L_0x001b
            long r0 = r6.mo18332a()
            r5.f3146a = r0
            r5.mo18010c((boolean) r3)
            goto L_0x00c2
        L_0x0033:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x001b
            boolean r0 = r6.mo18332a()
            r5.f3153b = r0
            r5.mo18007b((boolean) r3)
            goto L_0x00c2
        L_0x0042:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x001b
            boolean r0 = r6.mo18332a()
            r5.f3151a = r0
            r5.mo18005a((boolean) r3)
            goto L_0x00c2
        L_0x0051:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x001b
            java.lang.String r0 = r6.mo18332a()
            r5.f3156e = r0
            goto L_0x00c2
        L_0x005c:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x001b
            java.lang.String r0 = r6.mo18332a()
            r5.f3155d = r0
            goto L_0x00c2
        L_0x0067:
            byte r1 = r0.f3526a
            r2 = 15
            if (r1 != r2) goto L_0x001b
            com.xiaomi.push.ji r0 = r6.mo18332a()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.f3530a
            r1.<init>(r2)
            r5.f3150a = r1
            r1 = 0
        L_0x007b:
            int r2 = r0.f3530a
            if (r1 >= r2) goto L_0x008b
            java.lang.String r2 = r6.mo18332a()
            java.util.List<java.lang.String> r3 = r5.f3150a
            r3.add(r2)
            int r1 = r1 + 1
            goto L_0x007b
        L_0x008b:
            r6.mo18353i()
            goto L_0x00c2
        L_0x008f:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x001b
            java.lang.String r0 = r6.mo18332a()
            r5.f3154c = r0
            goto L_0x00c2
        L_0x009a:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x001b
            java.lang.String r0 = r6.mo18332a()
            r5.f3152b = r0
            goto L_0x00c2
        L_0x00a5:
            byte r1 = r0.f3526a
            if (r1 != r4) goto L_0x001b
            java.lang.String r0 = r6.mo18332a()
            r5.f3148a = r0
            goto L_0x00c2
        L_0x00b0:
            byte r1 = r0.f3526a
            r2 = 12
            if (r1 != r2) goto L_0x001b
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r5.f3147a = r0
            com.xiaomi.push.id r0 = r5.f3147a
            r0.mo17579a((com.xiaomi.push.C1920jk) r6)
        L_0x00c2:
            r6.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1889ii.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void m4178a(String str) {
        if (this.f3150a == null) {
            this.f3150a = new ArrayList();
        }
        this.f3150a.add(str);
    }

    /* renamed from: a */
    public void mo18005a(boolean z) {
        this.f3149a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4180a() {
        return this.f3147a != null;
    }

    /* renamed from: a */
    public boolean m4181a(C1889ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean a = mo18004a();
        boolean a2 = iiVar.mo18004a();
        if ((a || a2) && (!a || !a2 || !this.f3147a.compareTo(iiVar.f3147a))) {
            return false;
        }
        boolean b = mo18008b();
        boolean b2 = iiVar.mo18008b();
        if ((b || b2) && (!b || !b2 || !this.f3148a.equals(iiVar.f3148a))) {
            return false;
        }
        boolean c = mo18011c();
        boolean c2 = iiVar.mo18011c();
        if ((c || c2) && (!c || !c2 || !this.f3152b.equals(iiVar.f3152b))) {
            return false;
        }
        boolean d = mo18014d();
        boolean d2 = iiVar.mo18014d();
        if ((d || d2) && (!d || !d2 || !this.f3154c.equals(iiVar.f3154c))) {
            return false;
        }
        boolean e = mo18016e();
        boolean e2 = iiVar.mo18016e();
        if ((e || e2) && (!e || !e2 || !this.f3150a.equals(iiVar.f3150a))) {
            return false;
        }
        boolean f = mo18018f();
        boolean f2 = iiVar.mo18018f();
        if ((f || f2) && (!f || !f2 || !this.f3155d.equals(iiVar.f3155d))) {
            return false;
        }
        boolean g = mo18019g();
        boolean g2 = iiVar.mo18019g();
        if ((g || g2) && (!g || !g2 || !this.f3156e.equals(iiVar.f3156e))) {
            return false;
        }
        boolean h = mo18020h();
        boolean h2 = iiVar.mo18020h();
        if ((h || h2) && (!h || !h2 || this.f3151a != iiVar.f3151a)) {
            return false;
        }
        boolean i = mo18022i();
        boolean i2 = iiVar.mo18022i();
        if ((i || i2) && (!i || !i2 || this.f3153b != iiVar.f3153b)) {
            return false;
        }
        boolean j = mo18023j();
        boolean j2 = iiVar.mo18023j();
        if (j || j2) {
            return j && j2 && this.f3146a == iiVar.f3146a;
        }
        return true;
    }

    /* renamed from: b */
    public C1889ii mo18006b(String str) {
        this.f3152b = str;
        return this;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18004a();
        jkVar.mo18339a(f3136a);
        if (this.f3147a != null && mo18004a()) {
            jkVar.mo18336a(f3135a);
            this.f3147a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3148a != null) {
            jkVar.mo18336a(f3137b);
            jkVar.mo18340a(this.f3148a);
            jkVar.mo18344b();
        }
        if (this.f3152b != null) {
            jkVar.mo18336a(f3138c);
            jkVar.mo18340a(this.f3152b);
            jkVar.mo18344b();
        }
        if (this.f3154c != null) {
            jkVar.mo18336a(f3139d);
            jkVar.mo18340a(this.f3154c);
            jkVar.mo18344b();
        }
        if (this.f3150a != null && mo18016e()) {
            jkVar.mo18336a(f3140e);
            jkVar.mo18337a(new C1918ji((byte) 11, this.f3150a.size()));
            for (String a : this.f3150a) {
                jkVar.mo18340a(a);
            }
            jkVar.mo18349e();
            jkVar.mo18344b();
        }
        if (this.f3155d != null && mo18018f()) {
            jkVar.mo18336a(f3141f);
            jkVar.mo18340a(this.f3155d);
            jkVar.mo18344b();
        }
        if (this.f3156e != null && mo18019g()) {
            jkVar.mo18336a(f3142g);
            jkVar.mo18340a(this.f3156e);
            jkVar.mo18344b();
        }
        if (mo18020h()) {
            jkVar.mo18336a(f3143h);
            jkVar.mo18343a(this.f3151a);
            jkVar.mo18344b();
        }
        if (mo18022i()) {
            jkVar.mo18336a(f3144i);
            jkVar.mo18343a(this.f3153b);
            jkVar.mo18344b();
        }
        if (mo18023j()) {
            jkVar.mo18336a(f3145j);
            jkVar.mo18335a(this.f3146a);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo18007b(boolean z) {
        this.f3149a.set(1, z);
    }

    /* renamed from: b */
    public boolean mo18008b() {
        return this.f3148a != null;
    }

    /* renamed from: c */
    public C1889ii mo18009c(String str) {
        this.f3154c = str;
        return this;
    }

    /* renamed from: c */
    public void mo18010c(boolean z) {
        this.f3149a.set(2, z);
    }

    /* renamed from: c */
    public boolean mo18011c() {
        return this.f3152b != null;
    }

    /* renamed from: d */
    public C1889ii mo18013d(String str) {
        this.f3155d = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo18014d() {
        return this.f3154c != null;
    }

    /* renamed from: e */
    public C1889ii mo18015e(String str) {
        this.f3156e = str;
        return this;
    }

    /* renamed from: e */
    public boolean mo18016e() {
        return this.f3150a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1889ii)) {
            return compareTo((C1889ii) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo18018f() {
        return this.f3155d != null;
    }

    /* renamed from: g */
    public boolean mo18019g() {
        return this.f3156e != null;
    }

    /* renamed from: h */
    public boolean mo18020h() {
        return this.f3149a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo18022i() {
        return this.f3149a.get(1);
    }

    /* renamed from: j */
    public boolean mo18023j() {
        return this.f3149a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (mo18004a()) {
            sb.append("target:");
            C1884id idVar = this.f3147a;
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
        String str = this.f3148a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f3152b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f3154c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (mo18016e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f3150a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (mo18018f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f3155d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo18019g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f3156e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo18020h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f3151a);
        }
        if (mo18022i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f3153b);
        }
        if (mo18023j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f3146a);
        }
        sb.append(")");
        return sb.toString();
    }
}
