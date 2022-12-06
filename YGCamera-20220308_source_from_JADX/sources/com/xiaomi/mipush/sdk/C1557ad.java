package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.mipush.sdk.ad */
class C1557ad extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ NotificationClickedActivity f1645a;

    C1557ad(NotificationClickedActivity notificationClickedActivity) {
        this.f1645a = notificationClickedActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C1524b.m2158b("clicked activity finish by normal.");
        this.f1645a.finish();
    }
}
