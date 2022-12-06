package com.xiaomi.push;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;

/* renamed from: com.xiaomi.push.o */
public abstract class C1940o {
    /* renamed from: a */
    public static void m4733a(Context context) {
    }

    /* renamed from: a */
    public static void m4734a(Context context, String str, boolean z) {
        m4733a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).commit();
    }

    /* renamed from: a */
    public static void m4735a(Map<String, String> map, String str, String str2) {
        if (map != null && str != null && str2 != null) {
            map.put(str, str2);
        }
    }

    /* renamed from: a */
    public static boolean m4736a(Context context, String str, boolean z) {
        m4733a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }
}
