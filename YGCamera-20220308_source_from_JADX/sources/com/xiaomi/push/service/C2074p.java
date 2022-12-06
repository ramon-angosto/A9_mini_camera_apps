package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1663bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.xiaomi.push.service.p */
public class C2074p {

    /* renamed from: a */
    private static C2074p f3934a;

    /* renamed from: a */
    private Context f3935a;

    /* renamed from: a */
    private List<String> f3936a = new ArrayList();

    /* renamed from: b */
    private final List<String> f3937b = new ArrayList();

    /* renamed from: c */
    private final List<String> f3938c = new ArrayList();

    private C2074p(Context context) {
        this.f3935a = context.getApplicationContext();
        if (this.f3935a == null) {
            this.f3935a = context;
        }
        SharedPreferences sharedPreferences = this.f3935a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(str)) {
                this.f3936a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f3937b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str3)) {
                this.f3938c.add(str3);
            }
        }
    }

    /* renamed from: a */
    public static C2074p m5312a(Context context) {
        if (f3934a == null) {
            f3934a = new C2074p(context);
        }
        return f3934a;
    }

    /* renamed from: a */
    public void mo18556a(String str) {
        synchronized (this.f3936a) {
            if (!this.f3936a.contains(str)) {
                this.f3936a.add(str);
                this.f3935a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C1663bo.m2729a((Collection<?>) this.f3936a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: a */
    public boolean m5314a(String str) {
        boolean contains;
        synchronized (this.f3936a) {
            contains = this.f3936a.contains(str);
        }
        return contains;
    }

    /* renamed from: b */
    public void mo18557b(String str) {
        synchronized (this.f3937b) {
            if (!this.f3937b.contains(str)) {
                this.f3937b.add(str);
                this.f3935a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", C1663bo.m2729a((Collection<?>) this.f3937b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: b */
    public boolean m5316b(String str) {
        boolean contains;
        synchronized (this.f3937b) {
            contains = this.f3937b.contains(str);
        }
        return contains;
    }

    /* renamed from: c */
    public void mo18558c(String str) {
        synchronized (this.f3938c) {
            if (!this.f3938c.contains(str)) {
                this.f3938c.add(str);
                this.f3935a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", C1663bo.m2729a((Collection<?>) this.f3938c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: c */
    public boolean m5318c(String str) {
        boolean contains;
        synchronized (this.f3938c) {
            contains = this.f3938c.contains(str);
        }
        return contains;
    }

    /* renamed from: d */
    public void mo18559d(String str) {
        synchronized (this.f3936a) {
            if (this.f3936a.contains(str)) {
                this.f3936a.remove(str);
                this.f3935a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C1663bo.m2729a((Collection<?>) this.f3936a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: e */
    public void mo18560e(String str) {
        synchronized (this.f3937b) {
            if (this.f3937b.contains(str)) {
                this.f3937b.remove(str);
                this.f3935a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", C1663bo.m2729a((Collection<?>) this.f3937b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: f */
    public void mo18561f(String str) {
        synchronized (this.f3938c) {
            if (this.f3938c.contains(str)) {
                this.f3938c.remove(str);
                this.f3935a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", C1663bo.m2729a((Collection<?>) this.f3938c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
