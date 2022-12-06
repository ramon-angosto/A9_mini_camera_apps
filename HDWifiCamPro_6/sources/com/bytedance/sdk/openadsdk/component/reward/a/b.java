package com.bytedance.sdk.openadsdk.component.reward.a;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.HomeWatcherReceiver;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.c.h;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.a.d;
import com.bytedance.sdk.openadsdk.l.z;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: RewardFullPlayableManager */
public class b {
    protected final AtomicBoolean a = new AtomicBoolean(false);
    protected final AtomicBoolean b = new AtomicBoolean(false);
    boolean c = false;
    boolean d = false;
    long e = 0;
    int f = 0;
    int g = 0;
    int h = 0;
    private Activity i;
    /* access modifiers changed from: private */
    public n j;
    private f k;
    /* access modifiers changed from: private */
    public String l;
    private int m = 1;
    private PlayableLoadingView n;
    /* access modifiers changed from: private */
    public boolean o = true;
    private HomeWatcherReceiver p;
    private boolean q = false;

    public b(Activity activity) {
        this.i = activity;
    }

    public void a(f fVar, n nVar, String str, int i2) {
        if (!this.q) {
            this.q = true;
            this.k = fVar;
            this.j = nVar;
            this.l = str;
            this.m = i2;
            l();
        }
    }

    private void l() {
        Activity activity = this.i;
        this.n = (PlayableLoadingView) activity.findViewById(t.e(activity, "tt_reward_playable_loading"));
    }

    public boolean a() {
        if (this.n == null) {
            return false;
        }
        n nVar = this.j;
        if (nVar == null || !nVar.aO() || !p.i(this.j)) {
            this.n.a();
            return false;
        }
        this.n.b();
        return true;
    }

    public void b() {
        if (!this.a.getAndSet(true) && this.k.c() != null && this.k.d() != null) {
            z.a((View) this.k.c(), 0);
            z.a((View) this.k.d(), 8);
        }
    }

