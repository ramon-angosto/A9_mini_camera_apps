package sg.bigo.ads.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import sg.bigo.ads.core.adview.c;

public abstract class a<T extends c> extends FrameLayout {
    private T a;

    public a(Context context) {
        super(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public abstract T a();

    public final boolean a(int i, int i2) {
        return getViewImpl().a(i, i2);
    }

    /* access modifiers changed from: protected */
    public final synchronized T getViewImpl() {
        if (this.a == null) {
            this.a = a();
        }
        return this.a;
    }

    @Deprecated
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }
}
