package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.n */
public class C1939n {
    /* renamed from: a */
    public static boolean m4732a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
