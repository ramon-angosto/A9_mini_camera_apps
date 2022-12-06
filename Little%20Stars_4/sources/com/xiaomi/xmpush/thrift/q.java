package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.f;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class q implements Serializable, Cloneable, org.apache.thrift.a<q, a> {
    public static final Map<a, b> b;
    private static final j c = new j("XmPushActionCustomConfig");
    private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("customConfigs", (byte) 15, 1);
    public List<g> a;

    public enum a {
        CUSTOM_CONFIGS(1, "customConfigs");
        
        private static final Map<String, a> b = null;
        private final short c;
        private final String d;

        static {
            b = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                b.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.c = s;
            this.d = str;
        }

        public String a() {
            return this.d;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.CUSTOM_CONFIGS, new b("customConfigs", (byte) 1, new d((byte) 15, new f((byte) 12, g.class))));
        b = Collections.unmodifiableMap(enumMap);
        b.a(q.class, b);
    }

    public List<g> a() {
        return this.a;
    }

    public void a(e eVar) {
        eVar.f();
        while (true) {
            org.apache.thrift.protocol.b h = eVar.h();
            if (h.b == 0) {
                eVar.g();
                c();
                return;
            }
            if (h.c == 1 && h.b == 15) {
                c l = eVar.l();
                this.a = new ArrayList(l.b);
                for (int i = 0; i < l.b; i++) {
                    g gVar = new g();
                    gVar.a(eVar);
                    this.a.add(gVar);
                }
                eVar.m();
            } else {
                h.a(eVar, h.b);
            }
            eVar.i();
        }
    }

    public boolean a(q qVar) {
        if (qVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = qVar.b();
        if (b2 || b3) {
            return b2 && b3 && this.a.equals(qVar.a);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(q qVar) {
        int a2;
        if (!getClass().equals(qVar.getClass())) {
            return getClass().getName().compareTo(qVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(qVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!b() || (a2 = org.apache.thrift.b.a((List) this.a, (List) qVar.a)) == 0) {
            return 0;
        }
        return a2;
    }

    public void b(e eVar) {
        c();
        eVar.a(c);
        if (this.a != null) {
            eVar.a(d);
            eVar.a(new c((byte) 12, this.a.size()));
            for (g b2 : this.a) {
                b2.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.a != null;
    }

    public void c() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof q)) {
            return a((q) obj);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<g> list = this.a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
