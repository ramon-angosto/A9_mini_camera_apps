package com.ironsource.mediationsdk.a;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class a {
    JSONObject a;
    int b;
    String c;
    private final String d = "eventId";
    private final String e = "timestamp";
    private final String f = "InterstitialEvents";
    private final String g = "events";
    private final String h = "events";

    a() {
    }

    static JSONObject a(c cVar) {
        try {
            JSONObject jSONObject = !TextUtils.isEmpty(cVar.c()) ? new JSONObject(cVar.c()) : new JSONObject();
            jSONObject.put("eventId", cVar.a());
            jSONObject.put("timestamp", cVar.b());
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return TextUtils.isEmpty(this.c) ? b() : this.c;
    }

    public abstract String a(ArrayList<c> arrayList, JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    public final String a(JSONArray jSONArray) {
        try {
            if (this.a == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(this.a.toString());
            jSONObject.put("timestamp", IronSourceUtils.getTimeStamp());
            String str = "events";
            if (this.b == 2) {
                str = "InterstitialEvents";
            }
            jSONObject.put(str, jSONArray);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public abstract String b();

    public abstract String c();
}
