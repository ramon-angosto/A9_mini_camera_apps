package sg.bigo.ads.core.mraid.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.d;

public final class a extends FrameLayout {
    public final Drawable a;
    private final int b;
    private b c;
    private C0142a d;
    private final int e;
    private final int f;
    private final int g;
    private boolean h;
    private final Rect i;
    private final Rect j;
    private final Rect k;
    private final Rect l;
    private boolean m;
    private c n;

    /* renamed from: sg.bigo.ads.core.mraid.a.a$a  reason: collision with other inner class name */
    public enum C0142a {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);
        
        final int h;

        private C0142a(int i2) {
            this.h = i2;
        }
    }

    public interface b {
        void a();
    }

    final class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b) {
            this();
        }

        public final void run() {
            a.this.setClosePressed(false);
        }
    }

    public a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b2) {
        super(context, (AttributeSet) null, 0);
        this.i = new Rect();
        this.j = new Rect();
        this.k = new Rect();
        this.l = new Rect();
        this.a = context.getResources().getDrawable(R.drawable.bigo_ad_ic_close);
        this.d = C0142a.TOP_RIGHT;
        this.a.setState(EMPTY_STATE_SET);
        this.a.setCallback(this);
        this.b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.e = d.a(context, 50);
        this.f = d.a(context, 30);
        this.g = d.a(context, 8);
        setWillNotDraw(false);
        this.m = true;
    }

    private static void a(C0142a aVar, int i2, Rect rect, Rect rect2) {
        Gravity.apply(aVar.h, i2, i2, rect, rect2);
    }

    private boolean a() {
        return this.a.getState() == SELECTED_STATE_SET;
    }

    private boolean a(int i2, int i3, int i4) {
        return i2 >= this.j.left - i4 && i3 >= this.j.top - i4 && i2 < this.j.right + i4 && i3 < this.j.bottom + i4;
    }

    /* access modifiers changed from: private */
    public void setClosePressed(boolean z) {
        if (z != a()) {
            this.a.setState(z ? SELECTED_STATE_SET : EMPTY_STATE_SET);
            invalidate(this.j);
        }
    }

    public final void a(C0142a aVar, Rect rect, Rect rect2) {
        a(aVar, this.e, rect, rect2);
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.h) {
            this.h = false;
            this.i.set(0, 0, getWidth(), getHeight());
            a(this.d, this.i, this.j);
            this.l.set(this.j);
            Rect rect = this.l;
            int i2 = this.g;
            rect.inset(i2, i2);
            a(this.d, this.f, this.l, this.k);
            this.a.setBounds(this.k);
        }
        if (this.a.isVisible()) {
            this.a.draw(canvas);
        }
    }

    /* access modifiers changed from: package-private */
    public final Rect getCloseBounds() {
        return this.j;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return a((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.h = true;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (a((int) motionEvent.getX(), (int) motionEvent.getY(), this.b)) {
            if (this.m || this.a.isVisible()) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    setClosePressed(true);
                } else if (action != 1) {
                    if (action == 3) {
                        setClosePressed(false);
                    }
                } else if (a()) {
                    if (this.n == null) {
                        this.n = new c(this, (byte) 0);
                    }
                    postDelayed(this.n, (long) ViewConfiguration.getPressedStateDuration());
                    playSoundEffect(0);
                    b bVar = this.c;
                    if (bVar != null) {
                        bVar.a();
                    }
                }
                return true;
            }
        }
        setClosePressed(false);
        super.onTouchEvent(motionEvent);
        return false;
    }

    public final void setCloseAlwaysInteractable(boolean z) {
        this.m = z;
    }

    /* access modifiers changed from: package-private */
    public final void setCloseBoundChanged(boolean z) {
        this.h = z;
    }

    /* access modifiers changed from: package-private */
    public final void setCloseBounds(Rect rect) {
        this.j.set(rect);
    }

    public final void setClosePosition(C0142a aVar) {
        this.d = aVar;
        this.h = true;
        invalidate();
    }

    public final void setCloseVisible(boolean z) {
        if (this.a.setVisible(z, false)) {
            invalidate(this.j);
        }
    }

    public final void setOnCloseListener(b bVar) {
        this.c = bVar;
    }
}
