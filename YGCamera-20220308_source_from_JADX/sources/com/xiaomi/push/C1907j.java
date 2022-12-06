package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.p003os.EnvironmentCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.xiaomi.push.j */
public class C1907j {

    /* renamed from: a */
    private static String f3495a = null;

    /* renamed from: a */
    private static volatile boolean f3496a = false;

    /* renamed from: a */
    private static final String[] f3497a = {"--", "a-", "u-", "v-", "o-", "g-"};

    /* renamed from: b */
    private static String f3498b = null;

    /* renamed from: c */
    private static String f3499c = "";

    /* renamed from: d */
    private static String f3500d;

    /* renamed from: e */
    private static String f3501e;

    /* renamed from: f */
    private static final String f3502f = String.valueOf(2);

    /* renamed from: g */
    private static String f3503g = null;

    /* renamed from: a */
    private static double m4546a(double d) {
        int i = 1;
        while (true) {
            double d2 = (double) i;
            if (d2 >= d) {
                return d2;
            }
            i <<= 1;
        }
    }

    /* renamed from: a */
    private static float m4547a(int i) {
        float f = (((float) (((((i + 102400) / 524288) + 1) * 512) * 1024)) / 1024.0f) / 1024.0f;
        double d = (double) f;
        return d > 0.5d ? (float) Math.ceil(d) : f;
    }

