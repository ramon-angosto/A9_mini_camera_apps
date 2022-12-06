package com.shix.shixipc.activity;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import java.util.Iterator;
import java.util.List;
import object.p2pipcam.nativecaller.NativeCaller;

public class ApConnectActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.AddCameraInterface1 {
    private final int CHECKSSID = 1;
    private final int CHECKUID = 2;
    /* access modifiers changed from: private */
    public Handler MsgHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (ApConnectActivity.this.nowssid != null && ApConnectActivity.this.nowssid.length() > 0 && CommonUtil.SHIX_isSupportPrefix(ApConnectActivity.this.nowssid).booleanValue()) {
                    ApConnectActivity.this.startSearch();
                }
            } else if (message.what == 2) {
                CommonUtil.Log(1, "zhaogenghuai CHECKUID did:" + ApConnectActivity.this.strUid);
                Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
                while (it.hasNext()) {
                    if (ApConnectActivity.this.strUid.equalsIgnoreCase(it.next().getDev_Did())) {
                        ApConnectActivity apConnectActivity = ApConnectActivity.this;
                        apConnectActivity.showToast(apConnectActivity.getString(R.string.tip_device_add));
                        ApConnectActivity.this.finish();
                        Intent intent = new Intent(ApConnectActivity.this, NUIMainActivity.class);
                        intent.setFlags(67108864);
                        ApConnectActivity.this.startActivity(intent);
                        return;
                    }
                }
                ContentCommon.AP_ADD_UID = ApConnectActivity.this.strUid;
                CameraParamsBean cameraParamsBean = new CameraParamsBean();
                cameraParamsBean.setDev_Did(ApConnectActivity.this.strUid);
                cameraParamsBean.setDev_name(ContentCommon.SHIX_DEFUALT_NAME);
                cameraParamsBean.setDev_User("admin");
                cameraParamsBean.setDev_Pwd(ContentCommon.SHIX_DEFUALT_PWD);
                SystemValue.arrayList.add(cameraParamsBean);
                ContentCommon.SHIX_saveDev(cameraParamsBean);
                Intent intent2 = new Intent();
                intent2.setAction(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                intent2.putExtra(ContentCommon.CAMERA_OPTION, 5);
                intent2.putExtra(ContentCommon.STR_CAMERA_ID, ApConnectActivity.this.strUid);
                ApConnectActivity.this.sendBroadcast(intent2);
                ApConnectActivity.this.finish();
                CommonUtil.Log(1, "zhaogenghuai CHECKUID2 did:" + ApConnectActivity.this.strUid);
                Intent intent3 = new Intent(ApConnectActivity.this, NUIMainActivity.class);
                intent3.setFlags(67108864);
                ApConnectActivity.this.startActivity(intent3);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean isCheck = false;
    /* access modifiers changed from: private */
    public boolean isFistComeOn = false;
    private WifiManager mWifiManager;
    /* access modifiers changed from: private */
    public String nowssid;
    /* access modifiers changed from: private */
    public String strUid = "";

    class CheckThread extends Thread {
        CheckThread() {
        }

        public void run() {
            super.run();
            while (ApConnectActivity.this.isCheck) {
                if (!ApConnectActivity.this.isFistComeOn) {
                    ApConnectActivity apConnectActivity = ApConnectActivity.this;
                    String unused = apConnectActivity.nowssid = apConnectActivity.getWifiSSID();
                    Log.d("SHIX", "SHIX APConncet onresume wifissid:" + ApConnectActivity.this.nowssid);
                    ApConnectActivity.this.MsgHandler.sendEmptyMessageDelayed(1, 0);
                }
                CommonUtil.Log(1, "SHIX APConncet --------");
                if (ApConnectActivity.this.isCheck) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (ApConnectActivity.this.isCheck) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        if (ApConnectActivity.this.isCheck) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e3) {
                                e3.printStackTrace();
                            }
                            if (ApConnectActivity.this.isCheck) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e4) {
                                    e4.printStackTrace();
                                }
                                if (!ApConnectActivity.this.isCheck) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void startSearch() {
        new Thread(new SearchThread()).start();
    }

    private class SearchThread implements Runnable {
        private SearchThread() {
        }

        public void run() {
            Log.d("tag", "startSearch");
            String localIpAddress = CommonUtil.getLocalIpAddress(ApConnectActivity.this);
            Log.d("tag", "startSearch : " + localIpAddress);
            if (localIpAddress.indexOf("192") < 0) {
                localIpAddress = "AA";
            }
            NativeCaller.StartSearch(localIpAddress);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            NativeCaller.StopSearch();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ap_connect);
        CommonUtil.Log(1, "SHIX  onCreate");
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        NUIMainActivity.setAddCameraInterface1(this);
        findViewById(R.id.tvNext).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        this.isFistComeOn = true;
        this.isCheck = true;
        new CheckThread().start();
        SystemValue.isExitBackGoudExit = false;
        if (ContentCommon.ISAUDIOSHOW.booleanValue()) {
            try {
                CommonUtil.playAudioShow(this, R.string.audioshow_add_con);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public String getWifiSSID() {
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
        this.isFistComeOn = false;
        Log.d("SHIX", "SHIX onRestart" + this.nowssid);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (!this.isFistComeOn) {
            this.nowssid = getWifiSSID();
            Log.d("SHIX", "SHIX APConncet onresume wifissid:" + this.nowssid);
            this.MsgHandler.sendEmptyMessageDelayed(1, 0);
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.isCheck = false;
        super.onDestroy();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.tvNext) {
            startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        }
    }

    public void callBackSearchResultData(int i, String str, String str2, String str3, String str4, int i2) {
        CommonUtil.Log(1, "zhaogenghuai strDeviceID:" + str3);
        String str5 = this.strUid;
        if (str5 == null || str5.length() < 5) {
            this.strUid = str3.replace("-", "").trim();
            CommonUtil.Log(1, "zhaogenghuai did:" + this.strUid);
            this.MsgHandler.sendEmptyMessageDelayed(2, 1000);
        }
    }
}
