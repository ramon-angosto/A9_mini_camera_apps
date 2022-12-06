package com.apm.insight.l;

import android.os.Build;
import android.text.TextUtils;
import com.apm.insight.k.e;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d {
    private static boolean a = false;
    private static int b = -1;
    private static final Pattern c = Pattern.compile("^0-([\\d]+)$");

    public static String a() {
        return b("ro.build.version.emui");
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = a();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return b();
        }
        return true;
    }

    private static String b(String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                str2 = bufferedReader.readLine();
                bufferedReader.close();
                k.a((Closeable) bufferedReader);
                return str2;
            } catch (Throwable unused) {
                k.a((Closeable) bufferedReader);
                return str2;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
            k.a((Closeable) bufferedReader);
            return str2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (android.os.Build.BRAND.toLowerCase(java.util.Locale.getDefault()).startsWith("huawei") == false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b() {
        /*
            r0 = 0
            java.lang.String r1 = android.os.Build.BRAND     // Catch:{ all -> 0x0034 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "huawei"
            if (r1 != 0) goto L_0x001b
            java.lang.String r1 = android.os.Build.BRAND     // Catch:{ all -> 0x0034 }
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = r1.toLowerCase(r3)     // Catch:{ all -> 0x0034 }
            boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0033
        L_0x001b:
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0034 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0034
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0034 }
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = r1.toLowerCase(r3)     // Catch:{ all -> 0x0034 }
            boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0034
        L_0x0033:
            r0 = 1
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.l.d.b():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0025 A[Catch:{ IOException -> 0x0028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int c(java.lang.String r3) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0023 }
            r1.<init>(r3)     // Catch:{ all -> 0x0023 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0023 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0023 }
            r2.<init>(r1)     // Catch:{ all -> 0x0023 }
            r3.<init>(r2)     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r3.readLine()     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x001e
            int r0 = d(r0)     // Catch:{ all -> 0x0022 }
            r3.close()     // Catch:{ IOException -> 0x001d }
        L_0x001d:
            return r0
        L_0x001e:
            r3.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x0028
        L_0x0022:
            r0 = r3
        L_0x0023:
            if (r0 == 0) goto L_0x0028
            r0.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            r3 = -1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.l.d.c(java.lang.String):int");
    }

    public static boolean c() {
        if (!a) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    e.a = true;
                    a = true;
                    return e.a;
                }
            } catch (Exception unused) {
            }
            a = true;
        }
        return e.a;
    }

    private static int d(String str) {
        Matcher matcher = c.matcher(str);
        if (matcher.matches()) {
            try {
                return Integer.parseInt(matcher.group(1)) + 1;
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public static boolean d() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static int e() {
        int i = b;
        if (i > 0) {
            return i;
        }
        int c2 = c("/sys/devices/system/cpu/possible");
        if (c2 <= 0) {
            c2 = c("/sys/devices/system/cpu/present");
        }
        if (c2 <= 0) {
            c2 = e("/sys/devices/system/cpu/");
        }
        if (c2 <= 0) {
            c2 = Runtime.getRuntime().availableProcessors();
        }
        if (c2 <= 0) {
            c2 = 1;
        }
        b = c2;
        return c2;
    }

    private static int e(String str) {
        try {
            File[] listFiles = new File(str).listFiles(new FilenameFilter() {
                private final Pattern a = Pattern.compile("^cpu[\\d]+$");

                public boolean accept(File file, String str) {
                    return this.a.matcher(str).matches();
                }
            });
            if (listFiles == null || listFiles.length <= 0) {
                return -1;
            }
            return listFiles.length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
