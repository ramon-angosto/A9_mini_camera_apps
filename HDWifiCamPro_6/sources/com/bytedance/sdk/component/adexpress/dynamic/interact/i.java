package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.utils.t;

/* compiled from: ShakeInteract */
public class i implements c<ShakeAnimationView> {
    private ShakeAnimationView a;
    private Context b;
    private DynamicBaseWidget c;
    private g d;
    private String e;
    private int f;
    private int g;
    private int h;

    public i(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar, String str, int i, int i2, int i3) {
        this.b = context;
        this.c = dynamicBaseWidget;
        this.d = gVar;
        this.e = str;
        this.f = i;
        this.g = i2;
        this.h = i3;
        e();
    }

    private void e() {
        if ("16".equals(this.e)) {
            Context context = this.b;
            this.a = new ShakeAnimationView(context, t.f(context, "tt_hand_shake_interaction_type_16"), this.f, this.g, this.h);
            if (this.a.getShakeLayout() != null) {
                this.a.getShakeLayout().setOnClickListener((View.OnClickListener) this.c.getDynamicClickListener());
            }
        } else {
            Context context2 = this.b;
            this.a = new ShakeAnimationView(context2, t.f(context2, "tt_hand_shake"), this.f, this.g, this.h);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.a(this.b, 80.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setShakeText(this.d.L());
        this.a.setClipChildren(false);
        this.a.setOnShakeViewListener(new ShakeAnimationView.a() {
        });
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.clearAnimation();
    }

    /* renamed from: c */
    public ShakeAnimationView d() {
        return this.a;
    }
}
