package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CornerIV extends ImageView {
    private int a = 0;
    private int b = 0;

    public CornerIV(Context context) {
        super(context);
    }

    public CornerIV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CornerIV(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (!a()) {
            measure(0, 0);
            if (!b()) {
                try {
                    bitmap = ((BitmapDrawable) getDrawable()).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                } catch (Throwable unused) {
                    bitmap = null;
                }
                if (bitmap == null) {
                    super.onDraw(canvas);
                    return;
                }
                int radius = getRadius();
                try {
                    bitmap2 = a(bitmap, radius);
                } catch (Throwable unused2) {
                    bitmap2 = null;
                }
                if (bitmap2 == null) {
                    super.onDraw(canvas);
                } else {
                    canvas.drawBitmap(bitmap2, (float) ((this.a / 2) - radius), (float) ((this.b / 2) - radius), (Paint) null);
                }
            }
        }
    }

    private boolean a() {
        return getDrawable() == null || getWidth() == 0 || getHeight() == 0;
    }

    private boolean b() {
        return getDrawable().getClass() == NinePatchDrawable.class || ((getDrawable() instanceof BitmapDrawable) && ((BitmapDrawable) getDrawable()).getBitmap() == null);
    }

    private int getRadius() {
        if (this.a == 0) {
            this.a = getWidth();
        }
        if (this.b == 0) {
            this.b = getHeight();
        }
        int i = this.a;
        int i2 = this.b;
        if (i >= i2) {
            i = i2;
        }
        return i / 2;
    }

    private Bitmap a(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        int i2 = i * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > width) {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
        } else {
            bitmap2 = height < width ? Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height) : null;
        }
        if (bitmap2 != null) {
            bitmap = bitmap2;
        }
        if (!(bitmap.getWidth() == i2 && bitmap.getHeight() == i2)) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i2, i2, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = getPaint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle((float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2), (float) (bitmap.getWidth() / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        return paint;
    }
}
