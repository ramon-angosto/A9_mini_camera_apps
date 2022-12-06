package sg.bigo.ads.ad.interstitial.a.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import sg.bigo.ads.ad.banner.b;
import sg.bigo.ads.ad.banner.f;
import sg.bigo.ads.ad.interstitial.a.b.b;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.core.l;
import sg.bigo.ads.common.utils.d;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.core.c.c;
import sg.bigo.ads.core.f.a.a;
import sg.bigo.ads.core.f.a.p;
import sg.bigo.ads.core.mraid.e;
import sg.bigo.ads.core.mraid.n;
import sg.bigo.ads.core.player.c;

public final class b implements b.C0114b, sg.bigo.ads.ad.interstitial.a.b.b {
    final a.C0139a a;
    final c b;
    final p c;
    final Ad d;
    final sg.bigo.ads.api.core.c e;
    boolean f = false;
    boolean g = false;
    boolean h = false;
    long i;
    sg.bigo.ads.core.c.b j;
    public f k;
    public e l;
    WebView m;
    public View n;
    boolean o;
    boolean p;
    boolean q = false;
    final C0116b r = new C0116b((byte) 0);
    final b.a s;
    private final boolean t;
    private final String u;

    final class a {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        @JavascriptInterface
        public final void gameEnd(String str) {
            if (b.this.s != null) {
                b.this.s.b();
            }
        }

        @JavascriptInterface
        public final void onBGNDomContentLoaded() {
            b bVar = b.this;
            bVar.p = true;
            if (bVar.s != null) {
                b.this.s.c(b.this.e, SystemClock.elapsedRealtime() - b.this.i);
            }
        }

        @JavascriptInterface
        public final void onBGNLoaded() {
            b bVar = b.this;
            bVar.o = true;
            if (bVar.s != null) {
                b.this.s.b(b.this.e, SystemClock.elapsedRealtime() - b.this.i);
            }
        }
    }

    /* renamed from: sg.bigo.ads.ad.interstitial.a.a.b$b  reason: collision with other inner class name */
    static final class C0116b {
        private boolean a;
        private int b;
        private WeakReference<Activity> c;

        private C0116b() {
            this.a = false;
            this.b = -1;
        }

        /* synthetic */ C0116b(byte b2) {
            this();
        }

