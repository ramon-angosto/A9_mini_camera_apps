package com.mbridge.msdk.splash.d;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.ZoomOutTypeEnum;
import com.mbridge.msdk.splash.c.b;
import com.mbridge.msdk.splash.view.MBSplashPopView;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;

/* compiled from: SplashProvider */
public final class c {
    private static String b = "SplashProvider";
    private boolean A;
    private CampaignEx B;
    private MBSplashPopView C;
    private boolean D = false;
    public boolean a = false;
    private String c;
    private String d;
    private MBridgeIds e;
    private int f = 5;
    private long g;
    private b h;
    private com.mbridge.msdk.splash.c.c i;
    private b j;
    private MBSplashShowListener k;
    private d l;
    private MBSplashView m;
    private MBSplashWebview n;
    private ViewGroup o;
    private View p;
    private d q;
    private boolean r;
    private ViewGroup s;
    private com.mbridge.msdk.b.c t;
    private boolean u;
    private int v = 1;
    private int w = m.h(a.e().g());
    private int x = m.i(a.e().g());
    private Object y = new Object();
    private Object z = new Object();

    public final void a(ViewGroup viewGroup) {
        this.s = viewGroup;
    }

    public final boolean a() {
        return this.r;
    }

    public final void a(boolean z2) {
        this.r = z2;
    }

    public final void a(int i2) {
        this.v = i2;
    }

    public c(String str, String str2) {
        this.d = str;
        this.c = str2;
        this.e = new MBridgeIds(str, str2);
        if (this.i == null) {
            this.i = new com.mbridge.msdk.splash.c.c(a.e().g(), this.d, this.c);
        }
        if (this.n == null) {
            this.n = new MBSplashWebview(a.e().g());
            this.n.setWebViewClient(new com.mbridge.msdk.splash.view.a(this.c, this.i.a()));
        }
        if (this.m == null) {
            this.m = new MBSplashView(a.e().g());
            this.m.setSplashWebview(this.n);
        }
        if (this.t == null) {
            this.t = new com.mbridge.msdk.b.c();
        }
        this.t.a(a.e().g(), a.e().h(), a.e().i(), this.c);
    }

    public final void a(long j2) {
        this.g = j2;
    }

    public final long b() {
        return this.g;
    }

    public final boolean c() {
        return this.u;
    }

    public final void a(MBSplashLoadListener mBSplashLoadListener) {
        if (this.j == null) {
            this.j = new b(this, this.e);
        }
        this.j.a(mBSplashLoadListener);
    }

