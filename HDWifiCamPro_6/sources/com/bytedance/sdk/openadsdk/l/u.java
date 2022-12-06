package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TempSPUtils */
public class u {
    private static Map<String, u> a = new HashMap();
    private SharedPreferences b;

    public static u a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        u uVar = a.get(str);
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(str, context);
        a.put(str, uVar2);
        return uVar2;
    }

    private u(String str, Context context) {
        if (context != null) {
            this.b = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public void a(String str, String str2) {
        try {
            this.b.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    public String b(String str, String str2) {
        try {
            return this.b.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void a(String str, int i) {
        try {
            this.b.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    public int b(String str, int i) {
        try {
            return this.b.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void a(String str, boolean z) {
        try {
            this.b.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    public boolean b(String str, boolean z) {
        try {
            return this.b.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public void a(String str) {
        try {
            this.b.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
