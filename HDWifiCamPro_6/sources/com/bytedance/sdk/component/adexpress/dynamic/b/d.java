package com.bytedance.sdk.component.adexpress.dynamic.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DynamicDiffPlugin */
public class d {
    public List<a> a;
    public String b;
    public String c;
    public String d;

    /* compiled from: DynamicDiffPlugin */
    public static class a {
        public int a;
        public JSONObject b;
    }

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        String optString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.a = optJSONObject.optInt("id");
                    aVar.b = new JSONObject(optJSONObject.optString("componentLayout"));
                    arrayList.add(aVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dVar.a = arrayList;
        dVar.b = jSONObject.optString("diff_data");
        dVar.c = jSONObject.optString("style_diff");
        dVar.d = jSONObject.optString("tag_diff");
        return dVar;
    }
}
