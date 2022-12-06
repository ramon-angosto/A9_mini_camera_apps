package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.animation.Animation;
import android.widget.ImageView;

class CircleImageView extends ImageView {
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private Animation.AnimationListener mListener;
    /* access modifiers changed from: private */
    public int mShadowRadius;

    public CircleImageView(Context context, int i, float f) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (f * f2 * 2.0f);
        int i3 = (int) (Y_OFFSET * f2);
        int i4 = (int) (0.0f * f2);
        this.mShadowRadius = (int) (SHADOW_RADIUS * f2);
        if (elevationSupported()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new OvalShadow(this.mShadowRadius, i2));
            ViewCompat.setLayerType(this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.mShadowRadius, (float) i4, (float) i3, KEY_SHADOW_COLOR);
            int i5 = this.mShadowRadius;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    private boolean elevationSupported() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!elevationSupported()) {
            setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColorRes(int i) {
        setBackgroundColor(getContext().getResources().getColor(i));
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    private class OvalShadow extends OvalShape {
        private int mCircleDiameter;
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint = new Paint();

        public OvalShadow(int i, int i2) {
            int unused = CircleImageView.this.mShadowRadius = i;
            this.mCircleDiameter = i2;
            int i3 = this.mCircleDiameter;
            this.mRadialGradient = new RadialGradient((float) (i3 / 2), (float) (i3 / 2), (float) CircleImageView.this.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.mShadowPaint.setShader(this.mRadialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            float width = (float) (CircleImageView.this.getWidth() / 2);
            float height = (float) (CircleImageView.this.getHeight() / 2);
            canvas.drawCircle(width, height, (float) ((this.mCircleDiameter / 2) + CircleImageView.this.mShadowRadius), this.mShadowPaint);
            canvas.drawCircle(width, height, (float) (this.mCircleDiameter / 2), paint);
        }
    }
}
