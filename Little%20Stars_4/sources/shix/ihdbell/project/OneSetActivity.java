package shix.ihdbell.project;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.xiaomi.mipush.sdk.Constants;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.bean.WifiScanBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.DataBaseHelper;
import object.p2pipcam.utils.VibratorUtil;
import object.p2pipcam.utils.WifiSetting;
import shix.ihdbell.project.BridgeService;

@SuppressLint({"NewApi"})
public class OneSetActivity extends BaseActivity implements View.OnClickListener, BridgeService.AddCameraInterface, BridgeService.DoorBellOneKey, BridgeService.WifiInterface {
    private Handler PPPPMsgHandler = new Handler() {
        public void handleMessage(Message message) {
            Message message2 = message;
            if (message2.what == 2) {
                NativeCaller.PPPPGetSystemParams(OneSetActivity.this.didzhao, 20);
                Log.d("tes", "zhao-did:" + OneSetActivity.this.osDid + "getWifi  didzhao:" + OneSetActivity.this.didzhao);
            } else if (message2.what == 111) {
                NativeCaller.PPPPWifiSetting(OneSetActivity.this.wifiBean.getDid(), 1, OneSetActivity.this.wifiBean.getSsid(), OneSetActivity.this.wifiBean.getChannel(), OneSetActivity.this.wifiBean.getMode(), OneSetActivity.this.wifiBean.getSecurity(), 0, 0, 0, "", "", "", "", 0, 0, 0, 0, OneSetActivity.this.editPWD);
            } else if (message2.what == 112) {
                NativeCaller.PPPPRebootDevice(OneSetActivity.this.osDid);
                boolean unused = OneSetActivity.this.isFinish = true;
                OneSetActivity.this.showToast((int) R.string.doorbell_wifi_set_sucess);
            } else if (message2.what == 113) {
                boolean unused2 = OneSetActivity.this.isFinish = true;
                OneSetActivity.this.showToast((int) R.string.doorbell_wifi_set_faile);
                OneSetActivity oneSetActivity = OneSetActivity.this;
                oneSetActivity.connectToHotpotOld(oneSetActivity.editSSID, OneSetActivity.this.editPWD);
            }
        }
    };
    private DataBaseHelper baseHelper;
    private Button btn_one_set;
    private Button btn_reset;
    private ConnectivityManager cm;
    /* access modifiers changed from: private */
    public String didzhao = "";
    /* access modifiers changed from: private */
    public String editPWD;
    /* access modifiers changed from: private */
    public String editSSID;
    private EditText edit_pwd;
    private EditText edit_wifi;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    private ImageView image;
    /* access modifiers changed from: private */
    public boolean isClose = false;
    /* access modifiers changed from: private */
    public boolean isFinish = false;
    /* access modifiers changed from: private */
    public boolean isOK = false;
    private LinearLayout l_wifi;
    /* access modifiers changed from: private */
    public boolean noStartSerch = false;
    /* access modifiers changed from: private */
    public String osDid = "";
    private View popv;
    /* access modifiers changed from: private */
    public ProgressBar pp_progressBar;
    private SharedPreferences preWifi;
    int pro = 0;
    Runnable runnable = new Runnable() {
        public void run() {
            if (!OneSetActivity.this.noStartSerch && OneSetActivity.this.wifiConFlag && OneSetActivity.this.isWifiConnected()) {
                boolean unused = OneSetActivity.this.noStartSerch = true;
                boolean unused2 = OneSetActivity.this.isClose = false;
                boolean unused3 = OneSetActivity.this.isFinish = false;
                boolean unused4 = OneSetActivity.this.isOK = false;
                NativeCaller.StartSearch();
            }
            if (OneSetActivity.this.osDid != null && OneSetActivity.this.osDid.length() > 1 && !OneSetActivity.this.isClose && OneSetActivity.this.isFinish) {
                OneSetActivity oneSetActivity = OneSetActivity.this;
                oneSetActivity.connectToHotpotOld(oneSetActivity.editSSID, OneSetActivity.this.editPWD);
                Log.d("test", "zhao1_editSSID:" + OneSetActivity.this.editSSID);
                boolean unused5 = OneSetActivity.this.isClose = true;
            }
            if (OneSetActivity.this.wifiConFlagOld && OneSetActivity.this.isWifiConnected() && OneSetActivity.this.isFinish) {
                if (OneSetActivity.this.showWindow != null && OneSetActivity.this.showWindow.isShowing()) {
                    OneSetActivity.this.showWindow.dismiss();
                }
                OneSetActivity.this.handler.removeCallbacks(OneSetActivity.this.runnable);
                OneSetActivity.this.pp_progressBar.setProgress(0);
                OneSetActivity.this.finish();
                OneSetActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
            OneSetActivity oneSetActivity2 = OneSetActivity.this;
            oneSetActivity2.pro = oneSetActivity2.pp_progressBar.getProgress() + 1;
            OneSetActivity.this.pp_progressBar.setProgress(OneSetActivity.this.pro);
            if (OneSetActivity.this.pro < OneSetActivity.this.pp_progressBar.getMax()) {
                OneSetActivity.this.pp_progressBar.postDelayed(OneSetActivity.this.runnable, 500);
                return;
            }
            if (OneSetActivity.this.showWindow != null && OneSetActivity.this.showWindow.isShowing()) {
                OneSetActivity.this.showWindow.dismiss();
            }
            OneSetActivity.this.handler.removeCallbacks(OneSetActivity.this.runnable);
            OneSetActivity.this.pp_progressBar.setProgress(0);
            OneSetActivity.this.finish();
            OneSetActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        }
    };
    /* access modifiers changed from: private */
    public PopupWindow showWindow;
    private TextView tv_show;
    /* access modifiers changed from: private */
    public WifiScanBean wifiBean;
    /* access modifiers changed from: private */
    public boolean wifiConFlag = false;
    /* access modifiers changed from: private */
    public boolean wifiConFlagOld = false;
    private String wifiSSID;
    private WifiSetting wifiSetting;

    public void callBackPPPPMsgNotifyData(String str, int i, int i2) {
    }

    public void callBackResetResultData(int i) {
    }

    public void callBackWifiParams(String str, int i, String str2, int i2, int i3, int i4, int i5, int i6, int i7, String str3, String str4, String str5, String str6, int i8, int i9, int i10, int i11, String str7) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.ac_onc_set);
        this.preWifi = getSharedPreferences("shix_zhao_wifi", 0);
        this.wifiSetting = new WifiSetting(getApplicationContext());
        this.wifiSSID = this.wifiSetting.getNowWifiSSID();
        this.cm = (ConnectivityManager) getSystemService("connectivity");
        this.l_wifi = (LinearLayout) findViewById(R.id.l_wifi);
        this.tv_show = (TextView) findViewById(R.id.tv_show);
        this.image = (ImageView) findViewById(R.id.imageView1);
        this.btn_one_set = (Button) findViewById(R.id.btn_one_set);
        this.btn_one_set.setOnClickListener(this);
        this.btn_reset = (Button) findViewById(R.id.btn_reset);
        this.btn_reset.setOnClickListener(this);
        this.edit_wifi = (EditText) findViewById(R.id.edit_wifi);
        this.edit_pwd = (EditText) findViewById(R.id.edit_pwd);
        Log.d(OneSetActivity.class.getSimpleName(), "Start OneSetActivity!");
        if (this.wifiSSID != null) {
            this.tv_show.setVisibility(8);
            this.l_wifi.setVisibility(0);
            this.image.setVisibility(0);
            this.btn_one_set.setVisibility(0);
            this.edit_wifi.setText(this.wifiSSID);
            this.edit_pwd.setText(this.preWifi.getString(this.wifiSSID, ""));
        } else {
            this.tv_show.setVisibility(0);
            this.l_wifi.setVisibility(8);
            this.image.setVisibility(8);
            this.btn_one_set.setVisibility(8);
        }
        initExitPopupWindow2();
        BridgeService.setAddCameraInterface(this);
        BridgeService.setDoorBellOneKey(this);
        BridgeService.setWifiInterface(this);
        this.baseHelper = DataBaseHelper.getInstance(this);
        this.wifiBean = new WifiScanBean();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.isOK = false;
        BridgeService.setAddCameraInterface((BridgeService.AddCameraInterface) null);
        BridgeService.setDoorBellOneKey((BridgeService.DoorBellOneKey) null);
        BridgeService.setWifiInterface((BridgeService.WifiInterface) null);
        super.onDestroy();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_one_set) {
            VibratorUtil.Vibrate(this, 80);
            this.editSSID = this.edit_wifi.getText().toString().trim();
            this.editPWD = this.edit_pwd.getText().toString().trim();
            String str = this.editPWD;
            if (str == null || str.length() < 2) {
                showToast((int) R.string.doorbell_wifi_pwd_errer);
                return;
            }
            SharedPreferences.Editor edit = this.preWifi.edit();
            edit.putString(this.editSSID, this.editPWD);
            edit.commit();
            connectToHotpot();
            this.pp_progressBar.setProgress(1);
            this.showWindow.showAtLocation(this.btn_reset, 80, 0, 0);
            this.handler.post(this.runnable);
        } else if (id == R.id.btn_reset) {
            this.wifiSetting = null;
            this.wifiSSID = null;
            this.wifiSetting = new WifiSetting(getApplicationContext());
            this.wifiSSID = this.wifiSetting.getNowWifiSSID();
            Log.d("test", "zhao-wifi:" + this.wifiSSID);
            if (this.wifiSSID != null) {
                this.tv_show.setVisibility(8);
                this.l_wifi.setVisibility(0);
                this.image.setVisibility(0);
                this.btn_one_set.setVisibility(0);
                this.edit_wifi.setText(this.wifiSSID);
                this.edit_pwd.setText(this.preWifi.getString(this.wifiSSID, ""));
                return;
            }
            this.tv_show.setVisibility(0);
            this.l_wifi.setVisibility(8);
            this.image.setVisibility(8);
            this.btn_one_set.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public boolean isWifiConnected() {
        NetworkInfo networkInfo = this.cm.getNetworkInfo(1);
        Log.d("wifi", "ni.getState()==" + networkInfo.getState() + " ----ni.getDetailedState()=" + networkInfo.getDetailedState());
        if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            return true;
        }
        return false;
    }

    public void connectToHotpot() {
        this.wifiConFlagOld = false;
        this.wifiConFlag = false;
        this.noStartSerch = false;
        this.wifiConFlag = this.wifiSetting.getWifiManager().enableNetwork(this.wifiSetting.getWifiManager().addNetwork(setWifiParams("NEOBELL-0001", "123456789")), true);
    }

    public void connectToHotpotOld(String str, String str2) {
        this.wifiConFlagOld = false;
        this.wifiConFlagOld = this.wifiSetting.getWifiManager().enableNetwork(this.wifiSetting.getWifiManager().addNetwork(setWifiParams(str, str2)), true);
    }

    public WifiConfiguration setWifiParams(String str, String str2) {
        Log.d("test", "zhao-ssid:" + str + "  Password:" + str2);
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = "\"" + str + "\"";
        wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
        wifiConfiguration.hiddenSSID = true;
        wifiConfiguration.status = 2;
        wifiConfiguration.allowedGroupCiphers.set(2);
        wifiConfiguration.allowedGroupCiphers.set(3);
        wifiConfiguration.allowedKeyManagement.set(1);
        wifiConfiguration.allowedPairwiseCiphers.set(1);
        wifiConfiguration.allowedPairwiseCiphers.set(2);
        wifiConfiguration.allowedProtocols.set(1);
        return wifiConfiguration;
    }

    public void initExitPopupWindow2() {
        this.popv = LayoutInflater.from(this).inflate(R.layout.popup_show1, (ViewGroup) null);
        this.pp_progressBar = (ProgressBar) this.popv.findViewById(R.id.pp_progressBar);
        this.showWindow = new PopupWindow(this.popv, -1, -2);
        this.showWindow.setAnimationStyle(R.style.AnimationPreview);
        this.showWindow.setFocusable(true);
    }

    public void callBackSearchResultData(int i, String str, String str2, String str3, String str4, int i2) {
        if (!this.isOK) {
            this.didzhao = str3.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.isOK = true;
            Log.d("test", "zhao-strDeviceID:" + str3);
            new Thread() {
                public void run() {
                    OneSetActivity oneSetActivity = OneSetActivity.this;
                    oneSetActivity.AddCamera("DoorBell", oneSetActivity.didzhao, ContentCommon.DEFAULT_USER_NAME, "");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    NativeCaller.StopSearch();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    OneSetActivity oneSetActivity2 = OneSetActivity.this;
                    String unused = oneSetActivity2.osDid = oneSetActivity2.didzhao;
                    OneSetActivity oneSetActivity3 = OneSetActivity.this;
                    oneSetActivity3.StartPPPP(oneSetActivity3.osDid, ContentCommon.DEFAULT_USER_NAME, "", "test");
                    Log.d("test", "NativeCaller.StartPPPP:" + OneSetActivity.this.osDid);
                }
            }.start();
        }
    }

    private boolean CheckCameraInfo(String str) {
        synchronized (this) {
            int size = SystemValue.arrayList.size();
            for (int i = 0; i < size; i++) {
                if (SystemValue.arrayList.get(i).getDid().equals(str)) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean AddCamera(String str, String str2, String str3, String str4) {
        if (!CheckCameraInfo(str2) || str2 == null || str2.length() < 3) {
            return false;
        }
        this.baseHelper.createCamera("DoorBell", str2, ContentCommon.DEFAULT_USER_NAME, "");
        CameraParamsBean cameraParamsBean = new CameraParamsBean();
        cameraParamsBean.setAuthority(false);
        cameraParamsBean.setName(str);
        cameraParamsBean.setDid(str2);
        cameraParamsBean.setUser(str3);
        cameraParamsBean.setPwd(str4);
        cameraParamsBean.setStatus(-1);
        cameraParamsBean.setMode(-1);
        synchronized (this) {
            SystemValue.arrayList.add(cameraParamsBean);
        }
        return true;
    }

    public void BSMsgNotifyData(String str, int i, int i2) {
        Log.d("tes", "zhao-did:" + str + "  param:" + i2);
        if (i2 == 2) {
            new Bundle();
            Message obtainMessage = this.PPPPMsgHandler.obtainMessage();
            obtainMessage.what = 2;
            this.PPPPMsgHandler.sendMessage(obtainMessage);
        }
    }

    public void callBackWifiScanResult(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6) {
        Log.d("shix", "zhao1_ssid:" + str2 + " mac:" + str3 + " security:" + i + " dbm0" + i2 + " dbm1:" + i3 + " mode:" + i4 + " channel:" + i5 + " bEnd:" + i6);
        StringBuilder sb = new StringBuilder();
        sb.append("zhao-editSSID:");
        sb.append(this.editSSID);
        Log.d("test", sb.toString());
        if (this.editSSID.equals(str2) || this.editSSID.contains(str2)) {
            Log.d("tet", "zhao-ok");
            this.wifiBean.setDid(this.didzhao);
            this.wifiBean.setSsid(str2);
            this.wifiBean.setChannel(i5);
            this.wifiBean.setSecurity(i);
            this.wifiBean.setDbm0(i2);
            this.wifiBean.setMac(str3);
            this.wifiBean.setMode(i4);
            this.wifiBean.setDbm1(i3);
            this.PPPPMsgHandler.sendEmptyMessage(111);
        }
    }

    public void callBackSetSystemParamsResult(String str, int i, int i2) {
        if (i2 == 1) {
            this.PPPPMsgHandler.sendEmptyMessage(112);
        } else if (i2 == 0) {
            this.PPPPMsgHandler.sendEmptyMessage(113);
        }
    }
}
