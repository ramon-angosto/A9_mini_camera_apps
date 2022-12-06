package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.service.C1999aw;

/* renamed from: com.xiaomi.mipush.sdk.p */
final class C1594p extends C1618ak.C1619a {

    /* renamed from: a */
    final /* synthetic */ Context f1734a;

    /* renamed from: a */
    final /* synthetic */ C1894in f1735a;

    C1594p(C1894in inVar, Context context) {
        this.f1735a = inVar;
        this.f1734a = context;
    }

    /* renamed from: a */
    public String mo16986a() {
        return "22";
    }

    public void run() {
        C1894in inVar = this.f1735a;
        if (inVar != null) {
            inVar.mo18078a(C1999aw.m5064a());
            C1568ao.m2317a(this.f1734a.getApplicationContext()).mo17144a(this.f1735a, C1868ho.Notification, true, (C1882ib) null, true);
        }
    }
}
