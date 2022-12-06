package com.xiaomi.push;

import android.content.SharedPreferences;
import android.os.Build;

/* renamed from: com.xiaomi.push.s */
public final class C1945s {
    /* renamed from: a */
    public static void m4744a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT > 8) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
