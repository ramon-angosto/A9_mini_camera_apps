package com.huawei.hms.framework.common;

import android.text.TextUtils;

public class SystemPropUtils {
    private static final String TAG = "SystemPropUtils";

    public static String getProperty(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            Logger.m478w(TAG, "reflect class for method has exception.");
            return str4;
        }
        try {
            Class<?> cls = Class.forName(str3);
            return (String) cls.getMethod(str, new Class[]{String.class, String.class}).invoke(cls, new Object[]{str2, str4});
        } catch (Exception e) {
            Logger.m472e(TAG, "getProperty catch exception: ", (Throwable) e);
            return str4;
        }
    }
}
