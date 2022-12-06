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
import org.apache.thrift.meta_data.e;
import org.apache.thrift.meta_data.f;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.j;

public class v implements Serializable, Cloneable, org.apache.thrift.a<v, a> {
    public static final Map<a, b> g;
    private static final j h = new j("XmPushActionSendFeedback");
    private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_ID, (byte) 11, 3);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("feedbacks", (byte) 13, 5);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("category", (byte) 11, 6);
    public String a;
    public k b;
    public String c;
    public String d;
    public Map<String, String> e;
    public String f;

    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, DataBaseHelper.KEY_ID),
        APP_ID(4, "appId"),
        FEEDBACKS(5, "feedbacks"),
        CATEGORY(6, "category");
        
        private static final Map<String, a> g = null;
        private final short h;
        private final String i;

        static {
            g = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                g.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.h = s;
            this.i = str;
        }

        public String a() {
            return this.i;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.DEBUG, new b("debug", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TARGET, new b("target", (byte) 2, new f((byte) 12, k.class)));
        enumMap.put(a.ID, new b(DataBaseHelper.KEY_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.APP_ID, new b("appId", (byte) 1, new c((byte) 11)));
        enumMap.put(a.FEEDBACKS, new b("feedbacks", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.CATEGORY, new b("category", (byte) 2, new c((byte) 11)));
        g = Collections.unmodifiableMap(enumMap);
        b.a(v.class, g);
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
            r5.g()
            return
        L_0x0012:
            short r1 = r0.c
            r2 = 11
            switch(r1) {
                case 1: goto L_0x0082;
                case 2: goto L_0x006f;
                case 3: goto L_0x0064;
                case 4: goto L_0x0059;
                case 5: goto L_0x002b;
                case 6: goto L_0x0020;
                default: goto L_0x0019;
            }
        L_0x0019:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r6, r0)
            goto L_0x008c
        L_0x0020:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.v()
            r5.f = r0
            goto L_0x008c
        L_0x002b:
            byte r1 = r0.b
            r2 = 13
            if (r1 != r2) goto L_0x0019
            org.apache.thrift.protocol.d r0 = r6.j()
            java.util.HashMap r1 = new java.util.HashMap
            int r2 = r0.c
            int r2 = r2 * 2
            r1.<init>(r2)
            r5.e = r1
            r1 = 0
        L_0x0041:
            int r2 = r0.c
            if (r1 >= r2) goto L_0x0055
            java.lang.String r2 = r6.v()
            java.lang.String r3 = r6.v()
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.e
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x0041
        L_0x0055:
            r6.k()
            goto L_0x008c
        L_0x0059:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.v()
            r5.d = r0
            goto L_0x008c
        L_0x0064:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.v()
            r5.c = r0
            goto L_0x008c
        L_0x006f:
            byte r1 = r0.b
            r2 = 12
            if (r1 != r2) goto L_0x0019
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r5.b = r0
            com.xiaomi.xmpush.thrift.k r0 = r5.b
            r0.a((org.apache.thrift.protocol.e) r6)
            goto L_0x008c
        L_0x0082:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.v()
            r5.a = r0
        L_0x008c:
            r6.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.v.a(org.apache.thrift.protocol.e):void");
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(v vVar) {
        if (vVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = vVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(vVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = vVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(vVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = vVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(vVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = vVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(vVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = vVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.e.equals(vVar.e))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = vVar.f();
        if (f2 || f3) {
            return f2 && f3 && this.f.equals(vVar.f);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(v vVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!getClass().equals(vVar.getClass())) {
            return getClass().getName().compareTo(vVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(vVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a7 = org.apache.thrift.b.a(this.a, vVar.a)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(vVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a6 = org.apache.thrift.b.a((Comparable) this.b, (Comparable) vVar.b)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(vVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a5 = org.apache.thrift.b.a(this.c, vVar.c)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(vVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a4 = org.apache.thrift.b.a(this.d, vVar.d)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(vVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a3 = org.apache.thrift.b.a((Map) this.e, (Map) vVar.e)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(vVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!f() || (a2 = org.apache.thrift.b.a(this.f, vVar.f)) == 0) {
            return 0;
        }
        return a2;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        g();
        eVar.a(h);
        if (this.a != null && a()) {
            eVar.a(i);
            eVar.a(this.a);
            eVar.b();
        }
        if (this.b != null && b()) {
            eVar.a(j);
            this.b.b(eVar);
            eVar.b();
        }
        if (this.c != null) {
            eVar.a(k);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null) {
            eVar.a(l);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && e()) {
            eVar.a(m);
            eVar.a(new d((byte) 11, (byte) 11, this.e.size()));
            for (Map.Entry next : this.e.entrySet()) {
                eVar.a((String) next.getKey());
                eVar.a((String) next.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.f != null && f()) {
            eVar.a(n);
            eVar.a(this.f);
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
        if (obj != null && (obj instanceof v)) {
            return a((v) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public void g() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedback(");
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
            sb.append("feedbacks:");
            Map<String, String> map = this.e;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("category:");
            String str4 = this.f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
