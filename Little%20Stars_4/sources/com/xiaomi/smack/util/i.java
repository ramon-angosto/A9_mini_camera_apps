package com.xiaomi.smack.util;

import com.xiaomi.channel.commonutils.misc.f;

final class i extends f.b {
    final /* synthetic */ Runnable a;

    i(Runnable runnable) {
        this.a = runnable;
    }

    public void b() {
        this.a.run();
    }
}
