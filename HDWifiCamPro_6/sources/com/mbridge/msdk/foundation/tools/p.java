package com.mbridge.msdk.foundation.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: SameImageTool */
public final class p {
    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        if (i2 == 0) {
            return bitmap;
        }
        Bitmap bitmap2 = null;
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, width, height);
            RectF rectF = new RectF(rect);
            float f = (float) i2;
            paint.setAntiAlias(true);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f, f, paint);
            if (i == 2) {
                canvas.drawRect(0.0f, (float) (height - i2), (float) width, (float) height, paint);
            }
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
        } catch (Error | Exception unused) {
        }
        return bitmap2;
    }
}
