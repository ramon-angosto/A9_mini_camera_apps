package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;

public class AnimationImageView extends ImageView implements b {
    a a = new a();
    private float b;
    private float c;
    private float d;
    private float e;
    private g f;

    public g getBrickNativeValue() {
        return this.f;
    }

    public void setBrickNativeValue(g gVar) {
        this.f = gVar;
    }

    public float getShineValue() {
        return this.c;
    }

    public void setShineValue(float f2) {
        this.c = f2;
        postInvalidate();
    }

    public float getRippleValue() {
        return this.b;
    }

    public void setRippleValue(float f2) {
        this.b = f2;
        postInvalidate();
    }

    public float getMarqueeValue() {
        return this.d;
    }

    public void setMarqueeValue(float f2) {
        this.d = f2;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.e;
    }

    public void setStretchValue(float f2) {
        this.e = f2;
        this.a.a(this, f2);
    }

    public AnimationImageView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        g gVar;
        super.onDraw(canvas);
        this.a.a(canvas, (b) this, (View) this);
        if (getRippleValue() != 0.0f && (gVar = this.f) != null && gVar.b() > 0) {
            ((ViewGroup) getParent()).setClipChildren(false);
            ((ViewGroup) getParent().getParent()).setClipChildren(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a.a((View) this, i, i2);
    }
}
