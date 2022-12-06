package sg.bigo.ads.core.mraid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.core.mraid.a;
import sg.bigo.ads.core.mraid.a.a;
import sg.bigo.ads.core.mraid.c;

public final class e {
    private final Handler A;
    private final c.b B;
    private final c.b C;
    final Context a;
    final n b;
    final FrameLayout c;
    final sg.bigo.ads.core.mraid.a.a d;
    final j e;
    p f;
    public b g;
    public c.C0143c h;
    public c.C0143c i;
    public final c j;
    final c k;
    final c l;
    public boolean m;
    private WeakReference<Activity> n;
    private ViewGroup o;
    private final f p;
    private l q;
    private C0144e r;
    private Integer s;
    private final int t;
    private int u;
    private boolean v;
    private i w;
    private final h x;
    private boolean y;
    private a z;

    public interface a extends b {
        void a(String str, String str2);
    }

    public interface b {
        void a();

        void a(String str, Point point);

        boolean a(Activity activity, int i);

        void b();

        boolean b(Activity activity, int i);

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    class c {
        int a;
        int b;

        private c() {
            this.a = -1;
            this.b = -1;
        }

        /* synthetic */ c(e eVar, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            int measuredWidth = e.this.h.getMeasuredWidth();
            int measuredHeight = e.this.h.getMeasuredHeight();
            this.a = measuredWidth;
            this.b = measuredHeight;
        }
    }

    public interface d {
        void a();
    }

    /* renamed from: sg.bigo.ads.core.mraid.e$e  reason: collision with other inner class name */
    class C0144e extends BroadcastReceiver {
        Context a;
        private int c = -1;

        C0144e() {
        }

        public final void a() {
            Context context = this.a;
            if (context != null) {
                context.unregisterReceiver(this);
                this.a = null;
            }
        }

        public final void onReceive(Context context, Intent intent) {
            int rotation;
            if (this.a != null && "android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) && (rotation = ((WindowManager) e.this.a.getSystemService("window")).getDefaultDisplay().getRotation()) != this.c) {
                this.c = rotation;
                e.this.a((Runnable) null);
            }
        }
    }

    static class f {
        final Handler a = new Handler(Looper.getMainLooper());
        a b;

        static class a {
            final View[] a;
            final Handler b;
            Runnable c;
            int d;
            final Runnable e;

            private a(Handler handler, View[] viewArr) {
                this.e = new Runnable() {
                    public final void run() {
                        for (final View view : a.this.a) {
                            if (view.getHeight() > 0 || view.getWidth() > 0) {
                                a.a(a.this);
                            } else {
                                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                                    public final boolean onPreDraw() {
                                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                                        a.a(a.this);
                                        return true;
                                    }
                                });
                            }
                        }
                    }
                };
                this.b = handler;
                this.a = viewArr;
            }

            /* synthetic */ a(Handler handler, View[] viewArr, byte b2) {
                this(handler, viewArr);
            }

            static /* synthetic */ void a(a aVar) {
                Runnable runnable;
                aVar.d--;
                if (aVar.d == 0 && (runnable = aVar.c) != null) {
                    runnable.run();
                    aVar.c = null;
                }
            }

            /* access modifiers changed from: package-private */
            public final void a() {
                this.b.removeCallbacks(this.e);
                this.c = null;
            }
        }

