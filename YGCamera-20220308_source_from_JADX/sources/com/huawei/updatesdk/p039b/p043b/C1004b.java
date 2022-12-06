package com.huawei.updatesdk.p039b.p043b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;

/* renamed from: com.huawei.updatesdk.b.b.b */
public class C1004b {

    /* renamed from: a */
    private SharedPreferences f1365a;

    private C1004b(SharedPreferences sharedPreferences) {
        this.f1365a = sharedPreferences;
    }

    /* renamed from: a */
    public static C1004b m1844a(String str, Context context) {
        SharedPreferences sharedPreferences;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                context = context.createDeviceProtectedStorageContext();
            }
            sharedPreferences = context.getSharedPreferences(str, 0);
        } catch (Exception unused) {
            C0968a.m1682b("SharedPreferencesWrapper", "getSharedPreference error");
            sharedPreferences = null;
        }
        return new C1004b(sharedPreferences);
    }

    /* renamed from: a */
    public long mo14966a(String str, long j) {
        try {
            return this.f1365a.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    /* renamed from: a */
    public String mo14967a(String str, String str2) {
        try {
            return this.f1365a.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    /* renamed from: a */
    public void mo14968a(String str) {
        try {
            if (this.f1365a.contains(str)) {
                SharedPreferences.Editor edit = this.f1365a.edit();
                edit.remove(str);
                edit.commit();
            }
        } catch (Exception unused) {
            C0968a.m1682b("SharedPreferencesWrapper", "remove error!!key:" + str);
        }
    }

    /* renamed from: b */
    public void mo14969b(String str, long j) {
        try {
            SharedPreferences.Editor edit = this.f1365a.edit();
            edit.putLong(str, j);
            edit.commit();
        } catch (Exception e) {
            C0968a.m1681a("SharedPreferencesWrapper", "putLong error!!key:" + str, e);
        }
    }

    /* renamed from: b */
    public void mo14970b(String str, String str2) {
        try {
            SharedPreferences.Editor edit = this.f1365a.edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Exception e) {
            C0968a.m1681a("SharedPreferencesWrapper", "putString error!!key:" + str, e);
        }
    }
}
