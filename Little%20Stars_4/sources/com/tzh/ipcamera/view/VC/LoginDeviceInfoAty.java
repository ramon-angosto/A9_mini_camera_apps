package com.tzh.ipcamera.view.VC;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.view.delegate.IWiFiStateListener;
import java.io.UnsupportedEncodingException;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import shix.ihdbell.project.App;
import shix.ihdbell.project.BaseActivity;
import shix.ihdbell.project.BridgeService;
import shix.ihdbell.project.OnkeyActivity;

public class LoginDeviceInfoAty extends BaseActivity implements IWiFiStateListener, View.OnClickListener, BridgeService.PlayInterface {
    private final int CONNECTED = 3;
    private final int CONNECT_FAILED = 4;
    private final int COUNTTIMNE = 1;
    private final int SOCKET_NULL = 5;
    private final int TIMEOUT = 2;
    Runnable WaitAckRunnable = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002c, code lost:
            if (r0 != 2) goto L_0x005e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
            L_0x0000:
                com.tzh.ipcamera.view.VC.LoginDeviceInfoAty r0 = com.tzh.ipcamera.view.VC.LoginDeviceInfoAty.this
                boolean r0 = r0.isRunning
                if (r0 == 0) goto L_0x0069
                int r0 = object.p2pipcam.nativecaller.NativeCaller.iNetworkGetState()
                com.tzh.ipcamera.view.VC.LoginDeviceInfoAty r1 = com.tzh.ipcamera.view.VC.LoginDeviceInfoAty.this
                com.tzh.ipcamera.presenter.LogUtils r1 = r1.logUtils
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "###获取到state:"
                r2.append(r3)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.e(r2)
                r1 = -1
                r2 = 0
                if (r0 == r1) goto L_0x0047
                r1 = 1
                if (r0 == r1) goto L_0x002f
                r1 = 2
                if (r0 == r1) goto L_0x0047
                goto L_0x005e
            L_0x002f:
                com.tzh.ipcamera.view.VC.LoginDeviceInfoAty r0 = com.tzh.ipcamera.view.VC.LoginDeviceInfoAty.this
                android.os.Handler r0 = r0.mHandler
                r1 = 3
                r0.sendEmptyMessage(r1)
                com.tzh.ipcamera.view.VC.LoginDeviceInfoAty r0 = com.tzh.ipcamera.view.VC.LoginDeviceInfoAty.this
                boolean unused = r0.isRunning = r2
                com.tzh.ipcamera.view.VC.LoginDeviceInfoAty r0 = com.tzh.ipcamera.view.VC.LoginDeviceInfoAty.this
                com.tzh.ipcamera.view.VC.LoginDeviceInfoAty$2$2 r1 = new com.tzh.ipcamera.view.VC.LoginDeviceInfoAty$2$2
                r1.<init>()
                r0.runOnUiThread(r1)
                goto L_0x005e
            L_0x0047:
                com.tzh.ipcamera.view.VC.LoginDeviceInfoAty r0 = com.tzh.ipcamera.view.VC.LoginDeviceInfoAty.this
                android.os.Handler r0 = r0.mHandler
                r1 = 4
                r0.sendEmptyMessage(r1)
                com.tzh.ipcamera.view.VC.LoginDeviceInfoAty r0 = com.tzh.ipcamera.view.VC.LoginDeviceInfoAty.this
                boolean unused = r0.isRunning = r2
                com.tzh.ipcamera.view.VC.LoginDeviceInfoAty r0 = com.tzh.ipcamera.view.VC.LoginDeviceInfoAty.this
                com.tzh.ipcamera.view.VC.LoginDeviceInfoAty$2$1 r1 = new com.tzh.ipcamera.view.VC.LoginDeviceInfoAty$2$1
                r1.<init>()
                r0.runOnUiThread(r1)
            L_0x005e:
                r0 = 200(0xc8, double:9.9E-322)
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0064 }
                goto L_0x0000
            L_0x0064:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0000
            L_0x0069:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tzh.ipcamera.view.VC.LoginDeviceInfoAty.AnonymousClass2.run():void");
        }
    };
    /* access modifiers changed from: private */
    public boolean bAvaild = false;
    private boolean bHasEnter = false;
    /* access modifiers changed from: private */
    public Button btnNextStep = null;
    /* access modifiers changed from: private */
    public int checkCount = 0;
    /* access modifiers changed from: private */
    public boolean isConnectFailed = false;
    private boolean isRestart = false;
    /* access modifiers changed from: private */
    public boolean isRunning = false;
    LogUtils logUtils = LogUtils.setLogger(LoginDeviceInfoAty.class);
    Runnable mCheckDistribution = new Runnable() {
        public void run() {
            NativeCaller.StopPPPP(LoginDeviceInfoAty.this.getApp().connectSSid);
            try {
                Thread.sleep(300);
            } catch (Exception unused) {
            }
            LoginDeviceInfoAty loginDeviceInfoAty = LoginDeviceInfoAty.this;
            loginDeviceInfoAty.StartPPPP(loginDeviceInfoAty.getApp().connectSSid, ContentCommon.DEFAULT_USER_NAME, ContentCommon.DEFAULT_USER_NAME, "test");
            LoginDeviceInfoAty.this.mHandler.postDelayed(LoginDeviceInfoAty.this.mCheckDistribution, 3000);
        }
    };
    Runnable mCheckListener = new Runnable() {
        public void run() {
            IWiFiStateListener listener = LoginDeviceInfoAty.this.getApp().getListener();
            LoginDeviceInfoAty loginDeviceInfoAty = LoginDeviceInfoAty.this;
            if (listener != loginDeviceInfoAty) {
                loginDeviceInfoAty.logUtils.e("ReciveListener close");
                LoginDeviceInfoAty.this.getApp().setOnReciveListener(LoginDeviceInfoAty.this);
                int unused = LoginDeviceInfoAty.this.checkCount = 0;
            } else {
                LoginDeviceInfoAty.access$708(loginDeviceInfoAty);
                if (LoginDeviceInfoAty.this.checkCount >= 20) {
                    LoginDeviceInfoAty.this.logUtils.e("ReciveListener open");
                    LoginDeviceInfoAty.this.mHandler.removeCallbacks(LoginDeviceInfoAty.this.mCheckListener);
                    return;
                }
            }
            LoginDeviceInfoAty.this.mHandler.postDelayed(LoginDeviceInfoAty.this.mCheckListener, 500);
        }
    };
    Runnable mDistributionFail = new Runnable() {
        public void run() {
            NativeCaller.StopPPPP(LoginDeviceInfoAty.this.getApp().connectSSid);
            LoginDeviceInfoAty.this.mHandler.sendEmptyMessage(4);
            BridgeService.setPlayInterface((BridgeService.PlayInterface) null);
            boolean unused = LoginDeviceInfoAty.this.isRunning = false;
            LoginDeviceInfoAty.this.runOnUiThread(new Runnable() {
                public void run() {
                    if (LoginDeviceInfoAty.this.progressdlg != null && LoginDeviceInfoAty.this.progressdlg.isShowing()) {
                        LoginDeviceInfoAty.this.progressdlg.dismiss();
                    }
                }
            });
        }
    };
    Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 3) {
                LoginDeviceInfoAty.this.mHandler.removeCallbacks(LoginDeviceInfoAty.this.mDistributionFail);
                LoginDeviceInfoAty.this.mHandler.removeCallbacks(LoginDeviceInfoAty.this.mCheckDistribution);
                Toast.makeText(LoginDeviceInfoAty.this.getApplicationContext(), LoginDeviceInfoAty.this.getResources().getString(R.string.one_key_net_distribution_success), 0).show();
                LoginDeviceInfoAty.this.finish();
                LoginDeviceInfoAty.this.overridePendingTransition(17432578, 17432579);
            } else if (i == 4 || i == 5) {
                LoginDeviceInfoAty.this.mHandler.removeCallbacks(LoginDeviceInfoAty.this.mCheckDistribution);
                LoginDeviceInfoAty.this.getApp().connectSSid = "";
                boolean unused = LoginDeviceInfoAty.this.isConnectFailed = true;
                Toast.makeText(LoginDeviceInfoAty.this.getApplicationContext(), LoginDeviceInfoAty.this.getResources().getString(R.string.one_key_net_distribution_failed), 0).show();
                LoginDeviceInfoAty.this.finish();
                LoginDeviceInfoAty.this.startActivity(new Intent(LoginDeviceInfoAty.this, AddDeviceFailedActivity.class));
            }
        }
    };
    Runnable mStartDistribution = new Runnable() {
        public void run() {
            LoginDeviceInfoAty loginDeviceInfoAty = LoginDeviceInfoAty.this;
            loginDeviceInfoAty.netDistribution(loginDeviceInfoAty.wifiSSID, LoginDeviceInfoAty.this.wifiPwd);
            LoginDeviceInfoAty.this.mHandler.postDelayed(LoginDeviceInfoAty.this.mDistributionFail, 90000);
        }
    };
    private Thread mThread = null;
    /* access modifiers changed from: private */
    public int nFaild = 0;
    /* access modifiers changed from: private */
    public ProgressDialog progressdlg = null;
    private TextView tvBack = null;
    /* access modifiers changed from: private */
    public String wifiPwd = "";
    /* access modifiers changed from: private */
    public String wifiSSID = "";

    private byte IBaseCmd_RightData(byte b) {
        return (b == 102 || b == 153) ? (byte) (b + 1) : b;
    }

    public void CallBackAlermType(String str, int i) {
    }

    public void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
    }

    public void callBackAudioData(byte[] bArr, int i) {
    }

    public void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
    }

    public void callBackH264Data(String str, byte[] bArr, int i, int i2) {
    }

    public void onConnectChange(String str) {
    }

    public void onLocationClosed() {
    }

    public void onStateChange(int i) {
    }

    static /* synthetic */ int access$408(LoginDeviceInfoAty loginDeviceInfoAty) {
        int i = loginDeviceInfoAty.nFaild;
        loginDeviceInfoAty.nFaild = i + 1;
        return i;
    }

    static /* synthetic */ int access$708(LoginDeviceInfoAty loginDeviceInfoAty) {
        int i = loginDeviceInfoAty.checkCount;
        loginDeviceInfoAty.checkCount = i + 1;
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
        Intent intent = getIntent();
        this.wifiSSID = intent.getStringExtra("wifiSSID");
        this.wifiPwd = intent.getStringExtra("wifiPwd");
        Log.e("LogDeviceInfo", "###wifiSSID:" + this.wifiSSID + "  wifiPwd:" + this.wifiPwd);
        setContentView(R.layout.ly_device_info);
        widget_init();
        this.bAvaild = false;
        getApp().setOnReciveListener(this);
        this.mHandler.postDelayed(this.mCheckListener, 100);
        BridgeService.setPlayInterface(this);
    }

    private void widget_init() {
        this.tvBack = (TextView) findViewById(R.id.back);
        this.tvBack.setOnClickListener(this);
        this.btnNextStep = (Button) findViewById(R.id.btnNextStep);
        this.btnNextStep.setOnClickListener(this);
        this.progressdlg = new ProgressDialog(this);
        this.progressdlg.setProgressStyle(0);
    }

    public void waitForAck() {
        Thread thread = this.mThread;
        if (thread == null || !thread.isAlive()) {
            this.mThread = new Thread(this.WaitAckRunnable);
            this.mThread.start();
        }
    }

    private String getNewSSID(String str) {
        return str.startsWith("\"") ? str.substring(1, str.length() - 1) : str;
    }

    public byte cmdCheckOdd(byte[] bArr, int i) {
        byte b = bArr[1];
        for (int i2 = 2; i2 < i; i2++) {
            b = (byte) (b ^ bArr[i2]);
        }
        return IBaseCmd_RightData((byte) (b & 255));
    }

    public void netDistribution(String str, String str2) {
        if (str.isEmpty()) {
            Log.e(OnkeyActivity.class.getSimpleName(), "SSID is null or asswd is null start");
            return;
        }
        byte[] bArr = new byte[128];
        try {
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length;
            System.arraycopy(bytes, 0, bArr, 1, length);
            byte[] bytes2 = str.getBytes("GBK");
            int length2 = bytes2.length;
            int i = length + 4;
            System.arraycopy(bytes2, 0, bArr, i, length2);
            byte[] bytes3 = str2.getBytes("UTF-8");
            bArr[length + 1] = 38;
            bArr[length + 2] = 38;
            bArr[length + 3] = 38;
            bArr[i + length2] = 35;
            bArr[length + 5 + length2] = 35;
            bArr[length + 6 + length2] = 35;
            int i2 = length + 7 + length2;
            System.arraycopy(bytes3, 0, bArr, i2, bytes3.length);
            LogUtils logUtils2 = this.logUtils;
            logUtils2.e("####ssid is " + "GBK" + new String(bytes2, "GBK"));
            bArr[0] = 102;
            bArr[bytes3.length + i2] = cmdCheckOdd(bArr, i2 + bytes3.length);
            bArr[length + 8 + length2 + bytes3.length] = -103;
            NativeCaller.iNetWorkDistribution(bArr, length + 9 + length2 + bytes3.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void startOneKey() {
        BridgeService.setPlayInterface(this);
        this.progressdlg.setMessage(getResources().getString(R.string.ap_distrubtion_net));
        this.progressdlg.setCancelable(false);
        this.progressdlg.show();
        this.isRunning = true;
        this.mHandler.postDelayed(this.mStartDistribution, 1000);
        this.mHandler.postDelayed(this.mCheckDistribution, 3000);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            backToLocalPage();
        } else if (id == R.id.btnNextStep) {
            this.bHasEnter = true;
            this.nFaild = 0;
            this.bAvaild = true;
            this.isConnectFailed = false;
            gotoSettingWiFi();
        }
    }

    /* access modifiers changed from: private */
    public App getApp() {
        return (App) getApplication();
    }

    public void onConnected(int i, String str) {
        String newSSID = getNewSSID(str);
        if (newSSID.isEmpty()) {
            this.bAvaild = false;
            this.btnNextStep.setText(getResources().getString(R.string.camera_connect_device_access));
        }
        if (i == 1 && this.isRestart) {
            if (newSSID.startsWith("THPC") || newSSID.startsWith("ACCQ") || newSSID.startsWith("THDK") || newSSID.startsWith("AZQ") || newSSID.startsWith("ALK") || newSSID.startsWith("BCCQ")) {
                getApp().connectSSid = newSSID;
                if (!this.isRunning && !this.isConnectFailed) {
                    startOneKey();
                }
            }
        }
    }

    public void gotoSettingWiFi() {
        Intent intent = new Intent();
        intent.setAction("android.net.wifi.PICK_WIFI_NETWORK");
        intent.putExtra(":settings:show_fragment_as_subsetting", true);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void backToLocalPage() {
        Intent intent = new Intent();
        intent.setClass(this, LoginLocalWiFiAty.class);
        intent.putExtra("wifiSSID", this.wifiSSID);
        intent.putExtra("wifiPwd", this.wifiPwd);
        startActivity(intent);
        finish();
        overridePendingTransition(17432578, 17432579);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.e("LogDeviceInfo", "###device hase resume!");
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        this.isRestart = true;
        Log.e("LogDeviceInfo", "###device has restart!");
        String newSSID = getNewSSID(getApp().getConnectWifi());
        Log.e("LogDeviceInfo", "SSID_now:" + newSSID);
        if (newSSID.startsWith("THPC") || newSSID.startsWith("ACCQ") || newSSID.startsWith("THDK") || newSSID.startsWith("AZQ") || newSSID.startsWith("ALK") || newSSID.startsWith("BCCQ")) {
            getApp().connectSSid = getNewSSID(getApp().getConnectWifi());
            if (!this.isRunning && !this.isConnectFailed) {
                startOneKey();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.isRestart = false;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        Log.e("LogDeviceInfo", "###device has stop!");
        this.isRestart = false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.mCheckListener);
        this.mHandler.removeCallbacks(this.mStartDistribution);
        this.mHandler.removeCallbacks(this.mDistributionFail);
        this.mHandler.removeCallbacks(this.mCheckDistribution);
        getApp().setOnReciveListener((IWiFiStateListener) null);
        BridgeService.setPlayInterface((BridgeService.PlayInterface) null);
    }

    public void onBackPressed() {
        super.onBackPressed();
        backToLocalPage();
    }

    public void callBackMessageNotify(String str, int i, int i2) {
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("LoginDeviceInfoAty MessageNotify did: " + str + " msgType: " + i + " param: " + i2);
        if (i2 == 2) {
            this.mHandler.sendEmptyMessage(3);
            this.isRunning = false;
            runOnUiThread(new Runnable() {
                public void run() {
                    if (LoginDeviceInfoAty.this.progressdlg != null && LoginDeviceInfoAty.this.progressdlg.isShowing()) {
                        LoginDeviceInfoAty.this.progressdlg.dismiss();
                    }
                }
            });
        }
    }
}
