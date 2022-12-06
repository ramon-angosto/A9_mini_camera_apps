package com.huawei.android.pushselfshow.richpush.html.api;

import android.app.Activity;
import android.content.Intent;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.html.a.a;
import com.huawei.android.pushselfshow.richpush.html.a.d;
import com.huawei.android.pushselfshow.richpush.html.a.f;
import com.huawei.android.pushselfshow.richpush.html.a.h;
import com.huawei.android.pushselfshow.richpush.html.a.i;
import com.huawei.android.pushselfshow.richpush.html.a.j;
import com.huawei.android.pushselfshow.richpush.html.a.k;
import com.huawei.android.pushselfshow.richpush.html.api.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public HashMap a = new HashMap();

    public c(Activity activity, boolean z) {
        try {
            this.a.clear();
            this.a.put("Audio", new f(activity));
            this.a.put("Video", new k(activity));
            this.a.put("App", new d(activity));
            this.a.put("Geo", new j(activity));
            this.a.put("Accelerometer", new a(activity));
            this.a.put("Device", new i(activity, z));
        } catch (Exception e) {
            e.c("PluginManager", e.toString(), e);
        }
    }

    public String a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (jSONObject2.has("method")) {
                String string = jSONObject2.getString("method");
                e.a("PluginManager", "method is " + string);
                if (jSONObject2.has("options")) {
                    jSONObject = jSONObject2.getJSONObject("options");
                }
                if (!this.a.containsKey(str)) {
                    return d.a(d.a.SERVICE_NOT_FOUND_EXCEPTION).toString();
                }
                e.a("PluginManager", "plugins.containsKey(" + str + ") ");
                return ((h) this.a.get(str)).a(string, jSONObject);
            }
            e.a("PluginManager", "method is null");
            return d.a(d.a.METHOD_NOT_FOUND_EXCEPTION).toString();
        } catch (JSONException unused) {
            return d.a(d.a.JSON_EXCEPTION).toString();
        }
    }

    public void a() {
        for (Map.Entry entry : this.a.entrySet()) {
            e.e("PluginManager", "call plugin: " + ((String) entry.getKey()) + " reset");
            ((h) entry.getValue()).d();
        }
    }

    public void a(int i, int i2, Intent intent) {
        for (Map.Entry entry : this.a.entrySet()) {
            e.e("PluginManager", "call plugin: " + ((String) entry.getKey()) + " reset");
            ((h) entry.getValue()).a(i, i2, intent);
        }
    }

    public void a(String str, String str2, NativeToJsMessageQueue nativeToJsMessageQueue) {
        String str3;
        if (nativeToJsMessageQueue == null) {
            e.a("PluginManager", "plugin.exec,jsMessageQueue is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (jSONObject2.has("callbackId")) {
                str3 = jSONObject2.getString("callbackId");
                try {
                    e.a("PluginManager", "callbackId is " + str3);
                } catch (JSONException unused) {
                    nativeToJsMessageQueue.a(str3, d.a.JSON_EXCEPTION, "error", (JSONObject) null);
                }
            } else {
                str3 = null;
            }
            if (jSONObject2.has("method")) {
                String string = jSONObject2.getString("method");
                e.a("PluginManager", "method is " + string);
                if (jSONObject2.has("options")) {
                    jSONObject = jSONObject2.getJSONObject("options");
                }
                if (this.a.containsKey(str)) {
                    e.a("PluginManager", "plugins.containsKey(" + str + ") ");
                    ((h) this.a.get(str)).a(nativeToJsMessageQueue, string, str3, jSONObject);
                    return;
                }
                nativeToJsMessageQueue.a(str3, d.a.SERVICE_NOT_FOUND_EXCEPTION, "error", (JSONObject) null);
                return;
            }
            e.a("PluginManager", "method is null");
            nativeToJsMessageQueue.a(str3, d.a.METHOD_NOT_FOUND_EXCEPTION, "error", (JSONObject) null);
        } catch (JSONException unused2) {
            str3 = null;
            nativeToJsMessageQueue.a(str3, d.a.JSON_EXCEPTION, "error", (JSONObject) null);
        }
    }

    public void b() {
        for (Map.Entry entry : this.a.entrySet()) {
            e.e("PluginManager", "call plugin: " + ((String) entry.getKey()) + " reset");
            ((h) entry.getValue()).b();
        }
    }

    public void c() {
        for (Map.Entry entry : this.a.entrySet()) {
            e.e("PluginManager", "call plugin: " + ((String) entry.getKey()) + " reset");
            ((h) entry.getValue()).c();
        }
    }
}
