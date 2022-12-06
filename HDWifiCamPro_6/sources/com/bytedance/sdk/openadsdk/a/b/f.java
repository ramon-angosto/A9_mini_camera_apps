package com.bytedance.sdk.openadsdk.a.b;

import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: PAGNativeAdLoadListenerAdapter */
public class f implements PAGNativeAdLoadListener {
    /* access modifiers changed from: private */
    public final PAGNativeAdLoadListener a;

    public f(PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        this.a = pAGNativeAdLoadListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            if (str == null) {
                str = "Unknown exception.";
            }
            w.a((Runnable) new Runnable() {
                public void run() {
                    f.this.a.onError(i, str);
                }
            });
        }
    }

    /* renamed from: a */
    public void onAdLoaded(final PAGNativeAd pAGNativeAd) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    f.this.a.onAdLoaded(pAGNativeAd);
                }
            });
        }
    }
}
