package shix.ihdbell.project;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.view.delegate.IWifiListClickDelegate;
import com.tzh.ipcamera.view.dialog.WiFiScanDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

@SuppressLint({"NewApi"})
public class OnkeyActivity extends BaseActivity implements View.OnClickListener, BridgeService.AddCameraInterface, IWifiListClickDelegate {
    private static final int ONLINE_MSG_BY_TCP = 1;
    private static final int ONLINE_MSG_BY_UDP = 0;
    private static final int ONLINE_PORT_BY_TCP = 13590;
    private static final int ONLINE_PORT_BY_UDP = 1131;
    private final int CONNECTED = 3;
    private final int CONNECT_FAILED = 4;
    private final int COUNTTIMNE = 1;
    /* access modifiers changed from: private */
    public TextView PP_tv_ershow;
    /* access modifiers changed from: private */
    public TextView PP_tv_setting;
    private final int SOCKET_NULL = 5;
    private int SSID_REQUIST_CODE = 5;
    private final int TIMEOUT = 2;
    Runnable WaitAckRunnable = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
            if (r0 != 2) goto L_0x0046;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                shix.ihdbell.project.OnkeyActivity r0 = shix.ihdbell.project.OnkeyActivity.this
                r1 = 1
                r0.isRunning = r1
            L_0x0005:
                shix.ihdbell.project.OnkeyActivity r0 = shix.ihdbell.project.OnkeyActivity.this
                boolean r0 = r0.isRunning
                if (r0 == 0) goto L_0x0051
                int r0 = object.p2pipcam.nativecaller.NativeCaller.iNetworkGetState()
                r2 = -1
                r3 = 0
                if (r0 == r2) goto L_0x0030
                if (r0 == r1) goto L_0x0019
                r2 = 2
                if (r0 == r2) goto L_0x0030
                goto L_0x0046
            L_0x0019:
                shix.ihdbell.project.OnkeyActivity r0 = shix.ihdbell.project.OnkeyActivity.this
                android.os.Handler r0 = r0.mHandler
                r2 = 3
                r0.sendEmptyMessage(r2)
                shix.ihdbell.project.OnkeyActivity r0 = shix.ihdbell.project.OnkeyActivity.this
                r0.isRunning = r3
                shix.ihdbell.project.OnkeyActivity$2$2 r2 = new shix.ihdbell.project.OnkeyActivity$2$2
                r2.<init>()
                r0.runOnUiThread(r2)
                goto L_0x0046
            L_0x0030:
                shix.ihdbell.project.OnkeyActivity r0 = shix.ihdbell.project.OnkeyActivity.this
                android.os.Handler r0 = r0.mHandler
                r2 = 4
                r0.sendEmptyMessage(r2)
                shix.ihdbell.project.OnkeyActivity r0 = shix.ihdbell.project.OnkeyActivity.this
                r0.isRunning = r3
                shix.ihdbell.project.OnkeyActivity$2$1 r2 = new shix.ihdbell.project.OnkeyActivity$2$1
                r2.<init>()
                r0.runOnUiThread(r2)
            L_0x0046:
                r2 = 200(0xc8, double:9.9E-322)
                java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x004c }
                goto L_0x0005
            L_0x004c:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0005
            L_0x0051:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.OnkeyActivity.AnonymousClass2.run():void");
        }
    };
    private TextView back;
    private Bitmap bitmap;
    private String bssid = "";
    /* access modifiers changed from: private */
    public Button button_open_ss;
    private Button buttonsEnd;
    private Button buttonstart;
    private Button buttonstartEr;
    /* access modifiers changed from: private */
    public int clickType;
    /* access modifiers changed from: private */
    public int count = 70;
    String custom;
    private Button done;
    /* access modifiers changed from: private */
    public EditText editTextPWD;
    private EditText editTextSSID;
    /* access modifiers changed from: private */
    public ImageView img_er;
    private String ip;
    /* access modifiers changed from: private */
    public boolean isRegist = false;
    boolean isRunning = false;
    private String mConnectedBBSsid;
    /* access modifiers changed from: private */
    public String mConnectedSsid;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                TextView access$300 = OnkeyActivity.this.PP_tv_setting;
                access$300.setText(OnkeyActivity.this.getResources().getString(R.string.one_key_setting_stat_ing) + " " + OnkeyActivity.this.count);
            } else if (i == 2) {
                OnkeyActivity.this.pp_ll_setting.setVisibility(8);
                boolean unused = OnkeyActivity.this.isRegist = false;
                OnkeyActivity.this.finish();
                OnkeyActivity.this.startActivity(new Intent(OnkeyActivity.this, SertchActivity.class));
                OnkeyActivity.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            } else if (i == 3) {
                Toast.makeText(OnkeyActivity.this.getApplicationContext(), OnkeyActivity.this.getResources().getString(R.string.one_key_net_distribution_success), 0).show();
                OnkeyActivity.this.netWorkAddCamera();
            } else if (i == 4 || i == 5) {
                Toast.makeText(OnkeyActivity.this.getApplicationContext(), OnkeyActivity.this.getResources().getString(R.string.one_key_net_distribution_failed), 0).show();
            }
        }
    };
    /* access modifiers changed from: private */
    public String mTargetSSID = "";
    Thread mThread = null;
    private WiFiScanDialog mWifiDialog = null;
    private WifiManager mWifiManager;
    private int option = 65535;
    /* access modifiers changed from: private */
    public LinearLayout pp_ll_setting;
    private SharedPreferences preuser;
    /* access modifiers changed from: private */
    public ProgressDialog progressdlg = null;
    private List<ScanResult> resultList = new ArrayList();
    private int sertchcount;
    private String strEr = "";
    private String strName = "";
    private String strOldDID = "";
    private String strPwd = "";
    private String strUser = "";

    private byte IBaseCmd_RightData(byte b) {
        return (b == 102 || b == 153) ? (byte) (b + 1) : b;
    }

    private void InitParams() {
    }

    public void callBackResetResultData(int i) {
    }

    static /* synthetic */ int access$210(OnkeyActivity onkeyActivity) {
        int i = onkeyActivity.count;
        onkeyActivity.count = i - 1;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.onkey_camera);
        this.sertchcount = 0;
        this.preuser = getSharedPreferences("shixpwd", 0);
        Log.e("OneKeyActivity", "start onekey activity");
        findView();
        InitParams();
        BridgeService.setAddCameraInterface(this);
        initExitPopupWindow_List();
        wifiSetting();
        SetTab(this);
        this.progressdlg = new ProgressDialog(this);
        this.progressdlg.setProgressStyle(0);
    }

    private void wifiSetting() {
        this.mWifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (this.mWifiManager.isWifiEnabled()) {
            WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
            this.bssid = connectionInfo.getBSSID();
            String ssid = connectionInfo.getSSID();
            this.mConnectedSsid = ssid;
            this.mTargetSSID = ssid;
            int length = this.mConnectedSsid.length();
            if (this.mConnectedSsid.startsWith("\"") && this.mConnectedSsid.endsWith("\"")) {
                this.mConnectedSsid = this.mConnectedSsid.substring(1, length - 1);
            }
            this.editTextSSID.setText(this.mConnectedSsid);
            if (this.preuser.getString(this.mConnectedSsid, "") != null && this.preuser.getString(this.mConnectedSsid, "").length() > 0) {
                this.editTextPWD.setText(this.preuser.getString(this.mConnectedSsid, ""));
            }
        }
    }

    /* access modifiers changed from: private */
    public void hideSof(EditText editText) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.isRunning = false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        String obj;
        String str = this.mConnectedSsid;
        if (str != null && str.length() > 3 && (obj = this.editTextPWD.getText().toString()) != null && obj.length() > 3) {
            SharedPreferences.Editor edit = this.preuser.edit();
            edit.putString(this.mConnectedSsid, obj);
            edit.commit();
        }
        super.onDestroy();
    }

    private void findView() {
        findViewById(R.id.buttontg).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(OnkeyActivity.this, 20);
                OnkeyActivity.this.finish();
                OnkeyActivity.this.startActivity(new Intent(OnkeyActivity.this, SertchActivity.class));
                OnkeyActivity.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(OnkeyActivity.this, 20);
                OnkeyActivity.this.finish();
                OnkeyActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
        findViewById(R.id.buttonShow).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(OnkeyActivity.this, 20);
                OnkeyActivity.this.finish();
                OnkeyActivity.this.startActivity(new Intent(OnkeyActivity.this, AddCameraActivity.class));
                OnkeyActivity.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.done) {
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    private void hiddenInputMethod() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    public String ipCheck(String str) {
        if (str == null || str.isEmpty()) {
            return "matches ip";
        }
        if (str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")) {
            return str + "\n ipCheck matches";
        }
        return str + "\n ipCheck matches 111";
    }

    public boolean ipCheck11(String str) {
        if (str == null || str.isEmpty() || !str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")) {
            return false;
        }
        return true;
    }

    public void showDialog() {
        WiFiScanDialog wiFiScanDialog = this.mWifiDialog;
        if (wiFiScanDialog == null || !wiFiScanDialog.isShowing()) {
            this.resultList = getWifiList();
            Log.e("OnkeyActivity", "resultList:" + this.resultList.size());
            WiFiScanDialog wiFiScanDialog2 = this.mWifiDialog;
            if (wiFiScanDialog2 == null || !wiFiScanDialog2.isShowing()) {
                this.mWifiDialog = new WiFiScanDialog(this, R.style.dialog, this.resultList, this);
                this.mWifiDialog.show();
            }
        }
    }

    public List<ScanResult> getWifiList() {
        List<ScanResult> scanResults = ((WifiManager) getApplicationContext().getSystemService("wifi")).getScanResults();
        ArrayList arrayList = new ArrayList();
        if (scanResults != null && scanResults.size() > 0) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < scanResults.size(); i++) {
                ScanResult scanResult = scanResults.get(i);
                if (!scanResult.SSID.isEmpty()) {
                    String str = scanResult.SSID + " " + scanResult.capabilities;
                    if (!hashMap.containsKey(str)) {
                        hashMap.put(str, Integer.valueOf(i));
                        arrayList.add(scanResult);
                        Log.e(OnkeyActivity.class.getSimpleName(), "get wifi:" + scanResult.SSID);
                    }
                }
            }
        }
        return arrayList;
    }

    public void onItemClick(String str, int i) {
        if (!str.isEmpty()) {
            this.editTextSSID.setText(str);
            this.mTargetSSID = str;
        }
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
        byte[] bytes = str.getBytes();
        byte[] bytes2 = str2.getBytes();
        bArr[0] = 102;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        bArr[bytes.length + 1] = 35;
        bArr[bytes.length + 2] = 35;
        bArr[bytes.length + 3] = 35;
        System.arraycopy(bytes2, 0, bArr, bytes.length + 4, bytes2.length);
        bArr[bytes.length + 4 + bytes2.length] = cmdCheckOdd(bArr, bytes.length + 4 + bytes2.length);
        bArr[bytes.length + 5 + bytes2.length] = -103;
        for (int i = 0; i < bytes.length + 6 + bytes2.length; i++) {
            Log.e("OnKeyActivity", String.format("%d==%02x", new Object[]{Integer.valueOf(i), Byte.valueOf(bArr[i])}));
        }
        NativeCaller.iNetWorkDistribution(bArr, bytes.length + 6 + bytes2.length);
    }

    public void waitForAck() {
        Thread thread = this.mThread;
        if (thread == null || !thread.isAlive()) {
            this.mThread = new Thread(this.WaitAckRunnable);
            this.mThread.start();
        }
    }

    /* access modifiers changed from: protected */
    public void initParam() {
        Intent intent = getIntent();
        this.option = intent.getIntExtra(ContentCommon.CAMERA_OPTION, 65535);
        if (this.option != 65535) {
            this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
            this.strOldDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
            this.strUser = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
            this.strPwd = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
        }
        this.strName = this.strName.isEmpty() ? "DoorBell" : this.strName;
        this.strUser = this.strUser.isEmpty() ? ContentCommon.DEFAULT_USER_NAME : this.strUser;
        String simpleName = OnkeyActivity.class.getSimpleName();
        Log.e(simpleName, "name:" + this.strName);
        String simpleName2 = OnkeyActivity.class.getSimpleName();
        Log.e(simpleName2, "id:" + this.strOldDID);
        String simpleName3 = OnkeyActivity.class.getSimpleName();
        Log.e(simpleName3, "user:" + this.strUser);
        String simpleName4 = OnkeyActivity.class.getSimpleName();
        Log.e(simpleName4, "passwd:" + this.strPwd);
    }

    public void netWorkAddCamera() {
        activityResultCb(this.mConnectedSsid);
        finish();
    }

    private void activityResultCb(String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(ContentCommon.STR_CAMERA_ID, str);
        intent.putExtras(bundle);
        setResult(this.SSID_REQUIST_CODE, intent);
        finish();
    }

    public void initExitPopupWindow_List() {
        this.editTextSSID = (EditText) findViewById(R.id.editSSID);
        this.editTextPWD = (EditText) findViewById(R.id.editPwd);
        this.editTextSSID.setEnabled(false);
        this.editTextPWD.setTypeface(Typeface.DEFAULT);
        this.editTextPWD.setTransformationMethod(new PasswordTransformationMethod());
        this.img_er = (ImageView) findViewById(R.id.img_er);
        ((Button) findViewById(R.id.button_refresh)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OnkeyActivity.this.showDialog();
            }
        });
        this.pp_ll_setting = (LinearLayout) findViewById(R.id.pp_ll_setting);
        this.PP_tv_setting = (TextView) findViewById(R.id.PP_tv_setting);
        this.PP_tv_ershow = (TextView) findViewById(R.id.PP_tv_ershow);
        this.button_open_ss = (Button) findViewById(R.id.button_open_ss);
        this.button_open_ss.setTag(1);
        this.button_open_ss.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(OnkeyActivity.this, 20);
                if (OnkeyActivity.this.button_open_ss.getTag().toString().equals("1")) {
                    OnkeyActivity.this.button_open_ss.setTag(2);
                    OnkeyActivity.this.button_open_ss.setText(R.string.setting_user_2);
                    OnkeyActivity.this.editTextPWD.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    return;
                }
                OnkeyActivity.this.button_open_ss.setTag(1);
                OnkeyActivity.this.button_open_ss.setText(R.string.setting_user_1);
                OnkeyActivity.this.editTextPWD.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
        this.buttonstart = (Button) findViewById(R.id.buttonstart);
        this.buttonstart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(OnkeyActivity.this, 20);
                OnkeyActivity onkeyActivity = OnkeyActivity.this;
                onkeyActivity.hideSof(onkeyActivity.editTextPWD);
                if (OnkeyActivity.this.mConnectedSsid != null && OnkeyActivity.this.mConnectedSsid.length() >= 3) {
                    int unused = OnkeyActivity.this.clickType = 1;
                    String obj = OnkeyActivity.this.editTextPWD.getText().toString();
                    if (obj == null) {
                        obj = "";
                    }
                    OnkeyActivity.this.img_er.setVisibility(8);
                    OnkeyActivity.this.PP_tv_ershow.setVisibility(8);
                    OnkeyActivity onkeyActivity2 = OnkeyActivity.this;
                    onkeyActivity2.custom = "";
                    onkeyActivity2.waitForAck();
                    OnkeyActivity onkeyActivity3 = OnkeyActivity.this;
                    onkeyActivity3.netDistribution(onkeyActivity3.mTargetSSID, obj);
                    OnkeyActivity.this.progressdlg.setMessage(OnkeyActivity.this.getResources().getString(R.string.ap_distrubtion_net));
                    OnkeyActivity.this.progressdlg.setCancelable(false);
                    OnkeyActivity.this.progressdlg.show();
                }
            }
        });
    }

    public void callBackSearchResultData(int i, String str, String str2, String str3, String str4, int i2) {
        CommonUtil.Log(1, "strMac:" + str + "  strName:" + str2 + "  strDeviceID:" + str3 + "  strIpAddr:" + str4 + "  port:" + i2);
    }

    public void onBackPressed() {
        super.onBackPressed();
        activityResultCb("");
    }

    private class MsgHandler extends Handler {
        byte ret;

        private MsgHandler() {
        }

        public void handleMessage(Message message) {
            Log.d("TEST", " CONFIG msg.what: " + message.what);
        }
    }

    class MyTimeThread extends Thread {
        MyTimeThread() {
        }

        public void run() {
            while (OnkeyActivity.this.isRegist) {
                OnkeyActivity.this.mHandler.sendEmptyMessage(1);
                OnkeyActivity.access$210(OnkeyActivity.this);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (OnkeyActivity.this.count == 0 && OnkeyActivity.this.isRegist) {
                    OnkeyActivity.this.mHandler.sendEmptyMessage(2);
                    boolean unused = OnkeyActivity.this.isRegist = false;
                }
            }
            super.run();
        }
    }
}
