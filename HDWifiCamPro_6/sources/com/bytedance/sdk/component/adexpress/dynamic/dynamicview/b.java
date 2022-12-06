package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.GradientDrawable;

/* compiled from: CoverDrawable */
public class b extends GradientDrawable {
    protected Path a = new Path();
    private final Paint b = new Paint(1);

    public b() {
        this.b.setColor(-1);
    }

    public b(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
        this.b.setColor(-1);
    }

    public void draw(Canvas canvas) {
        Path path = this.a;
        if (path == null || path.isEmpty()) {
            a(canvas);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.b, 31);
        a(canvas);
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.a, this.b);
        this.b.setXfermode((Xfermode) null);
        canvas.restoreToCount(saveLayer);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.a.addRect((float) i, (float) i2, (float) i3, (float) i4, Path.Direction.CW);
        invalidateSelf();
    }
}
