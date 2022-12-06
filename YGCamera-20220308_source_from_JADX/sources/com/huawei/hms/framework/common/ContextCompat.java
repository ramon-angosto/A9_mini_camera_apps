package com.huawei.hms.framework.common;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Process;

public class ContextCompat {
    private static final String TAG = "ContextCompat";

    public static boolean checkSelfPermission(Context context, String str) {
        if (context == null || str == null) {
            Logger.m478w(TAG, "param is null");
            return false;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (RuntimeException e) {
            Logger.m472e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e);
            return false;
        }
    }

    public static Context getProtectedStorageContext(Context context) {
        if (context == null) {
            Logger.m478w(TAG, "context is null");
            return null;
        } else if (Build.VERSION.SDK_INT < 24) {
            return context;
        } else {
            return context.createDeviceProtectedStorageContext();
        }
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (context == null) {
            Logger.m478w(TAG, "context is null");
            return null;
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (RuntimeException e) {
            Logger.m472e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e);
            return null;
        }
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        if (context == null) {
            Logger.m478w(TAG, "context is null");
            return null;
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (RuntimeException e) {
            Logger.m472e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e);
            return null;
        }
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (context == null) {
            Logger.m478w(TAG, "context is null");
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (RuntimeException e) {
            Logger.m472e(TAG, "SystemServer error:", (Throwable) e);
        }
    }

    public static ComponentName startService(Context context, Intent intent) {
        if (context == null) {
            Logger.m478w(TAG, "context is null");
            return null;
        }
        try {
            return context.startService(intent);
        } catch (RuntimeException e) {
            Logger.m472e(TAG, "SystemServer error:", (Throwable) e);
            return null;
        }
    }

    public static Object getSystemService(Context context, String str) {
        if (context == null) {
            Logger.m478w(TAG, "context is null");
            return null;
        }
        try {
            return context.getSystemService(str);
        } catch (RuntimeException e) {
            Logger.m472e(TAG, "SystemServer error:", (Throwable) e);
            return null;
        }
    }
}
