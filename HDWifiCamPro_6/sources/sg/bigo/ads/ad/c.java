package sg.bigo.ads.ad;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.core.b;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.common.utils.o;

public abstract class c<T extends Ad> extends b<T> {
    boolean j = false;
    protected c<T>.a k = new a();

    protected final class a {
        boolean a = false;
        boolean b = false;
        final Runnable c = new Runnable() {
            public final void run() {
                if (c.this.g || ((a.this.a && a.this.b) || c.this.c == null)) {
                    a.this.a();
                    return;
                }
                View view = c.this.c;
                Rect rect = new Rect();
                if (sg.bigo.ads.common.q.a.a(view, rect) || (c.this.e && b.b(c.this.i()))) {
                    if (!a.this.a) {
                        a.a(a.this, rect);
                    }
                    if (!a.this.b) {
                        a.b(a.this, rect);
                    }
                }
                if (!a.this.a || !a.this.b) {
                    sg.bigo.ads.common.f.c.a(2, a.this.c, 500);
                } else {
                    a.this.a();
                }
            }
        };
        private long e;
        private long f;
        private int g;
        private long h = 0;
        private long i = 0;
        private boolean j = false;
        private boolean k = false;

        protected a() {
        }

        private float a(Rect rect) {
            if (c.this.c == null || b.b(c.this.b.a.m())) {
                return 0.0f;
            }
            float height = ((float) c.this.c.getHeight()) * 1.0f * ((float) c.this.c.getWidth());
            float height2 = ((float) rect.height()) * 1.0f * ((float) rect.width());
            if (height <= 0.0f) {
                return 0.0f;
            }
            return height2 / height;
        }

