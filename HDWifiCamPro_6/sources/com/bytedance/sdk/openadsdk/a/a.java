package com.bytedance.sdk.openadsdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.settings.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* compiled from: AdLoadBaseManager */
public abstract class a {
    protected volatile Context a;

    /* access modifiers changed from: protected */
    public Context a() {
        if (this.a == null) {
            this.a = m.a();
        }
        return this.a;
    }

    /* access modifiers changed from: protected */
    public boolean a(PAGLoadListener pAGLoadListener) {
        if (f.a()) {
            return false;
        }
        if (pAGLoadListener == null) {
            return true;
        }
        pAGLoadListener.onError(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(g gVar, PAGLoadListener pAGLoadListener, AdSlot adSlot) {
        if (!TTAdSdk.isInitSuccess()) {
            l.e("AdLoadBaseManager", "please exec TTAdSdk.init before load ad");
            if (pAGLoadListener != null) {
                pAGLoadListener.onError(10000, "Please exec TTAdSdk.init before load ad");
                return;
            }
            return;
        }
        c.a(adSlot);
        e.b(5).execute(gVar);
    }

    /* access modifiers changed from: protected */
    public void a(AdSlot.Builder builder, PAGRequest pAGRequest) {
        Map<String, Object> extraInfo;
        if (PAGSdk.isInitSuccess() && pAGRequest != null && builder != null && (extraInfo = pAGRequest.getExtraInfo()) != null) {
            if (extraInfo.containsKey("ad_id") && extraInfo.get("ad_id") != null) {
                builder.setAdId(extraInfo.get("ad_id").toString());
            }
            if (extraInfo.containsKey(CampaignEx.JSON_KEY_CREATIVE_ID) && extraInfo.get(CampaignEx.JSON_KEY_CREATIVE_ID) != null) {
                builder.setCreativeId(extraInfo.get(CampaignEx.JSON_KEY_CREATIVE_ID).toString());
            }
            if (extraInfo.containsKey("ext") && extraInfo.get("ext") != null) {
                builder.setExt(extraInfo.get("ext").toString());
            }
            if (extraInfo.containsKey("media_extra") && extraInfo.get("media_extra") != null) {
                builder.setMediaExtra(extraInfo.get("media_extra").toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(String str, PAGRequest pAGRequest, PAGLoadListener pAGLoadListener) {
        if (TextUtils.isEmpty(str) && pAGLoadListener != null) {
            pAGLoadListener.onError(1, PAGErrorCode.PAGAdErrorCodeSlotIdNULLMsg);
            return true;
        } else if (pAGRequest != null || pAGLoadListener == null) {
            return false;
        } else {
            pAGLoadListener.onError(2, PAGErrorCode.PAGAdErrorCodeRequestNULLMsg);
            return true;
        }
    }
}
