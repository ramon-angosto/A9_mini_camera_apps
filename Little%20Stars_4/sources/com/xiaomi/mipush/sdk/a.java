package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.b;
import com.xiaomi.channel.commonutils.android.e;

public class a {
    private static a a;
    /* access modifiers changed from: private */
    public Context b;
    private C0050a c;

    /* renamed from: com.xiaomi.mipush.sdk.a$a  reason: collision with other inner class name */
    private class C0050a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public boolean h;
        public boolean i;
        public int j;

        private C0050a() {
            this.h = true;
            this.i = false;
            this.j = 1;
        }

        private String d() {
            return b.a(a.this.b, a.this.b.getPackageName());
        }

        public void a(int i2) {
            this.j = i2;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = e.e(a.this.b);
            this.e = d();
            this.h = true;
            SharedPreferences.Editor edit = a.this.j().edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", d());
            edit.putBoolean("valid", true);
            edit.commit();
        }

        public void a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = a.this.j().edit();
            edit.putString("appId", this.a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.i = z;
        }

        public boolean a() {
            return b(this.a, this.b);
        }

        public void b() {
            a.this.j().edit().clear().commit();
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.h = false;
            this.i = false;
            this.j = 1;
        }

        public boolean b(String str, String str2) {
            return TextUtils.equals(this.a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && TextUtils.equals(this.f, e.e(a.this.b));
        }

        public void c() {
            this.h = false;
            a.this.j().edit().putBoolean("valid", this.h).commit();
        }
    }

    private a(Context context) {
        this.b = context;
        o();
    }

    public static a a(Context context) {
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    private void o() {
        this.c = new C0050a();
        SharedPreferences j = j();
        this.c.a = j.getString("appId", (String) null);
        this.c.b = j.getString("appToken", (String) null);
        this.c.c = j.getString("regId", (String) null);
        this.c.d = j.getString("regSec", (String) null);
        this.c.f = j.getString("devId", (String) null);
        if (!TextUtils.isEmpty(this.c.f) && this.c.f.startsWith("a-")) {
            this.c.f = e.e(this.b);
            j.edit().putString("devId", this.c.f).commit();
        }
        this.c.e = j.getString("vName", (String) null);
        this.c.h = j.getBoolean("valid", true);
        this.c.i = j.getBoolean("paused", false);
        this.c.j = j.getInt("envType", 1);
        this.c.g = j.getString("regResource", (String) null);
    }

    public void a(int i) {
        this.c.a(i);
        j().edit().putInt("envType", i).commit();
    }

    public void a(String str) {
        SharedPreferences.Editor edit = j().edit();
        edit.putString("vName", str);
        edit.commit();
        this.c.e = str;
    }

    public void a(String str, String str2, String str3) {
        this.c.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.c.a(z);
        j().edit().putBoolean("paused", z).commit();
    }

    public boolean a() {
        Context context = this.b;
        return !TextUtils.equals(b.a(context, context.getPackageName()), this.c.e);
    }

    public boolean a(String str, String str2) {
        return this.c.b(str, str2);
    }

    public void b(String str, String str2) {
        this.c.a(str, str2);
    }

    public boolean b() {
        if (this.c.a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.a("Don't send message before initialization succeeded!");
        return false;
    }

    public String c() {
        return this.c.a;
    }

    public String d() {
        return this.c.b;
    }

    public String e() {
        return this.c.c;
    }

    public String f() {
        return this.c.d;
    }

    public String g() {
        return this.c.g;
    }

    public void h() {
        this.c.b();
    }

    public boolean i() {
        return this.c.a();
    }

    public SharedPreferences j() {
        return this.b.getSharedPreferences("mipush", 0);
    }

    public void k() {
        this.c.c();
    }

    public boolean l() {
        return this.c.i;
    }

    public int m() {
        return this.c.j;
    }

    public boolean n() {
        return !this.c.h;
    }
}
