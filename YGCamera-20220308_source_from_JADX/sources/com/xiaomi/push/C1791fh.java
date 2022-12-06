package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.fh */
public class C1791fh implements C1906iz<C1791fh, Object>, Serializable, Cloneable {

    /* renamed from: a */
    private static final C1917jh f2374a = new C1917jh("", (byte) 11, 1);

    /* renamed from: a */
    private static final C1925jp f2375a = new C1925jp("StatsEvents");

    /* renamed from: b */
    private static final C1917jh f2376b = new C1917jh("", (byte) 11, 2);

    /* renamed from: c */
    private static final C1917jh f2377c = new C1917jh("", (byte) 15, 3);

    /* renamed from: a */
    public String f2378a;

    /* renamed from: a */
    public List<C1790fg> f2379a;

    /* renamed from: b */
    public String f2380b;

    public C1791fh() {
    }

    public C1791fh(String str, List<C1790fg> list) {
        this();
        this.f2378a = str;
        this.f2379a = list;
    }

    /* renamed from: a */
    public int compareTo(C1791fh fhVar) {
        int a;
        int a2;
        int a3;
        if (!getClass().equals(fhVar.getClass())) {
            return getClass().getName().compareTo(fhVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo17608a()).compareTo(Boolean.valueOf(fhVar.mo17608a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo17608a() && (a3 = C1908ja.m4589a(this.f2378a, fhVar.f2378a)) != 0) {
            return a3;
        }
        int compareTo2 = Boolean.valueOf(mo17609b()).compareTo(Boolean.valueOf(fhVar.mo17609b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo17609b() && (a2 = C1908ja.m4589a(this.f2380b, fhVar.f2380b)) != 0) {
            return a2;
        }
        int compareTo3 = Boolean.valueOf(mo17610c()).compareTo(Boolean.valueOf(fhVar.mo17610c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!mo17610c() || (a = C1908ja.m4591a((List) this.f2379a, (List) fhVar.f2379a)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: a */
    public C1791fh mo17607a(String str) {
        this.f2380b = str;
        return this;
    }

    /* renamed from: a */
    public void mo17608a() {
        if (this.f2378a == null) {
            throw new C1921jl("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f2379a == null) {
            throw new C1921jl("Required field 'events' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    public void mo17579a(C1920jk jkVar) {
        jkVar.mo18332a();
        while (true) {
            C1917jh a = jkVar.mo18332a();
            if (a.f3526a == 0) {
                jkVar.mo18350f();
                mo17608a();
                return;
            }
            short s = a.f3528a;
            if (s != 1) {
                if (s != 2) {
                    if (s == 3 && a.f3526a == 15) {
                        C1918ji a2 = jkVar.mo18332a();
                        this.f2379a = new ArrayList(a2.f3530a);
                        for (int i = 0; i < a2.f3530a; i++) {
                            C1790fg fgVar = new C1790fg();
                            fgVar.mo17579a(jkVar);
                            this.f2379a.add(fgVar);
                        }
                        jkVar.mo18353i();
                        jkVar.mo18351g();
                    }
                } else if (a.f3526a == 11) {
                    this.f2380b = jkVar.mo18332a();
                    jkVar.mo18351g();
                }
            } else if (a.f3526a == 11) {
                this.f2378a = jkVar.mo18332a();
                jkVar.mo18351g();
            }
            C1923jn.m4681a(jkVar, a.f3526a);
            jkVar.mo18351g();
        }
    }

    /* renamed from: a */
    public boolean m3525a() {
        return this.f2378a != null;
    }

    /* renamed from: a */
    public boolean m3526a(C1791fh fhVar) {
        if (fhVar == null) {
            return false;
        }
        boolean a = mo17608a();
        boolean a2 = fhVar.mo17608a();
        if ((a || a2) && (!a || !a2 || !this.f2378a.equals(fhVar.f2378a))) {
            return false;
        }
        boolean b = mo17609b();
        boolean b2 = fhVar.mo17609b();
        if ((b || b2) && (!b || !b2 || !this.f2380b.equals(fhVar.f2380b))) {
            return false;
        }
        boolean c = mo17610c();
        boolean c2 = fhVar.mo17610c();
        if (c || c2) {
            return c && c2 && this.f2379a.equals(fhVar.f2379a);
        }
        return true;
    }

    /* renamed from: b */
    public void mo17583b(C1920jk jkVar) {
        mo17608a();
        jkVar.mo18339a(f2375a);
        if (this.f2378a != null) {
            jkVar.mo18336a(f2374a);
            jkVar.mo18340a(this.f2378a);
            jkVar.mo18344b();
        }
        if (this.f2380b != null && mo17609b()) {
            jkVar.mo18336a(f2376b);
            jkVar.mo18340a(this.f2380b);
            jkVar.mo18344b();
        }
        if (this.f2379a != null) {
            jkVar.mo18336a(f2377c);
            jkVar.mo18337a(new C1918ji((byte) 12, this.f2379a.size()));
            for (C1790fg b : this.f2379a) {
                b.mo17583b(jkVar);
            }
            jkVar.mo18349e();
            jkVar.mo18344b();
        }
        jkVar.mo18346c();
        jkVar.mo18332a();
    }

    /* renamed from: b */
    public boolean mo17609b() {
        return this.f2380b != null;
    }

    /* renamed from: c */
    public boolean mo17610c() {
        return this.f2379a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1791fh)) {
            return compareTo((C1791fh) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f2378a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (mo17609b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f2380b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<C1790fg> list = this.f2379a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
