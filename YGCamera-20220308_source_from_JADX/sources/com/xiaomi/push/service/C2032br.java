package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C2030bq;

/* renamed from: com.xiaomi.push.service.br */
class C2032br implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2030bq f3846a;

    C2032br(C2030bq bqVar) {
        this.f3846a = bqVar;
    }

    public void run() {
        try {
            for (C2030bq.C2031a run : C2030bq.m5166a(this.f3846a).values()) {
                run.run();
            }
        } catch (Exception e) {
            C1524b.m2141a("Sync job exception :" + e.getMessage());
        }
        boolean unused = this.f3846a.f3843a = false;
    }
}
