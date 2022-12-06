package shix.ihdbell.project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.jxl.app.littlestars.project.R;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

public class SettingPushActivity extends BaseActivity implements View.OnClickListener, BridgeService.PushStatusInterface {
    /* access modifiers changed from: private */
    public int PushType;
    private String cameraName;
    /* access modifiers changed from: private */
    public CheckBox cbxChecka = null;
    private CheckBox cbxCheckb = null;
    private CheckBox cbxCheckc = null;
    int enable = 0;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1110 && SettingPushActivity.this.PushType != 255 && SettingPushActivity.this.PushType != 0) {
                SettingPushActivity.this.cbxChecka.setChecked(true);
            }
        }
    };
    private String strDID;

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
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.settingpush);
        this.cbxChecka = (CheckBox) findViewById(R.id.cbx_a);
        this.cbxCheckb = (CheckBox) findViewById(R.id.cbx_b);
        this.cbxCheckc = (CheckBox) findViewById(R.id.cbx_c);
        findViewById(R.id.date_ok).setOnClickListener(this);
        findViewById(R.id.date_cancel).setOnClickListener(this);
        this.PushType = 0;
        BridgeService.setPushStatusInterface(this);
        NativeCaller.PPPPGetSystemParams(this.strDID, 64);
        SetTab(this);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        int id = view.getId();
        if (id == R.id.date_cancel) {
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        } else if (id == R.id.date_ok) {
            this.PushType = 0;
            if (this.cbxChecka.isChecked()) {
                this.enable = 1;
            } else {
                this.enable = 0;
            }
            String str = (ContentCommon.HW_STRING == null || ContentCommon.HW_STRING.length() <= 5) ? "" : ContentCommon.HW_STRING;
            if ((str == null || str.length() < 5) && ContentCommon.XM_STRING != null && ContentCommon.XM_STRING.length() > 5) {
                str = ContentCommon.XM_STRING;
            }
            if ((str == null || str.length() < 5) && ContentCommon.MZ_STRING != null && ContentCommon.MZ_STRING.length() > 5) {
                String str2 = ContentCommon.MZ_STRING;
            }
            NativeCaller.TransferMessage(this.strDID, "android_push_register.cgi?&validity=120&hw_device_token=" + ContentCommon.HW_STRING + "&hw_client_id=" + ContentCommon.HW_APP_ID + "&hw_client_secret=" + ContentCommon.HW_APP_KEY + "&xm_registration_id=" + ContentCommon.XM_STRING + "&xm_app_secret=" + ContentCommon.XM_APPSECRET + "&xm_package_name=" + ContentCommon.XM_PACKAGE_NAME + "&mz_push_id=" + ContentCommon.MZ_STRING + "&mz_app_id=" + ContentCommon.MZ_APP_ID + "&mz_app_secret=" + ContentCommon.MZ_APPSECRET + "&pushtype=" + SystemValue.pustType + "&enable=" + this.enable + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        }
    }

    public void callBackPushStatus(String str, int i, int i2) {
        this.PushType = i;
        this.mHandler.sendEmptyMessage(1110);
    }
}
