package sg.bigo.ads.controller.a;

import android.text.TextUtils;
import android.util.Patterns;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.k.a;
import sg.bigo.ads.common.utils.m;

public final class c {
    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str)) {
            a.a(0, "AntiBanUtils", "decrypt error, cryptStr is empty.");
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            a.a(0, "AntiBanUtils", "decrypt error, hexStringSecKey is empty.");
            return null;
        } else {
            String b = m.b(str, str2);
            if (TextUtils.isEmpty(b)) {
                a.a(0, "AntiBanUtils", "decrypt error, decrypted content is empty.");
                return null;
            }
            try {
                jSONObject = new JSONObject(b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a.a(0, 3, "AntiBanUtils", "decrypt, cryptStr=" + str + ", hexStringSecKey=" + str2 + ", content=" + b);
            return jSONObject;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf(":");
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        return Patterns.DOMAIN_NAME.matcher(str).matches();
    }
}
