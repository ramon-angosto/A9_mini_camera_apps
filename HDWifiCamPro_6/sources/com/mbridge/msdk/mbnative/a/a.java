package com.mbridge.msdk.mbnative.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.Campaign;
import java.util.ArrayList;
import java.util.List;

/* compiled from: APICache */
public final class a extends b<String, List<Campaign>> {
    private e a = e.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
    private int b;

    public final /* synthetic */ Object a(Object obj, int i) {
        String str = (String) obj;
        List<CampaignEx> a2 = this.a.a(str, i, 2, this.b);
        if (a2 == null) {
            return null;
        }
        if (a(a2, 2)) {
            this.a.a(str, 2, this.b);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a2);
        return arrayList;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        String str = (String) obj;
        List list = (List) obj2;
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
            this.a.a(str, 1, this.b, false);
            this.a.a(str, 2, this.b, false);
            for (int i = 0; i < list.size(); i++) {
                CampaignEx campaignEx = (CampaignEx) list.get(i);
                campaignEx.setCacheLevel(1);
                this.a.a(campaignEx, str, 1);
            }
        }
    }

    public final /* synthetic */ void a(Object obj, Object obj2, String str) {
        String str2 = (String) obj;
        List list = (List) obj2;
        boolean z = !TextUtils.isEmpty(str);
        if (!TextUtils.isEmpty(str2) && list != null && list.size() > 0) {
            this.a.a(str2, 1, this.b, z);
            this.a.a(str2, 2, this.b, z);
            for (int i = 0; i < list.size(); i++) {
                CampaignEx campaignEx = (CampaignEx) list.get(i);
                campaignEx.setCacheLevel(1);
                this.a.a(campaignEx, str2, 1);
            }
        }
    }

    public final /* synthetic */ Object b(Object obj, int i) {
        String str = (String) obj;
        List<CampaignEx> a2 = this.a.a(str, i, 1, this.b);
        if (a2 == null) {
            return null;
        }
        if (a(a2, 1)) {
            for (int i2 = 0; i2 < a2.size(); i2++) {
                CampaignEx campaignEx = a2.get(i2);
                campaignEx.setCacheLevel(2);
                this.a.a(campaignEx, str, 1);
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a2);
        return arrayList;
    }

    public a(int i) {
        this.b = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L_0x0066
            int r1 = r11.size()
            if (r1 <= 0) goto L_0x0066
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Object r11 = r11.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = (com.mbridge.msdk.foundation.entity.CampaignEx) r11
            long r3 = r11.getTimestamp()
            r5 = 0
            r7 = 1000(0x3e8, double:4.94E-321)
            r11 = 1
            if (r12 == r11) goto L_0x0041
            r9 = 2
            if (r12 == r9) goto L_0x0022
            goto L_0x0060
        L_0x0022:
            com.mbridge.msdk.b.b r12 = com.mbridge.msdk.b.b.a()
            com.mbridge.msdk.foundation.controller.a r5 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r5 = r5.h()
            com.mbridge.msdk.b.a r12 = r12.b(r5)
            if (r12 != 0) goto L_0x003c
            com.mbridge.msdk.b.b r12 = com.mbridge.msdk.b.b.a()
            com.mbridge.msdk.b.a r12 = r12.b()
        L_0x003c:
            long r5 = r12.v()
            goto L_0x005f
        L_0x0041:
            com.mbridge.msdk.b.b r12 = com.mbridge.msdk.b.b.a()
            com.mbridge.msdk.foundation.controller.a r5 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r5 = r5.h()
            com.mbridge.msdk.b.a r12 = r12.b(r5)
            if (r12 != 0) goto L_0x005b
            com.mbridge.msdk.b.b r12 = com.mbridge.msdk.b.b.a()
            com.mbridge.msdk.b.a r12 = r12.b()
        L_0x005b:
            long r5 = r12.B()
        L_0x005f:
            long r5 = r5 * r7
        L_0x0060:
            long r1 = r1 - r3
            int r12 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r12 <= 0) goto L_0x0066
            return r11
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.a.a.a(java.util.List, int):boolean");
    }

    public final void a(String str, Campaign campaign, String str2) {
        boolean z = !TextUtils.isEmpty(str2);
        if (campaign != null && !TextUtils.isEmpty(str)) {
            try {
                CampaignEx campaignEx = (CampaignEx) campaign;
                if (this.a.a(campaignEx.getId(), campaignEx.getTab(), str, campaignEx.getCacheLevel(), campaignEx.getType(), z)) {
                    this.a.a(campaignEx.getId(), str, campaignEx.getCacheLevel(), this.b, z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
