package com.shix.shixipc.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.PayHttpUtils;
import com.shix.shixipc.utils.UploadUtil;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class TestPushActivity extends BaseActivity implements View.OnClickListener {
    private EditText editText;
    private EditText editText1;
    private EditText editText2;
    JSONObject objA = null;
    JSONObject objB = null;
    JSONObject objC = null;
    private SharedPreferences preuser;
    /* access modifiers changed from: private */
    public String rStr = "";
    private String strIp = "";
    private String strPort = "";
    private String strUUID1;
    String testDevName = "";
    String testID = "";
    String testIP = "";
    String testKey = "";
    /* access modifiers changed from: private */
    public TextView textView3;
    String token = "";
    private EditText tv_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test);
        CommonUtil.Log(1, "SHIX  onCreate");
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.editText = (EditText) findViewById(R.id.editText);
        this.editText1 = (EditText) findViewById(R.id.editText1);
        this.editText2 = (EditText) findViewById(R.id.editText2);
        this.tv_name = (EditText) findViewById(R.id.tv_name);
        this.textView3 = (TextView) findViewById(R.id.textView3);
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.tvNext).setOnClickListener(this);
        findViewById(R.id.tvNext1).setOnClickListener(this);
        findViewById(R.id.tvNext0).setOnClickListener(this);
        findViewById(R.id.tvNext2).setOnClickListener(this);
        findViewById(R.id.tvNext6).setOnClickListener(this);
        findViewById(R.id.tvNext7).setOnClickListener(this);
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        this.strUUID1 = this.preuser.getString("SHIXUUID1", "");
        String str = this.strUUID1;
        if (str == null || str.length() < 2) {
            this.strUUID1 = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = this.preuser.edit();
            edit.putString("SHIXUUID1", this.strUUID1);
            edit.commit();
        }
        CommonUtil.Log(1, "strUUID1:" + this.strUUID1);
        findViewById(R.id.pushOther).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(TestPushActivity.this, TestAllPushActivity.class);
                TestPushActivity.this.startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        this.testIP = this.tv_name.getText().toString();
        this.textView3.setText("");
        int id = view.getId();
        if (id != R.id.back) {
            switch (id) {
                case R.id.tvNext:
                    this.testID = this.editText.getText().toString();
                    this.testKey = this.editText1.getText().toString();
                    this.testDevName = this.editText2.getText().toString();
                    String str = this.testID;
                    if (str == null || str.length() < 5) {
                        showToast("请填写设备ID");
                        return;
                    }
                    String str2 = this.testKey;
                    if (str2 == null || str2.length() < 1) {
                        showToast("请填写设备Key");
                        return;
                    }
                    String str3 = this.testDevName;
                    if (str3 == null || str3.length() < 1) {
                        showToast("请填写设备Name");
                        return;
                    }
                    String str4 = this.token;
                    if (str4 == null || str4.length() < 1) {
                        showToast("请先获取宸云推送服务器token");
                        return;
                    } else if (ContentCommon.XM_REGID == null || ContentCommon.XM_REGID.length() < 1) {
                        showToast("小米REGID没获取到，小米平台注册失败");
                        return;
                    } else {
                        this.objB = new JSONObject();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("packageName", "com.shix.qhipc");
                            jSONObject.put("appSecret", ContentCommon.XM_APP_Secret);
                            jSONObject.put("targetAccount", ContentCommon.XM_REGID);
                            this.objB.put("devId", this.testID);
                            this.objB.put("devKey", this.testKey);
                            this.objB.put("devName", this.testDevName);
                            this.objB.put("phoneType", "xiaomi");
                            this.objB.put("phoneKey", this.strUUID1);
                            this.objB.put("platformType", "android");
                            this.objB.put("pushParameter", jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        new Thread() {
                            public void run() {
                                super.run();
                                PayHttpUtils payHttpUtils = new PayHttpUtils();
                                try {
                                    String postA = payHttpUtils.postA("http://" + TestPushActivity.this.testIP + "/push/dev/add", TestPushActivity.this.objB.toString(), TestPushActivity.this.token);
                                    if (postA != null) {
                                        if (postA.length() >= 1) {
                                            String unused = TestPushActivity.this.rStr = postA;
                                            TestPushActivity.this.runOnUiThread(new Runnable() {
                                                public void run() {
                                                    TextView access$100 = TestPushActivity.this.textView3;
                                                    access$100.setText(TestPushActivity.this.rStr + "");
                                                }
                                            });
                                        }
                                    }
                                    String unused2 = TestPushActivity.this.rStr = "null";
                                    TestPushActivity.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            TextView access$100 = TestPushActivity.this.textView3;
                                            access$100.setText(TestPushActivity.this.rStr + "");
                                        }
                                    });
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        return;
                    }
                case R.id.tvNext0:
                    this.objA = new JSONObject();
                    try {
                        this.objA.put("userName", "pushHQ");
                        this.objA.put("passwd", "pushHQ");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    new Thread() {
                        public void run() {
                            super.run();
                            PayHttpUtils payHttpUtils = new PayHttpUtils();
                            try {
                                String post = payHttpUtils.post("http://" + TestPushActivity.this.testIP + "/push/login", TestPushActivity.this.objA.toString(), "", "");
                                if (post != null) {
                                    if (post.length() >= 1) {
                                        String unused = TestPushActivity.this.rStr = post;
                                        try {
                                            JSONObject jSONObject = new JSONObject(TestPushActivity.this.rStr);
                                            String string = jSONObject.getString("status");
                                            if (string != null && string.equalsIgnoreCase("ok")) {
                                                TestPushActivity.this.token = jSONObject.getString(IronSourceConstants.EVENTS_RESULT);
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        TestPushActivity.this.runOnUiThread(new Runnable() {
                                            public void run() {
                                                TextView access$100 = TestPushActivity.this.textView3;
                                                access$100.setText(TestPushActivity.this.rStr + "");
                                            }
                                        });
                                    }
                                }
                                String unused2 = TestPushActivity.this.rStr = "null";
                                TestPushActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        TextView access$100 = TestPushActivity.this.textView3;
                                        access$100.setText(TestPushActivity.this.rStr + "");
                                    }
                                });
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }.start();
                    return;
                case R.id.tvNext1:
                    this.testID = this.editText.getText().toString();
                    this.testKey = this.editText1.getText().toString();
                    String str5 = this.testID;
                    if (str5 == null || str5.length() < 5) {
                        showToast("请填写设备ID");
                        return;
                    }
                    String str6 = this.testKey;
                    if (str6 == null || str6.length() < 1) {
                        showToast("请填写设备Key");
                        return;
                    }
                    this.objC = new JSONObject();
                    try {
                        this.objC.put("app_id", this.testID);
                        this.objC.put(MBridgeConstans.APP_KEY, this.testKey);
                        this.objC.put("msg_type", 1);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    new Thread() {
                        public void run() {
                            super.run();
                            PayHttpUtils payHttpUtils = new PayHttpUtils();
                            try {
                                String postA = payHttpUtils.postA("http://" + TestPushActivity.this.testIP + "/push/send", TestPushActivity.this.objC.toString(), TestPushActivity.this.token);
                                if (postA != null) {
                                    if (postA.length() >= 1) {
                                        String unused = TestPushActivity.this.rStr = postA;
                                        TestPushActivity.this.runOnUiThread(new Runnable() {
                                            public void run() {
                                                TextView access$100 = TestPushActivity.this.textView3;
                                                access$100.setText(TestPushActivity.this.rStr + "");
                                            }
                                        });
                                    }
                                }
                                String unused2 = TestPushActivity.this.rStr = "null";
                                TestPushActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        TextView access$100 = TestPushActivity.this.textView3;
                                        access$100.setText(TestPushActivity.this.rStr + "");
                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                    return;
                case R.id.tvNext2:
                    this.strUUID1 = UUID.randomUUID().toString();
                    SharedPreferences.Editor edit = this.preuser.edit();
                    edit.putString("SHIXUUID1", this.strUUID1);
                    edit.commit();
                    TextView textView = this.textView3;
                    textView.setText("手机唯一标识:" + this.strUUID1);
                    return;
                case R.id.tvNext6:
                    this.testID = this.editText.getText().toString();
                    new Thread() {
                        public void run() {
                            super.run();
                            File file = new File("/sdcard/DBG000016FNUMP.jpg");
                            if (file.exists()) {
                                CommonUtil.Log(1, "存在文件");
                            }
                            String str = TestPushActivity.this.testID;
                            UploadUtil.uploadFile(str, file, "http://" + TestPushActivity.this.testIP + "/system/oss/uploadFile", TestPushActivity.this.token);
                        }
                    }.start();
                    return;
                case R.id.tvNext7:
                    this.testID = this.editText.getText().toString();
                    this.testKey = this.editText1.getText().toString();
                    this.testDevName = this.editText2.getText().toString();
                    String str7 = this.testID;
                    if (str7 == null || str7.length() < 5) {
                        showToast("请填写设备ID");
                        return;
                    }
                    String str8 = this.testKey;
                    if (str8 == null || str8.length() < 1) {
                        showToast("请填写设备Key");
                        return;
                    }
                    String str9 = this.testDevName;
                    if (str9 == null || str9.length() < 1) {
                        showToast("请填写设备Name");
                        return;
                    }
                    String str10 = this.token;
                    if (str10 == null || str10.length() < 1) {
                        showToast("请先获取宸云推送服务器token");
                        return;
                    } else if (ContentCommon.HW_STRING == null || ContentCommon.HW_STRING.length() < 1) {
                        showToast("华为token没获取到");
                        return;
                    } else {
                        this.objB = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("hw_app_id", ContentCommon.HW_APP_ID);
                            jSONObject2.put("hw_app_secret", ContentCommon.HW_APPSECRET);
                            jSONObject2.put("hw_token", ContentCommon.HW_STRING);
                            this.objB.put("devId", this.testID);
                            this.objB.put("devKey", this.testKey);
                            this.objB.put("devName", this.testDevName);
                            this.objB.put("phoneType", "huawei");
                            this.objB.put("phoneKey", this.strUUID1);
                            this.objB.put("platformType", "android");
                            this.objB.put("pushParameter", jSONObject2.toString());
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        new Thread() {
                            public void run() {
                                super.run();
                                PayHttpUtils payHttpUtils = new PayHttpUtils();
                                try {
                                    String postA = payHttpUtils.postA("http://" + TestPushActivity.this.testIP + "/push/dev/add", TestPushActivity.this.objB.toString(), TestPushActivity.this.token);
                                    if (postA != null) {
                                        if (postA.length() >= 1) {
                                            String unused = TestPushActivity.this.rStr = postA;
                                            TestPushActivity.this.runOnUiThread(new Runnable() {
                                                public void run() {
                                                    TextView access$100 = TestPushActivity.this.textView3;
                                                    access$100.setText(TestPushActivity.this.rStr + "");
                                                }
                                            });
                                        }
                                    }
                                    String unused2 = TestPushActivity.this.rStr = "null";
                                    TestPushActivity.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            TextView access$100 = TestPushActivity.this.textView3;
                                            access$100.setText(TestPushActivity.this.rStr + "");
                                        }
                                    });
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        return;
                    }
                default:
                    return;
            }
        } else {
            finish();
        }
    }
}
