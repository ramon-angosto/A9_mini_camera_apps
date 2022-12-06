package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;

/* compiled from: UnlockInteract */
public class l implements c<DynamicUnlockView> {
    private final DynamicUnlockView a;

    public l(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        this.a = new DynamicUnlockView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.a(context, gVar.I() > 0 ? (float) gVar.I() : 120.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setClipChildren(false);
        this.a.setText(gVar.L());
    }

    public void a() {
        DynamicUnlockView dynamicUnlockView = this.a;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.a();
        }
    }

    public void b() {
        DynamicUnlockView dynamicUnlockView = this.a;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.b();
        }
    }

    /* renamed from: c */
    public DynamicUnlockView d() {
        return this.a;
    }
}
