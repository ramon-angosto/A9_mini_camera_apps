package sg.bigo.ads.controller.c;

import org.json.JSONObject;
import sg.bigo.ads.api.core.n;

public final class i implements n.b {
    private final int a;
    private final long b;
    private final int c;
    private final long d;

    public i(JSONObject jSONObject) {
        this.a = jSONObject.optInt("video_impression_area_rate", 0);
        this.b = jSONObject.optLong("video_impression_time", 0);
        this.c = jSONObject.optInt("image_impression_area_rate", 0);
        this.d = jSONObject.optLong("image_impression_time", 0);
    }

    public final int a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }
}
