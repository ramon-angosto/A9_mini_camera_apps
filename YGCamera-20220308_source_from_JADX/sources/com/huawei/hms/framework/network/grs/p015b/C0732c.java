package com.huawei.hms.framework.network.grs.p015b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.C0768a;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.b.c */
public class C0732c extends C0730a {
    public C0732c(Context context, boolean z) {
        this.f477e = z;
        if (mo13812a("grs_sdk_global_route_config.json", context, false) == 0) {
            this.f476d = true;
        }
    }

    /* renamed from: a */
    public int mo13811a(String str) {
        this.f473a = new C0768a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString(SharedPreferencesUtils.USER_NAME);
            long j = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.f473a.mo13904b(string);
            this.f473a.mo13901a(j);
            return (jSONArray == null || jSONArray.length() == 0) ? -1 : 0;
        } catch (JSONException e) {
            Logger.m479w("LocalManagerV1", "parse appbean failed maybe json style is wrong.", (Throwable) e);
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065 A[Catch:{ JSONException -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0086 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.huawei.hms.framework.network.grs.local.model.C0769b> mo13831a(org.json.JSONArray r10, org.json.JSONObject r11) {
        /*
            r9 = this;
            java.lang.String r10 = "countriesOrAreas"
            java.lang.String r0 = "LocalManagerV1"
            if (r11 == 0) goto L_0x0099
            int r1 = r11.length()
            if (r1 != 0) goto L_0x000e
            goto L_0x0099
        L_0x000e:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ JSONException -> 0x008d }
            r2 = 16
            r1.<init>(r2)     // Catch:{ JSONException -> 0x008d }
            java.util.Iterator r3 = r11.keys()     // Catch:{ JSONException -> 0x008d }
        L_0x0019:
            boolean r4 = r3.hasNext()     // Catch:{ JSONException -> 0x008d }
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r3.next()     // Catch:{ JSONException -> 0x008d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x008d }
            com.huawei.hms.framework.network.grs.local.model.b r5 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch:{ JSONException -> 0x008d }
            r5.<init>()     // Catch:{ JSONException -> 0x008d }
            r5.mo13909b(r4)     // Catch:{ JSONException -> 0x008d }
            org.json.JSONObject r4 = r11.getJSONObject(r4)     // Catch:{ JSONException -> 0x008d }
            java.lang.String r6 = "name"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ JSONException -> 0x008d }
            r5.mo13910c(r6)     // Catch:{ JSONException -> 0x008d }
            java.lang.String r6 = "description"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ JSONException -> 0x008d }
            r5.mo13906a((java.lang.String) r6)     // Catch:{ JSONException -> 0x008d }
            r6 = 0
            boolean r7 = r4.has(r10)     // Catch:{ JSONException -> 0x008d }
            java.lang.String r8 = "countries"
            if (r7 == 0) goto L_0x004e
            r8 = r10
            goto L_0x0054
        L_0x004e:
            boolean r7 = r4.has(r8)     // Catch:{ JSONException -> 0x008d }
            if (r7 == 0) goto L_0x0059
        L_0x0054:
            org.json.JSONArray r6 = r4.getJSONArray(r8)     // Catch:{ JSONException -> 0x008d }
            goto L_0x005e
        L_0x0059:
            java.lang.String r4 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.m478w(r0, r4)     // Catch:{ JSONException -> 0x008d }
        L_0x005e:
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ JSONException -> 0x008d }
            r4.<init>(r2)     // Catch:{ JSONException -> 0x008d }
            if (r6 == 0) goto L_0x0086
            int r7 = r6.length()     // Catch:{ JSONException -> 0x008d }
            if (r7 != 0) goto L_0x006c
            goto L_0x0086
        L_0x006c:
            r7 = 0
        L_0x006d:
            int r8 = r6.length()     // Catch:{ JSONException -> 0x008d }
            if (r7 >= r8) goto L_0x007f
            java.lang.Object r8 = r6.get(r7)     // Catch:{ JSONException -> 0x008d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ JSONException -> 0x008d }
            r4.add(r8)     // Catch:{ JSONException -> 0x008d }
            int r7 = r7 + 1
            goto L_0x006d
        L_0x007f:
            r5.mo13907a((java.util.Set<java.lang.String>) r4)     // Catch:{ JSONException -> 0x008d }
            r1.add(r5)     // Catch:{ JSONException -> 0x008d }
            goto L_0x0019
        L_0x0086:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ JSONException -> 0x008d }
            r10.<init>()     // Catch:{ JSONException -> 0x008d }
            return r10
        L_0x008c:
            return r1
        L_0x008d:
            r10 = move-exception
            java.lang.String r11 = "parse countryGroups failed maybe json style is wrong."
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r0, (java.lang.String) r11, (java.lang.Throwable) r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            return r10
        L_0x0099:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p015b.C0732c.mo13831a(org.json.JSONArray, org.json.JSONObject):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033 A[Catch:{ JSONException -> 0x00b0 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034 A[Catch:{ JSONException -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b A[Catch:{ JSONException -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ae A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo13818b(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "countriesOrAreas"
            java.lang.String r1 = "countryOrAreaGroups"
            java.lang.String r2 = "LocalManagerV1"
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 16
            r3.<init>(r4)
            r12.f474b = r3
            r3 = -1
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b0 }
            r5.<init>(r13)     // Catch:{ JSONException -> 0x00b0 }
            boolean r13 = r5.has(r1)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r6 = "countryGroups"
            r7 = 0
            if (r13 == 0) goto L_0x001f
            goto L_0x0026
        L_0x001f:
            boolean r13 = r5.has(r6)     // Catch:{ JSONException -> 0x00b0 }
            if (r13 == 0) goto L_0x002b
            r1 = r6
        L_0x0026:
            org.json.JSONObject r13 = r5.getJSONObject(r1)     // Catch:{ JSONException -> 0x00b0 }
            goto L_0x0031
        L_0x002b:
            java.lang.String r13 = "maybe local config json is wrong because the default countryOrAreaGroups isn't config."
            com.huawei.hms.framework.common.Logger.m471e(r2, r13)     // Catch:{ JSONException -> 0x00b0 }
            r13 = r7
        L_0x0031:
            if (r13 != 0) goto L_0x0034
            return r3
        L_0x0034:
            int r1 = r13.length()     // Catch:{ JSONException -> 0x00b0 }
            r5 = 0
            if (r1 == 0) goto L_0x00af
            java.util.Iterator r1 = r13.keys()     // Catch:{ JSONException -> 0x00b0 }
        L_0x003f:
            boolean r6 = r1.hasNext()     // Catch:{ JSONException -> 0x00b0 }
            if (r6 == 0) goto L_0x00af
            java.lang.Object r6 = r1.next()     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x00b0 }
            com.huawei.hms.framework.network.grs.local.model.b r8 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch:{ JSONException -> 0x00b0 }
            r8.<init>()     // Catch:{ JSONException -> 0x00b0 }
            r8.mo13909b(r6)     // Catch:{ JSONException -> 0x00b0 }
            org.json.JSONObject r6 = r13.getJSONObject(r6)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r9 = "name"
            java.lang.String r9 = r6.getString(r9)     // Catch:{ JSONException -> 0x00b0 }
            r8.mo13910c(r9)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r9 = "description"
            java.lang.String r9 = r6.getString(r9)     // Catch:{ JSONException -> 0x00b0 }
            r8.mo13906a((java.lang.String) r9)     // Catch:{ JSONException -> 0x00b0 }
            boolean r9 = r6.has(r0)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r10 = "countries"
            if (r9 == 0) goto L_0x0073
            r10 = r0
            goto L_0x0079
        L_0x0073:
            boolean r9 = r6.has(r10)     // Catch:{ JSONException -> 0x00b0 }
            if (r9 == 0) goto L_0x007e
        L_0x0079:
            org.json.JSONArray r6 = r6.getJSONArray(r10)     // Catch:{ JSONException -> 0x00b0 }
            goto L_0x0084
        L_0x007e:
            java.lang.String r6 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.m478w(r2, r6)     // Catch:{ JSONException -> 0x00b0 }
            r6 = r7
        L_0x0084:
            java.util.HashSet r9 = new java.util.HashSet     // Catch:{ JSONException -> 0x00b0 }
            r9.<init>(r4)     // Catch:{ JSONException -> 0x00b0 }
            if (r6 == 0) goto L_0x00ae
            int r10 = r6.length()     // Catch:{ JSONException -> 0x00b0 }
            if (r10 != 0) goto L_0x0092
            goto L_0x00ae
        L_0x0092:
            r10 = 0
        L_0x0093:
            int r11 = r6.length()     // Catch:{ JSONException -> 0x00b0 }
            if (r10 >= r11) goto L_0x00a5
            java.lang.Object r11 = r6.get(r10)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x00b0 }
            r9.add(r11)     // Catch:{ JSONException -> 0x00b0 }
            int r10 = r10 + 1
            goto L_0x0093
        L_0x00a5:
            r8.mo13907a((java.util.Set<java.lang.String>) r9)     // Catch:{ JSONException -> 0x00b0 }
            java.util.List<com.huawei.hms.framework.network.grs.local.model.b> r6 = r12.f474b     // Catch:{ JSONException -> 0x00b0 }
            r6.add(r8)     // Catch:{ JSONException -> 0x00b0 }
            goto L_0x003f
        L_0x00ae:
            return r3
        L_0x00af:
            return r5
        L_0x00b0:
            r13 = move-exception
            java.lang.String r0 = "parse countrygroup failed maybe json style is wrong."
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p015b.C0732c.mo13818b(java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x009b A[Catch:{ JSONException -> 0x0106 }, LOOP:2: B:38:0x0095->B:40:0x009b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f3 A[Catch:{ JSONException -> 0x0106 }] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo13824e(java.lang.String r19) {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r0 = "countryOrAreaGroup"
            java.lang.String r2 = "countryGroups"
            java.lang.String r3 = "countryOrAreaGroups"
            java.lang.String r4 = "LocalManagerV1"
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0106 }
            r6 = r19
            r5.<init>(r6)     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r6 = "services"
            org.json.JSONObject r5 = r5.getJSONObject(r6)     // Catch:{ JSONException -> 0x0106 }
            java.util.Iterator r6 = r5.keys()     // Catch:{ JSONException -> 0x0106 }
        L_0x001b:
            boolean r7 = r6.hasNext()     // Catch:{ JSONException -> 0x0106 }
            r8 = 0
            if (r7 == 0) goto L_0x0105
            java.lang.Object r7 = r6.next()     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ JSONException -> 0x0106 }
            com.huawei.hms.framework.network.grs.local.model.c r9 = new com.huawei.hms.framework.network.grs.local.model.c     // Catch:{ JSONException -> 0x0106 }
            r9.<init>()     // Catch:{ JSONException -> 0x0106 }
            r9.mo13916b(r7)     // Catch:{ JSONException -> 0x0106 }
            java.util.Set<java.lang.String> r10 = r1.f478f     // Catch:{ JSONException -> 0x0106 }
            boolean r10 = r10.contains(r7)     // Catch:{ JSONException -> 0x0106 }
            if (r10 != 0) goto L_0x001b
            java.util.Set<java.lang.String> r10 = r1.f478f     // Catch:{ JSONException -> 0x0106 }
            r10.add(r7)     // Catch:{ JSONException -> 0x0106 }
            boolean r10 = r1.f477e     // Catch:{ JSONException -> 0x0106 }
            if (r10 == 0) goto L_0x001b
            org.json.JSONObject r10 = r5.getJSONObject(r7)     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r11 = "routeBy"
            java.lang.String r11 = r10.getString(r11)     // Catch:{ JSONException -> 0x0106 }
            r9.mo13917c(r11)     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r11 = "servings"
            org.json.JSONArray r11 = r10.getJSONArray(r11)     // Catch:{ JSONException -> 0x0106 }
        L_0x0054:
            int r12 = r11.length()     // Catch:{ JSONException -> 0x0106 }
            if (r8 >= r12) goto L_0x00c8
            java.lang.Object r12 = r11.get(r8)     // Catch:{ JSONException -> 0x0106 }
            org.json.JSONObject r12 = (org.json.JSONObject) r12     // Catch:{ JSONException -> 0x0106 }
            com.huawei.hms.framework.network.grs.local.model.d r13 = new com.huawei.hms.framework.network.grs.local.model.d     // Catch:{ JSONException -> 0x0106 }
            r13.<init>()     // Catch:{ JSONException -> 0x0106 }
            boolean r14 = r12.has(r0)     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r15 = "countryGroup"
            if (r14 == 0) goto L_0x006f
            r15 = r0
            goto L_0x0075
        L_0x006f:
            boolean r14 = r12.has(r15)     // Catch:{ JSONException -> 0x0106 }
            if (r14 == 0) goto L_0x007a
        L_0x0075:
            java.lang.String r14 = r12.getString(r15)     // Catch:{ JSONException -> 0x0106 }
            goto L_0x0081
        L_0x007a:
            java.lang.String r14 = "maybe this service routeBy is unconditional."
            com.huawei.hms.framework.common.Logger.m476v(r4, r14)     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r14 = "no-country"
        L_0x0081:
            r13.mo13919a((java.lang.String) r14)     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r14 = "addresses"
            org.json.JSONObject r12 = r12.getJSONObject(r14)     // Catch:{ JSONException -> 0x0106 }
            java.util.HashMap r14 = new java.util.HashMap     // Catch:{ JSONException -> 0x0106 }
            r15 = 16
            r14.<init>(r15)     // Catch:{ JSONException -> 0x0106 }
            java.util.Iterator r15 = r12.keys()     // Catch:{ JSONException -> 0x0106 }
        L_0x0095:
            boolean r16 = r15.hasNext()     // Catch:{ JSONException -> 0x0106 }
            if (r16 == 0) goto L_0x00b3
            java.lang.Object r16 = r15.next()     // Catch:{ JSONException -> 0x0106 }
            r17 = r0
            r0 = r16
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x0106 }
            r19 = r5
            java.lang.String r5 = r12.getString(r0)     // Catch:{ JSONException -> 0x0106 }
            r14.put(r0, r5)     // Catch:{ JSONException -> 0x0106 }
            r5 = r19
            r0 = r17
            goto L_0x0095
        L_0x00b3:
            r17 = r0
            r19 = r5
            r13.mo13920a((java.util.Map<java.lang.String, java.lang.String>) r14)     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r0 = r13.mo13921b()     // Catch:{ JSONException -> 0x0106 }
            r9.mo13913a(r0, r13)     // Catch:{ JSONException -> 0x0106 }
            int r8 = r8 + 1
            r5 = r19
            r0 = r17
            goto L_0x0054
        L_0x00c8:
            r17 = r0
            r19 = r5
            boolean r0 = r10.has(r3)     // Catch:{ JSONException -> 0x0106 }
            r5 = 0
            if (r0 == 0) goto L_0x00d8
            org.json.JSONObject r0 = r10.getJSONObject(r3)     // Catch:{ JSONException -> 0x0106 }
            goto L_0x00e2
        L_0x00d8:
            boolean r0 = r10.has(r2)     // Catch:{ JSONException -> 0x0106 }
            if (r0 == 0) goto L_0x00e7
            org.json.JSONObject r0 = r10.getJSONObject(r2)     // Catch:{ JSONException -> 0x0106 }
        L_0x00e2:
            java.util.List r5 = r1.mo13831a(r5, r0)     // Catch:{ JSONException -> 0x0106 }
            goto L_0x00ec
        L_0x00e7:
            java.lang.String r0 = "service use default countryOrAreaGroup"
            com.huawei.hms.framework.common.Logger.m476v(r4, r0)     // Catch:{ JSONException -> 0x0106 }
        L_0x00ec:
            r9.mo13914a((java.util.List<com.huawei.hms.framework.network.grs.local.model.C0769b>) r5)     // Catch:{ JSONException -> 0x0106 }
            com.huawei.hms.framework.network.grs.local.model.a r0 = r1.f473a     // Catch:{ JSONException -> 0x0106 }
            if (r0 != 0) goto L_0x00fa
            com.huawei.hms.framework.network.grs.local.model.a r0 = new com.huawei.hms.framework.network.grs.local.model.a     // Catch:{ JSONException -> 0x0106 }
            r0.<init>()     // Catch:{ JSONException -> 0x0106 }
            r1.f473a = r0     // Catch:{ JSONException -> 0x0106 }
        L_0x00fa:
            com.huawei.hms.framework.network.grs.local.model.a r0 = r1.f473a     // Catch:{ JSONException -> 0x0106 }
            r0.mo13902a(r7, r9)     // Catch:{ JSONException -> 0x0106 }
            r5 = r19
            r0 = r17
            goto L_0x001b
        L_0x0105:
            return r8
        L_0x0106:
            r0 = move-exception
            java.lang.String r2 = "parse 1.0 services failed maybe because of json style.please check!"
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r4, (java.lang.String) r2, (java.lang.Throwable) r0)
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p015b.C0732c.mo13824e(java.lang.String):int");
    }
}
