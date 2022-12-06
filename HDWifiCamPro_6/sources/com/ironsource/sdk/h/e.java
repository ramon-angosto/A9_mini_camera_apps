package com.ironsource.sdk.h;

import org.json.JSONObject;

public final class e {
    public JSONObject a;

    public e(JSONObject jSONObject) {
        this.a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public final boolean a() {
        return this.a.optBoolean("useCacheDir", false);
    }
}
