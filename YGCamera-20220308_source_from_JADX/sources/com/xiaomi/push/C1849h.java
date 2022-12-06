package com.xiaomi.push;

import java.lang.Thread;

/* renamed from: com.xiaomi.push.h */
public abstract class C1849h implements Thread.UncaughtExceptionHandler {
    /* renamed from: a */
    public abstract void mo17380a(Thread thread, Throwable th, int i);

    public final void uncaughtException(Thread thread, Throwable th) {
        mo17380a(thread, th, 3);
    }
}
