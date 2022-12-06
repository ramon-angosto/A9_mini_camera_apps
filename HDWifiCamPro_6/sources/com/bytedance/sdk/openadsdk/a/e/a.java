package com.bytedance.sdk.openadsdk.a.e;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import java.lang.reflect.Method;

/* compiled from: PAGRewardedAdLoadManager */
public class a extends com.bytedance.sdk.openadsdk.a.a {
    public void a(String str, PAGRewardedRequest pAGRewardedRequest, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (!a(str, (PAGRequest) pAGRewardedRequest, (PAGLoadListener) pAGRewardedAdLoadListener)) {
            AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
            if (!TextUtils.isEmpty(pAGRewardedRequest.getAdString())) {
                codeId.withBid(pAGRewardedRequest.getAdString());
            }
            a(codeId, pAGRewardedRequest);
            final AdSlot build = codeId.setRequestExtraMap(pAGRewardedRequest.getExtraInfo()).build();
            final c cVar = new c(pAGRewardedAdLoadListener);
            a((g) new g("loadRewardVideoAd") {
                public void run() {
                    if (!a.this.a(cVar)) {
                        try {
                            Method a2 = w.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, PAGRewardedAdLoadListener.class);
                            if (a2 != null) {
                                a2.invoke((Object) null, new Object[]{a.this.a(), build, cVar});
                            }
                        } catch (Throwable th) {
                            l.b("PAGRewardedAdLoadManager", "reward component maybe not exist, pls check1", th);
                        }
                    }
                }
            }, (PAGLoadListener) cVar, build);
        }
    }
}
