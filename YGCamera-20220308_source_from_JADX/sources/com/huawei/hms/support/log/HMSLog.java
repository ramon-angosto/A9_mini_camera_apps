package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.base.log.C0684a;

public class HMSLog {

    /* renamed from: a */
    public static final C0684a f988a = new C0684a();

    /* renamed from: a */
    public static String m1373a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
                return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return "HMS-[unknown-version]";
    }

    /* renamed from: d */
    public static void m1374d(String str, String str2) {
        f988a.mo13314a(3, str, str2);
    }

    /* renamed from: e */
    public static void m1377e(String str, String str2) {
        f988a.mo13314a(6, str, str2);
    }

    /* renamed from: i */
    public static void m1379i(String str, String str2) {
        f988a.mo13314a(4, str, str2);
    }

    public static void init(Context context, int i, String str) {
        f988a.mo13315a(context, i, str);
        f988a.mo13316a(str, "============================================================================" + 10 + "====== " + m1373a(context) + 10 + "============================================================================");
    }

    public static boolean isErrorEnable() {
        return f988a.mo13317a(6);
    }

    public static boolean isInfoEnable() {
        return f988a.mo13317a(4);
    }

    public static boolean isWarnEnable() {
        return f988a.mo13317a(5);
    }

    /* renamed from: w */
    public static void m1380w(String str, String str2) {
        f988a.mo13314a(5, str, str2);
    }

    /* renamed from: e */
    public static void m1378e(String str, String str2, Throwable th) {
        f988a.mo13318b(6, str, str2, th);
    }

    /* renamed from: e */
    public static void m1375e(String str, long j, String str2) {
        C0684a aVar = f988a;
        aVar.mo13314a(6, str, "[" + j + "] " + str2);
    }

    /* renamed from: e */
    public static void m1376e(String str, long j, String str2, Throwable th) {
        C0684a aVar = f988a;
        aVar.mo13318b(6, str, "[" + j + "] " + str2, th);
    }
}
