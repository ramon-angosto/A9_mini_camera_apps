package sg.bigo.ads.core.a;

import org.json.JSONObject;
import sg.bigo.ads.common.utils.m;

public final class a {
    public String a;
    String b;
    String c;
    String d;
    String e;

    /* renamed from: sg.bigo.ads.core.a.a$a  reason: collision with other inner class name */
    public static class C0133a {
        /* access modifiers changed from: private */
        public static final a a = new a((byte) 0);
    }

    private a() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optString("k0", "");
            this.b = jSONObject.optString("k1", "");
            this.c = jSONObject.optString("k2", "");
            this.d = jSONObject.optString("k3", "");
            this.e = jSONObject.optString("k4", "");
            this.a = m.b(this.a, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F");
            this.b = m.b(this.b, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F");
            this.c = m.b(this.c, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F");
            this.d = m.b(this.d, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F");
            this.e = m.b(this.e, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F");
            sg.bigo.ads.common.k.a.a("k0 (QUERY_ALL_PACKAGE开关): ", this.a);
            sg.bigo.ads.common.k.a.a("k1 (OVERLAY_CHANGED开关): ", this.b);
            sg.bigo.ads.common.k.a.a("k2 (PACKAGE_ADDED开关): ", this.c);
            sg.bigo.ads.common.k.a.a("k3 (PACKAGE_REMOVED开关): ", this.d);
            sg.bigo.ads.common.k.a.a("k4 (PACKAGE_REPLACED开关): ", this.e);
        }
    }
}
