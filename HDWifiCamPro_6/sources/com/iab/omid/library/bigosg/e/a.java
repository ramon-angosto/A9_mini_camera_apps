package com.iab.omid.library.bigosg.e;

import android.os.Build;
import org.json.JSONObject;

public final class a {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        b.a(jSONObject, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        b.a(jSONObject, "os", "Android");
        return jSONObject;
    }
}
