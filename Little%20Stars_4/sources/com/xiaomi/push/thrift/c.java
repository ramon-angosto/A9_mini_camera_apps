package com.xiaomi.push.thrift;

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
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class c implements Serializable, Cloneable, org.apache.thrift.a<c, a> {
    public static final Map<a, b> d;
    private static final j e = new j("StatsEvents");
    private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("uuid", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("operator", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("events", (byte) 15, 3);
    public String a;
    public String b;
    public List<b> c;

    public enum a {
        UUID(1, "uuid"),
        OPERATOR(2, "operator"),
        EVENTS(3, "events");
        
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
        enumMap.put(a.UUID, new b("uuid", (byte) 1, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.OPERATOR, new b("operator", (byte) 2, new org.apache.thrift.meta_data.c((byte) 11)));
        enumMap.put(a.EVENTS, new b("events", (byte) 1, new d((byte) 15, new f((byte) 12, b.class))));
        d = Collections.unmodifiableMap(enumMap);
        b.a(c.class, d);
    }

    public c() {
    }

    public c(String str, List<b> list) {
        this();
        this.a = str;
        this.c = list;
    }

    public c a(String str) {
        this.b = str;
        return this;
    }

    public void a(e eVar) {
        eVar.f();
        while (true) {
            org.apache.thrift.protocol.b h2 = eVar.h();
            if (h2.b == 0) {
                eVar.g();
                d();
                return;
            }
            short s = h2.c;
            if (s != 1) {
                if (s != 2) {
                    if (s == 3 && h2.b == 15) {
                        org.apache.thrift.protocol.c l = eVar.l();
                        this.c = new ArrayList(l.b);
                        for (int i = 0; i < l.b; i++) {
                            b bVar = new b();
                            bVar.a(eVar);
                            this.c.add(bVar);
                        }
                        eVar.m();
                        eVar.i();
                    }
                } else if (h2.b == 11) {
                    this.b = eVar.v();
                    eVar.i();
                }
            } else if (h2.b == 11) {
                this.a = eVar.v();
                eVar.i();
            }
            h.a(eVar, h2.b);
            eVar.i();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = cVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(cVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = cVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.equals(cVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = cVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.c.equals(cVar.c);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(c cVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(cVar.getClass())) {
            return getClass().getName().compareTo(cVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(cVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a4 = org.apache.thrift.b.a(this.a, cVar.a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(cVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = org.apache.thrift.b.a(this.b, cVar.b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(cVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = org.apache.thrift.b.a((List) this.c, (List) cVar.c)) == 0) {
            return 0;
        }
        return a2;
    }

    public void b(e eVar) {
        d();
        eVar.a(e);
        if (this.a != null) {
            eVar.a(f);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(g);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(h);
            eVar.a(new org.apache.thrift.protocol.c((byte) 12, this.c.size()));
            for (b b2 : this.c) {
                b2.b(eVar);
            }
            eVar.e();
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.c != null;
    }

    public void d() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'events' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof c)) {
            return a((c) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<b> list = this.c;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
