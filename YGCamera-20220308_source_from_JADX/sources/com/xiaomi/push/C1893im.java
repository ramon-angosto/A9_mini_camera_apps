package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.im */
public class C1893im implements C1906iz<C1893im, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3200a = new C1917jh("", (byte) 15, 1);

    /* renamed from: a */
    private static final C1925jp f3201a = new C1925jp("XmPushActionNormalConfig");

    /* renamed from: a */
    public List<C1877hx> f3202a;

    /* JADX WARNING: type inference failed for: r0v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v1, types: [boolean] */
    /* renamed from: a */
    public int compareTo(C1893im imVar) {
        int a;
        if (!getClass().equals(imVar.getClass())) {
            return getClass().getName().compareTo(imVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo18071a()).compareTo(Boolean.valueOf(imVar.mo18071a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo18071a() == null || (a = C1908ja.m4591a((List) this.f3202a, (List) imVar.f3202a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public List<C1877hx> mo18071a() {
        return this.f3202a;
    }

    /* renamed from: a */
    public void m4257a() {
        if (this.f3202a == null) {
            throw new C1921jl("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    public void mo17579a(C1920jk jkVar) {
        jkVar.mo18332a();
        while (true) {
            C1917jh a = jkVar.mo18332a();
            if (a.f3526a == 0) {
                jkVar.mo18350f();
                mo18071a();
                return;
            }
            if (a.f3528a == 1 && a.f3526a == 15) {
                C1918ji a2 = jkVar.mo18332a();
                this.f3202a = new ArrayList(a2.f3530a);
                for (int i = 0; i < a2.f3530a; i++) {
                    C1877hx hxVar = new C1877hx();
                    hxVar.mo17579a(jkVar);
                    this.f3202a.add(hxVar);
                }
                jkVar.mo18353i();
            } else {
                C1923jn.m4681a(jkVar, a.f3526a);
            }
            jkVar.mo18351g();
        }
    }

    /* renamed from: a */
    public boolean m4259a() {
        return this.f3202a != null;
    }

    /* renamed from: a */
    public boolean m4260a(C1893im imVar) {
        if (imVar == null) {
            return false;
        }
        List<C1877hx> a = mo18071a();
        List<C1877hx> a2 = imVar.mo18071a();
        if (a == null && a2 == null) {
            return true;
        }
        return (a == null || a2 == null || !this.f3202a.equals(imVar.f3202a)) ? false : true;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo18071a();
        jkVar.mo18339a(f3201a);
        if (this.f3202a != null) {
            jkVar.mo18336a(f3200a);
            jkVar.mo18337a(new C1918ji((byte) 12, this.f3202a.size()));
            for (C1877hx b : this.f3202a) {
                b.mo17583b(jkVar);
            }
            jkVar.mo18349e();
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1893im)) {
            return compareTo((C1893im) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<C1877hx> list = this.f3202a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
