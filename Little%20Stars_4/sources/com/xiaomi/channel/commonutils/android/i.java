package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.reflect.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class i {
    private static Context a;

    public static Context a() {
        return a;
    }

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    public static String b() {
        String c = e.c(a);
        if (c == null) {
            c = e.e(a);
        }
        if (c == null) {
            return null;
        }
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(c.getBytes()), 8).substring(0, 16);
        } catch (NoSuchAlgorithmException e) {
            b.a((Throwable) e);
            return null;
        }
    }

    public static boolean b(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            b.a((Throwable) e);
            return false;
        }
    }

    public static int c() {
        try {
            Class<?> cls = Class.forName("miui.os.Build");
            if (cls.getField("IS_STABLE_VERSION").getBoolean((Object) null)) {
                return 3;
            }
            return cls.getField("IS_DEVELOPMENT_VERSION").getBoolean((Object) null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean d() {
        return TextUtils.equals((String) a.a(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES, "get", "sys.boot_completed"), "1");
    }
}
