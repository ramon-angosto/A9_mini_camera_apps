package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.multipro.b.a;

/* compiled from: TTBannerExpressVideoAdImpl */
public class e extends d {
    public e(Context context, n nVar, AdSlot adSlot) {
        super(context, nVar, adSlot);
    }

    /* access modifiers changed from: package-private */
    public a a(Context context, n nVar, AdSlot adSlot) {
        return new c(context, nVar, adSlot);
    }

    public a getVideoModel() {
        if (!(this.a instanceof c)) {
            return null;
        }
        return ((c) this.a).g();
    }
}
