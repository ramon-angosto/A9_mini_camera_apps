package com.bytedance.sdk.openadsdk.l;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.w;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.shix.shixipc.utils.RomUtil;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: ToolUtils */
public class y {
    private static final ExecutorService a = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public static volatile boolean b = false;
    /* access modifiers changed from: private */
    public static volatile String c = "";
    private static final ReentrantLock d = new ReentrantLock();
    private static String e = null;
    private static String f = null;
    private static String g = null;
    private static final HashSet<String> h = new HashSet<>(Arrays.asList(new String[]{"Asia/Shanghai", "Asia/Urumqi", "Asia/Chongqing", "Asia/Harbin", "Asia/Kashgar"}));

    public static String a(int i) {
        switch (i) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    public static void a(n nVar, View view) {
    }

    public static String b(int i) {
        return i != 1 ? i != 2 ? (i == 3 || i == 4) ? "open_ad" : i != 7 ? i != 8 ? i != 9 ? "embeded_ad" : "draw_ad" : "fullscreen_interstitial_ad" : "rewarded_video" : "interaction" : "banner_ad";
    }

    public static boolean c(int i) {
        return i == 4;
    }

    public static boolean d(int i) {
        return i == 5;
    }

    public static boolean e(int i) {
        return i == 6;
    }

    public static int f(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 4) {
            return 1;
        }
        if (i == 5) {
            return 4;
        }
        if (i != 6) {
            return i;
        }
        return 5;
    }

