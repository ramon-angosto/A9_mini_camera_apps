package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.TextView;

public class AnimationButton extends TextView implements b {
    a a = new a();
    private float b;
    private float c;
    private float d;
    private float e;

    public float getShineValue() {
        return this.c;
    }

    public void setShineValue(float f) {
        this.c = f;
        postInvalidate();
    }

    public float getRippleValue() {
        return this.b;
    }

    public void setRippleValue(float f) {
        this.b = f;
        postInvalidate();
    }

    public float getMarqueeValue() {
        return this.d;
    }

    public void setMarqueeValue(float f) {
        this.d = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.e;
    }

    public void setStretchValue(float f) {
        this.e = f;
        this.a.a(this, f);
    }

    public AnimationButton(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.a(canvas, (b) this, (View) this);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a.a((View) this, i, i2);
    }
}
