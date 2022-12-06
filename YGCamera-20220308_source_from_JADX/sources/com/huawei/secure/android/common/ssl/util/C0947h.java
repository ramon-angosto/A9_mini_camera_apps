package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: com.huawei.secure.android.common.ssl.util.h */
public class C0947h {

    /* renamed from: a */
    private static final String f1246a = "h";

    /* renamed from: a */
    public static String m1583a(String str) {
        Context a = C0942c.m1556a();
        if (a == null) {
            return "";
        }
        try {
            return a.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String str2 = f1246a;
            C0946g.m1579b(str2, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            String str3 = f1246a;
            C0946g.m1579b(str3, "getVersion: " + e2.getMessage());
            return "";
        } catch (Throwable unused) {
            C0946g.m1579b(f1246a, "throwable");
            return "";
        }
    }

    /* renamed from: b */
    public static int m1584b(String str) {
        Context a = C0942c.m1556a();
        if (a == null) {
            return 0;
        }
        try {
            return a.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            C0946g.m1579b(f1246a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e) {
            String str2 = f1246a;
            C0946g.m1579b(str2, "getVersion: " + e.getMessage());
            return 0;
        }
    }
}
