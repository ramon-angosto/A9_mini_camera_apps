package sg.bigo.ads.core.b;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.core.b.b.a;

public final class b {
    private static final b c = new b();
    public a a;
    public final AtomicBoolean b = new AtomicBoolean(false);

    private b() {
    }

    public static b a() {
        return c;
    }

    public final void a(String str, Map<String, Object> map) {
        if (!sg.bigo.ads.common.n.a.c()) {
            if (!this.b.get()) {
                sg.bigo.ads.common.k.a.a(0, 3, "Callback", "please execute init first");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.putOpt((String) next.getKey(), next.getValue());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.a.a(str, jSONObject);
        }
    }
}
