package sg.bigo.ads.controller.c;

import org.json.JSONObject;
import sg.bigo.ads.api.core.i;

public final class d implements i.a {
    private final boolean a;

    public d(JSONObject jSONObject) {
        this.a = jSONObject.optInt("banner_pre_load", 0) == 1;
    }

    public final boolean a() {
        return this.a;
    }

    public final String[] b() {
        return new String[0];
    }
}
