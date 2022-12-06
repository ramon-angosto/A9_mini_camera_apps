package sg.bigo.ads.core.d.a;

import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.o;

public final class a {
    public int a = 10;
    public int b = 900000;
    public final HashMap<String, C0136a> c = new HashMap<>();

    /* renamed from: sg.bigo.ads.core.d.a.a$a  reason: collision with other inner class name */
    public static class C0136a {
        String a;
        boolean b;
        public boolean c;
        public int d;

        public final void a(JSONObject jSONObject) {
            boolean z = false;
            if (jSONObject == null) {
                sg.bigo.ads.common.k.a.a(0, "Stats", "eventConfig is null.");
                return;
            }
            this.a = jSONObject.optString("event_id");
            this.b = jSONObject.optInt("status") == 1;
            if (jSONObject.optInt(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_DELAY) == 1) {
                z = true;
            }
            this.c = z;
            this.d = jSONObject.optInt("expired") * 1000;
            if (this.d == 0) {
                this.d = 3600000;
            }
        }
    }

    public a() {
        b();
    }

    private void b() {
        this.a = 10;
        this.b = 900000;
        this.c.clear();
    }

    public final int a() {
        return Math.round(((float) this.a) * 0.8f);
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            b();
            return;
        }
        this.a = jSONObject.optInt("delay_num", 10);
        this.b = jSONObject.optInt("delay_interval") * 1000;
        if (this.b == 0) {
            this.b = 900000;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("event_config");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                C0136a aVar = new C0136a();
                aVar.a(optJSONArray.optJSONObject(i));
                if (o.c(aVar.a)) {
                    this.c.put(aVar.a, aVar);
                }
            }
        }
    }

    public final boolean a(String str) {
        C0136a aVar = this.c.get(str);
        if (aVar == null) {
            return false;
        }
        return aVar.b;
    }
}
