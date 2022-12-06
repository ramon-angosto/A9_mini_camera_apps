package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.work.PeriodicWorkRequest;
import com.adcolony.adcolonysdk.BuildConfig;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.o;
import com.adcolony.sdk.s;
import com.adcolony.sdk.v;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.iab.omid.library.adcolony.Omid;
import com.iab.omid.library.adcolony.adsession.Partner;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

class k {
    static String Z = "https://adc3-launch.adcolony.com/v4/launch";
    private static volatile String a0 = "";
    private boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    private boolean C;
    /* access modifiers changed from: private */
    public f D = new f();
    /* access modifiers changed from: private */
    public boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    /* access modifiers changed from: private */
    public boolean J;
    /* access modifiers changed from: private */
    public boolean K;
    /* access modifiers changed from: private */
    public boolean L;
    private int M;
    private int N = 1;
    private Application.ActivityLifecycleCallbacks O;
    /* access modifiers changed from: private */
    public Partner P = null;
    /* access modifiers changed from: private */
    public f1 Q = new f1();
    private long R = 500;
    private long S = 500;
    private boolean T;
    private long U = 20000;
    private long V = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    private long W = 15000;
    private int X;
    /* access modifiers changed from: private */
    public boolean Y = false;
    private i0 a;
    /* access modifiers changed from: private */
    public t b;
    /* access modifiers changed from: private */
    public t0 c;
    private d d;
    /* access modifiers changed from: private */
    public r e;
    private w f;
    private x0 g;
    private v0 h;
    private g0 i;
    private q j;
    private m0 k;
    private c l;
    /* access modifiers changed from: private */
    public z m;
    private AdColonyAdView n;
    private AdColonyInterstitial o;
    /* access modifiers changed from: private */
    public AdColonyRewardListener p;
    private HashMap<String, AdColonyCustomMessageListener> q = new HashMap<>();
    /* access modifiers changed from: private */
    public AdColonyAppOptions r;
    /* access modifiers changed from: private */
    public h0 s;
    private f1 t;
    private HashMap<String, AdColonyZone> u = new HashMap<>();
    /* access modifiers changed from: private */
    public HashMap<Integer, c1> v = new HashMap<>();
    private String w;
    private String x;
    private String y;
    private String z = "";

    class a implements j0 {
        a(k kVar) {
        }

        public void a(h0 h0Var) {
            f1 b = c0.b();
            c0.b(b, "crc32", z0.a(c0.h(h0Var.a(), DataSchemeDataSource.SCHEME_DATA)));
            h0Var.a(b).c();
        }
    }

    class a0 implements j0 {
        a0() {
        }

        public void a(h0 h0Var) {
            boolean unused = k.this.a(true, true);
        }
    }

    class b implements j0 {
        b(k kVar) {
        }

        public void a(h0 h0Var) {
            int d = c0.d(h0Var.a(), "number");
            f1 b = c0.b();
            c0.a(b, "uuids", z0.a(d));
            h0Var.a(b).c();
        }
    }

    class b0 implements j0 {
        b0(k kVar) {
        }

        public void a(h0 h0Var) {
            f1 b = c0.b();
            c0.a(b, "sha1", z0.b(c0.h(h0Var.a(), DataSchemeDataSource.SCHEME_DATA)));
            h0Var.a(b).c();
        }
    }

    class c implements j0 {

        class a implements y<String> {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void a(String str) {
                f1 b2 = c0.b();
                c0.a(b2, "advertiser_id", k.this.n().f());
                c0.b(b2, "limit_ad_tracking", k.this.n().A());
                this.a.a(b2).c();
            }

            public void a(Throwable th) {
                new e0.a().a("Device.query_advertiser_info").a(" failed with error: ").a(Log.getStackTraceString(th)).a(e0.g);
            }
        }

        c() {
        }

        public void a(h0 h0Var) {
            k.this.n().a(a.a(), new a(h0Var));
        }
    }

    class d implements j0 {
        d() {
        }

        public void a(h0 h0Var) {
            s0 a2 = k.this.q().a();
            k.this.n().c(c0.h(h0Var.a(), "version"));
            if (a2 != null) {
                a2.e(k.this.n().o());
            }
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            f1 unused = k.this.Q = c0.f(h0Var.a(), "signals");
        }
    }

    class f implements j0 {

        class a implements x<o.b> {
            final /* synthetic */ h0 a;

            a(f fVar, h0 h0Var) {
                this.a = h0Var;
            }

