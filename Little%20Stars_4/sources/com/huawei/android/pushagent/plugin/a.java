package com.huawei.android.pushagent.plugin;

import com.huawei.android.pushagent.plugin.a.f;
import com.huawei.android.pushagent.plugin.c.c;

class a implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ PushPlugins c;

    a(PushPlugins pushPlugins, String str, long j) {
        this.c = pushPlugins;
        this.a = str;
        this.b = j;
    }

    public void run() {
        this.c.a(new c(this.a), f.TAG, this.b);
    }
}
