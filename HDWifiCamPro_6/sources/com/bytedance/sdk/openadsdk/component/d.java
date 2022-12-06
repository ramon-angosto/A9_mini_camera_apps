package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAppOpenAd;
import com.bytedance.sdk.openadsdk.a.d.c;
import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: TTAppOpenAdImpl */
public class d implements TTAppOpenAd {
    private final a a;

    public d(Context context, n nVar, boolean z) {
        this.a = new a(context, nVar, z);
    }

    public void setOpenAdInteractionListener(TTAppOpenAd.AppOpenAdInteractionListener appOpenAdInteractionListener) {
        this.a.a((c) new b(appOpenAdInteractionListener));
    }

    public void showAppOpenAd(Activity activity) {
        this.a.show(activity);
    }
}
