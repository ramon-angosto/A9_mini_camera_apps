package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import java.util.Iterator;
import java.util.List;

public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements b {
    int a;
    boolean b;
    private int s;
    private int t = 0;
    private boolean u;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        setTag(Integer.valueOf(getClickArea()));
        a();
        dynamicRootView.setTimeOutListener(this);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    public void f() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.b) {
            layoutParams.leftMargin = this.i;
        } else {
            layoutParams.leftMargin = this.i + this.t;
        }
        if (this.u && this.l != null) {
            layoutParams.leftMargin = ((this.i + this.t) - ((int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.c()))) - ((int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.d()));
        }
        layoutParams.topMargin = this.j;
        setLayoutParams(layoutParams);
    }

    public boolean i() {
        super.i();
        setPadding((int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.c()), (int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.b()), (int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.d()), (int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.a()));
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.u && this.l != null) {
            setMeasuredDimension(this.s + ((int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.c())) + ((int) com.bytedance.sdk.component.adexpress.c.b.a(d.a(), (float) this.l.d())), this.h);
        } else if (this.b) {
            setMeasuredDimension(this.g, this.h);
        } else {
            setMeasuredDimension(this.a, this.h);
        }
    }

    private void a() {
        List<h> j = this.m.j();
        if (j != null && j.size() > 0) {
            Iterator<h> it = j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (TextUtils.equals("skip-with-time-skip-btn", next.i().b())) {
                    this.s = (int) com.bytedance.sdk.component.adexpress.c.b.a(this.k, next.g());
                    this.a = this.g - this.s;
                    break;
                }
            }
            this.t = this.g - this.a;
        }
    }

    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (!z2 || this.u == z2) {
            if (z && this.b != z) {
                this.b = z;
                f();
            }
            this.b = z;
            return;
        }
        this.u = z2;
        f();
    }
}
