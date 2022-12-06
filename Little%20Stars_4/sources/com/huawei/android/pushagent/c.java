package com.huawei.android.pushagent;

import android.os.MessageQueue;

class c implements MessageQueue.IdleHandler {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public boolean queueIdle() {
        if (!this.a.c.isHeld()) {
            return true;
        }
        this.a.c.release();
        return true;
    }
}
