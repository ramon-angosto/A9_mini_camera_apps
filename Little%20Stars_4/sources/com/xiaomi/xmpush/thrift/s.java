package com.xiaomi.xmpush.thrift;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.nio.ByteBuffer;
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

public class s implements Serializable, Cloneable, org.apache.thrift.a<s, a> {
    public static final Map<a, b> l;
    private static final j m = new j("XmPushActionNotification");
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_ID, (byte) 11, 3);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_TYPE, (byte) 11, 5);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("requireAck", (byte) 2, 6);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("payload", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b(PushConstants.EXTRA, (byte) 13, 8);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("packageName", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("category", (byte) 11, 10);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("binaryExtra", (byte) 11, 14);
    public String a;
    public k b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public Map<String, String> h;
    public String i;
    public String j;
    public ByteBuffer k;
    private BitSet y;

    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, DataBaseHelper.KEY_ID),
        APP_ID(4, "appId"),
        TYPE(5, DataBaseHelper.KEY_TYPE),
        REQUIRE_ACK(6, "requireAck"),
        PAYLOAD(7, "payload"),
        EXTRA(8, PushConstants.EXTRA),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, "category"),
        BINARY_EXTRA(14, "binaryExtra");
        
        private static final Map<String, a> l = null;
        private final short m;
        private final String n;

        static {
            l = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                l.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.m = s;
            this.n = str;
        }

        public String a() {
            return this.n;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.DEBUG, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new b("target", (byte) 2, new f((byte) 12, k.class)));
        enumMap.put(a.ID, new b(DataBaseHelper.KEY_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new b("appId", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TYPE, new b(DataBaseHelper.KEY_TYPE, (byte) 2, new c((byte) 11)));
        enumMap.put(a.REQUIRE_ACK, new b("requireAck", (byte) 1, new c((byte) 2)));
        enumMap.put(a.PAYLOAD, new b("payload", (byte) 2, new c((byte) 11)));
        enumMap.put(a.EXTRA, new b(PushConstants.EXTRA, (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.PACKAGE_NAME, new b("packageName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.CATEGORY, new b("category", (byte) 2, new c((byte) 11)));
        enumMap.put(a.BINARY_EXTRA, new b("binaryExtra", (byte) 2, new c((byte) 11)));
        l = Collections.unmodifiableMap(enumMap);
        b.a(s.class, l);
    }

    public s() {
        this.y = new BitSet(1);
        this.f = true;
    }

    public s(String str, boolean z) {
        this();
        this.c = str;
        this.f = z;
        b(true);
    }

    public s a(String str) {
        this.c = str;
        return this;
    }

    public s a(ByteBuffer byteBuffer) {
        this.k = byteBuffer;
        return this;
    }

    public s a(Map<String, String> map) {
        this.h = map;
        return this;
    }

    public s a(boolean z) {
        this.f = z;
        b(true);
        return this;
    }

    public s a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
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
            boolean r6 = r5.f()
            if (r6 == 0) goto L_0x0018
            r5.n()
            return
        L_0x0018:
            org.apache.thrift.protocol.f r6 = new org.apache.thrift.protocol.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'requireAck' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x0033:
            short r1 = r0.c
            r2 = 14
            r3 = 11
            if (r1 == r2) goto L_0x00e5
            r2 = 2
            switch(r1) {
                case 1: goto L_0x00da;
                case 2: goto L_0x00c7;
                case 3: goto L_0x00bc;
                case 4: goto L_0x00b1;
                case 5: goto L_0x00a6;
                case 6: goto L_0x0097;
                case 7: goto L_0x008c;
                case 8: goto L_0x005e;
                case 9: goto L_0x0052;
                case 10: goto L_0x0046;
                default: goto L_0x003f;
            }
        L_0x003f:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r6, r0)
            goto L_0x00ef
        L_0x0046:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003f
            java.lang.String r0 = r6.v()
            r5.j = r0
            goto L_0x00ef
        L_0x0052:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003f
            java.lang.String r0 = r6.v()
            r5.i = r0
            goto L_0x00ef
        L_0x005e:
            byte r1 = r0.b
            r3 = 13
            if (r1 != r3) goto L_0x003f
            org.apache.thrift.protocol.d r0 = r6.j()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.c
            int r3 = r3 * 2
            r1.<init>(r3)
            r5.h = r1
            r1 = 0
        L_0x0074:
            int r2 = r0.c
            if (r1 >= r2) goto L_0x0088
            java.lang.String r2 = r6.v()
            java.lang.String r3 = r6.v()
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.h
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x0074
        L_0x0088:
            r6.k()
            goto L_0x00ef
        L_0x008c:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003f
            java.lang.String r0 = r6.v()
            r5.g = r0
            goto L_0x00ef
        L_0x0097:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x003f
            boolean r0 = r6.p()
            r5.f = r0
            r0 = 1
            r5.b((boolean) r0)
            goto L_0x00ef
        L_0x00a6:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003f
            java.lang.String r0 = r6.v()
            r5.e = r0
            goto L_0x00ef
        L_0x00b1:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003f
            java.lang.String r0 = r6.v()
            r5.d = r0
            goto L_0x00ef
        L_0x00bc:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003f
            java.lang.String r0 = r6.v()
            r5.c = r0
            goto L_0x00ef
        L_0x00c7:
            byte r1 = r0.b
            r2 = 12
            if (r1 != r2) goto L_0x003f
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r5.b = r0
            com.xiaomi.xmpush.thrift.k r0 = r5.b
            r0.a((org.apache.thrift.protocol.e) r6)
            goto L_0x00ef
        L_0x00da:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003f
            java.lang.String r0 = r6.v()
            r5.a = r0
            goto L_0x00ef
        L_0x00e5:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003f
            java.nio.ByteBuffer r0 = r6.w()
            r5.k = r0
        L_0x00ef:
            r6.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.s.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(s sVar) {
        if (sVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = sVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(sVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = sVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(sVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = sVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(sVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = sVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(sVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = sVar.e();
        if (((e2 || e3) && (!e2 || !e3 || !this.e.equals(sVar.e))) || this.f != sVar.f) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = sVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.g.equals(sVar.g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = sVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.h.equals(sVar.h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = sVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.i.equals(sVar.i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = sVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.j.equals(sVar.j))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = sVar.m();
        if (m2 || m3) {
            return m2 && m3 && this.k.equals(sVar.k);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(s sVar) {
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
        if (!getClass().equals(sVar.getClass())) {
            return getClass().getName().compareTo(sVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(sVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a12 = org.apache.thrift.b.a(this.a, sVar.a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(sVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a11 = org.apache.thrift.b.a((Comparable) this.b, (Comparable) sVar.b)) != 0) {
            return a11;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(sVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a10 = org.apache.thrift.b.a(this.c, sVar.c)) != 0) {
            return a10;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(sVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a9 = org.apache.thrift.b.a(this.d, sVar.d)) != 0) {
            return a9;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(sVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a8 = org.apache.thrift.b.a(this.e, sVar.e)) != 0) {
            return a8;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(sVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a7 = org.apache.thrift.b.a(this.f, sVar.f)) != 0) {
            return a7;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(sVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a6 = org.apache.thrift.b.a(this.g, sVar.g)) != 0) {
            return a6;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(sVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (i() && (a5 = org.apache.thrift.b.a((Map) this.h, (Map) sVar.h)) != 0) {
            return a5;
        }
        int compareTo9 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(sVar.j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (j() && (a4 = org.apache.thrift.b.a(this.i, sVar.i)) != 0) {
            return a4;
        }
        int compareTo10 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(sVar.k()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (k() && (a3 = org.apache.thrift.b.a(this.j, sVar.j)) != 0) {
            return a3;
        }
        int compareTo11 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(sVar.m()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!m() || (a2 = org.apache.thrift.b.a((Comparable) this.k, (Comparable) sVar.k)) == 0) {
            return 0;
        }
        return a2;
    }

    public s b(String str) {
        this.d = str;
        return this;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        n();
        eVar.a(m);
        if (this.a != null && a()) {
            eVar.a(n);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(o);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(p);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && d()) {
            eVar.a(q);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(r);
            eVar.a(this.e);
            eVar.b();
        }
        eVar.a(s);
        eVar.a(this.f);
        eVar.b();
        if (this.g != null && g()) {
            eVar.a(t);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && i()) {
            eVar.a(u);
            eVar.a(new d((byte) 11, (byte) 11, this.h.size()));
            for (Map.Entry next : this.h.entrySet()) {
                eVar.a((String) next.getKey());
                eVar.a((String) next.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.i != null && j()) {
            eVar.a(v);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && k()) {
            eVar.a(w);
            eVar.a(this.j);
            eVar.b();
        }
        if (this.k != null && m()) {
            eVar.a(x);
            eVar.a(this.k);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.y.set(0, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public s c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public s d(String str) {
        this.i = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof s)) {
            return a((s) obj);
        }
        return false;
    }

    public boolean f() {
        return this.y.get(0);
    }

    public boolean g() {
        return this.g != null;
    }

    public Map<String, String> h() {
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

    public boolean k() {
        return this.j != null;
    }

    public byte[] l() {
        a(org.apache.thrift.b.c(this.k));
        return this.k.array();
    }

    public boolean m() {
        return this.k != null;
    }

    public void n() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
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
            sb.append("type:");
            String str4 = this.e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.h;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
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
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.j;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.k;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                org.apache.thrift.b.a(byteBuffer, sb);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
