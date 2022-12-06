package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.badge.BadgeDrawable;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.b.a;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.videocommon.d.c;
import java.util.List;
import org.json.JSONObject;

public class MBridgeBTWebView extends BTBaseView implements b {
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public String q;
    /* access modifiers changed from: private */
    public String r;
    private boolean s = false;
    private ImageView t;
    private boolean u = false;
    private c v;
    private List<CampaignEx> w;
    /* access modifiers changed from: private */
    public WindVaneWebView x;
    /* access modifiers changed from: private */
    public j y;
    /* access modifiers changed from: private */
    public WebView z;

    public void expand(String str, boolean z2) {
    }

    public c getRewardUnitSetting() {
        return this.v;
    }

    public void setRewardUnitSetting(c cVar) {
        this.v = cVar;
    }

    public List<CampaignEx> getCampaigns() {
        return this.w;
    }

    public void setCampaigns(List<CampaignEx> list) {
        this.w = list;
    }

    public void setCreateWebView(WebView webView) {
        this.z = webView;
    }

    public String getFileURL() {
        return this.p;
    }

    public void setFileURL(String str) {
        this.p = str;
        if (!TextUtils.isEmpty(str)) {
            boolean contains = str.contains("play.google.com");
            setWebviewClickable(!contains);
            if (contains) {
                com.mbridge.msdk.mbsignalcommon.base.c cVar = new com.mbridge.msdk.mbsignalcommon.base.c();
                WindVaneWebView windVaneWebView = this.x;
                if (windVaneWebView != null) {
                    windVaneWebView.setFilter(cVar);
                }
            }
        }
    }

    public String getFilePath() {
        return this.q;
    }

    public void setFilePath(String str) {
        this.q = str;
    }

    public String getHtml() {
        return this.r;
    }

    public void setHtml(String str) {
        this.r = str;
    }

    public WindVaneWebView getWebView() {
        return this.x;
    }

    public MBridgeBTWebView(Context context) {
        super(context);
    }

    public MBridgeBTWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setWebviewClickable(boolean z2) {
        WindVaneWebView windVaneWebView = this.x;
        if (windVaneWebView != null) {
            windVaneWebView.setClickable(z2);
        }
    }

