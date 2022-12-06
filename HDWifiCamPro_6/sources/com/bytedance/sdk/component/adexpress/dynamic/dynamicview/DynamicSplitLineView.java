package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;

public class DynamicSplitLineView extends DynamicBaseWidgetImp {
    public DynamicSplitLineView(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        this.o = new View(context);
        addView(this.o, getWidgetLayoutParams());
    }

    public boolean i() {
        super.i();
        this.o.setBackgroundColor(this.l.y());
        return true;
    }
}