            public void a(o.b bVar) {
                f1 b = c0.b();
                if (bVar != null) {
                    c0.a(b, "odt", bVar.b());
                }
                this.a.a(b).c();
            }
        }

        f() {
        }

        public void a(h0 h0Var) {
            if (k.this.G()) {
                o0.c().a((x<o.b>) new a(this, h0Var), k.this.g());
                return;
            }
            o.b b = o0.c().b();
            f1 b2 = c0.b();
            if (b != null) {
                c0.a(b2, "odt", b.b());
            }
            h0Var.a(b2).c();
        }
    }

    class g implements j0 {
        g(k kVar) {
        }

        public void a(h0 h0Var) {
            o0.c().a();
        }
    }

    class h implements j0 {
        h() {
        }

        public void a(h0 h0Var) {
            k.this.m.a(h0Var);
        }
    }

    class i implements Runnable {
        i() {
        }

        public void run() {
            Context a2 = a.a();
            if (!k.this.L && a2 != null) {
                try {
                    Omid.activate(a2.getApplicationContext());
                    boolean unused = k.this.L = true;
                } catch (IllegalArgumentException unused2) {
                    new e0.a().a("IllegalArgumentException when activating Omid").a(e0.i);
                    boolean unused3 = k.this.L = false;
                }
            }
            if (k.this.L && k.this.P == null) {
                try {
                    Partner unused4 = k.this.P = Partner.createPartner("AdColony", "4.8.0");
                } catch (IllegalArgumentException unused5) {
                    new e0.a().a("IllegalArgumentException when creating Omid Partner").a(e0.i);
                    boolean unused6 = k.this.L = false;
                }
            }
        }
    }

    class j implements Runnable {

        class a implements s.a {
            a() {
            }

            public void a(s sVar, h0 h0Var, Map<String, List<String>> map) {
                k.this.a(sVar);
            }
        }

        j() {
        }

        public void run() {
            f1 b = c0.b();
            c0.a(b, "url", k.Z);
            c0.a(b, "content_type", "application/json");
            c0.a(b, "content", k.this.n().t().toString());
            c0.a(b, "url", k.Z);
            if (k.this.Y) {
                f1 b2 = c0.b();
                c0.a(b2, "request", BuildConfig.LAUNCH_REQ_DICT_ID);
                c0.a(b2, "response", BuildConfig.LAUNCH_RESP_DICT_ID);
                c0.a(b, "dictionaries_mapping", b2);
            }
            k.this.b.a(new s(new h0("WebServices.post", 0, b), new a()));
        }
    }

    /* renamed from: com.adcolony.sdk.k$k  reason: collision with other inner class name */
    class C0007k implements v.c {
        C0007k(k kVar) {
        }

        public void a() {
            o0.c().d();
        }
    }

    class l implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ h0 b;

        l(Context context, h0 h0Var) {
            this.a = context;
            this.b = h0Var;
        }

