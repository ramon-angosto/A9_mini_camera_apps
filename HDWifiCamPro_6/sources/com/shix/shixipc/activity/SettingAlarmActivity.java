package com.shix.shixipc.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.AlarmModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonAppUtil;
import com.shix.shixipc.utils.CommonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;

public class SettingAlarmActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.SHIXCOMMONInterface {
    private final int PARAMS = 3;
    private final int TIMEOUT = PathInterpolatorCompat.MAX_NUM_POINTS;
    /* access modifiers changed from: private */
    public AlarmModel alarmModel;
    Button button_cloud1;
    Button button_cloud2;
    Button button_cloud3;
    Button button_cloud4;
    Button button_cloud5;
    Button button_leve_1;
    Button button_leve_2;
    Button button_leve_3;
    Button button_leve_4;
    Button button_leve_5;
    private String cameraName = null;
    private Button cancel = null;
    /* access modifiers changed from: private */
    public EditText edit_alarm_delay_time;
    /* access modifiers changed from: private */
    public EditText edit_time_delay;
    private RadioGroup group1;
    private RadioGroup group2;
    private RadioGroup group3;
    private LinearLayout layout_cloud;
    RelativeLayout layoutr_alerm_leve;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 3) {
                if (SettingAlarmActivity.this.alarmModel.getPirenable() == 1) {
                    SettingAlarmActivity.this.rb1.setChecked(true);
                    SettingAlarmActivity.this.rb2.setChecked(false);
                } else {
                    SettingAlarmActivity.this.rb2.setChecked(true);
                    SettingAlarmActivity.this.rb1.setChecked(false);
                }
                if (SettingAlarmActivity.this.alarmModel.getPirvideo() == 1) {
                    SettingAlarmActivity.this.rb1_2.setChecked(true);
                    SettingAlarmActivity.this.rb2_2.setChecked(false);
                } else {
                    SettingAlarmActivity.this.rb2_2.setChecked(true);
                    SettingAlarmActivity.this.rb1_2.setChecked(false);
                }
                if (SettingAlarmActivity.this.alarmModel.getPirPush() == 1) {
                    SettingAlarmActivity.this.rb1_3.setChecked(true);
                    SettingAlarmActivity.this.rb2_3.setChecked(false);
                } else {
                    SettingAlarmActivity.this.rb2_3.setChecked(true);
                    SettingAlarmActivity.this.rb1_3.setChecked(false);
                }
                EditText access$700 = SettingAlarmActivity.this.edit_time_delay;
                access$700.setText(SettingAlarmActivity.this.alarmModel.getPirdelaytime() + "");
                EditText access$800 = SettingAlarmActivity.this.edit_alarm_delay_time;
                access$800.setText(SettingAlarmActivity.this.alarmModel.getPirvideotime() + "");
                if (SettingAlarmActivity.this.alarmModel.getPirsensitive() == 3) {
                    SettingAlarmActivity.this.tv_alarm_leve.setText(SettingAlarmActivity.this.getResources().getString(R.string.alarm_setting_5_h));
                } else if (SettingAlarmActivity.this.alarmModel.getPirsensitive() == 2) {
                    SettingAlarmActivity.this.tv_alarm_leve.setText(SettingAlarmActivity.this.getResources().getString(R.string.alarm_setting_5_M));
                } else {
                    SettingAlarmActivity.this.tv_alarm_leve.setText(SettingAlarmActivity.this.getResources().getString(R.string.alarm_setting_5_L));
                }
            }
        }
    };
    private WifiManager mWifiManager;
    private String nowssid = "";
    private Button ok = null;
    PopupWindow popupWindow_alarm_leve;
    PopupWindow popupWindow_cloud;
    View popv_alerm_leve;
    View popv_cloud;
    /* access modifiers changed from: private */
    public RadioButton rb1;
    /* access modifiers changed from: private */
    public RadioButton rb1_2;
    /* access modifiers changed from: private */
    public RadioButton rb1_3;
    /* access modifiers changed from: private */
    public RadioButton rb2;
    /* access modifiers changed from: private */
    public RadioButton rb2_2;
    /* access modifiers changed from: private */
    public RadioButton rb2_3;
    private String strDID = null;
    /* access modifiers changed from: private */
    public TextView tv_alarm_leve;
    private TextView tv_cloud_leve;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getDataFromOther();
        setContentView(R.layout.settingalarm);
        this.alarmModel = new AlarmModel();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getAlarmParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        this.edit_alarm_delay_time = (EditText) findViewById(R.id.edit_alarm_delay_time);
        this.edit_time_delay = (EditText) findViewById(R.id.edit_time_delay);
        this.ok = (Button) findViewById(R.id.alerm_ok);
        this.cancel = (Button) findViewById(R.id.alerm_cancel);
        this.ok.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        this.group1 = (RadioGroup) findViewById(R.id.group1);
        this.rb1 = (RadioButton) findViewById(R.id.rb1);
        this.rb2 = (RadioButton) findViewById(R.id.rb2);
        this.group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingAlarmActivity.this.rb1.getId()) {
                    SettingAlarmActivity.this.alarmModel.setPirenable(1);
                } else if (i == SettingAlarmActivity.this.rb2.getId()) {
                    SettingAlarmActivity.this.alarmModel.setPirenable(0);
                }
            }
        });
        this.tv_alarm_leve = (TextView) findViewById(R.id.tv_alarm_leve);
        this.layoutr_alerm_leve = (RelativeLayout) findViewById(R.id.layoutr_alerm_leve);
        this.layoutr_alerm_leve.setOnClickListener(this);
        this.group2 = (RadioGroup) findViewById(R.id.group2);
        this.rb1_2 = (RadioButton) findViewById(R.id.rb1_2);
        this.rb2_2 = (RadioButton) findViewById(R.id.rb2_2);
        this.group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingAlarmActivity.this.rb1_2.getId()) {
                    SettingAlarmActivity.this.alarmModel.setPirvideo(1);
                } else if (i == SettingAlarmActivity.this.rb2_2.getId()) {
                    SettingAlarmActivity.this.alarmModel.setPirvideo(0);
                }
            }
        });
        this.group3 = (RadioGroup) findViewById(R.id.group3);
        this.rb1_3 = (RadioButton) findViewById(R.id.rb1_3);
        this.rb2_3 = (RadioButton) findViewById(R.id.rb2_3);
        this.group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingAlarmActivity.this.rb1_3.getId()) {
                    SettingAlarmActivity.this.alarmModel.setPirPush(1);
                } else if (i == SettingAlarmActivity.this.rb2_3.getId()) {
                    SettingAlarmActivity.this.alarmModel.setPirPush(0);
                }
            }
        });
        this.tv_cloud_leve = (TextView) findViewById(R.id.tv_cloud_leve);
        this.layout_cloud = (LinearLayout) findViewById(R.id.layout_cloud);
        this.layout_cloud.setOnClickListener(this);
        TextView textView = this.tv_cloud_leve;
        textView.setText("" + CommonAppUtil.getShowDeuIp());
        initExitPopupWindow_leve();
        initExitPopupWindow_Cloud();
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
    }

    private String retrunTime(int i) {
        if (i < 10) {
            return MBridgeConstans.ENDCARD_URL_TYPE_PL + i;
        }
        return "" + i;
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        NUIMainActivity.setSHIXCOMMONInterface((NUIMainActivity.SHIXCOMMONInterface) null);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_cloud) {
            this.popupWindow_cloud.dismiss();
            ArrayList<String> allIps = CommonAppUtil.getAllIps();
            if (allIps != null && allIps.size() != 0) {
                for (int i = 0; i < allIps.size(); i++) {
                    if (i == 0) {
                        this.button_cloud1.setText("" + allIps.get(i));
                    }
                    if (i == 1) {
                        this.button_cloud2.setText("" + allIps.get(i));
                    }
                    if (i == 2) {
                        this.button_cloud3.setText("" + allIps.get(i));
                    }
                    if (i == 3) {
                        this.button_cloud4.setText("" + allIps.get(i));
                    }
                    if (i == 4) {
                        this.button_cloud5.setText("" + allIps.get(i));
                    }
                }
                this.popupWindow_cloud.showAsDropDown(this.layout_cloud, 0, 0, 5);
            }
        } else if (id != R.id.layoutr_alerm_leve) {
            switch (id) {
                case R.id.alerm_cancel:
                    finish();
                    overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                    return;
                case R.id.alerm_ok:
                    if (this.edit_alarm_delay_time.getText().toString().trim().length() == 0) {
                        showToast((int) R.string.door_setting_alarm_show1);
                        this.alarmModel.setPirvideotime(10);
                    } else {
                        int parseInt = Integer.parseInt(this.edit_alarm_delay_time.getText().toString().trim());
                        if (parseInt < 10 || parseInt > 60) {
                            parseInt = 10;
                        }
                        this.alarmModel.setPirvideotime(parseInt);
                    }
                    if (this.edit_time_delay.getText().toString().trim().length() == 0) {
                        this.alarmModel.setPirdelaytime(30);
                    } else {
                        int parseInt2 = Integer.parseInt(this.edit_time_delay.getText().toString().trim());
                        if (parseInt2 < 30 || parseInt2 > 240) {
                            parseInt2 = 30;
                        }
                        this.alarmModel.setPirdelaytime(parseInt2);
                    }
                    if (this.alarmModel.getPirenable() == 0) {
                        this.alarmModel.setPirvideo(0);
                    }
                    try {
                        NativeCaller.TransferMessage(this.strDID, AlarmModel.toJson(this.alarmModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    finish();
                    overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                    return;
                default:
                    switch (id) {
                        case R.id.button_cloud1:
                            this.popupWindow_cloud.dismiss();
                            CommonAppUtil.DoSHIXAPP(1);
                            this.tv_cloud_leve.setText("" + CommonAppUtil.getShowDeuIp());
                            String str = this.strDID;
                            NativeCaller.TransferMessage(str, CommonUtil.SHIX_RegistCyPushCloudVideo(str, SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
                            return;
                        case R.id.button_cloud2:
                            this.popupWindow_cloud.dismiss();
                            CommonAppUtil.DoSHIXAPP(2);
                            this.tv_cloud_leve.setText("" + CommonAppUtil.getShowDeuIp());
                            String str2 = this.strDID;
                            NativeCaller.TransferMessage(str2, CommonUtil.SHIX_RegistCyPushCloudVideo(str2, SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
                            return;
                        case R.id.button_cloud3:
                            this.popupWindow_cloud.dismiss();
                            CommonAppUtil.DoSHIXAPP(3);
                            this.tv_cloud_leve.setText("" + CommonAppUtil.getShowDeuIp());
                            String str3 = this.strDID;
                            NativeCaller.TransferMessage(str3, CommonUtil.SHIX_RegistCyPushCloudVideo(str3, SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
                            return;
                        case R.id.button_cloud4:
                            this.popupWindow_cloud.dismiss();
                            CommonAppUtil.DoSHIXAPP(4);
                            this.tv_cloud_leve.setText("" + CommonAppUtil.getShowDeuIp());
                            String str4 = this.strDID;
                            NativeCaller.TransferMessage(str4, CommonUtil.SHIX_RegistCyPushCloudVideo(str4, SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
                            return;
                        case R.id.button_cloud5:
                            this.popupWindow_cloud.dismiss();
                            CommonAppUtil.DoSHIXAPP(5);
                            this.tv_cloud_leve.setText("" + CommonAppUtil.getShowDeuIp());
                            String str5 = this.strDID;
                            NativeCaller.TransferMessage(str5, CommonUtil.SHIX_RegistCyPushCloudVideo(str5, SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
                            return;
                        default:
                            switch (id) {
                                case R.id.button_leve_1:
                                    this.tv_alarm_leve.setText(getResources().getString(R.string.alarm_setting_5_h));
                                    this.alarmModel.setPirsensitive(3);
                                    this.popupWindow_alarm_leve.dismiss();
                                    return;
                                case R.id.button_leve_2:
                                    this.tv_alarm_leve.setText(getResources().getString(R.string.alarm_setting_5_M));
                                    this.alarmModel.setPirsensitive(2);
                                    this.popupWindow_alarm_leve.dismiss();
                                    return;
                                case R.id.button_leve_3:
                                    this.tv_alarm_leve.setText(getResources().getString(R.string.alarm_setting_5_L));
                                    this.alarmModel.setPirsensitive(1);
                                    this.popupWindow_alarm_leve.dismiss();
                                    return;
                                case R.id.button_leve_4:
                                    this.popupWindow_alarm_leve.dismiss();
                                    return;
                                case R.id.button_leve_5:
                                    this.popupWindow_alarm_leve.dismiss();
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        } else {
            this.popupWindow_alarm_leve.showAsDropDown(this.layoutr_alerm_leve, 0, 0, 5);
        }
    }

    public void initExitPopupWindow_leve() {
        this.popv_alerm_leve = LayoutInflater.from(this).inflate(R.layout.popup_alarm_leve, (ViewGroup) null);
        this.button_leve_1 = (Button) this.popv_alerm_leve.findViewById(R.id.button_leve_1);
        this.button_leve_2 = (Button) this.popv_alerm_leve.findViewById(R.id.button_leve_2);
        this.button_leve_3 = (Button) this.popv_alerm_leve.findViewById(R.id.button_leve_3);
        this.button_leve_4 = (Button) this.popv_alerm_leve.findViewById(R.id.button_leve_4);
        this.button_leve_5 = (Button) this.popv_alerm_leve.findViewById(R.id.button_leve_5);
        this.button_leve_1.setOnClickListener(this);
        this.button_leve_2.setOnClickListener(this);
        this.button_leve_3.setOnClickListener(this);
        this.button_leve_4.setOnClickListener(this);
        this.button_leve_5.setOnClickListener(this);
        this.popupWindow_alarm_leve = new PopupWindow(this.popv_alerm_leve, -2, -2);
        this.popupWindow_alarm_leve.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_alarm_leve.setFocusable(true);
        this.popupWindow_alarm_leve.setOutsideTouchable(true);
        this.popupWindow_alarm_leve.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_alarm_leve.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                SettingAlarmActivity.this.popupWindow_alarm_leve.dismiss();
            }
        });
        this.popupWindow_alarm_leve.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingAlarmActivity.this.popupWindow_alarm_leve.dismiss();
                return false;
            }
        });
    }

    private void isAp() {
        this.nowssid = getWifiSSID();
        CommonUtil.Log(1, "nowssid:" + this.nowssid);
        if (this.nowssid.indexOf(ContentCommon.SHIX_APPRE) < 0 && this.nowssid.indexOf(ContentCommon.SHIX_APPRE1) < 0 && this.nowssid.indexOf(ContentCommon.SHIX_APPRE2) < 0 && this.nowssid.indexOf(ContentCommon.SHIX_APPRE3) < 0) {
            this.nowssid.indexOf(ContentCommon.SHIX_APPRE4);
        }
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

    public void initExitPopupWindow_Cloud() {
        this.popv_cloud = LayoutInflater.from(this).inflate(R.layout.popup_cloud_leve, (ViewGroup) null);
        this.button_cloud1 = (Button) this.popv_cloud.findViewById(R.id.button_cloud1);
        this.button_cloud2 = (Button) this.popv_cloud.findViewById(R.id.button_cloud2);
        this.button_cloud3 = (Button) this.popv_cloud.findViewById(R.id.button_cloud3);
        this.button_cloud4 = (Button) this.popv_cloud.findViewById(R.id.button_cloud4);
        this.button_cloud5 = (Button) this.popv_cloud.findViewById(R.id.button_cloud5);
        this.button_cloud1.setOnClickListener(this);
        this.button_cloud2.setOnClickListener(this);
        this.button_cloud3.setOnClickListener(this);
        this.button_cloud4.setOnClickListener(this);
        this.button_cloud5.setOnClickListener(this);
        this.popupWindow_cloud = new PopupWindow(this.popv_cloud, -2, -2);
        this.popupWindow_cloud.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_cloud.setFocusable(true);
        this.popupWindow_cloud.setOutsideTouchable(true);
        this.popupWindow_cloud.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_cloud.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                SettingAlarmActivity.this.popupWindow_cloud.dismiss();
            }
        });
        this.popupWindow_cloud.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingAlarmActivity.this.popupWindow_cloud.dismiss();
                return false;
            }
        });
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (str2.indexOf("107") > 0) {
            try {
                this.alarmModel = AlarmModel.jsonToModel(str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mHandler.sendEmptyMessage(3);
        }
    }
}
