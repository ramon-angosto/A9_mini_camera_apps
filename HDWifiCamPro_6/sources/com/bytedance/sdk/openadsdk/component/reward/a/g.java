package com.bytedance.sdk.openadsdk.component.reward.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.f.c;
import com.bytedance.sdk.openadsdk.core.f.e;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.e.a;
import com.bytedance.sdk.openadsdk.l.z;
import org.json.JSONObject;

/* compiled from: VastEndCardManager */
public class g {
    private final Activity a;
    /* access modifiers changed from: private */
    public n b;
    private FrameLayout c;
    private SSWebView d;
    /* access modifiers changed from: private */
    public ImageView e;
    private boolean f;
    private com.bytedance.sdk.openadsdk.core.b.g g;
    private e h;
    /* access modifiers changed from: private */
    public boolean i;

    public g(Activity activity) {
        this.a = activity;
    }

    public void a(n nVar) {
        c c2;
        Activity activity = this.a;
        if (activity != null) {
            this.b = nVar;
            this.c = (FrameLayout) activity.findViewById(t.e(activity, "tt_reward_full_endcard_vast"));
            if (this.b.ax() != null && (c2 = this.b.ax().c()) != null) {
                final String e2 = c2.e();
                if (!TextUtils.isEmpty(e2)) {
                    this.f = true;
                    Activity activity2 = this.a;
                    this.e = (ImageView) activity2.findViewById(t.e(activity2, "tt_reward_full_endcard_vast_image"));
                    a(c2.b(), c2.c(), this.b.ax());
                    a.a(e2).a(u.BITMAP).a((o) new o<Bitmap>() {
                        public void a(k<Bitmap> kVar) {
                            if (g.this.e != null && kVar != null) {
                                Bitmap b2 = kVar.b();
                                if (b2 == null) {
                                    g.this.a(-1, e2);
                                    return;
                                }
                                g.this.e.setImageBitmap(b2);
                                boolean unused = g.this.i = true;
                            }
                        }

                        public void a(int i, String str, Throwable th) {
                            if (g.this.e != null) {
                                g.this.e.setVisibility(8);
                            }
                            g.this.a(-2, e2);
                        }
                    });
                    return;
                }
                Activity activity3 = this.a;
                this.d = (SSWebView) activity3.findViewById(t.e(activity3, "tt_reward_full_endcard_vast_web"));
                b();
                String d2 = c2.d();
                if (d2 != null) {
                    this.f = true;
                    if (d2.startsWith("http")) {
                        this.d.a(d2);
                        return;
                    }
                    String a2 = e.a(d2);
                    String str = TextUtils.isEmpty(a2) ? d2 : a2;
                    this.d.setDefaultTextEncodingName("UTF -8");
                    this.d.a((String) null, str, "text/html", "UTF-8", (String) null);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final int i2, final String str) {
        com.bytedance.sdk.openadsdk.c.c.a((com.bytedance.sdk.component.g.g) new com.bytedance.sdk.component.g.g("load_vast_endcard_fail") {
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("reason_code", i2);
                    if (str != null) {
                        jSONObject.put("url", str);
                    }
                    String str = "";
                    if (g.this.b.ax() != null) {
                        str = g.this.b.ax().k();
                    }
                    com.bytedance.sdk.openadsdk.c.c.b(m.a(), g.this.b, str, "load_vast_endcard_fail", jSONObject);
                } catch (Exception unused) {
                }
            }
        });
    }

    private void b() {
        this.d.setWebViewClient(new SSWebView.a() {
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (Build.VERSION.SDK_INT >= 21 && webResourceRequest.isForMainFrame()) {
                    int statusCode = webResourceResponse.getStatusCode();
                    String str = null;
                    if (webResourceRequest.getUrl() != null) {
                        str = webResourceRequest.getUrl().toString();
                    }
                    g.this.a(statusCode, str);
                }
            }
        });
    }

    private void a(int i2, int i3, com.bytedance.sdk.openadsdk.core.f.a aVar) {
        Activity activity;
        if (i2 != 0 && i3 != 0 && this.e != null && (activity = this.a) != null) {
            int c2 = z.c((Context) activity);
            int d2 = z.d((Context) this.a);
            float f2 = ((float) i2) / ((float) i3);
            float f3 = (float) c2;
            if (f2 <= f3 / ((float) d2)) {
                c2 = (int) Math.ceil((double) (f3 * f2));
            } else {
                d2 = (int) Math.ceil((double) (f3 / f2));
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.width = c2;
            layoutParams.height = d2;
            this.e.setLayoutParams(layoutParams);
            this.g = new com.bytedance.sdk.openadsdk.core.b.g("VAST_END_CARD", aVar) {
                public void a() {
                }
            };
            this.e.setOnClickListener(this.g);
            this.e.setOnTouchListener(this.g);
        }
    }

    public void a() {
        z.a((View) this.c, 8);
    }

    public boolean a(e eVar) {
        c c2;
        if (!this.f) {
            return false;
        }
        this.h = eVar;
        ImageView imageView = this.e;
        if (imageView == null || !this.i) {
            SSWebView sSWebView = this.d;
            if (sSWebView != null) {
                sSWebView.setVisibility(0);
            }
        } else {
            imageView.setVisibility(0);
        }
        z.a((View) this.c, 0);
        n nVar = this.b;
        if (nVar == null || nVar.ax() == null || (c2 = this.b.ax().c()) == null) {
            return true;
        }
        e eVar2 = this.h;
        c2.b(eVar2 != null ? eVar2.s() : -1);
        return true;
    }

    public void a(com.bytedance.sdk.openadsdk.core.b.e eVar) {
        com.bytedance.sdk.openadsdk.core.b.g gVar = this.g;
        if (gVar != null) {
            gVar.a(eVar);
        }
    }
}
