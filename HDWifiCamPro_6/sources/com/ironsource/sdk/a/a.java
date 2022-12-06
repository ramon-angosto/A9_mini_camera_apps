package com.ironsource.sdk.a;

import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;

public final class a {
    public HashMap<String, Object> a = new HashMap<>();

    public final a a(String str, Object obj) {
        if (obj != null) {
            this.a.put(str, SDKUtils.encodeString(obj.toString()));
        }
        return this;
    }
}
