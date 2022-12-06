package com.baidu.mapapi;

import android.os.Handler;
import android.os.Message;

class t extends Handler {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.a.b();
        } else if (i == 2) {
            this.a.c();
        }
    }
}
