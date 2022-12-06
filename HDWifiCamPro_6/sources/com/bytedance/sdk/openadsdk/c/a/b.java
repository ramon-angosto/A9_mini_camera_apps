package com.bytedance.sdk.openadsdk.c.a;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* compiled from: AdEvenRecord */
public class b {
    public AtomicInteger a = new AtomicInteger(0);
    public AtomicInteger b = new AtomicInteger(0);
    public AtomicLong c = new AtomicLong(0);
    public int d;
    public AtomicInteger e = new AtomicInteger(0);
    public Map<Integer, Integer> f = new HashMap();
    public AtomicBoolean g = new AtomicBoolean(false);

    public b(int i) {
        this.d = i;
    }

    /* access modifiers changed from: package-private */
    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", this.a.get());
            jSONObject.put("fail", this.b.get());
            jSONObject.put("type", this.d);
            jSONObject.put(IronSourceConstants.EVENTS_DURATION, this.c.get() / ((long) this.a.get()));
            JSONObject jSONObject2 = new JSONObject();
            if (this.f.size() > 0) {
                for (Map.Entry next : this.f.entrySet()) {
                    jSONObject2.put(next.getKey() + "", next.getValue());
                }
            }
            jSONObject.put("fail_error_code", jSONObject2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", this.a.get());
            jSONObject.put("fail", this.b.get());
            jSONObject.put("type", this.d);
            jSONObject.put("time", this.e.get());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
