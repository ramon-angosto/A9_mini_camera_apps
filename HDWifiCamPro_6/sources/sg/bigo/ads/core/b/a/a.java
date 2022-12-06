package sg.bigo.ads.core.b.a;

import org.json.JSONObject;

public final class a {
    public int a = 10;
    public int b = 900000;
    public int c = 259200000;

    public a() {
        b();
    }

    private void b() {
        this.a = 10;
        this.b = 900000;
        this.c = 259200000;
    }

    public final int a() {
        return Math.round(((float) this.a) * 0.8f);
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            b();
            return;
        }
        this.a = jSONObject.optInt("num", 10);
        this.b = jSONObject.optInt("interval") * 1000;
        if (this.b == 0) {
            this.b = 900000;
        }
        this.c = jSONObject.optInt("expired") * 1000;
    }
}
