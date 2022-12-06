package object.p2pipcam.gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import object.p2pipcam.gridview.PullToRefreshBase;

public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements AbsListView.OnScrollListener {
    private View emptyView;
    private int lastSavedFirstVisibleItem = -1;
    private ImageView mTopImageView;
    private PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener;
    private AbsListView.OnScrollListener onScrollListener;
    private FrameLayout refreshableViewHolder;

    public abstract ContextMenu.ContextMenuInfo getContextMenuInfo();

    public PullToRefreshAdapterViewBase(Context context) {
        super(context);
        ((AbsListView) this.refreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, int i) {
        super(context, i);
        ((AbsListView) this.refreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((AbsListView) this.refreshableView).setOnScrollListener(this);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener2 = this.onLastItemVisibleListener;
        if (onLastItemVisibleListener2 != null && i2 > 0 && i + i2 == i3 && i != this.lastSavedFirstVisibleItem) {
            this.lastSavedFirstVisibleItem = i;
            onLastItemVisibleListener2.onLastItemVisible();
        }
        AbsListView.OnScrollListener onScrollListener2 = this.onScrollListener;
        if (onScrollListener2 != null) {
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener2 = this.onScrollListener;
        if (onScrollListener2 != null) {
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
    }

    public void setBackToTopView(ImageView imageView) {
        this.mTopImageView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PullToRefreshAdapterViewBase.this.refreshableView instanceof ListView) {
                    ((ListView) PullToRefreshAdapterViewBase.this.refreshableView).setSelection(0);
                } else if (PullToRefreshAdapterViewBase.this.refreshableView instanceof GridView) {
                    ((GridView) PullToRefreshAdapterViewBase.this.refreshableView).setSelection(0);
                }
            }
        });
    }

    public final void setEmptyView(View view) {
        View view2 = this.emptyView;
        if (view2 != null) {
            this.refreshableViewHolder.removeView(view2);
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            this.refreshableViewHolder.addView(view, -1, -1);
        }
        if (this.refreshableView instanceof EmptyViewMethodAccessor) {
            ((EmptyViewMethodAccessor) this.refreshableView).setEmptyViewInternal(view);
        } else {
            ((AbsListView) this.refreshableView).setEmptyView(view);
        }
    }

    public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener2) {
        this.onLastItemVisibleListener = onLastItemVisibleListener2;
    }

    public final void setOnScrollListener(AbsListView.OnScrollListener onScrollListener2) {
        this.onScrollListener = onScrollListener2;
    }

    /* access modifiers changed from: protected */
    public void addRefreshableView(Context context, T t) {
        this.refreshableViewHolder = new FrameLayout(context);
        this.refreshableViewHolder.addView(t, -1, -1);
        addView(this.refreshableViewHolder, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    /* access modifiers changed from: protected */
    public boolean isReadyForPullDown() {
        return isFirstItemVisible();
    }

    /* access modifiers changed from: protected */
    public boolean isReadyForPullUp() {
        return isLastItemVisible();
    }

    private boolean isFirstItemVisible() {
        View childAt;
        if (((AbsListView) this.refreshableView).getCount() == 0) {
            return true;
        }
        if (((AbsListView) this.refreshableView).getFirstVisiblePosition() != 0 || (childAt = ((AbsListView) this.refreshableView).getChildAt(0)) == null || childAt.getTop() < ((AbsListView) this.refreshableView).getTop()) {
            return false;
        }
        return true;
    }

    private boolean isLastItemVisible() {
        View childAt;
        int count = ((AbsListView) this.refreshableView).getCount();
        int lastVisiblePosition = ((AbsListView) this.refreshableView).getLastVisiblePosition();
        if (count == 0) {
            return true;
        }
        if (lastVisiblePosition != count - 1 || (childAt = ((AbsListView) this.refreshableView).getChildAt(lastVisiblePosition - ((AbsListView) this.refreshableView).getFirstVisiblePosition())) == null || childAt.getBottom() > ((AbsListView) this.refreshableView).getBottom()) {
            return false;
        }
        return true;
    }
}
