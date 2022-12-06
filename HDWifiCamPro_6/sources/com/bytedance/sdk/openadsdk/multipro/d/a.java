package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: SPMultiHelper */
public class a {
    private static Context a;

    public static boolean a() {
        if (a != null && m.a() != null) {
            return true;
        }
        l.d("The context of SPHelper is null, please initialize sdk in main process");
        return false;
    }

    private static g b() {
        try {
            if (a()) {
                return com.bytedance.sdk.openadsdk.multipro.a.a.a(m.a());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context) {
        a = context == null ? m.a() : context.getApplicationContext();
    }

    private static Context c() {
        Context context = a;
        return context == null ? m.a() : context;
    }

    private static String d() {
        return d.b + "/" + "t_sp" + "/";
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=" + str;
    }

    public static synchronized void a(String str, String str2, Boolean bool) {
        synchronized (a.class) {
            if (a()) {
                try {
                    if (!b.c()) {
                        b.a(c(), str, str2, bool);
                        return;
                    }
                    g b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "boolean" + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, bool);
                        b.a(parse, contentValues, (String) null, (String[]) null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (a.class) {
            a((String) null, str, str2);
        }
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (a()) {
                try {
                    if (!b.c()) {
                        b.a(c(), str, str2, str3);
                        return;
                    }
                    g b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "string" + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, str3);
                        b.a(parse, contentValues, (String) null, (String[]) null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Integer num) {
        synchronized (a.class) {
            if (a()) {
                try {
                    if (!b.c()) {
                        b.a(c(), str, str2, num);
                        return;
                    }
                    g b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "int" + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, num);
                        b.a(parse, contentValues, (String) null, (String[]) null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Long l) {
        synchronized (a.class) {
            if (a()) {
                try {
                    if (!b.c()) {
                        b.a(c(), str, str2, l);
                        return;
                    }
                    g b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "long" + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, l);
                        b.a(parse, contentValues, (String) null, (String[]) null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Float f) {
        synchronized (a.class) {
            if (a()) {
                try {
                    if (!b.c()) {
                        b.a(c(), str, str2, f);
                        return;
                    }
                    g b = b();
                    if (b != null) {
                        Uri parse = Uri.parse(d() + "float" + "/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, f);
                        b.a(parse, contentValues, (String) null, (String[]) null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static String b(String str, String str2, String str3) {
        if (!a()) {
            return str3;
        }
        try {
            if (!b.c()) {
                return a(c(), str, str2, str3);
            }
            g b = b();
            if (b != null) {
                String a2 = b.a(Uri.parse(d() + "string" + "/" + str2 + b(str)));
                return (a2 == null || a2.equals("null")) ? str3 : a2;
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(Context context, String str, String str2, String str3) {
        SharedPreferences a2 = b.a(context, str);
        if (a2 == null) {
            return str3;
        }
        return a2.getString(str2, str3);
    }

    public static int a(String str, String str2, int i) {
        if (!a()) {
            return i;
        }
        try {
            if (!b.c()) {
                return a(c(), str, str2, i);
            }
            g b = b();
            if (b != null) {
                String a2 = b.a(Uri.parse(d() + "int" + "/" + str2 + b(str)));
                if (a2 != null) {
                    if (!a2.equals("null")) {
                        return Integer.parseInt(a2);
                    }
                }
            }
            return i;
        } catch (Throwable unused) {
        }
    }

    public static int a(Context context, String str, String str2, int i) {
        SharedPreferences a2 = b.a(context, str);
        if (a2 == null) {
            return i;
        }
        return a2.getInt(str2, i);
    }

    public static float a(Context context, String str, String str2, float f) {
        SharedPreferences a2 = b.a(context, str);
        if (a2 == null) {
            return f;
        }
        return a2.getFloat(str2, f);
    }

    public static boolean a(String str, String str2, boolean z) {
        if (!a()) {
            return z;
        }
        try {
            if (!b.c()) {
                return a(c(), str, str2, z);
            }
            g b = b();
            if (b != null) {
                String a2 = b.a(Uri.parse(d() + "boolean" + "/" + str2 + b(str)));
                if (a2 != null) {
                    if (!a2.equals("null")) {
                        return Boolean.parseBoolean(a2);
                    }
                }
            }
            return z;
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        SharedPreferences a2 = b.a(context, str);
        if (a2 == null) {
            return z;
        }
        return a2.getBoolean(str2, z);
    }

    public static long a(String str, String str2, long j) {
        if (!a()) {
            return j;
        }
        try {
            if (!b.c()) {
                return a(c(), str, str2, j);
            }
            g b = b();
            if (b != null) {
                String a2 = b.a(Uri.parse(d() + "long" + "/" + str2 + b(str)));
                if (a2 != null) {
                    if (!a2.equals("null")) {
                        return Long.parseLong(a2);
                    }
                }
            }
            return j;
        } catch (Throwable unused) {
        }
    }

    public static long a(Context context, String str, String str2, long j) {
        SharedPreferences a2 = b.a(context, str);
        if (a2 == null) {
            return j;
        }
        return a2.getLong(str2, j);
    }

    public static void b(String str, String str2) {
        if (a()) {
            try {
                if (!b.c()) {
                    b.b(c(), str, str2);
                    return;
                }
                g b = b();
                if (b != null) {
                    b.a(Uri.parse(d() + "long" + "/" + str2 + b(str)), (String) null, (String[]) null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (a()) {
            try {
                if (!b.c()) {
                    b.b(c(), str);
                    return;
                }
                g b = b();
                if (b != null) {
                    b.a(Uri.parse(d() + "clean" + b(str)), (String) null, (String[]) null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
