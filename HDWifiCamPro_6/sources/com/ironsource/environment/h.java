package com.ironsource.environment;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Paint;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ironsource.environment.e.c;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

public final class h {
    private static String a = null;
    private static String b = null;
    /* access modifiers changed from: private */
    public static String c = "";
    /* access modifiers changed from: private */
    public static String d = "";

    public static String A(Context context) {
        return c(context) ? "Tablet" : "Phone";
    }

    public static String B(Context context) {
        g gVar = g.a;
        if (!g.a()) {
            return "";
        }
        try {
            Class<?> cls = Class.forName("com.google.android.gms.appset.AppSet");
            Object invoke = cls.getMethod("getClient", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            Object invoke2 = invoke.getClass().getMethod("getAppSetIdInfo", new Class[0]).invoke(invoke, new Object[0]);
            Class<?> cls2 = Class.forName("com.google.android.gms.tasks.OnSuccessListener");
            invoke2.getClass().getMethod("addOnSuccessListener", new Class[]{cls2}).invoke(invoke2, new Object[]{Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls2}, new InvocationHandler() {
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    if (objArr == null) {
                        return null;
                    }
                    try {
                        if (objArr.length <= 0 || objArr[0] == null) {
                            return null;
                        }
                        String obj2 = objArr[0].getClass().getMethod("getId", new Class[0]).invoke(objArr[0], new Object[0]).toString();
                        if (TextUtils.isEmpty(obj2)) {
                            return null;
                        }
                        String unused = h.d = obj2;
                        return null;
                    } catch (Exception unused2) {
                        return null;
                    }
                }
            })});
            return !TextUtils.isEmpty(d) ? d : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String[] C(Context context) {
        String[] strArr = new String[0];
        g gVar = g.a;
        if (!g.b()) {
            return strArr;
        }
        try {
            Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Object invoke = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            Method method = invoke.getClass().getMethod("getId", new Class[0]);
            Method method2 = invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
            String obj = method.invoke(invoke, new Object[0]).toString();
            boolean booleanValue = ((Boolean) method2.invoke(invoke, new Object[0])).booleanValue();
            StringBuilder sb = new StringBuilder();
            sb.append(booleanValue);
            return new String[]{obj, sb.toString()};
        } catch (Exception unused) {
            return strArr;
        }
    }

    public static int D(Context context) {
        return IronSourceSharedPreferencesUtilities.getIntFromDefaultSharedPrefs(context, "IABTCF_gdprApplies", -1);
    }

    public static String E(Context context) {
        return IronSourceSharedPreferencesUtilities.getStringFromDefaultSharedPrefs(context, "IABTCF_TCString", (String) null);
    }

    public static long a() {
        return Calendar.getInstance(TimeZone.getDefault()).getTime().getTime();
    }

