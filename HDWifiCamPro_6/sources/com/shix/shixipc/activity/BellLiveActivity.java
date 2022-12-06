package com.shix.shixipc.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.text.format.Formatter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.CameraParmsModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.AudioPlayer;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.CustomAudioRecorder;
import com.shix.shixipc.utils.CustomBuffer;
import com.shix.shixipc.utils.CustomBufferData;
import com.shix.shixipc.utils.CustomBufferHead;
import com.shix.shixipc.utils.CustomVideoRecord;
import com.shix.shixipc.utils.TimeUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;

public class BellLiveActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener, NUIMainActivity.PlayInterface, NUIMainActivity.SHIXCOMMONInterface, CustomAudioRecorder.AudioRecordResult, NUIMainActivity.SnapShotInterface {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    private static final int QUERY_RECORD_FILE = 6;
    private static final int REFRESH_DEVICE_STATUS = 2;
    private static final int REFRESH_PLAY_STATUS = 1;
    private static final int REFRESH_PLAY_TIME = 0;
    private static final int REFRESH_RECORD_TIME = 4;
    private static final int REFRESH_TIMEBAR = 3;
    private static final int SHOW_CAMERA_DIRECTION = 5;
    private static final String TAG = "NDNCameraLiveActivity";
    private CustomBuffer AudioBuffer = null;
    private AlphaAnimation alphaAnimation;
    private AudioManager audioManager;
    private AudioPlayer audioPlayer = null;
    private long availableBlocks;
    private boolean bAudioRecordStart = false;
    /* access modifiers changed from: private */
    public boolean bDisplayFinished = true;
    private int bat_mode;
    /* access modifiers changed from: private */
    public int batcapacity;
    private int batstatus;
    private long blockSize;
    private Button btnTouch;
    private Button btn_config;
    private int callType = 0;
    CameraParmsModel cameraParmsModel;
    private int checkCount = 0;
    private int clickRs = 0;
    private long clickTimeDown = 0;
    private long clickTimeUp = 0;
    private CustomAudioRecorder customAudioRecorder = null;
    private CustomVideoRecord customVideoRecord = null;
    /* access modifiers changed from: private */
    public int devDecoderCount1 = 0;
    /* access modifiers changed from: private */
    public int devDecoderCount2 = 0;
    private Dialog dlgExit;
    private String dnAccount = "";
    private Button icut0;
    private Button icut1;
    private Button icut2;
    private ImageView im_audio;
    private ImageView im_more;
    private ImageView im_pic;
    private ImageView im_talk;
    private ImageView im_video;
    private boolean isAdmin = true;
    private boolean isAudio = false;
    private boolean isAudioClick = false;
    /* access modifiers changed from: private */
    public boolean isCheckVideo = false;
    /* access modifiers changed from: private */
    public boolean isDateComeOn = false;
    private boolean isExitActivity = false;
    private boolean isFullscreen = false;
    private boolean isGQ = false;
    /* access modifiers changed from: private */
    public int isH264Data = 0;
    /* access modifiers changed from: private */
    public boolean isOneShow = true;
    private boolean isOnpause = false;
    private boolean isPictSave = false;
    private boolean isRecordVideo = false;
    private boolean isTakeHead = false;
    private boolean isTakeVideo = false;
    /* access modifiers changed from: private */
    public boolean isTakepic = false;
    private boolean isVideo = false;
    boolean isircut = false;
    boolean isk = false;
    boolean ist = false;
    boolean iszsd = false;
    /* access modifiers changed from: private */
    public ImageView ivBattery;
    /* access modifiers changed from: private */
    public ImageView ivBatterying;
    private ImageView ivRecordTips;
    /* access modifiers changed from: private */
    public ImageView ivSingn;
    private int led_mode;
    private int light;
    private LinearLayout llRecordTips;
    private LinearLayout llSee_batmode;
    private LinearLayout llSee_videomode;
    private LinearLayout ll_audio;
    /* access modifiers changed from: private */
    public RelativeLayout ll_batstatus;
    private LinearLayout ll_more;
    private LinearLayout ll_pic;
    private LinearLayout ll_talk;
    private LinearLayout ll_video;
    private RelativeLayout lyHeader;
    /* access modifiers changed from: private */
    public Bitmap mBmp;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                if (BellLiveActivity.this.isOneShow) {
                    boolean unused = BellLiveActivity.this.isDateComeOn = true;
                    boolean unused2 = BellLiveActivity.this.isOneShow = false;
                    boolean unused3 = BellLiveActivity.this.isDateComeOn = true;
                    BellLiveActivity.this.findViewById(R.id.progressBar).setVisibility(8);
                    boolean unused4 = BellLiveActivity.this.isOneShow = false;
                }
                BellLiveActivity bellLiveActivity = BellLiveActivity.this;
                Bitmap unused5 = bellLiveActivity.mBmp = BitmapFactory.decodeByteArray(bellLiveActivity.videodata, 0, BellLiveActivity.this.videoDataLen);
                if (BellLiveActivity.this.mBmp == null) {
                    boolean unused6 = BellLiveActivity.this.bDisplayFinished = true;
                    return;
                }
                BellLiveActivity.this.getWindowManager().getDefaultDisplay().getWidth();
                BellLiveActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                BellLiveActivity bellLiveActivity2 = BellLiveActivity.this;
                int unused7 = bellLiveActivity2.nVideoWidth = bellLiveActivity2.mBmp.getWidth();
                BellLiveActivity bellLiveActivity3 = BellLiveActivity.this;
                int unused8 = bellLiveActivity3.nVideoHeight = bellLiveActivity3.mBmp.getHeight();
                BellLiveActivity.this.videoView.setImageBitmap(BellLiveActivity.this.mBmp);
                if (BellLiveActivity.this.isTakepic) {
                    boolean unused9 = BellLiveActivity.this.isTakepic = false;
                    BellLiveActivity bellLiveActivity4 = BellLiveActivity.this;
                    bellLiveActivity4.takePicture(bellLiveActivity4.mBmp);
                }
            } else if (i != 23) {
                if (i == 123321) {
                    BellLiveActivity.this.showToast((int) R.string.camera_not_online);
                    BellLiveActivity.this.finish();
                }
            } else if (BellLiveActivity.this.cameraParmsModel != null) {
                BellLiveActivity bellLiveActivity5 = BellLiveActivity.this;
                int unused10 = bellLiveActivity5.batcapacity = bellLiveActivity5.cameraParmsModel.getBatvalue();
                CommonUtil.Log(1, "batcapacity:" + BellLiveActivity.this.batcapacity);
                BellLiveActivity.this.ll_batstatus.setVisibility(0);
                BellLiveActivity.this.tv_Electricity.setText(BellLiveActivity.this.batcapacity + "%");
                ImageView access$2800 = BellLiveActivity.this.ivBattery;
                BellLiveActivity bellLiveActivity6 = BellLiveActivity.this;
                access$2800.setImageResource(bellLiveActivity6.getBatteryRes(bellLiveActivity6.batcapacity));
                CommonUtil.SaveCommonShare(BellLiveActivity.this, BellLiveActivity.this.strDID + "Batvalue", (String) null, BellLiveActivity.this.batcapacity);
                if (BellLiveActivity.this.cameraParmsModel.getBatstatus() == 1) {
                    BellLiveActivity.this.ivBatterying.setVisibility(0);
                } else {
                    BellLiveActivity.this.ivBatterying.setVisibility(4);
                }
                if (BellLiveActivity.this.batcapacity == -110) {
                    BellLiveActivity.this.tv_Electricity.setVisibility(8);
                    BellLiveActivity.this.ll_batstatus.setVisibility(8);
                    BellLiveActivity.this.ivBattery.setVisibility(8);
                    BellLiveActivity.this.ivSingn.setVisibility(8);
                    BellLiveActivity.this.ivBatterying.setVisibility(8);
                }
            }
            if (message.what == 1 || message.what == 2) {
                boolean unused11 = BellLiveActivity.this.bDisplayFinished = true;
                if (BellLiveActivity.this.isH264Data == 0) {
                    Date date = new Date(System.currentTimeMillis());
                    BellLiveActivity.this.tv_name1.setText("" + BellLiveActivity.this.simpleDateFormat.format(date));
                }
            }
        }
    };
    private WifiManager mWifiManager;
    /* access modifiers changed from: private */
    public int nVideoHeight = 0;
    /* access modifiers changed from: private */
    public int nVideoWidth = 0;
    private File path = null;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_Icut;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_hight;
    private View popv_hight;
    private View popv_icut;
    private SharedPreferences preRet;
    int product_model = 0;
    int product_type = 0;
    /* access modifiers changed from: private */
    public int recordTime;
    /* access modifiers changed from: private */
    public Handler refreshUIHandler = new Handler() {
        /* access modifiers changed from: protected */
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public void handleMessage(Message message) {
            if (message.what == 4) {
                BellLiveActivity.access$408(BellLiveActivity.this);
                BellLiveActivity.this.tvRecordTime.setText(TimeUtil.getTimeDesc(BellLiveActivity.this.recordTime));
                BellLiveActivity.this.refreshUIHandler.sendEmptyMessageDelayed(4, 1000);
            }
        }
    };
    private Dialog restartDialog;
    int ret = 0;
    private String sdAvail = null;
    private String sdSize = null;
    private int shixUtcOffset = 28800;
    private LinearLayout shix_LL_buttom;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private StatFs stat;
    private String status = null;
    /* access modifiers changed from: private */
    public String strDID = null;
    private String strName = null;
    private String strPwd = null;
    private String strUser = null;
    public String strVideoName = "";
    private int timeCount = 0;
    private long totalBlocks;
    /* access modifiers changed from: private */
    public TextView tvRecordTime;
    /* access modifiers changed from: private */
    public TextView tv_Electricity;
    private TextView tv_audio;
    private TextView tv_info;
    private TextView tv_more;
    TextView tv_name1;
    TextView tv_name2;
    private TextView tv_pic;
    private TextView tv_talk;
    private TextView tv_video;
    private TextView tv_zsd;
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    /* access modifiers changed from: private */
    public ImageView videoView;
    /* access modifiers changed from: private */
    public byte[] videodata = null;
    private long videotime = 0;
    private View viewSee_batmode;
    private View viewSee_videomode;

    private void initListen() {
    }

    public void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
    }

    public void callBackConnectLook(String str, int i, int i2) {
    }

    public int getBatteryRes(int i) {
        return i >= 90 ? R.mipmap.home_power_100 : i >= 60 ? R.mipmap.home_power_80 : i >= 40 ? R.mipmap.home_power_60 : i >= 20 ? R.mipmap.home_power_40 : R.mipmap.home_power_20;
    }

    static /* synthetic */ int access$408(BellLiveActivity bellLiveActivity) {
        int i = bellLiveActivity.recordTime;
        bellLiveActivity.recordTime = i + 1;
        return i;
    }

    private void initExitDialog() {
        this.dlgExit = new Dialog(this, R.style.customDialog);
        this.dlgExit.setContentView(R.layout.dialog_exit_play);
        this.dlgExit.findViewById(R.id.tvCancel).setOnClickListener(this);
        this.dlgExit.findViewById(R.id.tvExit).setOnClickListener(this);
    }

    class CheckThread extends Thread {
        CheckThread() {
        }

        public void run() {
            super.run();
            while (BellLiveActivity.this.isCheckVideo && BellLiveActivity.this.isCheckVideo) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                BellLiveActivity bellLiveActivity = BellLiveActivity.this;
                int unused = bellLiveActivity.devDecoderCount2 = bellLiveActivity.devDecoderCount1;
                int unused2 = BellLiveActivity.this.devDecoderCount1 = 0;
                if (BellLiveActivity.this.isCheckVideo) {
                    BellLiveActivity.this.mHandler.sendEmptyMessage(1234);
                } else {
                    return;
                }
            }
        }
    }

    private String getWifiSSID() {
        this.mWifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (!this.mWifiManager.isWifiEnabled()) {
            return "";
        }
        String ssid = this.mWifiManager.getConnectionInfo().getSSID();
        return (!ssid.startsWith("\"") || !ssid.endsWith("\"")) ? ssid : ssid.substring(1, ssid.length() - 1);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(128, 128);
        setContentView(R.layout.activity_camera_live_bell);
        this.isDateComeOn = false;
        getDataFromOther();
        this.preRet = getSharedPreferences(ContentCommon.SHIX_SHARE_BAT, 0);
        this.audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.isExitActivity = false;
        initView();
        initAnim();
        initExitPopupWindow_Hight();
        initExitPopupWindow_Icut();
        initListen();
        initExitDialog();
        NUIMainActivity.setPlayInterface(this);
        if (this.callType != 0) {
            NativeCaller.StartPPPPLivestream(this.strDID, 1);
        } else {
            NUIMainActivity.setSnapShotInterface(this);
            NativeCaller.TransferMessage(this.strDID, CommonUtil.getSnapshot(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        }
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.SHIX_getSPKMICParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getCameraParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        this.customVideoRecord = new CustomVideoRecord(this.strDID);
        this.status = Environment.getExternalStorageState();
        if (this.status.equals("mounted")) {
            try {
                this.path = CommonUtil.getSDFilePath();
                this.stat = new StatFs(this.path.getPath());
                this.blockSize = (long) this.stat.getBlockSize();
                this.totalBlocks = (long) this.stat.getBlockCount();
                this.availableBlocks = (long) this.stat.getAvailableBlocks();
                this.sdSize = formatSize(this.totalBlocks * this.blockSize);
                this.sdAvail = formatSize(this.availableBlocks * this.blockSize);
            } catch (IllegalArgumentException unused) {
                this.status = "removed";
            }
        }
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this.AudioBuffer);
        this.customAudioRecorder = new CustomAudioRecorder(this);
        StartAudio();
    }

    private String formatSize(long j) {
        return Formatter.formatFileSize(this, j);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        if (intent != null) {
            this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
            this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
            this.strUser = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
            this.strPwd = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
            this.callType = intent.getIntExtra("callType", 0);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (getResources().getConfiguration().orientation == 1) {
            this.isFullscreen = false;
            this.isCheckVideo = true;
            new CheckThread().start();
            if (SystemValue.isApMode) {
                this.btn_config.setVisibility(0);
            } else {
                this.btn_config.setVisibility(8);
            }
        } else {
            this.isCheckVideo = false;
            this.isFullscreen = true;
            this.btn_config.setVisibility(8);
        }
    }

    private void initAnim() {
        this.alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.alphaAnimation.setDuration(500);
        this.alphaAnimation.setRepeatMode(2);
        this.alphaAnimation.setRepeatCount(-1);
    }

    private void showRecordTimeTips() {
        this.llRecordTips.setVisibility(0);
        this.refreshUIHandler.sendMessageDelayed(this.refreshUIHandler.obtainMessage(4), 1000);
        this.tvRecordTime.setText("00:00");
        this.recordTime = 0;
        this.ivRecordTips.startAnimation(this.alphaAnimation);
    }

    private void hideRecordTimeTips() {
        this.ivRecordTips.clearAnimation();
        this.refreshUIHandler.removeMessages(4);
        this.llRecordTips.setVisibility(4);
    }

    private void initView() {
        this.btn_config = (Button) findViewById(R.id.btn_config);
        this.tv_zsd = (TextView) findViewById(R.id.tv_zsd);
        this.videoView = (ImageView) findViewById(R.id.videoView);
        ((TextView) findViewById(R.id.tvHeaderTitle)).setText(this.strName);
        this.tv_name1 = (TextView) findViewById(R.id.tv_name1);
        this.tv_name2 = (TextView) findViewById(R.id.tv_name2);
        this.tv_Electricity = (TextView) findViewById(R.id.tv_Electricity);
        this.ivBattery = (ImageView) findViewById(R.id.ivBattery);
        this.ivBatterying = (ImageView) findViewById(R.id.ivBatterying);
        this.ivSingn = (ImageView) findViewById(R.id.ivSingn);
        this.tv_info = (TextView) findViewById(R.id.tv_info);
        int i = this.callType;
        if (i == 0) {
            TextView textView = this.tv_info;
            textView.setText(getResources().getString(R.string.bell_call_audio) + "" + getResources().getString(R.string.bell_call_mode));
        } else if (i == 1) {
            TextView textView2 = this.tv_info;
            textView2.setText(getResources().getString(R.string.bell_call_video) + "" + getResources().getString(R.string.bell_call_mode));
        } else {
            this.tv_info.setVisibility(8);
        }
        this.btnTouch = (Button) findViewById(R.id.btnTouch);
        this.btnTouch.setOnClickListener(this);
        this.ll_batstatus = (RelativeLayout) findViewById(R.id.ll_batstatus);
        this.llRecordTips = (LinearLayout) findViewById(R.id.llRecordTips);
        this.ivRecordTips = (ImageView) this.llRecordTips.findViewById(R.id.ivRecordTips);
        this.tvRecordTime = (TextView) this.llRecordTips.findViewById(R.id.tvRecordTime);
        this.shix_LL_buttom = (LinearLayout) findViewById(R.id.shix_LL_buttom);
        this.lyHeader = (RelativeLayout) findViewById(R.id.lyHeader);
        this.ll_video = (LinearLayout) findViewById(R.id.ll_video);
        this.ll_pic = (LinearLayout) findViewById(R.id.ll_pic);
        this.ll_talk = (LinearLayout) findViewById(R.id.ll_talk);
        this.ll_audio = (LinearLayout) findViewById(R.id.ll_audio);
        this.ll_more = (LinearLayout) findViewById(R.id.ll_more);
        this.im_video = (ImageView) findViewById(R.id.im_video);
        this.im_pic = (ImageView) findViewById(R.id.im_pic);
        this.im_talk = (ImageView) findViewById(R.id.im_talk);
        this.im_audio = (ImageView) findViewById(R.id.im_audio);
        this.im_more = (ImageView) findViewById(R.id.im_more);
        this.tv_video = (TextView) findViewById(R.id.tv_video);
        this.tv_pic = (TextView) findViewById(R.id.tv_pic);
        this.tv_talk = (TextView) findViewById(R.id.tv_talk);
        this.tv_audio = (TextView) findViewById(R.id.tv_audio);
        this.tv_more = (TextView) findViewById(R.id.tv_more);
        findViewById(R.id.ivOperator1).setOnClickListener(this);
        findViewById(R.id.ivOperator).setOnClickListener(this);
        this.ll_video.setOnClickListener(this);
        this.ll_pic.setOnClickListener(this);
        this.ll_talk.setOnClickListener(this);
        this.ll_audio.setOnClickListener(this);
        this.ll_more.setOnClickListener(this);
        this.btn_config.setOnClickListener(this);
        this.ll_video.setOnTouchListener(this);
        this.ll_pic.setOnTouchListener(this);
        this.ll_talk.setOnTouchListener(this);
        this.ll_audio.setOnTouchListener(this);
        this.ll_more.setOnTouchListener(this);
        findViewById(R.id.ivBack).setOnClickListener(this);
        if (getResources().getConfiguration().orientation == 1) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.75f));
            layoutParams.gravity = 48;
            this.videoView.setLayoutParams(layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.75f), -1);
            layoutParams2.gravity = 17;
            this.videoView.setLayoutParams(layoutParams2);
        }
        this.btnTouch.setVisibility(0);
        if (this.callType == 0) {
            findViewById(R.id.ll_video).setVisibility(8);
            findViewById(R.id.ll_pic).setVisibility(8);
            findViewById(R.id.ll_audio).setVisibility(8);
            findViewById(R.id.ll_more).setVisibility(8);
            this.tv_name1.setVisibility(8);
            this.tv_name2.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        StopAudio();
        StopTalk();
        releaseTalk();
        SystemValue.isCallIng = false;
        CustomVideoRecord customVideoRecord2 = this.customVideoRecord;
        if (customVideoRecord2 != null) {
            customVideoRecord2.stopRecordVideo();
        }
        NUIMainActivity.setSnapShotInterface((NUIMainActivity.SnapShotInterface) null);
        NativeCaller.StopPPPPLivestream(this.strDID);
        NUIMainActivity.setPlayInterface((NUIMainActivity.PlayInterface) null);
        this.isExitActivity = true;
        this.isTakeHead = false;
        this.isCheckVideo = false;
        if (!this.isDateComeOn) {
            NativeCaller.StopPPPP(this.strDID);
            StartPPPP(this.strDID, this.strUser, this.strPwd);
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 1) {
            this.isFullscreen = false;
            this.lyHeader.setVisibility(0);
            this.shix_LL_buttom.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.5625f));
            layoutParams.gravity = 17;
            this.btnTouch.setLayoutParams(layoutParams);
            this.ll_batstatus.setLayoutParams(layoutParams);
            this.btnTouch.setVisibility(0);
            return;
        }
        this.isFullscreen = true;
        this.lyHeader.setVisibility(8);
        this.shix_LL_buttom.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 49;
        this.btnTouch.setLayoutParams(layoutParams2);
        this.btnTouch.setVisibility(0);
    }

    private void toggleFullscreen(boolean z) {
        if (z) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        switch (view.getId()) {
            case R.id.btn_config:
                Intent intent = new Intent(this, SettingWifiActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
                startActivity(intent);
                finish();
                return;
            case R.id.btn_full:
                CommonUtil.Log(1, "zhaogenghuaiclick btn_full isFullscreen:" + this.isFullscreen);
                if (!this.isFullscreen) {
                    this.isFullscreen = true;
                    toggleFullscreen(true);
                    return;
                }
                this.isFullscreen = false;
                toggleFullscreen(false);
                return;
            case R.id.icut0:
                this.popupWindow_Icut.dismiss();
                if (this.cameraParmsModel != null) {
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "icut", 0), 0);
                    this.cameraParmsModel.setIcut(0);
                    this.icut0.setTextColor(getResources().getColor(R.color.color_n_status_offline));
                    this.icut1.setTextColor(getResources().getColor(R.color.color_white));
                    this.icut2.setTextColor(getResources().getColor(R.color.color_white));
                    return;
                }
                return;
            case R.id.icut1:
                this.popupWindow_Icut.dismiss();
                NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "icut", 1), 0);
                this.cameraParmsModel.setIcut(1);
                this.icut1.setTextColor(getResources().getColor(R.color.color_n_status_offline));
                this.icut0.setTextColor(getResources().getColor(R.color.color_white));
                this.icut2.setTextColor(getResources().getColor(R.color.color_white));
                return;
            case R.id.icut2:
                this.popupWindow_Icut.dismiss();
                NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "icut", 2), 0);
                this.cameraParmsModel.setIcut(2);
                this.icut2.setTextColor(getResources().getColor(R.color.color_n_status_offline));
                this.icut0.setTextColor(getResources().getColor(R.color.color_white));
                this.icut1.setTextColor(getResources().getColor(R.color.color_white));
                return;
            case R.id.im_ircut:
                this.popupWindow_Icut.showAsDropDown(this.tv_name2, 0, 60);
                return;
            case R.id.im_k:
                this.popupWindow_hight.showAsDropDown(this.tv_name2, 0, 100);
                return;
            case R.id.ivBack:
                if (this.isTakeVideo) {
                    showToast((int) R.string.ptz_takevideo_show);
                    return;
                }
                returnLastBmp2Home();
                this.dlgExit.show();
                return;
            case R.id.ivOperator1:
                Intent intent2 = new Intent(this, SettingActivity.class);
                intent2.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent2.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
                startActivity(intent2);
                finish();
                return;
            case R.id.tvCancel:
                this.dlgExit.dismiss();
                return;
            case R.id.tvExit:
                this.refreshUIHandler.removeCallbacksAndMessages((Object) null);
                this.dlgExit.dismiss();
                Intent intent3 = new Intent(this, NUIMainActivity.class);
                intent3.setFlags(67108864);
                startActivity(intent3);
                finish();
                return;
            default:
                return;
        }
    }

    private boolean touchView(View view, int i) {
        switch (view.getId()) {
            case R.id.ll_audio:
                if (i == 0) {
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(this, 10);
                    }
                    if (!this.isAudio) {
                        StartAudio();
                        this.isAudioClick = true;
                        this.tv_audio.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                        this.im_audio.setImageResource(R.mipmap.n_audios1);
                        break;
                    } else {
                        StopAudio();
                        this.isAudioClick = false;
                        this.im_audio.setImageResource(R.mipmap.n_audios2);
                        this.tv_audio.setTextColor(getResources().getColor(R.color.color_play_toptext));
                        break;
                    }
                }
                break;
            case R.id.ll_more:
                if (i == 0) {
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(this, 10);
                    }
                    if (CommonUtil.SHIX_isBkDid(this.strDID).booleanValue()) {
                        this.im_more.setImageResource(R.mipmap.n_play_buttom_more);
                    } else {
                        this.im_more.setImageResource(R.mipmap.n_play_buttom_more);
                    }
                    this.tv_more.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                } else {
                    this.im_more.setImageResource(R.mipmap.n_play_buttom_more);
                    this.tv_more.setTextColor(getResources().getColor(R.color.color_play_toptext));
                }
                Intent intent = new Intent(this, TfFilesActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
                intent.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_pic:
                if (i != 0) {
                    this.im_pic.setImageResource(R.mipmap.n_play_buttom_pic);
                    this.tv_pic.setTextColor(getResources().getColor(R.color.color_play_toptext));
                    break;
                } else {
                    try {
                        MediaPlayer.create(this, R.raw.photoshutter).start();
                    } catch (Exception unused) {
                    }
                    this.im_pic.setImageResource(R.mipmap.n_play_buttom_pic);
                    this.isTakepic = true;
                    break;
                }
            case R.id.ll_talk:
                if (i != 0) {
                    this.clickTimeUp = System.currentTimeMillis();
                    this.im_talk.setImageResource(R.mipmap.n_play_buttom_talking);
                    this.tv_talk.setTextColor(getResources().getColor(R.color.color_play_toptext));
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.startTalk(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 0), 0);
                    StopTalk();
                    if (this.isAudioClick) {
                        StartAudio();
                        this.tv_audio.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                        this.im_audio.setImageResource(R.mipmap.n_audios1);
                        break;
                    }
                } else {
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(this, 10);
                    }
                    this.clickTimeDown = System.currentTimeMillis();
                    this.im_talk.setImageResource(R.mipmap.n_play_buttom_talk);
                    this.tv_talk.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                    if (this.isAudioClick) {
                        StopAudio();
                        this.im_audio.setImageResource(R.mipmap.n_audios2);
                        this.tv_audio.setTextColor(getResources().getColor(R.color.color_play_toptext));
                    }
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.startTalk(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 1), 0);
                    StartTalk();
                    break;
                }
                break;
            case R.id.ll_video:
                if (i == 0) {
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(this, 10);
                    }
                    if (!this.isTakeVideo) {
                        this.im_video.setImageResource(R.mipmap.n_play_buttom_videoing);
                        this.tv_video.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                        showRecordTimeTips();
                        this.stat = new StatFs(this.path.getPath());
                        this.availableBlocks = (long) this.stat.getAvailableBlocks();
                        this.sdAvail = formatSize(this.availableBlocks * this.blockSize);
                        if ((this.availableBlocks * this.blockSize) / 1048576 >= 50) {
                            this.isTakeVideo = true;
                            SystemValue.checkSDStatu = 1;
                            if (!this.customVideoRecord.isRecordVideo()) {
                                String fileNameWithTime = CommonUtil.getFileNameWithTime(2);
                                this.videotime = new Date().getTime();
                                if (this.isH264Data == 1) {
                                    this.customVideoRecord.startRecordVideo(1, fileNameWithTime);
                                } else {
                                    this.customVideoRecord.startRecordVideo(2, fileNameWithTime);
                                }
                                saveVideoHead(fileNameWithTime);
                                break;
                            } else {
                                return true;
                            }
                        } else {
                            showToastLong(R.string.sd_card_size_show);
                            return false;
                        }
                    } else {
                        this.im_video.setImageResource(R.mipmap.n_play_buttom_video);
                        this.tv_video.setTextColor(getResources().getColor(R.color.color_play_toptext));
                        hideRecordTimeTips();
                        this.isTakeVideo = false;
                        CustomVideoRecord customVideoRecord2 = this.customVideoRecord;
                        if (customVideoRecord2 != null) {
                            customVideoRecord2.stopRecordVideo();
                            break;
                        }
                    }
                }
                break;
        }
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            return touchView(view, 0);
        }
        if (action != 1) {
            return false;
        }
        return touchView(view, 1);
    }

    private void saveVideoHead(String str) {
        if (this.videodata != null && str != null && str.length() > 5) {
            this.strVideoName = "IMG_" + str.replace("avi", "jpg");
            new Thread() {
                public void run() {
                    if (BellLiveActivity.this.isH264Data == 1) {
                        byte[] bArr = new byte[(BellLiveActivity.this.nVideoWidth * BellLiveActivity.this.nVideoHeight * 2)];
                        NativeCaller.YUV4202RGB565(BellLiveActivity.this.videodata, bArr, BellLiveActivity.this.nVideoWidth, BellLiveActivity.this.nVideoHeight);
                        ByteBuffer wrap = ByteBuffer.wrap(bArr);
                        BellLiveActivity bellLiveActivity = BellLiveActivity.this;
                        Bitmap unused = bellLiveActivity.mBmp = Bitmap.createBitmap(bellLiveActivity.nVideoWidth, BellLiveActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                        BellLiveActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                        if (BellLiveActivity.this.mBmp != null) {
                            File sDFilePath = CommonUtil.getSDFilePath();
                            File file = new File(sDFilePath, "HDWiFiCam/videohead/" + BellLiveActivity.this.strDID);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(new File(file, BellLiveActivity.this.strVideoName));
                                if (BellLiveActivity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (BellLiveActivity.this.mBmp != null) {
                        File sDFilePath2 = CommonUtil.getSDFilePath();
                        File file2 = new File(sDFilePath2, "HDWiFiCam/videohead/" + BellLiveActivity.this.strDID);
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file2, BellLiveActivity.this.strVideoName));
                            if (BellLiveActivity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream2)) {
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }

    private void returnLastBmp2Home() {
        if (this.videodata != null) {
            new Thread() {
                public void run() {
                    if (BellLiveActivity.this.isH264Data == 1) {
                        byte[] bArr = new byte[(BellLiveActivity.this.nVideoWidth * BellLiveActivity.this.nVideoHeight * 2)];
                        NativeCaller.YUV4202RGB565(BellLiveActivity.this.videodata, bArr, BellLiveActivity.this.nVideoWidth, BellLiveActivity.this.nVideoHeight);
                        ByteBuffer wrap = ByteBuffer.wrap(bArr);
                        BellLiveActivity bellLiveActivity = BellLiveActivity.this;
                        Bitmap unused = bellLiveActivity.mBmp = Bitmap.createBitmap(bellLiveActivity.nVideoWidth, BellLiveActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                        BellLiveActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                        if (BellLiveActivity.this.mBmp != null) {
                            File file = new File(CommonUtil.getSDFilePath(), "HDWiFiCam/picid");
                            File file2 = new File(file, BellLiveActivity.this.strDID + ".jpg");
                            if (file2.exists()) {
                                Log.d("first_pic", file2.delete() + "");
                            }
                            BellLiveActivity bellLiveActivity2 = BellLiveActivity.this;
                            bellLiveActivity2.setBitMapToBean(bellLiveActivity2.strDID, BellLiveActivity.this.mBmp);
                            BellLiveActivity bellLiveActivity3 = BellLiveActivity.this;
                            bellLiveActivity3.saveBmpToSDcard(bellLiveActivity3.strDID, BellLiveActivity.this.mBmp);
                        }
                    } else if (BellLiveActivity.this.mBmp != null) {
                        File file3 = new File(CommonUtil.getSDFilePath(), "HDWiFiCam/picid");
                        File file4 = new File(file3, BellLiveActivity.this.strDID + ".jpg");
                        if (file4.exists()) {
                            Log.d("first_pic", file4.delete() + "");
                        }
                        BellLiveActivity bellLiveActivity4 = BellLiveActivity.this;
                        bellLiveActivity4.setBitMapToBean(bellLiveActivity4.strDID, BellLiveActivity.this.mBmp);
                        BellLiveActivity bellLiveActivity5 = BellLiveActivity.this;
                        bellLiveActivity5.saveBmpToSDcard(bellLiveActivity5.strDID, BellLiveActivity.this.mBmp);
                    }
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    public void setBitMapToBean(String str, Bitmap bitmap) {
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            if (str != null) {
                str.equals(SystemValue.arrayList.get(i).getDev_Did());
            }
        }
    }

    /* access modifiers changed from: private */
    public void saveBmpToSDcard(String str, Bitmap bitmap) {
        File file = new File(CommonUtil.getSDFilePath(), "HDWiFiCam/picid");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str + ".jpg"));
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initExitPopupWindow_Icut() {
        this.popv_icut = LayoutInflater.from(this).inflate(R.layout.popup_icut, (ViewGroup) null);
        this.icut0 = (Button) this.popv_icut.findViewById(R.id.icut0);
        this.icut0.setOnClickListener(this);
        this.icut1 = (Button) this.popv_icut.findViewById(R.id.icut1);
        this.icut1.setOnClickListener(this);
        this.icut2 = (Button) this.popv_icut.findViewById(R.id.icut2);
        this.icut2.setOnClickListener(this);
        this.popupWindow_Icut = new PopupWindow(this.popv_icut, -2, -2);
        this.popupWindow_Icut.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_Icut.setFocusable(true);
        this.popupWindow_Icut.setInputMethodMode(1);
        this.popupWindow_Icut.setSoftInputMode(16);
        this.popupWindow_Icut.setOutsideTouchable(true);
        this.popupWindow_Icut.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_icut.setFocusableInTouchMode(true);
        this.popv_icut.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 82) {
                    return false;
                }
                BellLiveActivity.this.popupWindow_Icut.dismiss();
                return false;
            }
        });
        this.popupWindow_Icut.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                BellLiveActivity.this.popupWindow_Icut.dismiss();
            }
        });
        this.popupWindow_Icut.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                BellLiveActivity.this.popupWindow_Icut.dismiss();
                return false;
            }
        });
    }

    public void initExitPopupWindow_Hight() {
        this.popv_hight = LayoutInflater.from(this).inflate(R.layout.popup_4k, (ViewGroup) null);
        this.popv_hight.findViewById(R.id.button_4k).setOnClickListener(this);
        this.popv_hight.findViewById(R.id.button_2k).setOnClickListener(this);
        this.popv_hight.findViewById(R.id.button_1080).setOnClickListener(this);
        this.popupWindow_hight = new PopupWindow(this.popv_hight, -2, -2);
        this.popupWindow_hight.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_hight.setFocusable(true);
        this.popupWindow_hight.setInputMethodMode(1);
        this.popupWindow_hight.setSoftInputMode(16);
        this.popupWindow_hight.setOutsideTouchable(true);
        this.popupWindow_hight.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_hight.setFocusableInTouchMode(true);
        this.popv_hight.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 82) {
                    return false;
                }
                BellLiveActivity.this.popupWindow_hight.dismiss();
                return false;
            }
        });
        this.popupWindow_hight.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                BellLiveActivity.this.popupWindow_hight.dismiss();
            }
        });
        this.popupWindow_hight.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                BellLiveActivity.this.popupWindow_hight.dismiss();
                return false;
            }
        });
    }

    private void StartAudio() {
        synchronized (this) {
            this.AudioBuffer.ClearAll();
            this.audioPlayer.AudioPlayStart();
            NativeCaller.PPPPStartAudio(this.strDID);
            this.isAudio = true;
        }
    }

    private void StopAudio() {
        synchronized (this) {
            this.audioPlayer.AudioPlayStop();
            this.AudioBuffer.ClearAll();
            NativeCaller.PPPPStopAudio(this.strDID);
            this.isAudio = false;
        }
    }

    private void StartTalk() {
        CustomAudioRecorder customAudioRecorder2 = this.customAudioRecorder;
        if (customAudioRecorder2 != null) {
            customAudioRecorder2.StartRecord();
            this.bAudioRecordStart = true;
            NativeCaller.PPPPStartTalk(this.strDID);
        }
    }

    private void StopTalk() {
        CustomAudioRecorder customAudioRecorder2 = this.customAudioRecorder;
        if (customAudioRecorder2 != null) {
            this.bAudioRecordStart = false;
            customAudioRecorder2.StopRecord();
            NativeCaller.PPPPStopTalk(this.strDID);
        }
    }

    private void releaseTalk() {
        CustomAudioRecorder customAudioRecorder2 = this.customAudioRecorder;
        if (customAudioRecorder2 != null) {
            this.bAudioRecordStart = false;
            customAudioRecorder2.releaseRecord();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.isFullscreen) {
            toggleFullscreen(false);
            this.isFullscreen = false;
            return true;
        } else if (this.isTakeVideo) {
            showToast((int) R.string.ptz_takevideo_show);
            return true;
        } else {
            returnLastBmp2Home();
            this.dlgExit.show();
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void takePicture(final Bitmap bitmap) {
        if (!this.isPictSave) {
            this.isPictSave = true;
            new Thread() {
                public void run() {
                    BellLiveActivity.this.savePicToSDcard(bitmap);
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088 A[SYNTHETIC, Splitter:B:27:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0094 A[SYNTHETIC, Splitter:B:35:0x0094] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0090=Splitter:B:32:0x0090, B:14:0x0052=Splitter:B:14:0x0052, B:9:0x004b=Splitter:B:9:0x004b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void savePicToSDcard(android.graphics.Bitmap r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = r7.getStrDate()     // Catch:{ all -> 0x009d }
            r1 = 10
            r2 = 0
            r0.substring(r2, r1)     // Catch:{ all -> 0x009d }
            r0 = 0
            java.lang.String r1 = com.shix.shixipc.utils.CommonUtil.getFileNameWithTime(r2)     // Catch:{ all -> 0x009d }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x005e }
            java.io.File r4 = com.shix.shixipc.utils.CommonUtil.getSDFilePath()     // Catch:{ Exception -> 0x005e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005e }
            r5.<init>()     // Catch:{ Exception -> 0x005e }
            java.lang.String r6 = "HDWiFiCam/Snapshot/"
            r5.append(r6)     // Catch:{ Exception -> 0x005e }
            java.lang.String r6 = r7.strDID     // Catch:{ Exception -> 0x005e }
            r5.append(r6)     // Catch:{ Exception -> 0x005e }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x005e }
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x005e }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x005e }
            r4.<init>(r3, r1)     // Catch:{ Exception -> 0x005e }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005e }
            r1.<init>(r4)     // Catch:{ Exception -> 0x005e }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r3 = 100
            boolean r8 = r8.compress(r0, r3, r1)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            if (r8 == 0) goto L_0x004b
            r1.flush()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            com.shix.shixipc.activity.BellLiveActivity$11 r8 = new com.shix.shixipc.activity.BellLiveActivity$11     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r8.<init>()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r7.runOnUiThread(r8)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
        L_0x004b:
            r7.isPictSave = r2     // Catch:{ all -> 0x009d }
            r1.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x008e
        L_0x0051:
            r8 = move-exception
        L_0x0052:
            r8.printStackTrace()     // Catch:{ all -> 0x009d }
            goto L_0x008e
        L_0x0056:
            r8 = move-exception
            r0 = r1
            goto L_0x0090
        L_0x0059:
            r8 = move-exception
            r0 = r1
            goto L_0x005f
        L_0x005c:
            r8 = move-exception
            goto L_0x0090
        L_0x005e:
            r8 = move-exception
        L_0x005f:
            com.shix.shixipc.activity.BellLiveActivity$12 r1 = new com.shix.shixipc.activity.BellLiveActivity$12     // Catch:{ all -> 0x005c }
            r1.<init>()     // Catch:{ all -> 0x005c }
            r7.runOnUiThread(r1)     // Catch:{ all -> 0x005c }
            java.lang.String r1 = "tag"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005c }
            r3.<init>()     // Catch:{ all -> 0x005c }
            java.lang.String r4 = "exception:"
            r3.append(r4)     // Catch:{ all -> 0x005c }
            java.lang.String r4 = r8.getMessage()     // Catch:{ all -> 0x005c }
            r3.append(r4)     // Catch:{ all -> 0x005c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x005c }
            android.util.Log.d(r1, r3)     // Catch:{ all -> 0x005c }
            r8.printStackTrace()     // Catch:{ all -> 0x005c }
            r7.isPictSave = r2     // Catch:{ all -> 0x009d }
            if (r0 == 0) goto L_0x008e
            r0.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x008e
        L_0x008c:
            r8 = move-exception
            goto L_0x0052
        L_0x008e:
            monitor-exit(r7)
            return
        L_0x0090:
            r7.isPictSave = r2     // Catch:{ all -> 0x009d }
            if (r0 == 0) goto L_0x009c
            r0.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x009c
        L_0x0098:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x009d }
        L_0x009c:
            throw r8     // Catch:{ all -> 0x009d }
        L_0x009d:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.BellLiveActivity.savePicToSDcard(android.graphics.Bitmap):void");
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    public void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        CustomVideoRecord customVideoRecord2;
        if (str.endsWith(this.strDID)) {
            if (!this.bDisplayFinished) {
                CommonUtil.Log(1, "SHIXNEWDOOR return bDisplayFinished");
                return;
            }
            this.devDecoderCount1++;
            CommonUtil.Log(1, "callBaceVideoData width:" + i3 + "  height:" + i4 + "  h264Data:" + i);
            this.bDisplayFinished = false;
            this.videodata = bArr;
            this.videoDataLen = i2;
            this.isH264Data = this.isH264Data;
            Message message = new Message();
            if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
                long time = new Date().getTime();
                int i6 = (int) (time - this.videotime);
                Log.d("tag", "play  tspan:" + i6);
                this.videotime = time;
                this.customVideoRecord.VideoRecordData(3, bArr, 0, 0, i6);
            }
            message.what = 2;
            this.mHandler.sendMessage(message);
        }
    }

    public void BSSnapshotNotify(String str, byte[] bArr, int i) {
        this.videodata = bArr;
        this.videoDataLen = i;
        Message message = new Message();
        message.what = 2;
        this.mHandler.sendMessage(message);
    }

    public void callBackMessageNotify(String str, int i, int i2) {
        if (i == 0 && i2 != 2 && str.equalsIgnoreCase(this.strDID)) {
            this.mHandler.sendEmptyMessage(123321);
        }
    }

    public void callBackAudioData(byte[] bArr, int i) {
        CustomVideoRecord customVideoRecord2;
        if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
            this.customVideoRecord.VideoRecordData(110, bArr, 0, 0, 0);
        }
        if (this.audioPlayer.isAudioPlaying()) {
            CustomBufferHead customBufferHead = new CustomBufferHead();
            CustomBufferData customBufferData = new CustomBufferData();
            customBufferHead.length = i;
            customBufferHead.startcode = AUDIO_BUFFER_START_CODE;
            customBufferData.head = customBufferHead;
            customBufferData.data = bArr;
            this.AudioBuffer.addData(customBufferData);
        }
    }

    public void callBackH264Data(String str, byte[] bArr, int i, int i2) {
        CustomVideoRecord customVideoRecord2;
        if (!str.endsWith(this.strDID)) {
            Log.d("testTakeVideo", "!did.endsWith(strDID)   did:" + str + "  strDID:" + this.strDID);
        } else if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
            long time = new Date().getTime();
            int i3 = (int) (time - this.videotime);
            Log.d("tag", "play  tspan:" + i3);
            this.videotime = time;
            this.customVideoRecord.VideoRecordData(i, bArr, this.nVideoWidth, this.nVideoHeight, i3);
        }
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (str2.indexOf("101") > 0) {
            try {
                this.cameraParmsModel = CameraParmsModel.jsonToModel(str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mHandler.sendEmptyMessage(23);
        }
    }

    public void AudioRecordData(byte[] bArr, int i) {
        if (this.bAudioRecordStart && i > 0) {
            NativeCaller.PPPPTalkAudioData(this.strDID, bArr, i);
        }
    }
}
