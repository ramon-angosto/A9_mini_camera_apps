package com.bytedance.sdk.openadsdk.c.c.b;

import org.json.JSONObject;

/* compiled from: LoadVideoSuccessModel */
public class l implements c {
    private String a;
    private long b;
    private long c;
    private long d;

    public void a(String str) {
        this.a = str;
    }

    public void a(long j) {
        this.b = j;
    }

    public void b(long j) {
        this.c = j;
    }

    public void c(long j) {
        this.d = j;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("preload_url", this.a);
                jSONObject.put("preload_size", this.b);
                jSONObject.put("load_time", this.c);
                jSONObject.put("local_cache", this.d);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
