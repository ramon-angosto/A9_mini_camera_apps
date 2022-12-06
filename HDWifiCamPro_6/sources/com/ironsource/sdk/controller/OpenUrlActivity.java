package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.sdk.utils.b;
import java.util.List;

public class OpenUrlActivity extends Activity {
    private static final int a = SDKUtils.generateViewId();
    private static final int b = SDKUtils.generateViewId();
    private WebView c = null;
    /* access modifiers changed from: private */
    public x d;
    /* access modifiers changed from: private */
    public ProgressBar e;
    private boolean f;
    private RelativeLayout g;
    private String h;
    /* access modifiers changed from: private */
    public Handler i = new Handler();
    /* access modifiers changed from: private */
    public boolean j = false;
    /* access modifiers changed from: private */
    public final Runnable k = new Runnable() {
        public final void run() {
            OpenUrlActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(OpenUrlActivity.this.j));
        }
    };

    class a extends WebViewClient {
        private a() {
        }

        /* synthetic */ a(OpenUrlActivity openUrlActivity, byte b) {
            this();
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            OpenUrlActivity.this.e.setVisibility(4);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            OpenUrlActivity.this.e.setVisibility(0);
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e("OpenUrlActivity", "Chromium process crashed - detail.didCrash():" + renderProcessGoneDetail.didCrash());
            OpenUrlActivity.this.finish();
            return true;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            List<String> b = b.a().b();
            if (!b.isEmpty()) {
                for (String contains : b) {
                    if (str.contains(contains)) {
                        try {
                            OpenUrlActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            OpenUrlActivity.this.d.i();
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            if (e instanceof ActivityNotFoundException) {
                                sb.append("no activity to handle url");
                            } else {
                                sb.append("activity failed to open with unspecified reason");
                            }
                            if (OpenUrlActivity.this.d != null) {
                                x d = OpenUrlActivity.this.d;
                                String sb2 = sb.toString();
                                if (TextUtils.isEmpty(str)) {
                                    str = "unknown url";
                                }
                                d.b(x.b("failedToStartStoreActivity", x.a("errMsg", TextUtils.isEmpty(sb2) ? "activity failed to open with unspecified reason" : sb2, "url", str, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
                            }
                        }
                        OpenUrlActivity.this.finish();
                        return true;
                    }
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public void finish() {
        x xVar;
        if (this.f && (xVar = this.d) != null) {
            xVar.e("secondaryClose");
        }
        super.finish();
    }

    public void loadUrl(String str) {
        this.c.stopLoading();
        this.c.clearHistory();
        try {
            this.c.loadUrl(str);
        } catch (Throwable th) {
            Logger.e("OpenUrlActivity", "OpenUrlActivity:: loadUrl: " + th.toString());
        }
    }

    public void onBackPressed() {
        if (this.c.canGoBack()) {
            this.c.goBack();
        } else {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i("OpenUrlActivity", "onCreate()");
        try {
            this.d = (x) com.ironsource.sdk.d.b.a((Context) this).a.a;
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            Bundle extras = getIntent().getExtras();
            this.h = extras.getString(x.c);
            this.f = extras.getBoolean(x.d);
            this.j = getIntent().getBooleanExtra("immersive", false);
            if (this.j) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                    public final void onSystemUiVisibilityChange(int i) {
                        if ((i & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                            OpenUrlActivity.this.i.removeCallbacks(OpenUrlActivity.this.k);
                            OpenUrlActivity.this.i.postDelayed(OpenUrlActivity.this.k, 500);
                        }
                    }
                });
                runOnUiThread(this.k);
            }
            this.g = new RelativeLayout(this);
            setContentView(this.g, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.c;
        if (webView != null) {
            webView.destroy();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.j && (i2 == 25 || i2 == 24)) {
            this.i.postDelayed(this.k, 500);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ViewGroup viewGroup;
        super.onPause();
        x xVar = this.d;
        if (xVar != null) {
            xVar.a(false, "secondary");
            if (this.g != null && (viewGroup = (ViewGroup) this.c.getParent()) != null) {
                if (viewGroup.findViewById(a) != null) {
                    viewGroup.removeView(this.c);
                }
                if (viewGroup.findViewById(b) != null) {
                    viewGroup.removeView(this.e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.c == null) {
            this.c = new WebView(getApplicationContext());
            this.c.setId(a);
            this.c.getSettings().setJavaScriptEnabled(true);
            this.c.setWebViewClient(new a(this, (byte) 0));
            loadUrl(this.h);
        }
        if (findViewById(a) == null) {
            this.g.addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.e == null) {
            this.e = Build.VERSION.SDK_INT >= 11 ? new ProgressBar(new ContextThemeWrapper(this, 16973939)) : new ProgressBar(this);
            this.e.setId(b);
        }
        if (findViewById(b) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.e.setLayoutParams(layoutParams);
            this.e.setVisibility(4);
            this.g.addView(this.e);
        }
        x xVar = this.d;
        if (xVar != null) {
            xVar.a(true, "secondary");
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.j && z) {
            runOnUiThread(this.k);
        }
    }
}
