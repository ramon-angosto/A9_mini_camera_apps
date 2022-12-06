package object.p2pipcam.zxingtwodimensioncode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.media.TransportMediator;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.jxl.app.littlestars.project.R;
import java.util.Collection;
import java.util.HashSet;

public final class ViewfinderView extends View {
    private static final long ANIMATION_DELAY = 100;
    private static final int OPAQUE = 255;
    private static final int[] SCANNER_ALPHA = {0, 64, 128, 192, 255, 192, 128, 64};
    private final int frameColor;
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
        Resources resources = getResources();
        this.maskColor = resources.getColor(R.color.viewfinder_mask);
        this.resultColor = resources.getColor(R.color.result_view);
        this.frameColor = resources.getColor(R.color.viewfinder_frame);
        this.laserColor = resources.getColor(R.color.viewfinder_laser);
        this.resultPointColor = resources.getColor(R.color.possible_result_points);
        this.scannerAlpha = 0;
        this.possibleResultPoints = new HashSet(5);
    }

    public void onDraw(Canvas canvas) {
        Rect framingRect = CameraManager.get().getFramingRect();
        if (framingRect != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.paint.setColor(this.resultBitmap != null ? this.resultColor : this.maskColor);
            float f = (float) width;
            canvas.drawRect(0.0f, 0.0f, f, (float) framingRect.top, this.paint);
            canvas.drawRect(0.0f, (float) framingRect.top, (float) framingRect.left, (float) (framingRect.bottom + 1), this.paint);
            float f2 = f;
            canvas.drawRect((float) (framingRect.right + 1), (float) framingRect.top, f2, (float) (framingRect.bottom + 1), this.paint);
            canvas.drawRect(0.0f, (float) (framingRect.bottom + 1), f2, (float) height, this.paint);
            if (this.resultBitmap != null) {
                this.paint.setAlpha(255);
                canvas.drawBitmap(this.resultBitmap, (float) framingRect.left, (float) framingRect.top, this.paint);
                return;
            }
            this.paint.setColor(this.frameColor);
            canvas.drawRect((float) framingRect.left, (float) framingRect.top, (float) (framingRect.right + 1), (float) (framingRect.top + 2), this.paint);
            canvas.drawRect((float) framingRect.left, (float) (framingRect.top + 2), (float) (framingRect.left + 2), (float) (framingRect.bottom - 1), this.paint);
            canvas.drawRect((float) (framingRect.right - 1), (float) framingRect.top, (float) (framingRect.right + 1), (float) (framingRect.bottom - 1), this.paint);
            canvas.drawRect((float) framingRect.left, (float) (framingRect.bottom - 1), (float) (framingRect.right + 1), (float) (framingRect.bottom + 1), this.paint);
            this.paint.setColor(this.laserColor);
            this.paint.setAlpha(SCANNER_ALPHA[this.scannerAlpha]);
            this.scannerAlpha = (this.scannerAlpha + 1) % SCANNER_ALPHA.length;
            int height2 = (framingRect.height() / 2) + framingRect.top;
            canvas.drawRect((float) (framingRect.left + 2), (float) (height2 - 1), (float) (framingRect.right - 1), (float) (height2 + 2), this.paint);
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
                this.paint.setAlpha(TransportMediator.KEYCODE_MEDIA_PAUSE);
                this.paint.setColor(this.resultPointColor);
                for (ResultPoint next2 : collection2) {
                    canvas.drawCircle(((float) framingRect.left) + next2.getX(), ((float) framingRect.top) + next2.getY(), 3.0f, this.paint);
                }
            }
            postInvalidateDelayed(ANIMATION_DELAY, framingRect.left, framingRect.top, framingRect.right, framingRect.bottom);
        }
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
