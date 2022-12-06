package com.iab.omid.library.bigosg.h;

import com.iab.omid.library.bigosg.h.a.b;
import com.iab.omid.library.bigosg.h.a.d;
import org.json.JSONObject;

public final class c implements b.C0078b {
    final com.iab.omid.library.bigosg.h.a.c a;
    private JSONObject b;

    public c(com.iab.omid.library.bigosg.h.a.c cVar) {
        this.a = cVar;
    }

    public final JSONObject a() {
        return this.b;
    }

    public final void a(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public final void b() {
        this.a.a(new d(this));
    }
}
