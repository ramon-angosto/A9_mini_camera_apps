package com.ironsource.mediationsdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class f extends a {
    private final String d = "https://outcome-ssp.supersonicads.com/mediation?adUnit=3";

    f(int i) {
        this.b = i;
    }

    public final String a(ArrayList<c> arrayList, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.a = jSONObject;
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject a = a(it.next());
                if (a != null) {
                    jSONArray.put(a);
                }
            }
        }
        return a(jSONArray);
    }

    public final String b() {
        return "https://outcome-ssp.supersonicads.com/mediation?adUnit=3";
    }

    public final String c() {
        return "outcome";
    }
}
