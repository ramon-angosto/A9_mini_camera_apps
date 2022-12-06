package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Map;

/* renamed from: com.xiaomi.push.if */
public class C1886if implements C1906iz<C1886if, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3104a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f3105a = new C1925jp("XmPushActionAckNotification");

    /* renamed from: b */
    private static final C1917jh f3106b = new C1917jh("", (byte) 12, 2);

    /* renamed from: c */
    private static final C1917jh f3107c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3108d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3109e = new C1917jh("", (byte) 11, 5);

    /* renamed from: f */
    private static final C1917jh f3110f = new C1917jh("", (byte) 10, 7);

    /* renamed from: g */
    private static final C1917jh f3111g = new C1917jh("", (byte) 11, 8);

    /* renamed from: h */
    private static final C1917jh f3112h = new C1917jh("", (byte) 13, 9);

    /* renamed from: i */
    private static final C1917jh f3113i = new C1917jh("", (byte) 11, 10);

    /* renamed from: j */
    private static final C1917jh f3114j = new C1917jh("", (byte) 11, 11);

    /* renamed from: a */
    public long f3115a = 0;

    /* renamed from: a */
    public C1884id f3116a;

    /* renamed from: a */
    public String f3117a;

    /* renamed from: a */
    private BitSet f3118a = new BitSet(1);

    /* renamed from: a */
    public Map<String, String> f3119a;

    /* renamed from: b */
    public String f3120b;

    /* renamed from: c */
    public String f3121c;

    /* renamed from: d */
    public String f3122d;

    /* renamed from: e */
    public String f3123e;

    /* renamed from: f */
    public String f3124f;

    /* renamed from: g */
    public String f3125g;

    /* renamed from: a */
    public int compareTo(C1886if ifVar) {
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
        if (!getClass().equals(ifVar.getClass())) {
            return getClass().getName().compareTo(ifVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17964a()).compareTo(Boolean.valueOf(ifVar.mo17964a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17964a() && (a10 = C1908ja.m4589a(this.f3117a, ifVar.f3117a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo17967b()).compareTo(Boolean.valueOf(ifVar.mo17967b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo17967b() && (a9 = C1908ja.m4588a((Comparable) this.f3116a, (Comparable) ifVar.f3116a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo17969c()).compareTo(Boolean.valueOf(ifVar.mo17969c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo17969c() && (a8 = C1908ja.m4589a(this.f3120b, ifVar.f3120b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo17972d()).compareTo(Boolean.valueOf(ifVar.mo17972d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo17972d() && (a7 = C1908ja.m4589a(this.f3121c, ifVar.f3121c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo17974e()).compareTo(Boolean.valueOf(ifVar.mo17974e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo17974e() && (a6 = C1908ja.m4589a(this.f3122d, ifVar.f3122d)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo17976f()).compareTo(Boolean.valueOf(ifVar.mo17976f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo17976f() && (a5 = C1908ja.m4587a(this.f3115a, ifVar.f3115a)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo17977g()).compareTo(Boolean.valueOf(ifVar.mo17977g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo17977g() && (a4 = C1908ja.m4589a(this.f3123e, ifVar.f3123e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo17978h()).compareTo(Boolean.valueOf(ifVar.mo17978h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo17978h() && (a3 = C1908ja.m4592a((Map) this.f3119a, (Map) ifVar.f3119a)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo17980i()).compareTo(Boolean.valueOf(ifVar.mo17980i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo17980i() && (a2 = C1908ja.m4589a(this.f3124f, ifVar.f3124f)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo17981j()).compareTo(Boolean.valueOf(ifVar.mo17981j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo17981j() || (a = C1908ja.m4589a(this.f3125g, ifVar.f3125g)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1886if mo17961a(long j) {
        this.f3115a = j;
        mo17965a(true);
        return this;
    }

    /* renamed from: a */
    public C1886if mo17962a(C1884id idVar) {
        this.f3116a = idVar;
        return this;
    }

    /* renamed from: a */
    public C1886if mo17963a(String str) {
        this.f3120b = str;
        return this;
    }

    /* renamed from: a */
    public String mo17964a() {
        return this.f3120b;
    }

    /* renamed from: a */
    public Map<String, String> m4133a() {
        return this.f3119a;
    }

    /* renamed from: a */
    public void m4134a() {
        if (this.f3120b == null) {
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
            if (r1 != 0) goto L_0x0012
            r6.mo18350f()
            r5.mo17964a()
            return
        L_0x0012:
            short r1 = r0.f3528a
            r2 = 11
            switch(r1) {
                case 1: goto L_0x00b6;
                case 2: goto L_0x00a3;
                case 3: goto L_0x0098;
                case 4: goto L_0x008d;
                case 5: goto L_0x0082;
                case 6: goto L_0x0019;
                case 7: goto L_0x0071;
                case 8: goto L_0x0066;
                case 9: goto L_0x0038;
                case 10: goto L_0x002c;
                case 11: goto L_0x0020;
                default: goto L_0x0019;
            }
        L_0x0019:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r6, r0)
            goto L_0x00c0
        L_0x0020:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.mo18332a()
            r5.f3125g = r0
            goto L_0x00c0
        L_0x002c:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.mo18332a()
            r5.f3124f = r0
            goto L_0x00c0
        L_0x0038:
            byte r1 = r0.f3526a
            r2 = 13
            if (r1 != r2) goto L_0x0019
            com.xiaomi.push.jj r0 = r6.mo18332a()
            java.util.HashMap r1 = new java.util.HashMap
            int r2 = r0.f3532a
            int r2 = r2 * 2
            r1.<init>(r2)
            r5.f3119a = r1
            r1 = 0
        L_0x004e:
            int r2 = r0.f3532a
            if (r1 >= r2) goto L_0x0062
            java.lang.String r2 = r6.mo18332a()
            java.lang.String r3 = r6.mo18332a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.f3119a
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x004e
        L_0x0062:
            r6.mo18352h()
            goto L_0x00c0
        L_0x0066:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.mo18332a()
            r5.f3123e = r0
            goto L_0x00c0
        L_0x0071:
            byte r1 = r0.f3526a
            r2 = 10
            if (r1 != r2) goto L_0x0019
            long r0 = r6.mo18332a()
            r5.f3115a = r0
            r0 = 1
            r5.mo17965a((boolean) r0)
            goto L_0x00c0
        L_0x0082:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.mo18332a()
            r5.f3122d = r0
            goto L_0x00c0
        L_0x008d:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.mo18332a()
            r5.f3121c = r0
            goto L_0x00c0
        L_0x0098:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.mo18332a()
            r5.f3120b = r0
            goto L_0x00c0
        L_0x00a3:
            byte r1 = r0.f3526a
            r2 = 12
            if (r1 != r2) goto L_0x0019
            com.xiaomi.push.id r0 = new com.xiaomi.push.id
            r0.<init>()
            r5.f3116a = r0
            com.xiaomi.push.id r0 = r5.f3116a
            r0.mo17579a((com.xiaomi.push.C1920jk) r6)
            goto L_0x00c0
        L_0x00b6:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.mo18332a()
            r5.f3117a = r0
        L_0x00c0:
            r6.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1886if.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo17965a(boolean z) {
        this.f3118a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4137a() {
        return this.f3117a != null;
    }

    /* renamed from: a */
    public boolean m4138a(C1886if ifVar) {
        if (ifVar == null) {
            return false;
        }
        boolean a = mo17964a();
        boolean a2 = ifVar.mo17964a();
        if ((a || a2) && (!a || !a2 || !this.f3117a.equals(ifVar.f3117a))) {
            return false;
        }
        boolean b = mo17967b();
        boolean b2 = ifVar.mo17967b();
        if ((b || b2) && (!b || !b2 || !this.f3116a.compareTo(ifVar.f3116a))) {
            return false;
        }
        boolean c = mo17969c();
        boolean c2 = ifVar.mo17969c();
        if ((c || c2) && (!c || !c2 || !this.f3120b.equals(ifVar.f3120b))) {
            return false;
        }
        boolean d = mo17972d();
        boolean d2 = ifVar.mo17972d();
        if ((d || d2) && (!d || !d2 || !this.f3121c.equals(ifVar.f3121c))) {
            return false;
        }
        boolean e = mo17974e();
        boolean e2 = ifVar.mo17974e();
        if ((e || e2) && (!e || !e2 || !this.f3122d.equals(ifVar.f3122d))) {
            return false;
        }
        boolean f = mo17976f();
        boolean f2 = ifVar.mo17976f();
        if ((f || f2) && (!f || !f2 || this.f3115a != ifVar.f3115a)) {
            return false;
        }
        boolean g = mo17977g();
        boolean g2 = ifVar.mo17977g();
        if ((g || g2) && (!g || !g2 || !this.f3123e.equals(ifVar.f3123e))) {
            return false;
        }
        boolean h = mo17978h();
        boolean h2 = ifVar.mo17978h();
        if ((h || h2) && (!h || !h2 || !this.f3119a.equals(ifVar.f3119a))) {
            return false;
        }
        boolean i = mo17980i();
        boolean i2 = ifVar.mo17980i();
        if ((i || i2) && (!i || !i2 || !this.f3124f.equals(ifVar.f3124f))) {
            return false;
        }
        boolean j = mo17981j();
        boolean j2 = ifVar.mo17981j();
        if (j || j2) {
            return j && j2 && this.f3125g.equals(ifVar.f3125g);
        }
        return true;
    }

    /* renamed from: b */
    public C1886if mo17966b(String str) {
        this.f3121c = str;
        return this;
    }

    /* renamed from: b */
    public String mo17967b() {
        return this.f3122d;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17964a();
        jkVar.mo18339a(f3105a);
        if (this.f3117a != null && mo17964a()) {
            jkVar.mo18336a(f3104a);
            jkVar.mo18340a(this.f3117a);
            jkVar.mo18344b();
        }
        if (this.f3116a != null && mo17967b()) {
            jkVar.mo18336a(f3106b);
            this.f3116a.mo17583b(jkVar);
            jkVar.mo18344b();
        }
        if (this.f3120b != null) {
            jkVar.mo18336a(f3107c);
            jkVar.mo18340a(this.f3120b);
            jkVar.mo18344b();
        }
        if (this.f3121c != null && mo17972d()) {
            jkVar.mo18336a(f3108d);
            jkVar.mo18340a(this.f3121c);
            jkVar.mo18344b();
        }
        if (this.f3122d != null && mo17974e()) {
            jkVar.mo18336a(f3109e);
            jkVar.mo18340a(this.f3122d);
            jkVar.mo18344b();
        }
        if (mo17976f()) {
            jkVar.mo18336a(f3110f);
            jkVar.mo18335a(this.f3115a);
            jkVar.mo18344b();
        }
        if (this.f3123e != null && mo17977g()) {
            jkVar.mo18336a(f3111g);
            jkVar.mo18340a(this.f3123e);
            jkVar.mo18344b();
        }
        if (this.f3119a != null && mo17978h()) {
            jkVar.mo18336a(f3112h);
            jkVar.mo18338a(new C1919jj((byte) 11, (byte) 11, this.f3119a.size()));
            for (Map.Entry next : this.f3119a.entrySet()) {
                jkVar.mo18340a((String) next.getKey());
                jkVar.mo18340a((String) next.getValue());
            }
            jkVar.mo18348d();
            jkVar.mo18344b();
        }
        if (this.f3124f != null && mo17980i()) {
            jkVar.mo18336a(f3113i);
            jkVar.mo18340a(this.f3124f);
            jkVar.mo18344b();
        }
        if (this.f3125g != null && mo17981j()) {
            jkVar.mo18336a(f3114j);
            jkVar.mo18340a(this.f3125g);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public boolean m4142b() {
        return this.f3116a != null;
    }

    /* renamed from: c */
    public C1886if mo17968c(String str) {
        this.f3122d = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo17969c() {
        return this.f3120b != null;
    }

    /* renamed from: d */
    public C1886if mo17971d(String str) {
        this.f3123e = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo17972d() {
        return this.f3121c != null;
    }

    /* renamed from: e */
    public C1886if mo17973e(String str) {
        this.f3124f = str;
        return this;
    }

    /* renamed from: e */
    public boolean mo17974e() {
        return this.f3122d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1886if)) {
            return compareTo((C1886if) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo17976f() {
        return this.f3118a.get(0);
    }

    /* renamed from: g */
    public boolean mo17977g() {
        return this.f3123e != null;
    }

    /* renamed from: h */
    public boolean mo17978h() {
        return this.f3119a != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo17980i() {
        return this.f3124f != null;
    }

    /* renamed from: j */
    public boolean mo17981j() {
        return this.f3125g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        if (mo17964a()) {
            sb.append("debug:");
            String str = this.f3117a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (mo17967b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C1884id idVar = this.f3116a;
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
        String str2 = this.f3120b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (mo17972d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f3121c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (mo17974e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f3122d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (mo17976f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f3115a);
        }
        if (mo17977g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f3123e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (mo17978h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f3119a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (mo17980i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f3124f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (mo17981j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f3125g;
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
