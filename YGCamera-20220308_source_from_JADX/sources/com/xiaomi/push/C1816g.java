package com.xiaomi.push;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.xiaomi.push.g */
public class C1816g {

    /* renamed from: com.xiaomi.push.g$a */
    public enum C1817a {
        f2461a(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        

        /* renamed from: a */
        private final int f2465a;

        private C1817a(int i) {
            this.f2465a = i;
        }

        /* renamed from: a */
        public int mo17676a() {
            return this.f2465a;
        }
    }

    /* renamed from: a */
    public static int m3659a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: a */
    private static ApplicationInfo m3660a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            C1524b.m2141a("not found app info " + str);
            return null;
        }
    }

    /* renamed from: a */
    public static Drawable m3661a(Context context, String str) {
        ApplicationInfo a = m3659a(context, str);
        Drawable drawable = null;
        if (a != null) {
            try {
                drawable = a.loadIcon(context.getPackageManager());
                if (drawable == null && Build.VERSION.SDK_INT >= 9) {
                    drawable = a.loadLogo(context.getPackageManager());
                }
            } catch (Exception e) {
                C1524b.m2141a("get app icon drawable failed, " + e);
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.xiaomi.push.C1816g.C1817a m3662a(android.content.Context r5, android.content.pm.ApplicationInfo r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r6 == 0) goto L_0x0081
            r1 = 24
            if (r0 >= r1) goto L_0x000a
            goto L_0x0081
        L_0x000a:
            r1 = 0
            java.lang.String r2 = r6.packageName     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = r5.getPackageName()     // Catch:{ Exception -> 0x0069 }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "notification"
            if (r2 == 0) goto L_0x0028
            java.lang.Object r5 = r5.getSystemService(r3)     // Catch:{ Exception -> 0x0069 }
            android.app.NotificationManager r5 = (android.app.NotificationManager) r5     // Catch:{ Exception -> 0x0069 }
            boolean r5 = r5.areNotificationsEnabled()     // Catch:{ Exception -> 0x0069 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0069 }
            goto L_0x005b
        L_0x0028:
            r2 = 29
            r4 = 0
            if (r0 < r2) goto L_0x003a
            java.lang.Object r5 = r5.getSystemService(r3)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r0 = "getService"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r5 = com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r5, (java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0040
        L_0x003a:
            java.lang.String r0 = "security"
            java.lang.Object r5 = r5.getSystemService(r0)     // Catch:{ Exception -> 0x0069 }
        L_0x0040:
            if (r5 == 0) goto L_0x005b
            java.lang.String r0 = "areNotificationsEnabledForPackage"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0069 }
            java.lang.String r2 = r6.packageName     // Catch:{ Exception -> 0x0069 }
            r1[r4] = r2     // Catch:{ Exception -> 0x0069 }
            r2 = 1
            int r6 = r6.uid     // Catch:{ Exception -> 0x0069 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0069 }
            r1[r2] = r6     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r5 = com.xiaomi.push.C1656bj.m2706b((java.lang.Object) r5, (java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x0069 }
            r1 = r5
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x0069 }
        L_0x005b:
            if (r1 == 0) goto L_0x007e
            boolean r5 = r1.booleanValue()     // Catch:{ Exception -> 0x0069 }
            if (r5 == 0) goto L_0x0066
            com.xiaomi.push.g$a r5 = com.xiaomi.push.C1816g.C1817a.ALLOWED     // Catch:{ Exception -> 0x0069 }
            goto L_0x0068
        L_0x0066:
            com.xiaomi.push.g$a r5 = com.xiaomi.push.C1816g.C1817a.NOT_ALLOWED     // Catch:{ Exception -> 0x0069 }
        L_0x0068:
            return r5
        L_0x0069:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "are notifications enabled error "
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r5)
        L_0x007e:
            com.xiaomi.push.g$a r5 = com.xiaomi.push.C1816g.C1817a.f2461a
            return r5
        L_0x0081:
            com.xiaomi.push.g$a r5 = com.xiaomi.push.C1816g.C1817a.f2461a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1816g.m3662a(android.content.Context, android.content.pm.ApplicationInfo):com.xiaomi.push.g$a");
    }

    /* renamed from: a */
    public static C1817a m3663a(Context context, String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 19) {
            return C1817a.f2461a;
        }
        try {
            ApplicationInfo applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            C1817a a = m3662a(context, applicationInfo);
            if (a != C1817a.f2461a) {
                return a;
            }
            Integer num = (Integer) C1656bj.m2694a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
            if (num == null) {
                return C1817a.f2461a;
            }
            Integer num2 = (Integer) C1656bj.m2697a((Object) (AppOpsManager) context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
            int i = (Integer) C1656bj.m2694a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
            int i2 = (Integer) C1656bj.m2694a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
            C1524b.m2158b(String.format("get app mode %s|%s|%s", new Object[]{num2, i, i2}));
            if (i == null) {
                i = 0;
            }
            if (i2 == null) {
                i2 = 1;
            }
            if (num2 != null) {
                return z ? !num2.equals(i2) ? C1817a.ALLOWED : C1817a.NOT_ALLOWED : num2.equals(i) ? C1817a.ALLOWED : C1817a.NOT_ALLOWED;
            }
            return C1817a.f2461a;
        } catch (Throwable th) {
            C1524b.m2141a("get app op error " + th);
        }
    }

    /* renamed from: a */
    public static String m3664a(Context context) {
        return m3665a(context, Process.myPid());
    }

    /* renamed from: a */
    public static String m3665a(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> list;
        if (context == null) {
            return null;
        }
        try {
            list = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Exception unused) {
            list = null;
        }
        if (list == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : list) {
            if (next.pid == i) {
                return next.processName;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m3666a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: a */
    public static boolean m3667a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() >= 1) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == Process.myPid() && next.processName.equals(context.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3668a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static int m3669b(Context context, String str) {
        ApplicationInfo a = m3659a(context, str);
        if (a == null) {
            return 0;
        }
        int i = a.icon;
        return (i != 0 || Build.VERSION.SDK_INT < 9) ? i : a.logo;
    }

    /* renamed from: b */
    public static String m3670b(Context context) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                String[] strArr = runningAppProcessInfo.pkgList;
                int i = 0;
                while (strArr != null && i < strArr.length) {
                    if (!arrayList.contains(strArr[i])) {
                        arrayList.add(strArr[i]);
                        if (arrayList.size() == 1) {
                            str = (String) arrayList.get(0);
                        } else {
                            sb.append("#");
                            str = strArr[i];
                        }
                        sb.append(str.hashCode() % 100000);
                    }
                    i++;
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        r0 = r0.applicationInfo;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3671b(android.content.Context r1, java.lang.String r2) {
        /*
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0019 }
            r0 = 0
            android.content.pm.PackageInfo r0 = r1.getPackageInfo(r2, r0)     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r0 == 0) goto L_0x001d
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r0 == 0) goto L_0x001d
            java.lang.CharSequence r1 = r1.getApplicationLabel(r0)     // Catch:{ NameNotFoundException -> 0x0019 }
            java.lang.String r1 = r1.toString()     // Catch:{ NameNotFoundException -> 0x0019 }
            r2 = r1
            goto L_0x001d
        L_0x0019:
            r1 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r1)
        L_0x001d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1816g.m3671b(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static boolean m3672b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* renamed from: c */
    public static boolean m3673c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    /* renamed from: d */
    public static boolean m3674d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
