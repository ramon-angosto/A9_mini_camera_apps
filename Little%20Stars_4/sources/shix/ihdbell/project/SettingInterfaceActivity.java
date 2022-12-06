package shix.ihdbell.project;

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
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

public class SettingInterfaceActivity extends BaseActivity implements View.OnClickListener, BridgeService.DoorBellInterfaceParmInterface {
    private final int PARAMS = 3;
    private final int TIMEOUT = 3000;
    Button button_leve_1;
    Button button_leve_2;
    Button button_type_0;
    private String cameraName = null;
    private Button cancel = null;
    private RadioGroup group1;
    private RadioGroup group1_out;
    private ImageButton image_alarm_leve_dr;
    private ImageButton img_alarm_type_dr;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 3) {
                if (SettingInterfaceActivity.this.pin_bind == 0) {
                    SettingInterfaceActivity.this.tv_alarm_type.setText(R.string.doorbell_setting_interface_in_rele_dooralarm);
                }
                if (SettingInterfaceActivity.this.pout_bind == 0) {
                    SettingInterfaceActivity.this.tv_alarm_leve.setText(R.string.doorbell_setting_interface_out_rele_talk);
                } else if (SettingInterfaceActivity.this.pout_bind == 1) {
                    SettingInterfaceActivity.this.tv_alarm_leve.setText(R.string.doorbell_setting_interface_out_rele_alrm);
                }
                if (SettingInterfaceActivity.this.pin == 0) {
                    SettingInterfaceActivity.this.rb1.setChecked(true);
                    SettingInterfaceActivity.this.rb2.setChecked(false);
                } else {
                    SettingInterfaceActivity.this.rb2.setChecked(true);
                    SettingInterfaceActivity.this.rb1.setChecked(false);
                }
                if (SettingInterfaceActivity.this.pout == 0) {
                    SettingInterfaceActivity.this.rb1_out.setChecked(true);
                    SettingInterfaceActivity.this.rb2_out.setChecked(false);
                    return;
                }
                SettingInterfaceActivity.this.rb2_out.setChecked(true);
                SettingInterfaceActivity.this.rb1_out.setChecked(false);
            }
        }
    };
    private Button ok = null;
    int pin = 0;
    int pin_bind = 0;
    PopupWindow popupWindow_alarm_leve;
    PopupWindow popupWindow_alarm_type;
    View popv_alerm_leve;
    View popv_alerm_type;
    int pout = 0;
    int pout_bind = 0;
    /* access modifiers changed from: private */
    public RadioButton rb1;
    /* access modifiers changed from: private */
    public RadioButton rb1_out;
    /* access modifiers changed from: private */
    public RadioButton rb2;
    /* access modifiers changed from: private */
    public RadioButton rb2_out;
    private String strDID = null;
    /* access modifiers changed from: private */
    public TextView tv_alarm_leve;
    /* access modifiers changed from: private */
    public TextView tv_alarm_type;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getDataFromOther();
        setContentView(R.layout.settinginterface);
        BridgeService.setDoorBellInterfaceParmInterface(this);
        NativeCaller.TransferMessage(this.strDID, "get_pin_config.cgi?&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
        this.tv_alarm_type = (TextView) findViewById(R.id.tv_alarm_type);
        this.tv_alarm_leve = (TextView) findViewById(R.id.tv_alarm_leve);
        this.img_alarm_type_dr = (ImageButton) findViewById(R.id.img_alarm_type_dr);
        this.image_alarm_leve_dr = (ImageButton) findViewById(R.id.image_alarm_leve_dr);
        this.image_alarm_leve_dr.setOnClickListener(this);
        this.img_alarm_type_dr.setOnClickListener(this);
        this.ok = (Button) findViewById(R.id.alerm_ok);
        this.cancel = (Button) findViewById(R.id.alerm_cancel);
        this.ok.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        this.group1 = (RadioGroup) findViewById(R.id.group1);
        this.rb1 = (RadioButton) findViewById(R.id.rb1);
        this.rb2 = (RadioButton) findViewById(R.id.rb2);
        this.group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingInterfaceActivity.this.rb1.getId()) {
                    SettingInterfaceActivity.this.pin = 0;
                } else if (i == SettingInterfaceActivity.this.rb2.getId()) {
                    SettingInterfaceActivity.this.pin = 1;
                }
            }
        });
        this.group1_out = (RadioGroup) findViewById(R.id.group1_out);
        this.rb1_out = (RadioButton) findViewById(R.id.rb1_out);
        this.rb2_out = (RadioButton) findViewById(R.id.rb2_out);
        this.group1_out.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingInterfaceActivity.this.rb1_out.getId()) {
                    SettingInterfaceActivity.this.pout = 0;
                } else if (i == SettingInterfaceActivity.this.rb2_out.getId()) {
                    SettingInterfaceActivity.this.pout = 1;
                }
            }
        });
        initExitPopupWindow_type();
        initExitPopupWindow_leve();
        SetTab(this);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BridgeService.setDoorBellInterfaceParmInterface((BridgeService.DoorBellInterfaceParmInterface) null);
        super.onDestroy();
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        switch (view.getId()) {
            case R.id.alerm_cancel:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.alerm_ok:
                NativeCaller.TransferMessage(this.strDID, "set_pin_config.cgi?&pin=" + this.pin + "&pin_bind=" + this.pin_bind + "&pout=" + this.pout + "&pout_bind=" + this.pout_bind + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.button_leve_1:
                this.pout_bind = 0;
                this.tv_alarm_leve.setText(R.string.doorbell_setting_interface_out_rele_talk);
                this.popupWindow_alarm_leve.dismiss();
                return;
            case R.id.button_leve_2:
                this.pout_bind = 1;
                this.tv_alarm_leve.setText(R.string.doorbell_setting_interface_out_rele_alrm);
                this.popupWindow_alarm_leve.dismiss();
                return;
            case R.id.button_type_0:
                this.pin_bind = 0;
                this.tv_alarm_type.setText(R.string.doorbell_setting_interface_in_rele_dooralarm);
                this.popupWindow_alarm_type.dismiss();
                return;
            case R.id.image_alarm_leve_dr:
                this.popupWindow_alarm_leve.showAsDropDown(this.image_alarm_leve_dr);
                return;
            case R.id.img_alarm_type_dr:
                this.popupWindow_alarm_type.showAsDropDown(this.img_alarm_type_dr);
                return;
            default:
                return;
        }
    }

    public void initExitPopupWindow_type() {
        this.popv_alerm_type = LayoutInflater.from(this).inflate(R.layout.popup_interface_in, (ViewGroup) null);
        this.button_type_0 = (Button) this.popv_alerm_type.findViewById(R.id.button_type_0);
        this.button_type_0.setOnClickListener(this);
        this.popupWindow_alarm_type = new PopupWindow(this.popv_alerm_type, -2, -2);
        this.popupWindow_alarm_type.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_alarm_type.setFocusable(true);
        this.popupWindow_alarm_type.setOutsideTouchable(true);
        this.popupWindow_alarm_type.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_alarm_type.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                SettingInterfaceActivity.this.popupWindow_alarm_type.dismiss();
            }
        });
        this.popupWindow_alarm_type.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingInterfaceActivity.this.popupWindow_alarm_type.dismiss();
                return false;
            }
        });
    }

    public void initExitPopupWindow_leve() {
        this.popv_alerm_leve = LayoutInflater.from(this).inflate(R.layout.popup_interface_out, (ViewGroup) null);
        this.button_leve_1 = (Button) this.popv_alerm_leve.findViewById(R.id.button_leve_1);
        this.button_leve_2 = (Button) this.popv_alerm_leve.findViewById(R.id.button_leve_2);
        this.button_leve_1.setOnClickListener(this);
        this.button_leve_2.setOnClickListener(this);
        this.popupWindow_alarm_leve = new PopupWindow(this.popv_alerm_leve, -2, -2);
        this.popupWindow_alarm_leve.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_alarm_leve.setFocusable(true);
        this.popupWindow_alarm_leve.setOutsideTouchable(true);
        this.popupWindow_alarm_leve.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_alarm_leve.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                SettingInterfaceActivity.this.popupWindow_alarm_leve.dismiss();
            }
        });
        this.popupWindow_alarm_leve.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingInterfaceActivity.this.popupWindow_alarm_leve.dismiss();
                return false;
            }
        });
    }

    public void callBackDoorBellInterfaceParm(String str, int i, int i2, int i3, int i4) {
        this.pin = i;
        this.pin_bind = i2;
        this.pout = i3;
        this.pout_bind = i4;
        this.mHandler.sendEmptyMessage(3);
    }
}
