package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

public class ShadowTextView extends TextView {
    private Paint a;
    private RectF b;
    private int c;

    public ShadowTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        a();
    }

    private void a() {
        setTextColor(-1);
        this.a = new Paint();
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.a.setColor(Color.parseColor("#99333333"));
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(0.0f);
        this.b = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        this.c = (int) getPaint().measureText("00");
        int i3 = this.c;
        if (measuredWidth < i3) {
            measuredWidth = i3;
        }
        int i4 = measuredWidth + ((measuredHeight / 2) * 2);
        setMeasuredDimension(i4, measuredHeight);
        this.b.set(0.0f, 0.0f, (float) i4, (float) measuredHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.b;
        canvas.drawRoundRect(rectF, rectF.bottom / 2.0f, this.b.bottom / 2.0f, this.a);
        canvas.translate((this.b.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }
}
