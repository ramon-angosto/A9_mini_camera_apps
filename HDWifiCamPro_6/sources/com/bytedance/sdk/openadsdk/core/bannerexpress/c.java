package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.multipro.b.a;

/* compiled from: PAGBannerVideoAdImpl */
public class c extends a {
    public c(Context context, n nVar, AdSlot adSlot) {
        super(context, nVar, adSlot);
    }

    public void a(Context context, n nVar, AdSlot adSlot) {
        this.a = new BannerExpressVideoView(context, nVar, adSlot);
        a(this.a.getCurView(), this.c);
    }

    public a g() {
        View bannerView = getBannerView();
        if (bannerView != null) {
            return ((BannerExpressVideoView) bannerView).getVideoModel();
        }
        return null;
    }
}
