package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.a;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.utils.t;

public class DynamicMutedView extends DynamicBaseWidgetImp implements a {
    public boolean e() {
        return true;
    }

    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.o = new ImageView(context);
        this.o.setTag(5);
        addView(this.o, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
    }

    public boolean i() {
        super.i();
        ((ImageView) this.o).setScaleType(ImageView.ScaleType.CENTER);
        setSoundMute(this.n.b);
        GradientDrawable gradientDrawable = (GradientDrawable) t.c(getContext(), "tt_ad_skip_btn_bg");
        gradientDrawable.setCornerRadius((float) (this.h / 2));
        gradientDrawable.setColor(this.l.y());
        ((ImageView) this.o).setBackgroundDrawable(gradientDrawable);
        return true;
    }

    public void setSoundMute(boolean z) {
        int i;
        if (z) {
            i = t.d(getContext(), "tt_mute");
        } else {
            i = t.d(getContext(), "tt_unmute");
        }
        ((ImageView) this.o).setImageResource(i);
    }
}
