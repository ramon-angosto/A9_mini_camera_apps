package shix.ihdbell.project;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jxl.app.littlestars.project.R;
import java.util.Timer;
import java.util.TimerTask;
import object.p2pipcam.adapter.WifiScanListAdapter;
import object.p2pipcam.bean.WifiBean;
import object.p2pipcam.bean.WifiScanBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

public class SettingWifiActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemClickListener, BridgeService.WifiInterface {
    private static final int INITTIMEOUT = 10000;
    private int CAMERAPARAM = -1;
    private final int END = 1;
    /* access modifiers changed from: private */
    public String LOG_TAG = "SettingWifiActivity";
    private final int NO = 0;
    private final int OVER = 3;
    private final int SCANPARAMS = 2;
    private final int TIMEOUT = 4;
    private final int WEP = 1;
    private final int WIFIPARAMS = 1;
    private final int WPA2_PSK_AES = 4;
    private final int WPA2_PSK_TKIP = 5;
    private final int WPA_PSK_AES = 2;
    private final int WPA_PSK_TKIP = 3;
    private Button btnCancel;
    private Button btnManager;
    private Button btnOk;
    private String cameraName;
    private CheckBox cbxShowPwd;
    private boolean changeWifiFlag = false;
    private EditText editPwd;
    private RadioGroup group1;
    private RadioGroup group2;
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            TextView access$100 = SettingWifiActivity.this.tvSigal;
            access$100.setText(SettingWifiActivity.this.wifiBean.getDbm0() + "%");
            SettingWifiActivity.this.tvName.setText(SettingWifiActivity.this.wifiBean.getSsid());
            SettingWifiActivity.this.signalView.setVisibility(0);
            SettingWifiActivity.this.tvPrompt.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_not_connected));
            int authtype = SettingWifiActivity.this.wifiBean.getAuthtype();
            if (authtype == 0) {
                SettingWifiActivity.this.pwdView.setVisibility(8);
                SettingWifiActivity.this.tvSafe.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_no_safe));
                SettingWifiActivity.this.layoutwep_show1.setVisibility(8);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(8);
            } else if (authtype == 1) {
                SettingWifiActivity.this.pwdView.setVisibility(0);
                SettingWifiActivity.this.layoutwep_show1.setVisibility(0);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(0);
                SettingWifiActivity.this.tvSafe.setText("WEP");
            } else if (authtype == 2) {
                SettingWifiActivity.this.pwdView.setVisibility(0);
                SettingWifiActivity.this.tvSafe.setText("WPA_PSK(AES)");
                SettingWifiActivity.this.layoutwep_show1.setVisibility(8);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(8);
            } else if (authtype == 3) {
                SettingWifiActivity.this.pwdView.setVisibility(0);
                SettingWifiActivity.this.tvSafe.setText("WPA_PSK(TKIP)");
                SettingWifiActivity.this.layoutwep_show1.setVisibility(8);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(8);
            } else if (authtype == 4) {
                SettingWifiActivity.this.pwdView.setVisibility(0);
                SettingWifiActivity.this.tvSafe.setText("WPA2_PSK(AES)");
                SettingWifiActivity.this.layoutwep_show1.setVisibility(8);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(8);
            } else if (authtype == 5) {
                SettingWifiActivity.this.pwdView.setVisibility(0);
                SettingWifiActivity.this.tvSafe.setText("WPA2_PSK(TKIP)");
                SettingWifiActivity.this.layoutwep_show1.setVisibility(8);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(8);
            }
        }
    };
    private ImageView imgDropDown;
    /* access modifiers changed from: private */
    public boolean isTimerOver = false;
    /* access modifiers changed from: private */
    public LinearLayout layoutwep_show1;
    /* access modifiers changed from: private */
    public LinearLayout layoutwep_show2;
    /* access modifiers changed from: private */
    public WifiScanListAdapter mAdapter;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                boolean unused = SettingWifiActivity.this.successFlag = true;
                if (SettingWifiActivity.this.progressDialog.isShowing()) {
                    SettingWifiActivity.this.progressDialog.cancel();
                }
                if (SettingWifiActivity.this.wifiBean.getEnable() == 1) {
                    if (!TextUtils.isEmpty(SettingWifiActivity.this.wifiBean.getSsid())) {
                        SettingWifiActivity.this.tvName.setText(SettingWifiActivity.this.wifiBean.getSsid());
                        SettingWifiActivity.this.tvPrompt.setText(SettingWifiActivity.this.getResources().getString(R.string.connected));
                    } else {
                        SettingWifiActivity.this.tvName.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_no_safe));
                        SettingWifiActivity.this.tvPrompt.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_not_connected));
                    }
                    int authtype = SettingWifiActivity.this.wifiBean.getAuthtype();
                    if (authtype == 0) {
                        SettingWifiActivity.this.tvSafe.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_no_safe));
                    } else if (authtype == 1) {
                        SettingWifiActivity.this.tvSafe.setText("WEP");
                    } else if (authtype == 2) {
                        SettingWifiActivity.this.tvSafe.setText("WPA_PSK(AES)");
                    } else if (authtype == 3) {
                        SettingWifiActivity.this.tvSafe.setText("WPA_PSK(TKIP)");
                    } else if (authtype == 4) {
                        SettingWifiActivity.this.tvSafe.setText("WPA2_PSK(AES)");
                    } else if (authtype == 5) {
                        SettingWifiActivity.this.tvSafe.setText("WPA2_PSK(TKIP)");
                    }
                }
            } else if (i == 2) {
                Log.d(SettingWifiActivity.this.LOG_TAG, "handler  scan wifi");
                if (SettingWifiActivity.this.scanDialog != null && SettingWifiActivity.this.scanDialog.isShowing()) {
                    SettingWifiActivity.this.scanDialog.cancel();
                    if (!SettingWifiActivity.this.isTimerOver) {
                        SettingWifiActivity.this.mTimerTimeOut.cancel();
                    }
                    Log.d(SettingWifiActivity.this.LOG_TAG, "handler  scan wifi  2");
                }
                SettingWifiActivity.this.mAdapter.wifiSort();
                SettingWifiActivity.this.mListView.setAdapter(SettingWifiActivity.this.mAdapter);
                SettingWifiActivity.this.setListViewHeight();
                SettingWifiActivity.this.mListView.setVisibility(0);
                Log.d(SettingWifiActivity.this.LOG_TAG, "handler  scan wifi  3");
            } else if (i == 3) {
                boolean unused2 = SettingWifiActivity.this.successFlag = true;
                if (SettingWifiActivity.this.result == 1) {
                    Log.d("tag", "over");
                    NativeCaller.PPPPRebootDevice(SettingWifiActivity.this.strDID);
                    SettingWifiActivity settingWifiActivity = SettingWifiActivity.this;
                    Toast.makeText(settingWifiActivity, settingWifiActivity.getResources().getString(R.string.wifi_set_success), 1).show();
                    SettingWifiActivity.this.sendBroadcast(new Intent("myback"));
                    SettingWifiActivity.this.finish();
                } else if (SettingWifiActivity.this.result == 0) {
                    SettingWifiActivity.this.showToast((int) R.string.wifi_set_failed);
                }
            } else if (i == 4 && SettingWifiActivity.this.scanDialog.isShowing()) {
                SettingWifiActivity.this.scanDialog.cancel();
            }
        }
    };
    /* access modifiers changed from: private */
    public ListView mListView;
    /* access modifiers changed from: private */
    public Timer mTimerTimeOut;
    private PopupWindow popupWindow;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog;
    /* access modifiers changed from: private */
    public View pwdView;
    /* access modifiers changed from: private */
    public RadioButton rb1;
    /* access modifiers changed from: private */
    public RadioButton rb2;
    /* access modifiers changed from: private */
    public RadioButton rb3;
    /* access modifiers changed from: private */
    public RadioButton rb4;
    /* access modifiers changed from: private */
    public int result;
    private Runnable runnable = new Runnable() {
        public void run() {
            if (!SettingWifiActivity.this.successFlag) {
                SettingWifiActivity.this.progressDialog.dismiss();
            }
        }
    };
    /* access modifiers changed from: private */
    public ProgressDialog scanDialog;
    private Runnable settingRunnable = new Runnable() {
        public void run() {
            if (!SettingWifiActivity.this.successFlag) {
                SettingWifiActivity.this.showToast((int) R.string.wifi_set_failed);
            }
        }
    };
    /* access modifiers changed from: private */
    public View signalView;
    /* access modifiers changed from: private */
    public String strDID;
    /* access modifiers changed from: private */
    public boolean successFlag = false;
    private TextView tvCameraName;
    /* access modifiers changed from: private */
    public TextView tvName;
    /* access modifiers changed from: private */
    public TextView tvPrompt;
    /* access modifiers changed from: private */
    public TextView tvSafe;
    /* access modifiers changed from: private */
    public TextView tvSigal;
    /* access modifiers changed from: private */
    public WifiBean wifiBean;

    /* access modifiers changed from: protected */
    public void onResume() {
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        StopHeat();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.settingwifi);
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.wifi_getparams));
        this.progressDialog.show();
        this.mHandler.postDelayed(this.runnable, 10000);
        this.wifiBean = new WifiBean();
        findView();
        setListener();
        this.mAdapter = new WifiScanListAdapter(this);
        this.mListView.setOnItemClickListener(this);
        BridgeService.setWifiInterface(this);
        NativeCaller.PPPPGetSystemParams(this.strDID, 4);
        SetTab(this);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    private void setListener() {
        this.imgDropDown.setOnClickListener(this);
        this.btnManager.setOnClickListener(this);
        this.btnOk.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
        this.cbxShowPwd.setOnCheckedChangeListener(this);
    }

    private void findView() {
        this.imgDropDown = (ImageView) findViewById(R.id.wifi_img_drop);
        this.layoutwep_show1 = (LinearLayout) findViewById(R.id.wep_show1);
        this.layoutwep_show2 = (LinearLayout) findViewById(R.id.wep_show2);
        this.btnOk = (Button) findViewById(R.id.wifi_ok);
        this.btnCancel = (Button) findViewById(R.id.wifi_cancel);
        this.cbxShowPwd = (CheckBox) findViewById(R.id.wifi_cbox_show_pwd);
        this.mListView = (ListView) findViewById(R.id.wifi_listview);
        this.tvName = (TextView) findViewById(R.id.wifi_tv_name);
        this.tvPrompt = (TextView) findViewById(R.id.wifi_tv_prompt);
        this.tvSafe = (TextView) findViewById(R.id.wifi_tv_safe);
        this.tvSigal = (TextView) findViewById(R.id.wifi_tv_sigal);
        this.editPwd = (EditText) findViewById(R.id.wifi_edit_pwd);
        this.btnManager = (Button) findViewById(R.id.wifi_btn_manger);
        this.pwdView = findViewById(R.id.wifi_pwd_view);
        this.signalView = findViewById(R.id.wifi_sigalview);
        this.tvCameraName = (TextView) findViewById(R.id.tv_camera_setting);
        this.group1 = (RadioGroup) findViewById(R.id.group1);
        this.group2 = (RadioGroup) findViewById(R.id.group2);
        this.rb1 = (RadioButton) findViewById(R.id.rb1);
        this.rb2 = (RadioButton) findViewById(R.id.rb2);
        this.rb3 = (RadioButton) findViewById(R.id.rb3);
        this.rb4 = (RadioButton) findViewById(R.id.rb4);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.top);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.top_bg));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        bitmapDrawable.setDither(true);
        this.group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingWifiActivity.this.rb1.getId()) {
                    SettingWifiActivity.this.wifiBean.setEncryp(0);
                    Log.d("tag", "wifiBean.setEncryp(0)");
                } else if (i == SettingWifiActivity.this.rb2.getId()) {
                    SettingWifiActivity.this.wifiBean.setEncryp(1);
                    Log.d("tag", "wifiBean.setEncryp(1)");
                }
            }
        });
        this.group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingWifiActivity.this.rb3.getId()) {
                    SettingWifiActivity.this.wifiBean.setKeyformat(1);
                    Log.d("tag", "wifiBean.setKeyformat(1)");
                } else if (i == SettingWifiActivity.this.rb4.getId()) {
                    SettingWifiActivity.this.wifiBean.setKeyformat(0);
                    Log.d("tag", "wifiBean.setKeyformat(0)");
                }
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            this.popupWindow.dismiss();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        switch (view.getId()) {
            case R.id.wifi_btn_manger:
                this.mAdapter.clearWifi();
                this.mAdapter.notifyDataSetChanged();
                this.mListView.setVisibility(8);
                NativeCaller.PPPPGetSystemParams(this.strDID, 20);
                this.scanDialog = new ProgressDialog(this);
                this.scanDialog.setProgressStyle(0);
                this.scanDialog.setMessage(getResources().getString(R.string.wifi_scanning));
                this.scanDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        return i == 4;
                    }
                });
                this.scanDialog.show();
                setTimeOut();
                return;
            case R.id.wifi_cancel:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.wifi_ok:
                if (!this.changeWifiFlag) {
                    showToast((int) R.string.wifi_setting_no_change);
                    return;
                } else {
                    setWifi();
                    return;
                }
            default:
                return;
        }
    }

    private void setTimeOut() {
        AnonymousClass8 r0 = new TimerTask() {
            public void run() {
                Log.d(SettingWifiActivity.this.LOG_TAG, "isTimeOver");
                boolean unused = SettingWifiActivity.this.isTimerOver = true;
                SettingWifiActivity.this.mHandler.sendEmptyMessage(4);
            }
        };
        this.mTimerTimeOut = new Timer();
        this.mTimerTimeOut.schedule(r0, 10000);
    }

    private void setWifi() {
        if (this.changeWifiFlag) {
            String obj = this.editPwd.getText().toString();
            if (this.wifiBean.getAuthtype() == 0) {
                this.wifiBean.setWpa_psk("");
                this.wifiBean.setKey1("");
            } else if (TextUtils.isEmpty(obj)) {
                showToast((int) R.string.pwd_no_empty);
                return;
            } else if (this.wifiBean.getAuthtype() == 1) {
                this.wifiBean.setKey1(obj);
            } else {
                this.wifiBean.setWpa_psk(obj);
            }
            Log.d("tag", "wifiBean.getEncryp():" + this.wifiBean.getEncryp() + "wifiBean.getKeyformat():" + this.wifiBean.getKeyformat());
            try {
                NativeCaller.PPPPWifiSetting(this.wifiBean.getDid(), this.wifiBean.getEnable(), this.wifiBean.getSsid(), this.wifiBean.getChannel(), this.wifiBean.getMode(), this.wifiBean.getAuthtype(), this.wifiBean.getEncryp(), this.wifiBean.getKeyformat(), this.wifiBean.getDefkey(), this.wifiBean.getKey1(), this.wifiBean.getKey2(), this.wifiBean.getKey3(), this.wifiBean.getKey4(), this.wifiBean.getKey1_bits(), this.wifiBean.getKey2_bits(), this.wifiBean.getKey3_bits(), this.wifiBean.getKey4_bits(), this.wifiBean.getWpa_psk());
            } catch (Exception e) {
                showToast((int) R.string.wifi_scan_failed);
                e.printStackTrace();
            }
        }
    }

    private void setttingTimeOut() {
        this.successFlag = false;
        this.mHandler.postAtTime(this.settingRunnable, 10000);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.editPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            this.editPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.changeWifiFlag = true;
        WifiScanBean wifiScan = this.mAdapter.getWifiScan(i);
        this.wifiBean.setSsid(wifiScan.getSsid());
        this.wifiBean.setAuthtype(wifiScan.getSecurity());
        this.wifiBean.setChannel(wifiScan.getChannel());
        this.wifiBean.setDbm0(wifiScan.getDbm0());
        this.handler.sendEmptyMessage(1);
    }

    public void setListViewHeight() {
        ListAdapter adapter = this.mListView.getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            int i = 0;
            for (int i2 = 0; i2 < count; i2++) {
                View view = adapter.getView(i2, (View) null, this.mListView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = this.mListView.getLayoutParams();
            layoutParams.height = i + (this.mListView.getDividerHeight() * (adapter.getCount() - 1));
            this.mListView.setLayoutParams(layoutParams);
        }
    }

    public void callBackWifiParams(String str, int i, String str2, int i2, int i3, int i4, int i5, int i6, int i7, String str3, String str4, String str5, String str6, int i8, int i9, int i10, int i11, String str7) {
        String str8 = str;
        String str9 = str2;
        int i12 = i2;
        int i13 = i4;
        String str10 = str7;
        StringBuilder sb = new StringBuilder();
        sb.append("did:");
        sb.append(str);
        sb.append(" enable:");
        int i14 = i;
        sb.append(i);
        sb.append(" ssid:");
        sb.append(str2);
        sb.append(" channel:");
        sb.append(i2);
        sb.append(" authtype:");
        sb.append(i4);
        sb.append(" encryp:");
        int i15 = i5;
        sb.append(i5);
        sb.append(" wpa_psk:");
        sb.append(str10);
        Log.d("shix", sb.toString());
        this.wifiBean.setDid(str);
        this.wifiBean.setEnable(1);
        this.wifiBean.setSsid(str2);
        this.wifiBean.setChannel(i2);
        this.wifiBean.setMode(0);
        this.wifiBean.setAuthtype(i4);
        this.wifiBean.setEncryp(0);
        this.wifiBean.setKeyformat(0);
        this.wifiBean.setDefkey(0);
        this.wifiBean.setKey1(str3);
        this.wifiBean.setKey2("");
        this.wifiBean.setKey3("");
        this.wifiBean.setKey4("");
        this.wifiBean.setKey1_bits(0);
        this.wifiBean.setKey2_bits(0);
        this.wifiBean.setKey3_bits(0);
        this.wifiBean.setKey4_bits(0);
        this.wifiBean.setWpa_psk(str10);
        Log.d(this.LOG_TAG, this.wifiBean.toString());
        this.mHandler.sendEmptyMessage(1);
    }

    public void callBackWifiScanResult(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6) {
        Log.d("shix", "ssid:" + str2 + " mac:" + str3 + " security:" + i + " dbm0" + i2 + " dbm1:" + i3 + " mode:" + i4 + " channel:" + i5 + " bEnd:" + i6);
        String str4 = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("bEnd=");
        sb.append(i6);
        Log.d(str4, sb.toString());
        WifiScanBean wifiScanBean = new WifiScanBean();
        wifiScanBean.setDid(str);
        wifiScanBean.setSsid(str2);
        wifiScanBean.setChannel(i5);
        wifiScanBean.setSecurity(i);
        wifiScanBean.setDbm0(i2);
        wifiScanBean.setMac(str3);
        wifiScanBean.setMode(i4);
        wifiScanBean.setDbm1(i3);
        this.mAdapter.addWifiScan(wifiScanBean);
        if (i6 == 1) {
            this.mHandler.sendEmptyMessage(2);
        }
    }

    public void callBackSetSystemParamsResult(String str, int i, int i2) {
        Log.d("tag", "result:" + i2);
        this.result = i2;
        this.mHandler.sendEmptyMessage(3);
    }

    public void callBackPPPPMsgNotifyData(String str, int i, int i2) {
        if (this.strDID.equals(str) && i == 0) {
            this.CAMERAPARAM = i2;
        }
    }
}
