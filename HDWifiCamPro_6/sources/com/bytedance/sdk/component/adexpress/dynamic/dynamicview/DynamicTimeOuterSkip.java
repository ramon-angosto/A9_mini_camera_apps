package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.utils.t;

public class DynamicTimeOuterSkip extends DynamicButton implements b {
    private boolean a;

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.a = dynamicRootView.getRenderRequest().j();
        }
    }

    public boolean i() {
        super.i();
        if (!TextUtils.equals(this.m.i().b(), "skip-with-time-skip-btn")) {
            return true;
        }
        ((TextView) this.o).setText("");
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.o).getText())) {
            setMeasuredDimension(0, this.h);
        }
    }

    public void f() {
        if (TextUtils.equals("skip-with-time-skip-btn", this.m.i().b())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.g, this.h);
            layoutParams.gravity = 21;
            setLayoutParams(layoutParams);
            if (Build.VERSION.SDK_INT >= 17) {
                this.o.setTextAlignment(1);
            }
            ((TextView) this.o).setGravity(17);
        } else {
            super.f();
        }
        if (!"skip-with-time-skip-btn".equals(this.m.i().b()) && Build.VERSION.SDK_INT >= 17) {
            this.o.setTextAlignment(1);
            ((TextView) this.o).setGravity(17);
        }
        setVisibility(8);
    }

    private String a(boolean z) {
        String a2 = t.a(d.a(), "tt_reward_screen_skip_tx");
        if (!"skip-with-time-skip-btn".equals(this.m.i().b())) {
            return a2;
        }
        if (d.b() && this.a) {
            a2 = "X";
        }
        if (z) {
            return a2;
        }
        return " | " + a2;
    }

    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (z) {
            ((TextView) this.o).setText(a(z2));
            setVisibility(0);
            return;
        }
        if (z2) {
            ((TextView) this.o).setText(a(z2));
        }
        if (!z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
