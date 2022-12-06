package com.bytedance.sdk.openadsdk.a.c;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: PAGInterstitialAdListenerAdapter */
public class a implements PAGInterstitialAdLoadListener {
    /* access modifiers changed from: private */
    public PAGInterstitialAdLoadListener a;

    public a(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.a = pAGInterstitialAdLoadListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            if (str == null) {
                str = "Unknown exception.";
            }
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.onError(i, str);
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
                    if (a.this.a != null) {
                        a.this.a.onAdLoaded(pAGInterstitialAd);
                    }
                }
            });
        }
    }
}
