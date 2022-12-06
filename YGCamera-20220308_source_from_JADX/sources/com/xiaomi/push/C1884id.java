package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.id */
public class C1884id implements C1906iz<C1884id, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3048a = new C1917jh("", (byte) 10, 1);

    /* renamed from: a */
    private static final C1925jp f3049a = new C1925jp("Target");

    /* renamed from: b */
    private static final C1917jh f3050b = new C1917jh("", (byte) 11, 2);

    /* renamed from: c */
    private static final C1917jh f3051c = new C1917jh("", (byte) 11, 3);

    /* renamed from: d */
    private static final C1917jh f3052d = new C1917jh("", (byte) 11, 4);

    /* renamed from: e */
    private static final C1917jh f3053e = new C1917jh("", (byte) 2, 5);

    /* renamed from: f */
    private static final C1917jh f3054f = new C1917jh("", (byte) 11, 7);

    /* renamed from: a */
    public long f3055a = 5;

    /* renamed from: a */
    public String f3056a;

    /* renamed from: a */
    private BitSet f3057a = new BitSet(2);

    /* renamed from: a */
    public boolean f3058a = false;

    /* renamed from: b */
    public String f3059b = "xiaomi.com";

    /* renamed from: c */
    public String f3060c = "";

    /* renamed from: d */
    public String f3061d;

    /* renamed from: a */
    public int compareTo(C1884id idVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        if (!getClass().equals(idVar.getClass())) {
            return getClass().getName().compareTo(idVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17912a()).compareTo(Boolean.valueOf(idVar.mo17912a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17912a() && (a6 = C1908ja.m4587a(this.f3055a, idVar.f3055a)) != 0) {
            return a6;
        }
        int compareTo2 = Boolean.valueOf(mo17915b()).compareTo(Boolean.valueOf(idVar.mo17915b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo17915b() && (a5 = C1908ja.m4589a(this.f3056a, idVar.f3056a)) != 0) {
            return a5;
        }
        int compareTo3 = Boolean.valueOf(mo17916c()).compareTo(Boolean.valueOf(idVar.mo17916c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo17916c() && (a4 = C1908ja.m4589a(this.f3059b, idVar.f3059b)) != 0) {
            return a4;
        }
        int compareTo4 = Boolean.valueOf(mo17918d()).compareTo(Boolean.valueOf(idVar.mo17918d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo17918d() && (a3 = C1908ja.m4589a(this.f3060c, idVar.f3060c)) != 0) {
            return a3;
        }
        int compareTo5 = Boolean.valueOf(mo17919e()).compareTo(Boolean.valueOf(idVar.mo17919e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo17919e() && (a2 = C1908ja.m4595a(this.f3058a, idVar.f3058a)) != 0) {
            return a2;
        }
        int compareTo6 = Boolean.valueOf(mo17921f()).compareTo(Boolean.valueOf(idVar.mo17921f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!mo17921f() || (a = C1908ja.m4589a(this.f3061d, idVar.f3061d)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public void mo17912a() {
        if (this.f3056a == null) {
            throw new C1921jl("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    public void mo17579a(C1920jk jkVar) {
        jkVar.mo18332a();
        while (true) {
            C1917jh a = jkVar.mo18332a();
            if (a.f3526a == 0) {
                break;
            }
            short s = a.f3528a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s == 7 && a.f3526a == 11) {
                                    this.f3061d = jkVar.mo18332a();
                                    jkVar.mo18351g();
                                }
                            } else if (a.f3526a == 2) {
                                this.f3058a = jkVar.mo18332a();
                                mo17914b(true);
                                jkVar.mo18351g();
                            }
                        } else if (a.f3526a == 11) {
                            this.f3060c = jkVar.mo18332a();
                            jkVar.mo18351g();
                        }
                    } else if (a.f3526a == 11) {
                        this.f3059b = jkVar.mo18332a();
                        jkVar.mo18351g();
                    }
                } else if (a.f3526a == 11) {
                    this.f3056a = jkVar.mo18332a();
                    jkVar.mo18351g();
                }
            } else if (a.f3526a == 10) {
                this.f3055a = jkVar.mo18332a();
                mo17913a(true);
                jkVar.mo18351g();
            }
            C1923jn.m4681a(jkVar, a.f3526a);
            jkVar.mo18351g();
        }
        jkVar.mo18350f();
        if (mo17912a()) {
            mo17912a();
            return;
        }
        throw new C1921jl("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a */
    public void mo17913a(boolean z) {
        this.f3057a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4083a() {
        return this.f3057a.get(0);
    }

    /* renamed from: a */
    public boolean m4084a(C1884id idVar) {
        if (idVar == null || this.f3055a != idVar.f3055a) {
            return false;
        }
        boolean b = mo17915b();
        boolean b2 = idVar.mo17915b();
        if ((b || b2) && (!b || !b2 || !this.f3056a.equals(idVar.f3056a))) {
            return false;
        }
        boolean c = mo17916c();
        boolean c2 = idVar.mo17916c();
        if ((c || c2) && (!c || !c2 || !this.f3059b.equals(idVar.f3059b))) {
            return false;
        }
        boolean d = mo17918d();
        boolean d2 = idVar.mo17918d();
        if ((d || d2) && (!d || !d2 || !this.f3060c.equals(idVar.f3060c))) {
            return false;
        }
        boolean e = mo17919e();
        boolean e2 = idVar.mo17919e();
        if ((e || e2) && (!e || !e2 || this.f3058a != idVar.f3058a)) {
            return false;
        }
        boolean f = mo17921f();
        boolean f2 = idVar.mo17921f();
        if (f || f2) {
            return f && f2 && this.f3061d.equals(idVar.f3061d);
        }
        return true;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17912a();
        jkVar.mo18339a(f3049a);
        jkVar.mo18336a(f3048a);
        jkVar.mo18335a(this.f3055a);
        jkVar.mo18344b();
        if (this.f3056a != null) {
            jkVar.mo18336a(f3050b);
            jkVar.mo18340a(this.f3056a);
            jkVar.mo18344b();
        }
        if (this.f3059b != null && mo17916c()) {
            jkVar.mo18336a(f3051c);
            jkVar.mo18340a(this.f3059b);
            jkVar.mo18344b();
        }
        if (this.f3060c != null && mo17918d()) {
            jkVar.mo18336a(f3052d);
            jkVar.mo18340a(this.f3060c);
            jkVar.mo18344b();
        }
        if (mo17919e()) {
            jkVar.mo18336a(f3053e);
            jkVar.mo18343a(this.f3058a);
            jkVar.mo18344b();
        }
        if (this.f3061d != null && mo17921f()) {
            jkVar.mo18336a(f3054f);
            jkVar.mo18340a(this.f3061d);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo17914b(boolean z) {
        this.f3057a.set(1, z);
    }

    /* renamed from: b */
    public boolean mo17915b() {
        return this.f3056a != null;
    }

    /* renamed from: c */
    public boolean mo17916c() {
        return this.f3059b != null;
    }

    /* renamed from: d */
    public boolean mo17918d() {
        return this.f3060c != null;
    }

    /* renamed from: e */
    public boolean mo17919e() {
        return this.f3057a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1884id)) {
            return compareTo((C1884id) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo17921f() {
        return this.f3061d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f3055a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f3056a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (mo17916c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f3059b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (mo17918d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f3060c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (mo17919e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f3058a);
        }
        if (mo17921f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f3061d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
