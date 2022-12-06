package com.ironsource.sdk.service;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.environment.h;
import com.ironsource.environment.k;
import com.ironsource.mediationsdk.adunit.a.a;
import com.ironsource.sdk.utils.IronSourceQaProperties;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private a a = new a();

    public final void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("omv", com.ironsource.sdk.e.a.a.a);
        hashMap.put("ompv", "7");
        a.a((Map<String, Object>) hashMap);
    }

    public final void a(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (Build.VERSION.SDK_INT >= 19) {
                a.a("imm", (Object) Boolean.valueOf(h.a(activity)));
            }
        }
    }

    public final void b() {
        String controllerConfig = SDKUtils.getControllerConfig();
        if (!TextUtils.isEmpty(controllerConfig)) {
            try {
                a.a("cncdn", new JSONObject(controllerConfig).opt("chinaCDN"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void b(Context context) {
        a.a("gpi", (Object) Boolean.valueOf(k.a(context)));
    }

    public final void c() {
        JSONObject jSONObject = new JSONObject(IronSourceQaProperties.getInstance().getParameters());
        if (jSONObject.length() > 0) {
            a.a("debug", jSONObject);
        }
    }
}
