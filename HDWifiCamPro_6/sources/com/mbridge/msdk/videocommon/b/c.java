package com.mbridge.msdk.videocommon.b;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Reward */
public final class c {
    private String a;
    private int b;

    public c(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final int b() {
        return this.b;
    }

    public final void a(int i) {
        this.b = i;
    }

    private static c c() {
        return new c("Virtual Item", 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[Catch:{ Exception -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.videocommon.b.c b(java.lang.String r3) {
        /*
            r0 = 0
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x002f }
            com.mbridge.msdk.videocommon.d.a r1 = r1.b()     // Catch:{ Exception -> 0x002f }
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x002f }
            if (r2 == 0) goto L_0x0015
            com.mbridge.msdk.videocommon.b.c r3 = c()     // Catch:{ Exception -> 0x002f }
        L_0x0013:
            r0 = r3
            goto L_0x0028
        L_0x0015:
            if (r1 == 0) goto L_0x0028
            java.util.Map r2 = r1.i()     // Catch:{ Exception -> 0x002f }
            if (r2 == 0) goto L_0x0028
            java.util.Map r1 = r1.i()     // Catch:{ Exception -> 0x002f }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ Exception -> 0x002f }
            com.mbridge.msdk.videocommon.b.c r3 = (com.mbridge.msdk.videocommon.b.c) r3     // Catch:{ Exception -> 0x002f }
            goto L_0x0013
        L_0x0028:
            if (r0 != 0) goto L_0x0033
            com.mbridge.msdk.videocommon.b.c r0 = c()     // Catch:{ Exception -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.b.c.b(java.lang.String):com.mbridge.msdk.videocommon.b.c");
    }

    public static Map<String, c> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                hashMap.put(optJSONObject.optString("id"), new c(optJSONObject.optString("name"), optJSONObject.optInt(RewardPlus.AMOUNT)));
            }
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("name");
            int optInt = jSONObject.optInt(RewardPlus.AMOUNT);
            jSONObject.optString("id");
            return new c(optString, optInt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String toString() {
        return "Reward{name='" + this.a + '\'' + ", amount=" + this.b + '}';
    }
}
