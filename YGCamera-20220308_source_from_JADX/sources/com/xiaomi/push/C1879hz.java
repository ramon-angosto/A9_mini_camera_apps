package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.hz */
public class C1879hz implements C1906iz<C1879hz, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f2960a = new C1917jh("", (byte) 8, 1);

    /* renamed from: a */
    private static final C1925jp f2961a = new C1925jp("OnlineConfigItem");

    /* renamed from: b */
    private static final C1917jh f2962b = new C1917jh("", (byte) 8, 2);

    /* renamed from: c */
    private static final C1917jh f2963c = new C1917jh("", (byte) 2, 3);

    /* renamed from: d */
    private static final C1917jh f2964d = new C1917jh("", (byte) 8, 4);

    /* renamed from: e */
    private static final C1917jh f2965e = new C1917jh("", (byte) 10, 5);

    /* renamed from: f */
    private static final C1917jh f2966f = new C1917jh("", (byte) 11, 6);

    /* renamed from: g */
    private static final C1917jh f2967g = new C1917jh("", (byte) 2, 7);

    /* renamed from: a */
    public int f2968a;

    /* renamed from: a */
    public long f2969a;

    /* renamed from: a */
    public String f2970a;

    /* renamed from: a */
    private BitSet f2971a = new BitSet(6);

    /* renamed from: a */
    public boolean f2972a;

    /* renamed from: b */
    public int f2973b;

    /* renamed from: b */
    public boolean f2974b;

    /* renamed from: c */
    public int f2975c;

    /* renamed from: a */
    public int mo17830a() {
        return this.f2968a;
    }

    /* renamed from: a */
    public int compareTo(C1879hz hzVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!getClass().equals(hzVar.getClass())) {
            return getClass().getName().compareTo(hzVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17830a()).compareTo(Boolean.valueOf(hzVar.mo17830a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17830a() && (a7 = C1908ja.m4586a(this.f2968a, hzVar.f2968a)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(mo17833b()).compareTo(Boolean.valueOf(hzVar.mo17833b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo17833b() && (a6 = C1908ja.m4586a(this.f2973b, hzVar.f2973b)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(mo17835c()).compareTo(Boolean.valueOf(hzVar.mo17835c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo17835c() && (a5 = C1908ja.m4595a(this.f2972a, hzVar.f2972a)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(mo17839d()).compareTo(Boolean.valueOf(hzVar.mo17839d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo17839d() && (a4 = C1908ja.m4586a(this.f2975c, hzVar.f2975c)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(mo17841e()).compareTo(Boolean.valueOf(hzVar.mo17841e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo17841e() && (a3 = C1908ja.m4587a(this.f2969a, hzVar.f2969a)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(mo17844f()).compareTo(Boolean.valueOf(hzVar.mo17844f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo17844f() && (a2 = C1908ja.m4589a(this.f2970a, hzVar.f2970a)) != 0) {
            return a2;
        }
        int compareTo7 = Boolean.valueOf(mo17846h()).compareTo(Boolean.valueOf(hzVar.mo17846h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!mo17846h() || (a = C1908ja.m4595a(this.f2974b, hzVar.f2974b)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public long m3976a() {
        return this.f2969a;
    }

    /* renamed from: a */
    public String m3977a() {
        return this.f2970a;
    }

    /* renamed from: a */
    public void m3978a() {
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
            r5.mo17830a()
            return
        L_0x0012:
            short r1 = r0.f3528a
            r2 = 2
            r3 = 8
            r4 = 1
            switch(r1) {
                case 1: goto L_0x0076;
                case 2: goto L_0x0068;
                case 3: goto L_0x005a;
                case 4: goto L_0x004c;
                case 5: goto L_0x003c;
                case 6: goto L_0x002f;
                case 7: goto L_0x0021;
                default: goto L_0x001b;
            }
        L_0x001b:
            byte r0 = r0.f3526a
            com.xiaomi.push.C1923jn.m4681a(r6, r0)
            goto L_0x0083
        L_0x0021:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x001b
            boolean r0 = r6.mo18332a()
            r5.f2974b = r0
            r5.mo17843f(r4)
            goto L_0x0083
        L_0x002f:
            byte r1 = r0.f3526a
            r2 = 11
            if (r1 != r2) goto L_0x001b
            java.lang.String r0 = r6.mo18332a()
            r5.f2970a = r0
            goto L_0x0083
        L_0x003c:
            byte r1 = r0.f3526a
            r2 = 10
            if (r1 != r2) goto L_0x001b
            long r0 = r6.mo18332a()
            r5.f2969a = r0
            r5.mo17840e(r4)
            goto L_0x0083
        L_0x004c:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001b
            int r0 = r6.mo18332a()
            r5.f2975c = r0
            r5.mo17838d(r4)
            goto L_0x0083
        L_0x005a:
            byte r1 = r0.f3526a
            if (r1 != r2) goto L_0x001b
            boolean r0 = r6.mo18332a()
            r5.f2972a = r0
            r5.mo17836c(r4)
            goto L_0x0083
        L_0x0068:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001b
            int r0 = r6.mo18332a()
            r5.f2973b = r0
            r5.mo17834b((boolean) r4)
            goto L_0x0083
        L_0x0076:
            byte r1 = r0.f3526a
            if (r1 != r3) goto L_0x001b
            int r0 = r6.mo18332a()
            r5.f2968a = r0
            r5.mo17832a((boolean) r4)
        L_0x0083:
            r6.mo18351g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1879hz.mo17579a(com.xiaomi.push.jk):void");
    }

    /* renamed from: a */
    public void mo17832a(boolean z) {
        this.f2971a.set(0, z);
    }

    /* renamed from: a */
    public boolean m3981a() {
        return this.f2971a.get(0);
    }

    /* renamed from: a */
    public boolean m3982a(C1879hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean a = mo17830a();
        boolean a2 = hzVar.mo17830a();
        if ((a || a2) && (!a || !a2 || this.f2968a != hzVar.f2968a)) {
            return false;
        }
        boolean b = mo17833b();
        boolean b2 = hzVar.mo17833b();
        if ((b || b2) && (!b || !b2 || this.f2973b != hzVar.f2973b)) {
            return false;
        }
        boolean c = mo17835c();
        boolean c2 = hzVar.mo17835c();
        if ((c || c2) && (!c || !c2 || this.f2972a != hzVar.f2972a)) {
            return false;
        }
        boolean d = mo17839d();
        boolean d2 = hzVar.mo17839d();
        if ((d || d2) && (!d || !d2 || this.f2975c != hzVar.f2975c)) {
            return false;
        }
        boolean e = mo17841e();
        boolean e2 = hzVar.mo17841e();
        if ((e || e2) && (!e || !e2 || this.f2969a != hzVar.f2969a)) {
            return false;
        }
        boolean f = mo17844f();
        boolean f2 = hzVar.mo17844f();
        if ((f || f2) && (!f || !f2 || !this.f2970a.equals(hzVar.f2970a))) {
            return false;
        }
        boolean h = mo17846h();
        boolean h2 = hzVar.mo17846h();
        if (h || h2) {
            return h && h2 && this.f2974b == hzVar.f2974b;
        }
        return true;
    }

    /* renamed from: b */
    public int mo17833b() {
        return this.f2973b;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17830a();
        jkVar.mo18339a(f2961a);
        if (mo17830a()) {
            jkVar.mo18336a(f2960a);
            jkVar.mo18333a(this.f2968a);
            jkVar.mo18344b();
        }
        if (mo17833b()) {
            jkVar.mo18336a(f2962b);
            jkVar.mo18333a(this.f2973b);
            jkVar.mo18344b();
        }
        if (mo17835c()) {
            jkVar.mo18336a(f2963c);
            jkVar.mo18343a(this.f2972a);
            jkVar.mo18344b();
        }
        if (mo17839d()) {
            jkVar.mo18336a(f2964d);
            jkVar.mo18333a(this.f2975c);
            jkVar.mo18344b();
        }
        if (mo17841e()) {
            jkVar.mo18336a(f2965e);
            jkVar.mo18335a(this.f2969a);
            jkVar.mo18344b();
        }
        if (this.f2970a != null && mo17844f()) {
            jkVar.mo18336a(f2966f);
            jkVar.mo18340a(this.f2970a);
            jkVar.mo18344b();
        }
        if (mo17846h()) {
            jkVar.mo18336a(f2967g);
            jkVar.mo18343a(this.f2974b);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo17834b(boolean z) {
        this.f2971a.set(1, z);
    }

    /* renamed from: b */
    public boolean m3986b() {
        return this.f2971a.get(1);
    }

    /* renamed from: c */
    public int mo17835c() {
        return this.f2975c;
    }

    /* renamed from: c */
    public void mo17836c(boolean z) {
        this.f2971a.set(2, z);
    }

    /* renamed from: c */
    public boolean m3989c() {
        return this.f2971a.get(2);
    }

    /* renamed from: d */
    public void mo17838d(boolean z) {
        this.f2971a.set(3, z);
    }

    /* renamed from: d */
    public boolean mo17839d() {
        return this.f2971a.get(3);
    }

    /* renamed from: e */
    public void mo17840e(boolean z) {
        this.f2971a.set(4, z);
    }

    /* renamed from: e */
    public boolean mo17841e() {
        return this.f2971a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1879hz)) {
            return compareTo((C1879hz) obj);
        }
        return false;
    }

    /* renamed from: f */
    public void mo17843f(boolean z) {
        this.f2971a.set(5, z);
    }

    /* renamed from: f */
    public boolean mo17844f() {
        return this.f2970a != null;
    }

    /* renamed from: g */
    public boolean mo17845g() {
        return this.f2974b;
    }

    /* renamed from: h */
    public boolean mo17846h() {
        return this.f2971a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        if (mo17830a()) {
            sb.append("key:");
            sb.append(this.f2968a);
            z = false;
        } else {
            z = true;
        }
        if (mo17833b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f2973b);
            z = false;
        }
        if (mo17835c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f2972a);
            z = false;
        }
        if (mo17839d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f2975c);
            z = false;
        }
        if (mo17841e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f2969a);
            z = false;
        }
        if (mo17844f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f2970a;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            z = false;
        }
        if (mo17846h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f2974b);
        }
        sb.append(")");
        return sb.toString();
    }
}
