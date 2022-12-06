package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1656bj;

/* renamed from: com.xiaomi.mipush.sdk.n */
public class C1592n {

    /* renamed from: a */
    private static int f1733a = -1;

    /* renamed from: a */
    public static C1560ag m2452a(Context context) {
        try {
            return (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) == null || !m2453a()) ? C1560ag.OTHER : C1560ag.HUAWEI;
        } catch (Exception unused) {
            return C1560ag.OTHER;
        }
    }

    /* renamed from: a */
    private static boolean m2453a() {
        try {
            String str = (String) C1656bj.m2699a("android.os.SystemProperties", "get", "ro.build.hw_emui_api_level", "");
            return !TextUtils.isEmpty(str) && Integer.parseInt(str) >= 9;
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
        }
    }

    /* renamed from: a */
    public static boolean m2454a(Context context) {
        Object a = C1656bj.m2697a(C1656bj.m2699a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object a2 = C1656bj.m2698a("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        if (a2 == null || !(a2 instanceof Integer)) {
            C1524b.m2159c("google service is not avaliable");
            f1733a = 0;
            return false;
        }
        int intValue = Integer.class.cast(a2).intValue();
        if (a != null) {
            if (a instanceof Integer) {
                f1733a = Integer.class.cast(a).intValue() == intValue ? 1 : 0;
            } else {
                f1733a = 0;
                C1524b.m2159c("google service is not avaliable");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("is google service can be used");
        sb.append(f1733a > 0);
        C1524b.m2159c(sb.toString());
        return f1733a > 0;
    }

    /* renamed from: b */
    public static boolean m2455b(Context context) {
        boolean z = false;
        Object a = C1656bj.m2699a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (a != null && (a instanceof Boolean)) {
            z = Boolean.class.cast(a).booleanValue();
        }
        C1524b.m2159c("color os push  is avaliable ? :" + z);
        return z;
    }

    /* renamed from: c */
    public static boolean m2456c(Context context) {
        boolean z = false;
        Object a = C1656bj.m2699a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (a != null && (a instanceof Boolean)) {
            z = Boolean.class.cast(a).booleanValue();
        }
        C1524b.m2159c("fun touch os push  is avaliable ? :" + z);
        return z;
    }
}
