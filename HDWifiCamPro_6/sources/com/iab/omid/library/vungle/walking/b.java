package com.iab.omid.library.vungle.walking;

import com.iab.omid.library.vungle.walking.a.b;
import com.iab.omid.library.vungle.walking.a.c;
import com.iab.omid.library.vungle.walking.a.d;
import com.iab.omid.library.vungle.walking.a.e;
import com.iab.omid.library.vungle.walking.a.f;
import java.util.HashSet;
import org.json.JSONObject;

public class b implements b.C0084b {
    private JSONObject a;
    private final c b;

    public b(c cVar) {
        this.b = cVar;
    }

    public void a() {
        this.b.b(new d(this));
    }

    public void a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new f(this, hashSet, jSONObject, j));
    }

    public JSONObject b() {
        return this.a;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new e(this, hashSet, jSONObject, j));
    }
}
