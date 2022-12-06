package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MBRotationView extends FrameLayout {
    Runnable a = new Runnable() {
        public final void run() {
            MBRotationView.a(MBRotationView.this);
        }
    };
    private Camera b;
    private Matrix c;
    private int d;
    private int e;
    private int f = 40;
    private int g = 20;
    private int h = 0;
    private int i = 0;
    private int j;
    private int k = 0;
    private float l = 0.5f;
    private float m = 0.9f;
    private boolean n = true;
    private boolean o = false;
    private boolean p = false;

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public MBRotationView(Context context) {
        super(context);
        a();
    }

    public MBRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MBRotationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.b = new Camera();
        this.c = new Matrix();
        setWillNotDraw(false);
    }

    public void setWidthRatio(float f2) {
        this.l = f2;
    }

    public void setHeightRatio(float f2) {
        this.m = f2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        float f2 = (float) i6;
        float f3 = this.l;
        int i7 = (int) (((1.0f - f3) * f2) / 2.0f);
        int i8 = i5 - i3;
        float f4 = (float) i8;
        float f5 = this.m;
        int i9 = (int) (((1.0f - f5) * f4) / 2.0f);
        this.d = (int) (f4 * f5);
        this.e = (int) (f2 * f3);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            childAt.layout(i7, i9, i6 - i7, i8 - i9);
            childAt.setClickable(true);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i11 = layoutParams.width;
            int i12 = this.e;
            if (i11 != i12) {
                layoutParams.width = i12;
                layoutParams.height = this.d;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    public void setRotateV(boolean z) {
        this.o = z;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (getChildCount() != 0) {
            if (this.o) {
                int height = getHeight() / 2;
                int i2 = ((this.h * this.d) / 2) / this.f;
                a(canvas, i2, height, 0);
                a(canvas, i2, height, 1);
                if (Math.abs(this.h) > this.f / 2) {
                    a(canvas, i2, height, 3);
                    a(canvas, i2, height, 2);
                    return;
                }
                a(canvas, i2, height, 2);
                a(canvas, i2, height, 3);
                return;
            }
            int width = getWidth() / 2;
            int i3 = ((this.h * this.e) / 2) / this.f;
            b(canvas, i3, width, 0);
            b(canvas, i3, width, 1);
            if (Math.abs(this.h) > this.f / 2) {
                b(canvas, i3, width, 3);
                b(canvas, i3, width, 2);
                return;
            }
            b(canvas, i3, width, 2);
            b(canvas, i3, width, 3);
        }
    }

    public void setAutoscroll(boolean z) {
        if (z) {
            postDelayed(this.a, (long) (1000 / this.g));
        }
        this.n = z;
    }

    private void a(int i2, int i3, int i4) {
        float f2 = ((float) (-i2)) / 2.0f;
        if (i4 == 0) {
            this.b.translate(0.0f, f2, 0.0f);
            float f3 = (float) (-i3);
            this.b.rotateX(f3);
            this.b.translate(0.0f, f2, 0.0f);
            this.b.translate(0.0f, f2, 0.0f);
            this.b.rotateX(f3);
            this.b.translate(0.0f, f2, 0.0f);
        } else if (i4 == 1) {
            this.b.translate(0.0f, f2, 0.0f);
            this.b.rotateX((float) i3);
            this.b.translate(0.0f, f2, 0.0f);
        } else if (i4 == 2) {
            this.b.translate(0.0f, f2, 0.0f);
            this.b.rotateX((float) (-i3));
            this.b.translate(0.0f, f2, 0.0f);
        } else if (i4 == 3) {
            this.b.rotateX(0.0f);
        }
    }

    private void a(Canvas canvas, int i2, int i3, int i4) {
        canvas.save();
        this.b.save();
        this.c.reset();
        float f2 = (float) i2;
        this.b.translate(0.0f, f2, 0.0f);
        this.b.rotateX((float) this.h);
        this.b.translate(0.0f, f2, 0.0f);
        if (i2 == 0) {
            if (this.p) {
                a(this.d, this.f, i4);
            } else {
                a(-this.d, -this.f, i4);
            }
        } else if (i2 > 0) {
            a(this.d, this.f, i4);
        } else if (i2 < 0) {
            a(-this.d, -this.f, i4);
        }
        this.b.getMatrix(this.c);
        this.b.restore();
        this.c.preTranslate((float) ((-getWidth()) / 2), (float) (-i3));
        this.c.postTranslate((float) (getWidth() / 2), (float) i3);
        canvas.concat(this.c);
        View childAt = getChildAt(a(i4));
        if (childAt != null) {
            drawChild(canvas, childAt, 0);
        }
        canvas.restore();
    }

    private int a(int i2) {
        int i3;
        int i4;
        int i5;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    i3 = i2 != 3 ? 0 : this.i;
                } else if (this.p) {
                    i4 = this.i;
                    i3 = i4 - 1;
                } else {
                    i5 = this.i;
                }
            } else if (this.p) {
                i5 = this.i;
            } else {
                i4 = this.i;
                i3 = i4 - 1;
            }
            i3 = i5 + 1;
        } else if (this.p) {
            i3 = this.i - 2;
        } else {
            i3 = this.i + 2;
        }
        int childCount = i3 % getChildCount();
        if (childCount >= 0) {
            return childCount;
        }
        return childCount + getChildCount();
    }

    private void b(int i2, int i3, int i4) {
        if (i4 == 0) {
            float f2 = (float) ((-i2) / 2);
            this.b.translate(f2, 0.0f, 0.0f);
            float f3 = (float) (-i3);
            this.b.rotateY(f3);
            this.b.translate(f2, 0.0f, 0.0f);
            this.b.translate(f2, 0.0f, 0.0f);
            this.b.rotateY(f3);
            this.b.translate(f2, 0.0f, 0.0f);
        } else if (i4 == 1) {
            float f4 = (float) (i2 / 2);
            this.b.translate(f4, 0.0f, 0.0f);
            this.b.rotateY((float) i3);
            this.b.translate(f4, 0.0f, 0.0f);
        } else if (i4 == 2) {
            float f5 = (float) ((-i2) / 2);
            this.b.translate(f5, 0.0f, 0.0f);
            this.b.rotateY((float) (-i3));
            this.b.translate(f5, 0.0f, 0.0f);
        } else if (i4 == 3) {
            this.b.rotateY(0.0f);
        }
    }

    private void b(Canvas canvas, int i2, int i3, int i4) {
        canvas.save();
        this.b.save();
        this.c.reset();
        float f2 = (float) i2;
        this.b.translate(f2, 0.0f, 0.0f);
        this.b.rotateY((float) this.h);
        this.b.translate(f2, 0.0f, 0.0f);
        if (i2 == 0) {
            if (this.p) {
                b(this.e, this.f, i4);
            } else {
                b(-this.e, -this.f, i4);
            }
        } else if (i2 > 0) {
            b(this.e, this.f, i4);
        } else if (i2 < 0) {
            b(-this.e, -this.f, i4);
        }
        this.b.getMatrix(this.c);
        this.b.restore();
        this.c.preTranslate((float) (-i3), (float) ((-getHeight()) / 2));
        this.c.postTranslate((float) i3, (float) (getHeight() / 2));
        canvas.concat(this.c);
        View childAt = getChildAt(a(i4));
        if (childAt != null) {
            drawChild(canvas, childAt, 0);
        }
        canvas.restore();
    }

    static /* synthetic */ void a(MBRotationView mBRotationView) {
        int i2;
        if (mBRotationView.getChildCount() != 0) {
            mBRotationView.h--;
            mBRotationView.j = mBRotationView.i;
            int i3 = mBRotationView.h;
            int i4 = mBRotationView.f;
            int i5 = mBRotationView.j;
            mBRotationView.h = i3 % i4;
            mBRotationView.i = i5 - (i3 / i4);
            if (Math.abs(mBRotationView.h) > mBRotationView.f / 2) {
                i2 = mBRotationView.a(2);
            } else {
                i2 = mBRotationView.a(3);
            }
            if (mBRotationView.k != i2) {
                mBRotationView.k = i2;
            }
            mBRotationView.invalidate();
            if (mBRotationView.n) {
                mBRotationView.postDelayed(mBRotationView.a, (long) (1000 / mBRotationView.g));
            }
        }
    }
}
