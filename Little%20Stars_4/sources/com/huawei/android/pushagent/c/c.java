package com.huawei.android.pushagent.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import com.huawei.android.pushagent.c.a.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class c {
    public static void a(Context context) {
        a(context, "push_plugin", c(context));
    }

    private static void a(Context context, String str, String str2) {
        new Thread(new d(context, str, str2)).start();
    }

    private static String c(Context context) {
        String a = a.a(context);
        String str = Build.MODEL;
        String str2 = Build.DISPLAY;
        String format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINESE).format(new Date());
        String d = d(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(context.getPackageName());
        stringBuffer.append("|");
        stringBuffer.append(d);
        stringBuffer.append("|");
        stringBuffer.append(a);
        stringBuffer.append("|");
        stringBuffer.append(str);
        stringBuffer.append("|");
        stringBuffer.append(str2);
        stringBuffer.append("|");
        stringBuffer.append("PushPlugin");
        stringBuffer.append("|");
        stringBuffer.append(2705);
        stringBuffer.append("|");
        stringBuffer.append(format);
        return stringBuffer.toString();
    }

    private static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.a("PushLogAC2705", "package not exist", (Throwable) e);
        } catch (Exception e2) {
            e.c("PushLogAC2705", "getApkVersionName error", e2);
        }
        return "0.0";
    }

    /* access modifiers changed from: private */
    public static boolean e(Context context) {
        if (context == null) {
            return false;
        }
        int i = -1;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "user_experience_involved", -1);
            e.a("PushLogAC2705", "settingMainSwitch:" + i);
        } catch (Exception e) {
            e.c("PushLogAC2705", e.toString(), e);
        }
        return i == 1;
    }
}
