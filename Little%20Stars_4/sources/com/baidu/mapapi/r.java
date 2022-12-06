package com.baidu.mapapi;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

final class r implements p {
    private o a = new o(Bitmap.Config.ARGB_4444);
    private Drawable b = null;

    public static void a(Drawable drawable, Drawable drawable2) {
        Rect bounds = drawable2.getBounds();
        int height = (int) (((float) bounds.height()) * 0.5f);
        double width = (double) (((float) bounds.width()) * 0.9f);
        Double.isNaN(width);
        int i = (int) (width * 0.5d);
        drawable.setBounds(bounds.left + i, bounds.top + height, bounds.right + i, bounds.bottom + height);
    }

    public final Drawable a(Drawable drawable) {
        this.b = drawable;
        this.a.a(this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
        this.a.a(this);
        this.b = null;
        return new BitmapDrawable(this.a.b());
    }

    public final void a(Canvas canvas) {
        this.b.setColorFilter(2130706432, PorterDuff.Mode.SRC_IN);
        canvas.skew(-0.9f, 0.0f);
        canvas.scale(1.0f, 0.5f);
        this.b.draw(canvas);
        this.b.clearColorFilter();
    }
}
