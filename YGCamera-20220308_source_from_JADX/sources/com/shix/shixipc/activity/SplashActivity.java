package com.shix.shixipc.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import java.util.Date;
import object.p2pipcam.nativecaller.NativeCaller;
import shix.cykj.camera.R;

public class SplashActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            SplashActivity.this.startActivity(new Intent(SplashActivity.this, NUIMainActivity.class));
            SplashActivity.this.finish();
        }
    };
    private SharedPreferences preSHIX;
    String pwd;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_splash);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.preSHIX = getSharedPreferences(ContentCommon.SHIXLOGUSERPWD, 0);
        this.pwd = this.preSHIX.getString(ContentCommon.SHIX_LONGIN_PWD, "");
        new Thread(new Runnable() {
            public void run() {
                try {
                    NativeCaller.PPPPInitial(ContentCommon.SERVER_STRING);
                    Log.d("test-server", "SystemValue.SystemSerVer");
                    long time = new Date().getTime();
                    NativeCaller.PPPPNetworkDetect();
                    if (new Date().getTime() - time <= 1000) {
                        Thread.sleep(1000);
                    }
                    NativeCaller.Init();
                    SplashActivity.this.mHandler.sendMessage(new Message());
                } catch (Exception unused) {
                }
            }
        }).start();
    }
}
