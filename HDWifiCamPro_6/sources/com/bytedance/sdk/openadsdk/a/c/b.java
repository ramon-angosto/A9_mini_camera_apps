package com.bytedance.sdk.openadsdk.a.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.a.a;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import java.lang.reflect.Method;

/* compiled from: PAGInterstitialAdLoadManager */
public class b extends a {
    public void a(String str, PAGInterstitialRequest pAGInterstitialRequest, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        if (!a(str, (PAGRequest) pAGInterstitialRequest, (PAGLoadListener) pAGInterstitialAdLoadListener)) {
            AdSlot.Builder codeId = new AdSlot.Builder().setRequestExtraMap(pAGInterstitialRequest.getExtraInfo()).setCodeId(str);
            a(codeId, pAGInterstitialRequest);
            if (!TextUtils.isEmpty(pAGInterstitialRequest.getAdString())) {
                codeId.withBid(pAGInterstitialRequest.getAdString());
            }
            final AdSlot build = codeId.build();
            final a aVar = new a(pAGInterstitialAdLoadListener);
            a((g) new g("loadInterstitialAd") {
                public void run() {
                    if (!b.this.a(aVar)) {
                        try {
                            Method a2 = w.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, PAGInterstitialAdLoadListener.class);
                            if (a2 != null) {
                                a2.invoke((Object) null, new Object[]{b.this.a(), build, aVar});
                            }
                        } catch (Throwable th) {
                            l.b("PAGInterstitialAdLoadManager", "reward component maybe not exist, pls check2", th);
                        }
                    }
                }
            }, (PAGLoadListener) aVar, build);
        }
    }
}
