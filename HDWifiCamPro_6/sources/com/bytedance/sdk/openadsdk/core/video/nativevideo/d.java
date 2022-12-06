package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.a.e.a;
import com.bykv.vk.openvk.component.video.api.d.b;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.z;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* compiled from: NativeVideoDetailLayout */
public class d extends e {
    private TextView H;
    private ImageView I;
    private View J;
    private TextView K;
    private TextView L;
    private TextView M;
    private ImageView N;
    private View O;
    private ImageView P;
    private TextView Q;
    private View R;
    private SeekBar S;
    private TextView T;
    private TextView U;
    private ImageView V;
    private final x W = new x(this);
    /* access modifiers changed from: private */
    public boolean X = false;
    private boolean Y = false;
    private int Z = 0;
    private int aa = 0;
    private int ab = 0;
    private int ac = 0;
    private int ad = 0;
    private final Rect ae = new Rect();
    private ColorStateList af;
    private float ag;
    private final Rect ah = new Rect();
    private int ai = 0;
    private boolean aj;
    private int ak = 0;
    private int al = 0;
    private com.bytedance.sdk.openadsdk.core.widget.d am = null;
    /* access modifiers changed from: private */
    public boolean an = false;
    private final View.OnTouchListener ao = new View.OnTouchListener() {
        private float b;

        public boolean onTouch(View view, MotionEvent motionEvent) {
            float x = motionEvent.getX();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                boolean z = true;
                if (actionMasked == 1) {
                    d dVar = d.this;
                    if (Math.abs(this.b - motionEvent.getX()) >= 10.0f) {
                        z = false;
                    }
                    boolean unused = dVar.an = z;
                } else if (actionMasked == 2) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (actionMasked == 3) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            } else {
                this.b = x;
            }
            return false;
        }
    };
    private float ap;
    private ColorStateList aq;
    private float ar;
    private final Rect as = new Rect();
    private float at;
    private ColorStateList au;
    private float av;
    private final Rect aw = new Rect();
    private final Rect ax = new Rect();
    private boolean ay;
    private boolean az;

    public d(Context context, View view, boolean z, EnumSet<b.a> enumSet, n nVar, c cVar, boolean z2) {
        super(context, view, z, enumSet, nVar, cVar, z2);
        this.y = m.a().getApplicationContext();
        d(z2);
        this.a = view;
        this.t = z;
        this.am = new com.bytedance.sdk.openadsdk.core.widget.d(this);
        this.am.a(this.t);
        DisplayMetrics displayMetrics = this.y.getResources().getDisplayMetrics();
        this.ak = displayMetrics.widthPixels;
        this.al = displayMetrics.heightPixels;
        this.w = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
        this.D = cVar;
        this.x = nVar;
        c(8);
        a(context, this.a);
        d();
        p();
    }

    /* access modifiers changed from: protected */
    public void a(Context context, View view) {
        super.a(context, view);
        this.H = (TextView) view.findViewById(t.e(context, "tt_video_back"));
        this.I = (ImageView) view.findViewById(t.e(context, "tt_video_close"));
        this.J = view.findViewById(t.e(context, "tt_video_top_layout"));
        this.N = (ImageView) view.findViewById(t.e(context, "tt_video_fullscreen_back"));
        this.K = (TextView) view.findViewById(t.e(context, "tt_video_title"));
        this.L = (TextView) view.findViewById(t.e(context, "tt_video_top_title"));
        this.M = (TextView) view.findViewById(t.e(context, "tt_video_current_time"));
        this.O = view.findViewById(t.e(context, "tt_video_loading_retry"));
        this.P = (ImageView) view.findViewById(t.e(context, "tt_video_retry"));
        this.Q = (TextView) view.findViewById(t.e(context, "tt_video_retry_des"));
        this.Q.setText(t.a(context, "tt_video_retry_des_txt"));
        this.S = (SeekBar) view.findViewById(t.e(context, "tt_video_seekbar"));
        this.T = (TextView) view.findViewById(t.e(context, "tt_video_time_left_time"));
        this.U = (TextView) view.findViewById(t.e(context, "tt_video_time_play"));
        this.R = view.findViewById(t.e(context, "tt_video_ad_bottom_layout"));
        this.V = (ImageView) view.findViewById(t.e(context, "tt_video_ad_full_screen"));
        this.g = (ViewStub) view.findViewById(t.e(context, "tt_video_ad_cover"));
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.am.a(this.a);
        int i = 8;
        z.a((View) this.I, (this.t || this.w.contains(b.a.hideCloseBtn)) ? 8 : 0);
        this.I.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.t()) {
                    d.this.A.c(d.this, view);
                }
            }
        });
        TextView textView = this.H;
        if (!this.t || this.w.contains(b.a.alwayShowBackBtn)) {
            i = 0;
        }
        z.a((View) textView, i);
        this.H.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.t()) {
                    d.this.A.d(d.this, view);
                }
            }
        });
        this.N.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.t()) {
                    d.this.A.e(d.this, view);
                }
            }
        });
        this.P.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                d.this.b(false, true);
                d.this.h();
                d.this.g();
                if (d.this.t()) {
                    d.this.A.f(d.this, view);
                }
            }
        });
        this.V.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.t()) {
                    d.this.A.b((b) d.this, view);
                }
            }
        });
        this.S.setThumbOffset(0);
        this.S.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!d.this.X && d.this.y != null) {
                    seekBar.setThumb(t.c(m.a(), "tt_seek_thumb_normal"));
                }
                if (d.this.t()) {
                    seekBar.setThumbOffset(0);
                    d.this.A.a((b) d.this, seekBar.getProgress());
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!d.this.X && d.this.y != null) {
                    seekBar.setThumb(t.c(m.a(), "tt_seek_thumb_press"));
                }
                if (d.this.t()) {
                    seekBar.setThumbOffset(0);
                    d.this.A.b((b) d.this, seekBar.getProgress());
                }
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (d.this.t()) {
                    d.this.A.a(d.this, i, z);
                }
            }
        });
        this.S.setOnTouchListener(this.ao);
    }

    public void e() {
        this.W.removeMessages(1);
        this.W.sendMessageDelayed(this.W.obtainMessage(1), 2000);
    }

    public void f() {
        this.W.removeMessages(1);
    }

    public void b(boolean z) {
        int i = j() ? this.al : this.p;
        int i2 = j() ? this.ak : this.q;
        if (this.s > 0 && this.r > 0 && i > 0) {
            if (!k() && !j() && !this.w.contains(b.a.fixedSize)) {
                i2 = this.y.getResources().getDimensionPixelSize(t.i(this.y, "tt_video_container_maxheight"));
            }
            int i3 = (int) (((float) this.s) * ((((float) i) * 1.0f) / ((float) this.r)));
            if (i3 > i2) {
                i = (int) (((float) this.r) * ((((float) i2) * 1.0f) / ((float) this.s)));
            } else {
                i2 = i3;
            }
            if (!z && !j()) {
                i = this.p;
                i2 = this.q;
            }
            this.b.a(i, i2);
        }
    }

    public void a(String str) {
        TextView textView = this.K;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.L;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    public void a(int i) {
        View view = this.R;
        if (view == null || view.getVisibility() != 0) {
            this.S.setProgress(i);
        }
    }

    public void a(long j, long j2) {
        this.T.setText(a.a(j2));
        this.U.setText(a.a(j));
        this.S.setProgress(a.a(j, j2));
    }

    public void g() {
        z.f(this.d);
        z.f(this.e);
        z.e(this.O);
        if (!(this.f == null || this.x == null || this.x.J() == null || this.x.J().h() == null)) {
            z.f((View) this.f);
            com.bytedance.sdk.openadsdk.i.d.a().a(this.x.J().h(), this.f);
        }
        if (this.c.getVisibility() == 0) {
            z.a((View) this.c, 8);
        }
    }

    public void a() {
        a(false, this.t);
        w();
    }

    public void a(long j) {
        this.U.setText(a.a(j));
    }

    public void a(n nVar, WeakReference<Context> weakReference, boolean z) {
        String str;
        String str2;
        if (nVar != null) {
            a(this.a, m.a());
            a(false, this.t);
            z.a(this.h, 0);
            z.a((View) this.i, 0);
            z.a(this.j, 0);
            if (!(this.i == null || this.x == null || this.x.J() == null || this.x.J().h() == null)) {
                com.bytedance.sdk.openadsdk.i.d.a().a(this.x.J().h(), this.i);
            }
            if (!TextUtils.isEmpty(nVar.K())) {
                str = nVar.K();
            } else if (!TextUtils.isEmpty(nVar.U())) {
                str = nVar.U();
            } else {
                str = !TextUtils.isEmpty(nVar.V()) ? nVar.V() : "";
            }
            if (this.x != null && this.x.M() != null && this.x.M().a() != null) {
                z.a((View) this.k, 0);
                z.a((View) this.l, 4);
                if (this.k != null) {
                    com.bytedance.sdk.openadsdk.i.d.a().a(this.x.M(), (ImageView) this.k);
                    this.k.setOnClickListener(this.E);
                    this.k.setOnTouchListener(this.E);
                }
            } else if (!TextUtils.isEmpty(str)) {
                z.a((View) this.k, 4);
                z.a((View) this.l, 0);
                if (this.l != null) {
                    this.l.setText(str.substring(0, 1));
                    this.l.setOnClickListener(this.E);
                    this.l.setOnTouchListener(this.E);
                }
            }
            if (this.m != null && !TextUtils.isEmpty(str)) {
                this.m.setText(str);
            }
            z.a((View) this.m, 0);
            z.a((View) this.n, 0);
            int L2 = nVar.L();
            if (L2 == 2 || L2 == 3) {
                str2 = t.a(this.y, "tt_video_mobile_go_detail");
            } else if (L2 != 4) {
                str2 = L2 != 5 ? t.a(this.y, "tt_video_mobile_go_detail") : t.a(this.y, "tt_video_dial_phone");
            } else {
                str2 = t.a(this.y, "tt_video_download_apk");
            }
            if (this.n != null) {
                this.n.setText(str2);
                this.n.setOnClickListener(this.E);
                this.n.setOnTouchListener(this.E);
            }
        }
    }

    public void h() {
        z.e(this.d);
        z.e(this.O);
    }

    public void i() {
        this.S.setProgress(0);
        this.S.setSecondaryProgress(0);
        this.T.setText(t.b(this.y, "tt_00_00"));
        this.U.setText(t.b(this.y, "tt_00_00"));
        c(8);
        if (x()) {
            this.b.setVisibility(8);
        }
        if (this.f != null) {
            this.f.setImageDrawable((Drawable) null);
        }
        c(8);
        z.a(this.R, 8);
        z.a(this.h, 8);
        z.a((View) this.i, 8);
        z.a(this.j, 8);
        z.a((View) this.k, 8);
        z.a((View) this.l, 8);
        z.a((View) this.m, 8);
        if (this.z != null) {
            this.z.a(true);
        }
    }

    public boolean j() {
        return this.X;
    }

    public boolean k() {
        return this.t;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null && (this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.X = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            this.aa = marginLayoutParams.leftMargin;
            this.Z = marginLayoutParams.topMargin;
            this.ab = marginLayoutParams.width;
            this.ac = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.a.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.ad = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.ae.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                z.b(viewGroup, 0, 0, 0, 0);
            }
            b(true);
            this.V.setImageDrawable(t.c(this.y, "tt_shrink_video"));
            this.S.setThumb(t.c(this.y, "tt_seek_thumb_fullscreen_selector"));
            this.S.setThumbOffset(0);
            a.a(this.a, false);
            e(this.X);
            z.a(this.J, 8);
            if (!this.t) {
                z.a((View) this.I, 8);
                z.a((View) this.H, 8);
            } else if (this.w.contains(b.a.hideCloseBtn)) {
                z.a((View) this.I, 8);
            }
        }
    }

    public void b(ViewGroup viewGroup) {
        l.e("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup != null && this.a != null && (this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.X = false;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            marginLayoutParams.width = this.ab;
            marginLayoutParams.height = this.ac;
            marginLayoutParams.leftMargin = this.aa;
            marginLayoutParams.topMargin = this.Z;
            this.a.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(3, this.ad);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                z.b(viewGroup, this.ae.left, this.ae.top, this.ae.right, this.ae.bottom);
            }
            b(true);
            this.V.setImageDrawable(t.c(this.y, "tt_enlarge_video"));
            this.S.setThumb(t.c(this.y, "tt_seek_thumb_normal"));
            this.S.setThumbOffset(0);
            a.a(this.a, true);
            e(this.X);
            z.a(this.J, 8);
            if (this.w.contains(b.a.alwayShowBackBtn)) {
                z.a((View) this.H, 0);
            }
        }
    }

    private void e(boolean z) {
        if (z) {
            y();
        } else {
            z();
        }
    }

    private void y() {
        DisplayMetrics displayMetrics = this.y.getResources().getDisplayMetrics();
        TextView textView = this.U;
        if (textView != null) {
            this.ap = textView.getTextSize();
            this.U.setTextSize(2, 14.0f);
            this.aq = this.U.getTextColors();
            if (this.aq != null) {
                this.U.setTextColor(t.j(this.y, "tt_ssxinzi15"));
            }
            this.ar = this.U.getAlpha();
            this.U.setAlpha(0.85f);
            this.U.setShadowLayer(0.0f, z.b(this.y, 0.5f), z.b(this.y, 0.5f), t.j(this.y, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.U.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.as.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                z.b(this.U, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.as.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.as.bottom);
            }
        }
        TextView textView2 = this.T;
        if (textView2 != null) {
            this.at = textView2.getTextSize();
            this.T.setTextSize(2, 14.0f);
            this.au = this.T.getTextColors();
            if (this.au != null) {
                this.T.setTextColor(t.j(this.y, "tt_ssxinzi15"));
            }
            this.av = this.T.getAlpha();
            this.T.setAlpha(0.85f);
            this.T.setShadowLayer(0.0f, z.b(this.y, 0.5f), z.b(this.y, 0.5f), t.j(this.y, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.T.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.aw.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                z.b(this.T, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.aw.top, this.aw.right, this.aw.bottom);
            }
        }
        ImageView imageView = this.V;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.ax.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                z.b(this.V, this.ax.left, this.ax.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.ax.bottom);
            }
        }
        ImageView imageView2 = this.V;
        if (imageView2 != null) {
            imageView2.setImageDrawable(t.c(this.y, "tt_shrink_fullscreen"));
        }
        TextView textView3 = this.L;
        if (textView3 != null) {
            this.af = textView3.getTextColors();
            if (this.af != null) {
                this.L.setTextColor(t.j(this.y, "tt_ssxinzi15"));
            }
            this.ag = this.L.getAlpha();
            this.L.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.L.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.ah.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                z.b(this.L, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.aw.top, this.aw.right, this.aw.bottom);
            }
        }
        View view = this.J;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.ai = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.J.setLayoutParams(layoutParams5);
            this.J.setBackgroundResource(t.d(this.y, "tt_shadow_fullscreen_top"));
        }
        b(this.aj, true);
    }

    private void z() {
        TextView textView = this.U;
        if (textView != null) {
            textView.setTextSize(0, this.ap);
            ColorStateList colorStateList = this.aq;
            if (colorStateList != null) {
                this.U.setTextColor(colorStateList);
            }
            this.U.setAlpha(this.ar);
            this.U.setShadowLayer(z.b(this.y, 1.0f), 0.0f, 0.0f, t.j(this.y, "tt_video_shadow_color"));
            z.b(this.U, this.as.left, this.as.top, this.as.right, this.as.bottom);
        }
        TextView textView2 = this.T;
        if (textView2 != null) {
            textView2.setTextSize(0, this.at);
            ColorStateList colorStateList2 = this.au;
            if (colorStateList2 != null) {
                this.T.setTextColor(colorStateList2);
            }
            this.T.setAlpha(this.av);
            this.T.setShadowLayer(z.b(this.y, 1.0f), 0.0f, 0.0f, t.j(this.y, "tt_video_shadow_color"));
            z.b(this.T, this.aw.left, this.aw.top, this.aw.right, this.aw.bottom);
        }
        ImageView imageView = this.V;
        if (imageView != null) {
            z.b(imageView, this.ax.left, this.ax.top, this.ax.right, this.ax.bottom);
        }
        ImageView imageView2 = this.V;
        if (imageView2 != null) {
            imageView2.setImageDrawable(t.c(this.y, "tt_enlarge_video"));
        }
        TextView textView3 = this.L;
        if (textView3 != null) {
            ColorStateList colorStateList3 = this.af;
            if (colorStateList3 != null) {
                textView3.setTextColor(colorStateList3);
            }
            this.L.setAlpha(this.ag);
            z.b(this.L, this.aw.left, this.aw.top, this.aw.right, this.aw.bottom);
        }
        View view = this.J;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.ai;
            this.J.setLayoutParams(layoutParams);
            this.J.setBackgroundResource(t.d(this.y, "tt_video_black_desc_gradient"));
        }
        b(this.aj, true);
    }

    public void a(Message message) {
        if (message.what == 1) {
            l();
        }
    }

    public void a(boolean z, boolean z2, boolean z3) {
        z.a(this.R, 0);
        int i = 8;
        if (this.X) {
            z.a(this.J, 0);
            z.a((View) this.L, 0);
        } else if (z3) {
            z.a(this.J, 8);
        }
        z.a((View) this.c, (!z || this.d.getVisibility() == 0) ? 8 : 0);
        if (!this.t && !this.X) {
            if (!this.w.contains(b.a.hideCloseBtn) && !z3) {
                z.a((View) this.I, 0);
            }
            TextView textView = this.H;
            if (!z3) {
                i = 0;
            }
            z.a((View) textView, i);
        }
        z.a((View) this.T, 0);
        z.a((View) this.U, 0);
        z.a((View) this.S, 0);
    }

    public void a(boolean z, boolean z2) {
        z.a(this.R, 8);
        z.a(this.J, 8);
        z.a((View) this.c, 8);
        if (!this.t && !this.X) {
            z.a((View) this.I, 8);
            if (!this.w.contains(b.a.alwayShowBackBtn)) {
                z.a((View) this.H, 8);
            }
        } else if (this.w.contains(b.a.hideCloseBtn)) {
            z.a((View) this.I, 8);
        }
        if (z2) {
            z.a((View) this.I, 8);
            z.a((View) this.H, 8);
        }
        c(false);
    }

    public void l() {
        a(true, false);
    }

    public boolean b(int i) {
        SeekBar seekBar = this.S;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    public void c(boolean z) {
        if (this.K != null) {
            int i = 8;
            if (this.t) {
                z.a((View) this.K, 8);
                return;
            }
            TextView textView = this.K;
            if (z) {
                i = 0;
            }
            z.a((View) textView, i);
        }
    }

    public boolean m() {
        return this.u;
    }

    public void c(int i) {
        this.v = i;
        z.a(this.a, i);
        if (i != 0) {
            this.az = false;
        } else if (this.ay) {
            this.az = true;
        }
    }

    public void a(View view, boolean z) {
        if (j()) {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            if (this.x != null && !TextUtils.isEmpty(this.x.U())) {
                a(this.x.U());
            }
            this.M.setText(format);
        } else {
            a("");
            this.M.setText("");
        }
        if (!this.B) {
            boolean z2 = false;
            c(this.t && !this.X);
            if (t()) {
                a aVar = this.A;
                if (this.d.getVisibility() != 0) {
                    z2 = true;
                }
                aVar.a(this, view, true, z2);
            }
        }
    }

    public void n() {
        l();
        c(false);
    }

    public boolean o() {
        return this.z != null && this.z.a();
    }
}
