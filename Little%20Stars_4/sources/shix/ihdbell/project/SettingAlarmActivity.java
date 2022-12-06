package shix.ihdbell.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

public class SettingAlarmActivity extends BaseActivity implements View.OnClickListener, BridgeService.DoorBellAlarmParmInterface {
    private final int PARAMS = 3;
    private final int TIMEOUT = 3000;
    /* access modifiers changed from: private */
    public int alarm_delay;
    /* access modifiers changed from: private */
    public int alarm_level;
    /* access modifiers changed from: private */
    public int alarm_on;
    /* access modifiers changed from: private */
    public int alarm_start_hour;
    /* access modifiers changed from: private */
    public int alarm_start_minute;
    /* access modifiers changed from: private */
    public int alarm_stop_hour;
    /* access modifiers changed from: private */
    public int alarm_stop_minute;
    /* access modifiers changed from: private */
    public int alarm_type;
    Button button_leve_1;
    Button button_leve_2;
    Button button_leve_3;
    Button button_leve_4;
    Button button_leve_5;
    Button button_type_0;
    Button button_type_1;
    Button button_type_2;
    private String cameraName = null;
    private Button cancel = null;
    /* access modifiers changed from: private */
    public EditText edit_alarm_delay_time;
    private RadioGroup group1;
    private ImageButton image_alarm_leve_dr;
    private ImageButton img_alarm_type_dr;
    /* access modifiers changed from: private */
    public boolean isGet = false;
    /* access modifiers changed from: private */
    public boolean isGet1 = false;
    /* access modifiers changed from: private */
    public LinearLayout layout_alarm_delay;
    /* access modifiers changed from: private */
    public LinearLayout layout_alarm_view_all;
    private RelativeLayout layoutr_alerm_leve;
    private RelativeLayout layoutr_alerm_select;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 3) {
                if (SettingAlarmActivity.this.alarm_start_hour >= 0 && SettingAlarmActivity.this.alarm_start_hour <= 23) {
                    SettingAlarmActivity.this.timePicker.setCurrentHour(Integer.valueOf(SettingAlarmActivity.this.alarm_start_hour));
                }
                if (SettingAlarmActivity.this.alarm_start_minute >= 0 && SettingAlarmActivity.this.alarm_start_minute <= 59) {
                    SettingAlarmActivity.this.timePicker.setCurrentMinute(Integer.valueOf(SettingAlarmActivity.this.alarm_start_minute));
                }
                if (SettingAlarmActivity.this.alarm_stop_hour >= 0 && SettingAlarmActivity.this.alarm_stop_hour <= 23) {
                    SettingAlarmActivity.this.timePicker2.setCurrentHour(Integer.valueOf(SettingAlarmActivity.this.alarm_stop_hour));
                }
                if (SettingAlarmActivity.this.alarm_stop_minute >= 0 && SettingAlarmActivity.this.alarm_stop_minute <= 59) {
                    SettingAlarmActivity.this.timePicker2.setCurrentMinute(Integer.valueOf(SettingAlarmActivity.this.alarm_stop_minute));
                }
                EditText access$700 = SettingAlarmActivity.this.edit_alarm_delay_time;
                access$700.setText(SettingAlarmActivity.this.alarm_delay + "");
                TextView access$900 = SettingAlarmActivity.this.tv_alarm_leve;
                access$900.setText(SettingAlarmActivity.this.alarm_level + "");
                if (SettingAlarmActivity.this.alarm_type == 0) {
                    SettingAlarmActivity.this.tv_alarm_type.setText(R.string.doorbell_setting_alarm_type_0);
                } else if (SettingAlarmActivity.this.alarm_type == 1) {
                    SettingAlarmActivity.this.tv_alarm_type.setText(R.string.doorbell_setting_alarm_type_1);
                } else {
                    SettingAlarmActivity.this.tv_alarm_type.setText(R.string.doorbell_setting_alarm_type_2);
                }
                if (SettingAlarmActivity.this.alarm_on == 1) {
                    SettingAlarmActivity.this.rb1.setChecked(true);
                    SettingAlarmActivity.this.rb2.setChecked(false);
                    SettingAlarmActivity.this.layout_alarm_view_all.setVisibility(8);
                    SettingAlarmActivity.this.layout_alarm_delay.setVisibility(0);
                } else {
                    SettingAlarmActivity.this.rb2.setChecked(true);
                    SettingAlarmActivity.this.rb1.setChecked(false);
                    SettingAlarmActivity.this.layout_alarm_view_all.setVisibility(8);
                    SettingAlarmActivity.this.layout_alarm_delay.setVisibility(8);
                }
                boolean unused = SettingAlarmActivity.this.isGet = true;
                boolean unused2 = SettingAlarmActivity.this.isGet1 = true;
            }
        }
    };
    private Button ok = null;
    PopupWindow popupWindow_alarm_leve;
    PopupWindow popupWindow_alarm_type;
    View popv_alerm_leve;
    View popv_alerm_type;
    /* access modifiers changed from: private */
    public RadioButton rb1;
    /* access modifiers changed from: private */
    public RadioButton rb2;
    private Button setting_reset;
    /* access modifiers changed from: private */
    public String strDID = null;
    /* access modifiers changed from: private */
    public TimePicker timePicker;
    /* access modifiers changed from: private */
    public TimePicker timePicker2;
    /* access modifiers changed from: private */
    public TextView tv_alarm_leve;
    /* access modifiers changed from: private */
    public TextView tv_alarm_type;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getDataFromOther();
        setContentView(R.layout.settingalarm);
        BridgeService.setDoorBellAlarmParmInterface(this);
        NativeCaller.TransferMessage(this.strDID, "get_alarm_config.cgi?&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
        this.edit_alarm_delay_time = (EditText) findViewById(R.id.edit_alarm_delay_time);
        this.tv_alarm_type = (TextView) findViewById(R.id.tv_alarm_type);
        this.tv_alarm_leve = (TextView) findViewById(R.id.tv_alarm_leve);
        this.layout_alarm_view_all = (LinearLayout) findViewById(R.id.layout_alarm_view_all);
        this.layout_alarm_delay = (LinearLayout) findViewById(R.id.layout_alarm_delay);
        this.layoutr_alerm_select = (RelativeLayout) findViewById(R.id.layoutr_alerm_select);
        this.layoutr_alerm_leve = (RelativeLayout) findViewById(R.id.layoutr_alerm_leve);
        this.img_alarm_type_dr = (ImageButton) findViewById(R.id.img_alarm_type_dr);
        this.image_alarm_leve_dr = (ImageButton) findViewById(R.id.image_alarm_leve_dr);
        this.setting_reset = (Button) findViewById(R.id.setting_reset);
        this.image_alarm_leve_dr.setOnClickListener(this);
        this.img_alarm_type_dr.setOnClickListener(this);
        this.ok = (Button) findViewById(R.id.alerm_ok);
        this.cancel = (Button) findViewById(R.id.alerm_cancel);
        this.ok.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        this.setting_reset.setOnClickListener(this);
        this.group1 = (RadioGroup) findViewById(R.id.group1);
        this.rb1 = (RadioButton) findViewById(R.id.rb1);
        this.rb2 = (RadioButton) findViewById(R.id.rb2);
        this.isGet = false;
        this.isGet1 = false;
        this.group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingAlarmActivity.this.rb1.getId()) {
                    int unused = SettingAlarmActivity.this.alarm_on = 1;
                    SettingAlarmActivity.this.layout_alarm_delay.setVisibility(0);
                } else if (i == SettingAlarmActivity.this.rb2.getId()) {
                    int unused2 = SettingAlarmActivity.this.alarm_on = 0;
                    SettingAlarmActivity.this.layout_alarm_delay.setVisibility(8);
                }
            }
        });
        initExitPopupWindow_type();
        initExitPopupWindow_leve();
        this.timePicker = (TimePicker) findViewById(R.id.timePicker1);
        this.timePicker.setIs24HourView(true);
        this.timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            public void onTimeChanged(TimePicker timePicker, int i, int i2) {
                if (SettingAlarmActivity.this.isGet) {
                    int unused = SettingAlarmActivity.this.alarm_start_hour = i;
                    int unused2 = SettingAlarmActivity.this.alarm_start_minute = i2;
                    return;
                }
                boolean unused3 = SettingAlarmActivity.this.isGet = true;
            }
        });
        this.timePicker2 = (TimePicker) findViewById(R.id.timePicker2);
        this.timePicker2.setIs24HourView(true);
        this.timePicker2.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            public void onTimeChanged(TimePicker timePicker, int i, int i2) {
                if (SettingAlarmActivity.this.isGet1) {
                    int unused = SettingAlarmActivity.this.alarm_stop_hour = i;
                    int unused2 = SettingAlarmActivity.this.alarm_stop_minute = i2;
                    return;
                }
                boolean unused3 = SettingAlarmActivity.this.isGet1 = true;
            }
        });
        SetTab(this);
    }

    private String retrunTime(int i) {
        if (i < 10) {
            return PushConstants.PUSH_TYPE_NOTIFY + i;
        }
        return "" + i;
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

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
    public void onDestroy() {
        this.isGet = false;
        this.isGet1 = false;
        BridgeService.setDoorBellAlarmParmInterface((BridgeService.DoorBellAlarmParmInterface) null);
        super.onDestroy();
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        int id = view.getId();
        switch (id) {
            case R.id.alerm_cancel:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.alerm_ok:
                if (this.edit_alarm_delay_time.getText().toString().trim().length() == 0) {
                    showToast((int) R.string.door_setting_alarm_show1);
                    return;
                }
                this.alarm_delay = Integer.parseInt(this.edit_alarm_delay_time.getText().toString().trim());
                int i = this.alarm_delay;
                if (i < 1 || i > 20) {
                    showToast("1-20");
                    return;
                }
                NativeCaller.TransferMessage(this.strDID, "set_alarm_config.cgi?&alarm_on=" + this.alarm_on + "&alarm_delay=" + this.alarm_delay + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.image_alarm_leve_dr:
                this.popupWindow_alarm_leve.showAsDropDown(this.image_alarm_leve_dr);
                return;
            case R.id.img_alarm_type_dr:
                this.popupWindow_alarm_type.showAsDropDown(this.img_alarm_type_dr);
                return;
            case R.id.setting_reset:
                showSureReset();
                return;
            default:
                switch (id) {
                    case R.id.button_leve_1:
                        this.alarm_level = 1;
                        this.tv_alarm_leve.setText("1");
                        this.popupWindow_alarm_leve.dismiss();
                        return;
                    case R.id.button_leve_2:
                        this.alarm_level = 2;
                        this.tv_alarm_leve.setText("2");
                        this.popupWindow_alarm_leve.dismiss();
                        return;
                    case R.id.button_leve_3:
                        this.alarm_level = 3;
                        this.tv_alarm_leve.setText("3");
                        this.popupWindow_alarm_leve.dismiss();
                        return;
                    case R.id.button_leve_4:
                        this.alarm_level = 4;
                        this.tv_alarm_leve.setText("4");
                        this.popupWindow_alarm_leve.dismiss();
                        return;
                    case R.id.button_leve_5:
                        this.alarm_level = 5;
                        this.tv_alarm_leve.setText("5");
                        this.popupWindow_alarm_leve.dismiss();
                        return;
                    default:
                        switch (id) {
                            case R.id.button_type_0:
                                this.alarm_type = 0;
                                this.tv_alarm_type.setText(R.string.doorbell_setting_alarm_type_0);
                                this.popupWindow_alarm_type.dismiss();
                                return;
                            case R.id.button_type_1:
                                this.alarm_type = 1;
                                this.tv_alarm_type.setText(R.string.doorbell_setting_alarm_type_1);
                                this.popupWindow_alarm_type.dismiss();
                                return;
                            case R.id.button_type_2:
                                this.alarm_type = 2;
                                this.tv_alarm_type.setText(R.string.doorbell_setting_alarm_type_2);
                                this.popupWindow_alarm_type.dismiss();
                                return;
                            default:
                                return;
                        }
                }
        }
    }

    public void showSureReset() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.app);
        builder.setTitle(getResources().getString(R.string.doorbell_setting_reset));
        builder.setMessage(R.string.doorbell_setting_reset_show);
        builder.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                NativeCaller.TransferMessage(SettingAlarmActivity.this.strDID, "reset_alarm_config.cgi?&&alarm_delay=" + SettingAlarmActivity.this.alarm_delay + "loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                SettingAlarmActivity.this.finish();
            }
        });
        builder.setNegativeButton(R.string.str_cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void initExitPopupWindow_type() {
        this.popv_alerm_type = LayoutInflater.from(this).inflate(R.layout.popup_alarm_type, (ViewGroup) null);
        this.button_type_0 = (Button) this.popv_alerm_type.findViewById(R.id.button_type_0);
        this.button_type_1 = (Button) this.popv_alerm_type.findViewById(R.id.button_type_1);
        this.button_type_2 = (Button) this.popv_alerm_type.findViewById(R.id.button_type_2);
        this.button_type_0.setOnClickListener(this);
        this.button_type_1.setOnClickListener(this);
        this.button_type_2.setOnClickListener(this);
        this.popupWindow_alarm_type = new PopupWindow(this.popv_alerm_type, -2, -2);
        this.popupWindow_alarm_type.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_alarm_type.setFocusable(true);
        this.popupWindow_alarm_type.setOutsideTouchable(true);
        this.popupWindow_alarm_type.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_alarm_type.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                SettingAlarmActivity.this.popupWindow_alarm_type.dismiss();
            }
        });
        this.popupWindow_alarm_type.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingAlarmActivity.this.popupWindow_alarm_type.dismiss();
                return false;
            }
        });
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

    public void callBackDoorBellAlarmParm(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.alarm_on = i;
        this.alarm_type = i2;
        this.alarm_level = i3;
        this.alarm_delay = i4;
        this.alarm_start_hour = i5;
        this.alarm_start_minute = i7;
        this.alarm_stop_hour = i6;
        this.alarm_stop_minute = i8;
        this.mHandler.sendEmptyMessage(3);
    }
}
