package com.a.a.a.a.b.a;

import com.a.a.a.a.e.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    private final boolean a;
    private final Float b;
    private final boolean c;
    private final d d;

    private e(boolean z, Float f, boolean z2, d dVar) {
        this.a = z;
        this.b = f;
        this.c = z2;
        this.d = dVar;
    }

    public static e a(float f, boolean z, d dVar) {
        com.a.a.a.a.e.e.a((Object) dVar, "Position is null");
        return new e(true, Float.valueOf(f), z, dVar);
    }

    public static e a(boolean z, d dVar) {
        com.a.a.a.a.e.e.a((Object) dVar, "Position is null");
        return new e(false, (Float) null, z, dVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.a);
            if (this.a) {
                jSONObject.put("skipOffset", this.b);
            }
            jSONObject.put("autoPlay", this.c);
            jSONObject.put("position", this.d);
        } catch (JSONException e) {
            c.a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }
}
