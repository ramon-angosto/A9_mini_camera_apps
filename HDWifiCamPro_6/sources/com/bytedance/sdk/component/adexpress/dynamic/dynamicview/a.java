package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* compiled from: BitmapCoverDrawable */
public class a extends b {
    private final Rect b = new Rect();
    private final Bitmap c;
    private final Paint d = new Paint(1);

    public a(Bitmap bitmap, b bVar) {
        this.c = bitmap;
        if (bVar != null) {
            this.a = bVar.a;
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int height = rect.height();
        int width = rect.width();
        int width2 = this.c.getWidth();
        int height2 = this.c.getHeight();
        this.b.set(0, 0, width2, height2);
        if (height2 < height || width2 < width) {
            float f = (float) height;
            float f2 = f * 1.0f;
            float f3 = (float) height2;
            float f4 = f2 / f3;
            float f5 = (float) width;
            float f6 = 1.0f * f5;
            float f7 = (float) width2;
            if (Math.max(f4, f6 / f7) > f4) {
                int i = (int) ((f2 / f5) * f7);
                Rect rect2 = this.b;
                rect2.top = (height2 - i) / 2;
                rect2.bottom = rect2.top + i;
                return;
            }
            int i2 = (int) ((f6 / f) * f3);
            Rect rect3 = this.b;
            rect3.left = (width2 - i2) / 2;
            rect3.right = rect3.left + i2;
            return;
        }
        if (width2 > width) {
            Rect rect4 = this.b;
            rect4.left = (width2 - width) / 2;
            rect4.right = rect4.left + width;
        }
        if (height2 > height) {
            Rect rect5 = this.b;
            rect5.top = (height2 - height) / 2;
            rect5.bottom = rect5.top + height;
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        canvas.drawBitmap(this.c, this.b, getBounds(), this.d);
    }
}
