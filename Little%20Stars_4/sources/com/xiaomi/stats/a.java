package com.xiaomi.stats;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.y;

class a implements y.b.a {
    private XMPushService a;
    private y.b b;
    private com.xiaomi.smack.a c;
    private y.c d;
    private int e;
    private boolean f = false;

    a(XMPushService xMPushService, y.b bVar) {
        this.a = xMPushService;
        this.d = y.c.binding;
        this.b = bVar;
    }

    private void b() {
        this.b.b((y.b.a) this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r4 = this;
            r4.b()
            boolean r0 = r4.f
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            int r0 = r4.e
            r1 = 11
            if (r0 != r1) goto L_0x000f
            return
        L_0x000f:
            com.xiaomi.stats.f r0 = com.xiaomi.stats.f.a()
            com.xiaomi.push.thrift.b r0 = r0.f()
            int[] r1 = com.xiaomi.stats.c.a
            com.xiaomi.push.service.y$c r2 = r4.d
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L_0x0034
            r3 = 2
            if (r1 == r3) goto L_0x005f
            r3 = 3
            if (r1 == r3) goto L_0x002b
            goto L_0x005f
        L_0x002b:
            com.xiaomi.push.thrift.a r1 = com.xiaomi.push.thrift.a.BIND_SUCCESS
        L_0x002d:
            int r1 = r1.a()
            r0.b = r1
            goto L_0x005f
        L_0x0034:
            int r1 = r4.e
            r3 = 17
            if (r1 != r3) goto L_0x003d
            com.xiaomi.push.thrift.a r1 = com.xiaomi.push.thrift.a.BIND_TCP_READ_TIMEOUT
            goto L_0x002d
        L_0x003d:
            r3 = 21
            if (r1 != r3) goto L_0x0044
            com.xiaomi.push.thrift.a r1 = com.xiaomi.push.thrift.a.BIND_TIMEOUT
            goto L_0x002d
        L_0x0044:
            com.xiaomi.stats.e r1 = com.xiaomi.stats.f.b()     // Catch:{ NullPointerException -> 0x005e }
            java.lang.Exception r1 = r1.a()     // Catch:{ NullPointerException -> 0x005e }
            com.xiaomi.stats.d$a r1 = com.xiaomi.stats.d.c(r1)     // Catch:{ NullPointerException -> 0x005e }
            com.xiaomi.push.thrift.a r3 = r1.a     // Catch:{ NullPointerException -> 0x005e }
            int r3 = r3.a()     // Catch:{ NullPointerException -> 0x005e }
            r0.b = r3     // Catch:{ NullPointerException -> 0x005e }
            java.lang.String r1 = r1.b     // Catch:{ NullPointerException -> 0x005e }
            r0.c((java.lang.String) r1)     // Catch:{ NullPointerException -> 0x005e }
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            if (r0 == 0) goto L_0x0086
            com.xiaomi.smack.a r1 = r4.c
            java.lang.String r1 = r1.c()
            r0.b((java.lang.String) r1)
            com.xiaomi.push.service.y$b r1 = r4.b
            java.lang.String r1 = r1.b
            r0.d((java.lang.String) r1)
            r0.c = r2
            com.xiaomi.push.service.y$b r1 = r4.b     // Catch:{ NumberFormatException -> 0x007f }
            java.lang.String r1 = r1.h     // Catch:{ NumberFormatException -> 0x007f }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x007f }
            byte r1 = (byte) r1     // Catch:{ NumberFormatException -> 0x007f }
            r0.a((byte) r1)     // Catch:{ NumberFormatException -> 0x007f }
        L_0x007f:
            com.xiaomi.stats.f r1 = com.xiaomi.stats.f.a()
            r1.a((com.xiaomi.push.thrift.b) r0)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.stats.a.c():void");
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.b.a((y.b.a) this);
        this.c = this.a.g();
    }

    public void a(y.c cVar, y.c cVar2, int i) {
        if (!this.f && cVar == y.c.binding) {
            this.d = cVar2;
            this.e = i;
            this.f = true;
        }
        this.a.a((XMPushService.g) new b(this, 4));
    }
}
