package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

public class ShadowImageView extends ImageView {
    private Paint a;
    private RectF b;

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b.right != ((float) getMeasuredWidth()) || this.b.bottom != ((float) getMeasuredHeight())) {
            this.b.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.b;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.b.bottom / 2.0f, this.a);
        super.onDraw(canvas);
    }
}
