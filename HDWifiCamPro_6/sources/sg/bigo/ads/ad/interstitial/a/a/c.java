package sg.bigo.ads.ad.interstitial.a.a;

import android.content.Context;
import android.graphics.Point;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.ad.interstitial.a.b.c;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.core.l;
import sg.bigo.ads.common.h.e;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.core.f.a.a;
import sg.bigo.ads.core.f.a.p;

public final class c implements sg.bigo.ads.ad.interstitial.a.b.c {
    final sg.bigo.ads.api.core.c a;
    final c.b b;
    View c;
    WebView d;
    public c.a e;
    boolean f = false;
    long g;
    boolean h;
    boolean i = false;
    private final boolean j;
    private final List<a.C0139a> k;
    private final sg.bigo.ads.core.player.c l;
    private final p m;
    private final Ad n;

    class a extends FrameLayout {
        /* access modifiers changed from: private */
        public Point b;

        public a(Context context) {
            super(context);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 1) {
                this.b = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    class b implements View.OnTouchListener {
        final a.C0139a a;
        final ViewConfiguration b;
        final int c;
        boolean d = false;
        float e;
        float f;

        public b(Context context, a.C0139a aVar) {
            this.a = aVar;
            this.b = ViewConfiguration.get(context);
            this.c = this.b.getScaledTouchSlop();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                this.d = true;
                this.e = motionEvent.getX();
                this.f = motionEvent.getY();
            } else if (motionEvent.getActionMasked() == 1) {
                if (this.d) {
                    this.d = false;
                    if (Math.abs(this.e - motionEvent.getX()) < ((float) this.c) && Math.abs(this.f - motionEvent.getY()) < ((float) this.c)) {
                        c.a(c.this, new Point((int) motionEvent.getX(), (int) motionEvent.getY()), this.a);
                    }
                }
            } else if (motionEvent.getAction() == 3) {
                this.d = false;
            }
            return true;
        }
    }

    public c(Ad ad, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.core.player.c cVar2, p pVar, c.b bVar) {
        this.l = cVar2;
        this.m = pVar;
        this.n = ad;
        this.a = cVar;
        this.b = bVar;
        this.k = new ArrayList();
        if (pVar != null) {
            for (sg.bigo.ads.core.f.a.a aVar : pVar.z) {
                List<a.C0139a> list = aVar.b;
                if (list != null) {
                    for (a.C0139a next : list) {
                        if (next.a() && next.b()) {
                            this.k.add(next);
                        }
                    }
                    for (a.C0139a next2 : list) {
                        if (next2.a() && next2.c()) {
                            this.k.add(next2);
                        }
                    }
                }
            }
        }
        this.j = !this.k.isEmpty();
    }

