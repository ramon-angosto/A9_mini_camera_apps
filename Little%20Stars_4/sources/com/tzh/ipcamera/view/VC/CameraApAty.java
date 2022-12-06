package com.tzh.ipcamera.view.VC;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.model.CustomBuffer;
import com.tzh.ipcamera.model.CustomBufferData;
import com.tzh.ipcamera.model.CustomBufferHead;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.presenter.Media;
import com.tzh.ipcamera.presenter.Snap;
import com.tzh.ipcamera.presenter.listener.ITargetBitmapFixListener;
import com.tzh.ipcamera.utils.BmpUtils;
import com.tzh.ipcamera.view.delegate.ICameraDataDelegate;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.AudioPlayer;
import object.p2pipcam.utils.TakeVideoThread;
import object.p2pipcam.utils.VibratorUtil;
import object.p2pipcam.zxingtwodimensioncode.Intents;
import shix.ihdbell.project.BaseActivity;

public class CameraApAty extends BaseActivity implements View.OnClickListener, ICameraDataDelegate, ITargetBitmapFixListener {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    private static final byte MSG_INFRADE_SW = 6;
    private static final byte MSG_INSTRUCT_SW = 5;
    private static final byte MSG_LANDSCAPE_SW = 7;
    private static final byte MSG_PIX_SW = 1;
    private static final byte MSG_PORTRAIT_SW = 8;
    private static final byte MSG_SD_RECORD = 4;
    private static final byte MSG_SD_SNAPSHOT = 3;
    private static final byte MSG_VOICE_SW = 2;
    /* access modifiers changed from: private */
    public CustomBuffer AudioBuffer = null;
    private Bitmap OneBitmap = null;
    /* access modifiers changed from: private */
    public AudioPlayer audioPlayer = null;
    private long availableBlocks;
    private byte bHDModel = 0;
    private byte bInfradeOn = MSG_PIX_SW;
    private byte bInstructOn = 0;
    private byte bLROn = 0;
    /* access modifiers changed from: private */
    public boolean bRecIconShow = false;
    /* access modifiers changed from: private */
    public boolean bScreenRotate = false;
    /* access modifiers changed from: private */
    public boolean bSnapDown = false;
    /* access modifiers changed from: private */
    public boolean bSoundPlay = false;
    private byte bUDOn = 0;
    /* access modifiers changed from: private */
    public boolean bWiFiCon = false;
    private long blockSize;
    private ImageView btnFHD = null;
    private ImageView btnHFHD = null;
    private ImageView btnHHorizontal = null;
    private ImageView btnHInfradeLed = null;
    private ImageView btnHInstructLed = null;
    /* access modifiers changed from: private */
    public ImageView btnHRec = null;
    private ImageView btnHReturn = null;
    private ImageView btnHScale = null;
    private ImageView btnHSnap = null;
    private ImageView btnHSoundPlay = null;
    private ImageView btnHVertical = null;
    private ImageView btnHorizontal = null;
    private ImageView btnInfradeLed = null;
    private ImageView btnInstructLed = null;
    /* access modifiers changed from: private */
    public ImageView btnRecord = null;
    private TextView btnReturn = null;
    private ImageView btnRoundDown = null;
    private ImageView btnRoundLeft = null;
    private ImageView btnRoundRight = null;
    private ImageView btnRoundUp = null;
    private ImageView btnScale = null;
    private ImageView btnSnap = null;
    private ImageView btnSoundPlay = null;
    private ImageView btnVertical = null;
    private byte cmdId = 0;
    private byte[] cmdLine = new byte[10];
    private int count = 0;
    float density;
    private ImageView getBtnHSoundPlay = null;
    Handler handler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.arg1;
            boolean z = false;
            if (i == 0) {
                byte[] bArr = (byte[]) message.obj;
                int i2 = message.arg2;
                CameraApAty.this.tvCameraTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date(System.currentTimeMillis())));
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, i2);
                if (decodeByteArray != null) {
                    int unused = CameraApAty.this.nVideoWidth = decodeByteArray.getWidth();
                    int unused2 = CameraApAty.this.nVideoHeight = decodeByteArray.getHeight();
                    CameraApAty.this.logUtils.e("###you have recive a pic!");
                    CameraApAty.access$408(CameraApAty.this);
                    if (CameraApAty.this.bScreenRotate) {
                        CameraApAty.this.mBmpUtils.setImageParam(CameraApAty.this.mHPlayView.getWidth(), CameraApAty.this.mHPlayView.getHeight());
                        CameraApAty.this.mBmpUtils.push(decodeByteArray);
                    } else {
                        CameraApAty.this.mPlayView.setImageBitmap(decodeByteArray);
                    }
                    if (CameraApAty.this.bSnapDown) {
                        CameraApAty.this.mSnap.takePicture(decodeByteArray);
                        boolean unused3 = CameraApAty.this.bSnapDown = false;
                    }
                    if (CameraApAty.this.isTakeVideo && CameraApAty.this.takeVideoThread != null) {
                        CameraApAty.this.takeVideoThread.addVideo(bArr, 0, CameraApAty.this.nVideoWidth, CameraApAty.this.nVideoHeight);
                    }
                }
            } else if (i == 1) {
                CameraApAty cameraApAty = CameraApAty.this;
                if (message.arg2 == 1) {
                    z = true;
                }
                boolean unused4 = cameraApAty.bWiFiCon = z;
                LogUtils access$300 = CameraApAty.this.logUtils;
                access$300.e("###wificon:" + CameraApAty.this.bWiFiCon);
                boolean access$1300 = CameraApAty.this.bWiFiCon;
            } else if (i != 3 || !CameraApAty.this.bSoundPlay) {
            } else {
                if (CameraApAty.this.audioPlayer == null || CameraApAty.this.audioPlayer.isAudioPlaying()) {
                    CameraApAty.this.logUtils.e("###you have recive a audio buffer");
                    CustomBufferHead customBufferHead = new CustomBufferHead();
                    CustomBufferData customBufferData = new CustomBufferData();
                    customBufferHead.length = message.arg2;
                    customBufferHead.startcode = CameraApAty.AUDIO_BUFFER_START_CODE;
                    customBufferData.head = customBufferHead;
                    customBufferData.data = (byte[]) message.obj;
                    CameraApAty.this.AudioBuffer.addData(customBufferData);
                }
            }
        }
    };
    private int height;
    /* access modifiers changed from: private */
    public ImageView imgRecIcon = null;
    private boolean isMOTO = false;
    /* access modifiers changed from: private */
    public boolean isTakeVideo = false;
    /* access modifiers changed from: private */
    public LogUtils logUtils = LogUtils.setLogger(CameraApAty.class);
    private RelativeLayout lyBottom = null;
    private RelativeLayout lyOperator = null;
    private RelativeLayout lyRecArea = null;
    private RelativeLayout lyScreenLand = null;
    private LinearLayout lyScreenPortrait = null;
    private RelativeLayout lySurface = null;
    private RelativeLayout ly_status_bar = null;
    /* access modifiers changed from: private */
    public BmpUtils mBmpUtils;
    /* access modifiers changed from: private */
    public ImageView mHPlayView = null;
    private Media mMedia = null;
    NativeCaller mNativeCaller = null;
    /* access modifiers changed from: private */
    public ImageView mPlayView = null;
    Runnable mRecRunnable = new Runnable() {
        public void run() {
            if (CameraApAty.this.bRecIconShow) {
                boolean unused = CameraApAty.this.bRecIconShow = false;
                CameraApAty.this.imgRecIcon.setVisibility(4);
            } else {
                boolean unused2 = CameraApAty.this.bRecIconShow = true;
                CameraApAty.this.imgRecIcon.setVisibility(0);
            }
            CameraApAty.this.handler.postDelayed(CameraApAty.this.mRecRunnable, 500);
        }
    };
    /* access modifiers changed from: private */
    public Snap mSnap = null;
    /* access modifiers changed from: private */
    public int nVideoHeight = 0;
    /* access modifiers changed from: private */
    public int nVideoWidth = 0;
    private File path = null;
    private StatFs stat;
    /* access modifiers changed from: private */
    public String strDID = "APCAMERA0000000";
    /* access modifiers changed from: private */
    public TakeVideoThread takeVideoThread = null;
    /* access modifiers changed from: private */
    public TextView tvCameraTime = null;
    private TextView tvReturn = null;
    /* access modifiers changed from: private */
    public int videoHeightTarget = 1080;
    /* access modifiers changed from: private */
    public int videoWidthTarget = 1920;
    private int width;

    public void onDataRecv(Bitmap bitmap) {
    }

    static /* synthetic */ int access$408(CameraApAty cameraApAty) {
        int i = cameraApAty.count;
        cameraApAty.count = i + 1;
        return i;
    }

    private void startVideoRec() {
        if (hasSdcard()) {
            this.stat = new StatFs(this.path.getPath());
            this.blockSize = (long) this.stat.getBlockSize();
            this.availableBlocks = (long) this.stat.getAvailableBlocks();
            if ((this.availableBlocks * this.blockSize) / 1048576 < 50) {
                showToastLong(R.string.sd_card_size_show);
                return;
            }
            this.isTakeVideo = true;
            SystemValue.checkSDStatu = 1;
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    CameraApAty cameraApAty = CameraApAty.this;
                    TakeVideoThread unused = cameraApAty.takeVideoThread = new TakeVideoThread(0, cameraApAty.strDID, 15, CameraApAty.this.nVideoWidth, CameraApAty.this.nVideoHeight, CameraApAty.this.videoWidthTarget, CameraApAty.this.videoHeightTarget);
                    CameraApAty.this.takeVideoThread.start();
                    super.onPreExecute();
                }

                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    try {
                        Thread.sleep(1000);
                        return null;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    CameraApAty.this.imgRecIcon.setVisibility(0);
                    CameraApAty.this.btnRecord.setImageResource(R.drawable.play_record_icon_green);
                    CameraApAty.this.btnHRec.setImageResource(R.drawable.play_record_icon_green);
                    CameraApAty.this.handler.postDelayed(CameraApAty.this.mRecRunnable, 500);
                    super.onPostExecute(voidR);
                }
            }.execute(new Void[0]);
        }
    }

    private void stopVideoRec() {
        if (this.isTakeVideo) {
            this.isTakeVideo = false;
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    CameraApAty.this.takeVideoThread.stopThread();
                    super.onPreExecute();
                }

                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    try {
                        Thread.sleep(500);
                        return null;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    CameraApAty.this.btnRecord.setImageResource(R.drawable.play_record_icon_black);
                    CameraApAty.this.btnHRec.setImageResource(R.drawable.play_record_icon_white);
                    CameraApAty.this.imgRecIcon.setVisibility(4);
                    CameraApAty.this.showToast("/mnt/sdcard/LittleStars/video");
                    CameraApAty.this.handler.removeCallbacks(CameraApAty.this.mRecRunnable);
                    super.onPostExecute(voidR);
                }
            }.execute(new Void[0]);
        }
    }

    private String getConnectWifiSSID() {
        WifiInfo connectionInfo = ((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        Log.e("wifiInfo", connectionInfo.toString());
        Log.e(Intents.WifiConnect.SSID, connectionInfo.getSSID());
        return getNewSSID(connectionInfo.getSSID());
    }

    private String getNewSSID(String str) {
        return str.startsWith("\"") ? str.substring(1, str.length() - 1) : str;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(128, 128);
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.color_all_bg));
        }
        if (this.isMOTO) {
            setContentView(R.layout.ly_camera_play_moto);
        } else {
            setContentView(R.layout.ly_camera_play);
        }
        this.mNativeCaller = new NativeCaller(this, this.handler);
        this.path = Environment.getExternalStorageDirectory();
        widget_init();
    }

    private void widget_init() {
        this.mBmpUtils = new BmpUtils(this, this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.density = displayMetrics.density;
        this.height = displayMetrics.heightPixels;
        this.width = displayMetrics.widthPixels;
        this.tvReturn = (TextView) findViewById(R.id.btnCameraReturn);
        this.lyScreenLand = (RelativeLayout) findViewById(R.id.screenLandscape);
        this.lyScreenPortrait = (LinearLayout) findViewById(R.id.screenPortrait);
        this.lyRecArea = (RelativeLayout) findViewById(R.id.lyRecArea);
        this.mHPlayView = (ImageView) findViewById(R.id.playLandView);
        this.lySurface = (RelativeLayout) findViewById(R.id.lyGLSurface);
        this.mPlayView = (ImageView) findViewById(R.id.playSurface);
        this.ly_status_bar = (RelativeLayout) findViewById(R.id.ly_status_bar);
        this.btnReturn = (TextView) findViewById(R.id.btnCameraReturn);
        this.btnFHD = (ImageView) findViewById(R.id.btnFHDIcon);
        this.btnScale = (ImageView) findViewById(R.id.btnScaleIcon);
        this.btnSoundPlay = (ImageView) findViewById(R.id.btnSoundPlay);
        this.btnHSoundPlay = (ImageView) findViewById(R.id.btnHVoice);
        this.btnSnap = (ImageView) findViewById(R.id.btnSnap);
        this.btnRecord = (ImageView) findViewById(R.id.btnVideoRec);
        this.btnHorizontal = (ImageView) findViewById(R.id.btnHorizontalRotate);
        this.btnVertical = (ImageView) findViewById(R.id.btnVerticalRotate);
        this.tvCameraTime = (TextView) findViewById(R.id.tvCameraTime);
        this.imgRecIcon = (ImageView) findViewById(R.id.imgRecIcon);
        this.btnRoundDown = (ImageView) findViewById(R.id.btnRoundDown);
        this.btnRoundUp = (ImageView) findViewById(R.id.btnRoundTop);
        this.btnRoundLeft = (ImageView) findViewById(R.id.btnRoundLeft);
        this.btnRoundRight = (ImageView) findViewById(R.id.btnRoundRight);
        this.lyBottom = (RelativeLayout) findViewById(R.id.lyBottom);
        this.lyOperator = (RelativeLayout) findViewById(R.id.lyOperator);
        this.imgRecIcon.setVisibility(4);
        this.btnHHorizontal = (ImageView) findViewById(R.id.btnHHorizontalRotate);
        this.btnHVertical = (ImageView) findViewById(R.id.btnHVerticalRotate);
        this.btnHReturn = (ImageView) findViewById(R.id.btnHReturn);
        this.btnHFHD = (ImageView) findViewById(R.id.btnHFHDIcon);
        this.btnHScale = (ImageView) findViewById(R.id.btnHScaleIcon);
        this.btnHSnap = (ImageView) findViewById(R.id.btnHSnap);
        this.btnHRec = (ImageView) findViewById(R.id.btnHRec);
        this.btnHInfradeLed = (ImageView) findViewById(R.id.btnHInfraLightSw);
        this.btnInfradeLed = (ImageView) findViewById(R.id.btnInfraLightSw);
        this.btnHInstructLed = (ImageView) findViewById(R.id.btnHInstructLightSw);
        this.btnInstructLed = (ImageView) findViewById(R.id.btnInstructLightSw);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lySurface.getLayoutParams();
        int i = this.width;
        layoutParams.width = i;
        layoutParams.height = (i * 3) / 4;
        this.lySurface.setLayoutParams(layoutParams);
        this.tvCameraTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date(System.currentTimeMillis())));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lyOperator.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.y20);
        this.lyOperator.setLayoutParams(layoutParams2);
        this.lyOperator.invalidate();
        this.mMedia = new Media(this);
        this.mSnap = new Snap(this, this.strDID);
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this, this.AudioBuffer);
    }

    private void writeAPCmdLine(byte b, byte b2) {
        for (int i = 0; i < 5; i++) {
            byte[] bArr = this.cmdLine;
            bArr[0] = 85;
            bArr[1] = MSG_LANDSCAPE_SW;
            bArr[2] = this.cmdId;
            bArr[3] = b;
            bArr[4] = b2;
            bArr[5] = 0;
            bArr[6] = 0;
            bArr[7] = 0;
            bArr[8] = getOddData();
            byte[] bArr2 = this.cmdLine;
            bArr2[9] = -103;
            NativeCaller.iCmdSend(bArr2, 10);
        }
        this.cmdId = (byte) (this.cmdId + MSG_PIX_SW);
    }

    private byte getOddData() {
        int i = 0;
        for (int i2 = 1; i2 < 8; i2++) {
            i += this.cmdLine[i2];
        }
        return (byte) (i & 255);
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 50);
        switch (view.getId()) {
            case R.id.btnCameraReturn:
                exitActivity();
                finish();
                overridePendingTransition(17432578, 17432579);
                return;
            case R.id.btnFHDIcon:
            case R.id.btnHFHDIcon:
                if (this.bHDModel == 0) {
                    this.bHDModel = MSG_PIX_SW;
                    this.videoWidthTarget = 2560;
                    this.videoHeightTarget = 1440;
                    this.btnHFHD.setImageResource(R.drawable.fhd_icon_white_selector);
                    this.btnFHD.setImageResource(R.drawable.fhd_icon_black_selector);
                } else {
                    this.videoWidthTarget = 1920;
                    this.videoHeightTarget = 1080;
                    this.bHDModel = 0;
                    this.btnFHD.setImageResource(R.drawable.hd_icon_black_selector);
                    this.btnHFHD.setImageResource(R.drawable.hd_icon_white_selector);
                }
                writeAPCmdLine(MSG_PIX_SW, this.bHDModel);
                return;
            case R.id.btnHHorizontalRotate:
            case R.id.btnHorizontalRotate:
                writeAPCmdLine(MSG_LANDSCAPE_SW, (byte) 0);
                return;
            case R.id.btnHInfraLightSw:
            case R.id.btnInfraLightSw:
                if (this.bInfradeOn == 1) {
                    this.bInfradeOn = 0;
                    this.btnInfradeLed.setImageResource(R.drawable.camera_infra_light_off);
                    this.btnHInfradeLed.setImageResource(R.drawable.camera_infra_light_off_white);
                } else {
                    this.bInfradeOn = MSG_PIX_SW;
                    this.btnInfradeLed.setImageResource(R.drawable.camera_infra_light_on);
                    this.btnHInfradeLed.setImageResource(R.drawable.camera_infra_light_on_white);
                }
                writeAPCmdLine(MSG_INFRADE_SW, this.bInfradeOn);
                return;
            case R.id.btnHInstructLightSw:
            case R.id.btnInstructLightSw:
                if (this.bInstructOn == 1) {
                    this.bInstructOn = 0;
                    this.btnInstructLed.setImageResource(R.drawable.camera_instruct_light_off);
                    this.btnHInstructLed.setImageResource(R.drawable.camera_instruct_light_off_white);
                } else {
                    this.bInstructOn = MSG_PIX_SW;
                    this.btnInstructLed.setImageResource(R.drawable.camera_instruct_light_on);
                    this.btnHInstructLed.setImageResource(R.drawable.camera_instruct_light_on_white);
                }
                writeAPCmdLine(MSG_INSTRUCT_SW, this.bInstructOn);
                return;
            case R.id.btnHRec:
            case R.id.btnVideoRec:
                if (!this.bWiFiCon) {
                    Toast.makeText(this, getResources().getString(R.string.camera_connect_device_access_please), 1).show();
                    return;
                } else if (!this.isTakeVideo) {
                    startVideoRec();
                    return;
                } else {
                    stopVideoRec();
                    return;
                }
            case R.id.btnHReturn:
            case R.id.btnHScaleIcon:
            case R.id.btnScaleIcon:
                if (this.bScreenRotate) {
                    this.bScreenRotate = false;
                    this.btnHScale.setImageResource(R.drawable.play_fullscreen_icon_green);
                    this.btnScale.setImageResource(R.drawable.play_fullscreen_icon_green);
                    screenVertical();
                    return;
                }
                this.bScreenRotate = true;
                this.btnHScale.setImageResource(R.drawable.play_fullscreen_icon_white);
                this.btnScale.setImageResource(R.drawable.play_fullscreen_icon_black);
                screenHorizontal();
                return;
            case R.id.btnHSnap:
            case R.id.btnSnap:
                this.mMedia.play();
                if (!this.bWiFiCon) {
                    Toast.makeText(this, getResources().getString(R.string.camera_connect_device_access_please), 1).show();
                    return;
                } else {
                    this.bSnapDown = true;
                    return;
                }
            case R.id.btnHVerticalRotate:
            case R.id.btnVerticalRotate:
                writeAPCmdLine(MSG_PORTRAIT_SW, (byte) 0);
                return;
            case R.id.btnHVoice:
            case R.id.btnSoundPlay:
                if (this.bSoundPlay) {
                    soundPlayUp();
                    return;
                } else if (!this.bWiFiCon) {
                    Toast.makeText(this, getResources().getString(R.string.camera_connect_device_access_please), 1).show();
                    return;
                } else {
                    soundPlayPressed();
                    return;
                }
            default:
                return;
        }
    }

    private void soundPlayPressed() {
        this.btnHSoundPlay.setImageResource(R.drawable.sound_icon_green);
        this.btnSoundPlay.setImageResource(R.drawable.sound_icon_green);
        synchronized (this) {
            this.bSoundPlay = true;
            this.AudioBuffer.ClearAll();
            if (this.audioPlayer != null) {
                Log.e("###", "startPlayAudio");
                this.audioPlayer.AudioPlayStart();
            }
        }
    }

    private void soundPlayUp() {
        this.btnHSoundPlay.setImageResource(R.drawable.sound_icon_white);
        this.btnSoundPlay.setImageResource(R.drawable.sound_icon_black);
        synchronized (this) {
            this.bSoundPlay = false;
            if (this.audioPlayer != null) {
                this.audioPlayer.AudioPlayStop();
            }
            this.AudioBuffer.ClearAll();
        }
    }

    public void screenHorizontal() {
        setRequestedOrientation(0);
    }

    public void screenVertical() {
        setRequestedOrientation(1);
    }

    @TargetApi(11)
    public void widget_init_with_h() {
        this.logUtils.e("screen set width");
        getWindow().getDecorView().setSystemUiVisibility(1028);
        this.lyScreenPortrait.setVisibility(4);
        this.lyScreenLand.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lyRecArea.getLayoutParams();
        layoutParams.topMargin = (int) getResources().getDimension(R.dimen.y30);
        this.lyRecArea.setLayoutParams(layoutParams);
    }

    @TargetApi(21)
    public void widget_init_with_v() {
        this.logUtils.e("screen set height");
        getWindow().getDecorView().setSystemUiVisibility(512);
        getWindow().setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
        this.lyScreenLand.setVisibility(4);
        this.lyScreenPortrait.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lyRecArea.getLayoutParams();
        layoutParams.topMargin = this.ly_status_bar.getHeight();
        this.lyRecArea.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lySurface.getLayoutParams();
        int i = this.width;
        layoutParams2.width = i;
        layoutParams2.height = (i * 3) / 4;
        this.lySurface.setLayoutParams(layoutParams2);
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("lysurface height:" + layoutParams2.height);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.lyOperator.getLayoutParams();
        layoutParams3.width = -1;
        layoutParams3.height = -1;
        layoutParams3.bottomMargin = (int) getResources().getDimension(R.dimen.y70);
        this.lyOperator.setLayoutParams(layoutParams3);
        this.lyOperator.invalidate();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 1) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.density = displayMetrics.density;
            this.width = displayMetrics.widthPixels;
            this.height = displayMetrics.heightPixels;
            int i = this.width;
            int i2 = this.height;
            if (i > i2) {
                i = i2;
            }
            this.width = i;
            LogUtils logUtils2 = this.logUtils;
            logUtils2.e("CameraPlayActivity width:" + this.width);
            widget_init_with_v();
            return;
        }
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
        this.density = displayMetrics2.density;
        this.width = displayMetrics2.widthPixels;
        this.height = displayMetrics2.heightPixels;
        int i3 = this.width;
        int i4 = this.height;
        if (i3 <= i4) {
            i3 = i4;
        }
        this.width = i3;
        widget_init_with_h();
        LogUtils logUtils3 = this.logUtils;
        logUtils3.e("CameraPlayActivity width:" + this.width);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        NativeCaller.iCameraStart();
        BmpUtils bmpUtils = this.mBmpUtils;
        if (bmpUtils != null) {
            bmpUtils.start();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        soundPlayUp();
        if (this.isTakeVideo) {
            stopVideoRec();
            this.isTakeVideo = false;
            this.btnRecord.setImageResource(R.drawable.play_record_icon_black);
            this.btnHRec.setImageResource(R.drawable.play_record_icon_white);
            this.handler.removeCallbacks(this.mRecRunnable);
        }
        this.count = 0;
        NativeCaller.iCameraStop();
        BmpUtils bmpUtils = this.mBmpUtils;
        if (bmpUtils != null) {
            bmpUtils.stop();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void exitActivity() {
        this.mNativeCaller.clearHandler();
        Media media = this.mMedia;
        if (media != null) {
            media.destroy();
        }
        this.mMedia = null;
        if (this.bSoundPlay) {
            soundPlayUp();
        }
    }

    public void onBackPressed() {
        if (this.bScreenRotate) {
            this.btnHReturn.performClick();
            return;
        }
        super.onBackPressed();
        exitActivity();
        this.logUtils.e("onBackPressed");
        this.btnReturn.performClick();
    }

    public void OnBitmapFixed(final Bitmap bitmap) {
        runOnUiThread(new Runnable() {
            public void run() {
                CameraApAty.this.mHPlayView.setImageBitmap(bitmap);
            }
        });
    }
}
