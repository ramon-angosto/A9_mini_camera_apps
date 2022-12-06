package com.bytedance.sdk.openadsdk.k.a;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.e;

/* compiled from: PAGMrcVisibilityTracker */
public class f {
    public static boolean a(View view) {
        return a(view, false);
    }

    public static boolean a(View view, boolean z) {
        if (view == null || !e.a() || !view.isShown()) {
            return false;
        }
        if (v.a(view) > (z ? 0.3f : 0.5f)) {
            return true;
        }
        return false;
    }
}
