package com.huawei.hms.framework.common;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.List;

public class ActivityUtil {
    private static final String TAG = "ActivityUtil";

    public static boolean isForeground(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) ContextCompat.getSystemService(context, "activity")) == null) {
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> list = null;
        try {
            list = activityManager.getRunningAppProcesses();
        } catch (RuntimeException e) {
            Logger.m479w(TAG, "activityManager getRunningAppProcesses occur exception: ", (Throwable) e);
        }
        if (list == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : list) {
            if (next.processName != null && next.processName.equals(context.getPackageName()) && next.importance == 100) {
                Logger.m476v(TAG, "isForeground true");
                return true;
            }
        }
        return false;
    }

    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2) {
        if (context == null) {
            Logger.m478w(TAG, "context is null");
            return null;
        }
        try {
            return PendingIntent.getActivities(context, i, intentArr, i2);
        } catch (RuntimeException e) {
            Logger.m472e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e);
            return null;
        }
    }
}
