package com.huawei.updatesdk.p025a.p026a.p031d.p032h;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p026a.p031d.C0971c;
import com.huawei.updatesdk.p025a.p026a.p031d.C0973e;
import com.huawei.updatesdk.p039b.p049h.C1036a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.huawei.updatesdk.a.a.d.h.c */
public class C0981c {

    /* renamed from: c */
    private static C0981c f1319c = new C0981c();

    /* renamed from: d */
    private static String f1320d = null;

    /* renamed from: a */
    private int f1321a = 0;

    /* renamed from: b */
    private int f1322b = 0;

    static {
        m1727a("ro.product.brand", "");
    }

    private C0981c() {
        if (m1724a("ro.maple.enable", 0) == 1) {
            this.f1321a = 1;
        }
        this.f1322b = m1724a("ro.build.version.ark", 0);
    }

    /* renamed from: a */
    public static int m1724a(String str, int i) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Integer) cls.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke((Object) null, new Object[]{str, Integer.valueOf(i)})).intValue();
        } catch (Throwable th) {
            C0968a.m1681a("DeviceUtil", "Exception while getting system property: ", th);
            return i;
        }
    }

    /* renamed from: a */
    static String m1725a(Context context) {
        if (f1320d == null) {
            f1320d = C0973e.m1695a(m1731b(context), Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        return f1320d;
    }

    /* renamed from: a */
    public static String m1726a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 16).versionName + "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m1727a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
        } catch (Throwable th) {
            C0968a.m1681a("DeviceUtil", "Exception while getting system property: ", th);
            return str2;
        }
    }

    /* renamed from: a */
    public static List<String> m1728a(List<String> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!m1729a(next, strArr)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static boolean m1729a(String str, String[] strArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (String str2 : strArr) {
            if (str2.startsWith("config.")) {
                i = 1;
            } else if (!str2.contains(".config.")) {
                i2++;
            }
            if (str2.endsWith("config." + str)) {
                i3++;
            }
        }
        return i + i2 == i3;
    }

    /* renamed from: b */
    public static String m1730b(Context context, String str) {
        String a = m1726a(context, str);
        int i = 0;
        int i2 = 0;
        while (i < a.length() && i2 < 3) {
            if (a.charAt(i) == '.') {
                i2++;
            }
            i++;
        }
        return 3 == i2 ? a.substring(0, i - 1) : a;
    }

    /* renamed from: b */
    private static List<String> m1731b(Context context) {
        ArrayList arrayList = new ArrayList();
        FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
        if (systemAvailableFeatures != null) {
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                String str = featureInfo.name;
                if (str != null) {
                    arrayList.add(C0971c.m1690a(str));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private static DisplayMetrics m1732c(Context context) {
        Display defaultDisplay;
        Object systemService = context.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: c */
    public static String m1733c() {
        try {
            Object obj = Class.forName("com.huawei.system.BuildEx").getField("DISPLAY").get((Object) null);
            return obj == null ? Build.DISPLAY : obj.toString();
        } catch (IllegalAccessException unused) {
            return Build.DISPLAY;
        } catch (NoSuchFieldException unused2) {
            return Build.DISPLAY;
        } catch (ClassNotFoundException unused3) {
            return Build.DISPLAY;
        } catch (Throwable unused4) {
            return Build.DISPLAY;
        }
    }

    /* renamed from: d */
    public static C0981c m1734d() {
        return f1319c;
    }

    /* renamed from: d */
    public static List<String> m1735d(Context context) {
        ArrayList arrayList = new ArrayList();
        int i = Build.VERSION.SDK_INT;
        Configuration configuration = context.getResources().getConfiguration();
        if (i >= 24) {
            LocaleList locales = configuration.getLocales();
            for (int i2 = 0; i2 < locales.size(); i2++) {
                String language = locales.get(i2).getLanguage();
                if (!TextUtils.isEmpty(language) && !arrayList.contains(language)) {
                    arrayList.add(language);
                }
            }
        } else {
            arrayList.add(configuration.locale.getLanguage());
        }
        return arrayList;
    }

    /* renamed from: e */
    public static String m1736e() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        String script = Build.VERSION.SDK_INT >= 21 ? locale.getScript() : null;
        if (!TextUtils.isEmpty(script) || !TextUtils.isEmpty(variant)) {
            return language + "_" + script + "_" + country + "_" + variant;
        }
        return language + "_" + country;
    }

    /* renamed from: e */
    public static String m1737e(Context context) {
        DisplayMetrics c = m1732c(context);
        if (c == null) {
            return "";
        }
        String valueOf = String.valueOf(c.widthPixels);
        String valueOf2 = String.valueOf(c.heightPixels);
        return valueOf + "_" + valueOf2;
    }

    /* renamed from: f */
    public static String m1738f(Context context) {
        DisplayMetrics c = m1732c(context);
        return c != null ? String.valueOf(c.densityDpi) : "";
    }

    /* renamed from: f */
    public static String[] m1739f() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            return strArr == null ? new String[0] : strArr;
        }
        return new String[]{Build.CPU_ABI};
    }

    /* renamed from: g */
    public static int m1740g() {
        return m1727a("ro.product.cpu.abi", "").contains("arm64") ? 2 : 1;
    }

    /* renamed from: g */
    public static int m1741g(Context context) {
        try {
            return Integer.parseInt(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionCode + "");
        } catch (Exception unused) {
            return 1;
        }
    }

    /* renamed from: h */
    public static String m1742h() {
        String str;
        String str2;
        Locale locale = Locale.getDefault();
        String str3 = "";
        if (locale != null) {
            str = locale.getLanguage();
            if (Build.VERSION.SDK_INT >= 21) {
                str3 = locale.getScript();
            }
            str2 = locale.getCountry();
        } else {
            str = "en";
            str2 = "US";
        }
        if (TextUtils.isEmpty(str3)) {
            return str + "_" + str2;
        }
        return str + "_" + str3 + "_" + str2;
    }

    /* renamed from: h */
    public static String m1743h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName + "";
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: i */
    public static boolean m1744i() {
        return C1036a.m1952d().mo15011a() > 0;
    }

    /* renamed from: i */
    public static boolean m1745i(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo("com.google.android.gsf.login", 16);
            packageManager.getPackageInfo("com.google.android.gsf", 16);
            return (packageManager.getPackageInfo("com.google.android.gms", 16).applicationInfo.flags & 1) != 0;
        } catch (Exception e) {
            C0968a.m1684d("DeviceUtil", e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public int mo14889a() {
        return this.f1321a;
    }

    /* renamed from: a */
    public void mo14890a(Window window) {
        if (C1036a.m1952d().mo15011a() >= 21 && window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");
                Object newInstance = cls.getConstructor(new Class[]{WindowManager.LayoutParams.class}).newInstance(new Object[]{attributes});
                cls.getMethod("setDisplaySideMode", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{1});
            } catch (Throwable unused) {
                C0968a.m1682b("DeviceUtil", "setWindowDisplaySideMode: exception");
            }
        }
    }

    /* renamed from: b */
    public int mo14891b() {
        return this.f1322b;
    }
}
