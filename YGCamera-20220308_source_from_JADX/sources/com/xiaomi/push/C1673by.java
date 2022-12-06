package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1618ak;
import java.lang.ref.WeakReference;

/* renamed from: com.xiaomi.push.by */
class C1673by extends C1618ak.C1619a {

    /* renamed from: a */
    final /* synthetic */ C1671bw f1904a;

    C1673by(C1671bw bwVar) {
        this.f1904a = bwVar;
    }

    /* renamed from: a */
    public String mo16986a() {
        return "10054";
    }

    public void run() {
        C1524b.m2159c("exec== DbSizeControlJob");
        C1685ci.m2838a(C1671bw.m2759a(this.f1904a)).mo17313a((Runnable) new C1678cb(C1671bw.m2759a(this.f1904a), new WeakReference(C1671bw.m2759a(this.f1904a))));
        this.f1904a.m2765b("check_time");
    }
}
