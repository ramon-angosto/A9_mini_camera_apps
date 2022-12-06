package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import com.bytedance.sdk.openadsdk.h.b;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AppEnvironment */
public class d {
    private static volatile d a;
    /* access modifiers changed from: private */
    public long b = a.a("tt_sp_app_env", "last_app_env_time", 0);
    /* access modifiers changed from: private */
    public boolean c = false;

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public void b() {
        if (!this.c && !y.a(this.b, System.currentTimeMillis())) {
            this.c = true;
            b.a().a((com.bytedance.sdk.openadsdk.h.a) new com.bytedance.sdk.openadsdk.h.a() {
                public com.bytedance.sdk.openadsdk.h.a.a a() throws Exception {
                    JSONObject a2 = d.this.c();
                    if (a2 == null) {
                        return null;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    long unused = d.this.b = currentTimeMillis;
                    a.a("tt_sp_app_env", "last_app_env_time", Long.valueOf(currentTimeMillis));
                    com.bytedance.sdk.openadsdk.h.a.b b = com.bytedance.sdk.openadsdk.h.a.b.b().a("app_env").b(a2.toString());
                    boolean unused2 = d.this.c = false;
                    return b;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context a2 = m.a();
            if (a2 == null) {
                return null;
            }
            PackageInfo packageInfo = a2.getPackageManager().getPackageInfo(a2.getPackageName(), 4111);
            ApplicationInfo applicationInfo = a2.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                String[] strArr = packageInfo.requestedPermissions;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray2.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray2);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray3.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray3);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray4.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray4);
                }
                if (strArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (String put : strArr) {
                        jSONArray5.put(put);
                    }
                    jSONObject.put("permissions", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
