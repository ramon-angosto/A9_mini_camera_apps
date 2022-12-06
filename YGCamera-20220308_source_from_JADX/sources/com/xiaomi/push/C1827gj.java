package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.gj */
public class C1827gj extends C1830gl {

    /* renamed from: a */
    private C1828a f2497a = C1828a.f2499a;

    /* renamed from: a */
    private final Map<String, String> f2498a = new HashMap();

    /* renamed from: com.xiaomi.push.gj$a */
    public static class C1828a {

        /* renamed from: a */
        public static final C1828a f2499a = new C1828a("get");

        /* renamed from: b */
        public static final C1828a f2500b = new C1828a("set");

        /* renamed from: c */
        public static final C1828a f2501c = new C1828a("result");

        /* renamed from: d */
        public static final C1828a f2502d = new C1828a("error");

        /* renamed from: e */
        public static final C1828a f2503e = new C1828a("command");

        /* renamed from: a */
        private String f2504a;

        private C1828a(String str) {
            this.f2504a = str;
        }

        /* renamed from: a */
        public static C1828a m3724a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f2499a.toString().equals(lowerCase)) {
                return f2499a;
            }
            if (f2500b.toString().equals(lowerCase)) {
                return f2500b;
            }
            if (f2502d.toString().equals(lowerCase)) {
                return f2502d;
            }
            if (f2501c.toString().equals(lowerCase)) {
                return f2501c;
            }
            if (f2503e.toString().equals(lowerCase)) {
                return f2503e;
            }
            return null;
        }

        public String toString() {
            return this.f2504a;
        }
    }

    public C1827gj() {
    }

    public C1827gj(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.f2497a = C1828a.m3724a(bundle.getString("ext_iq_type"));
        }
    }

    /* renamed from: a */
    public Bundle mo17698a() {
        Bundle a = super.mo17698a();
        C1828a aVar = this.f2497a;
        if (aVar != null) {
            a.putString("ext_iq_type", aVar.toString());
        }
        return a;
    }

    /* renamed from: a */
    public C1828a m3719a() {
        return this.f2497a;
    }

    /* renamed from: a */
    public String m3720a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (mo17726j() != null) {
            sb.append("id=\"" + mo17726j() + "\" ");
        }
        if (mo17729l() != null) {
            sb.append("to=\"");
            sb.append(C1844gw.m3801a(mo17729l()));
            sb.append("\" ");
        }
        if (mo17731m() != null) {
            sb.append("from=\"");
            sb.append(C1844gw.m3801a(mo17731m()));
            sb.append("\" ");
        }
        if (mo17727k() != null) {
            sb.append("chid=\"");
            sb.append(C1844gw.m3801a(mo17727k()));
            sb.append("\" ");
        }
        for (Map.Entry next : this.f2498a.entrySet()) {
            sb.append(C1844gw.m3801a((String) next.getKey()));
            sb.append("=\"");
            sb.append(C1844gw.m3801a((String) next.getValue()));
            sb.append("\" ");
        }
        if (this.f2497a == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(mo17698a());
            str = "\">";
        }
        sb.append(str);
        String b = mo17701b();
        if (b != null) {
            sb.append(b);
        }
        sb.append(mo17735o());
        C1836gp a = mo17698a();
        if (a != null) {
            sb.append(a.mo17742a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo17699a(C1828a aVar) {
        if (aVar == null) {
            aVar = C1828a.f2499a;
        }
        this.f2497a = aVar;
    }

    /* renamed from: a */
    public synchronized void mo17700a(Map<String, String> map) {
        this.f2498a.putAll(map);
    }

    /* renamed from: b */
    public String mo17701b() {
        return null;
    }
}
