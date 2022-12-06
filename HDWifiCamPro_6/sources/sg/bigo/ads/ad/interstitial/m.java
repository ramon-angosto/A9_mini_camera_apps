package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.banner.f;
import sg.bigo.ads.ad.interstitial.a.b;
import sg.bigo.ads.ad.interstitial.a.b.c;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.utils.a;
import sg.bigo.ads.common.utils.d;
import sg.bigo.ads.common.utils.l;

public class m extends a {
    private final b A = new b(this, (byte) 0);
    /* access modifiers changed from: private */
    public boolean p = false;
    private boolean s = true;
    /* access modifiers changed from: private */
    public int t = 1;
    /* access modifiers changed from: private */
    public boolean u = false;
    /* access modifiers changed from: private */
    public Runnable v;
    /* access modifiers changed from: private */
    public Runnable w;
    /* access modifiers changed from: private */
    public int x = 9;
    /* access modifiers changed from: private */
    public volatile boolean y;
    private final Runnable z = new Runnable() {
        public final void run() {
            m.this.c(5);
            boolean unused = m.this.y = false;
        }
    };

    class a implements f {
        private int b;
        private int c = 9;

        public a(int i) {
            this.b = i;
        }

        public final void a() {
            if (m.this.a == 5 || m.this.a == 1 || m.this.a == 7 || m.this.a == 8) {
                m.this.j();
            }
        }

        public final void a(Point point, e eVar) {
            ((i) m.this.k).m.a(point, this.b, this.c, eVar);
        }

        public final void a(String str) {
        }

        public final void b() {
        }
    }

    final class b {
        private final List<View> b;

        private b() {
            this.b = new ArrayList();
        }

