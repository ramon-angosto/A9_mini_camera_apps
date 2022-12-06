package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import object.p2pipcam.utils.DataBaseHelper;
import org.apache.thrift.meta_data.b;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.f;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.j;

public class n implements Serializable, Cloneable, org.apache.thrift.a<n, a> {
    public static final Map<a, b> i;
    private static final j j = new j("XmPushActionCommand");
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_ID, (byte) 11, 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("cmdName", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("cmdArgs", (byte) 15, 6);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("packageName", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("category", (byte) 11, 9);
    public String a;
    public k b;
    public String c;
    public String d;
    public String e;
    public List<String> f;
    public String g;
    public String h;

    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, DataBaseHelper.KEY_ID),
        APP_ID(4, "appId"),
        CMD_NAME(5, "cmdName"),
        CMD_ARGS(6, "cmdArgs"),
        PACKAGE_NAME(7, "packageName"),
        CATEGORY(9, "category");
        
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
        enumMap.put(a.DEBUG, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new b("target", (byte) 2, new f((byte) 12, k.class)));
        enumMap.put(a.ID, new b(DataBaseHelper.KEY_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.CMD_NAME, new b("cmdName", (byte) 1, new c((byte) 11)));
        enumMap.put(a.CMD_ARGS, new b("cmdArgs", (byte) 2, new d((byte) 15, new c((byte) 11))));
        enumMap.put(a.PACKAGE_NAME, new b("packageName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.CATEGORY, new b("category", (byte) 2, new c((byte) 11)));
        i = Collections.unmodifiableMap(enumMap);
        b.a(n.class, i);
    }

    public n a(String str) {
        this.c = str;
        return this;
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
            r4.i()
            return
        L_0x0012:
            short r1 = r0.c
            r2 = 11
            switch(r1) {
                case 1: goto L_0x0093;
                case 2: goto L_0x0080;
                case 3: goto L_0x0075;
                case 4: goto L_0x006a;
                case 5: goto L_0x005f;
                case 6: goto L_0x0037;
                case 7: goto L_0x002c;
                case 8: goto L_0x0019;
                case 9: goto L_0x0020;
                default: goto L_0x0019;
            }
        L_0x0019:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r5, r0)
            goto L_0x009d
        L_0x0020:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.v()
            r4.h = r0
            goto L_0x009d
        L_0x002c:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.v()
            r4.g = r0
            goto L_0x009d
        L_0x0037:
            byte r1 = r0.b
            r2 = 15
            if (r1 != r2) goto L_0x0019
            org.apache.thrift.protocol.c r0 = r5.l()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.b
            r1.<init>(r2)
            r4.f = r1
            r1 = 0
        L_0x004b:
            int r2 = r0.b
            if (r1 >= r2) goto L_0x005b
            java.lang.String r2 = r5.v()
            java.util.List<java.lang.String> r3 = r4.f
            r3.add(r2)
            int r1 = r1 + 1
            goto L_0x004b
        L_0x005b:
            r5.m()
            goto L_0x009d
        L_0x005f:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.v()
            r4.e = r0
            goto L_0x009d
        L_0x006a:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.v()
            r4.d = r0
            goto L_0x009d
        L_0x0075:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.v()
            r4.c = r0
            goto L_0x009d
        L_0x0080:
            byte r1 = r0.b
            r2 = 12
            if (r1 != r2) goto L_0x0019
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r4.b = r0
            com.xiaomi.xmpush.thrift.k r0 = r4.b
            r0.a((org.apache.thrift.protocol.e) r5)
            goto L_0x009d
        L_0x0093:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.v()
            r4.a = r0
        L_0x009d:
            r5.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.n.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(n nVar) {
        if (nVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = nVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(nVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = nVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(nVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = nVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(nVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = nVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(nVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = nVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.e.equals(nVar.e))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = nVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f.equals(nVar.f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = nVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.g.equals(nVar.g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = nVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.h.equals(nVar.h);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(n nVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(nVar.getClass())) {
            return getClass().getName().compareTo(nVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(nVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a9 = org.apache.thrift.b.a(this.a, nVar.a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(nVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = org.apache.thrift.b.a((Comparable) this.b, (Comparable) nVar.b)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(nVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = org.apache.thrift.b.a(this.c, nVar.c)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(nVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = org.apache.thrift.b.a(this.d, nVar.d)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(nVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = org.apache.thrift.b.a(this.e, nVar.e)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(nVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = org.apache.thrift.b.a((List) this.f, (List) nVar.f)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(nVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = org.apache.thrift.b.a(this.g, nVar.g)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(nVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a2 = org.apache.thrift.b.a(this.h, nVar.h)) == 0) {
            return 0;
        }
        return a2;
    }

    public n b(String str) {
        this.d = str;
        return this;
    }

    public void b(e eVar) {
        i();
        eVar.a(j);
        if (this.a != null && a()) {
            eVar.a(k);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(l);
            this.b.b(eVar);
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
        if (this.e != null) {
            eVar.a(o);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(p);
            eVar.a(new org.apache.thrift.protocol.c((byte) 11, this.f.size()));
            for (String a2 : this.f) {
                eVar.a(a2);
            }
            eVar.e();
            eVar.b();
        }
        if (this.g != null && g()) {
            eVar.a(q);
            eVar.a(this.g);
            eVar.b();
        }
        if (this.h != null && h()) {
            eVar.a(r);
            eVar.a(this.h);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public n c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public void d(String str) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(str);
    }

    public boolean d() {
        return this.d != null;
    }

    public n e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof n)) {
            return a((n) obj);
        }
        return false;
    }

    public n f(String str) {
        this.h = str;
        return this;
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

    public void i() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.e == null) {
            throw new org.apache.thrift.protocol.f("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
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
        sb.append("cmdName:");
        String str4 = this.e;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.h;
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
