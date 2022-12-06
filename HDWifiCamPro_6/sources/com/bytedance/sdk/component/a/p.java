package com.bytedance.sdk.component.a;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Java2JsMsg */
public final class p {
    private final Map<String, Object> a = new ConcurrentHashMap();

    public static p a() {
        return new p();
    }

    private p() {
    }

    public p a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.a.put(str, obj);
        }
        return this;
    }

    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.a.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
