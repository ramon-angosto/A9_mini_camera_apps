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
import org.apache.thrift.meta_data.e;
import org.apache.thrift.meta_data.f;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.j;

public class x implements Serializable, Cloneable, org.apache.thrift.a<x, a> {
    public static final Map<a, b> m;
    private static final j n = new j("XmPushActionSendMessage");
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_ID, (byte) 11, 3);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("packageName", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("topic", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("aliasName", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("message", (byte) 12, 8);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("needAck", (byte) 2, 9);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("params", (byte) 13, 10);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("category", (byte) 11, 11);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("userAccount", (byte) 11, 12);
    private BitSet A = new BitSet(1);
    public String a;
    public k b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public h h;
    public boolean i = true;
    public Map<String, String> j;
    public String k;
    public String l;

    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, DataBaseHelper.KEY_ID),
        APP_ID(4, "appId"),
        PACKAGE_NAME(5, "packageName"),
        TOPIC(6, "topic"),
        ALIAS_NAME(7, "aliasName"),
        MESSAGE(8, "message"),
        NEED_ACK(9, "needAck"),
        PARAMS(10, "params"),
        CATEGORY(11, "category"),
        USER_ACCOUNT(12, "userAccount");
        
        private static final Map<String, a> m = null;
        private final short n;
        private final String o;

        static {
            m = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                m.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.n = s;
            this.o = str;
        }

        public String a() {
            return this.o;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.DEBUG, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new b("target", (byte) 2, new f((byte) 12, k.class)));
        enumMap.put(a.ID, new b(DataBaseHelper.KEY_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.PACKAGE_NAME, new b("packageName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TOPIC, new b("topic", (byte) 2, new c((byte) 11)));
        enumMap.put(a.ALIAS_NAME, new b("aliasName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.MESSAGE, new b("message", (byte) 2, new f((byte) 12, h.class)));
        enumMap.put(a.NEED_ACK, new b("needAck", (byte) 2, new c((byte) 2)));
        enumMap.put(a.PARAMS, new b("params", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.CATEGORY, new b("category", (byte) 2, new c((byte) 11)));
        enumMap.put(a.USER_ACCOUNT, new b("userAccount", (byte) 2, new c((byte) 11)));
        m = Collections.unmodifiableMap(enumMap);
        b.a(x.class, m);
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
            r5.t()
            return
        L_0x0012:
            short r1 = r0.c
            r2 = 2
            r3 = 12
            r4 = 11
            switch(r1) {
                case 1: goto L_0x00d2;
                case 2: goto L_0x00c1;
                case 3: goto L_0x00b6;
                case 4: goto L_0x00ab;
                case 5: goto L_0x00a0;
                case 6: goto L_0x0095;
                case 7: goto L_0x008a;
                case 8: goto L_0x0079;
                case 9: goto L_0x006a;
                case 10: goto L_0x003b;
                case 11: goto L_0x002f;
                case 12: goto L_0x0023;
                default: goto L_0x001c;
            }
        L_0x001c:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r6, r0)
            goto L_0x00dc
        L_0x0023:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.l = r0
            goto L_0x00dc
        L_0x002f:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.k = r0
            goto L_0x00dc
        L_0x003b:
            byte r1 = r0.b
            r3 = 13
            if (r1 != r3) goto L_0x001c
            org.apache.thrift.protocol.d r0 = r6.j()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.c
            int r3 = r3 * 2
            r1.<init>(r3)
            r5.j = r1
            r1 = 0
        L_0x0051:
            int r2 = r0.c
            if (r1 >= r2) goto L_0x0065
            java.lang.String r2 = r6.v()
            java.lang.String r3 = r6.v()
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.j
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x0051
        L_0x0065:
            r6.k()
            goto L_0x00dc
        L_0x006a:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x001c
            boolean r0 = r6.p()
            r5.i = r0
            r0 = 1
            r5.a((boolean) r0)
            goto L_0x00dc
        L_0x0079:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001c
            com.xiaomi.xmpush.thrift.h r0 = new com.xiaomi.xmpush.thrift.h
            r0.<init>()
            r5.h = r0
            com.xiaomi.xmpush.thrift.h r0 = r5.h
            r0.a((org.apache.thrift.protocol.e) r6)
            goto L_0x00dc
        L_0x008a:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.g = r0
            goto L_0x00dc
        L_0x0095:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.f = r0
            goto L_0x00dc
        L_0x00a0:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.e = r0
            goto L_0x00dc
        L_0x00ab:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.d = r0
            goto L_0x00dc
        L_0x00b6:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.c = r0
            goto L_0x00dc
        L_0x00c1:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001c
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r5.b = r0
            com.xiaomi.xmpush.thrift.k r0 = r5.b
            r0.a((org.apache.thrift.protocol.e) r6)
            goto L_0x00dc
        L_0x00d2:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.a = r0
        L_0x00dc:
            r6.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.x.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z2) {
        this.A.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(x xVar) {
        if (xVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = xVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(xVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = xVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(xVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = xVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.c.equals(xVar.c))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = xVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.d.equals(xVar.d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = xVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.e.equals(xVar.e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = xVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f.equals(xVar.f))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = xVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.g.equals(xVar.g))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = xVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.h.a(xVar.h))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = xVar.n();
        if ((n2 || n3) && (!n2 || !n3 || this.i != xVar.i)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = xVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.j.equals(xVar.j))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = xVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.k.equals(xVar.k))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = xVar.s();
        if (s2 || s3) {
            return s2 && s3 && this.l.equals(xVar.l);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(x xVar) {
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
        int a12;
        int a13;
        if (!getClass().equals(xVar.getClass())) {
            return getClass().getName().compareTo(xVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(xVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a13 = org.apache.thrift.b.a(this.a, xVar.a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(xVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a12 = org.apache.thrift.b.a((Comparable) this.b, (Comparable) xVar.b)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(xVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a11 = org.apache.thrift.b.a(this.c, xVar.c)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(xVar.f()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (f() && (a10 = org.apache.thrift.b.a(this.d, xVar.d)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(xVar.g()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (g() && (a9 = org.apache.thrift.b.a(this.e, xVar.e)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(xVar.i()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (i() && (a8 = org.apache.thrift.b.a(this.f, xVar.f)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(xVar.k()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (k() && (a7 = org.apache.thrift.b.a(this.g, xVar.g)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(xVar.m()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m() && (a6 = org.apache.thrift.b.a((Comparable) this.h, (Comparable) xVar.h)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(xVar.n()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (n() && (a5 = org.apache.thrift.b.a(this.i, xVar.i)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(xVar.o()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (o() && (a4 = org.apache.thrift.b.a((Map) this.j, (Map) xVar.j)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(xVar.q()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (q() && (a3 = org.apache.thrift.b.a(this.k, xVar.k)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(xVar.s()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!s() || (a2 = org.apache.thrift.b.a(this.l, xVar.l)) == 0) {
            return 0;
        }
        return a2;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        t();
        eVar.a(n);
        if (this.a != null && a()) {
            eVar.a(o);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(p);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(q);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(r);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && g()) {
            eVar.a(s);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && i()) {
            eVar.a(t);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && k()) {
            eVar.a(u);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && m()) {
            eVar.a(v);
            this.h.b(eVar);
            eVar.b();
        }
        if (n()) {
            eVar.a(w);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && o()) {
            eVar.a(x);
            eVar.a(new d((byte) 11, (byte) 11, this.j.size()));
            for (Map.Entry next : this.j.entrySet()) {
                eVar.a((String) next.getKey());
                eVar.a((String) next.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.k != null && q()) {
            eVar.a(y);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && s()) {
            eVar.a(z);
            eVar.a(this.l);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.c != null;
    }

    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof x)) {
            return a((x) obj);
        }
        return false;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.e != null;
    }

    public String h() {
        return this.f;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f != null;
    }

    public String j() {
        return this.g;
    }

    public boolean k() {
        return this.g != null;
    }

    public h l() {
        return this.h;
    }

    public boolean m() {
        return this.h != null;
    }

    public boolean n() {
        return this.A.get(0);
    }

    public boolean o() {
        return this.j != null;
    }

    public String p() {
        return this.k;
    }

    public boolean q() {
        return this.k != null;
    }

    public String r() {
        return this.l;
    }

    public boolean s() {
        return this.l != null;
    }

    public void t() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        if (a()) {
            sb.append("debug:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            k kVar = this.b;
            if (kVar == null) {
                sb.append("null");
            } else {
                sb.append(kVar);
            }
            z2 = false;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("message:");
            h hVar = this.h;
            if (hVar == null) {
                sb.append("null");
            } else {
                sb.append(hVar);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.i);
        }
        if (o()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.j;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.k;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.l;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
