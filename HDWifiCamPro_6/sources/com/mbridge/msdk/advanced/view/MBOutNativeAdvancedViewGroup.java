package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.advanced.c.c;

public class MBOutNativeAdvancedViewGroup extends RelativeLayout {
    /* access modifiers changed from: private */
    public c a;

    public void setProvider(c cVar) {
        this.a = cVar;
    }

    public MBOutNativeAdvancedViewGroup(Context context) {
        super(context);
    }

    public MBOutNativeAdvancedViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBOutNativeAdvancedViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            a(1);
            if (getVisibility() == 0) {
                a(2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.a;
        if (cVar != null) {
            cVar.e(1);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            a(2);
            if (getParent() != null) {
                a(1);
                return;
            }
            return;
        }
        c cVar = this.a;
        if (cVar != null) {
            cVar.e(2);
        }
    }

    private void a(final int i) {
        postDelayed(new Runnable() {
            public final void run() {
                if (MBOutNativeAdvancedViewGroup.this.a != null) {
                    MBOutNativeAdvancedViewGroup.this.a.d(i);
                }
            }
        }, 200);
    }
}
