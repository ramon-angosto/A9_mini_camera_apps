package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.work.WorkRequest;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.common.LandingPageLoadingLayout;
import com.bytedance.sdk.openadsdk.common.g;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.f.d;
import org.json.JSONObject;

public class TTVideoLandingPageLink2Activity extends TTVideoLandingPageActivity implements d {
    /* access modifiers changed from: private */
    public LandingPageLoadingLayout R;
    /* access modifiers changed from: private */
    public View S;
    /* access modifiers changed from: private */
    public View T;
    /* access modifiers changed from: private */
    public boolean U;
    private TextView V;
    private TextView W;
    private TextView X;
    /* access modifiers changed from: private */
    public TextView Y;
    private TTRoundRectImageView Z;
    private TextView aa;
    private TextView ab;
    /* access modifiers changed from: private */
    public long ac;
    /* access modifiers changed from: private */
    public boolean ad = false;
    /* access modifiers changed from: private */
    public boolean ae;
    /* access modifiers changed from: private */
    public g af;
    /* access modifiers changed from: private */
    public LinearLayout ag;

    /* access modifiers changed from: protected */
    public String a() {
        return "tt_activity_videolandingpage_link2";
    }

    /* access modifiers changed from: protected */
    public String c() {
        return "tt_top_back";
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.ae = m.d().n();
        super.onCreate(bundle);
        if (!TTAdSdk.isInitSuccess() || this.p == null || this.a == null) {
            finish();
            return;
        }
        this.a.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.a.d(this.e, this.i, this.g, this.M, true) {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoLandingPageLink2Activity.this.S != null && !TTVideoLandingPageLink2Activity.this.U) {
                        TTVideoLandingPageLink2Activity.this.S.setVisibility(8);
                    }
                    if (TTVideoLandingPageLink2Activity.this.ag != null) {
                        TTVideoLandingPageLink2Activity.this.ag.setVisibility(0);
                    }
                    boolean unused = TTVideoLandingPageLink2Activity.this.ad = true;
                    TTVideoLandingPageLink2Activity.this.m();
                    c.a((Context) TTVideoLandingPageLink2Activity.this, TTVideoLandingPageLink2Activity.this.p, TTVideoLandingPageLink2Activity.this.F, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.ac, true);
                } catch (Throwable unused2) {
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                long unused = TTVideoLandingPageLink2Activity.this.ac = System.currentTimeMillis();
            }
        });
        this.a.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.c(this.i, this.M) {
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoLandingPageLink2Activity.this.ae && TTVideoLandingPageLink2Activity.this.af != null && i == 100) {
                    TTVideoLandingPageLink2Activity.this.af.a(webView);
                }
                if (TTVideoLandingPageLink2Activity.this.C != null && !TTVideoLandingPageLink2Activity.this.isFinishing() && i == 100 && TTVideoLandingPageLink2Activity.this.C.isShown() && !TTVideoLandingPageLink2Activity.this.U) {
                    if (TTVideoLandingPageLink2Activity.this.S != null) {
                        TTVideoLandingPageLink2Activity.this.S.setVisibility(8);
                    }
                    if (TTVideoLandingPageLink2Activity.this.ag != null) {
                        TTVideoLandingPageLink2Activity.this.ag.setVisibility(0);
                    }
                    TTVideoLandingPageLink2Activity.this.m();
                }
                if (TTVideoLandingPageLink2Activity.this.R != null) {
                    TTVideoLandingPageLink2Activity.this.R.a(i);
                }
            }
        });
        this.aa = (TextView) findViewById(t.e(this, "tt_loading_tip"));
        if (!(this.aa == null || this.p.a() == null)) {
            this.aa.setText(this.p.a().c());
        }
        long j = WorkRequest.MIN_BACKOFF_MILLIS;
        if (!(this.p == null || this.p.a() == null)) {
            j = this.p.a().a() * 1000;
        }
        k.d().postDelayed(new Runnable() {
            public void run() {
                try {
                    boolean unused = TTVideoLandingPageLink2Activity.this.U = true;
                    if (TTVideoLandingPageLink2Activity.this.R != null) {
                        TTVideoLandingPageLink2Activity.this.R.b();
                    }
                    TTVideoLandingPageLink2Activity.this.T.setVisibility(0);
                    if (!TTVideoLandingPageLink2Activity.this.ad) {
                        c.a((Context) TTVideoLandingPageLink2Activity.this, TTVideoLandingPageLink2Activity.this.p, TTVideoLandingPageLink2Activity.this.F, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.ac, false);
                    }
                } catch (Exception unused2) {
                }
            }
        }, j);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.X = (TextView) findViewById(t.e(this, "tt_top_dislike"));
        TextView textView = this.X;
        if (textView != null) {
            textView.setText(t.a(m.a(), "tt_reward_feedback"));
            this.X.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTDelegateActivity.a(TTVideoLandingPageLink2Activity.this.p, "");
                }
            });
        }
        this.Y = (TextView) findViewById(t.e(this, "tt_top_skip"));
        this.R = (LandingPageLoadingLayout) findViewById(t.e(this, "tt_loading_layout"));
        this.S = findViewById(t.e(this.e, "tt_browser_webview_loading"));
        this.T = findViewById(t.e(this.e, "tt_back_container"));
        this.V = (TextView) findViewById(t.e(this.e, "tt_back_container_title"));
        this.W = (TextView) findViewById(t.e(this.e, "tt_back_container_des"));
        this.Z = (TTRoundRectImageView) findViewById(t.e(this.e, "tt_back_container_icon"));
        this.ab = (TextView) findViewById(t.e(this.e, "tt_back_container_download"));
        if (this.p.M() != null && !TextUtils.isEmpty(this.p.M().a())) {
            com.bytedance.sdk.openadsdk.i.d.a().a(this.p.M(), (ImageView) this.Z);
        }
        this.V.setText(this.p.K());
        this.W.setText(this.p.V());
        ((TextView) findViewById(t.e(this, "tt_ad_loading_logo"))).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTWebsiteActivity.a(TTVideoLandingPageLink2Activity.this.e, TTVideoLandingPageLink2Activity.this.p, TTVideoLandingPageLink2Activity.this.F);
            }
        });
        if (this.ae) {
            ((ViewStub) findViewById(t.e(this, "tt_browser_new_bottom_bar_view_stub"))).setVisibility(0);
            this.ag = (LinearLayout) findViewById(t.e(this, "tt_bottom_bar"));
            this.ag.setVisibility(8);
            this.af = new g(this, this.ag, this.a, this.p, "landingpage_split_screen");
            if (this.a.getWebView() != null) {
                this.a.getWebView().setOnTouchListener(new View.OnTouchListener() {
                    float a = 0.0f;

                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            this.a = motionEvent.getY();
                        }
                        if (motionEvent.getAction() == 2) {
                            float y = motionEvent.getY();
                            float f = this.a;
                            if (y - f > 8.0f) {
                                if (TTVideoLandingPageLink2Activity.this.af != null) {
                                    TTVideoLandingPageLink2Activity.this.af.a();
                                }
                                return false;
                            } else if (y - f < -8.0f && TTVideoLandingPageLink2Activity.this.af != null) {
                                TTVideoLandingPageLink2Activity.this.af.b();
                            }
                        }
                        return false;
                    }
                });
            }
        }
        LandingPageLoadingLayout landingPageLoadingLayout = this.R;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.a(this.p, this.F);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        c.a(this.e, this.p, "landingpage_split_screen", str, (JSONObject) null);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LandingPageLoadingLayout landingPageLoadingLayout = this.R;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.a();
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (f()) {
            super.e();
            if (this.n.getNativeVideoController() != null) {
                this.n.getNativeVideoController().a(false);
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.n.getNativeVideoController()).g(false);
                this.n.setIsNeedShowDetail(false);
                this.l.setClickable(true);
                this.l.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() != 0) {
                            return false;
                        }
                        TTVideoLandingPageLink2Activity.this.a("click_video");
                        return false;
                    }
                });
            }
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.c) this.n.getNativeVideoController()).a((c.a) new c.a() {
                public void a() {
                }

                public void a(long j, int i) {
                }

                public void b(long j, int i) {
                }

                public void a(long j, long j2) {
                    if (TTVideoLandingPageLink2Activity.this.Y != null) {
                        int max = (int) Math.max(0, (j2 - j) / 1000);
                        TextView k = TTVideoLandingPageLink2Activity.this.Y;
                        k.setText(max + "");
                        if (max <= 0) {
                            TTVideoLandingPageLink2Activity.this.Y.setVisibility(8);
                        }
                    }
                }
            });
            return;
        }
        try {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            com.bytedance.sdk.openadsdk.i.d.a().a(this.p.P().get(0), imageView);
            this.l.setVisibility(0);
            this.l.removeAllViews();
            this.l.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.c.c.b(m.a(), TTVideoLandingPageLink2Activity.this.p, "landingpage_split_screen");
                }
            });
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public boolean f() {
        return this.m == 5 || this.m == 15 || this.m == 50;
    }

    public void j() {
        super.j();
        if (this.p != null) {
            this.p.a(true);
        }
        TextView textView = this.ab;
        if (textView != null) {
            textView.setText(b());
            this.ab.setClickable(true);
            this.ab.setOnClickListener(this.Q);
            this.ab.setOnTouchListener(this.Q);
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        LandingPageLoadingLayout landingPageLoadingLayout = this.R;
        if (landingPageLoadingLayout != null) {
            landingPageLoadingLayout.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        m();
        if (!this.U && this.M != null && this.a != null && this.R.getVisibility() == 8) {
            this.M.a(this.a);
        }
        super.onDestroy();
    }
}
