package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import object.p2pipcam.utils.DataBaseHelper;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class e implements Serializable, Cloneable, org.apache.thrift.a<e, a> {
    public static final Map<a, b> d;
    private static final j e = new j("NormalConfig");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("version", (byte) 8, 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("configItems", (byte) 15, 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_TYPE, (byte) 8, 3);
    public int a;
    public List<g> b;
    public c c;
    private BitSet i = new BitSet(1);

    public enum a {
        VERSION(1, "version"),
        CONFIG_ITEMS(2, "configItems"),
        TYPE(3, DataBaseHelper.KEY_TYPE);
        
        private static final Map<String, a> d = null;
        private final short e;
        private final String f;

        static {
            d = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                d.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public String a() {
            return this.f;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.VERSION, new b("version", (byte) 1, new c((byte) 8)));
        enumMap.put(a.CONFIG_ITEMS, new b("configItems", (byte) 1, new d((byte) 15, new f((byte) 12, g.class))));
        enumMap.put(a.TYPE, new b(DataBaseHelper.KEY_TYPE, (byte) 1, new org.apache.thrift.meta_data.a((byte) 16, c.class)));
        d = Collections.unmodifiableMap(enumMap);
        b.a(e.class, d);
    }

    public int a() {
        return this.a;
    }

    public void a(org.apache.thrift.protocol.e eVar) {
        eVar.f();
        while (true) {
            org.apache.thrift.protocol.b h2 = eVar.h();
            if (h2.b == 0) {
                break;
            }
            short s = h2.c;
            if (s != 1) {
                if (s != 2) {
                    if (s == 3 && h2.b == 8) {
                        this.c = c.a(eVar.s());
                        eVar.i();
                    }
                } else if (h2.b == 15) {
                    org.apache.thrift.protocol.c l = eVar.l();
                    this.b = new ArrayList(l.b);
                    for (int i2 = 0; i2 < l.b; i2++) {
                        g gVar = new g();
                        gVar.a(eVar);
                        this.b.add(gVar);
                    }
                    eVar.m();
                    eVar.i();
                }
            } else if (h2.b == 8) {
                this.a = eVar.s();
                a(true);
                eVar.i();
            }
            h.a(eVar, h2.b);
            eVar.i();
        }
        eVar.g();
        if (b()) {
            f();
            return;
        }
        throw new org.apache.thrift.protocol.f("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.i.set(0, z);
    }

    public boolean a(e eVar) {
        if (eVar == null || this.a != eVar.a) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = eVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.b.equals(eVar.b))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = eVar.e();
        if (e2 || e3) {
            return e2 && e3 && this.c.equals(eVar.c);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(e eVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(eVar.getClass())) {
            return getClass().getName().compareTo(eVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(eVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a4 = org.apache.thrift.b.a(this.a, eVar.a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(eVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a3 = org.apache.thrift.b.a((List) this.b, (List) eVar.b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(eVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!e() || (a2 = org.apache.thrift.b.a((Comparable) this.c, (Comparable) eVar.c)) == 0) {
            return 0;
        }
        return a2;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        f();
        eVar.a(e);
        eVar.a(f);
        eVar.a(this.a);
        eVar.b();
        if (this.b != null) {
            eVar.a(g);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.b.size()));
            for (g b2 : this.b) {
                b2.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(h);
            eVar.a(this.c.a());
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.i.get(0);
    }

    public boolean c() {
        return this.b != null;
    }

    public c d() {
        return this.c;
    }

    public boolean e() {
        return this.c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof e)) {
            return a((e) obj);
        }
        return false;
    }

    public void f() {
        if (this.b == null) {
            throw new org.apache.thrift.protocol.f("Required field 'configItems' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'type' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("configItems:");
        List<g> list = this.b;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(", ");
        sb.append("type:");
        c cVar = this.c;
        if (cVar == null) {
            sb.append("null");
        } else {
            sb.append(cVar);
        }
        sb.append(")");
        return sb.toString();
    }
}
