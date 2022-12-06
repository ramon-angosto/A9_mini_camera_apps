package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* renamed from: com.xiaomi.push.hx */
public class C1877hx implements C1906iz<C1877hx, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f2893a = new C1917jh("", (byte) 8, 1);

    /* renamed from: a */
    private static final C1925jp f2894a = new C1925jp("NormalConfig");

    /* renamed from: b */
    private static final C1917jh f2895b = new C1917jh("", (byte) 15, 2);

    /* renamed from: c */
    private static final C1917jh f2896c = new C1917jh("", (byte) 8, 3);

    /* renamed from: a */
    public int f2897a;

    /* renamed from: a */
    public C1874hu f2898a;

    /* renamed from: a */
    private BitSet f2899a = new BitSet(1);

    /* renamed from: a */
    public List<C1879hz> f2900a;

    /* renamed from: a */
    public int mo17820a() {
        return this.f2897a;
    }

    /* renamed from: a */
    public int compareTo(C1877hx hxVar) {
        int a;
        int a2;
        int a3;
        if (!getClass().equals(hxVar.getClass())) {
            return getClass().getName().compareTo(hxVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17820a()).compareTo(Boolean.valueOf(hxVar.mo17820a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17820a() && (a3 = C1908ja.m4586a(this.f2897a, hxVar.f2897a)) != 0) {
            return a3;
        }
        int compareTo2 = Boolean.valueOf(mo17823b()).compareTo(Boolean.valueOf(hxVar.mo17823b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo17823b() && (a2 = C1908ja.m4591a((List) this.f2900a, (List) hxVar.f2900a)) != 0) {
            return a2;
        }
        int compareTo3 = Boolean.valueOf(mo17824c()).compareTo(Boolean.valueOf(hxVar.mo17824c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!mo17824c() || (a = C1908ja.m4588a((Comparable) this.f2898a, (Comparable) hxVar.f2898a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1874hu m3965a() {
        return this.f2898a;
    }

    /* renamed from: a */
    public void m3966a() {
        if (this.f2900a == null) {
            throw new C1921jl("Required field 'configItems' was not present! Struct: " + toString());
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
                    if (s == 3 && a.f3526a == 8) {
                        this.f2898a = C1874hu.m3947a(jkVar.mo18332a());
                        jkVar.mo18351g();
                    }
                } else if (a.f3526a == 15) {
                    C1918ji a2 = jkVar.mo18332a();
                    this.f2900a = new ArrayList(a2.f3530a);
                    for (int i = 0; i < a2.f3530a; i++) {
                        C1879hz hzVar = new C1879hz();
                        hzVar.mo17579a(jkVar);
                        this.f2900a.add(hzVar);
                    }
                    jkVar.mo18353i();
                    jkVar.mo18351g();
                }
            } else if (a.f3526a == 8) {
                this.f2897a = jkVar.mo18332a();
                mo17822a(true);
                jkVar.mo18351g();
            }
            C1923jn.m4681a(jkVar, a.f3526a);
            jkVar.mo18351g();
        }
        jkVar.mo18350f();
        if (mo17820a()) {
            mo17820a();
            return;
        }
        throw new C1921jl("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a */
    public void mo17822a(boolean z) {
        this.f2899a.set(0, z);
    }

    /* renamed from: a */
    public boolean m3969a() {
        return this.f2899a.get(0);
    }

    /* renamed from: a */
    public boolean m3970a(C1877hx hxVar) {
        if (hxVar == null || this.f2897a != hxVar.f2897a) {
            return false;
        }
        boolean b = mo17823b();
        boolean b2 = hxVar.mo17823b();
        if ((b || b2) && (!b || !b2 || !this.f2900a.equals(hxVar.f2900a))) {
            return false;
        }
        boolean c = mo17824c();
        boolean c2 = hxVar.mo17824c();
        if (c || c2) {
            return c && c2 && this.f2898a.equals(hxVar.f2898a);
        }
        return true;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17820a();
        jkVar.mo18339a(f2894a);
        jkVar.mo18336a(f2893a);
        jkVar.mo18333a(this.f2897a);
        jkVar.mo18344b();
        if (this.f2900a != null) {
            jkVar.mo18336a(f2895b);
            jkVar.mo18337a(new C1918ji((byte) 12, this.f2900a.size()));
            for (C1879hz b : this.f2900a) {
                b.mo17583b(jkVar);
            }
            jkVar.mo18349e();
            jkVar.mo18344b();
        }
        if (this.f2898a != null && mo17824c()) {
            jkVar.mo18336a(f2896c);
            jkVar.mo18333a(this.f2898a.mo17807a());
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public boolean mo17823b() {
        return this.f2900a != null;
    }

    /* renamed from: c */
    public boolean mo17824c() {
        return this.f2898a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1877hx)) {
            return compareTo((C1877hx) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f2897a);
        sb.append(", ");
        sb.append("configItems:");
        List<C1879hz> list = this.f2900a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (mo17824c()) {
            sb.append(", ");
            sb.append("type:");
            C1874hu huVar = this.f2898a;
            if (huVar == null) {
                sb.append("null");
            } else {
                sb.append(huVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
