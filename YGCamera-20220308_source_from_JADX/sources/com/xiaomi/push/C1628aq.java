package com.xiaomi.push;

import android.os.Looper;

/* renamed from: com.xiaomi.push.aq */
public class C1628aq {
    /* renamed from: a */
    public static void m2550a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
