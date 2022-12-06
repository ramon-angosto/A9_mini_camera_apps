package com.bytedance.sdk.openadsdk.core.e;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.openadsdk.core.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SecSdkHelperUtil */
public class c {
    private static boolean a = false;

    public static void a() {
        if (!a && m.d().L()) {
            b.a();
            a = b.a().b();
        }
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str) && m.d().L()) {
            b.a().a(str);
        }
    }

    public static String b() {
        if (m.d().L()) {
            return b.a().c();
        }
        return null;
    }

    public static void c() {
        if (m.d().L()) {
            b.a().b("AdShow");
        }
    }

    public static Map<String, String> a(String str, String str2) {
        if (!m.d().L()) {
            return new HashMap();
        }
        return b.a().a(str, str2 != null ? str2.getBytes() : new byte[0]);
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null && m.d().L()) {
            try {
                jSONObject.put("sec_did", b.a().d());
                String a2 = e.a(jSONObject.toString());
                Map<String, String> a3 = b.a().a("https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250", a2 != null ? a2.getBytes() : new byte[0]);
                if (a3 != null && a3.size() > 0) {
                    for (String next : a3.keySet()) {
                        jSONObject.put(next, a3.get(next));
                    }
                    jSONObject.put("url", "https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250");
                    jSONObject.put("pangle_m", a2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String d() {
        if (m.d().L()) {
            return b.a().d();
        }
        return null;
    }
}
