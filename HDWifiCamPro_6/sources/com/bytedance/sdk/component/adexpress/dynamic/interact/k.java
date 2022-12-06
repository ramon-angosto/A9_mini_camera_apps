package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* compiled from: SlideUpInteract */
public class k implements c<SlideUpView> {
    private SlideUpView a;
    private Context b;
    private DynamicBaseWidget c;
    private g d;

    public k(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        this.b = context;
        this.c = dynamicBaseWidget;
        this.d = gVar;
        e();
    }

    private void e() {
        this.a = new SlideUpView(this.b, this.d.F());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) b.a(this.b, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.a(this.b, 100.0f);
        this.a.setLayoutParams(layoutParams);
        try {
            this.a.setGuideText(this.d.L());
        } catch (Throwable unused) {
        }
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.c();
    }

    /* renamed from: c */
    public SlideUpView d() {
        return this.a;
    }
}
