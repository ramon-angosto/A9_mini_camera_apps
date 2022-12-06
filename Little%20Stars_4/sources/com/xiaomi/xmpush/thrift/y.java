package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
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

public class y implements Serializable, Cloneable, org.apache.thrift.a<y, a> {
    public static final Map<a, b> h;
    private static final j i = new j("XmPushActionSubscription");
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_ID, (byte) 11, 3);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("topic", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("packageName", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("category", (byte) 11, 7);
    public String a;
    public k b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, DataBaseHelper.KEY_ID),
        APP_ID(4, "appId"),
        TOPIC(5, "topic"),
        PACKAGE_NAME(6, "packageName"),
        CATEGORY(7, "category");
        
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
        enumMap.put(a.DEBUG, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new b("target", (byte) 2, new f((byte) 12, k.class)));
        enumMap.put(a.ID, new b(DataBaseHelper.KEY_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.TOPIC, new b("topic", (byte) 1, new c((byte) 11)));
        enumMap.put(a.PACKAGE_NAME, new b("packageName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.CATEGORY, new b("category", (byte) 2, new c((byte) 11)));
        h = Collections.unmodifiableMap(enumMap);
        b.a(y.class, h);
    }

    public y a(String str) {
        this.c = str;
        return this;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r4) {
        /*
            r3 = this;
            r4.f()
        L_0x0003:
            org.apache.thrift.protocol.b r0 = r4.h()
            byte r1 = r0.b
            if (r1 != 0) goto L_0x0012
            r4.g()
            r3.h()
            return
        L_0x0012:
            short r1 = r0.c
            r2 = 11
            switch(r1) {
                case 1: goto L_0x0069;
                case 2: goto L_0x0056;
                case 3: goto L_0x004b;
                case 4: goto L_0x0040;
                case 5: goto L_0x0035;
                case 6: goto L_0x002a;
                case 7: goto L_0x001f;
                default: goto L_0x0019;
            }
        L_0x0019:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r4, r0)
            goto L_0x0073
        L_0x001f:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.g = r0
            goto L_0x0073
        L_0x002a:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.f = r0
            goto L_0x0073
        L_0x0035:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.e = r0
            goto L_0x0073
        L_0x0040:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.d = r0
            goto L_0x0073
        L_0x004b:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.c = r0
            goto L_0x0073
        L_0x0056:
            byte r1 = r0.b
            r2 = 12
            if (r1 != r2) goto L_0x0019
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r3.b = r0
            com.xiaomi.xmpush.thrift.k r0 = r3.b
            r0.a((org.apache.thrift.protocol.e) r4)
            goto L_0x0073
        L_0x0069:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.a = r0
        L_0x0073:
            r4.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.y.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(y yVar) {
        if (yVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = yVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(yVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = yVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(yVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = yVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(yVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = yVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(yVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = yVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.e.equals(yVar.e))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = yVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f.equals(yVar.f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = yVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.g.equals(yVar.g);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(y yVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(yVar.getClass())) {
            return getClass().getName().compareTo(yVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(yVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a8 = org.apache.thrift.b.a(this.a, yVar.a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(yVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a7 = org.apache.thrift.b.a((Comparable) this.b, (Comparable) yVar.b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(yVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a6 = org.apache.thrift.b.a(this.c, yVar.c)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(yVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a5 = org.apache.thrift.b.a(this.d, yVar.d)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(yVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a4 = org.apache.thrift.b.a(this.e, yVar.e)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(yVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a3 = org.apache.thrift.b.a(this.f, yVar.f)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(yVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!g() || (a2 = org.apache.thrift.b.a(this.g, yVar.g)) == 0) {
            return 0;
        }
        return a2;
    }

    public y b(String str) {
        this.d = str;
        return this;
    }

    public void b(e eVar) {
        h();
        eVar.a(i);
        if (this.a != null && a()) {
            eVar.a(j);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(k);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(l);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(m);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null) {
            eVar.a(n);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(o);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(p);
            eVar.a(this.g);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public y c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public y d(String str) {
        this.f = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public y e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof y)) {
            return a((y) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public boolean g() {
        return this.g != null;
    }

    public void h() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.e == null) {
            throw new org.apache.thrift.protocol.f("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        if (a()) {
            sb.append("debug:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            k kVar = this.b;
            if (kVar == null) {
                sb.append("null");
            } else {
                sb.append(kVar);
            }
            z = false;
        }
        if (!z) {
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
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.e;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
