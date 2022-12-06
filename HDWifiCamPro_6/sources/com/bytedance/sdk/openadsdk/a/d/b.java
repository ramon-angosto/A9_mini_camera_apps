package com.bytedance.sdk.openadsdk.a.d;

import android.content.Context;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.a.a;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import java.lang.reflect.Method;

/* compiled from: PAGAppOpenAdLoadManager */
public class b extends a {
    /* access modifiers changed from: private */
    public int b;

    public void a(String str, PAGAppOpenRequest pAGAppOpenRequest, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
        if (!a(str, (PAGRequest) pAGAppOpenRequest, (PAGLoadListener) pAGAppOpenAdLoadListener)) {
            AdSlot.Builder builder = new AdSlot.Builder();
            a(builder, pAGAppOpenRequest);
            final AdSlot build = builder.setCodeId(str).setRequestExtraMap(pAGAppOpenRequest.getExtraInfo()).build();
            if (pAGAppOpenRequest != null) {
                this.b = pAGAppOpenRequest.getTimeout();
            }
            final a aVar = new a(pAGAppOpenAdLoadListener);
            a((g) new g("loadSplashAd") {
                public void run() {
                    Method a2;
                    try {
                        if (!b.this.a(aVar) && (a2 = w.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, PAGAppOpenAdLoadListener.class, Integer.TYPE)) != null) {
                            a2.invoke((Object) null, new Object[]{b.this.a(), build, aVar, Integer.valueOf(b.this.b)});
                        }
                    } catch (Throwable th) {
                        l.c("PAGAppOpenAdLoadManager", "open component maybe not exist, please check", th);
                    }
                }
            }, (PAGLoadListener) aVar, build);
        }
    }
}
