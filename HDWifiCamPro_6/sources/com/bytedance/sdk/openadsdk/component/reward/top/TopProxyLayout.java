package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.model.n;

public class TopProxyLayout extends View implements a<TopProxyLayout> {
    private a a;

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public TopProxyLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TopProxyLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopProxyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View getITopLayout() {
        a aVar = this.a;
        if (!(aVar instanceof View)) {
            return null;
        }
        return (View) aVar;
    }

    public TopProxyLayout a(boolean z, n nVar) {
        TopLayoutDislike2 a2 = new TopLayoutDislike2(getContext()).a(z, nVar);
        if (a2 instanceof a) {
            this.a = a2;
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                a((View) a2, (ViewGroup) parent);
            }
            return this;
        }
        l.e("TopProxyLayout", "view not implements ITopLayout interface");
        return this;
    }

    private void a(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
        if (view != null) {
            view.setId(t.e(getContext(), "tt_real_top_layout_proxy"));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setShowSkip(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setShowSkip(z);
        }
    }

    public void setSkipEnable(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setSkipEnable(z);
        }
    }

    public void c() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void setShowSound(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setShowSound(z);
        }
    }

    public void setSoundMute(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setSoundMute(z);
        }
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(charSequence, charSequence2);
        }
    }

    public void setShowDislike(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setShowDislike(z);
        }
    }

    public void setListener(b bVar) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setListener(bVar);
        }
    }

    public void a() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void b() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b();
        }
    }
}
