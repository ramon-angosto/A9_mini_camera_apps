package com.ironsource.sdk.c;

import com.ironsource.sdk.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class d {
    public static final String a = d.class.getSimpleName();
    private static d c = null;
    public Map<String, e> b = Collections.synchronizedMap(new HashMap());

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (c == null) {
                c = new d();
            }
            dVar = c;
        }
        return dVar;
    }

    public static String a(JSONObject jSONObject) {
        return (jSONObject == null || !jSONObject.has("adViewId")) ? (jSONObject == null || !jSONObject.has("params")) ? "" : new JSONObject(jSONObject.getString("params")).getString("adViewId") : jSONObject.getString("adViewId");
    }

    public static boolean b(JSONObject jSONObject) {
        try {
            return jSONObject.getBoolean("shouldCreateContainer");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static a d(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("adSize"));
            String obj = jSONObject2.get("height").toString();
            String obj2 = jSONObject2.get("width").toString();
            return new a(Integer.parseInt(obj2), Integer.parseInt(obj), jSONObject2.get("label").toString());
        } catch (Exception unused) {
            return new a();
        }
    }

    public final e a(String str) {
        if (str.isEmpty() || !this.b.containsKey(str)) {
            return null;
        }
        return this.b.get(str);
    }

    public a c(JSONObject jSONObject) {
        a aVar = new a();
        try {
            return d(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
            return aVar;
        }
    }
}
