package com.xiaomi.mipush.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.C1653bi;
import com.xiaomi.push.service.C2019bg;

/* renamed from: com.xiaomi.mipush.sdk.ar */
class C1572ar extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ C1568ao f1682a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1572ar(C1568ao aoVar, Handler handler) {
        super(handler);
        this.f1682a = aoVar;
    }

    public void onChange(boolean z) {
        C1568ao aoVar = this.f1682a;
        Integer unused = aoVar.f1672a = Integer.valueOf(C2019bg.m5124a(C1568ao.m2312a(aoVar)).mo18500a());
        if (C1568ao.m2312a(this.f1682a).intValue() != 0) {
            C1568ao.m2312a(this.f1682a).getContentResolver().unregisterContentObserver(this);
            if (C1653bi.m2685b(C1568ao.m2312a(this.f1682a))) {
                this.f1682a.mo17155c();
            }
        }
    }
}
