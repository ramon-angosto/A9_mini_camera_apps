package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.util.l;
import java.util.Date;

class c implements l {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void a(String str) {
        b.c("SMACK " + this.a.b.format(new Date()) + " SENT (" + this.a.c.hashCode() + "): " + str);
    }
}
