package object.p2pipcam.gridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.jxl.app.littlestars.project.R;
import com.nineoldandroids.view.ViewHelper;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.ScreenUtils;

public class SlidingMenu extends HorizontalScrollView {
    private static SlidingMenuEndInterface slidingMenuEndInterface;
    private boolean isOpen;
    private ViewGroup mContent;
    private int mHalfMenuWidth;
    private ViewGroup mMenu;
    private int mMenuRightPadding;
    private int mMenuWidth;
    private int mScreenWidth;
    private boolean once;

    public interface SlidingMenuEndInterface {
        void callbacMenuEnd();

        void callbacMenuOpen();
    }

    public SlidingMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScreenWidth = ScreenUtils.getScreenWidth(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SlidingMenu, i, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 0) {
                this.mMenuRightPadding = obtainStyledAttributes.getDimensionPixelSize(index, (int) TypedValue.applyDimension(1, 50.0f, getResources().getDisplayMetrics()));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public SlidingMenu(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public static void setSlidingMenuEndInterface(SlidingMenuEndInterface slidingMenuEndInterface2) {
        slidingMenuEndInterface = slidingMenuEndInterface2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!this.once) {
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            this.mMenu = (ViewGroup) linearLayout.getChildAt(0);
            this.mContent = (ViewGroup) linearLayout.getChildAt(1);
            this.mMenuWidth = this.mScreenWidth - this.mMenuRightPadding;
            this.mHalfMenuWidth = this.mMenuWidth / 2;
            this.mMenu.getLayoutParams().width = this.mMenuWidth;
            this.mContent.getLayoutParams().width = this.mScreenWidth;
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            scrollTo(this.mMenuWidth, 0);
            this.once = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            CommonUtil.Log(1, "MotionEvent.ACTION_DOWN");
            return true;
        } else if (action != 1) {
            return super.onTouchEvent(motionEvent);
        } else {
            CommonUtil.Log(1, "MotionEvent.ACTION_UP");
            if (getScrollX() > this.mHalfMenuWidth) {
                smoothScrollTo(this.mMenuWidth, 0);
                this.isOpen = false;
            } else {
                smoothScrollTo(0, 0);
                this.isOpen = true;
            }
            return true;
        }
    }

    public void openMenu() {
        if (!this.isOpen) {
            smoothScrollTo(0, 0);
            this.isOpen = true;
        }
    }

    public void closeMenu() {
        if (this.isOpen) {
            smoothScrollTo(this.mMenuWidth, 0);
            this.isOpen = false;
        }
    }

    public void toggle() {
        if (this.isOpen) {
            closeMenu();
        } else {
            openMenu();
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        SlidingMenuEndInterface slidingMenuEndInterface2;
        if (i3 == this.mMenuWidth && slidingMenuEndInterface != null) {
            CommonUtil.Log(1, "l==mMenuWidth&&slidingMenuEndInterface!=null");
            slidingMenuEndInterface.callbacMenuEnd();
        }
        super.onScrollChanged(i, i2, i3, i4);
        if (i4 == 0 && i == 0 && i2 == 0 && (slidingMenuEndInterface2 = slidingMenuEndInterface) != null) {
            slidingMenuEndInterface2.callbacMenuOpen();
        }
        float f = (((float) i) * 1.0f) / ((float) this.mMenuWidth);
        float f2 = 1.0f - (0.3f * f);
        float f3 = (0.2f * f) + 0.8f;
        ViewHelper.setScaleX(this.mMenu, f2);
        ViewHelper.setScaleY(this.mMenu, f2);
        ViewHelper.setAlpha(this.mMenu, ((1.0f - f) * 0.4f) + 0.6f);
        ViewHelper.setTranslationX(this.mMenu, ((float) this.mMenuWidth) * f * 0.7f);
        ViewHelper.setPivotX(this.mContent, 0.0f);
        ViewGroup viewGroup = this.mContent;
        ViewHelper.setPivotY(viewGroup, (float) (viewGroup.getHeight() / 2));
        ViewHelper.setScaleX(this.mContent, f3);
        ViewHelper.setScaleY(this.mContent, f3);
    }
}
