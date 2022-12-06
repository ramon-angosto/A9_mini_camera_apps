package com.adcolony.sdk;

import android.content.Context;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.MotionEventCompat;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

class u extends EditText {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private String k;
    private String l;
    private String m;
    private String n;
    private c o;
    private h0 p;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            if (u.this.c(h0Var)) {
                u.this.a(h0Var);
            }
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            if (u.this.c(h0Var)) {
                u.this.k(h0Var);
            }
        }
    }

    class c implements j0 {
        c() {
        }

        public void a(h0 h0Var) {
            if (u.this.c(h0Var)) {
                u.this.e(h0Var);
            }
        }
    }

    class d implements j0 {
        d() {
        }

        public void a(h0 h0Var) {
            if (u.this.c(h0Var)) {
                u.this.f(h0Var);
            }
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            if (u.this.c(h0Var)) {
                u.this.d(h0Var);
            }
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            if (u.this.c(h0Var)) {
                u.this.j(h0Var);
            }
        }
    }

    class g implements j0 {
        g() {
        }

        public void a(h0 h0Var) {
            if (u.this.c(h0Var)) {
                u.this.g(h0Var);
            }
        }
    }

    class h implements j0 {
        h() {
        }

        public void a(h0 h0Var) {
            if (u.this.c(h0Var)) {
                u.this.h(h0Var);
            }
        }
    }

    class i implements j0 {
        i() {
        }

        public void a(h0 h0Var) {
            if (u.this.c(h0Var)) {
                u.this.b(h0Var);
            }
        }
    }

    class j implements j0 {
        j() {
        }

        public void a(h0 h0Var) {
            if (u.this.c(h0Var)) {
                u.this.i(h0Var);
            }
        }
    }

    u(Context context, h0 h0Var, int i2, c cVar) {
        super(context);
        this.a = i2;
        this.p = h0Var;
        this.o = cVar;
    }

    /* access modifiers changed from: package-private */
    public int a(boolean z, int i2) {
        if (i2 == 0) {
            return z ? 1 : 16;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                return 17;
            }
            if (z) {
                return GravityCompat.END;
            }
            return 80;
        } else if (z) {
            return GravityCompat.START;
        } else {
            return 48;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.i = c0.d(a2, "x");
        this.j = c0.d(a2, "y");
        setGravity(a(true, this.i) | a(false, this.j));
    }

    /* access modifiers changed from: package-private */
    public void b(h0 h0Var) {
        f1 b2 = c0.b();
        c0.a(b2, MimeTypes.BASE_TYPE_TEXT, getText().toString());
        h0Var.a(b2).c();
    }

    /* access modifiers changed from: package-private */
    public boolean c(h0 h0Var) {
        f1 a2 = h0Var.a();
        return c0.d(a2, "id") == this.a && c0.d(a2, "container_id") == this.o.c() && c0.h(a2, "ad_session_id").equals(this.o.a());
    }

    /* access modifiers changed from: package-private */
    public void d(h0 h0Var) {
        String h2 = c0.h(h0Var.a(), "background_color");
        this.l = h2;
        setBackgroundColor(z0.f(h2));
    }

    /* access modifiers changed from: package-private */
    public void e(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.b = c0.d(a2, "x");
        this.c = c0.d(a2, "y");
        this.d = c0.d(a2, "width");
        this.e = c0.d(a2, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.b, this.c, 0, 0);
        layoutParams.width = this.d;
        layoutParams.height = this.e;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void f(h0 h0Var) {
        String h2 = c0.h(h0Var.a(), "font_color");
        this.m = h2;
        setTextColor(z0.f(h2));
    }

    /* access modifiers changed from: package-private */
    public void g(h0 h0Var) {
        int d2 = c0.d(h0Var.a(), "font_size");
        this.h = d2;
        setTextSize((float) d2);
    }

    /* access modifiers changed from: package-private */
    public void h(h0 h0Var) {
        int d2 = c0.d(h0Var.a(), "font_style");
        this.f = d2;
        if (d2 == 0) {
            setTypeface(getTypeface(), 0);
        } else if (d2 == 1) {
            setTypeface(getTypeface(), 1);
        } else if (d2 == 2) {
            setTypeface(getTypeface(), 2);
        } else if (d2 == 3) {
            setTypeface(getTypeface(), 3);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(h0 h0Var) {
        String h2 = c0.h(h0Var.a(), MimeTypes.BASE_TYPE_TEXT);
        this.n = h2;
        setText(h2);
    }

    /* access modifiers changed from: package-private */
    public void j(h0 h0Var) {
        int d2 = c0.d(h0Var.a(), "font_family");
        this.g = d2;
        if (d2 == 0) {
            setTypeface(Typeface.DEFAULT);
        } else if (d2 == 1) {
            setTypeface(Typeface.SERIF);
        } else if (d2 == 2) {
            setTypeface(Typeface.SANS_SERIF);
        } else if (d2 == 3) {
            setTypeface(Typeface.MONOSPACE);
        }
    }

    /* access modifiers changed from: package-private */
    public void k(h0 h0Var) {
        if (c0.b(h0Var.a(), "visible")) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
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
        c0.a(b3, "ad_session_id", this.k);
        c0.b(b3, "container_x", this.b + x);
        c0.b(b3, "container_y", this.c + y);
        c0.b(b3, "view_x", x);
        c0.b(b3, "view_y", y);
        c0.b(b3, "id", this.o.c());
        if (action == 0) {
            new h0("AdContainer.on_touch_began", this.o.k(), b3).c();
        } else if (action == 1) {
            if (!this.o.p()) {
                b2.a(c2.d().get(this.k));
            }
            new h0("AdContainer.on_touch_ended", this.o.k(), b3).c();
        } else if (action == 2) {
            new h0("AdContainer.on_touch_moved", this.o.k(), b3).c();
        } else if (action == 3) {
            new h0("AdContainer.on_touch_cancelled", this.o.k(), b3).c();
        } else if (action == 5) {
            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            c0.b(b3, "container_x", ((int) motionEvent2.getX(action2)) + this.b);
            c0.b(b3, "container_y", ((int) motionEvent2.getY(action2)) + this.c);
            c0.b(b3, "view_x", (int) motionEvent2.getX(action2));
            c0.b(b3, "view_y", (int) motionEvent2.getY(action2));
            new h0("AdContainer.on_touch_began", this.o.k(), b3).c();
        } else if (action == 6) {
            int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            c0.b(b3, "container_x", ((int) motionEvent2.getX(action3)) + this.b);
            c0.b(b3, "container_y", ((int) motionEvent2.getY(action3)) + this.c);
            c0.b(b3, "view_x", (int) motionEvent2.getX(action3));
            c0.b(b3, "view_y", (int) motionEvent2.getY(action3));
            if (!this.o.p()) {
                b2.a(c2.d().get(this.k));
            }
            new h0("AdContainer.on_touch_ended", this.o.k(), b3).c();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        f1 a2 = this.p.a();
        this.k = c0.h(a2, "ad_session_id");
        this.b = c0.d(a2, "x");
        this.c = c0.d(a2, "y");
        this.d = c0.d(a2, "width");
        this.e = c0.d(a2, "height");
        this.g = c0.d(a2, "font_family");
        this.f = c0.d(a2, "font_style");
        this.h = c0.d(a2, "font_size");
        this.l = c0.h(a2, "background_color");
        this.m = c0.h(a2, "font_color");
        this.n = c0.h(a2, MimeTypes.BASE_TYPE_TEXT);
        this.i = c0.d(a2, "align_x");
        this.j = c0.d(a2, "align_y");
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.d, this.e);
        layoutParams.setMargins(this.b, this.c, 0, 0);
        layoutParams.gravity = 0;
        this.o.addView(this, layoutParams);
        int i2 = this.g;
        if (i2 == 0) {
            setTypeface(Typeface.DEFAULT);
        } else if (i2 == 1) {
            setTypeface(Typeface.SERIF);
        } else if (i2 == 2) {
            setTypeface(Typeface.SANS_SERIF);
        } else if (i2 == 3) {
            setTypeface(Typeface.MONOSPACE);
        }
        int i3 = this.f;
        if (i3 == 0) {
            setTypeface(getTypeface(), 0);
        } else if (i3 == 1) {
            setTypeface(getTypeface(), 1);
        } else if (i3 == 2) {
            setTypeface(getTypeface(), 2);
        } else if (i3 == 3) {
            setTypeface(getTypeface(), 3);
        }
        setText(this.n);
        setTextSize((float) this.h);
        setGravity(a(true, this.i) | a(false, this.j));
        if (!this.l.equals("")) {
            setBackgroundColor(z0.f(this.l));
        }
        if (!this.m.equals("")) {
            setTextColor(z0.f(this.m));
        }
        this.o.i().add(a.a("TextView.set_visible", (j0) new b(), true));
        this.o.i().add(a.a("TextView.set_bounds", (j0) new c(), true));
        this.o.i().add(a.a("TextView.set_font_color", (j0) new d(), true));
        this.o.i().add(a.a("TextView.set_background_color", (j0) new e(), true));
        this.o.i().add(a.a("TextView.set_typeface", (j0) new f(), true));
        this.o.i().add(a.a("TextView.set_font_size", (j0) new g(), true));
        this.o.i().add(a.a("TextView.set_font_style", (j0) new h(), true));
        this.o.i().add(a.a("TextView.get_text", (j0) new i(), true));
        this.o.i().add(a.a("TextView.set_text", (j0) new j(), true));
        this.o.i().add(a.a("TextView.align", (j0) new a(), true));
        this.o.j().add("TextView.set_visible");
        this.o.j().add("TextView.set_bounds");
        this.o.j().add("TextView.set_font_color");
        this.o.j().add("TextView.set_background_color");
        this.o.j().add("TextView.set_typeface");
        this.o.j().add("TextView.set_font_size");
        this.o.j().add("TextView.set_font_style");
        this.o.j().add("TextView.get_text");
        this.o.j().add("TextView.set_text");
        this.o.j().add("TextView.align");
    }
}
