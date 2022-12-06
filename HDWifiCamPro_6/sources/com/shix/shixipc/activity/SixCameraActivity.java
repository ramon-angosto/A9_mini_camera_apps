package com.shix.shixipc.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;

public class SixCameraActivity extends BaseActivity implements NUIMainActivity.ConnectChannelStatusInterface1 {
    private boolean isFourPlay = false;
    /* access modifiers changed from: private */
    public int position = 0;
    private ProgressDialog progressDialog;
    /* access modifiers changed from: private */
    public String strDid = "";
    /* access modifiers changed from: private */
    public String strName = null;
    /* access modifiers changed from: private */
    public String strPwd = null;
    /* access modifiers changed from: private */
    public String strUser = null;
    /* access modifiers changed from: private */
    public String stringMac1 = "0000";

    public void BSMsgNotifyData(String str, int i, int i2) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_sixcamera);
        Intent intent = getIntent();
        if (intent != null) {
            this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
            this.strDid = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
            this.strUser = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
            this.strPwd = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
        }
        this.progressDialog = new ProgressDialog(this, 3);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage("正在连接从机...");
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                SixCameraActivity.this.finish();
            }
        });
        findViewById(R.id.btn_four).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                Intent intent = new Intent(SixCameraActivity.this, FourPlayNVRSportActivty.class);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, SixCameraActivity.this.strName);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, SixCameraActivity.this.strDid);
                intent.putExtra(ContentCommon.STR_CAMERA_USER, SixCameraActivity.this.strUser);
                intent.putExtra(ContentCommon.STR_CAMERA_PWD, SixCameraActivity.this.strPwd);
                SixCameraActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.ll_add1).setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                SixCameraActivity sixCameraActivity = SixCameraActivity.this;
                String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(sixCameraActivity, SixCameraActivity.this.strDid + "channel" + 1, "");
                if (GetCommonShareStringValue != null && GetCommonShareStringValue.length() >= 2) {
                    Intent intent = new Intent(SixCameraActivity.this, ChannelAddCameraActivity.class);
                    intent.putExtra("pushTypeInt", 1);
                    intent.putExtra("isEdit", 1);
                    intent.putExtra("strDid", SixCameraActivity.this.strDid);
                    intent.putExtra("strMac", GetCommonShareStringValue);
                    int unused = SixCameraActivity.this.position = 1;
                    SixCameraActivity.this.startActivity(intent);
                }
                return false;
            }
        });
        findViewById(R.id.ll_add1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                SixCameraActivity sixCameraActivity = SixCameraActivity.this;
                String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(sixCameraActivity, SixCameraActivity.this.strDid + "channel" + 1, "");
                if (GetCommonShareStringValue != null && GetCommonShareStringValue.length() >= 2) {
                    String unused = SixCameraActivity.this.stringMac1 = GetCommonShareStringValue;
                    SystemValue.devMac = GetCommonShareStringValue;
                    CommonUtil.Log(1, "SetDevMac 1:strDid:" + SixCameraActivity.this.strDid + "  stringMac:" + GetCommonShareStringValue);
                    NativeCaller.SetDevMac(SixCameraActivity.this.strDid, GetCommonShareStringValue);
                    CommonUtil.Log(1, "SetDevMac 2:strDid:" + SixCameraActivity.this.strDid + "  stringMac:" + GetCommonShareStringValue);
                    SixCameraActivity.this.Play();
                }
            }
        });
        findViewById(R.id.ll_add2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                SixCameraActivity sixCameraActivity = SixCameraActivity.this;
                String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(sixCameraActivity, SixCameraActivity.this.strDid + "channel" + 2, "");
                if (GetCommonShareStringValue != null && GetCommonShareStringValue.length() >= 2) {
                    String unused = SixCameraActivity.this.stringMac1 = GetCommonShareStringValue;
                    SystemValue.devMac = GetCommonShareStringValue;
                    NativeCaller.SetDevMac(SixCameraActivity.this.strDid, GetCommonShareStringValue);
                    SixCameraActivity.this.Play();
                }
            }
        });
        findViewById(R.id.ll_add3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                SixCameraActivity sixCameraActivity = SixCameraActivity.this;
                String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(sixCameraActivity, SixCameraActivity.this.strDid + "channel" + 3, "");
                if (GetCommonShareStringValue != null && GetCommonShareStringValue.length() >= 2) {
                    String unused = SixCameraActivity.this.stringMac1 = GetCommonShareStringValue;
                    SystemValue.devMac = GetCommonShareStringValue;
                    NativeCaller.SetDevMac(SixCameraActivity.this.strDid, GetCommonShareStringValue);
                    SixCameraActivity.this.Play();
                }
            }
        });
        findViewById(R.id.ll_add4).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                SixCameraActivity sixCameraActivity = SixCameraActivity.this;
                String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(sixCameraActivity, SixCameraActivity.this.strDid + "channel" + 4, "");
                if (GetCommonShareStringValue != null && GetCommonShareStringValue.length() >= 2) {
                    String unused = SixCameraActivity.this.stringMac1 = GetCommonShareStringValue;
                    SystemValue.devMac = GetCommonShareStringValue;
                    NativeCaller.SetDevMac(SixCameraActivity.this.strDid, GetCommonShareStringValue);
                    SixCameraActivity.this.Play();
                }
            }
        });
        findViewById(R.id.ll_add5).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                SixCameraActivity sixCameraActivity = SixCameraActivity.this;
                String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(sixCameraActivity, SixCameraActivity.this.strDid + "channel" + 5, "");
                if (GetCommonShareStringValue != null && GetCommonShareStringValue.length() >= 2) {
                    String unused = SixCameraActivity.this.stringMac1 = GetCommonShareStringValue;
                    SystemValue.devMac = GetCommonShareStringValue;
                    NativeCaller.SetDevMac(SixCameraActivity.this.strDid, GetCommonShareStringValue);
                    SixCameraActivity.this.Play();
                }
            }
        });
        findViewById(R.id.ll_add6).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                SixCameraActivity sixCameraActivity = SixCameraActivity.this;
                String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(sixCameraActivity, SixCameraActivity.this.strDid + "channel" + 6, "");
                if (GetCommonShareStringValue != null && GetCommonShareStringValue.length() >= 2) {
                    String unused = SixCameraActivity.this.stringMac1 = GetCommonShareStringValue;
                    SystemValue.devMac = GetCommonShareStringValue;
                    NativeCaller.SetDevMac(SixCameraActivity.this.strDid, GetCommonShareStringValue);
                    SixCameraActivity.this.Play();
                }
            }
        });
        findViewById(R.id.buttonAdd1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                Intent intent = new Intent(SixCameraActivity.this, ChannelAddCameraErCodeActivity.class);
                intent.putExtra("pushTypeInt", 1);
                intent.putExtra("strDid", SixCameraActivity.this.strDid);
                int unused = SixCameraActivity.this.position = 1;
                SixCameraActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.buttonAdd2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                Intent intent = new Intent(SixCameraActivity.this, ChannelAddCameraErCodeActivity.class);
                intent.putExtra("pushTypeInt", 2);
                intent.putExtra("strDid", SixCameraActivity.this.strDid);
                int unused = SixCameraActivity.this.position = 2;
                SixCameraActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.buttonAdd3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                Intent intent = new Intent(SixCameraActivity.this, ChannelAddCameraErCodeActivity.class);
                intent.putExtra("pushTypeInt", 3);
                intent.putExtra("strDid", SixCameraActivity.this.strDid);
                int unused = SixCameraActivity.this.position = 3;
                SixCameraActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.buttonAdd4).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                Intent intent = new Intent(SixCameraActivity.this, ChannelAddCameraErCodeActivity.class);
                intent.putExtra("pushTypeInt", 4);
                intent.putExtra("strDid", SixCameraActivity.this.strDid);
                int unused = SixCameraActivity.this.position = 4;
                SixCameraActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.buttonAdd5).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                Intent intent = new Intent(SixCameraActivity.this, ChannelAddCameraErCodeActivity.class);
                intent.putExtra("pushTypeInt", 5);
                intent.putExtra("strDid", SixCameraActivity.this.strDid);
                int unused = SixCameraActivity.this.position = 5;
                SixCameraActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.buttonAdd6).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SixCameraActivity.this, 10);
                }
                Intent intent = new Intent(SixCameraActivity.this, ChannelAddCameraErCodeActivity.class);
                intent.putExtra("pushTypeInt", 6);
                intent.putExtra("strDid", SixCameraActivity.this.strDid);
                int unused = SixCameraActivity.this.position = 6;
                SixCameraActivity.this.startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        NUIMainActivity.setConnectChannelStatusInterface1((NUIMainActivity.ConnectChannelStatusInterface1) null);
        super.onDestroy();
    }

    private void getPo() {
        for (int i = 1; i < 7; i++) {
            String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(this, this.strDid + "channel" + i, "");
            if (GetCommonShareStringValue != null && GetCommonShareStringValue.length() >= 2) {
                switch (i) {
                    case 1:
                        findViewById(R.id.buttonAdd1).setVisibility(8);
                        ((TextView) findViewById(R.id.textViewShow1)).setText(GetCommonShareStringValue);
                        findViewById(R.id.ll_add2).setVisibility(0);
                        break;
                    case 2:
                        findViewById(R.id.buttonAdd2).setVisibility(8);
                        ((TextView) findViewById(R.id.textViewShow2)).setText(GetCommonShareStringValue);
                        findViewById(R.id.ll_add3).setVisibility(0);
                        break;
                    case 3:
                        findViewById(R.id.buttonAdd3).setVisibility(8);
                        ((TextView) findViewById(R.id.textViewShow3)).setText(GetCommonShareStringValue);
                        findViewById(R.id.ll_add4).setVisibility(0);
                        break;
                    case 4:
                        findViewById(R.id.buttonAdd4).setVisibility(8);
                        ((TextView) findViewById(R.id.textViewShow4)).setText(GetCommonShareStringValue);
                        findViewById(R.id.ll_add5).setVisibility(0);
                        break;
                    case 5:
                        findViewById(R.id.buttonAdd5).setVisibility(8);
                        ((TextView) findViewById(R.id.textViewShow5)).setText(GetCommonShareStringValue);
                        findViewById(R.id.ll_add6).setVisibility(0);
                        break;
                    case 6:
                        findViewById(R.id.buttonAdd6).setVisibility(8);
                        ((TextView) findViewById(R.id.textViewShow6)).setText(GetCommonShareStringValue);
                        break;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void Play() {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && progressDialog2.isShowing()) {
            this.progressDialog.dismiss();
        }
        String str = this.stringMac1;
        if (str != null && str.length() >= 2) {
            NUIMainActivity.setConnectChannelStatusInterface1((NUIMainActivity.ConnectChannelStatusInterface1) null);
            Intent intent = new Intent(this, ChannelCameraLiveActivity.class);
            intent.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
            intent.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
            intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDid);
            intent.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
            intent.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
            intent.putExtra(ContentCommon.STR_CAMERA_MAC, SystemValue.devMac);
            startActivityForResult(intent, 2);
            this.stringMac1 = "";
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        NUIMainActivity.setConnectChannelStatusInterface1(this);
        getPo();
    }

    public void BSCallBack_TYPEMODE(String str, String str2) {
        CommonUtil.Log(1, "SixCamera BSCallBack_TYPEMODE:" + str + "  strDid:" + this.strDid + "  json:" + str2);
        if (str.equalsIgnoreCase(this.strDid)) {
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                jSONObject.getInt("restrict");
            } catch (JSONException unused) {
            }
            try {
                jSONObject.getInt("type");
            } catch (JSONException unused2) {
            }
            try {
                jSONObject.getInt("mode");
            } catch (JSONException unused3) {
            }
            Play();
        }
    }
}
