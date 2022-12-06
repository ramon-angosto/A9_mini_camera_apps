package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.misc.d;
import com.xiaomi.push.service.v;
import com.xiaomi.push.service.w;
import com.xiaomi.xmpush.thrift.a;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.c;
import com.xiaomi.xmpush.thrift.f;
import com.xiaomi.xmpush.thrift.i;
import com.xiaomi.xmpush.thrift.m;
import com.xiaomi.xmpush.thrift.s;

public class j extends d.a {
    private Context a;

    public j(Context context) {
        this.a = context;
    }

    public int a() {
        return 2;
    }

    public void run() {
        v a2 = v.a(this.a);
        m mVar = new m();
        mVar.a(w.a(a2, c.MISC_CONFIG));
        mVar.b(w.a(a2, c.PLUGIN_CONFIG));
        s sVar = new s("-1", false);
        sVar.c(f.DailyCheckClientConfig.z);
        sVar.a(ae.a(mVar));
        o.a(this.a).a(sVar, a.Notification, (i) null);
    }
}
