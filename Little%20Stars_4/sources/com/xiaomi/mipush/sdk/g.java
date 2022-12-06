package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.service.module.b;
import com.xiaomi.push.service.module.c;
import com.xiaomi.push.service.module.d;

final class g implements Runnable {
    g() {
    }

    public void run() {
        b a = c.a(MiPushClient.sContext).a(d.MODULE_CDATA);
        if (a != null) {
            try {
                a.a().loadClass("com.xiaomi.push.mpcd.MpcdPlugin").getMethod("main", new Class[]{Context.class}).invoke((Object) null, new Object[]{MiPushClient.sContext});
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.a("plugin load fail");
            }
        }
    }
}
