package com.xiaomi.push;

import android.os.Bundle;

/* renamed from: com.xiaomi.push.gn */
public class C1832gn extends C1830gl {

    /* renamed from: a */
    private int f2532a = Integer.MIN_VALUE;

    /* renamed from: a */
    private C1833a f2533a = null;

    /* renamed from: a */
    private C1834b f2534a = C1834b.available;

    /* renamed from: b */
    private String f2535b = null;

    /* renamed from: com.xiaomi.push.gn$a */
    public enum C1833a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* renamed from: com.xiaomi.push.gn$b */
    public enum C1834b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public C1832gn(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_pres_type")) {
            this.f2534a = C1834b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f2535b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f2532a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f2533a = C1833a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public C1832gn(C1834b bVar) {
        mo17740a(bVar);
    }

    /* renamed from: a */
    public Bundle mo17698a() {
        Bundle a = super.mo17698a();
        C1834b bVar = this.f2534a;
        if (bVar != null) {
            a.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f2535b;
        if (str != null) {
            a.putString("ext_pres_status", str);
        }
        int i = this.f2532a;
        if (i != Integer.MIN_VALUE) {
            a.putInt("ext_pres_prio", i);
        }
        C1833a aVar = this.f2533a;
        if (!(aVar == null || aVar == C1833a.available)) {
            a.putString("ext_pres_mode", this.f2533a.toString());
        }
        return a;
    }

    /* renamed from: a */
    public String m3773a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (mo17737p() != null) {
            sb.append(" xmlns=\"");
            sb.append(mo17737p());
            sb.append("\"");
        }
        if (mo17726j() != null) {
            sb.append(" id=\"");
            sb.append(mo17726j());
            sb.append("\"");
        }
        if (mo17729l() != null) {
            sb.append(" to=\"");
            sb.append(C1844gw.m3801a(mo17729l()));
            sb.append("\"");
        }
        if (mo17731m() != null) {
            sb.append(" from=\"");
            sb.append(C1844gw.m3801a(mo17731m()));
            sb.append("\"");
        }
        if (mo17727k() != null) {
            sb.append(" chid=\"");
            sb.append(C1844gw.m3801a(mo17727k()));
            sb.append("\"");
        }
        if (this.f2534a != null) {
            sb.append(" type=\"");
            sb.append(this.f2534a);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f2535b != null) {
            sb.append("<status>");
            sb.append(C1844gw.m3801a(this.f2535b));
            sb.append("</status>");
        }
        if (this.f2532a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.f2532a);
            sb.append("</priority>");
        }
        C1833a aVar = this.f2533a;
        if (!(aVar == null || aVar == C1833a.available)) {
            sb.append("<show>");
            sb.append(this.f2533a);
            sb.append("</show>");
        }
        sb.append(mo17735o());
        C1836gp a = mo17698a();
        if (a != null) {
            sb.append(a.mo17742a());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo17738a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
        }
        this.f2532a = i;
    }

    /* renamed from: a */
    public void mo17739a(C1833a aVar) {
        this.f2533a = aVar;
    }

    /* renamed from: a */
    public void mo17740a(C1834b bVar) {
        if (bVar != null) {
            this.f2534a = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    /* renamed from: a */
    public void mo17703a(String str) {
        this.f2535b = str;
    }
}
