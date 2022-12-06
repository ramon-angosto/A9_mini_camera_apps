package com.huawei.android.pushagent.plugin.a;

import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.tools.BLocation;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b {
    public abstract JSONObject a();

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(str, i);
            }
        } catch (JSONException e) {
            e.d(BLocation.TAG, "add json param error:" + e.getMessage());
        }
    }
}
