package com.huawei.secure.android.common.util;

import android.os.Looper;

/* renamed from: com.huawei.secure.android.common.util.b */
public class C0953b {
    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
