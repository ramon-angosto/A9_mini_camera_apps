package sg.bigo.ads.controller.c;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.common.utils.o;

public final class j implements c.b {
    private String a;
    private final String b;
    private final int c;
    private final String d;
    private final int e;
    private final String f;
    private final int g;
    private final String h;
    private final Map<String, String> i = new LinkedHashMap();
    private final String j;
    private final int k;

    public j(JSONObject jSONObject) {
        this.a = jSONObject.optString("land_url", "");
        this.b = jSONObject.optString("deeplink_url", "");
        this.c = jSONObject.optInt("web_ad_model", 0);
        this.d = jSONObject.optString("return_tracker_url", "");
        this.e = jSONObject.optInt("land_preload_type", 0);
        this.f = jSONObject.optString("click_open_pkg", "");
        this.g = jSONObject.optInt("probe_interval", 0);
        JSONObject optJSONObject = jSONObject.optJSONObject("pixel");
        if (optJSONObject != null) {
            this.h = optJSONObject.optString("host", "");
            String optString = optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
            if (!o.b(optString)) {
                b(optString);
            }
        } else {
            this.h = "";
        }
        this.j = jSONObject.optString("pre_landing_url", "");
        this.k = jSONObject.optInt("pre_landing_scene", 0);
    }

    private void b(String str) {
        this.i.clear();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split("&")) {
                if (str2.indexOf("=") >= 0) {
                    String substring = str2.substring(0, str2.indexOf("="));
                    if (!TextUtils.isEmpty(substring)) {
                        String str3 = this.i.get(substring);
                        if (o.c(str3)) {
                            str2 = str3 + "&" + str2;
                        }
                        this.i.put(substring, str2);
                    }
                }
            }
        }
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.h;
    }

    public final Map<String, String> h() {
        return this.i;
    }

    public final String i() {
        return this.j;
    }

    public final int j() {
        return this.k;
    }
}
