package com.bytedance.sdk.openadsdk.c.c.b;

import org.json.JSONObject;

/* compiled from: PlayBufferModel */
public class m implements c {
    public long a;
    public int b;
    public long c;

    public void a(long j) {
        this.a = j;
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(long j) {
        this.c = j;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("buffers_time", this.a);
                jSONObject.put("buffers_count", this.b);
                jSONObject.put("total_duration", this.c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
