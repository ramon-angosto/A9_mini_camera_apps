package sg.bigo.ads.common.d.a;

import org.json.JSONObject;

public final class a {
    public int a = 3;
    public long b = 432000000;
    private int c = 20;

    public a() {
        c();
    }

    private void c() {
        this.a = 3;
        this.c = 20;
        this.b = 432000000;
    }

    public final int a() {
        int i = this.c;
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        return i;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            c();
            return;
        }
        this.a = jSONObject.optInt("download_parallel_num", 3);
        this.c = jSONObject.optInt("num", 20);
        long optInt = ((long) jSONObject.optInt("valid_period")) * 1000;
        if (optInt == 0) {
            optInt = 432000000;
        }
        this.b = optInt;
    }

    public final boolean b() {
        return this.a <= 0;
    }
}
