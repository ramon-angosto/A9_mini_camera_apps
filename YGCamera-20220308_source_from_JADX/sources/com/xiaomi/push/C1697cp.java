package com.xiaomi.push;

import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cp */
public class C1697cp {

    /* renamed from: a */
    private int f1949a;

    /* renamed from: a */
    private long f1950a;

    /* renamed from: a */
    private String f1951a;

    /* renamed from: b */
    private long f1952b;

    /* renamed from: c */
    private long f1953c;

    public C1697cp() {
        this(0, 0, 0, (Exception) null);
    }

    public C1697cp(int i, long j, long j2, Exception exc) {
        this.f1949a = i;
        this.f1950a = j;
        this.f1953c = j2;
        this.f1952b = System.currentTimeMillis();
        if (exc != null) {
            this.f1951a = exc.getClass().getSimpleName();
        }
    }

    /* renamed from: a */
    public int mo17328a() {
        return this.f1949a;
    }

    /* renamed from: a */
    public C1697cp mo17329a(JSONObject jSONObject) {
        this.f1950a = jSONObject.getLong("cost");
        this.f1953c = jSONObject.getLong("size");
        this.f1952b = jSONObject.getLong("ts");
        this.f1949a = jSONObject.getInt("wt");
        this.f1951a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a */
    public JSONObject m2873a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f1950a);
        jSONObject.put("size", this.f1953c);
        jSONObject.put("ts", this.f1952b);
        jSONObject.put("wt", this.f1949a);
        jSONObject.put("expt", this.f1951a);
        return jSONObject;
    }
}
