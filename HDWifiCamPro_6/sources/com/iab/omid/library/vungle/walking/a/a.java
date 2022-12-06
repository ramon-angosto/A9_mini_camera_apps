package com.iab.omid.library.vungle.walking.a;

import com.iab.omid.library.vungle.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class a extends b {
    protected final HashSet<String> a;
    protected final JSONObject b;
    protected final long c;

    public a(b.C0084b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar);
        this.a = new HashSet<>(hashSet);
        this.b = jSONObject;
        this.c = j;
    }
}