    /* access modifiers changed from: private */
    public void a(Context context, List<a.C0139a> list, a.C0139a aVar, int i2) {
        final List<a.C0139a> list2 = list;
        final a.C0139a aVar2 = aVar;
        final int i3 = i2;
        final Context context2 = context;
        sg.bigo.ads.common.f.c.b(new Runnable() {
            public final void run() {
                if (c.this.f) {
                    sg.bigo.ads.common.k.a.a(0, 3, "StaticVastCompanion", "static vast companion destroyed, stop preload.");
                } else if (list2.isEmpty()) {
                    sg.bigo.ads.common.k.a.a(0, 3, "StaticVastCompanion", "image list empty, stop preload.");
                    if (c.this.b != null) {
                        c.b bVar = c.this.b;
                        sg.bigo.ads.api.core.c cVar = c.this.a;
                        long elapsedRealtime = SystemClock.elapsedRealtime() - c.this.g;
                        a.C0139a aVar = aVar2;
                        String str = null;
                        String str2 = aVar == null ? null : aVar.b;
                        int i = i3 - 1;
                        a.C0139a aVar2 = aVar2;
                        if (aVar2 != null) {
                            str = aVar2.e;
                        }
                        bVar.a(cVar, elapsedRealtime, str2, i, str, "load failed");
                    }
                } else {
                    final a.C0139a aVar3 = (a.C0139a) list2.remove(0);
                    String str3 = aVar3.b;
                    sg.bigo.ads.common.k.a.a(0, 3, "StaticVastCompanion", "try to preload image: ".concat(String.valueOf(str3)));
                    if (!URLUtil.isNetworkUrl(str3)) {
                        sg.bigo.ads.common.k.a.a(0, 3, "StaticVastCompanion", "image url is invalid: " + str3 + ", try to preload next image.");
                        c.this.a(context2, list2, aVar3, i3 + 1);
                        return;
                    }
                    sg.bigo.ads.common.h.c.a(str3, new e() {
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: android.webkit.WebView} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: android.webkit.WebView} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: android.webkit.WebView} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: sg.bigo.ads.common.view.a} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: android.webkit.WebView} */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void a(android.graphics.Bitmap r17, sg.bigo.ads.common.h.d r18) {
                            /*
                                r16 = this;
                                r1 = r16
                                r0 = 3
                                java.lang.String r2 = "StaticVastCompanion"
                                r3 = 0
                                java.lang.String r4 = "image load success."
                                sg.bigo.ads.common.k.a.a(r3, r0, r2, r4)
                                sg.bigo.ads.ad.interstitial.a.a.c$1 r4 = sg.bigo.ads.ad.interstitial.a.a.c.AnonymousClass1.this
                                sg.bigo.ads.ad.interstitial.a.a.c r4 = sg.bigo.ads.ad.interstitial.a.a.c.this
                                sg.bigo.ads.ad.interstitial.a.a.c$1 r5 = sg.bigo.ads.ad.interstitial.a.a.c.AnonymousClass1.this
                                android.content.Context r5 = r5
                                sg.bigo.ads.core.f.a.a$a r6 = r0
                                sg.bigo.ads.ad.interstitial.a.a.c$1 r7 = sg.bigo.ads.ad.interstitial.a.a.c.AnonymousClass1.this
                                int r13 = r4
                                java.lang.String r7 = "try to handle image."
                                sg.bigo.ads.common.k.a.a(r3, r0, r2, r7)
                                boolean r7 = r6.b()
                                r8 = 0
                                r9 = 1
                                if (r7 == 0) goto L_0x0041
                                java.lang.String r7 = "handle jpg/png image."
                                sg.bigo.ads.common.k.a.a(r3, r0, r2, r7)
                                sg.bigo.ads.common.view.a r0 = new sg.bigo.ads.common.view.a
                                r0.<init>(r5)
                                r7 = r17
                                r0.setImageBitmap(r7)
                                sg.bigo.ads.ad.interstitial.a.a.c$b r2 = new sg.bigo.ads.ad.interstitial.a.a.c$b
                                r2.<init>(r5, r6)
                                r0.setOnTouchListener(r2)
                                r15 = r8
                                r8 = r0
                                goto L_0x00cc
                            L_0x0041:
                                r7 = r17
                                boolean r10 = r6.c()
                                if (r10 == 0) goto L_0x00cb
                                java.lang.String r10 = "handle gif image."
                                sg.bigo.ads.common.k.a.a(r3, r0, r2, r10)
                                r10 = r18
                                java.lang.String r10 = r10.d
                                java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x00c1 }
                                r11.<init>(r10)     // Catch:{ Exception -> 0x00c1 }
                                boolean r10 = r11.exists()     // Catch:{ Exception -> 0x00c1 }
                                if (r10 == 0) goto L_0x00b8
                                java.net.URI r0 = r11.toURI()     // Catch:{ Exception -> 0x00c1 }
                                android.webkit.WebView r2 = new android.webkit.WebView     // Catch:{ Exception -> 0x00c1 }
                                r2.<init>(r5)     // Catch:{ Exception -> 0x00c1 }
                                android.webkit.WebSettings r10 = r2.getSettings()     // Catch:{ Exception -> 0x00c1 }
                                r10.setAllowFileAccess(r9)     // Catch:{ Exception -> 0x00c1 }
                                android.webkit.WebSettings r10 = r2.getSettings()     // Catch:{ Exception -> 0x00c1 }
                                r10.setAllowFileAccessFromFileURLs(r3)     // Catch:{ Exception -> 0x00c1 }
                                android.webkit.WebSettings r10 = r2.getSettings()     // Catch:{ Exception -> 0x00c1 }
                                r10.setAllowUniversalAccessFromFileURLs(r3)     // Catch:{ Exception -> 0x00c1 }
                                java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x00c1 }
                                java.lang.String r11 = "file://"
                                boolean r10 = r10.startsWith(r11)     // Catch:{ Exception -> 0x00c1 }
                                if (r10 == 0) goto L_0x008f
                                android.webkit.WebSettings r10 = r2.getSettings()     // Catch:{ Exception -> 0x00c1 }
                                r10.setJavaScriptEnabled(r3)     // Catch:{ Exception -> 0x00c1 }
                                goto L_0x0096
                            L_0x008f:
                                android.webkit.WebSettings r3 = r2.getSettings()     // Catch:{ Exception -> 0x00c1 }
                                r3.setJavaScriptEnabled(r9)     // Catch:{ Exception -> 0x00c1 }
                            L_0x0096:
                                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00c1 }
                                r2.loadUrl(r0)     // Catch:{ Exception -> 0x00c1 }
                                android.webkit.WebSettings r0 = r2.getSettings()     // Catch:{ Exception -> 0x00c1 }
                                r0.setLoadWithOverviewMode(r9)     // Catch:{ Exception -> 0x00c1 }
                                android.webkit.WebSettings r0 = r2.getSettings()     // Catch:{ Exception -> 0x00c1 }
                                r0.setUseWideViewPort(r9)     // Catch:{ Exception -> 0x00c1 }
                                sg.bigo.ads.ad.interstitial.a.a.c$b r0 = new sg.bigo.ads.ad.interstitial.a.a.c$b     // Catch:{ Exception -> 0x00c1 }
                                r0.<init>(r5, r6)     // Catch:{ Exception -> 0x00c1 }
                                r2.setOnTouchListener(r0)     // Catch:{ Exception -> 0x00c1 }
                                r4.d = r2     // Catch:{ Exception -> 0x00c1 }
                                r15 = r8
                                r8 = r2
                                goto L_0x00cc
                            L_0x00b8:
                                java.lang.String r10 = "git file not exists"
                                java.lang.String r11 = "gif image file is not exists."
                                sg.bigo.ads.common.k.a.a(r3, r0, r2, r11)     // Catch:{ Exception -> 0x00c1 }
                                r15 = r10
                                goto L_0x00cc
                            L_0x00c1:
                                r0 = move-exception
                                java.lang.String r2 = r0.toString()
                                r0.printStackTrace()
                                r15 = r2
                                goto L_0x00cc
                            L_0x00cb:
                                r15 = r8
                            L_0x00cc:
                                if (r8 == 0) goto L_0x014d
                                int r0 = r17.getWidth()
                                int r2 = r17.getHeight()
                                if (r0 <= 0) goto L_0x00da
                                if (r2 > 0) goto L_0x00e6
                            L_0x00da:
                                int r0 = r6.c
                                int r0 = sg.bigo.ads.common.utils.d.a(r5, r0)
                                int r2 = r6.d
                                int r2 = sg.bigo.ads.common.utils.d.a(r5, r2)
                            L_0x00e6:
                                android.content.res.Resources r3 = r5.getResources()
                                android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
                                int r3 = r3.widthPixels
                                float r3 = (float) r3
                                int r7 = sg.bigo.ads.common.utils.d.c(r5)
                                float r7 = (float) r7
                                r10 = 0
                                int r11 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
                                if (r11 <= 0) goto L_0x010f
                                int r10 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
                                if (r10 <= 0) goto L_0x010f
                                float r2 = (float) r2
                                float r10 = r2 * r3
                                float r0 = (float) r0
                                float r10 = r10 / r0
                                int r11 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
                                if (r11 <= 0) goto L_0x010c
                                float r0 = r0 * r7
                                float r3 = r0 / r2
                                goto L_0x010d
                            L_0x010c:
                                r7 = r10
                            L_0x010d:
                                int r0 = (int) r3
                                int r2 = (int) r7
                            L_0x010f:
                                if (r0 <= 0) goto L_0x011b
                                if (r2 <= 0) goto L_0x011b
                                android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
                                r7 = 17
                                r3.<init>(r0, r2, r7)
                                goto L_0x0121
                            L_0x011b:
                                android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
                                r0 = -1
                                r3.<init>(r0, r0)
                            L_0x0121:
                                sg.bigo.ads.ad.interstitial.a.a.c$a r0 = new sg.bigo.ads.ad.interstitial.a.a.c$a
                                r0.<init>(r5)
                                sg.bigo.ads.ad.interstitial.a.a.c$2 r2 = new sg.bigo.ads.ad.interstitial.a.a.c$2
                                r2.<init>(r0, r6)
                                r0.setOnClickListener(r2)
                                r0.addView(r8, r3)
                                r4.c = r0
                                sg.bigo.ads.ad.interstitial.a.b.c$b r0 = r4.b
                                if (r0 == 0) goto L_0x0166
                                r4.h = r9
                                sg.bigo.ads.ad.interstitial.a.b.c$b r8 = r4.b
                                sg.bigo.ads.api.core.c r9 = r4.a
                                long r2 = android.os.SystemClock.elapsedRealtime()
                                long r4 = r4.g
                                long r10 = r2 - r4
                                java.lang.String r12 = r6.b
                                java.lang.String r14 = r6.e
                                r8.a(r9, r10, r12, r13, r14)
                                return
                            L_0x014d:
                                sg.bigo.ads.ad.interstitial.a.b.c$b r0 = r4.b
                                if (r0 == 0) goto L_0x0166
                                r4.i = r9
                                sg.bigo.ads.ad.interstitial.a.b.c$b r8 = r4.b
                                sg.bigo.ads.api.core.c r9 = r4.a
                                long r2 = android.os.SystemClock.elapsedRealtime()
                                long r4 = r4.g
                                long r10 = r2 - r4
                                java.lang.String r12 = r6.b
                                java.lang.String r14 = r6.e
                                r8.a(r9, r10, r12, r13, r14, r15)
                            L_0x0166:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.a.a.c.AnonymousClass1.AnonymousClass1.a(android.graphics.Bitmap, sg.bigo.ads.common.h.d):void");
                        }

                        public final void a(String str, String str2) {
                            sg.bigo.ads.common.k.a.a(0, 3, "StaticVastCompanion", "image load failed: " + str + ", try to preload next image.");
                            c.this.a(context2, list2, aVar3, i3 + 1);
                        }
                    });
                }
            }
        });
    }

    static /* synthetic */ void a(c cVar, Point point, a.C0139a aVar) {
        sg.bigo.ads.common.k.a.a(0, 3, "StaticVastCompanion", "handle ad click.");
        sg.bigo.ads.api.core.e a2 = a.a(cVar.n, cVar.a, (String) null, cVar.m, cVar.l, aVar);
        c.a aVar2 = cVar.e;
        if (aVar2 != null) {
            aVar2.a(point, a2);
        }
    }

    public final View a() {
        return this.c;
    }

    public final void a(int i2) {
        sg.bigo.ads.core.player.c cVar;
        if (i2 == 1 && (cVar = this.l) != null) {
            cVar.b();
        }
    }

    public final boolean a(Context context) {
        String str;
        if (!this.j) {
            str = "image resource is disable.";
        } else if (this.f) {
            str = "static vast companion destroyed, stop preload.";
        } else if (this.k.isEmpty()) {
            str = "image list empty, stop preload.";
        } else {
            this.g = SystemClock.elapsedRealtime();
            c.b bVar = this.b;
            if (bVar != null) {
                bVar.a(this.a);
            }
            a(context, this.k, (a.C0139a) null, 0);
            return true;
        }
        sg.bigo.ads.common.k.a.a(0, 3, "StaticVastCompanion", str);
        return false;
    }

    public final boolean b() {
        return !this.f && this.c != null;
    }

    public final void c() {
        sg.bigo.ads.common.k.a.a(0, 3, "StaticVastCompanion", "release");
        WebView webView = this.d;
        if (webView != null) {
            webView.setOnTouchListener((View.OnTouchListener) null);
            this.d.destroy();
            this.d = null;
        }
        View view = this.c;
        if (view != null) {
            s.a(view);
            this.c = null;
        }
        Ad ad = this.n;
        if (ad instanceof l) {
            ((l) ad).l();
        }
        this.f = true;
    }

    public final void d() {
        c.b bVar;
        if (!this.i && !this.h && (bVar = this.b) != null) {
            bVar.a(this.a, SystemClock.elapsedRealtime() - this.g);
        }
    }
}
