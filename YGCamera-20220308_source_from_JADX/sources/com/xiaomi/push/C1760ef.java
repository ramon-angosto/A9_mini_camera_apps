package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.util.HashMap;

/* renamed from: com.xiaomi.push.ef */
public class C1760ef {
    /* renamed from: a */
    public static void m3335a(Context context, String str, int i, String str2) {
        C1618ak.m2518a(context).mo17212a((Runnable) new C1761eg(context, str, i, str2));
    }

    /* renamed from: a */
    private static void m3336a(Context context, HashMap<String, String> hashMap) {
        C1768en a = C1764ej.m3355a(context).mo17523a();
        if (a != null) {
            a.mo17185a(context, hashMap);
        }
    }

    /* renamed from: b */
    private static void m3338b(Context context, HashMap<String, String> hashMap) {
        C1768en a = C1764ej.m3355a(context).mo17523a();
        if (a != null) {
            a.mo17187c(context, hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m3339c(Context context, String str, int i, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("awake_info", str);
                hashMap.put("event_type", String.valueOf(i));
                hashMap.put("description", str2);
                int a = C1764ej.m3355a(context).mo17523a();
                if (a != 1) {
                    if (a != 2) {
                        if (a == 3) {
                            m3336a(context, hashMap);
                        }
                    }
                    m3340c(context, hashMap);
                } else {
                    m3336a(context, hashMap);
                }
                m3338b(context, hashMap);
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
            }
        }
    }

    /* renamed from: c */
    private static void m3340c(Context context, HashMap<String, String> hashMap) {
        C1768en a = C1764ej.m3355a(context).mo17523a();
        if (a != null) {
            a.mo17186b(context, hashMap);
        }
    }
}
