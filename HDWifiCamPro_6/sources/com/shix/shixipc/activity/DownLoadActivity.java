package com.shix.shixipc.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.viewpager.ImagePagerActivity;

public class DownLoadActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.PlayBackInterface {
    private Handler MsgHandler = new Handler() {
        public void handleMessage(Message message) {
        }
    };
    String filename = "";
    private TextView tv_show;

    public void AudioPCMDataPlayBack(byte[] bArr, int i, int i2) {
    }

    public void callBackH264Data(String str, byte[] bArr, int i, int i2) {
    }

    public void callBackPlaybackAudioData(byte[] bArr, int i) {
    }

    public void callBackPlaybackVideoData(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ap_connect);
        CommonUtil.Log(1, "SHIX  onCreate");
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.filename = getIntent().getStringExtra(ImagePagerActivity.FILENAME);
        findViewById(R.id.tvNext).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        this.tv_show = (TextView) findViewById(R.id.tv_show);
        CommonUtil.SHIX_DownLoad(SystemValue.doorBellAdmin, SystemValue.doorBellPass, ImagePagerActivity.FILENAME);
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
        CommonUtil.SHIX_StopFileDownload(SystemValue.doorBellAdmin, SystemValue.doorBellPass, ImagePagerActivity.FILENAME);
        super.onDestroy();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            finish();
        }
    }
}
