package com.huawei.android.pushagent;

import com.huawei.android.pushagent.c.a.e;
import java.lang.Thread;

class a implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ PushService a;

    a(PushService pushService) {
        this.a = pushService;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        e.b(PushService.a, "catch uncaughtException, stop service");
        this.a.stopService();
    }
}
