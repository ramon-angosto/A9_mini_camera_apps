package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: RewardFullProxyListener */
public class j implements TTAdNative.FullScreenVideoAdListener, TTAdNative.RewardVideoAdListener {
    final TTAdNative.RewardVideoAdListener a;
    final TTAdNative.FullScreenVideoAdListener b;

    public j(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.a = rewardVideoAdListener;
        this.b = null;
    }

    public j(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.a = null;
        this.b = fullScreenVideoAdListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    j.this.a.onError(i, str);
                }
            });
        }
        if (this.b != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    j.this.b.onError(i, str);
                }
            });
        }
    }

    public void onFullScreenVideoAdLoad(final TTFullScreenVideoAd tTFullScreenVideoAd) {
        if (this.b != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    j.this.b.onFullScreenVideoAdLoad(tTFullScreenVideoAd);
                }
            });
        }
    }

    public void onFullScreenVideoCached() {
        if (this.b != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    j.this.b.onFullScreenVideoCached();
                }
            });
        }
    }

    public void onRewardVideoAdLoad(final TTRewardVideoAd tTRewardVideoAd) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    j.this.a.onRewardVideoAdLoad(tTRewardVideoAd);
                }
            });
        }
    }

    public void onRewardVideoCached() {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    j.this.a.onRewardVideoCached();
                }
            });
        }
    }
}
