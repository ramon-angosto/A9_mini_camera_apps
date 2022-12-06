package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.push.u */
public class C2087u {

    /* renamed from: a */
    private static Context f3973a;

    /* renamed from: a */
    private static String f3974a;

    /* renamed from: a */
    public static int m5371a() {
        try {
            Class<?> a = m5373a((Context) null, "miui.os.Build");
            if (a.getField("IS_STABLE_VERSION").getBoolean((Object) null)) {
                return 3;
            }
            return a.getField("IS_DEVELOPMENT_VERSION").getBoolean((Object) null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public static Context m5372a() {
        return f3973a;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[SYNTHETIC, Splitter:B:13:0x0024] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?> m5373a(android.content.Context r5, java.lang.String r6) {
        /*
            if (r6 == 0) goto L_0x004a
            java.lang.String r0 = r6.trim()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x004a
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            if (r2 == 0) goto L_0x0024
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r3 < r4) goto L_0x0024
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ all -> 0x0024 }
            java.lang.Class r5 = r5.loadClass(r6)     // Catch:{ all -> 0x0024 }
            return r5
        L_0x0024:
            java.lang.Class r5 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x0029 }
            return r5
        L_0x0029:
            r5 = move-exception
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6[r1] = r2
            java.lang.String r1 = r5.getLocalizedMessage()
            r6[r0] = r1
            java.lang.String r0 = "loadClass fail hasContext= %s, errMsg = %s"
            java.lang.String r6 = java.lang.String.format(r0, r6)
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r6)
            java.lang.ClassNotFoundException r6 = new java.lang.ClassNotFoundException
            java.lang.String r0 = "loadClass fail "
            r6.<init>(r0, r5)
            throw r6
        L_0x004a:
            java.lang.ClassNotFoundException r5 = new java.lang.ClassNotFoundException
            java.lang.String r6 = "class is empty"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C2087u.m5373a(android.content.Context, java.lang.String):java.lang.Class");
    }

    /* renamed from: a */
    public static synchronized String m5374a() {
        String str;
        synchronized (C2087u.class) {
            if (f3974a != null) {
                String str2 = f3974a;
                return str2;
            }
            String str3 = Build.VERSION.INCREMENTAL;
            if (m5371a() <= 0) {
                str = m5379b();
                if (TextUtils.isEmpty(str)) {
                    str = m5381c();
                    if (TextUtils.isEmpty(str)) {
                        str = m5382d();
                        if (TextUtils.isEmpty(str)) {
                            str3 = String.valueOf(C2086t.m5370a("ro.product.brand", "Android") + "_" + str3);
                        }
                    }
                }
                f3974a = str;
                return str;
            }
            str = str3;
            f3974a = str;
            return str;
        }
    }

    /* renamed from: a */
    public static String m5375a(Context context) {
        if (C1938m.m4725b()) {
            return "";
        }
        String str = (String) C1656bj.m2699a("com.xiaomi.xmsf.helper.MIIDAccountHelper", "getMIID", context);
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    /* renamed from: a */
    public static void m5376a(Context context) {
        f3973a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static boolean m5377a() {
        return TextUtils.equals((String) C1656bj.m2699a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: a */
    public static boolean m5378a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            return false;
        }
    }

    /* renamed from: b */
    private static String m5379b() {
        f3974a = C2086t.m5370a("ro.build.version.emui", "");
        return f3974a;
    }

    /* renamed from: b */
    public static boolean m5380b() {
        try {
            return m5373a((Context) null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(false);
        } catch (ClassNotFoundException unused) {
            C1524b.m2160d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            return false;
        }
    }

    /* renamed from: c */
    private static String m5381c() {
        String a = C2086t.m5370a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a) && !a.startsWith("ColorOS_")) {
            f3974a = "ColorOS_" + a;
        }
        return f3974a;
    }

    /* renamed from: d */
    private static String m5382d() {
        String a = C2086t.m5370a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a) && !a.startsWith("FuntouchOS_")) {
            f3974a = "FuntouchOS_" + a;
        }
        return f3974a;
    }
}
