package sg.bigo.ads.controller.c;

import org.json.JSONObject;
import sg.bigo.ads.api.core.n;

public final class p implements n.d {
    private final boolean a;
    private final int b;
    private boolean c = false;
    private final long d;
    private final long e;
    private long f;

    public p(JSONObject jSONObject) {
        boolean z = false;
        this.a = jSONObject.optInt("play_ad_downloading", 0) == 1 ? true : z;
        this.b = jSONObject.optInt("play_ad_threshold", 50);
        this.d = jSONObject.optLong("play_ad_min_second", 6) * 1000;
        this.e = jSONObject.optLong("threshold_max_second", 15) * 1000;
    }

    public final void a(long j) {
        this.f = j;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final boolean a() {
        return this.a;
    }

    public final int b() {
        if (!this.a) {
            return 100;
        }
        long j = this.f;
        if (j <= this.d) {
            return 100;
        }
        long j2 = this.e;
        return j <= j2 ? this.b : j < (3 * j2) / 2 ? (int) ((((long) this.b) * j2) / j) : (this.b * 2) / 3;
    }

    public final boolean c() {
        return this.c;
    }
}
