package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class PackageManagerCompat {
    private static final String TAG = "PackageUtils";
    private static final String VERSION = "4.0.20.301";

    public static String getVersionName(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException | RuntimeException e) {
            Logger.m478w(TAG, e.getClass().getName());
            return "";
        }
    }

    public String getPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 16384).packageName;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.m478w(TAG, "Failed to get Package managers Package Info");
            return "";
        }
    }

    public String getVersion(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            return String.valueOf(packageManager.getPackageInfo(context.getPackageName(), 16384).versionCode);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.m478w(TAG, "Failed to get Package managers Package Info");
            return "";
        }
    }

    public static Bundle getMetaDataFromApp(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException | RuntimeException e) {
            Logger.m479w(TAG, "NameNotFoundException:", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            return null;
        }
        return applicationInfo.metaData;
    }
}
