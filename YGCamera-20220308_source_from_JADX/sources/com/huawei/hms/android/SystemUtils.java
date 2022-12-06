package com.huawei.hms.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class SystemUtils {
    /* renamed from: a */
    public static String m196a() {
        return getSystemProperties("ro.product.locale", "");
    }

    /* renamed from: b */
    public static String m197b() {
        return getSystemProperties("ro.product.locale.region", "");
    }

    public static String getLocalCountry() {
        Locale locale = Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r1 = (r1 = (android.net.ConnectivityManager) r1.getSystemService("connectivity")).getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getNetType(android.content.Context r1) {
        /*
            if (r1 == 0) goto L_0x001d
            java.lang.String r0 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r0)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            if (r1 == 0) goto L_0x001d
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            if (r1 == 0) goto L_0x001d
            boolean r0 = r1.isAvailable()
            if (r0 == 0) goto L_0x001d
            java.lang.String r1 = r1.getTypeName()
            goto L_0x001f
        L_0x001d:
            java.lang.String r1 = ""
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.android.SystemUtils.getNetType(android.content.Context):java.lang.String");
    }

    public static String getSystemProperties(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, str2});
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.m1377e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + str);
            return str2;
        }
    }

    public static boolean isChinaROM() {
        String b = m197b();
        if (!TextUtils.isEmpty(b)) {
            return "cn".equalsIgnoreCase(b);
        }
        String a = m196a();
        if (!TextUtils.isEmpty(a)) {
            return a.toLowerCase(Locale.US).contains("cn");
        }
        String localCountry = getLocalCountry();
        if (!TextUtils.isEmpty(localCountry)) {
            return "cn".equalsIgnoreCase(localCountry);
        }
        return false;
    }

    public static boolean isEMUI() {
        HMSLog.m1379i("SystemUtils", "is Emui :" + HwBuildEx.VERSION.EMUI_SDK_INT);
        return HwBuildEx.VERSION.EMUI_SDK_INT > 0;
    }

    public static boolean isSystemApp(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e) {
            HMSLog.m1377e("SystemUtils", "isSystemApp Exception: " + e);
            packageInfo = null;
        }
        if (packageInfo == null || (packageInfo.applicationInfo.flags & 1) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isTVDevice() {
        return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
    }
}
