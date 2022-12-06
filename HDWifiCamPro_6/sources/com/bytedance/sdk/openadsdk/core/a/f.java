package com.bytedance.sdk.openadsdk.core.a;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: RewardVideoAdListenerAdapter */
public class f implements TTAdNative.RewardVideoAdListener {
    /* access modifiers changed from: private */
    public final TTAdNative.RewardVideoAdListener a;

    public f(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.a = rewardVideoAdListener;
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

    public void onRewardVideoAdLoad(final TTRewardVideoAd tTRewardVideoAd) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    f.this.a.onRewardVideoAdLoad(tTRewardVideoAd);
                }
            });
        }
    }

    public void onRewardVideoCached() {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    f.this.a.onRewardVideoCached();
                }
            });
        }
    }
}
