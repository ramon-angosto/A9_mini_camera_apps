package com.shix.shixipc.gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MyImageView extends ImageView {
    private OnMeasureListener onMeasureListener;

    public interface OnMeasureListener {
        void onMeasureSize(int i, int i2);
    }

    public void setOnMeasureListener(OnMeasureListener onMeasureListener2) {
        this.onMeasureListener = onMeasureListener2;
    }

    public MyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        OnMeasureListener onMeasureListener2 = this.onMeasureListener;
        if (onMeasureListener2 != null) {
            onMeasureListener2.onMeasureSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }
}
