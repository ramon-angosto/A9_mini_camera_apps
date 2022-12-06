package sg.bigo.ads.api;

import android.content.Context;
import android.util.AttributeSet;
import sg.bigo.ads.core.adview.a;
import sg.bigo.ads.core.adview.c;

@Deprecated
public class AdIconView extends a<a> {
    public AdIconView(Context context) {
        super(context);
    }

    public AdIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ c a() {
        return new a(this);
    }

    public void setIconUrl(String str) {
        ((a) getViewImpl()).a(str);
    }
}
