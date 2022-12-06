package com.tzh.ipcamera.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class BasePlayer extends VideoView {
    public BasePlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
    }
}
