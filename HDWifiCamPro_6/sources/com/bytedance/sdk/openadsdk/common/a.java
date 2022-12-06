package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.y;

/* compiled from: AppInfo */
public class a {
    public static String a() {
        return "open_news";
    }

    public static String b() {
        return "1371";
    }

    public static String c() {
        return BuildConfig.VERSION_NAME;
    }

    public static String d() {
        return y.g();
    }

    public static String e() {
        return h.d().g();
    }

    public static String f() {
        return o.g(m.a());
    }

    public static String a(Context context) {
        return j.a(context);
    }
}
