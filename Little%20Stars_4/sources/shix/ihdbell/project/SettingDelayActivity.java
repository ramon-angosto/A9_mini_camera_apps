package shix.ihdbell.project;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

public class SettingDelayActivity extends BaseActivity implements BridgeService.DoorBellLockParmInterface, View.OnClickListener {
    /* access modifiers changed from: private */
    public int ClickType = 0;
    /* access modifiers changed from: private */
    public Button back;
    private Button btn_cancel;
    private Button btn_create;
    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_delet;
    private Button button_reset;
    private Button done;
    /* access modifiers changed from: private */
    public EditText editText_GroupName_pass;
    /* access modifiers changed from: private */
    public EditText editText_GroupName_pass2;
    /* access modifiers changed from: private */
    public EditText editText_GroupName_pass3;
    /* access modifiers changed from: private */
    public EditText edit_time;
    private RadioGroup group1;
    private RadioGroup groupLock;
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 0) {
                EditText access$000 = SettingDelayActivity.this.edit_time;
                access$000.setText(message.arg2 + "");
                int unused = SettingDelayActivity.this.lock_type1 = message.arg1;
                if (message.arg1 == 0) {
                    SettingDelayActivity.this.rb1.setChecked(true);
                    SettingDelayActivity.this.rb2.setChecked(false);
                    Log.e("test", "1msg.arg1:" + message.arg1);
                    return;
                }
                SettingDelayActivity.this.rb2.setChecked(true);
                SettingDelayActivity.this.rb1.setChecked(false);
                Log.e("test", "2msg.arg1:" + message.arg1);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean isOKTYPE = false;
    private String lockPwd = "";
    /* access modifiers changed from: private */
    public int lock_type1 = 0;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_group;
    private View popv_group;
    private SharedPreferences preuser;
    /* access modifiers changed from: private */
    public RadioButton rb1;
    /* access modifiers changed from: private */
    public RadioButton rb1lock;
    /* access modifiers changed from: private */
    public RadioButton rb2;
    /* access modifiers changed from: private */
    public RadioButton rb2lock;
    private Button setting_pwd_set;
    /* access modifiers changed from: private */
    public String strDID;
    /* access modifiers changed from: private */
    public StringBuffer stringBuffer;
    private StringBuffer stringBuffer2;
    private StringBuffer stringBuffer3;
    private int tag = 1;

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
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
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.settingdelay);
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        this.lockPwd = this.preuser.getString(this.strDID + "lockpwd", "123456");
        CommonUtil.Log(1, "lockPwd:" + this.lockPwd + " strDID:" + this.strDID);
        this.back = (Button) findViewById(R.id.back);
        this.edit_time = (EditText) findViewById(R.id.edit_time);
        String str = "get_lock_config.cgi?&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass;
        Log.d("test", "shix-cgi1:" + str);
        this.isOKTYPE = false;
        this.setting_pwd_set = (Button) findViewById(R.id.setting_pwd_set);
        this.setting_pwd_set.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(SettingDelayActivity.this, 20);
                if (SettingDelayActivity.this.popupWindow_group != null) {
                    int unused = SettingDelayActivity.this.ClickType = 0;
                    SettingDelayActivity.this.editText_GroupName_pass.setHint(R.string.lock_pwd_setting_show1);
                    SettingDelayActivity.this.editText_GroupName_pass2.setVisibility(0);
                    SettingDelayActivity.this.editText_GroupName_pass3.setVisibility(0);
                    SettingDelayActivity.this.stringBuffer.replace(0, SettingDelayActivity.this.stringBuffer.length(), "");
                    SettingDelayActivity.this.editText_GroupName_pass.setText("");
                    SettingDelayActivity.this.popupWindow_group.showAtLocation(SettingDelayActivity.this.back, 17, 0, 0);
                }
            }
        });
        this.group1 = (RadioGroup) findViewById(R.id.group1);
        this.rb1 = (RadioButton) findViewById(R.id.rb1);
        this.rb2 = (RadioButton) findViewById(R.id.rb2);
        this.group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == SettingDelayActivity.this.rb1.getId()) {
                    int unused = SettingDelayActivity.this.lock_type1 = 0;
                } else if (i == SettingDelayActivity.this.rb2.getId()) {
                    int unused2 = SettingDelayActivity.this.lock_type1 = 1;
                }
            }
        });
        NativeCaller.TransferMessage(this.strDID, str, 1);
        BridgeService.setDoorBellLockParmInterface(this);
        this.back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(SettingDelayActivity.this, 20);
                SettingDelayActivity.this.finish();
                SettingDelayActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
        this.done = (Button) findViewById(R.id.ok);
        this.done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(SettingDelayActivity.this, 20);
                if (SettingDelayActivity.this.edit_time.getText().toString().trim().length() == 0) {
                    SettingDelayActivity.this.edit_time.setText("1");
                }
                int parseInt = Integer.parseInt(SettingDelayActivity.this.edit_time.getText().toString().trim());
                if (parseInt < 1 || parseInt > 30) {
                    SettingDelayActivity.this.showToast("1-30");
                    return;
                }
                int unused = SettingDelayActivity.this.lock_type1 = 0;
                NativeCaller.TransferMessage(SettingDelayActivity.this.strDID, "set_lock_config.cgi?&lock_type=" + SettingDelayActivity.this.lock_type1 + "&lock_delay=" + parseInt + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                SettingDelayActivity.this.finish();
                SettingDelayActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
        initExitPopupWindow_Group();
        this.groupLock = (RadioGroup) findViewById(R.id.groupLock);
        this.rb1lock = (RadioButton) findViewById(R.id.rb1Lock);
        this.rb2lock = (RadioButton) findViewById(R.id.rb2Lock);
        this.groupLock.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (SettingDelayActivity.this.isOKTYPE) {
                    int unused = SettingDelayActivity.this.ClickType = 1;
                    SettingDelayActivity.this.editText_GroupName_pass.setHint(R.string.open_lock_hint1);
                    SettingDelayActivity.this.editText_GroupName_pass2.setVisibility(8);
                    SettingDelayActivity.this.editText_GroupName_pass3.setVisibility(8);
                    if (i == SettingDelayActivity.this.rb1lock.getId()) {
                        int unused2 = SettingDelayActivity.this.ClickType = 1;
                    } else if (i == SettingDelayActivity.this.rb2lock.getId()) {
                        int unused3 = SettingDelayActivity.this.ClickType = 2;
                    }
                    SettingDelayActivity.this.stringBuffer.replace(0, SettingDelayActivity.this.stringBuffer.length(), "");
                    SettingDelayActivity.this.editText_GroupName_pass.setText("");
                    if (SettingDelayActivity.this.popupWindow_group != null && !SettingDelayActivity.this.popupWindow_group.isShowing()) {
                        SettingDelayActivity.this.popupWindow_group.showAtLocation(SettingDelayActivity.this.back, 17, 0, 0);
                    }
                }
            }
        });
        if (this.preuser.getInt(this.strDID + "ClickType", 1) == 1) {
            this.rb1lock.setChecked(true);
            this.rb2lock.setChecked(false);
        } else {
            this.rb1lock.setChecked(false);
            this.rb2lock.setChecked(true);
        }
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean unused = SettingDelayActivity.this.isOKTYPE = true;
                return null;
            }
        }.execute(new Void[0]);
        SetTab(this);
    }

    public void initExitPopupWindow_Group() {
        this.stringBuffer = new StringBuffer();
        this.stringBuffer2 = new StringBuffer();
        this.stringBuffer3 = new StringBuffer();
        this.popv_group = LayoutInflater.from(this).inflate(R.layout.popup_edit_pwd, (ViewGroup) null);
        this.btn_create = (Button) this.popv_group.findViewById(R.id.popup_create_group_create);
        this.btn_cancel = (Button) this.popv_group.findViewById(R.id.popup_create_group_cancel);
        this.editText_GroupName_pass = (EditText) this.popv_group.findViewById(R.id.popup_create_group_edittext_pass);
        this.editText_GroupName_pass2 = (EditText) this.popv_group.findViewById(R.id.popup_create_group_edittext_pass2);
        this.editText_GroupName_pass3 = (EditText) this.popv_group.findViewById(R.id.popup_create_group_edittext_pass3);
        this.editText_GroupName_pass.setOnClickListener(this);
        this.editText_GroupName_pass2.setOnClickListener(this);
        this.editText_GroupName_pass3.setOnClickListener(this);
        this.button_1 = (Button) this.popv_group.findViewById(R.id.button_1);
        this.button_1.setOnClickListener(this);
        this.button_2 = (Button) this.popv_group.findViewById(R.id.button_2);
        this.button_2.setOnClickListener(this);
        this.button_3 = (Button) this.popv_group.findViewById(R.id.button_3);
        this.button_3.setOnClickListener(this);
        this.button_4 = (Button) this.popv_group.findViewById(R.id.button_4);
        this.button_4.setOnClickListener(this);
        this.button_5 = (Button) this.popv_group.findViewById(R.id.button_5);
        this.button_5.setOnClickListener(this);
        this.button_6 = (Button) this.popv_group.findViewById(R.id.button_6);
        this.button_6.setOnClickListener(this);
        this.button_7 = (Button) this.popv_group.findViewById(R.id.button_7);
        this.button_7.setOnClickListener(this);
        this.button_8 = (Button) this.popv_group.findViewById(R.id.button_8);
        this.button_8.setOnClickListener(this);
        this.button_9 = (Button) this.popv_group.findViewById(R.id.button_9);
        this.button_9.setOnClickListener(this);
        this.button_0 = (Button) this.popv_group.findViewById(R.id.button_0);
        this.button_0.setOnClickListener(this);
        this.button_reset = (Button) this.popv_group.findViewById(R.id.button_reset);
        this.button_reset.setOnClickListener(this);
        this.button_delet = (Button) this.popv_group.findViewById(R.id.button_delet);
        this.button_delet.setOnClickListener(this);
        this.btn_create.setOnClickListener(this);
        this.btn_cancel.setOnClickListener(this);
        this.popupWindow_group = new PopupWindow(this.popv_group, -1, -1);
        this.popupWindow_group.setFocusable(true);
        this.popupWindow_group.setInputMethodMode(1);
        this.popupWindow_group.setSoftInputMode(16);
        this.popupWindow_group.setOutsideTouchable(true);
        this.popupWindow_group.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_group.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                SettingDelayActivity.this.popupWindow_group.dismiss();
            }
        });
        this.popupWindow_group.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingDelayActivity.this.popupWindow_group.dismiss();
                return false;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BridgeService.setDoorBellLockParmInterface((BridgeService.DoorBellLockParmInterface) null);
        super.onDestroy();
    }

    public void callBackDoorBellLockParm(String str, int i, int i2) {
        Log.e("door_CallBack_GetLockParm", "did:" + str + "  lock_type:" + i + "  lock_delay:" + i2);
        Message message = new Message();
        message.what = 0;
        message.arg1 = i;
        message.arg2 = i2;
        this.handler.sendMessage(message);
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        int id = view.getId();
        if (id == R.id.button_delet) {
            int i = this.tag;
            if (i == 1) {
                if (this.stringBuffer.length() - 1 >= 0) {
                    StringBuffer stringBuffer4 = this.stringBuffer;
                    stringBuffer4.delete(stringBuffer4.length() - 1, this.stringBuffer.length());
                    this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                }
            } else if (i == 2) {
                if (this.stringBuffer2.length() - 1 >= 0) {
                    StringBuffer stringBuffer5 = this.stringBuffer2;
                    stringBuffer5.delete(stringBuffer5.length() - 1, this.stringBuffer2.length());
                    this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
                }
            } else if (this.stringBuffer3.length() - 1 >= 0) {
                StringBuffer stringBuffer6 = this.stringBuffer3;
                stringBuffer6.delete(stringBuffer6.length() - 1, this.stringBuffer3.length());
                this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
            }
        } else if (id != R.id.button_reset) {
            switch (id) {
                case R.id.button_0:
                    int i2 = this.tag;
                    if (i2 == 1) {
                        if (this.stringBuffer.length() < 6) {
                            this.stringBuffer.append(PushConstants.PUSH_TYPE_NOTIFY);
                            this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                            return;
                        }
                        return;
                    } else if (i2 == 2) {
                        if (this.stringBuffer2.length() < 6) {
                            this.stringBuffer2.append(PushConstants.PUSH_TYPE_NOTIFY);
                            this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
                            return;
                        }
                        return;
                    } else if (this.stringBuffer3.length() < 6) {
                        this.stringBuffer3.append(PushConstants.PUSH_TYPE_NOTIFY);
                        this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
                        return;
                    } else {
                        return;
                    }
                case R.id.button_1:
                    CommonUtil.Log(1, "test---zhaoclick:" + this.tag);
                    int i3 = this.tag;
                    if (i3 == 1) {
                        if (this.stringBuffer.length() < 6) {
                            this.stringBuffer.append("1");
                            this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                            return;
                        }
                        return;
                    } else if (i3 == 2) {
                        if (this.stringBuffer2.length() < 6) {
                            this.stringBuffer2.append("1");
                            this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
                            return;
                        }
                        return;
                    } else if (this.stringBuffer3.length() < 6) {
                        this.stringBuffer3.append("1");
                        this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
                        return;
                    } else {
                        return;
                    }
                case R.id.button_2:
                    int i4 = this.tag;
                    if (i4 == 1) {
                        if (this.stringBuffer.length() < 6) {
                            this.stringBuffer.append("2");
                            this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                            return;
                        }
                        return;
                    } else if (i4 == 2) {
                        if (this.stringBuffer2.length() < 6) {
                            this.stringBuffer2.append("2");
                            this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
                            return;
                        }
                        return;
                    } else if (this.stringBuffer3.length() < 6) {
                        this.stringBuffer3.append("2");
                        this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
                        return;
                    } else {
                        return;
                    }
                case R.id.button_3:
                    int i5 = this.tag;
                    if (i5 == 1) {
                        if (this.stringBuffer.length() < 6) {
                            this.stringBuffer.append("3");
                            this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                            return;
                        }
                        return;
                    } else if (i5 == 2) {
                        if (this.stringBuffer2.length() < 6) {
                            this.stringBuffer2.append("3");
                            this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
                            return;
                        }
                        return;
                    } else if (this.stringBuffer3.length() < 6) {
                        this.stringBuffer3.append("3");
                        this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
                        return;
                    } else {
                        return;
                    }
                case R.id.button_4:
                    int i6 = this.tag;
                    if (i6 == 1) {
                        if (this.stringBuffer.length() < 6) {
                            this.stringBuffer.append("4");
                            this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                            return;
                        }
                        return;
                    } else if (i6 == 2) {
                        if (this.stringBuffer2.length() < 6) {
                            this.stringBuffer2.append("4");
                            this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
                            return;
                        }
                        return;
                    } else if (this.stringBuffer3.length() < 6) {
                        this.stringBuffer3.append("4");
                        this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
                        return;
                    } else {
                        return;
                    }
                case R.id.button_5:
                    int i7 = this.tag;
                    if (i7 == 1) {
                        if (this.stringBuffer.length() < 6) {
                            this.stringBuffer.append("5");
                            this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                            return;
                        }
                        return;
                    } else if (i7 == 2) {
                        if (this.stringBuffer2.length() < 6) {
                            this.stringBuffer2.append("5");
                            this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
                            return;
                        }
                        return;
                    } else if (this.stringBuffer3.length() < 6) {
                        this.stringBuffer3.append("5");
                        this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
                        return;
                    } else {
                        return;
                    }
                case R.id.button_6:
                    int i8 = this.tag;
                    if (i8 == 1) {
                        if (this.stringBuffer.length() < 6) {
                            this.stringBuffer.append("6");
                            this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                            return;
                        }
                        return;
                    } else if (i8 == 2) {
                        if (this.stringBuffer2.length() < 6) {
                            this.stringBuffer2.append("6");
                            this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
                            return;
                        }
                        return;
                    } else if (this.stringBuffer3.length() < 6) {
                        this.stringBuffer3.append("6");
                        this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
                        return;
                    } else {
                        return;
                    }
                case R.id.button_7:
                    int i9 = this.tag;
                    if (i9 == 1) {
                        if (this.stringBuffer.length() < 6) {
                            this.stringBuffer.append("7");
                            this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                            return;
                        }
                        return;
                    } else if (i9 == 2) {
                        if (this.stringBuffer2.length() < 6) {
                            this.stringBuffer2.append("7");
                            this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
                            return;
                        }
                        return;
                    } else if (this.stringBuffer3.length() < 6) {
                        this.stringBuffer3.append("7");
                        this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
                        return;
                    } else {
                        return;
                    }
                case R.id.button_8:
                    int i10 = this.tag;
                    if (i10 == 1) {
                        if (this.stringBuffer.length() < 6) {
                            this.stringBuffer.append("8");
                            this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                            return;
                        }
                        return;
                    } else if (i10 == 2) {
                        if (this.stringBuffer2.length() < 6) {
                            this.stringBuffer2.append("8");
                            this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
                            return;
                        }
                        return;
                    } else if (this.stringBuffer3.length() < 6) {
                        this.stringBuffer3.append("8");
                        this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
                        return;
                    } else {
                        return;
                    }
                case R.id.button_9:
                    int i11 = this.tag;
                    if (i11 == 1) {
                        if (this.stringBuffer.length() < 6) {
                            this.stringBuffer.append("9");
                            this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                            return;
                        }
                        return;
                    } else if (i11 == 2) {
                        if (this.stringBuffer2.length() < 6) {
                            this.stringBuffer2.append("9");
                            this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
                            return;
                        }
                        return;
                    } else if (this.stringBuffer3.length() < 6) {
                        this.stringBuffer3.append("9");
                        this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
                        return;
                    } else {
                        return;
                    }
                default:
                    switch (id) {
                        case R.id.popup_create_group_cancel:
                            this.popupWindow_group.dismiss();
                            return;
                        case R.id.popup_create_group_create:
                            if (this.ClickType == 0) {
                                String trim = this.editText_GroupName_pass.getText().toString().trim();
                                String trim2 = this.editText_GroupName_pass2.getText().toString().trim();
                                String trim3 = this.editText_GroupName_pass3.getText().toString().trim();
                                if (trim.length() < 6 || trim2.length() < 6 || trim3.length() < 6) {
                                    showToast((int) R.string.lock_pwd_setting_show4);
                                    return;
                                }
                                CommonUtil.Log(1, "pwd0:" + trim + "  lockPwd:" + this.lockPwd);
                                if (!trim.equals(this.lockPwd)) {
                                    showToast((int) R.string.lock_pwd_setting_show5);
                                    return;
                                } else if (!trim2.equals(trim3)) {
                                    showToast((int) R.string.lock_pwd_setting_show6);
                                    return;
                                } else {
                                    SharedPreferences.Editor edit = this.preuser.edit();
                                    edit.putString(this.strDID + "lockpwd", trim2);
                                    edit.commit();
                                }
                            } else if (this.editText_GroupName_pass.getText().toString().trim().length() < 6) {
                                showToast((int) R.string.lock_pwd_setting_show4);
                                return;
                            } else {
                                String trim4 = this.editText_GroupName_pass.getText().toString().trim();
                                if (trim4.length() < 6) {
                                    showToast((int) R.string.lock_pwd_setting_show4);
                                    return;
                                }
                                SharedPreferences sharedPreferences = this.preuser;
                                if (!sharedPreferences.getString(this.strDID + "lockpwd", "123456").equals(trim4)) {
                                    showToast((int) R.string.lock_pwd_setting_show7);
                                    return;
                                }
                                int i12 = this.ClickType;
                                if (i12 == 1) {
                                    this.setting_pwd_set.setVisibility(0);
                                } else if (i12 == 2) {
                                    this.setting_pwd_set.setVisibility(8);
                                }
                                this.tag = 1;
                                SharedPreferences.Editor edit2 = this.preuser.edit();
                                edit2.putInt(this.strDID + "ClickType", this.ClickType);
                                edit2.commit();
                            }
                            this.popupWindow_group.dismiss();
                            return;
                        default:
                            switch (id) {
                                case R.id.popup_create_group_edittext_pass:
                                    this.editText_GroupName_pass.setBackgroundResource(R.drawable.biz_edittext_border_press);
                                    this.editText_GroupName_pass2.setBackgroundResource(R.drawable.biz_edittext_border);
                                    this.editText_GroupName_pass3.setBackgroundResource(R.drawable.biz_edittext_border);
                                    this.tag = 1;
                                    return;
                                case R.id.popup_create_group_edittext_pass2:
                                    this.editText_GroupName_pass.setBackgroundResource(R.drawable.biz_edittext_border);
                                    this.editText_GroupName_pass2.setBackgroundResource(R.drawable.biz_edittext_border_press);
                                    this.editText_GroupName_pass3.setBackgroundResource(R.drawable.biz_edittext_border);
                                    this.tag = 2;
                                    return;
                                case R.id.popup_create_group_edittext_pass3:
                                    this.editText_GroupName_pass.setBackgroundResource(R.drawable.biz_edittext_border);
                                    this.editText_GroupName_pass2.setBackgroundResource(R.drawable.biz_edittext_border);
                                    this.editText_GroupName_pass3.setBackgroundResource(R.drawable.biz_edittext_border_press);
                                    this.tag = 3;
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        } else {
            int i13 = this.tag;
            if (i13 == 1) {
                StringBuffer stringBuffer7 = this.stringBuffer;
                stringBuffer7.replace(0, stringBuffer7.length(), "");
                this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
            } else if (i13 == 2) {
                StringBuffer stringBuffer8 = this.stringBuffer2;
                stringBuffer8.replace(0, stringBuffer8.length(), "");
                this.editText_GroupName_pass2.setText(this.stringBuffer2.toString().trim());
            } else {
                StringBuffer stringBuffer9 = this.stringBuffer3;
                stringBuffer9.replace(0, stringBuffer9.length(), "");
                this.editText_GroupName_pass3.setText(this.stringBuffer3.toString().trim());
            }
        }
    }
}
