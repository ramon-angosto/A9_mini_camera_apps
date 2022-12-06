package com.huawei.hms.framework.network.grs.p016c.p018b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p015b.C0731b;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.c.b.c */
public class C0743c {

    /* renamed from: a */
    private GrsBaseInfo f503a;

    /* renamed from: b */
    private Context f504b;

    /* renamed from: c */
    private Set<String> f505c = new HashSet();

    public C0743c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f503a = grsBaseInfo;
        this.f504b = context;
    }

    /* renamed from: e */
    private String m569e() {
        Set<String> b = C0731b.m539a(this.f504b.getPackageName(), this.f503a).mo13830b();
        if (b.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String put : b) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.m475i("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: f */
    private String m570f() {
        Logger.m476v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String put : this.f505c) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.m477v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public Context mo13843a() {
        return this.f504b;
    }

    /* renamed from: a */
    public void mo13844a(String str) {
        this.f505c.add(str);
    }

    /* renamed from: b */
    public GrsBaseInfo mo13845b() {
        return this.f503a;
    }

    /* renamed from: c */
    public String mo13846c() {
        return this.f505c.size() == 0 ? m569e() : m570f();
    }

    /* renamed from: d */
    public Set<String> mo13847d() {
        return this.f505c;
    }
}
