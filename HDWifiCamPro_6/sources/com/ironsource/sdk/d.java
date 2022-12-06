package com.ironsource.sdk;

import com.ironsource.sdk.g.d;
import org.json.JSONObject;

public final class d {
    private static String a = "ManRewInst_";

    public static String a() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String a(b bVar) {
        return (bVar.a() ? d.e.Banner : bVar.a ? d.e.RewardedVideo : d.e.Interstitial).toString();
    }

    public static String a(JSONObject jSONObject) {
        if (!jSONObject.optBoolean("rewarded")) {
            return jSONObject.optString("name");
        }
        return a + jSONObject.optString("name");
    }
}