    public static Intent a(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage((String) null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a() {
        return h.d() != null && !h.d().a();
    }

    public static boolean c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                b.a(context, intent, (b.a) null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String a(n nVar) {
        if (nVar == null) {
            return null;
        }
        try {
            return b(nVar.aR());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r8) {
        /*
            int r0 = r8.hashCode()
            r1 = 7
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 6
            r7 = 1
            switch(r0) {
                case -1695837674: goto L_0x0055;
                case -1364000502: goto L_0x004b;
                case -1263194568: goto L_0x0041;
                case -764631662: goto L_0x0037;
                case -712491894: goto L_0x002d;
                case 564365438: goto L_0x0023;
                case 1844104722: goto L_0x0019;
                case 1912999166: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x005f
        L_0x000f:
            java.lang.String r0 = "draw_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x005f
            r8 = r7
            goto L_0x0060
        L_0x0019:
            java.lang.String r0 = "interaction"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x005f
            r8 = r4
            goto L_0x0060
        L_0x0023:
            java.lang.String r0 = "cache_splash_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x005f
            r8 = r2
            goto L_0x0060
        L_0x002d:
            java.lang.String r0 = "embeded_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x005f
            r8 = 0
            goto L_0x0060
        L_0x0037:
            java.lang.String r0 = "fullscreen_interstitial_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x005f
            r8 = r6
            goto L_0x0060
        L_0x0041:
            java.lang.String r0 = "open_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x005f
            r8 = r3
            goto L_0x0060
        L_0x004b:
            java.lang.String r0 = "rewarded_video"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x005f
            r8 = r1
            goto L_0x0060
        L_0x0055:
            java.lang.String r0 = "banner_ad"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x005f
            r8 = r5
            goto L_0x0060
        L_0x005f:
            r8 = -1
        L_0x0060:
            switch(r8) {
                case 0: goto L_0x006a;
                case 1: goto L_0x0069;
                case 2: goto L_0x0068;
                case 3: goto L_0x0067;
                case 4: goto L_0x0066;
                case 5: goto L_0x0066;
                case 6: goto L_0x0065;
                case 7: goto L_0x0064;
                default: goto L_0x0063;
            }
        L_0x0063:
            return r7
        L_0x0064:
            return r1
        L_0x0065:
            return r2
        L_0x0066:
            return r3
        L_0x0067:
            return r4
        L_0x0068:
            return r5
        L_0x0069:
            return r6
        L_0x006a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.y.a(java.lang.String):int");
    }

    public static String b() {
        String str;
        String str2 = "unKnow";
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                str = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_multi_ua_data", "android_system_ua", str2);
            } else {
                str = c.a(m.a()).b("android_system_ua", str2);
            }
            if (str != null && !str2.equals(str)) {
                return str;
            }
            FutureTask futureTask = new FutureTask(new a(2));
            a.execute(futureTask);
            str2 = (String) futureTask.get(500, TimeUnit.MILLISECONDS);
            l.e("getUA", " getAndroidSystemUA userAgent" + str2);
            return str2;
        } catch (Exception unused) {
        }
    }

    public static String c() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        c = h.a("sdk_local_web_ua", 86400000);
        if (TextUtils.isEmpty(c) && d.tryLock()) {
            try {
                if (Build.VERSION.SDK_INT < 17) {
                    w.a((Runnable) new Runnable() {
                        public void run() {
                            try {
                                if (TextUtils.isEmpty(y.c)) {
                                    SSWebView sSWebView = new SSWebView(m.a());
                                    sSWebView.setWebViewClient(new SSWebView.a());
                                    String unused = y.c = sSWebView.getUserAgentString();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else if (TextUtils.isEmpty(c)) {
                    c = WebSettings.getDefaultUserAgent(m.a());
                }
                h.a("sdk_local_web_ua", c);
            } catch (Exception e2) {
                l.c("ToolUtils", "", (Throwable) e2);
            } catch (Throwable th) {
                d.unlock();
                throw th;
            }
            d.unlock();
        }
        return c;
    }

    /* access modifiers changed from: private */
    public static String v() {
        try {
            WebView webView = new WebView(m.a());
            webView.setWebViewClient(new SSWebView.a());
            String userAgentString = webView.getSettings().getUserAgentString();
            if (userAgentString != null && !"unKnow".equals(userAgentString)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_ua_data", "webview_ua", userAgentString);
                } else {
                    c.a(m.a()).a("webview_ua", userAgentString);
                }
            }
            return userAgentString;
        } catch (Throwable th) {
            l.e("getUA", "e:" + th.getMessage());
            return "unKnow";
        }
    }

    /* compiled from: ToolUtils */
    public static class a implements Callable<String> {
        private final int a;

        a(int i) {
            this.a = i;
        }

        /* renamed from: a */
        public synchronized String call() throws Exception {
            String str;
            str = "unKnow";
            if (this.a == 1) {
                str = c();
            } else if (this.a == 2) {
                str = b();
            }
            return str;
        }

        private String b() {
            String str;
            Throwable th;
            try {
                str = System.getProperty("http.agent");
                if (str != null) {
                    try {
                        if (!"unKnow".equals(str)) {
                            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_ua_data", "android_system_ua", str);
                            } else {
                                c.a(m.a()).a("android_system_ua", str);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        l.e("getUA", "e:" + th.getMessage());
                        return str;
                    }
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                str = "unKnow";
                th = th4;
                l.e("getUA", "e:" + th.getMessage());
                return str;
            }
            return str;
        }

        private synchronized String c() {
            final String[] strArr;
            strArr = new String[]{"unKnow"};
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            w.a((Runnable) new Runnable() {
                public void run() {
                    strArr[0] = y.v();
                    l.b("getUA", "webview ua：" + strArr[0]);
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return strArr[0];
        }
    }

    public static String d() {
        return o.a();
    }

    public static synchronized String e() {
        String str;
        Context a2;
        synchronized (y.class) {
            if (TextUtils.isEmpty(e) && (a2 = m.a()) != null) {
                try {
                    e = a2.getPackageName();
                } catch (Throwable th) {
                    l.c("ToolUtils", "ToolUtils getPackageName throws exception :", th);
                }
            }
            str = e;
        }
        return str;
    }

    public static synchronized String f() {
        String str;
        synchronized (y.class) {
            if (TextUtils.isEmpty(f) && m.a() != null) {
                try {
                    PackageInfo packageInfo = m.a().getPackageManager().getPackageInfo(e(), 0);
                    f = String.valueOf(packageInfo.versionCode);
                    g = packageInfo.versionName;
                } catch (Throwable th) {
                    l.c("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
                }
            }
            str = f;
        }
        return str;
    }

    public static synchronized String g() {
        String str;
        synchronized (y.class) {
            if (TextUtils.isEmpty(g) && m.a() != null) {
                try {
                    PackageInfo packageInfo = m.a().getPackageManager().getPackageInfo(e(), 0);
                    f = String.valueOf(packageInfo.versionCode);
                    g = packageInfo.versionName;
                } catch (Throwable th) {
                    l.c("ToolUtils", "ToolUtils getVersionName throws exception :", th);
                }
            }
            str = g;
        }
        return str;
    }

    public static String a(Context context) {
        String b2 = c.a(context).b("total_memory", (String) null);
        if (b2 == null || b(b2) <= 0) {
            b2 = c("MemTotal");
            if (b(b2) <= 0) {
                b2 = h();
            }
            c.a(context).a("total_memory", b2);
        }
        return b2;
    }

    public static long b(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String h() {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) m.a().getSystemService("activity")).getMemoryInfo(memoryInfo);
            if (memoryInfo.totalMem > 0) {
                return String.valueOf(memoryInfo.totalMem / 1024);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        return c.a(context).b("total_memory", MBridgeConstans.ENDCARD_URL_TYPE_PL);
    }

    public static String i() {
        return c("MemTotal");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.FileReader} */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:17|18|19|20|21|22|23|24) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0048 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001d A[SYNTHETIC, Splitter:B:11:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0059 A[SYNTHETIC, Splitter:B:34:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005e A[SYNTHETIC, Splitter:B:38:0x005e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r7) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "/proc/meminfo"
            r1.<init>(r2)     // Catch:{ all -> 0x0051 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x004e }
            r3 = 4096(0x1000, float:5.74E-42)
            r2.<init>(r1, r3)     // Catch:{ all -> 0x004e }
        L_0x000f:
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x001b
            boolean r4 = r3.contains(r7)     // Catch:{ all -> 0x004c }
            if (r4 == 0) goto L_0x000f
        L_0x001b:
            if (r3 != 0) goto L_0x0024
            r2.close()     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            r1.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            return r0
        L_0x0024:
            java.lang.String r7 = "\\s+"
            java.lang.String[] r7 = r3.split(r7)     // Catch:{ all -> 0x004c }
            java.lang.String r3 = "ToolUtils"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r4.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r5 = "getTotalMemory = "
            r4.append(r5)     // Catch:{ all -> 0x004c }
            r5 = 1
            r6 = r7[r5]     // Catch:{ all -> 0x004c }
            r4.append(r6)     // Catch:{ all -> 0x004c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x004c }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x004c }
            r7 = r7[r5]     // Catch:{ all -> 0x004c }
            r2.close()     // Catch:{ Exception -> 0x0048 }
        L_0x0048:
            r1.close()     // Catch:{ Exception -> 0x004b }
        L_0x004b:
            return r7
        L_0x004c:
            r7 = move-exception
            goto L_0x0054
        L_0x004e:
            r7 = move-exception
            r2 = r0
            goto L_0x0054
        L_0x0051:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L_0x0054:
            r7.printStackTrace()     // Catch:{ all -> 0x0062 }
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ Exception -> 0x005c }
        L_0x005c:
            if (r1 == 0) goto L_0x0061
            r1.close()     // Catch:{ Exception -> 0x0061 }
        L_0x0061:
            return r0
        L_0x0062:
            r7 = move-exception
            if (r2 == 0) goto L_0x0068
            r2.close()     // Catch:{ Exception -> 0x0068 }
        L_0x0068:
            if (r1 == 0) goto L_0x006d
            r1.close()     // Catch:{ Exception -> 0x006d }
        L_0x006d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.y.c(java.lang.String):java.lang.String");
    }

    public static long c(Context context) {
        return c.a(context).b("total_internal_storage", 0).longValue();
    }

    public static long j() {
        long j;
        long j2;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                j = statFs.getBlockSizeLong();
                j2 = statFs.getBlockCountLong();
            } else {
                j = (long) statFs.getBlockSize();
                j2 = (long) statFs.getBlockCount();
            }
            return j2 * j;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long d(Context context) {
        return c.a(context).b("free_internal_storage", 0).longValue();
    }

    public static long e(Context context) {
        return c.a(context).b("total_sdcard_storage", 0).longValue();
    }

    public static long k() {
        try {
            if (!w()) {
                return 0;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private static boolean w() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int f(Context context) {
        return c.a(context).b("is_root", -1);
    }

    public static boolean l() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String d(String str) {
        return a(str, false);
    }

    public static String a(String str, boolean z) {
        String str2;
        String x = m.d().x();
        if (TextUtils.isEmpty(x)) {
            int p = p();
            if (p == 1) {
                str2 = "https://" + "pangolin16.sgsnssdk.com" + str;
            } else if (p == 2) {
                str2 = "https://" + "pangolin16.sgsnssdk.com" + str;
            } else {
                str2 = "https://" + "pangolin16.isnssdk.com" + str;
            }
            if (!z) {
                return v.a(str2);
            }
            return l(str2);
        }
        String str3 = "https://" + x + str;
        if (v.a() && !z) {
            str3 = v.a(str3);
        }
        return z ? l(str3) : str3;
    }

    private static String l(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", f()).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = m.d().y();
        }
        if (TextUtils.isEmpty(str)) {
            return p() == 2 ? "https://log.sgsnssdk.com/service/2/app_log/" : "https://log-mva.isnssdk.com/service/2/app_log/";
        }
        if (str.startsWith("http")) {
            return str;
        }
        return "https://" + str;
    }

    public static String m() {
        return String.format("https://%s", new Object[]{"log.byteoversea.com/service/2/app_log_test/"});
    }

    public static String n() {
        int p = p();
        return (p == 1 || p == 2) ? "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-sg/renderer/package_sg.json" : "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-va/renderer/package_va.json";
    }

    public static String o() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception e2) {
            l.e("ToolUtils", e2.toString());
            return "";
        }
    }

    public static int p() {
        try {
            String id = TimeZone.getDefault().getID();
            if (h.contains(id)) {
                return 2;
            }
            if (id != null && id.startsWith("Asia/")) {
                return 2;
            }
            if (id == null || !id.startsWith("Europe/")) {
                return (id == null || !id.startsWith("America/")) ? 3 : 5;
            }
            return 4;
        } catch (Throwable th) {
            l.e("ToolUtils", th.toString());
            return 0;
        }
    }

    public static String g(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            String language = locale.getLanguage();
            String country = locale.getCountry();
            return language + "_" + country;
        } catch (Exception e2) {
            l.e("ToolUtils", e2.toString());
            return "";
        }
    }

    public static String h(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e2) {
            l.e("ToolUtils", e2.toString());
            return "";
        }
    }

    public static int q() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static String r() {
        int i = -q();
        if (i >= 0) {
            return "Etc/GMT+" + i;
        }
        return "Etc/GMT" + i;
    }

    public static Map<String, Object> a(boolean z, n nVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(CampaignEx.JSON_KEY_CREATIVE_ID, nVar.Y());
        hashMap.put("load_time", Long.valueOf(j));
        com.bykv.vk.openvk.component.video.api.c.b J = nVar.J();
        if (J != null) {
            hashMap.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(J.e()));
            hashMap.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, J.g());
        }
        if (!z) {
            hashMap.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static Map<String, Object> a(n nVar, long j, com.bykv.vk.openvk.component.video.api.a aVar) {
        if (nVar == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CampaignEx.JSON_KEY_CREATIVE_ID, nVar.Y());
        hashMap.put("buffers_time", Long.valueOf(j));
        com.bykv.vk.openvk.component.video.api.c.b J = nVar.J();
        if (J != null) {
            hashMap.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(J.e()));
            hashMap.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, J.g());
        }
        a((Map<String, Object>) hashMap, aVar);
        return hashMap;
    }

    private static void a(Map<String, Object> map, com.bykv.vk.openvk.component.video.api.a aVar) {
        if (!map.containsKey(CampaignEx.JSON_KEY_VIDEO_RESOLUTION) && aVar != null) {
            try {
                int j = aVar.j();
                int k = aVar.k();
                map.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, String.format(Locale.getDefault(), "%d×%d", new Object[]{Integer.valueOf(j), Integer.valueOf(k)}));
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean f(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(n nVar, String str) {
        if (nVar != null) {
            try {
                String O = nVar.O();
                if (TextUtils.isEmpty(O) && nVar.ab() != null && nVar.ab().c() == 1 && !TextUtils.isEmpty(nVar.ab().b())) {
                    O = nVar.ab().b();
                }
                String str2 = O;
                if (!TextUtils.isEmpty(str2)) {
                    w.a(m.a(), str2, nVar, a(str), str, false);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean b(n nVar) {
        if (nVar == null) {
            return true;
        }
        int a2 = m.d().a(nVar.aW());
        int c2 = o.c(m.a());
        if (a2 == 1) {
            return c(c2);
        }
        if (a2 != 2) {
            if (a2 == 3) {
                return false;
            }
            if (a2 == 4 || a2 != 5 || c(c2) || e(c2)) {
                return true;
            }
            return false;
        } else if (d(c2) || c(c2) || e(c2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean i(Context context) {
        if (context != null) {
            boolean z = context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30;
            StringBuilder sb = new StringBuilder();
            sb.append("can query all package = ");
            sb.append(!z);
            l.c("ToolUtils", sb.toString());
            return !z;
        }
        throw new IllegalArgumentException("params context is null");
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", RomUtil.ROM_OPPO);
        }
        if (str.contains("kllk")) {
            return str.replace("kllk", "oppo");
        }
        return "";
    }

    public static boolean a(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && a(j) == a(j2);
    }

    public static long a(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static void a(String str, String str2, Context context) {
        int i;
        if (!TextUtils.isEmpty(str2) && j(context)) {
            int i2 = 3572;
            int length = str2.length();
            int i3 = 0;
            int i4 = 1;
            if (length % 3572 == 0) {
                i = length / 3572;
            } else {
                i = (length / 3572) + 1;
            }
            while (true) {
                int i5 = i3;
                i3 = i2;
                int i6 = i5;
                if (i4 > i) {
                    return;
                }
                if (i3 < length) {
                    Log.d(str, i + "-" + i4 + ":" + str2.substring(i6, i3));
                    i2 = i3 + 3572;
                    i4++;
                } else {
                    Log.d(str, i + "-" + i4 + ":" + str2.substring(i6));
                    return;
                }
            }
        }
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long k(Context context) {
        int i = -1;
        try {
            i = context.getApplicationInfo().targetSdkVersion;
            l.b("ToolUtils", "targetSdkVersion = ", Integer.valueOf(i));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return (long) i;
    }

    public static long l(Context context) {
        int i = -1;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                i = context.getApplicationInfo().minSdkVersion;
                l.b("ToolUtils", "minSdkVersion = ", Integer.valueOf(i));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return (long) i;
    }

    public static void h(final String str) {
        com.bytedance.sdk.openadsdk.h.b.a().b((com.bytedance.sdk.openadsdk.h.a) new com.bytedance.sdk.openadsdk.h.a() {
            public com.bytedance.sdk.openadsdk.h.a.a a() throws Exception {
                if (y.b || !m.d().O()) {
                    return null;
                }
                boolean unused = y.b = true;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                return com.bytedance.sdk.openadsdk.h.a.b.b().a("reportMultiLog").b(jSONObject.toString());
            }
        });
    }

    public static void i(String str) {
        if (!PAGSdk.isInitSuccess()) {
            l.d("You must use method '" + str + "' after initialization, please check.");
        }
    }

    public static void j(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            l.d("You should use method '" + str + "' on the asynchronous thread,it may cause anr, please check.");
        }
    }

    public static int m(Context context) {
        return f(v.a(context, 0));
    }
}
