package com.xiaomi.push;

import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.hb */
class C1851hb implements C2003az.C2005b.C2006a {

    /* renamed from: a */
    private int f2610a;

    /* renamed from: a */
    private C1809fu f2611a;

    /* renamed from: a */
    private XMPushService f2612a;

    /* renamed from: a */
    private C2003az.C2005b f2613a;

    /* renamed from: a */
    private C2003az.C2009c f2614a;

    /* renamed from: a */
    private boolean f2615a = false;

    C1851hb(XMPushService xMPushService, C2003az.C2005b bVar) {
        this.f2612a = xMPushService;
        this.f2614a = C2003az.C2009c.binding;
        this.f2613a = bVar;
    }

    /* renamed from: b */
    private void m3828b() {
        this.f2613a.mo18495b(this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m3829c() {
        /*
            r4 = this;
            r4.m3828b()
            boolean r0 = r4.f2615a
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            int r0 = r4.f2610a
            r1 = 11
            if (r0 != r1) goto L_0x000f
            return
        L_0x000f:
            com.xiaomi.push.hg r0 = com.xiaomi.push.C1857hg.mo17753a()
            com.xiaomi.push.fg r0 = r0.mo17753a()
            int[] r1 = com.xiaomi.push.C1853hd.f2617a
            com.xiaomi.push.service.az$c r2 = r4.f2614a
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
            com.xiaomi.push.ff r1 = com.xiaomi.push.C1789ff.BIND_SUCCESS
        L_0x002d:
            int r1 = r1.mo17573a()
            r0.f2364a = r1
            goto L_0x005f
        L_0x0034:
            int r1 = r4.f2610a
            r3 = 17
            if (r1 != r3) goto L_0x003d
            com.xiaomi.push.ff r1 = com.xiaomi.push.C1789ff.BIND_TCP_READ_TIMEOUT
            goto L_0x002d
        L_0x003d:
            r3 = 21
            if (r1 != r3) goto L_0x0044
            com.xiaomi.push.ff r1 = com.xiaomi.push.C1789ff.BIND_TIMEOUT
            goto L_0x002d
        L_0x0044:
            com.xiaomi.push.hf r1 = com.xiaomi.push.C1857hg.mo17753a()     // Catch:{ NullPointerException -> 0x005e }
            java.lang.Exception r1 = r1.mo17752a()     // Catch:{ NullPointerException -> 0x005e }
            com.xiaomi.push.he$a r1 = com.xiaomi.push.C1854he.m3837c(r1)     // Catch:{ NullPointerException -> 0x005e }
            com.xiaomi.push.ff r3 = r1.f2618a     // Catch:{ NullPointerException -> 0x005e }
            int r3 = r3.mo17573a()     // Catch:{ NullPointerException -> 0x005e }
            r0.f2364a = r3     // Catch:{ NullPointerException -> 0x005e }
            java.lang.String r1 = r1.f2619a     // Catch:{ NullPointerException -> 0x005e }
            r0.mo17587c((java.lang.String) r1)     // Catch:{ NullPointerException -> 0x005e }
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            if (r0 == 0) goto L_0x0086
            com.xiaomi.push.fu r1 = r4.f2611a
            java.lang.String r1 = r1.mo17639a()
            r0.mo17582b((java.lang.String) r1)
            com.xiaomi.push.service.az$b r1 = r4.f2613a
            java.lang.String r1 = r1.f3742b
            r0.mo17592d((java.lang.String) r1)
            r0.f2367b = r2
            com.xiaomi.push.service.az$b r1 = r4.f2613a     // Catch:{ NumberFormatException -> 0x007f }
            java.lang.String r1 = r1.f3748g     // Catch:{ NumberFormatException -> 0x007f }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x007f }
            byte r1 = (byte) r1     // Catch:{ NumberFormatException -> 0x007f }
            r0.mo17575a((byte) r1)     // Catch:{ NumberFormatException -> 0x007f }
        L_0x007f:
            com.xiaomi.push.hg r1 = com.xiaomi.push.C1857hg.mo17753a()
            r1.mo17755a((com.xiaomi.push.C1790fg) r0)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1851hb.m3829c():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo17750a() {
        this.f2613a.mo18493a((C2003az.C2005b.C2006a) this);
        this.f2611a = this.f2612a.mo18408a();
    }

    /* renamed from: a */
    public void mo17751a(C2003az.C2009c cVar, C2003az.C2009c cVar2, int i) {
        if (!this.f2615a && cVar == C2003az.C2009c.binding) {
            this.f2614a = cVar2;
            this.f2610a = i;
            this.f2615a = true;
        }
        this.f2612a.mo18412a((XMPushService.C1956i) new C1852hc(this, 4));
    }
}
