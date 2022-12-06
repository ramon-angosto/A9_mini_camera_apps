package com.bytedance.sdk.openadsdk.core.d;

import android.content.Context;
import com.bytedance.sdk.component.f.a.a;
import com.bytedance.sdk.component.f.b;
import com.bytedance.sdk.component.f.b.d;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.l.y;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FrequentCallEventHelper */
public class c {
    public static void a(Context context, String str, long j) {
        JSONObject a = a(str, j);
        d b = com.bytedance.sdk.openadsdk.i.d.a().b().b();
        b.a(y.d("/api/ad/union/sdk/stats/"));
        b.c(a.toString());
        b.a((a) new a() {
            public void a(com.bytedance.sdk.component.f.b.c cVar, b bVar) {
            }

            public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                l.c("uploadFrequentEvent", iOException.getMessage());
            }
        });
    }

    private static JSONObject a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("timestamp", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
