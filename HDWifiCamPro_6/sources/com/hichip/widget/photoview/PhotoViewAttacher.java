package com.hichip.widget.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.hichip.widget.photoview.gestures.OnGestureListener;
import com.hichip.widget.photoview.gestures.VersionedGestureDetector;
import com.hichip.widget.photoview.log.LogManager;
import com.hichip.widget.photoview.log.Logger;
import com.hichip.widget.photoview.scrollerproxy.ScrollerProxy;
import java.lang.ref.WeakReference;

public class PhotoViewAttacher implements IPhotoView, View.OnTouchListener, OnGestureListener, ViewTreeObserver.OnGlobalLayoutListener {
    private static /* synthetic */ int[] $SWITCH_TABLE$android$widget$ImageView$ScaleType = null;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = Log.isLoggable(LOG_TAG, 3);
    static final int EDGE_BOTH = 2;
    static final int EDGE_LEFT = 0;
    static final int EDGE_NONE = -1;
    static final int EDGE_RIGHT = 1;
    private static final String LOG_TAG = "PhotoViewAttacher";
    static final Interpolator sInterpolator = new AccelerateDecelerateInterpolator();
    int ZOOM_DURATION;
    private boolean mAllowParentInterceptOnEdge;
    private final Matrix mBaseMatrix;
    private boolean mBlockParentIntercept;
    private FlingRunnable mCurrentFlingRunnable;
    private final RectF mDisplayRect;
    private final Matrix mDrawMatrix;
    private GestureDetector mGestureDetector;
    private WeakReference<ImageView> mImageView;
    private int mIvBottom;
    private int mIvLeft;
    private int mIvRight;
    private int mIvTop;
    /* access modifiers changed from: private */
    public View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private final float[] mMatrixValues;
    private float mMaxScale;
    private float mMidScale;
    private float mMinScale;
    private OnPhotoTapListener mPhotoTapListener;
    private OnScaleChangeListener mScaleChangeListener;
    private com.hichip.widget.photoview.gestures.GestureDetector mScaleDragDetector;
    private ImageView.ScaleType mScaleType;
    private int mScrollEdge;
    /* access modifiers changed from: private */
    public final Matrix mSuppMatrix;
    private OnViewTapListener mViewTapListener;
    private boolean mZoomEnabled;

    public interface OnMatrixChangedListener {
        void onMatrixChanged(RectF rectF);
    }

    public interface OnPhotoTapListener {
        void onPhotoTap(View view, float f, float f2);
    }

    public interface OnScaleChangeListener {
        void onScaleChange(float f, float f2, float f3);
    }

    public interface OnViewTapListener {
        void onViewTap(View view, float f, float f2);
    }

