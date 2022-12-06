package com.bytedance.sdk.component.adexpress.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.component.utils.l;

public class BrushMaskView extends View {
    private static final String a = BrushMaskView.class.getSimpleName();
    private Paint b;
    private Bitmap c;
    /* access modifiers changed from: private */
    public Canvas d;
    private Paint e;
    private BitmapDrawable f;
    /* access modifiers changed from: private */
    public Paint g;
    private Path h;
    private Path i;
    private Paint j;

    public BrushMaskView(Context context) {
        super(context);
        a(context);
    }

    public BrushMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public BrushMaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public BrushMaskView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context);
    }

    private void a(Context context) {
        this.b = new Paint();
        this.b.setAntiAlias(true);
        this.b.setDither(true);
        setMaskColor(-1426063361);
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setDither(true);
        this.j = new Paint();
        this.j.setColor(-7829368);
        this.j.setAlpha(100);
        this.j.setAntiAlias(true);
        this.j.setDither(true);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeCap(Paint.Cap.ROUND);
        if (Build.VERSION.SDK_INT >= 21) {
            setWatermark(-1);
        } else {
            setMaskColor(-1426063361);
        }
        this.g = new Paint();
        this.g.setAntiAlias(true);
        this.g.setDither(true);
        this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeCap(Paint.Cap.ROUND);
        setEraserSize(60.0f);
        this.h = new Path();
        this.i = new Path();
    }

    public void setEraserSize(float f2) {
        this.g.setStrokeWidth(f2);
        this.j.setStrokeWidth(f2);
    }

    public void setMaskColor(int i2) {
        this.b.setColor(i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(a(i2), a(i3));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.e);
        }
    }

    public void a(float f2, float f3) {
        b(f2, f3);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a(i2, i3);
    }

    private void a(int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            try {
                this.c = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                if (this.d == null) {
                    this.d = new Canvas(this.c);
                } else {
                    this.d.setBitmap(this.c);
                }
                this.d.drawRoundRect(new RectF(0.0f, 0.0f, (float) i2, (float) i3), 120.0f, 120.0f, this.b);
                if (this.f != null) {
                    this.f.setBounds(new Rect(0, 0, i2, i3));
                    this.f.draw(this.d);
                }
            } catch (Exception e2) {
                l.e(a, e2.getMessage());
            }
        }
    }

    private int a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }

    private void b(float f2, float f3) {
        this.h.reset();
        this.i.reset();
        this.h.moveTo(f2, f3);
        this.i.moveTo(f2, f3);
    }

    public void setWatermark(int i2) {
        if (i2 == -1) {
            this.f = null;
        } else {
            this.f = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i2));
        }
    }

    public void a() {
        a(getWidth(), getHeight());
        invalidate();
    }

    public void b() {
        c();
    }

    public void c() {
        final int width = getWidth();
        final int height = getHeight();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(400);
        valueAnimator.setIntValues(new int[]{0, width});
        valueAnimator.setInterpolator(new TimeInterpolator() {
            public float getInterpolation(float f) {
                int i = (int) (((float) width) * f);
                int i2 = height;
                if (BrushMaskView.this.d != null) {
                    Canvas a2 = BrushMaskView.this.d;
                    int i3 = height;
                    a2.drawRect(0.0f, (float) (i3 / 2), (float) (i - 50), (float) (i3 / 2), BrushMaskView.this.g);
                    BrushMaskView.this.d.drawCircle((float) i, (float) (height / 2), 10.0f, BrushMaskView.this.g);
                }
                BrushMaskView.this.postInvalidate();
                return f;
            }
        });
        valueAnimator.start();
    }
}
