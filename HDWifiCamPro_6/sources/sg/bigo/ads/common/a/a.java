package sg.bigo.ads.common.a;

import android.content.Context;
import android.text.TextUtils;

public final class a {
    private static String a = "";
    private static boolean b = true;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a) || !b) {
            return a;
        }
        try {
            Class<?> cls = Class.forName("com.appsflyer.AppsFlyerLib");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            Object invoke2 = cls.getMethod("getAppsFlyerUID", new Class[]{Context.class}).invoke(invoke, new Object[]{context});
            if (invoke2 instanceof String) {
                a = (String) invoke2;
            }
        } catch (Exception unused) {
            b = false;
        }
        return a;
    }
}
