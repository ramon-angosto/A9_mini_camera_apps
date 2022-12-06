package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.opendevice.C0852f;
import com.huawei.hms.opendevice.C0855i;
import com.huawei.hms.support.log.HMSLog;

public class AutoInitHelper {
    public static void doAutoInit(Context context) {
        try {
            if (isAutoInitEnabled(context)) {
                HMSLog.m1379i("AutoInit", "Push init start");
                new Thread(new C0852f(context)).start();
            }
        } catch (Exception e) {
            HMSLog.m1378e("AutoInit", "Push init failed", (Throwable) e);
        }
    }

    public static boolean isAutoInitEnabled(Context context) {
        C0855i a = C0855i.m1144a(context);
        if (a.containsKey("push_kit_auto_init_enabled")) {
            return a.getBoolean("push_kit_auto_init_enabled");
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void setAutoInitEnabled(Context context, boolean z) {
        C0855i a = C0855i.m1144a(context);
        boolean z2 = a.getBoolean("push_kit_auto_init_enabled");
        a.saveBoolean("push_kit_auto_init_enabled", z);
        if (z && !z2) {
            doAutoInit(context);
        }
    }
}
