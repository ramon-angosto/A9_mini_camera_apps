package com.huawei.android.pushagent.c.c;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.c.a.e;

final class c implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Intent b;

    c(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    public void run() {
        try {
            b.a.b(this.a, this.b);
        } catch (Exception e) {
            e.c("PushLogAC2705", "call handleEvent process cause Exception:" + e.toString(), e);
        }
    }
}
