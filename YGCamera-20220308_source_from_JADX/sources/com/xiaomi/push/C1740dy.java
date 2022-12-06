package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.xiaomi.push.dy */
public class C1740dy extends C1741dz {

    /* renamed from: a */
    private String f2082a;

    public C1740dy(Context context, int i, String str) {
        super(context, i);
        this.f2082a = str;
    }

    /* renamed from: a */
    private String[] mo16986a() {
        if (TextUtils.isEmpty(this.f2082a)) {
            return null;
        }
        String b = C1660bl.m2720b(this.f2082a);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        if (b.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            return b.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        return new String[]{b};
    }

    /* renamed from: a */
    public C1870hq m3057a() {
        return C1870hq.AppIsInstalled;
    }

    /* renamed from: a */
    public String m3058a() {
        return "24";
    }

    /* renamed from: b */
    public String mo17404b() {
        String str;
        String[] a = mo16986a();
        if (a == null || a.length <= 0) {
            return null;
        }
        PackageManager packageManager = this.f2084a.getPackageManager();
        StringBuilder sb = new StringBuilder();
        for (String str2 : a) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str2, 16384);
                if (packageInfo != null) {
                    if (sb.length() > 0) {
                        sb.append(";");
                    }
                    try {
                        str = packageManager.getInstallerPackageName(str2);
                    } catch (IllegalArgumentException unused) {
                        str = null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = "null";
                    }
                    sb.append(packageInfo.applicationInfo.loadLabel(packageManager).toString());
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb.append(packageInfo.packageName);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb.append(packageInfo.versionName);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb.append(packageInfo.versionCode);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb.append(packageInfo.firstInstallTime);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb.append(packageInfo.lastUpdateTime);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb.append(str);
                }
            } catch (Exception unused2) {
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
