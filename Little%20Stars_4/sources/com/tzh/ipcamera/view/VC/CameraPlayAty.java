package com.tzh.ipcamera.view.VC;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tzh.ipcamera.model.CustomBuffer;
import com.tzh.ipcamera.model.CustomBufferData;
import com.tzh.ipcamera.model.CustomBufferHead;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.presenter.Media;
import com.tzh.ipcamera.presenter.Snap;
import com.tzh.ipcamera.presenter.listener.ITargetBitmapFixListener;
import com.tzh.ipcamera.utils.BmpUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.AudioPlayer;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.CustomAudioRecorder;
import object.p2pipcam.utils.DataBaseHelper;
import object.p2pipcam.utils.TakeVideoThread;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BaseActivity;
import shix.ihdbell.project.BridgeService;
import shix.ihdbell.project.MainActivity;

@SuppressLint({"Wakelock", "NewApi"})
public class CameraPlayAty extends BaseActivity implements GestureDetector.OnGestureListener, CustomAudioRecorder.AudioRecordResult, GestureDetector.OnDoubleTapListener, BridgeService.PlayInterface, BridgeService.DateTimeInterface, View.OnTouchListener, BridgeService.DoorBellSystemParmInterface, View.OnClickListener, BridgeService.CameraBatteryInterface, ITargetBitmapFixListener {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    private static final int CMD_AUDIO_SPK_REQ = 21;
    private static final int CMD_PIX_FHD = 13;
    private static final int CMD_PIX_HD = 12;
    private static final int CMD_PTZ_BATTERY_LEVEL = 17;
    private static final int CMD_PTZ_DOWN = 2;
    private static final int CMD_PTZ_DOWN_STOP = 3;
    private static final int CMD_PTZ_H_ROTATE = 8;
    private static final int CMD_PTZ_H_ROTATE_STOP = 9;
    private static final int CMD_PTZ_INSTRUCT_LED = 15;
    private static final int CMD_PTZ_LED = 14;
    private static final int CMD_PTZ_LEFT = 4;
    private static final int CMD_PTZ_LEFT_STOP = 5;
    private static final int CMD_PTZ_QUERY_VERSION = 16;
    private static final int CMD_PTZ_RIGHT = 6;
    private static final int CMD_PTZ_RIGHT_STOP = 7;
    private static final int CMD_PTZ_UP = 0;
    private static final int CMD_PTZ_UP_STOP = 1;
    private static final int CMD_PTZ_V_ROTATE = 10;
    private static final int CMD_PTZ_V_ROTATE_STOP = 11;
    private static final String LOG_TAG = "CameraPlayAty";
    private static final int NONE = 0;
    private static final int msgBattery = 6;
    private static final int msgReConnect = 8;
    private static final int msgReStart = 9;
    private static final int msgSdcard = 7;
    private static final int shakeDown = 2;
    private static final int shakeLeft = 3;
    private static final int shakeRight = 4;
    private static final int shakeStop = 0;
    private static final int shakeTop = 1;
    private CustomBuffer AudioBuffer = null;
    private int AudioOrTalkType = 2;
    private final int CANCELTIME = 1230;
    private final int CANCELTIMEFINISH = 1231;
    private Bitmap OneBitmap = null;
    private final int RESETTIME = 1232;
    private final int WIFI_NET_CONNECT_SUCCESS = 21763;
    private final int WIFI_NET_STATUS_BAD = 21762;
    private AnimationDrawable animationDrawable;
    private AudioPlayer audioPlayer = null;
    private long availableBlocks;
    private boolean bAudioRecordStart = false;
    private boolean bAudioStart = true;
    /* access modifiers changed from: private */
    public boolean bDisplayFinished = true;
    /* access modifiers changed from: private */
    public boolean bFHBDown = false;
    /* access modifiers changed from: private */
    public boolean bInfradeOn = true;
    /* access modifiers changed from: private */
    public boolean bInstructOn = false;
    /* access modifiers changed from: private */
    public boolean bRecIconShow = false;
    /* access modifiers changed from: private */
    public boolean bScreenRotate = false;
    /* access modifiers changed from: private */
    public boolean bSnap = false;
    /* access modifiers changed from: private */
    public boolean bSoundPlay = false;
    private boolean bSpeech = false;
    private boolean bVideoRec = false;
    private boolean bl_doorbell_sound = false;
    private long blockSize;
    private ImageView btnFHD = null;
    private ImageView btnHFHD = null;
    private ImageView btnHHorizontal = null;
    private ImageView btnHInfradeLed = null;
    private ImageView btnHInstructLed = null;
    /* access modifiers changed from: private */
    public ImageView btnHRec = null;
    private ImageView btnHRecord;
    private ImageView btnHReturn = null;
    private ImageView btnHScale = null;
    private ImageView btnHSnap = null;
    private ImageView btnHSoundPlay = null;
    private ImageView btnHVertical = null;
    private ImageView btnHVoiceSpeech = null;
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
    private ImageView btnVoiceSpeech = null;
    /* access modifiers changed from: private */
    public int cancelTime = 60;
    private CustomAudioRecorder customAudioRecorder = null;
    float density;
    private int height;
    /* access modifiers changed from: private */
    public ImageView imgBattery = null;
    private ImageView imgHProcess = null;
    /* access modifiers changed from: private */
    public ImageView imgRecIcon = null;
    private ImageView imgVProcess = null;
    /* access modifiers changed from: private */
    public RelativeLayout imgVProcess_ly = null;
    /* access modifiers changed from: private */
    public RelativeLayout imgVProcess_ly_full = null;
    private boolean isCancel = false;
    private boolean isH264 = false;
    /* access modifiers changed from: private */
    public int isH264Data = 0;
    private boolean isHigthVideo;
    private boolean isMOTO = true;
    private boolean isOneShow = true;
    private boolean isPictSave = false;
    /* access modifiers changed from: private */
    public boolean isTakeVideo = false;
    private boolean isTakepic = false;
    private boolean isVGA = false;
    /* access modifiers changed from: private */
    public String lockPwd = "";
    LogUtils logUtils = LogUtils.setLogger(CameraPlayAty.class);
    private RelativeLayout lyBottom = null;
    private RelativeLayout lyOperator = null;
    private RelativeLayout lyRecArea = null;
    private RelativeLayout lyScreenLand = null;
    private LinearLayout lyScreenPortrait = null;
    private RelativeLayout lySurface = null;
    private RelativeLayout ly_status_bar = null;
    /* access modifiers changed from: private */
    public Bitmap mBmp;
    /* access modifiers changed from: private */
    public BmpUtils mBmpUtils;
    /* access modifiers changed from: private */
    public ImageView mHPlayView = null;
    /* access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            String str;
            String str2;
            int i = message.what;
            if (i == 2) {
                CameraPlayAty.this.imgVProcess_ly.setVisibility(4);
                CameraPlayAty.this.imgVProcess_ly_full.setVisibility(4);
                CameraPlayAty.this.tvCameraTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date(System.currentTimeMillis())));
                CameraPlayAty cameraPlayAty = CameraPlayAty.this;
                Bitmap unused = cameraPlayAty.mBmp = BitmapFactory.decodeByteArray(cameraPlayAty.videodata, 0, CameraPlayAty.this.videoDataLen);
                if (CameraPlayAty.this.mBmp == null) {
                    Log.d(CameraPlayAty.LOG_TAG, "bmp can't be decode...");
                    boolean unused2 = CameraPlayAty.this.bDisplayFinished = true;
                    return;
                }
                CameraPlayAty cameraPlayAty2 = CameraPlayAty.this;
                int unused3 = cameraPlayAty2.nVideoWidth = cameraPlayAty2.mBmp.getWidth();
                CameraPlayAty cameraPlayAty3 = CameraPlayAty.this;
                int unused4 = cameraPlayAty3.nVideoHeight = cameraPlayAty3.mBmp.getHeight();
                CameraPlayAty cameraPlayAty4 = CameraPlayAty.this;
                Bitmap unused5 = cameraPlayAty4.mBmp = Bitmap.createScaledBitmap(cameraPlayAty4.mBmp, CameraPlayAty.this.width, (CameraPlayAty.this.width * 3) / 4, true);
                if (CameraPlayAty.this.bScreenRotate) {
                    CameraPlayAty.this.mBmpUtils.setImageParam(CameraPlayAty.this.mHPlayView.getWidth(), CameraPlayAty.this.mHPlayView.getHeight());
                    CameraPlayAty.this.mBmpUtils.push(CameraPlayAty.this.mBmp);
                } else {
                    CameraPlayAty.this.mPlayView.setImageBitmap(CameraPlayAty.this.mBmp);
                }
                if (CameraPlayAty.this.bSnap) {
                    boolean unused6 = CameraPlayAty.this.bSnap = false;
                    if (CameraPlayAty.this.mSnap != null) {
                        CameraPlayAty.this.mSnap.takePicture(CameraPlayAty.this.mBmp);
                    }
                }
                boolean unused7 = CameraPlayAty.this.bDisplayFinished = true;
            } else if (i == 3) {
            } else {
                if (i != 1232) {
                    switch (i) {
                        case 6:
                            int i2 = message.getData().getInt("batteryLevel");
                            if (i2 == 1) {
                                CameraPlayAty.this.imgBattery.setImageResource(R.drawable.battery1_icon);
                                return;
                            } else if (i2 == 2) {
                                CameraPlayAty.this.imgBattery.setImageResource(R.drawable.battery2_icon);
                                return;
                            } else if (i2 == 3) {
                                CameraPlayAty.this.imgBattery.setImageResource(R.drawable.battery3_icon);
                                return;
                            } else if (i2 == 4) {
                                CameraPlayAty.this.imgBattery.setImageResource(R.drawable.battery4_icon);
                                return;
                            } else {
                                return;
                            }
                        case 7:
                            Toast.makeText(CameraPlayAty.this, "SDCARD INFO", 0).show();
                            return;
                        case 8:
                            if (CameraPlayAty.this.isTakeVideo) {
                                CameraPlayAty.this.stopVideoRec();
                                boolean unused8 = CameraPlayAty.this.isTakeVideo = false;
                                CameraPlayAty.this.btnRecord.setImageResource(R.drawable.play_record_icon_black);
                                CameraPlayAty.this.btnHRec.setImageResource(R.drawable.play_record_icon_white);
                                CameraPlayAty.this.mHandler.removeCallbacks(CameraPlayAty.this.mRecRunnable);
                            }
                            NativeCaller.StopPPPPLivestream(CameraPlayAty.this.strDID);
                            CameraPlayAty.this.imgVProcess_ly.setVisibility(0);
                            CameraPlayAty.this.imgVProcess_ly_full.setVisibility(0);
                            new GetDataTask().execute(new Void[0]);
                            return;
                        case 9:
                            CameraPlayAty cameraPlayAty5 = CameraPlayAty.this;
                            String unused9 = cameraPlayAty5.pushUUID = (((int) (Math.random() * 900.0d)) + 100) + "";
                            if (CameraPlayAty.this.strDID.length() > 3) {
                                if (CameraPlayAty.this.pushTypeInt == 3) {
                                    NativeCaller.StartPPPPLivestream(CameraPlayAty.this.strDID, 20, CameraPlayAty.this.pushUUID, SystemValue.videFram);
                                } else {
                                    NativeCaller.StartPPPPLivestream(CameraPlayAty.this.strDID, 22, CameraPlayAty.this.pushUUID, SystemValue.videFram);
                                }
                            }
                            if (CameraPlayAty.this.bFHBDown) {
                                int unused10 = CameraPlayAty.this.videoWidthTarget = 2560;
                                int unused11 = CameraPlayAty.this.videoHeightTarget = 1440;
                                str = String.format("/decoder_control.cgi?command=13&onestep=1&user=" + CameraPlayAty.this.preuser + "&pwd=" + CameraPlayAty.this.lockPwd, new Object[0]);
                            } else {
                                int unused12 = CameraPlayAty.this.videoWidthTarget = 1920;
                                int unused13 = CameraPlayAty.this.videoHeightTarget = 1080;
                                str = String.format("/decoder_control.cgi?command=12&onestep=1&user=" + CameraPlayAty.this.preuser + "&pwd=" + CameraPlayAty.this.lockPwd, new Object[0]);
                            }
                            NativeCaller.TransferMessage(CameraPlayAty.this.strDID, str, 1);
                            if (CameraPlayAty.this.bSoundPlay) {
                                CameraPlayAty.this.soundPlayPressed();
                            } else {
                                CameraPlayAty.this.soundPlayUp();
                            }
                            if (CameraPlayAty.this.bInfradeOn) {
                                NativeCaller.TransferMessage(CameraPlayAty.this.strDID, String.format("/decoder_control.cgi?command=14&onestep=1&user=" + CameraPlayAty.this.preuser + "&pwd=" + CameraPlayAty.this.lockPwd, new Object[0]), 0);
                            } else {
                                NativeCaller.TransferMessage(CameraPlayAty.this.strDID, String.format("/decoder_control.cgi?command=14&onestep=0&user=" + CameraPlayAty.this.preuser + "&pwd=" + CameraPlayAty.this.lockPwd, new Object[0]), 1);
                            }
                            if (CameraPlayAty.this.bInstructOn) {
                                str2 = String.format("/decoder_control.cgi?command=15&onestep=1&user=" + CameraPlayAty.this.preuser + "&pwd=" + CameraPlayAty.this.lockPwd, new Object[0]);
                            } else {
                                str2 = String.format("/decoder_control.cgi?command=15&onestep=0&user=" + CameraPlayAty.this.preuser + "&pwd=" + CameraPlayAty.this.lockPwd, new Object[0]);
                            }
                            NativeCaller.TransferMessage(CameraPlayAty.this.strDID, str2, 1);
                            return;
                        default:
                            return;
                    }
                } else {
                    if (CameraPlayAty.this.resettime < 30) {
                        int unused14 = CameraPlayAty.this.resettime = 30;
                    }
                    CameraPlayAty cameraPlayAty6 = CameraPlayAty.this;
                    int unused15 = cameraPlayAty6.cancelTime = cameraPlayAty6.resettime;
                }
            }
        }
    };
    private final float[] mMatrixValues = new float[9];
    private Media mMedia = null;
    /* access modifiers changed from: private */
    public ImageView mPlayView = null;
    Runnable mRecRunnable = new Runnable() {
        public void run() {
            if (CameraPlayAty.this.bRecIconShow) {
                boolean unused = CameraPlayAty.this.bRecIconShow = false;
                CameraPlayAty.this.imgRecIcon.setVisibility(4);
            } else {
                boolean unused2 = CameraPlayAty.this.bRecIconShow = true;
                CameraPlayAty.this.imgRecIcon.setVisibility(0);
            }
            CameraPlayAty.this.mHandler.postDelayed(CameraPlayAty.this.mRecRunnable, 500);
        }
    };
    /* access modifiers changed from: private */
    public Snap mSnap = null;
    protected Matrix mSuppMatrix = new Matrix();
    /* access modifiers changed from: private */
    public int nVideoHeight = 0;
    /* access modifiers changed from: private */
    public int nVideoWidth = 0;
    private int p2pMode = 1;
    private File path = null;
    private int position = 0;
    private SharedPreferences preAudio;
    /* access modifiers changed from: private */
    public String preuser = "";
    /* access modifiers changed from: private */
    public int pushTypeInt = 0;
    /* access modifiers changed from: private */
    public String pushUUID = PushConstants.PUSH_TYPE_NOTIFY;
    /* access modifiers changed from: private */
    public int resettime = 20;
    private int samper = 8000;
    Animation shake = null;
    private int shakeStatus = 0;
    private StatFs stat;
    /* access modifiers changed from: private */
    public String strDID = null;
    private String strName = null;
    /* access modifiers changed from: private */
    public TakeVideoThread takeVideoThread = null;
    private long time;
    private long time1;
    private int timeCount = 0;
    /* access modifiers changed from: private */
    public TextView tvCameraTime = null;
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    /* access modifiers changed from: private */
    public int videoHeightTarget = 1080;
    /* access modifiers changed from: private */
    public int videoWidthTarget = 1920;
    /* access modifiers changed from: private */
    public byte[] videodata = null;
    PowerManager.WakeLock wakeLock = null;
    /* access modifiers changed from: private */
    public int width;

