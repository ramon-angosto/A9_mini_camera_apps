package sg.bigo.ads.ad.banner;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.ad.banner.b;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.core.d;
import sg.bigo.ads.api.core.i;
import sg.bigo.ads.api.core.l;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.core.h.b;
import sg.bigo.ads.core.mraid.e;
import sg.bigo.ads.core.mraid.n;

public final class c<T extends Ad> implements b.C0114b {
    WebView a;
    public int b = 1;
    a c;
    boolean d = false;
    boolean e = false;
    boolean f = false;
    Runnable g;
    sg.bigo.ads.core.c.b h;
    f i;
    final Context j;
    final T k;
    final i l;
    final boolean m;
    final AtomicBoolean n;
    AdOptionsView o;
    View p;
    boolean q;
    private e r;
    private View s;
    private final n t;
    private boolean u = false;
    private final View.OnAttachStateChangeListener v = new View.OnAttachStateChangeListener() {
        public final void onViewAttachedToWindow(View view) {
            b.e(c.this);
        }

        public final void onViewDetachedFromWindow(View view) {
            b.f(c.this);
            view.removeOnAttachStateChangeListener(this);
        }
    };

    static class a implements b.C0113b {
        Handler a = new Handler();
        private boolean b = false;
        private b.C0113b c;

        a(b.C0113b bVar) {
            this.c = bVar;
        }

        private boolean c() {
            if (this.b) {
                return true;
            }
            this.a.removeCallbacks((Runnable) null);
            this.b = true;
            return false;
        }

        public final void a() {
            b.C0113b bVar;
            if (!c() && (bVar = this.c) != null) {
                bVar.a();
            }
        }

        public final void a(d dVar) {
            b.C0113b bVar;
            if (!c() && (bVar = this.c) != null) {
                bVar.a(dVar);
            }
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            a(new d(3001, 10102, "Adx media load error because of destroying before loaded"));
        }
    }

    public c(Context context, T t2, i iVar, n nVar, f fVar, boolean z) {
        this.j = context;
        this.k = t2;
        this.l = iVar;
        this.t = nVar;
        this.i = fVar;
        this.m = z;
        this.n = new AtomicBoolean(false);
    }

    static TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setText("Реклама");
        textView.setBackgroundResource(R.drawable.bigo_ad_bg_ad_tag_white_border);
        textView.setTextColor(o.b("#B2FFFFFF", -1));
        textView.setTextSize(9.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(sg.bigo.ads.common.utils.d.a(context, 3), sg.bigo.ads.common.utils.d.a(context, 1), sg.bigo.ads.common.utils.d.a(context, 3), sg.bigo.ads.common.utils.d.a(context, 1));
        return textView;
    }

