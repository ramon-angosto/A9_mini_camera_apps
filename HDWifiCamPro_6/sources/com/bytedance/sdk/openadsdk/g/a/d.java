package com.bytedance.sdk.openadsdk.g.a;

import com.bytedance.sdk.component.a.e;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.u;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InteractiveFinishMethod */
public class d extends e<JSONObject, JSONObject> {
    private WeakReference<u> a;

    public static void a(r rVar, u uVar) {
        rVar.a("interactiveFinish", (e<?, ?>) new d(uVar));
    }

    public JSONObject a(JSONObject jSONObject, f fVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<u> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            u uVar = (u) this.a.get();
            n c = uVar.c();
            boolean z = true;
            try {
                if (jSONObject.optInt("finish", 1) != 1) {
                    z = false;
                }
                int i = -1;
                int optInt = jSONObject.optInt("reduce_duration", -1);
                int aA = c != null ? c.aA() : 0;
                if (optInt >= 0 && aA >= 0) {
                    optInt = Math.min(optInt, aA);
                } else if (optInt < 0) {
                    optInt = aA >= 0 ? aA : 0;
                }
                if (z) {
                    uVar.c(optInt);
                    i = 0;
                }
                jSONObject2.put("code", i);
                jSONObject2.put("reduce_duration", optInt);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject2;
    }

    public d(u uVar) {
        this.a = new WeakReference<>(uVar);
    }
}
