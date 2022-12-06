package com.bytedance.sdk.openadsdk.core.f.b;

import com.bytedance.sdk.openadsdk.core.f.b.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VastFractionalProgressTracker */
public class b extends c implements Comparable<b> {
    private float a;

    private b(float f, String str, c.C0047c cVar, Boolean bool) {
        super(str, cVar, bool);
        this.a = f;
    }

    public boolean a(float f) {
        return this.a <= f && !e();
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        if (bVar == null) {
            return 1;
        }
        float f = this.a;
        float f2 = bVar.a;
        if (f > f2) {
            return 1;
        }
        return f < f2 ? -1 : 0;
    }

    public void f_() {
        super.f_();
        float f = this.a;
        if (f != 0.25f) {
            int i = (f > 0.5f ? 1 : (f == 0.5f ? 0 : -1));
        }
    }

    /* compiled from: VastFractionalProgressTracker */
    public static class a {
        private String a;
        private float b;
        private c.C0047c c = c.C0047c.TRACKING_URL;
        private boolean d = false;

        public a(String str, float f) {
            this.a = str;
            this.b = f;
        }

        public b a() {
            return new b(this.b, this.a, this.c, Boolean.valueOf(this.d));
        }
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", c());
        jSONObject.put("trackingFraction", (double) this.a);
        return jSONObject;
    }
}
