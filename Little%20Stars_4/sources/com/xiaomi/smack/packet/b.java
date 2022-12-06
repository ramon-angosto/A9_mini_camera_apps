package com.xiaomi.smack.packet;

import android.os.Bundle;
import com.xiaomi.smack.util.g;
import java.util.HashMap;
import java.util.Map;

public class b extends d {
    private a c = a.a;
    private final Map<String, String> d = new HashMap();

    public static class a {
        public static final a a = new a("get");
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a("error");
        public static final a e = new a("command");
        private String f;

        private a(String str) {
            this.f = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (a.toString().equals(lowerCase)) {
                return a;
            }
            if (b.toString().equals(lowerCase)) {
                return b;
            }
            if (d.toString().equals(lowerCase)) {
                return d;
            }
            if (c.toString().equals(lowerCase)) {
                return c;
            }
            if (e.toString().equals(lowerCase)) {
                return e;
            }
            return null;
        }

        public String toString() {
            return this.f;
        }
    }

    public b() {
    }

    public b(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.c = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (k() != null) {
            sb.append("id=\"" + k() + "\" ");
        }
        if (m() != null) {
            sb.append("to=\"");
            sb.append(g.a(m()));
            sb.append("\" ");
        }
        if (n() != null) {
            sb.append("from=\"");
            sb.append(g.a(n()));
            sb.append("\" ");
        }
        if (l() != null) {
            sb.append("chid=\"");
            sb.append(g.a(l()));
            sb.append("\" ");
        }
        for (Map.Entry next : this.d.entrySet()) {
            sb.append(g.a((String) next.getKey()));
            sb.append("=\"");
            sb.append(g.a((String) next.getValue()));
            sb.append("\" ");
        }
        if (this.c == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(b());
            str = "\">";
        }
        sb.append(str);
        String d2 = d();
        if (d2 != null) {
            sb.append(d2);
        }
        sb.append(s());
        h p = p();
        if (p != null) {
            sb.append(p.d());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public synchronized String a(String str) {
        return this.d.get(str);
    }

    public void a(a aVar) {
        if (aVar == null) {
            aVar = a.a;
        }
        this.c = aVar;
    }

    public synchronized void a(String str, String str2) {
        this.d.put(str, str2);
    }

    public synchronized void a(Map<String, String> map) {
        this.d.putAll(map);
    }

    public a b() {
        return this.c;
    }

    public Bundle c() {
        Bundle c2 = super.c();
        a aVar = this.c;
        if (aVar != null) {
            c2.putString("ext_iq_type", aVar.toString());
        }
        return c2;
    }

    public String d() {
        return null;
    }
}
