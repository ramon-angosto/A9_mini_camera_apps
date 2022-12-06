package com.huawei.android.pushagent.plugin.a;

import org.json.JSONObject;

public class c extends b {
    private JSONObject a = new JSONObject();

    public JSONObject a() {
        return this.a;
    }

    public void a(int i) {
        a(this.a, "cid", i);
    }

    public void b(int i) {
        a(this.a, "lac", i);
    }

    public void c(int i) {
        a(this.a, "psc", i);
    }
}
