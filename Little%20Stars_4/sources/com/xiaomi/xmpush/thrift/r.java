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
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.f;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class r implements Serializable, Cloneable, org.apache.thrift.a<r, a> {
    public static final Map<a, b> d;
    private static final j e = new j("XmPushActionNormalConfig");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("normalConfigs", (byte) 15, 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("appId", (byte) 10, 4);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("packageName", (byte) 11, 5);
    public List<e> a;
    public long b;
    public String c;
    private BitSet i = new BitSet(1);

    public enum a {
        NORMAL_CONFIGS(1, "normalConfigs"),
        APP_ID(4, "appId"),
        PACKAGE_NAME(5, "packageName");
        
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
        enumMap.put(a.NORMAL_CONFIGS, new b("normalConfigs", (byte) 1, new d((byte) 15, new f((byte) 12, e.class))));
        enumMap.put(a.APP_ID, new b("appId", (byte) 2, new c((byte) 10)));
        enumMap.put(a.PACKAGE_NAME, new b("packageName", (byte) 2, new c((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        b.a(r.class, d);
    }

    public List<e> a() {
        return this.a;
    }

    public void a(e eVar) {
        eVar.f();
        while (true) {
            org.apache.thrift.protocol.b h2 = eVar.h();
            if (h2.b == 0) {
                eVar.g();
                e();
                return;
            }
            short s = h2.c;
            if (s != 1) {
                if (s != 4) {
                    if (s == 5 && h2.b == 11) {
                        this.c = eVar.v();
                        eVar.i();
                    }
                } else if (h2.b == 10) {
                    this.b = eVar.t();
                    a(true);
                    eVar.i();
                }
            } else if (h2.b == 15) {
                org.apache.thrift.protocol.c l = eVar.l();
                this.a = new ArrayList(l.b);
                for (int i2 = 0; i2 < l.b; i2++) {
                    e eVar2 = new e();
                    eVar2.a(eVar);
                    this.a.add(eVar2);
                }
                eVar.m();
                eVar.i();
            }
            h.a(eVar, h2.b);
            eVar.i();
        }
    }

    public void a(boolean z) {
        this.i.set(0, z);
    }

    public boolean a(r rVar) {
        if (rVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = rVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.a.equals(rVar.a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = rVar.c();
        if ((c2 || c3) && (!c2 || !c3 || this.b != rVar.b)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = rVar.d();
        if (d2 || d3) {
            return d2 && d3 && this.c.equals(rVar.c);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(r rVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(rVar.getClass())) {
            return getClass().getName().compareTo(rVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(rVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a4 = org.apache.thrift.b.a((List) this.a, (List) rVar.a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(rVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a3 = org.apache.thrift.b.a(this.b, rVar.b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(rVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!d() || (a2 = org.apache.thrift.b.a(this.c, rVar.c)) == 0) {
            return 0;
        }
        return a2;
    }

    public void b(e eVar) {
        e();
        eVar.a(e);
        if (this.a != null) {
            eVar.a(f);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.a.size()));
            for (e b2 : this.a) {
                b2.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        if (c()) {
            eVar.a(g);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null && d()) {
            eVar.a(h);
            eVar.a(this.c);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.a != null;
    }

    public boolean c() {
        return this.i.get(0);
    }

    public boolean d() {
        return this.c != null;
    }

    public void e() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof r)) {
            return a((r) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<e> list = this.a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("appId:");
            sb.append(this.b);
        }
        if (d()) {
            sb.append(", ");
            sb.append("packageName:");
            String str = this.c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
