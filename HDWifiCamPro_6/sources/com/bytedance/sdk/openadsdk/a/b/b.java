package com.bytedance.sdk.openadsdk.a.b;

import android.content.Context;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.a.a;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.bytedance.sdk.openadsdk.core.m;
import java.lang.reflect.Method;

/* compiled from: PAGFeedAdLoadManager */
public class b extends a {
    public static b b() {
        return new b();
    }

    public void a(String str, PAGNativeRequest pAGNativeRequest, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        if (!a(str, (PAGRequest) pAGNativeRequest, (PAGLoadListener) pAGNativeAdLoadListener)) {
            final f fVar = new f(pAGNativeAdLoadListener);
            AdSlot.Builder withBid = new AdSlot.Builder().setCodeId(str).withBid(pAGNativeRequest != null ? pAGNativeRequest.getAdString() : null);
            a(withBid, pAGNativeRequest);
            final AdSlot build = withBid.setRequestExtraMap(pAGNativeRequest.getExtraInfo()).build();
            AnonymousClass1 r4 = new g("loadFeedAd") {
                public void run() {
                    if (!b.this.a(fVar)) {
                        try {
                            Method a2 = w.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, PAGNativeAdLoadListener.class);
                            if (a2 != null) {
                                a2.invoke((Object) null, new Object[]{m.a(), build, fVar});
                            }
                        } catch (Throwable th) {
                            l.b("FeedAdLoadManager", "feed component maybe not exist, pls check1", th);
                        }
                    }
                }
            };
            com.bytedance.sdk.openadsdk.tool.b.a(1, "native");
            a((g) r4, (PAGLoadListener) fVar, build);
        }
    }
}
