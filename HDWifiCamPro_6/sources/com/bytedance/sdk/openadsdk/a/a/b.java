package com.bytedance.sdk.openadsdk.a.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.a.a;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* compiled from: PAGBannerAdLoadManager */
public class b extends a {
    public void a(String str, PAGBannerRequest pAGBannerRequest, PAGBannerAdLoadListener pAGBannerAdLoadListener) {
        if (!a(str, (PAGRequest) pAGBannerRequest, (PAGLoadListener) pAGBannerAdLoadListener)) {
            AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
            a(codeId, pAGBannerRequest);
            if (!TextUtils.isEmpty(pAGBannerRequest.getAdString())) {
                codeId.withBid(pAGBannerRequest.getAdString());
            }
            PAGBannerSize pAGBannerSize = null;
            if (pAGBannerRequest != null) {
                pAGBannerSize = pAGBannerRequest.getAdSize();
            }
            if (pAGBannerSize != null) {
                codeId.setExpressViewAcceptedSize((float) pAGBannerSize.getWidth(), (float) pAGBannerSize.getHeight());
            }
            final AdSlot build = codeId.setRequestExtraMap(pAGBannerRequest.getExtraInfo()).build();
            final a aVar = new a(pAGBannerAdLoadListener);
            a((g) new g("loadBannerExpressAd") {
                public void run() {
                    if (!b.this.a(aVar)) {
                        build.setNativeAdType(1);
                        build.setDurationSlotType(1);
                        com.bytedance.sdk.openadsdk.tool.b.a(1, "banner");
                        c.a(b.this.a()).a(build, 1, aVar, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
                    }
                }
            }, (PAGLoadListener) aVar, build);
        }
    }
}
