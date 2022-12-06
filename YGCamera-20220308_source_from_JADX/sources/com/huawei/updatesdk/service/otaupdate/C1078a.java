package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;

/* renamed from: com.huawei.updatesdk.service.otaupdate.a */
public abstract class C1078a {
    /* renamed from: a */
    public static void m2079a(Context context, BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null && context != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e) {
                C0968a.m1682b("ActivityUtil", "unregisterReceiver error:" + e.toString());
            }
        }
    }

    /* renamed from: a */
    public static void m2080a(Context context, IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        if (intentFilter != null && broadcastReceiver != null && !m2081a(context)) {
            try {
                context.registerReceiver(broadcastReceiver, intentFilter);
            } catch (IllegalArgumentException e) {
                C0968a.m1682b("ActivityUtil", "registerReceiver error:" + e.toString());
            }
        }
    }

    /* renamed from: a */
    public static boolean m2081a(Context context) {
        if (context == null) {
            return true;
        }
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (!activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            return false;
        }
        C0968a.m1682b("ActivityUtil", "activity has bean finished, cannot instance:" + activity);
        return true;
    }
}
