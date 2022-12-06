package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
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

public class o implements Serializable, Cloneable, org.apache.thrift.a<o, a> {
    public static final Map<a, b> l;
    private static final j m = new j("XmPushActionCommandResult");
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_ID, (byte) 11, 3);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("cmdName", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("request", (byte) 12, 6);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("errorCode", (byte) 10, 7);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("reason", (byte) 11, 8);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("packageName", (byte) 11, 9);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("cmdArgs", (byte) 15, 10);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("category", (byte) 11, 12);
    public String a;
    public k b;
    public String c;
    public String d;
    public String e;
    public n f;
    public long g;
    public String h;
    public String i;
    public List<String> j;
    public String k;
    private BitSet y = new BitSet(1);

    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, DataBaseHelper.KEY_ID),
        APP_ID(4, "appId"),
        CMD_NAME(5, "cmdName"),
        REQUEST(6, "request"),
        ERROR_CODE(7, "errorCode"),
        REASON(8, "reason"),
        PACKAGE_NAME(9, "packageName"),
        CMD_ARGS(10, "cmdArgs"),
        CATEGORY(12, "category");
        
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
        enumMap.put(a.APP_ID, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.CMD_NAME, new b("cmdName", (byte) 1, new c((byte) 11)));
        enumMap.put(a.REQUEST, new b("request", (byte) 2, new f((byte) 12, n.class)));
        enumMap.put(a.ERROR_CODE, new b("errorCode", (byte) 1, new c((byte) 10)));
        enumMap.put(a.REASON, new b("reason", (byte) 2, new c((byte) 11)));
        enumMap.put(a.PACKAGE_NAME, new b("packageName", (byte) 2, new c((byte) 11)));
        enumMap.put(a.CMD_ARGS, new b("cmdArgs", (byte) 2, new d((byte) 15, new c((byte) 11))));
        enumMap.put(a.CATEGORY, new b("category", (byte) 2, new c((byte) 11)));
        l = Collections.unmodifiableMap(enumMap);
        b.a(o.class, l);
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
            if (r1 != 0) goto L_0x0033
            r5.g()
            boolean r5 = r4.h()
            if (r5 == 0) goto L_0x0018
            r4.o()
            return
        L_0x0018:
            org.apache.thrift.protocol.f r5 = new org.apache.thrift.protocol.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'errorCode' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r4.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0033:
            short r1 = r0.c
            r2 = 12
            r3 = 11
            switch(r1) {
                case 1: goto L_0x00e3;
                case 2: goto L_0x00d2;
                case 3: goto L_0x00c7;
                case 4: goto L_0x00bc;
                case 5: goto L_0x00b1;
                case 6: goto L_0x00a0;
                case 7: goto L_0x008f;
                case 8: goto L_0x0084;
                case 9: goto L_0x0078;
                case 10: goto L_0x004f;
                case 11: goto L_0x003c;
                case 12: goto L_0x0043;
                default: goto L_0x003c;
            }
        L_0x003c:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r5, r0)
            goto L_0x00ed
        L_0x0043:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.k = r0
            goto L_0x00ed
        L_0x004f:
            byte r1 = r0.b
            r2 = 15
            if (r1 != r2) goto L_0x003c
            org.apache.thrift.protocol.c r0 = r5.l()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.b
            r1.<init>(r2)
            r4.j = r1
            r1 = 0
        L_0x0063:
            int r2 = r0.b
            if (r1 >= r2) goto L_0x0073
            java.lang.String r2 = r5.v()
            java.util.List<java.lang.String> r3 = r4.j
            r3.add(r2)
            int r1 = r1 + 1
            goto L_0x0063
        L_0x0073:
            r5.m()
            goto L_0x00ed
        L_0x0078:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.i = r0
            goto L_0x00ed
        L_0x0084:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.h = r0
            goto L_0x00ed
        L_0x008f:
            byte r1 = r0.b
            r2 = 10
            if (r1 != r2) goto L_0x003c
            long r0 = r5.t()
            r4.g = r0
            r0 = 1
            r4.a((boolean) r0)
            goto L_0x00ed
        L_0x00a0:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x003c
            com.xiaomi.xmpush.thrift.n r0 = new com.xiaomi.xmpush.thrift.n
            r0.<init>()
            r4.f = r0
            com.xiaomi.xmpush.thrift.n r0 = r4.f
            r0.a((org.apache.thrift.protocol.e) r5)
            goto L_0x00ed
        L_0x00b1:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.e = r0
            goto L_0x00ed
        L_0x00bc:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.d = r0
            goto L_0x00ed
        L_0x00c7:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.c = r0
            goto L_0x00ed
        L_0x00d2:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x003c
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r4.b = r0
            com.xiaomi.xmpush.thrift.k r0 = r4.b
            r0.a((org.apache.thrift.protocol.e) r5)
            goto L_0x00ed
        L_0x00e3:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.a = r0
        L_0x00ed:
            r5.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.o.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.y.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = oVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(oVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = oVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(oVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = oVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(oVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = oVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(oVar.d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = oVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.e.equals(oVar.e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = oVar.g();
        if (((g2 || g3) && (!g2 || !g3 || !this.f.a(oVar.f))) || this.g != oVar.g) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = oVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.h.equals(oVar.h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = oVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.i.equals(oVar.i))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = oVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.j.equals(oVar.j))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = oVar.n();
        if (n2 || n3) {
            return n2 && n3 && this.k.equals(oVar.k);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(o oVar) {
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
        if (!getClass().equals(oVar.getClass())) {
            return getClass().getName().compareTo(oVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(oVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a12 = org.apache.thrift.b.a(this.a, oVar.a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(oVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a11 = org.apache.thrift.b.a((Comparable) this.b, (Comparable) oVar.b)) != 0) {
            return a11;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(oVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a10 = org.apache.thrift.b.a(this.c, oVar.c)) != 0) {
            return a10;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(oVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a9 = org.apache.thrift.b.a(this.d, oVar.d)) != 0) {
            return a9;
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(oVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a8 = org.apache.thrift.b.a(this.e, oVar.e)) != 0) {
            return a8;
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(oVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a7 = org.apache.thrift.b.a((Comparable) this.f, (Comparable) oVar.f)) != 0) {
            return a7;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(oVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a6 = org.apache.thrift.b.a(this.g, oVar.g)) != 0) {
            return a6;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(oVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (i() && (a5 = org.apache.thrift.b.a(this.h, oVar.h)) != 0) {
            return a5;
        }
        int compareTo9 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(oVar.j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (j() && (a4 = org.apache.thrift.b.a(this.i, oVar.i)) != 0) {
            return a4;
        }
        int compareTo10 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(oVar.l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (l() && (a3 = org.apache.thrift.b.a((List) this.j, (List) oVar.j)) != 0) {
            return a3;
        }
        int compareTo11 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(oVar.n()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!n() || (a2 = org.apache.thrift.b.a(this.k, oVar.k)) == 0) {
            return 0;
        }
        return a2;
    }

    public void b(e eVar) {
        o();
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
        if (this.d != null) {
            eVar.a(q);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null) {
            eVar.a(r);
            eVar.a(this.e);
            eVar.b();
        }
        if (this.f != null && g()) {
            eVar.a(s);
            this.f.b(eVar);
            eVar.b();
        }
        eVar.a(t);
        eVar.a(this.g);
        eVar.b();
        if (this.h != null && i()) {
            eVar.a(u);
            eVar.a(this.h);
            eVar.b();
        }
        if (this.i != null && j()) {
            eVar.a(v);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && l()) {
            eVar.a(w);
            eVar.a(new org.apache.thrift.protocol.c((byte) 11, this.j.size()));
            for (String a2 : this.j) {
                eVar.a(a2);
            }
            eVar.e();
            eVar.b();
        }
        if (this.k != null && n()) {
            eVar.a(x);
            eVar.a(this.k);
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

    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof o)) {
            return a((o) obj);
        }
        return false;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.f != null;
    }

    public boolean h() {
        return this.y.get(0);
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

    public List<String> k() {
        return this.j;
    }

    public boolean l() {
        return this.j != null;
    }

    public String m() {
        return this.k;
    }

    public boolean n() {
        return this.k != null;
    }

    public void o() {
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
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
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
        if (g()) {
            sb.append(", ");
            sb.append("request:");
            n nVar = this.f;
            if (nVar == null) {
                sb.append("null");
            } else {
                sb.append(nVar);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.g);
        if (i()) {
            sb.append(", ");
            sb.append("reason:");
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
            sb.append("cmdArgs:");
            List<String> list = this.j;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.k;
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
