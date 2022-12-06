package sg.bigo.ads.ad.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.ad.c;
import sg.bigo.ads.api.AdIconView;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.NativeAdView;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.m;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.common.b.a;
import sg.bigo.ads.common.h.e;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.controller.f.d;
import sg.bigo.ads.core.adview.f;
import sg.bigo.ads.core.c.c;

public class b extends c<NativeAd> implements NativeAd, f {
    protected final n l;
    protected sg.bigo.ads.core.c.b m;
    protected ViewGroup n;
    protected MediaView o;
    private e p = null;

    public b(g gVar) {
        super(gVar);
        this.l = (n) gVar.a;
    }

    private void a(Point point, int i, int i2) {
        c.b B = this.l.B();
        sg.bigo.ads.api.core.e a = d.a(a.a, B.b(), B.a(), B.f(), this.l.a(2), B.c(), (sg.bigo.ads.ad.b<?>) this);
        k();
        a(point, i2, i, a);
        sg.bigo.ads.core.c.b bVar = this.m;
        if (bVar != null) {
            bVar.a(com.iab.omid.library.bigosg.b.a.a.CLICK);
        }
    }

    private static void a(ViewGroup viewGroup, View view) {
        Object tag = view.getTag();
        if (tag == null) {
            throw new IllegalStateException("Have you added a valid tag in AdComponentView?");
        } else if (viewGroup.findViewWithTag(tag) == null) {
            throw new IllegalStateException("The target AdComponentView must be contained in NativeAdView.");
        }
    }

    private void a(ViewGroup viewGroup, MediaView mediaView, View view, AdOptionsView adOptionsView, List<View> list, int i, View... viewArr) {
        this.n = viewGroup;
        int i2 = 1;
        if (view != null) {
            view.setTag(1);
            a(viewGroup, view);
            n.a Q = this.l.Q();
            if (Q != null) {
                if (view instanceof ImageView) {
                    new sg.bigo.ads.common.h.a((ImageView) view).a(Q.a());
                } else if (view instanceof AdIconView) {
                    ((AdIconView) view).setIconUrl(Q.a());
                }
            }
            a.a(viewGroup, view, i, this);
            i2 = 5;
        }
        if (adOptionsView != null) {
            adOptionsView.setTag(4);
            a(viewGroup, (View) adOptionsView);
            adOptionsView.a(this.l);
            a.a(viewGroup, adOptionsView, i, this);
            i2 |= 8;
        }
        if (mediaView != null) {
            mediaView.setTag(5);
            a(viewGroup, (View) mediaView);
            a(mediaView);
            i2 |= 2;
            this.o = mediaView;
        }
        for (View next : a.a(list)) {
            if (next != null) {
                a.a(viewGroup, next, i, this);
            }
        }
        this.m = c.a.a.a(r(), s(), this.n, viewArr);
        a("render_style", (Object) Integer.valueOf(i2));
        o();
        this.c = viewGroup;
        p();
    }

    private boolean a(ViewGroup viewGroup) {
        int i;
        String str;
        if (viewGroup == null) {
            i = 2001;
            str = "NativeAdView cannot be null.";
        } else if (!isExpired() && !this.g) {
            return true;
        } else {
            i = 2000;
            str = "The ad is expired.";
        }
        b(i, str);
        return false;
    }

    public final void a(int i, int i2, int i3, int i4) {
        a(new Point(i, i2), i3, i4);
    }

    public void a(ViewGroup viewGroup, MediaView mediaView, ImageView imageView, AdOptionsView adOptionsView, List<View> list, int i, View... viewArr) {
        a(viewGroup, mediaView, (View) imageView, adOptionsView, list, i, viewArr);
    }

    public final void a(b.a<NativeAd> aVar) {
        super.a(aVar);
        a(aVar, this.b.b.d());
    }

