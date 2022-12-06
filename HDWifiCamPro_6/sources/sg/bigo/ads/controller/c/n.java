package sg.bigo.ads.controller.c;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.core.c;

public final class n implements c.e {
    private final JSONObject a;
    private final int b;
    private final String c;
    private final String d;
    private final String e;
    private final String[] f;
    private final String[] g;

    public n(JSONObject jSONObject) {
        this.a = jSONObject;
        this.b = jSONObject.optInt("type", 0);
        this.c = jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
        this.d = jSONObject.optString("name", "");
        this.e = jSONObject.optString("uuid", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("reg");
        if (optJSONArray != null) {
            this.f = new String[optJSONArray.length()];
            this.g = new String[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    this.f[i] = optJSONObject.optString("token", "");
                    this.g[i] = optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
                }
            }
            return;
        }
        this.f = new String[0];
        this.g = new String[0];
    }

    public final JSONObject a() {
        return this.a;
    }
}
