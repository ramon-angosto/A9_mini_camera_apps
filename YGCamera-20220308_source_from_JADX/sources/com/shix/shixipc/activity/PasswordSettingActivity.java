package com.shix.shixipc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.EmojiFilter;
import com.shix.shixipc.utils.FullCharFilter;
import com.shix.shixipc.utils.FullCharUnionFilter;
import com.shix.shixipc.utils.NotCopyAndPaste;
import com.shix.shixipc.utils.SpcialCharFilter;
import com.xiaomi.mipush.sdk.Constants;
import object.p2pipcam.nativecaller.NativeCaller;
import shix.cykj.camera.R;

public class PasswordSettingActivity extends BaseActivity implements TextWatcher, NUIMainActivity.SHIXCOMMONInterface {
    private String cameraName;
    /* access modifiers changed from: private */
    public EditText edt_confirm_password;
    /* access modifiers changed from: private */
    public EditText edt_current_password;
    /* access modifiers changed from: private */
    public EditText edt_new_password;
    private boolean isSupportFullChar = false;
    private boolean isSupportLenExt = false;
    /* access modifiers changed from: private */
    public String newPassword;
    /* access modifiers changed from: private */
    public String strDID;

    public void CallBackSHIXJasonCommon(String str, String str2) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_password);
        getDataFromOther();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        initView();
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        findViewById(R.id.wifi_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PasswordSettingActivity.this.finish();
            }
        });
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    private void initView() {
        this.edt_current_password = (EditText) findViewById(R.id.edt_current_password);
        this.edt_current_password.setCustomSelectionActionModeCallback(new NotCopyAndPaste());
        this.edt_new_password = (EditText) findViewById(R.id.edt_new_password);
        this.edt_new_password.setCustomSelectionActionModeCallback(new NotCopyAndPaste());
        this.edt_confirm_password = (EditText) findViewById(R.id.edt_confirm_password);
        this.edt_confirm_password.setCustomSelectionActionModeCallback(new NotCopyAndPaste());
        this.edt_current_password.setFilters(new InputFilter[]{new InputFilter.LengthFilter(63), new FullCharUnionFilter(this), new EmojiFilter()});
        if (!this.isSupportFullChar || !this.isSupportLenExt) {
            this.edt_new_password.setFilters(new InputFilter[]{new InputFilter.LengthFilter(31), new SpcialCharFilter(this), new EmojiFilter()});
            this.edt_confirm_password.setFilters(new InputFilter[]{new InputFilter.LengthFilter(31), new SpcialCharFilter(this), new EmojiFilter()});
        } else {
            this.edt_new_password.setFilters(new InputFilter[]{new InputFilter.LengthFilter(63), new FullCharFilter(this), new EmojiFilter()});
            this.edt_confirm_password.setFilters(new InputFilter[]{new InputFilter.LengthFilter(63), new FullCharFilter(this), new EmojiFilter()});
        }
        this.edt_new_password.addTextChangedListener(this);
        this.edt_confirm_password.addTextChangedListener(this);
        ((CheckBox) findViewById(R.id.show_psw_cb)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    PasswordSettingActivity.this.edt_current_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    PasswordSettingActivity.this.edt_new_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    PasswordSettingActivity.this.edt_confirm_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    return;
                }
                PasswordSettingActivity.this.edt_current_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                PasswordSettingActivity.this.edt_new_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                PasswordSettingActivity.this.edt_confirm_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
        ((Button) findViewById(R.id.update_password_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PasswordSettingActivity.this.updatePassword();
            }
        });
    }

    private String getPwd() {
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            if (this.strDID.equalsIgnoreCase(SystemValue.arrayList.get(i).getDev_Did())) {
                return SystemValue.arrayList.get(i).getDev_Pwd();
            }
        }
        return "";
    }

    public void updatePassword() {
        String obj = this.edt_current_password.getText().toString();
        this.newPassword = this.edt_new_password.getText().toString();
        String obj2 = this.edt_confirm_password.getText().toString();
        if (!obj.equals(getPwd())) {
            Toast.makeText(this, getText(R.string.tips_old_password_is_wrong).toString(), 0).show();
        } else if (!this.newPassword.equals(obj2)) {
            Toast.makeText(this, getText(R.string.tips_new_passwords_do_not_match).toString(), 0).show();
        } else if (TextUtils.isEmpty(this.newPassword) && TextUtils.isEmpty(obj2)) {
            showToast(getString(R.string.tip_not_empty));
        } else if (this.newPassword.length() < 4) {
            showToast(getString(R.string.pwd_dialog_show2));
        } else if (this.newPassword.equalsIgnoreCase("123456") || this.newPassword.equalsIgnoreCase("654321")) {
            showToast(getString(R.string.pwd_dialog_show1));
        } else {
            if (this.isSupportLenExt) {
                if (this.newPassword.getBytes().length > 63 || obj2.getBytes().length > 63) {
                    showToast(getString(R.string.tips_input_tolong));
                    return;
                }
            } else if (this.newPassword.getBytes().length > 31 || obj2.getBytes().length > 31) {
                showToast(getString(R.string.tips_input_tolong));
                return;
            }
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    super.onPreExecute();
                    NativeCaller.TransferMessage(PasswordSettingActivity.this.strDID, CommonUtil.editUsersParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass, SystemValue.doorBellAdmin, SystemValue.doorBellAdmin, PasswordSettingActivity.this.newPassword), 0);
                }

                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    try {
                        Thread.sleep(500);
                        return null;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    super.onPostExecute(voidR);
                    NativeCaller.TransferMessage(PasswordSettingActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "reboot", 1), 0);
                    PasswordSettingActivity passwordSettingActivity = PasswordSettingActivity.this;
                    CameraParamsBean access$500 = passwordSettingActivity.getCameraBean(passwordSettingActivity.strDID);
                    if (access$500 != null) {
                        Intent intent = new Intent();
                        intent.setAction(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                        intent.putExtra(ContentCommon.CAMERA_OPTION, 2);
                        intent.putExtra(ContentCommon.STR_CAMERA_OLD_ID, PasswordSettingActivity.this.strDID);
                        intent.putExtra(ContentCommon.STR_CAMERA_NAME, access$500.getDev_name());
                        intent.putExtra(ContentCommon.STR_CAMERA_ID, PasswordSettingActivity.this.strDID.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").trim());
                        intent.putExtra(ContentCommon.STR_CAMERA_USER, "admin");
                        intent.putExtra(ContentCommon.STR_CAMERA_PWD, PasswordSettingActivity.this.newPassword);
                        PasswordSettingActivity.this.sendBroadcast(intent);
                        PasswordSettingActivity.this.finish();
                        PasswordSettingActivity.this.startActivity(new Intent(PasswordSettingActivity.this, NUIMainActivity.class));
                    }
                }
            }.execute(new Void[0]);
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    /* access modifiers changed from: private */
    public CameraParamsBean getCameraBean(String str) {
        int size = SystemValue.arrayList.size();
        for (int i = 0; i < size; i++) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
            if (cameraParamsBean.getDev_Did().equalsIgnoreCase(str)) {
                SystemValue.position = i;
                return cameraParamsBean;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        hideSoftKeyboard(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void afterTextChanged(Editable editable) {
        if (!this.isSupportFullChar || !this.isSupportLenExt) {
            if (editable.toString().length() > 31) {
                showToast(getString(R.string.tip_password_limit));
            }
        } else if (editable.toString().getBytes().length > 63) {
            showToast(getString(R.string.tip_password_limit));
        }
    }
}
