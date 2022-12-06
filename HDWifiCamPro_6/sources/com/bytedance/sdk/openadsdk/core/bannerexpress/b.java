package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;

/* compiled from: PAGBannerAdWrapper */
public class b implements PAGBannerAdWrapperListener {
    private PAGBannerAdInteractionListener a;
    private TTNativeExpressAd.ExpressAdInteractionListener b;

    public b(PAGBannerAdInteractionListener pAGBannerAdInteractionListener) {
        this.a = pAGBannerAdInteractionListener;
        this.b = null;
    }

    public b(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.a = null;
        this.b = expressAdInteractionListener;
    }

    public void onAdClicked(View view, int i) {
        PAGBannerAdInteractionListener pAGBannerAdInteractionListener = this.a;
        if (pAGBannerAdInteractionListener != null) {
            pAGBannerAdInteractionListener.onAdClicked();
        }
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.b;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onAdClicked(view, i);
        }
    }

    public void onAdShow(View view, int i) {
        PAGBannerAdInteractionListener pAGBannerAdInteractionListener = this.a;
        if (pAGBannerAdInteractionListener != null) {
            pAGBannerAdInteractionListener.onAdShowed();
        }
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.b;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onAdShow(view, i);
        }
    }

    public void onRenderFail(View view, String str, int i) {
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.b;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onRenderFail(view, str, i);
        }
    }

    public void onRenderSuccess(View view, float f, float f2) {
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.b;
        if (expressAdInteractionListener != null) {
            expressAdInteractionListener.onRenderSuccess(view, f, f2);
        }
    }

    public void onAdDismissed() {
        PAGBannerAdInteractionListener pAGBannerAdInteractionListener = this.a;
        if (pAGBannerAdInteractionListener != null) {
            pAGBannerAdInteractionListener.onAdDismissed();
        }
    }
}
