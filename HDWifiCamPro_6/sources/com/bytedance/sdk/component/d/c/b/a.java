package com.bytedance.sdk.component.d.c.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* compiled from: DefaultDecoder */
public class a {
    public static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config b = Bitmap.Config.ARGB_4444;
    private final Bitmap.Config c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final ImageView.ScaleType h;

    public a(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.c = config;
        this.d = i;
        this.e = i2;
        this.h = scaleType;
        this.f = i3;
        this.g = i4;
    }

    static int a(int i, int i2, int i3, int i4, int i5, int i6) {
        double min = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        if (i5 > 0 && i6 > 0) {
            min = Math.max(min, Math.min(((double) Math.max(i, i2)) / ((double) Math.max(i5, i6)), ((double) Math.min(i, i2)) / ((double) Math.min(i5, i6))));
        }
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (((double) f3) > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }

    private static int a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        } else if (i2 == 0) {
            return i;
        } else {
            double d2 = ((double) i4) / ((double) i3);
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d3 = (double) i2;
                return ((double) i) * d2 < d3 ? (int) (d3 / d2) : i;
            }
            double d4 = (double) i2;
            return ((double) i) * d2 > d4 ? (int) (d4 / d2) : i;
        }
    }

    public Bitmap a(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.d == 0 && this.e == 0) {
            options.inPreferredConfig = this.c;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        int a2 = a(this.d, this.e, i, i2, this.h);
        int a3 = a(this.e, this.d, i2, i, this.h);
        options.inJustDecodeBounds = false;
        options.inSampleSize = a(i, i2, a2, a3, this.f, this.g);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (decodeByteArray == null) {
            return decodeByteArray;
        }
        if (decodeByteArray.getWidth() <= a2 && decodeByteArray.getHeight() <= a3) {
            return decodeByteArray;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a2, a3, true);
        if (createScaledBitmap != decodeByteArray) {
            decodeByteArray.recycle();
        }
        return createScaledBitmap;
    }
}
