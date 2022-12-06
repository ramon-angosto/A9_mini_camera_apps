package com.shix.shixipc.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.PushUtils;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import java.util.Iterator;
import java.util.List;

public class TestAllPushActivity extends BaseActivity {
    WifiManager mWifiManager;
    private ClipData myClip;
    private ClipboardManager myClipboard;
    String strAll = "";
    private TextView tvAll;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_all_push);
        CommonUtil.Log(1, "SHIX  onCreate");
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.tvAll = (TextView) findViewById(R.id.tvAll);
        if (PushUtils.getPhoneType() == 1) {
            this.strAll = "手机类型：华为手机\n\n";
        } else if (PushUtils.getPhoneType() == 3) {
            this.strAll = "手机类型：OPPEN手机\n\n";
        } else if (PushUtils.getPhoneType() == 4) {
            this.strAll = "手机类型：VIVO手机\n\n";
        } else if (PushUtils.getPhoneType() == 2) {
            this.strAll = "手机类型：小米手机\n\n";
        } else {
            this.strAll = "手机类型：华为小米OPPOVIVO之外的手机\n\n";
        }
        this.strAll += "华为 token:" + ContentCommon.HW_STRING + "\n\n\n";
        this.strAll += "小米 token:" + ContentCommon.XM_REGID + "\n\n\n";
        this.strAll += "当前热点：" + getWifiSSID() + "\n\n\n";
        this.tvAll.setText(this.strAll + "");
        this.myClipboard = (ClipboardManager) getSystemService("clipboard");
        this.myClip = ClipData.newPlainText(MimeTypes.BASE_TYPE_TEXT, this.strAll);
        this.myClipboard.setPrimaryClip(this.myClip);
        this.tvAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(TestAllPushActivity.this, " 已复制", 0).show();
            }
        });
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TestAllPushActivity.this.finish();
            }
        });
    }

    private String getWifiSSID() {
        this.mWifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (!this.mWifiManager.isWifiEnabled()) {
            return "null ssid";
        }
        WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        if (ssid.indexOf(ContentCommon.SHIX_APPRE) < 0 && ssid.indexOf(ContentCommon.SHIX_APPRE1) < 0 && ssid.indexOf(ContentCommon.SHIX_APPRE2) < 0 && ssid.indexOf(ContentCommon.SHIX_APPRE3) < 0 && ssid.indexOf(ContentCommon.SHIX_APPRE4) < 0) {
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
                        ssid = next.SSID;
                        break;
                    }
                }
            } else {
                return "null ssid";
            }
        }
        if (ssid == null) {
            return "null ssid";
        }
        return (!ssid.startsWith("\"") || !ssid.endsWith("\"")) ? ssid : ssid.substring(1, ssid.length() - 1);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
