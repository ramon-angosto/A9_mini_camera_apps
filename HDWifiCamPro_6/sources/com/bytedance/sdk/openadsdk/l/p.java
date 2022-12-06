package com.bytedance.sdk.openadsdk.l;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: RomUtils */
public class p {
    public static boolean a = false;
    public static boolean b = false;
    private static final CharSequence c = "sony";
    private static final CharSequence d = "amigo";
    private static final CharSequence e = "funtouch";
    private static String f = null;
    private static int g = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public static final HashMap<String, String> h = new HashMap<>();

    public static String a() {
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        f = h.a("sdk_local_rom_info", 604800000);
        if (TextUtils.isEmpty(f)) {
            f = v();
            h.a("sdk_local_rom_info", f);
        }
        return f;
    }

    private static String v() {
        if (o()) {
            return p();
        }
        if (e()) {
            return l();
        }
        if (b()) {
            return q();
        }
        if (r()) {
            return s();
        }
        String m = m();
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        if (g()) {
            return f();
        }
        if (h()) {
            return i();
        }
        if (d()) {
            return c();
        }
        String j = j();
        if (!TextUtils.isEmpty(j)) {
            return j;
        }
        return Build.DISPLAY;
    }

    public static boolean b() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String c() {
        return d("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean d() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (!b) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    a = true;
                    b = true;
                    return a;
                }
            } catch (Exception unused) {
            }
            b = true;
        }
        return a;
    }

    public static String f() {
        return d("ro.vivo.os.build.display.id") + "_" + d("ro.vivo.product.version");
    }

    public static boolean g() {
        String d2 = d("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(d2) && d2.toLowerCase().contains(e);
    }

    public static boolean h() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(d);
    }

    public static String i() {
        return Build.DISPLAY + "_" + d("ro.gn.sv.version");
    }

    public static String j() {
        if (!k()) {
            return "";
        }
        return "eui_" + d("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean k() {
        return !TextUtils.isEmpty(d("ro.letv.release.version"));
    }

    public static String l() {
        if (!e()) {
            return "";
        }
        return "miui_" + d("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String m() {
        String n = n();
        if (n == null || !n.toLowerCase().contains("emotionui")) {
            return "";
        }
        return n + "_" + Build.DISPLAY;
    }

    public static String n() {
        return d("ro.build.version.emui");
    }

    public static boolean o() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String p() {
        if (o()) {
            try {
                String d2 = d("ro.smartisan.version");
                return "smartisan_" + d2;
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String q() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean r() {
        if (g == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String g2 = y.g("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(g2)) {
                g = 0;
            } else {
                g = 1;
            }
        }
        if (g == 1) {
            return true;
        }
        return false;
    }

    public static String s() {
        if (!r()) {
            return "";
        }
        String g2 = y.g("ro.build.version.kllkrom");
        return "coloros_" + d(g2) + "_" + Build.DISPLAY;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (android.os.Build.BRAND.toLowerCase().startsWith("huawei") == false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean t() {
        /*
            r0 = 0
            java.lang.String r1 = android.os.Build.BRAND     // Catch:{ all -> 0x002c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "huawei"
            if (r1 != 0) goto L_0x0017
            java.lang.String r1 = android.os.Build.BRAND     // Catch:{ all -> 0x002c }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x002c }
            boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x002b
        L_0x0017:
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x002c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x002c
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x002c }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x002c }
            boolean r1 = r1.startsWith(r2)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002c
        L_0x002b:
            r0 = 1
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.p.t():boolean");
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = n();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || t();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Process} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e A[SYNTHETIC, Splitter:B:21:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0079 A[SYNTHETIC, Splitter:B:39:0x0079] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r8) {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "ToolUtils"
            java.lang.String r2 = ""
            r3 = 0
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ IllegalThreadStateException -> 0x0073, all -> 0x0047 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IllegalThreadStateException -> 0x0073, all -> 0x0047 }
            r5.<init>()     // Catch:{ IllegalThreadStateException -> 0x0073, all -> 0x0047 }
            java.lang.String r6 = "getprop "
            r5.append(r6)     // Catch:{ IllegalThreadStateException -> 0x0073, all -> 0x0047 }
            r5.append(r8)     // Catch:{ IllegalThreadStateException -> 0x0073, all -> 0x0047 }
            java.lang.String r5 = r5.toString()     // Catch:{ IllegalThreadStateException -> 0x0073, all -> 0x0047 }
            java.lang.Process r4 = r4.exec(r5)     // Catch:{ IllegalThreadStateException -> 0x0073, all -> 0x0047 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IllegalThreadStateException -> 0x0044, all -> 0x0047 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IllegalThreadStateException -> 0x0044, all -> 0x0047 }
            java.io.InputStream r7 = r4.getInputStream()     // Catch:{ IllegalThreadStateException -> 0x0044, all -> 0x0047 }
            r6.<init>(r7)     // Catch:{ IllegalThreadStateException -> 0x0044, all -> 0x0047 }
            r7 = 1024(0x400, float:1.435E-42)
            r5.<init>(r6, r7)     // Catch:{ IllegalThreadStateException -> 0x0044, all -> 0x0047 }
            java.lang.String r2 = r5.readLine()     // Catch:{ IllegalThreadStateException -> 0x0045, all -> 0x0040 }
            r4.exitValue()     // Catch:{ IllegalThreadStateException -> 0x0045, all -> 0x0040 }
            r5.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x007c
        L_0x003b:
            r8 = move-exception
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r8)
            goto L_0x007c
        L_0x0040:
            r3 = move-exception
            r4 = r3
            r3 = r5
            goto L_0x0048
        L_0x0044:
            r5 = r3
        L_0x0045:
            r3 = r4
            goto L_0x0074
        L_0x0047:
            r4 = move-exception
        L_0x0048:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r5.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = "Unable to read sysprop "
            r5.append(r6)     // Catch:{ all -> 0x0067 }
            r5.append(r8)     // Catch:{ all -> 0x0067 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0067 }
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r8, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0066
            r3.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r8 = move-exception
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r8)
        L_0x0066:
            return r2
        L_0x0067:
            r8 = move-exception
            if (r3 == 0) goto L_0x0072
            r3.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r2 = move-exception
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x0072:
            throw r8
        L_0x0073:
            r5 = r3
        L_0x0074:
            r3.destroy()     // Catch:{ all -> 0x0077 }
        L_0x0077:
            if (r5 == 0) goto L_0x007c
            r5.close()     // Catch:{ IOException -> 0x003b }
        L_0x007c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.p.c(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d(java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            java.lang.String r3 = "getSystemPropertyTask() called with: propName = ["
            r1[r2] = r3
            r2 = 1
            r1[r2] = r5
            r2 = 2
            java.lang.String r3 = "]"
            r1[r2] = r3
            java.lang.String r3 = "RomUtils"
            com.bytedance.sdk.component.utils.l.a((java.lang.String) r3, (java.lang.Object[]) r1)
            java.util.HashMap<java.lang.String, java.lang.String> r1 = h
            java.lang.Object r1 = r1.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0022
            return r1
        L_0x0022:
            java.lang.String r1 = w()     // Catch:{ all -> 0x004e }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x004c
            com.bytedance.sdk.openadsdk.l.p$a r3 = new com.bytedance.sdk.openadsdk.l.p$a     // Catch:{ all -> 0x004c }
            r3.<init>(r5)     // Catch:{ all -> 0x004c }
            com.bytedance.sdk.component.g.f r5 = new com.bytedance.sdk.component.g.f     // Catch:{ all -> 0x004c }
            r4 = 5
            r5.<init>(r3, r4, r2)     // Catch:{ all -> 0x004c }
            com.bytedance.sdk.openadsdk.l.p$1 r2 = new com.bytedance.sdk.openadsdk.l.p$1     // Catch:{ all -> 0x004c }
            java.lang.String r3 = "_getSystemPropertyTask"
            r2.<init>(r3, r5)     // Catch:{ all -> 0x004c }
            com.bytedance.sdk.openadsdk.l.w.a((com.bytedance.sdk.component.g.g) r2)     // Catch:{ all -> 0x004c }
            r2 = 1
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x004c }
            java.lang.Object r5 = r5.get(r2, r4)     // Catch:{ all -> 0x004c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x004c }
            goto L_0x004f
        L_0x004c:
            r5 = r1
            goto L_0x004f
        L_0x004e:
            r5 = r0
        L_0x004f:
            if (r5 != 0) goto L_0x0052
            return r0
        L_0x0052:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.p.d(java.lang.String):java.lang.String");
    }

    /* compiled from: RomUtils */
    public static class a implements Callable<String> {
        private String a;

        public a(String str) {
            this.a = str;
        }

        /* renamed from: a */
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String b = p.c(this.a);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            l.b("RomUtils", "property:" + b + ",getSystemProperty use time :" + currentTimeMillis2);
            if (b != null) {
                p.h.put(this.a, b);
            }
            if (!TextUtils.isEmpty(b)) {
                try {
                    if (b.c()) {
                        l.d("RomUtils", "SPMultiHelper-getPropertyFromSPMultiHelper:" + b);
                        com.bytedance.sdk.openadsdk.multipro.d.a.a("rom_info", "rom_property_info", b);
                    } else {
                        l.d("RomUtils", "SP-getPropertyFromSP:" + b);
                        u.a("rom_info", m.a()).a("rom_property_info", b);
                    }
                } catch (Throwable unused) {
                }
            }
            return b;
        }
    }

    private static String w() {
        try {
            if (b.c()) {
                String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("rom_info", "rom_property_info", "");
                l.c("RomUtils", "get Property From SPMultiHelper..." + b2);
                return b2;
            }
            String b3 = u.a("rom_info", m.a()).b("rom_property_info", "");
            l.c("RomUtils", "get Property From SP...=" + b3);
            return b3;
        } catch (Throwable unused) {
            return "";
        }
    }
}
