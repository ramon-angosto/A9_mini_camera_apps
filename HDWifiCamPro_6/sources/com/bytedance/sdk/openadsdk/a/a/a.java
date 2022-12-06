package com.bytedance.sdk.openadsdk.a.a;

import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: PAGBannerAdListenerAdapter */
public class a implements PAGBannerAdLoadListener {
    /* access modifiers changed from: private */
    public final PAGBannerAdLoadListener a;

    public a(PAGBannerAdLoadListener pAGBannerAdLoadListener) {
        this.a = pAGBannerAdLoadListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            if (str == null) {
                str = "Unknown exception.";
            }
            w.a((Runnable) new Runnable() {
                public void run() {
                    a.this.a.onError(i, str);
                }
            });
        }
    }

    /* renamed from: a */
    public void onAdLoaded(final PAGBannerAd pAGBannerAd) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    a.this.a.onAdLoaded(pAGBannerAd);
                }
            });
        }
    }
}
