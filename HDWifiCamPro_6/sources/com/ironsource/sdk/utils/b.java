package com.ironsource.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ironsource.sdk.g.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static b b;
    public SharedPreferences a;

    static {
        b.class.getSimpleName();
    }

    private b(Context context) {
        this.a = context.getSharedPreferences("supersonic_shared_preferen", 0);
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            bVar = b;
        }
        return bVar;
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b(context);
            }
            bVar = b;
        }
        return bVar;
    }

    public static boolean b(String str) {
        return str.matches("^\\d+_\\d+$");
    }

    private String c() {
        return this.a.getString("version", "-1");
    }

    public final void a(String str) {
        if (!c().equalsIgnoreCase(str)) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString("version", str);
            edit.apply();
        }
    }

    public final boolean a(String str, String str2, String str3) {
        String string = this.a.getString("ssaUserData", (String) null);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.isNull(str2)) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
            if (jSONObject2.isNull(str3)) {
                return false;
            }
            jSONObject2.getJSONObject(str3).put("timestamp", str);
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString("ssaUserData", jSONObject.toString());
            return edit.commit();
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final List<String> b() {
        String string = this.a.getString("search_keys", (String) null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            f fVar = new f(string);
            if (fVar.a("searchKeys")) {
                try {
                    arrayList.addAll(fVar.a((JSONArray) fVar.c("searchKeys")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }
}
