package sg.bigo.ads.ad.b;

import android.app.Activity;
import java.util.Map;
import sg.bigo.ads.ad.b.a;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.k;
import sg.bigo.ads.ad.interstitial.m;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.core.d.a;

class b extends m {
    protected c p;
    private boolean s = true;

    protected b(Activity activity) {
        super(activity);
    }

    public final void A() {
        super.A();
        this.m.c();
        c cVar = this.p;
        if (cVar != null) {
            Map<String, String> b = a.b(cVar.b.a);
            b.put("rew_rslt", "1");
            a.a("06002019", b);
            if (cVar.p != null) {
                cVar.p.onAdRewarded();
                return;
            }
            return;
        }
        sg.bigo.ads.common.k.a.a(2, "", "Failed to claim reward because of null RewardVideoAd.");
    }

    public final k a() {
        k a = super.a();
        if (!this.s) {
            a.b = 0;
            a.c = -1;
        }
        return a;
    }

    public final void a(AdCountDownButton adCountDownButton) {
        super.a(adCountDownButton);
        adCountDownButton.setShowCloseButtonInCountdown(this.s);
    }

    public final void b() {
        boolean z = this.s;
        boolean z2 = true;
        if (!this.f ? this.d.a("interstitial_video_style.style") == 2 : this.e.a("video_play_page.force_staying_time") == -1) {
            z2 = false;
        }
        this.s = z & z2;
        super.b();
    }

    public final boolean k() {
        if (!this.s || this.a != 0) {
            return super.k();
        }
        final VideoController z = z();
        new a(this.q).a((a.C0112a) new a.C0112a() {
            private int c = -1;
            private boolean d = false;
            private boolean e = false;

            private void d() {
                if (b.this.a == 3) {
                    b.this.a(this.c);
                }
            }

            public final void a() {
                this.c = b.this.a;
                b.this.a(3);
                VideoController videoController = z;
                if (videoController != null && videoController.isPlaying()) {
                    z.pause();
                    this.d = true;
                }
                if (b.this.p != null) {
                    sg.bigo.ads.core.d.a.a(b.this.p.n(), b.this.a, 2);
                }
            }

            public final void b() {
                VideoController videoController;
                d();
                if (!this.e && this.d && (videoController = z) != null && videoController.isPaused()) {
                    z.play();
                }
            }

            public final void c() {
                this.e = true;
                if (b.this.f || b.this.d.a("interstitial_video_style.video_play_page.skip_type") == 2) {
                    d();
                    b.this.c(6);
                    return;
                }
                b.this.s();
            }
        });
        return false;
    }

    public final void m() {
        if (o()) {
            h();
        }
    }

    public final void p() {
        super.p();
        if (this.k != null) {
            if (this.k instanceof c) {
                this.p = (c) this.k;
            }
            if (this.p == null || !D()) {
                a("Illegal video content.");
            }
        }
    }

    public final void v() {
        if (this.s && this.a == 0) {
            i();
        }
    }

    public final int x() {
        return this.d.a("interstitial_video_style.video_play_page.icon_strategy") == 2 ? 2 : 1;
    }
}
