package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* renamed from: com.huawei.hms.hatool.j1 */
public abstract class C0806j1 {

    /* renamed from: a */
    public static C0800h1 f663a;

    /* renamed from: a */
    public static synchronized C0800h1 m881a() {
        C0800h1 h1Var;
        synchronized (C0806j1.class) {
            if (f663a == null) {
                f663a = C0815m1.m965c().mo14080b();
            }
            h1Var = f663a;
        }
        return h1Var;
    }

    /* renamed from: a */
    public static void m882a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (m881a() != null && C0832u0.m1039b().mo14121a()) {
            if (i == 1 || i == 0) {
                f663a.mo13973a(i, str, linkedHashMap);
                return;
            }
            C0841y.m1089d("hmsSdk", "Data type no longer collects range.type: " + i);
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m883a(Context context, String str, String str2) {
        if (m881a() != null) {
            f663a.mo13974a(context, str, str2);
        }
    }

    /* renamed from: b */
    public static boolean m884b() {
        return C0815m1.m965c().mo14079a();
    }

    /* renamed from: c */
    public static void m885c() {
        if (m881a() != null && C0832u0.m1039b().mo14121a()) {
            f663a.mo13972a(-1);
        }
    }
}
