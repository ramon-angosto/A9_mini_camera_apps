package com.tzh.ipcamera.view.VC;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.view.MyPreference;
import com.tzh.ipcamera.view.delegate.IWiFiStateListener;
import shix.ihdbell.project.App;
import shix.ihdbell.project.BaseActivity;

public class LoginLocalWiFiAty extends BaseActivity implements View.OnClickListener, IWiFiStateListener {
    private Button btnNextStep = null;
    /* access modifiers changed from: private */
    public int checkCount = 0;
    private EditText etPwd = null;
    private EditText etSSID = null;
    LogUtils logUtils = LogUtils.setLogger(LoginLocalWiFiAty.class);
    Runnable mCheckListener = new Runnable() {
        public void run() {
            IWiFiStateListener listener = LoginLocalWiFiAty.this.getApp().getListener();
            LoginLocalWiFiAty loginLocalWiFiAty = LoginLocalWiFiAty.this;
            if (listener != loginLocalWiFiAty) {
                loginLocalWiFiAty.logUtils.e("ReciveListener close");
                LoginLocalWiFiAty.this.getApp().setOnReciveListener(LoginLocalWiFiAty.this);
                int unused = LoginLocalWiFiAty.this.checkCount = 0;
            } else {
                LoginLocalWiFiAty.access$008(loginLocalWiFiAty);
                if (LoginLocalWiFiAty.this.checkCount >= 10) {
                    LoginLocalWiFiAty.this.logUtils.e("ReciveListener open");
                    LoginLocalWiFiAty.this.mHandler.removeCallbacks(LoginLocalWiFiAty.this.mCheckListener);
                    return;
                }
            }
            LoginLocalWiFiAty.this.mHandler.postDelayed(LoginLocalWiFiAty.this.mCheckListener, 500);
        }
    };
    Handler mHandler = new Handler() {
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i = message.what;
        }
    };
    private int mLocationState = 1;
    private int mState = 0;
    private String newSSID = "";
    private String passwd = "";
    private TextView tvBack = null;

    static /* synthetic */ int access$008(LoginLocalWiFiAty loginLocalWiFiAty) {
        int i = loginLocalWiFiAty.checkCount;
        loginLocalWiFiAty.checkCount = i + 1;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.color_all_bg));
        }
        setContentView(R.layout.ly_local_wifi);
        widget_init();
        Intent intent = getIntent();
        this.newSSID = intent.getStringExtra("wifiSSID");
        this.passwd = intent.getStringExtra("wifiPwd");
        this.etSSID.setText(this.newSSID);
        this.etPwd.setText(this.passwd);
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("###wifiSSID:" + this.newSSID + "  wifiPwd:" + this.passwd);
        getApp().registerReciver();
        getApp().setOnReciveListener(this);
        this.etPwd.setText(MyPreference.getInstance(this).getPassword_new(this.newSSID));
        this.mHandler.postDelayed(this.mCheckListener, 100);
    }

    private String getNewSSID(String str) {
        return str.startsWith("\"") ? str.substring(1, str.length() - 1) : str;
    }

    public void onStateChange(int i) {
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("###state:" + i);
    }

    public void onConnectChange(String str) {
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("###onConnectChange:" + str);
        this.newSSID = getNewSSID(str);
        this.etSSID.setText(this.newSSID);
        this.etPwd.setText(MyPreference.getInstance(this).getPassword_new(this.newSSID));
    }

    public void onConnected(int i, String str) {
        this.mLocationState = i;
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("###onConnected:" + i + "  ssid:" + str);
        if (i == 1) {
            this.btnNextStep.setText(getResources().getString(R.string.next_step_setting_ca));
        } else {
            this.btnNextStep.setText(getResources().getString(R.string.goto_wifi_info_connect));
        }
        this.mState = i;
        this.newSSID = getNewSSID(str);
        this.etSSID.setText(this.newSSID);
        this.etPwd.setText(MyPreference.getInstance(this).getPassword_new(this.newSSID));
    }

    public void onLocationClosed() {
        this.mState = 1;
        this.mLocationState = 0;
        this.btnNextStep.setText(R.string.string_location_open);
        this.etSSID.setText("");
    }

    public App getApp() {
        return (App) getApplication();
    }

    private void widget_init() {
        this.tvBack = (TextView) findViewById(R.id.back);
        this.etSSID = (EditText) findViewById(R.id.editSSID);
        this.etPwd = (EditText) findViewById(R.id.editPwd);
        this.tvBack.setOnClickListener(this);
        this.btnNextStep = (Button) findViewById(R.id.btnNextStep);
        this.btnNextStep.setOnClickListener(this);
    }

    public void gotoSettingWiFi() {
        startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }

    public void gotoSettingLocation() {
        startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    public void gotoNextPage() {
        Intent intent = new Intent();
        intent.setClass(this, LoginDeviceInfoAty.class);
        intent.putExtra("wifiSSID", this.newSSID);
        intent.putExtra("wifiPwd", this.etPwd.getText().toString());
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        MyPreference.getInstance(this).SetWifiData(this.etSSID.getText().toString().trim(), this.etPwd.getText().toString().trim());
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            getApp().unregisterReciver();
            finish();
            overridePendingTransition(17432578, 17432579);
        } else if (id == R.id.btnNextStep) {
            if (this.mState != 1) {
                gotoSettingWiFi();
            } else if (this.mLocationState == 0) {
                gotoSettingLocation();
            } else if (this.etPwd.getText().toString().isEmpty()) {
                showToast(getString(R.string.please_input_wifi_pwd));
            } else {
                gotoNextPage();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.newSSID = getNewSSID(getApp().getConnectWifi());
        this.etSSID.setText(this.newSSID);
        this.etPwd.setText(MyPreference.getInstance(this).getPassword_new(this.newSSID));
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.mCheckListener);
        getApp().setOnReciveListener((IWiFiStateListener) null);
    }

    public void onBackPressed() {
        super.onBackPressed();
        getApp().unregisterReciver();
        finish();
        overridePendingTransition(17432578, 17432579);
    }
}
