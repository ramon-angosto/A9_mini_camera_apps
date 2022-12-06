package com.bytedance.sdk.openadsdk.c.c.b;

import org.json.JSONObject;

/* compiled from: FeedOverModel */
public class f implements c {
    private long a;
    private long b;
    private int c = 0;

    public void a(long j) {
        this.a = j;
    }

    public void b(long j) {
        this.b = j;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("total_duration", this.a);
                jSONObject.put("buffers_time", this.b);
                jSONObject.put("video_backup", this.c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
