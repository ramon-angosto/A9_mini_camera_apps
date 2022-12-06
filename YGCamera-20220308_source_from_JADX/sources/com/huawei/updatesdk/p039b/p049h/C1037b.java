package com.huawei.updatesdk.p039b.p049h;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.updatesdk.p025a.p026a.C0964a;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p026a.p031d.C0972d;
import com.huawei.updatesdk.p039b.p045d.C1018d;
import com.huawei.updatesdk.service.otaupdate.C1085f;
import java.io.File;
import java.lang.Thread;
import java.lang.reflect.Field;

/* renamed from: com.huawei.updatesdk.b.h.b */
public class C1037b {

    /* renamed from: a */
    private static Integer f1401a = null;

    /* renamed from: b */
    private static boolean f1402b = false;

    /* renamed from: c */
    private static boolean f1403c = false;

    /* renamed from: d */
    private static Field f1404d;

    /* renamed from: com.huawei.updatesdk.b.h.b$a */
    static class C1038a implements Thread.UncaughtExceptionHandler {
        C1038a() {
        }

        public void uncaughtException(Thread thread, Throwable th) {
            C0968a.m1680a("PackageUtils", thread.getName() + " : " + th.getMessage());
        }
    }

    /* renamed from: com.huawei.updatesdk.b.h.b$b */
    public enum C1039b {
        NOT_INSTALLED,
        INSTALLED,
        INSTALLED_LOWCODE
    }

    /* renamed from: com.huawei.updatesdk.b.h.b$c */
    private static class C1040c implements Runnable {
        private C1040c() {
        }

        /* synthetic */ C1040c(C1038a aVar) {
            this();
        }

        public void run() {
            C0968a.m1680a("PackageManagerRunnable", "PackageManagerRunnable run!!!!");
            C0972d.m1693a(new File(C1018d.m1902b()));
        }
    }

    /* renamed from: a */
    public static int m1954a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if ((applicationInfo.flags & 1) == 0) {
            return 0;
        }
        return m1959a(applicationInfo) ? 1 : 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r0 = r3.applicationInfo;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m1955a(java.lang.String r3) {
        /*
            com.huawei.updatesdk.a.b.a.a r0 = com.huawei.updatesdk.p025a.p034b.p035a.C0985a.m1757c()
            android.content.Context r0 = r0.mo14892a()
            r1 = 0
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ Exception -> 0x002c }
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r3 = r0.getPackageInfo(r3, r2)     // Catch:{ Exception -> 0x002c }
            if (r3 == 0) goto L_0x002b
            android.content.pm.ApplicationInfo r0 = r3.applicationInfo
            if (r0 == 0) goto L_0x002b
            android.os.Bundle r0 = r0.metaData
            if (r0 == 0) goto L_0x002b
            android.content.pm.ApplicationInfo r3 = r3.applicationInfo
            android.os.Bundle r3 = r3.metaData
            java.lang.String r0 = "com.huawei.maple.flag"
            boolean r3 = r3.containsKey(r0)
            if (r3 == 0) goto L_0x002b
            r3 = 1
            return r3
        L_0x002b:
            return r1
        L_0x002c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "getMapleStatus not found: "
            r0.append(r2)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "PackageUtils"
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1684d(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p039b.p049h.C1037b.m1955a(java.lang.String):int");
    }

    /* renamed from: a */
    public static PackageInfo m1956a(String str, Context context) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (Exception unused) {
            C0968a.m1684d("PackageUtils", "not found: " + str);
            return null;
        }
    }

