package com.huawei.hms.framework.network.grs.p015b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.local.model.C0768a;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.b.d */
public class C0733d extends C0730a {
    public C0733d(Context context, boolean z) {
        this.f477e = z;
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.m474i("LocalManagerV2", "appConfigName is" + appConfigName);
        if (mo13812a(TextUtils.isEmpty(appConfigName) ? "grs_app_global_route_config.json" : appConfigName, context, true) == 0) {
            this.f476d = true;
        }
    }

    /* renamed from: a */
    public int mo13811a(String str) {
        this.f473a = new C0768a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONArray("applications").getJSONObject(0);
            this.f473a.mo13904b(jSONObject.getString(SharedPreferencesUtils.USER_NAME));
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    if (jSONObject.has("customservices")) {
                        mo13820b(jSONObject.getJSONArray("customservices"));
                    }
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e) {
            Logger.m479w("LocalManagerV2", "parse appbean failed maybe json style is wrong.", (Throwable) e);
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033 A[Catch:{ JSONException -> 0x00af }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034 A[Catch:{ JSONException -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0088 A[Catch:{ JSONException -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo13818b(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "countriesOrAreas"
            java.lang.String r1 = "countryOrAreaGroups"
            java.lang.String r2 = "LocalManagerV2"
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 16
            r3.<init>(r4)
            r12.f474b = r3
            r3 = -1
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00af }
            r5.<init>(r13)     // Catch:{ JSONException -> 0x00af }
            boolean r13 = r5.has(r1)     // Catch:{ JSONException -> 0x00af }
            java.lang.String r6 = "countryGroups"
            r7 = 0
            if (r13 == 0) goto L_0x001f
            goto L_0x0026
        L_0x001f:
            boolean r13 = r5.has(r6)     // Catch:{ JSONException -> 0x00af }
            if (r13 == 0) goto L_0x002b
            r1 = r6
        L_0x0026:
            org.json.JSONArray r13 = r5.getJSONArray(r1)     // Catch:{ JSONException -> 0x00af }
            goto L_0x0031
        L_0x002b:
            java.lang.String r13 = "maybe local config json is wrong because the default countryOrAreaGroups isn't config."
            com.huawei.hms.framework.common.Logger.m471e(r2, r13)     // Catch:{ JSONException -> 0x00af }
            r13 = r7
        L_0x0031:
            if (r13 != 0) goto L_0x0034
            return r3
        L_0x0034:
            int r1 = r13.length()     // Catch:{ JSONException -> 0x00af }
            r5 = 0
            if (r1 == 0) goto L_0x00ae
            r1 = 0
        L_0x003c:
            int r6 = r13.length()     // Catch:{ JSONException -> 0x00af }
            if (r1 >= r6) goto L_0x00ae
            org.json.JSONObject r6 = r13.getJSONObject(r1)     // Catch:{ JSONException -> 0x00af }
            com.huawei.hms.framework.network.grs.local.model.b r8 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch:{ JSONException -> 0x00af }
            r8.<init>()     // Catch:{ JSONException -> 0x00af }
            java.lang.String r9 = "id"
            java.lang.String r9 = r6.getString(r9)     // Catch:{ JSONException -> 0x00af }
            r8.mo13909b(r9)     // Catch:{ JSONException -> 0x00af }
            java.lang.String r9 = "name"
            java.lang.String r9 = r6.getString(r9)     // Catch:{ JSONException -> 0x00af }
            r8.mo13910c(r9)     // Catch:{ JSONException -> 0x00af }
            java.lang.String r9 = "description"
            java.lang.String r9 = r6.getString(r9)     // Catch:{ JSONException -> 0x00af }
            r8.mo13906a((java.lang.String) r9)     // Catch:{ JSONException -> 0x00af }
            boolean r9 = r6.has(r0)     // Catch:{ JSONException -> 0x00af }
            java.lang.String r10 = "countries"
            if (r9 == 0) goto L_0x0070
            r10 = r0
            goto L_0x0076
        L_0x0070:
            boolean r9 = r6.has(r10)     // Catch:{ JSONException -> 0x00af }
            if (r9 == 0) goto L_0x007b
        L_0x0076:
            org.json.JSONArray r6 = r6.getJSONArray(r10)     // Catch:{ JSONException -> 0x00af }
            goto L_0x0081
        L_0x007b:
            java.lang.String r6 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.m478w(r2, r6)     // Catch:{ JSONException -> 0x00af }
            r6 = r7
        L_0x0081:
            java.util.HashSet r9 = new java.util.HashSet     // Catch:{ JSONException -> 0x00af }
            r9.<init>(r4)     // Catch:{ JSONException -> 0x00af }
            if (r6 == 0) goto L_0x00ad
            int r10 = r6.length()     // Catch:{ JSONException -> 0x00af }
            if (r10 != 0) goto L_0x008f
            goto L_0x00ad
        L_0x008f:
            r10 = 0
        L_0x0090:
            int r11 = r6.length()     // Catch:{ JSONException -> 0x00af }
            if (r10 >= r11) goto L_0x00a2
            java.lang.Object r11 = r6.get(r10)     // Catch:{ JSONException -> 0x00af }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x00af }
            r9.add(r11)     // Catch:{ JSONException -> 0x00af }
            int r10 = r10 + 1
            goto L_0x0090
        L_0x00a2:
            r8.mo13907a((java.util.Set<java.lang.String>) r9)     // Catch:{ JSONException -> 0x00af }
            java.util.List<com.huawei.hms.framework.network.grs.local.model.b> r6 = r12.f474b     // Catch:{ JSONException -> 0x00af }
            r6.add(r8)     // Catch:{ JSONException -> 0x00af }
            int r1 = r1 + 1
            goto L_0x003c
        L_0x00ad:
            return r3
        L_0x00ae:
            return r5
        L_0x00af:
            r13 = move-exception
            java.lang.String r0 = "parse countrygroup failed maybe json style is wrong."
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p015b.C0733d.mo13818b(java.lang.String):int");
    }

    /* renamed from: e */
    public int mo13824e(String str) {
        return mo13823d(str);
    }
}
