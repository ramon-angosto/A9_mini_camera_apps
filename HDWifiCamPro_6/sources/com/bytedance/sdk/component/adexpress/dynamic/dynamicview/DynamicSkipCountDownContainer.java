package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import java.util.List;

public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements b {
    private int a;
    private int b;
    private int s;

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        a();
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    public boolean i() {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(getBackgroundDrawable());
        }
        setPadding((int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.c()), (int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.b()), (int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.d()), (int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.a()));
        return true;
    }

    public void f() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.i;
        layoutParams.topMargin = this.j;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.s == 0) {
            setMeasuredDimension(this.b, this.h);
        } else {
            setMeasuredDimension(this.a, this.h);
        }
    }

    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.s = i;
    }

    private void a() {
        List<h> j = this.m.j();
        if (j != null && j.size() > 0) {
            for (h next : j) {
                if (next.i().a() == 21) {
                    this.a = (int) (((float) this.g) - com.bytedance.sdk.component.adexpress.c.b.a(this.k, next.g()));
                }
                if (next.i().a() == 20) {
                    this.b = (int) (((float) this.g) - com.bytedance.sdk.component.adexpress.c.b.a(this.k, next.g()));
                }
            }
        }
    }
}
