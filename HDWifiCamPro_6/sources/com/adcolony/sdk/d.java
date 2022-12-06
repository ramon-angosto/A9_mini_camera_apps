package com.adcolony.sdk;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.webkit.WebView;
import com.adcolony.sdk.e0;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class d {
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Runnable> a;
    private HashMap<String, c> b;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, AdColonyInterstitial> c;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, AdColonyAdViewListener> d;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, AdColonyAdViewListener> e;
    /* access modifiers changed from: private */
    public Map<String, AdColonyAdView> f;
    /* access modifiers changed from: private */
    public final Object g = new Object();

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            d.this.e(h0Var);
        }
    }

    class b implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) d.this.c.get(c0.h(this.a.a(), "id"));
                if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
                    adColonyInterstitial.getListener().onAudioStopped(adColonyInterstitial);
                }
            }
        }

        b() {
        }

        public void a(h0 h0Var) {
            z0.b((Runnable) new a(h0Var));
        }
    }

    class c implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) d.this.c.get(c0.h(this.a.a(), "id"));
                if (adColonyInterstitial != null && adColonyInterstitial.getListener() != null) {
                    adColonyInterstitial.getListener().onAudioStarted(adColonyInterstitial);
                }
            }
        }

        c() {
        }

        public void a(h0 h0Var) {
            z0.b((Runnable) new a(h0Var));
        }
    }

    /* renamed from: com.adcolony.sdk.d$d  reason: collision with other inner class name */
    class C0006d implements j0 {
        C0006d() {
        }

        public void a(h0 h0Var) {
            d.this.i(h0Var);
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            d.this.h(h0Var);
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            boolean unused = d.this.g(h0Var);
        }
    }

    class g implements j0 {
        g(d dVar) {
        }

        public void a(h0 h0Var) {
            f1 b = c0.b();
            c0.b(b, "success", true);
            h0Var.a(b).c();
        }
    }

    class h implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h hVar, h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                h0 h0Var = this.a;
                h0Var.a(h0Var.a()).c();
            }
        }

        h(d dVar) {
        }

        public void a(h0 h0Var) {
            z0.b((Runnable) new a(this, h0Var));
        }
    }

    class i implements j0 {
        i(d dVar) {
        }

        public void a(h0 h0Var) {
            o0.c().a(h0Var);
        }
    }

    class j implements Runnable {
        j(d dVar) {
        }

        public void run() {
            r o = a.b().o();
            if (o.a() != null) {
                o.a().dismiss();
                o.a((AlertDialog) null);
            }
        }
    }

    class k implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ h0 b;
        final /* synthetic */ AdColonyAdViewListener c;
        final /* synthetic */ String d;

        k(Context context, h0 h0Var, AdColonyAdViewListener adColonyAdViewListener, String str) {
            this.a = context;
            this.b = h0Var;
            this.c = adColonyAdViewListener;
            this.d = str;
        }

        public void run() {
            AdColonyAdView adColonyAdView;
            try {
                adColonyAdView = new AdColonyAdView(this.a, this.b, this.c);
            } catch (RuntimeException e2) {
                new e0.a().a(e2.toString()).a(e0.i);
                adColonyAdView = null;
            }
            synchronized (d.this.g) {
                if (d.this.e.remove(this.d) != null) {
                    if (adColonyAdView == null) {
                        d.this.a(this.c);
                        return;
                    }
                    d.this.f.put(this.d, adColonyAdView);
                    adColonyAdView.setOmidManager(this.c.b());
                    adColonyAdView.e();
                    this.c.a((p0) null);
                    this.c.onRequestFilled(adColonyAdView);
                }
            }
        }
    }

    class l implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                d.this.c(this.a);
            }
        }

        l() {
        }

        public void a(h0 h0Var) {
            z0.b((Runnable) new a(h0Var));
        }
    }

    class m implements Runnable {
        final /* synthetic */ h0 a;
        final /* synthetic */ AdColonyInterstitial b;
        final /* synthetic */ AdColonyInterstitialListener c;

        m(d dVar, h0 h0Var, AdColonyInterstitial adColonyInterstitial, AdColonyInterstitialListener adColonyInterstitialListener) {
            this.a = h0Var;
            this.b = adColonyInterstitial;
            this.c = adColonyInterstitialListener;
        }

        public void run() {
            f1 a2 = this.a.a();
            if (this.b.e() == null) {
                this.b.a(c0.f(a2, "iab"));
            }
            this.b.a(c0.h(a2, "ad_id"));
            this.b.c(c0.h(a2, CampaignEx.JSON_KEY_CREATIVE_ID));
            this.b.setViewNetworkPassFilter(c0.h(a2, "view_network_pass_filter"));
            p0 e = this.b.e();
            if (!(e == null || e.d() == 2)) {
                try {
                    e.a();
                } catch (IllegalArgumentException unused) {
                    new e0.a().a("IllegalArgumentException when creating omid session").a(e0.i);
                }
            }
            this.c.onRequestFilled(this.b);
        }
    }

    class n implements Runnable {
        final /* synthetic */ AdColonyAdViewListener a;

        n(d dVar, AdColonyAdViewListener adColonyAdViewListener) {
            this.a = adColonyAdViewListener;
        }

        public void run() {
            AdColonyAdViewListener adColonyAdViewListener = this.a;
            adColonyAdViewListener.onRequestNotFilled(AdColony.a(adColonyAdViewListener.c()));
            if (!a.c()) {
                new e0.a().a("RequestNotFilled called for AdView due to a missing context. ").a(e0.i);
            }
        }
    }

    class o implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ long c;

        o(String str, String str2, long j) {
            this.a = str;
            this.b = str2;
            this.c = j;
        }

        public void run() {
            d.this.a.remove(this.a);
            AdColonyAdViewListener adColonyAdViewListener = (AdColonyAdViewListener) d.this.d.remove(this.a);
            if (adColonyAdViewListener != null) {
                adColonyAdViewListener.onRequestNotFilled(AdColony.a(this.b));
                f1 b2 = c0.b();
                c0.a(b2, "id", this.a);
                c0.a(b2, AdColonyAdapterUtils.KEY_ZONE_ID, this.b);
                c0.b(b2, "type", 1);
                c0.b(b2, "request_fail_reason", 26);
                new h0("AdSession.on_request_failure", 1, b2).c();
                e0.a a2 = new e0.a().a("RequestNotFilled called due to a native timeout. ");
                e0.a a3 = a2.a("Timeout set to: " + a.b().d() + " ms. ");
                e0.a a4 = a3.a("AdView request time allowed: " + this.c + " ms. ");
                a4.a("AdView with adSessionId(" + this.a + ") - request failed.").a(e0.i);
            }
        }
    }

    class p implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ long c;

        p(String str, String str2, long j) {
            this.a = str;
            this.b = str2;
            this.c = j;
        }

        public void run() {
            AdColonyInterstitialListener adColonyInterstitialListener;
            d.this.a.remove(this.a);
            AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) d.this.c.remove(this.a);
            if (adColonyInterstitial == null) {
                adColonyInterstitialListener = null;
            } else {
                adColonyInterstitialListener = adColonyInterstitial.getListener();
            }
            if (adColonyInterstitialListener != null) {
                adColonyInterstitialListener.onRequestNotFilled(AdColony.a(this.b));
                f1 b2 = c0.b();
                c0.a(b2, "id", this.a);
                c0.a(b2, AdColonyAdapterUtils.KEY_ZONE_ID, this.b);
                c0.b(b2, "type", 0);
                c0.b(b2, "request_fail_reason", 26);
                new h0("AdSession.on_request_failure", 1, b2).c();
                e0.a a2 = new e0.a().a("RequestNotFilled called due to a native timeout. ");
                e0.a a3 = a2.a("Timeout set to: " + a.b().d() + " ms. ");
                e0.a a4 = a3.a("Interstitial request time allowed: " + this.c + " ms. ");
                a4.a("Interstitial with adSessionId(" + this.a + ") - request failed.").a(e0.i);
            }
        }
    }

    class q implements Runnable {
        final /* synthetic */ AdColonyInterstitialListener a;
        final /* synthetic */ AdColonyInterstitial b;

        q(d dVar, AdColonyInterstitialListener adColonyInterstitialListener, AdColonyInterstitial adColonyInterstitial) {
            this.a = adColonyInterstitialListener;
            this.b = adColonyInterstitial;
        }

        public void run() {
            a.b().e(false);
            this.a.onClosed(this.b);
        }
    }

    class r implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ b1 b;
        final /* synthetic */ c c;

        r(String str, b1 b1Var, c cVar) {
            this.a = str;
            this.b = b1Var;
            this.c = cVar;
        }

        public void run() {
            p0 p0Var;
            int i;
            try {
                AdColonyInterstitial adColonyInterstitial = d.this.f().get(this.a);
                AdColonyAdView adColonyAdView = d.this.d().get(this.a);
                if (adColonyInterstitial == null) {
                    p0Var = null;
                } else {
                    p0Var = adColonyInterstitial.e();
                }
                if (p0Var == null && adColonyAdView != null) {
                    p0Var = adColonyAdView.getOmidManager();
                }
                if (p0Var == null) {
                    i = -1;
                } else {
                    i = p0Var.d();
                }
                if (p0Var != null && i == 2) {
                    p0Var.a((WebView) this.b);
                    p0Var.a(this.c);
                }
            } catch (IllegalArgumentException unused) {
                new e0.a().a("IllegalArgumentException when creating omid session").a(e0.i);
            }
        }
    }

    class s implements Runnable {
        final /* synthetic */ c a;

        s(d dVar, c cVar) {
            this.a = cVar;
        }

        public void run() {
            for (int i = 0; i < this.a.i().size(); i++) {
                a.b(this.a.j().get(i), this.a.i().get(i));
            }
            this.a.j().clear();
            this.a.i().clear();
            this.a.removeAllViews();
            c cVar = this.a;
            cVar.z = null;
            cVar.y = null;
            for (b1 next : cVar.n().values()) {
                if (!(next instanceof e)) {
                    if (next instanceof c1) {
                        a.b().a((k0) (c1) next);
                    } else {
                        next.l();
                    }
                }
            }
            for (a1 next2 : this.a.m().values()) {
                next2.j();
                next2.k();
            }
            this.a.m().clear();
            this.a.l().clear();
            this.a.n().clear();
            this.a.h().clear();
            this.a.e().clear();
            this.a.f().clear();
            this.a.g().clear();
            this.a.m = true;
        }
    }

    class t implements j0 {

        class a implements Runnable {
            final /* synthetic */ h0 a;

            a(h0 h0Var) {
                this.a = h0Var;
            }

            public void run() {
                boolean unused = d.this.d(this.a);
            }
        }

        t() {
        }

        public void a(h0 h0Var) {
            z0.b((Runnable) new a(h0Var));
        }
    }

    class u implements j0 {
        u() {
        }

        public void a(h0 h0Var) {
            boolean unused = d.this.k(h0Var);
        }
    }

    class v implements j0 {
        v() {
        }

        public void a(h0 h0Var) {
            boolean unused = d.this.j(h0Var);
        }
    }

    class w implements j0 {
        w() {
        }

        public void a(h0 h0Var) {
            boolean unused = d.this.f(h0Var);
        }
    }

    class x implements j0 {
        x() {
        }

        public void a(h0 h0Var) {
            boolean unused = d.this.l(h0Var);
        }
    }

    class y implements j0 {
        y() {
        }

        public void a(h0 h0Var) {
            d.this.b(h0Var);
        }
    }

    class z implements j0 {
        z() {
        }

        public void a(h0 h0Var) {
            d.this.a(h0Var);
        }
    }

    d() {
    }

    /* access modifiers changed from: private */
    public boolean g(h0 h0Var) {
        String h2 = c0.h(h0Var.a(), "id");
        f1 b2 = c0.b();
        c0.a(b2, "id", h2);
        Context a2 = a.a();
        if (a2 == null) {
            c0.b(b2, "has_audio", false);
            h0Var.a(b2).c();
            return false;
        }
        boolean b3 = z0.b(z0.a(a2));
        double a3 = z0.a(z0.a(a2));
        c0.b(b2, "has_audio", b3);
        c0.a(b2, "volume", a3);
        h0Var.a(b2).c();
        return b3;
    }

    /* access modifiers changed from: private */
    public boolean j(h0 h0Var) {
        f1 a2 = h0Var.a();
        String b2 = h0Var.b();
        String h2 = c0.h(a2, "ad_session_id");
        int d2 = c0.d(a2, "view_id");
        c cVar = this.b.get(h2);
        if (cVar == null) {
            a(b2, h2);
            return false;
        }
        View view = cVar.e().get(Integer.valueOf(d2));
        if (view == null) {
            a(b2, "" + d2);
            return false;
        }
        cVar.removeView(view);
        cVar.addView(view, view.getLayoutParams());
        return true;
    }

    /* access modifiers changed from: private */
    public boolean k(h0 h0Var) {
        f1 a2 = h0Var.a();
        String b2 = h0Var.b();
        String h2 = c0.h(a2, "ad_session_id");
        int d2 = c0.d(a2, "view_id");
        c cVar = this.b.get(h2);
        if (cVar == null) {
            a(b2, h2);
            return false;
        }
        View view = cVar.e().get(Integer.valueOf(d2));
        if (view == null) {
            a(b2, "" + d2);
            return false;
        }
        view.bringToFront();
        return true;
    }

    /* access modifiers changed from: private */
    public boolean l(h0 h0Var) {
        f1 a2 = h0Var.a();
        String h2 = c0.h(a2, "id");
        AdColonyInterstitial adColonyInterstitial = this.c.get(h2);
        AdColonyAdView adColonyAdView = this.f.get(h2);
        int a3 = c0.a(a2, "orientation", -1);
        boolean z2 = adColonyAdView != null;
        if (adColonyInterstitial != null || z2) {
            c0.a(c0.b(), "id", h2);
            if (adColonyInterstitial != null) {
                adColonyInterstitial.a(a3);
                adColonyInterstitial.n();
            }
            return true;
        }
        a(h0Var.b(), h2);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.a = new ConcurrentHashMap<>();
        this.b = new HashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.e = new ConcurrentHashMap<>();
        this.f = Collections.synchronizedMap(new HashMap());
        a.a("AdContainer.create", (j0) new l());
        a.a("AdContainer.destroy", (j0) new t());
        a.a("AdContainer.move_view_to_index", (j0) new u());
        a.a("AdContainer.move_view_to_front", (j0) new v());
        a.a("AdSession.finish_fullscreen_ad", (j0) new w());
        a.a("AdSession.start_fullscreen_ad", (j0) new x());
        a.a("AdSession.ad_view_available", (j0) new y());
        a.a("AdSession.ad_view_unavailable", (j0) new z());
        a.a("AdSession.expiring", (j0) new a());
        a.a("AdSession.audio_stopped", (j0) new b());
        a.a("AdSession.audio_started", (j0) new c());
        a.a("AdSession.interstitial_available", (j0) new C0006d());
        a.a("AdSession.interstitial_unavailable", (j0) new e());
        a.a("AdSession.has_audio", (j0) new f());
        a.a("WebView.prepare", (j0) new g(this));
        a.a("AdSession.expanded", (j0) new h(this));
        a.a("AdColony.odt_event", (j0) new i(this));
    }

    /* access modifiers changed from: package-private */
    public boolean i(h0 h0Var) {
        f1 a2 = h0Var.a();
        String h2 = c0.h(a2, "id");
        AdColonyInterstitial adColonyInterstitial = this.c.get(h2);
        if (adColonyInterstitial == null || adColonyInterstitial.j()) {
            return false;
        }
        AdColonyInterstitialListener listener = adColonyInterstitial.getListener();
        if (listener == null) {
            a(h0Var.b(), h2);
            return false;
        }
        z0.c(this.a.remove(h2));
        if (!a.c()) {
            a(adColonyInterstitial);
            return false;
        }
        adColonyInterstitial.t();
        adColonyInterstitial.a(c0.h(a2, "ad_id"));
        adColonyInterstitial.c(c0.h(a2, CampaignEx.JSON_KEY_CREATIVE_ID));
        adColonyInterstitial.d(c0.h(a2, "ad_request_id"));
        z0.b((Runnable) new m(this, h0Var, adColonyInterstitial, listener));
        return true;
    }

    /* access modifiers changed from: private */
    public boolean d(h0 h0Var) {
        String h2 = c0.h(h0Var.a(), "ad_session_id");
        c cVar = this.b.get(h2);
        if (cVar == null) {
            a(h0Var.b(), h2);
            return false;
        }
        a(cVar);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean f(h0 h0Var) {
        AdColonyInterstitialListener adColonyInterstitialListener;
        f1 a2 = h0Var.a();
        int d2 = c0.d(a2, "status");
        if (d2 == 5 || d2 == 1 || d2 == 0 || d2 == 6) {
            return false;
        }
        String h2 = c0.h(a2, "id");
        AdColonyInterstitial remove = this.c.remove(h2);
        if (remove == null) {
            adColonyInterstitialListener = null;
        } else {
            adColonyInterstitialListener = remove.getListener();
        }
        if (adColonyInterstitialListener == null) {
            a(h0Var.b(), h2);
            return false;
        }
        z0.b((Runnable) new q(this, adColonyInterstitialListener, remove));
        remove.o();
        remove.a((c) null);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b(h0 h0Var) {
        String h2 = c0.h(h0Var.a(), "id");
        AdColonyAdViewListener remove = this.d.remove(h2);
        if (remove == null) {
            a(h0Var.b(), h2);
            return false;
        }
        this.e.put(h2, remove);
        z0.c(this.a.remove(h2));
        Context a2 = a.a();
        if (a2 == null) {
            a(remove);
            return false;
        }
        z0.b((Runnable) new k(a2, h0Var, remove, h2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean c(h0 h0Var) {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        f1 a3 = h0Var.a();
        String h2 = c0.h(a3, "ad_session_id");
        c cVar = new c(a2.getApplicationContext(), h2);
        cVar.j(h0Var);
        this.b.put(h2, cVar);
        if (c0.d(a3, "width") == 0) {
            AdColonyInterstitial adColonyInterstitial = this.c.get(h2);
            if (adColonyInterstitial == null) {
                a(h0Var.b(), h2);
                return false;
            }
            adColonyInterstitial.a(cVar);
        } else {
            cVar.c(false);
        }
        f1 b2 = c0.b();
        c0.b(b2, "success", true);
        h0Var.a(b2).c();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean e(h0 h0Var) {
        f1 a2 = h0Var.a();
        String h2 = c0.h(a2, "id");
        if (c0.d(a2, "type") != 0) {
            return true;
        }
        AdColonyInterstitial remove = this.c.remove(h2);
        if (!a.c() || remove == null || !remove.p()) {
            a(h0Var.b(), h2);
            return true;
        }
        z0.b((Runnable) new j(this));
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(h0 h0Var) {
        String h2 = c0.h(h0Var.a(), "id");
        AdColonyAdViewListener remove = this.d.remove(h2);
        if (remove == null) {
            a(h0Var.b(), h2);
            return false;
        }
        z0.c(this.a.remove(h2));
        a(remove);
        return true;
    }

    /* access modifiers changed from: package-private */
    public Map<String, AdColonyAdView> d() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (AdColonyInterstitial next : this.c.values()) {
            if (next != null && next.m()) {
                next.e("Controller was reloaded and current ad was closed");
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(AdColonyAdViewListener adColonyAdViewListener) {
        z0.b((Runnable) new n(this, adColonyAdViewListener));
    }

    private void a(AdColonyInterstitial adColonyInterstitial) {
        adColonyInterstitial.q();
        if (!a.c()) {
            e0.a a2 = new e0.a().a("RequestNotFilled called due to a missing context. ");
            a2.a("Interstitial with adSessionId(" + adColonyInterstitial.b() + ").").a(e0.i);
        }
    }

    /* access modifiers changed from: package-private */
    public List<AdColonyInterstitial> g() {
        ArrayList arrayList = new ArrayList();
        for (AdColonyInterstitial next : f().values()) {
            if (!next.isExpired()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        HashSet<AdColonyAdViewListener> hashSet = new HashSet<>();
        synchronized (this.g) {
            for (String remove : this.e.keySet()) {
                AdColonyAdViewListener remove2 = this.e.remove(remove);
                if (remove2 != null) {
                    hashSet.add(remove2);
                }
            }
            for (String remove3 : this.d.keySet()) {
                AdColonyAdViewListener remove4 = this.d.remove(remove3);
                if (remove4 != null) {
                    hashSet.add(remove4);
                }
            }
        }
        for (AdColonyAdViewListener a2 : hashSet) {
            a(a2);
        }
        for (String next : this.c.keySet()) {
            AdColonyInterstitial adColonyInterstitial = this.c.get(next);
            if (adColonyInterstitial != null && adColonyInterstitial.l()) {
                this.c.remove(next);
                a(adColonyInterstitial);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ConcurrentHashMap<String, AdColonyAdViewListener> e() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, AdColonyAdViewListener adColonyAdViewListener, AdColonyAdSize adColonyAdSize, AdColonyAdOptions adColonyAdOptions, long j2) {
        f1 f1Var;
        String a2 = z0.a();
        float s2 = a.b().n().s();
        f1 b2 = c0.b();
        c0.a(b2, AdColonyAdapterUtils.KEY_ZONE_ID, str);
        c0.b(b2, "type", 1);
        c0.b(b2, "width_pixels", (int) (((float) adColonyAdSize.getWidth()) * s2));
        c0.b(b2, "height_pixels", (int) (((float) adColonyAdSize.getHeight()) * s2));
        c0.b(b2, "width", adColonyAdSize.getWidth());
        c0.b(b2, "height", adColonyAdSize.getHeight());
        c0.a(b2, "id", a2);
        if (!(adColonyAdOptions == null || (f1Var = adColonyAdOptions.d) == null)) {
            c0.a(b2, "options", f1Var);
        }
        adColonyAdViewListener.a(str);
        adColonyAdViewListener.a(adColonyAdSize);
        this.d.put(a2, adColonyAdViewListener);
        this.a.put(a2, new o(a2, str, j2));
        new h0("AdSession.on_request", 1, b2).c();
        z0.a(this.a.get(a2), j2);
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, c> c() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public ConcurrentHashMap<String, AdColonyInterstitial> f() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, AdColonyInterstitialListener adColonyInterstitialListener, AdColonyAdOptions adColonyAdOptions, long j2) {
        String a2 = z0.a();
        k b2 = a.b();
        AdColonyInterstitial adColonyInterstitial = new AdColonyInterstitial(a2, adColonyInterstitialListener, str);
        f1 b3 = c0.b();
        c0.a(b3, AdColonyAdapterUtils.KEY_ZONE_ID, str);
        c0.b(b3, "fullscreen", true);
        Rect w2 = b2.n().w();
        c0.b(b3, "width", w2.width());
        c0.b(b3, "height", w2.height());
        c0.b(b3, "type", 0);
        c0.a(b3, "id", a2);
        if (!(adColonyAdOptions == null || adColonyAdOptions.d == null)) {
            adColonyInterstitial.a(adColonyAdOptions);
            c0.a(b3, "options", adColonyAdOptions.d);
        }
        this.c.put(a2, adColonyInterstitial);
        this.a.put(a2, new p(a2, str, j2));
        new h0("AdSession.on_request", 1, b3).c();
        z0.a(this.a.get(a2), j2);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, f1 f1Var, String str) {
        h0 h0Var = new h0("AdSession.finish_fullscreen_ad", 0);
        c0.b(f1Var, "status", 1);
        h0Var.b(f1Var);
        new e0.a().a(str).a(e0.h);
        ((b) context).a(h0Var);
    }

    /* access modifiers changed from: package-private */
    public void a(b1 b1Var, String str, c cVar) {
        z0.b((Runnable) new r(str, b1Var, cVar));
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        z0.b((Runnable) new s(this, cVar));
        AdColonyAdView adColonyAdView = this.f.get(cVar.a());
        if (adColonyAdView == null || adColonyAdView.d()) {
            this.b.remove(cVar.a());
            cVar.y = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean h(h0 h0Var) {
        AdColonyInterstitialListener adColonyInterstitialListener;
        String h2 = c0.h(h0Var.a(), "id");
        AdColonyInterstitial remove = this.c.remove(h2);
        if (remove == null) {
            adColonyInterstitialListener = null;
        } else {
            adColonyInterstitialListener = remove.getListener();
        }
        if (adColonyInterstitialListener == null) {
            a(h0Var.b(), h2);
            return false;
        }
        z0.c(this.a.remove(h2));
        a(remove);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2) {
        new e0.a().a("Message '").a(str).a("' sent with invalid id: ").a(str2).a(e0.h);
    }

    /* access modifiers changed from: package-private */
    public AdColonyAdView a(String str) {
        AdColonyAdView remove;
        synchronized (this.g) {
            remove = this.f.remove(str);
        }
        return remove;
    }
}
