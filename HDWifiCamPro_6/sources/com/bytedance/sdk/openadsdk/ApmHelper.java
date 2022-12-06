package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.apm.insight.MonitorCrash;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.settings.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApmHelper {
    private static boolean a = false;
    private static String b;
    private static boolean c;

    public static void initApm(Context context, InitConfig initConfig) {
        if (!a) {
            j d = m.d();
            c = d.K();
            if (c && !TextUtils.isEmpty(d.z())) {
                b = initConfig.getAppId();
                String[] strArr = {"com.bytedance.sdk", "com.com.bytedance.overseas.sdk", "com.pgl.sys.ces", "com.bykv.vk"};
                String a2 = com.bytedance.sdk.openadsdk.core.j.a(context);
                String z = d.z();
                try {
                    MonitorCrash initSDK = MonitorCrash.initSDK(context, "10000001", 4806, BuildConfig.VERSION_NAME, strArr);
                    initSDK.config().setDeviceId(a2);
                    initSDK.setReportUrl(z);
                    initSDK.addTags("host_appid", b);
                    initSDK.addTags("sdk_version", BuildConfig.VERSION_NAME);
                    a = true;
                    b(a2, z);
                } catch (Throwable unused) {
                    l.d("ApmHelper", "init Apm fail or not include Apm module");
                    a = false;
                }
            }
        }
    }

    private static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            m.c().a(a(str), "https://" + str2 + "/monitor/collect/c/session?version_code=" + BuildConfig.VERSION_CODE + "&device_platform=android&aid=" + "10000001");
        }
    }

    private static void b(String str, String str2) {
        a(str, str2);
    }

    public static void reportPvFromBackGround() {
        if (c) {
            a(com.bytedance.sdk.openadsdk.core.j.a(m.a()), m.d().z());
        }
    }

    private static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject3.put("host_app_id", b);
            jSONObject2.putOpt("custom", jSONObject3);
            jSONObject2.put("os", "Android");
            jSONObject2.put("os_version", Build.VERSION.RELEASE);
            jSONObject2.put("device_model", Build.MODEL);
            jSONObject2.put("device_brand", Build.BRAND);
            jSONObject2.put("sdk_version_name", "0.0.5");
            jSONObject2.put("channel", "release");
            jSONObject2.put("aid", "10000001");
            jSONObject2.put("update_version_code", BuildConfig.VERSION_CODE);
            jSONObject2.put("bd_did", str);
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("local_time", Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("local_time_ms", System.currentTimeMillis()));
            jSONObject.putOpt("launch", jSONArray);
        } catch (JSONException e) {
            l.e("ApmHelper", e.getMessage());
        }
        return jSONObject;
    }

    public static boolean isIsInit() {
        return a;
    }
}
