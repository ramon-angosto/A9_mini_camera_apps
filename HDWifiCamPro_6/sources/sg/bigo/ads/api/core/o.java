package sg.bigo.ads.api.core;

import org.json.JSONObject;

public final class o {
    public boolean a = false;
    private String b = "";
    private int c = 0;
    private int d = 0;

    public o() {
        a();
    }

    private void a() {
        this.a = false;
        this.b = "";
        this.c = 3;
        this.d = 20000;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            a();
            return;
        }
        this.a = true;
        this.b = jSONObject.optString("http_succ_code");
        this.c = jSONObject.optInt("retry_cnt", 3);
        this.d = jSONObject.optInt("retry_interval") * 1000;
        if (this.d < 20000) {
            this.d = 20000;
        }
    }

    public final boolean a(int i) {
        if (i >= 100) {
            return this.b.contains(String.valueOf(i));
        }
        return false;
    }

    public final boolean a(long j, long j2) {
        return j + ((long) this.d) < j2;
    }

    public final boolean b(int i) {
        return i < this.c;
    }
}
