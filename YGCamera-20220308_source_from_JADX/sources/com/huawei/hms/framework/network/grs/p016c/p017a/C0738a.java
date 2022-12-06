package com.huawei.hms.framework.network.grs.p016c.p017a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0744d;
import com.huawei.hms.framework.network.grs.p019d.C0762c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.c.a.a */
public class C0738a {

    /* renamed from: a */
    private static final String f487a = "a";

    /* renamed from: b */
    private static C0744d f488b;

    /* renamed from: a */
    public static synchronized C0744d m557a(Context context) {
        synchronized (C0738a.class) {
            C0744d dVar = f488b;
            if (dVar != null) {
                return dVar;
            }
            String a = C0762c.m673a("grs_sdk_server_config.json", context);
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(a)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(a).getJSONObject("grs_server");
                JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                if (jSONArray != null && jSONArray.length() > 0) {
                    arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.get(i).toString());
                    }
                }
                f488b = new C0744d();
                f488b.mo13851a((List<String>) arrayList);
                f488b.mo13853b(jSONObject.getString("grs_query_endpoint_1.0"));
                f488b.mo13850a(jSONObject.getString("grs_query_endpoint_2.0"));
                f488b.mo13849a(jSONObject.getInt("grs_query_timeout"));
            } catch (JSONException e) {
                Logger.m479w(f487a, "getGrsServerBean catch JSONException", (Throwable) e);
            }
            C0744d dVar2 = f488b;
            return dVar2;
        }
    }
}
