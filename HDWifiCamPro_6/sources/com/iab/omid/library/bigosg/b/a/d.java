package com.iab.omid.library.bigosg.b.a;

import com.iab.omid.library.bigosg.e.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    private final boolean a = false;
    private final Float b = null;
    private final boolean c = true;
    private final c d;

    public d(c cVar) {
        this.d = cVar;
    }

    public final JSONObject a() {
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
