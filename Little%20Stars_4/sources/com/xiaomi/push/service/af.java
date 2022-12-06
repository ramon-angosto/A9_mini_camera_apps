package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.stats.f;

class af {
    private static int e = 300000;
    private XMPushService a;
    private int b;
    private long c;
    private int d = 0;

    public af(XMPushService xMPushService) {
        this.a = xMPushService;
        this.b = 500;
        this.c = 0;
    }

    private int b() {
        int i = this.d;
        if (i > 8) {
            return 300000;
        }
        if (i > 4) {
            return 60000;
        }
        if (i > 1) {
            return 10000;
        }
        if (this.c == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.c < 300000) {
            int i2 = this.b;
            if (i2 >= e) {
                return i2;
            }
            double d2 = (double) i2;
            Double.isNaN(d2);
            this.b = (int) (d2 * 1.5d);
            return i2;
        }
        this.b = 500;
        return 0;
    }

    public void a() {
        this.c = System.currentTimeMillis();
        this.a.a(1);
        this.d = 0;
    }

    public void a(boolean z) {
        if (!this.a.a()) {
            b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.a.b(1)) {
                this.d++;
            }
            this.a.a(1);
            XMPushService xMPushService = this.a;
            xMPushService.getClass();
            xMPushService.a((XMPushService.g) new XMPushService.c());
        } else if (!this.a.b(1)) {
            int b2 = b();
            if (!this.a.b(1)) {
                this.d++;
            }
            b.a("schedule reconnect in " + b2 + "ms");
            XMPushService xMPushService2 = this.a;
            xMPushService2.getClass();
            xMPushService2.a((XMPushService.g) new XMPushService.c(), (long) b2);
            if (this.d == 2 && f.a().c()) {
                t.b();
            }
            if (this.d == 3) {
                t.a();
            }
        }
    }
}
