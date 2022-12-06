package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1618ak;

/* renamed from: com.xiaomi.push.bx */
class C1672bx extends C1618ak.C1619a {

    /* renamed from: a */
    final /* synthetic */ C1671bw f1903a;

    C1672bx(C1671bw bwVar) {
        this.f1903a = bwVar;
    }

    /* renamed from: a */
    public String mo16986a() {
        return "10052";
    }

    public void run() {
        C1524b.m2159c("exec== mUploadJob");
        if (C1671bw.m2759a(this.f1903a) != null) {
            C1671bw.m2759a(this.f1903a).mo17326a(C1671bw.m2759a(this.f1903a));
            this.f1903a.m2765b("upload_time");
        }
    }
}
