package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.a.e.b;
import com.bytedance.sdk.openadsdk.core.model.n;
import java.util.Map;

/* compiled from: TTRewardVideoAdImpl */
class p implements TTRewardVideoAd {
    private g a;

    p(Context context, n nVar, AdSlot adSlot) {
        this.a = new g(context, nVar, adSlot);
    }

    public g a() {
        return this.a;
    }

    public void a(String str) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(str);
        }
    }

    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        h hVar = new h(rewardAdInteractionListener);
        g gVar = this.a;
        if (gVar != null) {
            gVar.a((b) hVar);
        }
    }

    public int getInteractionType() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.a();
        }
        return -1;
    }

    public void setShowDownLoadBar(boolean z) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    public int getRewardVideoAdType() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar.b();
        }
        return -1;
    }

    public String getAdCreativeToken() {
        g gVar = this.a;
        return gVar != null ? gVar.c() : "";
    }

    public void showRewardVideoAd(Activity activity) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.show(activity);
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        g gVar = this.a;
        if (gVar == null) {
            return null;
        }
        gVar.getMediaExtraInfo();
        return null;
    }

    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.a(activity, ritScenes, str);
        }
    }

    public void win(Double d) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.win(d);
        }
    }

    public void loss(Double d, String str, String str2) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.loss(d, str, str2);
        }
    }

    public void setPrice(Double d) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.setPrice(d);
        }
    }
}
