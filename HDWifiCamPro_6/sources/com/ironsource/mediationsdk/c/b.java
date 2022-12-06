package com.ironsource.mediationsdk.c;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.e;
import com.ironsource.mediationsdk.utils.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private String a;
    private String b;
    private e c;

    public b(String str, String str2, e eVar) {
        this.a = str;
        this.b = str2;
        this.c = eVar;
    }

    private static Object a(Object obj) {
        return obj instanceof JSONObject ? a((JSONObject) obj) : obj instanceof JSONArray ? a((JSONArray) obj) : obj;
    }

    private static List<Object> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(a(jSONArray.get(i)));
            } catch (JSONException e) {
                IronLog.INTERNAL.error(String.format("Could not put value into list: %s", new Object[]{e.getMessage()}));
            }
        }
        return arrayList;
    }

    public static Map<String, Object> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, a(jSONObject.get(next)));
            } catch (JSONException e) {
                IronLog.INTERNAL.error(String.format("Could not put value in map: %s, %s", new Object[]{next, e.getMessage()}));
            }
        }
        return hashMap;
    }

    public static JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                try {
                    jSONObject.put((String) next.getKey(), b(next.getValue()));
                } catch (JSONException unused) {
                    IronLog.INTERNAL.error(String.format("Could not map entry to object: %s, %s", new Object[]{next.getKey(), next.getValue()}));
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < 2; i++) {
            JSONObject jSONObject2 = jSONObjectArr[i];
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        jSONObject.put(next, jSONObject2.get(next));
                    } catch (JSONException e) {
                        IronLog.INTERNAL.error(e.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    private static Object b(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return new JSONArray(Arrays.asList(new Object[]{obj}));
            } else if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            } else {
                if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
                    return obj;
                }
                if (obj instanceof Enum) {
                    return obj.toString();
                }
                if (obj.getClass().getPackage().getName().startsWith("java.")) {
                    return obj.toString();
                }
                return null;
            }
        } catch (Exception unused) {
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.c.g.e > 0;
    }

    public long d() {
        return this.c.g.i;
    }

    public int e() {
        return this.c.f;
    }

    public long f() {
        return this.c.b;
    }

    public int g() {
        return this.c.e;
    }

    public c h() {
        return this.c.g;
    }
}
