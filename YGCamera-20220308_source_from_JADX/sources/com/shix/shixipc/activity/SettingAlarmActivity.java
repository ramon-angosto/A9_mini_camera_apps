package com.shix.shixipc.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.AlarmModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.view.SwitchView;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import shix.cykj.camera.R;

public class SettingAlarmActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.SHIXCOMMONInterface {
    private final int PARAMS = 3;
    private final int TIMEOUT = PathInterpolatorCompat.MAX_NUM_POINTS;
    /* access modifiers changed from: private */
    public AlarmModel alarmModel;
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
    RelativeLayout layoutr_alerm_leve;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 3) {
                if (SettingAlarmActivity.this.alarmModel.getPirenable() == 1) {
                    SettingAlarmActivity.this.sw1.setOpened(true);
                } else {
                    SettingAlarmActivity.this.sw1.setOpened(false);
                }
                if (SettingAlarmActivity.this.alarmModel.getPirvideo() == 1) {
                    SettingAlarmActivity.this.sw3.setOpened(true);
                } else {
                    SettingAlarmActivity.this.sw3.setOpened(false);
                }
                if (SettingAlarmActivity.this.alarmModel.getPirPush() == 1) {
                    SettingAlarmActivity.this.sw2.setOpened(true);
                } else {
                    SettingAlarmActivity.this.sw2.setOpened(false);
                }
                EditText access$100 = SettingAlarmActivity.this.edit_time_delay;
                access$100.setText(SettingAlarmActivity.this.alarmModel.getPirdelaytime() + "");
                EditText access$200 = SettingAlarmActivity.this.edit_alarm_delay_time;
                access$200.setText(SettingAlarmActivity.this.alarmModel.getPirvideotime() + "");
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

    /* renamed from: ok */
    private Button f1556ok = null;
    PopupWindow popupWindow_alarm_leve;
    View popv_alerm_leve;
    private RadioButton rb1;
    /* access modifiers changed from: private */
    public RadioButton rb1_2;
    /* access modifiers changed from: private */
    public RadioButton rb1_3;
    private RadioButton rb2;
    /* access modifiers changed from: private */
    public RadioButton rb2_2;
    /* access modifiers changed from: private */
    public RadioButton rb2_3;
    private String strDID = null;
    SwitchView sw1;
    SwitchView sw2;
    SwitchView sw3;
    /* access modifiers changed from: private */
    public TextView tv_alarm_leve;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getDataFromOther();
        setContentView(R.layout.settingalarm);
        this.alarmModel = new AlarmModel();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getAlarmParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        this.sw1 = (SwitchView) findViewById(R.id.sw1);
        this.sw1.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            public void toggleToOn(SwitchView switchView) {
                SettingAlarmActivity.this.sw1.setOpened(true);
                SettingAlarmActivity.this.alarmModel.setPirenable(1);
            }

            public void toggleToOff(SwitchView switchView) {
                SettingAlarmActivity.this.sw1.setOpened(false);
                SettingAlarmActivity.this.alarmModel.setPirenable(0);
            }
        });
        this.sw2 = (SwitchView) findViewById(R.id.sw2);
        this.sw2.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            public void toggleToOn(SwitchView switchView) {
                SettingAlarmActivity.this.sw2.setOpened(true);
                SettingAlarmActivity.this.alarmModel.setPirPush(1);
            }

            public void toggleToOff(SwitchView switchView) {
                SettingAlarmActivity.this.sw2.setOpened(false);
                SettingAlarmActivity.this.alarmModel.setPirPush(0);
            }
        });
        this.sw3 = (SwitchView) findViewById(R.id.sw3);
        this.sw3.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            public void toggleToOn(SwitchView switchView) {
                SettingAlarmActivity.this.sw3.setOpened(true);
                SettingAlarmActivity.this.alarmModel.setPirvideo(1);
            }

            public void toggleToOff(SwitchView switchView) {
                SettingAlarmActivity.this.sw3.setOpened(false);
                SettingAlarmActivity.this.alarmModel.setPirvideo(0);
            }
        });
        this.edit_alarm_delay_time = (EditText) findViewById(R.id.edit_alarm_delay_time);
        this.edit_time_delay = (EditText) findViewById(R.id.edit_time_delay);
        this.f1556ok = (Button) findViewById(R.id.alerm_ok);
        this.cancel = (Button) findViewById(R.id.alerm_cancel);
        this.f1556ok.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        this.group1 = (RadioGroup) findViewById(R.id.group1);
        this.rb1 = (RadioButton) findViewById(R.id.rb1);
        this.rb2 = (RadioButton) findViewById(R.id.rb2);
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
        initExitPopupWindow_leve();
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
    }

    private String retrunTime(int i) {
        if (i < 10) {
            return "0" + i;
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
        StopHeat();
        super.onPause();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.layoutr_alerm_leve) {
            switch (id) {
                case R.id.alerm_cancel /*2131165257*/:
                    finish();
                    overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                    return;
                case R.id.alerm_ok /*2131165258*/:
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
                        case R.id.button_leve_1 /*2131165324*/:
                            this.tv_alarm_leve.setText(getResources().getString(R.string.alarm_setting_5_h));
                            this.alarmModel.setPirsensitive(3);
                            this.popupWindow_alarm_leve.dismiss();
                            return;
                        case R.id.button_leve_2 /*2131165325*/:
                            this.tv_alarm_leve.setText(getResources().getString(R.string.alarm_setting_5_M));
                            this.alarmModel.setPirsensitive(2);
                            this.popupWindow_alarm_leve.dismiss();
                            return;
                        case R.id.button_leve_3 /*2131165326*/:
                            this.tv_alarm_leve.setText(getResources().getString(R.string.alarm_setting_5_L));
                            this.alarmModel.setPirsensitive(1);
                            this.popupWindow_alarm_leve.dismiss();
                            return;
                        case R.id.button_leve_4 /*2131165327*/:
                            this.popupWindow_alarm_leve.dismiss();
                            return;
                        case R.id.button_leve_5 /*2131165328*/:
                            this.popupWindow_alarm_leve.dismiss();
                            return;
                        default:
                            return;
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
