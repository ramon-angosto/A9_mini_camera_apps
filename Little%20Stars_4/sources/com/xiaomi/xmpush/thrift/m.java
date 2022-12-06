package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class m implements Serializable, Cloneable, org.apache.thrift.a<m, a> {
    public static final Map<a, b> c;
    private static final j d = new j("XmPushActionCheckClientInfo");
    private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("miscConfigVersion", (byte) 8, 1);
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("pluginConfigVersion", (byte) 8, 2);
    public int a;
    public int b;
    private BitSet g = new BitSet(2);

    public enum a {
        MISC_CONFIG_VERSION(1, "miscConfigVersion"),
        PLUGIN_CONFIG_VERSION(2, "pluginConfigVersion");
        
        private static final Map<String, a> c = null;
        private final short d;
        private final String e;

        static {
            c = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                c.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.d = s;
            this.e = str;
        }

        public String a() {
            return this.e;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.MISC_CONFIG_VERSION, new b("miscConfigVersion", (byte) 1, new c((byte) 8)));
        enumMap.put(a.PLUGIN_CONFIG_VERSION, new b("pluginConfigVersion", (byte) 1, new c((byte) 8)));
        c = Collections.unmodifiableMap(enumMap);
        b.a(m.class, c);
    }

    public m a(int i) {
        this.a = i;
        a(true);
        return this;
    }

    public void a(e eVar) {
        eVar.f();
        while (true) {
            org.apache.thrift.protocol.b h = eVar.h();
            if (h.b == 0) {
                break;
            }
            short s = h.c;
            if (s != 1) {
                if (s == 2 && h.b == 8) {
                    this.b = eVar.s();
                    b(true);
                    eVar.i();
                }
            } else if (h.b == 8) {
                this.a = eVar.s();
                a(true);
                eVar.i();
            }
            h.a(eVar, h.b);
            eVar.i();
        }
        eVar.g();
        if (!a()) {
            throw new f("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            c();
        } else {
            throw new f("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        this.g.set(0, z);
    }

    public boolean a() {
        return this.g.get(0);
    }

    public boolean a(m mVar) {
        return mVar != null && this.a == mVar.a && this.b == mVar.b;
    }

    /* renamed from: b */
    public int compareTo(m mVar) {
        int a2;
        int a3;
        if (!getClass().equals(mVar.getClass())) {
            return getClass().getName().compareTo(mVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(mVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a3 = org.apache.thrift.b.a(this.a, mVar.a)) != 0) {
            return a3;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(mVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!b() || (a2 = org.apache.thrift.b.a(this.b, mVar.b)) == 0) {
            return 0;
        }
        return a2;
    }

    public m b(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public void b(e eVar) {
        c();
        eVar.a(d);
        eVar.a(e);
        eVar.a(this.a);
        eVar.b();
        eVar.a(f);
        eVar.a(this.b);
        eVar.b();
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.g.set(1, z);
    }

    public boolean b() {
        return this.g.get(1);
    }

    public void c() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof m)) {
            return a((m) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(" + "miscConfigVersion:" + this.a + ", " + "pluginConfigVersion:" + this.b + ")";
    }
}
