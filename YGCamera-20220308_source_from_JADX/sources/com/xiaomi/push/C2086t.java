package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.push.t */
public class C2086t {
    /* renamed from: a */
    public static String m5370a(String str, String str2) {
        try {
            return (String) C2087u.m5373a((Context) null, "android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
        } catch (Exception e) {
            C1524b.m2141a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
