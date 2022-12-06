package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import java.util.List;
import java.util.Map;

/* compiled from: TTBannerExpressAdImpl */
public class d extends l {
    final a a;

    public d(Context context, n nVar, AdSlot adSlot) {
        this.a = a(context, nVar, adSlot);
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    /* access modifiers changed from: package-private */
    public a a(Context context, n nVar, AdSlot adSlot) {
        return new a(context, nVar, adSlot);
    }

    public View getExpressAdView() {
        a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        return aVar.getBannerView();
    }

    public int getImageMode() {
        a aVar = this.a;
        if (aVar == null) {
            return -1;
        }
        return aVar.b();
    }

    public List<FilterWord> getFilterWords() {
        a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(expressAdInteractionListener);
        }
    }

    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(adInteractionListener);
        }
    }

    public int getInteractionType() {
        a aVar = this.a;
        if (aVar == null) {
            return -1;
        }
        return aVar.d();
    }

    public void render() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(activity, dislikeInteractionCallback);
        }
    }

    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(tTDislikeDialogAbstract);
        }
    }

    public Map<String, Object> getMediaExtraInfo() {
        a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        return aVar.getMediaExtraInfo();
    }

    public String getAdCreativeToken() {
        a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        return aVar.f();
    }

    public void setSlideIntervalTime(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void win(Double d) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.win(d);
        }
    }

    public void loss(Double d, String str, String str2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.loss(d, str, str2);
        }
    }

    public void setPrice(Double d) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setPrice(d);
        }
    }
}
