package com.shix.shixipc.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;

public class MenuHelepActivity extends BaseActivity implements View.OnClickListener {
    private Button back;
    private String pictureName;
    /* access modifiers changed from: private */
    public SharedPreferences preuser;
    private String strHtml;
    private int type = 0;
    WebView wvDirectionForUse;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.menuhelpp);
        this.type = getIntent().getIntExtra("type", 0);
        this.back = (Button) findViewById(R.id.back);
        this.back.setOnClickListener(this);
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        this.wvDirectionForUse = (WebView) findViewById(R.id.webView1);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        findViewById(R.id.btn_readok).setVisibility(8);
        findViewById(R.id.btn_readcancel).setVisibility(8);
        findViewById(R.id.btn_readcancel).setOnClickListener(this);
        if (this.type == 10) {
            textView.setText(R.string.heye_xy);
            findViewById(R.id.btn_readok).setVisibility(0);
            findViewById(R.id.btn_readcancel).setVisibility(0);
        } else {
            textView.setText(R.string.heye_xy);
        }
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        initComponent1();
        initHtmlCode();
        loadHtmlCode();
        findViewById(R.id.btn_readok).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SharedPreferences.Editor edit = MenuHelepActivity.this.preuser.edit();
                edit.putInt("firstGo", 1);
                edit.commit();
                MenuHelepActivity.this.finish();
            }
        });
    }

    private void backPreviousActivity() {
        finish();
    }

    private void initComponent1() {
        this.wvDirectionForUse.getSettings().setJavaScriptEnabled(true);
        this.wvDirectionForUse.getSettings().setSupportZoom(true);
        this.wvDirectionForUse.getSettings().setBuiltInZoomControls(true);
        this.wvDirectionForUse.getSettings().setUseWideViewPort(true);
        this.wvDirectionForUse.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        this.wvDirectionForUse.getSettings().setLoadWithOverviewMode(true);
        this.wvDirectionForUse.setWebViewClient(new WebViewClientDemo());
    }

    private class WebViewClientDemo extends WebViewClient {
        private WebViewClientDemo() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    private void initHtmlCode() {
        if (getResources().getString(R.string.camera_user).equalsIgnoreCase("用户名")) {
            int i = this.type;
            if (i == 10) {
                this.pictureName = "shix_ys.html";
            } else if (i == 0) {
                this.pictureName = "shix_ys.html";
            } else if (i == 1) {
                this.pictureName = "shix_fwu.html";
            } else {
                this.pictureName = "shix_help.html";
            }
        } else {
            int i2 = this.type;
            if (i2 == 10) {
                this.pictureName = "shix_ys_en.html";
            } else if (i2 == 0) {
                this.pictureName = "shix_ys_en.html";
            } else if (i2 == 1) {
                this.pictureName = "shix_fwu_en.html";
            } else {
                this.pictureName = "shix_help_en.html";
            }
        }
        this.strHtml = "<img alt=\"XXX\" src=\"file:///android_asset/" + this.pictureName + "\" />";
    }

    private void loadHtmlCode() {
        if (getResources().getString(R.string.camera_user).equalsIgnoreCase("用户名")) {
            int i = this.type;
            if (i == 10) {
                this.pictureName = "shix_ys.html";
                this.wvDirectionForUse.loadUrl(" file:///android_asset/shix_ys.html");
            } else if (i == 0) {
                this.pictureName = "shix_ys.html";
                this.wvDirectionForUse.loadUrl(" file:///android_asset/shix_ys.html");
            } else if (i == 1) {
                this.pictureName = "shix_fwu.html";
                this.wvDirectionForUse.loadUrl(" file:///android_asset/shix_fwu.html");
            } else {
                this.pictureName = "shix_help.html";
                this.wvDirectionForUse.loadUrl(" file:///android_asset/shix_help.html");
            }
        } else {
            int i2 = this.type;
            if (i2 == 10) {
                this.pictureName = "shix_ys_en.html";
                this.wvDirectionForUse.loadUrl(" file:///android_asset/shix_ys_en.html");
            } else if (i2 == 0) {
                this.pictureName = "shix_ys_en.html";
                this.wvDirectionForUse.loadUrl(" file:///android_asset/shix_ys_en.html");
            } else if (i2 == 1) {
                this.pictureName = "shix_fwu_en.html";
                this.wvDirectionForUse.loadUrl(" file:///android_asset/shix_fwu_en.html");
            } else {
                this.pictureName = "shix_help_en.html";
                this.wvDirectionForUse.loadUrl(" file:///android_asset/shix_help_en.html");
            }
        }
    }

    private void setTranslucentStatus(Activity activity, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
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
        SharedPreferences.Editor edit = this.preuser.edit();
        edit.putInt("firstGo", 1);
        edit.commit();
        finish();
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        int id = view.getId();
        if (id == R.id.back || id == R.id.btn_readcancel) {
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }
}
