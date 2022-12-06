package com.bytedance.sdk.openadsdk.a.b;

import android.view.View;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;

/* compiled from: PAGNativeAdDataImpl */
public class e implements PAGNativeAdData {
    private final a a;

    public e(a aVar) {
        this.a = aVar;
    }

    public PAGImageItem getIcon() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public String getTitle() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public String getDescription() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    public String getButtonText() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.f();
        }
        return null;
    }

    public PAGMediaView getMediaView() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.g();
        }
        return null;
    }

    public View getAdLogoView() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.h();
        }
        return null;
    }
}
