package sg.bigo.ads.controller.c;

import com.vungle.warren.model.AdvertisementDBAdapter;
import org.json.JSONObject;
import sg.bigo.ads.api.core.n;

public final class h implements n.a {
    private final int a;
    private final int b;
    private final String c;
    private final String d;

    public h(JSONObject jSONObject) {
        this.a = jSONObject.optInt("w");
        this.b = jSONObject.optInt("h");
        this.c = jSONObject.optString("url");
        this.d = jSONObject.optString(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_MD5);
    }

    public final String a() {
        return this.c;
    }
}
