package sg.bigo.ads.controller.c;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONObject;
import sg.bigo.ads.api.core.i;

public final class g implements i.b {
    private final int a;
    private final int b;
    private final String c;

    public g(JSONObject jSONObject) {
        this.a = jSONObject.optInt("w");
        this.b = jSONObject.optInt("h");
        this.c = jSONObject.optString(DataSchemeDataSource.SCHEME_DATA);
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
