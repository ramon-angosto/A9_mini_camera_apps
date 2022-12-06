package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.component.e;
import com.bytedance.sdk.openadsdk.component.g.a;

public class TTC2Proxy {
    private TTC2Proxy() {
    }

    public static void load(Context context, AdSlot adSlot, TTAdNative.AppOpenAdListener appOpenAdListener, int i) {
        adSlot.setDurationSlotType(3);
        e.a(context).a(adSlot, (b) appOpenAdListener, i);
    }

    public static void load(Context context, AdSlot adSlot, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener, int i) {
        adSlot.setDurationSlotType(3);
        e.a(context).a(adSlot, (b) pAGAppOpenAdLoadListener, i);
    }

    public static void a(Context context) {
        a.a(context);
    }
}