    private static long a(File file) {
        long j;
        long j2;
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT < 19) {
            j2 = (long) statFs.getAvailableBlocks();
            j = (long) statFs.getBlockSize();
        } else {
            j2 = statFs.getAvailableBlocksLong();
            j = statFs.getBlockSizeLong();
        }
        return (j2 * j) / 1048576;
    }

    public static long a(String str) {
        return a(new File(str));
    }

    public static String a(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0010, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.Class<com.ironsource.environment.h> r0 = com.ironsource.environment.h.class
            monitor-enter(r0)
            java.lang.String r1 = "Mediation_Shared_Preferences"
            java.lang.String r2 = "browser_user_agent"
            com.ironsource.environment.IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(r3, r1, r2, r4)     // Catch:{ Exception -> 0x000f, all -> 0x000c }
            monitor-exit(r0)
            return
        L_0x000c:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x000f:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.h.a(android.content.Context, java.lang.String):void");
    }

    public static boolean a(Activity activity) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (systemUiVisibility | 4096) == systemUiVisibility || (systemUiVisibility | 2048) == systemUiVisibility;
    }

    public static int b() {
        return -(TimeZone.getDefault().getOffset(a()) / 60000);
    }

    public static String b(Context context) {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    public static String c() {
        String id = TimeZone.getDefault().getID();
        return id != null ? id : "";
    }

    public static boolean c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f) {
                return true;
            }
        }
        return false;
    }

    public static long d(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return -1;
        }
        activityManager.getMemoryInfo(memoryInfo);
        if (Build.VERSION.SDK_INT >= 16) {
            return memoryInfo.totalMem;
        }
        return -1;
    }

    public static boolean d() {
        return "mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable();
    }

    private static boolean d(String str) {
        try {
            String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (int i = 0; i < 8; i++) {
                if (new File(strArr[i] + str).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    public static boolean e(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = -1;
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("status", -1);
        }
        return i == 2 || i == 5;
    }

    public static int f() {
        return Build.VERSION.SDK_INT;
    }

    public static int f(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra("plugged", -1);
        }
        return -1;
    }

    public static String g() {
        return Build.MODEL;
    }

    public static boolean g(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 17 && Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String h() {
        return Build.MANUFACTURER;
    }

    public static boolean h(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 17 && Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String i() {
        return "android";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = (android.telephony.TelephonyManager) r2.getSystemService("phone");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x0013
            java.lang.String r1 = "phone"
            java.lang.Object r2 = r2.getSystemService(r1)
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2
            if (r2 == 0) goto L_0x0013
            java.lang.String r2 = r2.getNetworkOperatorName()
            return r2
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.h.i(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = (android.telephony.TelephonyManager) r2.getSystemService("phone");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String j(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x0013
            java.lang.String r1 = "phone"
            java.lang.Object r2 = r2.getSystemService(r1)
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2
            if (r2 == 0) goto L_0x0013
            java.lang.String r2 = r2.getNetworkCountryIso()
            return r2
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.h.j(android.content.Context):java.lang.String");
    }

    public static boolean j() {
        return d("su");
    }

    public static int k() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int k(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static float l(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        try {
            return ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
        } catch (Exception e) {
            e.printStackTrace();
            return -1.0f;
        }
    }

    public static int l() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int m() {
        return k();
    }

    public static int m(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getRequestedOrientation();
        }
        return -1;
    }

    public static int n() {
        return l();
    }

    public static String n(Context context) {
        if (context == null) {
            return "";
        }
        int m = m(context);
        if (m != 0) {
            if (m != 1) {
                if (m != 11) {
                    if (m != 12) {
                        switch (m) {
                            case 6:
                            case 8:
                                break;
                            case 7:
                            case 9:
                                break;
                            default:
                                return "none";
                        }
                    }
                }
            }
            return "portrait";
        }
        return "landscape";
    }

    public static float o() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int o(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static long p() {
        return a(Environment.getDataDirectory());
    }

    public static List<ApplicationInfo> p(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    public static void q() {
        final Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                c = WebSettings.getDefaultUserAgent(applicationContext);
                a(applicationContext, c);
            } catch (Exception unused) {
            }
        } else {
            c.a(new Runnable() {
                public final void run() {
                    try {
                        WebView webView = new WebView(applicationContext);
                        webView.setLayerType(1, (Paint) null);
                        String unused = h.c = webView.getSettings().getUserAgentString();
                        webView.destroy();
                        h.a(applicationContext, h.c);
                    } catch (Exception unused2) {
                    }
                }
            }, 0);
        }
    }

    public static boolean q(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    public static File r(Context context) {
        return context.getExternalCacheDir();
    }

    public static String r() {
        Context applicationContext;
        if (!c.isEmpty() || (applicationContext = ContextProvider.getInstance().getApplicationContext()) == null) {
            return c;
        }
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(applicationContext, "Mediation_Shared_Preferences", "browser_user_agent", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static File s(Context context) {
        return context.getExternalFilesDir((String) null);
    }

    public static File t(Context context) {
        return context.getCacheDir();
    }

    public static File u(Context context) {
        return context.getFilesDir();
    }

    public static int v(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i = 0;
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : 0;
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra("scale", -1);
            }
            if (intExtra == -1 || i == -1) {
                return -1;
            }
            return (int) ((((float) intExtra) / ((float) i)) * 100.0f);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean w(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((PowerManager) context.getSystemService("power")).isPowerSaveMode();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static synchronized String x(Context context) {
        synchronized (h.class) {
            if (!TextUtils.isEmpty(a)) {
                String str = a;
                return str;
            }
            if (IronSourceSharedPreferencesUtilities.a(context, "Mediation_Shared_Preferences", "uuidEnabled", true)) {
                String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "Mediation_Shared_Preferences", "cachedUUID", "");
                if (TextUtils.isEmpty(stringFromSharedPrefs)) {
                    a = UUID.randomUUID().toString();
                    IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, "Mediation_Shared_Preferences", "cachedUUID", a);
                } else {
                    a = stringFromSharedPrefs;
                }
            }
            String str2 = a;
            return str2;
        }
    }

    public static synchronized String y(Context context) {
        synchronized (h.class) {
            if (!TextUtils.isEmpty(b)) {
                String str = b;
                return str;
            } else if (context == null) {
                return "";
            } else {
                String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "supersonic_shared_preferen", "auid", "");
                b = stringFromSharedPrefs;
                if (TextUtils.isEmpty(stringFromSharedPrefs)) {
                    b = UUID.randomUUID().toString();
                    IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, "supersonic_shared_preferen", "auid", b);
                }
                String str2 = b;
                return str2;
            }
        }
    }

    public static int z(Context context) {
        if (context != null) {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }
}
