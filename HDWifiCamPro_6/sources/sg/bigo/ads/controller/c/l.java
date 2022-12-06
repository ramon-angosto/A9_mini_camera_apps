package sg.bigo.ads.controller.c;

import org.json.JSONObject;
import sg.bigo.ads.api.core.c;

public final class l implements c.C0120c {
    private final String a;
    private final String b;
    private final String c;

    public l(JSONObject jSONObject) {
        this.a = jSONObject.optString("vendor_url");
        this.b = jSONObject.optString("vendor_key");
        this.c = jSONObject.optString("params");
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