    public void a(b.a<NativeAd> aVar, int i) {
        final String ae = this.l.ae();
        if (o.b(ae)) {
            aVar.a(this, 1006, "Missing media image.");
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i == 0) {
            final b.a<NativeAd> aVar2 = aVar;
            final String str = ae;
            sg.bigo.ads.common.h.c.a(ae, new e() {
                public final void a(Bitmap bitmap, sg.bigo.ads.common.h.d dVar) {
                    b.this.l.a(dVar.b);
                    m mVar = new m();
                    mVar.a = bitmap.getWidth();
                    mVar.b = bitmap.getHeight();
                    mVar.d = dVar.c;
                    b.this.l.a(mVar);
                    b bVar = b.this;
                    boolean z = true;
                    if (dVar.a == 1) {
                        z = false;
                    }
                    bVar.a("is_cache", (Object) Boolean.valueOf(z));
                    aVar2.a(b.this);
                    sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) b.this.l, str, dVar.a, SystemClock.elapsedRealtime() - elapsedRealtime, dVar.c, 0, 1, dVar.b, false);
                }

                public final void a(String str, String str2) {
                    b.this.l.a(str2);
                    aVar2.a(b.this, 1006, "Failed to download media image: ".concat(String.valueOf(str)));
                    sg.bigo.ads.core.d.a.a(b.this.l, str, str, SystemClock.elapsedRealtime() - elapsedRealtime, 0, 1, str2, false);
                }
            });
            return;
        }
        if (i == 1) {
            sg.bigo.ads.common.h.c.a(ae, new e() {
                public final void a(Bitmap bitmap, sg.bigo.ads.common.h.d dVar) {
                    b.this.l.a(dVar.b);
                    m mVar = new m();
                    mVar.a = bitmap.getWidth();
                    mVar.b = bitmap.getHeight();
                    mVar.d = dVar.c;
                    b.this.l.a(mVar);
                    sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) b.this.l, ae, dVar.a, SystemClock.elapsedRealtime() - elapsedRealtime, dVar.c, 0, 1, dVar.b, false);
                }

                public final void a(String str, String str2) {
                    b.this.l.a(str2);
                    sg.bigo.ads.core.d.a.a(b.this.l, ae, str, SystemClock.elapsedRealtime() - elapsedRealtime, 0, 1, str2, false);
                }
            });
        }
        aVar.a(this);
    }

    /* access modifiers changed from: protected */
    public void a(MediaView mediaView) {
        if (this.b.b.d() == 2) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            this.p = new e() {
                public final void a(Bitmap bitmap, sg.bigo.ads.common.h.d dVar) {
                    sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) b.this.l, b.this.l.ae(), dVar.a, SystemClock.elapsedRealtime() - elapsedRealtime, dVar.c, 0, 1, dVar.b, false);
                }

                public final void a(String str, String str2) {
                    sg.bigo.ads.core.d.a.a(b.this.l, b.this.l.ae(), str, SystemClock.elapsedRealtime() - elapsedRealtime, 0, 1, str2, false);
                }
            };
        }
        mediaView.a(this.l, this.p);
    }

    public void d() {
        super.d();
        sg.bigo.ads.core.c.b bVar = this.m;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void destroy() {
        super.destroy();
        sg.bigo.ads.core.c.b bVar = this.m;
        if (bVar != null) {
            bVar.b();
        }
        this.c = null;
        this.n = null;
        MediaView mediaView = this.o;
        if (mediaView != null) {
            mediaView.b();
            this.o = null;
        }
        this.i = -1;
        this.p = null;
    }

    public String getCallToAction() {
        return this.l.j();
    }

    public NativeAd.CreativeType getCreativeType() {
        return NativeAd.CreativeType.IMAGE;
    }

    public String getDescription() {
        return this.l.i();
    }

    public String getTitle() {
        return this.l.h();
    }

    public VideoController getVideoController() {
        return null;
    }

    public String getWarning() {
        c.d q = this.l.q();
        return q != null ? q.c() : "";
    }

    public boolean hasIcon() {
        n.a Q = this.l.Q();
        return Q != null && !o.b(Q.a());
    }

    public final /* bridge */ /* synthetic */ sg.bigo.ads.api.core.c n() {
        return this.l;
    }

    public final n q() {
        return this.l;
    }

    /* access modifiers changed from: protected */
    public List<sg.bigo.ads.core.c.a> r() {
        List<c.C0120c> v = this.l.v();
        ArrayList arrayList = new ArrayList();
        if (v != null) {
            for (c.C0120c next : v) {
                if (next != null) {
                    sg.bigo.ads.core.c.a aVar = new sg.bigo.ads.core.c.a();
                    aVar.b = next.b();
                    aVar.a = next.a();
                    aVar.c = next.c();
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    public void registerViewForInteraction(ViewGroup viewGroup, MediaView mediaView, ImageView imageView, AdOptionsView adOptionsView, List<View> list) {
        if (a(viewGroup)) {
            a(viewGroup, mediaView, (View) imageView, adOptionsView, list, 1, null);
        }
    }

    public void registerViewForInteraction(NativeAdView nativeAdView, MediaView mediaView, AdIconView adIconView, AdOptionsView adOptionsView, List<View> list) {
        if (a((ViewGroup) nativeAdView)) {
            a((ViewGroup) nativeAdView, mediaView, (View) adIconView, adOptionsView, list, 1, null);
        }
    }

    /* access modifiers changed from: protected */
    public boolean s() {
        return false;
    }
}
