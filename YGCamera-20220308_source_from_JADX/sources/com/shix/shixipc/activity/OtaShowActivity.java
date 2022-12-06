package com.shix.shixipc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class OtaShowActivity extends BaseActivity implements NUIMainActivity.SHIXCOMMONInterface {
    private final int PARAMS = 3;
    private final int PARAMS1 = 4;
    private final int PARAMS2 = 5;
    int all_size = 0;
    /* access modifiers changed from: private */
    public int binAllLen = 0;
    /* access modifiers changed from: private */
    public int binNowLen = 0;
    /* access modifiers changed from: private */
    public Button buttonOTAServer;
    private LinearLayout llSee1;
    private LinearLayout llSee2;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                if (i == 4) {
                    TextView access$200 = OtaShowActivity.this.tvSee1;
                    access$200.setText("Bin: " + OtaShowActivity.this.binNowLen + "/" + OtaShowActivity.this.binAllLen);
                    double access$000 = (double) OtaShowActivity.this.binNowLen;
                    double access$100 = (double) OtaShowActivity.this.binAllLen;
                    Double.isNaN(access$000);
                    Double.isNaN(access$100);
                    double d = access$000 / access$100;
                    int i2 = (int) (100.0d * d);
                    CommonUtil.Log(1, "zhaogenghuai111 pro:" + i2 + "   binNowLen:" + OtaShowActivity.this.binNowLen + "   binAllLen:" + OtaShowActivity.this.binAllLen + " f:" + d);
                    if (i2 <= 100) {
                        OtaShowActivity.this.seekBar.setProgress(i2);
                    }
                } else if (i == 5) {
                    TextView access$600 = OtaShowActivity.this.tvSee2;
                    access$600.setText("MD5: " + OtaShowActivity.this.mdNowLen + "/" + OtaShowActivity.this.mdAllLen);
                    double access$400 = (double) OtaShowActivity.this.mdNowLen;
                    double access$500 = (double) OtaShowActivity.this.mdAllLen;
                    Double.isNaN(access$400);
                    Double.isNaN(access$500);
                    double d2 = access$400 / access$500;
                    int i3 = (int) (100.0d * d2);
                    CommonUtil.Log(1, "zhaogenghuai111 pro:" + i3 + "   mdNowLen:" + OtaShowActivity.this.mdAllLen + "   binAllLen:" + OtaShowActivity.this.mdAllLen + " f1:" + d2);
                    if (i3 <= 100) {
                        OtaShowActivity.this.seekBar2.setProgress(i3);
                    }
                }
            } else if (OtaShowActivity.this.result == 0) {
                OtaShowActivity.this.showToast("正在下载...");
            } else if (OtaShowActivity.this.result == -1) {
                OtaShowActivity.this.showToast("SD未插入，无法升级");
            } else if (OtaShowActivity.this.result == -2) {
                OtaShowActivity.this.showToast("正在下载中或正在接受下载文件");
            } else if (OtaShowActivity.this.result == -3) {
                OtaShowActivity.this.showToast("电量不足");
            }
        }
    };
    /* access modifiers changed from: private */
    public int mdAllLen = 0;
    /* access modifiers changed from: private */
    public int mdNowLen = 0;
    int now_size = 0;
    /* access modifiers changed from: private */
    public String pathSer = "";
    int result = 0;
    /* access modifiers changed from: private */
    public SeekBar seekBar;
    /* access modifiers changed from: private */
    public SeekBar seekBar2;
    /* access modifiers changed from: private */
    public String strDID = null;
    /* access modifiers changed from: private */
    public TextView tvSee1;
    /* access modifiers changed from: private */
    public TextView tvSee2;
    private TextView tvShowX;
    int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(128, 128);
        setContentView(R.layout.activity_ota);
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.pathSer = intent.getStringExtra(ContentCommon.STR_CAMERA_UPDATAPATH);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.tvShowX = (TextView) findViewById(R.id.tvShowX);
        this.llSee1 = (LinearLayout) findViewById(R.id.llSee1);
        this.seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.tvSee1 = (TextView) findViewById(R.id.tvSee1);
        this.llSee2 = (LinearLayout) findViewById(R.id.llSee2);
        this.seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        this.tvSee2 = (TextView) findViewById(R.id.tvSee2);
        this.buttonOTAServer = (Button) findViewById(R.id.buttonOTAServer);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(OtaShowActivity.this, 10);
                }
                OtaShowActivity.this.finish();
            }
        });
        findViewById(R.id.buttonOTAServer).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(OtaShowActivity.this, 10);
                }
                OtaShowActivity.this.buttonOTAServer.setEnabled(false);
                OtaShowActivity.this.buttonOTAServer.setBackgroundResource(R.drawable.play_button_normal);
                NativeCaller.TransferMessage(OtaShowActivity.this.strDID, CommonUtil.SHIX_CheckOTA(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "", OtaShowActivity.this.pathSer, 1), 0);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        NUIMainActivity.setSHIXCOMMONInterface((NUIMainActivity.SHIXCOMMONInterface) null);
        super.onDestroy();
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (str2.indexOf("406") > 0) {
            try {
                this.result = CommonUtil.jasonPaseInt(new JSONObject(str2), "result", ContentCommon.SHIXFINAL_ERRORINT);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mHandler.sendEmptyMessage(3);
        }
        if (str2.indexOf("check_ota") > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (CommonUtil.jasonPaseInt(jSONObject, "file_type", ContentCommon.SHIXFINAL_ERRORINT) == 1) {
                    this.binAllLen = CommonUtil.jasonPaseInt(jSONObject, "all_size", ContentCommon.SHIXFINAL_ERRORINT);
                    this.binNowLen = CommonUtil.jasonPaseInt(jSONObject, "now_size", ContentCommon.SHIXFINAL_ERRORINT);
                    this.mHandler.sendEmptyMessage(4);
                    return;
                }
                this.mdAllLen = CommonUtil.jasonPaseInt(jSONObject, "all_size", ContentCommon.SHIXFINAL_ERRORINT);
                this.mdNowLen = CommonUtil.jasonPaseInt(jSONObject, "now_size", ContentCommon.SHIXFINAL_ERRORINT);
                this.mHandler.sendEmptyMessage(5);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
