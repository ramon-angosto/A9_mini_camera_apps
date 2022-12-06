package com.shix.shixipc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.work.WorkRequest;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonAppUtil;
import com.shix.shixipc.utils.CommonUtil;
import com.unad.sdk.UNADSplash;
import com.unad.sdk.dto.AdError;
import java.util.Date;
import object.p2pipcam.nativecaller.NativeCaller;

public class SplashActivity extends BaseActivity {
    public boolean canJump = false;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 3) {
                CommonUtil.Log(1, "CyCamera 10S强制进入");
                SplashActivity.this.startMain();
            } else if (message.what == 1) {
                CommonUtil.Log(1, "CyCamera msg.what == 1 进入主页面");
                SplashActivity.this.startMain();
            } else if (message.what == 2 && CommonAppUtil.APP_isOpenAd() != 0 && CommonAppUtil.APP_adSplash()) {
                try {
                    SplashActivity.this.loadAd();
                } catch (Exception e) {
                    CommonUtil.Log(1, "CyCamera 加载广告异常进入主界面：" + e.getMessage().toString());
                    SplashActivity.this.startMain();
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.splash);
        findViewById(R.id.tvNextMain).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SplashActivity splashActivity = SplashActivity.this;
                splashActivity.startActivity(new Intent(splashActivity, NUIMainActivity.class));
                SplashActivity.this.finish();
                ((CrashApplication) SplashActivity.this.getApplication()).setRun(true);
            }
        });
        if (CommonAppUtil.APP_isOpenAd() == 0) {
            this.mHandler.sendEmptyMessageDelayed(2, 1500);
        } else {
            this.mHandler.sendEmptyMessageDelayed(2, 1);
        }
        this.mHandler.sendEmptyMessageDelayed(3, WorkRequest.MIN_BACKOFF_MILLIS);
        new Thread(new Runnable() {
            public void run() {
                try {
                    NativeCaller.PPPPInitial(ContentCommon.SERVER_STRING);
                    Log.d("test-server", "SystemValue.SystemSerVer");
                    NativeCaller.Init();
                    long time = new Date().getTime();
                    NativeCaller.PPPPNetworkDetect();
                    if (new Date().getTime() - time <= 1500) {
                        Thread.sleep(2000);
                    }
                    if (CommonAppUtil.APP_isOpenAd() == 0) {
                        CommonUtil.Log(1, "CyCamera 没有开启广告，进入主界面");
                        Message message = new Message();
                        message.what = 1;
                        SplashActivity.this.mHandler.sendMessage(message);
                    } else if (!CommonAppUtil.APP_adSplash()) {
                        Message message2 = new Message();
                        message2.what = 1;
                        SplashActivity.this.mHandler.sendMessage(message2);
                        CommonUtil.Log(1, "CyCamera 开启广告，没有开启开屏，进入主界面");
                    }
                } catch (Exception unused) {
                }
            }
        }).start();
    }

    public void loadAd() {
        UNADSplash uNADSplash = new UNADSplash(getApplication());
        uNADSplash.setSkipButtonType(UNADSplash.SKIPTYPE.CLICK);
        uNADSplash.setAdUnitId("Adgo-unit-5696530582");
        uNADSplash.setAdViewListener(new UNADSplash.AdViewListener() {
            public void onAdClicked() {
            }

            public void onAdOpen() {
            }

            public void onAdLoaded() {
                Log.e("UNAD_SDK", "UI  :onAdViewLoaded");
            }

            public void onAdFailed(AdError adError) {
                Log.e("UNAD_SDK", "UI  :onAdViewFailed" + adError.getMessage());
                SplashActivity.this.startMain();
            }

            public void onAdClose() {
                Log.e("UNAD_SDK", "UI  :onAdViewClose");
                SplashActivity.this.startMain();
            }
        });
        uNADSplash.setBackgroundPicture(R.mipmap.qh_splash);
        uNADSplash.setLogoPicture(R.mipmap.app);
        uNADSplash.setDurationTime(5);
        uNADSplash.setAppName(getString(R.string.app_name));
        uNADSplash.setIntervals(216000);
        uNADSplash.setTimeoutTime(5);
        uNADSplash.loadAd(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.canJump = false;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.canJump) {
            startMain();
        }
        this.canJump = true;
    }

    public void startMain() {
        if (this.canJump) {
            CrashApplication crashApplication = (CrashApplication) getApplication();
            if (!crashApplication.isRun) {
                startActivity(new Intent(this, NUIMainActivity.class));
                finish();
                crashApplication.setRun(true);
                return;
            }
            return;
        }
        this.canJump = true;
    }
}
