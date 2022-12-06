package com.xiaomi.smack.packet;

import android.os.Bundle;
import com.xiaomi.smack.util.g;

public class f extends d {
    private b c = b.available;
    private String d = null;
    private int e = Integer.MIN_VALUE;
    private a f = null;

    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public f(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_pres_type")) {
            this.c = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.d = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.e = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public f(b bVar) {
        a(bVar);
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (t() != null) {
            sb.append(" xmlns=\"");
            sb.append(t());
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" id=\"");
            sb.append(k());
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" to=\"");
            sb.append(g.a(m()));
            sb.append("\"");
        }
        if (n() != null) {
            sb.append(" from=\"");
            sb.append(g.a(n()));
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" chid=\"");
            sb.append(g.a(l()));
            sb.append("\"");
        }
        if (this.c != null) {
            sb.append(" type=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.d != null) {
            sb.append("<status>");
            sb.append(g.a(this.d));
            sb.append("</status>");
        }
        if (this.e != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.e);
            sb.append("</priority>");
        }
        a aVar = this.f;
        if (!(aVar == null || aVar == a.available)) {
            sb.append("<show>");
            sb.append(this.f);
            sb.append("</show>");
        }
        sb.append(s());
        h p = p();
        if (p != null) {
            sb.append(p.d());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    public void a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.e = i;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.c = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    public void a(String str) {
        this.d = str;
    }

    public Bundle c() {
        Bundle c2 = super.c();
        b bVar = this.c;
        if (bVar != null) {
            c2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.d;
        if (str != null) {
            c2.putString("ext_pres_status", str);
        }
        int i = this.e;
        if (i != Integer.MIN_VALUE) {
            c2.putInt("ext_pres_prio", i);
        }
        a aVar = this.f;
        if (!(aVar == null || aVar == a.available)) {
            c2.putString("ext_pres_mode", this.f.toString());
        }
        return c2;
    }
}
