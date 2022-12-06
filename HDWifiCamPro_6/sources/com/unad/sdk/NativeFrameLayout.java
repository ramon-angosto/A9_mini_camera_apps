package com.unad.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.ads.nativead.NativeAd;

public class NativeFrameLayout extends FrameLayout {
    public NativeFrameLayout(Context context) {
        super(context);
    }

    public void setNativeAd(NativeAd nativeAd) {
    }

    public NativeFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