    public IPhotoView getIPhotoViewImplementation() {
        return this;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|(2:18|19)|20|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0042 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] $SWITCH_TABLE$android$widget$ImageView$ScaleType() {
        /*
            int[] r0 = $SWITCH_TABLE$android$widget$ImageView$ScaleType
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0027 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0030 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0030 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0030 }
        L_0x0030:
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0039 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
        L_0x0039:
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0042 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0042 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0042 }
        L_0x0042:
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x004b }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0055 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0055 }
        L_0x0055:
            $SWITCH_TABLE$android$widget$ImageView$ScaleType = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hichip.widget.photoview.PhotoViewAttacher.$SWITCH_TABLE$android$widget$ImageView$ScaleType():int[]");
    }

    private static void checkZoomLevels(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        } else if (f2 >= f3) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private static boolean hasDrawable(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static boolean isSupportedScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if ($SWITCH_TABLE$android$widget$ImageView$ScaleType()[scaleType.ordinal()] != 8) {
            return true;
        }
        throw new IllegalArgumentException(String.valueOf(scaleType.name()) + " is not supported in PhotoView");
    }

    private static void setImageViewScaleTypeMatrix(ImageView imageView) {
        if (imageView != null && !(imageView instanceof IPhotoView) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        this(imageView, true);
    }

    public PhotoViewAttacher(ImageView imageView, boolean z) {
        this.ZOOM_DURATION = 200;
        this.mMinScale = 1.0f;
        this.mMidScale = 1.75f;
        this.mMaxScale = 3.0f;
        this.mAllowParentInterceptOnEdge = true;
        this.mBlockParentIntercept = false;
        this.mBaseMatrix = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDisplayRect = new RectF();
        this.mMatrixValues = new float[9];
        this.mScrollEdge = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.mImageView = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        setImageViewScaleTypeMatrix(imageView);
        if (!imageView.isInEditMode()) {
            this.mScaleDragDetector = VersionedGestureDetector.newInstance(imageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public void onLongPress(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.mLongClickListener != null) {
                        PhotoViewAttacher.this.mLongClickListener.onLongClick(PhotoViewAttacher.this.getImageView());
                    }
                }
            });
            this.mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
            setZoomable(z);
        }
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
        }
    }

    public void setOnScaleChangeListener(OnScaleChangeListener onScaleChangeListener) {
        this.mScaleChangeListener = onScaleChangeListener;
    }

    public boolean canZoom() {
        return this.mZoomEnabled;
    }

    public void cleanup() {
        WeakReference<ImageView> weakReference = this.mImageView;
        if (weakReference != null) {
            ImageView imageView = (ImageView) weakReference.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener((View.OnTouchListener) null);
                cancelFling();
            }
            GestureDetector gestureDetector = this.mGestureDetector;
            if (gestureDetector != null) {
                gestureDetector.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) null);
            }
            this.mMatrixChangeListener = null;
            this.mPhotoTapListener = null;
            this.mViewTapListener = null;
            this.mImageView = null;
        }
    }

    public RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix != null) {
            ImageView imageView = getImageView();
            if (imageView == null || imageView.getDrawable() == null) {
                return false;
            }
            this.mSuppMatrix.set(matrix);
            setImageViewMatrix(getDrawMatrix());
            checkMatrixBounds();
            return true;
        }
        throw new IllegalArgumentException("Matrix cannot be null");
    }

    public void setPhotoViewRotation(float f) {
        this.mSuppMatrix.setRotate(f % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setRotationTo(float f) {
        this.mSuppMatrix.setRotate(f % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setRotationBy(float f) {
        this.mSuppMatrix.postRotate(f % 360.0f);
        checkAndDisplayMatrix();
    }

    public ImageView getImageView() {
        WeakReference<ImageView> weakReference = this.mImageView;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        if (imageView == null) {
            cleanup();
            LogManager.getLogger().i(LOG_TAG, "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.mMidScale;
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getScale() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) getValue(this.mSuppMatrix, 0), 2.0d)) + ((float) Math.pow((double) getValue(this.mSuppMatrix, 3), 2.0d))));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void onDrag(float f, float f2) {
        if (!this.mScaleDragDetector.isScaling()) {
            if (DEBUG) {
                LogManager.getLogger().d(LOG_TAG, String.format("onDrag: dx: %.2f. dy: %.2f", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
            }
            ImageView imageView = getImageView();
            this.mSuppMatrix.postTranslate(f, f2);
            checkAndDisplayMatrix();
            ViewParent parent = imageView.getParent();
            if (this.mAllowParentInterceptOnEdge && !this.mScaleDragDetector.isScaling() && !this.mBlockParentIntercept) {
                int i = this.mScrollEdge;
                if ((i == 2 || ((i == 0 && f >= 1.0f) || (this.mScrollEdge == 1 && f <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public void onFling(float f, float f2, float f3, float f4) {
        if (DEBUG) {
            Logger logger = LogManager.getLogger();
            logger.d(LOG_TAG, "onFling. sX: " + f + " sY: " + f2 + " Vx: " + f3 + " Vy: " + f4);
        }
        ImageView imageView = getImageView();
        this.mCurrentFlingRunnable = new FlingRunnable(imageView.getContext());
        this.mCurrentFlingRunnable.fling(getImageViewWidth(imageView), getImageViewHeight(imageView), (int) f3, (int) f4);
        imageView.post(this.mCurrentFlingRunnable);
    }

    public void onGlobalLayout() {
        ImageView imageView = getImageView();
        if (imageView == null) {
            return;
        }
        if (this.mZoomEnabled) {
            int top = imageView.getTop();
            int right = imageView.getRight();
            int bottom = imageView.getBottom();
            int left = imageView.getLeft();
            if (top != this.mIvTop || bottom != this.mIvBottom || left != this.mIvLeft || right != this.mIvRight) {
                updateBaseMatrix(imageView.getDrawable());
                this.mIvTop = top;
                this.mIvRight = right;
                this.mIvBottom = bottom;
                this.mIvLeft = left;
                return;
            }
            return;
        }
        updateBaseMatrix(imageView.getDrawable());
    }

    public void onScale(float f, float f2, float f3) {
        if (DEBUG) {
            LogManager.getLogger().d(LOG_TAG, String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}));
        }
        if (getScale() < this.mMaxScale || f < 1.0f) {
            OnScaleChangeListener onScaleChangeListener = this.mScaleChangeListener;
            if (onScaleChangeListener != null) {
                onScaleChangeListener.onScaleChange(f, f2, f3);
            }
            this.mSuppMatrix.postScale(f, f, f2, f3);
            checkAndDisplayMatrix();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.mZoomEnabled
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00a1
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = hasDrawable(r0)
            if (r0 == 0) goto L_0x00a1
            android.view.ViewParent r0 = r11.getParent()
            int r3 = r12.getAction()
            if (r3 == 0) goto L_0x0049
            if (r3 == r2) goto L_0x001f
            r0 = 3
            if (r3 == r0) goto L_0x001f
            goto L_0x005d
        L_0x001f:
            float r0 = r10.getScale()
            float r3 = r10.mMinScale
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x005d
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L_0x005d
            com.hichip.widget.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.hichip.widget.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.getScale()
            float r6 = r10.mMinScale
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            r11 = r2
            goto L_0x005e
        L_0x0049:
            if (r0 == 0) goto L_0x004f
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L_0x005a
        L_0x004f:
            com.hichip.widget.photoview.log.Logger r11 = com.hichip.widget.photoview.log.LogManager.getLogger()
            java.lang.String r0 = "PhotoViewAttacher"
            java.lang.String r3 = "onTouch getParent() returned null"
            r11.i(r0, r3)
        L_0x005a:
            r10.cancelFling()
        L_0x005d:
            r11 = r1
        L_0x005e:
            com.hichip.widget.photoview.gestures.GestureDetector r0 = r10.mScaleDragDetector
            if (r0 == 0) goto L_0x0095
            boolean r11 = r0.isScaling()
            com.hichip.widget.photoview.gestures.GestureDetector r0 = r10.mScaleDragDetector
            boolean r0 = r0.isDragging()
            com.hichip.widget.photoview.gestures.GestureDetector r3 = r10.mScaleDragDetector
            boolean r3 = r3.onTouchEvent(r12)
            if (r11 != 0) goto L_0x007e
            com.hichip.widget.photoview.gestures.GestureDetector r11 = r10.mScaleDragDetector
            boolean r11 = r11.isScaling()
            if (r11 != 0) goto L_0x007e
            r11 = r2
            goto L_0x007f
        L_0x007e:
            r11 = r1
        L_0x007f:
            if (r0 != 0) goto L_0x008b
            com.hichip.widget.photoview.gestures.GestureDetector r0 = r10.mScaleDragDetector
            boolean r0 = r0.isDragging()
            if (r0 != 0) goto L_0x008b
            r0 = r2
            goto L_0x008c
        L_0x008b:
            r0 = r1
        L_0x008c:
            if (r11 == 0) goto L_0x0091
            if (r0 == 0) goto L_0x0091
            r1 = r2
        L_0x0091:
            r10.mBlockParentIntercept = r1
            r1 = r3
            goto L_0x0096
        L_0x0095:
            r1 = r11
        L_0x0096:
            android.view.GestureDetector r11 = r10.mGestureDetector
            if (r11 == 0) goto L_0x00a1
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto L_0x00a1
            r1 = r2
        L_0x00a1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hichip.widget.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAllowParentInterceptOnEdge = z;
    }

    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    public void setMinimumScale(float f) {
        checkZoomLevels(f, this.mMidScale, this.mMaxScale);
        this.mMinScale = f;
    }

    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    public void setMediumScale(float f) {
        checkZoomLevels(this.mMinScale, f, this.mMaxScale);
        this.mMidScale = f;
    }

    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    public void setMaximumScale(float f) {
        checkZoomLevels(this.mMinScale, this.mMidScale, f);
        this.mMaxScale = f;
    }

    public void setScaleLevels(float f, float f2, float f3) {
        checkZoomLevels(f, f2, f3);
        this.mMinScale = f;
        this.mMidScale = f2;
        this.mMaxScale = f3;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.mMatrixChangeListener = onMatrixChangedListener;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.mPhotoTapListener = onPhotoTapListener;
    }

    public OnPhotoTapListener getOnPhotoTapListener() {
        return this.mPhotoTapListener;
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mViewTapListener = onViewTapListener;
    }

    public OnViewTapListener getOnViewTapListener() {
        return this.mViewTapListener;
    }

    public void setScale(float f) {
        setScale(f, false);
    }

    public void setScale(float f, boolean z) {
        ImageView imageView = getImageView();
        if (imageView != null) {
            setScale(f, (float) (imageView.getRight() / 2), (float) (imageView.getBottom() / 2), z);
        }
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        ImageView imageView = getImageView();
        if (imageView == null) {
            return;
        }
        if (f < this.mMinScale || f > this.mMaxScale) {
            LogManager.getLogger().i(LOG_TAG, "Scale must be within the range of minScale and maxScale");
        } else if (z) {
            imageView.post(new AnimatedZoomRunnable(getScale(), f, f2, f3));
        } else {
            this.mSuppMatrix.setScale(f, f, f2, f3);
            checkAndDisplayMatrix();
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (isSupportedScaleType(scaleType) && scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            update();
        }
    }

    public void setZoomable(boolean z) {
        this.mZoomEnabled = z;
        update();
    }

    public void update() {
        ImageView imageView = getImageView();
        if (imageView == null) {
            return;
        }
        if (this.mZoomEnabled) {
            setImageViewScaleTypeMatrix(imageView);
            updateBaseMatrix(imageView.getDrawable());
            return;
        }
        resetMatrix();
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    private void cancelFling() {
        FlingRunnable flingRunnable = this.mCurrentFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    private void checkAndDisplayMatrix() {
        if (checkMatrixBounds()) {
            setImageViewMatrix(getDrawMatrix());
        }
    }

    private void checkImageViewScaleType() {
        ImageView imageView = getImageView();
        if (imageView != null && !(imageView instanceof IPhotoView) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkMatrixBounds() {
        /*
            r12 = this;
            android.widget.ImageView r0 = r12.getImageView()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.graphics.Matrix r2 = r12.getDrawMatrix()
            android.graphics.RectF r2 = r12.getDisplayRect(r2)
            if (r2 != 0) goto L_0x0013
            return r1
        L_0x0013:
            float r3 = r2.height()
            float r4 = r2.width()
            int r5 = r12.getImageViewHeight(r0)
            float r5 = (float) r5
            int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r7 = 1073741824(0x40000000, float:2.0)
            r8 = 6
            r9 = 5
            r10 = 0
            if (r6 > 0) goto L_0x0047
            int[] r6 = $SWITCH_TABLE$android$widget$ImageView$ScaleType()
            android.widget.ImageView$ScaleType r11 = r12.mScaleType
            int r11 = r11.ordinal()
            r6 = r6[r11]
            if (r6 == r9) goto L_0x0043
            if (r6 == r8) goto L_0x0040
            float r5 = r5 - r3
            float r5 = r5 / r7
            float r3 = r2.top
        L_0x003d:
            float r3 = r5 - r3
            goto L_0x005b
        L_0x0040:
            float r3 = r2.top
            goto L_0x004f
        L_0x0043:
            float r5 = r5 - r3
            float r3 = r2.top
            goto L_0x003d
        L_0x0047:
            float r3 = r2.top
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x0051
            float r3 = r2.top
        L_0x004f:
            float r3 = -r3
            goto L_0x005b
        L_0x0051:
            float r3 = r2.bottom
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x005a
            float r3 = r2.bottom
            goto L_0x003d
        L_0x005a:
            r3 = r10
        L_0x005b:
            int r0 = r12.getImageViewWidth(r0)
            float r0 = (float) r0
            int r5 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            r6 = 1
            if (r5 > 0) goto L_0x0088
            int[] r1 = $SWITCH_TABLE$android$widget$ImageView$ScaleType()
            android.widget.ImageView$ScaleType r5 = r12.mScaleType
            int r5 = r5.ordinal()
            r1 = r1[r5]
            if (r1 == r9) goto L_0x0080
            if (r1 == r8) goto L_0x007c
            float r0 = r0 - r4
            float r0 = r0 / r7
            float r1 = r2.left
        L_0x0079:
            float r0 = r0 - r1
        L_0x007a:
            r10 = r0
            goto L_0x0084
        L_0x007c:
            float r0 = r2.left
            float r0 = -r0
            goto L_0x007a
        L_0x0080:
            float r0 = r0 - r4
            float r1 = r2.left
            goto L_0x0079
        L_0x0084:
            r0 = 2
            r12.mScrollEdge = r0
            goto L_0x00a4
        L_0x0088:
            float r4 = r2.left
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x0094
            r12.mScrollEdge = r1
            float r0 = r2.left
            float r10 = -r0
            goto L_0x00a4
        L_0x0094:
            float r1 = r2.right
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x00a1
            float r1 = r2.right
            float r10 = r0 - r1
            r12.mScrollEdge = r6
            goto L_0x00a4
        L_0x00a1:
            r0 = -1
            r12.mScrollEdge = r0
        L_0x00a4:
            android.graphics.Matrix r0 = r12.mSuppMatrix
            r0.postTranslate(r10, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hichip.widget.photoview.PhotoViewAttacher.checkMatrixBounds():boolean");
    }

    private RectF getDisplayRect(Matrix matrix) {
        Drawable drawable;
        ImageView imageView = getImageView();
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return null;
        }
        this.mDisplayRect.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView imageView = getImageView();
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawingCache();
    }

    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.ZOOM_DURATION = i;
    }

    private float getValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    private void resetMatrix() {
        this.mSuppMatrix.reset();
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
    }

    /* access modifiers changed from: private */
    public void setImageViewMatrix(Matrix matrix) {
        RectF displayRect;
        ImageView imageView = getImageView();
        if (imageView != null) {
            checkImageViewScaleType();
            imageView.setImageMatrix(matrix);
            if (this.mMatrixChangeListener != null && (displayRect = getDisplayRect(matrix)) != null) {
                this.mMatrixChangeListener.onMatrixChanged(displayRect);
            }
        }
    }

    private void updateBaseMatrix(Drawable drawable) {
        ImageView imageView = getImageView();
        if (imageView != null && drawable != null) {
            float imageViewWidth = (float) getImageViewWidth(imageView);
            float imageViewHeight = (float) getImageViewHeight(imageView);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.mBaseMatrix.reset();
            float f = (float) intrinsicWidth;
            float f2 = imageViewWidth / f;
            float f3 = (float) intrinsicHeight;
            float f4 = imageViewHeight / f3;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.mBaseMatrix.postTranslate((imageViewWidth - f) / 2.0f, (imageViewHeight - f3) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f4);
                this.mBaseMatrix.postScale(max, max);
                this.mBaseMatrix.postTranslate((imageViewWidth - (f * max)) / 2.0f, (imageViewHeight - (f3 * max)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f4));
                this.mBaseMatrix.postScale(min, min);
                this.mBaseMatrix.postTranslate((imageViewWidth - (f * min)) / 2.0f, (imageViewHeight - (f3 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f, f3);
                RectF rectF2 = new RectF(0.0f, 0.0f, imageViewWidth, imageViewHeight);
                int i = $SWITCH_TABLE$android$widget$ImageView$ScaleType()[this.mScaleType.ordinal()];
                if (i == 4) {
                    this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i == 5) {
                    this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i == 6) {
                    this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i == 7) {
                    this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            resetMatrix();
        }
    }

    private int getImageViewWidth(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private int getImageViewHeight(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.mFocalX = f3;
            this.mFocalY = f4;
            this.mZoomStart = f;
            this.mZoomEnd = f2;
        }

        public void run() {
            ImageView imageView = PhotoViewAttacher.this.getImageView();
            if (imageView != null) {
                float interpolate = interpolate();
                float f = this.mZoomStart;
                PhotoViewAttacher.this.onScale((f + ((this.mZoomEnd - f) * interpolate)) / PhotoViewAttacher.this.getScale(), this.mFocalX, this.mFocalY);
                if (interpolate < 1.0f) {
                    Compat.postOnAnimation(imageView, this);
                }
            }
        }

        private float interpolate() {
            return PhotoViewAttacher.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / ((float) PhotoViewAttacher.this.ZOOM_DURATION)));
        }
    }

    private class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final ScrollerProxy mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = ScrollerProxy.getScroller(context);
        }

        public void cancelFling() {
            if (PhotoViewAttacher.DEBUG) {
                LogManager.getLogger().d(PhotoViewAttacher.LOG_TAG, "Cancel Fling");
            }
            this.mScroller.forceFinished(true);
        }

        public void fling(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
            if (displayRect != null) {
                int round = Math.round(-displayRect.left);
                float f = (float) i;
                if (f < displayRect.width()) {
                    i5 = Math.round(displayRect.width() - f);
                    i6 = 0;
                } else {
                    i6 = round;
                    i5 = i6;
                }
                int round2 = Math.round(-displayRect.top);
                float f2 = (float) i2;
                if (f2 < displayRect.height()) {
                    i7 = Math.round(displayRect.height() - f2);
                    i8 = 0;
                } else {
                    i8 = round2;
                    i7 = i8;
                }
                this.mCurrentX = round;
                this.mCurrentY = round2;
                if (PhotoViewAttacher.DEBUG) {
                    LogManager.getLogger().d(PhotoViewAttacher.LOG_TAG, "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i5 + " MaxY:" + i7);
                }
                if (round != i5 || round2 != i7) {
                    this.mScroller.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        public void run() {
            ImageView imageView;
            if (!this.mScroller.isFinished() && (imageView = PhotoViewAttacher.this.getImageView()) != null && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (PhotoViewAttacher.DEBUG) {
                    Logger logger = LogManager.getLogger();
                    logger.d(PhotoViewAttacher.LOG_TAG, "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.mCurrentY + " NewX:" + currX + " NewY:" + currY);
                }
                PhotoViewAttacher.this.mSuppMatrix.postTranslate((float) (this.mCurrentX - currX), (float) (this.mCurrentY - currY));
                PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                photoViewAttacher.setImageViewMatrix(photoViewAttacher.getDrawMatrix());
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                Compat.postOnAnimation(imageView, this);
            }
        }
    }
}
