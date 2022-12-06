package com.meizu.cloud.pushsdk.common.b;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.common.b.e;

public class h {
    public static boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static String a(Context context) {
        if (d.a().a) {
            return (String) d.a().b;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getDeviceId();
        }
        return null;
    }

    public static boolean a() {
        e.c a = f.a("ro.meizu.product.model");
        return (a.a && !TextUtils.isEmpty((CharSequence) a.b)) || "meizu".equalsIgnoreCase(Build.BRAND) || "22c4185e".equalsIgnoreCase(Build.BRAND);
    }

    public static boolean b() {
        if (a.a().a) {
            return ((Boolean) a.a().b).booleanValue();
        }
        return false;
    }

    public static boolean c() {
        e.c a = f.a("ro.meizu.locale.region");
        if (a.a) {
            return "india".equals(a.b);
        }
        return false;
    }

    public static boolean b(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
