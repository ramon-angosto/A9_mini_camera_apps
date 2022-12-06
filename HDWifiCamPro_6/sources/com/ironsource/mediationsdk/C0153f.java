package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.ironsource.environment.l;
import com.ironsource.mediationsdk.a.h;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.g;
import com.ironsource.mediationsdk.utils.k;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.f  reason: case insensitive filesystem */
public final class C0153f {
    private static C0153f b = new C0153f();
    private final AtomicBoolean a = new AtomicBoolean(false);

    /* renamed from: com.ironsource.mediationsdk.f$a */
    public static class a {
        String a;
        List<com.ironsource.mediationsdk.server.b> b;
        com.ironsource.mediationsdk.server.b c;
        JSONObject d;
        JSONObject e;
        int f;
        String g;
    }

    /* renamed from: com.ironsource.mediationsdk.f$b */
    static class b implements Runnable {
        private String a;
        private String b;
        private String c;

        public b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        public final void run() {
            boolean z = false;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.c).openConnection();
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
                httpURLConnection.setReadTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
                httpURLConnection.setConnectTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                httpURLConnection.disconnect();
                if (responseCode == 200 || responseCode == 204) {
                    z = true;
                }
            } catch (Exception unused) {
                IronLog.INTERNAL.error("exception - e");
            }
            if (!z) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
                    jSONObject.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
                    jSONObject.put(IronSourceConstants.EVENTS_EXT1, this.a + ";" + this.b + ";" + this.c);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                h.e().b(new com.ironsource.mediationsdk.a.c(IronSourceConstants.TROUBLESHOOTING_FAILED_TO_SEND_AUCTION_URL, jSONObject));
            }
        }
    }

    /* renamed from: com.ironsource.mediationsdk.f$c */
    enum c {
        ;
        
        public static final int a = 1;
        public static final int b = 2;

        static {
            c = new int[]{1, 2};
        }
    }

    static a a(JSONObject jSONObject) {
        String optString = jSONObject.optString(IronSourceConstants.EVENTS_AUCTION_ID);
        if (!TextUtils.isEmpty(optString)) {
            a aVar = new a();
            aVar.a = optString;
            JSONObject jSONObject2 = null;
            if (jSONObject.has("settings")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("settings");
                aVar.c = new com.ironsource.mediationsdk.server.b(jSONObject3);
                if (jSONObject3.has("armData")) {
                    jSONObject2 = jSONObject3.optJSONObject("armData");
                }
                if (jSONObject3.has(IronSourceConstants.EVENTS_GENERIC_PARAMS)) {
                    aVar.d = jSONObject3.optJSONObject(IronSourceConstants.EVENTS_GENERIC_PARAMS);
                }
                if (jSONObject3.has("configurations")) {
                    aVar.e = jSONObject3.optJSONObject("configurations");
                }
            }
            aVar.b = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("waterfall");
            int i = 0;
            while (i < jSONArray.length()) {
                com.ironsource.mediationsdk.server.b bVar = new com.ironsource.mediationsdk.server.b(jSONArray.getJSONObject(i), jSONObject2);
                if (bVar.g()) {
                    aVar.b.add(bVar);
                    i++;
                } else {
                    aVar.f = 1002;
                    aVar.g = "waterfall " + i;
                    throw new JSONException("invalid response");
                }
            }
            return aVar;
        }
        throw new JSONException("Invalid auction response - auction id is missing");
    }

    public static C0153f a() {
        return b;
    }

    public static com.ironsource.mediationsdk.server.b a(String str, List<com.ironsource.mediationsdk.server.b> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).a().equals(str)) {
                return list.get(i);
            }
        }
        return null;
    }

    public static String a(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7) {
        return str.replace("${AUCTION_PRICE}", str4).replace("${AUCTION_LOSS}", str6).replace("${AUCTION_MBR}", str5).replace("${INSTANCE}", str2).replace("${INSTANCE_TYPE}", Integer.toString(i)).replace("${DYNAMIC_DEMAND_SOURCE}", str3).replace("${PLACEMENT_NAME}", str7);
    }

    static JSONObject a(String str) {
        try {
            return new JSONObject(IronSourceAES.decode(g.a().b(), str));
        } catch (Exception unused) {
            return null;
        }
    }

    private static JSONObject a(JSONObject jSONObject, List<String> list) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if (list.contains(next)) {
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject2;
    }

    static void a(String str, String str2, String str3) {
        com.ironsource.environment.e.c.a.c(new b(str, str2, str3));
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.has(next)) {
                    int i = 0;
                    str = next;
                    while (jSONObject.has(str)) {
                        i++;
                        str = next + "_" + i;
                    }
                } else {
                    str = next;
                }
                try {
                    jSONObject.put(str, jSONObject2.opt(next));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (((com.ironsource.environment.ContextProvider.getInstance().getApplicationContext().getApplicationInfo().flags & 134217728) != 0) != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (android.security.NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() != false) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b() {
        /*
            int r0 = com.ironsource.mediationsdk.C0153f.c.b
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L_0x0016
            android.security.NetworkSecurityPolicy r0 = android.security.NetworkSecurityPolicy.getInstance()
            boolean r0 = r0.isCleartextTrafficPermitted()
            if (r0 == 0) goto L_0x0013
            goto L_0x0034
        L_0x0013:
            int r0 = com.ironsource.mediationsdk.C0153f.c.b
            goto L_0x0036
        L_0x0016:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L_0x0034
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r0 = r0.getApplicationContext()
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            int r0 = r0.flags
            r1 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0031
            r0 = 1
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            if (r0 == 0) goto L_0x0013
        L_0x0034:
            int r0 = com.ironsource.mediationsdk.C0153f.c.a
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0153f.b():int");
    }

    public static Map<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj instanceof String) {
                        hashMap.put(next, (String) obj);
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return hashMap;
    }

    private JSONObject b(JSONObject jSONObject, List<String> list) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    HashMap<String, String> hashMap = l.b;
                    String str = hashMap.containsKey(next) ? hashMap.get(next) : next;
                    if ((list.isEmpty() && !l.a.contains(str) && !str.startsWith("metadata_")) || list.contains(str)) {
                        jSONObject2.put(str, jSONObject.opt(next));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject2;
    }

    public static String c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has("adMarkup") ? jSONObject.getString("adMarkup") : str;
        } catch (JSONException unused) {
            return str;
        }
    }

    public static String d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("params")) {
                return "";
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            return jSONObject2.has(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID) ? jSONObject2.getString(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID) : "";
        } catch (JSONException unused) {
            return "";
        }
    }

    public final String a(String str, int i, com.ironsource.mediationsdk.server.b bVar, String str2, String str3, String str4) {
        String str5;
        String c2 = bVar.c();
        if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(str2)) {
            double parseDouble = Double.parseDouble(c2);
            double parseDouble2 = Double.parseDouble(str2);
            if (parseDouble2 != 0.0d) {
                str5 = String.valueOf(((double) Math.round((parseDouble / parseDouble2) * 1000.0d)) / 1000.0d);
                return a(str, bVar.a(), i, d(bVar.b()), c2, str5, str3, str4);
            }
        }
        str5 = "";
        return a(str, bVar.a(), i, d(bVar.b()), c2, str5, str3, str4);
    }

    /* access modifiers changed from: package-private */
    public final JSONObject a(Context context, Map<String, Object> map, List<String> list, C0156i iVar, int i, String str, com.ironsource.mediationsdk.utils.c cVar, ISBannerSize iSBannerSize, JSONObject jSONObject) {
        String str2;
        String str3;
        C0156i iVar2 = iVar;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            str2 = "";
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("instanceType", 2);
            Map<String, Object> map2 = map;
            jSONObject4.put("biddingAdditionalData", new JSONObject((Map) map.get(next)));
            if (iVar2 != null) {
                str2 = iVar2.a(next);
            }
            jSONObject4.put("performance", str2);
            jSONObject3.put(next, jSONObject4);
        }
        if (list != null) {
            for (String next2 : list) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("instanceType", 1);
                jSONObject5.put("performance", iVar2 != null ? iVar2.a(next2) : str2);
                jSONObject3.put(next2, jSONObject5);
            }
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = C0151d.a().c;
        concurrentHashMap.putAll(k.a().d());
        JSONObject jSONObject6 = new JSONObject();
        for (Map.Entry next3 : concurrentHashMap.entrySet()) {
            jSONObject6.put((String) next3.getKey(), TextUtils.join(",", (Iterable) next3.getValue()));
        }
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put("applicationUserId", H.a().k);
        Boolean bool = H.a().y;
        if (bool != null) {
            jSONObject7.put("consent", bool.booleanValue() ? 1 : 0);
        }
        jSONObject7.put("mobileCarrier", com.ironsource.environment.h.i(context));
        jSONObject7.put("connectionType", IronSourceUtils.getConnectionType(context));
        jSONObject7.put("deviceOS", "android");
        jSONObject7.put("deviceWidth", context.getResources().getConfiguration().screenWidthDp);
        jSONObject7.put("deviceHeight", context.getResources().getConfiguration().screenHeightDp);
        jSONObject7.put("deviceOSVersion", Build.VERSION.SDK_INT + "(" + Build.VERSION.RELEASE + ")");
        jSONObject7.put("deviceModel", Build.MODEL);
        jSONObject7.put("deviceMake", Build.MANUFACTURER);
        jSONObject7.put("bundleId", context.getPackageName());
        Context context2 = context;
        jSONObject7.put("appVersion", com.ironsource.environment.c.c(context, context.getPackageName()));
        jSONObject7.put("clientTimestamp", new Date().getTime());
        jSONObject7.put("fs", IronSourceUtils.getFirstSession(context) ? 1 : 0);
        jSONObject7.put("browserUserAgent", com.ironsource.environment.h.r());
        jSONObject7.put("deviceType", IronSourceUtils.getDeviceType(context));
        jSONObject7.put("deviceLang", Locale.getDefault().getLanguage());
        jSONObject7.put("secure", b() - 1);
        if (iSBannerSize != null) {
            jSONObject7.put("bannerSize", iSBannerSize.getDescription());
            jSONObject7.put("bannerWidth", iSBannerSize.getWidth());
            jSONObject7.put("bannerHeight", iSBannerSize.getHeight());
        }
        String[] C = com.ironsource.environment.h.C(context);
        boolean z = false;
        if (C == null || C.length != 2) {
            str3 = str2;
        } else {
            str3 = !TextUtils.isEmpty(C[0]) ? C[0] : str2;
            z = Boolean.valueOf(C[1]).booleanValue();
        }
        if (!TextUtils.isEmpty(str3)) {
            str2 = IronSourceConstants.TYPE_GAID;
        } else {
            str3 = com.ironsource.environment.h.x(context);
            if (!TextUtils.isEmpty(str3)) {
                str2 = IronSourceConstants.TYPE_UUID;
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            jSONObject7.put("advId", str3);
            jSONObject7.put("advIdType", str2);
            jSONObject7.put("isLimitAdTrackingEnabled", z ? "true" : "false");
        }
        String B = com.ironsource.environment.h.B(context);
        if (!TextUtils.isEmpty(B)) {
            jSONObject7.put("asid", B);
        }
        String y = com.ironsource.environment.h.y(context);
        if (!TextUtils.isEmpty(y)) {
            jSONObject7.put("auid", y);
        }
        JSONObject jSONObject8 = new JSONObject();
        jSONObject8.put("applicationKey", H.a().j);
        jSONObject8.put("SDKVersion", IronSourceUtils.getSDKVersion());
        jSONObject8.put("clientParams", jSONObject7);
        jSONObject8.put(IronSourceConstants.KEY_SESSION_DEPTH, i);
        jSONObject8.put("sessionId", str);
        jSONObject8.put("instances", jSONObject3);
        jSONObject8.put("auctionData", cVar.c);
        jSONObject8.put("metaData", jSONObject6);
        if (jSONObject2 != null) {
            jSONObject8.put("sg", jSONObject2);
        }
        return jSONObject8;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject a(String str, boolean z, Map<String, Object> map, List<String> list, C0156i iVar, int i, ISBannerSize iSBannerSize, JSONObject jSONObject) {
        String str2;
        C0156i iVar2 = iVar;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            str2 = "";
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("instp", 2);
            Map<String, Object> map2 = map;
            jSONObject5.put("badt", new JSONObject((Map) map.get(next)));
            if (iVar2 != null) {
                str2 = iVar2.a(next);
            }
            jSONObject5.put("prfm", str2);
            jSONObject4.put(next, jSONObject5);
        }
        if (list != null) {
            for (String next2 : list) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("instp", 1);
                jSONObject6.put("prfm", iVar2 != null ? iVar2.a(next2) : str2);
                jSONObject4.put(next2, jSONObject6);
            }
        }
        jSONObject3.put("inst", jSONObject4);
        com.ironsource.environment.a.b bVar = new com.ironsource.environment.a.b();
        JSONObject a2 = bVar.b.a(bVar.a);
        Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDataByKeys(mAuctionKeyList)");
        JSONObject a3 = com.ironsource.environment.c.b.a(a2.optJSONObject("md"));
        if (a3 != null) {
            a2.put("md", a3);
        }
        a(a2, false);
        a2.put("sd", i);
        a2.put("scr", b() - 1);
        if (jSONObject2 != null) {
            a2.put("sg", jSONObject2);
        }
        jSONObject3.put("ctdt", a2);
        if (iSBannerSize != null) {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("bns", iSBannerSize.getDescription());
            jSONObject7.put("bnw", iSBannerSize.getWidth());
            jSONObject7.put("bnh", iSBannerSize.getHeight());
            jSONObject3.put("bndt", jSONObject7);
        }
        String str3 = str;
        jSONObject3.put("adu", str);
        jSONObject3.put("dner", z ^ true ? 1 : 0);
        return jSONObject3;
    }

    public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2, List<String> list) {
        ah a2 = ah.a();
        a2.a(ah.c());
        a2.a(ah.b());
        JSONObject a3 = a(a2.a, list.isEmpty() ? l.a : list);
        a(a3, b(jSONObject, list));
        if (!list.isEmpty()) {
            jSONObject2 = a(jSONObject2, list);
        }
        a(a3, jSONObject2);
        return a3;
    }

    public final void a(JSONObject jSONObject, boolean z) {
        if (!TextUtils.isEmpty(jSONObject.optString("tcs")) && this.a.compareAndSet(false, true)) {
            h.e().b(new com.ironsource.mediationsdk.a.c(IronSourceConstants.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED, IronSourceUtils.getMediationAdditionalData(z, true, -1)));
        }
    }
}
