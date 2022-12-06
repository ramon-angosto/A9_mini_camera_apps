package com.xiaomi.xmpush.thrift;

import com.meizu.cloud.pushsdk.constants.PushConstants;
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
import org.apache.thrift.meta_data.e;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.j;

public class i implements Serializable, Cloneable, org.apache.thrift.a<i, a> {
    public static final Map<a, b> m;
    private static final j n = new j("PushMetaInfo");
    private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b(DataBaseHelper.KEY_ID, (byte) 11, 1);
    private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("messageTs", (byte) 10, 2);
    private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("topic", (byte) 11, 3);
    private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b(PushConstants.TITLE, (byte) 11, 4);
    private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("description", (byte) 11, 5);
    private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("notifyType", (byte) 8, 6);
    private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b(PushConstants.WEB_URL, (byte) 11, 7);
    private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("passThrough", (byte) 8, 8);
    private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("notifyId", (byte) 8, 9);
    private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b(PushConstants.EXTRA, (byte) 13, 10);
    private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("internal", (byte) 13, 11);
    private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("ignoreRegInfo", (byte) 2, 12);
    private BitSet A;
    public String a;
    public long b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public int h;
    public int i;
    public Map<String, String> j;
    public Map<String, String> k;
    public boolean l;

    public enum a {
        ID(1, DataBaseHelper.KEY_ID),
        MESSAGE_TS(2, "messageTs"),
        TOPIC(3, "topic"),
        TITLE(4, PushConstants.TITLE),
        DESCRIPTION(5, "description"),
        NOTIFY_TYPE(6, "notifyType"),
        URL(7, PushConstants.WEB_URL),
        PASS_THROUGH(8, "passThrough"),
        NOTIFY_ID(9, "notifyId"),
        EXTRA(10, PushConstants.EXTRA),
        INTERNAL(11, "internal"),
        IGNORE_REG_INFO(12, "ignoreRegInfo");
        
        private static final Map<String, a> m = null;
        private final short n;
        private final String o;

        static {
            m = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                m.put(aVar.a(), aVar);
            }
        }

        private a(short s, String str) {
            this.n = s;
            this.o = str;
        }

