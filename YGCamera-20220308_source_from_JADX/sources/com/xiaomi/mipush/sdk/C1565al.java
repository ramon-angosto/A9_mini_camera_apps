package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.xiaomi.mipush.sdk.al */
final class C1565al implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f1658a;

    /* renamed from: a */
    final /* synthetic */ Intent f1659a;

    C1565al(Context context, Intent intent) {
        this.f1658a = context;
        this.f1659a = intent;
    }

    public void run() {
        PushMessageHandler.m2270b(this.f1658a, this.f1659a);
    }
}
