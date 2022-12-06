package com.ironsource.mediationsdk.a;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e extends a {
    private final String d = "https://outcome-ssp.supersonicads.com/mediation?adUnit=2";
    private final String e = "super.dwh.mediation_events";
    private final String f = "table";
    private final String g = DataSchemeDataSource.SCHEME_DATA;

    e(int i) {
        this.b = i;
    }

    public final String a(ArrayList<c> arrayList, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.a = jSONObject;
        try {
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
            jSONObject2.put("table", "super.dwh.mediation_events");
            jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, a(jSONArray));
            return jSONObject2.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final String b() {
        return "https://outcome-ssp.supersonicads.com/mediation?adUnit=2";
    }

    public final String c() {
        return "ironbeast";
    }
}
