package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.k.a.e;

public class PAGMediaView extends FrameLayout {
    public void close() {
    }

    public PAGMediaView(Context context) {
        super(context);
    }

    public PAGMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PAGMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PAGMediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Object tag = getTag(t.e(getContext(), "tt_id_mrc_tracker_view"));
        if (tag instanceof Integer) {
            e.a(e.a((Integer) tag), z ? 4 : 8);
        }
    }
}
