package com.hichip.widget.stickygridheadersshix;

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
import com.hichip.widget.stickygridheadersshix.StickyGridHeadersBaseAdapterWrapper;
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

    /* access modifiers changed from: package-private */
    public void attachHeader(View view) {
    }

    /* access modifiers changed from: package-private */
    public void detachHeader(View view) {
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
        int action = motionEvent.getAction();
        boolean z = this.mHeaderChildBeingPressed;
        if (z) {
            View headerAt = getHeaderAt(this.mMotionHeaderPosition);
            int i2 = this.mMotionHeaderPosition;
            final View childAt = i2 == -2 ? headerAt : getChildAt(i2);
            if (action == 1 || action == 3) {
                this.mHeaderChildBeingPressed = false;
            }
            if (headerAt != null) {
                headerAt.dispatchTouchEvent(transformEvent(motionEvent, this.mMotionHeaderPosition));
                headerAt.invalidate();
                headerAt.postDelayed(new Runnable() {
                    public void run() {
                        StickyGridHeadersGridView.this.invalidate(0, childAt.getTop(), StickyGridHeadersGridView.this.getWidth(), childAt.getTop() + childAt.getHeight());
                    }
                }, (long) ViewConfiguration.getPressedStateDuration());
                invalidate(0, childAt.getTop(), getWidth(), childAt.getTop() + childAt.getHeight());
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
                        this.mPerformHeaderClick = new PerformHeaderClick();
                    }
                    final PerformHeaderClick performHeaderClick = this.mPerformHeaderClick;
                    performHeaderClick.mClickMotionPosition = this.mMotionHeaderPosition;
                    performHeaderClick.rememberWindowAttachCount();
                    int i7 = this.mTouchMode;
                    if (i7 == 0 || i7 == 1) {
                        Handler handler = getHandler();
                        if (handler != null) {
                            handler.removeCallbacks(this.mTouchMode == 0 ? this.mPendingCheckForTap : this.mPendingCheckForLongPress);
                        }
                        if (!this.mDataChanged) {
                            this.mTouchMode = 1;
                            headerAt3.setPressed(true);
                            setPressed(true);
                            Runnable runnable = this.mTouchModeReset;
                            if (runnable != null) {
                                removeCallbacks(runnable);
                            }
                            this.mTouchModeReset = new Runnable() {
                                public void run() {
                                    StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this;
                                    stickyGridHeadersGridView.mMotionHeaderPosition = -1;
                                    Runnable unused = stickyGridHeadersGridView.mTouchModeReset = null;
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
        return i == -2 ? this.mCurrentHeaderId : this.mAdapter.getHeaderId(getFirstVisiblePosition() + i);
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

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void scrollChanged(int r15) {
        /*
            r14 = this;
            com.hichip.widget.stickygridheadersshix.StickyGridHeadersBaseAdapterWrapper r0 = r14.mAdapter
            if (r0 == 0) goto L_0x012f
            int r0 = r0.getCount()
            if (r0 == 0) goto L_0x012f
            boolean r0 = r14.mAreHeadersSticky
            if (r0 == 0) goto L_0x012f
            r0 = 0
            android.view.View r1 = r14.getChildAt(r0)
            if (r1 == 0) goto L_0x012f
            int r1 = r14.mNumMeasuredColumns
            int r1 = r15 - r1
            if (r1 >= 0) goto L_0x001c
            r1 = r15
        L_0x001c:
            int r2 = r14.mNumMeasuredColumns
            int r2 = r2 + r15
            com.hichip.widget.stickygridheadersshix.StickyGridHeadersBaseAdapterWrapper r3 = r14.mAdapter
            int r3 = r3.getCount()
            if (r2 < r3) goto L_0x0028
            r2 = r15
        L_0x0028:
            int r3 = r14.mVerticalSpacing
            if (r3 != 0) goto L_0x0034
            com.hichip.widget.stickygridheadersshix.StickyGridHeadersBaseAdapterWrapper r1 = r14.mAdapter
            long r1 = r1.getHeaderId(r15)
        L_0x0032:
            r3 = r15
            goto L_0x0078
        L_0x0034:
            if (r3 >= 0) goto L_0x0059
            com.hichip.widget.stickygridheadersshix.StickyGridHeadersBaseAdapterWrapper r1 = r14.mAdapter
            r1.getHeaderId(r15)
            int r1 = r14.mNumMeasuredColumns
            android.view.View r1 = r14.getChildAt(r1)
            int r1 = r1.getTop()
            if (r1 > 0) goto L_0x004e
            com.hichip.widget.stickygridheadersshix.StickyGridHeadersBaseAdapterWrapper r1 = r14.mAdapter
            long r3 = r1.getHeaderId(r2)
            goto L_0x0056
        L_0x004e:
            com.hichip.widget.stickygridheadersshix.StickyGridHeadersBaseAdapterWrapper r1 = r14.mAdapter
            long r1 = r1.getHeaderId(r15)
            r3 = r1
            r2 = r15
        L_0x0056:
            r12 = r3
            r3 = r2
            goto L_0x006f
        L_0x0059:
            android.view.View r2 = r14.getChildAt(r0)
            int r2 = r2.getTop()
            if (r2 <= 0) goto L_0x0071
            int r3 = r14.mVerticalSpacing
            if (r2 >= r3) goto L_0x0071
            com.hichip.widget.stickygridheadersshix.StickyGridHeadersBaseAdapterWrapper r2 = r14.mAdapter
            long r2 = r2.getHeaderId(r1)
            r12 = r2
            r3 = r1
        L_0x006f:
            r1 = r12
            goto L_0x0078
        L_0x0071:
            com.hichip.widget.stickygridheadersshix.StickyGridHeadersBaseAdapterWrapper r1 = r14.mAdapter
            long r1 = r1.getHeaderId(r15)
            goto L_0x0032
        L_0x0078:
            long r4 = r14.mCurrentHeaderId
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x008e
            com.hichip.widget.stickygridheadersshix.StickyGridHeadersBaseAdapterWrapper r4 = r14.mAdapter
            android.view.View r5 = r14.mStickiedHeader
            android.view.View r3 = r4.getHeaderView(r3, r5, r14)
            r14.swapStickiedHeader(r3)
            r14.measureHeader()
            r14.mCurrentHeaderId = r1
        L_0x008e:
            int r1 = r14.getChildCount()
            if (r1 == 0) goto L_0x012f
            r2 = 0
            r3 = 99999(0x1869f, float:1.40128E-40)
            r3 = r2
            r2 = 0
            r4 = 99999(0x1869f, float:1.40128E-40)
        L_0x009d:
            if (r2 >= r1) goto L_0x00cf
            android.view.View r5 = super.getChildAt(r2)
            boolean r6 = r14.mClippingToPadding
            if (r6 == 0) goto L_0x00b1
            int r6 = r5.getTop()
            int r7 = r14.getPaddingTop()
            int r6 = r6 - r7
            goto L_0x00b5
        L_0x00b1:
            int r6 = r5.getTop()
        L_0x00b5:
            if (r6 < 0) goto L_0x00cb
            com.hichip.widget.stickygridheadersshix.StickyGridHeadersBaseAdapterWrapper r7 = r14.mAdapter
            int r8 = r14.getPositionForView(r5)
            long r7 = r7.getItemId(r8)
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x00cb
            if (r6 >= r4) goto L_0x00cb
            r3 = r5
            r4 = r6
        L_0x00cb:
            int r5 = r14.mNumMeasuredColumns
            int r2 = r2 + r5
            goto L_0x009d
        L_0x00cf:
            int r1 = r14.getHeaderHeight()
            if (r3 == 0) goto L_0x0120
            if (r15 != 0) goto L_0x00e8
            android.view.View r15 = super.getChildAt(r0)
            int r15 = r15.getTop()
            if (r15 <= 0) goto L_0x00e8
            boolean r15 = r14.mClippingToPadding
            if (r15 != 0) goto L_0x00e8
            r14.mHeaderBottomPosition = r0
            goto L_0x012f
        L_0x00e8:
            boolean r15 = r14.mClippingToPadding
            if (r15 == 0) goto L_0x010e
            int r15 = r3.getTop()
            int r0 = r14.getPaddingTop()
            int r0 = r0 + r1
            int r15 = java.lang.Math.min(r15, r0)
            r14.mHeaderBottomPosition = r15
            int r15 = r14.mHeaderBottomPosition
            int r0 = r14.getPaddingTop()
            if (r15 >= r0) goto L_0x0109
            int r15 = r14.getPaddingTop()
            int r1 = r1 + r15
            goto L_0x010b
        L_0x0109:
            int r1 = r14.mHeaderBottomPosition
        L_0x010b:
            r14.mHeaderBottomPosition = r1
            goto L_0x012f
        L_0x010e:
            int r15 = r3.getTop()
            int r15 = java.lang.Math.min(r15, r1)
            r14.mHeaderBottomPosition = r15
            int r15 = r14.mHeaderBottomPosition
            if (r15 >= 0) goto L_0x011d
            r15 = r1
        L_0x011d:
            r14.mHeaderBottomPosition = r15
            goto L_0x012f
        L_0x0120:
            r14.mHeaderBottomPosition = r1
            boolean r15 = r14.mClippingToPadding
            if (r15 == 0) goto L_0x012f
            int r15 = r14.mHeaderBottomPosition
            int r0 = r14.getPaddingTop()
            int r15 = r15 + r0
            r14.mHeaderBottomPosition = r15
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hichip.widget.stickygridheadersshix.StickyGridHeadersGridView.scrollChanged(int):void");
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
            int i4 = source;
            pointerCoords[i3].y -= (float) childAt.getTop();
            i3++;
            source = i4;
            edgeFlags = edgeFlags;
            deviceId = deviceId;
        }
        return MotionEvent.obtain(downTime, eventTime, action, pointerCount, pointerIds, pointerCoords, metaState, xPrecision, yPrecision, deviceId, edgeFlags, source, flags);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        Canvas canvas2 = canvas;
        if (Build.VERSION.SDK_INT < 8) {
            scrollChanged(getFirstVisiblePosition());
        }
        View view = this.mStickiedHeader;
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
                if (view2.getVisibility() == 0 && !z2) {
                    if (this.mHeadersIgnorePadding) {
                        i4 = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
                    } else {
                        i4 = View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
                    }
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    view2.measure(i4, makeMeasureSpec);
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
                i3 = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
            } else {
                i3 = View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
            }
            i2 = 0;
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.mStickiedHeader.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.mStickiedHeader.measure(i3, makeMeasureSpec2);
            if (this.mHeadersIgnorePadding) {
                this.mStickiedHeader.layout(getLeft(), 0, getRight(), this.mStickiedHeader.getHeight());
            } else {
                this.mStickiedHeader.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.mStickiedHeader.getHeight());
            }
        } else {
            i2 = 0;
        }
        if (this.mHeadersIgnorePadding) {
            Rect rect4 = this.mClippingRect;
            rect4.left = i2;
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
            rect5.top = 0;
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
        int i3;
        int i4 = this.mNumColumns;
        if (i4 == -1) {
            if (this.mColumnWidth > 0) {
                int max = Math.max((View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight(), 0);
                i3 = max / this.mColumnWidth;
                if (i3 > 0) {
                    while (i3 != 1 && (this.mColumnWidth * i3) + ((i3 - 1) * this.mHorizontalSpacing) > max) {
                        i3--;
                    }
                } else {
                    i3 = 1;
                }
            } else {
                i3 = 2;
            }
            this.mNumMeasuredColumns = i3;
        } else {
            this.mNumMeasuredColumns = i4;
        }
        StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.mAdapter;
        if (stickyGridHeadersBaseAdapterWrapper != null) {
            stickyGridHeadersBaseAdapterWrapper.setNumColumns(this.mNumMeasuredColumns);
        }
        measureHeader();
        super.onMeasure(i, i2);
    }

    private class CheckForHeaderLongPress extends WindowRunnable implements Runnable {
        private CheckForHeaderLongPress() {
            super();
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
                                stickyGridHeadersGridView2.mPendingCheckForLongPress = new CheckForHeaderLongPress();
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

    private class PerformHeaderClick extends WindowRunnable implements Runnable {
        int mClickMotionPosition;

        private PerformHeaderClick() {
            super();
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

    class RuntimePlatformSupportException extends RuntimeException {
        private static final long serialVersionUID = -6512098808936536538L;

        public RuntimePlatformSupportException(Exception exc) {
            super(StickyGridHeadersGridView.ERROR_PLATFORM, exc);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean areHeadersSticky;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
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

    private class WindowRunnable {
        private int mOriginalAttachCount;

        private WindowRunnable() {
        }

        public void rememberWindowAttachCount() {
            this.mOriginalAttachCount = StickyGridHeadersGridView.this.getWindowAttachCount();
        }

        public boolean sameWindow() {
            return StickyGridHeadersGridView.this.hasWindowFocus() && StickyGridHeadersGridView.this.getWindowAttachCount() == this.mOriginalAttachCount;
        }
    }
}
