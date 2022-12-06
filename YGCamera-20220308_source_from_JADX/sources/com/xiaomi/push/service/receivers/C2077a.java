package com.xiaomi.push.service.receivers;

import android.content.Context;

/* renamed from: com.xiaomi.push.service.receivers.a */
class C2077a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f3953a;

    /* renamed from: a */
    final /* synthetic */ NetworkStatusReceiver f3954a;

    C2077a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f3954a = networkStatusReceiver;
        this.f3953a = context;
    }

    public void run() {
        this.f3954a.m5330a(this.f3953a);
    }
}
