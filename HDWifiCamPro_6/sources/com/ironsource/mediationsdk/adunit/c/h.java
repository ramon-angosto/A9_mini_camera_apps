package com.ironsource.mediationsdk.adunit.c;

import com.ironsource.mediationsdk.C0151d;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdInteractionAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.d.a;
import com.ironsource.mediationsdk.adunit.d.c;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;

public final class h extends f<c> {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h(java.util.List<com.ironsource.mediationsdk.model.NetworkSettings> r18, com.ironsource.mediationsdk.model.o r19, java.lang.String r20, boolean r21, java.util.Set<com.ironsource.mediationsdk.impressionData.ImpressionDataListener> r22, com.ironsource.mediationsdk.IronSourceSegment r23) {
        /*
            r17 = this;
            r0 = r19
            com.ironsource.mediationsdk.adunit.c.a r10 = new com.ironsource.mediationsdk.adunit.c.a
            com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO
            com.ironsource.mediationsdk.utils.c r4 = r0.l
            int r5 = r0.c
            int r6 = r0.e
            int r7 = r0.j
            int r8 = r0.i
            if (r21 == 0) goto L_0x0016
            com.ironsource.mediationsdk.adunit.c.b.a$a r2 = com.ironsource.mediationsdk.adunit.c.b.a.C0091a.MANUAL
        L_0x0014:
            r12 = r2
            goto L_0x0022
        L_0x0016:
            com.ironsource.mediationsdk.utils.c r2 = r0.l
            boolean r2 = r2.n
            if (r2 == 0) goto L_0x001f
            com.ironsource.mediationsdk.adunit.c.b.a$a r2 = com.ironsource.mediationsdk.adunit.c.b.a.C0091a.AUTOMATIC_LOAD_WHILE_SHOW
            goto L_0x0014
        L_0x001f:
            com.ironsource.mediationsdk.adunit.c.b.a$a r2 = com.ironsource.mediationsdk.adunit.c.b.a.C0091a.AUTOMATIC_LOAD_AFTER_CLOSE
            goto L_0x0014
        L_0x0022:
            com.ironsource.mediationsdk.adunit.c.b.a r9 = new com.ironsource.mediationsdk.adunit.c.b.a
            com.ironsource.mediationsdk.utils.c r2 = r0.l
            long r13 = r2.k
            com.ironsource.mediationsdk.utils.c r0 = r0.l
            long r2 = r0.j
            r11 = r9
            r15 = r2
            r11.<init>(r12, r13, r15)
            r0 = r10
            r2 = r20
            r3 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r17
            r1 = r22
            r2 = r23
            r0.<init>(r10, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.c.h.<init>(java.util.List, com.ironsource.mediationsdk.model.o, java.lang.String, boolean, java.util.Set, com.ironsource.mediationsdk.IronSourceSegment):void");
    }

    private static BaseAdInteractionAdapter<?, AdapterAdRewardListener> b(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        BaseAdAdapter<?, ?> b = C0151d.a().b(networkSettings, ad_unit);
        if (b == null || !(b instanceof BaseAdInteractionAdapter)) {
            return null;
        }
        try {
            return (BaseAdInteractionAdapter) b;
        } catch (Exception e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception creating adapter - " + e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ BaseAdAdapter a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        return b(networkSettings, ad_unit);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ com.ironsource.mediationsdk.adunit.d.a.c a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i, String str) {
        return new c(new a(IronSource.AD_UNIT.REWARDED_VIDEO, this.m.b, i, this.h, str, this.f, this.g, networkSettings, this.m.g), (BaseAdInteractionAdapter) baseAdAdapter, this);
    }
}
