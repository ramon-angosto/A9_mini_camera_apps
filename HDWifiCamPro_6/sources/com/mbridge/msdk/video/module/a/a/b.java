package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

/* compiled from: ContainerViewDefaultListener */
public final class b extends d {
    private MBridgeVideoView j;
    private MBridgeContainerView k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, c cVar, a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i, boolean z) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i, z);
        MBridgeVideoView mBridgeVideoView2 = mBridgeVideoView;
        MBridgeContainerView mBridgeContainerView2 = mBridgeContainerView;
        this.j = mBridgeVideoView2;
        this.k = mBridgeContainerView2;
        if (mBridgeVideoView2 == null || mBridgeContainerView2 == null) {
            this.a = false;
        }
    }

    public final void a(int i, Object obj) {
        if (this.a) {
            if (i == 8) {
                MBridgeContainerView mBridgeContainerView = this.k;
                if (mBridgeContainerView == null) {
                    MBridgeVideoView mBridgeVideoView = this.j;
                    if (mBridgeVideoView != null) {
                        mBridgeVideoView.showAlertView();
                    }
                } else if (!mBridgeContainerView.showAlertWebView()) {
                    MBridgeVideoView mBridgeVideoView2 = this.j;
                    if (mBridgeVideoView2 != null) {
                        mBridgeVideoView2.showAlertView();
                    }
                } else {
                    MBridgeVideoView mBridgeVideoView3 = this.j;
                    if (mBridgeVideoView3 != null) {
                        mBridgeVideoView3.alertWebViewShowed();
                    }
                }
            } else if (!(i == 103 || i == 105)) {
                if (i == 107) {
                    this.k.showVideoClickView(-1);
                    this.j.setCover(false);
                    this.j.setMiniEndCardState(false);
                    this.j.videoOperate(1);
                } else if (i == 112) {
                    this.j.setCover(true);
                    this.j.setMiniEndCardState(true);
                    this.j.videoOperate(2);
                } else if (i == 115) {
                    this.k.resizeMiniCard(this.j.getBorderViewWidth(), this.j.getBorderViewHeight(), this.j.getBorderViewRadius());
                } else if (i != 100) {
                }
            }
        }
        super.a(i, obj);
    }
}
