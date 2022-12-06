package com.huawei.updatesdk.p039b.p048g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;

/* renamed from: com.huawei.updatesdk.b.g.a */
public final class C1032a {

    /* renamed from: a */
    private static String f1392a;

    /* renamed from: a */
    public static String m1944a() {
        String str = f1392a;
        if (str != null) {
            return str;
        }
        Context a = C0985a.m1757c().mo14892a();
        try {
            String packageName = a.getPackageName();
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
            if (packageInfo != null) {
                packageName = packageName + packageInfo.versionName;
            }
            f1392a = packageName + "_" + (TextUtils.isEmpty(Build.BRAND) ? "other" : Build.BRAND);
            return f1392a;
        } catch (Exception e) {
            C0968a.m1682b("ApplicationSession", "getUserAgent() " + e.toString());
            return null;
        }
    }
}
