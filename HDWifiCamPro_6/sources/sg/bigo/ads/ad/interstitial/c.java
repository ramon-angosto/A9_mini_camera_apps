package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.Window;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.e;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.controller.e.b;

public abstract class c<T extends e> extends b<T> implements e.b {
    protected T k;
    protected ViewGroup l;
    protected AdCountDownButton m;

    protected c(Activity activity) {
        super(activity);
    }

    private void a() {
        Window window = this.q.getWindow();
        if (window != null) {
            q.a(window);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        T t = this.k;
        if (t != null) {
            t.a(str);
        }
        E();
    }

    public final void a(boolean z) {
        if (z) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: protected */
    public void i() {
        s();
    }

    /* access modifiers changed from: protected */
    public int l() {
        return 1;
    }

    public void m() {
    }

    public void n() {
        super.n();
        AdCountDownButton adCountDownButton = this.m;
        if (!(adCountDownButton == null || adCountDownButton.b == null)) {
            adCountDownButton.b.b();
        }
        T t = this.k;
        if (t != null) {
            t.destroy();
        }
    }

    public void p() {
        super.p();
        try {
            this.k = (e) this.r;
            a();
            b(R.layout.bigo_ad_activity_interstitial);
            this.l = (ViewGroup) e(R.id.inter_main);
            this.q.getLayoutInflater().inflate(q(), this.l);
            this.m = (AdCountDownButton) e(R.id.inter_btn_close);
            AdCountDownButton adCountDownButton = this.m;
            if (adCountDownButton != null) {
                adCountDownButton.setOnCloseListener(new AdCountDownButton.a() {
                    public final void a() {
                        c.this.i();
                    }
                });
            }
            b();
            this.k.a((e.b) this);
            this.k.r();
        } catch (Exception e) {
            e.printStackTrace();
            a("Illegal InterstitialAd.");
        }
    }

    /* access modifiers changed from: protected */
    public abstract int q();

    /* access modifiers changed from: protected */
    public abstract boolean r();

    public final void s() {
        this.k.a(l());
        E();
    }

    public void t() {
        AdCountDownButton adCountDownButton = this.m;
        if (adCountDownButton != null && !adCountDownButton.c) {
            this.m.b();
        }
    }

    public void u() {
        AdCountDownButton adCountDownButton = this.m;
        if (adCountDownButton != null && !adCountDownButton.c) {
            this.m.a();
        }
    }

    public void v() {
    }

    public void w() {
    }
}
