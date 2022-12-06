package com.bytedance.sdk.openadsdk.core.f;

import com.bytedance.sdk.openadsdk.core.model.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VastAdConfig */
public class a {
    d a = new d(this);
    b b;
    c c;
    private String d;
    private String e;
    private String f;
    private String g;
    private double h;
    private int i;
    private int j;
    private String k;
    private Set<j> l = new HashSet();
    private String m = "VAST_ACTION_BUTTON";
    private boolean n = false;

    public d a() {
        return this.a;
    }

    public b b() {
        return this.b;
    }

    public c c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public void a(b bVar) {
        if (bVar != null) {
            bVar.a(this.g);
        }
        this.b = bVar;
    }

    public void a(c cVar) {
        if (cVar != null) {
            cVar.a(this.g);
        }
        this.c = cVar;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public void d(String str) {
        this.g = str;
    }

    public double h() {
        return this.h;
    }

    public void a(double d2) {
        this.h = d2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String i() {
        /*
            r5 = this;
            java.lang.String r0 = r5.f
            java.lang.String r1 = r5.m
            int r2 = r1.hashCode()
            r3 = -360520052(0xffffffffea82e68c, float:-7.912454E25)
            r4 = 1
            if (r2 == r3) goto L_0x001e
            r3 = 519982247(0x1efe4ca7, float:2.6924999E-20)
            if (r2 == r3) goto L_0x0014
            goto L_0x0028
        L_0x0014:
            java.lang.String r2 = "VAST_END_CARD"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0028
            r1 = r4
            goto L_0x0029
        L_0x001e:
            java.lang.String r2 = "VAST_ICON"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0028
            r1 = 0
            goto L_0x0029
        L_0x0028:
            r1 = -1
        L_0x0029:
            if (r1 == 0) goto L_0x0035
            if (r1 == r4) goto L_0x002e
            goto L_0x003b
        L_0x002e:
            com.bytedance.sdk.openadsdk.core.f.c r1 = r5.c
            if (r1 == 0) goto L_0x003b
            java.lang.String r0 = r1.h
            goto L_0x003b
        L_0x0035:
            com.bytedance.sdk.openadsdk.core.f.b r1 = r5.b
            if (r1 == 0) goto L_0x003b
            java.lang.String r0 = r1.h
        L_0x003b:
            java.lang.String r1 = "VAST_ACTION_BUTTON"
            r5.m = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.f.a.i():java.lang.String");
    }

    public void e(String str) {
        this.m = str;
    }

    public JSONObject j() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("videoTrackers", this.a.a());
        b bVar = this.b;
        if (bVar != null) {
            jSONObject.put("vastIcon", bVar.a());
        }
        c cVar = this.c;
        if (cVar != null) {
            jSONObject.put("endCard", cVar.a());
        }
        jSONObject.put(CampaignEx.JSON_KEY_TITLE, this.d);
        jSONObject.put("description", this.e);
        jSONObject.put("clickThroughUrl", this.f);
        jSONObject.put("videoUrl", this.g);
        jSONObject.put("videDuration", this.h);
        jSONObject.put("tag", this.k);
        jSONObject.put("videoWidth", this.i);
        jSONObject.put("videoHeight", this.j);
        jSONObject.put("viewabilityVendor", p());
        return jSONObject;
    }

    private JSONArray p() {
        JSONArray jSONArray = new JSONArray();
        for (j next : this.l) {
            if (next != null) {
                jSONArray.put(next.d());
            }
        }
        return jSONArray;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.a.a(jSONObject.optJSONObject("videoTrackers"));
        aVar.b = b.a(jSONObject.optJSONObject("vastIcon"));
        aVar.c = c.b(jSONObject.optJSONObject("endCard"));
        aVar.d = jSONObject.optString(CampaignEx.JSON_KEY_TITLE);
        aVar.e = jSONObject.optString("description");
        aVar.f = jSONObject.optString("clickThroughUrl");
        aVar.g = jSONObject.optString("videoUrl");
        aVar.h = jSONObject.optDouble("videDuration");
        aVar.k = jSONObject.optString("tag");
        aVar.i = jSONObject.optInt("videoWidth");
        aVar.i = jSONObject.optInt("videoHeight");
        aVar.l.addAll(j.a(jSONObject.optJSONArray("viewabilityVendor")));
        return aVar;
    }

    public void a(n nVar) {
        this.a.a(nVar);
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(nVar);
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(nVar);
        }
    }

    public String k() {
        return this.k;
    }

    public void f(String str) {
        this.k = str;
        this.a.a(str);
    }

    public void a(int i2) {
        this.i = i2;
    }

    public void b(int i2) {
        this.j = i2;
    }

    public int l() {
        return this.i;
    }

    public int m() {
        return this.j;
    }

    public void a(Set<j> set) {
        if (set != null && set.size() > 0) {
            this.l.addAll(set);
        }
    }

    public Set<j> n() {
        return this.l;
    }

    public void o() {
        this.n = true;
    }
}
