package com.huawei.agconnect.config.p006a;

import android.util.Log;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.agconnect.config.a.f */
class C0546f implements C0544d {

    /* renamed from: a */
    private final JSONObject f107a;

    C0546f(InputStream inputStream) {
        this.f107a = m58a(inputStream);
    }

    /* renamed from: a */
    private JSONObject m58a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(C0550j.m67a(inputStream, Key.STRING_CHARSET_NAME));
            } catch (IOException unused) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException unused2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    public String getString(String str, String str2) {
        if (str.endsWith("/")) {
            return str2;
        }
        String[] split = str.split("/");
        try {
            JSONObject jSONObject = this.f107a;
            for (int i = 1; i < split.length; i++) {
                if (i == split.length - 1) {
                    return jSONObject.get(split[i]).toString();
                }
                jSONObject = jSONObject.getJSONObject(split[i]);
            }
        } catch (JSONException unused) {
            Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
        }
        return str2;
    }
}
