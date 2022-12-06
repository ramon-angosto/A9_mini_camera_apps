package sg.bigo.ads.core.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    static JSONArray a(List<m> list) {
        JSONArray jSONArray = new JSONArray();
        for (m next : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("pkg_name", next.b);
                jSONObject.putOpt("timestamp", Long.valueOf(next.e / 1000));
                jSONObject.putOpt("install_ts", Long.valueOf(next.g / 1000));
                jSONObject.putOpt("code", Integer.valueOf(next.f));
                jSONObject.putOpt("source", Integer.valueOf(next.d));
                if (next.j > 0) {
                    jSONObject.putOpt("sid", Long.valueOf(next.j));
                    jSONObject.putOpt("ad_id", next.k);
                    jSONObject.putOpt("adn", "bigoad");
                    jSONObject.putOpt("dsp", next.l);
                }
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray;
    }

    static void a(List<m> list, long j) {
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (m next : list) {
                if (System.currentTimeMillis() - next.i > j) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                l.b((List<m>) arrayList);
                list.removeAll(arrayList);
            }
        }
    }
}
