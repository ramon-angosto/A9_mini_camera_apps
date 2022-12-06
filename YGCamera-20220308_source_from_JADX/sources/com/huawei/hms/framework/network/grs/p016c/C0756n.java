package com.huawei.hms.framework.network.grs.p016c;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.c.n */
public class C0756n {
    /* renamed from: a */
    public static String m636a(String str, String str2) {
        return !str.equals(str2) ? m637b(str, str2) : str;
    }

    /* renamed from: b */
    private static String m637b(String str, String str2) {
        HashSet<String> hashSet = new HashSet<>();
        if (!TextUtils.isEmpty(str)) {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("services");
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(jSONArray.getString(i));
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            JSONArray jSONArray2 = new JSONObject(str2).getJSONArray("services");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                hashSet.add(jSONArray2.getString(i2));
            }
        }
        if (hashSet.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray3 = new JSONArray();
        for (String put : hashSet) {
            jSONArray3.put(put);
        }
        jSONObject.put("services", jSONArray3);
        return jSONObject.toString();
    }
}
