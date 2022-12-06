package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.a.c.c;
import com.bytedance.sdk.openadsdk.component.c.a;
import com.bytedance.sdk.openadsdk.core.model.n;
import java.util.Map;

/* compiled from: TTFullScreenVideoAdImpl */
class o implements TTFullScreenVideoAd {
    private e a;

    o(Context context, n nVar, AdSlot adSlot) {
        this.a = new e(context, nVar, adSlot);
    }

    public e a() {
        return this.a;
    }

    public void a(boolean z) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a(z);
        }
    }

    public void a(String str) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a(str);
        }
    }

    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        a aVar = new a(fullScreenVideoAdInteractionListener);
        e eVar = this.a;
        if (eVar != null) {
            eVar.a((c) aVar);
        }
    }

    public int getInteractionType() {
        e eVar = this.a;
        if (eVar != null) {
            return eVar.a();
        }
        return -1;
    }

    public void showFullScreenVideoAd(Activity activity) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.show(activity);
        }
    }

    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a(activity, ritScenes, str);
        }
    }

    public void setShowDownLoadBar(boolean z) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.b(z);
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        e eVar = this.a;
        if (eVar != null) {
            return eVar.getMediaExtraInfo();
        }
        return null;
    }

    public int getFullVideoAdType() {
        e eVar = this.a;
        if (eVar != null) {
            return eVar.b();
        }
        return -1;
    }

    public String getAdCreativeToken() {
        e eVar = this.a;
        return eVar != null ? eVar.c() : "";
    }

    public void win(Double d) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.win(d);
        }
    }

    public void loss(Double d, String str, String str2) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.loss(d, str, str2);
        }
    }

    public void setPrice(Double d) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.setPrice(d);
        }
    }
}
