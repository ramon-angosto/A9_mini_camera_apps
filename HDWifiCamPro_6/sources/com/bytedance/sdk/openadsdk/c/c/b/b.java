package com.bytedance.sdk.openadsdk.c.c.b;

import org.json.JSONObject;

/* compiled from: EndcardSkipModel */
public class b implements c {
    private long a;
    private long b;
    private int c;
    private int d;

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
                jSONObject.put("vbtt_skip_type", this.c);
                jSONObject.put("skip_reason", this.d);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