    /* renamed from: a */
    public static int m4548a() {
        Object a;
        if (Build.VERSION.SDK_INT >= 17 && (a = C1656bj.m2699a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return Integer.class.cast(a).intValue();
        }
        return -1;
    }

    /* renamed from: a */
    private static int m4549a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i * 31) + str.charAt(i2);
        }
        return i;
    }

    /* renamed from: a */
    private static long m4550a(File file) {
        long j;
        long j2;
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j2 = statFs.getBlockCountLong();
            j = statFs.getBlockSizeLong();
        } else {
            j2 = (long) statFs.getBlockCount();
            j = (long) statFs.getBlockSize();
        }
        return j * j2;
    }

    /* renamed from: a */
    public static String m4551a() {
        return m4547a(m4560b()) + "GB";
    }

    /* renamed from: a */
    private static String m4552a(int i) {
        if (i > 0) {
            String[] strArr = f3497a;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return f3497a[0];
    }

    /* renamed from: a */
    public static String m4553a(Context context) {
        try {
            return C1933k.m4709a(context).mo18365a();
        } catch (Exception e) {
            C1524b.m2141a("failure to get gaid:" + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static String m4554a(Context context, boolean z) {
        if (f3500d == null) {
            String e = m4574e(context);
            String f = !C1938m.m4731d() ? z ? m4575f(context) : m4584o(context) : "";
            String d = m4572d(context);
            int i = 1;
            if ((Build.VERSION.SDK_INT < 26) || !m4565b(f) || !m4565b(d)) {
                e = f + e + d;
            } else {
                String a = C1640az.m2599a(context).mo17232a();
                if (!TextUtils.isEmpty(a)) {
                    e = a + e;
                    i = 2;
                } else {
                    String n = m4583n(context);
                    if (!TextUtils.isEmpty(n)) {
                        e = n;
                        i = 3;
                    } else {
                        String b = C1640az.m2599a(context).mo17233b();
                        if (!TextUtils.isEmpty(b)) {
                            i = 4;
                            e = b;
                        } else {
                            i = 5;
                        }
                    }
                }
            }
            C1524b.m2158b("devid rule select:" + i);
            if (i == 3) {
                f3500d = e;
            } else {
                f3500d = m4547a(i) + C1663bo.m2736b(e);
            }
            m4563b(context, f3500d);
        }
        return f3500d;
    }

    /* renamed from: a */
    public static void m4555a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f3503g = str;
            C2089w wVar = null;
            try {
                if (m4568c(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevid");
                    wVar = C2089w.m5384a(context, file2);
                    C1608aa.m2490a(file2);
                    C1608aa.m2494a(file2, f3503g);
                }
                C1608aa.m2494a(new File(context.getFilesDir(), ".vdevid"), f3503g);
                if (wVar == null) {
                    return;
                }
            } catch (IOException unused) {
                C1524b.m2141a("update vdevid failure.");
                if (wVar == null) {
                    return;
                }
            } catch (Throwable th) {
                if (wVar != null) {
                    wVar.mo18568a();
                }
                throw th;
            }
            wVar.mo18568a();
        }
    }

    /* renamed from: a */
    public static void m4556a(Context context, Map<String, String> map) {
        if (map != null && context != null) {
            String n = m4583n(context);
            if (!TextUtils.isEmpty(n)) {
                map.put("local_virt_devid", n);
            }
        }
    }

    /* renamed from: a */
    public static boolean m4557a(int i) {
        Integer num = (Integer) C1656bj.m2699a("android.os.UserHandle", "getUserId", Integer.valueOf(i));
        return num != null && num.intValue() == 999;
    }

    /* renamed from: a */
    public static boolean m4558a(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: a */
    public static boolean m4559a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = f3497a;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
        if (r1 != null) goto L_0x0041;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f A[SYNTHETIC, Splitter:B:23:0x004f] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m4560b() {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/proc/meminfo"
            r0.<init>(r1)
            boolean r0 = r0.exists()
            r2 = 0
            if (r0 == 0) goto L_0x0057
            r0 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0053, all -> 0x0049 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0053, all -> 0x0049 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0053, all -> 0x0049 }
            r4 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r3, r4)     // Catch:{ Exception -> 0x0053, all -> 0x0049 }
            java.lang.String r0 = r1.readLine()     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            if (r3 != 0) goto L_0x0041
            java.lang.String r3 = "\\s+"
            java.lang.String[] r0 = r0.split(r3)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            if (r0 == 0) goto L_0x0041
            int r3 = r0.length     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r4 = 2
            if (r3 < r4) goto L_0x0041
            r3 = 1
            r4 = r0[r3]     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            boolean r4 = android.text.TextUtils.isDigitsOnly(r4)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            if (r4 == 0) goto L_0x0041
            r0 = r0[r3]     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r2 = r0
        L_0x0041:
            r1.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x0057
        L_0x0045:
            r0 = move-exception
            goto L_0x004d
        L_0x0047:
            goto L_0x0054
        L_0x0049:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x004d:
            if (r1 == 0) goto L_0x0052
            r1.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            throw r0
        L_0x0053:
            r1 = r0
        L_0x0054:
            if (r1 == 0) goto L_0x0057
            goto L_0x0041
        L_0x0057:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1907j.m4560b():int");
    }

    /* renamed from: b */
    public static String m4561b() {
        double a = (double) m4550a(Environment.getDataDirectory());
        Double.isNaN(a);
        double a2 = m4546a(((a / 1024.0d) / 1024.0d) / 1024.0d);
        return a2 + "GB";
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.xiaomi.push.w, java.lang.String] */
    /* renamed from: b */
    public static String m4562b(Context context) {
        ? r1 = 0;
        if (!m4568c(context)) {
            return r1;
        }
        if (!TextUtils.isEmpty(f3503g)) {
            return f3503g;
        }
        f3503g = C1608aa.m2490a(new File(context.getFilesDir(), ".vdevid"));
        if (!TextUtils.isEmpty(f3503g)) {
            return f3503g;
        }
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
            C2089w a = C2089w.m5384a(context, file);
            f3503g = "";
            String a2 = C1608aa.m2490a(file);
            if (a2 != null) {
                f3503g = a2;
            }
            String str = f3503g;
            if (a != null) {
                a.mo18568a();
            }
            return str;
        } catch (IOException unused) {
            C1524b.m2141a("getVDevID failure.");
            if (r1 != 0) {
                r1.mo18568a();
            }
            return f3503g;
        } catch (Throwable th) {
            if (r1 != 0) {
                r1.mo18568a();
            }
            throw th;
        }
    }

    /* renamed from: b */
    private static void m4563b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            C2089w wVar = null;
            try {
                if (m4568c(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevidlocal");
                    if (!file2.exists() || !file2.isFile()) {
                        wVar = C2089w.m5384a(context, file2);
                        C1608aa.m2490a(file2);
                        C1608aa.m2494a(file2, f3500d + f3502f + m4549a(f3500d));
                        C1524b.m2158b("lvdd write succ.");
                    } else {
                        C1524b.m2158b("vdr exists, not rewrite.");
                        return;
                    }
                } else {
                    C1524b.m2141a("not support write lvdd.");
                }
                if (wVar == null) {
                    return;
                }
            } catch (IOException unused) {
                C1524b.m2141a("write lvdd failure.");
                if (wVar == null) {
                    return;
                }
            } catch (Throwable th) {
                if (wVar != null) {
                    wVar.mo18568a();
                }
                throw th;
            }
            wVar.mo18568a();
        }
    }

    /* renamed from: b */
    public static boolean m4564b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    /* renamed from: b */
    private static boolean m4565b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase("null") || trim.equalsIgnoreCase(EnvironmentCompat.MEDIA_UNKNOWN);
    }

    /* renamed from: c */
    private static int m4566c() {
        return Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    /* renamed from: c */
    public static String m4567c() {
        return m4560b() + "KB";
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007e  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4568c(android.content.Context r6) {
        /*
            boolean r0 = m4568c((android.content.Context) r6)
            r1 = 0
            if (r0 == 0) goto L_0x0082
            boolean r0 = f3496a
            if (r0 == 0) goto L_0x000d
            goto L_0x0082
        L_0x000d:
            r0 = 1
            f3496a = r0
            java.io.File r0 = new java.io.File
            java.io.File r2 = r6.getFilesDir()
            java.lang.String r3 = ".vdevid"
            r0.<init>(r2, r3)
            java.lang.String r0 = com.xiaomi.push.C1608aa.m2490a((java.io.File) r0)
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.lang.String r5 = "/.vdevdir/"
            r2.<init>(r4, r5)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            r4.<init>(r2, r3)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            com.xiaomi.push.w r2 = com.xiaomi.push.C2089w.m5384a(r6, r4)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.lang.String r3 = com.xiaomi.push.C1608aa.m2490a((java.io.File) r4)     // Catch:{ IOException -> 0x0040 }
            if (r2 == 0) goto L_0x004b
            r2.mo18568a()
            goto L_0x004b
        L_0x003d:
            r6 = move-exception
            goto L_0x007c
        L_0x003f:
            r2 = r1
        L_0x0040:
            java.lang.String r3 = "check id failure."
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r3)     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x004a
            r2.mo18568a()
        L_0x004a:
            r3 = r1
        L_0x004b:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0072
            f3503g = r0
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x006e
            int r2 = r3.length()
            r4 = 128(0x80, float:1.794E-43)
            if (r2 <= r4) goto L_0x0062
            goto L_0x006e
        L_0x0062:
            boolean r6 = android.text.TextUtils.equals(r0, r3)
            if (r6 != 0) goto L_0x0071
            java.lang.String r6 = "vid changed, need sync"
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r6)
            return r3
        L_0x006e:
            m4555a((android.content.Context) r6, (java.lang.String) r0)
        L_0x0071:
            return r1
        L_0x0072:
            java.lang.String r6 = "empty local vid"
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r6)
            java.lang.String r6 = "F*"
            return r6
        L_0x007a:
            r6 = move-exception
            r1 = r2
        L_0x007c:
            if (r1 == 0) goto L_0x0081
            r1.mo18568a()
        L_0x0081:
            throw r6
        L_0x0082:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1907j.m4568c(android.content.Context):java.lang.String");
    }

    /* renamed from: c */
    private static boolean m4569c(Context context) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 29 || !C1939n.m4732a(context, "android.permission.WRITE_EXTERNAL_STORAGE") || C1938m.m4713a()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            z = true;
        }
        return !z ? C2087u.m5375a(context) : z;
    }

    /* renamed from: c */
    private static boolean m4570c(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && C1663bo.m2736b(str) && !C1663bo.m2738c(str);
    }

    /* renamed from: d */
    public static String m4571d() {
        long a = m4550a(Environment.getDataDirectory());
        return (a / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + "KB";
    }

    /* renamed from: d */
    public static String m4572d(Context context) {
        if (!m4572d(context)) {
            return null;
        }
        if (Build.VERSION.SDK_INT > 8 && Build.VERSION.SDK_INT < 26) {
            return Build.SERIAL;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return (String) C1656bj.m2699a("android.os.Build", "getSerial", (Object[]) null);
        }
        return null;
    }

    /* renamed from: d */
    private static boolean m4573d(Context context) {
        String packageName = context.getPackageName();
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", packageName) == 0 || context.getPackageManager().checkPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", packageName) == 0;
    }

    /* renamed from: e */
    public static String m4574e(Context context) {
        String str = f3498b;
        if (str != null) {
            return str;
        }
        try {
            f3498b = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            C1524b.m2141a("failure to get androidId: " + th);
        }
        return f3498b;
    }

    /* renamed from: f */
    public static String m4575f(Context context) {
        int c = m4566c();
        String g = m4576g(context);
        while (g == null) {
            int i = c - 1;
            if (c <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            g = m4576g(context);
            c = i;
        }
        return g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        r2 = com.xiaomi.push.C1656bj.m2697a((r2 = com.xiaomi.push.C1656bj.m2699a("miui.telephony.TelephonyManager", "getDefault", new java.lang.Object[0])), "getMiuiDeviceId", new java.lang.Object[0]);
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4576g(android.content.Context r6) {
        /*
            boolean r0 = com.xiaomi.push.C1938m.m4731d()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.String r0 = f3495a
            if (r0 == 0) goto L_0x000e
            return r0
        L_0x000e:
            r0 = 0
            boolean r2 = m4572d((android.content.Context) r6)     // Catch:{ all -> 0x0086 }
            if (r2 == 0) goto L_0x007b
            boolean r2 = com.xiaomi.push.C1938m.m4713a()     // Catch:{ all -> 0x0086 }
            if (r2 == 0) goto L_0x003f
            java.lang.String r2 = "miui.telephony.TelephonyManager"
            java.lang.String r3 = "getDefault"
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0086 }
            java.lang.Object r2 = com.xiaomi.push.C1656bj.m2699a((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object[]) r5)     // Catch:{ all -> 0x0086 }
            if (r2 == 0) goto L_0x003f
            java.lang.String r3 = "getMiuiDeviceId"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0086 }
            java.lang.Object r2 = com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r2, (java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ all -> 0x0086 }
            if (r2 == 0) goto L_0x003f
            boolean r3 = r2 instanceof java.lang.String     // Catch:{ all -> 0x0086 }
            if (r3 == 0) goto L_0x003f
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.Object r2 = r3.cast(r2)     // Catch:{ all -> 0x0086 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0086 }
            goto L_0x0040
        L_0x003f:
            r2 = r0
        L_0x0040:
            if (r2 != 0) goto L_0x0079
            java.lang.String r3 = "phone"
            java.lang.Object r6 = r6.getSystemService(r3)     // Catch:{ all -> 0x0086 }
            android.telephony.TelephonyManager r6 = (android.telephony.TelephonyManager) r6     // Catch:{ all -> 0x0086 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0086 }
            r4 = 26
            if (r3 >= r4) goto L_0x0055
            java.lang.String r6 = r6.getDeviceId()     // Catch:{ all -> 0x0086 }
            goto L_0x007c
        L_0x0055:
            r3 = 1
            int r4 = r6.getPhoneType()     // Catch:{ all -> 0x0086 }
            if (r3 != r4) goto L_0x0068
            java.lang.String r2 = "getImei"
            r3 = r0
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch:{ all -> 0x0086 }
            java.lang.Object r6 = com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r6, (java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x0086 }
        L_0x0065:
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0086 }
            goto L_0x007c
        L_0x0068:
            r3 = 2
            int r4 = r6.getPhoneType()     // Catch:{ all -> 0x0086 }
            if (r3 != r4) goto L_0x0079
            java.lang.String r2 = "getMeid"
            r3 = r0
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch:{ all -> 0x0086 }
            java.lang.Object r6 = com.xiaomi.push.C1656bj.m2697a((java.lang.Object) r6, (java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x0086 }
            goto L_0x0065
        L_0x0079:
            r6 = r2
            goto L_0x007c
        L_0x007b:
            r6 = r0
        L_0x007c:
            boolean r2 = m4570c((java.lang.String) r6)     // Catch:{ all -> 0x0086 }
            if (r2 == 0) goto L_0x0085
            f3495a = r6     // Catch:{ all -> 0x0086 }
            return r6
        L_0x0085:
            return r1
        L_0x0086:
            r6 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "failure to get id:"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1907j.m4576g(android.content.Context):java.lang.String");
    }

    /* renamed from: h */
    public static String m4577h(Context context) {
        int c = m4566c();
        String j = m4579j(context);
        while (j == null) {
            int i = c - 1;
            if (c <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            j = m4579j(context);
            c = i;
        }
        return j;
    }

    /* renamed from: i */
    public static String m4578i(Context context) {
        Object a;
        if (C1938m.m4731d() || Build.VERSION.SDK_INT < 22) {
            return "";
        }
        if (!TextUtils.isEmpty(f3499c)) {
            return f3499c;
        }
        m4576g(context);
        if (TextUtils.isEmpty(f3495a)) {
            return "";
        }
        try {
            if (m4572d(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                Integer num = (Integer) C1656bj.m2697a((Object) telephonyManager, "getPhoneCount", new Object[0]);
                if (num != null && num.intValue() > 1) {
                    String str = null;
                    for (int i = 0; i < num.intValue(); i++) {
                        if (Build.VERSION.SDK_INT < 26) {
                            a = C1656bj.m2697a((Object) telephonyManager, "getDeviceId", Integer.valueOf(i));
                        } else if (1 == telephonyManager.getPhoneType()) {
                            a = C1656bj.m2697a((Object) telephonyManager, "getImei", Integer.valueOf(i));
                        } else {
                            if (2 == telephonyManager.getPhoneType()) {
                                a = C1656bj.m2697a((Object) telephonyManager, "getMeid", Integer.valueOf(i));
                            }
                            if (!TextUtils.isEmpty(str) && !TextUtils.equals(f3495a, str) && m4570c(str)) {
                                f3499c += str + Constants.ACCEPT_TIME_SEPARATOR_SP;
                            }
                        }
                        str = (String) a;
                        f3499c += str + Constants.ACCEPT_TIME_SEPARATOR_SP;
                    }
                    int length = f3499c.length();
                    if (length > 0) {
                        f3499c = f3499c.substring(0, length - 1);
                    }
                    return f3499c;
                }
            }
            return "";
        } catch (Exception e) {
            C1524b.m2141a("failure to get ids: " + e);
            return "";
        }
    }

    /* renamed from: j */
    public static String m4579j(Context context) {
        m4578i(context);
        if (TextUtils.isEmpty(f3499c)) {
            return "";
        }
        String str = "";
        for (String str2 : f3499c.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (m4570c(str2)) {
                str = str + C1663bo.m2727a(str2) + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    /* renamed from: k */
    public static synchronized String m4580k(Context context) {
        synchronized (C1907j.class) {
            if (f3501e != null) {
                String str = f3501e;
                return str;
            }
            String e = m4574e(context);
            String d = m4572d(context);
            f3501e = C1663bo.m2736b(e + d);
            String str2 = f3501e;
            return str2;
        }
    }

    /* renamed from: l */
    public static synchronized String m4581l(Context context) {
        String b;
        synchronized (C1907j.class) {
            String e = m4574e(context);
            b = C1663bo.m2736b(e + null);
        }
        return b;
    }

    /* renamed from: m */
    public static String m4582m(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.xiaomi.push.w} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|(2:13|(5:15|16|17|18|(1:20)))|21|22|(1:24)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a A[Catch:{ IOException -> 0x0066, all -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m4583n(android.content.Context r6) {
        /*
            boolean r0 = m4568c((android.content.Context) r6)
            r1 = 0
            if (r0 != 0) goto L_0x000d
            java.lang.String r6 = "not support read lvdd."
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r6)
            return r1
        L_0x000d:
            java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x0079 }
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ IOException -> 0x0079 }
            java.lang.String r3 = "/.vdevdir/"
            r0.<init>(r2, r3)     // Catch:{ IOException -> 0x0079 }
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x0079 }
            java.lang.String r3 = ".vdevidlocal"
            r2.<init>(r0, r3)     // Catch:{ IOException -> 0x0079 }
            boolean r0 = r2.exists()     // Catch:{ IOException -> 0x0079 }
            if (r0 == 0) goto L_0x006a
            boolean r0 = r2.isFile()     // Catch:{ IOException -> 0x0079 }
            if (r0 == 0) goto L_0x006a
            com.xiaomi.push.w r6 = com.xiaomi.push.C2089w.m5384a(r6, r2)     // Catch:{ IOException -> 0x0079 }
            java.lang.String r0 = com.xiaomi.push.C1608aa.m2490a((java.io.File) r2)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            if (r3 != 0) goto L_0x0054
            java.lang.String r3 = f3502f     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            java.lang.String[] r0 = r0.split(r3)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            int r3 = r0.length     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            r4 = 2
            if (r3 != r4) goto L_0x0054
            r3 = 0
            r3 = r0[r3]     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            r4 = 1
            r0 = r0[r4]     // Catch:{ Exception -> 0x0054 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0054 }
            int r4 = m4549a((java.lang.String) r3)     // Catch:{ Exception -> 0x0054 }
            if (r4 != r0) goto L_0x0054
            r1 = r3
        L_0x0054:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            if (r0 == 0) goto L_0x0070
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r2)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            java.lang.String r0 = "lvdd content invalid, remove it."
            com.xiaomi.channel.commonutils.logger.C1524b.m2158b(r0)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            goto L_0x0070
        L_0x0063:
            r0 = move-exception
            r1 = r6
            goto L_0x0085
        L_0x0066:
            r5 = r1
            r1 = r6
            r6 = r5
            goto L_0x007a
        L_0x006a:
            java.lang.String r6 = "lvdf not exists"
            com.xiaomi.channel.commonutils.logger.C1524b.m2158b(r6)     // Catch:{ IOException -> 0x0079 }
            r6 = r1
        L_0x0070:
            if (r6 == 0) goto L_0x0075
            r6.mo18568a()
        L_0x0075:
            r6 = r1
            goto L_0x0084
        L_0x0077:
            r0 = move-exception
            goto L_0x0085
        L_0x0079:
            r6 = r1
        L_0x007a:
            java.lang.String r0 = "get lvdd failure."
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x0084
            r1.mo18568a()
        L_0x0084:
            return r6
        L_0x0085:
            if (r1 == 0) goto L_0x008a
            r1.mo18568a()
        L_0x008a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1907j.m4583n(android.content.Context):java.lang.String");
    }

    /* renamed from: o */
    private static String m4584o(Context context) {
        int c = m4566c();
        String g = m4576g(context);
        while (TextUtils.isEmpty(g)) {
            int i = c - 1;
            if (c <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            g = m4576g(context);
            c = i;
        }
        return g;
    }
}
