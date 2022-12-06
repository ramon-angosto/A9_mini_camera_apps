package com.bytedance.sdk.openadsdk.c.c.b;

import org.json.JSONObject;

/* compiled from: FeedBreakModel */
public class d implements c {
    public long a;
    public long b;
    public int c;
    public int d = 0;

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
                jSONObject.put("total_duration", this.a);
                jSONObject.put("buffers_time", this.b);
                jSONObject.put("break_reason", this.c);
                jSONObject.put("video_backup", this.d);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
