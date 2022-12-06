package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.f;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.j;

public class p implements Serializable, Cloneable, org.apache.thrift.a<p, a> {
    public static final Map<a, b> i;
    private static final j j = new j("XmPushActionContainer");
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("action", (byte) 8, 1);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("encryptAction", (byte) 2, 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("isRequest", (byte) 2, 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("pushAction", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("appid", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("packageName", (byte) 11, 6);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("target", (byte) 12, 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("metaInfo", (byte) 12, 8);
    public a a;
    public boolean b = true;
    public boolean c = true;
    public ByteBuffer d;
    public String e;
    public String f;
    public k g;
    public i h;
    private BitSet s = new BitSet(2);

    public enum a {
        ACTION(1, "action"),
        ENCRYPT_ACTION(2, "encryptAction"),
        IS_REQUEST(3, "isRequest"),
        PUSH_ACTION(4, "pushAction"),
        APPID(5, "appid"),
        PACKAGE_NAME(6, "packageName"),
        TARGET(7, "target"),
        META_INFO(8, "metaInfo");
        
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
        enumMap.put(a.ACTION, new b("action", (byte) 1, new org.apache.thrift.meta_data.a((byte) 16, a.class)));
        enumMap.put(a.ENCRYPT_ACTION, new b("encryptAction", (byte) 1, new c((byte) 2)));
        enumMap.put(a.IS_REQUEST, new b("isRequest", (byte) 1, new c((byte) 2)));
        enumMap.put(a.PUSH_ACTION, new b("pushAction", (byte) 1, new c((byte) 11)));
        enumMap.put(a.APPID, new b("appid", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PACKAGE_NAME, new b("packageName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new b("target", (byte) 1, new f((byte) 12, k.class)));
        enumMap.put(a.META_INFO, new b("metaInfo", (byte) 2, new f((byte) 12, i.class)));
        i = Collections.unmodifiableMap(enumMap);
        b.a(p.class, i);
    }

    public a a() {
        return this.a;
    }

    public p a(a aVar) {
        this.a = aVar;
        return this;
    }

    public p a(i iVar) {
        this.h = iVar;
        return this;
    }

    public p a(k kVar) {
        this.g = kVar;
        return this;
    }

    public p a(String str) {
        this.e = str;
        return this;
    }

    public p a(ByteBuffer byteBuffer) {
        this.d = byteBuffer;
        return this;
    }

    public p a(boolean z) {
        this.b = z;
        b(true);
        return this;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r7) {
        /*
            r6 = this;
            r7.f()
        L_0x0003:
            org.apache.thrift.protocol.b r0 = r7.h()
            byte r1 = r0.b
            if (r1 != 0) goto L_0x0054
            r7.g()
            boolean r7 = r6.d()
            if (r7 == 0) goto L_0x0039
            boolean r7 = r6.e()
            if (r7 == 0) goto L_0x001e
            r6.o()
            return
        L_0x001e:
            org.apache.thrift.protocol.f r7 = new org.apache.thrift.protocol.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'isRequest' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x0039:
            org.apache.thrift.protocol.f r7 = new org.apache.thrift.protocol.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'encryptAction' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x0054:
            short r1 = r0.c
            r2 = 1
            r3 = 12
            r4 = 2
            r5 = 11
            switch(r1) {
                case 1: goto L_0x00c5;
                case 2: goto L_0x00b7;
                case 3: goto L_0x00a9;
                case 4: goto L_0x009e;
                case 5: goto L_0x0093;
                case 6: goto L_0x0088;
                case 7: goto L_0x0077;
                case 8: goto L_0x0066;
                default: goto L_0x005f;
            }
        L_0x005f:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r7, r0)
            goto L_0x00d5
        L_0x0066:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x005f
            com.xiaomi.xmpush.thrift.i r0 = new com.xiaomi.xmpush.thrift.i
            r0.<init>()
            r6.h = r0
            com.xiaomi.xmpush.thrift.i r0 = r6.h
            r0.a((org.apache.thrift.protocol.e) r7)
            goto L_0x00d5
        L_0x0077:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x005f
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r6.g = r0
            com.xiaomi.xmpush.thrift.k r0 = r6.g
            r0.a((org.apache.thrift.protocol.e) r7)
            goto L_0x00d5
        L_0x0088:
            byte r1 = r0.b
            if (r1 != r5) goto L_0x005f
            java.lang.String r0 = r7.v()
            r6.f = r0
            goto L_0x00d5
        L_0x0093:
            byte r1 = r0.b
            if (r1 != r5) goto L_0x005f
            java.lang.String r0 = r7.v()
            r6.e = r0
            goto L_0x00d5
        L_0x009e:
            byte r1 = r0.b
            if (r1 != r5) goto L_0x005f
            java.nio.ByteBuffer r0 = r7.w()
            r6.d = r0
            goto L_0x00d5
        L_0x00a9:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x005f
            boolean r0 = r7.p()
            r6.c = r0
            r6.d(r2)
            goto L_0x00d5
        L_0x00b7:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x005f
            boolean r0 = r7.p()
            r6.b = r0
            r6.b((boolean) r2)
            goto L_0x00d5
        L_0x00c5:
            byte r1 = r0.b
            r2 = 8
            if (r1 != r2) goto L_0x005f
            int r0 = r7.s()
            com.xiaomi.xmpush.thrift.a r0 = com.xiaomi.xmpush.thrift.a.a(r0)
            r6.a = r0
        L_0x00d5:
            r7.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.p.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a(p pVar) {
        if (pVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = pVar.b();
        if (((b2 || b3) && (!b2 || !b3 || !this.a.equals(pVar.a))) || this.b != pVar.b || this.c != pVar.c) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = pVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.d.equals(pVar.d))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = pVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.e.equals(pVar.e))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = pVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f.equals(pVar.f))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = pVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.g.a(pVar.g))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = pVar.n();
        if (n2 || n3) {
            return n2 && n3 && this.h.a(pVar.h);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(p pVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(pVar.getClass())) {
            return getClass().getName().compareTo(pVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(pVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a9 = org.apache.thrift.b.a((Comparable) this.a, (Comparable) pVar.a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(pVar.d()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (d() && (a8 = org.apache.thrift.b.a(this.b, pVar.b)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(pVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (e() && (a7 = org.apache.thrift.b.a(this.c, pVar.c)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(pVar.g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (g() && (a6 = org.apache.thrift.b.a((Comparable) this.d, (Comparable) pVar.d)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(pVar.i()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (i() && (a5 = org.apache.thrift.b.a(this.e, pVar.e)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(pVar.k()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (k() && (a4 = org.apache.thrift.b.a(this.f, pVar.f)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(pVar.l()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (l() && (a3 = org.apache.thrift.b.a((Comparable) this.g, (Comparable) pVar.g)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(pVar.n()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!n() || (a2 = org.apache.thrift.b.a((Comparable) this.h, (Comparable) pVar.h)) == 0) {
            return 0;
        }
        return a2;
    }

    public p b(String str) {
        this.f = str;
        return this;
    }

    public void b(e eVar) {
        o();
        eVar.a(j);
        if (this.a != null) {
            eVar.a(k);
            eVar.a(this.a.a());
            eVar.b();
        }
        eVar.a(l);
        eVar.a(this.b);
        eVar.b();
        eVar.a(m);
        eVar.a(this.c);
        eVar.b();
        if (this.d != null) {
            eVar.a(n);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && i()) {
            eVar.a(o);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && k()) {
            eVar.a(p);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null) {
            eVar.a(q);
            this.g.b(eVar);
            eVar.b();
        }
        if (this.h != null && n()) {
            eVar.a(r);
            this.h.b(eVar);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z) {
        this.s.set(0, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public p c(boolean z) {
        this.c = z;
        d(true);
        return this;
    }

    public boolean c() {
        return this.b;
    }

    public void d(boolean z) {
        this.s.set(1, z);
    }

    public boolean d() {
        return this.s.get(0);
    }

    public boolean e() {
        return this.s.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof p)) {
            return a((p) obj);
        }
        return false;
    }

    public byte[] f() {
        a(org.apache.thrift.b.c(this.d));
        return this.d.array();
    }

    public boolean g() {
        return this.d != null;
    }

    public String h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.e != null;
    }

    public String j() {
        return this.f;
    }

    public boolean k() {
        return this.f != null;
    }

    public boolean l() {
        return this.g != null;
    }

    public i m() {
        return this.h;
    }

    public boolean n() {
        return this.h != null;
    }

    public void o() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.f("Required field 'action' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new org.apache.thrift.protocol.f("Required field 'target' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        a aVar = this.a;
        if (aVar == null) {
            sb.append("null");
        } else {
            sb.append(aVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.c);
        sb.append(", ");
        sb.append("pushAction:");
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            org.apache.thrift.b.a(byteBuffer, sb);
        }
        if (i()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.e;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        k kVar = this.g;
        if (kVar == null) {
            sb.append("null");
        } else {
            sb.append(kVar);
        }
        if (n()) {
            sb.append(", ");
            sb.append("metaInfo:");
            i iVar = this.h;
            if (iVar == null) {
                sb.append("null");
            } else {
                sb.append(iVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
