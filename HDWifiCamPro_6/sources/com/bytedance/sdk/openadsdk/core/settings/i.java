package com.bytedance.sdk.openadsdk.core.settings;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.h.a;
import com.bytedance.sdk.openadsdk.h.b;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

/* compiled from: SettingsRequestEvent */
public class i {
    private final long a = SystemClock.elapsedRealtime();
    /* access modifiers changed from: private */
    public int b;
    /* access modifiers changed from: private */
    public int c;
    /* access modifiers changed from: private */
    public int d;
    /* access modifiers changed from: private */
    public int e;
    /* access modifiers changed from: private */
    public long f;
    /* access modifiers changed from: private */
    public boolean g;
    /* access modifiers changed from: private */
    public String h;

    public void a() {
        if (this.f == 0 && m.d().O()) {
            this.f = SystemClock.elapsedRealtime() - this.a;
            b.a().b((a) new a() {
                public com.bytedance.sdk.openadsdk.h.a.a a() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(IronSourceConstants.EVENTS_RESULT, i.this.b);
                        jSONObject.put("http_code", i.this.c);
                        jSONObject.put("request_size", i.this.d);
                        jSONObject.put("response_size", i.this.e);
                        jSONObject.put("total_time", i.this.f);
                        jSONObject.put("is_hit_cache", i.this.g ? 1 : 0);
                        jSONObject.put("abtest_ver", i.this.h);
                        return com.bytedance.sdk.openadsdk.h.a.b.b().a("settings_request").b(jSONObject.toString());
                    } catch (Exception e) {
                        l.c("SdkSettings.Event", "", (Throwable) e);
                        return null;
                    }
                }
            });
        }
    }

    public void a(boolean z) {
        this.b = z ? 1 : 0;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(int i) {
        this.e = i;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void a(String str) {
        this.h = str;
    }
}
