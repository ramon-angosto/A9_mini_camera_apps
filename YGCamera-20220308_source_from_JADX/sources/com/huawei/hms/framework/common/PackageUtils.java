package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.PackageManager;

public class PackageUtils {
    private static final String TAG = "PackageUtils";

    public static String getVersionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m479w(TAG, "", (Throwable) e);
            return "";
        }
    }
}
