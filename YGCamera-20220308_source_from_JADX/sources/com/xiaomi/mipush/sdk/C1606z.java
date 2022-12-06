package com.xiaomi.mipush.sdk;

import android.content.Context;

/* renamed from: com.xiaomi.mipush.sdk.z */
final class C1606z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f1749a;

    C1606z(Context context) {
        this.f1749a = context;
    }

    public void run() {
        MessageHandleService.m2232c(this.f1749a);
    }
}
