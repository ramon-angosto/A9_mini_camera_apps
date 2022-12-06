package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: PAGRewardProxyListener */
public class f implements PAGRewardedAdLoadListener {
    final PAGRewardedAdLoadListener a;

    public f(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.a = pAGRewardedAdLoadListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (f.this.a != null) {
                        f.this.a.onError(i, str);
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
                    if (f.this.a != null) {
                        f.this.a.onAdLoaded(pAGRewardedAd);
                    }
                }
            });
        }
    }
}
