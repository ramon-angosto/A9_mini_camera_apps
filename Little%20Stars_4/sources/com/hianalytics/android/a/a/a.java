package com.hianalytics.android.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.os.EnvironmentCompat;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static boolean b = true;
    private static Long c = 30L;
    private static Long d = 86400L;
    private static Long e = 1000L;
    private static Long f = 1800L;
    private static int g = Integer.MAX_VALUE;
    private static HandlerThread h;
    private static HandlerThread i;
    private static Handler j;
    private static Handler k;

    static {
        HandlerThread handlerThread = new HandlerThread("HiAnalytics_messageThread");
        h = handlerThread;
        handlerThread.start();
        HandlerThread handlerThread2 = new HandlerThread("HiAnalytics_sessionThread");
        i = handlerThread2;
        handlerThread2.start();
    }

    public static long a(String str) {
        long j2;
        try {
            Date parse = new SimpleDateFormat("yyyyMMddHHmmss").parse(str);
            if (parse != null) {
                j2 = parse.getTime();
                return j2 / 1000;
            }
        } catch (ParseException e2) {
            e2.toString();
        }
        j2 = 0;
        return j2 / 1000;
    }

    public static Long a() {
        return c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r3) {
        /*
            android.content.pm.PackageManager r0 = r3.getPackageManager()     // Catch:{ Exception -> 0x001f }
            java.lang.String r1 = r3.getPackageName()     // Catch:{ Exception -> 0x001f }
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r1, r2)     // Catch:{ Exception -> 0x001f }
            if (r0 == 0) goto L_0x001f
            android.os.Bundle r0 = r0.metaData     // Catch:{ Exception -> 0x001f }
            java.lang.String r1 = "APPKEY"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x001f }
            if (r0 == 0) goto L_0x001f
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x001f }
            goto L_0x0021
        L_0x001f:
            java.lang.String r0 = ""
        L_0x0021:
            if (r0 == 0) goto L_0x002f
            java.lang.String r1 = r0.trim()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            return r0
        L_0x002f:
            java.lang.String r3 = r3.getPackageName()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hianalytics.android.a.a.a.a(android.content.Context):java.lang.String");
    }

    public static void a(int i2) {
        g = i2;
    }

    public static void a(Long l) {
        c = l;
    }

    public static void a(boolean z) {
        b = z;
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0033 A[SYNTHETIC, Splitter:B:23:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0043 A[SYNTHETIC, Splitter:B:31:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[] r3) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x002b, all -> 0x0028 }
            r1.<init>()     // Catch:{ Exception -> 0x002b, all -> 0x0028 }
            java.util.zip.DeflaterOutputStream r2 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
            r2.write(r3)     // Catch:{ Exception -> 0x0021 }
            r2.close()     // Catch:{ Exception -> 0x0021 }
            byte[] r3 = r1.toByteArray()     // Catch:{ Exception -> 0x0021 }
            r2.close()     // Catch:{ IOException -> 0x001c }
            r1.close()     // Catch:{ IOException -> 0x001c }
            goto L_0x0020
        L_0x001c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0020:
            return r3
        L_0x0021:
            r3 = move-exception
            goto L_0x002e
        L_0x0023:
            r3 = move-exception
            goto L_0x0041
        L_0x0025:
            r3 = move-exception
            r2 = r0
            goto L_0x002e
        L_0x0028:
            r3 = move-exception
            r1 = r0
            goto L_0x0041
        L_0x002b:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L_0x002e:
            r3.printStackTrace()     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003e
            r2.close()     // Catch:{ IOException -> 0x003a }
            r1.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003e:
            return r0
        L_0x003f:
            r3 = move-exception
            r0 = r2
        L_0x0041:
            if (r0 == 0) goto L_0x004e
            r0.close()     // Catch:{ IOException -> 0x004a }
            r1.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hianalytics.android.a.a.a.a(byte[]):byte[]");
    }

    public static Long b() {
        return d;
    }

    public static String b(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("CHANNEL")) == null)) {
                return obj.toString();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "Unknown";
    }

    public static String b(String str) {
        return (str == null || str.equals("")) ? "000000000000000" : str;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(a[(b2 & 240) >> 4]);
            sb.append(a[b2 & 15]);
        }
        return sb.toString();
    }

    public static void b(Long l) {
        d = l;
    }

    public static Long c() {
        return f;
    }

    public static void c(Long l) {
        e = l;
    }

    public static String[] c(Context context) {
        String[] strArr = {"Unknown", "Unknown"};
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            strArr[0] = "Unknown";
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "Unknown";
            return strArr;
        } else if (connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        } else {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = "2G/3G";
                strArr[1] = networkInfo.getSubtypeName();
            }
            return strArr;
        }
    }

    public static int d() {
        return g;
    }

    public static void d(Long l) {
        f = l;
    }

    public static boolean d(Context context) {
        if (e.longValue() < 0) {
            return false;
        }
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder("/data/data/");
        sb.append(packageName);
        sb.append("/shared_prefs/");
        sb.append("hianalytics_state_" + packageName + ".xml");
        return new File(sb.toString()).length() > e.longValue();
    }

    public static String e(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static boolean e() {
        return b;
    }

    public static Handler f() {
        if (j == null) {
            Looper looper = h.getLooper();
            if (looper == null) {
                return null;
            }
            j = new Handler(looper);
        }
        return j;
    }

    public static boolean f(Context context) {
        SharedPreferences a2 = c.a(context, "flag");
        String str = Build.DISPLAY;
        String string = a2.getString("rom_version", "");
        "currentRom=" + str + ",lastRom=" + string;
        return "".equals(string) || !string.equals(str);
    }

    public static Handler g() {
        if (k == null) {
            Looper looper = i.getLooper();
            if (looper == null) {
                return null;
            }
            k = new Handler(looper);
        }
        return k;
    }

    public static void h() {
    }

    public static String i() {
        "URL = " + "http://data.hicloud.com:8089/sdkv1";
        return "http://data.hicloud.com:8089/sdkv1";
    }
}
