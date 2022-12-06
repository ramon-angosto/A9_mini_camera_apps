package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C1995at;

/* renamed from: com.xiaomi.push.di */
class C1720di {

    /* renamed from: a */
    private static Boolean f2024a;

    /* renamed from: a */
    private static String f2025a;

    /* renamed from: a */
    public static int m2993a() {
        return Build.VERSION.SDK_INT;
    }

    /* renamed from: a */
    public static String m2994a() {
        return Build.MANUFACTURER + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Build.VERSION.INCREMENTAL;
    }

    /* renamed from: a */
    public static String m2995a(Context context) {
        if (f2025a == null) {
            String packageName = context.getPackageName();
            String a = C1816g.m3659a(context, packageName);
            f2025a = packageName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + a;
        }
        return f2025a;
    }

    /* renamed from: a */
    public static String m2996a(String str) {
        try {
            String str2 = str.split("#n")[0];
            return str2.contains("android.os.DeadSystemException") ? "android.os.DeadSystemException" : str2.contains(Constants.COLON_SEPARATOR) ? str2.substring(0, str2.indexOf(Constants.COLON_SEPARATOR)) : str2;
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static boolean m2997a() {
        if (f2024a == null) {
            f2024a = Boolean.valueOf(!C1938m.m4731d());
        }
        return f2024a.booleanValue();
    }

    /* renamed from: a */
    public static boolean m2998a(Context context) {
        return C1995at.m5047a(context).mo18472a(C1873ht.SdkExceptionMonitorSwitch.mo17806a(), true);
    }

    /* renamed from: a */
    public static boolean m2999a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String contains : C1714dc.f1998a) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056 A[RETURN] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3000b(android.content.Context r4) {
        /*
            com.xiaomi.push.service.n r0 = com.xiaomi.push.service.C2072o.m5301a((android.content.Context) r4)
            r1 = 0
            if (r0 == 0) goto L_0x002f
            java.lang.String r2 = r0.f3926a
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x002f
            java.lang.String r0 = r0.f3926a
            java.lang.String r2 = "@"
            java.lang.String[] r0 = r0.split(r2)
            int r2 = r0.length
            if (r2 <= 0) goto L_0x002f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "@-"
            r2.append(r3)
            r3 = 0
            r0 = r0[r3]
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            goto L_0x0030
        L_0x002f:
            r0 = r1
        L_0x0030:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x003b
            r0 = 1
            java.lang.String r0 = com.xiaomi.push.C1907j.m4554a((android.content.Context) r4, (boolean) r0)
        L_0x003b:
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r2 = "uniqueId"
            r4.put(r2, r0)     // Catch:{ Exception -> 0x0046 }
            goto L_0x0047
        L_0x0046:
        L_0x0047:
            int r0 = r4.length()
            if (r0 <= 0) goto L_0x0056
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = com.xiaomi.push.service.C2024bl.m5142a(r4)
            return r4
        L_0x0056:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1720di.m3000b(android.content.Context):java.lang.String");
    }

    /* renamed from: b */
    public static String m3001b(String str) {
        try {
            String[] split = str.replaceAll("\\t", "").split("\\n");
            StringBuilder sb = new StringBuilder();
            int length = split.length;
            for (int i = 0; i < length; i++) {
                split[i] = split[i].replaceAll("((java:)|(length=)|(index=)|(Index:)|(Size:))\\d+", "$1XX").replaceAll("\\$[0-9a-fA-F]{1,10}@[0-9a-fA-F]{1,10}|@[0-9a-fA-F]{1,10}|0x[0-9a-fA-F]{1,10}", "XX");
                sb.append(split[i]);
                sb.append("#n");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
