package com.mbridge.msdk.advanced.c;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.mbridge.msdk.advanced.b.a;
import com.mbridge.msdk.advanced.b.b;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.advanced.view.MBOutNativeAdvancedViewGroup;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;
import org.json.JSONObject;

/* compiled from: NativeAdvancedProvider */
public final class c {
    private static String b = "NativeAdvancedProvider";
    private boolean A = false;
    /* access modifiers changed from: private */
    public MBOutNativeAdvancedViewGroup B;
    private boolean C;
    private boolean D;
    private boolean E;
    /* access modifiers changed from: private */
    public boolean F = true;
    private ViewTreeObserver.OnScrollChangedListener G = new ViewTreeObserver.OnScrollChangedListener() {
        public final void onScrollChanged() {
            if (c.this.F) {
                boolean unused = c.this.F = false;
                if (c.this.B != null) {
                    c.this.B.postDelayed(new Runnable() {
                        public final void run() {
                            boolean unused = c.this.F = true;
                        }
                    }, 1000);
                }
                c.this.h();
            }
        }
    };
    public boolean a = false;
    private String c;
    private String d;
    private MBridgeIds e;
    private a f;
    private b g;
    private b h;
    private NativeAdvancedAdListener i;
    private d j;
    private MBNativeAdvancedView k;
    private MBNativeAdvancedWebview l;
    private com.mbridge.msdk.advanced.view.a m;
    private d n;
    private boolean o;
    private com.mbridge.msdk.b.c p;
    private int q = -1;
    private boolean r = false;
    private int s = 0;
    private boolean t = false;
    private int u = 0;
    private boolean v = false;
    private int w = 0;
    private int x = 0;
    private Object y = new Object();
    private JSONObject z;

    public final boolean a() {
        return this.o;
    }

    public final void a(boolean z2) {
        this.o = z2;
    }

    public final MBOutNativeAdvancedViewGroup b() {
        return this.B;
    }

