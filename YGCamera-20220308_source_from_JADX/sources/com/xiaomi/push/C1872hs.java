package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.hs */
public class C1872hs implements C1906iz<C1872hs, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f2724a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f2725a = new C1925jp("ClientUploadDataItem");

    /* renamed from: b */
    private static final C1917jh f2726b = new C1917jh("", (byte) 11, 2);

    /* renamed from: c */
    private static final C1917jh f2727c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f2728d = new C1917jh("", (byte) 10, 4);

    /* renamed from: e */
    private static final C1917jh f2729e = new C1917jh("", (byte) 10, 5);

    /* renamed from: f */
    private static final C1917jh f2730f = new C1917jh("", (byte) 2, 6);

    /* renamed from: g */
    private static final C1917jh f2731g = new C1917jh("", (byte) 11, 7);

    /* renamed from: h */
    private static final C1917jh f2732h = new C1917jh("", (byte) 11, 8);

    /* renamed from: i */
    private static final C1917jh f2733i = new C1917jh("", (byte) 11, 9);

    /* renamed from: j */
    private static final C1917jh f2734j = new C1917jh("", (byte) 13, 10);

    /* renamed from: k */
    private static final C1917jh f2735k = new C1917jh("", (byte) 11, 11);

    /* renamed from: a */
    public long f2736a;

    /* renamed from: a */
    public String f2737a;

    /* renamed from: a */
    private BitSet f2738a = new BitSet(3);

    /* renamed from: a */
    public Map<String, String> f2739a;

    /* renamed from: a */
    public boolean f2740a;

    /* renamed from: b */
    public long f2741b;

    /* renamed from: b */
    public String f2742b;

    /* renamed from: c */
    public String f2743c;

    /* renamed from: d */
    public String f2744d;

    /* renamed from: e */
    public String f2745e;

    /* renamed from: f */
    public String f2746f;

    /* renamed from: g */
    public String f2747g;

    /* renamed from: a */
    public int compareTo(C1872hs hsVar) {
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
        if (!getClass().equals(hsVar.getClass())) {
            return getClass().getName().compareTo(hsVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17777a()).compareTo(Boolean.valueOf(hsVar.mo17777a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17777a() && (a11 = C1908ja.m4589a(this.f2737a, hsVar.f2737a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(mo17785b()).compareTo(Boolean.valueOf(hsVar.mo17785b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo17785b() && (a10 = C1908ja.m4589a(this.f2742b, hsVar.f2742b)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(mo17788c()).compareTo(Boolean.valueOf(hsVar.mo17788c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo17788c() && (a9 = C1908ja.m4589a(this.f2743c, hsVar.f2743c)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(mo17792d()).compareTo(Boolean.valueOf(hsVar.mo17792d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo17792d() && (a8 = C1908ja.m4587a(this.f2736a, hsVar.f2736a)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(mo17794e()).compareTo(Boolean.valueOf(hsVar.mo17794e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo17794e() && (a7 = C1908ja.m4587a(this.f2741b, hsVar.f2741b)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(mo17797f()).compareTo(Boolean.valueOf(hsVar.mo17797f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo17797f() && (a6 = C1908ja.m4595a(this.f2740a, hsVar.f2740a)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(mo17799g()).compareTo(Boolean.valueOf(hsVar.mo17799g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo17799g() && (a5 = C1908ja.m4589a(this.f2744d, hsVar.f2744d)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(mo17800h()).compareTo(Boolean.valueOf(hsVar.mo17800h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo17800h() && (a4 = C1908ja.m4589a(this.f2745e, hsVar.f2745e)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(mo17802i()).compareTo(Boolean.valueOf(hsVar.mo17802i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo17802i() && (a3 = C1908ja.m4589a(this.f2746f, hsVar.f2746f)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(mo17803j()).compareTo(Boolean.valueOf(hsVar.mo17803j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (mo17803j() && (a2 = C1908ja.m4592a((Map) this.f2739a, (Map) hsVar.f2739a)) != 0) {
            return a2;
        }
        int compareTo11 = Boolean.valueOf(mo17804k()).compareTo(Boolean.valueOf(hsVar.mo17804k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!mo17804k() || (a = C1908ja.m4589a(this.f2747g, hsVar.f2747g)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public long mo17777a() {
        return this.f2741b;
    }

    /* renamed from: a */
    public C1872hs mo17778a(long j) {
        this.f2736a = j;
        mo17781a(true);
        return this;
    }

    /* renamed from: a */
    public C1872hs mo17779a(String str) {
        this.f2737a = str;
        return this;
    }

    /* renamed from: a */
    public C1872hs mo17780a(Map<String, String> map) {
        this.f2739a = map;
        return this;
    }

    /* renamed from: a */
    public C1872hs mo17781a(boolean z) {
        this.f2740a = z;
        mo17789c(true);
        return this;
    }

    /* renamed from: a */
    public String m3914a() {
        return this.f2737a;
    }

    /* renamed from: a */
    public Map<String, String> m3915a() {
        return this.f2739a;
    }

    /* renamed from: a */
    public void m3916a() {
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
            r6.mo17777a()
            return
        L_0x0012:
            short r1 = r0.f3528a
            r2 = 2
            r3 = 10
            r4 = 1
            r5 = 11
            switch(r1) {
                case 1: goto L_0x00c0;
                case 2: goto L_0x00b5;
                case 3: goto L_0x00aa;
                case 4: goto L_0x009c;
                case 5: goto L_0x008e;
                case 6: goto L_0x0080;
                case 7: goto L_0x0075;
                case 8: goto L_0x006a;
                case 9: goto L_0x005f;
                case 10: goto L_0x0030;
                case 11: goto L_0x0024;
                default: goto L_0x001d;
            }
        L_0x001d:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r7, r0)
            goto L_0x00ca
        L_0x0024:
            byte r1 = r0.f3526a
            if (r1 != r5) goto L_0x001d
            java.lang.String r0 = r7.mo18332a()
            r6.f2747g = r0
            goto L_0x00ca
        L_0x0030:
            byte r1 = r0.f3526a
            r3 = 13
            if (r1 != r3) goto L_0x001d
            com.xiaomi.push.jj r0 = r7.mo18332a()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.f3532a
            int r3 = r3 * 2
            r1.<init>(r3)
            r6.f2739a = r1
            r1 = 0
        L_0x0046:
            int r2 = r0.f3532a
            if (r1 >= r2) goto L_0x005a
            java.lang.String r2 = r7.mo18332a()
            java.lang.String r3 = r7.mo18332a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r6.f2739a
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x0046
        L_0x005a:
            r7.mo18352h()
            goto L_0x00ca
        L_0x005f:
            byte r1 = r0.f3526a
            if (r1 != r5) goto L_0x001d
            java.lang.String r0 = r7.mo18332a()
            r6.f2746f = r0
            goto L_0x00ca
        L_0x006a:
            byte r1 = r0.f3526a
            if (r1 != r5) goto L_0x001d
            java.lang.String r0 = r7.mo18332a()
            r6.f2745e = r0
            goto L_0x00ca
        L_0x0075:
            byte r1 = r0.f3526a
            if (r1 != r5) goto L_0x001d
            java.lang.String r0 = r7.mo18332a()
            r6.f2744d = r0
            goto L_0x00ca
        L_0x0080:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x001d
            boolean r0 = r7.mo18332a()
            r6.f2740a = r0
            r6.mo17789c((boolean) r4)
            goto L_0x00ca
        L_0x008e:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001d
            long r0 = r7.mo18332a()
            r6.f2741b = r0
            r6.mo17786b((boolean) r4)
            goto L_0x00ca
        L_0x009c:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001d
            long r0 = r7.mo18332a()
            r6.f2736a = r0
            r6.mo17781a((boolean) r4)
            goto L_0x00ca
        L_0x00aa:
            byte r1 = r0.f3526a
            if (r1 != r5) goto L_0x001d
            java.lang.String r0 = r7.mo18332a()
            r6.f2743c = r0
            goto L_0x00ca
        L_0x00b5:
            byte r1 = r0.f3526a
            if (r1 != r5) goto L_0x001d
            java.lang.String r0 = r7.mo18332a()
            r6.f2742b = r0
            goto L_0x00ca
        L_0x00c0:
            byte r1 = r0.f3526a
            if (r1 != r5) goto L_0x001d
            java.lang.String r0 = r7.mo18332a()
            r6.f2737a = r0
        L_0x00ca:
            r7.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1872hs.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo17782a(String str, String str2) {
        if (this.f2739a == null) {
            this.f2739a = new HashMap();
        }
        this.f2739a.put(str, str2);
    }

    /* renamed from: a */
    public void m3919a(boolean z) {
        this.f2738a.set(0, z);
    }

    /* renamed from: a */
    public boolean m3920a() {
        return this.f2737a != null;
    }

    /* renamed from: a */
    public boolean m3921a(C1872hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean a = mo17777a();
        boolean a2 = hsVar.mo17777a();
        if ((a || a2) && (!a || !a2 || !this.f2737a.equals(hsVar.f2737a))) {
            return false;
        }
        boolean b = mo17785b();
        boolean b2 = hsVar.mo17785b();
        if ((b || b2) && (!b || !b2 || !this.f2742b.equals(hsVar.f2742b))) {
            return false;
        }
        boolean c = mo17788c();
        boolean c2 = hsVar.mo17788c();
        if ((c || c2) && (!c || !c2 || !this.f2743c.equals(hsVar.f2743c))) {
            return false;
        }
        boolean d = mo17792d();
        boolean d2 = hsVar.mo17792d();
        if ((d || d2) && (!d || !d2 || this.f2736a != hsVar.f2736a)) {
            return false;
        }
        boolean e = mo17794e();
        boolean e2 = hsVar.mo17794e();
        if ((e || e2) && (!e || !e2 || this.f2741b != hsVar.f2741b)) {
            return false;
        }
        boolean f = mo17797f();
        boolean f2 = hsVar.mo17797f();
        if ((f || f2) && (!f || !f2 || this.f2740a != hsVar.f2740a)) {
            return false;
        }
        boolean g = mo17799g();
        boolean g2 = hsVar.mo17799g();
        if ((g || g2) && (!g || !g2 || !this.f2744d.equals(hsVar.f2744d))) {
            return false;
        }
        boolean h = mo17800h();
        boolean h2 = hsVar.mo17800h();
        if ((h || h2) && (!h || !h2 || !this.f2745e.equals(hsVar.f2745e))) {
            return false;
        }
        boolean i = mo17802i();
        boolean i2 = hsVar.mo17802i();
        if ((i || i2) && (!i || !i2 || !this.f2746f.equals(hsVar.f2746f))) {
            return false;
        }
        boolean j = mo17803j();
        boolean j2 = hsVar.mo17803j();
        if ((j || j2) && (!j || !j2 || !this.f2739a.equals(hsVar.f2739a))) {
            return false;
        }
        boolean k = mo17804k();
        boolean k2 = hsVar.mo17804k();
        if (k || k2) {
            return k && k2 && this.f2747g.equals(hsVar.f2747g);
        }
        return true;
    }

    /* renamed from: b */
    public C1872hs mo17783b(long j) {
        this.f2741b = j;
        mo17786b(true);
        return this;
    }

    /* renamed from: b */
    public C1872hs mo17784b(String str) {
        this.f2742b = str;
        return this;
    }

    /* renamed from: b */
    public String mo17785b() {
        return this.f2743c;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17777a();
        jkVar.mo18339a(f2725a);
        if (this.f2737a != null && mo17777a()) {
            jkVar.mo18336a(f2724a);
            jkVar.mo18340a(this.f2737a);
            jkVar.mo18344b();
        }
        if (this.f2742b != null && mo17785b()) {
            jkVar.mo18336a(f2726b);
            jkVar.mo18340a(this.f2742b);
            jkVar.mo18344b();
        }
        if (this.f2743c != null && mo17788c()) {
            jkVar.mo18336a(f2727c);
            jkVar.mo18340a(this.f2743c);
            jkVar.mo18344b();
        }
        if (mo17792d()) {
            jkVar.mo18336a(f2728d);
            jkVar.mo18335a(this.f2736a);
            jkVar.mo18344b();
        }
        if (mo17794e()) {
            jkVar.mo18336a(f2729e);
            jkVar.mo18335a(this.f2741b);
            jkVar.mo18344b();
        }
        if (mo17797f()) {
            jkVar.mo18336a(f2730f);
            jkVar.mo18343a(this.f2740a);
            jkVar.mo18344b();
        }
        if (this.f2744d != null && mo17799g()) {
            jkVar.mo18336a(f2731g);
            jkVar.mo18340a(this.f2744d);
            jkVar.mo18344b();
        }
        if (this.f2745e != null && mo17800h()) {
            jkVar.mo18336a(f2732h);
            jkVar.mo18340a(this.f2745e);
            jkVar.mo18344b();
        }
        if (this.f2746f != null && mo17802i()) {
            jkVar.mo18336a(f2733i);
            jkVar.mo18340a(this.f2746f);
            jkVar.mo18344b();
        }
        if (this.f2739a != null && mo17803j()) {
            jkVar.mo18336a(f2734j);
            jkVar.mo18338a(new C1919jj((byte) 11, (byte) 11, this.f2739a.size()));
            for (Map.Entry next : this.f2739a.entrySet()) {
                jkVar.mo18340a((String) next.getKey());
                jkVar.mo18340a((String) next.getValue());
            }
            jkVar.mo18348d();
            jkVar.mo18344b();
        }
        if (this.f2747g != null && mo17804k()) {
            jkVar.mo18336a(f2735k);
            jkVar.mo18340a(this.f2747g);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo17786b(boolean z) {
        this.f2738a.set(1, z);
    }

    /* renamed from: b */
    public boolean m3927b() {
        return this.f2742b != null;
    }

    /* renamed from: c */
    public C1872hs mo17787c(String str) {
        this.f2743c = str;
        return this;
    }

    /* renamed from: c */
    public String mo17788c() {
        return this.f2745e;
    }

    /* renamed from: c */
    public void mo17789c(boolean z) {
        this.f2738a.set(2, z);
    }

    /* renamed from: c */
    public boolean m3931c() {
        return this.f2743c != null;
    }

    /* renamed from: d */
    public C1872hs mo17791d(String str) {
        this.f2744d = str;
        return this;
    }

    /* renamed from: d */
    public String mo17792d() {
        return this.f2746f;
    }

    /* renamed from: d */
    public boolean m3934d() {
        return this.f2738a.get(0);
    }

    /* renamed from: e */
    public C1872hs mo17793e(String str) {
        this.f2745e = str;
        return this;
    }

    /* renamed from: e */
    public String mo17794e() {
        return this.f2747g;
    }

    /* renamed from: e */
    public boolean m3937e() {
        return this.f2738a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1872hs)) {
            return compareTo((C1872hs) obj);
        }
        return false;
    }

    /* renamed from: f */
    public C1872hs mo17796f(String str) {
        this.f2746f = str;
        return this;
    }

    /* renamed from: f */
    public boolean mo17797f() {
        return this.f2738a.get(2);
    }

    /* renamed from: g */
    public C1872hs mo17798g(String str) {
        this.f2747g = str;
        return this;
    }

    /* renamed from: g */
    public boolean mo17799g() {
        return this.f2744d != null;
    }

    /* renamed from: h */
    public boolean mo17800h() {
        return this.f2745e != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo17802i() {
        return this.f2746f != null;
    }

    /* renamed from: j */
    public boolean mo17803j() {
        return this.f2739a != null;
    }

    /* renamed from: k */
    public boolean mo17804k() {
        return this.f2747g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        if (mo17777a()) {
            sb.append("channel:");
            String str = this.f2737a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (mo17785b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f2742b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (mo17788c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f2743c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (mo17792d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f2736a);
            z = false;
        }
        if (mo17794e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f2741b);
            z = false;
        }
        if (mo17797f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f2740a);
            z = false;
        }
        if (mo17799g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f2744d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (mo17800h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f2745e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (mo17802i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f2746f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (mo17803j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f2739a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
            z = false;
        }
        if (mo17804k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f2747g;
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
