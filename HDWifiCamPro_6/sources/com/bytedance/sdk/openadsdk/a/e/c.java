package com.bytedance.sdk.openadsdk.a.e;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: PARewardedAdListenerAdapter */
public class c implements PAGRewardedAdLoadListener {
    /* access modifiers changed from: private */
    public PAGRewardedAdLoadListener a;

    public c(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.a = pAGRewardedAdLoadListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            if (str == null) {
                str = "Unknown exception.";
            }
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.a != null) {
                        c.this.a.onError(i, str);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void onAdLoaded(final PAGRewardedAd pAGRewardedAd) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.a != null) {
                        c.this.a.onAdLoaded(pAGRewardedAd);
                    }
                }
            });
        }
    }
}
