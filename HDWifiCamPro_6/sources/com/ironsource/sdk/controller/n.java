package com.ironsource.sdk.controller;

import org.json.JSONException;
import org.json.JSONObject;

public final class n {
    String a;
    JSONObject b;
    String c;
    String d;

    public n(JSONObject jSONObject) {
        this.a = jSONObject.optString("functionName");
        this.b = jSONObject.optJSONObject("functionParams");
        this.c = jSONObject.optString("success");
        this.d = jSONObject.optString("fail");
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("functionName", this.a);
            jSONObject.put("functionParams", this.b);
            jSONObject.put("success", this.c);
            jSONObject.put("fail", this.d);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
