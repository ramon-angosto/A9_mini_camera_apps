package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.common.utils.a;
import sg.bigo.ads.common.utils.d;

class l extends a {
    private boolean p = false;

    protected l(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public final k a() {
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
    public final void a(AdCountDownButton adCountDownButton) {
        adCountDownButton.setShowCloseButtonInCountdown(false);
        adCountDownButton.setTakeoverTickEvent(false);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        String str;
        h hVar;
        super.b();
        if (this.n != null) {
            MediaView mediaView = (MediaView) this.n.findViewById(R.id.inter_media);
            if (mediaView != null) {
                if (mediaView instanceof MaximumHeightMediaView) {
                    ((MaximumHeightMediaView) mediaView).setMaxHeight(d.c(this.q) - d.a(this.q, 292));
                    y().a((ViewGroup) mediaView);
                } else {
                    y().a(this.n);
                }
            }
            final TextView textView = (TextView) this.n.findViewById(R.id.inter_advertiser);
            TextView textView2 = (TextView) this.n.findViewById(R.id.inter_ad_label);
            if (!(textView == null || textView2 == null)) {
                if (TextUtils.isEmpty(this.h)) {
                    textView.setVisibility(8);
                } else {
                    if (q() != R.layout.bigo_ad_activity_interstitial_native_top) {
                        textView.bringToFront();
                    }
                    textView.setText(this.h);
                    textView.setPadding(d.a(this.n.getContext(), 4), d.a(textView.getContext(), 1), d.a(textView.getContext(), 4), d.a(textView.getContext(), 1));
                    textView2.setText("Реклама");
                }
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
                this.i = new sg.bigo.ads.common.utils.l(((long) hVar.a(str)) * 1000) {
                    public final void a() {
                        findViewById.setVisibility(0);
                        b.a(findViewById, new a.C0127a() {
                            public final void onAnimationEnd(Animation animation) {
                                if (l.this.o != null && findViewById.getTop() > 0 && l.this.o.getBottom() > findViewById.getTop()) {
                                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) l.this.o.getLayoutParams();
                                    layoutParams.addRule(8, 0);
                                    layoutParams.addRule(2, R.id.inter_ad_info);
                                    l.this.o.setLayoutParams(layoutParams);
                                }
                            }
                        });
                        l.this.a(textView);
                        final View findViewById = l.this.n.findViewById(R.id.inter_btn_cta);
                        if (findViewById == null) {
                            return;
                        }
                        if (l.this.f && l.this.e.c("video_play_page.is_cta_show_animation")) {
                            b.e(findViewById);
                        } else if (!l.this.f) {
                            l.this.g.postDelayed(new Runnable() {
                                public final void run() {
                                    b.e(findViewById);
                                }
                            }, ((long) l.this.d.a("interstitial_image_style.main_page.cta_impression")) * 1000);
                        }
                    }

                    public final void a(long j) {
                    }
                };
                this.i.c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean k() {
        if (this.a != 0) {
            return true;
        }
        if (this.j != null) {
            this.j.b();
        }
        if (this.i != null) {
            this.i.b();
        }
        c();
        this.i = null;
        boolean g = g();
        if (g) {
            sg.bigo.ads.core.d.a.a(((i) this.k).n(), 9, 2);
        }
        return !g;
    }

    /* access modifiers changed from: protected */
    public final int q() {
        if (!this.f) {
            int a = this.d.a("interstitial_image_style.image_format");
            return a == 1 ? R.layout.bigo_ad_activity_interstitial_native_top : a == 2 ? R.layout.bigo_ad_activity_interstitial_bottom_card : R.layout.bigo_ad_activity_interstitial_native_center;
        }
        int a2 = this.e.a("video_play_page.ad_component_layout");
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
    }

    public final void u() {
        super.u();
        if (this.i != null) {
            this.i.d();
        }
    }
}