        f() {
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
                this.b = null;
            }
        }
    }

    public e(Context context, n nVar) {
        this(context, nVar, new c(nVar), new c(n.INTERSTITIAL), new f());
    }

    private e(Context context, n nVar, c cVar, c cVar2, f fVar) {
        this.f = p.LOADING;
        this.r = new C0144e();
        this.v = true;
        this.w = i.NONE;
        this.m = true;
        this.y = false;
        this.B = new c.a() {
            public final void a() {
                e eVar = e.this;
                eVar.j.a(h.b(eVar.a), h.a(eVar.a), h.d(eVar.a), h.c(eVar.a), eVar.c());
                eVar.j.a(eVar.b);
                eVar.j.a(eVar.j.b());
                eVar.j.a(eVar.e);
                eVar.j();
                eVar.a(p.DEFAULT);
                eVar.j.c("mraidbridge.notifyReadyEvent();");
                if (e.this.g != null) {
                    e.this.g.a();
                }
            }

            public final void a(int i, int i2, int i3, int i4, a.C0142a aVar, boolean z) {
                int i5 = i;
                int i6 = i2;
                int i7 = i3;
                int i8 = i4;
                a.C0142a aVar2 = aVar;
                e eVar = e.this;
                if (eVar.h == null) {
                    throw new d("Unable to resize after the WebView is destroyed");
                } else if (eVar.f != p.LOADING && eVar.f != p.HIDDEN) {
                    if (eVar.f == p.EXPANDED) {
                        throw new d("Not allowed to resize from an already expanded ad");
                    } else if (eVar.b != n.INTERSTITIAL) {
                        eVar.l.a();
                        Context context = eVar.a;
                        int a2 = sg.bigo.ads.common.utils.d.a(context, i5);
                        int a3 = sg.bigo.ads.common.utils.d.a(context, i6);
                        int a4 = sg.bigo.ads.common.utils.d.a(context, i7);
                        int a5 = sg.bigo.ads.common.utils.d.a(context, i8);
                        int i9 = eVar.e.g.left + a4;
                        int i10 = eVar.e.g.top + a5;
                        Rect rect = new Rect(i9, i10, a2 + i9, i10 + a3);
                        if (!z) {
                            Rect rect2 = eVar.e.c;
                            if (rect.width() > rect2.width() || rect.height() > rect2.height()) {
                                throw new d("resizeProperties specified a size (" + i5 + ", " + i6 + ") and offset (" + i7 + ", " + i8 + ") that doesn't allow the ad to appear within the max allowed size (" + eVar.e.d.width() + ", " + eVar.e.d.height() + ")");
                            }
                            rect.offsetTo(e.a(rect2.left, rect.left, rect2.right - rect.width()), e.a(rect2.top, rect.top, rect2.bottom - rect.height()));
                        }
                        Rect rect3 = new Rect();
                        eVar.d.a(aVar2, rect, rect3);
                        if (!eVar.e.c.contains(rect3)) {
                            throw new d("resizeProperties specified a size (" + i5 + ", " + i6 + ") and offset (" + i7 + ", " + i8 + ") that doesn't allow the close region to appear within the max allowed size (" + eVar.e.d.width() + ", " + eVar.e.d.height() + ")");
                        } else if (rect.contains(rect3)) {
                            eVar.d.setCloseVisible(false);
                            eVar.d.setClosePosition(aVar2);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
                            layoutParams.leftMargin = rect.left - eVar.e.c.left;
                            layoutParams.topMargin = rect.top - eVar.e.c.top;
                            if (eVar.f == p.DEFAULT) {
                                eVar.c.removeView(eVar.h);
                                eVar.c.setVisibility(4);
                                eVar.d.addView(eVar.h, new FrameLayout.LayoutParams(-1, -1));
                                eVar.i().addView(eVar.d, layoutParams);
                            } else if (eVar.f == p.RESIZED) {
                                eVar.d.setLayoutParams(layoutParams);
                            }
                            eVar.d.setClosePosition(aVar2);
                            eVar.a(p.RESIZED);
                        } else {
                            throw new d("resizeProperties specified a size (" + i5 + ", " + a3 + ") and offset (" + i7 + ", " + i8 + ") that don't allow the close region to appear within the resized ad.");
                        }
                    } else {
                        throw new d("Not allowed to resize from an interstitial ad");
                    }
                }
            }

            public final void a(String str) {
                e.this.a(str);
            }

            public final void a(String str, Point point) {
                e.this.a(str, point);
            }

            public final void a(String str, String str2) {
                if (e.this.g != null && (e.this.g instanceof a)) {
                    ((a) e.this.g).a(str, str2);
                }
            }

            public final void a(String str, boolean z) {
                e.this.a(str, z);
            }

            public final void a(b bVar) {
                if (!e.this.k.c()) {
                    e.this.j.a(bVar);
                }
            }

            public final void a(boolean z) {
                if (!e.this.k.c()) {
                    e.this.j.a(z);
                }
            }

            public final void a(boolean z, i iVar) {
                e.this.a(z, iVar);
            }

            public final boolean a(JsResult jsResult) {
                return e.this.a(jsResult);
            }

            public final void b() {
                if (e.this.g != null) {
                    e.this.g.b();
                }
            }

            public final void b(boolean z) {
                e.this.b(z);
            }

            public final void c() {
                e.this.g();
            }

            public final boolean d() {
                return e.this.a();
            }

            public final void e() {
                e.this.e();
            }

            public final void f() {
                e.this.f();
            }
        };
        this.C = new c.b() {
            public final void a() {
                e eVar = e.this;
                eVar.a((Runnable) new Runnable() {
                    public final void run() {
                        e.this.k.a(h.b(e.this.a), h.a(e.this.a), h.d(e.this.a), h.c(e.this.a), e.this.c());
                        e.this.k.a(e.this.f);
                        e.this.k.a(e.this.b);
                        e.this.k.a(e.this.k.b());
                        e.this.k.c("mraidbridge.notifyReadyEvent();");
                    }
                });
            }

            public final void a(int i, int i2, int i3, int i4, a.C0142a aVar, boolean z) {
                throw new d("Not allowed to resize from an expanded state");
            }

            public final void a(String str) {
                e.this.a(str);
            }

            public final void a(String str, Point point) {
                e.this.a(str, point);
            }

            public final void a(String str, boolean z) {
            }

            public final void a(b bVar) {
                e.this.j.a(bVar);
                e.this.k.a(bVar);
            }

            public final void a(boolean z) {
                e.this.j.a(z);
                e.this.k.a(z);
            }

            public final void a(boolean z, i iVar) {
                e.this.a(z, iVar);
            }

            public final boolean a(JsResult jsResult) {
                return e.this.a(jsResult);
            }

            public final void b() {
            }

            public final void b(boolean z) {
                e.this.b(z);
            }

            public final void c() {
                e.this.g();
            }

            public final boolean d() {
                return e.this.a();
            }

            public final void e() {
                e.this.e();
            }

            public final void f() {
                e.this.f();
            }
        };
        this.A = new Handler(Looper.getMainLooper());
        this.a = context;
        if (context instanceof Activity) {
            this.n = new WeakReference<>((Activity) context);
        } else {
            this.n = new WeakReference<>((Object) null);
        }
        this.b = nVar;
        this.j = cVar;
        this.k = cVar2;
        this.p = fVar;
        this.l = new c(this, (byte) 0);
        this.f = p.LOADING;
        this.e = new j(this.a, this.a.getResources().getDisplayMetrics().density);
        this.c = new FrameLayout(this.a);
        this.d = new sg.bigo.ads.core.mraid.a.a(this.a);
        this.d.setOnCloseListener(new a.b() {
            public final void a() {
                e.this.f();
            }
        });
        View view = new View(this.a);
        view.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.d.addView(view, new FrameLayout.LayoutParams(-1, -1));
        C0144e eVar = this.r;
        eVar.a = this.a.getApplicationContext();
        if (eVar.a != null) {
            eVar.a.registerReceiver(eVar, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
        this.j.a = this.B;
        this.k.a = this.C;
        this.x = new h();
        this.t = Build.VERSION.SDK_INT >= 19 ? 4871 : 775;
    }

    static int a(int i2, int i3, int i4) {
        return Math.max(i2, Math.min(i3, i4));
    }

    private void a(int i2) {
        Activity activity = (Activity) this.n.get();
        if (activity == null || !a(this.w)) {
            throw new d("Attempted to lock orientation to unsupported value: " + this.w.name());
        }
        if (this.s == null) {
            this.s = Integer.valueOf(activity.getRequestedOrientation());
        }
        b bVar = this.g;
        if (bVar == null || !bVar.a(activity, i2)) {
            activity.setRequestedOrientation(i2);
        }
    }

    private static void a(WebView webView, boolean z2) {
        if (z2) {
            webView.stopLoading();
            webView.loadUrl("");
        }
        webView.onPause();
    }

    private static boolean a(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    private boolean a(i iVar) {
        if (iVar == i.NONE) {
            return true;
        }
        Activity activity = (Activity) this.n.get();
        if (activity == null) {
            return false;
        }
        try {
            ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0);
            return a(activityInfo.configChanges, 128) && a(activityInfo.configChanges, 1024);
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private void k() {
        this.j.a();
        this.h = null;
    }

    private void l() {
        this.k.a();
        this.i = null;
    }

    private void m() {
        int i2;
        if (this.w != i.NONE) {
            i2 = this.w.d;
        } else if (this.v) {
            n();
            return;
        } else {
            Activity activity = (Activity) this.n.get();
            if (activity != null) {
                i2 = sg.bigo.ads.common.p.b.a(activity);
            } else {
                throw new d("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            }
        }
        a(i2);
    }

    private void n() {
        Integer num;
        i().setSystemUiVisibility(this.u);
        Activity activity = (Activity) this.n.get();
        if (!(activity == null || (num = this.s) == null)) {
            b bVar = this.g;
            if (bVar == null || !bVar.b(activity, num.intValue())) {
                activity.setRequestedOrientation(this.s.intValue());
            } else {
                return;
            }
        }
        this.s = null;
    }

    private boolean o() {
        return !this.d.a.isVisible();
    }

    private void p() {
        if (this.z != null) {
            this.a.getContentResolver().unregisterContentObserver(this.z);
            this.z = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(final Runnable runnable) {
        this.p.a();
        final c.C0143c b2 = b();
        if (b2 != null) {
            f fVar = this.p;
            fVar.b = new f.a(fVar.a, new View[]{this.c, b2}, (byte) 0);
            f.a aVar = fVar.b;
            aVar.c = new Runnable() {
                public final void run() {
                    DisplayMetrics displayMetrics = e.this.a.getResources().getDisplayMetrics();
                    j jVar = e.this.e;
                    jVar.a.set(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                    jVar.a(jVar.a, jVar.b);
                    int[] iArr = new int[2];
                    ViewGroup h = e.this.h();
                    h.getLocationOnScreen(iArr);
                    j jVar2 = e.this.e;
                    int i = iArr[0];
                    int i2 = iArr[1];
                    jVar2.c.set(i, i2, h.getWidth() + i, h.getHeight() + i2);
                    jVar2.a(jVar2.c, jVar2.d);
                    e.this.c.getLocationOnScreen(iArr);
                    j jVar3 = e.this.e;
                    int i3 = iArr[0];
                    int i4 = iArr[1];
                    jVar3.g.set(i3, i4, e.this.c.getWidth() + i3, e.this.c.getHeight() + i4);
                    jVar3.a(jVar3.g, jVar3.h);
                    b2.getLocationOnScreen(iArr);
                    j jVar4 = e.this.e;
                    int i5 = iArr[0];
                    int i6 = iArr[1];
                    jVar4.e.set(i5, i6, b2.getWidth() + i5, b2.getHeight() + i6);
                    jVar4.a(jVar4.e, jVar4.f);
                    e.this.j.a(e.this.e);
                    if (e.this.k.c()) {
                        e.this.k.a(e.this.e);
                    }
                    Runnable runnable = runnable;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            };
            aVar.d = aVar.a.length;
            aVar.b.post(aVar.e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        MraidVideoActivity.a(this.a, str);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, Point point) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if ("tel".equalsIgnoreCase(scheme) || "voicemail".equalsIgnoreCase(scheme) || "sms".equalsIgnoreCase(scheme) || "mailto".equalsIgnoreCase(scheme) || "geo".equalsIgnoreCase(scheme) || "google.streetview".equalsIgnoreCase(scheme)) {
            sg.bigo.ads.common.k.a.a(2, "MraidController", String.format("Uri scheme %s is not allowed.", new Object[]{parse.getScheme()}));
            return;
        }
        b bVar = this.g;
        if (bVar != null) {
            bVar.a(str, point);
        }
    }

    public final void a(String str, d dVar) {
        a(dVar);
        this.j.a(str);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, boolean z2) {
        c.C0143c cVar;
        sg.bigo.ads.core.mraid.a.a aVar;
        if (this.h == null) {
            throw new d("Unable to expand after the WebView is destroyed");
        } else if (this.b != n.INTERSTITIAL) {
            if (this.f == p.DEFAULT || this.f == p.RESIZED) {
                m();
                boolean z3 = str != null;
                if (z3) {
                    this.i = c.a(this.a);
                    c.C0143c cVar2 = this.i;
                    if (cVar2 != null) {
                        this.k.a(cVar2);
                        this.k.b(str);
                    } else {
                        return;
                    }
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                if (this.f == p.DEFAULT) {
                    this.u = i().getSystemUiVisibility();
                    i().setSystemUiVisibility(this.t);
                    if (z3) {
                        aVar = this.d;
                        cVar = this.i;
                    } else {
                        this.l.a();
                        this.c.removeView(this.h);
                        this.c.setVisibility(4);
                        aVar = this.d;
                        cVar = this.h;
                    }
                    aVar.addView(cVar, layoutParams);
                    i().addView(this.d, new FrameLayout.LayoutParams(-1, -1));
                } else if (this.f == p.RESIZED && z3) {
                    this.d.removeView(this.h);
                    this.c.addView(this.h, layoutParams);
                    this.c.setVisibility(4);
                    this.d.addView(this.i, layoutParams);
                }
                this.d.setLayoutParams(layoutParams);
                b(z2);
                a(p.EXPANDED);
            }
        }
    }

    public final void a(d dVar) {
        this.h = c.a(this.a);
        if (this.h != null) {
            if (dVar != null) {
                dVar.a();
            }
            this.j.a(this.h);
            this.c.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(p pVar) {
        sg.bigo.ads.common.k.a.a(0, 3, "MraidController", "MRAID state set to ".concat(String.valueOf(pVar)));
        p pVar2 = this.f;
        this.f = pVar;
        this.j.a(pVar);
        if (this.k.c) {
            this.k.a(pVar);
        }
        b bVar = this.g;
        if (bVar != null) {
            if (pVar == p.EXPANDED) {
                bVar.d();
            } else if ((pVar2 == p.EXPANDED && pVar == p.DEFAULT) || pVar == p.HIDDEN) {
                bVar.f();
            } else if ((pVar2 == p.RESIZED && pVar == p.DEFAULT) || pVar == p.RESIZED) {
                bVar.e();
            }
        }
        a((Runnable) null);
    }

    public final void a(boolean z2) {
        this.m = true;
        p();
        c.C0143c cVar = this.h;
        if (cVar != null) {
            a((WebView) cVar, z2);
        }
        c.C0143c cVar2 = this.i;
        if (cVar2 != null) {
            a((WebView) cVar2, z2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2, i iVar) {
        if (a(iVar)) {
            this.v = z2;
            this.w = iVar;
            if (this.f == p.EXPANDED || (this.b == n.INTERSTITIAL && !this.m)) {
                m();
                return;
            }
            return;
        }
        throw new d("Unable to force orientation to ".concat(String.valueOf(iVar)));
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        l lVar = this.q;
        if (lVar != null) {
            return lVar.b();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(JsResult jsResult) {
        l lVar = this.q;
        if (lVar != null) {
            return lVar.a();
        }
        jsResult.confirm();
        return true;
    }

    public final c.C0143c b() {
        return this.k.c() ? this.i : this.h;
    }

    /* access modifiers changed from: protected */
    public final void b(boolean z2) {
        if (z2 != o()) {
            this.d.setCloseVisible(!z2);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        Activity activity = (Activity) this.n.get();
        if (activity == null || b() == null) {
            return false;
        }
        if (this.b != n.INLINE) {
            return true;
        }
        return h.a(activity);
    }

    public final void d() {
        this.p.a();
        try {
            this.r.a();
        } catch (IllegalArgumentException e2) {
            if (!e2.getMessage().contains("Receiver not registered")) {
                throw e2;
            }
        }
        if (!this.m) {
            a(true);
        }
        s.a(this.d);
        k();
        l();
        n();
        p();
        this.o = null;
        s.a(this.c);
        s.a(this.d);
        this.y = true;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        b bVar;
        if (this.b == n.INTERSTITIAL && (bVar = this.g) != null) {
            bVar.g();
        }
    }

    /* access modifiers changed from: protected */
    public final void f() {
        ViewGroup.LayoutParams layoutParams;
        c.C0143c cVar;
        if (this.h != null && this.f != p.LOADING && this.f != p.HIDDEN) {
            if (this.f == p.EXPANDED || this.b == n.INTERSTITIAL) {
                n();
            }
            if (this.f == p.RESIZED || this.f == p.EXPANDED) {
                if (!this.k.c() || (cVar = this.i) == null) {
                    this.d.removeView(this.h);
                    this.c.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
                    this.c.setVisibility(0);
                } else {
                    l();
                    this.d.removeView(cVar);
                }
                c cVar2 = this.l;
                if (e.this.h != null && cVar2.a > 0 && cVar2.b > 0 && (layoutParams = e.this.h.getLayoutParams()) != null) {
                    layoutParams.width = cVar2.a;
                    layoutParams.height = cVar2.b;
                    if (layoutParams instanceof FrameLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
                    }
                    e.this.h.setLayoutParams(layoutParams);
                }
                s.a(this.d);
                a(p.DEFAULT);
            } else if (this.f == p.DEFAULT) {
                this.c.setVisibility(4);
                a(p.HIDDEN);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        b bVar = this.g;
        if (bVar != null) {
            bVar.c();
        }
    }

    /* access modifiers changed from: package-private */
    public final ViewGroup h() {
        ViewGroup viewGroup = this.o;
        if (viewGroup != null) {
            return viewGroup;
        }
        View a2 = s.a((Context) this.n.get(), this.c);
        return a2 instanceof ViewGroup ? (ViewGroup) a2 : this.c;
    }

    /* access modifiers changed from: package-private */
    public final ViewGroup i() {
        if (this.o == null) {
            this.o = h();
        }
        return this.o;
    }

    public final void j() {
        if (!this.y && this.f != p.LOADING && this.f != p.HIDDEN && this.h != null) {
            Context context = this.a;
            if (this.z != null) {
                p();
            }
            this.z = new a(this.A, context.getApplicationContext(), new a.C0141a() {
                public final void a(float f) {
                    c cVar = e.this.j;
                    cVar.c("mraidbridge.notifyAudioVolumeChangeEvent(" + f + ");");
                }
            });
            context.getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.z);
        }
    }
}
