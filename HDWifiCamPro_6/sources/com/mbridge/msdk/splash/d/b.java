package com.mbridge.msdk.splash.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.b.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SplashLoadListenerImpl */
public final class b implements a {
    private MBSplashLoadListener a;
    private c b;
    private String c;
    private String d;
    private MBridgeIds e;

    public b(c cVar, MBridgeIds mBridgeIds) {
        this.b = cVar;
        this.e = mBridgeIds;
        MBridgeIds mBridgeIds2 = this.e;
        if (mBridgeIds2 != null) {
            this.c = mBridgeIds2.getUnitId();
        }
    }

    public final void a(MBSplashLoadListener mBSplashLoadListener) {
        this.a = mBSplashLoadListener;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(CampaignEx campaignEx, int i) {
        c cVar;
        c cVar2 = this.b;
        if (cVar2 != null && cVar2.a() && campaignEx != null) {
            MBSplashLoadListener mBSplashLoadListener = this.a;
            if (mBSplashLoadListener != null) {
                mBSplashLoadListener.onLoadSuccessed(this.e, i);
                this.a.isSupportZoomOut(this.e, campaignEx.getFlb() == 1);
            }
            this.b.a(false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            d.a(com.mbridge.msdk.foundation.controller.a.e().g(), (List<CampaignEx>) arrayList, this.c, campaignEx.isBidCampaign());
            if (i == 2 && (cVar = this.b) != null) {
                cVar.a(campaignEx, 0, true);
            }
        }
    }

    public final void a(String str, int i) {
        c cVar = this.b;
        if (cVar != null && cVar.a()) {
            MBSplashLoadListener mBSplashLoadListener = this.a;
            if (mBSplashLoadListener != null) {
                mBSplashLoadListener.onLoadFailed(this.e, str, i);
            }
            this.b.a(false);
            d.a(com.mbridge.msdk.foundation.controller.a.e().g(), str, this.c, !TextUtils.isEmpty(this.d));
        }
    }
}
