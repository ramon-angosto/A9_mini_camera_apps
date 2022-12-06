package sg.bigo.ads.core.mraid;

import android.content.Context;
import android.graphics.Rect;
import sg.bigo.ads.common.utils.d;

final class j {
    final Rect a = new Rect();
    final Rect b = new Rect();
    final Rect c = new Rect();
    final Rect d = new Rect();
    final Rect e = new Rect();
    final Rect f = new Rect();
    final Rect g = new Rect();
    final Rect h = new Rect();
    private final Context i;
    private final float j;

    j(Context context, float f2) {
        this.i = context.getApplicationContext();
        this.j = f2;
    }

    /* access modifiers changed from: package-private */
    public final void a(Rect rect, Rect rect2) {
        rect2.set(d.a(this.i, rect.left), d.a(this.i, rect.top), d.a(this.i, rect.right), d.a(this.i, rect.bottom));
    }
}
