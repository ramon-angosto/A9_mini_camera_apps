package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;

public class DynamicRoot extends DynamicBaseWidgetImp {
    public b a;

    public DynamicRoot(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
    }

    public boolean i() {
        return super.i();
    }

    /* access modifiers changed from: protected */
    public b a(Bitmap bitmap) {
        this.a = new a(bitmap, this.a);
        return this.a;
    }

    /* access modifiers changed from: protected */
    public GradientDrawable getDrawable() {
        this.a = new b();
        return this.a;
    }

    /* access modifiers changed from: protected */
    public GradientDrawable a(GradientDrawable.Orientation orientation, int[] iArr) {
        this.a = new b(orientation, iArr);
        return this.a;
    }
}
