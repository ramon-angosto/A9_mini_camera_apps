package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AutoTestModel */
public class e {
    private String a = "";
    private List<String> b = new ArrayList();

    public e(String str) {
        HashMap<String, Object> hashMap = TextUtils.isEmpty(str) ? new HashMap<>() : a(str);
        try {
            this.a = (String) hashMap.get("auto_test_param");
            JSONArray jSONArray = new JSONArray((String) hashMap.get("auto_test_hosts"));
            this.b = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.b.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String a() {
        return this.a;
    }

    public List<String> b() {
        return this.b;
    }

    private static final HashMap<String, Object> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                hashMap.put(optJSONObject.optString("name"), optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE));
            }
            return hashMap;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }
}
