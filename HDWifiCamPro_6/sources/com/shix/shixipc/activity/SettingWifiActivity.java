package com.shix.shixipc.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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
import androidx.work.WorkRequest;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.adapter.WifiScanListAdapter;
import com.shix.shixipc.bean.WifiModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import object.p2pipcam.nativecaller.NativeCaller;

public class SettingWifiActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemClickListener, NUIMainActivity.SHIXCOMMONInterface {
    private static final int INITTIMEOUT = 10000;
    private int CAMERAPARAM = -1;
    private final int END = 1;
    /* access modifiers changed from: private */
    public String LOG_TAG = "SettingWifiActivity";
    private final int NO = 0;
    private final int OVER = 3;
    private final int SCANCLEARS = 6;
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
    private Button btn_cancel;
    private Button btn_create;
    private String cameraName;
    private CheckBox cbxShowPwd;
    private boolean changeWifiFlag = false;
    private EditText editPwd;
    private EditText editText_GroupName;
    private EditText editText_GroupName_pass;
    private RadioGroup group1;
    private RadioGroup group2;
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            TextView access$1400 = SettingWifiActivity.this.tvSigal;
            access$1400.setText(SettingWifiActivity.this.wifiBean.getSignal() + "%");
            SettingWifiActivity.this.tvName.setText(SettingWifiActivity.this.wifiBean.getSsid());
            SettingWifiActivity.this.signalView.setVisibility(0);
            SettingWifiActivity.this.tvPrompt.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_not_connected));
            int encryption = SettingWifiActivity.this.wifiBean.getEncryption();
            if (encryption == 0) {
                SettingWifiActivity.this.pwdView.setVisibility(0);
                SettingWifiActivity.this.tvSafe.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_no_safe));
                SettingWifiActivity.this.layoutwep_show1.setVisibility(8);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(8);
            } else if (encryption == 1) {
                SettingWifiActivity.this.pwdView.setVisibility(0);
                SettingWifiActivity.this.layoutwep_show1.setVisibility(8);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(8);
                SettingWifiActivity.this.tvSafe.setText("WEP");
            } else if (encryption == 2) {
                SettingWifiActivity.this.pwdView.setVisibility(0);
                SettingWifiActivity.this.tvSafe.setText("WPA_PSK(AES)");
                SettingWifiActivity.this.layoutwep_show1.setVisibility(8);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(8);
            } else if (encryption == 3) {
                SettingWifiActivity.this.pwdView.setVisibility(0);
                SettingWifiActivity.this.tvSafe.setText("WPA_PSK(TKIP)");
                SettingWifiActivity.this.layoutwep_show1.setVisibility(8);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(8);
            } else if (encryption == 4) {
                SettingWifiActivity.this.pwdView.setVisibility(0);
                SettingWifiActivity.this.tvSafe.setText("WPA2_PSK(AES)");
                SettingWifiActivity.this.layoutwep_show1.setVisibility(8);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(8);
            } else if (encryption == 5) {
                SettingWifiActivity.this.pwdView.setVisibility(0);
                SettingWifiActivity.this.tvSafe.setText("WPA2_PSK(TKIP)");
                SettingWifiActivity.this.layoutwep_show1.setVisibility(8);
                SettingWifiActivity.this.layoutwep_show2.setVisibility(8);
            }
        }
    };
    private ImageView imgDropDown;
    private boolean isAdminEdit = false;
    boolean isOldEnable = false;
    boolean isPwd2Enable = false;
    boolean isPwdEnable = false;
    /* access modifiers changed from: private */
    public boolean isTimerOver = false;
    ImageView ivPwdAgainStatus;
    /* access modifiers changed from: private */
    public LinearLayout layoutwep_show1;
    /* access modifiers changed from: private */
    public LinearLayout layoutwep_show2;
    /* access modifiers changed from: private */
    public List<WifiModel> listWifiModels;
    private LinearLayout ll_ssid;
    /* access modifiers changed from: private */
    public WifiScanListAdapter mAdapter;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                boolean unused = SettingWifiActivity.this.successFlag = true;
                if (SettingWifiActivity.this.wifiModel.getSsid() == null || SettingWifiActivity.this.wifiModel.getSsid().length() < 1) {
                    SettingWifiActivity.this.tvName.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_no_safe));
                    SettingWifiActivity.this.tvPrompt.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_not_connected));
                }
                if (SettingWifiActivity.this.wifiModel.getSsid() != null && SettingWifiActivity.this.wifiModel.getSsid().length() > 1) {
                    SettingWifiActivity.this.tvName.setText(SettingWifiActivity.this.wifiModel.getSsid());
                    if (SettingWifiActivity.this.wifiModel.getConmode() == 1) {
                        SettingWifiActivity.this.tvPrompt.setText(SettingWifiActivity.this.getResources().getString(R.string.connected));
                    } else {
                        SettingWifiActivity.this.tvPrompt.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_not_connected));
                    }
                    int encryption = SettingWifiActivity.this.wifiModel.getEncryption();
                    if (encryption == 0) {
                        SettingWifiActivity.this.tvSafe.setText(SettingWifiActivity.this.getResources().getString(R.string.wifi_no_safe));
                    } else if (encryption == 1) {
                        SettingWifiActivity.this.tvSafe.setText("WEP");
                    } else if (encryption == 2) {
                        SettingWifiActivity.this.tvSafe.setText("WPA_PSK(AES)");
                    } else if (encryption == 3) {
                        SettingWifiActivity.this.tvSafe.setText("WPA_PSK(TKIP)");
                    } else if (encryption == 4) {
                        SettingWifiActivity.this.tvSafe.setText("WPA2_PSK(AES)");
                    } else if (encryption == 5) {
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
                if (SettingWifiActivity.this.progressDialog.isShowing()) {
                    SettingWifiActivity.this.progressDialog.cancel();
                    if (!SettingWifiActivity.this.isTimerOver && SettingWifiActivity.this.mTimerTimeOut != null) {
                        SettingWifiActivity.this.mTimerTimeOut.cancel();
                    }
                }
                if (SettingWifiActivity.this.listWifiModels.size() > 0) {
                    SettingWifiActivity.this.mListView.setVisibility(0);
                }
                SettingWifiActivity.this.mAdapter.updateList(SettingWifiActivity.this.listWifiModels);
                Log.d(SettingWifiActivity.this.LOG_TAG, "handler  scan wifi  3");
            } else if (i == 3) {
                boolean unused2 = SettingWifiActivity.this.successFlag = true;
                Log.d("tag", "over");
                SettingWifiActivity settingWifiActivity = SettingWifiActivity.this;
                Toast.makeText(settingWifiActivity, settingWifiActivity.getResources().getString(R.string.wifi_set_success), 1).show();
                SettingWifiActivity.this.sendBroadcast(new Intent("myback"));
                SettingWifiActivity.this.finish();
            } else if (i == 4) {
                if (SettingWifiActivity.this.scanDialog.isShowing()) {
                    SettingWifiActivity.this.scanDialog.cancel();
                }
                if (SettingWifiActivity.this.progressDialog.isShowing()) {
                    SettingWifiActivity.this.progressDialog.cancel();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public ListView mListView;
    /* access modifiers changed from: private */
    public Timer mTimerTimeOut;
    private PopupWindow popupWindow;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_group;
    private View popv_group;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog;
    /* access modifiers changed from: private */
    public View pwdView;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private int result;
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
    private String strDID;
    /* access modifiers changed from: private */
    public boolean successFlag = false;
    private int tag = 0;
    private TextView title;
    private TextView title_show;
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
    public WifiModel wifiBean;
    /* access modifiers changed from: private */
    public WifiModel wifiModel;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.settingwifi);
        this.progressDialog = new ProgressDialog(this, 3);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.wifi_getparams));
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        this.progressDialog.show();
        this.mHandler.postDelayed(this.runnable, WorkRequest.MIN_BACKOFF_MILLIS);
        this.wifiBean = new WifiModel();
        findView();
        setListener();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        this.listWifiModels = new ArrayList();
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getWifiParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.scanWifi(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        initExitPopupWindow_Group();
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.mAdapter = new WifiScanListAdapter(this);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        StopHeat();
        super.onPause();
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
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            this.popupWindow.dismiss();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_psd_status:
                if (this.isOldEnable) {
                    this.isOldEnable = false;
                    this.editText_GroupName_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    this.ivPwdAgainStatus.setImageResource(R.drawable.icon_psd_disable);
                    return;
                }
                this.isOldEnable = true;
                this.editText_GroupName_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                this.ivPwdAgainStatus.setImageResource(R.drawable.icon_psd_enable);
                return;
            case R.id.popup_create_group_cancel:
                this.editText_GroupName.setText("");
                this.editText_GroupName_pass.setText("");
                this.popupWindow_group.dismiss();
                return;
            case R.id.popup_create_group_create:
                String trim = this.editText_GroupName.getText().toString().trim();
                String trim2 = this.editText_GroupName_pass.getText().toString().trim();
                String str = trim.toString();
                try {
                    str = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String str2 = str;
                String str3 = trim2.toString();
                try {
                    str3 = URLEncoder.encode(str3, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                setWifi(trim, trim2, str2, str3, this.wifiBean.getEncryption());
                return;
            case R.id.wifi_btn_manger:
                this.mListView.setVisibility(8);
                this.mAdapter.clearWifi();
                this.mAdapter.notifyDataSetChanged();
                NativeCaller.TransferMessage(this.strDID, CommonUtil.scanWifi(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
                this.scanDialog = new ProgressDialog(this, 3);
                this.scanDialog.setProgressStyle(0);
                this.scanDialog.setCanceledOnTouchOutside(false);
                this.scanDialog.setMessage(getResources().getString(R.string.wifi_scanning));
                this.scanDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        return false;
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
                this.ll_ssid.setVisibility(0);
                this.title.setText(R.string.other_net_show);
                this.editText_GroupName.setText("");
                this.popupWindow_group.showAtLocation(this.btn_cancel, 17, 0, 0);
                return;
            default:
                return;
        }
    }

    private void setTimeOut() {
        AnonymousClass6 r0 = new TimerTask() {
            public void run() {
                Log.d(SettingWifiActivity.this.LOG_TAG, "isTimeOver");
                boolean unused = SettingWifiActivity.this.isTimerOver = true;
                SettingWifiActivity.this.mHandler.sendEmptyMessage(4);
            }
        };
        this.mTimerTimeOut = new Timer();
        this.mTimerTimeOut.schedule(r0, WorkRequest.MIN_BACKOFF_MILLIS);
    }

    private void setWifi(String str, String str2, String str3, String str4, int i) {
        NativeCaller.TransferMessage(this.strDID, CommonUtil.SHIX_SetWifi(SystemValue.doorBellAdmin, SystemValue.doorBellPass, str, str2, str3, str4, i), 0);
        Intent intent = new Intent(this, NUIMainActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    private void setttingTimeOut() {
        this.successFlag = false;
        this.mHandler.postAtTime(this.settingRunnable, WorkRequest.MIN_BACKOFF_MILLIS);
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
        WifiModel wifiScan = this.mAdapter.getWifiScan(i);
        this.wifiBean.setSsid(wifiScan.getSsid());
        this.wifiBean.setEncryption(wifiScan.getEncryption());
        this.wifiBean.setSignal(wifiScan.getSignal());
        this.ll_ssid.setVisibility(8);
        this.title.setText(wifiScan.getSsid());
        this.editText_GroupName.setText(wifiScan.getSsid());
        this.popupWindow_group.showAtLocation(this.btn_cancel, 17, 0, 0);
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

    public void initExitPopupWindow_Group() {
        this.popv_group = LayoutInflater.from(this).inflate(R.layout.popup_create_group, (ViewGroup) null);
        this.title = (TextView) this.popv_group.findViewById(R.id.title);
        this.title_show = (TextView) this.popv_group.findViewById(R.id.title_show);
        this.ll_ssid = (LinearLayout) this.popv_group.findViewById(R.id.ll_ssid);
        this.btn_create = (Button) this.popv_group.findViewById(R.id.popup_create_group_create);
        this.btn_cancel = (Button) this.popv_group.findViewById(R.id.popup_create_group_cancel);
        this.editText_GroupName = (EditText) this.popv_group.findViewById(R.id.popup_create_group_edittext);
        this.editText_GroupName_pass = (EditText) this.popv_group.findViewById(R.id.popup_create_group_edittext_pass);
        this.ivPwdAgainStatus = (ImageView) this.popv_group.findViewById(R.id.iv_psd_status);
        this.btn_create.setOnClickListener(this);
        this.btn_cancel.setOnClickListener(this);
        this.ivPwdAgainStatus.setOnClickListener(this);
        this.popupWindow_group = new PopupWindow(this.popv_group, -1, -1);
        this.popupWindow_group.setFocusable(true);
        this.popupWindow_group.setInputMethodMode(1);
        this.popupWindow_group.setSoftInputMode(16);
        this.popupWindow_group.setOutsideTouchable(true);
        this.popupWindow_group.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_group.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                SettingWifiActivity.this.popupWindow_group.dismiss();
            }
        });
        this.popupWindow_group.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingWifiActivity.this.popupWindow_group.dismiss();
                return false;
            }
        });
    }

    public void wifiSort() {
        Collections.sort(this.listWifiModels, new Comparator<WifiModel>() {
            public int compare(WifiModel wifiModel, WifiModel wifiModel2) {
                return wifiModel.getSignal() < wifiModel2.getSignal() ? 1 : -1;
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:51|52|53|54|55|56|57|58|59|(2:63|74)|64) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x01a4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x01ab */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x01b4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void CallBackSHIXJasonCommon(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "cmd"
            java.lang.String r1 = "]"
            java.lang.String r2 = r10.strDID
            boolean r11 = r2.equals(r11)
            if (r11 != 0) goto L_0x000d
            return
        L_0x000d:
            r11 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0018 }
            r2.<init>(r12)     // Catch:{ JSONException -> 0x0018 }
            int r2 = r2.getInt(r0)     // Catch:{ JSONException -> 0x0018 }
            goto L_0x001d
        L_0x0018:
            r2 = move-exception
            r2.printStackTrace()
            r2 = r11
        L_0x001d:
            r3 = 114(0x72, float:1.6E-43)
            if (r2 != r3) goto L_0x0029
            android.os.Handler r11 = r10.mHandler
            r12 = 3
            r11.sendEmptyMessage(r12)
            goto L_0x01f4
        L_0x0029:
            r3 = 112(0x70, float:1.57E-43)
            r4 = 1
            if (r2 != r3) goto L_0x0041
            com.shix.shixipc.bean.WifiModel r11 = com.shix.shixipc.bean.WifiModel.jsonToModel(r12)     // Catch:{ JSONException -> 0x003b }
            r10.wifiModel = r11     // Catch:{ JSONException -> 0x003b }
            android.os.Handler r11 = r10.mHandler     // Catch:{ JSONException -> 0x003b }
            r11.sendEmptyMessage(r4)     // Catch:{ JSONException -> 0x003b }
            goto L_0x01f4
        L_0x003b:
            r11 = move-exception
            r11.printStackTrace()
            goto L_0x01f4
        L_0x0041:
            r3 = 113(0x71, float:1.58E-43)
            if (r2 != r3) goto L_0x01f4
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01f0 }
            r2.<init>(r12)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r12 = "SHIX"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01f0 }
            r3.<init>()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r5 = "SHIXWIFI cmd:"
            r3.append(r5)     // Catch:{ JSONException -> 0x01f0 }
            int r0 = r2.getInt(r0)     // Catch:{ JSONException -> 0x01f0 }
            r3.append(r0)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r0 = r3.toString()     // Catch:{ JSONException -> 0x01f0 }
            android.util.Log.d(r12, r0)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r12 = "result"
            int r12 = r2.getInt(r12)     // Catch:{ JSONException -> 0x01f0 }
            if (r12 < 0) goto L_0x01f4
            java.lang.String r12 = "count"
            int r12 = r2.getInt(r12)     // Catch:{ JSONException -> 0x01f0 }
            android.os.Handler r0 = r10.mHandler     // Catch:{ JSONException -> 0x01f0 }
            r3 = 6
            r0.sendEmptyMessage(r3)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01f0 }
            r0.<init>()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r3 = "SHIXWIFI ap_number:"
            r0.append(r3)     // Catch:{ JSONException -> 0x01f0 }
            r0.append(r12)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x01f0 }
            com.shix.shixipc.utils.CommonUtil.Log(r4, r0)     // Catch:{ JSONException -> 0x01f0 }
            r0 = 0
            java.lang.String r3 = "data"
            org.json.JSONArray r3 = r2.getJSONArray(r3)     // Catch:{ Exception -> 0x0094 }
            goto L_0x0095
        L_0x0094:
            r3 = r0
        L_0x0095:
            java.util.List<com.shix.shixipc.bean.WifiModel> r5 = r10.listWifiModels     // Catch:{ JSONException -> 0x01f0 }
            r5.clear()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r5 = "SHIXWIFI listWifiModel.add  size:"
            r6 = 2
            if (r12 <= 0) goto L_0x0132
            if (r3 == 0) goto L_0x0132
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01f0 }
            r1.<init>()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r2 = "SHIXWIFI list:"
            r1.append(r2)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r2 = r3.toString()     // Catch:{ JSONException -> 0x01f0 }
            r1.append(r2)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x01f0 }
            com.shix.shixipc.utils.CommonUtil.Log(r4, r1)     // Catch:{ JSONException -> 0x01f0 }
        L_0x00b9:
            if (r11 >= r12) goto L_0x012c
            org.json.JSONObject r1 = r3.getJSONObject(r11)     // Catch:{ Exception -> 0x00c0 }
            goto L_0x00c1
        L_0x00c0:
            r1 = r0
        L_0x00c1:
            if (r1 != 0) goto L_0x00c4
            goto L_0x0129
        L_0x00c4:
            com.shix.shixipc.bean.WifiModel r2 = new com.shix.shixipc.bean.WifiModel     // Catch:{ JSONException -> 0x01f0 }
            r2.<init>()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r7 = "ssid"
            java.lang.Object r7 = r1.get(r7)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x01f0 }
            r2.setSsid(r7)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r7 = "signal"
            int r1 = r1.getInt(r7)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01f0 }
            r7.<init>()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r8 = "WIFISSID:"
            r7.append(r8)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r8 = r2.getSsid()     // Catch:{ JSONException -> 0x01f0 }
            r7.append(r8)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x01f0 }
            com.shix.shixipc.utils.CommonUtil.Log(r4, r7)     // Catch:{ JSONException -> 0x01f0 }
            r2.setSignal(r1)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r1 = r2.getSsid()     // Catch:{ JSONException -> 0x01f0 }
            if (r1 == 0) goto L_0x0129
            java.lang.String r1 = r2.getSsid()     // Catch:{ JSONException -> 0x01f0 }
            int r1 = r1.length()     // Catch:{ JSONException -> 0x01f0 }
            if (r1 <= 0) goto L_0x0129
            java.util.List<com.shix.shixipc.bean.WifiModel> r1 = r10.listWifiModels     // Catch:{ JSONException -> 0x01f0 }
            r1.add(r2)     // Catch:{ JSONException -> 0x01f0 }
            com.shix.shixipc.adapter.WifiScanListAdapter r1 = r10.mAdapter     // Catch:{ JSONException -> 0x01f0 }
            r1.addWifiScan(r2)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01f0 }
            r1.<init>()     // Catch:{ JSONException -> 0x01f0 }
            r1.append(r5)     // Catch:{ JSONException -> 0x01f0 }
            java.util.List<com.shix.shixipc.bean.WifiModel> r2 = r10.listWifiModels     // Catch:{ JSONException -> 0x01f0 }
            int r2 = r2.size()     // Catch:{ JSONException -> 0x01f0 }
            r1.append(r2)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x01f0 }
            com.shix.shixipc.utils.CommonUtil.Log(r4, r1)     // Catch:{ JSONException -> 0x01f0 }
        L_0x0129:
            int r11 = r11 + 1
            goto L_0x00b9
        L_0x012c:
            android.os.Handler r11 = r10.mHandler     // Catch:{ JSONException -> 0x01f0 }
            r11.sendEmptyMessage(r6)     // Catch:{ JSONException -> 0x01f0 }
            return
        L_0x0132:
            if (r11 >= r12) goto L_0x01ea
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01f0 }
            r0.<init>()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r3 = "ssid["
            r0.append(r3)     // Catch:{ JSONException -> 0x01f0 }
            r0.append(r11)     // Catch:{ JSONException -> 0x01f0 }
            r0.append(r1)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01f0 }
            r3.<init>()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r7 = "signal["
            r3.append(r7)     // Catch:{ JSONException -> 0x01f0 }
            r3.append(r11)     // Catch:{ JSONException -> 0x01f0 }
            r3.append(r1)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01f0 }
            r7.<init>()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r8 = "encryption["
            r7.append(r8)     // Catch:{ JSONException -> 0x01f0 }
            r7.append(r11)     // Catch:{ JSONException -> 0x01f0 }
            r7.append(r1)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01f0 }
            r8.<init>()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r9 = "key1:"
            r8.append(r9)     // Catch:{ JSONException -> 0x01f0 }
            r8.append(r0)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r9 = "  key2:"
            r8.append(r9)     // Catch:{ JSONException -> 0x01f0 }
            r8.append(r3)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r9 = "  key3:"
            r8.append(r9)     // Catch:{ JSONException -> 0x01f0 }
            r8.append(r7)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x01f0 }
            com.shix.shixipc.utils.CommonUtil.Log(r4, r8)     // Catch:{ JSONException -> 0x01f0 }
            com.shix.shixipc.bean.WifiModel r8 = new com.shix.shixipc.bean.WifiModel     // Catch:{ JSONException -> 0x01f0 }
            r8.<init>()     // Catch:{ JSONException -> 0x01f0 }
            java.lang.Object r0 = r2.get(r0)     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01a4 }
            r8.setSsid(r0)     // Catch:{ Exception -> 0x01a4 }
        L_0x01a4:
            int r0 = r2.getInt(r7)     // Catch:{ Exception -> 0x01ab }
            r8.setEncryption(r0)     // Catch:{ Exception -> 0x01ab }
        L_0x01ab:
            int r0 = r2.getInt(r3)     // Catch:{ Exception -> 0x01b4 }
            int r0 = r0 + 100
            r8.setSignal(r0)     // Catch:{ Exception -> 0x01b4 }
        L_0x01b4:
            java.lang.String r0 = r8.getSsid()     // Catch:{ JSONException -> 0x01f0 }
            if (r0 == 0) goto L_0x01e6
            java.lang.String r0 = r8.getSsid()     // Catch:{ JSONException -> 0x01f0 }
            int r0 = r0.length()     // Catch:{ JSONException -> 0x01f0 }
            if (r0 <= 0) goto L_0x01e6
            java.util.List<com.shix.shixipc.bean.WifiModel> r0 = r10.listWifiModels     // Catch:{ JSONException -> 0x01f0 }
            r0.add(r8)     // Catch:{ JSONException -> 0x01f0 }
            com.shix.shixipc.adapter.WifiScanListAdapter r0 = r10.mAdapter     // Catch:{ JSONException -> 0x01f0 }
            r0.addWifiScan(r8)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01f0 }
            r0.<init>()     // Catch:{ JSONException -> 0x01f0 }
            r0.append(r5)     // Catch:{ JSONException -> 0x01f0 }
            java.util.List<com.shix.shixipc.bean.WifiModel> r3 = r10.listWifiModels     // Catch:{ JSONException -> 0x01f0 }
            int r3 = r3.size()     // Catch:{ JSONException -> 0x01f0 }
            r0.append(r3)     // Catch:{ JSONException -> 0x01f0 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x01f0 }
            com.shix.shixipc.utils.CommonUtil.Log(r4, r0)     // Catch:{ JSONException -> 0x01f0 }
        L_0x01e6:
            int r11 = r11 + 1
            goto L_0x0132
        L_0x01ea:
            android.os.Handler r11 = r10.mHandler     // Catch:{ JSONException -> 0x01f0 }
            r11.sendEmptyMessage(r6)     // Catch:{ JSONException -> 0x01f0 }
            goto L_0x01f4
        L_0x01f0:
            r11 = move-exception
            r11.printStackTrace()
        L_0x01f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.SettingWifiActivity.CallBackSHIXJasonCommon(java.lang.String, java.lang.String):void");
    }
}
