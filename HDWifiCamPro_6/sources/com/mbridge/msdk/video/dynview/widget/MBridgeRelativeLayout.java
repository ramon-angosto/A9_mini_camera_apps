package com.mbridge.msdk.video.dynview.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.video.dynview.endcard.a;
import com.mbridge.msdk.video.dynview.endcard.c;

public class MBridgeRelativeLayout extends RelativeLayout {
    private c a;
    private boolean b;
    private AnimatorSet c;
    private boolean d;
    private a e;

    public MBridgeRelativeLayout(Context context) {
        super(context);
    }

    public MBridgeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.c = animatorSet;
    }

    public void setMoreOfferShowFailedCallBack(c cVar) {
        this.a = cVar;
    }

    public void setMoreOfferCacheReportCallBack(a aVar) {
        this.e = aVar;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AnimatorSet animatorSet = this.c;
        if (animatorSet != null) {
            try {
                animatorSet.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        c cVar;
        super.onDetachedFromWindow();
        if (!this.b && (cVar = this.a) != null) {
            this.b = true;
            cVar.a();
        }
        AnimatorSet animatorSet = this.c;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        a aVar;
        super.onVisibilityChanged(view, i);
        if ((view instanceof MBridgeRelativeLayout) && i == 0 && (aVar = this.e) != null && !this.d) {
            this.d = true;
            aVar.a();
        }
    }
}
