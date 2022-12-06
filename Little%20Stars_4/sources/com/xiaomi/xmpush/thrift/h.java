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
import org.apache.thrift.meta_data.f;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.j;

public class h implements Serializable, Cloneable, org.apache.thrift.a<h, a> {
    public static final Map<a, b> i;
    private static final j j = new j("PushMessage");
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("to", (byte) 12, 1);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_ID, (byte) 11, 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("appId", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("payload", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("createAt", (byte) 10, 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("ttl", (byte) 10, 6);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("collapseKey", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("packageName", (byte) 11, 8);
    public k a;
    public String b;
    public String c;
    public String d;
    public long e;
    public long f;
    public String g;
    public String h;
    private BitSet s = new BitSet(2);

    public enum a {
        TO(1, "to"),
        ID(2, DataBaseHelper.KEY_ID),
        APP_ID(3, "appId"),
        PAYLOAD(4, "payload"),
        CREATE_AT(5, "createAt"),
        TTL(6, "ttl"),
        COLLAPSE_KEY(7, "collapseKey"),
        PACKAGE_NAME(8, "packageName");
        
        private static final Map<String, a> i = null;
        private final short j;
        private final String k;

        static {
            i = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                i.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.j = s;
            this.k = str;
        }

        public String a() {
            return this.k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.TO, new b("to", (byte) 2, new f((byte) 12, k.class)));
        enumMap.put(a.ID, new b(DataBaseHelper.KEY_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.PAYLOAD, new b("payload", (byte) 1, new c((byte) 11)));
        enumMap.put(a.CREATE_AT, new b("createAt", (byte) 2, new c((byte) 10)));
        enumMap.put(a.TTL, new b("ttl", (byte) 2, new c((byte) 10)));
        enumMap.put(a.COLLAPSE_KEY, new b("collapseKey", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PACKAGE_NAME, new b("packageName", (byte) 2, new c((byte) 11)));
        i = Collections.unmodifiableMap(enumMap);
        b.a(h.class, i);
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
            r5.m()
            return
        L_0x0012:
            short r1 = r0.c
            r2 = 1
            r3 = 10
            r4 = 11
            switch(r1) {
                case 1: goto L_0x0075;
                case 2: goto L_0x006a;
                case 3: goto L_0x005f;
                case 4: goto L_0x0054;
                case 5: goto L_0x0046;
                case 6: goto L_0x0038;
                case 7: goto L_0x002d;
                case 8: goto L_0x0022;
                default: goto L_0x001c;
            }
        L_0x001c:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r6, r0)
            goto L_0x0087
        L_0x0022:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.h = r0
            goto L_0x0087
        L_0x002d:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.g = r0
            goto L_0x0087
        L_0x0038:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001c
            long r0 = r6.t()
            r5.f = r0
            r5.b((boolean) r2)
            goto L_0x0087
        L_0x0046:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001c
            long r0 = r6.t()
            r5.e = r0
            r5.a((boolean) r2)
            goto L_0x0087
        L_0x0054:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.d = r0
            goto L_0x0087
        L_0x005f:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.c = r0
            goto L_0x0087
        L_0x006a:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.v()
            r5.b = r0
            goto L_0x0087
        L_0x0075:
            byte r1 = r0.b
            r2 = 12
            if (r1 != r2) goto L_0x001c
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r5.a = r0
            com.xiaomi.xmpush.thrift.k r0 = r5.a
            r0.a((org.apache.thrift.protocol.e) r6)
        L_0x0087:
            r6.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.h.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.s.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(h hVar) {
        if (hVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.a(hVar.a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.b.equals(hVar.b))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.c.equals(hVar.c))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.d.equals(hVar.d))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.e != hVar.e)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hVar.j();
        if ((j2 || j3) && (!j2 || !j3 || this.f != hVar.f)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.g.equals(hVar.g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.h.equals(hVar.h);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(h hVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(hVar.getClass())) {
            return getClass().getName().compareTo(hVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a9 = org.apache.thrift.b.a((Comparable) this.a, (Comparable) hVar.a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a8 = org.apache.thrift.b.a(this.b, hVar.b)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (e() && (a7 = org.apache.thrift.b.a(this.c, hVar.c)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hVar.g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (g() && (a6 = org.apache.thrift.b.a(this.d, hVar.d)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hVar.i()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (i() && (a5 = org.apache.thrift.b.a(this.e, hVar.e)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hVar.j()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (j() && (a4 = org.apache.thrift.b.a(this.f, hVar.f)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hVar.k()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (k() && (a3 = org.apache.thrift.b.a(this.g, hVar.g)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hVar.l()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!l() || (a2 = org.apache.thrift.b.a(this.h, hVar.h)) == 0) {
            return 0;
        }
        return a2;
    }

    public String b() {
        return this.b;
    }

    public void b(e eVar) {
        m();
        eVar.a(j);
        if (this.a != null && a()) {
            eVar.a(k);
            this.a.b(eVar);
            eVar.b();
        }
        if (this.b != null) {
            eVar.a(l);
            eVar.a(this.b);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(m);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(n);
            eVar.a(this.d);
            eVar.b();
        }
        if (i()) {
            eVar.a(o);
            eVar.a(this.e);
            eVar.b();
        }
        if (j()) {
            eVar.a(p);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && k()) {
            eVar.a(q);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && l()) {
            eVar.a(r);
            eVar.a(this.h);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.s.set(1, z);
    }

    public boolean c() {
        return this.b != null;
    }

    public String d() {
        return this.c;
    }

    public boolean e() {
        return this.c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof h)) {
            return a((h) obj);
        }
        return false;
    }

    public String f() {
        return this.d;
    }

    public boolean g() {
        return this.d != null;
    }

    public long h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.s.get(0);
    }

    public boolean j() {
        return this.s.get(1);
    }

    public boolean k() {
        return this.g != null;
    }

    public boolean l() {
        return this.h != null;
    }

    public void m() {
        if (this.b == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (a()) {
            sb.append("to:");
            k kVar = this.a;
            if (kVar == null) {
                sb.append("null");
            } else {
                sb.append(kVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.b;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (i()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.e);
        }
        if (j()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f);
        }
        if (k()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.g;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.h;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
