package com.shix.shixipc.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class NApGetWififActivity extends BaseActivity implements View.OnClickListener {
    private ImageView img_mode_show;
    private ImageView ivEye;
    private int localIp;
    private WifiManager mWifiManager;
    private Dialog resetDialog;
    /* access modifiers changed from: private */
    public Dialog tipsDialog;
    EditText tvWIFINAME;
    private EditText tvWifiPass;
    String wifyName = "";

    private void initResetDialog() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_getwifi);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        initTipsDialog();
        initResetDialog();
        initEvents();
        if (ContentCommon.ISAUDIOSHOW.booleanValue()) {
            try {
                CommonUtil.playAudioShow(this, R.string.audioshow_add_rm);
            } catch (Exception unused) {
            }
        }
    }

    private void initTipsDialog() {
        this.tipsDialog = new Dialog(this, R.style.customDialog);
        this.tipsDialog.setCanceledOnTouchOutside(false);
        this.tipsDialog.setContentView(R.layout.dialog_wifi_nopwd_tips);
        this.tipsDialog.findViewById(R.id.tvCancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NApGetWififActivity.this.tipsDialog.dismiss();
            }
        });
        this.tipsDialog.findViewById(R.id.tvConfirm).setOnClickListener(this);
        this.tipsDialog.getWindow().setGravity(17);
    }

    private String getWifiSSID() {
        String str;
        this.mWifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (!this.mWifiManager.isWifiEnabled()) {
            return "null ssid";
        }
        WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        int length = ssid.length();
        if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
            ssid = ssid.substring(1, length - 1);
        }
        if (ssid == null || ssid.indexOf("null ssid") > 0) {
            int networkId = connectionInfo.getNetworkId();
            List<WifiConfiguration> configuredNetworks = this.mWifiManager.getConfiguredNetworks();
            if (configuredNetworks != null) {
                Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WifiConfiguration next = it.next();
                    if (next.networkId == networkId) {
                        str = next.SSID;
                        break;
                    }
                }
            } else {
                return "null ssid";
            }
        }
        str = ssid;
        return (!str.startsWith("\"") || !str.endsWith("\"")) ? str : str.substring(1, length - 1);
    }

    /* access modifiers changed from: protected */
    public void initEvents() {
        findViewById(R.id.btn_wifi_r).setOnClickListener(this);
        findViewById(R.id.btn_next).setOnClickListener(this);
        findViewById(R.id.ivDevice).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        this.img_mode_show = (ImageView) findViewById(R.id.img_mode_show);
        this.tvWifiPass = (EditText) findViewById(R.id.edit_wify_pass);
        this.tvWifiPass.setInputType(32);
        this.tvWifiPass.setImeOptions(6);
        this.ivEye = (ImageView) findViewById(R.id.edit_wify_pass_eye);
        this.ivEye.setOnClickListener(this);
        this.tvWIFINAME = (EditText) findViewById(R.id.edit_wify_name);
        this.ivEye.setSelected(false);
        this.ivEye.setImageResource(R.mipmap.btn_eye);
        this.tvWifiPass.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.tvWIFINAME.setText(getWifiSSID());
        EditText editText = this.tvWifiPass;
        editText.setText(CommonUtil.GetCommonShareStringValue(this, getWifiSSID() + "_pw", ""));
    }

    private byte[] strToByteArray(String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes();
    }

    private boolean isContainChinese(String str) {
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        switch (view.getId()) {
            case R.id.back:
                finish();
                return;
            case R.id.btn_next:
                this.wifyName = this.tvWIFINAME.getText().toString().trim();
                String str = this.wifyName;
                if (str == null || str.length() < 1 || CommonUtil.SHIX_isSupportPrefix(this.wifyName).booleanValue()) {
                    Toast.makeText(this, getResources().getString(R.string.add_device_danale_wifi1_1), 0).show();
                    return;
                }
                String trim = this.tvWifiPass.getText().toString().trim();
                if ("".equals(this.wifyName)) {
                    Toast.makeText(this, getResources().getString(R.string.add_device_danale_wifi), 0).show();
                    return;
                }
                byte[] strToByteArray = strToByteArray(this.wifyName);
                CommonUtil.Log(1, "SHIXWIFI  wifiName:" + this.wifyName + "  Len:" + strToByteArray.length);
                if (strToByteArray.length > 30) {
                    showToast((int) R.string.config_wifi_len_show);
                    return;
                }
                if (trim != null && trim.length() > 1) {
                    byte[] strToByteArray2 = strToByteArray(trim);
                    CommonUtil.Log(1, "SHIXWIFI  pwd:" + trim + "  Len:" + strToByteArray2.length);
                    if (strToByteArray2.length > 30) {
                        showToast((int) R.string.config_wifi_len_show);
                        return;
                    }
                }
                if (trim == null || trim.length() == 0) {
                    this.tipsDialog.show();
                    return;
                }
                SystemValue.configWifiSSID = this.wifyName;
                SystemValue.configWifiPWD = trim;
                CommonUtil.SaveCommonShare(this, "SHIXconfigWifiSSID", SystemValue.configWifiSSID, -1);
                CommonUtil.SaveCommonShare(this, "SHIXconfigWifiPWD", SystemValue.configWifiPWD, -1);
                Intent intent = new Intent();
                intent.setClass(this, ApConnectActivity.class);
                startActivity(intent);
                CommonUtil.SaveCommonShare(this, this.wifyName + "_pw", trim, -1);
                finish();
                return;
            case R.id.btn_wifi_r:
                SystemValue.isExitBackGoudExit = false;
                startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                return;
            case R.id.edit_wify_pass_eye:
                if (this.ivEye.isSelected()) {
                    this.ivEye.setSelected(false);
                    this.ivEye.setImageResource(R.mipmap.btn_eye);
                    this.tvWifiPass.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
                    return;
                }
                this.ivEye.setSelected(true);
                this.ivEye.setImageResource(R.mipmap.btn_eyeno);
                this.tvWifiPass.setInputType(145);
                return;
            case R.id.ivDevice:
                ((TextView) findViewById(R.id.edit_wify_name)).setText(getWifiSSID());
                EditText editText = this.tvWifiPass;
                editText.setText(CommonUtil.GetCommonShareStringValue(this, getWifiSSID() + "_pw", ""));
                return;
            case R.id.tvConfirm:
                SystemValue.configWifiSSID = this.wifyName;
                SystemValue.configWifiPWD = "";
                CommonUtil.SaveCommonShare(this, "SHIXconfigWifiSSID", SystemValue.configWifiSSID, -1);
                CommonUtil.SaveCommonShare(this, "SHIXconfigWifiPWD", SystemValue.configWifiPWD, -1);
                Intent intent2 = new Intent();
                intent2.setClass(this, ApConnectActivity.class);
                startActivity(intent2);
                CommonUtil.SaveCommonShare(this, this.wifyName + "_pw", "", -1);
                finish();
                return;
            default:
                return;
        }
    }
}
