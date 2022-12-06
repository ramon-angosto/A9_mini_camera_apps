package com.shix.shixipc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.shix.shixipc.C1113R;

public class SwitchView extends View {
    private static final int STATE_SWITCH_OFF = 1;
    private static final int STATE_SWITCH_OFF2 = 2;
    private static final int STATE_SWITCH_ON = 4;
    private static final int STATE_SWITCH_ON2 = 3;
    private final float ANIMATION_SPEED;
    private final int DEFAULT_COLOR_PRIMARY;
    private final int DEFAULT_COLOR_PRIMARY_DARK;
    private final float RATIO_ASPECT;
    private int actuallyDrawingAreaBottom;
    private int actuallyDrawingAreaLeft;
    private int actuallyDrawingAreaRight;
    private int actuallyDrawingAreaTop;
    private float bAnim;
    private float bBottom;
    private float bLeft;
    private float bOff2LeftX;
    private float bOffLeftX;
    private float bOffset;
    private float bOn2LeftX;
    private float bOnLeftX;
    private final Path bPath;
    private float bRadius;
    private final RectF bRectF;
    private float bRight;
    private float bStrokeWidth;
    private float bTop;
    private float bWidth;
    private int colorPrimary;
    private int colorPrimaryDark;
    private boolean hasShadow;
    private final AccelerateInterpolator interpolator;
    private boolean isCanVisibleDrawing;
    private boolean isOpened;
    private int lastState;
    private OnStateChangedListener listener;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private int mWidth;
    private final Paint paint;
    private float sAnim;
    private float sBottom;
    private float sCenterX;
    private float sCenterY;
    private float sHeight;
    private float sLeft;
    private final Path sPath;
    private float sRight;
    private float sScale;
    private float sTop;
    private float sWidth;
    private RadialGradient shadowGradient;
    private float shadowReservedHeight;
    private int state;

    public interface OnStateChangedListener {
        void toggleToOff(SwitchView switchView);

        void toggleToOn(SwitchView switchView);
    }

