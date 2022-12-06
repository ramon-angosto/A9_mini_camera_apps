package com.adcolony.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import java.io.File;

class a0 extends ImageView {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private String i;
    private String j;
    private h0 k;
    private c l;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            if (a0.this.a(h0Var)) {
                a0.this.d(h0Var);
            }
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            if (a0.this.a(h0Var)) {
                a0.this.b(h0Var);
            }
        }
    }

    class c implements j0 {
        c() {
        }

        public void a(h0 h0Var) {
            if (a0.this.a(h0Var)) {
                a0.this.c(h0Var);
            }
        }
    }

    a0(Context context, h0 h0Var, int i2, c cVar) {
        super(context);
        this.a = i2;
        this.k = h0Var;
        this.l = cVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        k b2 = a.b();
        d c2 = b2.c();
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        f1 b3 = c0.b();
        c0.b(b3, "view_id", this.a);
        c0.a(b3, "ad_session_id", this.j);
        c0.b(b3, "container_x", this.b + x);
        c0.b(b3, "container_y", this.c + y);
        c0.b(b3, "view_x", x);
        c0.b(b3, "view_y", y);
        c0.b(b3, "id", this.l.getId());
        if (action != 0) {
            int i2 = y;
            if (action == 1) {
                if (!this.l.p()) {
                    b2.a(c2.d().get(this.j));
                }
                if (x <= 0 || x >= this.d || i2 <= 0 || i2 >= this.e) {
                    new h0("AdContainer.on_touch_cancelled", this.l.k(), b3).c();
                } else {
                    new h0("AdContainer.on_touch_ended", this.l.k(), b3).c();
                }
            } else if (action == 2) {
                new h0("AdContainer.on_touch_moved", this.l.k(), b3).c();
            } else if (action == 3) {
                new h0("AdContainer.on_touch_cancelled", this.l.k(), b3).c();
            } else if (action == 5) {
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                c0.b(b3, "container_x", ((int) motionEvent2.getX(action2)) + this.b);
                c0.b(b3, "container_y", ((int) motionEvent2.getY(action2)) + this.c);
                c0.b(b3, "view_x", (int) motionEvent2.getX(action2));
                c0.b(b3, "view_y", (int) motionEvent2.getY(action2));
                new h0("AdContainer.on_touch_began", this.l.k(), b3).c();
            } else if (action != 6) {
                return true;
            } else {
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                int x2 = (int) motionEvent2.getX(action3);
                int y2 = (int) motionEvent2.getY(action3);
                c0.b(b3, "container_x", ((int) motionEvent2.getX(action3)) + this.b);
                c0.b(b3, "container_y", ((int) motionEvent2.getY(action3)) + this.c);
                c0.b(b3, "view_x", (int) motionEvent2.getX(action3));
                c0.b(b3, "view_y", (int) motionEvent2.getY(action3));
                if (!this.l.p()) {
                    b2.a(c2.d().get(this.j));
                }
                if (x2 <= 0 || x2 >= this.d || y2 <= 0 || y2 >= this.e) {
                    new h0("AdContainer.on_touch_cancelled", this.l.k(), b3).c();
                } else {
                    new h0("AdContainer.on_touch_ended", this.l.k(), b3).c();
                }
            }
        } else {
            new h0("AdContainer.on_touch_began", this.l.k(), b3).c();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean a(h0 h0Var) {
        f1 a2 = h0Var.a();
        return c0.d(a2, "id") == this.a && c0.d(a2, "container_id") == this.l.c() && c0.h(a2, "ad_session_id").equals(this.l.a());
    }

    /* access modifiers changed from: private */
    public void b(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.b = c0.d(a2, "x");
        this.c = c0.d(a2, "y");
        this.d = c0.d(a2, "width");
        this.e = c0.d(a2, "height");
        if (this.f) {
            float s = (((float) this.e) * a.b().n().s()) / ((float) getDrawable().getIntrinsicHeight());
            this.e = (int) (((float) getDrawable().getIntrinsicHeight()) * s);
            int intrinsicWidth = (int) (((float) getDrawable().getIntrinsicWidth()) * s);
            this.d = intrinsicWidth;
            this.b -= intrinsicWidth;
            this.c -= this.e;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.b, this.c, 0, 0);
        layoutParams.width = this.d;
        layoutParams.height = this.e;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void c(h0 h0Var) {
        this.i = c0.h(h0Var.a(), "filepath");
        setImageURI(Uri.fromFile(new File(this.i)));
    }

    /* access modifiers changed from: private */
    public void d(h0 h0Var) {
        if (c0.b(h0Var.a(), "visible")) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        FrameLayout.LayoutParams layoutParams;
        int i2;
        f1 a2 = this.k.a();
        this.j = c0.h(a2, "ad_session_id");
        this.b = c0.d(a2, "x");
        this.c = c0.d(a2, "y");
        this.d = c0.d(a2, "width");
        this.e = c0.d(a2, "height");
        this.i = c0.h(a2, "filepath");
        this.f = c0.b(a2, "dpi");
        this.g = c0.b(a2, "invert_y");
        this.h = c0.b(a2, "wrap_content");
        setImageURI(Uri.fromFile(new File(this.i)));
        if (this.f) {
            float s = (((float) this.e) * a.b().n().s()) / ((float) getDrawable().getIntrinsicHeight());
            this.e = (int) (((float) getDrawable().getIntrinsicHeight()) * s);
            int intrinsicWidth = (int) (((float) getDrawable().getIntrinsicWidth()) * s);
            this.d = intrinsicWidth;
            this.b -= intrinsicWidth;
            if (this.g) {
                i2 = this.c + this.e;
            } else {
                i2 = this.c - this.e;
            }
            this.c = i2;
        }
        setVisibility(4);
        if (this.h) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.d, this.e);
        }
        layoutParams.setMargins(this.b, this.c, 0, 0);
        layoutParams.gravity = 0;
        this.l.addView(this, layoutParams);
        this.l.i().add(a.a("ImageView.set_visible", (j0) new a(), true));
        this.l.i().add(a.a("ImageView.set_bounds", (j0) new b(), true));
        this.l.i().add(a.a("ImageView.set_image", (j0) new c(), true));
        this.l.j().add("ImageView.set_visible");
        this.l.j().add("ImageView.set_bounds");
        this.l.j().add("ImageView.set_image");
    }
}
