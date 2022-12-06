package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.xiaomi.push.bv */
public class C1670bv {

    /* renamed from: a */
    private static volatile C1670bv f1888a;

    /* renamed from: a */
    private Context f1889a;

    private C1670bv(Context context) {
        this.f1889a = context;
    }

    /* renamed from: a */
    public static C1670bv m2754a(Context context) {
        if (f1888a == null) {
            synchronized (C1670bv.class) {
                if (f1888a == null) {
                    f1888a = new C1670bv(context);
                }
            }
        }
        return f1888a;
    }

    /* renamed from: a */
    public synchronized long mo17268a(String str, String str2, long j) {
        try {
        } catch (Throwable unused) {
            return j;
        }
        return this.f1889a.getSharedPreferences(str, 4).getLong(str2, j);
    }

    /* renamed from: a */
    public synchronized String mo17269a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f1889a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a */
    public synchronized void m2757a(String str, String str2, long j) {
        SharedPreferences.Editor edit = this.f1889a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    /* renamed from: a */
    public synchronized void m2758a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f1889a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }
}
