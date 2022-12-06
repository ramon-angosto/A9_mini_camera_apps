package com.huawei.updatesdk.p039b.p049h;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.updatesdk.p025a.p026a.C0964a;

/* renamed from: com.huawei.updatesdk.b.h.c */
public final class C1041c {

    /* renamed from: a */
    private static String f1409a;

    /* renamed from: b */
    private static Resources f1410b;

    /* renamed from: a */
    public static int m1966a(Context context, String str) {
        return m1967a(context, str, "id");
    }

    /* renamed from: a */
    private static int m1967a(Context context, String str, String str2) {
        if (f1410b == null) {
            f1410b = context.getResources();
        }
        return f1410b.getIdentifier(str, str2, m1968a(context));
    }

    /* renamed from: a */
    private static String m1968a(Context context) {
        if (f1409a == null) {
            f1409a = context.getPackageName();
        }
        return f1409a;
    }

    /* renamed from: b */
    public static int m1969b(Context context, String str) {
        return m1967a(context, str, "layout");
    }

    /* renamed from: c */
    public static int m1970c(Context context, String str) {
        return m1967a(context, str, "string");
    }

    /* renamed from: d */
    public static String m1971d(Context context, String str) {
        try {
            return context.getResources().getString(m1967a(context, str, "string"));
        } catch (Resources.NotFoundException unused) {
            C0964a.m1666a("UpdateSDK", "recource get error name: " + str);
            return "";
        }
    }
}
