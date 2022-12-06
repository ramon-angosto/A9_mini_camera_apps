package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.widget.DislikeView;

public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.o = new DislikeView(context);
        this.o.setTag(3);
        addView(this.o, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.o);
    }

    public boolean i() {
        super.i();
        int a = (int) b.a(this.k, this.l.q());
        if (!(this.o instanceof DislikeView)) {
            return true;
        }
        ((DislikeView) this.o).setRadius((int) b.a(this.k, this.l.o()));
        ((DislikeView) this.o).setStrokeWidth(a);
        ((DislikeView) this.o).setStrokeColor(this.l.p());
        ((DislikeView) this.o).setBgColor(this.l.y());
        ((DislikeView) this.o).setDislikeColor(this.l.g());
        ((DislikeView) this.o).setDislikeWidth((int) b.a(this.k, 1.0f));
        return true;
    }
}
