package com.shix.shixipc.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.vungle.warren.model.AdAssetDBAdapter;
import java.io.InputStream;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;

public class OtaShowActivity extends BaseActivity implements NUIMainActivity.SHIXCOMMONInterface, NUIMainActivity.SHIXAlarmInterface {
    private final int PARAMS = 3;
    private final int PARAMS1 = 4;
    private final int PARAMS2 = 5;
    int all_size = 0;
    /* access modifiers changed from: private */
    public int binAllLen = 0;
    /* access modifiers changed from: private */
    public int binNowLen = 0;
    /* access modifiers changed from: private */
    public Button buttonOTAP2P;
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
                    double access$000 = ((double) OtaShowActivity.this.binNowLen) / ((double) OtaShowActivity.this.binAllLen);
                    int i2 = (int) (100.0d * access$000);
                    CommonUtil.Log(1, "zhaogenghuai111 pro:" + i2 + "   binNowLen:" + OtaShowActivity.this.binNowLen + "   binAllLen:" + OtaShowActivity.this.binAllLen + " f:" + access$000);
                    if (i2 <= 100) {
                        OtaShowActivity.this.seekBar.setProgress(i2);
                    }
                } else if (i == 5) {
                    TextView access$600 = OtaShowActivity.this.tvSee2;
                    access$600.setText("MD5: " + OtaShowActivity.this.mdNowLen + "/" + OtaShowActivity.this.mdAllLen);
                    double access$400 = ((double) OtaShowActivity.this.mdNowLen) / ((double) OtaShowActivity.this.mdAllLen);
                    int i3 = (int) (100.0d * access$400);
                    CommonUtil.Log(1, "zhaogenghuai111 pro:" + i3 + "   mdNowLen:" + OtaShowActivity.this.mdAllLen + "   binAllLen:" + OtaShowActivity.this.mdAllLen + " f1:" + access$400);
                    if (i3 <= 100) {
                        OtaShowActivity.this.seekBar2.setProgress(i3);
                    }
                }
            } else if (OtaShowActivity.this.result == 0) {
                OtaShowActivity.this.showToast("可以升级");
                new Thread() {
                    public void run() {
                    }
                }.start();
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
        setContentView(R.layout.activity_ota);
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.tvShowX = (TextView) findViewById(R.id.tvShowX);
        this.llSee1 = (LinearLayout) findViewById(R.id.llSee1);
        this.seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.tvSee1 = (TextView) findViewById(R.id.tvSee1);
        this.llSee2 = (LinearLayout) findViewById(R.id.llSee2);
        this.seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        this.tvSee2 = (TextView) findViewById(R.id.tvSee2);
        this.buttonOTAServer = (Button) findViewById(R.id.buttonOTAServer);
        this.buttonOTAP2P = (Button) findViewById(R.id.buttonOTAP2P);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NUIMainActivity.setSHIXAlarmInterface(this);
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
                OtaShowActivity.this.buttonOTAP2P.setEnabled(false);
                OtaShowActivity.this.buttonOTAServer.setBackgroundResource(R.drawable.play_button_normal);
                OtaShowActivity.this.buttonOTAP2P.setBackgroundResource(R.drawable.play_button_normal);
                NativeCaller.TransferMessage(OtaShowActivity.this.strDID, CommonUtil.SHIX_CheckOTA(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "", "http://shixapp.oss-cn-hongkong.aliyuncs.com/hqbka9/bka9.rbl", 1), 0);
            }
        });
        findViewById(R.id.buttonOTAP2P).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(OtaShowActivity.this, 10);
                }
                OtaShowActivity.this.buttonOTAServer.setEnabled(false);
                OtaShowActivity.this.buttonOTAP2P.setEnabled(false);
                OtaShowActivity.this.buttonOTAServer.setBackgroundResource(R.drawable.play_button_normal);
                OtaShowActivity.this.buttonOTAP2P.setBackgroundResource(R.drawable.play_button_normal);
                NativeCaller.TransferMessage(OtaShowActivity.this.strDID, CommonUtil.SHIX_CheckOTA(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "", "", 2), 0);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        NUIMainActivity.setSHIXCOMMONInterface((NUIMainActivity.SHIXCOMMONInterface) null);
        NUIMainActivity.setSHIXAlarmInterface((NUIMainActivity.SHIXAlarmInterface) null);
        super.onDestroy();
    }

    public void uploadFile() {
        new Thread() {
            public void run() {
                long j;
                try {
                    InputStream open = OtaShowActivity.this.getAssets().open("app42045.bin");
                    byte[] bArr = new byte[4096];
                    int available = open.available();
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        int read = open.read(bArr);
                        j = 20;
                        if (read == -1) {
                            break;
                        }
                        Log.d(ContentCommon.SERVER_STRING, "ds.write");
                        while (NativeCaller.PPPPCheckFileBuffer(OtaShowActivity.this.strDID) >= 51200) {
                            Thread.sleep(20);
                            CommonUtil.Log(1, "SHIXSEND bufferSize: >=5*1024");
                        }
                        int length = i + bArr.length;
                        if (NativeCaller.PPPPSendFileData(OtaShowActivity.this.strDID, bArr, read, i2, available, 1) < 0) {
                            Thread.sleep(500);
                            NativeCaller.PPPPSendFileData(OtaShowActivity.this.strDID, bArr, read, i2, available, 1);
                        }
                        i2++;
                        Log.v(ContentCommon.SERVER_STRING, "文件总大小==    每次上传的length==" + read + "    上传进度=" + length);
                        i = length;
                    }
                    open.close();
                    InputStream open2 = OtaShowActivity.this.getAssets().open("bak.sh");
                    byte[] bArr2 = new byte[2048];
                    int available2 = open2.available();
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        int read2 = open2.read(bArr2);
                        if (read2 != -1) {
                            Log.d(ContentCommon.SERVER_STRING, "ds.write");
                            while (NativeCaller.PPPPCheckFileBuffer(OtaShowActivity.this.strDID) >= 51200) {
                                Thread.sleep(j);
                                CommonUtil.Log(1, "SHIXSEND bufferSize: >=5*1024");
                            }
                            int length2 = i4 + bArr2.length;
                            if (NativeCaller.PPPPSendFileData(OtaShowActivity.this.strDID, bArr2, read2, i3, available2, 2) < 0) {
                                Thread.sleep(500);
                                NativeCaller.PPPPSendFileData(OtaShowActivity.this.strDID, bArr2, read2, i3, available2, 2);
                            }
                            i3++;
                            Log.v(ContentCommon.SERVER_STRING, "文件总大小2==    每次上传的length==" + read2 + "    上传进度=" + length2);
                            i4 = length2;
                            j = 20;
                        } else {
                            open2.close();
                            return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.v(ContentCommon.SERVER_STRING, "imgfilestring==>>333");
                }
            }
        }.start();
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (str2.indexOf("406") > 0) {
            try {
                this.result = CommonUtil.jasonPaseInt(new JSONObject(str2), IronSourceConstants.EVENTS_RESULT, ContentCommon.SHIXFINAL_ERRORINT);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mHandler.sendEmptyMessage(3);
        }
        if (str2.indexOf("check_ota") > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (CommonUtil.jasonPaseInt(jSONObject, AdAssetDBAdapter.AdAssetColumns.COLUMN_FILE_TYPE, ContentCommon.SHIXFINAL_ERRORINT) == 1) {
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

    public void CallBackSHIXJasonAlarm(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (CommonUtil.jasonPaseInt(jSONObject, AdAssetDBAdapter.AdAssetColumns.COLUMN_FILE_TYPE, ContentCommon.SHIXFINAL_ERRORINT) == 1) {
                this.binAllLen = CommonUtil.jasonPaseInt(jSONObject, "all_size", ContentCommon.SHIXFINAL_ERRORINT);
                this.binNowLen = CommonUtil.jasonPaseInt(jSONObject, "now_size", ContentCommon.SHIXFINAL_ERRORINT);
                this.mHandler.sendEmptyMessage(4);
                return;
            }
            this.mdAllLen = CommonUtil.jasonPaseInt(jSONObject, "all_size", ContentCommon.SHIXFINAL_ERRORINT);
            this.mdNowLen = CommonUtil.jasonPaseInt(jSONObject, "now_size", ContentCommon.SHIXFINAL_ERRORINT);
            this.mHandler.sendEmptyMessage(5);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
