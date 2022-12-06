package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;

public class UIUtil {
    public static Activity getActiveActivity(Activity activity, Context context) {
        if (isBackground(context)) {
            HMSLog.m1379i("UIUtil", "isBackground" + isBackground(context));
            return null;
        } else if (activity == null) {
            HMSLog.m1379i("UIUtil", "activity is " + activity);
            return ActivityMgr.INST.getCurrentActivity();
        } else if (!activity.isFinishing()) {
            return activity;
        } else {
            HMSLog.m1379i("UIUtil", "activity isFinishing is " + activity.isFinishing());
            return ActivityMgr.INST.getCurrentActivity();
        }
    }

    public static String getProcessName(Context context, int i) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (!(context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == i) {
                    return next.processName;
                }
            }
        }
        return "";
    }

    public static boolean isActivityFullscreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static boolean isBackground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z;
        if (context == null) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return true;
        }
        String processName = getProcessName(context, Process.myPid());
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (TextUtils.equals(next.processName, processName)) {
                HMSLog.m1379i("UIUtil", "appProcess.importance is " + next.importance);
                boolean z2 = next.importance == 100;
                if (Build.VERSION.SDK_INT > 22) {
                    z = keyguardManager.isDeviceLocked();
                } else {
                    z = keyguardManager.inKeyguardRestrictedInputMode();
                }
                HMSLog.m1379i("UIUtil", "isForground is " + z2 + "***  isLockedState is " + z);
                if (!z2 || z) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }
}
