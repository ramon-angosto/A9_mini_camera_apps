package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.push.aw */
class C1637aw {

    /* renamed from: a */
    private static volatile boolean f1818a = false;

    /* renamed from: a */
    private static void m2588a(Class<?> cls, Context context) {
        if (!f1818a) {
            try {
                f1818a = true;
                cls.getDeclaredMethod("InitEntry", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            } catch (Throwable th) {
                C1524b.m2141a("mdid:load lib error " + th);
            }
        }
    }

    /* renamed from: a */
    public static boolean m2589a(Context context) {
        try {
            Class<?> a = C2087u.m5373a(context, "com.bun.miitmdid.core.JLibrary");
            if (a == null) {
                return false;
            }
            m2588a(a, context);
            return true;
        } catch (Throwable th) {
            C1524b.m2141a("mdid:check error " + th);
            return false;
        }
    }
}
