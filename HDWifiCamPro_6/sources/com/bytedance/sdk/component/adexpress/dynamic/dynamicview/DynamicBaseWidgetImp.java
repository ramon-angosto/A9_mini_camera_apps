package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.a.a.a;
import com.bytedance.sdk.component.adexpress.b.l;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.d.j;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.d.u;
import com.shix.shixipc.utils.RomUtil;

public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    /* access modifiers changed from: private */
    public InteractViewContainer a;
    private Runnable b;

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, h hVar) {
        super(context, dynamicRootView, hVar);
        setTag(Integer.valueOf(getClickArea()));
        String b2 = hVar.i().b();
        if ("logo-union".equals(b2)) {
            dynamicRootView.setLogoUnionHeight(this.h - ((int) b.a(context, (float) (this.l.b() + this.l.a()))));
        } else if ("scoreCountWithIcon".equals(b2)) {
            dynamicRootView.setScoreCountWithIcon(this.h - ((int) b.a(context, (float) (this.l.b() + this.l.a()))));
        }
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.g, this.h);
    }

    public boolean i() {
        Drawable backgroundDrawable;
        final View view = this.o == null ? this : this.o;
        setContentDescription(this.m.a(this.l.x()));
        String u = this.l.u();
        if (this.l.t() && Build.VERSION.SDK_INT >= 17) {
            final int s = this.l.s();
            a.a().e().a(this.l.b).a(u.BITMAP).a((com.bytedance.sdk.component.d.h) new com.bytedance.sdk.component.d.h() {
                public Bitmap a(Bitmap bitmap) {
                    return com.bytedance.sdk.component.adexpress.c.a.a(DynamicBaseWidgetImp.this.k, bitmap, s);
                }
            }).a((o) new o<Bitmap>() {
                public void a(int i, String str, Throwable th) {
                }

                public void a(k<Bitmap> kVar) {
                    Bitmap b2 = kVar.b();
                    if (b2 != null && kVar.c() != null) {
                        view.setBackground(DynamicBaseWidgetImp.this.a(b2));
                    }
                }
            });
        } else if (!TextUtils.isEmpty(u)) {
            if (!u.startsWith("http:")) {
                u = com.bytedance.sdk.component.adexpress.dynamic.c.h.b(u);
            }
            j a2 = a.a().e().a(u).a(u.BITMAP);
            a(a2);
            a2.a((o) new o<Bitmap>() {
                public void a(int i, String str, Throwable th) {
                }

                public void a(k<Bitmap> kVar) {
                    if (!"open_ad".equals(DynamicBaseWidgetImp.this.n.getRenderRequest().b())) {
                        view.setBackground(new BitmapDrawable(kVar.b()));
                        return;
                    }
                    view.setBackground(new a(kVar.b(), ((DynamicRoot) DynamicBaseWidgetImp.this.n.getChildAt(0)).a));
                }
            });
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.l.z() > 0) {
            postDelayed(new Runnable() {
                public void run() {
                    try {
                        view.setBackground(DynamicBaseWidgetImp.this.a(true, DynamicBaseWidgetImp.this.n.getBgColor()));
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.l.z() * 1000));
        }
        if (this.o != null) {
            this.o.setPadding((int) b.a(this.k, (float) this.l.c()), (int) b.a(this.k, (float) this.l.b()), (int) b.a(this.k, (float) this.l.d()), (int) b.a(this.k, (float) this.l.a()));
        }
        if (this.p || this.l.n() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    private static void a(j jVar) {
        if (RomUtil.ROM_SMARTISAN.equals(Build.BRAND) && "SM901".equals(Build.MODEL)) {
            jVar.a(Bitmap.Config.ARGB_8888);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        final View view = this.o == null ? this : this.o;
        double n = this.m.i().e().n();
        if (n < 90.0d && n > 0.0d) {
            com.bytedance.sdk.component.utils.h.b().postDelayed(new Runnable() {
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (n * 1000.0d));
        }
        double m = this.m.i().e().m();
        if (m > 0.0d) {
            com.bytedance.sdk.component.utils.h.b().postDelayed(new Runnable() {
                public void run() {
                    if (DynamicBaseWidgetImp.this.m.i().e().af() == null) {
                        view.setVisibility(0);
                        DynamicBaseWidgetImp.this.setVisibility(0);
                    }
                }
            }, (long) (m * 1000.0d));
        }
        if (!TextUtils.isEmpty(this.l.F())) {
            a();
        }
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.b);
    }

    private void a() {
        int J = this.l.J();
        int K = this.l.K();
        this.b = new Runnable() {
            public void run() {
                if (DynamicBaseWidgetImp.this.n == null || DynamicBaseWidgetImp.this.n.getRenderRequest() == null) {
                    DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                    Context context = dynamicBaseWidgetImp.k;
                    DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                    InteractViewContainer unused = dynamicBaseWidgetImp.a = new InteractViewContainer(context, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.l);
                } else {
                    l renderRequest = DynamicBaseWidgetImp.this.n.getRenderRequest();
                    int l = renderRequest.l();
                    int m = renderRequest.m();
                    int n = renderRequest.n();
                    int o = renderRequest.o();
                    DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                    Context context2 = dynamicBaseWidgetImp3.k;
                    DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                    InteractViewContainer unused2 = dynamicBaseWidgetImp3.a = new InteractViewContainer(context2, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.l, l, m, n, o);
                }
                DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                dynamicBaseWidgetImp5.a((View) dynamicBaseWidgetImp5.a);
                DynamicBaseWidgetImp.this.a.setTag(2);
                DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                dynamicBaseWidgetImp6.addView(dynamicBaseWidgetImp6.a, new FrameLayout.LayoutParams(-1, -1));
                DynamicBaseWidgetImp.this.a.b();
            }
        };
        postDelayed(this.b, ((long) J) * 1000);
        if (K < Integer.MAX_VALUE && J < K) {
            postDelayed(new Runnable() {
                public void run() {
                    if (DynamicBaseWidgetImp.this.a != null) {
                        DynamicBaseWidgetImp.this.a.setVisibility(8);
                    }
                }
            }, ((long) K) * 1000);
        }
    }
}
