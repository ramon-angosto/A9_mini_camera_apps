package com.bytedance.sdk.openadsdk.c.c.b;

import org.json.JSONObject;

/* compiled from: PlayErrorModel */
public class n implements c {
    private long a;
    private long b;
    private int c;
    private int d;
    private String e;

    public void a(long j) {
        this.a = j;
    }

    public void b(long j) {
        this.b = j;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("buffers_time", this.a);
                jSONObject.put("total_duration", this.b);
                jSONObject.put("error_code", this.c);
                jSONObject.put("extra_error_code", this.d);
                jSONObject.put("error_message", this.e);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
