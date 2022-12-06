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

public class k implements Serializable, Cloneable, org.apache.thrift.a<k, a> {
    public static final Map<a, b> f;
    private static final j g = new j("Target");
    private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("channelId", (byte) 10, 1);
    private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("userId", (byte) 11, 2);
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("server", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("resource", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("isPreview", (byte) 2, 5);
    public long a = 5;
    public String b;
    public String c = "xiaomi.com";
    public String d = "";
    public boolean e = false;
    private BitSet m = new BitSet(2);

    public enum a {
        CHANNEL_ID(1, "channelId"),
        USER_ID(2, "userId"),
        SERVER(3, "server"),
        RESOURCE(4, "resource"),
        IS_PREVIEW(5, "isPreview");
        
        private static final Map<String, a> f = null;
        private final short g;
        private final String h;

        static {
            f = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                f.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.g = s;
            this.h = str;
        }

        public String a() {
            return this.h;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.CHANNEL_ID, new b("channelId", (byte) 1, new c((byte) 10)));
        enumMap.put(a.USER_ID, new b("userId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.SERVER, new b("server", (byte) 2, new c((byte) 11)));
        enumMap.put(a.RESOURCE, new b("resource", (byte) 2, new c((byte) 11)));
        enumMap.put(a.IS_PREVIEW, new b("isPreview", (byte) 2, new c((byte) 2)));
        f = Collections.unmodifiableMap(enumMap);
        b.a(k.class, f);
    }

    public void a(e eVar) {
        eVar.f();
        while (true) {
            org.apache.thrift.protocol.b h2 = eVar.h();
            if (h2.b == 0) {
                break;
            }
            short s = h2.c;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s == 5 && h2.b == 2) {
                                this.e = eVar.p();
                                b(true);
                                eVar.i();
                            }
                        } else if (h2.b == 11) {
                            this.d = eVar.v();
                            eVar.i();
                        }
                    } else if (h2.b == 11) {
                        this.c = eVar.v();
                        eVar.i();
                    }
                } else if (h2.b == 11) {
                    this.b = eVar.v();
                    eVar.i();
                }
            } else if (h2.b == 10) {
                this.a = eVar.t();
                a(true);
                eVar.i();
            }
            h.a(eVar, h2.b);
            eVar.i();
        }
        eVar.g();
        if (a()) {
            f();
            return;
        }
        throw new f("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.m.set(0, z);
    }

    public boolean a() {
        return this.m.get(0);
    }

    public boolean a(k kVar) {
        if (kVar == null || this.a != kVar.a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = kVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.equals(kVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = kVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(kVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = kVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(kVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = kVar.e();
        if (e2 || e3) {
            return e2 && e3 && this.e == kVar.e;
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(k kVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        if (!getClass().equals(kVar.getClass())) {
            return getClass().getName().compareTo(kVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(kVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a6 = org.apache.thrift.b.a(this.a, kVar.a)) != 0) {
            return a6;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(kVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a5 = org.apache.thrift.b.a(this.b, kVar.b)) != 0) {
            return a5;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(kVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a4 = org.apache.thrift.b.a(this.c, kVar.c)) != 0) {
            return a4;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(kVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a3 = org.apache.thrift.b.a(this.d, kVar.d)) != 0) {
            return a3;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(kVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (!e() || (a2 = org.apache.thrift.b.a(this.e, kVar.e)) == 0) {
            return 0;
        }
        return a2;
    }

    public void b(e eVar) {
        f();
        eVar.a(g);
        eVar.a(h);
        eVar.a(this.a);
        eVar.b();
        if (this.b != null) {
            eVar.a(i);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null && c()) {
            eVar.a(j);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && d()) {
            eVar.a(k);
            eVar.a(this.d);
            eVar.b();
        }
        if (e()) {
            eVar.a(l);
            eVar.a(this.e);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.m.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.c != null;
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.m.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof k)) {
            return a((k) obj);
        }
        return false;
    }

    public void f() {
        if (this.b == null) {
            throw new f("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.b;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.c;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.e);
        }
        sb.append(")");
        return sb.toString();
    }
}
