package com.huawei.android.pushagent.c;

import android.content.Context;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.b.b.a;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.e;

final class b implements Runnable {
    final /* synthetic */ Context a;

    b(Context context) {
        this.a = context;
    }

    public void run() {
        try {
            Thread.sleep(a.a(this.a).O() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        e.a("PushLogAC2705", "start to handle clone event");
        a.w(this.a);
        a.x(this.a);
        a.e(this.a, "pushConfig");
        c.a(this.a).a();
        a.v(this.a);
        if (PushService.a() != null) {
            PushService.a().stopService();
        }
    }
}
