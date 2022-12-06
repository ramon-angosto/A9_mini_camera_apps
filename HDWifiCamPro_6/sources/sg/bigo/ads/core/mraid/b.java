package sg.bigo.ads.core.mraid;

import android.graphics.Rect;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class b {
    final float a;
    final Rect b;
    final List<Rect> c;

    b(float f, Rect rect, List<Rect> list) {
        this.a = f;
        this.b = rect;
        this.c = list;
    }

    static JSONArray a(List<Rect> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Rect a2 : list) {
            jSONArray.put(a(a2));
        }
        return jSONArray;
    }

    static JSONObject a(Rect rect) {
        if (rect == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", rect.left);
            jSONObject.put("y", rect.top);
            jSONObject.put("width", rect.width());
            jSONObject.put("height", rect.height());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
