package com.xiaomi.xmpush.thrift;

import com.xiaomi.mipush.sdk.Constants;
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

public class aa implements Serializable, Cloneable, org.apache.thrift.a<aa, a> {
    public static final Map<a, b> k;
    private static final j l = new j("XmPushActionUnRegistration");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_ID, (byte) 11, 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("regId", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("appVersion", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("packageName", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b(Constants.EXTRA_KEY_TOKEN, (byte) 11, 8);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("deviceId", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("aliasName", (byte) 11, 10);
    public String a;
    public k b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, DataBaseHelper.KEY_ID),
        APP_ID(4, "appId"),
        REG_ID(5, "regId"),
        APP_VERSION(6, "appVersion"),
        PACKAGE_NAME(7, "packageName"),
        TOKEN(8, Constants.EXTRA_KEY_TOKEN),
        DEVICE_ID(9, "deviceId"),
        ALIAS_NAME(10, "aliasName");
        
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
        enumMap.put(a.DEBUG, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new b("target", (byte) 2, new f((byte) 12, k.class)));
        enumMap.put(a.ID, new b(DataBaseHelper.KEY_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.REG_ID, new b("regId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.APP_VERSION, new b("appVersion", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PACKAGE_NAME, new b("packageName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TOKEN, new b(Constants.EXTRA_KEY_TOKEN, (byte) 2, new c((byte) 11)));
        enumMap.put(a.DEVICE_ID, new b("deviceId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.ALIAS_NAME, new b("aliasName", (byte) 2, new c((byte) 11)));
        k = Collections.unmodifiableMap(enumMap);
        b.a(aa.class, k);
    }

    public aa a(String str) {
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
            r3.k()
            return
        L_0x0012:
            short r1 = r0.c
            r2 = 11
            switch(r1) {
                case 1: goto L_0x008c;
                case 2: goto L_0x0079;
                case 3: goto L_0x006e;
                case 4: goto L_0x0063;
                case 5: goto L_0x0058;
                case 6: goto L_0x004d;
                case 7: goto L_0x0042;
                case 8: goto L_0x0037;
                case 9: goto L_0x002c;
                case 10: goto L_0x0020;
                default: goto L_0x0019;
            }
        L_0x0019:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r4, r0)
            goto L_0x0096
        L_0x0020:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.j = r0
            goto L_0x0096
        L_0x002c:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.i = r0
            goto L_0x0096
        L_0x0037:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.h = r0
            goto L_0x0096
        L_0x0042:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.g = r0
            goto L_0x0096
        L_0x004d:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.f = r0
            goto L_0x0096
        L_0x0058:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.e = r0
            goto L_0x0096
        L_0x0063:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.d = r0
            goto L_0x0096
        L_0x006e:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.c = r0
            goto L_0x0096
        L_0x0079:
            byte r1 = r0.b
            r2 = 12
            if (r1 != r2) goto L_0x0019
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r3.b = r0
            com.xiaomi.xmpush.thrift.k r0 = r3.b
            r0.a((org.apache.thrift.protocol.e) r4)
            goto L_0x0096
        L_0x008c:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.v()
            r3.a = r0
        L_0x0096:
            r4.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.aa.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(aa aaVar) {
        if (aaVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = aaVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(aaVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = aaVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(aaVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = aaVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(aaVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = aaVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(aaVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = aaVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.e.equals(aaVar.e))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = aaVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f.equals(aaVar.f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = aaVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.g.equals(aaVar.g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = aaVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.h.equals(aaVar.h))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = aaVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.i.equals(aaVar.i))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = aaVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.j.equals(aaVar.j);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(aa aaVar) {
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
        if (!getClass().equals(aaVar.getClass())) {
            return getClass().getName().compareTo(aaVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aaVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a11 = org.apache.thrift.b.a(this.a, aaVar.a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aaVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = org.apache.thrift.b.a((Comparable) this.b, (Comparable) aaVar.b)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(aaVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = org.apache.thrift.b.a(this.c, aaVar.c)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(aaVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = org.apache.thrift.b.a(this.d, aaVar.d)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(aaVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = org.apache.thrift.b.a(this.e, aaVar.e)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(aaVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = org.apache.thrift.b.a(this.f, aaVar.f)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(aaVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = org.apache.thrift.b.a(this.g, aaVar.g)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(aaVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = org.apache.thrift.b.a(this.h, aaVar.h)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(aaVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = org.apache.thrift.b.a(this.i, aaVar.i)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(aaVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = org.apache.thrift.b.a(this.j, aaVar.j)) == 0) {
            return 0;
        }
        return a2;
    }

    public aa b(String str) {
        this.d = str;
        return this;
    }

    public void b(e eVar) {
        k();
        eVar.a(l);
        if (this.a != null && a()) {
            eVar.a(m);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(n);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(o);
            eVar.a(this.c);
            eVar.b();
        }
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
        if (this.f != null && f()) {
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
        if (this.i != null && i()) {
            eVar.a(u);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && j()) {
            eVar.a(v);
            eVar.a(this.j);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public aa c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public aa d(String str) {
        this.g = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public aa e(String str) {
        this.h = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof aa)) {
            return a((aa) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
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
        return this.i != null;
    }

    public boolean j() {
        return this.j != null;
    }

    public void k() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
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
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
