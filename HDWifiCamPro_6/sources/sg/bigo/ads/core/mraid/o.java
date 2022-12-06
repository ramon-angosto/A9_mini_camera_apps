package sg.bigo.ads.core.mraid;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

public final class o extends GestureDetector {
    a a;
    private long b;

    static class a extends GestureDetector.SimpleOnGestureListener {
        boolean a = false;

        a() {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            this.a = true;
            return super.onSingleTapUp(motionEvent);
        }
    }

    public o(Context context) {
        this(context, new a());
    }

    private o(Context context, a aVar) {
        super(context, aVar);
        this.b = -1;
        this.a = aVar;
        setIsLongpressEnabled(false);
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.b <= 3000;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.a.a = false;
            this.b = System.currentTimeMillis();
        }
        return super.onTouchEvent(motionEvent);
    }
}
