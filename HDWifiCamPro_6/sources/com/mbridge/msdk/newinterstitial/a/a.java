package com.mbridge.msdk.newinterstitial.a;

import com.mbridge.msdk.newinterstitial.out.NewInterstitialListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;

/* compiled from: DecoratorInterstitialListener */
public final class a implements InterVideoOutListener {
    private NewInterstitialListener a;

    public a(NewInterstitialListener newInterstitialListener) {
        this.a = newInterstitialListener;
    }

    public final void onAdShow(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdShow(mBridgeIds);
        }
    }

    public final void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdClose(mBridgeIds, rewardInfo);
        }
    }

    public final void onShowFail(MBridgeIds mBridgeIds, String str) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onShowFail(mBridgeIds, str);
        }
    }

    public final void onVideoAdClicked(boolean z, MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdClicked(mBridgeIds);
        }
    }

    public final void onVideoComplete(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onVideoComplete(mBridgeIds);
        }
    }

    public final void onAdCloseWithIVReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onAdCloseWithNIReward(mBridgeIds, rewardInfo);
        }
    }

    public final void onEndcardShow(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onEndcardShow(mBridgeIds);
        }
    }

    public final void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onResourceLoadFail(mBridgeIds, str);
        }
    }

    public final void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onResourceLoadSuccess(mBridgeIds);
        }
    }

    public final void onLoadSuccess(MBridgeIds mBridgeIds) {
        NewInterstitialListener newInterstitialListener = this.a;
        if (newInterstitialListener != null) {
            newInterstitialListener.onLoadCampaignSuccess(mBridgeIds);
        }
    }
}
