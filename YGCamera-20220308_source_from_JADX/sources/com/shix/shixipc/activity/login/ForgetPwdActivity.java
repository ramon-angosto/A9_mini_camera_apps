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
import com.shix.shixipc.utils.StringUtil;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class ForgetPwdActivity extends BaseActivity implements View.OnClickListener {
    public static int USER_FIND_PWD_VERIFY = 2;
    String account;
    String code;
    private EditText etAccount;
    private EditText etCode;
    private EditText etPwd;
    /* access modifiers changed from: private */
    public boolean isPhone = false;
    private boolean isShowPwd = false;
    private ImageView ivShowPwd;
    String password;
    /* access modifiers changed from: private */
    public SharedPreferences preSHIX;
    /* access modifiers changed from: private */
    public int time = 60;
    /* access modifiers changed from: private */
    public TextView tvGetCode;
    /* access modifiers changed from: private */
    public Handler validateCodeHandler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                ForgetPwdActivity.access$010(ForgetPwdActivity.this);
                if (ForgetPwdActivity.this.time <= 0) {
                    ForgetPwdActivity.this.tvGetCode.setText(ForgetPwdActivity.this.getString(R.string.get_validate_code));
                    ForgetPwdActivity.this.tvGetCode.setEnabled(true);
                    return;
                }
                TextView access$100 = ForgetPwdActivity.this.tvGetCode;
                access$100.setText(ForgetPwdActivity.this.time + ForgetPwdActivity.this.getString(R.string.second));
                ForgetPwdActivity.this.validateCodeHandler.sendEmptyMessageDelayed(1, 1000);
            }
        }
    };

    static /* synthetic */ int access$010(ForgetPwdActivity forgetPwdActivity) {
        int i = forgetPwdActivity.time;
        forgetPwdActivity.time = i - 1;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        EditText editText;
        super.onCreate(bundle);
        setContentView(R.layout.activity_forget_pwd);
        this.preSHIX = getSharedPreferences(ContentCommon.SHIXLOGUSERPWD, 0);
        initViews();
        initEvents();
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        String string = this.preSHIX.getString(ContentCommon.SHIX_LONGIN_USER, "");
        if (string != null && string.length() > 5 && (editText = this.etAccount) != null) {
            editText.setText(string);
        }
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.etAccount = (EditText) findViewById(R.id.etAccount);
        this.etPwd = (EditText) findViewById(R.id.etPwd);
        this.etCode = (EditText) findViewById(R.id.etCode);
        this.ivShowPwd = (ImageView) findViewById(R.id.ivShowPwd);
        this.tvGetCode = (TextView) findViewById(R.id.tvGetCode);
    }

    /* access modifiers changed from: protected */
    public void initEvents() {
        findViewById(R.id.back).setOnClickListener(this);
        this.ivShowPwd.setOnClickListener(this);
        this.tvGetCode.setOnClickListener(this);
        findViewById(R.id.tvReset).setOnClickListener(this);
    }

    public void onClick(View view) {
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
            case R.id.tvGetCode /*2131165865*/:
                this.time = 60;
                this.account = this.etAccount.getText().toString();
                if (StringUtil.isEmpty(this.account)) {
                    showToast(getString(R.string.hint_input_account));
                    return;
                }
                if (this.account.contains("@")) {
                    this.isPhone = false;
                } else {
                    this.isPhone = true;
                }
                new Thread() {
                    public void run() {
                        int i = (-TimeZone.getDefault().getRawOffset()) / 1000;
                        int timeInMillis = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("codeType", 1);
                            jSONObject.put("loginName", ForgetPwdActivity.this.account);
                            if (ForgetPwdActivity.this.isPhone) {
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
            case R.id.tvReset /*2131165874*/:
                this.account = this.etAccount.getText().toString();
                this.password = this.etPwd.getText().toString();
                this.code = this.etCode.getText().toString();
                if (StringUtil.isEmpty(this.account)) {
                    showToast(getString(R.string.hint_input_account));
                    return;
                }
                this.account.contains("@");
                if (StringUtil.isEmpty(this.password)) {
                    showToast(getString(R.string.hint_pwd));
                    return;
                } else if (StringUtil.isEmpty(this.password)) {
                    showToast(getString(R.string.hint_validate_code));
                    return;
                } else if (StringUtil.isEmpty(this.code)) {
                    showToast(getString(R.string.hint_validate_code));
                    return;
                } else {
                    new Thread() {
                        public void run() {
                            int i = (-TimeZone.getDefault().getRawOffset()) / 1000;
                            long timeInMillis = Calendar.getInstance().getTimeInMillis() / 1000;
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("code", ForgetPwdActivity.this.code);
                                jSONObject.put("password", ForgetPwdActivity.this.password);
                                jSONObject.put("loginName", ForgetPwdActivity.this.account);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String doHttpPost = HttpUtils.doHttpPost(jSONObject.toString(), "http://xyx.365uj.com/homeeye/api/user/forgotPassword");
                            try {
                                JSONObject jSONObject2 = new JSONObject(doHttpPost);
                                if (jSONObject2.getInt("code") == 200) {
                                    ForgetPwdActivity.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            SharedPreferences.Editor edit = ForgetPwdActivity.this.preSHIX.edit();
                                            edit.putString(ContentCommon.SHIX_LONGIN_USER, ForgetPwdActivity.this.account);
                                            edit.putString(ContentCommon.SHIX_LONGIN_PWD, ForgetPwdActivity.this.password);
                                            edit.commit();
                                            Intent intent = new Intent(ForgetPwdActivity.this, LoginActivity.class);
                                            intent.addFlags(268468224);
                                            ForgetPwdActivity.this.startActivity(intent);
                                            ForgetPwdActivity.this.finish();
                                        }
                                    });
                                } else {
                                    final String string = jSONObject2.getString(CrashHianalyticsData.MESSAGE);
                                    ForgetPwdActivity.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            ForgetPwdActivity forgetPwdActivity = ForgetPwdActivity.this;
                                            forgetPwdActivity.showToast("" + string);
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
            default:
                return;
        }
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
