package com.mbridge.msdk.advanced.c;

import android.text.TextUtils;
import com.mbridge.msdk.advanced.a.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NativeAdvancedLoadListenerImpl */
public final class b implements a {
    private NativeAdvancedAdListener a;
    private c b;
    private String c = this.e.getUnitId();
    private String d;
    private MBridgeIds e;

    public b(c cVar, MBridgeIds mBridgeIds) {
        this.b = cVar;
        this.e = mBridgeIds;
    }

    public final void a(NativeAdvancedAdListener nativeAdvancedAdListener) {
        this.a = nativeAdvancedAdListener;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(CampaignEx campaignEx, int i) {
        c cVar;
        c cVar2 = this.b;
        if (cVar2 != null && cVar2.a() && campaignEx != null) {
            NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
            if (!(nativeAdvancedAdListener == null || this.b == null)) {
                nativeAdvancedAdListener.onLoadSuccessed(this.e);
            }
            this.b.a(false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            d.a(com.mbridge.msdk.foundation.controller.a.e().g(), (List<CampaignEx>) arrayList, this.c, campaignEx.isBidCampaign());
            if (i == 2 && (cVar = this.b) != null) {
                cVar.a(campaignEx, true);
            }
        }
    }

    public final void a(String str, int i) {
        c cVar = this.b;
        if (cVar != null && cVar.a()) {
            NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
            if (nativeAdvancedAdListener != null) {
                nativeAdvancedAdListener.onLoadFailed(this.e, str);
            }
            this.b.a(false);
            d.a(com.mbridge.msdk.foundation.controller.a.e().g(), str, this.c, !TextUtils.isEmpty(this.d));
        }
    }
}
