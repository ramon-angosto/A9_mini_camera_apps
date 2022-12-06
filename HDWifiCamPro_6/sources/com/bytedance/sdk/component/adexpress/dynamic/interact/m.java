package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideView;
import com.bytedance.sdk.component.utils.t;

/* compiled from: WriggleGuideInteract */
public class m implements c<WriggleGuideAnimationView> {
    private WriggleGuideAnimationView a;
    private Context b;
    private DynamicBaseWidget c;
    private g d;
    private String e;
    private int f;

    public m(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar, String str, int i) {
        this.b = context;
        this.c = dynamicBaseWidget;
        this.d = gVar;
        this.e = str;
        this.f = i;
        e();
    }

    private void e() {
        int I = this.d.I();
        if ("18".equals(this.e)) {
            Context context = this.b;
            this.a = new WriggleGuideAnimationView(context, t.f(context, "tt_hand_wriggle_guide"), this.f);
            if (this.a.getWriggleLayout() != null) {
                this.a.getWriggleLayout().setOnClickListener((View.OnClickListener) this.c.getDynamicClickListener());
            }
            if (this.a.getTopTextView() != null) {
                this.a.getTopTextView().setText(t.b(this.b, "tt_splash_wriggle_top_text_style_17"));
            }
        } else {
            Context context2 = this.b;
            this.a = new WriggleGuideAnimationView(context2, t.f(context2, "tt_hand_wriggle_guide"), this.f);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) b.a(this.b, (float) I);
        this.a.setLayoutParams(layoutParams);
        this.a.setShakeText(this.d.L());
        this.a.setClipChildren(false);
        final WriggleGuideView wriggleProgressIv = this.a.getWriggleProgressIv();
        this.a.setOnShakeViewListener(new WriggleGuideAnimationView.a() {
        });
    }

    public void a() {
        this.a.a();
    }

    public void b() {
        this.a.clearAnimation();
    }

    /* renamed from: c */
    public WriggleGuideAnimationView d() {
        return this.a;
    }
}
