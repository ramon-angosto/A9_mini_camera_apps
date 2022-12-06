package com.apm.insight.l;

import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.entity.a;
import com.apm.insight.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class s {
    public static void a(a aVar, Header header, CrashType crashType) {
        if (aVar != null) {
            a(aVar.h(), header, crashType);
        }
    }

    public static void a(JSONObject jSONObject, Header header, CrashType crashType) {
        if (jSONObject != null && crashType != null) {
            long optLong = jSONObject.optLong("crash_time");
            String a = h.c().a();
            if (optLong > 0 && !TextUtils.isEmpty(crashType.getName())) {
                try {
                    String str = "android__" + a + "_" + optLong + "_" + crashType;
                    if (header != null) {
                        jSONObject = header.f();
                        if (jSONObject == null) {
                            return;
                        }
                    }
                    jSONObject.put("unique_key", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
