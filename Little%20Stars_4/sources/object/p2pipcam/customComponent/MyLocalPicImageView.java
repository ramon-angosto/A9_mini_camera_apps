package object.p2pipcam.customComponent;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import shix.ihdbell.project.ShowLocalPictureActivity;

public class MyLocalPicImageView extends ImageView {
    static final float SCALE_RATE = 1.25f;
    private static final String TAG = "ImageViewTouchBase";
    float _dy = 0.0f;
    protected Bitmap image = null;
    private int imageHeight;
    private int imageWidth;
    protected Matrix mBaseMatrix = new Matrix();
    private final Matrix mDisplayMatrix = new Matrix();
    protected Handler mHandler = new Handler();
    private final float[] mMatrixValues = new float[9];
    float mMaxZoom = 2.0f;
    float mMinZoom;
    protected Matrix mSuppMatrix = new Matrix();
    int mThisHeight = -1;
    int mThisWidth = -1;
    private float scaleRate;

    public MyLocalPicImageView(Context context, int i, int i2) {
        super(context);
        Log.d("test", "ImageWidth:" + i + "  ImageHeight:" + i2);
        this.imageHeight = i2;
        this.imageWidth = i;
        if (i > 640 && i2 > 480) {
            this.mMaxZoom = 1.5f;
        } else if (i <= 320 || i > 640 || i2 <= 240 || i2 > 480) {
            this.mMaxZoom = 2.0f;
        } else {
            this.mMaxZoom = 2.0f;
        }
        init();
    }

