package com.bytedance.sdk.openadsdk.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: PAGNativeFeedAdWrapperListenerImpl */
public class h implements g {
    /* access modifiers changed from: private */
    public PAGNativeAdInteractionListener a;
    /* access modifiers changed from: private */
    public TTNativeAd.AdInteractionListener b;
    /* access modifiers changed from: private */
    public TTNativeAd c;

    public h(PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        this.a = pAGNativeAdInteractionListener;
    }

    public h(TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        this.b = adInteractionListener;
        this.c = tTNativeAd;
    }

    public void a(final View view, PAGNativeAd pAGNativeAd) {
        w.a((Runnable) new Runnable() {
            public void run() {
                if (h.this.a != null) {
                    h.this.a.onAdClicked();
                }
                if (h.this.b != null) {
                    h.this.b.onAdClicked(view, h.this.c);
                }
            }
        });
    }

    public void b(final View view, PAGNativeAd pAGNativeAd) {
        w.a((Runnable) new Runnable() {
            public void run() {
                if (h.this.a != null) {
                    h.this.a.onAdClicked();
                }
                if (h.this.b != null) {
                    h.this.b.onAdCreativeClick(view, h.this.c);
                }
            }
        });
    }

    public void a(PAGNativeAd pAGNativeAd) {
        w.a((Runnable) new Runnable() {
            public void run() {
                if (h.this.a != null) {
                    h.this.a.onAdShowed();
                }
                if (h.this.b != null) {
                    h.this.b.onAdShow(h.this.c);
                }
            }
        });
    }

    public void a() {
        w.a((Runnable) new Runnable() {
            public void run() {
                if (h.this.a != null) {
                    h.this.a.onAdDismissed();
                }
            }
        });
    }

    public boolean b() {
        return this.a != null;
    }
}
