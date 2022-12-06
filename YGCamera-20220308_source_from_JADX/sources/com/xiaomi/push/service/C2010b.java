package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1905iy;
import java.lang.ref.WeakReference;

/* renamed from: com.xiaomi.push.service.b */
public class C2010b extends C1618ak.C1619a {

    /* renamed from: a */
    private C1894in f3763a;

    /* renamed from: a */
    private WeakReference<XMPushService> f3764a;

    /* renamed from: a */
    private boolean f3765a = false;

    public C2010b(C1894in inVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f3763a = inVar;
        this.f3764a = weakReference;
        this.f3765a = z;
    }

    /* renamed from: a */
    public String mo16986a() {
        return "22";
    }

    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.f3764a;
        if (weakReference != null && this.f3763a != null && (xMPushService = (XMPushService) weakReference.get()) != null) {
            this.f3763a.mo18078a(C1999aw.m5064a());
            this.f3763a.mo18081a(false);
            C1524b.m2159c("MoleInfo aw_ping : send aw_Ping msg " + this.f3763a.mo18077a());
            try {
                String c = this.f3763a.mo18088c();
                xMPushService.mo18417a(c, C1905iy.m4543a(C1970ab.m4880a(c, this.f3763a.mo18085b(), this.f3763a, C1868ho.Notification)), this.f3765a);
            } catch (Exception e) {
                C1524b.m2160d("MoleInfo aw_ping : send help app ping error" + e.toString());
            }
        }
    }
}
