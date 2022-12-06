package com.mbridge.msdk.videocommon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.widget.MBImageView;

public class RoundImageView extends MBImageView {
    private int a;
    private int b;
    private Paint c = new Paint();
    private int d;
    private Matrix e = new Matrix();
    private BitmapShader f;
    private int g;
    private RectF h;

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c.setAntiAlias(true);
        this.b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.a = 1;
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c.setAntiAlias(true);
        this.b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.a = 1;
    }

    public RoundImageView(Context context) {
        super(context);
        this.c.setAntiAlias(true);
        this.b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.a = 1;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a == 0) {
            this.g = Math.min(getMeasuredWidth(), getMeasuredHeight());
            int i3 = this.g;
            this.d = i3 / 2;
            setMeasuredDimension(i3, i3);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                Bitmap a2 = a(drawable);
                this.f = new BitmapShader(a2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                int i = this.a;
                float f2 = 1.0f;
                if (i == 0) {
                    f2 = (((float) this.g) * 1.0f) / ((float) Math.min(a2.getWidth(), a2.getHeight()));
                } else if (i == 1) {
                    f2 = Math.max((((float) getWidth()) * 1.0f) / ((float) a2.getWidth()), (((float) getHeight()) * 1.0f) / ((float) a2.getHeight()));
                }
                this.e.setScale(f2, f2);
                this.f.setLocalMatrix(this.e);
                this.c.setShader(this.f);
            }
            if (this.a == 1) {
                RectF rectF = this.h;
                int i2 = this.b;
                canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.c);
                return;
            }
            int i3 = this.d;
            canvas.drawCircle((float) i3, (float) i3, (float) i3, this.c);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.a == 1) {
            this.h = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.a);
        bundle.putInt("state_border_radius", this.b);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
            this.a = bundle.getInt("state_type");
            this.b = bundle.getInt("state_border_radius");
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setBorderRadius(int i) {
        int b2 = u.b(getContext(), (float) i);
        if (this.b != b2) {
            this.b = b2;
            invalidate();
        }
    }

    public void setType(int i) {
        if (this.a != i) {
            this.a = i;
            int i2 = this.a;
            if (!(i2 == 1 || i2 == 0)) {
                this.a = 0;
            }
            requestLayout();
        }
    }

    private Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            q.d("View", th.getMessage());
            return null;
        }
    }
}
