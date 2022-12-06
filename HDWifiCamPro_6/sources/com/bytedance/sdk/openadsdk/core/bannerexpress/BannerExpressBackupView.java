package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.j;
import com.bytedance.sdk.openadsdk.core.widget.RatioFrameLayout;
import com.bytedance.sdk.openadsdk.core.widget.RatioImageView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.z;
import ms.bd.o.Pgl.c;

public class BannerExpressBackupView extends BackupView {
    public static j[] a = {new j(1, 6.4f, 320, 50), new j(4, 1.2f, c.COLLECT_MODE_FINANCE, 250)};
    private View m;
    private NativeExpressView n;
    private com.com.bytedance.overseas.sdk.a.c o;
    private int p = 1;
    private String q;

    public void setClosedListenerKey(String str) {
        this.q = str;
    }

    public BannerExpressBackupView(Context context) {
        super(context);
        this.b = context;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i, com.bytedance.sdk.openadsdk.core.model.j jVar) {
        if (this.n != null) {
            if (i == 1 || i == 2) {
                View findViewById = this.m.findViewById(t.e(this.b, "tt_bu_close"));
                if (i == 1) {
                    this.n.getClickListener().b(findViewById);
                } else {
                    this.n.getClickCreativeListener().b(findViewById);
                }
            }
            this.n.a(view, i, jVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(n nVar, NativeExpressView nativeExpressView, com.com.bytedance.overseas.sdk.a.c cVar) {
        setBackgroundColor(-1);
        this.c = nVar;
        this.n = nativeExpressView;
        this.o = cVar;
        this.f = "banner_ad";
        this.n.addView(this, new ViewGroup.LayoutParams(-2, -2));
        b();
    }

    private void b() {
        j a2 = a(this.n.getExpectExpressWidth(), this.n.getExpectExpressHeight());
        if (this.n.getExpectExpressWidth() <= 0 || this.n.getExpectExpressHeight() <= 0) {
            this.g = z.c(this.b);
            this.h = Float.valueOf(((float) this.g) / a2.b).intValue();
        } else {
            this.g = (int) z.b(this.b, (float) this.n.getExpectExpressWidth());
            this.h = (int) z.b(this.b, (float) this.n.getExpectExpressHeight());
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
        if (a2.a == 1) {
            c();
        } else if (a2.a == 4) {
            d();
        } else {
            d();
        }
    }

    private void a(ImageView imageView) {
        d.a().a(this.c.P().get(0), imageView);
    }

    private void c() {
        float b = (((float) this.h) * 1.0f) / z.b(this.b, 50.0f);
        if ((((float) this.h) * 1.0f) / ((float) this.g) > 0.21875f) {
            b = (((float) this.g) * 1.0f) / z.b(this.b, 320.0f);
        }
        this.m = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_backup_banner_layout1"), this, true);
        View findViewById = this.m.findViewById(t.e(this.b, "tt_bu_close"));
        ImageView imageView = (ImageView) this.m.findViewById(t.e(this.b, "tt_bu_icon"));
        TextView textView = (TextView) this.m.findViewById(t.e(this.b, "tt_bu_title"));
        TextView textView2 = (TextView) this.m.findViewById(t.e(this.b, "tt_bu_score"));
        TTRatingBar2 tTRatingBar2 = (TTRatingBar2) this.m.findViewById(t.e(this.b, "tt_bu_score_bar"));
        TextView textView3 = (TextView) this.m.findViewById(t.e(this.b, "tt_bu_download"));
        textView.setTextSize(2, ((float) z.a(this.b, textView.getTextSize())) * b);
        textView2.setTextSize(2, ((float) z.a(this.b, textView2.getTextSize())) * b);
        textView3.setTextSize(2, ((float) z.a(this.b, textView3.getTextSize())) * b);
        View findViewById2 = this.m.findViewById(t.e(this.b, "tt_backup_logoLayout"));
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTWebsiteActivity.a(BannerExpressBackupView.this.b, BannerExpressBackupView.this.c, BannerExpressBackupView.this.f);
                }
            });
        }
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (z.b(this.b, 45.0f) * b);
            layoutParams.height = (int) (z.b(this.b, 45.0f) * b);
        }
        if (this.c.M() != null && !TextUtils.isEmpty(this.c.M().a())) {
            d.a().a(this.c.M().a(), imageView);
        }
        textView.setText(getTitle());
        if (!TextUtils.isEmpty(this.c.W())) {
            textView3.setText(this.c.W());
        } else {
            textView3.setVisibility(8);
        }
        z.a(textView2, tTRatingBar2, this.c, this.b);
        a(imageView, true);
        imageView.setTag(t.e(m.a(), "tt_id_is_video_picture"), true);
        a(this, true);
        a(textView3, true);
    }

    private void d() {
        String str;
        if (this.c != null) {
            int ad = this.c.ad();
            float b = (((float) this.h) * 1.0f) / z.b(this.b, 250.0f);
            if (this.c.J() == null) {
                this.m = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_backup_banner_layout4"), this, true);
                View findViewById = this.m.findViewById(t.e(this.b, "tt_bu_close"));
                RatioImageView ratioImageView = (RatioImageView) this.m.findViewById(t.e(this.b, "ratio_image_view"));
                ImageView imageView = (ImageView) this.m.findViewById(t.e(this.b, "tt_bu_icon"));
                TextView textView = (TextView) this.m.findViewById(t.e(this.b, "tt_bu_title"));
                TextView textView2 = (TextView) this.m.findViewById(t.e(this.b, "tt_bu_desc"));
                TextView textView3 = (TextView) this.m.findViewById(t.e(this.b, "tt_bu_name"));
                TextView textView4 = (TextView) this.m.findViewById(t.e(this.b, "tt_bu_download"));
                FrameLayout frameLayout = (FrameLayout) this.m.findViewById(t.e(this.b, "tt_image_layout"));
                LinearLayout linearLayout = (LinearLayout) this.m.findViewById(t.e(this.b, "tt_bu_total_title"));
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                if (layoutParams != null) {
                    str = "tt_id_is_video_picture";
                    layoutParams.width = (int) (z.b(this.b, 45.0f) * b);
                    layoutParams.height = (int) (z.b(this.b, 45.0f) * b);
                } else {
                    str = "tt_id_is_video_picture";
                }
                textView.setTextSize(2, ((float) z.a(this.b, textView.getTextSize())) * b);
                textView2.setTextSize(2, ((float) z.a(this.b, textView2.getTextSize())) * b);
                textView3.setTextSize(2, ((float) z.a(this.b, textView3.getTextSize())) * b);
                textView4.setTextSize(2, ((float) z.a(this.b, textView4.getTextSize())) * b);
                try {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                    float f = b - 1.0f;
                    if (f > 0.0f) {
                        layoutParams2.topMargin = (int) z.b(this.b, f * 8.0f);
                    }
                    ((LinearLayout.LayoutParams) textView4.getLayoutParams()).setMargins(0, (int) (z.b(this.b, 16.0f) * b), 0, 0);
                } catch (Throwable unused) {
                }
                View findViewById2 = this.m.findViewById(t.e(this.b, "tt_backup_logoLayout"));
                if (findViewById2 != null) {
                    findViewById2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            TTWebsiteActivity.a(BannerExpressBackupView.this.b, BannerExpressBackupView.this.c, BannerExpressBackupView.this.f);
                        }
                    });
                }
                if (ad == 33) {
                    ratioImageView.setRatio(1.0f);
                } else {
                    ((LinearLayout.LayoutParams) frameLayout.getLayoutParams()).weight = 2.5f;
                    ratioImageView.setRatio(1.91f);
                }
                findViewById.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BannerExpressBackupView.this.a();
                    }
                });
                int b2 = (int) z.b(this.b, 15.0f);
                z.a(findViewById, b2, b2, b2, b2);
                a((ImageView) ratioImageView);
                if (this.c.M() != null && !TextUtils.isEmpty(this.c.M().a())) {
                    d.a().a(this.c.M().a(), imageView);
                }
                textView3.setText(getNameOrSource());
                textView.setText(getNameOrSource());
                textView2.setText(getDescription());
                if (!TextUtils.isEmpty(this.c.W())) {
                    textView4.setText(this.c.W());
                } else {
                    textView4.setVisibility(8);
                }
                a(ratioImageView, true);
                ratioImageView.setTag(t.e(m.a(), str), true);
                a(this, true);
                a(textView4, true);
                return;
            }
            String str2 = "tt_id_is_video_picture";
            this.m = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_backup_banner_layout4_video"), this, true);
            View findViewById3 = this.m.findViewById(t.e(this.b, "tt_bu_close"));
            TextView textView5 = (TextView) this.m.findViewById(t.e(this.b, "tt_bu_title"));
            TextView textView6 = (TextView) this.m.findViewById(t.e(this.b, "tt_bu_desc"));
            TextView textView7 = (TextView) this.m.findViewById(t.e(this.b, "tt_bu_download"));
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) this.m.findViewById(t.e(this.b, "ratio_frame_layout"));
            textView5.setTextSize(2, ((float) z.a(this.b, textView5.getTextSize())) * b);
            textView6.setTextSize(2, ((float) z.a(this.b, textView6.getTextSize())) * b);
            textView7.setTextSize(2, ((float) z.a(this.b, textView7.getTextSize())) * b);
            View findViewById4 = this.m.findViewById(t.e(this.b, "tt_backup_logoLayout"));
            if (findViewById4 != null) {
                findViewById4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        TTWebsiteActivity.a(BannerExpressBackupView.this.b, BannerExpressBackupView.this.c, BannerExpressBackupView.this.f);
                    }
                });
            }
            if (ad == 15) {
                ratioFrameLayout.setRatio(0.5625f);
            } else if (ad == 5) {
                ratioFrameLayout.setRatio(1.7777778f);
            } else {
                ratioFrameLayout.setRatio(1.0f);
            }
            ratioFrameLayout.removeAllViews();
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            View videoView = getVideoView();
            if (videoView != null) {
                ratioFrameLayout.addView(videoView, layoutParams3);
            }
            textView5.setText(getNameOrSource());
            textView6.setText(getDescription());
            if (!TextUtils.isEmpty(this.c.W())) {
                textView7.setText(this.c.W());
            } else {
                textView7.setVisibility(8);
            }
            findViewById3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    BannerExpressBackupView.this.a();
                }
            });
            int b3 = (int) z.b(this.b, 15.0f);
            z.a(findViewById3, b3, b3, b3, b3);
            a(videoView, true);
            videoView.setTag(t.e(m.a(), str2), true);
            a(this, true);
            a(textView7, true);
            a((View) ratioFrameLayout);
        }
    }

    public static j a(int i, int i2) {
        try {
            return ((double) i2) >= Math.floor((((double) i) * 450.0d) / 600.0d) ? a[1] : a[0];
        } catch (Throwable unused) {
            return a[0];
        }
    }

    public void a() {
        if (this.e != null) {
            this.e.show();
        } else if (this.d != null) {
            this.d.showDislikeDialog();
        } else {
            TTDelegateActivity.a(this.c, this.q);
        }
    }
}
