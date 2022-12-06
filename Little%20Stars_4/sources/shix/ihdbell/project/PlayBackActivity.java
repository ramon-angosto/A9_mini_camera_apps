package shix.ihdbell.project;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tzh.ipcamera.model.CustomBuffer;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.TimeZone;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.AudioPlayer;
import object.p2pipcam.utils.DataBaseHelper;
import shix.ihdbell.project.BridgeService;

public class PlayBackActivity extends BaseActivity implements BridgeService.PlayBackInterface, BridgeService.DateTimeInterface {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    private CustomBuffer AudioBuffer = null;
    private AudioPlayer audioPlayer = null;
    boolean exit = false;
    /* access modifiers changed from: private */
    public int i1 = 0;
    /* access modifiers changed from: private */
    public int i2 = 0;
    private boolean isPlaySeekBar = false;
    /* access modifiers changed from: private */
    public LinearLayout layoutConnPrompt;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            Bitmap bitmap;
            PlayBackActivity.this.layoutConnPrompt.setVisibility(8);
            int i = message.what;
            if (i == 1) {
                PlayBackActivity.this.textTimeStamp.setText(PlayBackActivity.this.timeShow);
                PlayBackActivity.this.myRender.writeSample(PlayBackActivity.this.videodata, PlayBackActivity.this.nVideoWidth, PlayBackActivity.this.nVideoHeight);
                PlayBackActivity.this.playImg.setVisibility(8);
                int width = PlayBackActivity.this.getWindowManager().getDefaultDisplay().getWidth();
                PlayBackActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, (width * 3) / 4);
                layoutParams.gravity = 17;
                PlayBackActivity.this.myGlSurfaceView.setLayoutParams(layoutParams);
            } else if (i == 2) {
                PlayBackActivity.this.textTimeStamp.setText(PlayBackActivity.this.timeShow);
                Bitmap bitmap2 = null;
                try {
                    bitmap = BitmapFactory.decodeByteArray(PlayBackActivity.this.videodata, 0, PlayBackActivity.this.videoDataLen);
                } catch (Exception unused) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    int width2 = PlayBackActivity.this.getWindowManager().getDefaultDisplay().getWidth();
                    int height = PlayBackActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                    int i2 = (width2 * 3) / 4;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(width2, i2);
                    layoutParams2.gravity = 17;
                    PlayBackActivity.this.playImg.setLayoutParams(layoutParams2);
                    if (PlayBackActivity.this.getResources().getConfiguration().orientation == 1) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, width2, i2, true);
                    } else if (PlayBackActivity.this.getResources().getConfiguration().orientation == 2) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, width2, height, true);
                    }
                    PlayBackActivity.this.playImg.setVisibility(0);
                    PlayBackActivity.this.playImg.setImageBitmap(bitmap2);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public GLSurfaceView myGlSurfaceView;
    /* access modifiers changed from: private */
    public MyRender myRender;
    /* access modifiers changed from: private */
    public int nVideoHeight = 0;
    /* access modifiers changed from: private */
    public int nVideoWidth = 0;
    /* access modifiers changed from: private */
    public ImageView playImg;
    private SeekBar playSeekBar;
    private String strDID;
    private String strFilePath;
    /* access modifiers changed from: private */
    public TextView textTimeStamp;
    private long time;
    private long time1;
    /* access modifiers changed from: private */
    public String timeShow = " ";
    private String tzStr = "GMT+08:00";
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    /* access modifiers changed from: private */
    public byte[] videodata = null;

    public void callBackSetSystemParamsResult(String str, int i, int i3) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.playback);
        findView();
        setListener();
        BridgeService.setPlayBackInterface(this);
        NativeCaller.StartPlayBack(this.strDID, this.strFilePath, 0);
        BridgeService.setDateTimeInterface(this);
        NativeCaller.PPPPGetSystemParams(this.strDID, 4);
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this, this.AudioBuffer);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        StartAudio();
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        StopHeat();
        super.onStop();
    }

    private void StartAudio() {
        synchronized (this) {
            this.AudioBuffer.ClearAll();
            this.audioPlayer.AudioPlayStart();
        }
    }

    private void StopAudio() {
        synchronized (this) {
            this.audioPlayer.AudioPlayStop();
            this.AudioBuffer.ClearAll();
        }
    }

    private void setListener() {
        this.playSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.isPlaySeekBar) {
                this.isPlaySeekBar = false;
                this.playSeekBar.setVisibility(8);
            } else {
                this.isPlaySeekBar = true;
                this.playSeekBar.setVisibility(0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(DataBaseHelper.KEY_DID);
        this.strFilePath = intent.getStringExtra(DataBaseHelper.KEY_FILEPATH);
    }

    private void findView() {
        this.playImg = (ImageView) findViewById(R.id.playback_img);
        this.layoutConnPrompt = (LinearLayout) findViewById(R.id.layout_connect_prompt);
        this.playSeekBar = (SeekBar) findViewById(R.id.playback_seekbar);
        this.textTimeStamp = (TextView) findViewById(R.id.textTimeStamp);
        this.myGlSurfaceView = (GLSurfaceView) findViewById(R.id.myhsurfaceview);
        this.myRender = new MyRender(this.myGlSurfaceView);
        this.myGlSurfaceView.setRenderer(this.myRender);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        StopAudio();
        MyRender myRender2 = this.myRender;
        if (myRender2 != null) {
            myRender2.destroyShaders();
        }
        BridgeService.setPlayBackInterface((BridgeService.PlayBackInterface) null);
        BridgeService.setDateTimeInterface((BridgeService.DateTimeInterface) null);
        this.exit = false;
        NativeCaller.StopPlayBack(this.strDID);
        Log.d("tag", "PlayBackActivity  onDestroy()");
    }

    private void setTimeZone(int i) {
        switch (i) {
            case -43200:
                this.tzStr = "GMT+12:00";
                return;
            case -39600:
                this.tzStr = "GMT+11:00";
                return;
            case -36000:
                this.tzStr = "GMT+10:00";
                return;
            case -34200:
                this.tzStr = "GMT+09:30";
                return;
            case -32400:
                this.tzStr = "GMT+09:00";
                return;
            case -28800:
                this.tzStr = "GMT+08:00";
                return;
            case -25200:
                this.tzStr = "GMT+07:00";
                return;
            case -21600:
                this.tzStr = "GMT+06:00";
                return;
            case -19800:
                this.tzStr = "GMT+05:30";
                return;
            case -18000:
                this.tzStr = "GMT+05:00";
                return;
            case -16200:
                this.tzStr = "GMT+04:30";
                return;
            case -14400:
                this.tzStr = "GMT+04:00";
                return;
            case -12600:
                this.tzStr = "GMT+03:30";
                return;
            case -10800:
                this.tzStr = "GMT+03:00";
                return;
            case -7200:
                this.tzStr = "GMT+02:00";
                return;
            case -3600:
                this.tzStr = "GMT+01:00";
                return;
            case 0:
                this.tzStr = "GMT";
                return;
            case 3600:
                this.tzStr = "GMT-01:00";
                return;
            case 7200:
                this.tzStr = "GMT-02:00";
                return;
            case 10800:
                this.tzStr = "GMT-03:00";
                return;
            case 12600:
                this.tzStr = "GMT-03:30";
                return;
            case 14400:
                this.tzStr = "GMT-04:00";
                return;
            case 18000:
                this.tzStr = "GMT-05:00";
                return;
            case 21600:
                this.tzStr = "GMT-06:00";
                return;
            case 25200:
                this.tzStr = "GMT-07:00";
                return;
            case 28800:
                this.tzStr = "GMT-08:00";
                return;
            case 32400:
                this.tzStr = "GMT-09:00";
                return;
            case 36000:
                this.tzStr = "GMT-10:00";
                return;
            case 39600:
                this.tzStr = "GMT-11:00";
                return;
            default:
                return;
        }
    }

    private String setDeviceTime(long j, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(str));
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        int i3 = instance.get(2) + 1;
        int i4 = instance.get(5);
        int i5 = instance.get(11);
        int i6 = instance.get(12);
        int i7 = instance.get(13);
        if (i3 < 10) {
            str2 = PushConstants.PUSH_TYPE_NOTIFY + i3;
        } else {
            str2 = String.valueOf(i3);
        }
        if (i4 < 10) {
            str3 = PushConstants.PUSH_TYPE_NOTIFY + i4;
        } else {
            str3 = String.valueOf(i4);
        }
        if (i5 < 10) {
            str4 = PushConstants.PUSH_TYPE_NOTIFY + i5;
        } else {
            str4 = String.valueOf(i5);
        }
        if (i6 < 10) {
            str5 = PushConstants.PUSH_TYPE_NOTIFY + i6;
        } else {
            str5 = String.valueOf(i6);
        }
        if (i7 < 10) {
            str6 = PushConstants.PUSH_TYPE_NOTIFY + i7;
        } else {
            str6 = String.valueOf(i7);
        }
        return i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + "   " + str4 + ":" + str5 + ":" + str6;
    }

    public void callBackPlaybackVideoData(byte[] bArr, int i, int i3, int i4, int i5, int i6) {
        this.i1++;
        Log.d("tag", "playback  len:" + i3 + " width:" + i4 + " height:" + i5 + "i1==" + this.i1);
        if (!this.exit) {
            this.exit = true;
            new MyThread().start();
        }
        this.time = (long) i6;
        this.videodata = bArr;
        this.videoDataLen = i3;
        this.nVideoWidth = i4;
        this.nVideoHeight = i5;
        this.time1 = this.time * 1000;
        this.timeShow = setDeviceTime(this.time1, this.tzStr);
        if (i == 1) {
            this.mHandler.sendEmptyMessage(1);
        } else {
            this.mHandler.sendEmptyMessage(2);
        }
    }

    public void callBackDatetimeParams(String str, int i, int i3, int i4, String str2) {
        setTimeZone(i3);
        Log.d("tag", "timestr:" + this.tzStr + "  tz:" + i3);
    }

    class MyThread extends Thread {
        MyThread() {
        }

        public void run() {
            while (PlayBackActivity.this.exit) {
                PlayBackActivity playBackActivity = PlayBackActivity.this;
                int unused = playBackActivity.i2 = playBackActivity.i1;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (PlayBackActivity.this.i2 == PlayBackActivity.this.i1 && PlayBackActivity.this.exit) {
                    PlayBackActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            PlayBackActivity.this.exit = false;
                            PlayBackActivity.this.finish();
                            PlayBackActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                        }
                    });
                }
            }
            super.run();
        }
    }
}
