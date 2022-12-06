package com.bytedance.sdk.openadsdk.core.a;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppOpenAd;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: AppOpenAdListenerAdapter */
public class b implements TTAdNative.AppOpenAdListener {
    /* access modifiers changed from: private */
    public final TTAdNative.AppOpenAdListener a;

    public b(TTAdNative.AppOpenAdListener appOpenAdListener) {
        this.a = appOpenAdListener;
    }

    public void onAppOpenAdLoaded(final TTAppOpenAd tTAppOpenAd) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    b.this.a.onAppOpenAdLoaded(tTAppOpenAd);
                }
            });
        }
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            if (str == null) {
                str = "Unknown exception.";
            }
            w.a((Runnable) new Runnable() {
                public void run() {
                    b.this.a.onError(i, str);
                }
            });
        }
    }
}