        static /* synthetic */ void a(a aVar, Rect rect) {
            float f2;
            if (aVar.h == 0) {
                aVar.h = SystemClock.elapsedRealtime();
            }
            if (!aVar.j) {
                f2 = aVar.a(rect);
                View view = c.this.c;
                int i2 = aVar.g;
                if ((view != null && view.getMeasuredHeight() > 0 && view.getMeasuredWidth() > 0 && (i2 == 0 || ((float) i2) <= 100.0f * f2)) || (b.b(c.this.i()) && !c.this.f)) {
                    aVar.j = true;
                }
            } else {
                f2 = 0.0f;
            }
            if (aVar.j && SystemClock.elapsedRealtime() - aVar.h >= aVar.e) {
                if (f2 == 0.0f) {
                    f2 = aVar.a(rect);
                }
                c.this.a("show_proportion", (Object) o.a("%.4f", Float.valueOf(f2)));
                c.this.c();
                aVar.a = true;
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
            if (r0 != 12) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
            if (r2 != 2) goto L_0x0053;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r7 = this;
                boolean r0 = r7.k
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                sg.bigo.ads.ad.c r0 = sg.bigo.ads.ad.c.this
                int r0 = r0.j()
                r1 = 2
                if (r0 != r1) goto L_0x0015
                sg.bigo.ads.ad.c r0 = sg.bigo.ads.ad.c.this
                long r2 = sg.bigo.ads.ad.c.a(r0)
                goto L_0x001b
            L_0x0015:
                sg.bigo.ads.ad.c r0 = sg.bigo.ads.ad.c.this
                long r2 = sg.bigo.ads.ad.c.b(r0)
            L_0x001b:
                r7.e = r2
                sg.bigo.ads.ad.c r0 = sg.bigo.ads.ad.c.this
                int r0 = r0.j()
                if (r0 != r1) goto L_0x002c
                sg.bigo.ads.ad.c r0 = sg.bigo.ads.ad.c.this
                int r0 = sg.bigo.ads.ad.c.c(r0)
                goto L_0x0032
            L_0x002c:
                sg.bigo.ads.ad.c r0 = sg.bigo.ads.ad.c.this
                int r0 = sg.bigo.ads.ad.c.d(r0)
            L_0x0032:
                r7.g = r0
                sg.bigo.ads.ad.c r0 = sg.bigo.ads.ad.c.this
                int r0 = r0.i()
                sg.bigo.ads.ad.c r2 = sg.bigo.ads.ad.c.this
                int r2 = r2.j()
                r3 = 0
                r4 = 1000(0x3e8, float:1.401E-42)
                r5 = 1
                if (r0 == r5) goto L_0x0055
                if (r0 == r1) goto L_0x0053
                r6 = 3
                if (r0 == r6) goto L_0x0053
                r6 = 4
                if (r0 == r6) goto L_0x0058
                r6 = 12
                if (r0 == r6) goto L_0x0055
                goto L_0x005a
            L_0x0053:
                r3 = r4
                goto L_0x005a
            L_0x0055:
                if (r2 == r1) goto L_0x0058
                goto L_0x0053
            L_0x0058:
                r3 = 2000(0x7d0, float:2.803E-42)
            L_0x005a:
                long r2 = (long) r3
                r7.f = r2
                java.lang.Runnable r0 = r7.c
                sg.bigo.ads.common.f.c.a(r1, r0)
                r7.k = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.c.a.b():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
            if (r1 != 12) goto L_0x0073;
         */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0095  */
        /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ void b(sg.bigo.ads.ad.c.a r10, android.graphics.Rect r11) {
            /*
                long r0 = r10.i
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x000e
                long r0 = android.os.SystemClock.elapsedRealtime()
                r10.i = r0
            L_0x000e:
                float r11 = r10.a((android.graphics.Rect) r11)
                sg.bigo.ads.ad.c r0 = sg.bigo.ads.ad.c.this
                android.view.View r0 = r0.c
                sg.bigo.ads.ad.c r1 = sg.bigo.ads.ad.c.this
                int r1 = r1.i()
                sg.bigo.ads.ad.c r2 = sg.bigo.ads.ad.c.this
                int r2 = r2.j()
                r3 = 0
                r4 = 1
                if (r0 == 0) goto L_0x0073
                int r5 = r0.getMeasuredWidth()
                if (r5 <= 0) goto L_0x0073
                int r5 = r0.getMeasuredHeight()
                if (r5 <= 0) goto L_0x0073
                int r5 = r0.getHeight()
                int r0 = r0.getWidth()
                int r5 = r5 * r0
                r0 = 1050253722(0x3e99999a, float:0.3)
                r6 = 242000(0x3b150, float:3.39114E-40)
                r7 = 2
                r8 = 1056964608(0x3f000000, float:0.5)
                if (r1 == r4) goto L_0x0060
                if (r1 == r7) goto L_0x0053
                r9 = 3
                if (r1 == r9) goto L_0x0059
                r9 = 4
                if (r1 == r9) goto L_0x0059
                r9 = 12
                if (r1 == r9) goto L_0x0060
                goto L_0x0073
            L_0x0053:
                if (r5 <= r6) goto L_0x005b
                int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
                if (r0 <= 0) goto L_0x0073
            L_0x0059:
                r0 = r4
                goto L_0x0074
            L_0x005b:
                int r0 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x0073
                goto L_0x0059
            L_0x0060:
                if (r2 != r7) goto L_0x0067
                int r0 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x0073
                goto L_0x0059
            L_0x0067:
                if (r5 <= r6) goto L_0x006e
                int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
                if (r0 <= 0) goto L_0x0073
                goto L_0x0059
            L_0x006e:
                int r0 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x0073
                goto L_0x0059
            L_0x0073:
                r0 = r3
            L_0x0074:
                if (r0 != 0) goto L_0x0088
                sg.bigo.ads.ad.c r0 = sg.bigo.ads.ad.c.this
                int r0 = r0.i()
                boolean r0 = sg.bigo.ads.api.core.b.b(r0)
                if (r0 == 0) goto L_0x00ce
                sg.bigo.ads.ad.c r0 = sg.bigo.ads.ad.c.this
                boolean r0 = r0.f
                if (r0 != 0) goto L_0x00ce
            L_0x0088:
                long r0 = android.os.SystemClock.elapsedRealtime()
                long r5 = r10.i
                long r0 = r0 - r5
                long r5 = r10.f
                int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r0 < 0) goto L_0x00ce
                sg.bigo.ads.ad.c r0 = sg.bigo.ads.ad.c.this
                java.lang.Object[] r1 = new java.lang.Object[r4]
                java.lang.Float r11 = java.lang.Float.valueOf(r11)
                r1[r3] = r11
                java.lang.String r11 = "%.4f"
                java.lang.String r11 = sg.bigo.ads.common.utils.o.a((java.lang.String) r11, (java.lang.Object[]) r1)
                boolean r1 = r0.j
                if (r1 != 0) goto L_0x00cc
                r0.j = r4
                sg.bigo.ads.api.core.g r1 = r0.b
                sg.bigo.ads.api.core.c r1 = r1.a
                java.lang.String r2 = r0.e()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.String r5 = "render_style"
                java.lang.Object r0 = r0.b((java.lang.String) r5, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                java.util.Map r11 = sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) r1, (java.lang.String) r11, (java.lang.String) r2, (int) r0)
                java.lang.String r0 = "06002029"
                sg.bigo.ads.core.d.a.a((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.String>) r11)
            L_0x00cc:
                r10.b = r4
            L_0x00ce:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.c.a.b(sg.bigo.ads.ad.c$a, android.graphics.Rect):void");
        }

        public final void a() {
            sg.bigo.ads.common.f.c.a(this.c);
            this.k = false;
        }

        public final void a(final View view, boolean z) {
            c.this.c = view;
            if (view != null) {
                if (z) {
                    sg.bigo.ads.common.f.c.a(2, new Runnable() {
                        public final void run() {
                            a.this.b();
                        }
                    });
                } else {
                    view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                        public final void onViewAttachedToWindow(View view) {
                            a.this.b();
                            view.removeOnAttachStateChangeListener(this);
                        }

                        public final void onViewDetachedFromWindow(View view) {
                            a.this.a();
                        }
                    });
                }
            }
        }
    }

    public c(g gVar) {
        super(gVar);
    }

    static /* synthetic */ long a(c cVar) {
        n.b S;
        if (!(cVar.b.a instanceof n) || (S = ((n) cVar.b.a).S()) == null) {
            return 0;
        }
        return S.b();
    }

    static /* synthetic */ long b(c cVar) {
        n.b S;
        if (!(cVar.b.a instanceof n) || (S = ((n) cVar.b.a).S()) == null) {
            return 0;
        }
        return S.d();
    }

    static /* synthetic */ int c(c cVar) {
        n.b S;
        if (!(cVar.b.a instanceof n) || (S = ((n) cVar.b.a).S()) == null) {
            return 0;
        }
        return S.a();
    }

    static /* synthetic */ int d(c cVar) {
        n.b S;
        if (!(cVar.b.a instanceof n) || (S = ((n) cVar.b.a).S()) == null) {
            return 0;
        }
        return S.c();
    }

    public final void a(View view, boolean z) {
        this.k.a(view, z);
    }

    public final void b() {
        super.b();
        this.k = new a();
    }

    public void destroy() {
        super.destroy();
        this.k.a();
    }

    /* access modifiers changed from: protected */
    public final void f() {
        super.f();
        this.k.a();
    }

    public final void p() {
        this.k.b();
    }
}
