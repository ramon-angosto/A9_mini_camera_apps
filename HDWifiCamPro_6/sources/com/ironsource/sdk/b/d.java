package com.ironsource.sdk.b;

import java.util.HashMap;
import org.json.JSONObject;

public final class d {
    HashMap<String, Boolean> a = new HashMap<String, Boolean>() {
        {
            boolean z = true;
            put("isVisible", Boolean.valueOf(d.this.b == 0));
            put("isWindowVisible", Boolean.valueOf(d.this.c != 0 ? false : z));
            put("isShown", Boolean.FALSE);
            put("isViewVisible", Boolean.FALSE);
        }
    };
    int b = 4;
    int c = 4;

    d() {
    }

    public final JSONObject a() {
        return new JSONObject(this.a);
    }
}
