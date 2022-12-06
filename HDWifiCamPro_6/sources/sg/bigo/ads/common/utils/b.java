package sg.bigo.ads.common.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import sg.bigo.ads.common.m.a;

public final class b {
    private static byte a;
    private static a b;

    public static String a() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
        } catch (AssertionError e) {
            e.printStackTrace();
            return "";
        }
    }

    public static synchronized String a(Context context) {
        String str;
        synchronized (b.class) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return str;
    }

    public static boolean a(Context context, String str) {
        if (a == 0) {
            if (Build.VERSION.SDK_INT < 30 || (!o.b(str) && context.checkSelfPermission(str) == 0)) {
                a = 1;
            } else {
                a = -1;
            }
        }
        return a == 1;
    }

    public static synchronized int b(Context context) {
        int i;
        synchronized (b.class) {
            try {
                i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return i;
    }

    public static void b(Context context, String str) {
        if (!a(context, str)) {
            b = new a(context);
        }
    }

    public static boolean c(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public static int d(Context context, String str) {
        if (context == null || str == null) {
            return -1;
        }
        a aVar = b;
        if (aVar != null && !aVar.b.contains(str)) {
            if (!b.a.contains("android.intent.action.MAIN")) {
                return -1;
            }
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.MAIN"), 0);
            if (queryIntentActivities != null) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (str.equalsIgnoreCase(resolveInfo.activityInfo.packageName)) {
                        return 1;
                    }
                }
            }
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 256) != null ? 1 : -1;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return 0;
        }
    }

    public static long e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static long f(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static PackageInfo g(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String h(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = Build.VERSION.SDK_INT >= 30 ? context.getPackageManager().getInstallSourceInfo(str).getInstallingPackageName() : context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }
}
