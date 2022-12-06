package shix.ihdbell.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.jxl.app.littlestars.project.R;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

public class SettingSystemActivity extends BaseActivity implements View.OnClickListener, BridgeService.DoorBellSystemParmInterface {
    private final int PARAMS = 3;
    private final int TIMEOUT = 3000;
    /* access modifiers changed from: private */
    public int audioTalkType = 0;
    int bell_audio = 0;
    int bell_en = 0;
    int bell_mode = 0;
    int bell_on = 0;
    private String cameraName = null;
    private Button cancel = null;
    /* access modifiers changed from: private */
    public EditText edit_time1;
    /* access modifiers changed from: private */
    public EditText edit_time2;
    /* access modifiers changed from: private */
    public EditText edit_time3;
    private RadioGroup group1;
    private RadioGroup group2;
    private RadioGroup group3;
    private RadioGroup group4;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 3) {
                EditText access$000 = SettingSystemActivity.this.edit_time1;
                access$000.setText(SettingSystemActivity.this.max_watch + "");
                EditText access$100 = SettingSystemActivity.this.edit_time2;
                access$100.setText(SettingSystemActivity.this.max_talk + "");
                EditText access$200 = SettingSystemActivity.this.edit_time3;
                access$200.setText(SettingSystemActivity.this.max_wait + "");
                if (SettingSystemActivity.this.bell_on == 0) {
                    SettingSystemActivity.this.rb1.setChecked(true);
                    SettingSystemActivity.this.rb2.setChecked(false);
                } else {
                    SettingSystemActivity.this.rb2.setChecked(true);
                    SettingSystemActivity.this.rb1.setChecked(false);
                }
                if (SettingSystemActivity.this.bell_audio == 1) {
                    SettingSystemActivity.this.rb1_2.setChecked(true);
                    SettingSystemActivity.this.rb2_2.setChecked(false);
                } else {
                    SettingSystemActivity.this.rb2_2.setChecked(true);
                    SettingSystemActivity.this.rb1_2.setChecked(false);
                }
                if (SettingSystemActivity.this.bell_mode == 1) {
                    SettingSystemActivity.this.rb1_3.setChecked(true);
                    SettingSystemActivity.this.rb2_3.setChecked(false);
                    return;
                }
                SettingSystemActivity.this.rb2_3.setChecked(true);
                SettingSystemActivity.this.rb1_3.setChecked(false);
            }
        }
    };
    int max_talk = 0;
    int max_wait = 0;
    int max_watch = 0;
    private Button ok = null;
    private SharedPreferences preAudio;
    /* access modifiers changed from: private */
    public RadioButton rb1;
    /* access modifiers changed from: private */
    public RadioButton rb1_2;
    /* access modifiers changed from: private */
    public RadioButton rb1_3;
    /* access modifiers changed from: private */
    public RadioButton rb1_4;
    /* access modifiers changed from: private */
    public RadioButton rb2;
    /* access modifiers changed from: private */
    public RadioButton rb2_2;
    /* access modifiers changed from: private */
    public RadioButton rb2_3;
    /* access modifiers changed from: private */
    public RadioButton rb2_4;
    /* access modifiers changed from: private */
    public RadioButton rb3_4;
    private Button setting_reboot;
    /* access modifiers changed from: private */
    public String strDID = null;

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
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getDataFromOther();
        setContentView(R.layout.settingsystem);
        BridgeService.setDoorBellSystemParmInterface(this);
        this.preAudio = getSharedPreferences("shix_zhao_audio", 0);
        SharedPreferences sharedPreferences = this.preAudio;
        this.audioTalkType = sharedPreferences.getInt(this.strDID + "audiotalktype", 2);
        NativeCaller.TransferMessage(this.strDID, "get_bell_config.cgi?&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
        this.edit_time1 = (EditText) findViewById(R.id.edit_time1);
        this.edit_time2 = (EditText) findViewById(R.id.edit_time2);
        this.edit_time3 = (EditText) findViewById(R.id.edit_time3);
        if (SystemValue.isLitos) {
            findViewById(R.id.layout_alarm_view_all).setVisibility(8);
            findViewById(R.id.lView1).setVisibility(8);
        }
        this.ok = (Button) findViewById(R.id.alerm_ok);
        this.cancel = (Button) findViewById(R.id.alerm_cancel);
        this.ok.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        this.group1 = (RadioGroup) findViewById(R.id.group1);
        this.rb1 = (RadioButton) findViewById(R.id.rb1);
        this.rb2 = (RadioButton) findViewById(R.id.rb2);
        this.group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingSystemActivity.this.rb1.getId()) {
                    SettingSystemActivity.this.bell_on = 0;
                } else if (i == SettingSystemActivity.this.rb2.getId()) {
                    SettingSystemActivity.this.bell_on = 1;
                }
            }
        });
        this.group2 = (RadioGroup) findViewById(R.id.group2);
        this.rb1_2 = (RadioButton) findViewById(R.id.rb1_2);
        this.rb2_2 = (RadioButton) findViewById(R.id.rb2_2);
        this.setting_reboot = (Button) findViewById(R.id.setting_reboot);
        this.setting_reboot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingSystemActivity.this.showSureReboot();
            }
        });
        findViewById(R.id.setting_reset).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingSystemActivity.this.showSureReset();
            }
        });
        this.group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingSystemActivity.this.rb1_2.getId()) {
                    SettingSystemActivity.this.bell_audio = 1;
                } else if (i == SettingSystemActivity.this.rb2_2.getId()) {
                    SettingSystemActivity.this.bell_audio = 0;
                }
            }
        });
        this.group3 = (RadioGroup) findViewById(R.id.group3);
        this.rb1_3 = (RadioButton) findViewById(R.id.rb1_3);
        this.rb2_3 = (RadioButton) findViewById(R.id.rb2_3);
        this.group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingSystemActivity.this.rb1_3.getId()) {
                    SettingSystemActivity.this.bell_mode = 1;
                } else if (i == SettingSystemActivity.this.rb2_3.getId()) {
                    SettingSystemActivity.this.bell_mode = 0;
                }
            }
        });
        this.group4 = (RadioGroup) findViewById(R.id.group4);
        this.rb1_4 = (RadioButton) findViewById(R.id.rb1_4);
        this.rb2_4 = (RadioButton) findViewById(R.id.rb2_4);
        this.rb3_4 = (RadioButton) findViewById(R.id.rb3_4);
        this.group4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingSystemActivity.this.rb1_4.getId()) {
                    int unused = SettingSystemActivity.this.audioTalkType = 0;
                } else if (i == SettingSystemActivity.this.rb2_4.getId()) {
                    int unused2 = SettingSystemActivity.this.audioTalkType = 1;
                } else if (i == SettingSystemActivity.this.rb3_4.getId()) {
                    int unused3 = SettingSystemActivity.this.audioTalkType = 2;
                }
            }
        });
        int i = this.audioTalkType;
        if (i == 0) {
            this.rb1_4.setChecked(true);
            this.rb2_4.setChecked(false);
            this.rb3_4.setChecked(false);
        } else if (i == 1) {
            this.rb1_4.setChecked(false);
            this.rb2_4.setChecked(true);
            this.rb3_4.setChecked(false);
        } else {
            this.rb1_4.setChecked(false);
            this.rb3_4.setChecked(true);
            this.rb2_4.setChecked(false);
        }
        SetTab(this);
    }

    public void showSureReset() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.app);
        builder.setTitle(getResources().getString(R.string.doorbell_setting_reset));
        builder.setMessage(R.string.doorbell_setting_reset_show);
        builder.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                NativeCaller.TransferMessage(SettingSystemActivity.this.strDID, "restore_factory.cgi?&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                SettingSystemActivity.this.sendBroadcast(new Intent("myback"));
                SettingSystemActivity.this.finish();
            }
        });
        builder.setNegativeButton(R.string.str_cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showSureReboot() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.app);
        builder.setTitle(getResources().getString(R.string.doorbell_setting_reboot));
        builder.setMessage(R.string.doorbell_setting_reboot_show);
        builder.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                NativeCaller.PPPPRebootDevice(SettingSystemActivity.this.strDID);
                SettingSystemActivity.this.sendBroadcast(new Intent("myback"));
                SettingSystemActivity.this.finish();
            }
        });
        builder.setNegativeButton(R.string.str_cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BridgeService.setDoorBellSystemParmInterface((BridgeService.DoorBellSystemParmInterface) null);
        super.onDestroy();
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        int id = view.getId();
        if (id == R.id.alerm_cancel) {
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        } else if (id == R.id.alerm_ok) {
            if (SystemValue.isLitos) {
                SharedPreferences.Editor edit = this.preAudio.edit();
                edit.putInt(this.strDID + "audiotalktype", this.audioTalkType);
                edit.commit();
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            } else if (this.edit_time1.getText().toString().trim().length() == 0) {
                showToast((int) R.string.system_no_time_show);
            } else {
                this.max_watch = Integer.parseInt(this.edit_time1.getText().toString().trim());
                int i = this.max_watch;
                if (i < 10 || i > 300) {
                    showToast("10-300");
                } else if (this.edit_time2.getText().toString().trim().length() == 0) {
                    showToast((int) R.string.system_no_time_show);
                } else {
                    this.max_talk = Integer.parseInt(this.edit_time2.getText().toString().trim());
                    int i2 = this.max_talk;
                    if (i2 < 10 || i2 > 300) {
                        showToast("10-300");
                    } else if (this.edit_time3.getText().toString().trim().length() == 0) {
                        showToast((int) R.string.system_no_time_show);
                    } else {
                        this.max_wait = Integer.parseInt(this.edit_time3.getText().toString().trim());
                        int i3 = this.max_wait;
                        if (i3 < 10 || i3 > 120) {
                            showToast("10-120");
                            return;
                        }
                        NativeCaller.TransferMessage(this.strDID, "set_bell_config.cgi?&bell_on=" + this.bell_on + "&bell_en=" + this.bell_en + "&bell_audio=" + this.bell_audio + "&bell_mode=" + this.bell_mode + "&max_watch=" + this.max_watch + "&max_talk=" + this.max_talk + "&max_wait=" + this.max_wait + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                        SharedPreferences.Editor edit2 = this.preAudio.edit();
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.strDID);
                        sb.append("audiotalktype");
                        edit2.putInt(sb.toString(), this.audioTalkType);
                        edit2.commit();
                        finish();
                        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                    }
                }
            }
        }
    }

    public void callBackDoorBellSystemParm(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Log.e("test", "1did:" + str + "  bell_en:" + i + "  bell_on:" + i2 + "  bell_audio:" + i3 + "  bell_mode:" + i4 + "  max_watch:" + i5 + "  max_talk:" + i6 + "  max_wait:" + i7);
        this.bell_en = i;
        this.bell_on = i2;
        this.bell_audio = i3;
        this.bell_mode = i4;
        this.max_watch = i5;
        this.max_talk = i6;
        this.max_wait = i7;
        this.mHandler.sendEmptyMessage(3);
    }
}