        public void run() {
            j a2 = j.a(this.a.getApplicationContext(), this.b);
            k.this.v.put(Integer.valueOf(a2.getAdc3ModuleId()), a2);
        }
    }

    class m implements Runnable {
        m() {
        }

        public void run() {
            if (a.b().x().f()) {
                k.this.K();
            }
        }
    }

    class n implements s.a {
        n() {
        }

        public void a(s sVar, h0 h0Var, Map<String, List<String>> map) {
            k.this.N();
        }
    }

    class o implements Runnable {
        o() {
        }

        public void run() {
            boolean unused = k.this.L();
        }
    }

    class p implements AdColonyInterstitial.f {
        p() {
        }

        public void a() {
            k.this.b();
        }
    }

    class q implements AdColonyAdView.c {
        q() {
        }

        public void a() {
            k.this.b();
        }
    }

    class r implements x<n0> {
        r(k kVar) {
        }

        public void a(n0 n0Var) {
            o0.c().a(n0Var);
        }
    }

    class s implements Runnable {
        final /* synthetic */ h0 a;

        s(h0 h0Var) {
            this.a = h0Var;
        }

        public void run() {
            k.this.p.onReward(new AdColonyReward(this.a));
        }
    }

    class t implements Application.ActivityLifecycleCallbacks {
        private final Set<Integer> a = new HashSet();

        t() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (!k.this.c.f()) {
                k.this.c.c(true);
            }
            a.a((Context) activity);
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            a.d = false;
            k.this.c.d(false);
        }

        public void onActivityResumed(Activity activity) {
            ScheduledExecutorService scheduledExecutorService;
            this.a.add(Integer.valueOf(activity.hashCode()));
            a.d = true;
            a.a((Context) activity);
            s0 a2 = k.this.q().a();
            Context a3 = a.a();
            if (a3 == null || !k.this.c.e() || !(a3 instanceof b) || ((b) a3).d) {
                a.a((Context) activity);
                if (k.this.s != null) {
                    if (!Objects.equals(c0.h(k.this.s.a(), "m_origin"), "")) {
                        k.this.s.a(k.this.s.a()).c();
                    }
                    h0 unused = k.this.s = null;
                }
                boolean unused2 = k.this.B = false;
                k.this.c.g(false);
                if (k.this.E && !k.this.c.f()) {
                    k.this.c.c(true);
                }
                k.this.c.d(true);
                k.this.e.c();
                if (a2 == null || (scheduledExecutorService = a2.b) == null || scheduledExecutorService.isShutdown() || a2.b.isTerminated()) {
                    AdColony.a((Context) activity, a.b().r);
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            k.this.c.e(true);
        }

        public void onActivityStopped(Activity activity) {
            this.a.remove(Integer.valueOf(activity.hashCode()));
            if (this.a.isEmpty()) {
                k.this.c.e(false);
            }
        }
    }

    class u implements j0 {
        u() {
        }

        public void a(h0 h0Var) {
            boolean unused = k.this.c(h0Var);
        }
    }

    class v implements j0 {
        v() {
        }

        public void a(h0 h0Var) {
            k.this.a(h0Var);
        }
    }

    class w implements j0 {
        w() {
        }

        public void a(h0 h0Var) {
            s0 a2 = k.this.q().a();
            k.this.D.a(true);
            if (k.this.J) {
                f1 b = c0.b();
                f1 b2 = c0.b();
                c0.a(b2, "app_version", z0.c());
                c0.a(b, "app_bundle_info", b2);
                new h0("AdColony.on_update", 1, b).c();
                boolean unused = k.this.J = false;
            }
            if (k.this.K) {
                new h0("AdColony.on_install", 1).c();
            }
            f1 a3 = h0Var.a();
            if (a2 != null) {
                a2.f(c0.h(a3, "app_session_id"));
            }
            if (AdColonyEventTracker.a()) {
                AdColonyEventTracker.b();
            }
            Integer i = a3.i("base_download_threads");
            if (i != null) {
                k.this.b.a(i.intValue());
            }
            Integer i2 = a3.i("concurrent_requests");
            if (i2 != null) {
                k.this.b.b(i2.intValue());
            }
            Integer i3 = a3.i("threads_keep_alive_time");
            if (i3 != null) {
                k.this.b.c(i3.intValue());
            }
            double h = a3.h("thread_pool_scaling_factor");
            if (!Double.isNaN(h)) {
                k.this.b.a(h);
            }
            k.this.m.b();
            k.this.M();
        }
    }

    class x implements j0 {
        x() {
        }

        public void a(h0 h0Var) {
            k.this.b(h0Var);
        }
    }

    class y implements j0 {
        y() {
        }

        public void a(h0 h0Var) {
            k.this.e(h0Var);
        }
    }

    class z implements j0 {
        z() {
        }

        public void a(h0 h0Var) {
            k.this.f(h0Var);
        }
    }

    k() {
    }

    /* access modifiers changed from: private */
    public void K() {
        new Thread(new j()).start();
    }

    /* access modifiers changed from: private */
    public boolean L() {
        this.a.a();
        return true;
    }

    /* access modifiers changed from: private */
    public void M() {
        f1 b2 = c0.b();
        c0.a(b2, "type", "AdColony.on_configuration_completed");
        e1 e1Var = new e1();
        for (String b3 : C().keySet()) {
            e1Var.b(b3);
        }
        f1 b4 = c0.b();
        c0.a(b4, AdColonyAdapterUtils.KEY_ZONE_IDS, e1Var);
        c0.a(b2, "message", b4);
        new h0("CustomMessage.controller_send", 0, b2).c();
    }

    /* access modifiers changed from: private */
    public void N() {
        if (a(this.x) || l.H) {
            if (!this.F && !this.I) {
                z0.b((Runnable) new o());
            }
            if (this.F && this.I) {
                Q();
                return;
            }
            return;
        }
        new e0.a().a("Downloaded controller sha1 does not match, retrying.").a(e0.f);
        S();
    }

    private void O() {
        Application application;
        Context a2 = a.a();
        if (a2 != null && this.O == null && Build.VERSION.SDK_INT > 14) {
            this.O = new t();
            if (a2 instanceof Application) {
                application = (Application) a2;
            } else {
                application = ((Activity) a2).getApplication();
            }
            application.registerActivityLifecycleCallbacks(this.O);
        }
    }

    private void S() {
        if (a.b().x().f()) {
            int i2 = this.M + 1;
            this.M = i2;
            this.N = Math.min(this.N * i2, 120);
            z0.a((Runnable) new m(), ((long) this.N) * 1000);
            return;
        }
        new e0.a().a("Max launch server download attempts hit, or AdColony is no longer").a(" active.").a(e0.g);
    }

    /* access modifiers changed from: package-private */
    public x0 A() {
        if (this.g == null) {
            x0 x0Var = new x0();
            this.g = x0Var;
            x0Var.a();
        }
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, c1> B() {
        return this.v;
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, AdColonyZone> C() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return this.r != null;
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        return this.B;
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return this.T;
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        return this.D.a();
    }

    /* access modifiers changed from: package-private */
    public boolean J() {
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public void P() {
        this.D.a(false);
        this.d.b();
        Object option = this.r.getOption("force_ad_id");
        if ((option instanceof String) && !((String) option).isEmpty()) {
            R();
        }
        AdColony.a(a.a(), this.r);
        T();
        this.u.clear();
        this.a.a();
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        this.X = 0;
        for (AdColonyInterstitial next : this.d.f().values()) {
            if (next.m()) {
                this.X++;
                next.a((AdColonyInterstitial.f) new p());
            }
        }
        for (AdColonyAdView onDestroyListenerOrCall : this.d.d().values()) {
            this.X++;
            onDestroyListenerOrCall.setOnDestroyListenerOrCall(new q());
        }
        if (this.X == 0) {
            P();
        }
    }

    /* access modifiers changed from: package-private */
    public void R() {
        synchronized (this.d.f()) {
            for (AdColonyInterstitial p2 : this.d.f().values()) {
                p2.p();
            }
            this.d.f().clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void T() {
        a(1);
        for (c1 b2 : this.v.values()) {
            this.a.b((k0) b2);
        }
        this.v.clear();
    }

    /* access modifiers changed from: package-private */
    public AdColonyAppOptions u() {
        if (this.r == null) {
            this.r = new AdColonyAppOptions();
        }
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public String v() {
        return a0;
    }

    /* access modifiers changed from: package-private */
    public AdColonyRewardListener w() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public t0 x() {
        if (this.c == null) {
            t0 t0Var = new t0();
            this.c = t0Var;
            t0Var.d();
        }
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public long y() {
        return this.R;
    }

    /* access modifiers changed from: package-private */
    public v0 z() {
        if (this.h == null) {
            v0 v0Var = new v0();
            this.h = v0Var;
            v0Var.e();
        }
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public long g() {
        return this.S;
    }

    /* access modifiers changed from: package-private */
    public long h() {
        return this.V;
    }

    /* access modifiers changed from: package-private */
    public long i() {
        return this.W;
    }

    /* access modifiers changed from: package-private */
    public AdColonyInterstitial j() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public AdColonyAdView k() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public c l() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, AdColonyCustomMessageListener> m() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public q n() {
        if (this.j == null) {
            q qVar = new q();
            this.j = qVar;
            qVar.M();
        }
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public r o() {
        if (this.e == null) {
            this.e = new r();
        }
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public w p() {
        if (this.f == null) {
            w wVar = new w();
            this.f = wVar;
            wVar.b();
        }
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public g0 q() {
        if (this.i == null) {
            g0 g0Var = new g0();
            this.i = g0Var;
            g0Var.c();
        }
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public i0 r() {
        if (this.a == null) {
            i0 i0Var = new i0();
            this.a = i0Var;
            i0Var.a();
        }
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public m0 s() {
        if (this.k == null) {
            this.k = new m0();
        }
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public Partner t() {
        return this.P;
    }

    /* access modifiers changed from: private */
    public void f(h0 h0Var) {
        AdColonyZone adColonyZone;
        if (!this.C) {
            String h2 = c0.h(h0Var.a(), AdColonyAdapterUtils.KEY_ZONE_ID);
            if (this.u.containsKey(h2)) {
                adColonyZone = this.u.get(h2);
            } else {
                AdColonyZone adColonyZone2 = new AdColonyZone(h2);
                this.u.put(h2, adColonyZone2);
                adColonyZone = adColonyZone2;
            }
            adColonyZone.a(h0Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(h0 h0Var) {
        this.s = h0Var;
    }

    /* access modifiers changed from: package-private */
    public boolean e(h0 h0Var) {
        if (this.p == null) {
            return false;
        }
        z0.b((Runnable) new s(h0Var));
        return true;
    }

    /* access modifiers changed from: private */
    public boolean c(h0 h0Var) {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        try {
            int j2 = h0Var.a().j("id");
            if (j2 > 0) {
                a(j2);
            }
            z0.b((Runnable) new l(a2, h0Var));
            return true;
        } catch (RuntimeException e2) {
            e0.a aVar = new e0.a();
            aVar.a(e2.toString() + ": during WebView initialization.").a(" Disabling AdColony.").a(e0.h);
            AdColony.disable();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.D.a(false);
        this.C = z2;
    }

    /* access modifiers changed from: package-private */
    public void d(boolean z2) {
        this.E = z2;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.U;
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z2) {
        this.A = z2;
    }

    /* access modifiers changed from: package-private */
    public f1 e() {
        return this.Q;
    }

    /* access modifiers changed from: private */
    public void b(h0 h0Var) {
        f1 b2 = this.r.b();
        c0.a(b2, "app_id", this.r.a());
        f1 b3 = c0.b();
        c0.a(b3, "options", b2);
        h0Var.a(b3).c();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.adcolony.sdk.AdColonyAppOptions r5, boolean r6) {
        /*
            r4 = this;
            r4.C = r6
            r4.r = r5
            com.adcolony.sdk.i0 r0 = new com.adcolony.sdk.i0
            r0.<init>()
            r4.a = r0
            com.adcolony.sdk.m r0 = new com.adcolony.sdk.m
            r0.<init>()
            com.adcolony.sdk.q r0 = new com.adcolony.sdk.q
            r0.<init>()
            r4.j = r0
            r0.M()
            com.adcolony.sdk.t r0 = new com.adcolony.sdk.t
            r0.<init>()
            r4.b = r0
            r0.a()
            com.adcolony.sdk.t0 r0 = new com.adcolony.sdk.t0
            r0.<init>()
            r4.c = r0
            r0.d()
            com.adcolony.sdk.d r0 = new com.adcolony.sdk.d
            r0.<init>()
            r4.d = r0
            r0.h()
            com.adcolony.sdk.r r0 = new com.adcolony.sdk.r
            r0.<init>()
            r4.e = r0
            com.adcolony.sdk.w r0 = new com.adcolony.sdk.w
            r0.<init>()
            r4.f = r0
            r0.b()
            com.adcolony.sdk.g0 r0 = new com.adcolony.sdk.g0
            r0.<init>()
            r4.i = r0
            r0.c()
            com.adcolony.sdk.v0 r0 = new com.adcolony.sdk.v0
            r0.<init>()
            r4.h = r0
            r0.e()
            com.adcolony.sdk.x0 r0 = new com.adcolony.sdk.x0
            r0.<init>()
            r4.g = r0
            r0.a()
            com.adcolony.sdk.m0 r0 = new com.adcolony.sdk.m0
            r0.<init>()
            r4.k = r0
            com.adcolony.sdk.z r0 = new com.adcolony.sdk.z
            r0.<init>()
            r4.m = r0
            com.adcolony.sdk.m0 r0 = r4.k
            r0.b()
            android.content.Context r0 = com.adcolony.sdk.a.a()
            com.adcolony.sdk.AdColony.a((android.content.Context) r0, (com.adcolony.sdk.AdColonyAppOptions) r5)
            r5 = 0
            r0 = 1
            if (r6 != 0) goto L_0x0135
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.adcolony.sdk.v0 r2 = r4.h
            java.lang.String r2 = r2.a()
            r1.append(r2)
            java.lang.String r2 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.<init>(r1)
            boolean r6 = r6.exists()
            r4.G = r6
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.adcolony.sdk.v0 r3 = r4.h
            java.lang.String r3 = r3.a()
            r1.append(r3)
            java.lang.String r3 = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r6.<init>(r1)
            boolean r6 = r6.exists()
            r4.H = r6
            boolean r1 = r4.G
            if (r1 == 0) goto L_0x00fc
            if (r6 == 0) goto L_0x00fc
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.adcolony.sdk.v0 r1 = r4.h
            java.lang.String r1 = r1.a()
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.adcolony.sdk.f1 r6 = com.adcolony.sdk.c0.c(r6)
            java.lang.String r1 = "sdkVersion"
            java.lang.String r6 = com.adcolony.sdk.c0.h(r6, r1)
            com.adcolony.sdk.q r1 = r4.j
            java.lang.String r1 = r1.I()
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x00fc
            r6 = r0
            goto L_0x00fd
        L_0x00fc:
            r6 = r5
        L_0x00fd:
            r4.F = r6
            com.adcolony.sdk.v r6 = com.adcolony.sdk.v.a()
            com.adcolony.sdk.k$k r1 = new com.adcolony.sdk.k$k
            r1.<init>(r4)
            r6.a((com.adcolony.sdk.v.c) r1)
            boolean r6 = r4.G
            if (r6 == 0) goto L_0x012d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.adcolony.sdk.v0 r1 = r4.h
            java.lang.String r1 = r1.a()
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.adcolony.sdk.f1 r6 = com.adcolony.sdk.c0.c(r6)
            r4.t = r6
            r4.b((com.adcolony.sdk.f1) r6)
        L_0x012d:
            boolean r6 = r4.F
            r4.a((boolean) r6)
            r4.O()
        L_0x0135:
            com.adcolony.sdk.k$u r6 = new com.adcolony.sdk.k$u
            r6.<init>()
            java.lang.String r1 = "Module.load"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$v r6 = new com.adcolony.sdk.k$v
            r6.<init>()
            java.lang.String r1 = "Module.unload"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$w r6 = new com.adcolony.sdk.k$w
            r6.<init>()
            java.lang.String r1 = "AdColony.on_configured"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$x r6 = new com.adcolony.sdk.k$x
            r6.<init>()
            java.lang.String r1 = "AdColony.get_app_info"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$y r6 = new com.adcolony.sdk.k$y
            r6.<init>()
            java.lang.String r1 = "AdColony.v4vc_reward"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$z r6 = new com.adcolony.sdk.k$z
            r6.<init>()
            java.lang.String r1 = "AdColony.zone_info"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$a0 r6 = new com.adcolony.sdk.k$a0
            r6.<init>()
            java.lang.String r1 = "AdColony.probe_launch_server"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$b0 r6 = new com.adcolony.sdk.k$b0
            r6.<init>(r4)
            java.lang.String r1 = "Crypto.sha1"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$a r6 = new com.adcolony.sdk.k$a
            r6.<init>(r4)
            java.lang.String r1 = "Crypto.crc32"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$b r6 = new com.adcolony.sdk.k$b
            r6.<init>(r4)
            java.lang.String r1 = "Crypto.uuid"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$c r6 = new com.adcolony.sdk.k$c
            r6.<init>()
            java.lang.String r1 = "Device.query_advertiser_info"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$d r6 = new com.adcolony.sdk.k$d
            r6.<init>()
            java.lang.String r1 = "AdColony.controller_version"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$e r6 = new com.adcolony.sdk.k$e
            r6.<init>()
            java.lang.String r1 = "AdColony.provide_signals"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$f r6 = new com.adcolony.sdk.k$f
            r6.<init>()
            java.lang.String r1 = "AdColony.odt_calculate"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$g r6 = new com.adcolony.sdk.k$g
            r6.<init>(r4)
            java.lang.String r1 = "AdColony.odt_cache"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.k$h r6 = new com.adcolony.sdk.k$h
            r6.<init>()
            java.lang.String r1 = "AdColony.heartbeat"
            com.adcolony.sdk.a.a((java.lang.String) r1, (com.adcolony.sdk.j0) r6)
            com.adcolony.sdk.v0 r6 = r4.h
            int r6 = com.adcolony.sdk.z0.b((com.adcolony.sdk.v0) r6)
            if (r6 != r0) goto L_0x01df
            r1 = r0
            goto L_0x01e0
        L_0x01df:
            r1 = r5
        L_0x01e0:
            r4.J = r1
            r1 = 2
            if (r6 != r1) goto L_0x01e6
            r5 = r0
        L_0x01e6:
            r4.K = r5
            com.adcolony.sdk.k$i r5 = new com.adcolony.sdk.k$i
            r5.<init>()
            com.adcolony.sdk.z0.b((java.lang.Runnable) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.k.a(com.adcolony.sdk.AdColonyAppOptions, boolean):void");
    }

    /* access modifiers changed from: private */
    public void b() {
        int i2 = this.X - 1;
        this.X = i2;
        if (i2 == 0) {
            P();
        }
    }

    private void b(f1 f1Var) {
        if (!l.H) {
            f1 f2 = c0.f(f1Var, RequestParameters.SUBRESOURCE_LOGGING);
            g0.h = c0.a(f2, "send_level", 1);
            g0.f = c0.b(f2, "log_private");
            g0.g = c0.a(f2, "print_level", 3);
            this.i.b(c0.a(f2, "modules"));
            this.i.c(c0.e(f2, "included_fields"));
        }
        f1 f3 = c0.f(f1Var, TtmlNode.TAG_METADATA);
        n().a(f3);
        x().a(c0.d(f3, "session_timeout"));
        a0 = c0.h(f1Var, "pie");
        this.z = c0.h(c0.f(f1Var, "controller"), "version");
        this.R = c0.a(f3, "signals_timeout", this.R);
        this.S = c0.a(f3, "calculate_odt_timeout", this.S);
        this.T = c0.a(f3, "async_odt_query", this.T);
        this.U = c0.a(f3, "ad_request_timeout", this.U);
        this.V = c0.a(f3, "controller_heartbeat_interval", this.V);
        this.W = c0.a(f3, "controller_heartbeat_timeout", this.W);
        this.Y = c0.a(f3, "enable_compression", false);
        v.a().a(f3.n("odt_config"), (x<n0>) new r(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        new java.io.File(r3.h.a() + "026ae9c9824b3e483fa6c71fa88f57ae27816141").delete();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(com.adcolony.sdk.f1 r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "controller"
            com.adcolony.sdk.f1 r1 = com.adcolony.sdk.c0.f(r4, r1)     // Catch:{ Exception -> 0x002f }
            java.lang.String r2 = "url"
            java.lang.String r2 = com.adcolony.sdk.c0.h(r1, r2)     // Catch:{ Exception -> 0x002f }
            r3.w = r2     // Catch:{ Exception -> 0x002f }
            java.lang.String r2 = "sha1"
            java.lang.String r1 = com.adcolony.sdk.c0.h(r1, r2)     // Catch:{ Exception -> 0x002f }
            r3.x = r1     // Catch:{ Exception -> 0x002f }
            java.lang.String r1 = "status"
            java.lang.String r1 = com.adcolony.sdk.c0.h(r4, r1)     // Catch:{ Exception -> 0x002f }
            r3.y = r1     // Catch:{ Exception -> 0x002f }
            r3.b((com.adcolony.sdk.f1) r4)     // Catch:{ Exception -> 0x002f }
            boolean r4 = com.adcolony.sdk.AdColonyEventTracker.a()     // Catch:{ Exception -> 0x002f }
            if (r4 == 0) goto L_0x004e
            com.adcolony.sdk.AdColonyEventTracker.b()     // Catch:{ Exception -> 0x002f }
            goto L_0x004e
        L_0x002f:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x004e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004e }
            r1.<init>()     // Catch:{ Exception -> 0x004e }
            com.adcolony.sdk.v0 r2 = r3.h     // Catch:{ Exception -> 0x004e }
            java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x004e }
            r1.append(r2)     // Catch:{ Exception -> 0x004e }
            java.lang.String r2 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r1.append(r2)     // Catch:{ Exception -> 0x004e }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x004e }
            r4.<init>(r1)     // Catch:{ Exception -> 0x004e }
            r4.delete()     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            java.lang.String r4 = r3.y
            java.lang.String r1 = "disable"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0095
            boolean r4 = com.adcolony.sdk.l.H
            if (r4 != 0) goto L_0x0095
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x007b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007b }
            r1.<init>()     // Catch:{ Exception -> 0x007b }
            com.adcolony.sdk.v0 r2 = r3.h     // Catch:{ Exception -> 0x007b }
            java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x007b }
            r1.append(r2)     // Catch:{ Exception -> 0x007b }
            java.lang.String r2 = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5"
            r1.append(r2)     // Catch:{ Exception -> 0x007b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x007b }
            r4.<init>(r1)     // Catch:{ Exception -> 0x007b }
            r4.delete()     // Catch:{ Exception -> 0x007b }
        L_0x007b:
            com.adcolony.sdk.e0$a r4 = new com.adcolony.sdk.e0$a
            r4.<init>()
            java.lang.String r1 = "Launch server response with disabled status. Disabling AdColony "
            com.adcolony.sdk.e0$a r4 = r4.a((java.lang.String) r1)
            java.lang.String r1 = "until next launch."
            com.adcolony.sdk.e0$a r4 = r4.a((java.lang.String) r1)
            com.adcolony.sdk.e0 r1 = com.adcolony.sdk.e0.g
            r4.a((com.adcolony.sdk.e0) r1)
            com.adcolony.sdk.AdColony.disable()
            return r0
        L_0x0095:
            java.lang.String r4 = r3.w
            java.lang.String r1 = ""
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x00a7
            java.lang.String r4 = r3.y
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x00c2
        L_0x00a7:
            boolean r4 = com.adcolony.sdk.l.H
            if (r4 != 0) goto L_0x00c2
            com.adcolony.sdk.e0$a r4 = new com.adcolony.sdk.e0$a
            r4.<init>()
            java.lang.String r1 = "Missing controller status or URL. Disabling AdColony until next "
            com.adcolony.sdk.e0$a r4 = r4.a((java.lang.String) r1)
            java.lang.String r1 = "launch."
            com.adcolony.sdk.e0$a r4 = r4.a((java.lang.String) r1)
            com.adcolony.sdk.e0 r1 = com.adcolony.sdk.e0.i
            r4.a((com.adcolony.sdk.e0) r1)
            return r0
        L_0x00c2:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.k.c(com.adcolony.sdk.f1):boolean");
    }

    /* access modifiers changed from: package-private */
    public void b(AdColonyAppOptions adColonyAppOptions) {
        this.r = adColonyAppOptions;
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z2) {
        this.B = z2;
    }

    /* access modifiers changed from: package-private */
    public d c() {
        if (this.d == null) {
            d dVar = new d();
            this.d = dVar;
            dVar.h();
        }
        return this.d;
    }

    private boolean a(boolean z2) {
        return a(z2, false);
    }

    /* access modifiers changed from: private */
    public boolean a(boolean z2, boolean z3) {
        if (!a.c()) {
            return false;
        }
        this.I = z3;
        this.F = z2;
        if (z2 && !z3) {
            if (!L()) {
                return false;
            }
            this.I = true;
        }
        K();
        return true;
    }

    private boolean a(f1 f1Var) {
        if (!this.F) {
            return true;
        }
        f1 f1Var2 = this.t;
        if (f1Var2 != null && c0.h(c0.f(f1Var2, "controller"), "sha1").equals(c0.h(c0.f(f1Var, "controller"), "sha1"))) {
            return false;
        }
        new e0.a().a("Controller sha1 does not match, downloading new controller.").a(e0.g);
        return true;
    }

    /* access modifiers changed from: private */
    public void a(h0 h0Var) {
        a(c0.d(h0Var.a(), "id"));
    }

    /* access modifiers changed from: private */
    public void a(s sVar) {
        if (sVar.n) {
            f1 a2 = c0.a(sVar.m, "Parsing launch response");
            c0.a(a2, "sdkVersion", n().I());
            c0.j(a2, this.h.a() + "026ae9c9824b3e483fa6c71fa88f57ae27816141");
            if (c(a2)) {
                if (a(a2)) {
                    f1 b2 = c0.b();
                    c0.a(b2, "url", this.w);
                    c0.a(b2, "filepath", this.h.a() + "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
                    this.b.a(new s(new h0("WebServices.download", 0, b2), new n()));
                }
                this.t = a2;
            } else if (!this.F) {
                new e0.a().a("Incomplete or disabled launch server response. ").a("Disabling AdColony until next launch.").a(e0.h);
                b(true);
            }
        } else {
            S();
        }
    }

    private boolean a(String str) {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        File file = new File(a2.getFilesDir().getAbsolutePath() + "/adc3/" + "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
        if (file.exists()) {
            return z0.a(str, file);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.d.a();
        P();
    }

    /* access modifiers changed from: package-private */
    public void a(AdColonyAppOptions adColonyAppOptions) {
        this.D.a(false);
        this.d.b();
        R();
        AdColony.a(a.a(), adColonyAppOptions);
        T();
        this.u.clear();
        this.r = adColonyAppOptions;
        this.a.a();
        a(true, true);
    }

    /* access modifiers changed from: package-private */
    public boolean a(k0 k0Var) {
        this.v.remove(Integer.valueOf(k0Var.getModuleId()));
        return this.a.b(k0Var);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        this.v.remove(Integer.valueOf(i2));
        return this.a.b(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(AdColonyRewardListener adColonyRewardListener) {
        this.p = adColonyRewardListener;
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        this.l = cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(AdColonyAdView adColonyAdView) {
        this.n = adColonyAdView;
    }

    /* access modifiers changed from: package-private */
    public void a(AdColonyInterstitial adColonyInterstitial) {
        this.o = adColonyInterstitial;
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.D.a(j2);
    }
}
