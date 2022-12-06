package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* renamed from: com.huawei.hms.hatool.p0 */
public class C0822p0 {
    /* renamed from: a */
    public static boolean m987a(Context context) {
        return System.currentTimeMillis() - C0796g0.m828a(context, "Privacy_MY", "flashKeyTime", -1) > 43200000;
    }

    /* renamed from: a */
    public static boolean m988a(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return false;
            }
            C0841y.m1092f("hmsSdk", "not have read phone permission!");
            return true;
        } else if (context.checkSelfPermission(str) == 0) {
            return false;
        } else {
            C0841y.m1092f("hmsSdk", "not have read phone permission!");
            return true;
        }
    }

    /* renamed from: a */
    public static boolean m989a(Context context, String str, int i) {
        String str2 = C0796g0.m835c(context, str) + ".xml";
        long length = new File(context.getFilesDir(), "../shared_prefs/" + str2).length();
        if (length <= ((long) i)) {
            return false;
        }
        C0841y.m1087c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", new Object[]{Long.valueOf(length), Integer.valueOf(i)}));
        return true;
    }

    /* renamed from: a */
    public static boolean m990a(String str, long j, long j2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j - Long.parseLong(str) > j2;
        } catch (NumberFormatException unused) {
            C0841y.m1092f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
