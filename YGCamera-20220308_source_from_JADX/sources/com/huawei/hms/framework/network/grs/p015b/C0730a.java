package com.huawei.hms.framework.network.grs.p015b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C0768a;
import com.huawei.hms.framework.network.grs.local.model.C0769b;
import com.huawei.hms.framework.network.grs.local.model.C0770c;
import com.huawei.hms.framework.network.grs.local.model.C0771d;
import com.huawei.hms.framework.network.grs.p014a.C0726a;
import com.huawei.hms.framework.network.grs.p019d.C0762c;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.b.a */
public abstract class C0730a {

    /* renamed from: a */
    protected C0768a f473a;

    /* renamed from: b */
    protected List<C0769b> f474b;

    /* renamed from: c */
    protected Map<String, String> f475c = new ConcurrentHashMap(16);

    /* renamed from: d */
    protected boolean f476d = false;

    /* renamed from: e */
    protected boolean f477e = false;

    /* renamed from: f */
    protected Set<String> f478f = new HashSet(16);

    /* renamed from: a */
    private int m520a(Context context) {
        int i = -1;
        try {
            String[] list = context.getAssets().list("");
            if (list == null || list.length <= 0) {
                return -1;
            }
            int length = list.length;
            int i2 = 0;
            int i3 = -1;
            while (i2 < length) {
                try {
                    String str = list[i2];
                    if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str) && m524g(C0762c.m673a(str, context)) == 0) {
                        Logger.m474i("AbstractLocalManager", "load SDK_CONFIG_FILE sucess.");
                        i3 = 0;
                    }
                    i2++;
                } catch (IOException unused) {
                    i = i3;
                    Logger.m478w("AbstractLocalManager", "list assets files fail,please check if according to our standard config json files.");
                    return i;
                }
            }
            return i3;
        } catch (IOException unused2) {
            Logger.m478w("AbstractLocalManager", "list assets files fail,please check if according to our standard config json files.");
            return i;
        }
    }

    /* renamed from: a */
    private int m521a(String str, Context context) {
        if (m523f(C0762c.m673a(str, context)) != 0) {
            return -1;
        }
        Logger.m474i("AbstractLocalManager", "load APP_CONFIG_FILE success.");
        return 0;
    }

    /* renamed from: a */
    private Map<String, String> m522a(List<C0769b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (C0769b next : list) {
            if (next.mo13905a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), next.mo13908b());
            }
            if (next.mo13905a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), next.mo13908b());
            }
            if (next.mo13905a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), next.mo13908b());
            }
            if (next.mo13905a().contains(str)) {
                Logger.m476v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, next.mo13908b());
            }
        }
        return concurrentHashMap;
    }

    /* renamed from: f */
    private int m523f(String str) {
        int b;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.f477e && (b = mo13818b(str)) != 0) {
            return b;
        }
        int a = mo13811a(str);
        return a != 0 ? a : mo13824e(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r0 = r1.f474b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r0 = mo13821c(r2);
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m524g(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0008
            r2 = -1
            return r2
        L_0x0008:
            boolean r0 = r1.f477e
            if (r0 == 0) goto L_0x001d
            java.util.List<com.huawei.hms.framework.network.grs.local.model.b> r0 = r1.f474b
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001d
        L_0x0016:
            int r0 = r1.mo13821c(r2)
            if (r0 == 0) goto L_0x001d
            return r0
        L_0x001d:
            int r2 = r1.mo13823d(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p015b.C0730a.m524g(java.lang.String):int");
    }

    /* renamed from: a */
    public abstract int mo13811a(String str);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo13812a(String str, Context context, boolean z) {
        if (m521a(str, context) != 0 && z) {
            return -1;
        }
        m520a(context);
        return 0;
    }

    /* renamed from: a */
    public C0768a mo13813a() {
        return this.f473a;
    }

    /* renamed from: a */
    public String mo13814a(Context context, C0726a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        Map<String, String> a = mo13816a(context, aVar, grsBaseInfo, str, z);
        if (a != null) {
            return a.get(str2);
        }
        Logger.m480w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063 A[Catch:{ JSONException -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.huawei.hms.framework.network.grs.local.model.C0769b> mo13815a(org.json.JSONArray r12) {
        /*
            r11 = this;
            java.lang.String r0 = "countriesOrAreas"
            java.lang.String r1 = "AbstractLocalManager"
            if (r12 == 0) goto L_0x0099
            int r2 = r12.length()
            if (r2 != 0) goto L_0x000e
            goto L_0x0099
        L_0x000e:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ JSONException -> 0x008d }
            r3 = 16
            r2.<init>(r3)     // Catch:{ JSONException -> 0x008d }
            r4 = 0
            r5 = 0
        L_0x0017:
            int r6 = r12.length()     // Catch:{ JSONException -> 0x008d }
            if (r5 >= r6) goto L_0x008c
            org.json.JSONObject r6 = r12.getJSONObject(r5)     // Catch:{ JSONException -> 0x008d }
            com.huawei.hms.framework.network.grs.local.model.b r7 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch:{ JSONException -> 0x008d }
            r7.<init>()     // Catch:{ JSONException -> 0x008d }
            java.lang.String r8 = "id"
            java.lang.String r8 = r6.getString(r8)     // Catch:{ JSONException -> 0x008d }
            r7.mo13909b(r8)     // Catch:{ JSONException -> 0x008d }
            java.lang.String r8 = "name"
            java.lang.String r8 = r6.getString(r8)     // Catch:{ JSONException -> 0x008d }
            r7.mo13910c(r8)     // Catch:{ JSONException -> 0x008d }
            java.lang.String r8 = "description"
            java.lang.String r8 = r6.getString(r8)     // Catch:{ JSONException -> 0x008d }
            r7.mo13906a((java.lang.String) r8)     // Catch:{ JSONException -> 0x008d }
            r8 = 0
            boolean r9 = r6.has(r0)     // Catch:{ JSONException -> 0x008d }
            java.lang.String r10 = "countries"
            if (r9 == 0) goto L_0x004c
            r10 = r0
            goto L_0x0052
        L_0x004c:
            boolean r9 = r6.has(r10)     // Catch:{ JSONException -> 0x008d }
            if (r9 == 0) goto L_0x0057
        L_0x0052:
            org.json.JSONArray r8 = r6.getJSONArray(r10)     // Catch:{ JSONException -> 0x008d }
            goto L_0x005c
        L_0x0057:
            java.lang.String r6 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.m478w(r1, r6)     // Catch:{ JSONException -> 0x008d }
        L_0x005c:
            java.util.HashSet r6 = new java.util.HashSet     // Catch:{ JSONException -> 0x008d }
            r6.<init>(r3)     // Catch:{ JSONException -> 0x008d }
            if (r8 == 0) goto L_0x0086
            int r9 = r8.length()     // Catch:{ JSONException -> 0x008d }
            if (r9 != 0) goto L_0x006a
            goto L_0x0086
        L_0x006a:
            r9 = 0
        L_0x006b:
            int r10 = r8.length()     // Catch:{ JSONException -> 0x008d }
            if (r9 >= r10) goto L_0x007d
            java.lang.Object r10 = r8.get(r9)     // Catch:{ JSONException -> 0x008d }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ JSONException -> 0x008d }
            r6.add(r10)     // Catch:{ JSONException -> 0x008d }
            int r9 = r9 + 1
            goto L_0x006b
        L_0x007d:
            r7.mo13907a((java.util.Set<java.lang.String>) r6)     // Catch:{ JSONException -> 0x008d }
            r2.add(r7)     // Catch:{ JSONException -> 0x008d }
            int r5 = r5 + 1
            goto L_0x0017
        L_0x0086:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ JSONException -> 0x008d }
            r12.<init>()     // Catch:{ JSONException -> 0x008d }
            return r12
        L_0x008c:
            return r2
        L_0x008d:
            r12 = move-exception
            java.lang.String r0 = "parse countrygroup failed maybe json style is wrong."
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            return r12
        L_0x0099:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p015b.C0730a.mo13815a(org.json.JSONArray):java.util.List");
    }

    /* renamed from: a */
    public Map<String, String> mo13816a(Context context, C0726a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        if (!this.f476d) {
            return null;
        }
        C0768a aVar2 = this.f473a;
        if (aVar2 == null) {
            Logger.m478w("AbstractLocalManager", "application data is null.");
            return null;
        }
        C0770c a = aVar2.mo13899a(str);
        if (a == null) {
            Logger.m480w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String a2 = C0735f.m554a(context, aVar, a.mo13915b(), grsBaseInfo, z);
        if (a2 == null) {
            Logger.m480w("AbstractLocalManager", "country not found by routeby in local config{%s}", a.mo13915b());
            return null;
        }
        List<C0769b> a3 = a.mo13912a();
        C0771d a4 = a.mo13911a(((a3 == null || a3.size() == 0) ? this.f475c : m522a(a3, grsBaseInfo, a2)).get(a2));
        if (a4 == null) {
            return null;
        }
        return a4.mo13918a();
    }

    /* renamed from: a */
    public void mo13817a(GrsBaseInfo grsBaseInfo) {
        this.f475c.put("no_route_country", "no-country");
        List<C0769b> list = this.f474b;
        if (list != null && !list.isEmpty()) {
            for (C0769b next : this.f474b) {
                if (next.mo13905a().contains(grsBaseInfo.getIssueCountry())) {
                    this.f475c.put(grsBaseInfo.getIssueCountry(), next.mo13908b());
                }
                if (next.mo13905a().contains(grsBaseInfo.getRegCountry())) {
                    this.f475c.put(grsBaseInfo.getRegCountry(), next.mo13908b());
                }
                if (next.mo13905a().contains(grsBaseInfo.getSerCountry())) {
                    this.f475c.put(grsBaseInfo.getSerCountry(), next.mo13908b());
                }
            }
            this.f474b = null;
        }
    }

    /* renamed from: b */
    public abstract int mo13818b(String str);

    /* renamed from: b */
    public Set<String> mo13819b() {
        return this.f478f;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008f A[LOOP:2: B:20:0x0089->B:22:0x008f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d1  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo13820b(org.json.JSONArray r14) {
        /*
            r13 = this;
            if (r14 == 0) goto L_0x00e1
            int r0 = r14.length()
            if (r0 != 0) goto L_0x000a
            goto L_0x00e1
        L_0x000a:
            r0 = 0
            r1 = 0
        L_0x000c:
            int r2 = r14.length()
            if (r1 >= r2) goto L_0x00e1
            org.json.JSONObject r2 = r14.getJSONObject(r1)
            com.huawei.hms.framework.network.grs.local.model.c r3 = new com.huawei.hms.framework.network.grs.local.model.c
            r3.<init>()
            java.lang.String r4 = "name"
            java.lang.String r4 = r2.getString(r4)
            r3.mo13916b(r4)
            java.util.Set<java.lang.String> r5 = r13.f478f
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto L_0x00dd
            java.util.Set<java.lang.String> r5 = r13.f478f
            r5.add(r4)
            boolean r5 = r13.f477e
            if (r5 == 0) goto L_0x00dd
            java.lang.String r5 = "routeBy"
            java.lang.String r5 = r2.getString(r5)
            r3.mo13917c(r5)
            java.lang.String r5 = "servings"
            org.json.JSONArray r5 = r2.getJSONArray(r5)
            r6 = 0
        L_0x0045:
            int r7 = r5.length()
            java.lang.String r8 = "AbstractLocalManager"
            if (r6 >= r7) goto L_0x00aa
            java.lang.Object r7 = r5.get(r6)
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            com.huawei.hms.framework.network.grs.local.model.d r9 = new com.huawei.hms.framework.network.grs.local.model.d
            r9.<init>()
            java.lang.String r10 = "countryOrAreaGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L_0x0065
        L_0x0060:
            java.lang.String r8 = r7.getString(r10)
            goto L_0x0075
        L_0x0065:
            java.lang.String r10 = "countryGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L_0x006e
            goto L_0x0060
        L_0x006e:
            java.lang.String r10 = "maybe this service routeBy is unconditional."
            com.huawei.hms.framework.common.Logger.m476v(r8, r10)
            java.lang.String r8 = "no-country"
        L_0x0075:
            r9.mo13919a((java.lang.String) r8)
            java.lang.String r8 = "addresses"
            org.json.JSONObject r7 = r7.getJSONObject(r8)
            java.util.HashMap r8 = new java.util.HashMap
            r10 = 16
            r8.<init>(r10)
            java.util.Iterator r10 = r7.keys()
        L_0x0089:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x009d
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = r7.getString(r11)
            r8.put(r11, r12)
            goto L_0x0089
        L_0x009d:
            r9.mo13920a((java.util.Map<java.lang.String, java.lang.String>) r8)
            java.lang.String r7 = r9.mo13921b()
            r3.mo13913a(r7, r9)
            int r6 = r6 + 1
            goto L_0x0045
        L_0x00aa:
            r5 = 0
            java.lang.String r6 = "countryOrAreaGroups"
            boolean r7 = r2.has(r6)
            if (r7 == 0) goto L_0x00bc
        L_0x00b3:
            org.json.JSONArray r2 = r2.getJSONArray(r6)
            java.util.List r5 = r13.mo13815a((org.json.JSONArray) r2)
            goto L_0x00ca
        L_0x00bc:
            java.lang.String r6 = "countryGroups"
            boolean r7 = r2.has(r6)
            if (r7 == 0) goto L_0x00c5
            goto L_0x00b3
        L_0x00c5:
            java.lang.String r2 = "service use default countryOrAreaGroup"
            com.huawei.hms.framework.common.Logger.m474i(r8, r2)
        L_0x00ca:
            r3.mo13914a((java.util.List<com.huawei.hms.framework.network.grs.local.model.C0769b>) r5)
            com.huawei.hms.framework.network.grs.local.model.a r2 = r13.f473a
            if (r2 != 0) goto L_0x00d8
            com.huawei.hms.framework.network.grs.local.model.a r2 = new com.huawei.hms.framework.network.grs.local.model.a
            r2.<init>()
            r13.f473a = r2
        L_0x00d8:
            com.huawei.hms.framework.network.grs.local.model.a r2 = r13.f473a
            r2.mo13902a(r4, r3)
        L_0x00dd:
            int r1 = r1 + 1
            goto L_0x000c
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p015b.C0730a.mo13820b(org.json.JSONArray):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A[Catch:{ JSONException -> 0x003c }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031 A[Catch:{ JSONException -> 0x003c }] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo13821c(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "countryOrAreaGroups"
            java.lang.String r1 = "AbstractLocalManager"
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 16
            r2.<init>(r3)
            r6.f474b = r2
            r2 = -1
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003c }
            r3.<init>(r7)     // Catch:{ JSONException -> 0x003c }
            r7 = 0
            boolean r4 = r3.has(r0)     // Catch:{ JSONException -> 0x003c }
            java.lang.String r5 = "countryGroups"
            if (r4 == 0) goto L_0x001d
            goto L_0x0024
        L_0x001d:
            boolean r0 = r3.has(r5)     // Catch:{ JSONException -> 0x003c }
            if (r0 == 0) goto L_0x0029
            r0 = r5
        L_0x0024:
            org.json.JSONArray r7 = r3.getJSONArray(r0)     // Catch:{ JSONException -> 0x003c }
            goto L_0x002e
        L_0x0029:
            java.lang.String r0 = "maybe local config json is wrong because the default countryOrAreaGroups isn't config."
            com.huawei.hms.framework.common.Logger.m471e(r1, r0)     // Catch:{ JSONException -> 0x003c }
        L_0x002e:
            if (r7 != 0) goto L_0x0031
            return r2
        L_0x0031:
            java.util.List<com.huawei.hms.framework.network.grs.local.model.b> r0 = r6.f474b     // Catch:{ JSONException -> 0x003c }
            java.util.List r7 = r6.mo13815a((org.json.JSONArray) r7)     // Catch:{ JSONException -> 0x003c }
            r0.addAll(r7)     // Catch:{ JSONException -> 0x003c }
            r7 = 0
            return r7
        L_0x003c:
            r7 = move-exception
            java.lang.String r0 = "parse countrygroup failed maybe json style is wrong."
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p015b.C0730a.mo13821c(java.lang.String):int");
    }

    /* renamed from: c */
    public boolean mo13822c() {
        return this.f476d;
    }

    /* renamed from: d */
    public int mo13823d(String str) {
        try {
            mo13820b(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e) {
            Logger.m479w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check!", (Throwable) e);
            return -1;
        }
    }

    /* renamed from: e */
    public abstract int mo13824e(String str);
}
