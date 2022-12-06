package com.a.a.a.a.b;

import com.a.a.a.a.e.b;
import com.a.a.a.a.e.e;
import org.json.JSONObject;

public class c {
    private final i a;
    private final i b;
    private final boolean c;
    private final f d;
    private final h e;

    private c(f fVar, h hVar, i iVar, i iVar2, boolean z) {
        this.d = fVar;
        this.e = hVar;
        this.a = iVar;
        if (iVar2 == null) {
            this.b = i.NONE;
        } else {
            this.b = iVar2;
        }
        this.c = z;
    }

    public static c a(f fVar, h hVar, i iVar, i iVar2, boolean z) {
        e.a((Object) fVar, "CreativeType is null");
        e.a((Object) hVar, "ImpressionType is null");
        e.a((Object) iVar, "Impression owner is null");
        e.a(iVar, fVar, hVar);
        return new c(fVar, hVar, iVar, iVar2, z);
    }

    public boolean a() {
        return i.NATIVE == this.a;
    }

    public boolean b() {
        return i.NATIVE == this.b;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "impressionOwner", this.a);
        b.a(jSONObject, "mediaEventsOwner", this.b);
        b.a(jSONObject, "creativeType", this.d);
        b.a(jSONObject, "impressionType", this.e);
        b.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.c));
        return jSONObject;
    }
}
