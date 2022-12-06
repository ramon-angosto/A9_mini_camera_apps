package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;

/* compiled from: CircleLongPressInteract */
public class b implements c {
    private CircleLongPressView a;

    public b(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        this.a = new CircleLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.c.b.a(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.c.b.a(context, 180.0f));
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
    public CircleLongPressView d() {
        return this.a;
    }
}
