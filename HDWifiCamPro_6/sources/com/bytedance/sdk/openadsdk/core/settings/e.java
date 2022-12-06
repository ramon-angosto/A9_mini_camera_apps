package com.bytedance.sdk.openadsdk.core.settings;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JsConfiglInfo */
public class e {
    public static final e a = new e((String) null);
    public String b = "https://sf16-scmcdn-sg.ibytedtos.com/goofy/bytecom/resource/tetris/oversea_pi.01f77b3a.js";
    public boolean c = true;

    public e(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("performance_js");
            this.b = optJSONObject.optString("url", "https://sf16-scmcdn-sg.ibytedtos.com/goofy/bytecom/resource/tetris/oversea_pi.01f77b3a.js");
            JSONArray optJSONArray = optJSONObject.optJSONArray("execute_time");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            this.c = arrayList.contains("load_finish");
        } catch (Exception unused) {
        }
    }
}
