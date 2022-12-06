package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.a.a.a.a.b.g;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.RatioFrameLayout;
import com.bytedance.sdk.openadsdk.core.widget.ShadowImageView;
import com.bytedance.sdk.openadsdk.l.z;
import java.util.ArrayList;
import java.util.List;

public class VastBannerBackupView extends BackupView implements c.C0021c, c.d {
    public boolean a = true;
    private NativeExpressView m;
    private com.com.bytedance.overseas.sdk.a.c n;
    private View o;
    /* access modifiers changed from: private */
    public NativeVideoTsView p;
    /* access modifiers changed from: private */
    public ShadowImageView q;
    private String r;
    /* access modifiers changed from: private */
    public long s;
    private long t;

    public void b_() {
    }

    public void c_() {
    }

    public void d_() {
    }

    public void e_() {
    }

    public VastBannerBackupView(Context context) {
        super(context);
        this.b = context;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i, j jVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.a(view, i, jVar);
            NativeVideoTsView nativeVideoTsView = this.p;
            if (nativeVideoTsView != null && (nativeVideoTsView.getNativeVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.c)) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.p.getNativeVideoController()).x();
            }
        }
    }

    public void setClosedListenerKey(String str) {
        this.r = str;
    }

    public void a(n nVar, NativeExpressView nativeExpressView, com.com.bytedance.overseas.sdk.a.c cVar) {
        setBackgroundColor(-16777216);
        this.c = nVar;
        this.m = nativeExpressView;
        this.n = cVar;
        this.f = "banner_ad";
        this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
        f();
    }

    private void f() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.j a2 = BannerExpressBackupView.a(this.m.getExpectExpressWidth(), this.m.getExpectExpressHeight());
        if (this.m.getExpectExpressWidth() <= 0 || this.m.getExpectExpressHeight() <= 0) {
            this.g = z.c(this.b);
            this.h = Float.valueOf(((float) this.g) / a2.b).intValue();
        } else {
            this.g = (int) z.b(this.b, (float) this.m.getExpectExpressWidth());
            this.h = (int) z.b(this.b, (float) this.m.getExpectExpressHeight());
        }
        if (this.g > 0 && this.g > z.c(this.b)) {
            float c = ((float) z.c(this.b)) / ((float) this.g);
            this.g = z.c(this.b);
            this.h = Float.valueOf(((float) this.h) * c).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.g, this.h);
        }
        layoutParams.width = this.g;
        layoutParams.height = this.h;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        g();
    }

    private void g() {
        if (this.c != null) {
            int ad = this.c.ad();
            this.o = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_backup_banner_layout_vast_video"), this, true);
            View findViewById = this.o.findViewById(t.e(this.b, "tt_bu_close"));
            View findViewById2 = this.o.findViewById(t.e(this.b, "tt_backup_logoLayout"));
            this.q = (ShadowImageView) this.o.findViewById(t.e(this.b, "tt_banner_mute"));
            View videoView = getVideoView();
            if (videoView instanceof NativeVideoTsView) {
                this.p = (NativeVideoTsView) videoView;
                this.p.setVideoAdLoadListener(this);
                this.p.setVideoAdInteractionListener(this);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(findViewById, g.CLOSE_AD));
                arrayList.add(new Pair(findViewById2, g.OTHER));
                arrayList.add(new Pair(this.q, g.VIDEO_CONTROLS));
                this.p.a((List<Pair<View, g>>) arrayList);
            }
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        TTWebsiteActivity.a(VastBannerBackupView.this.b, VastBannerBackupView.this.c, VastBannerBackupView.this.f);
                    }
                });
            }
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        VastBannerBackupView.this.a();
                    }
                });
                NativeExpressView nativeExpressView = this.m;
                if (nativeExpressView != null) {
                    if (nativeExpressView.getClickListener() != null) {
                        this.m.getClickListener().b(findViewById);
                    }
                    if (this.m.getClickCreativeListener() != null) {
                        this.m.getClickCreativeListener().b(findViewById);
                    }
                }
            }
            ShadowImageView shadowImageView = this.q;
            if (shadowImageView != null) {
                shadowImageView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        int i;
                        if (VastBannerBackupView.this.p != null) {
                            boolean z = !VastBannerBackupView.this.p.i();
                            VastBannerBackupView vastBannerBackupView = VastBannerBackupView.this;
                            if (z) {
                                i = t.d(vastBannerBackupView.getContext(), "tt_mute");
                            } else {
                                i = t.d(vastBannerBackupView.getContext(), "tt_unmute");
                            }
                            VastBannerBackupView.this.p.setIsQuiet(z);
                            VastBannerBackupView.this.q.setImageResource(i);
                            if (VastBannerBackupView.this.c != null && VastBannerBackupView.this.c.ax() != null && VastBannerBackupView.this.c.ax().a() != null) {
                                if (z) {
                                    VastBannerBackupView.this.c.ax().a().h(VastBannerBackupView.this.s);
                                } else {
                                    VastBannerBackupView.this.c.ax().a().i(VastBannerBackupView.this.s);
                                }
                            }
                        }
                    }
                });
            }
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) this.o.findViewById(t.e(this.b, "ratio_frame_layout"));
            if (!(this.c == null || this.c.ax() == null || ratioFrameLayout == null)) {
                int l = this.c.ax().l();
                float m2 = (float) this.c.ax().m();
                if (l > 0 && m2 > 0.0f) {
                    ratioFrameLayout.setRatio(((float) l) / m2);
                } else if (ad == 15) {
                    ratioFrameLayout.setRatio(0.5625f);
                } else if (ad == 5) {
                    ratioFrameLayout.setRatio(1.7777778f);
                } else {
                    ratioFrameLayout.setRatio(1.0f);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (!(videoView == null || ratioFrameLayout == null)) {
                ratioFrameLayout.addView(videoView, layoutParams);
                videoView.setTag(t.e(m.a(), "tt_id_is_video_picture"), true);
            }
            a(videoView, true);
            a(this, true);
            a((View) ratioFrameLayout);
        }
    }

    public void a() {
        if (this.e != null) {
            this.e.show();
        } else if (this.d != null) {
            this.d.showDislikeDialog();
        } else {
            TTDelegateActivity.a(this.c, this.r);
        }
    }

    public void a(int i, int i2) {
        ShadowImageView shadowImageView = this.q;
        if (shadowImageView != null) {
            shadowImageView.setVisibility(8);
        }
    }

    public void a(long j, long j2) {
        this.s = j;
        this.t = j2;
    }

    public void a_() {
        ShadowImageView shadowImageView = this.q;
        if (shadowImageView != null) {
            shadowImageView.setVisibility(8);
        }
    }

    public long getVideoProgress() {
        return this.s;
    }
}