    public void a(DownloadListener downloadListener) {
        if (this.k.d() != null) {
            String m2 = m();
            if (!TextUtils.isEmpty(m2)) {
                this.k.d().setWebViewClient(new d(this.i, this.k.f(), this.j.Y(), (h) null, false) {
                    public void onPageFinished(WebView webView, String str) {
                        if (b.this.o) {
                            c.c(this.d, b.this.j, b.this.l, "loading_h5_success", (JSONObject) null);
                        }
                        super.onPageFinished(webView, str);
                    }

                    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                        boolean unused = b.this.o = false;
                    }

                    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                        boolean unused = b.this.o = false;
                    }

                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        boolean unused = b.this.o = false;
                    }
                });
                this.k.d().a(m2);
                this.k.d().setDisplayZoomControls(false);
                this.k.d().setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.a.c(this.k.f(), this.k.g()));
                this.k.d().setDownloadListener(downloadListener);
            }
        }
    }

    private String m() {
        n nVar;
        String s = m.d().s();
        l.c("Playable", "getPlayableLoadH5Url->loadH5Url=" + s);
        if (TextUtils.isEmpty(s) || (nVar = this.j) == null || nVar.aa() == null) {
            return s;
        }
        String b2 = this.j.aa().b();
        double d2 = this.j.aa().d();
        int e2 = this.j.aa().e();
        String a2 = (this.j.M() == null || TextUtils.isEmpty(this.j.M().a())) ? "" : this.j.M().a();
        String Y = this.j.Y();
        String c2 = this.j.aa().c();
        String a3 = this.j.aa().a();
        String b3 = this.j.aa().b();
        String U = this.j.U();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appname=");
        stringBuffer.append(URLEncoder.encode(b2));
        stringBuffer.append("&stars=");
        stringBuffer.append(d2);
        stringBuffer.append("&comments=");
        stringBuffer.append(e2);
        stringBuffer.append("&icon=");
        stringBuffer.append(URLEncoder.encode(a2));
        stringBuffer.append("&downloading=");
        stringBuffer.append(true);
        stringBuffer.append("&id=");
        stringBuffer.append(URLEncoder.encode(Y));
        stringBuffer.append("&packageName=");
        stringBuffer.append(URLEncoder.encode(c2));
        stringBuffer.append("&downloadUrl=");
        stringBuffer.append(URLEncoder.encode(a3));
        stringBuffer.append("&name=");
        stringBuffer.append(URLEncoder.encode(b3));
        stringBuffer.append("&orientation=");
        stringBuffer.append(this.m == 1 ? "portrait" : "landscape");
        stringBuffer.append("&apptitle=");
        stringBuffer.append(URLEncoder.encode(U));
        String str = s + "?" + stringBuffer.toString();
        l.c("Playable", "Playable-loadH5Url=" + str);
        return str;
    }

    public void c() {
        this.c = true;
    }

    public boolean d() {
        return this.c;
    }

    public void a(boolean z) {
        if (Build.VERSION.SDK_INT >= 19 && z) {
            this.k.c().setDomStorageEnabled(true);
        }
    }

    public void b(boolean z) {
        if (z) {
            try {
                if (!TextUtils.isEmpty(this.k.q()) && this.k.o() != 0) {
                    com.bytedance.sdk.openadsdk.h.b.a().a(this.k.q(), this.k.o(), this.k.p());
                }
            } catch (Throwable unused) {
            }
        }
        if (z) {
            try {
                if (!TextUtils.isEmpty(this.k.q())) {
                    com.bytedance.sdk.openadsdk.h.b.a().b(this.k.q());
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public void e() {
        try {
            this.p = new HomeWatcherReceiver();
            this.p.a(new HomeWatcherReceiver.a() {
                public void a() {
                    b.this.d = true;
                }

                public void b() {
                    b.this.d = true;
                }
            });
            this.i.getApplicationContext().registerReceiver(this.p, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Throwable unused) {
        }
    }

    public void a(Context context) {
        try {
            this.p.a((HomeWatcherReceiver.a) null);
            context.getApplicationContext().unregisterReceiver(this.p);
        } catch (Throwable unused) {
        }
    }

    public void a(String str) {
        if (this.d) {
            HashMap hashMap = new HashMap();
            hashMap.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(System.currentTimeMillis() - this.e));
            c.c((Context) this.i, this.j, this.l, str, (Map<String, Object>) hashMap);
            if ("return_foreground".equals(str)) {
                this.d = false;
            }
        }
    }

    public void f() {
        this.e = System.currentTimeMillis();
    }

    public void a(Map<String, Object> map) {
        if (map != null) {
            map.put(IronSourceConstants.EVENTS_DURATION, Long.valueOf(System.currentTimeMillis() - this.e));
        }
    }

    public void a(int i2) {
        PlayableLoadingView playableLoadingView = this.n;
        if (playableLoadingView != null) {
            playableLoadingView.setProgress(i2);
        }
    }

    public void a(e eVar) {
        PlayableLoadingView playableLoadingView = this.n;
        if (playableLoadingView != null && playableLoadingView.getPlayView() != null && p.i(this.j)) {
            this.n.getPlayView().setOnClickListener(eVar);
            this.n.getPlayView().setOnTouchListener(eVar);
        }
    }

    public void g() {
        PlayableLoadingView playableLoadingView = this.n;
        if (playableLoadingView != null) {
            playableLoadingView.a();
        }
    }

    public void h() {
        this.b.set(true);
    }

    public boolean i() {
        return this.b.get();
    }

    public int b(int i2) {
        return this.h - (this.g - i2);
    }

    public int j() {
        return this.g;
    }

    public int k() {
        return this.f;
    }

    public void a(int i2, n nVar, boolean z) {
        if (nVar != null) {
            this.g = nVar.at();
            this.h = m.d().a(String.valueOf(i2), z);
        }
    }

    public void c(int i2) {
        this.f = i2 - 1;
    }

    public void d(int i2) {
        this.f = i2;
    }
}