        /* synthetic */ b(m mVar, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (m.this.n != null) {
                for (View removeView : this.b) {
                    m.this.n.removeView(removeView);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(View view) {
            this.b.add(view);
        }
    }

    protected m(Activity activity) {
        super(activity);
    }

    private void F() {
        View findViewById;
        if (this.n != null && (findViewById = this.n.findViewById(R.id.layout_end_page)) != null) {
            findViewById.setVisibility(8);
        }
    }

    private int G() {
        sg.bigo.ads.ad.interstitial.a.a aVar;
        sg.bigo.ads.common.k.a.a(0, 3, "RichInterstitialVideoActivityImpl", "try to show end page view.");
        if (!((this.f && this.e.a("endpage.ad_component_layout") != 5) || this.k == null || (aVar = ((i) this.k).o) == null)) {
            if (aVar.a && aVar.b()) {
                sg.bigo.ads.common.k.a.a(0, 3, "RichInterstitialVideoActivityImpl", "[VastCompanion] companion resource is available and ready.");
                View a2 = aVar.a();
                if (a2 != null) {
                    if ((a2 instanceof ViewGroup) && !this.d.c("interstitial_video_style.endpage.is_global_click")) {
                        a2.setOnClickListener((View.OnClickListener) null);
                    }
                    sg.bigo.ads.common.k.a.a(0, 3, "RichInterstitialVideoActivityImpl", "[VastCompanion] show companion end page view.");
                    a(aVar, a2);
                    return 7;
                }
            }
            if (!aVar.b()) {
                aVar.d();
            }
        }
        sg.bigo.ads.common.k.a.a(0, 3, "RichInterstitialVideoActivityImpl", "show video end page view.");
        I();
        return 1;
    }

    private int H() {
        int a2 = this.f ? this.e.a("endpage.ad_component_layout") : 1;
        return a2 != 2 ? a2 != 3 ? a2 != 4 ? R.layout.bigo_ad_activity_interstitial_rich_video_end : R.layout.bigo_ad_activity_interstitial_rich_video_end_4 : R.layout.bigo_ad_activity_interstitial_rich_video_end_3 : R.layout.bigo_ad_activity_interstitial_rich_video_end_2;
    }

    private void I() {
        String str;
        h hVar;
        if (this.n != null) {
            View findViewById = this.n.findViewById(R.id.inter_end_page);
            if (findViewById == null) {
                this.q.getLayoutInflater().inflate(H(), this.n);
            }
            View findViewById2 = this.n.findViewById(R.id.layout_playable_loading);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            View findViewById3 = this.n.findViewById(R.id.layout_end_page);
            boolean z2 = false;
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
            if (findViewById == null) {
                View findViewById4 = this.n.findViewById(R.id.inter_end_page);
                View findViewById5 = this.n.findViewById(R.id.end_page_image);
                if (findViewById4 != null) {
                    y().a(this.n, findViewById3, x(), this.f ? 9 : 4, findViewById3);
                    View view = findViewById5 == null ? findViewById4 : findViewById5;
                    if (findViewById5 != null) {
                        findViewById3 = findViewById4;
                    }
                    view.setTag(5);
                    findViewById3.setTag(9);
                    a(view, findViewById3);
                    TextView textView = (TextView) findViewById4.findViewById(R.id.inter_advertiser);
                    TextView textView2 = (TextView) findViewById4.findViewById(R.id.inter_ad_label);
                    if (TextUtils.isEmpty(this.h)) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(this.h);
                        textView2.setText("Реклама");
                    }
                    b.d(findViewById4);
                    View findViewById6 = findViewById4.findViewById(R.id.inter_btn_cta);
                    if (!this.f || this.e.c("endpage.is_cta_show_animation")) {
                        z2 = true;
                    }
                    if (z2 && findViewById6 != null) {
                        b.e(findViewById6);
                    }
                    if (this.f) {
                        hVar = this.e;
                        str = "endpage.close_click_seconds";
                    } else {
                        hVar = this.d;
                        str = "interstitial_video_style.endpage.impression_close_seconds";
                    }
                    a(((long) hVar.a(str)) * 1000);
                    this.m.c();
                }
            }
        }
    }

    private void J() {
        View findViewById;
        View findViewById2;
        if (this.n != null) {
            if (this.p && (findViewById2 = this.n.findViewById(R.id.inter_ad_info)) != null) {
                this.p = false;
                b.a(findViewById2);
            }
            if (this.s && (findViewById = this.n.findViewById(R.id.inter_media_container)) != null) {
                this.s = false;
                b.c(findViewById);
                MediaView mediaView = (MediaView) findViewById.findViewById(R.id.inter_media);
                if (mediaView != null) {
                    mediaView.b();
                }
            }
        }
    }

    private void a(View view, View view2) {
        sg.bigo.ads.core.adview.f fVar;
        ViewGroup viewGroup;
        if (!this.f && this.d.c("interstitial_video_style.endpage.is_global_click")) {
            this.n.setTag(11);
            sg.bigo.ads.ad.a.a.a(this.n, this.n, 4, ((i) this.k).m);
        } else if (this.f) {
            if (this.e.c("endpage.media_view_clickable_switch")) {
                viewGroup = this.n;
                fVar = ((i) this.k).m;
            } else {
                viewGroup = this.n;
                fVar = this.c;
            }
            sg.bigo.ads.ad.a.a.a(viewGroup, view, 9, fVar);
            if (this.e.c("endpage.other_space_clickable_switch")) {
                sg.bigo.ads.ad.a.a.a(this.n, view2, 9, ((i) this.k).m);
            } else {
                sg.bigo.ads.ad.a.a.a(this.n, view2, 9, this.c);
            }
        }
    }

    private void a(sg.bigo.ads.ad.interstitial.a.a aVar, View view) {
        String str;
        h hVar;
        if (this.n != null) {
            this.n.addView(view, new FrameLayout.LayoutParams(-1, -1, 17));
            view.setTag(20);
            this.n.setTag(20);
            a(view, (View) this.n);
            aVar.a(1);
            if (this.f) {
                hVar = this.e;
                str = "endpage.close_click_seconds";
            } else {
                hVar = this.d;
                str = "interstitial_video_style.endpage.impression_close_seconds";
            }
            a(((long) hVar.a(str)) * 1000);
            if (this.m != null) {
                this.m.c();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean a(int i, sg.bigo.ads.ad.interstitial.a.b bVar) {
        View view = bVar.e.n;
        if (view == null) {
            sg.bigo.ads.common.k.a.a(0, "RichInterstitialVideoActivityImpl", "playableView == null.");
            bVar.e.d();
            return false;
        } else if (this.n == null) {
            sg.bigo.ads.common.k.a.a(0, "RichInterstitialVideoActivityImpl", "nativeAdView == null.");
            return false;
        } else if (this.a == 0 || this.a == 4) {
            a(5);
            J();
            F();
            this.n.addView(view, new FrameLayout.LayoutParams(-1, -1, 17));
            view.setTag(19);
            this.n.setTag(19);
            a(view, (View) this.n);
            if (this.m != null) {
                a(((long) (this.f ? this.e.a("endpage.close_click_seconds") : sg.bigo.ads.api.a.e.a.j().c())) * 1000);
                this.m.c();
            }
            this.A.a(view);
            bVar.a(1);
            sg.bigo.ads.core.d.a.a(((i) this.k).n(), this.a, i);
            return true;
        } else {
            sg.bigo.ads.common.k.a.a(0, "RichInterstitialVideoActivityImpl", "playable page can be shown but current page is not main or playable loading.");
            return false;
        }
    }

    private boolean a(sg.bigo.ads.ad.interstitial.a.b bVar, int i) {
        if (this.n == null || this.a != 0) {
            return false;
        }
        a(4);
        J();
        I();
        f();
        b(bVar, i);
        sg.bigo.ads.core.d.a.a(((i) this.k).n(), this.a, 7);
        return true;
    }

    private void b(final sg.bigo.ads.ad.interstitial.a.b bVar, int i) {
        View findViewById;
        if (this.n != null && (findViewById = this.n.findViewById(R.id.layout_playable_loading)) != null) {
            findViewById.setVisibility(0);
            if (i <= 0) {
                i = 1;
            }
            Runnable runnable = this.v;
            if (runnable == null) {
                runnable = new Runnable() {
                    final /* synthetic */ int b = 7;

                    public final void run() {
                        if (m.this.w != null) {
                            bVar.a(m.this.w);
                        }
                        m.this.d(this.b);
                    }
                };
                this.v = runnable;
            }
            c.a(2, runnable, ((long) i) * 1000);
        }
    }

    static /* synthetic */ void d(m mVar) {
        View findViewById;
        if (mVar.n != null && mVar.a == 0 && mVar.p && (findViewById = mVar.n.findViewById(R.id.inter_btn_cta)) != null) {
            b.e(findViewById);
            mVar.u = true;
        }
    }

    /* access modifiers changed from: protected */
    public void A() {
        super.A();
        c(1);
    }

    /* access modifiers changed from: protected */
    public final void B() {
        super.B();
        if (this.a == 0 && !this.y) {
            this.g.postDelayed(this.z, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            this.y = true;
        }
    }

    /* access modifiers changed from: protected */
    public final void C() {
        super.C();
        if (this.y) {
            this.g.removeCallbacks(this.z);
            this.y = false;
        }
    }

    /* access modifiers changed from: protected */
    public k a() {
        h hVar;
        String str;
        k kVar = new k();
        if (this.e != null) {
            this.f = true;
            kVar.f = this.e.c("video_play_page.media_view_clickable_switch");
            kVar.h = this.e.c("video_play_page.ad_component_clickable_switch");
            kVar.g = this.e.c("video_play_page.other_space_clickable_switch");
            kVar.i = this.e.c("layer.other_space_clickable_switch");
            kVar.a = false;
            kVar.b = 0;
            kVar.c = this.e.a("video_play_page.force_staying_time");
            kVar.d = this.e.c("layer.is_show_layer");
            hVar = this.e;
            str = "layer.force_staying_time";
        } else {
            this.f = false;
            kVar.a = this.d.c("interstitial_video_style.video_play_page.is_global_click");
            kVar.b = this.d.a("interstitial_video_style.video_play_page.impression_close_seconds");
            kVar.c = this.d.a("interstitial_video_style.video_play_page.close_click_seconds");
            kVar.d = this.d.c("interstitial_video_style.video_play_page.is_jump_layer");
            hVar = this.d;
            str = "interstitial_video_style.layer.impression_layer_close_seconds";
        }
        kVar.e = hVar.a(str);
        return kVar;
    }

    /* access modifiers changed from: protected */
    public void a(final AdCountDownButton adCountDownButton) {
        adCountDownButton.setShowCloseButtonInCountdown(true);
        adCountDownButton.setTakeoverTickEvent(true);
        VideoController z2 = z();
        if (z2 != null) {
            z2.setProgressChangeListener(new VideoController.b() {
                public final void a(int i, int i2) {
                    adCountDownButton.a((long) (i2 - i));
                    if (!m.this.u && !m.this.f && m.this.t == 2 && ((float) i) / ((float) i2) >= m.this.d.b("interstitial_video_style.video_play_page.cta_animation_show_wait_progress")) {
                        m.d(m.this);
                    }
                    if (!m.this.u && m.this.f && m.this.e.c("video_play_page.is_cta_show_animation")) {
                        m.d(m.this);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        String str;
        h hVar;
        super.b();
        if (this.n != null) {
            y().a(this.n);
            this.t = this.d.a("interstitial_video_style.video_play_page.cta_animation_show_way");
            final TextView textView = (TextView) this.n.findViewById(R.id.inter_advertiser);
            TextView textView2 = (TextView) this.n.findViewById(R.id.inter_ad_label);
            if (TextUtils.isEmpty(this.h)) {
                textView.setVisibility(8);
            } else {
                textView.setText(this.h);
                textView.setPadding(d.a(this.n.getContext(), 4), d.a(textView.getContext(), 1), d.a(textView.getContext(), 4), d.a(textView.getContext(), 1));
                textView2.setText("Реклама");
            }
            final View findViewById = this.n.findViewById(R.id.inter_ad_info);
            if (findViewById != null) {
                if (this.f) {
                    hVar = this.e;
                    str = "video_play_page.ad_component_show_time";
                } else {
                    hVar = this.d;
                    str = "interstitial_video_style.video_play_page.impression_ad_seconds";
                }
                this.i = new l(((long) hVar.a(str)) * 1000) {
                    public final void a() {
                        boolean unused = m.this.p = true;
                        findViewById.setVisibility(0);
                        b.a(findViewById, new a.C0127a() {
                            public final void onAnimationEnd(Animation animation) {
                                if (m.this.o != null && findViewById.getTop() > 0 && m.this.o.getBottom() > findViewById.getTop()) {
                                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.o.getLayoutParams();
                                    layoutParams.addRule(8, 0);
                                    layoutParams.addRule(2, R.id.inter_ad_info);
                                    m.this.o.setLayoutParams(layoutParams);
                                }
                            }
                        });
                        m.this.a(textView);
                        if (!m.this.u && !m.this.f && m.this.t == 1) {
                            m.this.g.postDelayed(new Runnable() {
                                public final void run() {
                                    m.d(m.this);
                                }
                            }, ((long) m.this.d.a("interstitial_video_style.video_play_page.cta_animation_show_wait_time")) * 1000);
                        } else if (!m.this.u && m.this.f && m.this.e.c("video_play_page.is_cta_show_animation")) {
                            m.d(m.this);
                        }
                    }

                    public final void a(long j) {
                    }
                };
                this.i.c();
            }
            if ((!this.f || this.e.a("endpage.ad_component_layout") == 5) && this.k != null) {
                Activity activity = this.q;
                sg.bigo.ads.ad.interstitial.a.b bVar = ((i) this.k).n;
                if (bVar != null) {
                    bVar.c = new b.C0118b() {
                        public final void a() {
                            c.b(new Runnable() {
                                public final void run() {
                                    if (m.this.a == 5 && m.this.m.getVisibility() != 0) {
                                        int unused = m.this.x = 8;
                                        m.this.e();
                                    }
                                }
                            });
                        }
                    };
                    bVar.e.k = new a(13);
                    bVar.a((Context) activity);
                }
                sg.bigo.ads.ad.interstitial.a.a aVar = ((i) this.k).o;
                if (aVar != null) {
                    a aVar2 = new a(15);
                    if (aVar.b instanceof sg.bigo.ads.ad.interstitial.a.a.b) {
                        ((sg.bigo.ads.ad.interstitial.a.a.b) aVar.b).k = aVar2;
                    }
                    AnonymousClass3 r2 = new c.a() {
                        public final void a(Point point, e eVar) {
                            ((i) m.this.k).a(point, 15, 9, eVar);
                        }
                    };
                    if (aVar.b instanceof sg.bigo.ads.ad.interstitial.a.a.c) {
                        ((sg.bigo.ads.ad.interstitial.a.a.c) aVar.b).e = r2;
                    }
                    aVar.a((Context) activity);
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ void b(int i) {
        super.b(i);
    }

    public final void c(int i) {
        c();
        if (this.j != null) {
            this.j.b();
        }
        if (this.i != null) {
            this.i.b();
        }
        this.i = null;
        final sg.bigo.ads.ad.interstitial.a.b bVar = ((i) this.k).n;
        if ((!this.f || this.e.a("endpage.ad_component_layout") == 5) && bVar != null && bVar.a) {
            if (bVar.b()) {
                a(i, bVar);
                return;
            } else if (sg.bigo.ads.ad.interstitial.a.b.e()) {
                Runnable runnable = this.w;
                if (runnable == null) {
                    runnable = new Runnable() {
                        public final void run() {
                            sg.bigo.ads.common.f.c.a(m.this.v);
                            bVar.a((Runnable) this);
                            sg.bigo.ads.common.f.c.b(new Runnable() {
                                public final void run() {
                                    boolean unused = m.this.a(7, bVar);
                                }
                            });
                        }
                    };
                    this.w = runnable;
                }
                bVar.b = runnable;
                if (a(bVar, sg.bigo.ads.ad.interstitial.a.b.f())) {
                    return;
                }
            } else if (a(i, bVar)) {
                return;
            }
        }
        d(i);
    }

    /* access modifiers changed from: protected */
    public final void d(int i) {
        if (this.n != null) {
            if (this.a == 0 || this.a == 4) {
                this.A.a();
                J();
                a(G());
                sg.bigo.ads.core.d.a.a(((i) this.k).n(), this.a, i);
                return;
            }
            sg.bigo.ads.common.k.a.a(0, "RichInterstitialVideoActivityImpl", "end page can be shown but current page is not main or playable loading.");
        }
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        String str;
        h hVar;
        int i = this.a;
        if (i == 0) {
            c(2);
            return false;
        }
        if (i == 5) {
            boolean g = g();
            if (this.m != null) {
                this.m.c();
                if (!g) {
                    if (this.f) {
                        hVar = this.e;
                        str = "endpage.close_click_seconds";
                    } else {
                        hVar = this.d;
                        str = "interstitial_video_style.endpage.impression_close_seconds";
                    }
                    a(((long) hVar.a(str)) * 1000);
                }
            }
            if (g) {
                sg.bigo.ads.core.d.a.a(((i) this.k).n(), 9, this.x);
                return false;
            }
        }
        if (i != 1 && i != 7) {
            return true;
        }
        boolean g2 = g();
        if (g2) {
            sg.bigo.ads.core.d.a.a(((i) this.k).n(), 9, 10);
        }
        return !g2;
    }

    public void m() {
        if (this.f || this.a != 0) {
            super.m();
        } else {
            c(3);
        }
    }

    public final void n() {
        if (this.k != null) {
            sg.bigo.ads.ad.interstitial.a.b bVar = ((i) this.k).n;
            if (bVar != null) {
                bVar.e.c();
            }
            sg.bigo.ads.ad.interstitial.a.a aVar = ((i) this.k).o;
            if (aVar != null) {
                aVar.c();
            }
        }
        Runnable runnable = this.v;
        if (runnable != null) {
            sg.bigo.ads.common.f.c.a(runnable);
        }
        super.n();
    }

    /* access modifiers changed from: protected */
    public final int q() {
        int a2 = this.f ? this.e.a("video_play_page.ad_component_layout") : 1;
        return a2 != 2 ? a2 != 3 ? a2 != 4 ? a2 != 5 ? R.layout.bigo_ad_activity_interstitial_rich_video : R.layout.bigo_ad_activity_interstitial_rich_video_5 : R.layout.bigo_ad_activity_interstitial_rich_video_4 : R.layout.bigo_ad_activity_interstitial_rich_video_3 : R.layout.bigo_ad_activity_interstitial_rich_video_2;
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        return this.f;
    }

    public final void t() {
        super.t();
        if (this.i != null && this.i.e()) {
            this.i.c();
        }
        sg.bigo.ads.ad.interstitial.a.b bVar = ((i) this.k).n;
        if (bVar != null) {
            sg.bigo.ads.ad.interstitial.a.a.b bVar2 = bVar.e;
            sg.bigo.ads.common.k.a.a(0, 3, "HtmlVastCompanion", CampaignEx.JSON_NATIVE_VIDEO_RESUME);
            if (bVar2.l != null) {
                sg.bigo.ads.core.mraid.e eVar = bVar2.l;
                eVar.m = false;
                eVar.j();
                if (eVar.h != null) {
                    eVar.h.onResume();
                }
                if (eVar.i != null) {
                    eVar.i.onResume();
                }
            }
        }
    }

    public final void u() {
        super.u();
        if (this.i != null) {
            this.i.d();
        }
        sg.bigo.ads.ad.interstitial.a.b bVar = ((i) this.k).n;
        if (bVar != null) {
            sg.bigo.ads.ad.interstitial.a.a.b bVar2 = bVar.e;
            sg.bigo.ads.common.k.a.a(0, 3, "HtmlVastCompanion", CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
            if (bVar2.l != null) {
                bVar2.l.a(false);
            }
        }
    }

    public final void w() {
        C();
        c(4);
    }
}
