package com.bytedance.sdk.openadsdk.k.a;

import org.json.JSONObject;

/* compiled from: PAGAdViewInfo */
public class a {
    private final int a;
    private final int b;
    private final float c;

    public a(int i, int i2, float f) {
        this.a = i;
        this.b = i2;
        this.c = f;
    }

    public static JSONObject a(a aVar) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", aVar.a);
        jSONObject.put("height", aVar.b);
        jSONObject.put("alpha", (double) aVar.c);
        return jSONObject;
    }
}