        private void b() {
            if (this.a) {
                int i = this.b;
                this.b = -1;
                if (i == 0 || i == 1) {
                    WeakReference<Activity> weakReference = this.c;
                    Activity activity = weakReference == null ? null : (Activity) weakReference.get();
                    if (activity != null) {
                        activity.setRequestedOrientation(i);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.a = true;
            b();
        }

        public final void a(Activity activity, int i) {
            this.b = i;
            this.c = new WeakReference<>(activity);
            b();
        }
    }

    public b(Ad ad, sg.bigo.ads.api.core.c cVar, c cVar2, p pVar, a.C0139a aVar, b.a aVar2) {
        this.a = aVar;
        this.u = aVar == null ? null : aVar.b;
        this.b = cVar2;
        this.c = pVar;
        this.d = ad;
        this.e = cVar;
        this.s = aVar2;
        this.t = !TextUtils.isEmpty(this.u);
    }

    public final View a() {
        return this.n;
    }

    public final void a(int i2) {
        if (i2 == 1) {
            this.r.a();
            c cVar = this.b;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public final boolean a(Context context) {
        int i2;
        int i3;
        if (!this.t) {
            return false;
        }
        if (this.l == null) {
            try {
                this.l = new e(context, n.INTERSTITIAL);
            } catch (NoClassDefFoundError unused) {
                sg.bigo.ads.common.k.a.a(0, "HtmlVastCompanion", "Banner webview is not support");
            }
            e eVar = this.l;
            if (eVar == null) {
                return false;
            }
            eVar.g = new e.b() {
                public final void a() {
                    b bVar = b.this;
                    bVar.g = true;
                    bVar.h = false;
                    bVar.j = c.a.a.a(b.this.m, new View[0]);
                    if (b.this.f) {
                        b bVar2 = b.this;
                        if (bVar2.m != null) {
                            sg.bigo.ads.common.k.a.a(0, 3, "HtmlVastCompanion", "javascript:onViewImpression()");
                            bVar2.m.loadUrl("javascript:onViewImpression()");
                        }
                        if (b.this.j != null) {
                            b.this.j.a();
                        }
                    }
                    sg.bigo.ads.ad.banner.b.b(b.this);
                    if (b.this.s != null) {
                        b.this.s.a();
                    }
                }

                public final void a(String str, Point point) {
                    b bVar = b.this;
                    sg.bigo.ads.common.k.a.a(0, 3, "HtmlVastCompanion", "handle ad click.");
                    if (bVar.s == null || !bVar.s.c()) {
                        str = null;
                    }
                    sg.bigo.ads.api.core.e a2 = a.a(bVar.d, bVar.e, str, bVar.c, bVar.b, bVar.a);
                    if (bVar.k != null) {
                        bVar.k.a(point, a2);
                    }
                }

                public final boolean a(Activity activity, int i) {
                    b.this.r.a(activity, i);
                    return true;
                }

                public final void b() {
                    b bVar = b.this;
                    bVar.h = false;
                    bVar.q = true;
                    sg.bigo.ads.ad.banner.b.c(bVar);
                    if (b.this.s != null) {
                        b.this.s.a(b.this.e, SystemClock.elapsedRealtime() - b.this.i);
                    }
                }

                public final boolean b(Activity activity, int i) {
                    b.this.r.a(activity, i);
                    return true;
                }

                public final void c() {
                    sg.bigo.ads.common.k.a.a(0, "HtmlVastCompanion", "onRenderProcessGone");
                }

                public final void d() {
                    sg.bigo.ads.common.k.a.a(0, 3, "HtmlVastCompanion", "onExpand");
                }

                public final void e() {
                    sg.bigo.ads.common.k.a.a(0, 3, "HtmlVastCompanion", "onResize");
                }

                public final void f() {
                    if (b.this.k != null) {
                        b.this.k.a();
                    }
                }

                public final void g() {
                    if (b.this.k != null) {
                        b.this.k.a();
                    }
                }
            };
            String str = (c.a.a.d(this.u) + "\n<script>document.addEventListener('DOMContentLoaded',function(){BGN_PLAYABLE.onBGNDomContentLoaded()});\nwindow.addEventListener('load',function(){BGN_PLAYABLE.onBGNLoaded()});</script>") + "\n<script type=\"text/javascript\">\n    document.body.style.margin = '0px';\n</script>";
            this.i = SystemClock.elapsedRealtime();
            b.a aVar = this.s;
            if (aVar != null) {
                aVar.a(this.e);
            }
            this.l.a(str, (e.d) new e.d() {
                public final void a() {
                    sg.bigo.ads.common.k.a.a(0, 3, "HtmlVastCompanion", "onReady");
                }
            });
            this.h = true;
            r.a();
        }
        this.m = this.l.b();
        WebView webView = this.m;
        if (webView != null) {
            webView.setOverScrollMode(2);
            this.m.setHorizontalScrollBarEnabled(false);
            this.m.setHorizontalScrollbarOverlay(false);
            this.m.setVerticalScrollBarEnabled(false);
            this.m.setVerticalScrollbarOverlay(false);
            this.m.getSettings().setSupportZoom(false);
            this.m.setBackgroundColor(-1);
            a.C0139a aVar2 = this.a;
            if (aVar2 != null) {
                i2 = aVar2.c;
                i3 = this.a.d;
            } else {
                i2 = 0;
                i3 = 0;
            }
            WebView webView2 = this.m;
            if (webView2 != null) {
                ViewParent parent = webView2.getParent();
                if (parent instanceof FrameLayout) {
                    this.n = (View) parent;
                    sg.bigo.ads.ad.banner.b.a(this);
                    Context context2 = webView2.getContext();
                    int i4 = context2.getResources().getDisplayMetrics().widthPixels;
                    int c2 = d.c(context2);
                    if (d.a(context2, i2) > i4 || d.a(context2, i3) > c2) {
                        i2 = 0;
                    }
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) webView2.getLayoutParams();
                    if (i2 <= 0 || i3 <= 0) {
                        layoutParams.width = -1;
                        layoutParams.height = -1;
                    } else {
                        layoutParams.gravity = 17;
                        layoutParams.width = d.a(context2, i2);
                        layoutParams.height = d.a(context2, i3);
                    }
                }
            }
            this.m.addJavascriptInterface(new a(this, (byte) 0), "BGN_PLAYABLE");
        }
        return true;
    }

    public final boolean b() {
        if (!this.t) {
            return false;
        }
        return this.g;
    }

    public final void c() {
        sg.bigo.ads.common.k.a.a(0, 3, "HtmlVastCompanion", "release");
        sg.bigo.ads.ad.banner.b.h(this);
        sg.bigo.ads.core.c.b bVar = this.j;
        if (bVar != null) {
            bVar.b();
        }
        e eVar = this.l;
        if (eVar != null) {
            eVar.d();
            this.l = null;
        }
        WebView webView = this.m;
        if (webView != null) {
            s.a(webView);
            this.m = null;
        }
        Ad ad = this.d;
        if (ad instanceof l) {
            ((l) ad).l();
        }
    }

    public final void d() {
        b.a aVar;
        if (!this.o && !this.p && !this.q && (aVar = this.s) != null) {
            aVar.d(this.e, SystemClock.elapsedRealtime() - this.i);
        }
    }
}