    public SwitchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEFAULT_COLOR_PRIMARY = -11806877;
        this.DEFAULT_COLOR_PRIMARY_DARK = -12925358;
        this.RATIO_ASPECT = 0.68f;
        this.ANIMATION_SPEED = 0.1f;
        this.interpolator = new AccelerateInterpolator(2.0f);
        this.paint = new Paint();
        this.sPath = new Path();
        this.bPath = new Path();
        this.bRectF = new RectF();
        this.isCanVisibleDrawing = false;
        this.listener = new OnStateChangedListener() {
            public void toggleToOn(SwitchView switchView) {
                SwitchView.this.toggleSwitch(true);
            }

            public void toggleToOff(SwitchView switchView) {
                SwitchView.this.toggleSwitch(false);
            }
        };
        setLayerType(1, (Paint) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1113R.styleable.SwitchView);
        this.colorPrimary = obtainStyledAttributes.getColor(2, -11806877);
        this.colorPrimaryDark = obtainStyledAttributes.getColor(3, -12925358);
        this.hasShadow = obtainStyledAttributes.getBoolean(0, true);
        this.isOpened = obtainStyledAttributes.getBoolean(1, false);
        this.state = this.isOpened ? 4 : 1;
        this.lastState = this.state;
        obtainStyledAttributes.recycle();
        if (this.colorPrimary == -11806877 && this.colorPrimaryDark == -12925358) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    TypedValue typedValue = new TypedValue();
                    context.getTheme().resolveAttribute(16843827, typedValue, true);
                    if (typedValue.data > 0) {
                        this.colorPrimary = typedValue.data;
                    }
                    TypedValue typedValue2 = new TypedValue();
                    context.getTheme().resolveAttribute(16843828, typedValue2, true);
                    if (typedValue2.data > 0) {
                        this.colorPrimaryDark = typedValue2.data;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setColor(int i, int i2) {
        this.colorPrimary = i;
        this.colorPrimaryDark = i2;
        invalidate();
    }

    public void setShadow(boolean z) {
        this.hasShadow = z;
        invalidate();
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    public void setOpened(boolean z) {
        int i = z ? 4 : 1;
        if (i != this.state) {
            refreshState(i);
        }
    }

    public void toggleSwitch(boolean z) {
        int i;
        int i2 = z ? 4 : 1;
        int i3 = this.state;
        if (i2 != i3) {
            if ((i2 == 4 && (i3 == 1 || i3 == 2)) || (i2 == 1 && ((i = this.state) == 4 || i == 3))) {
                this.sAnim = 1.0f;
            }
            this.bAnim = 1.0f;
            refreshState(i2);
        }
    }

    private void refreshState(int i) {
        if (!this.isOpened && i == 4) {
            this.isOpened = true;
        } else if (this.isOpened && i == 1) {
            this.isOpened = false;
        }
        this.lastState = this.state;
        this.state = i;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode != 1073741824) {
            int paddingLeft = ((int) ((getResources().getDisplayMetrics().density * 56.0f) + 0.5f)) + getPaddingLeft() + getPaddingRight();
            size = mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
        }
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 != 1073741824) {
            int paddingTop = ((int) (((float) size) * 0.68f)) + getPaddingTop() + getPaddingBottom();
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(paddingTop, size2) : paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        this.isCanVisibleDrawing = this.mWidth > getPaddingLeft() + getPaddingRight() && this.mHeight > getPaddingTop() + getPaddingBottom();
        if (this.isCanVisibleDrawing) {
            float paddingLeft = (float) ((this.mWidth - getPaddingLeft()) - getPaddingRight());
            float f = paddingLeft * 0.68f;
            float paddingTop = (float) ((this.mHeight - getPaddingTop()) - getPaddingBottom());
            if (f < paddingTop) {
                this.actuallyDrawingAreaLeft = getPaddingLeft();
                this.actuallyDrawingAreaRight = this.mWidth - getPaddingRight();
                int i5 = ((int) (paddingTop - f)) / 2;
                this.actuallyDrawingAreaTop = getPaddingTop() + i5;
                this.actuallyDrawingAreaBottom = (getHeight() - getPaddingBottom()) - i5;
            } else {
                int i6 = ((int) (paddingLeft - (paddingTop / 0.68f))) / 2;
                this.actuallyDrawingAreaLeft = getPaddingLeft() + i6;
                this.actuallyDrawingAreaRight = (getWidth() - getPaddingRight()) - i6;
                this.actuallyDrawingAreaTop = getPaddingTop();
                this.actuallyDrawingAreaBottom = getHeight() - getPaddingBottom();
            }
            int i7 = this.actuallyDrawingAreaBottom;
            int i8 = this.actuallyDrawingAreaTop;
            this.shadowReservedHeight = (float) ((int) (((float) (i7 - i8)) * 0.09f));
            this.sLeft = (float) this.actuallyDrawingAreaLeft;
            float f2 = this.shadowReservedHeight;
            this.sTop = ((float) i8) + f2;
            this.sRight = (float) this.actuallyDrawingAreaRight;
            this.sBottom = ((float) i7) - f2;
            float f3 = this.sRight;
            float f4 = this.sLeft;
            this.sWidth = f3 - f4;
            float f5 = this.sBottom;
            float f6 = this.sTop;
            this.sHeight = f5 - f6;
            this.sCenterX = (f3 + f4) / 2.0f;
            this.sCenterY = (f5 + f6) / 2.0f;
            this.bLeft = f4;
            this.bTop = f6;
            this.bBottom = f5;
            this.bWidth = f5 - f6;
            float f7 = this.bWidth;
            this.bRight = f4 + f7;
            float f8 = f7 / 2.0f;
            this.bRadius = 0.95f * f8;
            float f9 = this.bRadius;
            this.bOffset = 0.0f * f9;
            this.bStrokeWidth = (f8 - f9) * 2.0f;
            this.bOnLeftX = f3 - f7;
            float f10 = this.bOnLeftX;
            float f11 = this.bOffset;
            this.bOn2LeftX = f10 - f11;
            this.bOffLeftX = f4;
            this.bOff2LeftX = this.bOffLeftX + f11;
            this.sScale = 1.0f - (this.bStrokeWidth / this.sHeight);
            this.sPath.reset();
            RectF rectF = new RectF();
            rectF.top = this.sTop;
            rectF.bottom = this.sBottom;
            float f12 = this.sLeft;
            rectF.left = f12;
            rectF.right = f12 + this.sHeight;
            this.sPath.arcTo(rectF, 90.0f, 180.0f);
            float f13 = this.sRight;
            rectF.left = f13 - this.sHeight;
            rectF.right = f13;
            this.sPath.arcTo(rectF, 270.0f, 180.0f);
            this.sPath.close();
            RectF rectF2 = this.bRectF;
            float f14 = this.bLeft;
            rectF2.left = f14;
            float f15 = this.bRight;
            rectF2.right = f15;
            float f16 = this.bTop;
            float f17 = this.bStrokeWidth;
            rectF2.top = (f17 / 2.0f) + f16;
            float f18 = this.bBottom;
            rectF2.bottom = f18 - (f17 / 2.0f);
            this.shadowGradient = new RadialGradient((f15 + f14) / 2.0f, (f18 + f16) / 2.0f, this.bRadius, -16777216, 0, Shader.TileMode.CLAMP);
        }
    }

    private void calcBPath(float f) {
        this.bPath.reset();
        RectF rectF = this.bRectF;
        float f2 = this.bLeft;
        float f3 = this.bStrokeWidth;
        rectF.left = f2 + (f3 / 2.0f);
        rectF.right = this.bRight - (f3 / 2.0f);
        this.bPath.arcTo(rectF, 90.0f, 180.0f);
        RectF rectF2 = this.bRectF;
        float f4 = this.bLeft;
        float f5 = this.bOffset;
        float f6 = this.bStrokeWidth;
        rectF2.left = f4 + (f * f5) + (f6 / 2.0f);
        rectF2.right = (this.bRight + (f * f5)) - (f6 / 2.0f);
        this.bPath.arcTo(rectF2, 270.0f, 180.0f);
        this.bPath.close();
    }

    private float calcBTranslate(float f) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i = this.state;
        int i2 = i - this.lastState;
        if (i2 != -3) {
            if (i2 != -2) {
                if (i2 != -1) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i == 1) {
                                    f2 = this.bOffLeftX;
                                } else if (i == 4) {
                                    f2 = this.bOnLeftX;
                                }
                                return f2 - this.bOffLeftX;
                            }
                            f5 = this.bOnLeftX;
                            f6 = this.bOffLeftX;
                        } else if (i == 4) {
                            f5 = this.bOnLeftX;
                            f6 = this.bOffLeftX;
                        } else if (i == 4) {
                            f5 = this.bOn2LeftX;
                            f6 = this.bOffLeftX;
                        }
                    } else if (i == 2) {
                        f2 = this.bOffLeftX;
                        return f2 - this.bOffLeftX;
                    } else if (i == 4) {
                        f5 = this.bOnLeftX;
                        f6 = this.bOn2LeftX;
                    }
                    f2 = f5 - ((f5 - f6) * f);
                    return f2 - this.bOffLeftX;
                } else if (i == 3) {
                    f4 = this.bOn2LeftX;
                    f3 = this.bOnLeftX;
                } else if (i == 1) {
                    f2 = this.bOffLeftX;
                    return f2 - this.bOffLeftX;
                }
            } else if (i == 1) {
                f4 = this.bOffLeftX;
                f3 = this.bOn2LeftX;
            } else if (i == 2) {
                f4 = this.bOff2LeftX;
                f3 = this.bOnLeftX;
            }
            f2 = 0.0f;
            return f2 - this.bOffLeftX;
        }
        f4 = this.bOffLeftX;
        f3 = this.bOnLeftX;
        f2 = f4 + ((f3 - f4) * f);
        return f2 - this.bOffLeftX;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isCanVisibleDrawing) {
            boolean z = true;
            this.paint.setAntiAlias(true);
            int i = this.state;
            boolean z2 = i == 4 || i == 3;
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(z2 ? this.colorPrimary : -1842205);
            canvas.drawPath(this.sPath, this.paint);
            float f = this.sAnim;
            this.sAnim = f - 0.1f > 0.0f ? f - 0.1f : 0.0f;
            float f2 = this.bAnim;
            this.bAnim = f2 - 0.1f > 0.0f ? f2 - 0.1f : 0.0f;
            float interpolation = this.interpolator.getInterpolation(this.sAnim);
            float interpolation2 = this.interpolator.getInterpolation(this.bAnim);
            float f3 = this.sScale * (z2 ? interpolation : 1.0f - interpolation);
            float f4 = (this.sRight - this.sCenterX) - this.bRadius;
            if (z2) {
                interpolation = 1.0f - interpolation;
            }
            canvas.save();
            canvas.scale(f3, f3, this.sCenterX + (f4 * interpolation), this.sCenterY);
            this.paint.setColor(-1);
            canvas.drawPath(this.sPath, this.paint);
            canvas.restore();
            canvas.save();
            canvas.translate(calcBTranslate(interpolation2), this.shadowReservedHeight);
            int i2 = this.state;
            if (!(i2 == 3 || i2 == 2)) {
                z = false;
            }
            if (z) {
                interpolation2 = 1.0f - interpolation2;
            }
            calcBPath(interpolation2);
            if (this.hasShadow) {
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setColor(-13421773);
                this.paint.setShader(this.shadowGradient);
                canvas.drawPath(this.bPath, this.paint);
                this.paint.setShader((Shader) null);
            }
            canvas.translate(0.0f, -this.shadowReservedHeight);
            float f5 = this.bWidth;
            canvas.scale(0.98f, 0.98f, f5 / 2.0f, f5 / 2.0f);
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(-1);
            canvas.drawPath(this.bPath, this.paint);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(this.bStrokeWidth * 0.5f);
            this.paint.setColor(z2 ? this.colorPrimaryDark : -4210753);
            canvas.drawPath(this.bPath, this.paint);
            canvas.restore();
            this.paint.reset();
            if (this.sAnim > 0.0f || this.bAnim > 0.0f) {
                invalidate();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = this.state;
        if ((i == 4 || i == 1) && this.sAnim * this.bAnim == 0.0f) {
            int action = motionEvent.getAction();
            if (action == 0) {
                return true;
            }
            if (action == 1) {
                int i2 = this.state;
                this.lastState = i2;
                this.bAnim = 1.0f;
                if (i2 == 1) {
                    refreshState(2);
                    this.listener.toggleToOn(this);
                } else if (i2 == 4) {
                    refreshState(3);
                    this.listener.toggleToOff(this);
                }
                View.OnClickListener onClickListener = this.mOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        if (onStateChangedListener != null) {
            this.listener = onStateChangedListener;
            return;
        }
        throw new IllegalArgumentException("empty listener");
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        boolean unused = savedState.isOpened = this.isOpened;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.isOpened = savedState.isOpened;
        this.state = this.isOpened ? 4 : 1;
        invalidate();
    }

    static final class SavedState extends View.BaseSavedState {
        /* access modifiers changed from: private */
        public boolean isOpened;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.isOpened = 1 != parcel.readInt() ? false : true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpened ? 1 : 0);
        }
    }
}
