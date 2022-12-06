package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class TwoSemicirclesView extends View {
    private final RectF a;
    private int b;
    private int c;
    private Paint d;
    private Paint e;
    private float f = -90.0f;
    private float g = 220.0f;
    private int h = Color.parseColor("#FFFFFF");
    private int i = Color.parseColor("#C4C4C4");

    public TwoSemicirclesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        float f2 = this.g;
        this.a = new RectF(-f2, -f2, f2, f2);
    }

    private void a() {
        this.d = new Paint();
        this.d.setColor(this.h);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(4.0f);
        this.d.setAlpha(20);
        this.e = new Paint(this.d);
        this.e.setColor(this.i);
        this.e.setAlpha(255);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.b = i2;
        this.c = i3;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.a;
        float f2 = this.g;
        rectF.set(-f2, -f2, f2, f2);
        canvas.translate((float) (this.b / 2), (float) (this.c / 2));
        canvas.drawArc(this.a, this.f, 180.0f, false, this.d);
        canvas.drawArc(this.a, this.f + 180.0f, 180.0f, false, this.e);
    }

    public void setCurrentStartAngle(float f2) {
        this.f = f2;
        postInvalidate();
    }

    public void setRadius(float f2) {
        this.g = f2;
        postInvalidate();
    }

    public void setPaintOne(Paint paint) {
        this.d = paint;
        postInvalidate();
    }

    public Paint getPaintOne() {
        return this.d;
    }

    public void setPaintTwo(Paint paint) {
        this.e = paint;
        postInvalidate();
    }

    public Paint getPaintTwo() {
        return this.e;
    }
}
