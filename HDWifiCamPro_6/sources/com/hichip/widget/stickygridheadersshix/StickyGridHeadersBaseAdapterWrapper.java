package com.hichip.widget.stickygridheadersshix;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;

public class StickyGridHeadersBaseAdapterWrapper extends BaseAdapter {
    protected static final int ID_FILLER = -2;
    protected static final int ID_HEADER = -1;
    protected static final int ID_HEADER_FILLER = -3;
    protected static final int POSITION_FILLER = -1;
    protected static final int POSITION_HEADER = -2;
    protected static final int POSITION_HEADER_FILLER = -3;
    protected static final int VIEW_TYPE_FILLER = 0;
    protected static final int VIEW_TYPE_HEADER = 1;
    protected static final int VIEW_TYPE_HEADER_FILLER = 2;
    private static final int sNumViewTypes = 3;
    private final Context mContext;
    private int mCount;
    /* access modifiers changed from: private */
    public boolean mCounted = false;
    private DataSetObserver mDataSetObserver = new DataSetObserver() {
        public void onChanged() {
            StickyGridHeadersBaseAdapterWrapper.this.updateCount();
            StickyGridHeadersBaseAdapterWrapper.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            boolean unused = StickyGridHeadersBaseAdapterWrapper.this.mCounted = false;
            StickyGridHeadersBaseAdapterWrapper.this.notifyDataSetInvalidated();
        }
    };
    private final StickyGridHeadersBaseAdapter mDelegate;
    /* access modifiers changed from: private */
    public StickyGridHeadersGridView mGridView;
    private View mLastHeaderViewSeen;
    private View mLastViewSeen;
    private int mNumColumns = 1;

    public boolean areAllItemsEnabled() {
        return false;
    }

    public StickyGridHeadersBaseAdapterWrapper(Context context, StickyGridHeadersGridView stickyGridHeadersGridView, StickyGridHeadersBaseAdapter stickyGridHeadersBaseAdapter) {
        this.mContext = context;
        this.mDelegate = stickyGridHeadersBaseAdapter;
        this.mGridView = stickyGridHeadersGridView;
        stickyGridHeadersBaseAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    public int getCount() {
        if (this.mCounted) {
            return this.mCount;
        }
        this.mCount = 0;
        int numHeaders = this.mDelegate.getNumHeaders();
        if (numHeaders == 0) {
            this.mCount = this.mDelegate.getCount();
            this.mCounted = true;
            return this.mCount;
        }
        for (int i = 0; i < numHeaders; i++) {
            this.mCount += this.mDelegate.getCountForHeader(i) + unFilledSpacesInHeaderGroup(i) + this.mNumColumns;
        }
        this.mCounted = true;
        return this.mCount;
    }

    public Object getItem(int i) throws ArrayIndexOutOfBoundsException {
        Position translatePosition = translatePosition(i);
        if (translatePosition.mPosition == -1 || translatePosition.mPosition == -2) {
            return null;
        }
        return this.mDelegate.getItem(translatePosition.mPosition);
    }

    public long getItemId(int i) {
        Position translatePosition = translatePosition(i);
        if (translatePosition.mPosition == -2) {
            return -1;
        }
        if (translatePosition.mPosition == -1) {
            return -2;
        }
        if (translatePosition.mPosition == -3) {
            return -3;
        }
        return this.mDelegate.getItemId(translatePosition.mPosition);
    }

    public int getItemViewType(int i) {
        Position translatePosition = translatePosition(i);
        if (translatePosition.mPosition == -2) {
            return 1;
        }
        if (translatePosition.mPosition == -1) {
            return 0;
        }
        if (translatePosition.mPosition == -3) {
            return 2;
        }
        int itemViewType = this.mDelegate.getItemViewType(translatePosition.mPosition);
        return itemViewType == -1 ? itemViewType : itemViewType + 3;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Position translatePosition = translatePosition(i);
        if (translatePosition.mPosition == -2) {
            HeaderFillerView headerFillerView = getHeaderFillerView(translatePosition.mHeader, view, viewGroup);
            View headerView = this.mDelegate.getHeaderView(translatePosition.mHeader, (View) headerFillerView.getTag(), viewGroup);
            this.mGridView.detachHeader((View) headerFillerView.getTag());
            headerFillerView.setTag(headerView);
            this.mGridView.attachHeader(headerView);
            this.mLastHeaderViewSeen = headerFillerView;
            headerFillerView.forceLayout();
            return headerFillerView;
        } else if (translatePosition.mPosition == -3) {
            FillerView fillerView = getFillerView(view, viewGroup, this.mLastHeaderViewSeen);
            fillerView.forceLayout();
            return fillerView;
        } else if (translatePosition.mPosition == -1) {
            return getFillerView(view, viewGroup, this.mLastViewSeen);
        } else {
            View view2 = this.mDelegate.getView(translatePosition.mPosition, view, viewGroup);
            this.mLastViewSeen = view2;
            return view2;
        }
    }

    public int getViewTypeCount() {
        return this.mDelegate.getViewTypeCount() + 3;
    }

    public StickyGridHeadersBaseAdapter getWrappedAdapter() {
        return this.mDelegate;
    }

    public boolean hasStableIds() {
        return this.mDelegate.hasStableIds();
    }

    public boolean isEmpty() {
        return this.mDelegate.isEmpty();
    }

    public boolean isEnabled(int i) {
        Position translatePosition = translatePosition(i);
        if (translatePosition.mPosition == -1 || translatePosition.mPosition == -2) {
            return false;
        }
        return this.mDelegate.isEnabled(translatePosition.mPosition);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDelegate.registerDataSetObserver(dataSetObserver);
    }

    public void setNumColumns(int i) {
        this.mNumColumns = i;
        this.mCounted = false;
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDelegate.unregisterDataSetObserver(dataSetObserver);
    }

    private FillerView getFillerView(View view, ViewGroup viewGroup, View view2) {
        FillerView fillerView = (FillerView) view;
        if (fillerView == null) {
            fillerView = new FillerView(this.mContext);
        }
        fillerView.setMeasureTarget(view2);
        return fillerView;
    }

    private HeaderFillerView getHeaderFillerView(int i, View view, ViewGroup viewGroup) {
        HeaderFillerView headerFillerView = (HeaderFillerView) view;
        return headerFillerView == null ? new HeaderFillerView(this.mContext) : headerFillerView;
    }

    private int unFilledSpacesInHeaderGroup(int i) {
        int countForHeader = this.mDelegate.getCountForHeader(i);
        int i2 = this.mNumColumns;
        int i3 = countForHeader % i2;
        if (i3 == 0) {
            return 0;
        }
        return i2 - i3;
    }

    /* access modifiers changed from: protected */
    public long getHeaderId(int i) {
        return (long) translatePosition(i).mHeader;
    }

    /* access modifiers changed from: protected */
    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        if (this.mDelegate.getNumHeaders() == 0) {
            return null;
        }
        return this.mDelegate.getHeaderView(translatePosition(i).mHeader, view, viewGroup);
    }

