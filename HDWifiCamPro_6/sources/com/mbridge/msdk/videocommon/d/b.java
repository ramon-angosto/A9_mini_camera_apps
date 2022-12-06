package com.mbridge.msdk.videocommon.d;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.videocommon.c.a;
import com.mbridge.msdk.videocommon.c.c;
import com.mbridge.msdk.videocommon.download.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardSettingManager */
public final class b {
    public static a a = null;
    private static Map<String, c> c = new HashMap();
    private static b d;
    private Object b = new Object();

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (d == null) {
                d = new b();
            }
            bVar = d;
        }
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0047 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.videocommon.d.a b() {
        /*
            r7 = this;
            com.mbridge.msdk.videocommon.d.a r0 = a
            if (r0 != 0) goto L_0x0077
            com.mbridge.msdk.foundation.a.a.a r0 = com.mbridge.msdk.foundation.a.a.a.a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "reward_"
            r1.append(r2)
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r2 = r2.h()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r0.b(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0060
            com.mbridge.msdk.videocommon.d.a r0 = com.mbridge.msdk.videocommon.d.a.a((java.lang.String) r0)
            if (r0 == 0) goto L_0x0044
            long r1 = r0.b()
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = r0.g()
            long r5 = r5 + r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0044
            r1 = 0
            goto L_0x0045
        L_0x0044:
            r1 = 1
        L_0x0045:
            if (r1 != 0) goto L_0x0048
            return r0
        L_0x0048:
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r0 = r0.h()
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r1 = r1.i()
            r7.b(r0, r1)
            com.mbridge.msdk.videocommon.d.a r0 = r7.c()
            return r0
        L_0x0060:
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r0 = r0.h()
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r1 = r1.i()
            r7.b(r0, r1)
            com.mbridge.msdk.videocommon.d.a r0 = r7.c()
        L_0x0077:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.d.b.b():com.mbridge.msdk.videocommon.d.a");
    }

    private void b(String str, String str2) {
        new a().a(com.mbridge.msdk.foundation.controller.a.e().g(), str, str2);
    }

    public final void a(String str, String str2, String str3, c cVar) {
        new a().a(com.mbridge.msdk.foundation.controller.a.e().g(), str, str2, str3, cVar);
    }

    public final c a(String str, String str2) {
        synchronized (this.b) {
            String str3 = "reward" + "_" + str + "_" + str2;
            if (c.containsKey(str3)) {
                c cVar = c.get(str3);
                return cVar;
            }
            c c2 = c.c(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
            if (a(c2)) {
                return null;
            }
            c.put(str3, c2);
            return c2;
        }
    }

    public final c a(String str, String str2, boolean z) {
        synchronized (this.b) {
            String str3 = "reward_" + str + "_" + str2;
            if (c.containsKey(str3)) {
                c cVar = c.get(str3);
                return cVar;
            }
            c c2 = c.c(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
            if (!a(c2)) {
                c.put(str3, c2);
                return c2;
            } else if (c2 != null) {
                return c2;
            } else {
                c a2 = a(z);
                return a2;
            }
        }
    }

    public final a c() {
        a aVar = new a();
        HashMap hashMap = new HashMap(5);
        hashMap.put("1", 1000);
        hashMap.put("9", 1000);
        hashMap.put("8", 1000);
        HashMap hashMap2 = new HashMap(3);
        hashMap2.put("1", new com.mbridge.msdk.videocommon.b.c("Virtual Item", 1));
        aVar.a((Map<String, Integer>) hashMap);
        aVar.b((Map<String, com.mbridge.msdk.videocommon.b.c>) hashMap2);
        aVar.a(43200);
        aVar.b(5400);
        aVar.c(3600);
        aVar.d(3600);
        aVar.e(5);
        aVar.a(1);
        return aVar;
    }

    private final boolean a(c cVar) {
        a b2 = b();
        if (b2 == null || cVar == null) {
            return true;
        }
        return cVar.v() + b2.c() <= System.currentTimeMillis();
    }

    public final void a(String str, String str2, String str3) {
        synchronized (this.b) {
            String str4 = "reward_" + str + "_" + str2;
            com.mbridge.msdk.foundation.a.a.a.a().a(str4, str3);
            c.put(str4, c.c(str3));
            if (!TextUtils.isEmpty(c.a)) {
                c(c.a, str2);
            }
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            a().a(com.mbridge.msdk.foundation.controller.a.e().h(), str, false);
            String str2 = c.a;
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(g.a().b(str2))) {
                c(str2, str);
            }
        }
    }

    private void c(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
            d.a(g, str, str2, 2, "alert url is exception ,url:" + str);
            return;
        }
        g.a().b(str, new g.d() {
            public final void a(String str) {
                d.a(com.mbridge.msdk.foundation.controller.a.e().g(), str, str2, 1, "");
            }

            public final void a(String str, String str2) {
                d.a(com.mbridge.msdk.foundation.controller.a.e().g(), str, str2, 2, str2);
            }
        });
    }

    public static boolean b(String str) {
        JSONArray optJSONArray;
        try {
            if (!TextUtils.isEmpty(str) && (optJSONArray = new JSONObject(str).optJSONArray("unitSetting")) != null) {
                String optString = optJSONArray.optJSONObject(0).optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (optJSONArray == null || optJSONArray.length() <= 0 || TextUtils.isEmpty(optString)) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static c a(boolean z) {
        c cVar = new c();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.mbridge.msdk.videocommon.b.b(1, 15, (com.mbridge.msdk.videocommon.b.a) null));
            cVar.a((List<com.mbridge.msdk.videocommon.b.b>) arrayList);
            cVar.m(1);
            cVar.l(1);
            cVar.n(1);
            cVar.q(1);
            cVar.o(1);
            cVar.p(1);
            cVar.h(3);
            cVar.i(80);
            cVar.j(100);
            cVar.k(0);
            cVar.g(2);
            cVar.e(-1);
            cVar.x(70);
            cVar.d(2);
            if (z) {
                cVar.c(5);
            } else {
                cVar.c(-1);
            }
            cVar.b(0);
            cVar.a(0);
            cVar.f(1);
            cVar.r(1);
            cVar.t(3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(4);
            arrayList2.add(6);
            cVar.a((ArrayList<Integer>) arrayList2);
            cVar.u(1);
            cVar.v(1);
            cVar.w(60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cVar;
    }
}
