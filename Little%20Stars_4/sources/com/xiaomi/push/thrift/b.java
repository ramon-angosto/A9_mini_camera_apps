package com.xiaomi.push.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import object.p2pipcam.utils.DataBaseHelper;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class b implements Serializable, Cloneable, org.apache.thrift.a<b, a> {
    public static final Map<a, org.apache.thrift.meta_data.b> k;
    private static final j l = new j("StatsEvent");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("chid", (byte) 3, 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_TYPE, (byte) 8, 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("value", (byte) 8, 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("connpt", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("host", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("subvalue", (byte) 8, 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("annotation", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_USER, (byte) 11, 8);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("time", (byte) 8, 9);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("clientIp", (byte) 8, 10);
    public byte a;
    public int b;
    public int c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public int i;
    public int j;
    private BitSet w = new BitSet(6);

    public enum a {
        CHID(1, "chid"),
        TYPE(2, DataBaseHelper.KEY_TYPE),
        VALUE(3, "value"),
        CONNPT(4, "connpt"),
        HOST(5, "host"),
        SUBVALUE(6, "subvalue"),
        ANNOTATION(7, "annotation"),
        USER(8, DataBaseHelper.KEY_USER),
        TIME(9, "time"),
        CLIENT_IP(10, "clientIp");
        
        private static final Map<String, a> k = null;
        private final short l;
        private final String m;

        static {
            k = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                k.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.l = s;
            this.m = str;
        }

        public String a() {
            return this.m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.CHID, new org.apache.thrift.meta_data.b("chid", (byte) 1, new c((byte) 3)));
        enumMap.put(a.TYPE, new org.apache.thrift.meta_data.b(DataBaseHelper.KEY_TYPE, (byte) 1, new c((byte) 8)));
        enumMap.put(a.VALUE, new org.apache.thrift.meta_data.b("value", (byte) 1, new c((byte) 8)));
        enumMap.put(a.CONNPT, new org.apache.thrift.meta_data.b("connpt", (byte) 1, new c((byte) 11)));
        enumMap.put(a.HOST, new org.apache.thrift.meta_data.b("host", (byte) 2, new c((byte) 11)));
        enumMap.put(a.SUBVALUE, new org.apache.thrift.meta_data.b("subvalue", (byte) 2, new c((byte) 8)));
        enumMap.put(a.ANNOTATION, new org.apache.thrift.meta_data.b("annotation", (byte) 2, new c((byte) 11)));
        enumMap.put(a.USER, new org.apache.thrift.meta_data.b(DataBaseHelper.KEY_USER, (byte) 2, new c((byte) 11)));
        enumMap.put(a.TIME, new org.apache.thrift.meta_data.b("time", (byte) 2, new c((byte) 8)));
        enumMap.put(a.CLIENT_IP, new org.apache.thrift.meta_data.b("clientIp", (byte) 2, new c((byte) 8)));
        k = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(b.class, k);
    }

    public b() {
    }

    public b(b bVar) {
        this.w.clear();
        this.w.or(bVar.w);
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        if (bVar.d()) {
            this.d = bVar.d;
        }
        if (bVar.e()) {
            this.e = bVar.e;
        }
        this.f = bVar.f;
        if (bVar.g()) {
            this.g = bVar.g;
        }
        if (bVar.h()) {
            this.h = bVar.h;
        }
        this.i = bVar.i;
        this.j = bVar.j;
    }

    public b a(byte b2) {
        this.a = b2;
        a(true);
        return this;
    }

    public b a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public b a(String str) {
        this.d = str;
        return this;
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
            if (r1 != 0) goto L_0x0075
            r6.g()
            boolean r6 = r5.a()
            if (r6 == 0) goto L_0x005a
            boolean r6 = r5.b()
            if (r6 == 0) goto L_0x003f
            boolean r6 = r5.c()
            if (r6 == 0) goto L_0x0024
            r5.k()
            return
        L_0x0024:
            org.apache.thrift.protocol.f r6 = new org.apache.thrift.protocol.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'value' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x003f:
            org.apache.thrift.protocol.f r6 = new org.apache.thrift.protocol.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'type' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x005a:
            org.apache.thrift.protocol.f r6 = new org.apache.thrift.protocol.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'chid' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x0075:
            short r1 = r0.c
            r2 = 11
            r3 = 8
            r4 = 1
            switch(r1) {
                case 1: goto L_0x00f9;
                case 2: goto L_0x00eb;
                case 3: goto L_0x00dd;
                case 4: goto L_0x00d2;
                case 5: goto L_0x00c7;
                case 6: goto L_0x00b9;
                case 7: goto L_0x00ae;
                case 8: goto L_0x00a3;
                case 9: goto L_0x0095;
                case 10: goto L_0x0086;
                default: goto L_0x007f;
            }
        L_0x007f:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r6, r0)
            goto L_0x0107
        L_0x0086:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x007f
            int r0 = r6.s()
            r5.j = r0
            r5.f(r4)
            goto L_0x0107
        L_0x0095:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x007f
            int r0 = r6.s()
            r5.i = r0
            r5.e((boolean) r4)
            goto L_0x0107
        L_0x00a3:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x007f
            java.lang.String r0 = r6.v()
            r5.h = r0
            goto L_0x0107
        L_0x00ae:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x007f
            java.lang.String r0 = r6.v()
            r5.g = r0
            goto L_0x0107
        L_0x00b9:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x007f
            int r0 = r6.s()
            r5.f = r0
            r5.d((boolean) r4)
            goto L_0x0107
        L_0x00c7:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x007f
            java.lang.String r0 = r6.v()
            r5.e = r0
            goto L_0x0107
        L_0x00d2:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x007f
            java.lang.String r0 = r6.v()
            r5.d = r0
            goto L_0x0107
        L_0x00dd:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x007f
            int r0 = r6.s()
            r5.c = r0
            r5.c((boolean) r4)
            goto L_0x0107
        L_0x00eb:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x007f
            int r0 = r6.s()
            r5.b = r0
            r5.b((boolean) r4)
            goto L_0x0107
        L_0x00f9:
            byte r1 = r0.b
            r2 = 3
            if (r1 != r2) goto L_0x007f
            byte r0 = r6.q()
            r5.a = r0
            r5.a((boolean) r4)
        L_0x0107:
            r6.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.thrift.b.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.w.set(0, z);
    }

    public boolean a() {
        return this.w.get(0);
    }

    public boolean a(b bVar) {
        if (bVar == null || this.a != bVar.a || this.b != bVar.b || this.c != bVar.c) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = bVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(bVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = bVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.e.equals(bVar.e))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = bVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f != bVar.f)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = bVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.g.equals(bVar.g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = bVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.h.equals(bVar.h))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = bVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.i != bVar.i)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = bVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.j == bVar.j;
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(b bVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        if (!getClass().equals(bVar.getClass())) {
            return getClass().getName().compareTo(bVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(bVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a11 = org.apache.thrift.b.a(this.a, bVar.a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(bVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = org.apache.thrift.b.a(this.b, bVar.b)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(bVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = org.apache.thrift.b.a(this.c, bVar.c)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(bVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = org.apache.thrift.b.a(this.d, bVar.d)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(bVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = org.apache.thrift.b.a(this.e, bVar.e)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(bVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = org.apache.thrift.b.a(this.f, bVar.f)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(bVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = org.apache.thrift.b.a(this.g, bVar.g)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(bVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = org.apache.thrift.b.a(this.h, bVar.h)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(bVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = org.apache.thrift.b.a(this.i, bVar.i)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(bVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = org.apache.thrift.b.a(this.j, bVar.j)) == 0) {
            return 0;
        }
        return a2;
    }

    public b b(int i2) {
        this.c = i2;
        c(true);
        return this;
    }

    public b b(String str) {
        this.e = str;
        return this;
    }

    public void b(e eVar) {
        k();
        eVar.a(l);
        eVar.a(m);
        eVar.a(this.a);
        eVar.b();
        eVar.a(n);
        eVar.a(this.b);
        eVar.b();
        eVar.a(o);
        eVar.a(this.c);
        eVar.b();
        if (this.d != null) {
            eVar.a(p);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(q);
            eVar.a(this.e);
            eVar.b();
        }
        if (f()) {
            eVar.a(r);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(s);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(t);
            eVar.a(this.h);
            eVar.b();
        }
        if (i()) {
            eVar.a(u);
            eVar.a(this.i);
            eVar.b();
        }
        if (j()) {
            eVar.a(v);
            eVar.a(this.j);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.w.set(1, z);
    }

    public boolean b() {
        return this.w.get(1);
    }

    public b c(int i2) {
        this.f = i2;
        d(true);
        return this;
    }

    public b c(String str) {
        this.g = str;
        return this;
    }

    public void c(boolean z) {
        this.w.set(2, z);
    }

    public boolean c() {
        return this.w.get(2);
    }

    public b d(int i2) {
        this.i = i2;
        e(true);
        return this;
    }

    public b d(String str) {
        this.h = str;
        return this;
    }

    public void d(boolean z) {
        this.w.set(3, z);
    }

    public boolean d() {
        return this.d != null;
    }

    public b e(int i2) {
        this.j = i2;
        f(true);
        return this;
    }

    public void e(boolean z) {
        this.w.set(4, z);
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            return a((b) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.w.set(5, z);
    }

    public boolean f() {
        return this.w.get(3);
    }

    public boolean g() {
        return this.g != null;
    }

    public boolean h() {
        return this.h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.w.get(4);
    }

    public boolean j() {
        return this.w.get(5);
    }

    public void k() {
        if (this.d == null) {
            throw new f("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.c);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.d;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.e;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.g;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.h;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.i);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }
}
