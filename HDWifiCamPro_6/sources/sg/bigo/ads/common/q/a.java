package sg.bigo.ads.common.q;

import android.graphics.Rect;
import android.view.View;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.common.utils.s;

public final class a {
    public static boolean a(View view, Rect rect) {
        if (view == null || !s.b(view)) {
            r.a();
            return false;
        } else if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            return false;
        } else {
            return view.getGlobalVisibleRect(rect);
        }
    }
}
