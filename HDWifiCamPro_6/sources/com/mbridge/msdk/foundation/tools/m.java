package com.mbridge.msdk.foundation.tools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.f.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* compiled from: SameDiTool */
public final class m extends d {
    private static String a = null;
    private static String b = null;
    private static int c = -1;
    private static int d = -1;
    /* access modifiers changed from: private */
    public static volatile int e = 0;
    /* access modifiers changed from: private */
    public static String f = "";
    private static String g = "";
    private static String h = "";
    private static String i = "";
    private static int j = 0;
    private static String k = "";
    /* access modifiers changed from: private */
    public static String l = "";
    private static int m = -1;
    private static String n = "";
    private static int o = 0;
    private static String p = "";

    public static int a(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                return 0;
        }
    }

    public static void b(Context context) {
        try {
            f();
            k(context);
            f(context);
            e(context);
            d(context);
            a();
            c();
            i();
            c(context);
            e();
            a.c = false;
            a.b = u.a("android.permission.ACCESS_NETWORK_STATE", context);
            g(context);
            t();
        } catch (Exception unused) {
        }
    }

    public static String a() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MODEL;
    }

    public static String b() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static String c() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.BRAND;
    }

    public static String c(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(k)) {
            if (context == null) {
                return "en-US";
            }
            try {
                if (context.getResources() != null) {
                    if (context.getResources().getConfiguration() != null) {
                        Locale locale = context.getResources().getConfiguration().locale;
                        if (locale == null) {
                            return "en-US";
                        }
                        if (Build.VERSION.SDK_INT >= 21) {
                            k = locale.toLanguageTag();
                        } else {
                            k = locale.getLanguage() + "-" + locale.getCountry();
                        }
                        return k;
                    }
                }
                return "en-US";
            } catch (Throwable th) {
                q.a("SameDiTool", th.getMessage());
                k = "en-US";
            }
        }
        return k;
    }

    public static int d(Context context) {
        Configuration configuration;
        if (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null) {
            return 1;
        }
        int i2 = configuration.orientation;
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 1) {
        }
        return 1;
    }

    public static int e(Context context) {
        if (context == null) {
            return j;
        }
        int i2 = j;
        if (i2 != 0) {
            return i2;
        }
        try {
            j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            return j;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String f(Context context) {
        if (context == null) {
            return i;
        }
        try {
            if (!TextUtils.isEmpty(i)) {
                return i;
            }
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return i;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int g(Context context) {
        if (context == null) {
            return o;
        }
        if (o == 0) {
            try {
                o = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e2) {
                q.d("SameDiTool", e2.getMessage());
            }
        }
        return o;
    }

    public static int h(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap j2 = j(context);
            return j2.get("width") == null ? displayMetrics.widthPixels : ((Integer) j2.get("width")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int i(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap j2 = j(context);
            return j2.get("height") == null ? displayMetrics.heightPixels : ((Integer) j2.get("height")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static HashMap j(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            hashMap.put("height", Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("width", Integer.valueOf(displayMetrics.widthPixels));
        } catch (Exception e2) {
            q.a("SameDiTool", e2.getMessage(), e2);
        }
        return hashMap;
    }

    public static String k(Context context) {
        if (context == null) {
            return h;
        }
        try {
            if (!TextUtils.isEmpty(h)) {
                return h;
            }
            h = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            return h;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void l(final Context context) {
        if (context != null) {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    a(context);
                } else {
                    new Handler(context.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            d.a(context);
                        }
                    });
                }
            } catch (Exception e2) {
                q.a("SameDiTool", "", e2);
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0054 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m(final android.content.Context r8) {
        /*
            com.mbridge.msdk.foundation.controller.authoritycontroller.a r0 = com.mbridge.msdk.foundation.controller.authoritycontroller.a.a()
            java.lang.String r1 = "authority_general_data"
            boolean r0 = r0.a((java.lang.String) r1)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.String r0 = f
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "SameDiTool"
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = "mbridge_ua"
            java.lang.String r3 = ""
            java.lang.Object r0 = com.mbridge.msdk.foundation.tools.w.b(r8, r0, r3)     // Catch:{ all -> 0x0027 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0027 }
            f = r0     // Catch:{ all -> 0x0027 }
            goto L_0x002f
        L_0x0027:
            r0 = move-exception
            java.lang.String r3 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r2, r3, r0)
        L_0x002f:
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch:{ all -> 0x00c9 }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x00c9 }
            r4 = 1
            r5 = 0
            if (r0 != r3) goto L_0x003d
            r0 = r4
            goto L_0x003e
        L_0x003d:
            r0 = r5
        L_0x003e:
            if (r0 == 0) goto L_0x00c5
            java.lang.String r0 = f     // Catch:{ all -> 0x00c9 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x00b2
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0054 }
            r3 = 17
            if (r0 < r3) goto L_0x0054
            java.lang.String r0 = android.webkit.WebSettings.getDefaultUserAgent(r8)     // Catch:{ all -> 0x0054 }
            f = r0     // Catch:{ all -> 0x0054 }
        L_0x0054:
            java.lang.String r0 = f     // Catch:{ all -> 0x00c9 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x00d1
            java.lang.Class<android.webkit.WebSettings> r0 = android.webkit.WebSettings.class
            r3 = 2
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ all -> 0x0086 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r5] = r7     // Catch:{ all -> 0x0086 }
            java.lang.Class<android.webkit.WebView> r7 = android.webkit.WebView.class
            r6[r4] = r7     // Catch:{ all -> 0x0086 }
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r6)     // Catch:{ all -> 0x0086 }
            r0.setAccessible(r4)     // Catch:{ all -> 0x0086 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0086 }
            r3[r5] = r8     // Catch:{ all -> 0x0086 }
            r3[r4] = r1     // Catch:{ all -> 0x0086 }
            java.lang.Object r1 = r0.newInstance(r3)     // Catch:{ all -> 0x0086 }
            android.webkit.WebSettings r1 = (android.webkit.WebSettings) r1     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = r1.getUserAgentString()     // Catch:{ all -> 0x0086 }
            f = r1     // Catch:{ all -> 0x0086 }
            r0.setAccessible(r5)     // Catch:{ all -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00c9 }
        L_0x008a:
            java.lang.String r0 = f     // Catch:{ all -> 0x00c9 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x00a6
            android.webkit.WebView r0 = new android.webkit.WebView     // Catch:{ all -> 0x00a2 }
            r0.<init>(r8)     // Catch:{ all -> 0x00a2 }
            android.webkit.WebSettings r0 = r0.getSettings()     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r0.getUserAgentString()     // Catch:{ all -> 0x00a2 }
            f = r0     // Catch:{ all -> 0x00a2 }
            goto L_0x00a6
        L_0x00a2:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00c9 }
        L_0x00a6:
            java.lang.String r0 = f     // Catch:{ all -> 0x00c9 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x00d1
            r()     // Catch:{ all -> 0x00c9 }
            goto L_0x00d1
        L_0x00b2:
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ Exception -> 0x00c0 }
            com.mbridge.msdk.foundation.tools.m$2 r1 = new com.mbridge.msdk.foundation.tools.m$2     // Catch:{ Exception -> 0x00c0 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x00c0 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00c0 }
            r0.start()     // Catch:{ Exception -> 0x00c0 }
            goto L_0x00d1
        L_0x00c0:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00c9 }
            goto L_0x00d1
        L_0x00c5:
            r()     // Catch:{ all -> 0x00c9 }
            goto L_0x00d1
        L_0x00c9:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r2, r1, r0)
        L_0x00d1:
            r(r8)
            java.lang.String r8 = f
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.m.m(android.content.Context):java.lang.String");
    }

    /* access modifiers changed from: private */
    public static void r(Context context) {
        try {
            w.a(context, "mbridge_ua", f);
        } catch (Throwable th) {
            q.a("SameDiTool", th.getMessage(), th);
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(f)) {
            m(com.mbridge.msdk.foundation.controller.a.e().g());
        }
        return f;
    }

    private static void r() {
        String str = Build.VERSION.RELEASE;
        String a2 = a();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(a2)) {
            f = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
            return;
        }
        f = "Mozilla/5.0 (Linux; Android " + str + "; " + a2 + " Build/) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
    }

    public static int n(Context context) {
        try {
            final Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return e;
            }
            if (g2 == null) {
                return e;
            }
            if (e != 0) {
                b.a().execute(new Runnable() {
                    public final void run() {
                        ConnectivityManager connectivityManager;
                        try {
                            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && g2 != null && (connectivityManager = (ConnectivityManager) g2.getSystemService("connectivity")) != null && a.b) {
                                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                if (activeNetworkInfo == null) {
                                    int unused = m.e = 0;
                                } else if (activeNetworkInfo.getType() == 1) {
                                    int unused2 = m.e = 9;
                                } else {
                                    TelephonyManager telephonyManager = (TelephonyManager) g2.getSystemService("phone");
                                    if (telephonyManager == null) {
                                        int unused3 = m.e = 0;
                                    } else {
                                        int unused4 = m.e = m.a(telephonyManager.getNetworkType());
                                    }
                                }
                            }
                        } catch (Exception e) {
                            q.a("SameDiTool", e.getMessage(), e);
                            int unused5 = m.e = 0;
                        }
                    }
                });
                return e;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) g2.getSystemService("connectivity");
            if (connectivityManager == null) {
                return e;
            }
            if (a.b) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    e = 0;
                    return e;
                } else if (activeNetworkInfo.getType() == 1) {
                    e = 9;
                    return e;
                } else {
                    TelephonyManager telephonyManager = (TelephonyManager) g2.getSystemService("phone");
                    if (telephonyManager == null) {
                        e = 0;
                        return e;
                    }
                    e = telephonyManager.getNetworkType();
                    return a(e);
                }
            } else {
                e = 0;
                return e;
            }
        } catch (Exception e2) {
            q.a("SameDiTool", e2.getMessage(), e2);
            e = 0;
            return e;
        }
    }

    public static String a(Context context, int i2) {
        TelephonyManager telephonyManager;
        if (i2 == 0 || i2 == 9) {
            return "";
        }
        try {
            if (!a.b || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                return "";
            }
            return String.valueOf(telephonyManager.getNetworkType());
        } catch (Throwable th) {
            q.a("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    public static String e() {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
                return "";
            }
            if (TextUtils.isEmpty(l)) {
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            String unused = m.l = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }).start();
                return l;
            }
            return l;
        } catch (Throwable th) {
            q.a("SameDiTool", th.getMessage(), th);
        }
    }

    public static String f() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(g)) {
            int g2 = g();
            g = g2 + "";
        }
        return g;
    }

    public static int g() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int h() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return -1;
        }
        return Build.VERSION.SDK_INT;
    }

    public static void a(String str) {
        b = l.a(str);
        a = str;
    }

    public static String i() {
        String str;
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID) && (str = a) != null) {
            return str;
        }
        return "";
    }

    public static String j() {
        String str;
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID) && (str = b) != null) {
            return str;
        }
        return "";
    }

    public static String a(String str, Context context) {
        try {
            if (!TextUtils.isEmpty(n)) {
                return n;
            }
            if (!TextUtils.isEmpty(str) && context != null) {
                n = context.getPackageManager().getInstallerPackageName(str);
                q.a("SameDiTool", "PKGSource:" + n);
            }
            return n;
        } catch (Exception e2) {
            q.a("SameDiTool", e2.getMessage(), e2);
        }
    }

    public static String k() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MANUFACTURER;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:3|4|5|6|7|8|9|(2:11|12)|13|14|15|16|47|48) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0050 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074 A[SYNTHETIC, Splitter:B:30:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0079 A[SYNTHETIC, Splitter:B:34:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008a A[SYNTHETIC, Splitter:B:41:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f A[SYNTHETIC, Splitter:B:45:0x008f] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x0081=Splitter:B:38:0x0081, B:27:0x006b=Splitter:B:27:0x006b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String l() {
        /*
            java.lang.String r0 = "SameDiTool"
            com.mbridge.msdk.foundation.controller.authoritycontroller.a r1 = com.mbridge.msdk.foundation.controller.authoritycontroller.a.a()
            java.lang.String r2 = "authority_general_data"
            boolean r1 = r1.a((java.lang.String) r2)
            if (r1 != 0) goto L_0x0011
            java.lang.String r0 = ""
            return r0
        L_0x0011:
            java.lang.String r1 = "/proc/meminfo"
            r2 = 0
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x007d, all -> 0x0067 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x007d, all -> 0x0067 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            r5 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r4, r5)     // Catch:{ Exception -> 0x0062, all -> 0x005d }
            java.lang.String r3 = r1.readLine()     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            r5 = 1
            r3 = r3[r5]     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            r1.close()     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            if (r3 == 0) goto L_0x004d
            java.lang.Float r5 = new java.lang.Float     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            float r3 = r3.floatValue()     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            r6 = 1233125376(0x49800000, float:1048576.0)
            float r3 = r3 / r6
            r5.<init>(r3)     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            double r5 = r5.doubleValue()     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            double r2 = java.lang.Math.ceil(r5)     // Catch:{ Exception -> 0x005b, all -> 0x0059 }
            int r0 = (int) r2
            r2 = r0
        L_0x004d:
            r4.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0050:
            r1.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0092
        L_0x0054:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0092
        L_0x0059:
            r3 = move-exception
            goto L_0x006b
        L_0x005b:
            r3 = move-exception
            goto L_0x0081
        L_0x005d:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x006b
        L_0x0062:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0081
        L_0x0067:
            r1 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
        L_0x006b:
            java.lang.String r5 = r3.getMessage()     // Catch:{ all -> 0x00a4 }
            com.mbridge.msdk.foundation.tools.q.a(r0, r5, r3)     // Catch:{ all -> 0x00a4 }
            if (r4 == 0) goto L_0x0077
            r4.close()     // Catch:{ IOException -> 0x0077 }
        L_0x0077:
            if (r1 == 0) goto L_0x0092
            r1.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0092
        L_0x007d:
            r1 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
        L_0x0081:
            java.lang.String r5 = r3.getMessage()     // Catch:{ all -> 0x00a4 }
            com.mbridge.msdk.foundation.tools.q.a(r0, r5, r3)     // Catch:{ all -> 0x00a4 }
            if (r4 == 0) goto L_0x008d
            r4.close()     // Catch:{ IOException -> 0x008d }
        L_0x008d:
            if (r1 == 0) goto L_0x0092
            r1.close()     // Catch:{ IOException -> 0x0054 }
        L_0x0092:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r1 = "GB"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x00a4:
            r0 = move-exception
            if (r4 == 0) goto L_0x00aa
            r4.close()     // Catch:{ IOException -> 0x00aa }
        L_0x00aa:
            if (r1 == 0) goto L_0x00b4
            r1.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00b4
        L_0x00b0:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00b4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.m.l():java.lang.String");
    }

    public static String o(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return "";
        }
        try {
            return Settings.System.getString(context.getContentResolver(), "time_12_24");
        } catch (Exception e2) {
            q.a("SameDiTool", e2.getMessage(), e2);
            return "";
        } catch (Throwable th) {
            q.a("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r1v23 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e A[SYNTHETIC, Splitter:B:32:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007c A[SYNTHETIC, Splitter:B:37:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c A[SYNTHETIC, Splitter:B:44:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009a A[SYNTHETIC, Splitter:B:49:0x009a] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:41:0x0083=Splitter:B:41:0x0083, B:29:0x0065=Splitter:B:29:0x0065} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String p(android.content.Context r9) {
        /*
            java.lang.String r0 = "SameDiTool"
            com.mbridge.msdk.foundation.controller.authoritycontroller.a r1 = com.mbridge.msdk.foundation.controller.authoritycontroller.a.a()
            java.lang.String r2 = "authority_general_data"
            boolean r1 = r1.a((java.lang.String) r2)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0011
            return r2
        L_0x0011:
            if (r9 != 0) goto L_0x0014
            return r2
        L_0x0014:
            java.lang.String r1 = "/proc/meminfo"
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x0080, all -> 0x0062 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0080, all -> 0x0062 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            r5 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            java.lang.String r3 = r1.readLine()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r5 = 1
            r3 = r3[r5]     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            long r5 = r3.longValue()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r7 = 1024(0x400, double:5.06E-321)
            long r5 = r5 * r7
            java.lang.String r9 = android.text.format.Formatter.formatFileSize(r9, r5)     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r1.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x004b
        L_0x0043:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r0, r2, r1)
        L_0x004b:
            r4.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0057
        L_0x004f:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r0, r2, r1)
        L_0x0057:
            return r9
        L_0x0058:
            r9 = move-exception
            goto L_0x0065
        L_0x005a:
            r9 = move-exception
            goto L_0x0083
        L_0x005c:
            r9 = move-exception
            r1 = r3
            goto L_0x0065
        L_0x005f:
            r9 = move-exception
            r1 = r3
            goto L_0x0083
        L_0x0062:
            r9 = move-exception
            r1 = r3
            r4 = r1
        L_0x0065:
            java.lang.String r3 = r9.getMessage()     // Catch:{ all -> 0x00a7 }
            com.mbridge.msdk.foundation.tools.q.a(r0, r3, r9)     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x007a
            r1.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x007a
        L_0x0072:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r0, r1, r9)
        L_0x007a:
            if (r4 == 0) goto L_0x00a6
            r4.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x00a6
        L_0x0080:
            r9 = move-exception
            r1 = r3
            r4 = r1
        L_0x0083:
            java.lang.String r3 = r9.getMessage()     // Catch:{ all -> 0x00a7 }
            com.mbridge.msdk.foundation.tools.q.a(r0, r3, r9)     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x0098
            r1.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0098
        L_0x0090:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r0, r1, r9)
        L_0x0098:
            if (r4 == 0) goto L_0x00a6
            r4.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x00a6
        L_0x009e:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r0, r1, r9)
        L_0x00a6:
            return r2
        L_0x00a7:
            r9 = move-exception
            if (r1 == 0) goto L_0x00b6
            r1.close()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00b6
        L_0x00ae:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r0, r2, r1)
        L_0x00b6:
            if (r4 == 0) goto L_0x00c4
            r4.close()     // Catch:{ IOException -> 0x00bc }
            goto L_0x00c4
        L_0x00bc:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r0, r2, r1)
        L_0x00c4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.m.p(android.content.Context):java.lang.String");
    }

    public static String m() {
        String str = "";
        try {
            Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            long s = s();
            String str2 = "app_tki_" + currentTimeMillis + "_" + s;
            String str3 = (String) w.b(g2, str2, str);
            try {
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("1", str);
                    jSONObject.put("2", String.valueOf(s));
                    jSONObject.put(MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3, String.valueOf(currentTimeMillis));
                    jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4, str);
                    jSONObject.put("5", str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                str = a.a(jSONObject.toString());
                w.a(g2, str2, str);
                return str;
            } catch (Exception e3) {
                e = e3;
                str = str3;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static int n() {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return 0;
            }
            Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
            long j2 = 0;
            long longValue = ((Long) w.b(g2, "FreeRamSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || d == -1) {
                Context g3 = com.mbridge.msdk.foundation.controller.a.e().g();
                if (g3 != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) g3.getSystemService("activity")).getMemoryInfo(memoryInfo);
                    j2 = memoryInfo.availMem;
                }
                d = Long.valueOf((j2 / 1000) / 1000).intValue();
                w.a(g2, "FreeRamSize", Long.valueOf(currentTimeMillis));
            }
            return d;
        } catch (Throwable th) {
            q.a("SameDiTool", th.getMessage(), th);
        }
    }

    private static long s() {
        Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
        if (g2 == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) g2.getSystemService("activity")).getMemoryInfo(memoryInfo);
        if (Build.VERSION.SDK_INT >= 16) {
            return memoryInfo.totalMem;
        }
        return 0;
    }

    public static int o() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return 0;
        }
        if (c < 1) {
            try {
                Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
                long longValue = ((Long) w.b(g2, "TotalRamSize", 0L)).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - longValue > 1800000 || c == -1) {
                    c = Long.valueOf((s() / 1000) / 1000).intValue();
                    w.a(g2, "TotalRamSize", Long.valueOf(currentTimeMillis));
                }
            } catch (Throwable th) {
                q.a("SameDiTool", th.getMessage(), th);
            }
        }
        return c;
    }

    public static int p() {
        return m;
    }

    private static String t() {
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        JSONObject jSONObject = new JSONObject();
        String str = null;
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable th) {
            q.d("SameDiTool", th.getMessage());
        }
        try {
            if (TextUtils.isEmpty(str) || !str.equals("harmony")) {
                p = "android";
                return p;
            }
            jSONObject.put("osType", str);
            Class<?> cls2 = Class.forName("ohos.system.version.SystemVersion");
            jSONObject.put("version", (String) cls2.getMethod("getVersion", new Class[0]).invoke(cls2, new Object[0]));
            try {
                jSONObject.put("pure_state", Settings.Secure.getInt(com.mbridge.msdk.foundation.controller.a.e().g().getContentResolver(), "pure_mode_state", -1));
            } catch (Throwable th2) {
                q.d("SameDiTool", th2.getMessage());
            }
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                jSONObject2 = l.a(jSONObject2);
            }
            p = jSONObject2;
            return p;
        } catch (Throwable th3) {
            q.d("SameDiTool", th3.getMessage());
        }
    }
}
