package sg.bigo.ads.controller.c;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONObject;
import sg.bigo.ads.api.core.n;

public final class o implements n.c {
    private final int a;
    private final int b;
    private final String c;

    public o(JSONObject jSONObject) {
        this.a = jSONObject.optInt("w");
        this.b = jSONObject.optInt("h");
        this.c = jSONObject.optString(DataSchemeDataSource.SCHEME_DATA);
    }

    public final String a() {
        return this.c;
    }
}
