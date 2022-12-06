package com.bytedance.sdk.component.f.d;

import android.content.Context;
import com.bytedance.sdk.component.utils.r;

/* compiled from: ProcessUtils */
public class f {
    public static boolean a(Context context) {
        String c = c(context);
        return c != null && (c.endsWith(":push") || c.endsWith(":pushservice"));
    }

    @Deprecated
    public static boolean b(Context context) {
        String c = c(context);
        if ((c == null || !c.contains(":")) && c != null && c.equals(context.getPackageName())) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static String c(Context context) {
        return r.b(context);
    }
}
