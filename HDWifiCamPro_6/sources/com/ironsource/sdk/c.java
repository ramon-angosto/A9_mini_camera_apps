package com.ironsource.sdk;

import com.ironsource.sdk.j.a;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public boolean a = false;
    public boolean b = false;
    public a c = null;
    public Map<String, String> d;
    private String e;
    private final a f;

    public c(String str, a aVar) {
        this.e = SDKUtils.requireNonEmptyOrNull(str, "Instance name can't be null");
        this.f = (a) SDKUtils.requireNonNull(aVar, "AdListener name can't be null");
    }

    public final b a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.e);
            jSONObject.put("rewarded", this.a);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new b(this.b ? d.a() : d.a(jSONObject), this.e, this.a, this.b, this.d, this.f, this.c);
    }
}
