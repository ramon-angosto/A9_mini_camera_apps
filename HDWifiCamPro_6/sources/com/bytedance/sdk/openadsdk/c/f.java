package com.bytedance.sdk.openadsdk.c;

import org.json.JSONObject;

/* compiled from: AdShowTime */
public class f {
    private long a;
    private long b;
    private long c;
    private long d;
    private long e;

    public JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        if (this.a > 0) {
            jSONObject.put("show_start", this.a);
            if (this.b > 0) {
                jSONObject.put("show_firstQuartile", this.b);
                if (this.c > 0) {
                    jSONObject.put("show_mid", this.c);
                    if (this.d > 0) {
                        jSONObject.put("show_thirdQuartile", this.d);
                        if (this.e > 0) {
                            jSONObject.put("show_full", this.e);
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    public void a(long j) {
        if (this.a <= 0) {
            this.a = j;
        }
    }

    public void a(long j, float f) {
        if (f > 0.0f) {
            a(j);
        }
        double d2 = (double) f;
        if (d2 >= 0.25d) {
            a(j);
            b(j);
        }
        if (d2 >= 0.5d) {
            a(j);
            b(j);
            c(j);
        }
        if (d2 >= 0.75d) {
            a(j);
            b(j);
            c(j);
            d(j);
        }
        if (f >= 1.0f) {
            a(j);
            b(j);
            c(j);
            d(j);
            e(j);
        }
    }

    public boolean a() {
        return this.a > 0;
    }

    public JSONObject b() {
        return a((JSONObject) null);
    }

    public void b(long j) {
        if (this.b <= 0) {
            this.b = j;
        }
    }

    public void c(long j) {
        if (this.c <= 0) {
            this.c = j;
        }
    }

    public void d(long j) {
        if (this.d <= 0) {
            this.d = j;
        }
    }

    public void e(long j) {
        if (this.e <= 0) {
            this.e = j;
        }
    }
}
