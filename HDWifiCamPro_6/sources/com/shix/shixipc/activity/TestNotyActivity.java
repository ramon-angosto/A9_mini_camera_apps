package com.shix.shixipc.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

public class TestNotyActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.SHIXCOMMONInterface {
    private final int PARAMS = 3;
    /* access modifiers changed from: private */
    public String did;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 3) {
                TextView access$100 = TestNotyActivity.this.tv_show;
                access$100.setText(TestNotyActivity.this.testStr + "");
            }
        }
    };
    /* access modifiers changed from: private */
    public String testStr = "";
    /* access modifiers changed from: private */
    public TextView tv_show;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test_noty);
        CommonUtil.Log(1, "SHIX  onCreate");
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.did = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.tv_show = (TextView) findViewById(R.id.tv_show);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.tvNext0).setOnClickListener(this);
        findViewById(R.id.tv_getParms).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NativeCaller.TransferMessage(TestNotyActivity.this.did, CommonUtil.getCloudsupport(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
            }
        });
        findViewById(R.id.tv_getCloud).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NativeCaller.TransferMessage(TestNotyActivity.this.did, CommonUtil.getCloudinfo(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
            }
        });
        findViewById(R.id.tv_setCloud).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        findViewById(R.id.tv_delCloud).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NativeCaller.TransferMessage(TestNotyActivity.this.did, CommonUtil.delCloudinfo(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
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
        NUIMainActivity.setSHIXCOMMONInterface((NUIMainActivity.SHIXCOMMONInterface) null);
        super.onDestroy();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.tvNext0) {
            NativeCaller.TransferMessage(this.did, CommonUtil.getCameraParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        }
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        this.testStr = str2;
        this.mHandler.sendEmptyMessage(3);
    }
}
