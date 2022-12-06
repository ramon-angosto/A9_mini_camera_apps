package sg.bigo.ads.core.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.o;

final class g {
    final long a;
    final int b;
    final String c;
    final List<String> d = new ArrayList();

    public g(JSONObject jSONObject) {
        this.a = jSONObject.optLong("timestamp");
        this.b = jSONObject.optInt("next_index");
        this.c = jSONObject.optString("next_key");
        JSONArray optJSONArray = jSONObject.optJSONArray("apps");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!o.b(optString)) {
                    this.d.add(optString);
                }
            }
        }
    }

    public final String toString() {
        return "AppListImpl{mTimestamp=" + this.a + ", mNextIndex=" + this.b + ", mNextKey='" + this.c + '\'' + ", mAppPackageNames=" + this.d + '}';
    }
}
