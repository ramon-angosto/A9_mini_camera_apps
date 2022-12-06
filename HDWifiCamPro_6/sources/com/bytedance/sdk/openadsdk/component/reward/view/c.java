package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.graphics.Color;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.z;

/* compiled from: RewardFullNativeVideoLayout */
public class c extends d {
    /* access modifiers changed from: protected */
    public boolean a() {
        return false;
    }

    public c(Activity activity) {
        super(activity);
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (this.c != null && n.c(this.c) && this.c.t() == 3 && this.c.v() == 0) {
            try {
                FrameLayout frameLayout = (FrameLayout) this.b.findViewById(t.e(this.b, "tt_video_container_back"));
                frameLayout.setBackgroundColor(Color.parseColor("#000000"));
                if (this.c.am() == 1) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                    layoutParams.bottomMargin = (int) z.b(m.a(), 90.0f);
                    frameLayout.setLayoutParams(layoutParams);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
