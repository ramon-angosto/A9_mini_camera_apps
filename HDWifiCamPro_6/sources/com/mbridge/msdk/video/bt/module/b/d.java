package com.mbridge.msdk.video.bt.module.b;

import android.content.Context;
import com.mbridge.msdk.videocommon.d.c;

/* compiled from: ProxyShowRewardListener */
public final class d extends b {
    private h a;
    private c b;
    private String c;
    private String d;
    private boolean e;
    private Context f;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d A[Catch:{ Exception -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053 A[Catch:{ Exception -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(android.content.Context r4, boolean r5, com.mbridge.msdk.videocommon.d.c r6, com.mbridge.msdk.foundation.entity.CampaignEx r7, com.mbridge.msdk.video.bt.module.b.h r8, java.lang.String r9, java.lang.String r10) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.g = r0
            r3.h = r0
            r3.i = r0
            r3.a = r8
            r3.b = r6
            r3.c = r10
            r3.d = r9
            r3.e = r5
            r3.f = r4
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r4 = r4.h()     // Catch:{ Exception -> 0x0071 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0071 }
            r8 = 0
            if (r5 != 0) goto L_0x0042
            com.mbridge.msdk.b.b r5 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x0071 }
            com.mbridge.msdk.b.a r4 = r5.b(r4)     // Catch:{ Exception -> 0x0071 }
            if (r4 != 0) goto L_0x0038
            com.mbridge.msdk.b.b r4 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x0071 }
            com.mbridge.msdk.b.a r4 = r4.b()     // Catch:{ Exception -> 0x0071 }
        L_0x0038:
            if (r4 == 0) goto L_0x0042
            long r4 = r4.v()     // Catch:{ Exception -> 0x0071 }
            r1 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r1
            goto L_0x0043
        L_0x0042:
            r4 = r8
        L_0x0043:
            com.mbridge.msdk.videocommon.d.b r10 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x0071 }
            com.mbridge.msdk.videocommon.d.a r10 = r10.b()     // Catch:{ Exception -> 0x0071 }
            if (r10 == 0) goto L_0x0051
            long r8 = r10.d()     // Catch:{ Exception -> 0x0071 }
        L_0x0051:
            if (r7 == 0) goto L_0x0071
            boolean r4 = r7.isSpareOffer(r8, r4)     // Catch:{ Exception -> 0x0071 }
            if (r4 == 0) goto L_0x006b
            r4 = 1
            r7.setSpareOfferFlag(r4)     // Catch:{ Exception -> 0x0071 }
            int r5 = r6.x()     // Catch:{ Exception -> 0x0071 }
            if (r5 != r4) goto L_0x0067
            r7.setCbt(r4)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0071
        L_0x0067:
            r7.setCbt(r0)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0071
        L_0x006b:
            r7.setSpareOfferFlag(r0)     // Catch:{ Exception -> 0x0071 }
            r7.setCbt(r0)     // Catch:{ Exception -> 0x0071 }
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.b.d.<init>(android.content.Context, boolean, com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.video.bt.module.b.h, java.lang.String, java.lang.String):void");
    }

    public final void a() {
        super.a();
        h hVar = this.a;
        if (hVar != null && !this.g) {
            this.g = true;
            hVar.a();
            this.a.a(2, this.d, this.c);
        }
    }

    public final void a(boolean z, com.mbridge.msdk.videocommon.b.c cVar) {
        super.a(z, cVar);
        h hVar = this.a;
        if (hVar != null && !this.i) {
            this.i = true;
            hVar.a(7, this.d, this.c);
            this.a.a(z, cVar);
        }
    }

    public final void a(boolean z, int i2) {
        super.a(z, i2);
        h hVar = this.a;
        if (hVar != null && !this.i) {
            hVar.a(z, i2);
        }
    }

    public final void a(String str) {
        super.a(str);
        h hVar = this.a;
        if (hVar != null && !this.h) {
            this.h = true;
            hVar.a(str);
            this.a.a(4, this.d, this.c);
        }
    }

    public final void a(boolean z, String str, String str2) {
        super.a(z, str, str2);
        h hVar = this.a;
        if (hVar != null) {
            hVar.a(z, str, str2);
        }
    }

    public final void b(String str, String str2) {
        super.b(str, str2);
        h hVar = this.a;
        if (hVar != null) {
            hVar.b(str, str2);
            this.a.a(6, str, str2);
        }
    }

    public final void a(String str, String str2) {
        super.a(str, str2);
        h hVar = this.a;
        if (hVar != null) {
            hVar.a(str, str2);
            this.a.a(5, str, str2);
        }
    }
}
