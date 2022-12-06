package object.p2pipcam.gridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.jxl.app.littlestars.project.R;

public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    static final float FRICTION = 2.0f;
    static final int MANUAL_REFRESHING = 3;
    public static final int MODE_BOTH = 3;
    public static final int MODE_PULL_DOWN_TO_REFRESH = 1;
    public static final int MODE_PULL_UP_TO_REFRESH = 2;
    static final int PULL_TO_REFRESH = 0;
    static final int REFRESHING = 2;
    static final int RELEASE_TO_REFRESH = 1;
    private int currentMode;
    private PullToRefreshBase<T>.SmoothScrollRunnable currentSmoothScrollRunnable;
    private boolean disableScrollingWhileRefreshing = true;
    private LoadingLayout footerLayout;
    private final Handler handler = new Handler();
    private int headerHeight;
    private LoadingLayout headerLayout;
    private float initialMotionY;
    private boolean isBeingDragged = false;
    private boolean isPullToRefreshEnabled = true;
    private float lastMotionX;
    private float lastMotionY;
    private int mode = 1;
    private OnRefreshListener onRefreshListener;
    T refreshableView;
    private int state = 0;
    private int touchSlop;

    public interface OnLastItemVisibleListener {
        void onLastItemVisible();
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    /* access modifiers changed from: protected */
    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    /* access modifiers changed from: protected */
    public abstract boolean isReadyForPullDown();

    /* access modifiers changed from: protected */
    public abstract boolean isReadyForPullUp();

    public PullToRefreshBase(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public PullToRefreshBase(Context context, int i) {
        super(context);
        this.mode = i;
        init(context, (AttributeSet) null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public final T getAdapterView() {
        return this.refreshableView;
    }

    public final T getRefreshableView() {
        return this.refreshableView;
    }

    public final boolean isPullToRefreshEnabled() {
        return this.isPullToRefreshEnabled;
    }

    public final void setPullToRefreshEnabled(boolean z) {
        this.isPullToRefreshEnabled = z;
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        return this.disableScrollingWhileRefreshing;
    }

    public final void setDisableScrollingWhileRefreshing(boolean z) {
        this.disableScrollingWhileRefreshing = z;
    }

    public final boolean isRefreshing() {
        int i = this.state;
        return i == 2 || i == 3;
    }

    public final void setRefreshing(boolean z) {
        if (!isRefreshing()) {
            setRefreshingInternal(z);
            this.state = 3;
        }
    }

    public final void onRefreshComplete() {
        if (this.state != 0) {
            resetHeader();
        }
    }

    public final void setOnRefreshListener(OnRefreshListener onRefreshListener2) {
        this.onRefreshListener = onRefreshListener2;
    }

    public void setReleaseLabel(String str) {
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setReleaseLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setReleaseLabel(str);
        }
    }

    public void setPullLabel(String str) {
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setPullLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setPullLabel(str);
        }
    }

    public void setRefreshingLabel(String str) {
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setRefreshingLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setRefreshingLabel(str);
        }
    }

    public final void setRefreshing() {
        setRefreshing(true);
    }

    public final boolean hasPullFromTop() {
        return this.currentMode != 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        if (r0 != 3) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.isPullToRefreshEnabled
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r4.isRefreshing()
            r2 = 1
            if (r0 == 0) goto L_0x0012
            boolean r0 = r4.disableScrollingWhileRefreshing
            if (r0 == 0) goto L_0x0012
            return r2
        L_0x0012:
            int r0 = r5.getAction()
            if (r0 != 0) goto L_0x001f
            int r0 = r5.getEdgeFlags()
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            int r0 = r5.getAction()
            if (r0 == 0) goto L_0x0057
            if (r0 == r2) goto L_0x003c
            r3 = 2
            if (r0 == r3) goto L_0x002e
            r5 = 3
            if (r0 == r5) goto L_0x003c
            goto L_0x0066
        L_0x002e:
            boolean r0 = r4.isBeingDragged
            if (r0 == 0) goto L_0x0066
            float r5 = r5.getY()
            r4.lastMotionY = r5
            r4.pullEvent()
            return r2
        L_0x003c:
            boolean r5 = r4.isBeingDragged
            if (r5 == 0) goto L_0x0066
            r4.isBeingDragged = r1
            int r5 = r4.state
            if (r5 != r2) goto L_0x0053
            object.p2pipcam.gridview.PullToRefreshBase$OnRefreshListener r5 = r4.onRefreshListener
            if (r5 == 0) goto L_0x0053
            r4.setRefreshingInternal(r2)
            object.p2pipcam.gridview.PullToRefreshBase$OnRefreshListener r5 = r4.onRefreshListener
            r5.onRefresh()
            goto L_0x0056
        L_0x0053:
            r4.smoothScrollTo(r1)
        L_0x0056:
            return r2
        L_0x0057:
            boolean r0 = r4.isReadyForPull()
            if (r0 == 0) goto L_0x0066
            float r5 = r5.getY()
            r4.initialMotionY = r5
            r4.lastMotionY = r5
            return r2
        L_0x0066:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: object.p2pipcam.gridview.PullToRefreshBase.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.isPullToRefreshEnabled) {
            return false;
        }
        if (isRefreshing() && this.disableScrollingWhileRefreshing) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.isBeingDragged = false;
            return false;
        } else if (action != 0 && this.isBeingDragged) {
            return true;
        } else {
            if (action != 0) {
                if (action == 2 && isReadyForPull()) {
                    float y = motionEvent.getY();
                    float f = y - this.lastMotionY;
                    float abs = Math.abs(f);
                    float abs2 = Math.abs(motionEvent.getX() - this.lastMotionX);
                    if (abs > ((float) this.touchSlop) && abs > abs2) {
                        int i = this.mode;
                        if ((i == 1 || i == 3) && f >= 1.0E-4f && isReadyForPullDown()) {
                            this.lastMotionY = y;
                            this.isBeingDragged = true;
                            if (this.mode == 3) {
                                this.currentMode = 1;
                            }
                        } else {
                            int i2 = this.mode;
                            if ((i2 == 2 || i2 == 3) && f <= 1.0E-4f && isReadyForPullUp()) {
                                this.lastMotionY = y;
                                this.isBeingDragged = true;
                                if (this.mode == 3) {
                                    this.currentMode = 2;
                                }
                            }
                        }
                    }
                }
            } else if (isReadyForPull()) {
                float y2 = motionEvent.getY();
                this.initialMotionY = y2;
                this.lastMotionY = y2;
                this.lastMotionX = motionEvent.getX();
                this.isBeingDragged = false;
            }
            return this.isBeingDragged;
        }
    }

    /* access modifiers changed from: protected */
    public void addRefreshableView(Context context, T t) {
        addView(t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    /* access modifiers changed from: protected */
    public final int getCurrentMode() {
        return this.currentMode;
    }

    /* access modifiers changed from: protected */
    public final LoadingLayout getFooterLayout() {
        return this.footerLayout;
    }

    /* access modifiers changed from: protected */
    public final LoadingLayout getHeaderLayout() {
        return this.headerLayout;
    }

    /* access modifiers changed from: protected */
    public final int getHeaderHeight() {
        return this.headerHeight;
    }

    /* access modifiers changed from: protected */
    public final int getMode() {
        return this.mode;
    }

    /* access modifiers changed from: protected */
    public void resetHeader() {
        this.state = 0;
        this.isBeingDragged = false;
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.reset();
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.reset();
        }
        smoothScrollTo(0);
    }

    /* access modifiers changed from: protected */
    public void setRefreshingInternal(boolean z) {
        this.state = 2;
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.refreshing();
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.refreshing();
        }
        if (z) {
            smoothScrollTo(this.currentMode == 1 ? -this.headerHeight : this.headerHeight);
        }
    }

    /* access modifiers changed from: protected */
    public final void setHeaderScroll(int i) {
        scrollTo(0, i);
    }

    /* access modifiers changed from: protected */
    public final void smoothScrollTo(int i) {
        PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable = this.currentSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (getScrollY() != i) {
            this.currentSmoothScrollRunnable = new SmoothScrollRunnable(this.handler, getScrollY(), i);
            this.handler.post(this.currentSmoothScrollRunnable);
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i;
        Context context2 = context;
        setOrientation(1);
        this.touchSlop = ViewConfiguration.getTouchSlop();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.PullToRefresh);
        if (obtainStyledAttributes.hasValue(3)) {
            this.mode = obtainStyledAttributes.getInteger(3, 1);
        }
        this.refreshableView = createRefreshableView(context, attributeSet);
        addRefreshableView(context2, this.refreshableView);
        String string = context2.getString(R.string.pull_to_refresh_pull_label);
        String string2 = context2.getString(R.string.pull_to_refresh_refreshing_label);
        String string3 = context2.getString(R.string.pull_to_refresh_release_label);
        int i2 = this.mode;
        if (i2 == 1 || i2 == 3) {
            LoadingLayout loadingLayout = r1;
            i = 0;
            LoadingLayout loadingLayout2 = new LoadingLayout(context, 1, string3, string, string2);
            this.headerLayout = loadingLayout;
            addView(this.headerLayout, 0, new LinearLayout.LayoutParams(-1, -2));
            measureView(this.headerLayout);
            this.headerHeight = this.headerLayout.getMeasuredHeight();
        } else {
            i = 0;
        }
        int i3 = this.mode;
        if (i3 == 2 || i3 == 3) {
            LoadingLayout loadingLayout3 = r1;
            LoadingLayout loadingLayout4 = new LoadingLayout(context, 2, string3, string, string2);
            this.footerLayout = loadingLayout3;
            addView(this.footerLayout, new LinearLayout.LayoutParams(-1, -2));
            measureView(this.footerLayout);
            this.headerHeight = this.footerLayout.getMeasuredHeight();
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, ViewCompat.MEASURED_STATE_MASK);
            LoadingLayout loadingLayout5 = this.headerLayout;
            if (loadingLayout5 != null) {
                loadingLayout5.setTextColor(color);
            }
            LoadingLayout loadingLayout6 = this.footerLayout;
            if (loadingLayout6 != null) {
                loadingLayout6.setTextColor(color);
            }
        }
        if (obtainStyledAttributes.hasValue(1)) {
            setBackgroundResource(obtainStyledAttributes.getResourceId(1, -1));
        }
        if (obtainStyledAttributes.hasValue(i)) {
            this.refreshableView.setBackgroundResource(obtainStyledAttributes.getResourceId(i, -1));
        }
        obtainStyledAttributes.recycle();
        int i4 = this.mode;
        if (i4 == 2) {
            setPadding(i, i, i, -this.headerHeight);
        } else if (i4 != 3) {
            setPadding(i, -this.headerHeight, i, i);
        } else {
            int i5 = this.headerHeight;
            setPadding(i, -i5, i, -i5);
        }
        int i6 = this.mode;
        if (i6 != 3) {
            this.currentMode = i6;
        }
    }

    private void measureView(View view) {
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        if (i2 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, i);
    }

    private boolean pullEvent() {
        int scrollY = getScrollY();
        int round = this.currentMode != 2 ? Math.round(Math.min(this.initialMotionY - this.lastMotionY, 0.0f) / FRICTION) : Math.round(Math.max(this.initialMotionY - this.lastMotionY, 0.0f) / FRICTION);
        setHeaderScroll(round);
        if (round != 0) {
            if (this.state == 0 && this.headerHeight < Math.abs(round)) {
                this.state = 1;
                int i = this.currentMode;
                if (i == 1) {
                    this.headerLayout.releaseToRefresh();
                } else if (i == 2) {
                    this.footerLayout.releaseToRefresh();
                }
                return true;
            } else if (this.state == 1 && this.headerHeight >= Math.abs(round)) {
                this.state = 0;
                int i2 = this.currentMode;
                if (i2 == 1) {
                    this.headerLayout.pullToRefresh();
                } else if (i2 == 2) {
                    this.footerLayout.pullToRefresh();
                }
                return true;
            }
        }
        if (scrollY != round) {
            return true;
        }
        return false;
    }

    private boolean isReadyForPull() {
        int i = this.mode;
        if (i == 1) {
            return isReadyForPullDown();
        }
        if (i == 2) {
            return isReadyForPullUp();
        }
        if (i != 3) {
            return false;
        }
        if (isReadyForPullUp() || isReadyForPullDown()) {
            return true;
        }
        return false;
    }

    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    final class SmoothScrollRunnable implements Runnable {
        static final int ANIMATION_DURATION_MS = 190;
        static final int ANIMATION_FPS = 16;
        private boolean continueRunning = true;
        private int currentY = -1;
        private final Handler handler;
        private final Interpolator interpolator;
        private final int scrollFromY;
        private final int scrollToY;
        private long startTime = -1;

        public SmoothScrollRunnable(Handler handler2, int i, int i2) {
            this.handler = handler2;
            this.scrollFromY = i;
            this.scrollToY = i2;
            this.interpolator = new AccelerateDecelerateInterpolator();
        }

        public void run() {
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                this.currentY = this.scrollFromY - Math.round(((float) (this.scrollFromY - this.scrollToY)) * this.interpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / 190, 1000), 0)) / 1000.0f));
                PullToRefreshBase.this.setHeaderScroll(this.currentY);
            }
            if (this.continueRunning && this.scrollToY != this.currentY) {
                this.handler.postDelayed(this, 16);
            }
        }

        public void stop() {
            this.continueRunning = false;
            this.handler.removeCallbacks(this);
        }
    }
}
