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

public class ad implements Serializable, Cloneable, org.apache.thrift.a<ad, a> {
    public static final Map<a, b> k;
    private static final j l = new j("XmPushActionUnSubscriptionResult");
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_ID, (byte) 11, 3);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("request", (byte) 12, 5);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("errorCode", (byte) 10, 6);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("reason", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("topic", (byte) 11, 8);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("packageName", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("category", (byte) 11, 10);
    public String a;
    public k b;
    public String c;
    public String d;
    public ac e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    private BitSet w = new BitSet(1);

    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, DataBaseHelper.KEY_ID),
        APP_ID(4, "appId"),
        REQUEST(5, "request"),
        ERROR_CODE(6, "errorCode"),
        REASON(7, "reason"),
        TOPIC(8, "topic"),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, "category");
        
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
        enumMap.put(a.APP_ID, new b("appId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.REQUEST, new b("request", (byte) 2, new f((byte) 12, ac.class)));
        enumMap.put(a.ERROR_CODE, new b("errorCode", (byte) 2, new c((byte) 10)));
        enumMap.put(a.REASON, new b("reason", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TOPIC, new b("topic", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PACKAGE_NAME, new b("packageName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.CATEGORY, new b("category", (byte) 2, new c((byte) 11)));
        k = Collections.unmodifiableMap(enumMap);
        b.a(ad.class, k);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r5) {
        /*
            r4 = this;
            r5.f()
        L_0x0003:
            org.apache.thrift.protocol.b r0 = r5.h()
            byte r1 = r0.b
            if (r1 != 0) goto L_0x0012
            r5.g()
            r4.m()
            return
        L_0x0012:
            short r1 = r0.c
            r2 = 12
            r3 = 11
            switch(r1) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0088;
                case 3: goto L_0x007d;
                case 4: goto L_0x0072;
                case 5: goto L_0x0061;
                case 6: goto L_0x0050;
                case 7: goto L_0x0045;
                case 8: goto L_0x003a;
                case 9: goto L_0x002e;
                case 10: goto L_0x0022;
                default: goto L_0x001b;
            }
        L_0x001b:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r5, r0)
            goto L_0x00a3
        L_0x0022:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001b
            java.lang.String r0 = r5.v()
            r4.j = r0
            goto L_0x00a3
        L_0x002e:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001b
            java.lang.String r0 = r5.v()
            r4.i = r0
            goto L_0x00a3
        L_0x003a:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001b
            java.lang.String r0 = r5.v()
            r4.h = r0
            goto L_0x00a3
        L_0x0045:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001b
            java.lang.String r0 = r5.v()
            r4.g = r0
            goto L_0x00a3
        L_0x0050:
            byte r1 = r0.b
            r2 = 10
            if (r1 != r2) goto L_0x001b
            long r0 = r5.t()
            r4.f = r0
            r0 = 1
            r4.a((boolean) r0)
            goto L_0x00a3
        L_0x0061:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x001b
            com.xiaomi.xmpush.thrift.ac r0 = new com.xiaomi.xmpush.thrift.ac
            r0.<init>()
            r4.e = r0
            com.xiaomi.xmpush.thrift.ac r0 = r4.e
            r0.a((org.apache.thrift.protocol.e) r5)
            goto L_0x00a3
        L_0x0072:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001b
            java.lang.String r0 = r5.v()
            r4.d = r0
            goto L_0x00a3
        L_0x007d:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001b
            java.lang.String r0 = r5.v()
            r4.c = r0
            goto L_0x00a3
        L_0x0088:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x001b
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r4.b = r0
            com.xiaomi.xmpush.thrift.k r0 = r4.b
            r0.a((org.apache.thrift.protocol.e) r5)
            goto L_0x00a3
        L_0x0099:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x001b
            java.lang.String r0 = r5.v()
            r4.a = r0
        L_0x00a3:
            r5.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.ad.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.w.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ad adVar) {
        if (adVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = adVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(adVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = adVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(adVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = adVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(adVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = adVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(adVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = adVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.e.a(adVar.e))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = adVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f != adVar.f)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = adVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.g.equals(adVar.g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = adVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.h.equals(adVar.h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = adVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.i.equals(adVar.i))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = adVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.j.equals(adVar.j);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(ad adVar) {
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
        if (!getClass().equals(adVar.getClass())) {
            return getClass().getName().compareTo(adVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(adVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a11 = org.apache.thrift.b.a(this.a, adVar.a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(adVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = org.apache.thrift.b.a((Comparable) this.b, (Comparable) adVar.b)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(adVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = org.apache.thrift.b.a(this.c, adVar.c)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(adVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = org.apache.thrift.b.a(this.d, adVar.d)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(adVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = org.apache.thrift.b.a((Comparable) this.e, (Comparable) adVar.e)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(adVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = org.apache.thrift.b.a(this.f, adVar.f)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(adVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = org.apache.thrift.b.a(this.g, adVar.g)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(adVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (i() && (a4 = org.apache.thrift.b.a(this.h, adVar.h)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(adVar.j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (j() && (a3 = org.apache.thrift.b.a(this.i, adVar.i)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(adVar.l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!l() || (a2 = org.apache.thrift.b.a(this.j, adVar.j)) == 0) {
            return 0;
        }
        return a2;
    }

    public void b(e eVar) {
        m();
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
        if (this.d != null && d()) {
            eVar.a(p);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(q);
            this.e.b(eVar);
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
        if (this.h != null && i()) {
            eVar.a(t);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && j()) {
            eVar.a(u);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && l()) {
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

    public boolean c() {
        return this.c != null;
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ad)) {
            return a((ad) obj);
        }
        return false;
    }

    public boolean f() {
        return this.w.get(0);
    }

    public boolean g() {
        return this.g != null;
    }

    public String h() {
        return this.h;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.h != null;
    }

    public boolean j() {
        return this.i != null;
    }

    public String k() {
        return this.j;
    }

    public boolean l() {
        return this.j != null;
    }

    public void m() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
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
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("request:");
            ac acVar = this.e;
            if (acVar == null) {
                sb.append("null");
            } else {
                sb.append(acVar);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.g;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.h;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.j;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
