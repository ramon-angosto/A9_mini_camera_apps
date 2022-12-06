package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.widget.RelativeLayout;
import sg.bigo.ads.R;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.common.utils.s;

public class f extends c<g> {
    private RelativeLayout a;

    protected f(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (this.k != null) {
            ((g) this.k).n = new sg.bigo.ads.ad.banner.f() {
                public final void a() {
                    f.this.i();
                }

                public final void a(Point point, e eVar) {
                }

                public final void a(String str) {
                }

                public final void b() {
                }
            };
            this.a = (RelativeLayout) this.l.findViewById(R.id.inter_banner_container);
            g gVar = (g) this.k;
            if (!c.b()) {
                r.a("adView() must run on UI thread");
            }
            View b = gVar.m.b();
            gVar.a(b, false);
            if (b != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                s.a(b, this.a, layoutParams, 0);
            }
        }
    }

    public final void n() {
        super.n();
        RelativeLayout relativeLayout = this.a;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    /* access modifiers changed from: protected */
    public final int q() {
        return R.layout.bigo_ad_activity_interstitial_banner;
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        return false;
    }
}
