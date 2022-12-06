package com.huawei.android.pushagent.plugin;

import com.huawei.android.pushagent.plugin.tools.c;

class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run() {
        this.a.d.a(this.a.a, this.a.b, this.a.c);
        c.a(this.a.d.a);
    }
}