        public String a() {
            return this.o;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.ID, new b(DataBaseHelper.KEY_ID, (byte) 1, new c((byte) 11)));
        enumMap.put(a.MESSAGE_TS, new b("messageTs", (byte) 1, new c((byte) 10)));
        enumMap.put(a.TOPIC, new b("topic", (byte) 2, new c((byte) 11)));
        enumMap.put(a.TITLE, new b(PushConstants.TITLE, (byte) 2, new c((byte) 11)));
        enumMap.put(a.DESCRIPTION, new b("description", (byte) 2, new c((byte) 11)));
        enumMap.put(a.NOTIFY_TYPE, new b("notifyType", (byte) 2, new c((byte) 8)));
        enumMap.put(a.URL, new b(PushConstants.WEB_URL, (byte) 2, new c((byte) 11)));
        enumMap.put(a.PASS_THROUGH, new b("passThrough", (byte) 2, new c((byte) 8)));
        enumMap.put(a.NOTIFY_ID, new b("notifyId", (byte) 2, new c((byte) 8)));
        enumMap.put(a.EXTRA, new b(PushConstants.EXTRA, (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.INTERNAL, new b("internal", (byte) 2, new e((byte) 13, new c((byte) 11), new c((byte) 11))));
        enumMap.put(a.IGNORE_REG_INFO, new b("ignoreRegInfo", (byte) 2, new c((byte) 2)));
        m = Collections.unmodifiableMap(enumMap);
        b.a(i.class, m);
    }

    public i() {
        this.A = new BitSet(5);
        this.l = false;
    }

    public i(i iVar) {
        this.A = new BitSet(5);
        this.A.clear();
        this.A.or(iVar.A);
        if (iVar.c()) {
            this.a = iVar.a;
        }
        this.b = iVar.b;
        if (iVar.g()) {
            this.c = iVar.c;
        }
        if (iVar.i()) {
            this.d = iVar.d;
        }
        if (iVar.k()) {
            this.e = iVar.e;
        }
        this.f = iVar.f;
        if (iVar.n()) {
            this.g = iVar.g;
        }
        this.h = iVar.h;
        this.i = iVar.i;
        if (iVar.t()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : iVar.j.entrySet()) {
                hashMap.put((String) next.getKey(), (String) next.getValue());
            }
            this.j = hashMap;
        }
        if (iVar.u()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry next2 : iVar.k.entrySet()) {
                hashMap2.put((String) next2.getKey(), (String) next2.getValue());
            }
            this.k = hashMap2;
        }
        this.l = iVar.l;
    }

    public i a() {
        return new i(this);
    }

    public i a(int i2) {
        this.f = i2;
        b(true);
        return this;
    }

    public i a(String str) {
        this.a = str;
        return this;
    }

    public i a(Map<String, String> map) {
        this.j = map;
        return this;
    }

    public void a(String str, String str2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        this.j.put(str, str2);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a5, code lost:
        r9.k();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.apache.thrift.protocol.e r9) {
        /*
            r8 = this;
            r9.f()
        L_0x0003:
            org.apache.thrift.protocol.b r0 = r9.h()
            byte r1 = r0.b
            if (r1 != 0) goto L_0x0033
            r9.g()
            boolean r9 = r8.e()
            if (r9 == 0) goto L_0x0018
            r8.x()
            return
        L_0x0018:
            org.apache.thrift.protocol.f r9 = new org.apache.thrift.protocol.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Required field 'messageTs' was not found in serialized data! Struct: "
            r0.append(r1)
            java.lang.String r1 = r8.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x0033:
            short r1 = r0.c
            r2 = 0
            r3 = 13
            r4 = 2
            r5 = 8
            r6 = 11
            r7 = 1
            switch(r1) {
                case 1: goto L_0x0110;
                case 2: goto L_0x0100;
                case 3: goto L_0x00f5;
                case 4: goto L_0x00ea;
                case 5: goto L_0x00df;
                case 6: goto L_0x00d1;
                case 7: goto L_0x00c6;
                case 8: goto L_0x00b8;
                case 9: goto L_0x00aa;
                case 10: goto L_0x007e;
                case 11: goto L_0x0057;
                case 12: goto L_0x0048;
                default: goto L_0x0041;
            }
        L_0x0041:
            byte r0 = r0.b
            org.apache.thrift.protocol.h.a(r9, r0)
            goto L_0x011a
        L_0x0048:
            byte r1 = r0.b
            if (r1 != r4) goto L_0x0041
            boolean r0 = r9.p()
            r8.l = r0
            r8.e(r7)
            goto L_0x011a
        L_0x0057:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0041
            org.apache.thrift.protocol.d r0 = r9.j()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.c
            int r3 = r3 * 2
            r1.<init>(r3)
            r8.k = r1
        L_0x006a:
            int r1 = r0.c
            if (r2 >= r1) goto L_0x00a5
            java.lang.String r1 = r9.v()
            java.lang.String r3 = r9.v()
            java.util.Map<java.lang.String, java.lang.String> r4 = r8.k
            r4.put(r1, r3)
            int r2 = r2 + 1
            goto L_0x006a
        L_0x007e:
            byte r1 = r0.b
            if (r1 != r3) goto L_0x0041
            org.apache.thrift.protocol.d r0 = r9.j()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.c
            int r3 = r3 * 2
            r1.<init>(r3)
            r8.j = r1
        L_0x0091:
            int r1 = r0.c
            if (r2 >= r1) goto L_0x00a5
            java.lang.String r1 = r9.v()
            java.lang.String r3 = r9.v()
            java.util.Map<java.lang.String, java.lang.String> r4 = r8.j
            r4.put(r1, r3)
            int r2 = r2 + 1
            goto L_0x0091
        L_0x00a5:
            r9.k()
            goto L_0x011a
        L_0x00aa:
            byte r1 = r0.b
            if (r1 != r5) goto L_0x0041
            int r0 = r9.s()
            r8.i = r0
            r8.d((boolean) r7)
            goto L_0x011a
        L_0x00b8:
            byte r1 = r0.b
            if (r1 != r5) goto L_0x0041
            int r0 = r9.s()
            r8.h = r0
            r8.c((boolean) r7)
            goto L_0x011a
        L_0x00c6:
            byte r1 = r0.b
            if (r1 != r6) goto L_0x0041
            java.lang.String r0 = r9.v()
            r8.g = r0
            goto L_0x011a
        L_0x00d1:
            byte r1 = r0.b
            if (r1 != r5) goto L_0x0041
            int r0 = r9.s()
            r8.f = r0
            r8.b((boolean) r7)
            goto L_0x011a
        L_0x00df:
            byte r1 = r0.b
            if (r1 != r6) goto L_0x0041
            java.lang.String r0 = r9.v()
            r8.e = r0
            goto L_0x011a
        L_0x00ea:
            byte r1 = r0.b
            if (r1 != r6) goto L_0x0041
            java.lang.String r0 = r9.v()
            r8.d = r0
            goto L_0x011a
        L_0x00f5:
            byte r1 = r0.b
            if (r1 != r6) goto L_0x0041
            java.lang.String r0 = r9.v()
            r8.c = r0
            goto L_0x011a
        L_0x0100:
            byte r1 = r0.b
            r2 = 10
            if (r1 != r2) goto L_0x0041
            long r0 = r9.t()
            r8.b = r0
            r8.a((boolean) r7)
            goto L_0x011a
        L_0x0110:
            byte r1 = r0.b
            if (r1 != r6) goto L_0x0041
            java.lang.String r0 = r9.v()
            r8.a = r0
        L_0x011a:
            r9.i()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.xmpush.thrift.i.a(org.apache.thrift.protocol.e):void");
    }

    public void a(boolean z2) {
        this.A.set(0, z2);
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iVar.c();
        if (((c2 || c3) && (!c2 || !c3 || !this.a.equals(iVar.a))) || this.b != iVar.b) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.c.equals(iVar.c))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.d.equals(iVar.d))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = iVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.e.equals(iVar.e))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = iVar.m();
        if ((m2 || m3) && (!m2 || !m3 || this.f != iVar.f)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = iVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.g.equals(iVar.g))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = iVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.h != iVar.h)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = iVar.r();
        if ((r2 || r3) && (!r2 || !r3 || this.i != iVar.i)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = iVar.t();
        if ((t2 || t3) && (!t2 || !t3 || !this.j.equals(iVar.j))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = iVar.u();
        if ((u2 || u3) && (!u2 || !u3 || !this.k.equals(iVar.k))) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = iVar.w();
        if (w2 || w3) {
            return w2 && w3 && this.l == iVar.l;
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(i iVar) {
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
        if (!getClass().equals(iVar.getClass())) {
            return getClass().getName().compareTo(iVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c() && (a13 = org.apache.thrift.b.a(this.a, iVar.a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iVar.e()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (e() && (a12 = org.apache.thrift.b.a(this.b, iVar.b)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iVar.g()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (g() && (a11 = org.apache.thrift.b.a(this.c, iVar.c)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iVar.i()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (i() && (a10 = org.apache.thrift.b.a(this.d, iVar.d)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iVar.k()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (k() && (a9 = org.apache.thrift.b.a(this.e, iVar.e)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(iVar.m()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m() && (a8 = org.apache.thrift.b.a(this.f, iVar.f)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(iVar.n()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (n() && (a7 = org.apache.thrift.b.a(this.g, iVar.g)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(iVar.p()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (p() && (a6 = org.apache.thrift.b.a(this.h, iVar.h)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(iVar.r()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (r() && (a5 = org.apache.thrift.b.a(this.i, iVar.i)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(iVar.t()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (t() && (a4 = org.apache.thrift.b.a((Map) this.j, (Map) iVar.j)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(iVar.u()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (u() && (a3 = org.apache.thrift.b.a((Map) this.k, (Map) iVar.k)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(iVar.w()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!w() || (a2 = org.apache.thrift.b.a(this.l, iVar.l)) == 0) {
            return 0;
        }
        return a2;
    }

    public i b(int i2) {
        this.h = i2;
        c(true);
        return this;
    }

    public i b(String str) {
        this.c = str;
        return this;
    }

    public String b() {
        return this.a;
    }

    public void b(org.apache.thrift.protocol.e eVar) {
        x();
        eVar.a(n);
        if (this.a != null) {
            eVar.a(o);
            eVar.a(this.a);
            eVar.b();
        }
        eVar.a(p);
        eVar.a(this.b);
        eVar.b();
        if (this.c != null && g()) {
            eVar.a(q);
            eVar.a(this.c);
            eVar.b();
        }
        if (this.d != null && i()) {
            eVar.a(r);
            eVar.a(this.d);
            eVar.b();
        }
        if (this.e != null && k()) {
            eVar.a(s);
            eVar.a(this.e);
            eVar.b();
        }
        if (m()) {
            eVar.a(t);
            eVar.a(this.f);
            eVar.b();
        }
        if (this.g != null && n()) {
            eVar.a(u);
            eVar.a(this.g);
            eVar.b();
        }
        if (p()) {
            eVar.a(v);
            eVar.a(this.h);
            eVar.b();
        }
        if (r()) {
            eVar.a(w);
            eVar.a(this.i);
            eVar.b();
        }
        if (this.j != null && t()) {
            eVar.a(x);
            eVar.a(new d((byte) 11, (byte) 11, this.j.size()));
            for (Map.Entry next : this.j.entrySet()) {
                eVar.a((String) next.getKey());
                eVar.a((String) next.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (this.k != null && u()) {
            eVar.a(y);
            eVar.a(new d((byte) 11, (byte) 11, this.k.size()));
            for (Map.Entry next2 : this.k.entrySet()) {
                eVar.a((String) next2.getKey());
                eVar.a((String) next2.getValue());
            }
            eVar.d();
            eVar.b();
        }
        if (w()) {
            eVar.a(z);
            eVar.a(this.l);
            eVar.b();
        }
        eVar.c();
        eVar.a();
    }

    public void b(boolean z2) {
        this.A.set(1, z2);
    }

    public i c(int i2) {
        this.i = i2;
        d(true);
        return this;
    }

    public i c(String str) {
        this.d = str;
        return this;
    }

    public void c(boolean z2) {
        this.A.set(2, z2);
    }

    public boolean c() {
        return this.a != null;
    }

    public long d() {
        return this.b;
    }

    public i d(String str) {
        this.e = str;
        return this;
    }

    public void d(boolean z2) {
        this.A.set(3, z2);
    }

    public void e(boolean z2) {
        this.A.set(4, z2);
    }

    public boolean e() {
        return this.A.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof i)) {
            return a((i) obj);
        }
        return false;
    }

    public String f() {
        return this.c;
    }

    public boolean g() {
        return this.c != null;
    }

    public String h() {
        return this.d;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.d != null;
    }

    public String j() {
        return this.e;
    }

    public boolean k() {
        return this.e != null;
    }

    public int l() {
        return this.f;
    }

    public boolean m() {
        return this.A.get(1);
    }

    public boolean n() {
        return this.g != null;
    }

    public int o() {
        return this.h;
    }

    public boolean p() {
        return this.A.get(2);
    }

    public int q() {
        return this.i;
    }

    public boolean r() {
        return this.A.get(3);
    }

    public Map<String, String> s() {
        return this.j;
    }

    public boolean t() {
        return this.j != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.b);
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.c;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f);
        }
        if (n()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.h);
        }
        if (r()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.i);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.j;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.k;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (w()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.l);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.k != null;
    }

    public boolean v() {
        return this.l;
    }

    public boolean w() {
        return this.A.get(4);
    }

    public void x() {
        if (this.a == null) {
            throw new f("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
