package com.bytedance.sdk.openadsdk.api.banner;

import android.view.View;
import com.bytedance.sdk.openadsdk.a.a.b;
import com.bytedance.sdk.openadsdk.api.PAGClientBidding;
import com.bytedance.sdk.openadsdk.api.PangleAd;

public abstract class PAGBannerAd implements PAGClientBidding, PangleAd {
    public abstract void destroy();

    public abstract View getBannerView();

    public abstract void setAdInteractionListener(PAGBannerAdInteractionListener pAGBannerAdInteractionListener);

    public static void loadAd(String str, PAGBannerRequest pAGBannerRequest, PAGBannerAdLoadListener pAGBannerAdLoadListener) {
        new b().a(str, pAGBannerRequest, pAGBannerAdLoadListener);
    }
}
