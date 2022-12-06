package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView;

/* compiled from: BrushMaskInteract */
public class a implements c<DynamicBrushMaskView> {
    private DynamicBrushMaskView a;

    public a(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        this.a = new DynamicBrushMaskView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.a(context, gVar.I() > 0 ? (float) gVar.I() : 120.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setClipChildren(false);
        this.a.setBrushText(gVar.L());
    }

    public void a() {
        DynamicBrushMaskView dynamicBrushMaskView = this.a;
        if (dynamicBrushMaskView != null) {
            dynamicBrushMaskView.a();
        }
    }

    public void b() {
        DynamicBrushMaskView dynamicBrushMaskView = this.a;
        if (dynamicBrushMaskView != null) {
            dynamicBrushMaskView.c();
        }
    }

    /* renamed from: c */
    public DynamicBrushMaskView d() {
        return this.a;
    }
}
