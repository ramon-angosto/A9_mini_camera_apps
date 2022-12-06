package com.bytedance.sdk.openadsdk.common;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import org.json.JSONObject;

/* compiled from: TTBottomNewStyleManager */
public class g {
    private final LinearLayout a;
    /* access modifiers changed from: private */
    public final SSWebView b;
    private final n c;
    private final String d;
    /* access modifiers changed from: private */
    public Context e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;

    public g(Context context, LinearLayout linearLayout, SSWebView sSWebView, n nVar, String str) {
        this.e = context;
        this.a = linearLayout;
        this.b = sSWebView;
        this.c = nVar;
        this.d = str;
        c();
    }

    private void c() {
        this.f = (ImageView) this.a.findViewById(t.e(this.e, "tt_bottom_bar_back"));
        this.g = (ImageView) this.a.findViewById(t.e(this.e, "tt_bottom_bar_forward"));
        this.h = (ImageView) this.a.findViewById(t.e(this.e, "tt_bottom_bar_refresh"));
        this.i = (ImageView) this.a.findViewById(t.e(this.e, "tt_bottom_bar_go_to_browser"));
        this.f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (g.this.b != null && g.this.b.e()) {
                    g.this.a("backward");
                    g.this.b.f();
                }
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (g.this.b != null && g.this.b.g()) {
                    g.this.a("forward");
                    g.this.b.h();
                }
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (g.this.b != null) {
                    g.this.b("refresh");
                    g.this.b.d();
                }
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (g.this.b != null) {
                    g.this.b("external_btn_click");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    String url = g.this.b.getUrl();
                    if (!TextUtils.isEmpty(url)) {
                        intent.setData(Uri.parse(url));
                        b.a(g.this.e, intent, (b.a) null);
                    }
                }
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.f.setClickable(false);
        this.g.setClickable(false);
        this.f.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
        this.g.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
    }

    public void a(WebView webView) {
        try {
            if (this.f != null) {
                if (webView.canGoBack()) {
                    this.f.setClickable(true);
                    this.f.clearColorFilter();
                } else {
                    this.f.setClickable(false);
                    this.f.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
                }
            }
            if (this.g == null) {
                return;
            }
            if (webView.canGoForward()) {
                this.g.setClickable(true);
                this.g.clearColorFilter();
                return;
            }
            this.g.setClickable(false);
            this.g.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (this.a.getAlpha() == 0.0f) {
            ObjectAnimator.ofFloat(this.a, "alpha", new float[]{0.0f, 1.0f}).setDuration(300).start();
        }
    }

    public void b() {
        if (this.a.getAlpha() == 1.0f) {
            ObjectAnimator.ofFloat(this.a, "alpha", new float[]{1.0f, 0.0f}).setDuration(300).start();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        WebBackForwardList copyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!(this.b.getWebView() == null || (copyBackForwardList = this.b.getWebView().copyBackForwardList()) == null)) {
                int currentIndex = copyBackForwardList.getCurrentIndex();
                String url = copyBackForwardList.getItemAtIndex(currentIndex).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.b.getUrl();
                }
                String str2 = "";
                if (str.equals("backward")) {
                    str2 = copyBackForwardList.getItemAtIndex(currentIndex - 1).getUrl();
                }
                int i2 = 1;
                if (str.equals("forward")) {
                    str2 = copyBackForwardList.getItemAtIndex(currentIndex + 1).getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("next_url", str2);
                if (copyBackForwardList.getCurrentIndex() != 0) {
                    i2 = 0;
                }
                jSONObject2.putOpt("first_page", Integer.valueOf(i2));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        c.c(m.a(), this.c, this.d, str, jSONObject);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        WebBackForwardList copyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!(this.b.getWebView() == null || (copyBackForwardList = this.b.getWebView().copyBackForwardList()) == null)) {
                String url = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex()).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.b.getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("first_page", Integer.valueOf(copyBackForwardList.getCurrentIndex() == 0 ? 1 : 0));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        c.c(m.a(), this.c, this.d, str, jSONObject);
    }
}
