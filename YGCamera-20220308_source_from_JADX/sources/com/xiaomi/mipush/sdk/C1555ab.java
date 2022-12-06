package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;

/* renamed from: com.xiaomi.mipush.sdk.ab */
class C1555ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MiTinyDataClient.C1550a.C1551a f1643a;

    C1555ab(MiTinyDataClient.C1550a.C1551a aVar) {
        this.f1643a = aVar;
    }

    public void run() {
        if (this.f1643a.f1632a.size() != 0) {
            this.f1643a.m2251b();
        } else if (MiTinyDataClient.C1550a.C1551a.m2247a(this.f1643a) != null) {
            MiTinyDataClient.C1550a.C1551a.m2247a(this.f1643a).cancel(false);
            ScheduledFuture unused = this.f1643a.f1633a = null;
        }
    }
}
