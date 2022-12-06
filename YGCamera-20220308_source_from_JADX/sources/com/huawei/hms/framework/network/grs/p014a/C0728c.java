package com.huawei.hms.framework.network.grs.p014a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;

/* renamed from: com.huawei.hms.framework.network.grs.a.c */
public class C0728c {

    /* renamed from: a */
    private static final String f471a = "c";

    /* renamed from: b */
    private PLSharedPreferences f472b = null;

    public C0728c(Context context, String str) {
        String packageName = context.getPackageName();
        Logger.m470d(f471a, "get pkgname from context is{%s}", packageName);
        this.f472b = new PLSharedPreferences(context, str + packageName);
        m511a(context);
    }

    /* renamed from: a */
    private void m511a(Context context) {
        try {
            String l = Long.toString((long) context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
            String a = mo13805a(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, "");
            if (!l.equals(a)) {
                Logger.m475i(f471a, "app version changed! old version{%s} and new version{%s}", a, l);
                mo13810c();
                mo13809b(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, l);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.m478w(f471a, "get app version failed and catch NameNotFoundException");
        }
    }

    /* renamed from: a */
    public String mo13805a(String str, String str2) {
        return this.f472b.getString(str, str2);
    }

    /* renamed from: a */
    public Map<String, ?> mo13806a() {
        return this.f472b.getAll();
    }

    /* renamed from: a */
    public void mo13807a(String str) {
        this.f472b.remove(str);
    }

    /* renamed from: b */
    public String mo13808b() {
        return mo13805a("cp", "");
    }

    /* renamed from: b */
    public void mo13809b(String str, String str2) {
        this.f472b.putString(str, str2);
    }

    /* renamed from: c */
    public void mo13810c() {
        this.f472b.clear();
    }
}
