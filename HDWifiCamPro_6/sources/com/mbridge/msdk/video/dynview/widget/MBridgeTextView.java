package com.mbridge.msdk.video.dynview.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class MBridgeTextView extends AppCompatTextView {
    private ObjectAnimator objectAnimator;

    public MBridgeTextView(Context context) {
        super(context);
    }

    public MBridgeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator2) {
        this.objectAnimator = objectAnimator2;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator2 = this.objectAnimator;
        if (objectAnimator2 != null) {
            try {
                objectAnimator2.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator2 = this.objectAnimator;
        if (objectAnimator2 != null) {
            try {
                objectAnimator2.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
