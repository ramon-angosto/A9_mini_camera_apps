package com.ironsource.mediationsdk.adunit.b;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;

public final class a extends f {
    public a(d dVar) {
        super(dVar);
    }

    public final void a() {
        a(b.SESSION_CAPPED);
    }

    public final void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        a(b.SHOW_AD, hashMap);
    }

    public final void a(String str, int i, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(IronSourceConstants.EVENTS_EXT1, str3);
        }
        a(b.SHOW_AD_FAILED, hashMap);
    }

    public final void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(IronSourceConstants.EVENTS_EXT1, str2);
        }
        a(b.AD_CLOSED, hashMap);
    }

    public final void a(String str, String str2, int i, long j, String str3, long j2, Map<String, Object> map, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        hashMap.put(IronSourceConstants.EVENTS_REWARD_NAME, str2);
        hashMap.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(i));
        hashMap.put(IronSourceConstants.EVENTS_TRANS_ID, str3);
        if (j2 != 0) {
            hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2));
        }
        hashMap.putAll(map);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, str4);
        }
        a(b.AD_REWARDED, hashMap, j);
    }

    public final void a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "true" : "false");
        a(b.SHOW_AD_CHANCE, hashMap);
    }

    public final void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        a(b.SHOW_AD_SUCCESS, hashMap);
    }

    public final void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        a(b.AD_OPENED, hashMap);
    }

    public final void d(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        a(b.AD_CLICKED, hashMap);
    }

    public final void e(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        a(b.AD_STARTED, hashMap);
    }

    public final void f(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        a(b.AD_ENDED, hashMap);
    }

    public final void g(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        a(b.AD_VISIBLE, hashMap);
    }

    public final void h(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", str);
        a(b.PLACEMENT_CAPPED, hashMap);
    }
}
