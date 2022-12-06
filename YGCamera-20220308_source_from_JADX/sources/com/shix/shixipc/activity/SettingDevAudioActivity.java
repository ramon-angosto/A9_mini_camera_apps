package com.shix.shixipc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.view.SwitchView;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class SettingDevAudioActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.SHIXCOMMONInterface {
    private final int PARAMS = 3;
    private final int TIMEOUT = PathInterpolatorCompat.MAX_NUM_POINTS;
    private String cameraName = null;
    private Button cancel = null;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 3) {
                if (SettingDevAudioActivity.this.voiceTip == 1) {
                    SettingDevAudioActivity.this.sw1.setOpened(true);
                } else {
                    SettingDevAudioActivity.this.sw1.setOpened(false);
                }
            }
        }
    };

    /* renamed from: ok */
    private Button f1557ok = null;
    /* access modifiers changed from: private */
    public String strDID = null;
    SwitchView sw1;
    /* access modifiers changed from: private */
    public int voiceTip = 0;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getDataFromOther();
        setContentView(R.layout.settingaudio);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getVoiceParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        this.sw1 = (SwitchView) findViewById(R.id.sw1);
        this.sw1.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            public void toggleToOn(SwitchView switchView) {
                SettingDevAudioActivity.this.sw1.setOpened(true);
                int unused = SettingDevAudioActivity.this.voiceTip = 1;
                NativeCaller.TransferMessage(SettingDevAudioActivity.this.strDID, CommonUtil.setVoiceParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass, SettingDevAudioActivity.this.voiceTip), 0);
            }

            public void toggleToOff(SwitchView switchView) {
                SettingDevAudioActivity.this.sw1.setOpened(false);
                int unused = SettingDevAudioActivity.this.voiceTip = 0;
                NativeCaller.TransferMessage(SettingDevAudioActivity.this.strDID, CommonUtil.setVoiceParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass, SettingDevAudioActivity.this.voiceTip), 0);
            }
        });
        this.f1557ok = (Button) findViewById(R.id.alerm_ok);
        this.cancel = (Button) findViewById(R.id.alerm_cancel);
        this.f1557ok.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
    }

    private String retrunTime(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return "" + i;
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        NUIMainActivity.setSHIXCOMMONInterface((NUIMainActivity.SHIXCOMMONInterface) null);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        StopHeat();
        super.onPause();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alerm_cancel /*2131165257*/:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            default:
                return;
        }
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (str2.indexOf("301") > 0) {
            try {
                this.voiceTip = CommonUtil.jasonPaseInt(new JSONObject(str2), "voice", ContentCommon.SHIXFINAL_ERRORINT);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mHandler.sendEmptyMessage(3);
        }
    }
}
