package sg.bigo.ads.ad.banner;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.AdSize;

public final class a {
    public static JSONArray a(List<AdSize> list) {
        JSONArray jSONArray = new JSONArray();
        for (AdSize next : list) {
            if (next != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("w", next.getWidth());
                    jSONObject.put("h", next.getHeight());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
