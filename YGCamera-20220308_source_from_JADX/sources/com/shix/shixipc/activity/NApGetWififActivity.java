package com.shix.shixipc.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.DisplayUtil;
import java.util.regex.Pattern;
import shix.cykj.camera.R;

public class NApGetWififActivity extends BaseActivity implements View.OnClickListener {
    private ImageView img_mode_show;
    private ImageView ivEye;
    private int localIp;
    private WifiManager mWifiManager;
    /* access modifiers changed from: private */
    public Dialog resetDialog;
    /* access modifiers changed from: private */
    public Dialog tipsDialog;
    EditText tvWIFINAME;
    private EditText tvWifiPass;
    String wifyName = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_getwifi);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        initTipsDialog();
        initResetDialog();
        initEvents();
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

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getWifiSSID() {
        /*
            r8 = this;
            android.content.Context r0 = r8.getApplicationContext()
            java.lang.String r1 = "wifi"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0
            r8.mWifiManager = r0
            android.net.wifi.WifiManager r0 = r8.mWifiManager
            boolean r0 = r0.isWifiEnabled()
            java.lang.String r1 = "null ssid"
            if (r0 == 0) goto L_0x0077
            android.net.wifi.WifiManager r0 = r8.mWifiManager
            android.net.wifi.WifiInfo r0 = r0.getConnectionInfo()
            java.lang.String r2 = r0.getSSID()
            int r3 = r2.length()
            java.lang.String r4 = "\""
            boolean r5 = r2.startsWith(r4)
            r6 = 1
            if (r5 == 0) goto L_0x003b
            boolean r5 = r2.endsWith(r4)
            if (r5 == 0) goto L_0x003b
            int r5 = r3 + -1
            java.lang.String r2 = r2.substring(r6, r5)
        L_0x003b:
            if (r2 == 0) goto L_0x0043
            int r1 = r2.indexOf(r1)
            if (r1 <= 0) goto L_0x0065
        L_0x0043:
            int r0 = r0.getNetworkId()
            android.net.wifi.WifiManager r1 = r8.mWifiManager
            java.util.List r1 = r1.getConfiguredNetworks()
            java.util.Iterator r1 = r1.iterator()
        L_0x0051:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0065
            java.lang.Object r5 = r1.next()
            android.net.wifi.WifiConfiguration r5 = (android.net.wifi.WifiConfiguration) r5
            int r7 = r5.networkId
            if (r7 != r0) goto L_0x0051
            java.lang.String r0 = r5.SSID
            r1 = r0
            goto L_0x0066
        L_0x0065:
            r1 = r2
        L_0x0066:
            boolean r0 = r1.startsWith(r4)
            if (r0 == 0) goto L_0x0077
            boolean r0 = r1.endsWith(r4)
            if (r0 == 0) goto L_0x0077
            int r3 = r3 - r6
            java.lang.String r1 = r1.substring(r6, r3)
        L_0x0077:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.NApGetWififActivity.getWifiSSID():java.lang.String");
    }

    /* access modifiers changed from: protected */
    public void initEvents() {
        findViewById(R.id.add_more).setOnClickListener(this);
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
        this.tvWifiPass.setInputType(129);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.tvWIFINAME.setText(getWifiSSID());
        EditText editText = this.tvWifiPass;
        editText.setText(CommonUtil.GetCommonShareStringValue(this, getWifiSSID() + "_pw", ""));
    }

    private void initResetDialog() {
        this.resetDialog = new Dialog(this, R.style.customDialog);
        this.resetDialog.setCanceledOnTouchOutside(false);
        this.resetDialog.setContentView(R.layout.dialog_get_more);
        this.resetDialog.findViewById(R.id.im_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NApGetWififActivity.this.resetDialog.dismiss();
            }
        });
        Window window = this.resetDialog.getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = -2;
        attributes.width = getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px(this, 40.0f);
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
        switch (view.getId()) {
            case R.id.add_more /*2131165251*/:
                this.resetDialog.show();
                return;
            case R.id.back /*2131165270*/:
                finish();
                return;
            case R.id.btn_next /*2131165302*/:
                this.wifyName = this.tvWIFINAME.getText().toString().trim();
                String str = this.wifyName;
                if (str == null || str.length() < 1 || this.wifyName.indexOf("IKB") > 0 || this.wifyName.indexOf(ContentCommon.SHIX_APPRE) > 0 || this.wifyName.indexOf(ContentCommon.SHIX_APPRE2) > 0 || this.wifyName.indexOf("IKB") > 0) {
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
                Intent intent = new Intent(this, ErShowActivity.class);
                intent.putExtra("mConnectedSsid", this.wifyName);
                intent.putExtra("Password", trim);
                startActivity(intent);
                CommonUtil.SaveCommonShare(this, this.wifyName + "_pw", trim, -1);
                finish();
                return;
            case R.id.edit_wify_pass_eye /*2131165431*/:
                if (this.ivEye.isSelected()) {
                    this.ivEye.setSelected(false);
                    this.ivEye.setImageResource(R.mipmap.btn_eye);
                    this.tvWifiPass.setInputType(129);
                    return;
                }
                this.ivEye.setSelected(true);
                this.ivEye.setImageResource(R.mipmap.btn_eye_selected);
                this.tvWifiPass.setInputType(145);
                return;
            case R.id.ivDevice /*2131165548*/:
                ((TextView) findViewById(R.id.edit_wify_name)).setText(getWifiSSID());
                EditText editText = this.tvWifiPass;
                editText.setText(CommonUtil.GetCommonShareStringValue(this, getWifiSSID() + "_pw", ""));
                return;
            case R.id.tvConfirm /*2131165861*/:
                Intent intent2 = new Intent(this, ErShowActivity.class);
                intent2.putExtra("mConnectedSsid", this.wifyName);
                intent2.putExtra("Password", "");
                startActivity(intent2);
                CommonUtil.SaveCommonShare(this, this.wifyName + "_pw", "", -1);
                finish();
                return;
            default:
                return;
        }
    }
}
