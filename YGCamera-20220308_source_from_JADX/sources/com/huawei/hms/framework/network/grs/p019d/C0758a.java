package com.huawei.hms.framework.network.grs.p019d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

/* renamed from: com.huawei.hms.framework.network.grs.d.a */
public class C0758a {
    /* renamed from: a */
    public static String m662a() {
        return "4.0.20.301";
    }

    /* renamed from: a */
    public static String m663a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m479w("AgentUtil", "", (Throwable) e);
            return "";
        }
    }

    /* renamed from: a */
    public static String m664a(Context context, String str, String str2) {
        if (context == null) {
            return String.format(Locale.ROOT, str + "/%s", new Object[]{m662a()});
        }
        String packageName = context.getPackageName();
        String a = m663a(context);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.MODEL;
        Locale locale = Locale.ROOT;
        String str5 = "%s/%s (Linux; Android %s; %s) " + str + "/%s %s";
        Object[] objArr = new Object[6];
        objArr[0] = packageName;
        objArr[1] = a;
        objArr[2] = str3;
        objArr[3] = str4;
        objArr[4] = m662a();
        if (TextUtils.isEmpty(str2)) {
            str2 = "no_service_name";
        }
        objArr[5] = str2;
        return String.format(locale, str5, objArr);
    }

    /* renamed from: b */
    public static String m665b(Context context, String str, String str2) {
        return m664a(context, str, str2);
    }
}
