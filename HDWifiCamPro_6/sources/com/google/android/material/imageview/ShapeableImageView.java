package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class ShapeableImageView extends AppCompatImageView implements Shapeable {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_ShapeableImageView;
    private final Paint borderPaint;
    private final Paint clearPaint;
    /* access modifiers changed from: private */
    public final RectF destination;
    private Path maskPath;
    private final RectF maskRect;
    private final Path path;
    private final ShapeAppearancePathProvider pathProvider;
    /* access modifiers changed from: private */
    public final MaterialShapeDrawable shadowDrawable;
    /* access modifiers changed from: private */
    public ShapeAppearanceModel shapeAppearanceModel;
    private ColorStateList strokeColor;
    private float strokeWidth;

    public ShapeableImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.pathProvider = new ShapeAppearancePathProvider();
        this.path = new Path();
        Context context2 = getContext();
        this.clearPaint = new Paint();
        this.clearPaint.setAntiAlias(true);
        this.clearPaint.setColor(-1);
        this.clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.destination = new RectF();
        this.maskRect = new RectF();
        this.maskPath = new Path();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.ShapeableImageView, i, DEF_STYLE_RES);
        this.strokeColor = MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.ShapeableImageView_strokeColor);
        this.strokeWidth = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
        this.borderPaint = new Paint();
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setAntiAlias(true);
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES).build();
        this.shadowDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new OutlineProvider());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        setLayerType(0, (Paint) null);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, (Paint) null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.maskPath, this.clearPaint);
        drawStroke(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateShapeMask(i, i2);
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        this.shadowDrawable.setShapeAppearanceModel(shapeAppearanceModel2);
        updateShapeMask(getWidth(), getHeight());
        invalidate();
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    private void updateShapeMask(int i, int i2) {
        this.destination.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i - getPaddingRight()), (float) (i2 - getPaddingBottom()));
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.destination, this.path);
        this.maskPath.rewind();
        this.maskPath.addPath(this.path);
        this.maskRect.set(0.0f, 0.0f, (float) i, (float) i2);
        this.maskPath.addRect(this.maskRect, Path.Direction.CCW);
    }

    private void drawStroke(Canvas canvas) {
        if (this.strokeColor != null) {
            this.borderPaint.setStrokeWidth(this.strokeWidth);
            int colorForState = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
            if (this.strokeWidth > 0.0f && colorForState != 0) {
                this.borderPaint.setColor(colorForState);
                canvas.drawPath(this.path, this.borderPaint);
            }
        }
    }

    public void setStrokeColorResource(int i) {
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
    }

    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public void setStrokeWidth(float f) {
        if (this.strokeWidth != f) {
            this.strokeWidth = f;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i) {
        setStrokeWidth((float) getResources().getDimensionPixelSize(i));
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.strokeColor = colorStateList;
        invalidate();
    }

    class OutlineProvider extends ViewOutlineProvider {
        private final Rect rect = new Rect();

        OutlineProvider() {
        }

        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.shapeAppearanceModel != null) {
                ShapeableImageView.this.destination.round(this.rect);
                ShapeableImageView.this.shadowDrawable.setBounds(this.rect);
                ShapeableImageView.this.shadowDrawable.getOutline(outline);
            }
        }
    }
}
