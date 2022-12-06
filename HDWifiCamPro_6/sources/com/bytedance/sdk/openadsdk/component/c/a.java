package com.bytedance.sdk.openadsdk.component.c;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.a.c.c;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;

/* compiled from: PAGInterstitialAdWrapper */
public class a implements c {
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener a;
    private PAGInterstitialAdInteractionListener b;

    public a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.a = fullScreenVideoAdInteractionListener;
        this.b = null;
    }

    public a(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.b = pAGInterstitialAdInteractionListener;
        this.a = null;
    }

    public void a() {
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.a;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdShow();
            return;
        }
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.b;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdShowed();
        }
    }

    public void b() {
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.a;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdVideoBarClick();
            return;
        }
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.b;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdClicked();
        }
    }

    public void c() {
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.a;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdClose();
            return;
        }
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.b;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdDismissed();
        }
    }

    public void d() {
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.a;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoComplete();
        } else {
            PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.b;
        }
    }

    public void e() {
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.a;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onSkippedVideo();
        } else {
            PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.b;
        }
    }
}