    /* access modifiers changed from: protected */
    public Position translatePosition(int i) {
        int numHeaders = this.mDelegate.getNumHeaders();
        int i2 = 0;
        if (numHeaders == 0) {
            return i >= this.mDelegate.getCount() ? new Position(-1, 0) : new Position(i, 0);
        }
        int i3 = i;
        while (i2 < numHeaders) {
            int countForHeader = this.mDelegate.getCountForHeader(i2);
            if (i == 0) {
                return new Position(-2, i2);
            }
            int i4 = this.mNumColumns;
            int i5 = i - i4;
            if (i5 < 0) {
                return new Position(-3, i2);
            }
            int i6 = i3 - i4;
            if (i5 < countForHeader) {
                return new Position(i6, i2);
            }
            int unFilledSpacesInHeaderGroup = unFilledSpacesInHeaderGroup(i2);
            i3 = i6 - unFilledSpacesInHeaderGroup;
            i = i5 - (countForHeader + unFilledSpacesInHeaderGroup);
            if (i < 0) {
                return new Position(-1, i2);
            }
            i2++;
        }
        return new Position(-1, i2);
    }

    /* access modifiers changed from: protected */
    public void updateCount() {
        this.mCount = 0;
        int numHeaders = this.mDelegate.getNumHeaders();
        if (numHeaders == 0) {
            this.mCount = this.mDelegate.getCount();
            this.mCounted = true;
            return;
        }
        for (int i = 0; i < numHeaders; i++) {
            this.mCount += this.mDelegate.getCountForHeader(i) + this.mNumColumns;
        }
        this.mCounted = true;
    }

    protected class FillerView extends View {
        private View mMeasureTarget;

        public FillerView(Context context) {
            super(context);
        }

        public FillerView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public FillerView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public void setMeasureTarget(View view) {
            this.mMeasureTarget = view;
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.mMeasureTarget.getMeasuredHeight(), 1073741824));
        }
    }

    protected class HeaderFillerView extends FrameLayout {
        private int mHeaderId;

        public HeaderFillerView(Context context) {
            super(context);
        }

        public HeaderFillerView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public HeaderFillerView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public int getHeaderId() {
            return this.mHeaderId;
        }

        public void setHeaderId(int i) {
            this.mHeaderId = i;
        }

        /* access modifiers changed from: protected */
        public FrameLayout.LayoutParams generateDefaultLayoutParams() {
            return new FrameLayout.LayoutParams(-1, -1);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            View view = (View) getTag();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (view.getVisibility() != 8) {
                view.measure(getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(StickyGridHeadersBaseAdapterWrapper.this.mGridView.getWidth(), 1073741824), 0, layoutParams.width), getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, layoutParams.height));
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i), view.getMeasuredHeight());
        }
    }

    protected class HeaderHolder {
        protected View mHeaderView;

        protected HeaderHolder() {
        }
    }

    protected class Position {
        protected int mHeader;
        protected int mPosition;

        protected Position(int i, int i2) {
            this.mPosition = i;
            this.mHeader = i2;
        }
    }
}
