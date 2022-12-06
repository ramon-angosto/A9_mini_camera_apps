package com.xiaomi.xmpush.thrift;

import com.xiaomi.mipush.sdk.Constants;
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
import org.apache.thrift.meta_data.e;
import org.apache.thrift.meta_data.f;
import org.apache.thrift.protocol.b;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.j;

public class t implements Serializable, Cloneable, org.apache.thrift.a<t, a> {
    private static final b A = new b("target", (byte) 12, 2);
    private static final b B = new b(DataBaseHelper.KEY_ID, (byte) 11, 3);
    private static final b C = new b("appId", (byte) 11, 4);
    private static final b D = new b("appVersion", (byte) 11, 5);
    private static final b E = new b("packageName", (byte) 11, 6);
    private static final b F = new b(Constants.EXTRA_KEY_TOKEN, (byte) 11, 7);
    private static final b G = new b("deviceId", (byte) 11, 8);
    private static final b H = new b("aliasName", (byte) 11, 9);
    private static final b I = new b("sdkVersion", (byte) 11, 10);
    private static final b J = new b("regId", (byte) 11, 11);
    private static final b K = new b("pushSdkVersionName", (byte) 11, 12);
    private static final b L = new b("pushSdkVersionCode", (byte) 8, 13);
    private static final b M = new b("appVersionCode", (byte) 8, 14);
    private static final b N = new b("androidId", (byte) 11, 15);
    private static final b O = new b("imei", (byte) 11, 16);
    private static final b P = new b("serial", (byte) 11, 17);
    private static final b Q = new b("imeiMd5", (byte) 11, 18);
    private static final b R = new b("spaceId", (byte) 8, 19);
    private static final b S = new b("reason", (byte) 8, 20);
    private static final b T = new b("connectionAttrs", (byte) 13, 100);
    private static final b U = new b("cleanOldRegInfo", (byte) 2, 101);
    private static final b V = new b("oldRegId", (byte) 11, 102);
    public static final Map<a, org.apache.thrift.meta_data.b> x;
    private static final j y = new j("XmPushActionRegistration");
    private static final b z = new b("debug", (byte) 11, 1);
    private BitSet W = new BitSet(4);
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
    public String k;
    public String l;
    public int m;
    public int n;
    public String o;
    public String p;
    public String q;
    public String r;
    public int s;
    public j t;
    public Map<String, String> u;
    public boolean v = false;
    public String w;

    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, DataBaseHelper.KEY_ID),
        APP_ID(4, "appId"),
        APP_VERSION(5, "appVersion"),
        PACKAGE_NAME(6, "packageName"),
        TOKEN(7, Constants.EXTRA_KEY_TOKEN),
        DEVICE_ID(8, "deviceId"),
        ALIAS_NAME(9, "aliasName"),
        SDK_VERSION(10, "sdkVersion"),
        REG_ID(11, "regId"),
        PUSH_SDK_VERSION_NAME(12, "pushSdkVersionName"),
        PUSH_SDK_VERSION_CODE(13, "pushSdkVersionCode"),
        APP_VERSION_CODE(14, "appVersionCode"),
        ANDROID_ID(15, "androidId"),
        IMEI(16, "imei"),
        SERIAL(17, "serial"),
        IMEI_MD5(18, "imeiMd5"),
        SPACE_ID(19, "spaceId"),
        REASON(20, "reason"),
        CONNECTION_ATTRS(100, "connectionAttrs"),
        CLEAN_OLD_REG_INFO(101, "cleanOldRegInfo"),
        OLD_REG_ID(102, "oldRegId");
        
        private static final Map<String, a> x = null;
        private final short y;
        private final String z;

        static {
            x = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                x.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.y = s;
            this.z = str;
        }

        public String a() {
            return this.z;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.DEBUG, new org.apache.thrift.meta_data.b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 2, new f((byte) 12, k.class)));
        enumMap.put(a.ID, new org.apache.thrift.meta_data.b(DataBaseHelper.KEY_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_VERSION, new org.apache.thrift.meta_data.b("appVersion", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PACKAGE_NAME, new org.apache.thrift.meta_data.b("packageName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TOKEN, new org.apache.thrift.meta_data.b(Constants.EXTRA_KEY_TOKEN, (byte) 1, new c((byte) 11)));
        enumMap.put(a.DEVICE_ID, new org.apache.thrift.meta_data.b("deviceId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.ALIAS_NAME, new org.apache.thrift.meta_data.b("aliasName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.SDK_VERSION, new org.apache.thrift.meta_data.b("sdkVersion", (byte) 2, new c((byte) 11)));
        enumMap.put(a.REG_ID, new org.apache.thrift.meta_data.b("regId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PUSH_SDK_VERSION_NAME, new org.apache.thrift.meta_data.b("pushSdkVersionName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PUSH_SDK_VERSION_CODE, new org.apache.thrift.meta_data.b("pushSdkVersionCode", (byte) 2, new c((byte) 8)));
        enumMap.put(a.APP_VERSION_CODE, new org.apache.thrift.meta_data.b("appVersionCode", (byte) 2, new c((byte) 8)));
        enumMap.put(a.ANDROID_ID, new org.apache.thrift.meta_data.b("androidId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.IMEI, new org.apache.thrift.meta_data.b("imei", (byte) 2, new c((byte) 11)));
        enumMap.put(a.SERIAL, new org.apache.thrift.meta_data.b("serial", (byte) 2, new c((byte) 11)));
        enumMap.put(a.IMEI_MD5, new org.apache.thrift.meta_data.b("imeiMd5", (byte) 2, new c((byte) 11)));
        enumMap.put(a.SPACE_ID, new org.apache.thrift.meta_data.b("spaceId", (byte) 2, new c((byte) 8)));
        enumMap.put(a.REASON, new org.apache.thrift.meta_data.b("reason", (byte) 2, new org.apache.thrift.meta_data.a((byte) 16, j.class)));
        enumMap.put(a.CONNECTION_ATTRS, new org.apache.thrift.meta_data.b("connectionAttrs", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.CLEAN_OLD_REG_INFO, new org.apache.thrift.meta_data.b("cleanOldRegInfo", (byte) 2, new c((byte) 2)));
        enumMap.put(a.OLD_REG_ID, new org.apache.thrift.meta_data.b("oldRegId", (byte) 2, new c((byte) 11)));
        x = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(t.class, x);
    }

    public t a(int i2) {
        this.m = i2;
        a(true);
        return this;
    }

    public t a(j jVar) {
        this.t = jVar;
        return this;
    }

    public t a(String str) {
        this.c = str;
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
            if (r1 != 0) goto L_0x0012
            r6.g()
            r5.z()
            return
        L_0x0012:
            short r1 = r0.c
            r2 = 8
            r3 = 1
            r4 = 11
            switch(r1) {
                case 1: goto L_0x0162;
                case 2: goto L_0x014f;
                case 3: goto L_0x0144;
                case 4: goto L_0x0139;
                case 5: goto L_0x012e;
                case 6: goto L_0x0123;
                case 7: goto L_0x0118;
                case 8: goto L_0x010d;
                case 9: goto L_0x0102;
                case 10: goto L_0x00f6;
                case 11: goto L_0x00ea;
                case 12: goto L_0x00de;
                case 13: goto L_0x00cf;
                case 14: goto L_0x00c0;
                case 15: goto L_0x00b4;
                case 16: goto L_0x00a8;
                case 17: goto L_0x009c;
                case 18: goto L_0x0090;
                case 19: goto L_0x0081;
                case 20: goto L_0x0071;
                default: goto L_0x001c;
            }
        L_0x001c:
            r2 = 2
            switch(r1) {
                case 100: goto L_0x0042;
                case 101: goto L_0x0033;
                case 102: goto L_0x0027;
                default: goto L_0x0020;
            }
        L_0x0020:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r6, r0)
            goto L_0x016c
        L_0x0027:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.w = r0
            goto L_0x016c
        L_0x0033:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0020
            boolean r0 = r6.p()
            r5.v = r0
            r5.d((boolean) r3)
            goto L_0x016c
        L_0x0042:
            byte r1 = r0.b
            r3 = 13
            if (r1 != r3) goto L_0x0020
            org.apache.thrift.protocol.d r0 = r6.j()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.c
            int r3 = r3 * 2
            r1.<init>(r3)
            r5.u = r1
            r1 = 0
        L_0x0058:
            int r2 = r0.c
            if (r1 >= r2) goto L_0x006c
            java.lang.String r2 = r6.v()
            java.lang.String r3 = r6.v()
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.u
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x0058
        L_0x006c:
            r6.k()
            goto L_0x016c
        L_0x0071:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0020
            int r0 = r6.s()
            com.xiaomi.xmpush.thrift.j r0 = com.xiaomi.xmpush.thrift.j.a(r0)
            r5.t = r0
            goto L_0x016c
        L_0x0081:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0020
            int r0 = r6.s()
            r5.s = r0
            r5.c((boolean) r3)
            goto L_0x016c
        L_0x0090:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.r = r0
            goto L_0x016c
        L_0x009c:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.q = r0
            goto L_0x016c
        L_0x00a8:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.p = r0
            goto L_0x016c
        L_0x00b4:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.o = r0
            goto L_0x016c
        L_0x00c0:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0020
            int r0 = r6.s()
            r5.n = r0
            r5.b((boolean) r3)
            goto L_0x016c
        L_0x00cf:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0020
            int r0 = r6.s()
            r5.m = r0
            r5.a((boolean) r3)
            goto L_0x016c
        L_0x00de:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.l = r0
            goto L_0x016c
        L_0x00ea:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.k = r0
            goto L_0x016c
        L_0x00f6:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.j = r0
            goto L_0x016c
        L_0x0102:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.i = r0
            goto L_0x016c
        L_0x010d:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.h = r0
            goto L_0x016c
        L_0x0118:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.g = r0
            goto L_0x016c
        L_0x0123:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.f = r0
            goto L_0x016c
        L_0x012e:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.e = r0
            goto L_0x016c
        L_0x0139:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.d = r0
            goto L_0x016c
        L_0x0144:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.c = r0
            goto L_0x016c
        L_0x014f:
            byte r1 = r0.b
            r2 = 12
            if (r1 != r2) goto L_0x0020
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r5.b = r0
            com.xiaomi.xmpush.thrift.k r0 = r5.b
            r0.a((org.apache.thrift.protocol.e) r6)
            goto L_0x016c
        L_0x0162:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0020
            java.lang.String r0 = r6.v()
            r5.a = r0
        L_0x016c:
            r6.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.t.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z2) {
        this.W.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(t tVar) {
        if (tVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = tVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(tVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = tVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(tVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = tVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(tVar.c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = tVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.d.equals(tVar.d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = tVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.e.equals(tVar.e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = tVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f.equals(tVar.f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = tVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.g.equals(tVar.g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = tVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.h.equals(tVar.h))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = tVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.i.equals(tVar.i))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = tVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.j.equals(tVar.j))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = tVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.k.equals(tVar.k))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = tVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.l.equals(tVar.l))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = tVar.o();
        if ((o2 || o3) && (!o2 || !o3 || this.m != tVar.m)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = tVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.n != tVar.n)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = tVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.o.equals(tVar.o))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = tVar.r();
        if ((r2 || r3) && (!r2 || !r3 || !this.p.equals(tVar.p))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = tVar.s();
        if ((s2 || s3) && (!s2 || !s3 || !this.q.equals(tVar.q))) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = tVar.t();
        if ((t2 || t3) && (!t2 || !t3 || !this.r.equals(tVar.r))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = tVar.u();
        if ((u2 || u3) && (!u2 || !u3 || this.s != tVar.s)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = tVar.v();
        if ((v2 || v3) && (!v2 || !v3 || !this.t.equals(tVar.t))) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = tVar.w();
        if ((w2 || w3) && (!w2 || !w3 || !this.u.equals(tVar.u))) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = tVar.x();
        if ((x2 || x3) && (!x2 || !x3 || this.v != tVar.v)) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = tVar.y();
        if (y2 || y3) {
            return y2 && y3 && this.w.equals(tVar.w);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(t tVar) {
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
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a20;
        int a21;
        int a22;
        int a23;
        int a24;
        if (!getClass().equals(tVar.getClass())) {
            return getClass().getName().compareTo(tVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(tVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a24 = org.apache.thrift.b.a(this.a, tVar.a)) != 0) {
            return a24;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(tVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a23 = org.apache.thrift.b.a((Comparable) this.b, (Comparable) tVar.b)) != 0) {
            return a23;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(tVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a22 = org.apache.thrift.b.a(this.c, tVar.c)) != 0) {
            return a22;
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(tVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a21 = org.apache.thrift.b.a(this.d, tVar.d)) != 0) {
            return a21;
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(tVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a20 = org.apache.thrift.b.a(this.e, tVar.e)) != 0) {
            return a20;
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(tVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a19 = org.apache.thrift.b.a(this.f, tVar.f)) != 0) {
            return a19;
        }
        int compareTo7 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(tVar.i()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (i() && (a18 = org.apache.thrift.b.a(this.g, tVar.g)) != 0) {
            return a18;
        }
        int compareTo8 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(tVar.j()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (j() && (a17 = org.apache.thrift.b.a(this.h, tVar.h)) != 0) {
            return a17;
        }
        int compareTo9 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(tVar.k()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (k() && (a16 = org.apache.thrift.b.a(this.i, tVar.i)) != 0) {
            return a16;
        }
        int compareTo10 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(tVar.l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (l() && (a15 = org.apache.thrift.b.a(this.j, tVar.j)) != 0) {
            return a15;
        }
        int compareTo11 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(tVar.m()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m() && (a14 = org.apache.thrift.b.a(this.k, tVar.k)) != 0) {
            return a14;
        }
        int compareTo12 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(tVar.n()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (n() && (a13 = org.apache.thrift.b.a(this.l, tVar.l)) != 0) {
            return a13;
        }
        int compareTo13 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(tVar.o()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (o() && (a12 = org.apache.thrift.b.a(this.m, tVar.m)) != 0) {
            return a12;
        }
        int compareTo14 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(tVar.p()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (p() && (a11 = org.apache.thrift.b.a(this.n, tVar.n)) != 0) {
            return a11;
        }
        int compareTo15 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(tVar.q()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (q() && (a10 = org.apache.thrift.b.a(this.o, tVar.o)) != 0) {
            return a10;
        }
        int compareTo16 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(tVar.r()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (r() && (a9 = org.apache.thrift.b.a(this.p, tVar.p)) != 0) {
            return a9;
        }
        int compareTo17 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(tVar.s()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (s() && (a8 = org.apache.thrift.b.a(this.q, tVar.q)) != 0) {
            return a8;
        }
        int compareTo18 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(tVar.t()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (t() && (a7 = org.apache.thrift.b.a(this.r, tVar.r)) != 0) {
            return a7;
        }
        int compareTo19 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(tVar.u()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (u() && (a6 = org.apache.thrift.b.a(this.s, tVar.s)) != 0) {
            return a6;
        }
        int compareTo20 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(tVar.v()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (v() && (a5 = org.apache.thrift.b.a((Comparable) this.t, (Comparable) tVar.t)) != 0) {
            return a5;
        }
        int compareTo21 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(tVar.w()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (w() && (a4 = org.apache.thrift.b.a((Map) this.u, (Map) tVar.u)) != 0) {
            return a4;
        }
        int compareTo22 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(tVar.x()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (x() && (a3 = org.apache.thrift.b.a(this.v, tVar.v)) != 0) {
            return a3;
        }
        int compareTo23 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(tVar.y()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (!y() || (a2 = org.apache.thrift.b.a(this.w, tVar.w)) == 0) {
            return 0;
        }
        return a2;
    }

    public t b(int i2) {
        this.n = i2;
        b(true);
        return this;
    }

    public t b(String str) {
        this.d = str;
        return this;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        z();
        eVar.a(y);
        if (this.a != null && a()) {
            eVar.a(z);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(A);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(B);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(C);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && f()) {
            eVar.a(D);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && g()) {
            eVar.a(E);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null) {
            eVar.a(F);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && j()) {
            eVar.a(G);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && k()) {
            eVar.a(H);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && l()) {
            eVar.a(I);
            eVar.a(this.j);
            eVar.b();
        }
        if (this.k != null && m()) {
            eVar.a(J);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && n()) {
            eVar.a(K);
            eVar.a(this.l);
            eVar.b();
        }
        if (o()) {
            eVar.a(L);
            eVar.a(this.m);
            eVar.b();
        }
        if (p()) {
            eVar.a(M);
            eVar.a(this.n);
            eVar.b();
        }
        if (this.o != null && q()) {
            eVar.a(N);
            eVar.a(this.o);
            eVar.b();
        }
        if (this.p != null && r()) {
            eVar.a(O);
            eVar.a(this.p);
            eVar.b();
        }
        if (this.q != null && s()) {
            eVar.a(P);
            eVar.a(this.q);
            eVar.b();
        }
        if (this.r != null && t()) {
            eVar.a(Q);
            eVar.a(this.r);
            eVar.b();
        }
        if (u()) {
            eVar.a(R);
            eVar.a(this.s);
            eVar.b();
        }
        if (this.t != null && v()) {
            eVar.a(S);
            eVar.a(this.t.a());
            eVar.b();
        }
        if (this.u != null && w()) {
            eVar.a(T);
            eVar.a(new d((byte) 11, (byte) 11, this.u.size()));
            for (Map.Entry next : this.u.entrySet()) {
                eVar.a((String) next.getKey());
                eVar.a((String) next.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (x()) {
            eVar.a(U);
            eVar.a(this.v);
            eVar.b();
        }
        if (this.w != null && y()) {
            eVar.a(V);
            eVar.a(this.w);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z2) {
        this.W.set(1, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public t c(int i2) {
        this.s = i2;
        c(true);
        return this;
    }

    public t c(String str) {
        this.e = str;
        return this;
    }

    public void c(boolean z2) {
        this.W.set(2, z2);
    }

    public boolean c() {
        return this.c != null;
    }

    public t d(String str) {
        this.f = str;
        return this;
    }

    public String d() {
        return this.d;
    }

    public void d(boolean z2) {
        this.W.set(3, z2);
    }

    public t e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof t)) {
            return a((t) obj);
        }
        return false;
    }

    public t f(String str) {
        this.h = str;
        return this;
    }

    public boolean f() {
        return this.e != null;
    }

    public t g(String str) {
        this.l = str;
        return this;
    }

    public boolean g() {
        return this.f != null;
    }

    public t h(String str) {
        this.o = str;
        return this;
    }

    public String h() {
        return this.g;
    }

    public int hashCode() {
        return 0;
    }

    public t i(String str) {
        this.p = str;
        return this;
    }

    public boolean i() {
        return this.g != null;
    }

    public t j(String str) {
        this.q = str;
        return this;
    }

    public boolean j() {
        return this.h != null;
    }

    public t k(String str) {
        this.r = str;
        return this;
    }

    public boolean k() {
        return this.i != null;
    }

    public boolean l() {
        return this.j != null;
    }

    public boolean m() {
        return this.k != null;
    }

    public boolean n() {
        return this.l != null;
    }

    public boolean o() {
        return this.W.get(0);
    }

    public boolean p() {
        return this.W.get(1);
    }

    public boolean q() {
        return this.o != null;
    }

    public boolean r() {
        return this.p != null;
    }

    public boolean s() {
        return this.q != null;
    }

    public boolean t() {
        return this.r != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
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
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.g;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (j()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.k;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.l;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.m);
        }
        if (p()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.n);
        }
        if (q()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.o;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.p;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.q;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.r;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.s);
        }
        if (v()) {
            sb.append(", ");
            sb.append("reason:");
            j jVar = this.t;
            if (jVar == null) {
                sb.append("null");
            } else {
                sb.append(jVar);
            }
        }
        if (w()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.u;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (x()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.v);
        }
        if (y()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str16 = this.w;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.W.get(2);
    }

    public boolean v() {
        return this.t != null;
    }

    public boolean w() {
        return this.u != null;
    }

    public boolean x() {
        return this.W.get(3);
    }

    public boolean y() {
        return this.w != null;
    }

    public void z() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new org.apache.thrift.protocol.f("Required field 'token' was not present! Struct: " + toString());
        }
    }
}
