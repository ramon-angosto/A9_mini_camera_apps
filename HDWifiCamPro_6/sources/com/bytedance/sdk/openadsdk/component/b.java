package com.bytedance.sdk.openadsdk.component;

import com.bytedance.sdk.openadsdk.TTAppOpenAd;
import com.bytedance.sdk.openadsdk.a.d.c;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;

/* compiled from: PAGAppOpenAdWrapper */
public class b implements c {
    private final PAGAppOpenAdInteractionListener a;
    private final TTAppOpenAd.AppOpenAdInteractionListener b;

    public b(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.a = pAGAppOpenAdInteractionListener;
        this.b = null;
    }

    public b(TTAppOpenAd.AppOpenAdInteractionListener appOpenAdInteractionListener) {
        this.b = appOpenAdInteractionListener;
        this.a = null;
    }

    public void a() {
        TTAppOpenAd.AppOpenAdInteractionListener appOpenAdInteractionListener = this.b;
        if (appOpenAdInteractionListener != null) {
            appOpenAdInteractionListener.onAdShow();
            return;
        }
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.a;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdShowed();
        }
    }

    public void b() {
        TTAppOpenAd.AppOpenAdInteractionListener appOpenAdInteractionListener = this.b;
        if (appOpenAdInteractionListener != null) {
            appOpenAdInteractionListener.onAdClicked();
            return;
        }
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.a;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdClicked();
        }
    }

    public void c() {
        TTAppOpenAd.AppOpenAdInteractionListener appOpenAdInteractionListener = this.b;
        if (appOpenAdInteractionListener != null) {
            appOpenAdInteractionListener.onAdSkip();
            return;
        }
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.a;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdDismissed();
        }
    }

    public void d() {
        TTAppOpenAd.AppOpenAdInteractionListener appOpenAdInteractionListener = this.b;
        if (appOpenAdInteractionListener != null) {
            appOpenAdInteractionListener.onAdCountdownToZero();
            return;
        }
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.a;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdDismissed();
        }
    }
}
