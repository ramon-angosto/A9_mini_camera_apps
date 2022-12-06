package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class DislikeView extends View {
    private int a;
    private int b;
    private RectF c;
    private Paint d;
    private Paint e;
    private int f;
    private Paint g;
    private int h;

    public DislikeView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.g = new Paint();
        this.g.setAntiAlias(true);
        this.e = new Paint();
        this.e.setAntiAlias(true);
    }

    public void setRadius(int i) {
        this.f = i;
    }

    public void setDislikeColor(int i) {
        this.g.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.g.setStrokeWidth((float) i);
    }

    public void setStrokeColor(int i) {
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.d.setStrokeWidth((float) i);
        this.h = i;
    }

    public void setBgColor(int i) {
        this.e.setStyle(Paint.Style.FILL);
        this.e.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.c;
        int i = this.f;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.e);
        RectF rectF2 = this.c;
        int i2 = this.f;
        canvas.drawRoundRect(rectF2, (float) i2, (float) i2, this.d);
        int i3 = this.a;
        int i4 = this.b;
        Canvas canvas2 = canvas;
        canvas2.drawLine(((float) i3) * 0.3f, ((float) i4) * 0.3f, ((float) i3) * 0.7f, ((float) i4) * 0.7f, this.g);
        int i5 = this.a;
        int i6 = this.b;
        Canvas canvas3 = canvas;
        canvas3.drawLine(((float) i5) * 0.7f, ((float) i6) * 0.3f, ((float) i5) * 0.3f, ((float) i6) * 0.7f, this.g);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a = i;
        this.b = i2;
        int i5 = this.h;
        this.c = new RectF((float) i5, (float) i5, (float) (this.a - i5), (float) (this.b - i5));
    }
}
