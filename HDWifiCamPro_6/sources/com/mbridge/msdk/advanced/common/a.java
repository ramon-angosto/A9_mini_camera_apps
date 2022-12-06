package com.mbridge.msdk.advanced.common;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.u;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceInfo */
public final class a {
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

    public a(Context context) {
        int n = m.n(context);
        this.e = String.valueOf(n);
        this.f = m.a(context, n);
        this.g = m.m(context);
        this.h = com.mbridge.msdk.foundation.controller.a.e().i();
        this.i = com.mbridge.msdk.foundation.controller.a.e().h();
        this.j = String.valueOf(u.h(context));
        this.k = String.valueOf(u.g(context));
        this.m = String.valueOf(u.d(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.l = "landscape";
        } else {
            this.l = "portrait";
        }
    }

    public final JSONObject a() {
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
            jSONObject.put("scale", this.m);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
