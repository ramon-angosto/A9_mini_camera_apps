package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;

/* compiled from: AdPreference */
public class c {
    private static volatile c a;
    private final SharedPreferences b;

    private c(Context context) {
        this.b = context.getSharedPreferences("ttopenadsdk", 0);
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(context);
                }
            }
        }
        return a;
    }

    public void a(String str, String str2) {
        if (b.c()) {
            a.a("ttopenadsdk", str, str2);
        } else {
            this.b.edit().putString(str, str2).apply();
        }
    }

    public String b(String str, String str2) {
        if (b.c()) {
            return a.b("ttopenadsdk", str, str2);
        }
        return this.b.getString(str, str2);
    }

    public void a(String str, int i) {
        if (b.c()) {
            a.a("ttopenadsdk", str, Integer.valueOf(i));
        } else {
            this.b.edit().putInt(str, i).apply();
        }
    }

    public int b(String str, int i) {
        if (b.c()) {
            return a.a("ttopenadsdk", str, i);
        }
        return this.b.getInt(str, i);
    }

    public void a(String str, long j) {
        if (b.c()) {
            a.a("ttopenadsdk", str, Long.valueOf(j));
        } else {
            this.b.edit().putLong(str, j).apply();
        }
    }

    public Long b(String str, long j) {
        long j2;
        if (b.c()) {
            j2 = a.a("ttopenadsdk", str, j);
        } else {
            j2 = this.b.getLong(str, j);
        }
        return Long.valueOf(j2);
    }
}
