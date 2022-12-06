package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import object.p2pipcam.utils.DataBaseHelper;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.j;

public class g implements Serializable, Cloneable, org.apache.thrift.a<g, a> {
    public static final Map<a, b> h;
    private static final j i = new j("OnlineConfigItem");
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("key", (byte) 8, 1);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_TYPE, (byte) 8, 2);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("clear", (byte) 2, 3);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("intValue", (byte) 8, 4);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("longValue", (byte) 10, 5);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("stringValue", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("boolValue", (byte) 2, 7);
    public int a;
    public int b;
    public boolean c;
    public int d;
    public long e;
    public String f;
    public boolean g;
    private BitSet q = new BitSet(6);

    public enum a {
        KEY(1, "key"),
        TYPE(2, DataBaseHelper.KEY_TYPE),
        CLEAR(3, "clear"),
        INT_VALUE(4, "intValue"),
        LONG_VALUE(5, "longValue"),
        STRING_VALUE(6, "stringValue"),
        BOOL_VALUE(7, "boolValue");
        
        private static final Map<String, a> h = null;
        private final short i;
        private final String j;

        static {
            h = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                h.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.i = s;
            this.j = str;
        }

        public String a() {
            return this.j;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.KEY, new b("key", (byte) 2, new c((byte) 8)));
        enumMap.put(a.TYPE, new b(DataBaseHelper.KEY_TYPE, (byte) 2, new c((byte) 8)));
        enumMap.put(a.CLEAR, new b("clear", (byte) 2, new c((byte) 2)));
        enumMap.put(a.INT_VALUE, new b("intValue", (byte) 2, new c((byte) 8)));
        enumMap.put(a.LONG_VALUE, new b("longValue", (byte) 2, new c((byte) 10)));
        enumMap.put(a.STRING_VALUE, new b("stringValue", (byte) 2, new c((byte) 11)));
        enumMap.put(a.BOOL_VALUE, new b("boolValue", (byte) 2, new c((byte) 2)));
        h = Collections.unmodifiableMap(enumMap);
        b.a(g.class, h);
    }

    public int a() {
        return this.a;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r6) {
        /*
            r5 = this;
            r6.f()
        L_0x0003:
            org.apache.thrift.protocol.b r0 = r6.h()
            byte r1 = r0.b
            if (r1 != 0) goto L_0x0012
            r6.g()
            r5.n()
            return
        L_0x0012:
            short r1 = r0.c
            r2 = 2
            r3 = 8
            r4 = 1
            switch(r1) {
                case 1: goto L_0x0076;
                case 2: goto L_0x0068;
                case 3: goto L_0x005a;
                case 4: goto L_0x004c;
                case 5: goto L_0x003c;
                case 6: goto L_0x002f;
                case 7: goto L_0x0021;
                default: goto L_0x001b;
            }
        L_0x001b:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r6, r0)
            goto L_0x0083
        L_0x0021:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x001b
            boolean r0 = r6.p()
            r5.g = r0
            r5.f(r4)
            goto L_0x0083
        L_0x002f:
            byte r1 = r0.b
            r2 = 11
            if (r1 != r2) goto L_0x001b
            java.lang.String r0 = r6.v()
            r5.f = r0
            goto L_0x0083
        L_0x003c:
            byte r1 = r0.b
            r2 = 10
            if (r1 != r2) goto L_0x001b
            long r0 = r6.t()
            r5.e = r0
            r5.e(r4)
            goto L_0x0083
        L_0x004c:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001b
            int r0 = r6.s()
            r5.d = r0
            r5.d(r4)
            goto L_0x0083
        L_0x005a:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x001b
            boolean r0 = r6.p()
            r5.c = r0
            r5.c(r4)
            goto L_0x0083
        L_0x0068:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001b
            int r0 = r6.s()
            r5.b = r0
            r5.b((boolean) r4)
            goto L_0x0083
        L_0x0076:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001b
            int r0 = r6.s()
            r5.a = r0
            r5.a((boolean) r4)
        L_0x0083:
            r6.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.g.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.q.set(0, z);
    }

    public boolean a(g gVar) {
        if (gVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gVar.b();
        if ((b2 || b3) && (!b2 || !b3 || this.a != gVar.a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gVar.d();
        if ((d2 || d3) && (!d2 || !d3 || this.b != gVar.b)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.c != gVar.c)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gVar.g();
        if ((g2 || g3) && (!g2 || !g3 || this.d != gVar.d)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.e != gVar.e)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = gVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f.equals(gVar.f))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = gVar.m();
        if (m2 || m3) {
            return m2 && m3 && this.g == gVar.g;
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(g gVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(gVar.getClass())) {
            return getClass().getName().compareTo(gVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a8 = org.apache.thrift.b.a(this.a, gVar.a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gVar.d()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (d() && (a7 = org.apache.thrift.b.a(this.b, gVar.b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (e() && (a6 = org.apache.thrift.b.a(this.c, gVar.c)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gVar.g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (g() && (a5 = org.apache.thrift.b.a(this.d, gVar.d)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gVar.i()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (i() && (a4 = org.apache.thrift.b.a(this.e, gVar.e)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gVar.k()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (k() && (a3 = org.apache.thrift.b.a(this.f, gVar.f)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gVar.m()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!m() || (a2 = org.apache.thrift.b.a(this.g, gVar.g)) == 0) {
            return 0;
        }
        return a2;
    }

    public void b(e eVar) {
        n();
        eVar.a(i);
        if (b()) {
            eVar.a(j);
            eVar.a(this.a);
            eVar.b();
        }
        if (d()) {
            eVar.a(k);
            eVar.a(this.b);
            eVar.b();
        }
        if (e()) {
            eVar.a(l);
            eVar.a(this.c);
            eVar.b();
        }
        if (g()) {
            eVar.a(m);
            eVar.a(this.d);
            eVar.b();
        }
        if (i()) {
            eVar.a(n);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && k()) {
            eVar.a(o);
            eVar.a(this.f);
            eVar.b();
        }
        if (m()) {
            eVar.a(p);
            eVar.a(this.g);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.q.set(1, z);
    }

    public boolean b() {
        return this.q.get(0);
    }

    public int c() {
        return this.b;
    }

    public void c(boolean z) {
        this.q.set(2, z);
    }

    public void d(boolean z) {
        this.q.set(3, z);
    }

    public boolean d() {
        return this.q.get(1);
    }

    public void e(boolean z) {
        this.q.set(4, z);
    }

    public boolean e() {
        return this.q.get(2);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof g)) {
            return a((g) obj);
        }
        return false;
    }

    public int f() {
        return this.d;
    }

    public void f(boolean z) {
        this.q.set(5, z);
    }

    public boolean g() {
        return this.q.get(3);
    }

    public long h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.q.get(4);
    }

    public String j() {
        return this.f;
    }

    public boolean k() {
        return this.f != null;
    }

    public boolean l() {
        return this.g;
    }

    public boolean m() {
        return this.q.get(5);
    }

    public void n() {
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        if (b()) {
            sb.append("key:");
            sb.append(this.a);
            z = false;
        } else {
            z = true;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.b);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.c);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.d);
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.e);
            z = false;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            z = false;
        }
        if (m()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.g);
        }
        sb.append(")");
        return sb.toString();
    }
}
