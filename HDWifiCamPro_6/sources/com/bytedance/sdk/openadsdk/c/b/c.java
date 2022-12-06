package com.bytedance.sdk.openadsdk.c.b;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EventStartListenerWrapper */
public class c implements b {
    b a;

    public void a(JSONObject jSONObject, long j) throws JSONException {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(jSONObject, j);
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        jSONObject.put("event_ts", j);
    }
}
