package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.ig */
public class C1887ig implements C1906iz<C1887ig, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f3126a = new C1917jh("", (byte) 8, 1);

    /* renamed from: a */
    private static final C1925jp f3127a = new C1925jp("XmPushActionCheckClientInfo");

    /* renamed from: b */
    private static final C1917jh f3128b = new C1917jh("", (byte) 8, 2);

    /* renamed from: a */
    public int f3129a;

    /* renamed from: a */
    private BitSet f3130a = new BitSet(2);

    /* renamed from: b */
    public int f3131b;

    /* renamed from: a */
    public int compareTo(C1887ig igVar) {
        int a;
        int a2;
        if (!getClass().equals(igVar.getClass())) {
            return getClass().getName().compareTo(igVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17985a()).compareTo(Boolean.valueOf(igVar.mo17985a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17985a() && (a2 = C1908ja.m4586a(this.f3129a, igVar.f3129a)) != 0) {
            return a2;
        }
        int compareTo2 = Boolean.valueOf(mo17989b()).compareTo(Boolean.valueOf(igVar.mo17989b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!mo17989b() || (a = C1908ja.m4586a(this.f3131b, igVar.f3131b)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1887ig mo17984a(int i) {
        this.f3129a = i;
        mo17986a(true);
        return this;
    }

    /* renamed from: a */
    public void mo17985a() {
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
                if (s == 2 && a.f3526a == 8) {
                    this.f3131b = jkVar.mo18332a();
                    mo17988b(true);
                    jkVar.mo18351g();
                }
            } else if (a.f3526a == 8) {
                this.f3129a = jkVar.mo18332a();
                mo17986a(true);
                jkVar.mo18351g();
            }
            C1923jn.m4681a(jkVar, a.f3526a);
            jkVar.mo18351g();
        }
        jkVar.mo18350f();
        if (!mo17985a()) {
            throw new C1921jl("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (mo17989b()) {
            mo17985a();
        } else {
            throw new C1921jl("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    /* renamed from: a */
    public void mo17986a(boolean z) {
        this.f3130a.set(0, z);
    }

    /* renamed from: a */
    public boolean m4159a() {
        return this.f3130a.get(0);
    }

    /* renamed from: a */
    public boolean m4160a(C1887ig igVar) {
        return igVar != null && this.f3129a == igVar.f3129a && this.f3131b == igVar.f3131b;
    }

    /* renamed from: b */
    public C1887ig mo17987b(int i) {
        this.f3131b = i;
        mo17988b(true);
        return this;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17985a();
        jkVar.mo18339a(f3127a);
        jkVar.mo18336a(f3126a);
        jkVar.mo18333a(this.f3129a);
        jkVar.mo18344b();
        jkVar.mo18336a(f3128b);
        jkVar.mo18333a(this.f3131b);
        jkVar.mo18344b();
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public void mo17988b(boolean z) {
        this.f3130a.set(1, z);
    }

    /* renamed from: b */
    public boolean mo17989b() {
        return this.f3130a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1887ig)) {
            return compareTo((C1887ig) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(" + "miscConfigVersion:" + this.f3129a + ", " + "pluginConfigVersion:" + this.f3131b + ")";
    }
}
