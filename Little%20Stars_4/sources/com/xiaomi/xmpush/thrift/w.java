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

public class w implements Serializable, Cloneable, org.apache.thrift.a<w, a> {
    public static final Map<a, b> i;
    private static final j j = new j("XmPushActionSendFeedbackResult");
    private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("debug", (byte) 11, 1);
    private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("target", (byte) 12, 2);
    private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_ID, (byte) 11, 3);
    private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("appId", (byte) 11, 4);
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("request", (byte) 12, 5);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("errorCode", (byte) 10, 6);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("reason", (byte) 11, 7);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("category", (byte) 11, 8);
    public String a;
    public k b;
    public String c;
    public String d;
    public v e;
    public long f;
    public String g;
    public String h;
    private BitSet s = new BitSet(1);

    public enum a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, DataBaseHelper.KEY_ID),
        APP_ID(4, "appId"),
        REQUEST(5, "request"),
        ERROR_CODE(6, "errorCode"),
        REASON(7, "reason"),
        CATEGORY(8, "category");
        
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
        enumMap.put(a.REQUEST, new b("request", (byte) 2, new f((byte) 12, v.class)));
        enumMap.put(a.ERROR_CODE, new b("errorCode", (byte) 1, new c((byte) 10)));
        enumMap.put(a.REASON, new b("reason", (byte) 2, new c((byte) 11)));
        enumMap.put(a.CATEGORY, new b("category", (byte) 2, new c((byte) 11)));
        i = Collections.unmodifiableMap(enumMap);
        b.a(w.class, i);
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
            boolean r5 = r4.f()
            if (r5 == 0) goto L_0x0018
            r4.i()
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
                case 1: goto L_0x00a2;
                case 2: goto L_0x0091;
                case 3: goto L_0x0086;
                case 4: goto L_0x007b;
                case 5: goto L_0x006a;
                case 6: goto L_0x0059;
                case 7: goto L_0x004e;
                case 8: goto L_0x0043;
                default: goto L_0x003c;
            }
        L_0x003c:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r5, r0)
            goto L_0x00ac
        L_0x0043:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.h = r0
            goto L_0x00ac
        L_0x004e:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.g = r0
            goto L_0x00ac
        L_0x0059:
            byte r1 = r0.b
            r2 = 10
            if (r1 != r2) goto L_0x003c
            long r0 = r5.t()
            r4.f = r0
            r0 = 1
            r4.a((boolean) r0)
            goto L_0x00ac
        L_0x006a:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x003c
            com.xiaomi.xmpush.thrift.v r0 = new com.xiaomi.xmpush.thrift.v
            r0.<init>()
            r4.e = r0
            com.xiaomi.xmpush.thrift.v r0 = r4.e
            r0.a((org.apache.thrift.protocol.e) r5)
            goto L_0x00ac
        L_0x007b:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.d = r0
            goto L_0x00ac
        L_0x0086:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.c = r0
            goto L_0x00ac
        L_0x0091:
            byte r1 = r0.b
            if (r1 != r2) goto L_0x003c
            com.xiaomi.xmpush.thrift.k r0 = new com.xiaomi.xmpush.thrift.k
            r0.<init>()
            r4.b = r0
            com.xiaomi.xmpush.thrift.k r0 = r4.b
            r0.a((org.apache.thrift.protocol.e) r5)
            goto L_0x00ac
        L_0x00a2:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x003c
            java.lang.String r0 = r5.v()
            r4.a = r0
        L_0x00ac:
            r5.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.w.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z) {
        this.s.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(w wVar) {
        if (wVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = wVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(wVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = wVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(wVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = wVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(wVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = wVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(wVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = wVar.e();
        if (((e2 || e3) && (!e2 || !e3 || !this.e.a(wVar.e))) || this.f != wVar.f) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = wVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.g.equals(wVar.g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = wVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.h.equals(wVar.h);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(w wVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(wVar.getClass())) {
            return getClass().getName().compareTo(wVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(wVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a9 = org.apache.thrift.b.a(this.a, wVar.a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(wVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = org.apache.thrift.b.a((Comparable) this.b, (Comparable) wVar.b)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(wVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = org.apache.thrift.b.a(this.c, wVar.c)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(wVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = org.apache.thrift.b.a(this.d, wVar.d)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(wVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = org.apache.thrift.b.a((Comparable) this.e, (Comparable) wVar.e)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(wVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = org.apache.thrift.b.a(this.f, wVar.f)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(wVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = org.apache.thrift.b.a(this.g, wVar.g)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(wVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a2 = org.apache.thrift.b.a(this.h, wVar.h)) == 0) {
            return 0;
        }
        return a2;
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
        if (this.e != null && e()) {
            eVar.a(o);
            this.e.b(eVar);
            eVar.b();
        }
        eVar.a(p);
        eVar.a(this.f);
        eVar.b();
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
        if (obj != null && (obj instanceof w)) {
            return a((w) obj);
        }
        return false;
    }

    public boolean f() {
        return this.s.get(0);
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
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
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
            sb.append("request:");
            v vVar = this.e;
            if (vVar == null) {
                sb.append("null");
            } else {
                sb.append(vVar);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f);
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
        if (h()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.h;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
