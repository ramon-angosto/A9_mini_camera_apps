package com.shix.shixipc.activity.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Selection;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.HttpUtils;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    String account;
    String code;
    private EditText etAccount;
    private EditText etCode;
    private EditText etPwd;
    /* access modifiers changed from: private */
    public boolean isPhone = true;
    private boolean isShowPwd = false;
    private ImageView ivEmailType;
    private ImageView ivPhoneType;
    private ImageView ivShowPwd;
    private View lineAreaCode;
    String password;
    /* access modifiers changed from: private */
    public SharedPreferences preSHIX;
    private String registerType = "PHONE";
    /* access modifiers changed from: private */
    public int time = 60;
    private TextView tvAreaCode;
    private TextView tvEmailType;
    /* access modifiers changed from: private */
    public TextView tvGetCode;
    private TextView tvPhoneType;
    /* access modifiers changed from: private */
    public Handler validateCodeHandler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                RegisterActivity.access$010(RegisterActivity.this);
                if (RegisterActivity.this.time <= 0) {
                    RegisterActivity.this.tvGetCode.setText(R.string.getagain);
                    RegisterActivity.this.tvGetCode.setEnabled(true);
                    return;
                }
                TextView access$100 = RegisterActivity.this.tvGetCode;
                access$100.setText(RegisterActivity.this.time + RegisterActivity.this.getString(R.string.second));
                RegisterActivity.this.validateCodeHandler.sendEmptyMessageDelayed(1, 1000);
            }
        }
    };

    static /* synthetic */ int access$010(RegisterActivity registerActivity) {
        int i = registerActivity.time;
        registerActivity.time = i - 1;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_register);
        this.preSHIX = getSharedPreferences(ContentCommon.SHIXLOGUSERPWD, 0);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        initViews();
        initEvents();
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.tvEmailType = (TextView) findViewById(R.id.tvEmailType);
        this.tvPhoneType = (TextView) findViewById(R.id.tvPhoneType);
        this.ivEmailType = (ImageView) findViewById(R.id.ivEmailType);
        this.ivPhoneType = (ImageView) findViewById(R.id.ivPhoneType);
        this.etAccount = (EditText) findViewById(R.id.etAccount);
        this.etPwd = (EditText) findViewById(R.id.etPwd);
        this.etCode = (EditText) findViewById(R.id.etCode);
        this.ivShowPwd = (ImageView) findViewById(R.id.ivShowPwd);
        this.tvGetCode = (TextView) findViewById(R.id.tvGetCode);
        this.tvAreaCode = (TextView) findViewById(R.id.tvAreaCode);
        this.lineAreaCode = findViewById(R.id.lineAreaCode);
    }

    /* access modifiers changed from: protected */
    public void initEvents() {
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.llPhone).setOnClickListener(this);
        findViewById(R.id.llEmail).setOnClickListener(this);
        findViewById(R.id.tvRegister).setOnClickListener(this);
        this.ivShowPwd.setOnClickListener(this);
        this.tvGetCode.setOnClickListener(this);
    }

    public void onClick(View view) {
        String str;
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        switch (view.getId()) {
            case R.id.back /*2131165270*/:
                finish();
                return;
            case R.id.ivShowPwd /*2131165555*/:
                if (this.isShowPwd) {
                    this.isShowPwd = false;
                    this.ivShowPwd.setImageResource(R.mipmap.btn_eye);
                    this.etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    this.isShowPwd = true;
                    this.ivShowPwd.setImageResource(R.mipmap.btn_eye_selected);
                    this.etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                Selection.setSelection(this.etPwd.getText(), this.etPwd.getText().toString().length());
                return;
            case R.id.llEmail /*2131165601*/:
                this.registerType = "EMAIL";
                this.isPhone = false;
                this.tvAreaCode.setVisibility(8);
                this.lineAreaCode.setVisibility(8);
                selectRegisterType(this.tvEmailType, this.tvPhoneType, this.ivEmailType, this.ivPhoneType);
                this.etAccount.setHint(getString(R.string.hint_input_email));
                this.etAccount.setText("");
                return;
            case R.id.llPhone /*2131165603*/:
                this.registerType = "PHONE";
                this.isPhone = true;
                this.tvAreaCode.setVisibility(0);
                this.lineAreaCode.setVisibility(0);
                selectRegisterType(this.tvPhoneType, this.tvEmailType, this.ivPhoneType, this.ivEmailType);
                this.etAccount.setHint(getString(R.string.hint_input_phone));
                this.etAccount.setText("");
                return;
            case R.id.tvGetCode /*2131165865*/:
                this.time = 60;
                this.account = this.etAccount.getText().toString();
                String str2 = this.account;
                if (str2 == null || str2.length() < 1) {
                    showToast(getString(R.string.hint_input_account));
                    return;
                }
                new Thread() {
                    public void run() {
                        int i = (-TimeZone.getDefault().getRawOffset()) / 1000;
                        int timeInMillis = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("codeType", 0);
                            jSONObject.put("loginName", RegisterActivity.this.account);
                            if (RegisterActivity.this.isPhone) {
                                jSONObject.put("loginType", 0);
                            } else {
                                jSONObject.put("loginType", 1);
                            }
                            jSONObject.put("timestamp", timeInMillis);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String doHttpPost = HttpUtils.doHttpPost(jSONObject.toString(), "http://xyx.365uj.com/homeeye/api/user/code");
                        CommonUtil.Log(1, "zhaogenghuaiPOST result:" + doHttpPost);
                        super.run();
                    }
                }.start();
                this.tvGetCode.setEnabled(false);
                this.validateCodeHandler.sendEmptyMessage(1);
                return;
            case R.id.tvRegister /*2131165873*/:
                this.account = this.etAccount.getText().toString();
                this.password = this.etPwd.getText().toString();
                this.code = this.etCode.getText().toString();
                String str3 = this.account;
                if (str3 == null || str3.length() < 1) {
                    showToast(getString(R.string.hint_input_account));
                    return;
                } else if (this.isPhone || ((str = this.account) != null && str.length() >= 1)) {
                    String str4 = this.password;
                    if (str4 == null || str4.length() < 1) {
                        showToast(getString(R.string.hint_pwd));
                        return;
                    } else if (this.password.length() < 6) {
                        showToast(getString(R.string.regist_pwd_len_show));
                        return;
                    } else {
                        String str5 = this.code;
                        if (str5 == null || str5.length() < 1) {
                            showToast(getString(R.string.hint_validate_code));
                            return;
                        } else {
                            new Thread() {
                                public void run() {
                                    int i = (-TimeZone.getDefault().getRawOffset()) / 1000;
                                    int timeInMillis = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("code", RegisterActivity.this.code);
                                        jSONObject.put("codeType", 0);
                                        jSONObject.put("password", RegisterActivity.this.password);
                                        jSONObject.put("loginName", RegisterActivity.this.account);
                                        if (RegisterActivity.this.isPhone) {
                                            jSONObject.put("loginType", 0);
                                        } else {
                                            jSONObject.put("loginType", 1);
                                        }
                                        jSONObject.put("remark", "android");
                                        jSONObject.put("timestamp", timeInMillis);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    String doHttpPost = HttpUtils.doHttpPost(jSONObject.toString(), "http://xyx.365uj.com/homeeye/api/user/registered");
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(doHttpPost);
                                        if (jSONObject2.getInt("code") == 200) {
                                            RegisterActivity.this.runOnUiThread(new Runnable() {
                                                public void run() {
                                                    SharedPreferences.Editor edit = RegisterActivity.this.preSHIX.edit();
                                                    edit.putString(ContentCommon.SHIX_LONGIN_USER, RegisterActivity.this.account);
                                                    edit.putString(ContentCommon.SHIX_LONGIN_PWD, RegisterActivity.this.password);
                                                    edit.commit();
                                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                                    intent.addFlags(268468224);
                                                    RegisterActivity.this.startActivity(intent);
                                                    RegisterActivity.this.finish();
                                                }
                                            });
                                        } else {
                                            final String string = jSONObject2.getString(CrashHianalyticsData.MESSAGE);
                                            RegisterActivity.this.runOnUiThread(new Runnable() {
                                                public void run() {
                                                    RegisterActivity registerActivity = RegisterActivity.this;
                                                    registerActivity.showToast("" + string);
                                                }
                                            });
                                        }
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                    CommonUtil.Log(1, "zhaogenghuaiPOST result:" + doHttpPost);
                                    super.run();
                                }
                            }.start();
                            return;
                        }
                    }
                } else {
                    showToast(getString(R.string.email_account_correct));
                    return;
                }
            default:
                return;
        }
    }

    private void selectRegisterType(TextView textView, TextView textView2, ImageView imageView, ImageView imageView2) {
        textView.setTextColor(getResources().getColor(R.color.z2));
        textView2.setTextColor(getResources().getColor(R.color.z3));
        imageView.setVisibility(0);
        imageView2.setVisibility(4);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.validateCodeHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }
}
