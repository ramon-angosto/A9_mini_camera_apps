package com.a.a.a.a.h;

import com.a.a.a.a.h.a.b;
import com.a.a.a.a.h.a.d;
import com.a.a.a.a.h.a.e;
import com.a.a.a.a.h.a.f;
import java.util.HashSet;
import org.json.JSONObject;

public class c implements b.C0003b {
    private JSONObject a;
    private final com.a.a.a.a.h.a.c b;

    public c(com.a.a.a.a.h.a.c cVar) {
        this.b = cVar;
    }

    public JSONObject a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new f(this, hashSet, jSONObject, j));
    }

    public void b() {
        this.b.b(new d(this));
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new e(this, hashSet, jSONObject, j));
    }
}
