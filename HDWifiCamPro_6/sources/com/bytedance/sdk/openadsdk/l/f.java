package com.bytedance.sdk.openadsdk.l;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;

/* compiled from: ExternalSpUtils */
public class f {
    public static void a(String str) {
        a("any_door_id", str);
    }

    public static String a() {
        return b("any_door_id", (String) null);
    }

    private static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (b.c()) {
                    a.a(str, str2);
                } else {
                    u.a("", m.a()).a(str, str2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            if (b.c()) {
                return a.b((String) null, str, str2);
            }
            return u.a("", m.a()).b(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
