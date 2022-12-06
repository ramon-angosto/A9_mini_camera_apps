package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.channel.commonutils.misc.f;

class g extends Handler {
    final /* synthetic */ f a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g(f fVar, Looper looper) {
        super(looper);
        this.a = fVar;
    }

    public void handleMessage(Message message) {
        f.b bVar = (f.b) message.obj;
        if (message.what == 0) {
            bVar.a();
        } else if (message.what == 1) {
            bVar.c();
        }
        super.handleMessage(message);
    }
}
