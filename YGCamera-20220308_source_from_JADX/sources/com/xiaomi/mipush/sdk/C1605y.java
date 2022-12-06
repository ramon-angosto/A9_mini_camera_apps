package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.mipush.sdk.y */
final class C1605y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f1747a;

    /* renamed from: a */
    final /* synthetic */ Intent f1748a;

    C1605y(Context context, Intent intent) {
        this.f1747a = context;
        this.f1748a = intent;
    }

    public void run() {
        try {
            this.f1747a.startService(this.f1748a);
        } catch (Exception e) {
            C1524b.m2141a(e.getMessage());
        }
    }
}
