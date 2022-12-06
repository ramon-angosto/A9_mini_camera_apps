package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: ResourceHelp */
public final class t {
    private static String a;
    private static Resources b;
    private static Context c;

    public static void a(String str) {
        a = str;
    }

    private static String b(Context context) {
        if (a == null) {
            a = context.getPackageName();
        }
        return a;
    }

    private static int a(Context context, String str, String str2) {
        if (b == null) {
            b = context.getResources();
        }
        return b.getIdentifier(str, str2, b(context));
    }

    public static String a(Context context, String str) {
        Context context2 = c;
        if (context2 == null) {
            return context.getResources().getString(b(context, str));
        }
        return context2.getResources().getString(b(c, str));
    }

    public static void a(Context context) {
        c = context;
    }

    public static int b(Context context, String str) {
        return a(context, str, "string");
    }

    public static Drawable c(Context context, String str) {
        return context.getResources().getDrawable(d(context, str));
    }

    public static int d(Context context, String str) {
        return a(context, str, "drawable");
    }

    public static int e(Context context, String str) {
        return a(context, str, "id");
    }

    public static int f(Context context, String str) {
        return a(context, str, TtmlNode.TAG_LAYOUT);
    }

    public static int g(Context context, String str) {
        return a(context, str, TtmlNode.TAG_STYLE);
    }

    public static int h(Context context, String str) {
        return a(context, str, "attr");
    }

    public static int i(Context context, String str) {
        return a(context, str, "dimen");
    }

    public static int j(Context context, String str) {
        return context.getResources().getColor(k(context, str));
    }

    public static int k(Context context, String str) {
        return a(context, str, TtmlNode.ATTR_TTS_COLOR);
    }

    public static int l(Context context, String str) {
        return a(context, str, "anim");
    }

    public static int m(Context context, String str) {
        return a(context, str, "integer");
    }

    public static int n(Context context, String str) {
        return context.getResources().getInteger(m(context, str));
    }
}
