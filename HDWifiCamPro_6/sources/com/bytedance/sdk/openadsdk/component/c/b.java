package com.bytedance.sdk.openadsdk.component.c;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: PAGInterstitialProxyListener */
public class b implements PAGInterstitialAdLoadListener {
    final PAGInterstitialAdLoadListener a;

    public b(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.a = pAGInterstitialAdLoadListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (b.this.a != null) {
                        b.this.a.onError(i, str);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void onAdLoaded(final PAGInterstitialAd pAGInterstitialAd) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (b.this.a != null) {
                        b.this.a.onAdLoaded(pAGInterstitialAd);
                    }
                }
            });
        }
    }
}
