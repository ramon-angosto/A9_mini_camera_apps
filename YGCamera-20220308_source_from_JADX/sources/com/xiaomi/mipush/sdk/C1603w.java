package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

/* renamed from: com.xiaomi.mipush.sdk.w */
final class C1603w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f1744a;

    C1603w(Context context) {
        this.f1744a = context;
    }

    public void run() {
        try {
            PackageInfo packageInfo = this.f1744a.getPackageManager().getPackageInfo(this.f1744a.getPackageName(), 4612);
            C1600v.m2483c(this.f1744a);
            C1600v.m2485d(this.f1744a, packageInfo);
            C1600v.m2484c(this.f1744a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
