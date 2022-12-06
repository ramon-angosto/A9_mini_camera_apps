package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.channel.commonutils.android.i;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.channel.commonutils.network.c;
import com.xiaomi.network.HttpUtils;
import com.xiaomi.push.protobuf.a;
import com.xiaomi.push.service.ah;
import java.util.List;

class ai extends f.b {
    boolean a = false;
    final /* synthetic */ ah b;

    ai(ah ahVar) {
        this.b = ahVar;
    }

    public void b() {
        try {
            a.C0052a b2 = a.C0052a.b(Base64.decode(HttpUtils.a(i.a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<c>) null), 10));
            if (b2 != null) {
                a.C0052a unused = this.b.c = b2;
                this.a = true;
                this.b.i();
            }
        } catch (Exception e) {
            b.a("fetch config failure: " + e.getMessage());
        }
    }

    public void c() {
        ah.a[] aVarArr;
        f.b unused = this.b.d = null;
        if (this.a) {
            synchronized (this.b) {
                aVarArr = (ah.a[]) this.b.b.toArray(new ah.a[this.b.b.size()]);
            }
            for (ah.a a2 : aVarArr) {
                a2.a(this.b.c);
            }
        }
    }
}
