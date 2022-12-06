package com.bytedance.sdk.component.adexpress.dynamic.c;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DiffUtils */
public class c {
    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject2 == null || jSONObject2.length() <= 0 || jSONObject == null) {
            return jSONObject;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                Object opt2 = jSONObject2.opt(next);
                if (opt2 == null) {
                    jSONObject3.put(next, opt);
                } else if ((opt instanceof JSONObject) && (opt2 instanceof JSONObject)) {
                    jSONObject3.put(next, a((JSONObject) opt, (JSONObject) opt2));
                } else if (!(opt instanceof JSONArray) || !(opt2 instanceof JSONArray)) {
                    jSONObject3.put(next, opt2);
                } else {
                    jSONObject3.put(next, a((JSONArray) opt, (JSONArray) opt2));
                }
            }
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (!jSONObject.has(next2)) {
                    jSONObject3.put(next2, jSONObject2.opt(next2));
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject3;
    }

    private static JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray2 == null || jSONArray2.length() <= 0) {
            return jSONArray;
        }
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        JSONArray jSONArray3 = new JSONArray();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                Object opt = jSONArray.opt(i);
                Object opt2 = jSONArray2.opt(i);
                if (opt2 == null) {
                    jSONArray3.put(i, opt);
                } else if ((opt instanceof JSONObject) && (opt2 instanceof JSONObject)) {
                    jSONArray3.put(i, a((JSONObject) opt, (JSONObject) opt2));
                } else if (!(opt instanceof JSONArray) || !(opt2 instanceof JSONArray)) {
                    jSONArray3.put(i, opt2);
                } else {
                    jSONArray3.put(i, a((JSONArray) opt, (JSONArray) opt2));
                }
                i++;
            } catch (JSONException unused) {
            }
        }
        return jSONArray3;
    }
}
