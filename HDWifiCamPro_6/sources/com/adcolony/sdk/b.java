package com.adcolony.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import java.util.Map;

class b extends Activity {
    c a;
    int b = -1;
    int c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            b.this.a(h0Var);
        }
    }

    b() {
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        Iterator<Map.Entry<Integer, a1>> it = this.a.m().entrySet().iterator();
        while (it.hasNext() && !isFinishing()) {
            a1 a1Var = (a1) it.next().getValue();
            if (!a1Var.f() && a1Var.b().isPlaying()) {
                a1Var.h();
            }
        }
        AdColonyInterstitial j = a.b().j();
        if (j != null && j.i() && j.e().c() != null && z && this.h) {
            j.e().a(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        for (Map.Entry<Integer, a1> value : this.a.m().entrySet()) {
            a1 a1Var = (a1) value.getValue();
            if (!a1Var.f() && !a1Var.b().isPlaying() && !a.b().o().b()) {
                a1Var.i();
            }
        }
        AdColonyInterstitial j = a.b().j();
        if (j != null && j.i() && j.e().c() != null) {
            if ((!z || !this.h) && this.i) {
                j.e().a(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
            }
        }
    }

    public void onBackPressed() {
        f1 b2 = c0.b();
        c0.a(b2, "id", this.a.a());
        new h0("AdSession.on_back_button", this.a.k(), b2).c();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this instanceof AdColonyInterstitialActivity) {
            a();
        } else {
            ((AdColonyAdViewActivity) this).c();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!a.d() || a.b().l() == null) {
            finish();
            return;
        }
        k b2 = a.b();
        this.f = false;
        c l = b2.l();
        this.a = l;
        l.d(false);
        if (z0.g()) {
            this.a.d(true);
        }
        this.a.a();
        this.c = this.a.k();
        boolean multiWindowEnabled = b2.u().getMultiWindowEnabled();
        this.g = multiWindowEnabled;
        if (multiWindowEnabled) {
            getWindow().addFlags(2048);
            getWindow().clearFlags(1024);
        } else {
            getWindow().addFlags(1024);
            getWindow().clearFlags(2048);
        }
        requestWindowFeature(1);
        getWindow().getDecorView().setBackgroundColor(-16777216);
        if (b2.u().getKeepScreenOn()) {
            getWindow().addFlags(128);
        }
        ViewParent parent = this.a.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.a);
        }
        setContentView(this.a);
        this.a.i().add(a.a("AdSession.finish_fullscreen_ad", (j0) new a(), true));
        this.a.j().add("AdSession.finish_fullscreen_ad");
        a(this.b);
        if (!this.a.o()) {
            f1 b3 = c0.b();
            c0.a(b3, "id", this.a.a());
            c0.b(b3, "screen_width", this.a.d());
            c0.b(b3, "screen_height", this.a.b());
            new h0("AdSession.on_fullscreen_ad_started", this.a.k(), b3).c();
            this.a.e(true);
            return;
        }
        a();
    }

    public void onDestroy() {
        super.onDestroy();
        if (a.d() && this.a != null && !this.d) {
            if ((Build.VERSION.SDK_INT < 24 || !z0.g()) && !this.a.q()) {
                f1 b2 = c0.b();
                c0.a(b2, "id", this.a.a());
                new h0("AdSession.on_error", this.a.k(), b2).c();
                this.f = true;
            }
        }
    }

    public void onPause() {
        super.onPause();
        a(this.e);
        this.e = false;
    }

    public void onResume() {
        super.onResume();
        a();
        b(this.e);
        this.e = true;
        this.i = true;
    }

    public void onWindowFocusChanged(boolean z) {
        if (z && this.e) {
            a.b().x().b(true);
            b(this.e);
            this.h = true;
        } else if (!z && this.e) {
            a.b().x().a(true);
            a(this.e);
            this.h = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Rect rect;
        k b2 = a.b();
        if (this.a == null) {
            this.a = b2.l();
        }
        c cVar = this.a;
        if (cVar != null) {
            cVar.d(false);
            if (z0.g()) {
                this.a.d(true);
            }
            if (this.g) {
                rect = b2.n().x();
            } else {
                rect = b2.n().w();
            }
            if (rect.width() > 0 && rect.height() > 0) {
                f1 b3 = c0.b();
                f1 b4 = c0.b();
                float s = b2.n().s();
                c0.b(b4, "width", (int) (((float) rect.width()) / s));
                c0.b(b4, "height", (int) (((float) rect.height()) / s));
                c0.b(b4, "app_orientation", z0.d(z0.f()));
                c0.b(b4, "x", 0);
                c0.b(b4, "y", 0);
                c0.a(b4, "ad_session_id", this.a.a());
                c0.b(b3, "screen_width", rect.width());
                c0.b(b3, "screen_height", rect.height());
                c0.a(b3, "ad_session_id", this.a.a());
                c0.b(b3, "id", this.a.c());
                this.a.setLayoutParams(new FrameLayout.LayoutParams(rect.width(), rect.height()));
                this.a.b(rect.width());
                this.a.a(rect.height());
                new h0("MRAID.on_size_change", this.a.k(), b4).c();
                new h0("AdContainer.on_orientation_change", this.a.k(), b3).c();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(h0 h0Var) {
        int d2 = c0.d(h0Var.a(), "status");
        if ((d2 == 5 || d2 == 0 || d2 == 6 || d2 == 1) && !this.d) {
            k b2 = a.b();
            r o = b2.o();
            b2.d(h0Var);
            if (o.a() != null) {
                o.a().dismiss();
                o.a((AlertDialog) null);
            }
            if (!this.f) {
                finish();
            }
            this.d = true;
            ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            b2.e(false);
            f1 b3 = c0.b();
            c0.a(b3, "id", this.a.a());
            new h0("AdSession.on_close", this.a.k(), b3).c();
            b2.a((c) null);
            b2.a((AdColonyInterstitial) null);
            b2.a((AdColonyAdView) null);
            a.b().c().f().remove(this.a.a());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (i2 == 0) {
            setRequestedOrientation(7);
        } else if (i2 != 1) {
            setRequestedOrientation(4);
        } else {
            setRequestedOrientation(6);
        }
        this.b = i2;
    }
}
