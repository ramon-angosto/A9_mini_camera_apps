package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.a.d;
import com.bytedance.sdk.openadsdk.core.a.e;
import com.bytedance.sdk.openadsdk.core.a.f;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.lang.reflect.Method;

/* compiled from: TTAdNativeImpl */
public class t implements TTAdNative {
    private final n a = m.c();
    private volatile Context b;

    public t(Context context) {
        this.b = context;
    }

    /* access modifiers changed from: private */
    public Context a() {
        if (this.b == null) {
            this.b = m.a();
        }
        return this.b;
    }

    public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
        c cVar = new c(feedAdListener);
        final c cVar2 = cVar;
        final AdSlot adSlot2 = adSlot;
        final TTAdNative.FeedAdListener feedAdListener2 = feedAdListener;
        AnonymousClass1 r0 = new g("loadFeedAd") {
            public void run() {
                if (!t.this.a((b) cVar2)) {
                    try {
                        t.this.b(adSlot2);
                        try {
                            Method a2 = w.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, TTAdNative.FeedAdListener.class);
                            if (a2 != null) {
                                a2.invoke((Object) null, new Object[]{t.this.a(), adSlot2, cVar2});
                            }
                        } catch (Throwable th) {
                            l.b("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                        }
                    } catch (Exception unused) {
                        l.c("TTAdNativeImpl", "embeded_ad", "Ad Slot not Valid, please check");
                        feedAdListener2.onError(-1, "Ad Slot not Valid, please check");
                    }
                }
            }
        };
        com.bytedance.sdk.openadsdk.tool.b.a(0, "native");
        a(r0, cVar, adSlot);
    }

    public void loadRewardVideoAd(final AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        final f fVar = new f(rewardVideoAdListener);
        a(new g("loadRewardVideoAd") {
            public void run() {
                if (!t.this.a((b) fVar)) {
                    try {
                        Method a2 = w.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, TTAdNative.RewardVideoAdListener.class);
                        if (a2 != null) {
                            a2.invoke((Object) null, new Object[]{t.this.a(), adSlot, fVar});
                        }
                    } catch (Throwable th) {
                        l.a("TTAdNativeImpl", "embeded_ad", "reward component maybe not exist, pls check1", th);
                    }
                }
            }
        }, fVar, adSlot);
    }

    public void loadFullScreenVideoAd(final AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        final d dVar = new d(fullScreenVideoAdListener);
        a(new g("loadFullScreenVideoAd") {
            public void run() {
                if (!t.this.a((b) dVar)) {
                    try {
                        Method a2 = w.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, TTAdNative.FullScreenVideoAdListener.class);
                        if (a2 != null) {
                            a2.invoke((Object) null, new Object[]{t.this.a(), adSlot, dVar});
                        }
                    } catch (Throwable th) {
                        l.a("TTAdNativeImpl", "embeded_ad", "reward component maybe not exist, pls check2", th);
                    }
                }
            }
        }, dVar, adSlot);
    }

    public void loadBannerExpressAd(final AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        final e eVar = new e(nativeExpressAdListener);
        a(new g("loadBannerExpressAd") {
            public void run() {
                if (!t.this.a((b) eVar)) {
                    adSlot.setNativeAdType(1);
                    adSlot.setDurationSlotType(1);
                    com.bytedance.sdk.openadsdk.tool.b.a(0, "banner");
                    com.bytedance.sdk.openadsdk.core.nativeexpress.c.a(t.this.a()).a(adSlot, 1, eVar, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
                }
            }
        }, eVar, adSlot);
    }

    public void loadAppOpenAd(AdSlot adSlot, TTAdNative.AppOpenAdListener appOpenAdListener, int i) {
        com.bytedance.sdk.openadsdk.core.a.b bVar = new com.bytedance.sdk.openadsdk.core.a.b(appOpenAdListener);
        final com.bytedance.sdk.openadsdk.core.a.b bVar2 = bVar;
        final AdSlot adSlot2 = adSlot;
        final int i2 = i;
        a(new g("loadSplashAd b") {
            public void run() {
                Method a2;
                try {
                    if (!t.this.a((b) bVar2) && (a2 = w.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, TTAdNative.AppOpenAdListener.class, Integer.TYPE)) != null) {
                        a2.invoke((Object) null, new Object[]{t.this.a(), adSlot2, bVar2, Integer.valueOf(i2)});
                    }
                } catch (Throwable th) {
                    l.b("TTAdNativeImpl", "embeded_ad", "open component maybe not exist, please check", th);
                }
            }
        }, bVar, adSlot);
    }

    private void a(AdSlot adSlot) {
        boolean z = true;
        q.a(adSlot.getImgAcceptedWidth() > 0, "Image material size must be set");
        if (adSlot.getImgAcceptedHeight() <= 0) {
            z = false;
        }
        q.a(z, "Image material size must be set");
    }

    /* access modifiers changed from: private */
    public void b(AdSlot adSlot) {
        a(adSlot);
        q.a(adSlot.getNativeAdType() == 0, "Request the type of non-native ad, please do not call the setNativeAdType() method");
    }

    /* access modifiers changed from: private */
    public boolean a(b bVar) {
        if (com.bytedance.sdk.openadsdk.core.settings.f.a()) {
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar.onError(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
        return true;
    }

    private void a(final g gVar, final b bVar, final AdSlot adSlot) {
        AnonymousClass6 r0 = new Runnable() {
            public void run() {
                int e = k.e();
                if (e == 0 || e == 2) {
                    l.c("TTAdNativeImpl", "embeded_ad", "please exec TTAdSdk.init before load ad");
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.onError(10000, "Please exec TTAdSdk.init before load ad");
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.c.c.a(adSlot);
                k.c().post(gVar);
            }
        };
        if (com.bytedance.sdk.openadsdk.l.w.a()) {
            com.bytedance.sdk.component.g.e.a().execute(r0);
        } else {
            r0.run();
        }
    }
}
