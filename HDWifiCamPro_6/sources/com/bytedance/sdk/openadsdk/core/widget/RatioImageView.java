package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class RatioImageView extends ImageView {
    private float a;

    public RatioImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public RatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = getLayoutParams().width;
        int i4 = getLayoutParams().height;
        float f = this.a;
        if (f > 0.0f) {
            if (i3 == -2) {
                size = (int) (((float) size2) * f);
                mode = 1073741824;
            } else if (i4 == -2) {
                size2 = (int) (((float) size) / f);
                mode2 = 1073741824;
            }
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    public void setRatio(float f) {
        this.a = f;
    }
}
