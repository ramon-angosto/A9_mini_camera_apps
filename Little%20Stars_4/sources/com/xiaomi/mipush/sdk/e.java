package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xiaomi.channel.commonutils.logger.b;

final class e implements Runnable {
    final /* synthetic */ Context a;

    e(Context context) {
        this.a = context;
    }

    public void run() {
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 4100);
            d.c(this.a);
            d.d(this.a, packageInfo);
            d.c(this.a, packageInfo);
        } catch (PackageManager.NameNotFoundException e) {
            b.a((Throwable) e);
        }
    }
}
