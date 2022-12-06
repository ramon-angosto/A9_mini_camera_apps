package com.xiaomi.mipush.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.push.service.ac;

class p extends ContentObserver {
    final /* synthetic */ o a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p(o oVar, Handler handler) {
        super(handler);
        this.a = oVar;
    }

    public void onChange(boolean z) {
        o oVar = this.a;
        Integer unused = oVar.g = Integer.valueOf(ac.a(oVar.c).b());
        if (this.a.g.intValue() != 0) {
            this.a.c.getContentResolver().unregisterContentObserver(this);
            if (d.d(this.a.c)) {
                this.a.c();
            }
        }
    }
}
