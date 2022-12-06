package sg.bigo.ads;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.k.a;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.controller.a.c;

public class b {
    private static final String a = b.class.getSimpleName();
    private static String b = "api.bytegle.tech";

    public static String a() {
        r.a();
        return b;
    }

    public static boolean a(sg.bigo.ads.controller.b.b bVar, String str) {
        JSONArray jSONArray;
        if (bVar == null) {
            return false;
        }
        String str2 = null;
        try {
            jSONArray = new JSONArray(bVar.a("api_hosts").toString());
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray != null) {
            a.a(0, 3, a, "[api host] try to update host directly. current country code is ".concat(String.valueOf(str)));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("country", "");
                    if (!"".equals(optString)) {
                        if (str != null && str.equalsIgnoreCase(optString)) {
                            str2 = optJSONObject.optString("host");
                            a.a(0, 3, a, "[api host] match specific country host: ".concat(String.valueOf(str2)));
                            if (!TextUtils.isEmpty(str2)) {
                                break;
                            }
                        }
                    } else {
                        str2 = optJSONObject.optString("host");
                        a.a(0, 3, a, "[api host] match general host: ".concat(String.valueOf(str2)));
                    }
                }
            }
            if (!TextUtils.isEmpty(str2) && c.a(str2) && !str2.equalsIgnoreCase(b)) {
                b = str2;
                return true;
            }
        }
        return false;
    }

    public static String b() {
        r.a();
        return o.a("https://%1$s/Ad/GetUniConfig", b);
    }

    public static String c() {
        r.a();
        return o.a("https://%1$s/Ad/GetUniAd", b);
    }

    public static String d() {
        r.a();
        return o.a("https://%1$s/Ad/ReportUniBaina", b);
    }

    public static String e() {
        r.a();
        return o.a("https://%1$s/Ad/UniCallback", b);
    }

    public static String f() {
        r.a();
        return o.a("https://%1$s/Ad/GetUniData", b);
    }

    public static String g() {
        r.a();
        return o.a("https://%1$s/Ad/ReportUniData", b);
    }
}
