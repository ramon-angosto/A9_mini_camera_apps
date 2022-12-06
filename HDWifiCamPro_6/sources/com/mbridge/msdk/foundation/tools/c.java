package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DomainDeviceInfo */
public class c {
    public String a = m.b();
    public String b = m.f();
    public String c = "android";
    public String d = m.i();
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;

    public c(Context context) {
        int n2 = m.n(context);
        this.e = String.valueOf(n2);
        this.f = m.a(context, n2);
        this.g = m.m(context);
        this.h = a.e().i();
        this.i = a.e().h();
        this.j = String.valueOf(u.h(context));
        this.k = String.valueOf(u.g(context));
        this.o = String.valueOf(u.d(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.l = "landscape";
        } else {
            this.l = "portrait";
        }
        this.m = com.mbridge.msdk.foundation.same.a.k;
        this.n = com.mbridge.msdk.foundation.same.a.l;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.a);
                jSONObject.put("system_version", this.b);
                jSONObject.put("network_type", this.e);
                jSONObject.put("network_type_str", this.f);
                jSONObject.put("device_ua", this.g);
            }
            jSONObject.put("plantform", this.c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.d);
            }
            jSONObject.put("appkey", this.h);
            jSONObject.put("appId", this.i);
            jSONObject.put("screen_width", this.j);
            jSONObject.put("screen_height", this.k);
            jSONObject.put("orientation", this.l);
            jSONObject.put("scale", this.o);
            jSONObject.put("b", this.m);
            jSONObject.put("c", this.n);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
