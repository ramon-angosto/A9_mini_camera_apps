package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.provider.Settings;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.common.b.b;
import com.meizu.cloud.pushsdk.common.b.h;
import java.util.List;

public class MzSystemUtils {
    private static String c(Context context, String str) {
        ServiceInfo[] serviceInfoArr;
        try {
            serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
        } catch (PackageManager.NameNotFoundException unused) {
            serviceInfoArr = null;
        }
        if (serviceInfoArr == null) {
            return null;
        }
        for (int i = 0; i < serviceInfoArr.length; i++) {
            if ("com.meizu.cloud.pushsdk.pushservice.MzPushService".equals(serviceInfoArr[i].name)) {
                return serviceInfoArr[i].processName;
            }
        }
        return null;
    }

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            String c = c(context, "com.meizu.cloud");
            if (!TextUtils.isEmpty(c) && c.contains("mzservice_v1")) {
                return "com.meizu.cloud";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DebugLogger.i("SystemUtils", "startservice package name " + packageName);
        return packageName;
    }

    public static String a(Context context, String str) {
        try {
            String str2 = context.getPackageManager().getPackageInfo(str, 0).versionName;
            if (str2 == null || str2.length() <= 0) {
                return "";
            }
            return str2;
        } catch (Exception e) {
            DebugLogger.e("VersionInfo", "Exception message " + e.getMessage());
            return "";
        }
    }

    public static boolean a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            i = split[i2].length() - split2[i2].length();
            if (i != 0 || (i = split[i2].compareTo(split2[i2])) != 0) {
                break;
            }
        }
        if (i == 0) {
            i = split.length - split2.length;
        }
        if (i >= 0) {
            return true;
        }
        return false;
    }

    public static String a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent(str);
            intent.setPackage(str2);
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return queryBroadcastReceivers.get(0).activityInfo.name;
            }
        }
        return null;
    }

    public static void a(Context context, String str, boolean z) {
        try {
            Settings.System.putInt(context.getContentResolver(), str, z ? 0 : 1);
        } catch (Exception e) {
            DebugLogger.e("MzSystemUtils", "Setting setCurrentPackageName exception " + e.getMessage());
        }
    }

    public static boolean b(Context context, String str) {
        try {
            int i = Settings.System.getInt(context.getContentResolver(), str);
            DebugLogger.e("MzSystemUtils", "isRemoved " + i);
            if (i == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            DebugLogger.e("MzSystemUtils", "get removed package fail " + e.getMessage());
            return false;
        }
    }

    public static String b(Context context) {
        return b.a(context);
    }

    public static boolean isBrandMeizu() {
        return h.a();
    }
}
