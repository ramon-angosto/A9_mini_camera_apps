package com.bytedance.sdk.openadsdk.core.video.b;

import android.content.Context;
import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PlayableEvent */
public class b {
    public static void a(Context context, n nVar) {
        if (p.a(nVar)) {
            c.e(context, nVar, "playable_preload", "preload_start", (Map<String, Object>) null);
        }
    }

    public static void a(Context context, n nVar, long j, long j2) {
        if (nVar == null) {
            return;
        }
        if (p.i(nVar) || p.a(nVar)) {
            HashMap hashMap = new HashMap();
            hashMap.put("loadzip_success_time", Long.valueOf(j));
            hashMap.put("unzip_success_time", Long.valueOf(j2));
            c.e(context, nVar, "playable_preload", "preload_success", hashMap);
        }
    }

    public static void a(Context context, n nVar, int i, String str) {
        if (nVar == null) {
            return;
        }
        if (p.i(nVar) || p.a(nVar)) {
            HashMap hashMap = new HashMap();
            hashMap.put("error_code", Integer.valueOf(i));
            hashMap.put("error_reason", str);
            c.e(context, nVar, "playable_preload", "preload_fail", hashMap);
        }
    }
}
