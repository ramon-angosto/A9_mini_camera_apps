package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.hw */
public class C1876hw implements C1906iz<C1876hw, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f2885a = new C1917jh("", (byte) 10, 1);

    /* renamed from: a */
    private static final C1925jp f2886a = new C1925jp("DataCollectionItem");

    /* renamed from: b */
    private static final C1917jh f2887b = new C1917jh("", (byte) 8, 2);

    /* renamed from: c */
    private static final C1917jh f2888c = new C1917jh("", (byte) 11, 3);

    /* renamed from: a */
    public long f2889a;

    /* renamed from: a */
    public C1870hq f2890a;

    /* renamed from: a */
    public String f2891a;

    /* renamed from: a */
    private BitSet f2892a = new BitSet(1);

    /* renamed from: a */
    public int compareTo(C1876hw hwVar) {
        int a;
        int a2;
        int a3;
        if (!getClass().equals(hwVar.getClass())) {
            return getClass().getName().compareTo(hwVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17812a()).compareTo(Boolean.valueOf(hwVar.mo17812a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17812a() && (a3 = C1908ja.m4587a(this.f2889a, hwVar.f2889a)) != 0) {
            return a3;
        }
        int compareTo2 = Boolean.valueOf(mo17814b()).compareTo(Boolean.valueOf(hwVar.mo17814b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo17814b() && (a2 = C1908ja.m4588a((Comparable) this.f2890a, (Comparable) hwVar.f2890a)) != 0) {
            return a2;
        }
        int compareTo3 = Boolean.valueOf(mo17815c()).compareTo(Boolean.valueOf(hwVar.mo17815c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!mo17815c() || (a = C1908ja.m4589a(this.f2891a, hwVar.f2891a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1876hw mo17809a(long j) {
        this.f2889a = j;
        mo17813a(true);
        return this;
    }

    /* renamed from: a */
    public C1876hw mo17810a(C1870hq hqVar) {
        this.f2890a = hqVar;
        return this;
    }

    /* renamed from: a */
    public C1876hw mo17811a(String str) {
        this.f2891a = str;
        return this;
    }

    /* renamed from: a */
    public String mo17812a() {
        return this.f2891a;
    }

    /* renamed from: a */
    public void m3955a() {
        if (this.f2890a == null) {
            throw new C1921jl("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f2891a == null) {
            throw new C1921jl("Required field 'content' was not present! Struct: " + toString());
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
                    if (s == 3 && a.f3526a == 11) {
                        this.f2891a = jkVar.mo18332a();
                        jkVar.mo18351g();
                    }
                } else if (a.f3526a == 8) {
                    this.f2890a = C1870hq.m3898a(jkVar.mo18332a());
                    jkVar.mo18351g();
                }
            } else if (a.f3526a == 10) {
                this.f2889a = jkVar.mo18332a();
                mo17813a(true);
                jkVar.mo18351g();
            }
            C1923jn.m4681a(jkVar, a.f3526a);
            jkVar.mo18351g();
        }
        jkVar.mo18350f();
        if (mo17812a()) {
            mo17812a();
            return;
        }
        throw new C1921jl("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a */
    public void mo17813a(boolean z) {
        this.f2892a.set(0, z);
    }

    /* renamed from: a */
    public boolean m3958a() {
        return this.f2892a.get(0);
    }

    /* renamed from: a */
    public boolean m3959a(C1876hw hwVar) {
        if (hwVar == null || this.f2889a != hwVar.f2889a) {
            return false;
        }
        boolean b = mo17814b();
        boolean b2 = hwVar.mo17814b();
        if ((b || b2) && (!b || !b2 || !this.f2890a.equals(hwVar.f2890a))) {
            return false;
        }
        boolean c = mo17815c();
        boolean c2 = hwVar.mo17815c();
        if (c || c2) {
            return c && c2 && this.f2891a.equals(hwVar.f2891a);
        }
        return true;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17812a();
        jkVar.mo18339a(f2886a);
        jkVar.mo18336a(f2885a);
        jkVar.mo18335a(this.f2889a);
        jkVar.mo18344b();
        if (this.f2890a != null) {
            jkVar.mo18336a(f2887b);
            jkVar.mo18333a(this.f2890a.mo17768a());
            jkVar.mo18344b();
        }
        if (this.f2891a != null) {
            jkVar.mo18336a(f2888c);
            jkVar.mo18340a(this.f2891a);
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public boolean mo17814b() {
        return this.f2890a != null;
    }

    /* renamed from: c */
    public boolean mo17815c() {
        return this.f2891a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1876hw)) {
            return compareTo((C1876hw) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f2889a);
        sb.append(", ");
        sb.append("collectionType:");
        C1870hq hqVar = this.f2890a;
        if (hqVar == null) {
            sb.append("null");
        } else {
            sb.append(hqVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f2891a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }
}
