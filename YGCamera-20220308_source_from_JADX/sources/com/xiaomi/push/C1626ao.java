package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.C1623an;

/* renamed from: com.xiaomi.push.ao */
class C1626ao extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1623an f1785a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1626ao(C1623an anVar, Looper looper) {
        super(looper);
        this.f1785a = anVar;
    }

    public void handleMessage(Message message) {
        C1623an.C1625b bVar = (C1623an.C1625b) message.obj;
        if (message.what == 0) {
            bVar.mo17227a();
        } else if (message.what == 1) {
            bVar.mo17229c();
        }
        super.handleMessage(message);
    }
}
