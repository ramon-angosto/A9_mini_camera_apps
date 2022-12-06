package com.shix.shixipc.activity.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Selection;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.MenuHelepActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.HttpUtils;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    String account;
    private EditText etAccount;
    private EditText etPwd;
    private boolean isShowPwd = false;
    private ImageView ivShowPwd;
    String password;
    /* access modifiers changed from: private */
    public SharedPreferences preSHIX;
    private TextView tvLoginAP;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.preSHIX = getSharedPreferences(ContentCommon.SHIXLOGUSERPWD, 0);
        initViews();
        initEvents();
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.etAccount = (EditText) findViewById(R.id.etAccount);
        this.etPwd = (EditText) findViewById(R.id.etPwd);
        this.ivShowPwd = (ImageView) findViewById(R.id.ivShowPwd);
    }

    /* access modifiers changed from: protected */
    public void initEvents() {
        findViewById(R.id.tvRegister).setOnClickListener(this);
        findViewById(R.id.tvLogin).setOnClickListener(this);
        findViewById(R.id.tvForgetPwd).setOnClickListener(this);
        findViewById(R.id.tvHelp).setOnClickListener(this);
        findViewById(R.id.imwx).setOnClickListener(this);
        this.ivShowPwd.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        CommonUtil.Log(1, "zhaowx user_openId requestCode:" + i + "  resultCode:" + i2);
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        switch (view.getId()) {
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
            case R.id.tvForgetPwd /*2131165864*/:
                startActivity(new Intent(this, ForgetPwdActivity.class));
                return;
            case R.id.tvHelp /*2131165867*/:
                startActivity(new Intent(this, MenuHelepActivity.class));
                return;
            case R.id.tvLogin /*2131165869*/:
                this.account = this.etAccount.getText().toString();
                this.password = this.etPwd.getText().toString();
                String str = this.account;
                if (str == null || str.length() < 1) {
                    showToast(getString(R.string.hint_input_account));
                    return;
                }
                this.account.contains("@");
                String str2 = this.password;
                if (str2 == null || str2.length() < 1) {
                    showToast(getString(R.string.hint_pwd));
                    return;
                } else {
                    new Thread() {
                        public void run() {
                            int i = (-TimeZone.getDefault().getRawOffset()) / 1000;
                            long timeInMillis = Calendar.getInstance().getTimeInMillis() / 1000;
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("password", LoginActivity.this.password);
                                jSONObject.put("loginName", LoginActivity.this.account);
                                jSONObject.put("remark", "android");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String doHttpPost = HttpUtils.doHttpPost(jSONObject.toString(), "http://xyx.365uj.com/homeeye/api/user/login");
                            try {
                                JSONObject jSONObject2 = new JSONObject(doHttpPost);
                                if (jSONObject2.getInt("code") == 200) {
                                    LoginActivity.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            SharedPreferences.Editor edit = LoginActivity.this.preSHIX.edit();
                                            edit.putString(ContentCommon.SHIX_LONGIN_USER, LoginActivity.this.account);
                                            edit.putString(ContentCommon.SHIX_LONGIN_PWD, LoginActivity.this.password);
                                            edit.commit();
                                            LoginActivity.this.startActivity(new Intent(LoginActivity.this, NUIMainActivity.class));
                                            LoginActivity.this.finish();
                                        }
                                    });
                                } else {
                                    final String string = jSONObject2.getString(CrashHianalyticsData.MESSAGE);
                                    LoginActivity.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            LoginActivity loginActivity = LoginActivity.this;
                                            loginActivity.showToast("" + string);
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
            case R.id.tvRegister /*2131165873*/:
                startActivity(new Intent(this, RegisterActivity.class));
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        String string = this.preSHIX.getString(ContentCommon.SHIX_LONGIN_USER, "");
        String string2 = this.preSHIX.getString(ContentCommon.SHIX_LONGIN_PWD, "");
        if (string != null && string.length() > 5) {
            this.etAccount.setText(string);
        }
        if (string2 != null && string2.length() > 5) {
            this.etPwd.setText(string2);
        }
        CommonUtil.Log(1, "zhaogenghuai SystemValue.wx_code:" + SystemValue.wx_code);
        if (SystemValue.wx_code == null || SystemValue.wx_code.length() <= 0) {
            new Thread() {
                public void run() {
                    super.run();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (SystemValue.wx_code != null && SystemValue.wx_code.length() > 0) {
                        LoginActivity.this.logtowx();
                    }
                }
            }.start();
        } else {
            logtowx();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        String string = this.preSHIX.getString(ContentCommon.SHIX_LONGIN_USER, "");
        String string2 = this.preSHIX.getString(ContentCommon.SHIX_LONGIN_PWD, "");
        if (string != null && string.length() > 5) {
            this.etAccount.setText(string);
        }
        if (string2 != null && string2.length() > 5) {
            this.etPwd.setText(string2);
        }
    }

    /* access modifiers changed from: private */
    public void logtowx() {
        CommonUtil.Log(1, "zhaogenghuailogtowx");
        new Thread() {
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", SystemValue.wx_code);
                    jSONObject.put("loginType", 2);
                    jSONObject.put("remark", "android");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String doHttpPost = HttpUtils.doHttpPost(jSONObject.toString(), "http://xyx.365uj.com/homeeye/api/user/login");
                try {
                    JSONObject jSONObject2 = new JSONObject(doHttpPost);
                    if (jSONObject2.getInt("code") == 200) {
                        LoginActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                LoginActivity.this.startActivity(new Intent(LoginActivity.this, NUIMainActivity.class));
                                LoginActivity.this.finish();
                            }
                        });
                    } else {
                        final String string = jSONObject2.getString(CrashHianalyticsData.MESSAGE);
                        LoginActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                LoginActivity loginActivity = LoginActivity.this;
                                loginActivity.showToast("" + string);
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
    }
}