    public final void a(MBSplashShowListener mBSplashShowListener) {
        this.k = mBSplashShowListener;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            b bVar = this.j;
            if (bVar != null) {
                bVar.a("token is null or empty", 1);
                return;
            }
            return;
        }
        a(str, 1);
    }

    public final void b(String str) {
        a(str, 1);
    }

    public final void a(String str, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str)) {
            b bVar = this.j;
            if (bVar != null) {
                bVar.a("token is null or empty", 1);
                return;
            }
            return;
        }
        b(str, viewGroup);
    }

    public final void b(String str, ViewGroup viewGroup) {
        this.o = viewGroup;
        MBSplashView mBSplashView = this.m;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        a(str, 2);
    }

    public final boolean c(String str) {
        return com.mbridge.msdk.splash.c.a.a(this.m, this.d, this.c, str, this.u, this.f, false, true) != null;
    }

    public final void b(boolean z2) {
        this.u = z2;
    }

    public final void b(int i2) {
        this.f = i2;
    }

    public final int d() {
        return this.f;
    }

    public final void a(int i2, int i3) {
        b(i3, i2);
    }

    public final String e() {
        if (!this.a) {
            b bVar = this.h;
            if (bVar != null) {
                return bVar.a();
            }
            return "";
        }
        com.mbridge.msdk.splash.c.c cVar = this.i;
        return cVar != null ? cVar.b() : "";
    }

    public final void c(String str, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str)) {
            MBSplashShowListener mBSplashShowListener = this.k;
            if (mBSplashShowListener != null) {
                mBSplashShowListener.onShowFailed(this.e, "token is null or empty");
                return;
            }
            return;
        }
        d(str, viewGroup);
    }

    public final void d(String str, ViewGroup viewGroup) {
        this.o = viewGroup;
        MBSplashView mBSplashView = this.m;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        CampaignEx a2 = com.mbridge.msdk.splash.c.a.a(this.m, this.d, this.c, str, this.u, this.f, true, false);
        if (a2 != null) {
            if (this.q == null) {
                this.q = com.mbridge.msdk.b.b.a().c(a.e().h(), this.c);
            }
            this.l = new d(this, this.k, a2);
            if (this.w == 0 || this.x == 0) {
                d dVar = this.l;
                if (dVar != null) {
                    dVar.a(this.e, "width or height is 0  or width or height is too small");
                    return;
                }
                return;
            }
            int i2 = this.f;
            if (i2 < 2 || i2 > 10) {
                d dVar2 = this.l;
                if (dVar2 != null) {
                    MBridgeIds mBridgeIds = this.e;
                    dVar2.a(mBridgeIds, "countDownTime must in 2 - 10 ,but now is " + this.f);
                    return;
                }
                return;
            }
            a(a2, this.q.n(), false);
            return;
        }
        MBSplashShowListener mBSplashShowListener = this.k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.e, "campaignEx is vali");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(CampaignEx campaignEx, int i2, boolean z2) {
        if (campaignEx != null && z2) {
            if (this.q == null) {
                this.q = com.mbridge.msdk.b.b.a().c(a.e().h(), this.c);
            }
            this.l = new d(this, this.k, campaignEx);
        }
        ViewGroup viewGroup = this.o;
        if (viewGroup == null) {
            d dVar = this.l;
            if (dVar != null) {
                dVar.a(this.e, "container is null");
                return;
            }
            return;
        }
        if (this.i == null) {
            this.i = new com.mbridge.msdk.splash.c.c(viewGroup.getContext(), this.d, this.c);
        }
        this.B = campaignEx;
        b(campaignEx, i2, z2);
    }

    /* access modifiers changed from: private */
    public void b(final CampaignEx campaignEx, final int i2, final boolean z2) {
        if (com.mbridge.msdk.splash.c.a.a(this.m, campaignEx)) {
            d(true);
            ViewGroup.LayoutParams layoutParams = this.o.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            this.o.setLayoutParams(layoutParams);
            this.o.removeAllViews();
            this.i.a(this.f);
            this.i.a(this.s);
            this.i.a(this.l);
            q.d(b, "start show process");
            ViewGroup viewGroup = this.o;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                aa.a(this.m);
                this.o.addView(this.m);
            }
            this.i.a(this.u);
            this.i.a(campaignEx, this.m);
        } else if (i2 > 0) {
            this.i.a.postDelayed(new Runnable() {
                public final void run() {
                    c.this.b(campaignEx, i2 - 1, z2);
                }
            }, 1);
        } else {
            d dVar = this.l;
            if (dVar != null) {
                dVar.a(this.e, "campaignEx is not ready");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        r0 = r7.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        if (r0 < 2) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        if (r0 <= 10) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        if (r7.w == 0) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        if (r7.x != 0) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        r7.m.clearResState();
        r7.q = com.mbridge.msdk.b.b.a().c(com.mbridge.msdk.foundation.controller.a.e().h(), r7.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r7.h != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        r7.h = new com.mbridge.msdk.splash.c.b(r7.d, r7.c, r7.g * 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r0 = r7.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r0 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        r0.a(r8);
        r7.h.a((com.mbridge.msdk.splash.b.a) r7.j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
        r7.m.resetLoadState();
        r7.h.a(r7.f);
        r7.h.a(r7.m);
        r7.h.a(r7.q);
        r7.h.a(r7.w, r7.x);
        r7.h.a(r7.u);
        r7.h.a(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        r8 = r7.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009b, code lost:
        if (r8 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009d, code lost:
        r8.a("width or height is 0  or width or height is too small", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a3, code lost:
        r8 = r7.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a5, code lost:
        if (r8 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a7, code lost:
        r8.a("countDownTime must in 2 - 10 ,but now is " + r7.f, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.y
            monitor-enter(r0)
            boolean r1 = r7.r     // Catch:{ all -> 0x00be }
            r2 = 1
            if (r1 == 0) goto L_0x0017
            com.mbridge.msdk.splash.d.b r8 = r7.j     // Catch:{ all -> 0x00be }
            if (r8 == 0) goto L_0x0015
            com.mbridge.msdk.splash.d.b r8 = r7.j     // Catch:{ all -> 0x00be }
            java.lang.String r1 = "current unit is loading"
            r8.a((java.lang.String) r1, (int) r9)     // Catch:{ all -> 0x00be }
            r7.r = r2     // Catch:{ all -> 0x00be }
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x00be }
            return
        L_0x0017:
            r7.r = r2     // Catch:{ all -> 0x00be }
            monitor-exit(r0)     // Catch:{ all -> 0x00be }
            int r0 = r7.f
            r1 = 2
            if (r0 < r1) goto L_0x00a3
            r1 = 10
            if (r0 <= r1) goto L_0x0025
            goto L_0x00a3
        L_0x0025:
            int r0 = r7.w
            if (r0 == 0) goto L_0x0099
            int r0 = r7.x
            if (r0 != 0) goto L_0x002e
            goto L_0x0099
        L_0x002e:
            com.mbridge.msdk.splash.view.MBSplashView r0 = r7.m
            r0.clearResState()
            com.mbridge.msdk.b.b r0 = com.mbridge.msdk.b.b.a()
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r1 = r1.h()
            java.lang.String r2 = r7.c
            com.mbridge.msdk.b.d r0 = r0.c(r1, r2)
            r7.q = r0
            com.mbridge.msdk.splash.c.b r0 = r7.h
            if (r0 != 0) goto L_0x005b
            com.mbridge.msdk.splash.c.b r0 = new com.mbridge.msdk.splash.c.b
            java.lang.String r1 = r7.d
            java.lang.String r2 = r7.c
            long r3 = r7.g
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
            r0.<init>(r1, r2, r3)
            r7.h = r0
        L_0x005b:
            com.mbridge.msdk.splash.d.b r0 = r7.j
            if (r0 == 0) goto L_0x0069
            r0.a((java.lang.String) r8)
            com.mbridge.msdk.splash.c.b r0 = r7.h
            com.mbridge.msdk.splash.d.b r1 = r7.j
            r0.a((com.mbridge.msdk.splash.b.a) r1)
        L_0x0069:
            com.mbridge.msdk.splash.view.MBSplashView r0 = r7.m
            r0.resetLoadState()
            com.mbridge.msdk.splash.c.b r0 = r7.h
            int r1 = r7.f
            r0.a((int) r1)
            com.mbridge.msdk.splash.c.b r0 = r7.h
            com.mbridge.msdk.splash.view.MBSplashView r1 = r7.m
            r0.a((com.mbridge.msdk.splash.view.MBSplashView) r1)
            com.mbridge.msdk.splash.c.b r0 = r7.h
            com.mbridge.msdk.b.d r1 = r7.q
            r0.a((com.mbridge.msdk.b.d) r1)
            com.mbridge.msdk.splash.c.b r0 = r7.h
            int r1 = r7.w
            int r2 = r7.x
            r0.a((int) r1, (int) r2)
            com.mbridge.msdk.splash.c.b r0 = r7.h
            boolean r1 = r7.u
            r0.a((boolean) r1)
            com.mbridge.msdk.splash.c.b r0 = r7.h
            r0.a((java.lang.String) r8, (int) r9)
            return
        L_0x0099:
            com.mbridge.msdk.splash.d.b r8 = r7.j
            if (r8 == 0) goto L_0x00a2
            java.lang.String r0 = "width or height is 0  or width or height is too small"
            r8.a((java.lang.String) r0, (int) r9)
        L_0x00a2:
            return
        L_0x00a3:
            com.mbridge.msdk.splash.d.b r8 = r7.j
            if (r8 == 0) goto L_0x00bd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "countDownTime must in 2 - 10 ,but now is "
            r0.append(r1)
            int r1 = r7.f
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.a((java.lang.String) r0, (int) r9)
        L_0x00bd:
            return
        L_0x00be:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00be }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.d.c.a(java.lang.String, int):void");
    }

    public final void a(View view, RelativeLayout.LayoutParams layoutParams) {
        this.p = view;
        if (view != null) {
            b(layoutParams.width, layoutParams.height);
            MBSplashView mBSplashView = this.m;
            if (mBSplashView != null) {
                mBSplashView.setIconVg(view, layoutParams);
            }
        }
    }

    private void b(int i2, int i3) {
        int h2 = m.h(a.e().g());
        int i4 = m.i(a.e().g());
        int i5 = this.v;
        if (i5 == 1) {
            if (i4 >= i3 * 4) {
                this.x = i4 - i3;
                this.w = h2;
                return;
            }
            this.x = 0;
            this.w = 0;
        } else if (i5 != 2) {
        } else {
            if (h2 >= i2 * 4) {
                this.w = h2 - i2;
                this.x = i4;
                return;
            }
            this.x = 0;
            this.w = 0;
        }
    }

    public final void c(boolean z2) {
        this.A = z2;
    }

    public final ViewGroup a(ZoomOutTypeEnum zoomOutTypeEnum) {
        this.C = new MBSplashPopView(a.e().g(), new MBSplashPopView.a(this.d, this.c, zoomOutTypeEnum.getIndex(), this.B), this.l);
        return this.C;
    }

    public final void f() {
        this.D = true;
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView != null) {
            mBSplashPopView.startCountDown();
        }
    }

    public final void g() {
        this.D = false;
        MBSplashShowListener mBSplashShowListener = this.k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayFinish(new MBridgeIds(this.d, this.c));
        }
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView != null) {
            mBSplashPopView.release();
        }
    }

    public final void h() {
        com.mbridge.msdk.splash.c.c cVar = this.i;
        if (cVar != null) {
            cVar.d();
        }
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView != null && this.D) {
            mBSplashPopView.reStartCountDown();
        }
    }

    public final void d(final boolean z2) {
        MBSplashWebview mBSplashWebview = this.n;
        if (mBSplashWebview != null) {
            mBSplashWebview.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !z2;
                }
            });
        }
        MBSplashView mBSplashView = this.m;
        if (mBSplashView != null) {
            mBSplashView.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !z2;
                }
            });
        }
    }

    public final void i() {
        com.mbridge.msdk.splash.c.c cVar = this.i;
        if (cVar != null) {
            cVar.e();
        }
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView != null && this.D) {
            mBSplashPopView.pauseCountDown();
        }
    }

    public final void j() {
        this.B = null;
        if (this.k != null) {
            this.k = null;
        }
        if (this.j != null) {
            this.j = null;
        }
        if (this.l != null) {
            this.l = null;
        }
        b bVar = this.h;
        if (bVar != null) {
            bVar.b();
        }
        com.mbridge.msdk.splash.c.c cVar = this.i;
        if (cVar != null) {
            cVar.c();
        }
    }
}
