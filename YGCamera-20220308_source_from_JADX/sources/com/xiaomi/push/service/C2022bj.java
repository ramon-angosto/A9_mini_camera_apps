package com.xiaomi.push.service;

import com.huawei.agconnect.exception.AGCServerException;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1857hg;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.bj */
class C2022bj {

    /* renamed from: d */
    private static int f3820d = 300000;

    /* renamed from: a */
    private int f3821a;

    /* renamed from: a */
    private long f3822a;

    /* renamed from: a */
    private XMPushService f3823a;

    /* renamed from: b */
    private int f3824b = 0;

    /* renamed from: c */
    private int f3825c = 0;

    public C2022bj(XMPushService xMPushService) {
        this.f3823a = xMPushService;
        this.f3821a = AGCServerException.UNKNOW_EXCEPTION;
        this.f3822a = 0;
    }

    /* renamed from: a */
    private int mo18502a() {
        if (this.f3824b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.f3824b;
        if (i > 4) {
            return (int) (random * 60000.0d);
        }
        if (i > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f3822a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f3822a < 310000) {
            int i2 = this.f3821a;
            int i3 = f3820d;
            if (i2 >= i3) {
                return i2;
            }
            this.f3825c++;
            if (this.f3825c >= 4) {
                return i3;
            }
            double d = (double) i2;
            Double.isNaN(d);
            this.f3821a = (int) (d * 1.5d);
            return i2;
        }
        this.f3821a = 1000;
        this.f3825c = 0;
        return 0;
    }

    /* renamed from: a */
    public void m5139a() {
        this.f3822a = System.currentTimeMillis();
        this.f3823a.mo18409a(1);
        this.f3824b = 0;
    }

    /* renamed from: a */
    public void mo18503a(boolean z) {
        if (!this.f3823a.mo18408a()) {
            C1524b.m2159c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f3823a.mo18409a(1)) {
                this.f3824b++;
            }
            this.f3823a.mo18409a(1);
            XMPushService xMPushService = this.f3823a;
            xMPushService.getClass();
            xMPushService.mo18412a((XMPushService.C1956i) new XMPushService.C1951d());
        } else if (!this.f3823a.mo18409a(1)) {
            int a = mo18502a();
            this.f3824b++;
            C1524b.m2141a("schedule reconnect in " + a + "ms");
            XMPushService xMPushService2 = this.f3823a;
            xMPushService2.getClass();
            xMPushService2.mo18413a((XMPushService.C1956i) new XMPushService.C1951d(), (long) a);
            if (this.f3824b == 2 && C1857hg.mo17753a().mo17753a()) {
                C1981aj.m4960b();
            }
            if (this.f3824b == 3) {
                C1981aj.m4957a();
            }
        }
    }
}
