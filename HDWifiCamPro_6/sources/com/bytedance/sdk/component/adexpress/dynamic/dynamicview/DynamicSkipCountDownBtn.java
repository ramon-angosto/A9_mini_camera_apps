package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.utils.t;

public class DynamicSkipCountDownBtn extends DynamicButton implements b {
    private int[] a;
    private int b;
    private int s;

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        dynamicRootView.setTimeOutListener(this);
    }

    public boolean i() {
        super.i();
        ((TextView) this.o).setText("");
        return true;
    }

    public void f() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.g, this.h);
        layoutParams.gravity = 21;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.o).getText())) {
            setMeasuredDimension(0, this.h);
        } else {
            setMeasuredDimension(this.g, this.h);
        }
    }

    public void a(CharSequence charSequence, boolean z, int i, boolean z2) {
        String a2 = t.a(d.a(), "tt_reward_screen_skip_tx");
        if (i == 0) {
            this.o.setVisibility(0);
            ((TextView) this.o).setText(" | " + a2);
            this.o.measure(-2, -2);
            this.a = new int[]{this.o.getMeasuredWidth() + 1, this.o.getMeasuredHeight()};
            View view = this.o;
            int[] iArr = this.a;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.o).setGravity(17);
            ((TextView) this.o).setIncludeFontPadding(false);
            a();
            this.o.setPadding(this.l.c(), this.b, this.l.d(), this.s);
        }
        requestLayout();
    }

    private void a() {
        this.b = ((this.h - ((int) com.bytedance.sdk.component.adexpress.c.b.a(this.k, this.l.e()))) / 2) - this.l.a();
        this.s = 0;
    }
}
