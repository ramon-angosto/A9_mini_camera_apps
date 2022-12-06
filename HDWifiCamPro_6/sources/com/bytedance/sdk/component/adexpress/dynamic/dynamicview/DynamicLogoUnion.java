package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.utils.t;

public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.o = new ImageView(context);
        this.o.setTag(Integer.valueOf(getClickArea()));
        if (d.b()) {
            this.h = Math.max(dynamicRootView.getLogoUnionHeight(), this.h);
        }
        addView(this.o, getWidgetLayoutParams());
    }

    public boolean i() {
        super.i();
        if (d.b()) {
            ((ImageView) this.o).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.o).setImageResource(t.d(getContext(), "tt_ad_logo_reward_full"));
        } else {
            ((ImageView) this.o).setImageResource(t.d(getContext(), "tt_ad_logo"));
        }
        ((ImageView) this.o).setColorFilter(this.l.g(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
