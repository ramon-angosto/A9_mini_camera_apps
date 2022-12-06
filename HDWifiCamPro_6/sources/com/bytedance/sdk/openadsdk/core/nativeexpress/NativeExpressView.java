package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.adexpress.b.b;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.adexpress.b.e;
import com.bytedance.sdk.component.adexpress.b.g;
import com.bytedance.sdk.component.adexpress.b.h;
import com.bytedance.sdk.component.adexpress.b.i;
import com.bytedance.sdk.component.adexpress.b.k;
import com.bytedance.sdk.component.adexpress.b.l;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.adexpress.b.o;
import com.bytedance.sdk.component.adexpress.dynamic.c;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.c.m;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.bannerexpress.VastBannerBackupView;
import com.bytedance.sdk.openadsdk.core.bannerexpress.a;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class NativeExpressView extends FrameLayout implements g, n, c, a.C0043a, i {
    public static int o = 500;
    private String A;
    private a.C0044a B;
    /* access modifiers changed from: private */
    public AtomicBoolean C = new AtomicBoolean(false);
    private BrandBannerController D;
    private final ViewTreeObserver.OnScrollChangedListener E = new ViewTreeObserver.OnScrollChangedListener() {
        public void onScrollChanged() {
            NativeExpressView.this.t();
            NativeExpressView nativeExpressView = NativeExpressView.this;
            nativeExpressView.removeCallbacks(nativeExpressView.F);
            NativeExpressView nativeExpressView2 = NativeExpressView.this;
            nativeExpressView2.postDelayed(nativeExpressView2.F, 500);
        }
    };
    /* access modifiers changed from: private */
    public final Runnable F = new Runnable() {
        public void run() {
            if (v.a(NativeExpressView.this, 0, 5)) {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.d(nativeExpressView.getVisibility());
                return;
            }
            NativeExpressView.this.d(8);
        }
    };
    private final Runnable G = new Runnable() {
        public void run() {
            NativeExpressView.this.d(0);
        }
    };
    private final Runnable H = new Runnable() {
        public void run() {
            NativeExpressView.this.d(8);
        }
    };
    private ThemeStatusBroadcastReceiver I;
    private n J;
    private i.a K;
    private List<i> L;
    private o M;
    private e N;
    private h O;
    private l P;
    private SparseArray<c.a> Q = new SparseArray<>();
    private float R = -1.0f;
    private float S = -1.0f;
    private float T = -1.0f;
    private float U = -1.0f;
    private long V = 0;
    private VastBannerBackupView W;
    private boolean a = true;
    private int b = 0;
    private com.bytedance.sdk.openadsdk.dislike.c c;
    private TTDislikeDialogAbstract d;
    private PAGBannerAdWrapperListener e;
    protected final Context f;
    protected String g = "embeded_ad";
    protected AdSlot h;
    /* access modifiers changed from: protected */
    public com.bytedance.sdk.openadsdk.core.model.n i;
    protected FrameLayout j;
    protected boolean k;
    protected boolean l = false;
    protected com.bytedance.sdk.component.adexpress.b.c m;
    protected boolean n = false;
    public boolean p = false;
    public f q = new f();
    protected b r;
    public d<? extends View> s;
    private d t;
    private e u;
    private final AtomicBoolean v = new AtomicBoolean(false);
    private String w = null;
    private float x;
    private float y;
    private m z;

    public void a() {
    }

    public void a(int i2) {
    }

    /* access modifiers changed from: protected */
    public void a(l.a aVar) {
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
    }

    public void a(boolean z2) {
    }

    public void b() {
    }

    public void b(int i2) {
    }

    public long c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public void e() {
    }

    public void f() {
    }

    public void setTimeUpdate(int i2) {
    }

    public f getAdShowTime() {
        return this.q;
    }

    public void setClosedListenerKey(String str) {
        this.A = str;
        BrandBannerController brandBannerController = this.D;
        if (brandBannerController != null) {
            brandBannerController.a(str);
        }
    }

    public String getClosedListenerKey() {
        return this.A;
    }

    public void setBannerClickClosedListener(a.C0044a aVar) {
        this.B = aVar;
    }

    public NativeExpressView(Context context, com.bytedance.sdk.openadsdk.core.model.n nVar, AdSlot adSlot, String str) {
        super(context);
        this.g = str;
        this.f = context;
        this.i = nVar;
        this.h = adSlot;
        this.p = false;
        g();
    }

    public NativeExpressView(Context context, com.bytedance.sdk.openadsdk.core.model.n nVar, AdSlot adSlot, String str, boolean z2) {
        super(context);
        this.g = str;
        this.f = context;
        this.i = nVar;
        this.h = adSlot;
        this.p = z2;
        g();
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.I = new ThemeStatusBroadcastReceiver();
        AdSlot adSlot = this.h;
        if (adSlot != null) {
            this.x = adSlot.getExpressViewAcceptedWidth();
            this.y = this.h.getExpressViewAcceptedHeight();
            this.w = this.h.getCodeId();
        }
        setBackgroundColor(0);
        if (this.i.ay()) {
            this.D = new BrandBannerController(this.f, this, this.i);
            return;
        }
        h();
        this.L = new ArrayList();
        i();
        o oVar = this.M;
        if (oVar != null) {
            this.J = (n) oVar.d();
        }
        u jsObject = getJsObject();
        if (jsObject != null) {
            jsObject.g(this.g);
        }
    }

    public SSWebView getWebView() {
        n nVar = this.J;
        if (nVar == null) {
            return null;
        }
        return nVar.a();
    }

    private void h() {
        long j2;
        JSONObject a2 = com.bytedance.sdk.openadsdk.core.nativeexpress.a.b.a(this.x, this.y, this.l, this.i);
        this.z = new m(1, this.g, this.i);
        this.O = new h(this.z, this.g, this.i, this.w);
        boolean z2 = false;
        try {
            j2 = new JSONObject(this.i.G().g()).optLong("render_delay_time");
            try {
                if (!com.bytedance.sdk.openadsdk.core.model.n.c(this.i) && com.bytedance.sdk.openadsdk.core.m.d().k(this.w) == 1) {
                    z2 = true;
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            j2 = 0;
        }
        long min = Math.min(Math.max(j2, 0), WorkRequest.MIN_BACKOFF_MILLIS);
        a(a2);
        int renderTimeout = getRenderTimeout();
        com.bytedance.sdk.component.utils.l.b("NativeExpressView", "initRenderRequest: renderTimeout=" + renderTimeout);
        l.a b2 = new l.a().a(this.g).b(this.i.Y()).c(this.i.aY()).d(this.i.ac()).a(a2).a(this.O).d(this.i.aG()).a(renderTimeout).a(this.i.ap()).b(this.i.t()).a(min).c(this.i.L()).a(com.bytedance.sdk.openadsdk.core.nativeexpress.a.b.b(this.i)).b(z2);
        a(b2);
        this.P = b2.a();
    }

    /* access modifiers changed from: protected */
    public int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.core.m.d().t();
    }

    private void i() {
        if (this.i.aR() == 1 && this.i.aw()) {
            this.N = new e(this.f, this.P, new k(this, this.I, this.P));
            this.L.add(this.N);
            this.K = new k(this.L, this.O);
        } else if (x()) {
            j();
        } else {
            try {
                k();
                this.J = new n(this.f, this.P, this.I, this.z, this.i);
                this.M = new o(this.f, this.P, this.J, this);
                this.L.add(this.M);
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.l.c("NativeExpressView", "NativeExpressView dynamicRender fail", (Throwable) e2);
            }
            this.N = new e(this.f, this.P, new k(this, this.I, this.P));
            this.L.add(this.N);
            this.K = new k(this.L, this.O);
        }
    }

    private void j() {
        this.b = this.i.q();
        try {
            k();
            s();
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.l.c("NativeExpressView", "NativeExpressView dynamicRender fail", (Throwable) e2);
        }
        boolean z2 = true;
        if (this.i.r() != 1) {
            z2 = false;
        }
        this.a = z2;
        if (this.a) {
            this.N = new e(this.f, this.P, new k(this, this.I, this.P));
            this.L.add(this.N);
        }
        com.bytedance.sdk.component.utils.l.b("NativeExpressView", "initRender: mRenderSequenceType is " + this.b + ", mInterceptors is " + this.L);
        this.K = new k(this.L, this.O);
    }

    private void k() {
        if (!TTAdSdk.isInitSuccess()) {
            com.bytedance.sdk.openadsdk.core.k.b();
        }
    }

    private void s() {
        com.bytedance.sdk.openadsdk.core.c.a.a aVar = new com.bytedance.sdk.openadsdk.core.c.a.a();
        if (this.b != 3) {
            this.J = new n(this.f, this.P, this.I, this.z, this.i);
            this.M = new o(this.f, this.P, this.J, this);
            this.L.add(this.M);
            return;
        }
        this.r = new b(this.f, this.P, this.I, this.p, new com.bytedance.sdk.component.adexpress.dynamic.c.f(), this, aVar);
        this.L.add(this.r);
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        BackupView backupView;
        d<? extends View> dVar = this.s;
        if (!(dVar == null || !(dVar instanceof k) || (backupView = (BackupView) dVar.e()) == null)) {
            backupView.setDislikeOuter(tTDislikeDialogAbstract);
        }
        BrandBannerController brandBannerController = this.D;
        if (brandBannerController != null) {
            brandBannerController.a(tTDislikeDialogAbstract);
        }
        this.d = tTDislikeDialogAbstract;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.dislike.c cVar) {
        BackupView backupView;
        d<? extends View> dVar = this.s;
        if (!(dVar == null || !(dVar instanceof k) || (backupView = (BackupView) dVar.e()) == null)) {
            backupView.setDislikeInner(cVar);
        }
        BrandBannerController brandBannerController = this.D;
        if (brandBannerController != null) {
            brandBannerController.a((TTAdDislike) cVar);
        }
        this.c = cVar;
    }

    public void setExpressInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.e = pAGBannerAdWrapperListener;
    }

    public void setClickCreativeListener(d dVar) {
        this.t = dVar;
        d dVar2 = this.t;
        if (dVar2 != null) {
            dVar2.a((a.C0043a) this);
        }
    }

    public d getClickCreativeListener() {
        return this.t;
    }

    public e getClickListener() {
        return this.u;
    }

    public void setClickListener(e eVar) {
        this.u = eVar;
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.b.c cVar) {
        this.m = cVar;
        e eVar = this.N;
        if (eVar != null) {
            eVar.a(cVar);
        }
    }

    public void l() {
        d<? extends View> dVar = this.s;
        if (dVar instanceof n) {
            if (dVar != null) {
                ((n) dVar).j();
            } else {
                return;
            }
        }
        com.bytedance.sdk.openadsdk.core.model.n nVar = this.i;
        if (nVar != null && nVar.ax() != null && this.i.ax().a() != null) {
            this.i.ax().a().a(0);
        }
    }

    public void d(int i2) {
        d<? extends View> dVar = this.s;
        if (dVar != null && (dVar instanceof n)) {
            ((n) dVar).a(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        removeCallbacks(this.H);
        removeCallbacks(this.G);
        if (i2 == 0) {
            postDelayed(this.G, 50);
        } else {
            postDelayed(this.H, 50);
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z2 ? getVisibility() : 8);
        }
        t();
        if (z2) {
            com.bytedance.sdk.openadsdk.k.a.e.a(this.i, 4);
        } else {
            com.bytedance.sdk.openadsdk.k.a.e.a(this.i, 8);
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        com.bytedance.sdk.component.utils.h.a().post(new Runnable() {
            public void run() {
                if (NativeExpressView.this.C.get()) {
                    NativeExpressView.this.q.a(System.currentTimeMillis(), v.a(NativeExpressView.this));
                }
            }
        });
    }

    public void m() {
        if (this.i.ay()) {
            BrandBannerController brandBannerController = this.D;
            if (brandBannerController == null) {
                a_(106);
                return;
            }
            brandBannerController.a((n) this);
            this.D.a();
            return;
        }
        this.z.a();
        i.a aVar = this.K;
        if (aVar != null) {
            aVar.a((n) this);
        }
        try {
            this.K.a();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r13) {
        /*
            r12 = this;
            com.bytedance.sdk.openadsdk.core.nativeexpress.d r0 = r12.t
            r1 = 0
            if (r0 == 0) goto L_0x001e
            int r2 = r13.getDeviceId()
            r0.b((int) r2)
            com.bytedance.sdk.openadsdk.core.nativeexpress.d r0 = r12.t
            int r2 = r13.getSource()
            r0.a((int) r2)
            com.bytedance.sdk.openadsdk.core.nativeexpress.d r0 = r12.t
            int r2 = r13.getToolType(r1)
            r0.c((int) r2)
        L_0x001e:
            com.bytedance.sdk.openadsdk.core.nativeexpress.e r0 = r12.u
            if (r0 == 0) goto L_0x003b
            int r2 = r13.getDeviceId()
            r0.b((int) r2)
            com.bytedance.sdk.openadsdk.core.nativeexpress.e r0 = r12.u
            int r2 = r13.getSource()
            r0.a((int) r2)
            com.bytedance.sdk.openadsdk.core.nativeexpress.e r0 = r12.u
            int r2 = r13.getToolType(r1)
            r0.c((int) r2)
        L_0x003b:
            int r0 = r13.getActionMasked()
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L_0x009c
            if (r0 == r4) goto L_0x009a
            if (r0 == r3) goto L_0x004f
            if (r0 == r2) goto L_0x004d
            r1 = -1
        L_0x004b:
            r5 = r1
            goto L_0x00af
        L_0x004d:
            r1 = 4
            goto L_0x004b
        L_0x004f:
            float r0 = r12.T
            float r1 = r13.getX()
            float r2 = r12.R
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            float r0 = r0 + r1
            r12.T = r0
            float r0 = r12.U
            float r1 = r13.getY()
            float r2 = r12.S
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            float r0 = r0 + r1
            r12.U = r0
            float r0 = r13.getX()
            r12.R = r0
            float r0 = r13.getY()
            r12.S = r0
            long r0 = java.lang.System.currentTimeMillis()
            long r5 = r12.V
            long r0 = r0 - r5
            r5 = 200(0xc8, double:9.9E-322)
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0098
            float r0 = r12.T
            r1 = 1090519040(0x41000000, float:8.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0096
            float r0 = r12.U
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0098
        L_0x0096:
            r5 = r4
            goto L_0x00af
        L_0x0098:
            r5 = r3
            goto L_0x00af
        L_0x009a:
            r5 = r2
            goto L_0x00af
        L_0x009c:
            float r0 = r13.getRawX()
            r12.R = r0
            float r0 = r13.getRawY()
            r12.S = r0
            long r2 = java.lang.System.currentTimeMillis()
            r12.V = r2
            goto L_0x004b
        L_0x00af:
            android.util.SparseArray<com.bytedance.sdk.openadsdk.core.b.c$a> r0 = r12.Q
            if (r0 == 0) goto L_0x00ce
            int r1 = r13.getActionMasked()
            com.bytedance.sdk.openadsdk.core.b.c$a r2 = new com.bytedance.sdk.openadsdk.core.b.c$a
            float r3 = r13.getSize()
            double r6 = (double) r3
            float r3 = r13.getPressure()
            double r8 = (double) r3
            long r10 = java.lang.System.currentTimeMillis()
            r4 = r2
            r4.<init>(r5, r6, r8, r10)
            r0.put(r1, r2)
        L_0x00ce:
            boolean r13 = super.dispatchTouchEvent(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: type inference failed for: r24v0, types: [android.view.View] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r24, int r25, com.bytedance.sdk.component.adexpress.c r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = -1
            if (r2 == r3) goto L_0x01da
            if (r26 != 0) goto L_0x000d
            goto L_0x01da
        L_0x000d:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            com.bytedance.sdk.openadsdk.core.model.n r4 = r0.i
            boolean r4 = com.bytedance.sdk.openadsdk.core.model.p.i(r4)
            java.lang.String r5 = "click_scence"
            r6 = 1
            if (r4 == 0) goto L_0x0026
            r4 = 3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.put(r5, r4)
            goto L_0x002d
        L_0x0026:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r3.put(r5, r4)
        L_0x002d:
            r4 = r26
            com.bytedance.sdk.openadsdk.core.model.j r4 = (com.bytedance.sdk.openadsdk.core.model.j) r4
            com.bytedance.sdk.openadsdk.core.nativeexpress.d r5 = r0.t
            if (r5 == 0) goto L_0x0041
            int r7 = r23.getDynamicShowType()
            r5.d((int) r7)
            com.bytedance.sdk.openadsdk.core.nativeexpress.d r5 = r0.t
            r5.a((java.util.Map<java.lang.String, java.lang.Object>) r3)
        L_0x0041:
            com.bytedance.sdk.openadsdk.core.nativeexpress.e r5 = r0.u
            if (r5 == 0) goto L_0x0051
            int r7 = r23.getDynamicShowType()
            r5.d((int) r7)
            com.bytedance.sdk.openadsdk.core.nativeexpress.e r5 = r0.u
            r5.a((java.util.Map<java.lang.String, java.lang.Object>) r3)
        L_0x0051:
            float r9 = r4.a
            float r10 = r4.b
            float r11 = r4.c
            float r12 = r4.d
            boolean r14 = r4.o
            android.util.SparseArray<com.bytedance.sdk.openadsdk.core.b.c$a> r3 = r4.n
            if (r3 == 0) goto L_0x0065
            int r5 = r3.size()
            if (r5 != 0) goto L_0x0067
        L_0x0065:
            android.util.SparseArray<com.bytedance.sdk.openadsdk.core.b.c$a> r3 = r0.Q
        L_0x0067:
            r13 = r3
            java.lang.String r3 = r4.k
            r5 = 0
            if (r1 != 0) goto L_0x006f
            r8 = r0
            goto L_0x0076
        L_0x006f:
            if (r1 == r0) goto L_0x0075
            org.json.JSONObject r5 = a((android.view.View) r24)
        L_0x0075:
            r8 = r1
        L_0x0076:
            if (r4 == 0) goto L_0x0082
            r4.l = r2
            if (r5 == 0) goto L_0x0082
            org.json.JSONObject r1 = r4.m
            if (r1 != 0) goto L_0x0082
            r4.m = r5
        L_0x0082:
            switch(r2) {
                case 1: goto L_0x0198;
                case 2: goto L_0x0167;
                case 3: goto L_0x014c;
                case 4: goto L_0x009f;
                case 5: goto L_0x0097;
                case 6: goto L_0x0092;
                case 7: goto L_0x0087;
                default: goto L_0x0085;
            }
        L_0x0085:
            goto L_0x01da
        L_0x0087:
            android.content.Context r1 = r0.f
            com.bytedance.sdk.openadsdk.core.model.n r2 = r0.i
            java.lang.String r3 = r0.g
            com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.a(r1, r2, r3)
            goto L_0x01da
        L_0x0092:
            r23.a()
            goto L_0x01da
        L_0x0097:
            boolean r1 = r0.p
            r1 = r1 ^ r6
            r0.a((boolean) r1)
            goto L_0x01da
        L_0x009f:
            android.widget.FrameLayout r1 = r0.j
            if (r1 == 0) goto L_0x00b6
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r15, r17, r19, r20, r21, r22)
            r1.dispatchTouchEvent(r2)
        L_0x00b6:
            com.bytedance.sdk.openadsdk.core.model.n r1 = r0.i
            if (r1 == 0) goto L_0x00c3
            int r1 = r1.h()
            if (r1 != r6) goto L_0x00c3
            if (r14 != 0) goto L_0x00c3
            return
        L_0x00c3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Creativity....mAdType="
            r1.append(r2)
            java.lang.String r2 = r0.g
            r1.append(r2)
            java.lang.String r2 = ",!mVideoPause="
            r1.append(r2)
            boolean r2 = r0.k
            r2 = r2 ^ r6
            r1.append(r2)
            java.lang.String r2 = "，isAutoPlay="
            r1.append(r2)
            com.bytedance.sdk.openadsdk.core.model.n r2 = r0.i
            boolean r2 = com.bytedance.sdk.openadsdk.l.y.b((com.bytedance.sdk.openadsdk.core.model.n) r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ClickCreativeListener"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r2, (java.lang.String) r1)
            java.lang.String r1 = r0.g
            java.lang.String r5 = "embeded_ad"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0127
            boolean r1 = r23.u()
            if (r1 == 0) goto L_0x0127
            boolean r1 = r0.k
            if (r1 != 0) goto L_0x0127
            com.bytedance.sdk.openadsdk.core.model.n r1 = r0.i
            boolean r1 = com.bytedance.sdk.openadsdk.l.y.b((com.bytedance.sdk.openadsdk.core.model.n) r1)
            if (r1 == 0) goto L_0x0127
            java.lang.String r1 = "Creative...."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r2, (java.lang.String) r1)
            com.bytedance.sdk.openadsdk.core.nativeexpress.d r1 = r0.t
            if (r1 == 0) goto L_0x013d
            r1.a(r4)
            com.bytedance.sdk.openadsdk.core.nativeexpress.d r1 = r0.t
            r1.a((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.nativeexpress.d r7 = r0.t
            r7.a(r8, r9, r10, r11, r12, r13, r14)
            goto L_0x013d
        L_0x0127:
            java.lang.String r1 = "normal...."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r2, (java.lang.String) r1)
            com.bytedance.sdk.openadsdk.core.nativeexpress.e r1 = r0.u
            if (r1 == 0) goto L_0x013d
            r1.a(r4)
            com.bytedance.sdk.openadsdk.core.nativeexpress.e r1 = r0.u
            r1.a((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.nativeexpress.e r7 = r0.u
            r7.a(r8, r9, r10, r11, r12, r13, r14)
        L_0x013d:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener r1 = r0.e
            if (r1 == 0) goto L_0x01da
            com.bytedance.sdk.openadsdk.core.model.n r2 = r0.i
            int r2 = r2.L()
            r1.onAdClicked(r0, r2)
            goto L_0x01da
        L_0x014c:
            com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract r1 = r0.d
            if (r1 == 0) goto L_0x0155
            r1.show()
            goto L_0x01da
        L_0x0155:
            com.bytedance.sdk.openadsdk.dislike.c r1 = r0.c
            if (r1 == 0) goto L_0x015e
            r1.showDislikeDialog()
            goto L_0x01da
        L_0x015e:
            com.bytedance.sdk.openadsdk.core.model.n r1 = r0.i
            java.lang.String r2 = r0.A
            com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.a((com.bytedance.sdk.openadsdk.core.model.n) r1, (java.lang.String) r2)
            goto L_0x01da
        L_0x0167:
            int r1 = r4.p
            if (r1 <= 0) goto L_0x016e
            com.bytedance.sdk.openadsdk.core.w.a(r6)
        L_0x016e:
            com.bytedance.sdk.openadsdk.core.nativeexpress.d r1 = r0.t
            if (r1 == 0) goto L_0x017f
            r1.a(r4)
            com.bytedance.sdk.openadsdk.core.nativeexpress.d r1 = r0.t
            r1.a((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.nativeexpress.d r7 = r0.t
            r7.a(r8, r9, r10, r11, r12, r13, r14)
        L_0x017f:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener r1 = r0.e
            if (r1 == 0) goto L_0x018c
            com.bytedance.sdk.openadsdk.core.model.n r2 = r0.i
            int r2 = r2.L()
            r1.onAdClicked(r0, r2)
        L_0x018c:
            r1 = 0
            com.bytedance.sdk.openadsdk.core.w.a(r1)
            com.bytedance.sdk.openadsdk.core.model.n r1 = r0.i
            r2 = 9
            com.bytedance.sdk.openadsdk.k.a.e.a((com.bytedance.sdk.openadsdk.core.model.n) r1, (int) r2)
            goto L_0x01da
        L_0x0198:
            android.widget.FrameLayout r1 = r0.j
            if (r1 == 0) goto L_0x01af
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r15, r17, r19, r20, r21, r22)
            r1.dispatchTouchEvent(r2)
        L_0x01af:
            com.bytedance.sdk.openadsdk.core.model.n r1 = r0.i
            if (r1 == 0) goto L_0x01bc
            int r1 = r1.h()
            if (r1 != r6) goto L_0x01bc
            if (r14 != 0) goto L_0x01bc
            return
        L_0x01bc:
            com.bytedance.sdk.openadsdk.core.nativeexpress.e r1 = r0.u
            if (r1 == 0) goto L_0x01cd
            r1.a(r4)
            com.bytedance.sdk.openadsdk.core.nativeexpress.e r1 = r0.u
            r1.a((java.lang.String) r3)
            com.bytedance.sdk.openadsdk.core.nativeexpress.e r7 = r0.u
            r7.a(r8, r9, r10, r11, r12, r13, r14)
        L_0x01cd:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener r1 = r0.e
            if (r1 == 0) goto L_0x01da
            com.bytedance.sdk.openadsdk.core.model.n r2 = r0.i
            int r2 = r2.L()
            r1.onAdClicked(r0, r2)
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.a(android.view.View, int, com.bytedance.sdk.component.adexpress.c):void");
    }

    public long getVideoProgress() {
        VastBannerBackupView vastBannerBackupView = this.W;
        if (vastBannerBackupView != null) {
            return vastBannerBackupView.getVideoProgress();
        }
        return 0;
    }

    public static JSONObject a(View view) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put(TtmlNode.LEFT, iArr[0]);
            jSONObject.put("top", iArr[1]);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean u() {
        return com.bytedance.sdk.openadsdk.core.model.n.c(this.i);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getAdSlotType() {
        /*
            r6 = this;
            java.lang.String r0 = r6.g
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 5
            switch(r1) {
                case -1695837674: goto L_0x004a;
                case -1364000502: goto L_0x0040;
                case -1263194568: goto L_0x0036;
                case -764631662: goto L_0x002c;
                case -712491894: goto L_0x0022;
                case 1844104722: goto L_0x0018;
                case 1912999166: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0054
        L_0x000e:
            java.lang.String r1 = "draw_ad"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0054
            r0 = r4
            goto L_0x0055
        L_0x0018:
            java.lang.String r1 = "interaction"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0054
            r0 = r5
            goto L_0x0055
        L_0x0022:
            java.lang.String r1 = "embeded_ad"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0054
            r0 = 0
            goto L_0x0055
        L_0x002c:
            java.lang.String r1 = "fullscreen_interstitial_ad"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0054
            r0 = r2
            goto L_0x0055
        L_0x0036:
            java.lang.String r1 = "open_ad"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0054
            r0 = 6
            goto L_0x0055
        L_0x0040:
            java.lang.String r1 = "rewarded_video"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0054
            r0 = r3
            goto L_0x0055
        L_0x004a:
            java.lang.String r1 = "banner_ad"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0054
            r0 = 4
            goto L_0x0055
        L_0x0054:
            r0 = -1
        L_0x0055:
            switch(r0) {
                case 0: goto L_0x0064;
                case 1: goto L_0x0061;
                case 2: goto L_0x005f;
                case 3: goto L_0x005c;
                case 4: goto L_0x005b;
                case 5: goto L_0x005a;
                case 6: goto L_0x0059;
                default: goto L_0x0058;
            }
        L_0x0058:
            return r5
        L_0x0059:
            return r2
        L_0x005a:
            return r3
        L_0x005b:
            return r4
        L_0x005c:
            r0 = 8
            return r0
        L_0x005f:
            r0 = 7
            return r0
        L_0x0061:
            r0 = 9
            return r0
        L_0x0064:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.getAdSlotType():int");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        t();
        v();
        com.bytedance.sdk.component.utils.l.e("webviewpool", "onAttachedToWindow+++");
        getViewTreeObserver().addOnScrollChangedListener(this.E);
        com.bytedance.sdk.openadsdk.core.h.d().a(this.A, this.B);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        t();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.bytedance.sdk.component.utils.l.e("webviewpool", "onFinishTemporaryDetach+++");
    }

    private void v() {
        List<i> list = this.L;
        if (list != null) {
            for (i next : list) {
                if (next != null) {
                    next.b();
                }
            }
        }
    }

    private void w() {
        List<i> list = this.L;
        if (list != null) {
            for (i next : list) {
                if (next != null) {
                    next.c();
                }
            }
        }
    }

    public void n() {
        n nVar = this.J;
        if (nVar != null && nVar.e() != null) {
            this.J.f();
        }
    }

    public void o() {
        try {
            if (this.D != null) {
                this.D.b();
            }
            r();
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            if (this.L != null) {
                for (i a2 : this.L) {
                    a2.a();
                }
            }
            com.bytedance.sdk.openadsdk.k.a.e.a(this.i);
            this.c = null;
            this.d = null;
            this.h = null;
            this.i = null;
            this.e = null;
            this.t = null;
            this.m = null;
            this.u = null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.c("NativeExpressView", "detach error", th);
        }
    }

    public void p() {
        try {
            if (this.j != null && this.j.getParent() != null) {
                removeView(this.j);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.l.a("NativeExpressView", "backupDestroy remove video container error", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.E);
        com.bytedance.sdk.openadsdk.core.h.d().f(this.A);
        w();
        com.bytedance.sdk.component.utils.l.e("webviewpool", "onDetachedFromWindow===");
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.bytedance.sdk.component.utils.l.e("webviewpool", "onStartTemporaryDetach===");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.bytedance.sdk.component.adexpress.b.d, com.bytedance.sdk.component.adexpress.b.d<? extends android.view.View>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bytedance.sdk.component.adexpress.b.d<? extends android.view.View> r5, com.bytedance.sdk.component.adexpress.b.m r6) {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.C
            r1 = 1
            r0.set(r1)
            r4.s = r5
            int r0 = r5.c()
            r2 = 3
            r3 = 0
            if (r0 != r2) goto L_0x001d
            com.bytedance.sdk.openadsdk.core.model.n r0 = r4.i
            int r0 = r0.f()
            if (r0 != r1) goto L_0x001d
            com.bytedance.sdk.openadsdk.core.model.n r0 = r4.i
            r0.b((int) r3)
        L_0x001d:
            int r0 = r5.c()
            r1 = 2
            if (r0 == r1) goto L_0x0030
            int r0 = r5.c()
            if (r0 == 0) goto L_0x0030
            int r0 = r5.c()
            if (r0 != r2) goto L_0x007a
        L_0x0030:
            android.view.View r0 = r5.e()
            android.view.ViewParent r1 = r0.getParent()
            if (r1 == 0) goto L_0x0043
            android.view.ViewParent r1 = r0.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r1.removeView(r0)
        L_0x0043:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = r3
        L_0x0049:
            int r2 = r4.getChildCount()
            if (r1 >= r2) goto L_0x0059
            android.view.View r2 = r4.getChildAt(r1)
            r0.add(r2)
            int r1 = r1 + 1
            goto L_0x0049
        L_0x0059:
            int r1 = r0.size()
            if (r3 >= r1) goto L_0x0073
            java.lang.Object r1 = r0.get(r3)
            boolean r1 = r1 instanceof com.bytedance.sdk.component.widget.SSWebView
            if (r1 == 0) goto L_0x0070
            java.lang.Object r1 = r0.get(r3)
            android.view.View r1 = (android.view.View) r1
            r4.removeView(r1)
        L_0x0070:
            int r3 = r3 + 1
            goto L_0x0059
        L_0x0073:
            android.view.View r5 = r5.e()
            r4.addView(r5)
        L_0x007a:
            com.bytedance.sdk.component.adexpress.b.h r5 = r4.O
            if (r5 == 0) goto L_0x0083
            com.bytedance.sdk.openadsdk.core.nativeexpress.h r5 = (com.bytedance.sdk.openadsdk.core.nativeexpress.h) r5
            r5.i()
        L_0x0083:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener r5 = r4.e
            if (r5 == 0) goto L_0x0094
            double r0 = r6.b()
            float r0 = (float) r0
            double r1 = r6.c()
            float r6 = (float) r1
            r5.onRenderSuccess(r4, r0, r6)
        L_0x0094:
            com.bytedance.sdk.openadsdk.core.model.n r5 = r4.i
            int r6 = r4.getDynamicShowType()
            com.bytedance.sdk.openadsdk.k.a.e.a(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.a(com.bytedance.sdk.component.adexpress.b.d, com.bytedance.sdk.component.adexpress.b.m):void");
    }

    public void a_(int i2) {
        h hVar = this.O;
        if (hVar != null) {
            if (!this.a) {
                hVar.f();
            }
            this.O.g();
            ((h) this.O).i();
        }
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.e;
        if (pAGBannerAdWrapperListener != null) {
            pAGBannerAdWrapperListener.onRenderFail(this, com.bytedance.sdk.openadsdk.core.g.a(i2), i2);
        }
    }

    public boolean q() {
        d<? extends View> dVar = this.s;
        return dVar != null && dVar.c() == 1;
    }

    public int getDynamicShowType() {
        d<? extends View> dVar = this.s;
        if (dVar != null) {
            return dVar.c();
        }
        return 0;
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.x).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.y).intValue();
    }

    public u getJsObject() {
        n nVar = this.J;
        if (nVar != null) {
            return nVar.p();
        }
        return null;
    }

    private boolean x() {
        return TextUtils.equals(this.g, "fullscreen_interstitial_ad") || TextUtils.equals(this.g, "rewarded_video") || TextUtils.equals("open_ad", this.g) || n.b(this.g);
    }

    public void a(CharSequence charSequence, int i2, int i3, boolean z2) {
        b(Integer.parseInt(String.valueOf(charSequence)), i2);
    }

    public void setSoundMute(boolean z2) {
        this.p = z2;
        b bVar = this.r;
        if (bVar != null && bVar.d() != null) {
            this.r.d().setSoundMute(z2);
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3) {
        int i4;
        if (TextUtils.equals(this.g, "fullscreen_interstitial_ad")) {
            i4 = com.bytedance.sdk.openadsdk.core.m.d().o(this.w);
        } else if (TextUtils.equals(this.g, "rewarded_video")) {
            i4 = com.bytedance.sdk.openadsdk.core.m.d().h(this.w);
        } else if (TextUtils.equals(this.g, "open_ad")) {
            i4 = com.bytedance.sdk.openadsdk.core.m.d().s(this.w);
        } else {
            return;
        }
        if (i4 < 0) {
            i4 = 5;
        }
        int i5 = (i3 >= i4 || d() == 5) ? 1 : 0;
        int i6 = i3 <= i4 ? i4 - i3 : 0;
        b bVar = this.r;
        if (bVar != null && bVar.d() != null) {
            this.r.d().a(String.valueOf(i2), i5, i6, false);
        }
    }

    public void r() {
        com.bytedance.sdk.openadsdk.core.model.n nVar = this.i;
        if (nVar != null && nVar.ax() != null && this.i.ax().a() != null) {
            this.i.ax().a().e(getVideoProgress());
        }
    }

    public void setVastVideoHelper(VastBannerBackupView vastBannerBackupView) {
        this.W = vastBannerBackupView;
    }
}
