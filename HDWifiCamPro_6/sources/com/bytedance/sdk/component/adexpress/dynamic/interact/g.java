package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView;

/* compiled from: PressButtonInteract */
public class g implements c {
    private PressButtonInteractView a;

    public g(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.g gVar) {
        this.a = new PressButtonInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicBaseWidget.getDynamicHeight(), dynamicBaseWidget.getDynamicHeight());
        layoutParams.gravity = 21;
        this.a.setLayoutParams(layoutParams);
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.b();
    }

    /* renamed from: c */
    public PressButtonInteractView d() {
        return this.a;
    }
}
