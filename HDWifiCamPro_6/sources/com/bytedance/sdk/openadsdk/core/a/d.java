package com.bytedance.sdk.openadsdk.core.a;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: FullScreenVideoAdListenerAdapter */
public class d implements TTAdNative.FullScreenVideoAdListener {
    final TTAdNative.FullScreenVideoAdListener a;

    public d(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.a = fullScreenVideoAdListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            if (str == null) {
                str = "Unknown exception.";
            }
            w.a((Runnable) new Runnable() {
                public void run() {
                    d.this.a.onError(i, str);
                }
            });
        }
    }

    public void onFullScreenVideoAdLoad(final TTFullScreenVideoAd tTFullScreenVideoAd) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    d.this.a.onFullScreenVideoAdLoad(tTFullScreenVideoAd);
                }
            });
        }
    }

    public void onFullScreenVideoCached() {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    d.this.a.onFullScreenVideoCached();
                }
            });
        }
    }
}
