package com.bytedance.sdk.openadsdk.c.c.b;

import com.bytedance.sdk.openadsdk.c.c.b.c;
import com.bytedance.sdk.openadsdk.core.model.n;
import org.json.JSONObject;

/* compiled from: BaseEventModel */
public class a<T extends c> {
    private n a;
    private String b;
    private JSONObject c;
    private T d = null;
    private boolean e = false;

    public a(n nVar, String str, JSONObject jSONObject, T t) {
        this.a = nVar;
        this.b = str;
        this.c = jSONObject;
        this.d = t;
    }

    public n a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public JSONObject c() {
        if (this.c == null) {
            this.c = new JSONObject();
        }
        return this.c;
    }

    public T d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }
}
