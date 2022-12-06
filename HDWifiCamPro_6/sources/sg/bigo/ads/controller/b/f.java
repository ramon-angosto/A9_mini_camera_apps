package sg.bigo.ads.controller.b;

import org.json.JSONObject;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.common.utils.i;

public final class f implements h {
    private final JSONObject a;

    public f(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    private Object d(String str) {
        String[] split = str.split("\\.");
        if (split.length == 0) {
            return null;
        }
        JSONObject jSONObject = this.a;
        for (int i = 0; i < split.length - 1; i++) {
            jSONObject = jSONObject.optJSONObject(split[i]);
            if (jSONObject == null) {
                return null;
            }
        }
        return jSONObject.opt(split[split.length - 1]);
    }

    public final int a(String str) {
        Integer a2 = i.a(d(str));
        if (a2 != null) {
            return a2.intValue();
        }
        return 0;
    }

    public final float b(String str) {
        Float b = i.b(d(str));
        if (b != null) {
            return b.floatValue();
        }
        return 0.0f;
    }

    public final boolean c(String str) {
        return a(str) == 1;
    }

    public final String toString() {
        return this.a.toString();
    }
}
