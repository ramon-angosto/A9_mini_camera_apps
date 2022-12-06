package com.huawei.android.pushselfshow.richpush.html.api;

import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue;

class a implements Runnable {
    final /* synthetic */ NativeToJsMessageQueue.OnlineEventsBridgeMode a;

    a(NativeToJsMessageQueue.OnlineEventsBridgeMode onlineEventsBridgeMode) {
        this.a = onlineEventsBridgeMode;
    }

    public void run() {
        boolean a2 = NativeToJsMessageQueue.this.d();
        e.a("PushSelfShowLog", "bEmptyMsg is " + a2);
        if (!a2) {
            NativeToJsMessageQueue.OnlineEventsBridgeMode onlineEventsBridgeMode = this.a;
            onlineEventsBridgeMode.a = !onlineEventsBridgeMode.a;
            NativeToJsMessageQueue.this.a.setNetworkAvailable(this.a.a);
            e.a("PushSelfShowLog", "setNetworkAvailable ： " + this.a.a);
        }
    }
}
