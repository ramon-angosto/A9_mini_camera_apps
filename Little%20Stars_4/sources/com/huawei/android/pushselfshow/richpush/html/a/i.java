package com.huawei.android.pushselfshow.richpush.html.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.a.h;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.f;
import com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue;
import com.huawei.android.pushselfshow.richpush.html.api.d;
import com.huawei.android.pushselfshow.utils.a;
import org.json.JSONObject;

public class i implements h {
    private Activity a;
    private NativeToJsMessageQueue b;
    private String c;
    private boolean d = false;

    public i(Activity activity, boolean z) {
        e.e("PushSelfShowLog", "init App");
        this.a = activity;
        this.d = z;
    }

    private String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("version", Build.DISPLAY);
            jSONObject.put("os", "Android");
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("uuid", a());
            jSONObject.put("sdkVersion", "2705");
            if (this.d) {
                jSONObject.put("imei", a.a(a.b((Context) this.a)));
            }
        } catch (Exception e) {
            e.d("PushSelfShowLog", "onError error", e);
        }
        return jSONObject.toString();
    }

    public String a() {
        try {
            String a2 = f.a(this.a, "push_client_self_info", "token_info");
            if (TextUtils.isEmpty(a2)) {
                a2 = a.b((Context) this.a);
            }
            return h.a(a2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String a(String str, JSONObject jSONObject) {
        return "getDeviceInfo".equals(str) ? e() : d.a(d.a.ERROR).toString();
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void a(NativeToJsMessageQueue nativeToJsMessageQueue, String str, String str2, JSONObject jSONObject) {
        if (nativeToJsMessageQueue == null) {
            e.a("PushSelfShowLog", "jsMessageQueue is null while run into App exec");
            return;
        }
        this.b = nativeToJsMessageQueue;
        if (str2 != null) {
            this.c = str2;
        } else {
            e.a("PushSelfShowLog", "get DeviceInfo exec callback is null ");
        }
        this.b.a(this.c, d.a.METHOD_NOT_FOUND_EXCEPTION, "error", (JSONObject) null);
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }
}
