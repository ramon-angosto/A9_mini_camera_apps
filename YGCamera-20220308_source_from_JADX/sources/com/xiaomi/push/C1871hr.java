package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.hr */
public class C1871hr implements C1906iz<C1871hr, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f2721a = new C1917jh("", (byte) 15, 1);

    /* renamed from: a */
    private static final C1925jp f2722a = new C1925jp("ClientUploadData");

    /* renamed from: a */
    public List<C1872hs> f2723a;

    /* renamed from: a */
    public int mo17769a() {
        List<C1872hs> list = this.f2723a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: a */
    public int compareTo(C1871hr hrVar) {
        int a;
        if (!getClass().equals(hrVar.getClass())) {
            return getClass().getName().compareTo(hrVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17769a()).compareTo(Boolean.valueOf(hrVar.mo17769a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!mo17769a() || (a = C1908ja.m4591a((List) this.f2723a, (List) hrVar.f2723a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public void m3902a() {
        if (this.f2723a == null) {
            throw new C1921jl("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    public void mo17771a(C1872hs hsVar) {
        if (this.f2723a == null) {
            this.f2723a = new ArrayList();
        }
        this.f2723a.add(hsVar);
    }

    /* renamed from: a */
    public void mo17579a(C1920jk jkVar) {
        jkVar.mo18332a();
        while (true) {
            C1917jh a = jkVar.mo18332a();
            if (a.f3526a == 0) {
                jkVar.mo18350f();
                mo17769a();
                return;
            }
            if (a.f3528a == 1 && a.f3526a == 15) {
                C1918ji a2 = jkVar.mo18332a();
                this.f2723a = new ArrayList(a2.f3530a);
                for (int i = 0; i < a2.f3530a; i++) {
                    C1872hs hsVar = new C1872hs();
                    hsVar.mo17579a(jkVar);
                    this.f2723a.add(hsVar);
                }
                jkVar.mo18353i();
            } else {
                C1923jn.m4681a(jkVar, a.f3526a);
            }
            jkVar.mo18351g();
        }
    }

    /* renamed from: a */
    public boolean m3905a() {
        return this.f2723a != null;
    }

    /* renamed from: a */
    public boolean m3906a(C1871hr hrVar) {
        if (hrVar == null) {
            return false;
        }
        boolean a = mo17769a();
        boolean a2 = hrVar.mo17769a();
        if (a || a2) {
            return a && a2 && this.f2723a.equals(hrVar.f2723a);
        }
        return true;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17769a();
        jkVar.mo18339a(f2722a);
        if (this.f2723a != null) {
            jkVar.mo18336a(f2721a);
            jkVar.mo18337a(new C1918ji((byte) 12, this.f2723a.size()));
            for (C1872hs b : this.f2723a) {
                b.mo17583b(jkVar);
            }
            jkVar.mo18349e();
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1871hr)) {
            return compareTo((C1871hr) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<C1872hs> list = this.f2723a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
