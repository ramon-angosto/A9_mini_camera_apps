package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.f.c;
import com.meizu.cloud.pushsdk.b.f.d;
import com.meizu.cloud.pushsdk.b.f.e;
import java.util.HashMap;
import java.util.Map;

public class b implements a {
    private final String a = b.class.getSimpleName();
    private final HashMap<String, Object> b = new HashMap<>();

    public b(String str, Object obj) {
        a(str);
        a(obj);
    }

    public b a(String str) {
        d.a(str, (Object) "schema cannot be null");
        d.a(!str.isEmpty(), (Object) "schema cannot be empty.");
        this.b.put("schema", str);
        return this;
    }

    public b a(Object obj) {
        if (obj == null) {
            return this;
        }
        this.b.put("data", obj);
        return this;
    }

    @Deprecated
    public void a(String str, String str2) {
        c.c(this.a, "Payload: add(String, String) method called - Doing nothing.", new Object[0]);
    }

    public Map<String, Object> a() {
        return this.b;
    }

    public String toString() {
        return e.a((Map) this.b).toString();
    }

    public long b() {
        return e.a(toString());
    }
}
