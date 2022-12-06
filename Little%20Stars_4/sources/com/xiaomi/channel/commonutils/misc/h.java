package com.xiaomi.channel.commonutils.misc;

import com.xiaomi.channel.commonutils.misc.f;

class h implements Runnable {
    final /* synthetic */ f.b a;
    final /* synthetic */ f b;

    h(f fVar, f.b bVar) {
        this.b = fVar;
        this.a = bVar;
    }

    public void run() {
        this.b.a(this.a);
    }
}
