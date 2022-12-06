package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.huawei.secure.android.common.util.c */
public class C0954c {

    /* renamed from: x */
    private static Handler f1283x = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static void m1662a(Runnable runnable) {
        if (runnable != null) {
            f1283x.post(runnable);
        }
    }
}
