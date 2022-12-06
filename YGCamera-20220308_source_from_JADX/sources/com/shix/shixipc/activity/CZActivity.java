package com.shix.shixipc.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import com.shix.shixipc.utils.CommonUtil;
import java.util.HashMap;
import shix.cykj.camera.R;

public class CZActivity extends BaseActivity implements View.OnClickListener {
    private Button back;
    WebView browser;
    private String did = "";
    private String iccid = "";
    private int positon;
    private SharedPreferences preuser;
    private TextView tv_camera_setting;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.menuhelpp);
        this.positon = getIntent().getIntExtra("positon", 0);
        this.back = (Button) findViewById(R.id.back);
        this.back.setOnClickListener(this);
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        this.browser = (WebView) findViewById(R.id.webView1);
        this.browser.getSettings().setJavaScriptEnabled(true);
        this.browser.getSettings().setAllowFileAccess(false);
        this.tv_camera_setting = (TextView) findViewById(R.id.tv_camera_setting);
        WebSettings settings = this.browser.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        this.did = getIntent().getStringExtra("did");
        this.iccid = this.preuser.getString("iccid" + this.did, "");
        this.tv_camera_setting.setText("ccid:" + this.iccid);
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
                CZActivity.this.setProgress(i * 100);
            }
        });
        this.browser.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
        new HashMap().put("Referer", "http://openh5.szlaina.com/Index/index/company_uuid/dd620aa1600f2a661b875eb253b95e70/iccid/898604491820C0622491/contact_phone/18888888888");
        String str = "http://openh5.szlaina.com/Index/index/company_uuid/dd620aa1600f2a661b875eb253b95e70/iccid/" + this.iccid + "/contact_phone/18888888888";
        CommonUtil.Log(1, "iccid:" + this.iccid);
        CommonUtil.Log(1, "StrURL:" + str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        startActivity(intent);
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
