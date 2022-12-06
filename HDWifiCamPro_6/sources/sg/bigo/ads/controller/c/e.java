package sg.bigo.ads.controller.c;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.core.c;

public final class e implements c.a {
    private final int a;
    private final int b;
    private final List<Object> c = new ArrayList();

    public e(JSONObject jSONObject) {
        this.a = jSONObject.optInt(CampaignEx.JSON_KEY_CLICK_MODE, 2);
        this.b = jSONObject.optInt("wrong_click_time", 500);
        JSONArray optJSONArray = jSONObject.optJSONArray("reconfirm_click_region");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    this.c.add(new f(optJSONObject));
                }
            }
        }
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }
}
