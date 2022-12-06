package com.google.zxing.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.zxing.ResultPoint;
import com.google.zxing.camera.CameraManager;
import com.shix.shixipc.C1113R;
import java.util.Collection;
import java.util.HashSet;

public final class ViewfinderView extends View {
    private static final long ANIMATION_DELAY = 10;
    private static final int CORNER_RECT_HEIGHT = 40;
    private static final int CORNER_RECT_WIDTH = 8;
    private static final int OPAQUE = 255;
    private static final int[] SCANNER_ALPHA = {0, 64, 128, 192, 255, 192, 128, 64};
    private static final int SCANNER_LINE_HEIGHT = 10;
    private static final int SCANNER_LINE_MOVE_DISTANCE = 5;
    public static int scannerEnd = 0;
    public static int scannerStart = 0;
    private final int cornerColor;
    private final int frameColor;
    private final String labelText;
    private final int labelTextColor;
    private final float labelTextSize;
    private final int laserColor;
    private Collection<ResultPoint> lastPossibleResultPoints;
    private final int maskColor;
    private final Paint paint = new Paint();
    private Collection<ResultPoint> possibleResultPoints;
    private Bitmap resultBitmap;
    private final int resultColor;
    private final int resultPointColor;
    private int scannerAlpha;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1113R.styleable.ViewfinderView);
        this.laserColor = obtainStyledAttributes.getColor(5, MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        this.cornerColor = obtainStyledAttributes.getColor(0, MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        this.frameColor = obtainStyledAttributes.getColor(1, ViewCompat.MEASURED_SIZE_MASK);
        this.resultPointColor = obtainStyledAttributes.getColor(8, -1056964864);
        this.maskColor = obtainStyledAttributes.getColor(6, 1610612736);
        this.resultColor = obtainStyledAttributes.getColor(7, -1342177280);
        this.labelTextColor = obtainStyledAttributes.getColor(3, -1862270977);
        this.labelText = obtainStyledAttributes.getString(2);
        this.labelTextSize = obtainStyledAttributes.getFloat(4, 36.0f);
        this.paint.setAntiAlias(true);
        this.scannerAlpha = 0;
        this.possibleResultPoints = new HashSet(5);
    }

    public void onDraw(Canvas canvas) {
        Rect framingRect = CameraManager.get().getFramingRect();
        if (framingRect != null) {
            if (scannerStart == 0 || scannerEnd == 0) {
                scannerStart = framingRect.top;
                scannerEnd = framingRect.bottom;
            }
            drawExterior(canvas, framingRect, canvas.getWidth(), canvas.getHeight());
            if (this.resultBitmap != null) {
                this.paint.setAlpha(255);
                canvas.drawBitmap(this.resultBitmap, (float) framingRect.left, (float) framingRect.top, this.paint);
                return;
            }
            drawFrame(canvas, framingRect);
            drawCorner(canvas, framingRect);
            drawTextInfo(canvas, framingRect);
            drawLaserScanner(canvas, framingRect);
            Collection<ResultPoint> collection = this.possibleResultPoints;
            Collection<ResultPoint> collection2 = this.lastPossibleResultPoints;
            if (collection.isEmpty()) {
                this.lastPossibleResultPoints = null;
            } else {
                this.possibleResultPoints = new HashSet(5);
                this.lastPossibleResultPoints = collection;
                this.paint.setAlpha(255);
                this.paint.setColor(this.resultPointColor);
                for (ResultPoint next : collection) {
                    canvas.drawCircle(((float) framingRect.left) + next.getX(), ((float) framingRect.top) + next.getY(), 6.0f, this.paint);
                }
            }
            if (collection2 != null) {
                this.paint.setAlpha(127);
                this.paint.setColor(this.resultPointColor);
                for (ResultPoint next2 : collection2) {
                    canvas.drawCircle(((float) framingRect.left) + next2.getX(), ((float) framingRect.top) + next2.getY(), 3.0f, this.paint);
                }
            }
            postInvalidateDelayed(ANIMATION_DELAY, framingRect.left, framingRect.top, framingRect.right, framingRect.bottom);
        }
    }

    private void drawTextInfo(Canvas canvas, Rect rect) {
        this.paint.setColor(this.labelTextColor);
        this.paint.setTextSize(this.labelTextSize);
        this.paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(this.labelText, (float) (rect.left + (rect.width() / 2)), ((float) rect.bottom) + 60.0f, this.paint);
    }

    private void drawCorner(Canvas canvas, Rect rect) {
        this.paint.setColor(this.cornerColor);
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) rect.left, (float) rect.top, (float) (rect.left + 8), (float) (rect.top + 40), this.paint);
        canvas2.drawRect((float) rect.left, (float) rect.top, (float) (rect.left + 40), (float) (rect.top + 8), this.paint);
        canvas2.drawRect((float) (rect.right - 8), (float) rect.top, (float) rect.right, (float) (rect.top + 40), this.paint);
        canvas2.drawRect((float) (rect.right - 40), (float) rect.top, (float) rect.right, (float) (rect.top + 8), this.paint);
        canvas2.drawRect((float) rect.left, (float) (rect.bottom - 8), (float) (rect.left + 40), (float) rect.bottom, this.paint);
        canvas2.drawRect((float) rect.left, (float) (rect.bottom - 40), (float) (rect.left + 8), (float) rect.bottom, this.paint);
        canvas2.drawRect((float) (rect.right - 8), (float) (rect.bottom - 40), (float) rect.right, (float) rect.bottom, this.paint);
        canvas2.drawRect((float) (rect.right - 40), (float) (rect.bottom - 8), (float) rect.right, (float) rect.bottom, this.paint);
    }

    private void drawLaserScanner(Canvas canvas, Rect rect) {
        Rect rect2 = rect;
        this.paint.setColor(this.laserColor);
        LinearGradient linearGradient = new LinearGradient((float) rect2.left, (float) scannerStart, (float) rect2.left, (float) (scannerStart + 10), shadeColor(this.laserColor), this.laserColor, Shader.TileMode.MIRROR);
        float width = (float) (rect2.left + (rect.width() / 2));
        float f = (float) (scannerStart + 5);
        int i = this.laserColor;
        RadialGradient radialGradient = new RadialGradient(width, f, 360.0f, i, shadeColor(i), Shader.TileMode.MIRROR);
        new SweepGradient((float) (rect2.left + (rect.width() / 2)), (float) (scannerStart + 10), shadeColor(this.laserColor), this.laserColor);
        new ComposeShader(radialGradient, linearGradient, PorterDuff.Mode.ADD);
        this.paint.setShader(radialGradient);
        if (scannerStart <= scannerEnd) {
            canvas.drawOval(new RectF((float) (rect2.left + 20), (float) scannerStart, (float) (rect2.right - 20), (float) (scannerStart + 10)), this.paint);
            scannerStart += 5;
        } else {
            scannerStart = rect2.top;
        }
        this.paint.setShader((Shader) null);
    }

    public int shadeColor(int i) {
        String hexString = Integer.toHexString(i);
        return Integer.valueOf("20" + hexString.substring(2), 16).intValue();
    }

    private void drawFrame(Canvas canvas, Rect rect) {
        this.paint.setColor(this.frameColor);
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) rect.left, (float) rect.top, (float) (rect.right + 1), (float) (rect.top + 2), this.paint);
        canvas2.drawRect((float) rect.left, (float) (rect.top + 2), (float) (rect.left + 2), (float) (rect.bottom - 1), this.paint);
        canvas2.drawRect((float) (rect.right - 1), (float) rect.top, (float) (rect.right + 1), (float) (rect.bottom - 1), this.paint);
        canvas2.drawRect((float) rect.left, (float) (rect.bottom - 1), (float) (rect.right + 1), (float) (rect.bottom + 1), this.paint);
    }

    private void drawExterior(Canvas canvas, Rect rect, int i, int i2) {
        Rect rect2 = rect;
        this.paint.setColor(this.resultBitmap != null ? this.resultColor : this.maskColor);
        float f = (float) i;
        canvas.drawRect(0.0f, 0.0f, f, (float) rect2.top, this.paint);
        canvas.drawRect(0.0f, (float) rect2.top, (float) rect2.left, (float) (rect2.bottom + 1), this.paint);
        Canvas canvas2 = canvas;
        float f2 = f;
        canvas2.drawRect((float) (rect2.right + 1), (float) rect2.top, f2, (float) (rect2.bottom + 1), this.paint);
        canvas2.drawRect(0.0f, (float) (rect2.bottom + 1), f2, (float) i2, this.paint);
    }

    public void drawViewfinder() {
        this.resultBitmap = null;
        invalidate();
    }

    public void drawResultBitmap(Bitmap bitmap) {
        this.resultBitmap = bitmap;
        invalidate();
    }

    public void addPossibleResultPoint(ResultPoint resultPoint) {
        this.possibleResultPoints.add(resultPoint);
    }
}