    public MyLocalPicImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet);
        this.imageHeight = i2;
        this.imageWidth = i;
        init();
    }

    private void arithScaleRate() {
        this.scaleRate = Math.min(((float) ShowLocalPictureActivity.screenWidth) / ((float) this.imageWidth), ((float) ShowLocalPictureActivity.screenHeight) / ((float) this.imageHeight));
    }

    public float getScaleRate() {
        return this.scaleRate;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public void setImageWidth(int i) {
        this.imageWidth = i;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public void setImageHeight(int i) {
        this.imageHeight = i;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !keyEvent.isTracking() || keyEvent.isCanceled() || getScale() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        zoomTo(1.0f);
        return true;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.image = bitmap;
        arithScaleRate();
        zoomTo(this.scaleRate, ((float) ShowLocalPictureActivity.screenWidth) / 2.0f, ((float) ShowLocalPictureActivity.screenHeight) / 2.0f);
        layoutToCenter();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void center(boolean r7, boolean r8) {
        /*
            r6 = this;
            android.graphics.Bitmap r0 = r6.image
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.graphics.Matrix r0 = r6.getImageViewMatrix()
            android.graphics.RectF r1 = new android.graphics.RectF
            android.graphics.Bitmap r2 = r6.image
            int r2 = r2.getWidth()
            float r2 = (float) r2
            android.graphics.Bitmap r3 = r6.image
            int r3 = r3.getHeight()
            float r3 = (float) r3
            r4 = 0
            r1.<init>(r4, r4, r2, r3)
            r0.mapRect(r1)
            float r0 = r1.height()
            float r2 = r1.width()
            r3 = 1073741824(0x40000000, float:2.0)
            if (r8 == 0) goto L_0x0053
            int r8 = r6.getHeight()
            float r8 = (float) r8
            int r5 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x003b
            float r8 = r8 - r0
            float r8 = r8 / r3
            float r0 = r1.top
        L_0x0039:
            float r8 = r8 - r0
            goto L_0x0054
        L_0x003b:
            float r0 = r1.top
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0045
            float r8 = r1.top
            float r8 = -r8
            goto L_0x0054
        L_0x0045:
            float r0 = r1.bottom
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0053
            int r8 = r6.getHeight()
            float r8 = (float) r8
            float r0 = r1.bottom
            goto L_0x0039
        L_0x0053:
            r8 = 0
        L_0x0054:
            if (r7 == 0) goto L_0x0079
            int r7 = r6.getWidth()
            float r7 = (float) r7
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0066
            float r7 = r7 - r2
            float r7 = r7 / r3
            float r0 = r1.left
        L_0x0063:
            float r4 = r7 - r0
            goto L_0x0079
        L_0x0066:
            float r0 = r1.left
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0070
            float r7 = r1.left
            float r4 = -r7
            goto L_0x0079
        L_0x0070:
            float r0 = r1.right
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0079
            float r0 = r1.right
            goto L_0x0063
        L_0x0079:
            r6.postTranslate(r4, r8)
            android.graphics.Matrix r7 = r6.getImageViewMatrix()
            r6.setImageMatrix(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: object.p2pipcam.customComponent.MyLocalPicImageView.center(boolean, boolean):void");
    }

    private void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void layoutToCenter() {
        float scale = ((float) this.imageWidth) * getScale();
        float scale2 = ((float) this.imageHeight) * getScale();
        Log.d("tag", "width:" + scale);
        Log.d("tag", "height:" + scale2);
        float f = ((float) ShowLocalPictureActivity.screenWidth) - scale;
        float f2 = ((float) ShowLocalPictureActivity.screenHeight) - scale2;
        float f3 = 0.0f;
        float f4 = f > 0.0f ? f / 2.0f : 0.0f;
        if (f2 > 0.0f) {
            f3 = f2 / 2.0f;
        }
        postTranslate(f4, f3);
        setImageMatrix(getImageViewMatrix());
    }

    /* access modifiers changed from: protected */
    public float getValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        this.mMinZoom = (((float) ShowLocalPictureActivity.screenWidth) / 2.0f) / ((float) this.imageWidth);
        return this.mMatrixValues[i];
    }

    /* access modifiers changed from: protected */
    public float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    /* access modifiers changed from: protected */
    public float getScale() {
        return getScale(this.mSuppMatrix);
    }

    /* access modifiers changed from: protected */
    public Matrix getImageViewMatrix() {
        this.mDisplayMatrix.set(this.mBaseMatrix);
        this.mDisplayMatrix.postConcat(this.mSuppMatrix);
        return this.mDisplayMatrix;
    }

    /* access modifiers changed from: protected */
    public float maxZoom() {
        Bitmap bitmap = this.image;
        if (bitmap == null) {
            return 1.0f;
        }
        return Math.max(((float) bitmap.getWidth()) / ((float) this.mThisWidth), ((float) this.image.getHeight()) / ((float) this.mThisHeight)) * 4.0f;
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float f, float f2, float f3) {
        Log.d("tg", "zoomTo scale:" + f);
        float f4 = this.mMaxZoom;
        if (f > f4) {
            Log.d("tag", "img max scale:" + f4);
        } else {
            f4 = this.mMinZoom;
            if (f < f4) {
                Log.d("tag", "img min scale:" + f4);
            } else {
                f4 = f;
            }
        }
        float scale = getScale();
        Log.d("tg", "oldScale:" + scale);
        float f5 = f4 / scale;
        Log.d("tag", "deltaScale:" + f5);
        this.mSuppMatrix.postScale(f5, f5, f2, f3);
        setImageMatrix(getImageViewMatrix());
        center(true, true);
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float f, float f2, float f3, float f4) {
        final float scale = (f - getScale()) / f4;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        final float f5 = f4;
        final float f6 = f2;
        final float f7 = f3;
        this.mHandler.post(new Runnable() {
            public void run() {
                float min = Math.min(f5, (float) (System.currentTimeMillis() - currentTimeMillis));
                MyLocalPicImageView.this.zoomTo(scale2 + (scale * min), f6, f7);
                if (min < f5) {
                    MyLocalPicImageView.this.mHandler.post(this);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        center(true, true);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float f) {
        zoomTo(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    /* access modifiers changed from: protected */
    public void zoomToPoint(float f, float f2, float f3) {
        float width = ((float) getWidth()) / 2.0f;
        float height = ((float) getHeight()) / 2.0f;
        panBy(width - f2, height - f3);
        zoomTo(f, width, height);
    }

    /* access modifiers changed from: protected */
    public void zoomIn(float f) {
        Log.d("tg", "zoomIn");
        if (getScale() < this.mMaxZoom && getScale() > this.mMinZoom && this.image != null) {
            this.mSuppMatrix.postScale(f, f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    /* access modifiers changed from: protected */
    public void zoomOut(float f) {
        if (this.image != null) {
            Log.d("tag", "zoomOut:");
            float width = ((float) getWidth()) / 2.0f;
            float height = ((float) getHeight()) / 2.0f;
            Matrix matrix = new Matrix(this.mSuppMatrix);
            float f2 = 1.0f / f;
            matrix.postScale(f2, f2, width, height);
            if (getScale(matrix) < 1.0f) {
                this.mSuppMatrix.setScale(1.0f, 1.0f, width, height);
            } else {
                this.mSuppMatrix.postScale(f2, f2, width, height);
            }
            setImageMatrix(getImageViewMatrix());
            center(true, true);
        }
    }

    public void postTranslate(float f, float f2) {
        this.mSuppMatrix.postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    /* access modifiers changed from: protected */
    public void postTranslateDur(float f, float f2) {
        this._dy = 0.0f;
        final float f3 = f / f2;
        final long currentTimeMillis = System.currentTimeMillis();
        final float f4 = f2;
        this.mHandler.post(new Runnable() {
            public void run() {
                float min = Math.min(f4, (float) (System.currentTimeMillis() - currentTimeMillis));
                MyLocalPicImageView myLocalPicImageView = MyLocalPicImageView.this;
                myLocalPicImageView.postTranslate(0.0f, (f3 * min) - myLocalPicImageView._dy);
                MyLocalPicImageView myLocalPicImageView2 = MyLocalPicImageView.this;
                myLocalPicImageView2._dy = f3 * min;
                if (min < f4) {
                    myLocalPicImageView2.mHandler.post(this);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void panBy(float f, float f2) {
        postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }
}
