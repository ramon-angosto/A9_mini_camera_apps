package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressInteractView;

/* compiled from: PressInteract */
public class h implements c<PressInteractView> {
    private PressInteractView a;

    public h(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        this.a = new PressInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) b.a(context, 180.0f), (int) b.a(context, 180.0f));
        layoutParams.gravity = 17;
        this.a.setLayoutParams(layoutParams);
        this.a.setGuideText(gVar.L());
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.b();
    }

    /* renamed from: c */
    public PressInteractView d() {
        return this.a;
    }
}