    public void init(Context context) {
        this.x = new WindVaneWebView(context);
        this.x.setBackgroundColor(0);
        this.x.setVisibility(0);
        this.y = new j((Activity) null, this.b, this.w);
        this.y.a(this.c);
        this.x.setObject(this.y);
        this.x.setMraidObject(this);
        this.x.setWebViewListener(new a() {
            public final void a(Object obj) {
                super.a(obj);
                try {
                    String str = "";
                    String c = MBridgeBTWebView.this.y != null ? MBridgeBTWebView.this.y.c() : str;
                    if (!TextUtils.isEmpty(c)) {
                        str = Base64.encodeToString(c.getBytes(), 2);
                        q.a("RVWindVaneWebView", "getEndScreenInfo success");
                    } else {
                        q.a("RVWindVaneWebView", "getEndScreenInfo failed");
                    }
                    g.a().a(obj, str);
                } catch (Throwable th) {
                    q.a("RVWindVaneWebView", th.getMessage());
                }
            }

            public final void a(WebView webView, String str) {
                super.a(webView, str);
                if (MBridgeBTWebView.this.z != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.d);
                        jSONObject.put("code", BTBaseView.n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.d);
                        jSONObject2.put(IronSourceConstants.EVENTS_RESULT, 1);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.z, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        com.mbridge.msdk.video.bt.a.c.a().a(MBridgeBTWebView.this.z, e.getMessage());
                        q.a("RVWindVaneWebView", e.getMessage());
                    }
                }
                g.a().a(MBridgeBTWebView.this.x);
            }

            public final void a(WebView webView, int i, String str, String str2) {
                super.a(webView, i, str, str2);
                if (MBridgeBTWebView.this.z != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.d);
                        jSONObject.put("code", BTBaseView.n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.d);
                        jSONObject2.put(IronSourceConstants.EVENTS_RESULT, 2);
                        jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.z, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        com.mbridge.msdk.video.bt.a.c.a().a(MBridgeBTWebView.this.z, e.getMessage());
                        q.a("RVWindVaneWebView", e.getMessage());
                    }
                }
            }

            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.a(webView, sslErrorHandler, sslError);
                if (MBridgeBTWebView.this.z != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.d);
                        jSONObject.put("code", BTBaseView.n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.d);
                        jSONObject2.put(IronSourceConstants.EVENTS_RESULT, 2);
                        jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, sslError.toString());
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.z, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        com.mbridge.msdk.video.bt.a.c.a().a(MBridgeBTWebView.this.z, e.getMessage());
                        q.a("RVWindVaneWebView", e.getMessage());
                    }
                }
            }

            public final void a(WebView webView, int i) {
                super.a(webView, i);
            }
        });
        addView(this.x, new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBridgeBTWebView.this.z != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.n);
                        jSONObject.put("id", MBridgeBTWebView.this.d);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", String.valueOf(view.getX()));
                        jSONObject2.put("y", String.valueOf(view.getY()));
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        g.a().a(MBridgeBTWebView.this.z, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception unused) {
                        com.mbridge.msdk.video.bt.a.c.a().a(MBridgeBTWebView.this.z, "onClicked", MBridgeBTWebView.this.d);
                    }
                }
            }
        });
        try {
            this.t = new ImageView(getContext());
            this.t.setImageResource(findDrawable("mbridge_reward_close"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
            layoutParams.gravity = BadgeDrawable.TOP_END;
            layoutParams.setMargins(30, 30, 30, 30);
            this.t.setLayoutParams(layoutParams);
            this.t.setVisibility(this.s ? 4 : 8);
            if (this.b != null && this.b.isMraid()) {
                this.t.setVisibility(4);
            }
            this.t.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeBTWebView.this.close();
                }
            });
            addView(this.t);
        } catch (Throwable th) {
            q.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void setWebViewRid(String str) {
        WindVaneWebView windVaneWebView = this.x;
        if (windVaneWebView != null) {
            windVaneWebView.setRid(str);
        }
    }

    public void preload() {
        if (!TextUtils.isEmpty(this.p)) {
            this.x.loadUrl(this.p);
        } else if (!TextUtils.isEmpty(this.q)) {
            this.x.loadUrl(this.q);
        } else if (!TextUtils.isEmpty(this.r)) {
            this.x.loadDataWithBaseURL("", this.r, "text/html", "UTF-8", (String) null);
        }
    }

    public void webviewLoad(int i) {
        if (this.y == null) {
            this.y = new j((Activity) null, this.b, this.w);
        }
        if (this.b != null) {
            this.y.a(this.b);
        } else {
            List<CampaignEx> list = this.w;
            if (list != null && list.size() > 0) {
                this.y.a(this.w);
                if (this.w.size() == 1) {
                    this.y.a(this.w.get(0));
                }
            }
        }
        c cVar = this.v;
        if (cVar != null) {
            this.y.a(cVar);
        }
        this.y.a(this.c);
        this.y.c(this.d);
        if (i == 1) {
            this.y.n();
        }
        WindVaneWebView windVaneWebView = this.x;
        if (windVaneWebView != null) {
            windVaneWebView.setObject(this.y);
        }
        if (this.b != null && this.b.isMraid()) {
            this.t.setVisibility(4);
        }
        preload();
    }

    public boolean webviewReload() {
        WindVaneWebView windVaneWebView = this.x;
        if (windVaneWebView == null) {
            return false;
        }
        windVaneWebView.reload();
        return true;
    }

    public boolean webviewGoBack() {
        WindVaneWebView windVaneWebView = this.x;
        if (windVaneWebView == null || !windVaneWebView.canGoBack()) {
            return false;
        }
        this.x.goBack();
        return true;
    }

    public boolean webviewGoForward() {
        WindVaneWebView windVaneWebView = this.x;
        if (windVaneWebView == null || !windVaneWebView.canGoForward()) {
            return false;
        }
        this.x.goForward();
        return true;
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.x != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", n);
                jSONObject2.put("id", this.d);
                jSONObject2.put("eventName", str);
                jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
                g.a().a((WebView) this.x, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                com.mbridge.msdk.video.bt.a.c.a().a((WebView) this.x, "broadcast", this.d);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.x != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (configuration.orientation == 2) {
                    jSONObject.put("orientation", "landscape");
                } else {
                    jSONObject.put("orientation", "portrait");
                }
                jSONObject.put("instanceId", this.d);
                g.a().a((WebView) this.x, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onBackPressed() {
        if (this.x != null) {
            com.mbridge.msdk.video.bt.a.c.a().a((WebView) this.x, "onSystemBackPressed", this.d);
        }
    }

    public void onDestory() {
        if (!this.u) {
            this.u = true;
            try {
                if (this.x != null) {
                    com.mbridge.msdk.video.bt.a.c.a().a((WebView) this.x, "onSystemDestory", this.d);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        try {
                            if (MBridgeBTWebView.this.x != null) {
                                MBridgeBTWebView.this.x.clearWebView();
                                MBridgeBTWebView.this.x.release();
                            }
                            String unused = MBridgeBTWebView.this.p = null;
                            String unused2 = MBridgeBTWebView.this.q = null;
                            String unused3 = MBridgeBTWebView.this.r = null;
                            if (MBridgeBTWebView.this.z != null) {
                                WebView unused4 = MBridgeBTWebView.this.z = null;
                            }
                        } catch (Throwable th) {
                            q.a(BTBaseView.TAG, th.getMessage());
                        }
                    }
                }, 500);
                setOnClickListener((View.OnClickListener) null);
                removeAllViews();
            } catch (Throwable th) {
                q.a(BTBaseView.TAG, th.getMessage());
            }
        }
    }

    public void open(String str) {
        String clickURL;
        try {
            clickURL = this.b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.b.setClickURL(str);
                CampaignEx mraidCampaign = getMraidCampaign();
                if (mraidCampaign != null) {
                    new com.mbridge.msdk.foundation.same.report.c(getContext()).b(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.c, str, this.b.isBidCampaign());
                }
            }
        } catch (Throwable th) {
            q.d(BTBaseView.TAG, th.getMessage());
            return;
        }
        new com.mbridge.msdk.click.a(getContext(), this.c).a(this.b);
        this.b.setClickURL(clickURL);
    }

    public void close() {
        WebView webView = this.z;
        if (webView != null) {
            a(webView, "onPlayerCloseBtnClicked", this.d);
        }
    }

    public void unload() {
        close();
    }

    public CampaignEx getMraidCampaign() {
        return this.b;
    }

    public void useCustomClose(boolean z2) {
        try {
            this.t.setVisibility(z2 ? 4 : 0);
        } catch (Throwable th) {
            q.d(BTBaseView.TAG, th.getMessage());
        }
    }
}
