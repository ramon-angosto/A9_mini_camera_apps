package com.hichip.widget.stickygridheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class StickyGridHeadersGridView extends GridView implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, AdapterView.OnItemLongClickListener {
    /* access modifiers changed from: private */
    public static final String ERROR_PLATFORM = ("Error supporting platform " + Build.VERSION.SDK_INT + ".");
    private static final int MATCHED_STICKIED_HEADER = -2;
    private static final int NO_MATCHED_HEADER = -1;
    static final String TAG = StickyGridHeadersGridView.class.getSimpleName();
    protected static final int TOUCH_MODE_DONE_WAITING = 2;
    protected static final int TOUCH_MODE_DOWN = 0;
    protected static final int TOUCH_MODE_FINISHED_LONG_PRESS = -2;
    protected static final int TOUCH_MODE_REST = -1;
    protected static final int TOUCH_MODE_TAP = 1;
    protected StickyGridHeadersBaseAdapterWrapper mAdapter;
    private boolean mAreHeadersSticky;
    private boolean mClipToPaddingHasBeenSet;
    private final Rect mClippingRect;
    private boolean mClippingToPadding;
    private int mColumnWidth;
    private long mCurrentHeaderId;
    protected boolean mDataChanged;
    private DataSetObserver mDataSetObserver;
    private int mHeaderBottomPosition;
    boolean mHeaderChildBeingPressed;
    private boolean mHeadersIgnorePadding;
    private int mHorizontalSpacing;
    private boolean mMaskStickyHeaderRegion;
    protected int mMotionHeaderPosition;
    private float mMotionY;
    private int mNumColumns;
    private boolean mNumColumnsSet;
    private int mNumMeasuredColumns;
    private OnHeaderClickListener mOnHeaderClickListener;
    private OnHeaderLongClickListener mOnHeaderLongClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemLongClickListener mOnItemLongClickListener;
    private AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    public CheckForHeaderLongPress mPendingCheckForLongPress;
    public CheckForHeaderTap mPendingCheckForTap;
    private PerformHeaderClick mPerformHeaderClick;
    private AbsListView.OnScrollListener mScrollListener;
    private int mScrollState;
    private View mStickiedHeader;
    protected int mTouchMode;
    /* access modifiers changed from: private */
    public Runnable mTouchModeReset;
    private int mTouchSlop;
    private int mVerticalSpacing;

    public interface OnHeaderClickListener {
        void onHeaderClick(AdapterView<?> adapterView, View view, long j);
    }

    public interface OnHeaderLongClickListener {
        boolean onHeaderLongClick(AdapterView<?> adapterView, View view, long j);
    }

    private static MotionEvent.PointerCoords[] getPointerCoords(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            pointerCoordsArr[i] = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i, pointerCoordsArr[i]);
        }
        return pointerCoordsArr;
    }

    private static int[] getPointerIds(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
        }
        return iArr;
    }

    public StickyGridHeadersGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    public StickyGridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public StickyGridHeadersGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAreHeadersSticky = true;
        this.mClippingRect = new Rect();
        this.mCurrentHeaderId = -1;
        this.mDataSetObserver = new DataSetObserver() {
            public void onChanged() {
                StickyGridHeadersGridView.this.reset();
            }

            public void onInvalidated() {
                StickyGridHeadersGridView.this.reset();
            }
        };
        this.mMaskStickyHeaderRegion = true;
        this.mNumMeasuredColumns = 1;
        this.mScrollState = 0;
        this.mHeaderChildBeingPressed = false;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.mNumColumnsSet) {
            this.mNumColumns = -1;
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean areHeadersSticky() {
        return this.mAreHeadersSticky;
    }

    public View getHeaderAt(int i) {
        if (i == -2) {
            return this.mStickiedHeader;
        }
        try {
            return (View) getChildAt(i).getTag();
        } catch (Exception unused) {
            return null;
        }
    }

    public View getStickiedHeader() {
        return this.mStickiedHeader;
    }

    public boolean getStickyHeaderIsTranscluent() {
        return !this.mMaskStickyHeaderRegion;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mOnItemClickListener.onItemClick(adapterView, view, this.mAdapter.translatePosition(i).mPosition, j);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return this.mOnItemLongClickListener.onItemLongClick(adapterView, view, this.mAdapter.translatePosition(i).mPosition, j);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.mOnItemSelectedListener.onItemSelected(adapterView, view, this.mAdapter.translatePosition(i).mPosition, j);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        this.mOnItemSelectedListener.onNothingSelected(adapterView);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mAreHeadersSticky = savedState.areHeadersSticky;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.areHeadersSticky = this.mAreHeadersSticky;
        return savedState;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            scrollChanged(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
        this.mScrollState = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        Runnable runnable;
        final View view;
        int action = motionEvent.getAction();
        boolean z = this.mHeaderChildBeingPressed;
        if (z) {
            View headerAt = getHeaderAt(this.mMotionHeaderPosition);
            int i2 = this.mMotionHeaderPosition;
            if (i2 == -2) {
                view = headerAt;
            } else {
                view = getChildAt(i2);
            }
            if (action == 1 || action == 3) {
                this.mHeaderChildBeingPressed = false;
            }
            if (headerAt != null) {
                headerAt.dispatchTouchEvent(transformEvent(motionEvent, this.mMotionHeaderPosition));
                headerAt.invalidate();
                headerAt.postDelayed(new Runnable() {
                    public void run() {
                        StickyGridHeadersGridView.this.invalidate(0, view.getTop(), StickyGridHeadersGridView.this.getWidth(), view.getTop() + view.getHeight());
                    }
                }, (long) ViewConfiguration.getPressedStateDuration());
                invalidate(0, view.getTop(), getWidth(), view.getTop() + view.getHeight());
            }
        }
        int i3 = action & 255;
        if (i3 == 0) {
            if (this.mPendingCheckForTap == null) {
                this.mPendingCheckForTap = new CheckForHeaderTap();
            }
            postDelayed(this.mPendingCheckForTap, (long) ViewConfiguration.getTapTimeout());
            float y = (float) ((int) motionEvent.getY());
            this.mMotionY = y;
            this.mMotionHeaderPosition = findMotionHeader(y);
            int i4 = this.mMotionHeaderPosition;
            if (!(i4 == -1 || this.mScrollState == 2)) {
                View headerAt2 = getHeaderAt(i4);
                if (headerAt2 != null) {
                    if (headerAt2.dispatchTouchEvent(transformEvent(motionEvent, this.mMotionHeaderPosition))) {
                        this.mHeaderChildBeingPressed = true;
                        headerAt2.setPressed(true);
                    }
                    headerAt2.invalidate();
                    int i5 = this.mMotionHeaderPosition;
                    if (i5 != -2) {
                        headerAt2 = getChildAt(i5);
                    }
                    invalidate(0, headerAt2.getTop(), getWidth(), headerAt2.getTop() + headerAt2.getHeight());
                }
                this.mTouchMode = 0;
                return true;
            }
        } else if (i3 == 1) {
            int i6 = this.mTouchMode;
            if (i6 == -2) {
                this.mTouchMode = -1;
                return true;
            } else if (!(i6 == -1 || (i = this.mMotionHeaderPosition) == -1)) {
                final View headerAt3 = getHeaderAt(i);
                if (!z && headerAt3 != null) {
                    if (this.mTouchMode != 0) {
                        headerAt3.setPressed(false);
                    }
                    if (this.mPerformHeaderClick == null) {
                        this.mPerformHeaderClick = new PerformHeaderClick(this, (PerformHeaderClick) null);
                    }
                    final PerformHeaderClick performHeaderClick = this.mPerformHeaderClick;
                    performHeaderClick.mClickMotionPosition = this.mMotionHeaderPosition;
                    performHeaderClick.rememberWindowAttachCount();
                    int i7 = this.mTouchMode;
                    if (i7 == 0 || i7 == 1) {
                        Handler handler = getHandler();
                        if (handler != null) {
                            if (this.mTouchMode == 0) {
                                runnable = this.mPendingCheckForTap;
                            } else {
                                runnable = this.mPendingCheckForLongPress;
                            }
                            handler.removeCallbacks(runnable);
                        }
                        if (!this.mDataChanged) {
                            this.mTouchMode = 1;
                            headerAt3.setPressed(true);
                            setPressed(true);
                            Runnable runnable2 = this.mTouchModeReset;
                            if (runnable2 != null) {
                                removeCallbacks(runnable2);
                            }
                            this.mTouchModeReset = new Runnable() {
                                public void run() {
                                    StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this;
                                    stickyGridHeadersGridView.mMotionHeaderPosition = -1;
                                    stickyGridHeadersGridView.mTouchModeReset = null;
                                    StickyGridHeadersGridView.this.mTouchMode = -1;
                                    headerAt3.setPressed(false);
                                    StickyGridHeadersGridView.this.setPressed(false);
                                    headerAt3.invalidate();
                                    StickyGridHeadersGridView.this.invalidate(0, headerAt3.getTop(), StickyGridHeadersGridView.this.getWidth(), headerAt3.getHeight());
                                    if (!StickyGridHeadersGridView.this.mDataChanged) {
                                        performHeaderClick.run();
                                    }
                                }
                            };
                            postDelayed(this.mTouchModeReset, (long) ViewConfiguration.getPressedStateDuration());
                        } else {
                            this.mTouchMode = -1;
                        }
                    } else if (!this.mDataChanged) {
                        performHeaderClick.run();
                    }
                }
                this.mTouchMode = -1;
                return true;
            }
        } else if (i3 == 2 && this.mMotionHeaderPosition != -1 && Math.abs(motionEvent.getY() - this.mMotionY) > ((float) this.mTouchSlop)) {
            this.mTouchMode = -1;
            View headerAt4 = getHeaderAt(this.mMotionHeaderPosition);
            if (headerAt4 != null) {
                headerAt4.setPressed(false);
                headerAt4.invalidate();
            }
            Handler handler2 = getHandler();
            if (handler2 != null) {
                handler2.removeCallbacks(this.mPendingCheckForLongPress);
            }
            this.mMotionHeaderPosition = -1;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean performHeaderClick(View view, long j) {
        if (this.mOnHeaderClickListener == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.mOnHeaderClickListener.onHeaderClick(this, view, j);
        return true;
    }

    public boolean performHeaderLongPress(View view, long j) {
        OnHeaderLongClickListener onHeaderLongClickListener = this.mOnHeaderLongClickListener;
        boolean onHeaderLongClick = onHeaderLongClickListener != null ? onHeaderLongClickListener.onHeaderLongClick(this, view, j) : false;
        if (onHeaderLongClick) {
            if (view != null) {
                view.sendAccessibilityEvent(2);
            }
            performHapticFeedback(0);
        }
        return onHeaderLongClick;
    }

    public void setAdapter(ListAdapter listAdapter) {
        StickyGridHeadersBaseAdapter stickyGridHeadersBaseAdapter;
        DataSetObserver dataSetObserver;
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.mAdapter;
        if (!(stickyGridHeadersBaseAdapterWrapper == null || (dataSetObserver = this.mDataSetObserver) == null)) {
            stickyGridHeadersBaseAdapterWrapper.unregisterDataSetObserver(dataSetObserver);
        }
        if (!this.mClipToPaddingHasBeenSet) {
            this.mClippingToPadding = true;
        }
        if (listAdapter instanceof StickyGridHeadersBaseAdapter) {
            stickyGridHeadersBaseAdapter = (StickyGridHeadersBaseAdapter) listAdapter;
        } else if (listAdapter instanceof StickyGridHeadersSimpleAdapter) {
            stickyGridHeadersBaseAdapter = new StickyGridHeadersSimpleAdapterWrapper((StickyGridHeadersSimpleAdapter) listAdapter);
        } else {
            stickyGridHeadersBaseAdapter = new StickyGridHeadersListAdapterWrapper(listAdapter);
        }
        this.mAdapter = new StickyGridHeadersBaseAdapterWrapper(getContext(), this, stickyGridHeadersBaseAdapter);
        this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
        reset();
        super.setAdapter(this.mAdapter);
    }

    public void setAreHeadersSticky(boolean z) {
        if (z != this.mAreHeadersSticky) {
            this.mAreHeadersSticky = z;
            requestLayout();
        }
    }

    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.mClippingToPadding = z;
        this.mClipToPaddingHasBeenSet = true;
    }

    public void setColumnWidth(int i) {
        super.setColumnWidth(i);
        this.mColumnWidth = i;
    }

    public void setHeadersIgnorePadding(boolean z) {
        this.mHeadersIgnorePadding = z;
    }

    public void setHorizontalSpacing(int i) {
        super.setHorizontalSpacing(i);
        this.mHorizontalSpacing = i;
    }

    public void setNumColumns(int i) {
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper;
        super.setNumColumns(i);
        this.mNumColumnsSet = true;
        this.mNumColumns = i;
        if (i != -1 && (stickyGridHeadersBaseAdapterWrapper = this.mAdapter) != null) {
            stickyGridHeadersBaseAdapterWrapper.setNumColumns(i);
        }
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.mOnHeaderClickListener = onHeaderClickListener;
    }

    public void setOnHeaderLongClickListener(OnHeaderLongClickListener onHeaderLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mOnHeaderLongClickListener = onHeaderLongClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        super.setOnItemClickListener(this);
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelectedListener = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setStickyHeaderIsTranscluent(boolean z) {
        this.mMaskStickyHeaderRegion = !z;
    }

    public void setVerticalSpacing(int i) {
        super.setVerticalSpacing(i);
        this.mVerticalSpacing = i;
    }

    private int findMotionHeader(float f) {
        if (this.mStickiedHeader != null && f <= ((float) this.mHeaderBottomPosition)) {
            return -2;
        }
        int i = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                View childAt = getChildAt(i);
                int bottom = childAt.getBottom();
                int top = childAt.getTop();
                if (f <= ((float) bottom) && f >= ((float) top)) {
                    return i;
                }
            }
            int i2 = this.mNumMeasuredColumns;
            firstVisiblePosition += i2;
            i += i2;
        }
        return -1;
    }

    private int getHeaderHeight() {
        View view = this.mStickiedHeader;
        if (view != null) {
            return view.getMeasuredHeight();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public long headerViewPositionToId(int i) {
        if (i == -2) {
            return this.mCurrentHeaderId;
        }
        return this.mAdapter.getHeaderId(getFirstVisiblePosition() + i);
    }

    private void measureHeader() {
        int i;
        int i2;
        if (this.mStickiedHeader != null) {
            if (this.mHeadersIgnorePadding) {
                i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
            } else {
                i = View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
            }
            ViewGroup.LayoutParams layoutParams = this.mStickiedHeader.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            this.mStickiedHeader.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.mStickiedHeader.measure(i, i2);
            if (this.mHeadersIgnorePadding) {
                this.mStickiedHeader.layout(getLeft(), 0, getRight(), this.mStickiedHeader.getMeasuredHeight());
            } else {
                this.mStickiedHeader.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.mStickiedHeader.getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: private */
    public void reset() {
        this.mHeaderBottomPosition = 0;
        swapStickiedHeader((View) null);
        this.mCurrentHeaderId = Long.MIN_VALUE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void scrollChanged(int r14) {
        /*
            r13 = this;
            com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper r0 = r13.mAdapter
            if (r0 == 0) goto L_0x0132
            int r0 = r0.getCount()
            if (r0 == 0) goto L_0x0132
            boolean r0 = r13.mAreHeadersSticky
            if (r0 != 0) goto L_0x0010
            goto L_0x0132
        L_0x0010:
            r0 = 0
            android.view.View r1 = r13.getChildAt(r0)
            if (r1 != 0) goto L_0x0018
            return
        L_0x0018:
            int r1 = r13.mNumMeasuredColumns
            int r1 = r14 - r1
            if (r1 >= 0) goto L_0x001f
            r1 = r14
        L_0x001f:
            int r2 = r13.mNumMeasuredColumns
            int r2 = r2 + r14
            com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper r3 = r13.mAdapter
            int r3 = r3.getCount()
            if (r2 < r3) goto L_0x002b
            r2 = r14
        L_0x002b:
            int r3 = r13.mVerticalSpacing
            if (r3 != 0) goto L_0x0037
            com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper r1 = r13.mAdapter
            long r1 = r1.getHeaderId(r14)
        L_0x0035:
            r3 = r14
            goto L_0x0079
        L_0x0037:
            if (r3 >= 0) goto L_0x005b
            com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper r1 = r13.mAdapter
            r1.getHeaderId(r14)
            int r1 = r13.mNumMeasuredColumns
            android.view.View r1 = r13.getChildAt(r1)
            int r1 = r1.getTop()
            if (r1 > 0) goto L_0x0054
            com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper r1 = r13.mAdapter
            long r3 = r1.getHeaderId(r2)
            r11 = r3
            r3 = r2
        L_0x0052:
            r1 = r11
            goto L_0x0079
        L_0x0054:
            com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper r1 = r13.mAdapter
            long r1 = r1.getHeaderId(r14)
            goto L_0x0035
        L_0x005b:
            android.view.View r2 = r13.getChildAt(r0)
            int r2 = r2.getTop()
            if (r2 <= 0) goto L_0x0072
            int r3 = r13.mVerticalSpacing
            if (r2 >= r3) goto L_0x0072
            com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper r2 = r13.mAdapter
            long r2 = r2.getHeaderId(r1)
            r11 = r2
            r3 = r1
            goto L_0x0052
        L_0x0072:
            com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper r1 = r13.mAdapter
            long r1 = r1.getHeaderId(r14)
            goto L_0x0035
        L_0x0079:
            long r4 = r13.mCurrentHeaderId
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x008f
            com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper r4 = r13.mAdapter
            android.view.View r5 = r13.mStickiedHeader
            android.view.View r3 = r4.getHeaderView(r3, r5, r13)
            r13.swapStickiedHeader(r3)
            r13.measureHeader()
            r13.mCurrentHeaderId = r1
        L_0x008f:
            int r1 = r13.getChildCount()
            if (r1 == 0) goto L_0x0132
            r2 = 0
            r3 = 99999(0x1869f, float:1.40128E-40)
            r4 = r3
            r3 = r2
            r2 = r0
        L_0x009c:
            if (r2 < r1) goto L_0x0100
            int r1 = r13.getHeaderHeight()
            if (r3 == 0) goto L_0x00f0
            if (r14 != 0) goto L_0x00b8
            android.view.View r14 = super.getChildAt(r0)
            int r14 = r14.getTop()
            if (r14 <= 0) goto L_0x00b8
            boolean r14 = r13.mClippingToPadding
            if (r14 != 0) goto L_0x00b8
            r13.mHeaderBottomPosition = r0
            goto L_0x0132
        L_0x00b8:
            boolean r14 = r13.mClippingToPadding
            if (r14 == 0) goto L_0x00de
            int r14 = r3.getTop()
            int r0 = r13.getPaddingTop()
            int r0 = r0 + r1
            int r14 = java.lang.Math.min(r14, r0)
            r13.mHeaderBottomPosition = r14
            int r14 = r13.mHeaderBottomPosition
            int r0 = r13.getPaddingTop()
            if (r14 >= r0) goto L_0x00d9
            int r14 = r13.getPaddingTop()
            int r1 = r1 + r14
            goto L_0x00db
        L_0x00d9:
            int r1 = r13.mHeaderBottomPosition
        L_0x00db:
            r13.mHeaderBottomPosition = r1
            goto L_0x0132
        L_0x00de:
            int r14 = r3.getTop()
            int r14 = java.lang.Math.min(r14, r1)
            r13.mHeaderBottomPosition = r14
            int r14 = r13.mHeaderBottomPosition
            if (r14 >= 0) goto L_0x00ed
            r14 = r1
        L_0x00ed:
            r13.mHeaderBottomPosition = r14
            goto L_0x0132
        L_0x00f0:
            r13.mHeaderBottomPosition = r1
            boolean r14 = r13.mClippingToPadding
            if (r14 == 0) goto L_0x0132
            int r14 = r13.mHeaderBottomPosition
            int r0 = r13.getPaddingTop()
            int r14 = r14 + r0
            r13.mHeaderBottomPosition = r14
            goto L_0x0132
        L_0x0100:
            android.view.View r5 = super.getChildAt(r2)
            boolean r6 = r13.mClippingToPadding
            if (r6 == 0) goto L_0x0112
            int r6 = r5.getTop()
            int r7 = r13.getPaddingTop()
            int r6 = r6 - r7
            goto L_0x0116
        L_0x0112:
            int r6 = r5.getTop()
        L_0x0116:
            if (r6 >= 0) goto L_0x0119
            goto L_0x012d
        L_0x0119:
            com.hichip.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper r7 = r13.mAdapter
            int r8 = r13.getPositionForView(r5)
            long r7 = r7.getItemId(r8)
            r9 = -1
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x012d
            if (r6 >= r4) goto L_0x012d
            r3 = r5
            r4 = r6
        L_0x012d:
            int r5 = r13.mNumMeasuredColumns
            int r2 = r2 + r5
            goto L_0x009c
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hichip.widget.stickygridheaders.StickyGridHeadersGridView.scrollChanged(int):void");
    }

    private void swapStickiedHeader(View view) {
        detachHeader(this.mStickiedHeader);
        attachHeader(view);
        this.mStickiedHeader = view;
    }

    private MotionEvent transformEvent(MotionEvent motionEvent, int i) {
        int i2 = i;
        if (i2 == -2) {
            return motionEvent;
        }
        long downTime = motionEvent.getDownTime();
        long eventTime = motionEvent.getEventTime();
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        int[] pointerIds = getPointerIds(motionEvent);
        MotionEvent.PointerCoords[] pointerCoords = getPointerCoords(motionEvent);
        int metaState = motionEvent.getMetaState();
        float xPrecision = motionEvent.getXPrecision();
        float yPrecision = motionEvent.getYPrecision();
        int deviceId = motionEvent.getDeviceId();
        int edgeFlags = motionEvent.getEdgeFlags();
        int source = motionEvent.getSource();
        int flags = motionEvent.getFlags();
        View childAt = getChildAt(i2);
        int i3 = 0;
        while (i3 < pointerCount) {
            long j = downTime;
            pointerCoords[i3].y -= (float) childAt.getTop();
            i3++;
            downTime = j;
            eventTime = eventTime;
        }
        return MotionEvent.obtain(downTime, eventTime, action, pointerCount, pointerIds, pointerCoords, metaState, xPrecision, yPrecision, deviceId, edgeFlags, source, flags);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        Canvas canvas2 = canvas;
        if (Build.VERSION.SDK_INT < 8) {
            scrollChanged(getFirstVisiblePosition());
        }
        View view = this.mStickiedHeader;
        int i4 = 0;
        boolean z = view != null && this.mAreHeadersSticky && view.getVisibility() == 0;
        int headerHeight = getHeaderHeight();
        int i5 = this.mHeaderBottomPosition - headerHeight;
        if (z && this.mMaskStickyHeaderRegion) {
            if (this.mHeadersIgnorePadding) {
                Rect rect = this.mClippingRect;
                rect.left = 0;
                rect.right = getWidth();
            } else {
                this.mClippingRect.left = getPaddingLeft();
                this.mClippingRect.right = getWidth() - getPaddingRight();
            }
            Rect rect2 = this.mClippingRect;
            rect2.top = this.mHeaderBottomPosition;
            rect2.bottom = getHeight();
            canvas.save();
            canvas2.clipRect(this.mClippingRect);
        }
        super.dispatchDraw(canvas);
        ArrayList arrayList = new ArrayList();
        int firstVisiblePosition = getFirstVisiblePosition();
        int i6 = 0;
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                arrayList.add(Integer.valueOf(i6));
            }
            int i7 = this.mNumMeasuredColumns;
            firstVisiblePosition += i7;
            i6 += i7;
        }
        int i8 = 0;
        while (i8 < arrayList.size()) {
            View childAt = getChildAt(((Integer) arrayList.get(i8)).intValue());
            try {
                View view2 = (View) childAt.getTag();
                boolean z2 = ((long) ((StickyGridHeadersBaseAdapterWrapper.HeaderFillerView) childAt).getHeaderId()) == this.mCurrentHeaderId && childAt.getTop() < 0 && this.mAreHeadersSticky;
                if (view2.getVisibility() != 0 || z2) {
                    i4 = 0;
                } else {
                    if (this.mHeadersIgnorePadding) {
                        i3 = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
                    } else {
                        i3 = View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
                    }
                    i4 = 0;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    view2.measure(i3, makeMeasureSpec);
                    if (this.mHeadersIgnorePadding) {
                        view2.layout(getLeft(), 0, getRight(), childAt.getHeight());
                    } else {
                        view2.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), childAt.getHeight());
                    }
                    if (this.mHeadersIgnorePadding) {
                        Rect rect3 = this.mClippingRect;
                        rect3.left = 0;
                        rect3.right = getWidth();
                    } else {
                        this.mClippingRect.left = getPaddingLeft();
                        this.mClippingRect.right = getWidth() - getPaddingRight();
                    }
                    this.mClippingRect.bottom = childAt.getBottom();
                    this.mClippingRect.top = childAt.getTop();
                    canvas.save();
                    canvas2.clipRect(this.mClippingRect);
                    if (this.mHeadersIgnorePadding) {
                        canvas2.translate(0.0f, (float) childAt.getTop());
                    } else {
                        canvas2.translate((float) getPaddingLeft(), (float) childAt.getTop());
                    }
                    view2.draw(canvas2);
                    canvas.restore();
                }
                i8++;
            } catch (Exception unused) {
                return;
            }
        }
        if (z && this.mMaskStickyHeaderRegion) {
            canvas.restore();
        } else if (!z) {
            return;
        }
        if (this.mHeadersIgnorePadding) {
            i = getWidth();
        } else {
            i = (getWidth() - getPaddingLeft()) - getPaddingRight();
        }
        if (this.mStickiedHeader.getWidth() != i) {
            if (this.mHeadersIgnorePadding) {
                i2 = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
            }
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, i4);
            this.mStickiedHeader.measure(View.MeasureSpec.makeMeasureSpec(i4, i4), View.MeasureSpec.makeMeasureSpec(i4, i4));
            this.mStickiedHeader.measure(i2, makeMeasureSpec2);
            if (this.mHeadersIgnorePadding) {
                this.mStickiedHeader.layout(getLeft(), i4, getRight(), this.mStickiedHeader.getHeight());
            } else {
                this.mStickiedHeader.layout(getLeft() + getPaddingLeft(), i4, getRight() - getPaddingRight(), this.mStickiedHeader.getHeight());
            }
        }
        if (this.mHeadersIgnorePadding) {
            Rect rect4 = this.mClippingRect;
            rect4.left = i4;
            rect4.right = getWidth();
        } else {
            this.mClippingRect.left = getPaddingLeft();
            this.mClippingRect.right = getWidth() - getPaddingRight();
        }
        Rect rect5 = this.mClippingRect;
        rect5.bottom = i5 + headerHeight;
        if (this.mClippingToPadding) {
            rect5.top = getPaddingTop();
        } else {
            rect5.top = i4;
        }
        canvas.save();
        canvas2.clipRect(this.mClippingRect);
        if (this.mHeadersIgnorePadding) {
            canvas2.translate(0.0f, (float) i5);
        } else {
            canvas2.translate((float) getPaddingLeft(), (float) i5);
        }
        if (this.mHeaderBottomPosition != headerHeight) {
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (this.mHeaderBottomPosition * 255) / headerHeight, 31);
        }
        this.mStickiedHeader.draw(canvas2);
        if (this.mHeaderBottomPosition != headerHeight) {
            canvas.restore();
        }
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.mNumColumns;
        if (i3 == -1) {
            int i4 = 1;
            if (this.mColumnWidth > 0) {
                int max = Math.max((View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight(), 0);
                int i5 = max / this.mColumnWidth;
                if (i5 > 0) {
                    while (i5 != 1 && (this.mColumnWidth * i5) + ((i5 - 1) * this.mHorizontalSpacing) > max) {
                        i5--;
                    }
                    i4 = i5;
                }
            } else {
                i4 = 2;
            }
            this.mNumMeasuredColumns = i4;
        } else {
            this.mNumMeasuredColumns = i3;
        }
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.mAdapter;
        if (stickyGridHeadersBaseAdapterWrapper != null) {
            stickyGridHeadersBaseAdapterWrapper.setNumColumns(this.mNumMeasuredColumns);
        }
        measureHeader();
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: package-private */
    public void attachHeader(View view) {
        if (view != null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                declaredField.setAccessible(true);
                Method declaredMethod = View.class.getDeclaredMethod("dispatchAttachedToWindow", new Class[]{Class.forName("android.view.View$AttachInfo"), Integer.TYPE});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(view, new Object[]{declaredField.get(this), 8});
            } catch (NoSuchMethodException e) {
                throw new RuntimePlatformSupportException(e);
            } catch (ClassNotFoundException e2) {
                throw new RuntimePlatformSupportException(e2);
            } catch (IllegalArgumentException e3) {
                throw new RuntimePlatformSupportException(e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimePlatformSupportException(e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimePlatformSupportException(e5);
            } catch (NoSuchFieldException e6) {
                throw new RuntimePlatformSupportException(e6);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void detachHeader(View view) {
        if (view != null) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("dispatchDetachedFromWindow", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(view, new Object[0]);
            } catch (NoSuchMethodException e) {
                throw new RuntimePlatformSupportException(e);
            } catch (IllegalArgumentException e2) {
                throw new RuntimePlatformSupportException(e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimePlatformSupportException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimePlatformSupportException(e4);
            }
        }
    }

    private class CheckForHeaderLongPress extends WindowRunnable implements Runnable {
        private CheckForHeaderLongPress() {
            super(StickyGridHeadersGridView.this, (WindowRunnable) null);
        }

        /* synthetic */ CheckForHeaderLongPress(StickyGridHeadersGridView stickyGridHeadersGridView, CheckForHeaderLongPress checkForHeaderLongPress) {
            this();
        }

        public void run() {
            StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this;
            View headerAt = stickyGridHeadersGridView.getHeaderAt(stickyGridHeadersGridView.mMotionHeaderPosition);
            if (headerAt != null) {
                StickyGridHeadersGridView stickyGridHeadersGridView2 = StickyGridHeadersGridView.this;
                if ((!sameWindow() || StickyGridHeadersGridView.this.mDataChanged) ? false : StickyGridHeadersGridView.this.performHeaderLongPress(headerAt, stickyGridHeadersGridView2.headerViewPositionToId(stickyGridHeadersGridView2.mMotionHeaderPosition))) {
                    StickyGridHeadersGridView stickyGridHeadersGridView3 = StickyGridHeadersGridView.this;
                    stickyGridHeadersGridView3.mTouchMode = -2;
                    stickyGridHeadersGridView3.setPressed(false);
                    headerAt.setPressed(false);
                    return;
                }
                StickyGridHeadersGridView.this.mTouchMode = 2;
            }
        }
    }

    private class PerformHeaderClick extends WindowRunnable implements Runnable {
        int mClickMotionPosition;

        private PerformHeaderClick() {
            super(StickyGridHeadersGridView.this, (WindowRunnable) null);
        }

        /* synthetic */ PerformHeaderClick(StickyGridHeadersGridView stickyGridHeadersGridView, PerformHeaderClick performHeaderClick) {
            this();
        }

        public void run() {
            int i;
            View headerAt;
            if (!StickyGridHeadersGridView.this.mDataChanged && StickyGridHeadersGridView.this.mAdapter != null && StickyGridHeadersGridView.this.mAdapter.getCount() > 0 && (i = this.mClickMotionPosition) != -1 && i < StickyGridHeadersGridView.this.mAdapter.getCount() && sameWindow() && (headerAt = StickyGridHeadersGridView.this.getHeaderAt(this.mClickMotionPosition)) != null) {
                StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this;
                stickyGridHeadersGridView.performHeaderClick(headerAt, stickyGridHeadersGridView.headerViewPositionToId(this.mClickMotionPosition));
            }
        }
    }

    private class WindowRunnable {
        private int mOriginalAttachCount;

        private WindowRunnable() {
        }

        /* synthetic */ WindowRunnable(StickyGridHeadersGridView stickyGridHeadersGridView, WindowRunnable windowRunnable) {
            this();
        }

        public void rememberWindowAttachCount() {
            this.mOriginalAttachCount = StickyGridHeadersGridView.this.getWindowAttachCount();
        }

        public boolean sameWindow() {
            return StickyGridHeadersGridView.this.hasWindowFocus() && StickyGridHeadersGridView.this.getWindowAttachCount() == this.mOriginalAttachCount;
        }
    }

    final class CheckForHeaderTap implements Runnable {
        CheckForHeaderTap() {
        }

        public void run() {
            if (StickyGridHeadersGridView.this.mTouchMode == 0) {
                StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this;
                stickyGridHeadersGridView.mTouchMode = 1;
                View headerAt = stickyGridHeadersGridView.getHeaderAt(stickyGridHeadersGridView.mMotionHeaderPosition);
                if (headerAt != null && !StickyGridHeadersGridView.this.mHeaderChildBeingPressed) {
                    if (!StickyGridHeadersGridView.this.mDataChanged) {
                        headerAt.setPressed(true);
                        StickyGridHeadersGridView.this.setPressed(true);
                        StickyGridHeadersGridView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        if (StickyGridHeadersGridView.this.isLongClickable()) {
                            if (StickyGridHeadersGridView.this.mPendingCheckForLongPress == null) {
                                StickyGridHeadersGridView stickyGridHeadersGridView2 = StickyGridHeadersGridView.this;
                                stickyGridHeadersGridView2.mPendingCheckForLongPress = new CheckForHeaderLongPress(stickyGridHeadersGridView2, (CheckForHeaderLongPress) null);
                            }
                            StickyGridHeadersGridView.this.mPendingCheckForLongPress.rememberWindowAttachCount();
                            StickyGridHeadersGridView stickyGridHeadersGridView3 = StickyGridHeadersGridView.this;
                            stickyGridHeadersGridView3.postDelayed(stickyGridHeadersGridView3.mPendingCheckForLongPress, (long) longPressTimeout);
                            return;
                        }
                        StickyGridHeadersGridView.this.mTouchMode = 2;
                        return;
                    }
                    StickyGridHeadersGridView.this.mTouchMode = 2;
                }
            }
        }
    }

    class RuntimePlatformSupportException extends RuntimeException {
        private static final long serialVersionUID = -6512098808936536538L;

        public RuntimePlatformSupportException(Exception exc) {
            super(StickyGridHeadersGridView.ERROR_PLATFORM, exc);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (SavedState) null);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean areHeadersSticky;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.areHeadersSticky = parcel.readByte() != 0;
        }

        public String toString() {
            return "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.areHeadersSticky + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.areHeadersSticky ? (byte) 1 : 0);
        }
    }
}
