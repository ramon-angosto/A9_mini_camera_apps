package com.shix.shixipc.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.StyleCommon;
import shix.cykj.camera.R;

public class MenuHelepActivity extends BaseActivity implements View.OnClickListener {
    private Button back;
    WebView browser;
    private int position;
    private SharedPreferences preuser;
    private TextView tv_camera_setting;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.menuhelpp);
        this.position = getIntent().getIntExtra("position", 0);
        this.back = (Button) findViewById(R.id.back);
        this.back.setOnClickListener(this);
        this.tv_camera_setting = (TextView) findViewById(R.id.tv_camera_setting);
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        this.browser = (WebView) findViewById(R.id.webView1);
        this.browser.getSettings().setJavaScriptEnabled(true);
        this.browser.getSettings().setAllowFileAccess(false);
        WebSettings settings = this.browser.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        this.browser.getSettings().setJavaScriptEnabled(true);
        this.browser.getSettings().setSupportZoom(true);
        this.browser.getSettings().setBuiltInZoomControls(true);
        this.browser.getSettings().setUseWideViewPort(true);
        this.browser.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        this.browser.getSettings().setLoadWithOverviewMode(true);
        this.browser.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                MenuHelepActivity.this.setProgress(i * 100);
            }
        });
        this.browser.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        int i = this.position;
        if (i == 0) {
            this.tv_camera_setting.setText(R.string.heye_xy);
            this.browser.loadUrl("file:///android_asset/reads.html");
        } else if (i == 1) {
            this.tv_camera_setting.setText(R.string.main_me_help);
            this.browser.loadUrl("file:///android_asset/readx.html");
        } else {
            this.tv_camera_setting.setText("意见反馈");
            this.browser.loadUrl("file:///android_asset/readxx.html");
        }
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.browser.canGoBack()) {
            this.browser.goBack();
            return true;
        }
        finish();
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }
}
