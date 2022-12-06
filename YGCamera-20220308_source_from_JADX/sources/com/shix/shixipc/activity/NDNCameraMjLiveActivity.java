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
import android.opengl.GLSurfaceView;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
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
import com.shix.shixipc.view.SwitchView;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.nativecaller.MyRender;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class NDNCameraMjLiveActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener, NUIMainActivity.PlayInterface, NUIMainActivity.SHIXCOMMONInterface, CustomAudioRecorder.AudioRecordResult {
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
    private Button btnPtz_cer;
    private ImageButton btnPtz_down;
    private ImageButton btnPtz_large;
    private ImageButton btnPtz_left;
    private ImageButton btnPtz_right;
    private ImageButton btnPtz_small;
    private ImageButton btnPtz_up;
    private Button btnTouch;
    ImageView btn_full;
    CameraParmsModel cameraParmsModel;
    private int checkCount = 0;
    /* access modifiers changed from: private */
    public int clickRs = 1;
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
    /* access modifiers changed from: private */
    public FrameLayout fl_bg;
    /* access modifiers changed from: private */
    public int flipping = 0;
    /* access modifiers changed from: private */
    public GLSurfaceView glVideo;
    /* access modifiers changed from: private */
    public Button icut0;
    /* access modifiers changed from: private */
    public Button icut1;
    /* access modifiers changed from: private */
    public Button icut2;
    private ImageView im_audio;
    private ImageView im_ircut;
    private ImageView im_jx_rl;
    private ImageView im_jx_ud;
    private ImageView im_k;
    private ImageView im_more;
    private ImageView im_pic;
    private ImageButton im_showhide;
    private ImageView im_t;
    private ImageView im_talk;
    private ImageView im_video;
    /* access modifiers changed from: private */
    public ImageView im_zsd;
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
    private boolean isPlayingAudio = false;
    private boolean isPlayingRecord = false;
    private boolean isPlayingVideo = false;
    private boolean isRecordVideo = false;
    /* access modifiers changed from: private */
    public boolean isSendPtzCotr = false;
    private boolean isTakeHead = false;
    private boolean isTakeVideo = false;
    /* access modifiers changed from: private */
    public boolean isTakepic = false;
    private boolean isTalking = false;
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
    private LinearLayout ll_h_right;
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
            if (i == 1) {
                if (NDNCameraMjLiveActivity.this.isOneShow) {
                    NDNCameraMjLiveActivity.this.videoView.setVisibility(8);
                    boolean unused = NDNCameraMjLiveActivity.this.isOneShow = false;
                    boolean unused2 = NDNCameraMjLiveActivity.this.isDateComeOn = true;
                    NDNCameraMjLiveActivity.this.findViewById(R.id.progressBar).setVisibility(8);
                }
                NDNCameraMjLiveActivity.this.myRender.writeSample(NDNCameraMjLiveActivity.this.videodata, NDNCameraMjLiveActivity.this.nVideoWidth, NDNCameraMjLiveActivity.this.nVideoHeight);
            } else if (i == 2) {
                if (NDNCameraMjLiveActivity.this.isOneShow) {
                    boolean unused3 = NDNCameraMjLiveActivity.this.isDateComeOn = true;
                    boolean unused4 = NDNCameraMjLiveActivity.this.isOneShow = false;
                    boolean unused5 = NDNCameraMjLiveActivity.this.isDateComeOn = true;
                    NDNCameraMjLiveActivity.this.findViewById(R.id.progressBar).setVisibility(8);
                    NDNCameraMjLiveActivity.this.glVideo.setVisibility(8);
                    boolean unused6 = NDNCameraMjLiveActivity.this.isOneShow = false;
                }
                NDNCameraMjLiveActivity nDNCameraMjLiveActivity = NDNCameraMjLiveActivity.this;
                Bitmap unused7 = nDNCameraMjLiveActivity.mBmp = BitmapFactory.decodeByteArray(nDNCameraMjLiveActivity.videodata, 0, NDNCameraMjLiveActivity.this.videoDataLen);
                if (NDNCameraMjLiveActivity.this.mBmp == null) {
                    boolean unused8 = NDNCameraMjLiveActivity.this.bDisplayFinished = true;
                    return;
                }
                NDNCameraMjLiveActivity.this.getWindowManager().getDefaultDisplay().getWidth();
                NDNCameraMjLiveActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                NDNCameraMjLiveActivity nDNCameraMjLiveActivity2 = NDNCameraMjLiveActivity.this;
                int unused9 = nDNCameraMjLiveActivity2.nVideoWidth = nDNCameraMjLiveActivity2.mBmp.getWidth();
                NDNCameraMjLiveActivity nDNCameraMjLiveActivity3 = NDNCameraMjLiveActivity.this;
                int unused10 = nDNCameraMjLiveActivity3.nVideoHeight = nDNCameraMjLiveActivity3.mBmp.getHeight();
                NDNCameraMjLiveActivity.this.videoView.setImageBitmap(NDNCameraMjLiveActivity.this.mBmp);
                if (NDNCameraMjLiveActivity.this.isTakepic) {
                    boolean unused11 = NDNCameraMjLiveActivity.this.isTakepic = false;
                    NDNCameraMjLiveActivity nDNCameraMjLiveActivity4 = NDNCameraMjLiveActivity.this;
                    nDNCameraMjLiveActivity4.takePicture(nDNCameraMjLiveActivity4.mBmp);
                }
            } else if (i != 23) {
                if (i == 1234) {
                    if (NDNCameraMjLiveActivity.this.devDecoderCount2 < 10) {
                        NDNCameraMjLiveActivity nDNCameraMjLiveActivity5 = NDNCameraMjLiveActivity.this;
                        int unused12 = nDNCameraMjLiveActivity5.devDecoderCount2 = nDNCameraMjLiveActivity5.devDecoderCount2 + 5;
                    }
                    String string = NDNCameraMjLiveActivity.this.getResources().getString(R.string.n_play_h);
                    if (NDNCameraMjLiveActivity.this.clickRs == 0) {
                        string = NDNCameraMjLiveActivity.this.getResources().getString(R.string.n_play_hh);
                    } else if (NDNCameraMjLiveActivity.this.clickRs == 1) {
                        string = NDNCameraMjLiveActivity.this.getResources().getString(R.string.n_play_h);
                    } else if (NDNCameraMjLiveActivity.this.clickRs == 2) {
                        string = NDNCameraMjLiveActivity.this.getResources().getString(R.string.n_play_l);
                    }
                    new Date(System.currentTimeMillis());
                    NDNCameraMjLiveActivity.this.tv_info.setText(NDNCameraMjLiveActivity.this.getResources().getString(R.string.play_res_title) + string);
                } else if (i == 123321) {
                    NDNCameraMjLiveActivity.this.showToast((int) R.string.camera_not_online);
                    NDNCameraMjLiveActivity.this.finish();
                }
            } else if (NDNCameraMjLiveActivity.this.cameraParmsModel != null) {
                CommonUtil.Log(1, "getQccid:" + NDNCameraMjLiveActivity.this.cameraParmsModel.getQccid());
                if (NDNCameraMjLiveActivity.this.cameraParmsModel.getQccid() != null && NDNCameraMjLiveActivity.this.cameraParmsModel.getQccid().length() > 5) {
                    CommonUtil.Log(1, "getQccid:" + NDNCameraMjLiveActivity.this.cameraParmsModel.getQccid());
                    SharedPreferences.Editor edit = NDNCameraMjLiveActivity.this.preuser.edit();
                    edit.putString("iccid" + NDNCameraMjLiveActivity.this.strDID, NDNCameraMjLiveActivity.this.cameraParmsModel.getQccid());
                    edit.commit();
                }
                NDNCameraMjLiveActivity.this.seekBar1.setProgress(NDNCameraMjLiveActivity.this.cameraParmsModel.getMic());
                NDNCameraMjLiveActivity.this.seekBar2.setProgress(NDNCameraMjLiveActivity.this.cameraParmsModel.getSpk());
                NDNCameraMjLiveActivity.this.tvSee1.setText(String.valueOf(NDNCameraMjLiveActivity.this.cameraParmsModel.getMic()));
                NDNCameraMjLiveActivity.this.tvSee2.setText(String.valueOf(NDNCameraMjLiveActivity.this.cameraParmsModel.getSpk()));
                NDNCameraMjLiveActivity nDNCameraMjLiveActivity6 = NDNCameraMjLiveActivity.this;
                int unused13 = nDNCameraMjLiveActivity6.batcapacity = nDNCameraMjLiveActivity6.cameraParmsModel.getBatvalue();
                NDNCameraMjLiveActivity.this.ll_batstatus.setVisibility(0);
                NDNCameraMjLiveActivity.this.tv_Electricity.setText(NDNCameraMjLiveActivity.this.batcapacity + "%");
                ImageView access$4600 = NDNCameraMjLiveActivity.this.ivBattery;
                NDNCameraMjLiveActivity nDNCameraMjLiveActivity7 = NDNCameraMjLiveActivity.this;
                access$4600.setImageResource(nDNCameraMjLiveActivity7.getBatteryRes(nDNCameraMjLiveActivity7.batcapacity));
                if (NDNCameraMjLiveActivity.this.cameraParmsModel.getSignal() != -110) {
                    if (NDNCameraMjLiveActivity.this.cameraParmsModel.getSignal() >= 70) {
                        NDNCameraMjLiveActivity.this.ivSingn.setImageResource(R.mipmap.hz_wifisign_100);
                    } else if (NDNCameraMjLiveActivity.this.cameraParmsModel.getSignal() >= 40) {
                        NDNCameraMjLiveActivity.this.ivSingn.setImageResource(R.mipmap.hz_wifisign_50);
                    } else {
                        NDNCameraMjLiveActivity.this.ivSingn.setImageResource(R.mipmap.hz_wifisign_20);
                    }
                }
                if (NDNCameraMjLiveActivity.this.cameraParmsModel.getBatstatus() == 1) {
                    NDNCameraMjLiveActivity.this.ivBatterying.setVisibility(0);
                } else {
                    NDNCameraMjLiveActivity.this.ivBatterying.setVisibility(4);
                }
                if (NDNCameraMjLiveActivity.this.cameraParmsModel.getRotmir() == 0) {
                    int unused14 = NDNCameraMjLiveActivity.this.mirror = 0;
                    int unused15 = NDNCameraMjLiveActivity.this.flipping = 0;
                } else if (NDNCameraMjLiveActivity.this.cameraParmsModel.getRotmir() == 1) {
                    int unused16 = NDNCameraMjLiveActivity.this.mirror = 1;
                    int unused17 = NDNCameraMjLiveActivity.this.flipping = 0;
                } else if (NDNCameraMjLiveActivity.this.cameraParmsModel.getRotmir() == 2) {
                    int unused18 = NDNCameraMjLiveActivity.this.mirror = 0;
                    int unused19 = NDNCameraMjLiveActivity.this.flipping = 1;
                } else if (NDNCameraMjLiveActivity.this.cameraParmsModel.getRotmir() == 3) {
                    int unused20 = NDNCameraMjLiveActivity.this.mirror = 1;
                    int unused21 = NDNCameraMjLiveActivity.this.flipping = 1;
                }
                if (NDNCameraMjLiveActivity.this.cameraParmsModel.getLamp() == 1) {
                    NDNCameraMjLiveActivity.this.im_zsd.setImageResource(R.mipmap.n_play_buttom_zsd_open);
                    NDNCameraMjLiveActivity.this.tv_zsd.setTextColor(NDNCameraMjLiveActivity.this.getResources().getColor(R.color.color_qh_addtxt));
                } else {
                    NDNCameraMjLiveActivity.this.im_zsd.setImageResource(R.mipmap.n_play_buttom_zsd_close);
                    NDNCameraMjLiveActivity.this.tv_zsd.setTextColor(NDNCameraMjLiveActivity.this.getResources().getColor(R.color.color_play_toptext));
                }
                if (NDNCameraMjLiveActivity.this.cameraParmsModel.getIcut() == 2) {
                    NDNCameraMjLiveActivity.this.icut2.setTextColor(NDNCameraMjLiveActivity.this.getResources().getColor(R.color.color_n_status_offline));
                    NDNCameraMjLiveActivity.this.icut1.setTextColor(NDNCameraMjLiveActivity.this.getResources().getColor(R.color.color_white));
                    NDNCameraMjLiveActivity.this.icut0.setTextColor(NDNCameraMjLiveActivity.this.getResources().getColor(R.color.color_white));
                } else if (NDNCameraMjLiveActivity.this.cameraParmsModel.getIcut() == 1) {
                    NDNCameraMjLiveActivity.this.icut1.setTextColor(NDNCameraMjLiveActivity.this.getResources().getColor(R.color.color_n_status_offline));
                    NDNCameraMjLiveActivity.this.icut2.setTextColor(NDNCameraMjLiveActivity.this.getResources().getColor(R.color.color_white));
                    NDNCameraMjLiveActivity.this.icut0.setTextColor(NDNCameraMjLiveActivity.this.getResources().getColor(R.color.color_white));
                } else {
                    NDNCameraMjLiveActivity.this.icut0.setTextColor(NDNCameraMjLiveActivity.this.getResources().getColor(R.color.color_n_status_offline));
                    NDNCameraMjLiveActivity.this.icut1.setTextColor(NDNCameraMjLiveActivity.this.getResources().getColor(R.color.color_white));
                    NDNCameraMjLiveActivity.this.icut2.setTextColor(NDNCameraMjLiveActivity.this.getResources().getColor(R.color.color_white));
                }
                if (NDNCameraMjLiveActivity.this.cameraParmsModel.getClockScreen() == 1 || NDNCameraMjLiveActivity.this.cameraParmsModel.getClockScreen() == 2) {
                    NDNCameraMjLiveActivity.this.sv_szp.setOpened(true);
                } else {
                    NDNCameraMjLiveActivity.this.sv_szp.setOpened(false);
                }
                NDNCameraMjLiveActivity.this.seekBar11.setProgress(NDNCameraMjLiveActivity.this.cameraParmsModel.getBright());
                NDNCameraMjLiveActivity.this.seekBar12.setProgress(NDNCameraMjLiveActivity.this.cameraParmsModel.getContrast());
                NDNCameraMjLiveActivity.this.tvSee11.setText(String.valueOf(NDNCameraMjLiveActivity.this.cameraParmsModel.getBright()));
                NDNCameraMjLiveActivity.this.tvSee12.setText(String.valueOf(NDNCameraMjLiveActivity.this.cameraParmsModel.getContrast()));
            }
            if (message.what == 1 || message.what == 2) {
                boolean unused22 = NDNCameraMjLiveActivity.this.bDisplayFinished = true;
                if (NDNCameraMjLiveActivity.this.isH264Data == 0) {
                    NDNCameraMjLiveActivity.this.tv_name1.setText(NDNCameraMjLiveActivity.this.strName);
                }
            }
        }
    };
    private WifiManager mWifiManager;
    /* access modifiers changed from: private */
    public int mirror = 0;
    /* access modifiers changed from: private */
    public MyRender myRender;
    /* access modifiers changed from: private */
    public int nVideoHeight = 0;
    /* access modifiers changed from: private */
    public int nVideoWidth = 0;
    private File path = null;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_Icut;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_hight;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_more_funtion;
    private View popupmore;
    private View popv_hight;
    private View popv_icut;
    private View popv_more_funtion;
    private SharedPreferences preRet;
    /* access modifiers changed from: private */
    public SharedPreferences preuser;
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
                NDNCameraMjLiveActivity.access$408(NDNCameraMjLiveActivity.this);
                NDNCameraMjLiveActivity.this.tvRecordTime.setText(TimeUtil.getTimeDesc(NDNCameraMjLiveActivity.this.recordTime));
                NDNCameraMjLiveActivity.this.refreshUIHandler.sendEmptyMessageDelayed(4, 1000);
            }
        }
    };
    private Dialog restartDialog;
    int ret = 0;
    private RelativeLayout rl_h_bm;
    private String sdAvail = null;
    private String sdSize = null;
    /* access modifiers changed from: private */
    public SeekBar seekBar1;
    /* access modifiers changed from: private */
    public SeekBar seekBar11;
    /* access modifiers changed from: private */
    public SeekBar seekBar12;
    /* access modifiers changed from: private */
    public SeekBar seekBar2;
    private int shixUtcOffset = 28800;
    private LinearLayout shix_LL_buttom;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private StatFs stat;
    private String status = null;
    /* access modifiers changed from: private */
    public String strDID = null;
    /* access modifiers changed from: private */
    public String strName = null;
    private String strPwd = null;
    private String strUser = null;
    public String strVideoName = "";
    /* access modifiers changed from: private */
    public SwitchView sv_szp;
    /* access modifiers changed from: private */
    public SwitchView sv_zsd;
    private int timeCount = 0;
    private long totalBlocks;
    /* access modifiers changed from: private */
    public TextView tvRecordTime;
    /* access modifiers changed from: private */
    public TextView tvSee1;
    /* access modifiers changed from: private */
    public TextView tvSee11;
    /* access modifiers changed from: private */
    public TextView tvSee12;
    /* access modifiers changed from: private */
    public TextView tvSee2;
    /* access modifiers changed from: private */
    public TextView tv_Electricity;
    private TextView tv_audio;
    /* access modifiers changed from: private */
    public TextView tv_info;
    private TextView tv_more;
    TextView tv_name1;
    TextView tv_name2;
    private TextView tv_pic;
    private TextView tv_talk;
    private TextView tv_video;
    /* access modifiers changed from: private */
    public TextView tv_zsd;
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    /* access modifiers changed from: private */
    public ImageView videoView;
    /* access modifiers changed from: private */
    public byte[] videodata = null;
    private long videotime = 0;
    private View viewSee_batmode;
    private View viewSee_videomode;

    private void contrDev(int i, int i2) {
    }

    private void initListen() {
    }

    private void startPlayAudio() {
    }

    private void startTalk() {
    }

    private void stopPlayAudio() {
    }

    private void stopTalk() {
    }

    public void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
    }

    public void callBackConnectLook(String str, int i, int i2) {
    }

    public int getBatteryRes(int i) {
        return i >= 90 ? R.mipmap.home_power_100 : i >= 60 ? R.mipmap.home_power_80 : i >= 40 ? R.mipmap.home_power_60 : i >= 20 ? R.mipmap.home_power_40 : R.mipmap.home_power_20;
    }

    static /* synthetic */ int access$408(NDNCameraMjLiveActivity nDNCameraMjLiveActivity) {
        int i = nDNCameraMjLiveActivity.recordTime;
        nDNCameraMjLiveActivity.recordTime = i + 1;
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
            while (NDNCameraMjLiveActivity.this.isCheckVideo && NDNCameraMjLiveActivity.this.isCheckVideo) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                NDNCameraMjLiveActivity nDNCameraMjLiveActivity = NDNCameraMjLiveActivity.this;
                int unused = nDNCameraMjLiveActivity.devDecoderCount2 = nDNCameraMjLiveActivity.devDecoderCount1;
                int unused2 = NDNCameraMjLiveActivity.this.devDecoderCount1 = 0;
                if (NDNCameraMjLiveActivity.this.isCheckVideo) {
                    NDNCameraMjLiveActivity.this.mHandler.sendEmptyMessage(1234);
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
        setContentView(R.layout.activity_camera_live_dn_n);
        this.isDateComeOn = false;
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        getDataFromOther();
        this.preRet = getSharedPreferences(ContentCommon.SHIX_SHARE_BAT, 0);
        this.audioManager = (AudioManager) getSystemService("audio");
        this.glVideo = (GLSurfaceView) findViewById(R.id.glVideo);
        this.isExitActivity = false;
        initView();
        initAnim();
        initExitPopupWindow_more_funtion();
        initExitPopupWindow_Hight();
        initExitPopupWindow_Icut();
        initListen();
        initExitDialog();
        this.myRender = new MyRender(this.glVideo);
        this.glVideo.setRenderer(this.myRender);
        NUIMainActivity.setPlayInterface(this);
        NativeCaller.StartPPPPLivestream(this.strDID, 2);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.SHIX_getSPKMICParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getCameraParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        this.customVideoRecord = new CustomVideoRecord(this.strDID);
        this.status = Environment.getExternalStorageState();
        if (this.status.equals("mounted")) {
            try {
                this.path = Environment.getExternalStorageDirectory();
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
        if (CommonUtil.SHIX_is100WDev(this.strDID).booleanValue()) {
            findViewById(R.id.ll_zsd).setVisibility(8);
            findViewById(R.id.ll_talk).setVisibility(0);
            return;
        }
        findViewById(R.id.im_showhide).setVisibility(8);
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
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (getResources().getConfiguration().orientation == 1) {
            this.isFullscreen = false;
            this.isCheckVideo = true;
            new CheckThread().start();
            return;
        }
        this.isCheckVideo = false;
        this.isFullscreen = true;
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
        this.tv_zsd = (TextView) findViewById(R.id.tv_zsd);
        this.videoView = (ImageView) findViewById(R.id.videoView);
        this.im_showhide = (ImageButton) findViewById(R.id.im_showhide);
        this.im_showhide.setOnClickListener(this);
        ((TextView) findViewById(R.id.tvHeaderTitle)).setText(this.strName);
        this.tv_name1 = (TextView) findViewById(R.id.tv_name1);
        this.tv_name1.setText(this.strName);
        this.tv_name2 = (TextView) findViewById(R.id.tv_name2);
        this.tv_Electricity = (TextView) findViewById(R.id.tv_Electricity);
        this.ivBattery = (ImageView) findViewById(R.id.ivBattery);
        this.ivBatterying = (ImageView) findViewById(R.id.ivBatterying);
        this.rl_h_bm = (RelativeLayout) findViewById(R.id.rl_h_bm);
        this.ll_h_right = (LinearLayout) findViewById(R.id.ll_h_right);
        this.ivSingn = (ImageView) findViewById(R.id.ivSingn);
        this.tv_info = (TextView) findViewById(R.id.tv_info);
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
        this.btn_full = (ImageView) findViewById(R.id.btn_full);
        this.btn_full.setOnClickListener(this);
        this.ll_video.setOnClickListener(this);
        this.ll_pic.setOnClickListener(this);
        this.ll_talk.setOnClickListener(this);
        this.ll_audio.setOnClickListener(this);
        this.ll_more.setOnClickListener(this);
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
        this.im_jx_ud = (ImageView) findViewById(R.id.im_jx_ud);
        this.im_jx_rl = (ImageView) findViewById(R.id.im_jx_rl);
        this.im_zsd = (ImageView) findViewById(R.id.im_zsd);
        this.im_ircut = (ImageView) findViewById(R.id.im_ircut);
        this.im_t = (ImageView) findViewById(R.id.im_t);
        this.im_k = (ImageView) findViewById(R.id.im_k);
        this.im_jx_ud.setOnClickListener(this);
        this.im_jx_rl.setOnClickListener(this);
        this.im_zsd.setOnClickListener(this);
        this.im_ircut.setOnClickListener(this);
        this.im_t.setOnClickListener(this);
        this.im_k.setOnClickListener(this);
        this.fl_bg = (FrameLayout) findViewById(R.id.fl_bg);
        this.btnPtz_up = (ImageButton) findViewById(R.id.btnPtz_up);
        this.btnPtz_down = (ImageButton) findViewById(R.id.btnPtz_down);
        this.btnPtz_left = (ImageButton) findViewById(R.id.btnPtz_left);
        this.btnPtz_right = (ImageButton) findViewById(R.id.btnPtz_right);
        this.btnPtz_cer = (Button) findViewById(R.id.btnPtz_cer);
        this.btnPtz_up.setOnClickListener(this);
        this.btnPtz_down.setOnClickListener(this);
        this.btnPtz_left.setOnClickListener(this);
        this.btnPtz_right.setOnClickListener(this);
        this.btnPtz_cer.setOnClickListener(this);
        this.btnPtz_up.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (!CommonUtil.SHIX_isSupportPTZ().booleanValue()) {
                    NDNCameraMjLiveActivity.this.showToast((int) R.string.no_support_ptz);
                    return true;
                }
                boolean unused = NDNCameraMjLiveActivity.this.isSendPtzCotr = true;
                NDNCameraMjLiveActivity.this.contrDevDee(0, 0);
                return true;
            }
        });
        this.btnPtz_up.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    NDNCameraMjLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg_up);
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(NDNCameraMjLiveActivity.this, 10);
                    }
                    return false;
                } else if (action != 1) {
                    return true;
                } else {
                    NDNCameraMjLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg);
                    if (!CommonUtil.SHIX_isSupportPTZ().booleanValue()) {
                        NDNCameraMjLiveActivity.this.showToast((int) R.string.no_support_ptz);
                        return false;
                    }
                    if (NDNCameraMjLiveActivity.this.isSendPtzCotr) {
                        boolean unused = NDNCameraMjLiveActivity.this.isSendPtzCotr = false;
                        NDNCameraMjLiveActivity.this.contrDevDee(0, 1);
                    }
                    return false;
                }
            }
        });
        this.btnPtz_down.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (!CommonUtil.SHIX_isSupportPTZ().booleanValue()) {
                    NDNCameraMjLiveActivity.this.showToast((int) R.string.no_support_ptz);
                    return false;
                }
                boolean unused = NDNCameraMjLiveActivity.this.isSendPtzCotr = true;
                NDNCameraMjLiveActivity.this.contrDevDee(0, 2);
                return true;
            }
        });
        this.btnPtz_down.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    NDNCameraMjLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg_down);
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(NDNCameraMjLiveActivity.this, 10);
                    }
                    return false;
                } else if (action != 1) {
                    return true;
                } else {
                    NDNCameraMjLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg);
                    if (!CommonUtil.SHIX_isSupportPTZ().booleanValue()) {
                        NDNCameraMjLiveActivity.this.showToast((int) R.string.no_support_ptz);
                        return false;
                    }
                    if (NDNCameraMjLiveActivity.this.isSendPtzCotr) {
                        boolean unused = NDNCameraMjLiveActivity.this.isSendPtzCotr = false;
                        NDNCameraMjLiveActivity.this.contrDevDee(0, 3);
                    }
                    return false;
                }
            }
        });
        this.btnPtz_left.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (!CommonUtil.SHIX_isSupportPTZ().booleanValue()) {
                    NDNCameraMjLiveActivity.this.showToast((int) R.string.no_support_ptz);
                    return false;
                }
                boolean unused = NDNCameraMjLiveActivity.this.isSendPtzCotr = true;
                NDNCameraMjLiveActivity.this.contrDevDee(0, 4);
                return true;
            }
        });
        this.btnPtz_left.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    NDNCameraMjLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg_left);
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(NDNCameraMjLiveActivity.this, 10);
                    }
                    return false;
                } else if (action != 1) {
                    return true;
                } else {
                    NDNCameraMjLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg);
                    if (!CommonUtil.SHIX_isSupportPTZ().booleanValue()) {
                        NDNCameraMjLiveActivity.this.showToast((int) R.string.no_support_ptz);
                        return false;
                    }
                    if (NDNCameraMjLiveActivity.this.isSendPtzCotr) {
                        boolean unused = NDNCameraMjLiveActivity.this.isSendPtzCotr = false;
                        NDNCameraMjLiveActivity.this.contrDevDee(0, 5);
                    }
                    return false;
                }
            }
        });
        this.btnPtz_right.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (!CommonUtil.SHIX_isSupportPTZ().booleanValue()) {
                    NDNCameraMjLiveActivity.this.showToast((int) R.string.no_support_ptz);
                    return false;
                }
                boolean unused = NDNCameraMjLiveActivity.this.isSendPtzCotr = true;
                NDNCameraMjLiveActivity.this.contrDevDee(0, 6);
                return true;
            }
        });
        this.btnPtz_right.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    NDNCameraMjLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg_rigth);
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(NDNCameraMjLiveActivity.this, 10);
                    }
                    return false;
                } else if (action != 1) {
                    return true;
                } else {
                    NDNCameraMjLiveActivity.this.fl_bg.setBackgroundResource(R.mipmap.n_ptz_bg);
                    if (!CommonUtil.SHIX_isSupportPTZ().booleanValue()) {
                        NDNCameraMjLiveActivity.this.showToast((int) R.string.no_support_ptz);
                        return false;
                    }
                    if (NDNCameraMjLiveActivity.this.isSendPtzCotr) {
                        boolean unused = NDNCameraMjLiveActivity.this.isSendPtzCotr = false;
                        NDNCameraMjLiveActivity.this.contrDevDee(0, 7);
                    }
                    return false;
                }
            }
        });
        if (CommonUtil.SHIX_isBkDid(this.strDID).booleanValue()) {
            this.tv_more.setText(R.string.n_play_more_sd_title);
        }
    }

    /* access modifiers changed from: private */
    public void contrDevDee(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "ptz_control");
            jSONObject.put("cmd", 128);
            jSONObject.put("parms", i);
            jSONObject.put("value", i2);
            jSONObject.put("user", SystemValue.doorBellAdmin);
            jSONObject.put("pwd", SystemValue.doorBellPass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            NativeCaller.TransferMessage(this.strDID, jSONObject.toString(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
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
        CustomVideoRecord customVideoRecord2 = this.customVideoRecord;
        if (customVideoRecord2 != null) {
            customVideoRecord2.stopRecordVideo();
        }
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
            this.glVideo.setLayoutParams(layoutParams);
            this.btnTouch.setLayoutParams(layoutParams);
            this.ll_batstatus.setLayoutParams(layoutParams);
            this.popupmore.setBackgroundColor(getResources().getColor(R.color.color_main));
            this.btnTouch.setVisibility(0);
            return;
        }
        this.isFullscreen = true;
        this.lyHeader.setVisibility(8);
        this.shix_LL_buttom.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 49;
        this.glVideo.setLayoutParams(layoutParams2);
        this.btnTouch.setLayoutParams(layoutParams2);
        this.btnTouch.setVisibility(0);
        this.popupmore.setBackgroundColor(getResources().getColor(R.color.color_main_90));
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
            case R.id.btnPtz_cer /*2131165281*/:
                contrDevDee(1, ContentCommon.CMD_PTZ_RESET);
                return;
            case R.id.btnPtz_down /*2131165282*/:
                contrDevDee(1, 2);
                return;
            case R.id.btnPtz_left /*2131165283*/:
                contrDevDee(1, 4);
                return;
            case R.id.btnPtz_right /*2131165284*/:
                contrDevDee(1, 6);
                return;
            case R.id.btnPtz_up /*2131165285*/:
                contrDevDee(1, 0);
                return;
            case R.id.btnTouch /*2131165286*/:
                if (this.rl_h_bm.isShown()) {
                    this.ll_h_right.setVisibility(8);
                    this.rl_h_bm.setVisibility(8);
                    return;
                }
                this.ll_h_right.setVisibility(0);
                this.rl_h_bm.setVisibility(0);
                return;
            case R.id.btn_full /*2131165301*/:
                CommonUtil.Log(1, "zhaogenghuaiclick btn_full isFullscreen:" + this.isFullscreen);
                if (!this.isFullscreen) {
                    this.isFullscreen = true;
                    toggleFullscreen(true);
                    return;
                }
                this.isFullscreen = false;
                toggleFullscreen(false);
                return;
            case R.id.button_1080 /*2131165318*/:
                this.clickRs = 0;
                this.popupWindow_hight.dismiss();
                NativeCaller.StopPPPPLivestream(this.strDID);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                NativeCaller.StartPPPPLivestream(this.strDID, 1);
                if (!this.isFullscreen) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.625f));
                    layoutParams.gravity = 17;
                    this.glVideo.setLayoutParams(layoutParams);
                    this.btnTouch.setLayoutParams(layoutParams);
                    this.ll_batstatus.setLayoutParams(layoutParams);
                    this.btnTouch.setVisibility(0);
                    return;
                }
                return;
            case R.id.button_2k /*2131165319*/:
                this.clickRs = 2;
                this.popupWindow_hight.dismiss();
                NativeCaller.StopPPPPLivestream(this.strDID);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                NativeCaller.StartPPPPLivestream(this.strDID, 2);
                if (!this.isFullscreen) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.625f));
                    layoutParams2.gravity = 17;
                    this.glVideo.setLayoutParams(layoutParams2);
                    this.btnTouch.setLayoutParams(layoutParams2);
                    this.ll_batstatus.setLayoutParams(layoutParams2);
                    this.btnTouch.setVisibility(0);
                    return;
                }
                return;
            case R.id.button_4k /*2131165320*/:
                this.clickRs = 1;
                this.popupWindow_hight.dismiss();
                NativeCaller.StopPPPPLivestream(this.strDID);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
                NativeCaller.StartPPPPLivestream(this.strDID, 2);
                if (!this.isFullscreen) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.5625f));
                    layoutParams3.gravity = 17;
                    this.glVideo.setLayoutParams(layoutParams3);
                    this.btnTouch.setLayoutParams(layoutParams3);
                    this.ll_batstatus.setLayoutParams(layoutParams3);
                    this.btnTouch.setVisibility(0);
                    return;
                }
                return;
            case R.id.button_720 /*2131165321*/:
                this.popupWindow_hight.dismiss();
                this.im_k.setImageResource(R.mipmap.n_playview_t_720);
                NativeCaller.StopPPPPLivestream(this.strDID);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
                NativeCaller.StartPPPPLivestream(this.strDID, 2);
                if (!this.isFullscreen) {
                    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.75f));
                    layoutParams4.gravity = 17;
                    this.glVideo.setLayoutParams(layoutParams4);
                    this.btnTouch.setLayoutParams(layoutParams4);
                    this.ll_batstatus.setLayoutParams(layoutParams4);
                    this.btnTouch.setVisibility(0);
                    return;
                }
                return;
            case R.id.icut0 /*2131165485*/:
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
            case R.id.icut1 /*2131165486*/:
                this.popupWindow_Icut.dismiss();
                NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "icut", 1), 0);
                this.cameraParmsModel.setIcut(1);
                this.icut1.setTextColor(getResources().getColor(R.color.color_n_status_offline));
                this.icut0.setTextColor(getResources().getColor(R.color.color_white));
                this.icut2.setTextColor(getResources().getColor(R.color.color_white));
                return;
            case R.id.icut2 /*2131165487*/:
                this.popupWindow_Icut.dismiss();
                NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "icut", 2), 0);
                this.cameraParmsModel.setIcut(2);
                this.icut2.setTextColor(getResources().getColor(R.color.color_n_status_offline));
                this.icut0.setTextColor(getResources().getColor(R.color.color_white));
                this.icut1.setTextColor(getResources().getColor(R.color.color_white));
                return;
            case R.id.im_ircut /*2131165493*/:
                this.popupWindow_Icut.showAsDropDown(this.tv_name2, 0, 60);
                return;
            case R.id.im_jx_rl /*2131165494*/:
                if (this.mirror == 1) {
                    this.mirror = 0;
                    if (this.mirror == 0 && this.flipping == 1) {
                        this.ret = 2;
                    } else if (this.mirror == 0 && this.flipping == 0) {
                        this.ret = 0;
                    }
                } else {
                    this.mirror = 1;
                    if (this.mirror == 1 && this.flipping == 1) {
                        this.ret = 3;
                    } else if (this.mirror == 1 && this.flipping == 0) {
                        this.ret = 1;
                    }
                }
                NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "rotmir", this.ret), 0);
                return;
            case R.id.im_jx_ud /*2131165495*/:
                if (this.flipping == 1) {
                    this.flipping = 0;
                    if (this.mirror == 1 && this.flipping == 0) {
                        this.ret = 1;
                    } else if (this.mirror == 0 && this.flipping == 0) {
                        this.ret = 0;
                    }
                } else {
                    this.flipping = 1;
                    if (this.mirror == 1 && this.flipping == 1) {
                        this.ret = 3;
                    } else if (this.mirror == 0 && this.flipping == 1) {
                        this.ret = 2;
                    }
                }
                NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "rotmir", this.ret), 0);
                return;
            case R.id.im_k /*2131165496*/:
                this.popupWindow_hight.showAsDropDown(this.tv_name2, 0, 100);
                return;
            case R.id.im_showhide /*2131165501*/:
                if (this.isFullscreen) {
                    return;
                }
                if (this.fl_bg.isShown()) {
                    this.fl_bg.setVisibility(8);
                    this.im_showhide.setImageResource(R.mipmap.huang_play_up);
                    return;
                }
                this.fl_bg.setVisibility(0);
                this.im_showhide.setImageResource(R.mipmap.huang_play_down);
                return;
            case R.id.im_t /*2131165502*/:
                CameraParmsModel cameraParmsModel2 = this.cameraParmsModel;
                if (cameraParmsModel2 != null) {
                    if (cameraParmsModel2.getClockScreen() == 0) {
                        NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 1), 0);
                        this.cameraParmsModel.setClockScreen(1);
                        return;
                    }
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 0), 0);
                    this.cameraParmsModel.setClockScreen(0);
                    return;
                }
                return;
            case R.id.im_zsd /*2131165507*/:
                CameraParmsModel cameraParmsModel3 = this.cameraParmsModel;
                if (cameraParmsModel3 != null) {
                    if (cameraParmsModel3.getLamp() == 0) {
                        NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 1), 0);
                        this.im_zsd.setImageResource(R.mipmap.n_play_buttom_zsd_open);
                        this.tv_zsd.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                        this.cameraParmsModel.setLamp(1);
                        return;
                    }
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 0), 0);
                    this.im_zsd.setImageResource(R.mipmap.n_play_buttom_zsd_close);
                    this.tv_zsd.setTextColor(getResources().getColor(R.color.color_play_toptext));
                    this.cameraParmsModel.setLamp(0);
                    return;
                }
                return;
            case R.id.ivBack /*2131165545*/:
                if (this.isTakeVideo) {
                    showToast((int) R.string.ptz_takevideo_show);
                    return;
                }
                returnLastBmp2Home();
                this.dlgExit.show();
                return;
            case R.id.ivOperator1 /*2131165551*/:
                Intent intent = new Intent(this, SettingActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
                startActivity(intent);
                finish();
                return;
            case R.id.tvCancel /*2131165860*/:
                this.dlgExit.dismiss();
                return;
            case R.id.tvExit /*2131165863*/:
                this.refreshUIHandler.removeCallbacksAndMessages((Object) null);
                this.dlgExit.dismiss();
                Intent intent2 = new Intent(this, NUIMainActivity.class);
                intent2.setFlags(67108864);
                startActivity(intent2);
                finish();
                return;
            default:
                return;
        }
    }

    private boolean touchView(View view, int i) {
        switch (view.getId()) {
            case R.id.ll_audio /*2131165618*/:
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
            case R.id.ll_more /*2131165629*/:
                if (i == 0) {
                    if (ContentCommon.ISVISI.booleanValue()) {
                        CommonUtil.Vibrate(this, 10);
                    }
                    this.tv_more.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                } else {
                    this.tv_more.setTextColor(getResources().getColor(R.color.color_play_toptext));
                }
                if (!CommonUtil.SHIX_is100WDev(this.strDID).booleanValue()) {
                    Intent intent = new Intent(this, TfFilesActivity.class);
                    intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
                    intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                    intent.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
                    intent.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
                    startActivity(intent);
                    finish();
                    break;
                } else {
                    Intent intent2 = new Intent(this, PlayBackActivity.class);
                    intent2.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
                    intent2.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                    intent2.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
                    intent2.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
                    startActivity(intent2);
                    finish();
                    break;
                }
            case R.id.ll_pic /*2131165631*/:
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
            case R.id.ll_talk /*2131165636*/:
                if (CommonUtil.SHIX_isSupportTalk().booleanValue()) {
                    if (i != 0) {
                        this.clickTimeUp = System.currentTimeMillis();
                        this.im_talk.setImageResource(R.mipmap.n_play_buttom_talk);
                        this.tv_talk.setTextColor(getResources().getColor(R.color.color_play_toptext));
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
                        this.im_talk.setImageResource(R.mipmap.n_play_buttom_talking);
                        this.tv_talk.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                        if (this.isAudioClick) {
                            StopAudio();
                            this.im_audio.setImageResource(R.mipmap.n_audios2);
                            this.tv_audio.setTextColor(getResources().getColor(R.color.color_play_toptext));
                        }
                        StartTalk();
                        break;
                    }
                } else {
                    showToast((int) R.string.no_support_audio);
                    return false;
                }
                break;
            case R.id.ll_video /*2131165637*/:
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
                    if (NDNCameraMjLiveActivity.this.isH264Data == 1) {
                        byte[] bArr = new byte[(NDNCameraMjLiveActivity.this.nVideoWidth * NDNCameraMjLiveActivity.this.nVideoHeight * 2)];
                        NativeCaller.YUV4202RGB565(NDNCameraMjLiveActivity.this.videodata, bArr, NDNCameraMjLiveActivity.this.nVideoWidth, NDNCameraMjLiveActivity.this.nVideoHeight);
                        ByteBuffer wrap = ByteBuffer.wrap(bArr);
                        NDNCameraMjLiveActivity nDNCameraMjLiveActivity = NDNCameraMjLiveActivity.this;
                        Bitmap unused = nDNCameraMjLiveActivity.mBmp = Bitmap.createBitmap(nDNCameraMjLiveActivity.nVideoWidth, NDNCameraMjLiveActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                        NDNCameraMjLiveActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                        if (NDNCameraMjLiveActivity.this.mBmp != null) {
                            File file = new File(Environment.getExternalStorageDirectory(), "YGCamera/videohead/ALLFile");
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(new File(file, NDNCameraMjLiveActivity.this.strVideoName));
                                if (NDNCameraMjLiveActivity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (NDNCameraMjLiveActivity.this.mBmp != null) {
                        File file2 = new File(Environment.getExternalStorageDirectory(), "YGCamera/videohead/ALLFile");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file2, NDNCameraMjLiveActivity.this.strVideoName));
                            if (NDNCameraMjLiveActivity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream2)) {
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
                    if (NDNCameraMjLiveActivity.this.isH264Data == 1) {
                        byte[] bArr = new byte[(NDNCameraMjLiveActivity.this.nVideoWidth * NDNCameraMjLiveActivity.this.nVideoHeight * 2)];
                        NativeCaller.YUV4202RGB565(NDNCameraMjLiveActivity.this.videodata, bArr, NDNCameraMjLiveActivity.this.nVideoWidth, NDNCameraMjLiveActivity.this.nVideoHeight);
                        ByteBuffer wrap = ByteBuffer.wrap(bArr);
                        NDNCameraMjLiveActivity nDNCameraMjLiveActivity = NDNCameraMjLiveActivity.this;
                        Bitmap unused = nDNCameraMjLiveActivity.mBmp = Bitmap.createBitmap(nDNCameraMjLiveActivity.nVideoWidth, NDNCameraMjLiveActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                        NDNCameraMjLiveActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                        if (NDNCameraMjLiveActivity.this.mBmp != null) {
                            File file = new File(Environment.getExternalStorageDirectory(), "YGCamera/picid");
                            File file2 = new File(file, NDNCameraMjLiveActivity.this.strDID + ".jpg");
                            if (file2.exists()) {
                                Log.d("first_pic", file2.delete() + "");
                            }
                            NDNCameraMjLiveActivity nDNCameraMjLiveActivity2 = NDNCameraMjLiveActivity.this;
                            nDNCameraMjLiveActivity2.setBitMapToBean(nDNCameraMjLiveActivity2.strDID, NDNCameraMjLiveActivity.this.mBmp);
                            NDNCameraMjLiveActivity nDNCameraMjLiveActivity3 = NDNCameraMjLiveActivity.this;
                            nDNCameraMjLiveActivity3.saveBmpToSDcard(nDNCameraMjLiveActivity3.strDID, NDNCameraMjLiveActivity.this.mBmp);
                        }
                    } else if (NDNCameraMjLiveActivity.this.mBmp != null) {
                        File file3 = new File(Environment.getExternalStorageDirectory(), "YGCamera/picid");
                        File file4 = new File(file3, NDNCameraMjLiveActivity.this.strDID + ".jpg");
                        if (file4.exists()) {
                            Log.d("first_pic", file4.delete() + "");
                        }
                        NDNCameraMjLiveActivity nDNCameraMjLiveActivity4 = NDNCameraMjLiveActivity.this;
                        nDNCameraMjLiveActivity4.setBitMapToBean(nDNCameraMjLiveActivity4.strDID, NDNCameraMjLiveActivity.this.mBmp);
                        NDNCameraMjLiveActivity nDNCameraMjLiveActivity5 = NDNCameraMjLiveActivity.this;
                        nDNCameraMjLiveActivity5.saveBmpToSDcard(nDNCameraMjLiveActivity5.strDID, NDNCameraMjLiveActivity.this.mBmp);
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
        File file = new File(Environment.getExternalStorageDirectory(), "YGCamera/picid");
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

    public void initExitPopupWindow_more_funtion() {
        this.popv_more_funtion = LayoutInflater.from(this).inflate(R.layout.popup_playmore_funtion, (ViewGroup) null);
        this.popupmore = this.popv_more_funtion.findViewById(R.id.popupmore);
        this.seekBar1 = (SeekBar) this.popv_more_funtion.findViewById(R.id.seekBar1);
        this.seekBar2 = (SeekBar) this.popv_more_funtion.findViewById(R.id.seekBar2);
        this.sv_zsd = (SwitchView) this.popv_more_funtion.findViewById(R.id.sv_zsd);
        this.sv_szp = (SwitchView) this.popv_more_funtion.findViewById(R.id.sv_szp);
        this.sv_szp.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            public void toggleToOn(SwitchView switchView) {
                NDNCameraMjLiveActivity.this.sv_szp.setOpened(true);
                NativeCaller.TransferMessage(NDNCameraMjLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 1), 0);
                NDNCameraMjLiveActivity.this.cameraParmsModel.setClockScreen(1);
            }

            public void toggleToOff(SwitchView switchView) {
                NDNCameraMjLiveActivity.this.sv_szp.setOpened(false);
                NativeCaller.TransferMessage(NDNCameraMjLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 0), 0);
                NDNCameraMjLiveActivity.this.cameraParmsModel.setClockScreen(0);
            }
        });
        this.sv_zsd.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            public void toggleToOn(SwitchView switchView) {
                NDNCameraMjLiveActivity.this.sv_zsd.setOpened(true);
                NativeCaller.TransferMessage(NDNCameraMjLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 1), 0);
                NDNCameraMjLiveActivity.this.cameraParmsModel.setLamp(1);
            }

            public void toggleToOff(SwitchView switchView) {
                NDNCameraMjLiveActivity.this.sv_zsd.setOpened(false);
                NativeCaller.TransferMessage(NDNCameraMjLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 0), 0);
                NDNCameraMjLiveActivity.this.cameraParmsModel.setLamp(0);
            }
        });
        this.tvSee1 = (TextView) this.popv_more_funtion.findViewById(R.id.tvSee1);
        this.tvSee2 = (TextView) this.popv_more_funtion.findViewById(R.id.tvSee2);
        this.seekBar1.setMax(100);
        this.seekBar2.setMax(100);
        this.seekBar11 = (SeekBar) this.popv_more_funtion.findViewById(R.id.seekBar11);
        this.seekBar12 = (SeekBar) this.popv_more_funtion.findViewById(R.id.seekBar12);
        this.tvSee11 = (TextView) this.popv_more_funtion.findViewById(R.id.tvSee11);
        this.tvSee12 = (TextView) this.popv_more_funtion.findViewById(R.id.tvSee12);
        this.seekBar11.setMax(100);
        this.seekBar12.setMax(100);
        this.seekBar11.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                NDNCameraMjLiveActivity.this.tvSee11.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(NDNCameraMjLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "contrast", seekBar.getProgress()), 0);
            }
        });
        this.seekBar12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                NDNCameraMjLiveActivity.this.tvSee12.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(NDNCameraMjLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "bright", seekBar.getProgress()), 0);
            }
        });
        this.seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                NDNCameraMjLiveActivity.this.tvSee1.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(NDNCameraMjLiveActivity.this.strDID, CommonUtil.SHIX_setMIC(SystemValue.doorBellAdmin, SystemValue.doorBellPass, seekBar.getProgress()), 0);
            }
        });
        this.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                NDNCameraMjLiveActivity.this.tvSee2.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(NDNCameraMjLiveActivity.this.strDID, CommonUtil.SHIX_setSPK(SystemValue.doorBellAdmin, SystemValue.doorBellPass, seekBar.getProgress()), 0);
            }
        });
        this.popv_more_funtion.findViewById(R.id.buttonClose).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NDNCameraMjLiveActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popv_more_funtion.findViewById(R.id.buttonSD).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NDNCameraMjLiveActivity.this.popupWindow_more_funtion.dismiss();
                Intent intent = new Intent(NDNCameraMjLiveActivity.this, PlayBackTFActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, NDNCameraMjLiveActivity.this.strName);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, NDNCameraMjLiveActivity.this.strDID);
                NDNCameraMjLiveActivity.this.startActivity(intent);
                NDNCameraMjLiveActivity.this.finish();
            }
        });
        this.popupWindow_more_funtion = new PopupWindow(this.popv_more_funtion, -1, -2);
        this.popupWindow_more_funtion.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_more_funtion.setFocusable(true);
        this.popupWindow_more_funtion.setInputMethodMode(1);
        this.popupWindow_more_funtion.setSoftInputMode(16);
        this.popupWindow_more_funtion.setOutsideTouchable(true);
        this.popupWindow_more_funtion.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_more_funtion.setFocusableInTouchMode(true);
        this.popv_more_funtion.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 82) {
                    return false;
                }
                NDNCameraMjLiveActivity.this.popupWindow_more_funtion.dismiss();
                return false;
            }
        });
        this.popupWindow_more_funtion.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                NDNCameraMjLiveActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popupWindow_more_funtion.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                NDNCameraMjLiveActivity.this.popupWindow_more_funtion.dismiss();
                return false;
            }
        });
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
                NDNCameraMjLiveActivity.this.popupWindow_Icut.dismiss();
                return false;
            }
        });
        this.popupWindow_Icut.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                NDNCameraMjLiveActivity.this.popupWindow_Icut.dismiss();
            }
        });
        this.popupWindow_Icut.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                NDNCameraMjLiveActivity.this.popupWindow_Icut.dismiss();
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
                NDNCameraMjLiveActivity.this.popupWindow_hight.dismiss();
                return false;
            }
        });
        this.popupWindow_hight.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                NDNCameraMjLiveActivity.this.popupWindow_hight.dismiss();
            }
        });
        this.popupWindow_hight.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                NDNCameraMjLiveActivity.this.popupWindow_hight.dismiss();
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
                    NDNCameraMjLiveActivity.this.savePicToSDcard(bitmap);
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0080 A[SYNTHETIC, Splitter:B:30:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008c A[SYNTHETIC, Splitter:B:38:0x008c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:12:0x0043=Splitter:B:12:0x0043, B:35:0x0088=Splitter:B:35:0x0088, B:17:0x004a=Splitter:B:17:0x004a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void savePicToSDcard(android.graphics.Bitmap r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = r6.getStrDate()     // Catch:{ all -> 0x0095 }
            r1 = 10
            r2 = 0
            r0.substring(r2, r1)     // Catch:{ all -> 0x0095 }
            r0 = 0
            java.lang.String r1 = com.shix.shixipc.utils.CommonUtil.getFileNameWithTime(r2)     // Catch:{ all -> 0x0095 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0056 }
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0056 }
            java.lang.String r5 = "YGCamera/Snapshot/ALLFile"
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0056 }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0056 }
            if (r4 != 0) goto L_0x0024
            r3.mkdirs()     // Catch:{ Exception -> 0x0056 }
        L_0x0024:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0056 }
            r4.<init>(r3, r1)     // Catch:{ Exception -> 0x0056 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0056 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0056 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            r3 = 100
            boolean r7 = r7.compress(r0, r3, r1)     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            if (r7 == 0) goto L_0x0043
            r1.flush()     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            com.shix.shixipc.activity.NDNCameraMjLiveActivity$30 r7 = new com.shix.shixipc.activity.NDNCameraMjLiveActivity$30     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            r7.<init>()     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            r6.runOnUiThread(r7)     // Catch:{ Exception -> 0x0051, all -> 0x004e }
        L_0x0043:
            r6.isPictSave = r2     // Catch:{ all -> 0x0095 }
            r1.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x0086
        L_0x0049:
            r7 = move-exception
        L_0x004a:
            r7.printStackTrace()     // Catch:{ all -> 0x0095 }
            goto L_0x0086
        L_0x004e:
            r7 = move-exception
            r0 = r1
            goto L_0x0088
        L_0x0051:
            r7 = move-exception
            r0 = r1
            goto L_0x0057
        L_0x0054:
            r7 = move-exception
            goto L_0x0088
        L_0x0056:
            r7 = move-exception
        L_0x0057:
            com.shix.shixipc.activity.NDNCameraMjLiveActivity$31 r1 = new com.shix.shixipc.activity.NDNCameraMjLiveActivity$31     // Catch:{ all -> 0x0054 }
            r1.<init>()     // Catch:{ all -> 0x0054 }
            r6.runOnUiThread(r1)     // Catch:{ all -> 0x0054 }
            java.lang.String r1 = "tag"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            r3.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = "exception:"
            r3.append(r4)     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r7.getMessage()     // Catch:{ all -> 0x0054 }
            r3.append(r4)     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0054 }
            android.util.Log.d(r1, r3)     // Catch:{ all -> 0x0054 }
            r7.printStackTrace()     // Catch:{ all -> 0x0054 }
            r6.isPictSave = r2     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x0086
            r0.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0086
        L_0x0084:
            r7 = move-exception
            goto L_0x004a
        L_0x0086:
            monitor-exit(r6)
            return
        L_0x0088:
            r6.isPictSave = r2     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x0094
            r0.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0095 }
        L_0x0094:
            throw r7     // Catch:{ all -> 0x0095 }
        L_0x0095:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x0099
        L_0x0098:
            throw r7
        L_0x0099:
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.NDNCameraMjLiveActivity.savePicToSDcard(android.graphics.Bitmap):void");
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    public void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        CustomVideoRecord customVideoRecord2;
        byte[] bArr2 = bArr;
        int i6 = i;
        int i7 = i3;
        int i8 = i4;
        String str2 = str;
        if (str.endsWith(this.strDID)) {
            if (!this.bDisplayFinished) {
                CommonUtil.Log(1, "SHIXNEWDOOR return bDisplayFinished");
                return;
            }
            this.devDecoderCount1++;
            CommonUtil.Log(1, "callBaceVideoData width:" + i3 + "  height:" + i4 + "  h264Data:" + i);
            this.bDisplayFinished = false;
            this.videodata = bArr2;
            this.videoDataLen = i2;
            this.isH264Data = i6;
            Message message = new Message();
            if (i6 == 1) {
                this.nVideoWidth = i7;
                this.nVideoHeight = i8;
                if (this.isTakepic) {
                    this.isTakepic = false;
                    byte[] bArr3 = new byte[(i7 * i8 * 2)];
                    NativeCaller.YUV4202RGB565(bArr, bArr3, i3, i4);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr3);
                    this.mBmp = Bitmap.createBitmap(i3, i4, Bitmap.Config.RGB_565);
                    this.mBmp.copyPixelsFromBuffer(wrap);
                    takePicture(this.mBmp);
                }
                message.what = 1;
            } else {
                if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
                    long time = new Date().getTime();
                    int i9 = (int) (time - this.videotime);
                    Log.d(RemoteMessageConst.Notification.TAG, "play  tspan:" + i9);
                    this.videotime = time;
                    this.customVideoRecord.VideoRecordData(3, bArr, 0, 0, i9);
                }
                message.what = 2;
            }
            this.mHandler.sendMessage(message);
        }
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
            Log.d(RemoteMessageConst.Notification.TAG, "play  tspan:" + i3);
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