    /* renamed from: a */
    public static C1039b m1957a(Context context, String str) {
        C1039b bVar = C1039b.NOT_INSTALLED;
        if (context == null) {
            return bVar;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return bVar;
            }
            C0964a.m1667b("PackageUtils", "appmarket info," + "versioncode = " + packageInfo.versionCode + "versioncode = " + packageInfo.versionName);
            return packageInfo.versionCode < 70203000 ? C1039b.INSTALLED_LOWCODE : C1039b.INSTALLED;
        } catch (Exception e) {
            C0968a.m1684d("PackageUtils", "isInstallByPackage Exception:" + e.toString());
            return bVar;
        }
    }

    /* renamed from: a */
    public static void m1958a() {
        Thread thread = new Thread(new C1040c((C1038a) null));
        thread.setName("delete market file task");
        thread.setUncaughtExceptionHandler(new C1038a());
        thread.start();
    }

    /* renamed from: a */
    private static boolean m1959a(ApplicationInfo applicationInfo) {
        String str;
        StringBuilder sb;
        int i = applicationInfo.flags;
        Integer c = m1962c();
        if (c != null && (i & c.intValue()) != 0) {
            return true;
        }
        Field b = m1961b();
        if (b == null) {
            return false;
        }
        try {
            return (b.getInt(applicationInfo) & 33554432) != 0;
        } catch (IllegalAccessException e) {
            sb = new StringBuilder();
            sb.append("can not get hwflags");
            str = e.toString();
            sb.append(str);
            C0968a.m1680a("PackageUtils", sb.toString());
            return false;
        } catch (IllegalArgumentException e2) {
            sb = new StringBuilder();
            sb.append("can not get hwflags");
            str = e2.toString();
            sb.append(str);
            C0968a.m1680a("PackageUtils", sb.toString());
            return false;
        }
    }

    /* renamed from: b */
    private static int m1960b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e) {
            C0968a.m1684d("PackageUtils", "isInstallByPackage:" + e.toString());
            return 0;
        }
    }

    /* renamed from: b */
    public static Field m1961b() {
        if (f1403c) {
            return f1404d;
        }
        try {
            f1404d = ApplicationInfo.class.getField("hwFlags");
        } catch (NoSuchFieldException unused) {
            C0968a.m1680a("PackageUtils", "can not find hwFlags");
        }
        f1403c = true;
        return f1404d;
    }

    /* renamed from: c */
    public static Integer m1962c() {
        String str;
        StringBuilder sb;
        String str2;
        if (f1402b) {
            return f1401a;
        }
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            f1401a = Integer.valueOf(cls.getDeclaredField("PARSE_IS_REMOVABLE_PREINSTALLED_APK").getInt(cls));
        } catch (NoSuchFieldException e) {
            sb = new StringBuilder();
            sb.append("isDelApp error NoSuchFieldException:");
            str2 = e.toString();
        } catch (ClassNotFoundException e2) {
            sb = new StringBuilder();
            sb.append("isDelApp error ClassNotFoundException:");
            str2 = e2.toString();
        } catch (IllegalAccessException e3) {
            sb = new StringBuilder();
            sb.append("isDelApp error IllegalAccessException:");
            str2 = e3.toString();
        } catch (IllegalArgumentException e4) {
            sb = new StringBuilder();
            sb.append("isDelApp error IllegalArgumentException:");
            str2 = e4.toString();
        } catch (Exception e5) {
            str = e5.toString();
            C0968a.m1680a("PackageUtils", str);
            f1402b = true;
            return f1401a;
        }
        f1402b = true;
        return f1401a;
        sb.append(str2);
        str = sb.toString();
        C0968a.m1680a("PackageUtils", str);
        f1402b = true;
        return f1401a;
    }

    /* renamed from: c */
    public static boolean m1963c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0) != null;
            } catch (Exception e) {
                C0968a.m1684d("PackageUtils", "isAppInstalled NameNotFoundException:" + e.toString());
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m1964d(Context context, String str) {
        return C1085f.m2106f().mo15209e() || m1960b(context, str) > 90000000;
    }

    /* renamed from: e */
    public static boolean m1965e(Context context, String str) {
        return C1085f.m2106f().mo15209e() || m1960b(context, str) > 100200000;
    }
}
