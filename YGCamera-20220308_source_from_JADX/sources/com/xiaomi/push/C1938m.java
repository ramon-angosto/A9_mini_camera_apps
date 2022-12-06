package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.xiaomi.push.m */
public class C1938m {

    /* renamed from: a */
    private static volatile int f3558a = 0;

    /* renamed from: a */
    private static Map<String, C1941p> f3559a = null;

    /* renamed from: b */
    private static int f3560b = -1;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0024 A[Catch:{ all -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[Catch:{ all -> 0x0029 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m4713a() {
        /*
            int r0 = f3558a
            if (r0 != 0) goto L_0x0047
            r0 = 0
            java.lang.String r1 = "ro.miui.ui.version.code"
            java.lang.String r1 = m4715a((java.lang.String) r1)     // Catch:{ all -> 0x0029 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0029 }
            r2 = 1
            if (r1 == 0) goto L_0x0021
            java.lang.String r1 = "ro.miui.ui.version.name"
            java.lang.String r1 = m4715a((java.lang.String) r1)     // Catch:{ all -> 0x0029 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r1 = 0
            goto L_0x0022
        L_0x0021:
            r1 = 1
        L_0x0022:
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            f3558a = r2     // Catch:{ all -> 0x0029 }
            goto L_0x0031
        L_0x0029:
            r1 = move-exception
            java.lang.String r2 = "get isMIUI failed"
            com.xiaomi.channel.commonutils.logger.C1524b.m2154a((java.lang.String) r2, (java.lang.Throwable) r1)
            f3558a = r0
        L_0x0031:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isMIUI's value is: "
            r0.append(r1)
            int r1 = f3558a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2158b(r0)
        L_0x0047:
            int r0 = f3558a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1938m.m4713a():int");
    }

    /* renamed from: a */
    public static int m4714a(Context context) {
        String a = m4715a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(a) || !TextUtils.isDigitsOnly(a)) {
            return 0;
        }
        return Integer.parseInt(a);
    }

    /* renamed from: a */
    public static C1941p m4715a(String str) {
        C1941p b = m4724b(str);
        return b == null ? C1941p.Global : b;
    }

    /* renamed from: a */
    public static String m4716a() {
        int a = C2087u.m5371a();
        return (!m4713a() || a <= 0) ? "" : a < 2 ? "alpha" : a < 3 ? "development" : "stable";
    }

    /* renamed from: a */
    public static String m4717a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + m4718a(intent.getExtras());
    }

    /* renamed from: a */
    public static String m4718a(Bundle bundle) {
        String a;
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append("null");
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    a = Arrays.toString((int[]) obj);
                } else if (obj instanceof byte[]) {
                    a = Arrays.toString((byte[]) obj);
                } else if (obj instanceof boolean[]) {
                    a = Arrays.toString((boolean[]) obj);
                } else if (obj instanceof short[]) {
                    a = Arrays.toString((short[]) obj);
                } else if (obj instanceof long[]) {
                    a = Arrays.toString((long[]) obj);
                } else if (obj instanceof float[]) {
                    a = Arrays.toString((float[]) obj);
                } else if (obj instanceof double[]) {
                    a = Arrays.toString((double[]) obj);
                } else if (obj instanceof String[]) {
                    a = Arrays.toString((String[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    a = Arrays.toString((CharSequence[]) obj);
                } else if (obj instanceof Parcelable[]) {
                    a = Arrays.toString((Parcelable[]) obj);
                } else if (obj instanceof Bundle) {
                    a = m4718a((Bundle) obj);
                } else {
                    sb.append(obj);
                    z = false;
                }
                sb.append(a);
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    public static String m4719a(String str) {
        try {
            return (String) C1656bj.m2699a("android.os.SystemProperties", "get", str, "");
        } catch (Exception e) {
            C1524b.m2160d("fail to get property. " + e);
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a */
    private static void m4720a() {
        if (f3559a == null) {
            f3559a = new HashMap();
            f3559a.put("CN", C1941p.China);
            f3559a.put("FI", C1941p.Europe);
            f3559a.put("SE", C1941p.Europe);
            f3559a.put("NO", C1941p.Europe);
            f3559a.put("FO", C1941p.Europe);
            f3559a.put("EE", C1941p.Europe);
            f3559a.put("LV", C1941p.Europe);
            f3559a.put("LT", C1941p.Europe);
            f3559a.put("BY", C1941p.Europe);
            f3559a.put("MD", C1941p.Europe);
            f3559a.put("UA", C1941p.Europe);
            f3559a.put("PL", C1941p.Europe);
            f3559a.put("CZ", C1941p.Europe);
            f3559a.put("SK", C1941p.Europe);
            f3559a.put("HU", C1941p.Europe);
            f3559a.put("DE", C1941p.Europe);
            f3559a.put("AT", C1941p.Europe);
            f3559a.put("CH", C1941p.Europe);
            f3559a.put("LI", C1941p.Europe);
            f3559a.put("GB", C1941p.Europe);
            f3559a.put("IE", C1941p.Europe);
            f3559a.put("NL", C1941p.Europe);
            f3559a.put("BE", C1941p.Europe);
            f3559a.put("LU", C1941p.Europe);
            f3559a.put("FR", C1941p.Europe);
            f3559a.put("RO", C1941p.Europe);
            f3559a.put("BG", C1941p.Europe);
            f3559a.put("RS", C1941p.Europe);
            f3559a.put("MK", C1941p.Europe);
            f3559a.put("AL", C1941p.Europe);
            f3559a.put("GR", C1941p.Europe);
            f3559a.put("SI", C1941p.Europe);
            f3559a.put("HR", C1941p.Europe);
            f3559a.put("IT", C1941p.Europe);
            f3559a.put("SM", C1941p.Europe);
            f3559a.put("MT", C1941p.Europe);
            f3559a.put("ES", C1941p.Europe);
            f3559a.put("PT", C1941p.Europe);
            f3559a.put("AD", C1941p.Europe);
            f3559a.put("CY", C1941p.Europe);
            f3559a.put("DK", C1941p.Europe);
            f3559a.put("RU", C1941p.Russia);
            f3559a.put("IN", C1941p.India);
        }
    }

    /* renamed from: a */
    public static boolean m4721a() {
        return m4713a() == 1;
    }

    /* renamed from: a */
    public static boolean m4722a(Context context) {
        return context != null && m4715a(context.getPackageName());
    }

    /* renamed from: a */
    public static boolean m4723a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    /* renamed from: b */
    private static C1941p m4724b(String str) {
        m4713a();
        return f3559a.get(str.toUpperCase());
    }

    /* renamed from: b */
    public static String m4725b() {
        String a = C2086t.m5370a("ro.miui.region", "");
        if (TextUtils.isEmpty(a)) {
            a = C2086t.m5370a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a)) {
            a = C2086t.m5370a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a)) {
            a = C2086t.m5370a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a)) {
            a = C2086t.m5370a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a)) {
            a = m4724b(C2086t.m5370a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(a)) {
            a = C2086t.m5370a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a)) {
            a = C2086t.m5370a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a)) {
            a = C2086t.m5370a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a)) {
            a = C2086t.m5370a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a)) {
            C1524b.m2141a("get region from system, region = " + a);
        }
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String country = Locale.getDefault().getCountry();
        C1524b.m2141a("locale.default.country = " + country);
        return country;
    }

    /* renamed from: b */
    private static String m4726b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return split.length > 0 ? split[0] : str;
    }

    /* renamed from: b */
    public static boolean m4727b() {
        return m4713a() == 2;
    }

    /* renamed from: b */
    public static boolean m4728b(Context context) {
        if (context == null || !m4714a(context)) {
            return false;
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            File file = new File(absolutePath + "/debug_for_xmsf");
            return file.exists() && !file.isDirectory();
        }
    }

    /* renamed from: c */
    public static String m4729c() {
        return m4715a("ro.miui.ui.version.name");
    }

    /* renamed from: c */
    public static boolean m4730c() {
        if (f3560b < 0) {
            Object a = C1656bj.m2699a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
            f3560b = 0;
            if (a != null && (a instanceof Boolean) && !Boolean.class.cast(a).booleanValue()) {
                f3560b = 1;
            }
        }
        return f3560b > 0;
    }

    /* renamed from: d */
    public static boolean m4731d() {
        return !C1941p.China.name().equalsIgnoreCase(m4715a(m4725b()).name());
    }
}