    public c(String str, String str2, Activity activity) {
        ViewGroup.LayoutParams layoutParams;
        int i2;
        this.d = str;
        this.c = str2;
        this.e = new MBridgeIds(str, str2);
        if (this.g == null) {
            this.g = new b(com.mbridge.msdk.foundation.controller.a.e().g(), this.d, this.c);
            this.g.a(this);
        }
        if (this.l == null) {
            this.l = new MBNativeAdvancedWebview(com.mbridge.msdk.foundation.controller.a.e().g());
            if (this.m == null) {
                this.m = new com.mbridge.msdk.advanced.view.a(this.c, this.g.b(), this);
            }
            this.l.setWebViewClient(this.m);
        }
        if (this.k == null) {
            this.k = new MBNativeAdvancedView(activity != null ? activity : com.mbridge.msdk.foundation.controller.a.e().g());
            this.k.setAdvancedNativeWebview(this.l);
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
            if (mBNativeAdvancedWebview != null && mBNativeAdvancedWebview.getParent() == null) {
                this.k.addView(this.l, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        if (this.B == null) {
            this.B = new MBOutNativeAdvancedViewGroup(com.mbridge.msdk.foundation.controller.a.e().g());
            int i3 = this.w;
            if (i3 == 0 || (i2 = this.x) == 0) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            } else {
                layoutParams = new ViewGroup.LayoutParams(i3, i2);
            }
            this.B.setLayoutParams(layoutParams);
            this.B.setProvider(this);
            this.B.addView(this.k);
            this.B.getViewTreeObserver().addOnScrollChangedListener(this.G);
        }
        if (this.p == null) {
            this.p = new com.mbridge.msdk.b.c();
        }
        this.p.a(com.mbridge.msdk.foundation.controller.a.e().g(), com.mbridge.msdk.foundation.controller.a.e().h(), com.mbridge.msdk.foundation.controller.a.e().i(), this.c);
        com.mbridge.msdk.advanced.common.b.a();
    }

    public final void a(JSONObject jSONObject) {
        this.A = true;
        b(jSONObject);
    }

    private void b(JSONObject jSONObject) {
        if (this.A) {
            this.z = jSONObject;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
            if (mBNativeAdvancedWebview != null && !mBNativeAdvancedWebview.isDestoryed()) {
                com.mbridge.msdk.advanced.js.a.a(this.l, "setStyleList", "", jSONObject);
            }
        }
    }

    private void f(int i2) {
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
        if (mBNativeAdvancedWebview != null && !mBNativeAdvancedWebview.isDestoryed()) {
            try {
                if (this.l != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("netstat", i2);
                    g.a().a((WebView) this.l, "onNetstatChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                }
            } catch (Throwable th) {
                q.a(b, th.getMessage());
            }
        }
    }

    public final int c() {
        return this.q;
    }

    public final void a(NativeAdvancedAdListener nativeAdvancedAdListener) {
        this.i = nativeAdvancedAdListener;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            NativeAdvancedAdListener nativeAdvancedAdListener = this.i;
            if (nativeAdvancedAdListener != null) {
                nativeAdvancedAdListener.onLoadFailed(this.e, "bid  token is null or empty");
                return;
            }
            return;
        }
        b(str);
    }

    public final void b(String str) {
        this.h = new b(this, this.e);
        this.h.a(this.i);
        this.h.a(str);
        a(str, 2);
    }

    public final boolean c(String str) {
        if (this.B != null) {
            if (com.mbridge.msdk.advanced.b.c.a(this.k, this.d, this.c, str, this.q, false, true) != null) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i2) {
        this.r = true;
        g(i2);
    }

    private void g(int i2) {
        if (this.r) {
            this.q = i2;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
            if (mBNativeAdvancedWebview != null && !mBNativeAdvancedWebview.isDestoryed()) {
                int i3 = this.q;
                if (i3 == 1) {
                    this.g.a(true);
                    com.mbridge.msdk.advanced.js.a.a(this.l, "showCloseButton", "", (Object) null);
                } else if (i3 == 0) {
                    this.g.a(false);
                    com.mbridge.msdk.advanced.js.a.a(this.l, "hideCloseButton", "", (Object) null);
                }
            }
        }
    }

    public final void b(int i2) {
        this.t = true;
        h(i2);
    }

    private void h(int i2) {
        if (this.t) {
            this.s = i2;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
            if (mBNativeAdvancedWebview != null && !mBNativeAdvancedWebview.isDestoryed()) {
                com.mbridge.msdk.advanced.js.a.a(this.l, "setVolume", "mute", Integer.valueOf(i2));
            }
        }
    }

    public final void c(int i2) {
        this.v = true;
        i(i2);
    }

    private void i(int i2) {
        if (this.v) {
            this.u = i2;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.l;
            if (mBNativeAdvancedWebview != null && !mBNativeAdvancedWebview.isDestoryed()) {
                com.mbridge.msdk.advanced.js.a.a(this.l, "setVideoPlayMode", "autoPlay", Integer.valueOf(i2));
            }
        }
    }

    private void f() {
        CampaignEx a2 = com.mbridge.msdk.advanced.b.c.a(this.k, this.d, this.c, "", this.q, true, true);
        if (a2 != null) {
            if (this.n == null) {
                this.n = com.mbridge.msdk.b.b.a().d(com.mbridge.msdk.foundation.controller.a.e().h(), this.c);
            }
            this.j = new d(this, this.i, a2);
            if (this.w == 0 || this.x == 0) {
                d dVar = this.j;
                if (dVar != null) {
                    dVar.a(this.e, "width or height is 0  or width or height is too small");
                    return;
                }
                return;
            }
            a(a2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(CampaignEx campaignEx, boolean z2) {
        g();
        MBOutNativeAdvancedViewGroup mBOutNativeAdvancedViewGroup = this.B;
        if (mBOutNativeAdvancedViewGroup != null && mBOutNativeAdvancedViewGroup.getParent() != null) {
            if (campaignEx != null && z2) {
                if (this.n == null) {
                    this.n = com.mbridge.msdk.b.b.a().d(com.mbridge.msdk.foundation.controller.a.e().h(), this.c);
                }
                this.j = new d(this, this.i, campaignEx);
            }
            if (this.g == null) {
                this.g = new b(com.mbridge.msdk.foundation.controller.a.e().g(), this.d, this.c);
                this.g.a(this);
            }
            a(campaignEx);
        }
    }

    public final String d() {
        if (this.a) {
            b bVar = this.g;
            if (bVar != null) {
                return bVar.a();
            }
            return "";
        }
        a aVar = this.f;
        return aVar != null ? aVar.a() : "";
    }

    private void a(CampaignEx campaignEx) {
        if (com.mbridge.msdk.advanced.b.c.a(this.k, campaignEx, this.d, this.c)) {
            this.g.a(this.j);
            this.g.a(campaignEx, this.k, true);
        }
    }

    private void g() {
        g(this.q);
        h(this.s);
        i(this.u);
        b(this.z);
        f(m.n(com.mbridge.msdk.foundation.controller.a.e().g()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        if (r5.w == 0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        if (r5.x != 0) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        r0 = r5.k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        if (r0 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        r6 = r5.h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        r6.a("view is not ready", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        r0.clearResStateAndRemoveClose();
        r5.n = com.mbridge.msdk.b.b.a().f(com.mbridge.msdk.foundation.controller.a.e().h(), r5.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.n != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        r5.n = com.mbridge.msdk.b.d.c(r5.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        if (r5.f != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        r5.f = new com.mbridge.msdk.advanced.b.a(r5.d, r5.c, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
        r0 = r5.h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
        if (r0 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
        r0.a(r6);
        r5.f.a((com.mbridge.msdk.advanced.a.a) r5.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        r5.k.resetLoadState();
        r5.f.a(r5.k);
        r5.f.a(r5.n);
        r5.f.a(r5.w, r5.x);
        r5.f.a(r5.q);
        r5.f.a(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009f, code lost:
        r6 = r5.h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a3, code lost:
        r6.a("width or height is 0  or width or height is too small", r7);
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
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r6, int r7) {
        /*
            r5 = this;
            r0 = 1
            r5.F = r0
            java.lang.Object r1 = r5.y
            monitor-enter(r1)
            boolean r2 = r5.o     // Catch:{ all -> 0x00a9 }
            if (r2 == 0) goto L_0x0019
            com.mbridge.msdk.advanced.c.b r6 = r5.h     // Catch:{ all -> 0x00a9 }
            if (r6 == 0) goto L_0x0017
            com.mbridge.msdk.advanced.c.b r6 = r5.h     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = "current unit is loading"
            r6.a((java.lang.String) r2, (int) r7)     // Catch:{ all -> 0x00a9 }
            r5.o = r0     // Catch:{ all -> 0x00a9 }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x00a9 }
            return
        L_0x0019:
            r5.o = r0     // Catch:{ all -> 0x00a9 }
            monitor-exit(r1)     // Catch:{ all -> 0x00a9 }
            int r0 = r5.w
            if (r0 == 0) goto L_0x009f
            int r0 = r5.x
            if (r0 != 0) goto L_0x0026
            goto L_0x009f
        L_0x0026:
            com.mbridge.msdk.advanced.view.MBNativeAdvancedView r0 = r5.k
            if (r0 != 0) goto L_0x0034
            com.mbridge.msdk.advanced.c.b r6 = r5.h
            if (r6 == 0) goto L_0x0033
            java.lang.String r0 = "view is not ready"
            r6.a((java.lang.String) r0, (int) r7)
        L_0x0033:
            return
        L_0x0034:
            r0.clearResStateAndRemoveClose()
            com.mbridge.msdk.b.b r0 = com.mbridge.msdk.b.b.a()
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r1 = r1.h()
            java.lang.String r2 = r5.c
            com.mbridge.msdk.b.d r0 = r0.f(r1, r2)
            r5.n = r0
            com.mbridge.msdk.b.d r0 = r5.n
            if (r0 != 0) goto L_0x0057
            java.lang.String r0 = r5.c
            com.mbridge.msdk.b.d r0 = com.mbridge.msdk.b.d.c((java.lang.String) r0)
            r5.n = r0
        L_0x0057:
            com.mbridge.msdk.advanced.b.a r0 = r5.f
            if (r0 != 0) goto L_0x0068
            com.mbridge.msdk.advanced.b.a r0 = new com.mbridge.msdk.advanced.b.a
            java.lang.String r1 = r5.d
            java.lang.String r2 = r5.c
            r3 = 0
            r0.<init>(r1, r2, r3)
            r5.f = r0
        L_0x0068:
            com.mbridge.msdk.advanced.c.b r0 = r5.h
            if (r0 == 0) goto L_0x0076
            r0.a((java.lang.String) r6)
            com.mbridge.msdk.advanced.b.a r0 = r5.f
            com.mbridge.msdk.advanced.c.b r1 = r5.h
            r0.a((com.mbridge.msdk.advanced.a.a) r1)
        L_0x0076:
            com.mbridge.msdk.advanced.view.MBNativeAdvancedView r0 = r5.k
            r0.resetLoadState()
            com.mbridge.msdk.advanced.b.a r0 = r5.f
            com.mbridge.msdk.advanced.view.MBNativeAdvancedView r1 = r5.k
            r0.a((com.mbridge.msdk.advanced.view.MBNativeAdvancedView) r1)
            com.mbridge.msdk.advanced.b.a r0 = r5.f
            com.mbridge.msdk.b.d r1 = r5.n
            r0.a((com.mbridge.msdk.b.d) r1)
            com.mbridge.msdk.advanced.b.a r0 = r5.f
            int r1 = r5.w
            int r2 = r5.x
            r0.a((int) r1, (int) r2)
            com.mbridge.msdk.advanced.b.a r0 = r5.f
            int r1 = r5.q
            r0.a((int) r1)
            com.mbridge.msdk.advanced.b.a r0 = r5.f
            r0.a((java.lang.String) r6, (int) r7)
            return
        L_0x009f:
            com.mbridge.msdk.advanced.c.b r6 = r5.h
            if (r6 == 0) goto L_0x00a8
            java.lang.String r0 = "width or height is 0  or width or height is too small"
            r6.a((java.lang.String) r0, (int) r7)
        L_0x00a8:
            return
        L_0x00a9:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00a9 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.advanced.c.c.a(java.lang.String, int):void");
    }

    public final String d(String str) {
        a aVar = this.f;
        return aVar != null ? aVar.a(str) : "";
    }

    public final void d(int i2) {
        if (i2 == 1) {
            this.C = true;
        } else if (i2 == 2) {
            this.D = true;
        } else if (i2 == 3) {
            this.E = true;
        }
        h();
    }

    public final void e(int i2) {
        if (i2 == 1) {
            this.C = false;
        } else if (i2 == 2) {
            this.D = false;
        } else if (i2 == 3) {
            this.E = false;
        }
        b bVar = this.g;
        if (bVar != null) {
            bVar.e();
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.C && this.D && this.E && !z.a(this.k.getAdvancedNativeWebview()) && this.B.getAlpha() >= 0.5f && this.B.getVisibility() == 0) {
            b bVar = this.g;
            if (bVar != null) {
                bVar.d();
            }
            f();
        }
    }

    public final void e() {
        if (this.i != null) {
            this.i = null;
        }
        if (this.h != null) {
            this.h = null;
        }
        if (this.j != null) {
            this.j = null;
        }
        a aVar = this.f;
        if (aVar != null) {
            aVar.a((MBNativeAdvancedView) null);
            this.f.b();
        }
        b bVar = this.g;
        if (bVar != null) {
            bVar.c();
        }
        MBNativeAdvancedView mBNativeAdvancedView = this.k;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.destroy();
        }
        com.mbridge.msdk.advanced.common.b.a();
        com.mbridge.msdk.advanced.view.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a();
        }
        MBOutNativeAdvancedViewGroup mBOutNativeAdvancedViewGroup = this.B;
        if (mBOutNativeAdvancedViewGroup != null) {
            mBOutNativeAdvancedViewGroup.getViewTreeObserver().removeOnScrollChangedListener(this.G);
            this.B.removeAllViews();
            this.B = null;
        }
    }

    public final void a(int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            this.x = i2;
            this.w = i3;
            this.B.setLayoutParams(new ViewGroup.LayoutParams(i3, i2));
        }
    }
}
