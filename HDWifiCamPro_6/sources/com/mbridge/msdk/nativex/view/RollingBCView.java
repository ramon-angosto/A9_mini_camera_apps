package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.mbridge.msdk.nativex.adapter.RollingAdapter;
import com.mbridge.msdk.nativex.listener.RollingPagerListenrt;
import com.mbridge.msdk.nativex.view.MBNativeRollView;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;

public class RollingBCView extends ViewPager {
    private NativeListener.FilpListener FilpListening;
    private boolean isReport = true;
    private RollingPagerListenrt listenrt = new RollingPagerListenrt();
    private MBNativeRollView.a mvinterface;

    public void setFilpListening(NativeListener.FilpListener filpListener) {
        this.FilpListening = filpListener;
    }

    private RollingBCView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOffscreenPageLimit(1);
        setClipChildren(false);
    }

    public RollingBCView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            int i3 = 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
                if (measuredHeight > 10 && this.isReport) {
                    this.listenrt.reportRollBC(0);
                    this.isReport = false;
                }
            }
            i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setData(List<Frame> list, Context context, String str, MBNativeRollView.a aVar) {
        if (list == null || list.size() == 0) {
            throw new NegativeArraySizeException("ad date is null or size is 0");
        }
        RollingAdapter rollingAdapter = new RollingAdapter(list);
        if (aVar != null) {
            rollingAdapter.setMvinterface(aVar);
        }
        setAdapter(rollingAdapter);
        this.listenrt.setCampList(list, context, str);
        NativeListener.FilpListener filpListener = this.FilpListening;
        if (filpListener != null) {
            this.listenrt.setFilpListening(filpListener);
        }
        setOnPageChangeListener(this.listenrt);
        if (this.isReport) {
            this.listenrt.reportRollBC(0);
            this.isReport = false;
        }
    }
}
