package com.apm.insight.l;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l {
    public static int a(JSONObject jSONObject, int i, String... strArr) {
        JSONObject c = c(jSONObject, strArr);
        if (c == null) {
            return i;
        }
        int optInt = c.optInt(strArr[strArr.length - 1], i);
        q.a("JSONUtil", (Object) "normal get jsonInt: " + strArr[strArr.length - 1] + " : " + optInt);
        return optInt;
    }

    public static JSONArray a(int i, int i2, JSONArray jSONArray) {
        int i3 = i2 + i;
        if (jSONArray.length() <= i3) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i4 = 0; i4 < i; i4++) {
            jSONArray2.put(jSONArray.opt(i4));
        }
        while (i < i3) {
            jSONArray2.put(jSONArray.opt(jSONArray.length() - (i3 - i)));
            i++;
        }
        return jSONArray2;
    }

    public static JSONArray a(JSONObject jSONObject, String... strArr) {
        JSONObject c = c(jSONObject, strArr);
        if (c == null) {
            return null;
        }
        JSONArray optJSONArray = c.optJSONArray(strArr[strArr.length - 1]);
        q.a("ApmConfig", (Object) "normal get configArray: " + strArr[strArr.length - 1] + " : " + optJSONArray);
        return optJSONArray;
    }

    public static JSONArray a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : strArr) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                if (!jSONObject.has(next)) {
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (Throwable unused) {
                return;
            }
        }
    }

    public static boolean a(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return a(jSONObject) || a(jSONObject.optJSONArray(str));
    }

    public static String b(JSONObject jSONObject, String... strArr) {
        JSONObject c = c(jSONObject, strArr);
        if (c == null) {
            return null;
        }
        String optString = c.optString(strArr[strArr.length - 1]);
        q.a("ApmConfig", (Object) "normal get configArray: " + strArr[strArr.length - 1] + " : " + optString);
        return optString;
    }

    public static HashMap<String, Object> b(JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.opt(next));
        }
        return hashMap;
    }

    public static JSONObject c(JSONObject jSONObject, String... strArr) {
        if (jSONObject == null) {
            q.a("JSONUtil", "err get JsonFromParent: null json", new RuntimeException());
            return null;
        }
        for (int i = 0; i < strArr.length - 1; i++) {
            jSONObject = jSONObject.optJSONObject(strArr[i]);
            if (jSONObject == null) {
                q.a("JSONUtil", (Object) "err get json: not found node:" + strArr[i]);
                return null;
            }
        }
        return jSONObject;
    }
}
