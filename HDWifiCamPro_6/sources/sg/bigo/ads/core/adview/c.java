package sg.bigo.ads.core.adview;

import android.view.View;
import android.view.ViewGroup;
import sg.bigo.ads.api.a;
import sg.bigo.ads.common.utils.s;

public abstract class c {
    final a<?> a;

    protected c(a<?> aVar) {
        this.a = aVar;
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        s.a(view, this.a, (ViewGroup.LayoutParams) null, -1);
    }

    public boolean a(int i, int i2) {
        return s.a((View) this.a, i, i2);
    }
}
