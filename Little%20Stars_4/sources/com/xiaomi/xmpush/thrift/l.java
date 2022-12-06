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
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.f;
import org.apache.thrift.protocol.b;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.j;

public class l implements Serializable, Cloneable, org.apache.thrift.a<l, a> {
    private static final b A = new b("request", (byte) 12, 8);
    private static final b B = new b("packageName", (byte) 11, 9);
    private static final b C = new b("category", (byte) 11, 10);
    private static final b D = new b("isOnline", (byte) 2, 11);
    private static final b E = new b("regId", (byte) 11, 12);
    private static final b F = new b("callbackUrl", (byte) 11, 13);
    private static final b G = new b("userAccount", (byte) 11, 14);
    private static final b H = new b("deviceStatus", (byte) 6, 15);
    private static final b I = new b("imeiMd5", (byte) 11, 20);
    private static final b J = new b("deviceId", (byte) 11, 21);
    public static final Map<a, org.apache.thrift.meta_data.b> r;
    private static final j s = new j("XmPushActionAckMessage");
    private static final b t = new b("debug", (byte) 11, 1);
    private static final b u = new b("target", (byte) 12, 2);
    private static final b v = new b(DataBaseHelper.KEY_ID, (byte) 11, 3);
    private static final b w = new b("appId", (byte) 11, 4);
    private static final b x = new b("messageTs", (byte) 10, 5);
    private static final b y = new b("topic", (byte) 11, 6);
    private static final b z = new b("aliasName", (byte) 11, 7);
    private BitSet K = new BitSet(3);
    public String a;
    public k b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public x h;
    public String i;
    public String j;
    public boolean k = false;
    public String l;
    public String m;
    public String n;
    public short o;
    public String p;
    public String q;

    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, DataBaseHelper.KEY_ID),
        APP_ID(4, "appId"),
        MESSAGE_TS(5, "messageTs"),
        TOPIC(6, "topic"),
        ALIAS_NAME(7, "aliasName"),
        REQUEST(8, "request"),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, "category"),
        IS_ONLINE(11, "isOnline"),
        REG_ID(12, "regId"),
        CALLBACK_URL(13, "callbackUrl"),
        USER_ACCOUNT(14, "userAccount"),
        DEVICE_STATUS(15, "deviceStatus"),
        IMEI_MD5(20, "imeiMd5"),
        DEVICE_ID(21, "deviceId");
        
        private static final Map<String, a> r = null;
        private final short s;
        private final String t;

        static {
            r = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                r.put(aVar.a(), aVar);
            }
        }

        private a(short s2, String str) {
            this.s = s2;
            this.t = str;
        }

        public String a() {
            return this.t;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.DEBUG, new org.apache.thrift.meta_data.b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 2, new f((byte) 12, k.class)));
        enumMap.put(a.ID, new org.apache.thrift.meta_data.b(DataBaseHelper.KEY_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.MESSAGE_TS, new org.apache.thrift.meta_data.b("messageTs", (byte) 1, new c((byte) 10)));
        enumMap.put(a.TOPIC, new org.apache.thrift.meta_data.b("topic", (byte) 2, new c((byte) 11)));
        enumMap.put(a.ALIAS_NAME, new org.apache.thrift.meta_data.b("aliasName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.REQUEST, new org.apache.thrift.meta_data.b("request", (byte) 2, new f((byte) 12, x.class)));
        enumMap.put(a.PACKAGE_NAME, new org.apache.thrift.meta_data.b("packageName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.CATEGORY, new org.apache.thrift.meta_data.b("category", (byte) 2, new c((byte) 11)));
        enumMap.put(a.IS_ONLINE, new org.apache.thrift.meta_data.b("isOnline", (byte) 2, new c((byte) 2)));
        enumMap.put(a.REG_ID, new org.apache.thrift.meta_data.b("regId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.CALLBACK_URL, new org.apache.thrift.meta_data.b("callbackUrl", (byte) 2, new c((byte) 11)));
        enumMap.put(a.USER_ACCOUNT, new org.apache.thrift.meta_data.b("userAccount", (byte) 2, new c((byte) 11)));
        enumMap.put(a.DEVICE_STATUS, new org.apache.thrift.meta_data.b("deviceStatus", (byte) 2, new c((byte) 6)));
        enumMap.put(a.IMEI_MD5, new org.apache.thrift.meta_data.b("imeiMd5", (byte) 2, new c((byte) 11)));
        enumMap.put(a.DEVICE_ID, new org.apache.thrift.meta_data.b("deviceId", (byte) 2, new c((byte) 11)));
        r = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(l.class, r);
    }

    public l a(long j2) {
        this.e = j2;
        a(true);
        return this;
    }

    public l a(String str) {
        this.c = str;
        return this;
    }

    public l a(short s2) {
        this.o = s2;
        c(true);
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
            if (r1 != 0) goto L_0x0033
            r6.g()
            boolean r6 = r5.e()
            if (r6 == 0) goto L_0x0018
            r5.r()
            return
        L_0x0018:
            org.apache.thrift.protocol.f r6 = new org.apache.thrift.protocol.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'messageTs' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x0033:
            short r1 = r0.c
            r2 = 20
            r3 = 11
            if (r1 == r2) goto L_0x011d
            r2 = 21
            if (r1 == r2) goto L_0x0112
            r2 = 12
            r4 = 1
            switch(r1) {
                case 1: goto L_0x0107;
                case 2: goto L_0x00f6;
                case 3: goto L_0x00eb;
                case 4: goto L_0x00e0;
                case 5: goto L_0x00d0;
                case 6: goto L_0x00c5;
                case 7: goto L_0x00ba;
                case 8: goto L_0x00a8;
                case 9: goto L_0x009c;
                case 10: goto L_0x0090;
                case 11: goto L_0x0080;
                case 12: goto L_0x0074;
                case 13: goto L_0x0068;
                case 14: goto L_0x005c;
                case 15: goto L_0x004c;
                default: goto L_0x0045;
            }
        L_0x0045:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r6, r0)
            goto L_0x0127
        L_0x004c:
            byte r1 = r0.b
            r2 = 6
            if (r1 != r2) goto L_0x0045
            short r0 = r6.r()
            r5.o = r0
            r5.c((boolean) r4)
            goto L_0x0127
        L_0x005c:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.n = r0
            goto L_0x0127
        L_0x0068:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.m = r0
            goto L_0x0127
        L_0x0074:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.l = r0
            goto L_0x0127
        L_0x0080:
            byte r1 = r0.b
            r2 = 2
            if (r1 != r2) goto L_0x0045
            boolean r0 = r6.p()
            r5.k = r0
            r5.b((boolean) r4)
            goto L_0x0127
        L_0x0090:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.j = r0
            goto L_0x0127
        L_0x009c:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.i = r0
            goto L_0x0127
        L_0x00a8:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0045
            com.xiaomi.xmpush.thrift.x r0 = new com.xiaomi.xmpush.thrift.x
            r0.<init>()
            r5.h = r0
            com.xiaomi.xmpush.thrift.x r0 = r5.h
            r0.a((org.apache.thrift.protocol.e) r6)
            goto L_0x0127
        L_0x00ba:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.g = r0
            goto L_0x0127
        L_0x00c5:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.f = r0
            goto L_0x0127
        L_0x00d0:
            byte r1 = r0.b
            r2 = 10
            if (r1 != r2) goto L_0x0045
            long r0 = r6.t()
            r5.e = r0
            r5.a((boolean) r4)
            goto L_0x0127
        L_0x00e0:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.d = r0
            goto L_0x0127
        L_0x00eb:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.c = r0
            goto L_0x0127
        L_0x00f6:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0045
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r5.b = r0
            com.xiaomi.xmpush.thrift.k r0 = r5.b
            r0.a((org.apache.thrift.protocol.e) r6)
            goto L_0x0127
        L_0x0107:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.a = r0
            goto L_0x0127
        L_0x0112:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.q = r0
            goto L_0x0127
        L_0x011d:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0045
            java.lang.String r0 = r6.v()
            r5.p = r0
        L_0x0127:
            r6.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.l.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z2) {
        this.K.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(l lVar) {
        if (lVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = lVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(lVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = lVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(lVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = lVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(lVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = lVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.d.equals(lVar.d))) || this.e != lVar.e) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = lVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f.equals(lVar.f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = lVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.g.equals(lVar.g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = lVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.h.a(lVar.h))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = lVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.i.equals(lVar.i))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = lVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.j.equals(lVar.j))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = lVar.k();
        if ((k2 || k3) && (!k2 || !k3 || this.k != lVar.k)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = lVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.l.equals(lVar.l))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = lVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.m.equals(lVar.m))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = lVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.n.equals(lVar.n))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = lVar.o();
        if ((o2 || o3) && (!o2 || !o3 || this.o != lVar.o)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = lVar.p();
        if ((p2 || p3) && (!p2 || !p3 || !this.p.equals(lVar.p))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = lVar.q();
        if (q2 || q3) {
            return q2 && q3 && this.q.equals(lVar.q);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(l lVar) {
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
        if (!getClass().equals(lVar.getClass())) {
            return getClass().getName().compareTo(lVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(lVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a18 = org.apache.thrift.b.a(this.a, lVar.a)) != 0) {
            return a18;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(lVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a17 = org.apache.thrift.b.a((Comparable) this.b, (Comparable) lVar.b)) != 0) {
            return a17;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(lVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a16 = org.apache.thrift.b.a(this.c, lVar.c)) != 0) {
            return a16;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(lVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a15 = org.apache.thrift.b.a(this.d, lVar.d)) != 0) {
            return a15;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(lVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a14 = org.apache.thrift.b.a(this.e, lVar.e)) != 0) {
            return a14;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(lVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a13 = org.apache.thrift.b.a(this.f, lVar.f)) != 0) {
            return a13;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(lVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a12 = org.apache.thrift.b.a(this.g, lVar.g)) != 0) {
            return a12;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(lVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a11 = org.apache.thrift.b.a((Comparable) this.h, (Comparable) lVar.h)) != 0) {
            return a11;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(lVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a10 = org.apache.thrift.b.a(this.i, lVar.i)) != 0) {
            return a10;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(lVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a9 = org.apache.thrift.b.a(this.j, lVar.j)) != 0) {
            return a9;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(lVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a8 = org.apache.thrift.b.a(this.k, lVar.k)) != 0) {
            return a8;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(lVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a7 = org.apache.thrift.b.a(this.l, lVar.l)) != 0) {
            return a7;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(lVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a6 = org.apache.thrift.b.a(this.m, lVar.m)) != 0) {
            return a6;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(lVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a5 = org.apache.thrift.b.a(this.n, lVar.n)) != 0) {
            return a5;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(lVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a4 = org.apache.thrift.b.a(this.o, lVar.o)) != 0) {
            return a4;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(lVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a3 = org.apache.thrift.b.a(this.p, lVar.p)) != 0) {
            return a3;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(lVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (!q() || (a2 = org.apache.thrift.b.a(this.q, lVar.q)) == 0) {
            return 0;
        }
        return a2;
    }

    public l b(String str) {
        this.d = str;
        return this;
    }

    public void b(e eVar) {
        r();
        eVar.a(s);
        if (this.a != null && a()) {
            eVar.a(t);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(u);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(v);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(w);
            eVar.a(this.d);
            eVar.b();
        }
        eVar.a(x);
        eVar.a(this.e);
        eVar.b();
        if (this.f != null && f()) {
            eVar.a(y);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(z);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(A);
            this.h.b(eVar);
            eVar.b();
        }
        if (this.i != null && i()) {
            eVar.a(B);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && j()) {
            eVar.a(C);
            eVar.a(this.j);
            eVar.b();
        }
        if (k()) {
            eVar.a(D);
            eVar.a(this.k);
            eVar.b();
        }
        if (this.l != null && l()) {
            eVar.a(E);
            eVar.a(this.l);
            eVar.b();
        }
        if (this.m != null && m()) {
            eVar.a(F);
            eVar.a(this.m);
            eVar.b();
        }
        if (this.n != null && n()) {
            eVar.a(G);
            eVar.a(this.n);
            eVar.b();
        }
        if (o()) {
            eVar.a(H);
            eVar.a(this.o);
            eVar.b();
        }
        if (this.p != null && p()) {
            eVar.a(I);
            eVar.a(this.p);
            eVar.b();
        }
        if (this.q != null && q()) {
            eVar.a(J);
            eVar.a(this.q);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z2) {
        this.K.set(1, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public l c(String str) {
        this.f = str;
        return this;
    }

    public void c(boolean z2) {
        this.K.set(2, z2);
    }

    public boolean c() {
        return this.c != null;
    }

    public l d(String str) {
        this.g = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.K.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof l)) {
            return a((l) obj);
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

    public boolean k() {
        return this.K.get(1);
    }

    public boolean l() {
        return this.l != null;
    }

    public boolean m() {
        return this.m != null;
    }

    public boolean n() {
        return this.n != null;
    }

    public boolean o() {
        return this.K.get(2);
    }

    public boolean p() {
        return this.p != null;
    }

    public boolean q() {
        return this.q != null;
    }

    public void r() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
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
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.e);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            x xVar = this.h;
            if (xVar == null) {
                sb.append("null");
            } else {
                sb.append(xVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.j;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.k);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.l;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.m;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.n;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append(this.o);
        }
        if (p()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.p;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.q;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
