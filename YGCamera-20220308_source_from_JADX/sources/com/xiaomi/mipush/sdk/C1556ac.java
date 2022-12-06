package com.xiaomi.mipush.sdk;

import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.mipush.sdk.ac */
class C1556ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NotificationClickedActivity f1644a;

    C1556ac(NotificationClickedActivity notificationClickedActivity) {
        this.f1644a = notificationClickedActivity;
    }

    public void run() {
        C1524b.m2141a("clicked activity finish by timeout.");
        this.f1644a.finish();
    }
}
