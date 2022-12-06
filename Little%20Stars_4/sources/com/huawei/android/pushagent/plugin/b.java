package com.huawei.android.pushagent.plugin;

import com.huawei.android.pushagent.plugin.a.f;
import com.huawei.android.pushagent.plugin.c.a;

class b implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ PushPlugins b;

    b(PushPlugins pushPlugins, long j) {
        this.b = pushPlugins;
        this.a = j;
    }

    public void run() {
        this.b.a(new a(), f.LBS, this.a);
    }
}