    public void callBackDatetimeParams(String str, int i, int i2, int i3, String str2) {
    }

    public void callBackH264Data(String str, byte[] bArr, int i, int i2) {
    }

    public void callBackSetSystemParamsResult(String str, int i, int i2) {
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.preAudio = getSharedPreferences("shix_zhao_audio", 0);
        getDataFromOther();
        getWindow().setFlags(128, 128);
        requestWindowFeature(1);
        requesetPermission();
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
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(268435466, "MyWakeLock");
        this.isHigthVideo = false;
        this.logUtils.e("cameraPlayAty  onCreate ");
        widget_init();
        BridgeService.setDateTimeInterface(this);
        BridgeService.setPlayInterface(this);
        BridgeService.setDoorBellSystemParmInterface(this);
        BridgeService.setCameraBatteryInterface(this);
        this.path = Environment.getExternalStorageDirectory();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.cancelTime = 60;
        this.resettime = 21;
        this.density = displayMetrics.density;
        this.width = displayMetrics.widthPixels;
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("CameraPlayActivity  OnCreate width:" + this.width);
        doorBellOtherView();
        this.bAudioRecordStart = true;
        this.bAudioStart = true;
        NativeCaller.PPPPGetSystemParams(this.strDID, 4);
        NativeCaller.PPPPGetSystemParams(this.strDID, 2);
        this.preuser = SystemValue.doorBellAdmin;
        this.lockPwd = SystemValue.doorBellPass;
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this, this.AudioBuffer);
        this.customAudioRecorder = new CustomAudioRecorder(this);
    }

    public void requesetPermission() {
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 1);
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            for (int i2 : iArr) {
                if (i2 != 0) {
                    Toast.makeText(this, "缺少相关权限，请允许相关权限！", 1).show();
                    finish();
                    return;
                }
                this.customAudioRecorder = new CustomAudioRecorder(this);
            }
        }
    }

    private void widget_init() {
        this.mBmpUtils = new BmpUtils(this, this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.density = displayMetrics.density;
        this.height = displayMetrics.heightPixels;
        this.width = displayMetrics.widthPixels;
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
        this.btnVoiceSpeech = (ImageView) findViewById(R.id.btnVoiceSpeech);
        this.btnSoundPlay = (ImageView) findViewById(R.id.btnSoundPlay);
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
        this.btnVoiceSpeech.setOnTouchListener(this);
        this.imgRecIcon.setVisibility(4);
        this.btnHHorizontal = (ImageView) findViewById(R.id.btnHHorizontalRotate);
        this.btnHVertical = (ImageView) findViewById(R.id.btnHVerticalRotate);
        this.btnHReturn = (ImageView) findViewById(R.id.btnHReturn);
        this.btnHFHD = (ImageView) findViewById(R.id.btnHFHDIcon);
        this.btnHScale = (ImageView) findViewById(R.id.btnHScaleIcon);
        this.btnHVoiceSpeech = (ImageView) findViewById(R.id.btnHVoiceSpeech);
        this.btnHSoundPlay = (ImageView) findViewById(R.id.btnHVoice);
        this.btnHSnap = (ImageView) findViewById(R.id.btnHSnap);
        this.btnHRec = (ImageView) findViewById(R.id.btnHRec);
        this.imgHProcess = (ImageView) findViewById(R.id.imgHProcess);
        this.imgVProcess = (ImageView) findViewById(R.id.imgVProcess);
        ((AnimationDrawable) this.imgVProcess.getBackground()).start();
        this.btnHVoiceSpeech.setOnTouchListener(this);
        this.btnRoundDown.setOnTouchListener(this);
        this.btnRoundUp.setOnTouchListener(this);
        this.btnRoundLeft.setOnTouchListener(this);
        this.btnRoundRight.setOnTouchListener(this);
        this.btnHInfradeLed = (ImageView) findViewById(R.id.btnHInfraLightSw);
        this.btnInfradeLed = (ImageView) findViewById(R.id.btnInfraLightSw);
        this.btnHInstructLed = (ImageView) findViewById(R.id.btnHInstructLightSw);
        this.btnInstructLed = (ImageView) findViewById(R.id.btnInstructLightSw);
        this.imgBattery = (ImageView) findViewById(R.id.imgBattery);
        this.imgVProcess_ly = (RelativeLayout) findViewById(R.id.imgVProcess_ly);
        this.imgVProcess_ly_full = (RelativeLayout) findViewById(R.id.imgVProcess_ly_full);
        this.mHPlayView.setOnTouchListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lySurface.getLayoutParams();
        int i = this.width;
        layoutParams.width = i;
        layoutParams.height = (i * 3) / 4;
        this.lySurface.setLayoutParams(layoutParams);
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("lysurface height:" + layoutParams.height);
        this.mSnap = new Snap(this, this.strDID);
        this.mMedia = new Media(this);
        this.tvCameraTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date(System.currentTimeMillis())));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lyOperator.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.y20);
        this.lyOperator.setLayoutParams(layoutParams2);
        this.lyOperator.invalidate();
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 50);
        switch (view.getId()) {
            case R.id.btnCameraReturn:
                this.isCancel = false;
                this.logUtils.e("###camera return start");
                new AsyncTask<Void, Void, Void>() {
                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        if (CameraPlayAty.this.pushTypeInt != 3) {
                            CameraPlayAty.this.logUtils.e("###back onPreExecute");
                            CameraPlayAty.this.sendBroadcast(new Intent("back"));
                        }
                    }

                    /* access modifiers changed from: protected */
                    public Void doInBackground(Void... voidArr) {
                        boolean unused = CameraPlayAty.this.isTakeVideo = false;
                        try {
                            CameraPlayAty.this.logUtils.e("###back doInBackground");
                            Thread.sleep(300);
                            return null;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Void voidR) {
                        CameraPlayAty.this.logUtils.e("###camera return onPostExecute exit");
                        CameraPlayAty.this.finish();
                        CameraPlayAty.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                    }
                }.execute(new Void[0]);
                return;
            case R.id.btnFHDIcon:
            case R.id.btnHFHDIcon:
                if (this.bFHBDown) {
                    this.bFHBDown = false;
                    this.videoWidthTarget = 1920;
                    this.videoHeightTarget = 1080;
                    NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=12&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                    this.btnFHD.setImageResource(R.drawable.hd_icon_black_selector);
                    this.btnHFHD.setImageResource(R.drawable.hd_icon_white_selector);
                    return;
                }
                this.bFHBDown = true;
                this.videoWidthTarget = 2560;
                this.videoHeightTarget = 1440;
                NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=13&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                this.btnHFHD.setImageResource(R.drawable.fhd_icon_white_selector);
                this.btnFHD.setImageResource(R.drawable.fhd_icon_black_selector);
                return;
            case R.id.btnHHorizontalRotate:
            case R.id.btnHorizontalRotate:
                NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=8&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                return;
            case R.id.btnHInfraLightSw:
            case R.id.btnInfraLightSw:
                if (this.bInfradeOn) {
                    this.bInfradeOn = false;
                    this.btnInfradeLed.setImageResource(R.drawable.camera_infra_light_off);
                    this.btnHInfradeLed.setImageResource(R.drawable.camera_infra_light_off_white);
                    NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=14&onestep=0&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                    return;
                }
                this.bInfradeOn = true;
                this.btnInfradeLed.setImageResource(R.drawable.camera_infra_light_on);
                this.btnHInfradeLed.setImageResource(R.drawable.camera_infra_light_on_white);
                NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=14&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 0);
                return;
            case R.id.btnHInstructLightSw:
            case R.id.btnInstructLightSw:
                if (this.bInstructOn) {
                    this.bInstructOn = false;
                    this.btnInstructLed.setImageResource(R.drawable.camera_instruct_light_off);
                    this.btnHInstructLed.setImageResource(R.drawable.camera_instruct_light_off_white);
                    NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=15&onestep=0&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                    return;
                }
                this.bInstructOn = true;
                this.btnInstructLed.setImageResource(R.drawable.camera_instruct_light_on);
                this.btnHInstructLed.setImageResource(R.drawable.camera_instruct_light_on_white);
                NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=15&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                return;
            case R.id.btnHRec:
            case R.id.btnVideoRec:
                if (!this.isTakeVideo) {
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
                this.bSnap = true;
                return;
            case R.id.btnHVerticalRotate:
            case R.id.btnVerticalRotate:
                NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=10&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                return;
            case R.id.btnHVoice:
            case R.id.btnSoundPlay:
                if (!this.bSoundPlay) {
                    this.bSoundPlay = true;
                    soundPlayPressed();
                    return;
                }
                this.bSoundPlay = false;
                soundPlayUp();
                return;
            default:
                return;
        }
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
                    CameraPlayAty cameraPlayAty = CameraPlayAty.this;
                    TakeVideoThread unused = cameraPlayAty.takeVideoThread = new TakeVideoThread(cameraPlayAty.isH264Data, CameraPlayAty.this.strDID, 15, CameraPlayAty.this.nVideoWidth, CameraPlayAty.this.nVideoHeight, CameraPlayAty.this.videoWidthTarget, CameraPlayAty.this.videoHeightTarget);
                    CameraPlayAty.this.takeVideoThread.start();
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
                    CameraPlayAty.this.imgRecIcon.setVisibility(0);
                    CameraPlayAty.this.btnRecord.setImageResource(R.drawable.play_record_icon_green);
                    CameraPlayAty.this.btnHRec.setImageResource(R.drawable.play_record_icon_green);
                    CameraPlayAty.this.mHandler.postDelayed(CameraPlayAty.this.mRecRunnable, 500);
                    super.onPostExecute(voidR);
                }
            }.execute(new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    public void stopVideoRec() {
        if (this.isTakeVideo) {
            this.isTakeVideo = false;
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    CameraPlayAty.this.takeVideoThread.stopThread();
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
                    CameraPlayAty.this.btnRecord.setImageResource(R.drawable.play_record_icon_black);
                    CameraPlayAty.this.btnHRec.setImageResource(R.drawable.play_record_icon_white);
                    CameraPlayAty.this.imgRecIcon.setVisibility(4);
                    CameraPlayAty.this.showToast("/mnt/sdcard/LittleStars/video");
                    CameraPlayAty.this.mHandler.removeCallbacks(CameraPlayAty.this.mRecRunnable);
                    super.onPostExecute(voidR);
                }
            }.execute(new Void[0]);
        }
    }

    private void StartAudio() {
        synchronized (this) {
            this.bAudioStart = true;
            this.AudioBuffer.ClearAll();
            if (this.audioPlayer != null) {
                Log.e("###", "startPlayAudio");
                this.audioPlayer.AudioPlayStart();
            }
            NativeCaller.PPPPStartAudio(this.strDID);
        }
    }

    private void StopAudio() {
        synchronized (this) {
            this.bAudioStart = false;
            if (this.audioPlayer != null) {
                this.audioPlayer.AudioPlayStop();
            }
            this.AudioBuffer.ClearAll();
            NativeCaller.PPPPStopAudio(this.strDID);
        }
    }

    /* access modifiers changed from: private */
    public void soundPlayPressed() {
        this.btnHSoundPlay.setImageResource(R.drawable.sound_icon_green);
        this.btnSoundPlay.setImageResource(R.drawable.sound_icon_green);
        StartAudio();
    }

    /* access modifiers changed from: private */
    public void soundPlayUp() {
        this.btnHSoundPlay.setImageResource(R.drawable.sound_icon_white);
        this.btnSoundPlay.setImageResource(R.drawable.sound_icon_black);
        StopAudio();
    }

    public void screenHorizontal() {
        setRequestedOrientation(0);
    }

    public void screenVertical() {
        setRequestedOrientation(1);
    }

    private void doorBellOtherView() {
        this.shake = AnimationUtils.loadAnimation(this, R.anim.shake);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        if (intent != null) {
            this.OneBitmap = (Bitmap) intent.getParcelableExtra(ContentCommon.STR_CAMERA_SNAPSHOT);
            this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
            this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
            this.pushTypeInt = intent.getIntExtra("pushTypeInt", 3);
            this.pushUUID = intent.getStringExtra("pushUUID");
            this.p2pMode = intent.getIntExtra("modep", 1);
            this.samper = intent.getIntExtra("samper", 8000);
            SharedPreferences sharedPreferences = this.preAudio;
            this.AudioOrTalkType = sharedPreferences.getInt(this.strDID + "audiotalktype", 2);
            CommonUtil.Log(1, "samper:" + this.samper);
            String str = this.pushUUID;
            if (str == null || str.length() < 1) {
                this.pushUUID = (((int) (Math.random() * 900.0d)) + 100) + "";
            }
            if (this.strDID.length() <= 3) {
                return;
            }
            if (this.pushTypeInt == 3) {
                NativeCaller.StartPPPPLivestream(this.strDID, 20, this.pushUUID, SystemValue.videFram);
            } else {
                NativeCaller.StartPPPPLivestream(this.strDID, 22, this.pushUUID, SystemValue.videFram);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        StopHeat();
        super.onStop();
        if (this.bSoundPlay) {
            this.bSoundPlay = false;
            soundPlayUp();
        }
        if (this.isTakeVideo) {
            stopVideoRec();
            this.isTakeVideo = false;
            this.btnRecord.setImageResource(R.drawable.play_record_icon_black);
            this.btnHRec.setImageResource(R.drawable.play_record_icon_white);
            this.mHandler.removeCallbacks(this.mRecRunnable);
        }
        BmpUtils bmpUtils = this.mBmpUtils;
        if (bmpUtils != null) {
            bmpUtils.stop();
        }
        if (this.bSpeech) {
            this.bSpeech = false;
            this.btnVoiceSpeech.setImageResource(R.drawable.speech_icon_black);
            StopTalk();
        }
    }

    private void StartTalk() {
        String format = String.format("/decoder_control.cgi?command=21&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]);
        int i = this.AudioOrTalkType;
        if (i == 0 || i == 1) {
            NativeCaller.TransferMessage(this.strDID, format, 1);
            NativeCaller.PPPPStartTalk(this.strDID);
            return;
        }
        CustomAudioRecorder customAudioRecorder2 = this.customAudioRecorder;
        if (customAudioRecorder2 != null) {
            customAudioRecorder2.StartRecord();
            NativeCaller.TransferMessage(this.strDID, format, 1);
            NativeCaller.PPPPStartTalk(this.strDID);
        }
    }

    private void releaseTalk() {
        CustomAudioRecorder customAudioRecorder2;
        int i = this.AudioOrTalkType;
        if (i != 0 && i != 1 && (customAudioRecorder2 = this.customAudioRecorder) != null) {
            customAudioRecorder2.releaseRecord();
        }
    }

    private void StopTalk() {
        String format = String.format("/decoder_control.cgi?command=21&onestep=0&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]);
        int i = this.AudioOrTalkType;
        if (i == 0 || i == 1) {
            NativeCaller.PPPPStopTalk(this.strDID);
            NativeCaller.TransferMessage(this.strDID, format, 1);
            return;
        }
        CustomAudioRecorder customAudioRecorder2 = this.customAudioRecorder;
        if (customAudioRecorder2 != null) {
            customAudioRecorder2.StopRecord();
            NativeCaller.PPPPStopTalk(this.strDID);
            NativeCaller.TransferMessage(this.strDID, format, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void setResolution(int i) {
        Log.d("tag", "setResolution resolution:" + i);
        NativeCaller.PPPPCameraControl(this.strDID, 0, i);
        NativeCaller.PPPPGetSystemParams(this.strDID, 2);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    public void widget_init_with_h() {
        this.logUtils.e("screen set width");
        getWindow().getDecorView().setSystemUiVisibility(1028);
        getWindow().setStatusBarColor(0);
        this.lyScreenPortrait.setVisibility(4);
        this.lyScreenLand.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lyRecArea.getLayoutParams();
        layoutParams.topMargin = (int) getResources().getDimension(R.dimen.y30);
        layoutParams.leftMargin = (int) getResources().getDimension(R.dimen.x100);
        this.lyRecArea.setLayoutParams(layoutParams);
    }

    public void widget_init_with_v() {
        this.logUtils.e("screen set height");
        getWindow().getDecorView().setSystemUiVisibility(512);
        getWindow().setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
        this.lyScreenLand.setVisibility(4);
        this.lyScreenPortrait.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lyRecArea.getLayoutParams();
        layoutParams.topMargin = this.ly_status_bar.getHeight();
        layoutParams.leftMargin = 10;
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

    private boolean existSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* access modifiers changed from: protected */
    public float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    /* access modifiers changed from: protected */
    public float getScale() {
        return getScale(this.mSuppMatrix);
    }

    /* access modifiers changed from: protected */
    public float getValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    public boolean onDown(MotionEvent motionEvent) {
        Log.d("tag", "onDown");
        return false;
    }

    public void AudioRecordData(byte[] bArr, int i) {
        int i2;
        if (this.bAudioRecordStart && i > 0 && (i2 = this.AudioOrTalkType) != 0 && i2 != 1) {
            NativeCaller.PPPPTalkAudioData(this.strDID, bArr, i);
        }
    }

    public void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        CommonUtil.Log(1, "zhaogenghuai hzMode:" + i8);
        Message message = new Message();
        message.what = 3;
        this.mHandler.sendMessage(message);
    }

    public void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        TakeVideoThread takeVideoThread2;
        Log.e(LOG_TAG, "Call VideoData...h264Data: " + i + " len: " + i2 + " videobuf len: " + bArr.length);
        if (!str.endsWith(this.strDID) || !this.bDisplayFinished) {
            return;
        }
        if (bArr[0] != -1 || bArr[1] != -40) {
            Log.e(LOG_TAG, String.format("头部数据异常，数据长度：%d，videobuf[0]:%02x, videobuf[1]:%02x", new Object[]{Integer.valueOf(bArr.length), Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1])}));
        } else if (bArr[bArr.length - 7] == -1 && bArr[bArr.length - 6] == -39) {
            this.isH264Data = i;
            this.time = (long) i5;
            this.time1 = this.time * 1000;
            this.bDisplayFinished = false;
            this.videodata = bArr;
            this.videoDataLen = i2;
            Message message = new Message();
            if (i == 1) {
                this.nVideoWidth = i3;
                this.nVideoHeight = i4;
                if (this.isTakepic) {
                    this.isTakepic = false;
                    byte[] bArr2 = new byte[(i3 * i4 * 2)];
                    NativeCaller.YUV4202RGB565(bArr, bArr2, i3, i4);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr2);
                    this.mBmp = Bitmap.createBitmap(i3, i4, Bitmap.Config.RGB_565);
                    this.mBmp.copyPixelsFromBuffer(wrap);
                }
                this.isH264 = true;
                message.what = 1;
                this.isHigthVideo = true;
            } else {
                message.what = 2;
                if (this.isTakeVideo && (takeVideoThread2 = this.takeVideoThread) != null) {
                    takeVideoThread2.addVideo(bArr, 0, this.nVideoWidth, this.nVideoHeight);
                }
                this.isHigthVideo = false;
            }
            this.mHandler.sendMessage(message);
        } else {
            Log.e(LOG_TAG, String.format("尾部数据异常，数据长度：%d，videobuf[len - 7]:%02x, videobuf[len - 6]:%02x", new Object[]{Integer.valueOf(bArr.length), Byte.valueOf(bArr[bArr.length - 7]), Byte.valueOf(bArr[bArr.length - 6])}));
        }
    }

    public void callBackMessageNotify(String str, int i, int i2) {
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("MessageNotify did: " + str + " msgType: " + i + " param: " + i2);
        if (i != 0 || !str.equals(this.strDID)) {
            return;
        }
        if (i2 == 4) {
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(CameraPlayAty.this, "连接断开", 0).show();
                }
            });
            this.logUtils.e("###PPPP disconnect");
            Message message = new Message();
            message.what = 8;
            this.mHandler.sendMessage(message);
        } else if (i2 == 2) {
            this.logUtils.e("###PPPP connect success");
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(CameraPlayAty.this, "重新连接成功", 0).show();
                }
            });
            Message message2 = new Message();
            message2.what = 9;
            this.mHandler.sendMessage(message2);
        } else if (i2 == 3 || i2 == 5 || i2 == 6 || i2 == 7 || i2 == 8 || i2 == 9 || i2 == 10 || i2 == -1) {
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(CameraPlayAty.this, "重连失败", 0).show();
                }
            });
            this.logUtils.e("###PPPP connect fail");
            Message message3 = new Message();
            message3.what = 8;
            this.mHandler.sendMessage(message3);
        } else if (i2 == 0) {
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(CameraPlayAty.this, "重新连接中", 0).show();
                }
            });
        }
    }

    private class GetDataTask extends AsyncTask<Void, Void, Void> {
        private GetDataTask() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            if (!SystemValue.ISRUN) {
                BridgeService.isAppClose = false;
                Intent intent = new Intent();
                intent.setClass(CameraPlayAty.this, BridgeService.class);
                CameraPlayAty.this.startService(intent);
                Log.d("tagx", "SystemValue.ISRUN == false--and--server is run to");
                new Thread() {
                    public void run() {
                        NativeCaller.PPPPInitial(SystemValue.SystemSerVer, SystemValue.SystemSerVer.length());
                        NativeCaller.PPPPNetworkDetect();
                        NativeCaller.Init();
                        Log.e("tagx", "GetDataTask  Init");
                    }
                }.start();
            }
        }

        /* access modifiers changed from: private */
        public void StartCameraPPPP() {
            CameraPlayAty.this.runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(CameraPlayAty.this, "尝试重连", 0).show();
                }
            });
            CameraPlayAty cameraPlayAty = CameraPlayAty.this;
            cameraPlayAty.StartPPPP(cameraPlayAty.strDID, CameraPlayAty.this.preuser, CameraPlayAty.this.lockPwd, "test");
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            new Thread(new StopPPPPThread()).start();
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
        }

        class StopPPPPThread implements Runnable {
            StopPPPPThread() {
            }

            public void run() {
                try {
                    Thread.sleep(500);
                    GetDataTask.this.StartCameraPPPP();
                } catch (Exception unused) {
                }
            }
        }
    }

    public void callBackAudioData(byte[] bArr, int i) {
        TakeVideoThread takeVideoThread2;
        Log.e(LOG_TAG, "######AudioData: len :+ " + i);
        if (this.isTakeVideo && (takeVideoThread2 = this.takeVideoThread) != null) {
            takeVideoThread2.addAudio(bArr);
        }
        AudioPlayer audioPlayer2 = this.audioPlayer;
        if (audioPlayer2 == null || audioPlayer2.isAudioPlaying()) {
            this.logUtils.e("###you have recive a audio buffer");
            CustomBufferHead customBufferHead = new CustomBufferHead();
            CustomBufferData customBufferData = new CustomBufferData();
            customBufferHead.length = i;
            customBufferHead.startcode = AUDIO_BUFFER_START_CODE;
            customBufferData.head = customBufferHead;
            customBufferData.data = bArr;
            this.AudioBuffer.addData(customBufferData);
        }
    }

    public int getCameraParamsBean(String str) {
        new CameraParamsBean();
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            if (str.endsWith(SystemValue.arrayList.get(i).getDid())) {
                return i;
            }
        }
        return -1;
    }

    @SuppressLint({"ResourceType"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d("test", "MotionEvent:" + motionEvent.getAction());
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                Log.d("test", "zhaogenghuai1");
                switch (view.getId()) {
                    case R.id.btnHVoiceSpeech:
                    case R.id.btnVoiceSpeech:
                        this.bSpeech = false;
                        this.btnVoiceSpeech.setImageResource(R.drawable.speech_icon_black);
                        this.btnHVoiceSpeech.setImageResource(R.drawable.speech_icon_white);
                        VibratorUtil.Vibrate(this, 80);
                        StopTalk();
                        new AsyncTask<Void, Void, Void>() {
                            /* access modifiers changed from: protected */
                            public void onPreExecute() {
                            }

                            /* access modifiers changed from: protected */
                            public Void doInBackground(Void... voidArr) {
                                try {
                                    Thread.sleep(200);
                                    return null;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }

                            /* access modifiers changed from: protected */
                            public void onPostExecute(Void voidR) {
                                boolean unused = CameraPlayAty.this.bSoundPlay = true;
                                CameraPlayAty.this.soundPlayPressed();
                            }
                        }.execute(new Void[0]);
                        break;
                    case R.id.btnRoundDown:
                        if (this.shakeStatus == 2) {
                            this.btnRoundDown.setImageResource(R.drawable.play_down_icon_black);
                            NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=2&onestep=0&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                            this.shakeStatus = 0;
                            break;
                        }
                        break;
                    case R.id.btnRoundLeft:
                        if (this.shakeStatus == 3) {
                            this.btnRoundLeft.setImageResource(R.drawable.play_left_icon_black);
                            NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=4&onestep=0&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                            this.shakeStatus = 0;
                            break;
                        }
                        break;
                    case R.id.btnRoundRight:
                        if (this.shakeStatus == 4) {
                            this.btnRoundRight.setImageResource(R.drawable.play_right_icon_black);
                            NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=6&onestep=0&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                            this.shakeStatus = 0;
                            break;
                        }
                        break;
                    case R.id.btnRoundTop:
                        if (this.shakeStatus == 1) {
                            this.btnRoundUp.setImageResource(R.drawable.play_up_icon_black);
                            NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=0&onestep=0&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                            this.shakeStatus = 0;
                            break;
                        }
                        break;
                    case R.id.btn_doorbell_hz:
                        Log.d("test", "zhaogenghuai");
                        break;
                    case R.id.btn_doorbell_pic:
                        Log.d("test", "zhaogenghuai");
                        break;
                }
            } else if (action == 2) {
                view.getId();
            }
        } else {
            int id = view.getId();
            if (id != R.id.btnHVoiceSpeech && id != R.id.btnVoiceSpeech) {
                switch (id) {
                    case R.id.btnRoundDown:
                        if (this.shakeStatus == 0) {
                            this.shakeStatus = 2;
                            this.btnRoundDown.setImageResource(R.drawable.play_down_icon_green);
                            NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=2&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                            break;
                        }
                        break;
                    case R.id.btnRoundLeft:
                        if (this.shakeStatus == 0) {
                            this.shakeStatus = 3;
                            this.btnRoundLeft.setImageResource(R.drawable.play_left_icon_green);
                            NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=4&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                            break;
                        }
                        break;
                    case R.id.btnRoundRight:
                        if (this.shakeStatus == 0) {
                            this.shakeStatus = 4;
                            this.btnRoundRight.setImageResource(R.drawable.play_right_icon_green);
                            NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=6&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                            break;
                        }
                        break;
                    case R.id.btnRoundTop:
                        if (this.shakeStatus == 0) {
                            this.shakeStatus = 1;
                            this.btnRoundUp.setImageResource(R.drawable.play_up_icon_green);
                            NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=0&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
                            break;
                        }
                        break;
                }
            } else {
                this.bSpeech = true;
                this.btnVoiceSpeech.setImageResource(R.drawable.speech_icon_green);
                this.btnHVoiceSpeech.setImageResource(R.drawable.speech_icon_green);
                VibratorUtil.Vibrate(this, 80);
                this.bSoundPlay = false;
                soundPlayUp();
                StartTalk();
            }
        }
        return true;
    }

    public void callBackDoorBellSystemParm(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Log.e("test", "callBackDoorBellSystemParm: did:" + str + "  bell_on:" + i2 + "   bell_audio:" + i3 + "  bell_mode:" + i4 + "  max_watch:" + i5 + "  max_talk:" + i6 + "  max_wait:" + i7);
        if (i5 != 0 || i6 != 0) {
            if (this.pushTypeInt == 3) {
                this.cancelTime = i5;
                this.resettime = i5;
                if (i5 < 20) {
                    this.cancelTime = 20;
                    this.resettime = 20;
                    return;
                }
                return;
            }
            this.cancelTime = i6;
            this.resettime = i6;
            if (i6 < 20) {
                this.cancelTime = 20;
                this.resettime = 20;
            }
        }
    }

    public void CallBackAlermType(String str, int i) {
        Log.e("test", "CallBackAlermType:" + i);
        if (i == 7) {
            this.mHandler.sendEmptyMessage(1232);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        getWindow().getAttributes().flags |= 524288;
        this.logUtils.e("cameraPlayAty  onResume ");
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.acquire();
        }
        if (MainActivity.keyguardLock != null) {
            MainActivity.keyguardLock.disableKeyguard();
        }
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
        BmpUtils bmpUtils = this.mBmpUtils;
        if (bmpUtils != null) {
            bmpUtils.start();
        }
        setPic();
        NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=12&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
        NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=17&onestep=1&user=" + this.preuser + "&pwd=" + this.lockPwd, new Object[0]), 1);
        NativeCaller.PPPPGetSystemParams(this.strDID, 65);
    }

    public void callBackBatteryResult(int i) {
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("###当前电量:" + i);
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putInt("batteryLevel", i);
        message.what = 6;
        message.setData(bundle);
        this.mHandler.sendMessage(message);
    }

    public void setPic() {
        Cursor queryAllPicture = DataBaseHelper.getInstance(this).queryAllPicture(this.strDID);
        if (queryAllPicture.getCount() == 0) {
            Snap.snap.is_Toast = false;
            this.bSnap = true;
        }
        queryAllPicture.close();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.logUtils.e("###cameraPlayAty  onPause ");
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        releaseTalk();
        this.isCancel = false;
        this.isOneShow = true;
        SystemValue.isStartRun = false;
        if (this.pushTypeInt == 3) {
            NativeCaller.StartPPPPLivestream(this.strDID, 21, this.pushUUID, SystemValue.videFram);
        } else {
            NativeCaller.StartPPPPLivestream(this.strDID, 24, this.pushUUID, SystemValue.videFram);
        }
        StopAudio();
        NativeCaller.StartPPPPLivestream(this.strDID, 42, this.pushUUID, SystemValue.videFram);
        TakeVideoThread takeVideoThread2 = this.takeVideoThread;
        if (takeVideoThread2 != null) {
            takeVideoThread2.stopThread();
        }
        BridgeService.setDateTimeInterface((BridgeService.DateTimeInterface) null);
        BridgeService.setPlayInterface((BridgeService.PlayInterface) null);
        BridgeService.setDoorBellSystemParmInterface((BridgeService.DoorBellSystemParmInterface) null);
        BridgeService.setCameraBatteryInterface((BridgeService.CameraBatteryInterface) null);
        SystemValue.ISPLAY = 0;
        Bitmap bitmap = this.mBmp;
        if (bitmap != null) {
            bitmap.recycle();
            this.mBmp = null;
        }
        super.onDestroy();
        this.logUtils.e("###camera play stops!");
    }

    public void onBackPressed() {
        if (this.bScreenRotate) {
            this.btnHReturn.performClick();
            return;
        }
        this.logUtils.e("###onBackPressed");
        this.btnReturn.performClick();
    }

    public void OnBitmapFixed(final Bitmap bitmap) {
        runOnUiThread(new Runnable() {
            public void run() {
                CameraPlayAty.this.mHPlayView.setImageBitmap(bitmap);
            }
        });
    }
}
