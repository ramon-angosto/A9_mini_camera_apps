package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* renamed from: com.huawei.secure.android.common.ssl.util.c */
public class C0942c {

    /* renamed from: a */
    private static Context f1240a;

    /* renamed from: a */
    public static Context m1556a() {
        return f1240a;
    }

    /* renamed from: a */
    public static void m1557a(Context context) {
        if (context != null && f1240a == null) {
            f1240a = context.getApplicationContext();
        }
    }
}