    static TextView a(Context context, String str) {
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextColor(-1);
        textView.setTextSize(9.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxWidth(sg.bigo.ads.common.utils.d.a(context, 120));
        textView.setBackgroundColor(o.b("#4D000000", -7829368));
        textView.setPadding(sg.bigo.ads.common.utils.d.a(context, 4), sg.bigo.ads.common.utils.d.a(context, 1), sg.bigo.ads.common.utils.d.a(context, 4), sg.bigo.ads.common.utils.d.a(context, 1));
        return textView;
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(final sg.bigo.ads.ad.b.C0113b r13) {
        /*
            r12 = this;
            sg.bigo.ads.api.core.i r0 = r12.l
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            sg.bigo.ads.api.core.i$b r0 = r0.R()
            if (r0 == 0) goto L_0x0238
            sg.bigo.ads.api.core.i r0 = r12.l
            sg.bigo.ads.api.core.i$b r0 = r0.R()
            java.lang.String r0 = r0.c()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001e
            goto L_0x0238
        L_0x001e:
            sg.bigo.ads.core.mraid.e r0 = r12.r
            r2 = 2
            java.lang.String r3 = "BannerAd"
            r4 = 1
            if (r0 != 0) goto L_0x0125
            r0 = 3
            java.lang.String r5 = "new controller"
            sg.bigo.ads.common.k.a.a(r1, r0, r3, r5)
            sg.bigo.ads.core.mraid.e r5 = new sg.bigo.ads.core.mraid.e     // Catch:{ NoClassDefFoundError -> 0x0038 }
            android.content.Context r6 = sg.bigo.ads.common.b.a.a     // Catch:{ NoClassDefFoundError -> 0x0038 }
            sg.bigo.ads.core.mraid.n r7 = r12.t     // Catch:{ NoClassDefFoundError -> 0x0038 }
            r5.<init>(r6, r7)     // Catch:{ NoClassDefFoundError -> 0x0038 }
            r12.r = r5     // Catch:{ NoClassDefFoundError -> 0x0038 }
            goto L_0x003d
        L_0x0038:
            java.lang.String r5 = "Server Banner is not support"
            sg.bigo.ads.common.k.a.a(r1, r3, r5)
        L_0x003d:
            sg.bigo.ads.core.mraid.e r5 = r12.r
            if (r5 != 0) goto L_0x0042
            return r1
        L_0x0042:
            sg.bigo.ads.api.AdOptionsView r5 = r12.o
            if (r5 != 0) goto L_0x004f
            sg.bigo.ads.api.AdOptionsView r5 = new sg.bigo.ads.api.AdOptionsView
            android.content.Context r6 = r12.j
            r5.<init>(r6)
            r12.o = r5
        L_0x004f:
            sg.bigo.ads.core.mraid.e r5 = r12.r
            sg.bigo.ads.ad.banner.c$3 r6 = new sg.bigo.ads.ad.banner.c$3
            r6.<init>(r13)
            r5.g = r6
            sg.bigo.ads.core.mraid.e r13 = r12.r
            sg.bigo.ads.api.core.i r5 = r12.l
            sg.bigo.ads.api.a.g r5 = r5.b()
            boolean r5 = r5.t()
            r5 = r5 ^ r4
            sg.bigo.ads.core.mraid.c r13 = r13.j
            r13.d = r5
            sg.bigo.ads.api.core.i r13 = r12.l
            sg.bigo.ads.api.core.i$b r13 = r13.R()
            java.lang.String r13 = r13.c()
            sg.bigo.ads.ad.banner.c$4 r5 = new sg.bigo.ads.ad.banner.c$4
            r5.<init>()
            boolean r6 = android.webkit.URLUtil.isNetworkUrl(r13)
            if (r6 == 0) goto L_0x008a
            sg.bigo.ads.core.mraid.e r0 = r12.r
            r0.a((sg.bigo.ads.core.mraid.e.d) r5)
            sg.bigo.ads.core.mraid.c r0 = r0.j
            r0.b((java.lang.String) r13)
            goto L_0x0120
        L_0x008a:
            sg.bigo.ads.core.c.c r6 = sg.bigo.ads.core.c.c.a.a
            java.lang.String r13 = r6.d(r13)
            sg.bigo.ads.core.h.a r6 = sg.bigo.ads.core.h.a.k()
            sg.bigo.ads.api.a.d r7 = sg.bigo.ads.api.a.e.a
            sg.bigo.ads.api.a.f r7 = r7.h()
            boolean r7 = r7.a(r1)
            if (r7 != 0) goto L_0x00a4
            goto L_0x011b
        L_0x00a4:
            java.lang.String r6 = r6.a
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r8 = "\n<script type=\"text/javascript\">\n    var object = { \"act\": \"notify\", \"type\": \"render_start\" };\n    window.bigossp.webCollect(JSON.stringify(object));\n    var imgs = document.images;\n    for (i = 0; i < imgs.length; i++) {\n        var img = imgs[i];\n        if (!checkImgForBigo(img)) {\n            img.addEventListener(\"load\", function () {\n                checkImgForBigo(img)\n            })\n        }\n    }\n    function checkImgForBigo(img) {\n        if (img.naturalWidth * img.naturalHeight >= 900 && img.offsetWidth * img.offsetHeight >= 900) {\n            var object = { \"act\": \"notify\", \"type\": \"render\", \"target\": \"IMG\", \"url\": img.src, \"w\": img.width, \"h\": img.height };\n            // console.log(\"notify render result: \" + JSON.stringify(object));\n            window.bigossp.webCollect(JSON.stringify(object));\n            return true;\n        }\n        return false;\n    }\n</script>"
            java.lang.String r9 = "insertFromHead\n<script>\n    window.addEventListener('load', function (d) {\n        let backgroundDivs = Array.from(document.querySelectorAll('div'));\n        var backgroundImags = [];\n        backgroundDivs.forEach(div => {\n            let imgUrl = window.getComputedStyle(div).backgroundImage.match(/url\\([\"']?(.*)[\"']?\\)/)\n            if (!imgUrl) imgUrl = window.getComputedStyle(div, ':before').backgroundImage.match(/url\\([\"']?(.*)[\"']?\\)/);\n            if (!imgUrl) imgUrl = window.getComputedStyle(div, ':after').backgroundImage.match(/url\\([\"']?(.*)[\"']?\\)/);\n            if (imgUrl) {\n                var object = { \"act\": \"stash\", \"type\": \"mayError\", \"target\": \"background-image\", \"url\": imgUrl[1]};\n                backgroundImags.push(object);\n            }\n        });\n        // console.log('webCollect: ' + JSON.stringify(backgroundImags));\n        window.bigossp.webCollect(JSON.stringify(backgroundImags));\n    });\n</script>"
            java.lang.String r10 = "insertFromHead\n<script>(function () {\n        //add listener error\n        window.addEventListener('error', function (e) {\n            if (e) {\n                var target = e.target || e.srcElement;\n                var isElementTarget = target instanceof HTMLElement;\n                if (isElementTarget) {\n                    var url = target.href || target.src;\n                    var width = parseInt(window.getComputedStyle(target).width);\n                    var height = parseInt(window.getComputedStyle(target).height);\n                    var errorInfo = { \"url\": url, \"w\": width, \"h\": height };\n                    //object格式 { \"act\": \"error\", \"type\": e.type, \"target\": e.target.nodeName, \"url\": \"http://testhehe.com/test\", \"w\": 20, \"h\": 20}\n                    var object = { \"act\": \"error\", \"type\": e.type, \"target\": e.target.nodeName, \"url\": url };\n                    if (width) object[\"w\"] = width;\n                    if (height) object[\"h\"] = height;\n                    window.bigossp.webCollect(JSON.stringify(object));\n                }\n            }\n        }, true);\n    }());\n</script>\n"
            if (r7 == 0) goto L_0x00b7
            java.lang.String[] r0 = new java.lang.String[]{r10, r9, r8}
            goto L_0x00d6
        L_0x00b7:
            java.lang.String r7 = "keepOldJs"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L_0x00d2
            r7 = 4
            java.lang.String[] r7 = new java.lang.String[r7]
            r7[r1] = r10
            r7[r4] = r9
            r7[r2] = r8
            r8 = 9
            java.lang.String r6 = r6.substring(r8)
            r7[r0] = r6
            r0 = r7
            goto L_0x00d6
        L_0x00d2:
            java.lang.String[] r0 = new java.lang.String[r4]
            r0[r1] = r6
        L_0x00d6:
            int r6 = r0.length
            if (r6 != 0) goto L_0x00da
            goto L_0x011b
        L_0x00da:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r13)
            int r13 = r0.length
            r7 = r1
        L_0x00e1:
            if (r7 >= r13) goto L_0x0117
            r8 = r0[r7]
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x0114
            java.lang.String r9 = "insertFromHead"
            boolean r9 = r8.startsWith(r9)
            java.lang.String r10 = "\n"
            if (r9 == 0) goto L_0x010e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r11 = 14
            java.lang.String r8 = r8.substring(r11)
            r9.append(r8)
            r9.append(r10)
            java.lang.String r8 = r9.toString()
            r6.insert(r1, r8)
            goto L_0x0114
        L_0x010e:
            r6.append(r10)
            r6.append(r8)
        L_0x0114:
            int r7 = r7 + 1
            goto L_0x00e1
        L_0x0117:
            java.lang.String r13 = r6.toString()
        L_0x011b:
            sg.bigo.ads.core.mraid.e r0 = r12.r
            r0.a((java.lang.String) r13, (sg.bigo.ads.core.mraid.e.d) r5)
        L_0x0120:
            r12.f = r4
            sg.bigo.ads.common.utils.r.a()
        L_0x0125:
            sg.bigo.ads.core.mraid.e r13 = r12.r
            sg.bigo.ads.core.mraid.c$c r13 = r13.b()
            r12.a = r13
            android.webkit.WebView r13 = r12.a
            if (r13 == 0) goto L_0x0237
            r13.setOverScrollMode(r2)
            android.webkit.WebView r13 = r12.a
            r13.setHorizontalScrollBarEnabled(r1)
            android.webkit.WebView r13 = r12.a
            r13.setHorizontalScrollbarOverlay(r1)
            android.webkit.WebView r13 = r12.a
            r13.setVerticalScrollBarEnabled(r1)
            android.webkit.WebView r13 = r12.a
            r13.setVerticalScrollbarOverlay(r1)
            android.webkit.WebView r13 = r12.a
            android.webkit.WebSettings r13 = r13.getSettings()
            r13.setSupportZoom(r1)
            android.webkit.WebView r13 = r12.a
            android.view.ViewParent r13 = r13.getParent()
            boolean r0 = r13 instanceof android.view.ViewGroup
            if (r0 == 0) goto L_0x0236
            r0 = r13
            android.view.View r0 = (android.view.View) r0
            android.content.Context r2 = r12.j
            if (r2 != 0) goto L_0x0164
            android.content.Context r2 = sg.bigo.ads.common.b.a.a
        L_0x0164:
            android.view.View r5 = r12.s
            boolean r6 = r5 instanceof android.widget.FrameLayout
            r7 = 0
            if (r6 == 0) goto L_0x0178
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            int r5 = r5.getChildCount()
            if (r5 != 0) goto L_0x0178
            android.view.View r3 = r12.s
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            goto L_0x0182
        L_0x0178:
            android.view.View r5 = r12.s
            if (r5 == 0) goto L_0x0181
            java.lang.String r5 = "bind banner view in abnormal situation."
            sg.bigo.ads.common.k.a.a(r1, r3, r5)
        L_0x0181:
            r3 = r7
        L_0x0182:
            sg.bigo.ads.api.core.i r5 = r12.l
            if (r5 != 0) goto L_0x0187
            goto L_0x018b
        L_0x0187:
            java.lang.String r7 = r5.f()
        L_0x018b:
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 != 0) goto L_0x01b0
            if (r3 != 0) goto L_0x0198
            android.widget.FrameLayout r3 = new android.widget.FrameLayout
            r3.<init>(r2)
        L_0x0198:
            android.widget.TextView r5 = a((android.content.Context) r2)
            android.widget.TextView r6 = a(r2, r7)
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r2)
            r7.setOrientation(r1)
            r7.addView(r6)
            r7.addView(r5)
            r12.p = r7
        L_0x01b0:
            if (r3 == 0) goto L_0x01b5
            r3.addView(r0)
        L_0x01b5:
            android.view.View r1 = r12.p
            if (r1 == 0) goto L_0x01d2
            sg.bigo.ads.core.mraid.n r1 = r12.t
            sg.bigo.ads.core.mraid.n r2 = sg.bigo.ads.core.mraid.n.INTERSTITIAL
            if (r1 == r2) goto L_0x01d2
            android.view.View r1 = r12.p
            if (r3 == 0) goto L_0x01e8
            if (r1 != 0) goto L_0x01c6
            goto L_0x01e8
        L_0x01c6:
            android.webkit.WebView r1 = r12.a
            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
            sg.bigo.ads.ad.banner.c$5 r2 = new sg.bigo.ads.ad.banner.c$5
            r2.<init>(r3)
            goto L_0x01e5
        L_0x01d2:
            sg.bigo.ads.core.mraid.n r1 = r12.t
            sg.bigo.ads.core.mraid.n r2 = sg.bigo.ads.core.mraid.n.INTERSTITIAL
            if (r1 != r2) goto L_0x01e8
            if (r3 == 0) goto L_0x01e8
            android.webkit.WebView r1 = r12.a
            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
            sg.bigo.ads.ad.banner.c$6 r2 = new sg.bigo.ads.ad.banner.c$6
            r2.<init>(r3)
        L_0x01e5:
            r1.addOnGlobalLayoutListener(r2)
        L_0x01e8:
            if (r3 != 0) goto L_0x01eb
            goto L_0x01ec
        L_0x01eb:
            r0 = r3
        L_0x01ec:
            r12.s = r0
            sg.bigo.ads.ad.banner.b.a(r12)
            sg.bigo.ads.api.core.i r0 = r12.l
            sg.bigo.ads.api.core.i$b r0 = r0.R()
            boolean r13 = r13 instanceof android.widget.FrameLayout
            if (r13 == 0) goto L_0x0236
            int r13 = r0.a()
            int r0 = r0.b()
            android.content.Context r1 = r12.j
            android.webkit.WebView r2 = r12.a
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            if (r13 <= 0) goto L_0x022b
            if (r0 <= 0) goto L_0x022b
            int r13 = sg.bigo.ads.common.utils.d.a(r1, r13)
            r2.width = r13
            int r13 = sg.bigo.ads.common.utils.d.a(r1, r0)
            r2.height = r13
            r13 = 17
            r2.gravity = r13
            android.view.View r13 = r12.s
            int r0 = sg.bigo.ads.common.utils.d.a(r1, r0)
            r13.setMinimumHeight(r0)
            goto L_0x0236
        L_0x022b:
            sg.bigo.ads.core.mraid.n r13 = r12.t
            sg.bigo.ads.core.mraid.n r0 = sg.bigo.ads.core.mraid.n.INTERSTITIAL
            if (r13 != r0) goto L_0x0236
            r13 = -1
            r2.width = r13
            r2.height = r13
        L_0x0236:
            return r4
        L_0x0237:
            return r1
        L_0x0238:
            sg.bigo.ads.api.core.i r13 = r12.l
            r0 = 3001(0xbb9, float:4.205E-42)
            r2 = 10104(0x2778, float:1.4159E-41)
            java.lang.String r3 = "Banner with no data"
            sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) r13, (int) r0, (int) r2, (java.lang.String) r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.banner.c.c(sg.bigo.ads.ad.b$b):boolean");
    }

    public final void a() {
        b.h(this);
        sg.bigo.ads.core.c.b bVar = this.h;
        if (bVar != null) {
            bVar.b();
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
        if (this.g != null) {
            this.g = null;
        }
        e eVar = this.r;
        if (eVar != null) {
            eVar.d();
            this.r = null;
        }
        View view = this.s;
        if (view != null) {
            view.removeOnAttachStateChangeListener(this.v);
            this.s = null;
        }
        WebView webView = this.a;
        if (webView != null) {
            s.a(webView);
            this.a = null;
        }
        T t2 = this.k;
        if (t2 instanceof l) {
            ((l) t2).l();
        }
    }

    public final void a(final b.C0113b bVar) {
        sg.bigo.ads.common.f.c.a(2, new Runnable() {
            public final void run() {
                if (c.this.b == 0) {
                    if (c.this.c != null) {
                        c.this.c.b();
                    }
                    c.this.c = new a(bVar);
                    a aVar = c.this.c;
                    aVar.a.postDelayed(new Runnable() {
                        public final void run() {
                            a.this.a();
                        }
                    }, 15000);
                    c cVar = c.this;
                    if (!cVar.b(cVar.c)) {
                        c.this.c.a(new d(3001, 10102, "Adx media load error when preload"));
                    }
                } else if (!c.this.b(bVar)) {
                    bVar.a(new d(3001, 10102, "Adx media load error when preload"));
                }
            }
        });
    }

    public final View b() {
        if (this.s == null) {
            sg.bigo.ads.common.k.a.a(2, "BannerAd", "The banner ad is not ready, an empty view will be retrieved.");
            this.s = new FrameLayout(this.j);
        }
        b.d(this);
        this.s.addOnAttachStateChangeListener(this.v);
        return this.s;
    }

    public final boolean b(b.C0113b bVar) {
        if (this.q) {
            return true;
        }
        this.q = c(bVar);
        return this.q;
    }

    public final void c() {
        sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "performImpression");
        b.g(this);
        T t2 = this.k;
        if (t2 instanceof d) {
            ((d) t2).a(b.i(this));
        }
        if (!this.d) {
            this.d = true;
            if (this.e) {
                e();
                d();
                sg.bigo.ads.core.c.b bVar = this.h;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        if (this.a != null) {
            sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "javascript:onViewImpression()");
            this.a.loadUrl("javascript:onViewImpression()");
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        final WebView webView = this.a;
        if (!this.u && (webView instanceof sg.bigo.ads.core.h.b)) {
            this.u = true;
            sg.bigo.ads.common.f.c.a(1, new Runnable() {
                public final void run() {
                    b.C0140b bVar;
                    long j;
                    long j2;
                    long j3;
                    long j4;
                    long j5;
                    sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "Notify webView performance stat.");
                    sg.bigo.ads.core.h.b bVar2 = (sg.bigo.ads.core.h.b) webView;
                    if (sg.bigo.ads.api.a.e.a.h().a(0) || sg.bigo.ads.api.a.e.a.h().a(1)) {
                        b.C0140b bVar3 = bVar2.c;
                        sg.bigo.ads.core.h.b.a(bVar3);
                        if (sg.bigo.ads.api.a.e.a.h().a(1)) {
                            if (bVar2.d == null) {
                                bVar2.d = new b.c(bVar2, (byte) 0);
                            }
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            bVar3.d = bVar2.d.a();
                            bVar3.g = SystemClock.elapsedRealtime() - elapsedRealtime;
                            bVar3.f = SystemClock.elapsedRealtime();
                        }
                        bVar = bVar3;
                    } else {
                        bVar = null;
                    }
                    if (bVar == null) {
                        return;
                    }
                    if (bVar.c != null || bVar.d != null) {
                        Boolean bool = bVar.c;
                        Boolean bool2 = bVar.d;
                        if (bool != null) {
                            j = bool.booleanValue() ? 1 : 0;
                            j2 = b.a((b.C0114b) c.this, bVar.e);
                        } else {
                            j2 = -1;
                            j = -1;
                        }
                        if (bool2 != null) {
                            j3 = bool2.booleanValue() ? 1 : 0;
                            j5 = bVar.g;
                            j4 = b.a((b.C0114b) c.this, bVar.f);
                        } else {
                            j5 = -1;
                            j4 = -1;
                            j3 = -1;
                        }
                        sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "Stat check blank resutl.");
                        Map<String, String> b2 = sg.bigo.ads.core.d.a.b((sg.bigo.ads.api.core.c) c.this.l);
                        b2.put("by_js", String.valueOf(j));
                        b2.put("by_js_cost", String.valueOf(j2));
                        b2.put("by_bit", String.valueOf(j3));
                        b2.put("by_bit_cost", String.valueOf(j4));
                        b2.put("by_bit_run_cost", String.valueOf(j5));
                        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                        if (i > 0 && j2 >= 0 && j3 > 0 && j4 >= 0) {
                            j4 = Math.min(j2, j4);
                        } else if (i > 0 && j2 >= 0) {
                            j4 = j2;
                        } else if (j3 <= 0 || j4 < 0) {
                            j4 = -1;
                        }
                        b2.put("cost", String.valueOf(j4));
                        sg.bigo.ads.core.d.a.a("06002040", b2);
                    }
                }
            });
        }
    }
}
