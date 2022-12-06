package sg.bigo.ads.controller.c;

import org.json.JSONObject;
import sg.bigo.ads.api.a.g;
import sg.bigo.ads.api.core.h;
import sg.bigo.ads.api.core.i;

public final class c extends b implements i {
    private boolean A;
    protected i.b x;
    protected final i.a y;
    private boolean z;

    protected c(long j, h hVar, g gVar, JSONObject jSONObject) {
        super(j, hVar, gVar, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("display");
        if (optJSONObject != null) {
            this.x = new g(optJSONObject);
        }
        this.y = new d(jSONObject);
    }

    public final boolean Q() {
        return a(32);
    }

    public final i.b R() {
        return this.x;
    }

    public final i.a S() {
        return this.y;
    }

    public final void T() {
        this.z = true;
    }

    public final boolean U() {
        return this.z;
    }

    public final void V() {
        this.A = true;
    }

    public final boolean W() {
        return this.A;
    }
}
