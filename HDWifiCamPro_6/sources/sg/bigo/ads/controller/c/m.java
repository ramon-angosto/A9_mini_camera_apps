package sg.bigo.ads.controller.c;

import org.json.JSONObject;
import sg.bigo.ads.api.core.c;

public final class m implements c.d {
    private final String a;
    private final String b;
    private final String c;

    public m(JSONObject jSONObject) {
        this.a = jSONObject.optString("imageurl");
        this.b = jSONObject.optString("clickurl");
        this.c = jSONObject.optString("longlegaltext");
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
