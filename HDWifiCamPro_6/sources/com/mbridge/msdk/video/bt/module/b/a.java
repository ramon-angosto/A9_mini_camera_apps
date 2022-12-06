package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;

/* compiled from: DecoratorRewardVideoListener */
public final class a implements InterVideoOutListener {
    private g a;

    public final void onAdCloseWithIVReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
    }

    public a(g gVar) {
        this.a = gVar;
    }

    public final void onAdShow(MBridgeIds mBridgeIds) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onAdShow(mBridgeIds);
        }
    }

    public final void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onAdClose(mBridgeIds, rewardInfo);
        }
    }

    public final void onShowFail(MBridgeIds mBridgeIds, String str) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onShowFail(mBridgeIds, str);
        }
    }

    public final void onVideoAdClicked(boolean z, MBridgeIds mBridgeIds) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onVideoAdClicked(mBridgeIds);
        }
    }

    public final void onVideoComplete(MBridgeIds mBridgeIds) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onVideoComplete(mBridgeIds);
        }
    }

    public final void onEndcardShow(MBridgeIds mBridgeIds) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onEndcardShow(mBridgeIds);
        }
    }

    public final void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onVideoLoadFail(mBridgeIds, str);
        }
    }

    public final void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onVideoLoadSuccess(mBridgeIds);
        }
    }

    public final void onLoadSuccess(MBridgeIds mBridgeIds) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onLoadSuccess(mBridgeIds);
        }
    }
}
