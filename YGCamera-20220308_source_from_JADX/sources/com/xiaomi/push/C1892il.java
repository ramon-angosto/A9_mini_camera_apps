package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.il */
public class C1892il implements C1906iz<C1892il, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3197a = new C1917jh("", (byte) 15, 1);

    /* renamed from: a */
    private static final C1925jp f3198a = new C1925jp("XmPushActionCustomConfig");

    /* renamed from: a */
    public List<C1879hz> f3199a;

    /* JADX WARNING: type inference failed for: r0v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v1, types: [boolean] */
    /* renamed from: a */
    public int compareTo(C1892il ilVar) {
        int a;
        if (!getClass().equals(ilVar.getClass())) {
            return getClass().getName().compareTo(ilVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18065a()).compareTo(Boolean.valueOf(ilVar.mo18065a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18065a() == null || (a = C1908ja.m4591a((List) this.f3199a, (List) ilVar.f3199a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public List<C1879hz> mo18065a() {
        return this.f3199a;
    }

    /* renamed from: a */
    public void m4250a() {
        if (this.f3199a == null) {
            throw new C1921jl("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    public void mo17579a(C1920jk jkVar) {
        jkVar.mo18332a();
        while (true) {
            C1917jh a = jkVar.mo18332a();
            if (a.f3526a == 0) {
                jkVar.mo18350f();
                mo18065a();
                return;
            }
            if (a.f3528a == 1 && a.f3526a == 15) {
                C1918ji a2 = jkVar.mo18332a();
                this.f3199a = new ArrayList(a2.f3530a);
                for (int i = 0; i < a2.f3530a; i++) {
                    C1879hz hzVar = new C1879hz();
                    hzVar.mo17579a(jkVar);
                    this.f3199a.add(hzVar);
                }
                jkVar.mo18353i();
            } else {
                C1923jn.m4681a(jkVar, a.f3526a);
            }
            jkVar.mo18351g();
        }
    }

    /* renamed from: a */
    public boolean m4252a() {
        return this.f3199a != null;
    }

    /* renamed from: a */
    public boolean m4253a(C1892il ilVar) {
        if (ilVar == null) {
            return false;
        }
        List<C1879hz> a = mo18065a();
        List<C1879hz> a2 = ilVar.mo18065a();
        if (a == null && a2 == null) {
            return true;
        }
        return (a == null || a2 == null || !this.f3199a.equals(ilVar.f3199a)) ? false : true;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18065a();
        jkVar.mo18339a(f3198a);
        if (this.f3199a != null) {
            jkVar.mo18336a(f3197a);
            jkVar.mo18337a(new C1918ji((byte) 12, this.f3199a.size()));
            for (C1879hz b : this.f3199a) {
                b.mo17583b(jkVar);
            }
            jkVar.mo18349e();
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1892il)) {
            return compareTo((C1892il) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<C1879hz> list = this.f3199a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
