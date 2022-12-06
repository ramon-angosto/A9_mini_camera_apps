package com.mbridge.msdk.splash.d;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.a.b;

/* compiled from: SplashShowListenerImpl */
public final class d {
    private MBSplashShowListener a;
    private CampaignEx b;
    private c c;

    public d(c cVar, MBSplashShowListener mBSplashShowListener, CampaignEx campaignEx) {
        this.c = cVar;
        this.a = mBSplashShowListener;
        this.b = campaignEx;
    }

    public final void a(MBridgeIds mBridgeIds) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("load_to=");
        stringBuffer.append(this.c.b());
        stringBuffer.append("&");
        stringBuffer.append("allow_skip=");
        stringBuffer.append(this.c.c() ? 1 : 0);
        stringBuffer.append("&");
        stringBuffer.append("countdown=");
        stringBuffer.append(this.c.d());
        stringBuffer.append("&");
        com.mbridge.msdk.foundation.same.report.d.a(a.e().g(), this.b, mBridgeIds.getUnitId(), stringBuffer.toString());
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowSuccessed(mBridgeIds);
        }
    }

    public final void a(MBridgeIds mBridgeIds, String str) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a = false;
        }
        com.mbridge.msdk.foundation.same.report.d.b(a.e().g(), this.b, mBridgeIds.getUnitId(), str);
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(mBridgeIds, str);
        }
    }

    public final void b(MBridgeIds mBridgeIds) {
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onAdClicked(mBridgeIds);
        }
    }

    public final void a(MBridgeIds mBridgeIds, int i) {
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onDismiss(mBridgeIds, i);
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.a = false;
        }
        if (i == 6 || i == 4 || i == 5) {
            CampaignEx campaignEx = this.b;
            String unitId = mBridgeIds.getUnitId();
            b bVar = null;
            if (campaignEx != null) {
                try {
                    b c2 = b.a().b(unitId).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).c(campaignEx.getId());
                    bVar = c2.e(campaignEx.getCreativeId() + "").a(campaignEx.isBidCampaign());
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            com.mbridge.msdk.splash.e.a.a(bVar, unitId, i);
        }
    }

    public final void a(MBridgeIds mBridgeIds, long j) {
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onAdTick(mBridgeIds, j);
        }
    }

    public final void a(MBridgeIds mBridgeIds, int i, int i2, int i3) {
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayStart(mBridgeIds);
        }
        CampaignEx campaignEx = this.b;
        String unitId = mBridgeIds.getUnitId();
        try {
            com.mbridge.msdk.foundation.same.report.d.a(a.e().g(), campaignEx, unitId, "flb_size=" + i2 + "x" + i + "&flb_type=" + i3 + "&");
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
