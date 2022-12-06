package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class RingProgressView extends View {
    private Context a;
    private Paint b;
    private RectF c;
    /* access modifiers changed from: private */
    public float d;
    private ValueAnimator e;
    private int f = 1500;
    private boolean g;

    public RingProgressView(Context context) {
        super(context);
        this.a = context;
        this.b = new Paint();
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(10.0f);
        this.b.setColor(Color.parseColor("#80FFFFFF"));
        this.c = new RectF();
    }

    public void a() {
        this.e = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        this.e.setDuration((long) this.f);
        this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = RingProgressView.this.d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.e.start();
    }

    public void b() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void c() {
        this.g = true;
        invalidate();
    }

    public void setDuration(int i) {
        this.f = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.g) {
            canvas.drawArc(this.c, 270.0f, this.d, false, this.b);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c.set(5.0f, 5.0f, (float) (i - 5), (float) (i2 - 5));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }
}
