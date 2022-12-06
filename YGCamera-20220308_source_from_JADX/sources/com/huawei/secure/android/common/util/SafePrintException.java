package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;

public abstract class SafePrintException {
    public static void print(String str, String str2, Throwable th) {
        if (th != null) {
            Log.w(str, getStackTrace(str2, th));
        }
    }

    public static String getStackTrace(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        sb.append("Exception: ");
        sb.append(th.getClass().getName());
        sb.append(10);
        if (!m1633c(th.getClass().getCanonicalName())) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null) {
                sb.append("Stack trace is NULL!");
                sb.append(10);
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString());
                    sb.append(10);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    private static boolean m1633c(String str) {
        for (String contains : new String[]{"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", "java.security.acl.NotOwnerException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.net.BindException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.sql.SQLException"}) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
