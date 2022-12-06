package sg.bigo.ads.core.a;

import org.json.JSONObject;

public final class b {
    int a;
    private int b;
    private int c;
    private int d;
    private int e;

    public static class a {
        /* access modifiers changed from: private */
        public static final b a = new b((byte) 0);
    }

    private b() {
        this.b = 0;
        this.c = 86400;
        this.a = 10;
        this.d = 3600;
        this.e = 259200;
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    public final void a(JSONObject jSONObject) {
        this.b = jSONObject.optInt("app_chk_state", 0);
        this.a = jSONObject.optInt("app_chk_batch_size", 10);
        this.c = jSONObject.optInt("app_chk_list_interval", 3600);
        this.d = jSONObject.optInt("app_chk_interval", 3600);
        this.e = jSONObject.optInt("app_chk_expire", 259200);
    }

    public final boolean a() {
        return this.b == 1;
    }

    public final long b() {
        return (long) (this.d * 1000);
    }

    public final long c() {
        return (long) (this.e * 1000);
    }

    public final long d() {
        return (long) (this.c * 1000);
    }
}
