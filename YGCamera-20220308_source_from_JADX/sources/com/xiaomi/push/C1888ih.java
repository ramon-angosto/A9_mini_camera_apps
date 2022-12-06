package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.ih */
public class C1888ih implements C1906iz<C1888ih, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3132a = new C1917jh("", (byte) 15, 1);

    /* renamed from: a */
    private static final C1925jp f3133a = new C1925jp("XmPushActionCollectData");

    /* renamed from: a */
    public List<C1876hw> f3134a;

    /* renamed from: a */
    public int compareTo(C1888ih ihVar) {
        int a;
        if (!getClass().equals(ihVar.getClass())) {
            return getClass().getName().compareTo(ihVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17996a()).compareTo(Boolean.valueOf(ihVar.mo17996a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!mo17996a() || (a = C1908ja.m4591a((List) this.f3134a, (List) ihVar.f3134a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1888ih mo17995a(List<C1876hw> list) {
        this.f3134a = list;
        return this;
    }

    /* renamed from: a */
    public void mo17996a() {
        if (this.f3134a == null) {
            throw new C1921jl("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    public void mo17579a(C1920jk jkVar) {
        jkVar.mo18332a();
        while (true) {
            C1917jh a = jkVar.mo18332a();
            if (a.f3526a == 0) {
                jkVar.mo18350f();
                mo17996a();
                return;
            }
            if (a.f3528a == 1 && a.f3526a == 15) {
                C1918ji a2 = jkVar.mo18332a();
                this.f3134a = new ArrayList(a2.f3530a);
                for (int i = 0; i < a2.f3530a; i++) {
                    C1876hw hwVar = new C1876hw();
                    hwVar.mo17579a(jkVar);
                    this.f3134a.add(hwVar);
                }
                jkVar.mo18353i();
            } else {
                C1923jn.m4681a(jkVar, a.f3526a);
            }
            jkVar.mo18351g();
        }
    }

    /* renamed from: a */
    public boolean m4169a() {
        return this.f3134a != null;
    }

    /* renamed from: a */
    public boolean m4170a(C1888ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean a = mo17996a();
        boolean a2 = ihVar.mo17996a();
        if (a || a2) {
            return a && a2 && this.f3134a.equals(ihVar.f3134a);
        }
        return true;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17996a();
        jkVar.mo18339a(f3133a);
        if (this.f3134a != null) {
            jkVar.mo18336a(f3132a);
            jkVar.mo18337a(new C1918ji((byte) 12, this.f3134a.size()));
            for (C1876hw b : this.f3134a) {
                b.mo17583b(jkVar);
            }
            jkVar.mo18349e();
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1888ih)) {
            return compareTo((C1888ih) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<C1876hw> list = this.f3134a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
