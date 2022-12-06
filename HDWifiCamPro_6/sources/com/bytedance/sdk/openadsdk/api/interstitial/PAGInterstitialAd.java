package com.bytedance.sdk.openadsdk.api.interstitial;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.a.c.b;
import com.bytedance.sdk.openadsdk.api.PAGClientBidding;
import com.bytedance.sdk.openadsdk.api.PangleAd;

public abstract class PAGInterstitialAd implements PAGClientBidding, PangleAd {
    public abstract void setAdInteractionListener(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener);

    public abstract void show(Activity activity);

    public static void loadAd(String str, PAGInterstitialRequest pAGInterstitialRequest, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        new b().a(str, pAGInterstitialRequest, pAGInterstitialAdLoadListener);
    }
}
