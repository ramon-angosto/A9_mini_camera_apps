package com.shix.shixipc.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
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
import android.view.SurfaceView;
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
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.CameraParmsModel;
import com.shix.shixipc.bean.VideoMode;
import com.shix.shixipc.glview.MyLiveViewGLMonitor;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.AudioPlayer;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.CustomAudioRecorder;
import com.shix.shixipc.utils.CustomBuffer;
import com.shix.shixipc.utils.CustomBufferData;
import com.shix.shixipc.utils.CustomBufferHead;
import com.shix.shixipc.utils.CustomVideoRecord;
import com.shix.shixipc.utils.H264HardDecoder;
import com.shix.shixipc.utils.HardVideoBuffer;
import com.shix.shixipc.utils.TakeVideoThread;
import com.shix.shixipc.utils.TimeUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import object.p2pipcam.nativecaller.MyRender;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;

public class HardDNCameraLiveActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener, NUIMainActivity.PlayInterface, NUIMainActivity.VideoTransInterface, NUIMainActivity.SHIXCOMMONInterface, CustomAudioRecorder.AudioRecordResult, NUIMainActivity.P2PMpdeInterface {
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
    private final int VIEDETYRANVALUE = 1239;
    private float action_down_x;
    private float action_down_y;
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
    public float bottom;
    private Button btnTouch;
    ImageButton btn_full;
    private Button btn_hl;
    /* access modifiers changed from: private */
    public Button button_2k;
    /* access modifiers changed from: private */
    public Button button_4k;
    CameraParmsModel cameraParmsModel;
    /* access modifiers changed from: private */
    public int checkCount = 0;
    private long clickTimeDown = 0;
    private long clickTimeUp = 0;
    private CustomAudioRecorder customAudioRecorder = null;
    private CustomVideoRecord customVideoRecord = null;
    private int devMode;
    /* access modifiers changed from: private */
    public int devType;
    private Dialog dlgExit;
    private String dnAccount = "";
    /* access modifiers changed from: private */
    public int flipping = 0;
    /* access modifiers changed from: private */
    public MyLiveViewGLMonitor glVideo;
    /* access modifiers changed from: private */
    public H264HardDecoder h264HardDecoder = null;
    /* access modifiers changed from: private */
    public byte[] h264byte;
    /* access modifiers changed from: private */
    public int hardHeight = 1080;
    /* access modifiers changed from: private */
    public HardVideoBuffer hardVideoBuffer = null;
    /* access modifiers changed from: private */
    public int hardWidth = 1920;
    public float height;
    /* access modifiers changed from: private */
    public Button icut0;
    /* access modifiers changed from: private */
    public Button icut1;
    /* access modifiers changed from: private */
    public Button icut2;
    private ImageView im_audio;
    private ImageView im_audio_l;
    private ImageView im_ircut;
    private ImageView im_jx_rl;
    private ImageView im_jx_ud;
    /* access modifiers changed from: private */
    public ImageView im_k;
    private ImageView im_more;
    private ImageView im_more_l;
    private ImageView im_pic;
    private ImageView im_pic_l;
    /* access modifiers changed from: private */
    public ImageView im_t;
    private ImageView im_talk;
    private ImageView im_talk_l;
    private ImageView im_video;
    private ImageView im_video_l;
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
    public boolean isH265 = false;
    /* access modifiers changed from: private */
    public boolean isOneShow = true;
    /* access modifiers changed from: private */
    public boolean isOnpause = false;
    private boolean isPictSave = false;
    private boolean isPlayingAudio = false;
    private boolean isPlayingRecord = false;
    private boolean isPlayingVideo = false;
    private boolean isRecordVideo = false;
    private boolean isStartHard = false;
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
    public ImageView ivBattery1;
    /* access modifiers changed from: private */
    public ImageView ivBatterying;
    private ImageView ivRecordTips;
    float lastX;
    float lastY;
    private int led_mode;
    public float left;
    private int light;
    private LinearLayout llRecordTips;
    private LinearLayout llSee_batmode;
    private LinearLayout llSee_videomode;
    private LinearLayout ll_audio;
    private LinearLayout ll_audio_l;
    /* access modifiers changed from: private */
    public RelativeLayout ll_batstatus;
    private LinearLayout ll_landscreen_buttom;
    private LinearLayout ll_more;
    private LinearLayout ll_more_l;
    private LinearLayout ll_pic;
    private LinearLayout ll_pic_l;
    private LinearLayout ll_r_f;
    private LinearLayout ll_talk;
    private LinearLayout ll_talk_l;
    private LinearLayout ll_video;
    private LinearLayout ll_video_l;
    private RelativeLayout lyHeader;
    /* access modifiers changed from: private */
    public Bitmap mBmp;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            Message message2 = message;
            int i = message2.what;
            if (i == 1) {
                if (HardDNCameraLiveActivity.this.isOneShow) {
                    boolean unused = HardDNCameraLiveActivity.this.isOneShow = false;
                    boolean unused2 = HardDNCameraLiveActivity.this.isDateComeOn = true;
                    HardDNCameraLiveActivity.this.findViewById(R.id.progressBar).setVisibility(8);
                }
                HardDNCameraLiveActivity.this.glVideo.setYuvFrameData(HardDNCameraLiveActivity.this.videodata, HardDNCameraLiveActivity.this.nVideoWidth, HardDNCameraLiveActivity.this.nVideoHeight);
                if (HardDNCameraLiveActivity.this.tv_test.isShown()) {
                    HardDNCameraLiveActivity hardDNCameraLiveActivity = HardDNCameraLiveActivity.this;
                    int unused3 = hardDNCameraLiveActivity.oldLen = hardDNCameraLiveActivity.nowLen;
                    HardDNCameraLiveActivity.this.tvName.setText("" + HardDNCameraLiveActivity.this.oldLen);
                }
            } else if (i == 2) {
                if (HardDNCameraLiveActivity.this.isOneShow) {
                    boolean unused4 = HardDNCameraLiveActivity.this.isDateComeOn = true;
                    boolean unused5 = HardDNCameraLiveActivity.this.isOneShow = false;
                    boolean unused6 = HardDNCameraLiveActivity.this.isDateComeOn = true;
                    HardDNCameraLiveActivity.this.findViewById(R.id.progressBar).setVisibility(8);
                    HardDNCameraLiveActivity.this.glVideo.setVisibility(8);
                    boolean unused7 = HardDNCameraLiveActivity.this.isOneShow = false;
                }
                HardDNCameraLiveActivity hardDNCameraLiveActivity2 = HardDNCameraLiveActivity.this;
                Bitmap unused8 = hardDNCameraLiveActivity2.mBmp = BitmapFactory.decodeByteArray(hardDNCameraLiveActivity2.videodata, 0, HardDNCameraLiveActivity.this.videoDataLen);
                if (HardDNCameraLiveActivity.this.mBmp == null) {
                    boolean unused9 = HardDNCameraLiveActivity.this.bDisplayFinished = true;
                    return;
                }
                int width = HardDNCameraLiveActivity.this.getWindowManager().getDefaultDisplay().getWidth();
                int height = HardDNCameraLiveActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                HardDNCameraLiveActivity hardDNCameraLiveActivity3 = HardDNCameraLiveActivity.this;
                int unused10 = hardDNCameraLiveActivity3.nVideoWidth = hardDNCameraLiveActivity3.mBmp.getWidth();
                HardDNCameraLiveActivity hardDNCameraLiveActivity4 = HardDNCameraLiveActivity.this;
                int unused11 = hardDNCameraLiveActivity4.nVideoHeight = hardDNCameraLiveActivity4.mBmp.getHeight();
                if (HardDNCameraLiveActivity.this.getResources().getConfiguration().orientation == 1) {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(HardDNCameraLiveActivity.this.mBmp, width, (width * 3) / 4, true);
                    HardDNCameraLiveActivity.this.videoView.setVisibility(0);
                    HardDNCameraLiveActivity.this.videoView.setImageBitmap(createScaledBitmap);
                } else if (HardDNCameraLiveActivity.this.getResources().getConfiguration().orientation == 2) {
                    Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(HardDNCameraLiveActivity.this.mBmp, width, height, true);
                    HardDNCameraLiveActivity.this.videoView.setVisibility(0);
                    HardDNCameraLiveActivity.this.videoView.setImageBitmap(createScaledBitmap2);
                }
                if (HardDNCameraLiveActivity.this.isTakepic) {
                    boolean unused12 = HardDNCameraLiveActivity.this.isTakepic = false;
                    HardDNCameraLiveActivity hardDNCameraLiveActivity5 = HardDNCameraLiveActivity.this;
                    hardDNCameraLiveActivity5.takePicture(hardDNCameraLiveActivity5.mBmp);
                }
            } else if (i != 23) {
                if (i != 1239) {
                    if (i == 123321) {
                        HardDNCameraLiveActivity.this.showToast((int) R.string.camera_not_online);
                        HardDNCameraLiveActivity.this.finish();
                    }
                } else if (HardDNCameraLiveActivity.this.isCheckVideo) {
                    if (!HardDNCameraLiveActivity.this.myGLSurfaceView.isShown()) {
                        HardDNCameraLiveActivity.this.myGLSurfaceView.setVisibility(0);
                    }
                    if (HardDNCameraLiveActivity.this.isOneShow) {
                        try {
                            int timeInMillis = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
                            Log.d("tag", "tz:" + ((-TimeZone.getDefault().getRawOffset()) / 1000));
                            Log.d("tag", "tz:" + timeInMillis + "");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pro", "set_datetime");
                            jSONObject.put("cmd", 126);
                            jSONObject.put("user", SystemValue.doorBellAdmin);
                            jSONObject.put("pwd", SystemValue.doorBellPass);
                            jSONObject.put("time", timeInMillis);
                            NativeCaller.TransferMessage(HardDNCameraLiveActivity.this.strDID, jSONObject.toString(), 0);
                            if (HardDNCameraLiveActivity.this.devType != 1000) {
                                if (HardDNCameraLiveActivity.this.devType == 1001) {
                                    NativeCaller.TransferMessage(HardDNCameraLiveActivity.this.strDID, CommonUtil.SHIX_RegistPushFCM(SystemValue.doorBellAdmin, SystemValue.doorBellPass, HardDNCameraLiveActivity.this.strDID, HardDNCameraLiveActivity.this.strUUID, timeInMillis, ContentCommon.FCM_TOKEN, HardDNCameraLiveActivity.this.strName), 0);
                                } else {
                                    NativeCaller.TransferMessage(HardDNCameraLiveActivity.this.strDID, CommonUtil.SHIX_RegistPush(SystemValue.doorBellAdmin, SystemValue.doorBellPass, HardDNCameraLiveActivity.this.strDID, HardDNCameraLiveActivity.this.strUUID, timeInMillis, ContentCommon.FCM_TOKEN, HardDNCameraLiveActivity.this.strName), 0);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        boolean unused13 = HardDNCameraLiveActivity.this.isOneShow = false;
                        boolean unused14 = HardDNCameraLiveActivity.this.isDateComeOn = true;
                        HardDNCameraLiveActivity.this.findViewById(R.id.progressBar).setVisibility(8);
                    }
                    if (HardDNCameraLiveActivity.this.h264HardDecoder == null) {
                        HardDNCameraLiveActivity hardDNCameraLiveActivity6 = HardDNCameraLiveActivity.this;
                        H264HardDecoder unused15 = hardDNCameraLiveActivity6.h264HardDecoder = new H264HardDecoder(hardDNCameraLiveActivity6.myGLSurfaceView.getHolder().getSurface(), HardDNCameraLiveActivity.this);
                        HardDNCameraLiveActivity.this.h264HardDecoder.H264HardStartDecoder(HardDNCameraLiveActivity.this.hardWidth, HardDNCameraLiveActivity.this.hardHeight, HardDNCameraLiveActivity.this.isH265);
                    }
                    VideoMode RemoveData = HardDNCameraLiveActivity.this.hardVideoBuffer.RemoveData();
                    if (RemoveData != null) {
                        if (HardDNCameraLiveActivity.this.h264HardDecoder != null) {
                            HardDNCameraLiveActivity.this.h264HardDecoder.H264HardDecoderOneFram(RemoveData.getVideo(), RemoveData.getVideo().length, HardDNCameraLiveActivity.this.hardWidth, HardDNCameraLiveActivity.this.hardHeight, RemoveData.getType());
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (HardDNCameraLiveActivity.this.cameraParmsModel != null) {
                HardDNCameraLiveActivity.this.seekBar1.setProgress(HardDNCameraLiveActivity.this.cameraParmsModel.getMic());
                HardDNCameraLiveActivity.this.seekBar2.setProgress(HardDNCameraLiveActivity.this.cameraParmsModel.getSpk());
                HardDNCameraLiveActivity.this.tvSee1.setText(String.valueOf(HardDNCameraLiveActivity.this.cameraParmsModel.getMic()));
                HardDNCameraLiveActivity.this.tvSee2.setText(String.valueOf(HardDNCameraLiveActivity.this.cameraParmsModel.getSpk()));
                HardDNCameraLiveActivity hardDNCameraLiveActivity7 = HardDNCameraLiveActivity.this;
                int unused16 = hardDNCameraLiveActivity7.batcapacity = hardDNCameraLiveActivity7.cameraParmsModel.getBatvalue();
                HardDNCameraLiveActivity.this.batcapacity + "%";
                HardDNCameraLiveActivity.this.ll_batstatus.setVisibility(0);
                HardDNCameraLiveActivity.this.tv_Electricity.setText("");
                ImageView access$5200 = HardDNCameraLiveActivity.this.ivBattery;
                HardDNCameraLiveActivity hardDNCameraLiveActivity8 = HardDNCameraLiveActivity.this;
                access$5200.setImageResource(hardDNCameraLiveActivity8.getBatteryRes(hardDNCameraLiveActivity8.batcapacity));
                ImageView access$5300 = HardDNCameraLiveActivity.this.ivBattery1;
                HardDNCameraLiveActivity hardDNCameraLiveActivity9 = HardDNCameraLiveActivity.this;
                access$5300.setImageResource(hardDNCameraLiveActivity9.getBatteryRes(hardDNCameraLiveActivity9.batcapacity));
                if (HardDNCameraLiveActivity.this.cameraParmsModel.getBatstatus() == 1) {
                    HardDNCameraLiveActivity.this.ivBatterying.setVisibility(0);
                } else {
                    HardDNCameraLiveActivity.this.ivBatterying.setVisibility(4);
                }
                if (HardDNCameraLiveActivity.this.cameraParmsModel.getRotmir() == 0) {
                    int unused17 = HardDNCameraLiveActivity.this.mirror = 0;
                    int unused18 = HardDNCameraLiveActivity.this.flipping = 0;
                } else if (HardDNCameraLiveActivity.this.cameraParmsModel.getRotmir() == 1) {
                    int unused19 = HardDNCameraLiveActivity.this.mirror = 1;
                    int unused20 = HardDNCameraLiveActivity.this.flipping = 0;
                } else if (HardDNCameraLiveActivity.this.cameraParmsModel.getRotmir() == 2) {
                    int unused21 = HardDNCameraLiveActivity.this.mirror = 0;
                    int unused22 = HardDNCameraLiveActivity.this.flipping = 1;
                } else if (HardDNCameraLiveActivity.this.cameraParmsModel.getRotmir() == 3) {
                    int unused23 = HardDNCameraLiveActivity.this.mirror = 1;
                    int unused24 = HardDNCameraLiveActivity.this.flipping = 1;
                }
                if (HardDNCameraLiveActivity.this.cameraParmsModel.getLamp() == 1) {
                    HardDNCameraLiveActivity.this.im_zsd.setImageResource(R.mipmap.n_playview_t_zsd_open);
                } else {
                    HardDNCameraLiveActivity.this.im_zsd.setImageResource(R.mipmap.n_playview_t_zsd);
                }
                if (HardDNCameraLiveActivity.this.cameraParmsModel.getIcut() == 2) {
                    HardDNCameraLiveActivity.this.icut2.setTextColor(HardDNCameraLiveActivity.this.getResources().getColor(R.color.color_n_status_offline));
                    HardDNCameraLiveActivity.this.icut1.setTextColor(HardDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                    HardDNCameraLiveActivity.this.icut0.setTextColor(HardDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                } else if (HardDNCameraLiveActivity.this.cameraParmsModel.getIcut() == 1) {
                    HardDNCameraLiveActivity.this.icut1.setTextColor(HardDNCameraLiveActivity.this.getResources().getColor(R.color.color_n_status_offline));
                    HardDNCameraLiveActivity.this.icut2.setTextColor(HardDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                    HardDNCameraLiveActivity.this.icut0.setTextColor(HardDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                } else {
                    HardDNCameraLiveActivity.this.icut0.setTextColor(HardDNCameraLiveActivity.this.getResources().getColor(R.color.color_n_status_offline));
                    HardDNCameraLiveActivity.this.icut1.setTextColor(HardDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                    HardDNCameraLiveActivity.this.icut2.setTextColor(HardDNCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                }
                if (HardDNCameraLiveActivity.this.cameraParmsModel.getClockScreen() == 1 || HardDNCameraLiveActivity.this.cameraParmsModel.getClockScreen() == 2) {
                    HardDNCameraLiveActivity.this.im_t.setImageResource(R.mipmap.n_playview_t_zsd_tclose);
                } else {
                    HardDNCameraLiveActivity.this.im_t.setImageResource(R.mipmap.n_playview_t_zsd_topen);
                }
                HardDNCameraLiveActivity.this.seekBar12.setProgress(HardDNCameraLiveActivity.this.cameraParmsModel.getBright());
                HardDNCameraLiveActivity.this.seekBar11.setProgress(HardDNCameraLiveActivity.this.cameraParmsModel.getContrast());
                HardDNCameraLiveActivity.this.tvSee12.setText(String.valueOf(HardDNCameraLiveActivity.this.cameraParmsModel.getBright()));
                HardDNCameraLiveActivity.this.tvSee11.setText(String.valueOf(HardDNCameraLiveActivity.this.cameraParmsModel.getContrast()));
                if (HardDNCameraLiveActivity.this.cameraParmsModel.getIsShowClock() == 0) {
                    HardDNCameraLiveActivity.this.findViewById(R.id.ll_t).setVisibility(8);
                } else {
                    HardDNCameraLiveActivity.this.findViewById(R.id.ll_t).setVisibility(0);
                }
                if (HardDNCameraLiveActivity.this.cameraParmsModel.getIsShowPower() == 0) {
                    HardDNCameraLiveActivity.this.ivBattery.setVisibility(8);
                } else {
                    HardDNCameraLiveActivity.this.ivBattery.setVisibility(0);
                }
                if (HardDNCameraLiveActivity.this.cameraParmsModel.getIsShowIcutAuto() == 0) {
                    HardDNCameraLiveActivity.this.icut2.setVisibility(8);
                } else {
                    HardDNCameraLiveActivity.this.icut2.setVisibility(0);
                }
                if (HardDNCameraLiveActivity.this.cameraParmsModel.getIsShow4KMenu() == 0) {
                    HardDNCameraLiveActivity.this.button_4k.setVisibility(8);
                    HardDNCameraLiveActivity.this.button_2k.setVisibility(8);
                    HardDNCameraLiveActivity.this.view_4k.setVisibility(8);
                    HardDNCameraLiveActivity.this.view_2k.setVisibility(8);
                    HardDNCameraLiveActivity.this.im_k.setImageResource(R.mipmap.n_playview_t_720);
                } else {
                    HardDNCameraLiveActivity.this.button_4k.setVisibility(0);
                    HardDNCameraLiveActivity.this.button_2k.setVisibility(0);
                    HardDNCameraLiveActivity.this.view_4k.setVisibility(0);
                    HardDNCameraLiveActivity.this.view_2k.setVisibility(0);
                }
            }
            if (message2.what == 1 || message2.what == 2) {
                boolean unused25 = HardDNCameraLiveActivity.this.bDisplayFinished = true;
            }
        }
    };
    private WifiManager mWifiManager;
    /* access modifiers changed from: private */
    public int mirror = 0;
    int moveX;
    int moveY;
    float move_x;
    float move_y;
    /* access modifiers changed from: private */
    public SurfaceView myGLSurfaceView;
    private MyRender myRender;
    double nLenStart = 0.0d;
    /* access modifiers changed from: private */
    public int nVideoHeight = 0;
    /* access modifiers changed from: private */
    public int nVideoWidth = 0;
    /* access modifiers changed from: private */
    public int nowFram = 0;
    /* access modifiers changed from: private */
    public int nowLen = 0;
    /* access modifiers changed from: private */
    public long nowSize = 0;
    /* access modifiers changed from: private */
    public int oldFram = 0;
    /* access modifiers changed from: private */
    public int oldLen = 0;
    /* access modifiers changed from: private */
    public long oldSize = 0;
    int p2pmode = -1;
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
            int i = message.what;
            if (i == 4) {
                HardDNCameraLiveActivity.access$1108(HardDNCameraLiveActivity.this);
                HardDNCameraLiveActivity.this.tvRecordTime.setText(TimeUtil.getTimeDesc(HardDNCameraLiveActivity.this.recordTime));
                HardDNCameraLiveActivity.this.refreshUIHandler.sendEmptyMessageDelayed(4, 1000);
            } else if (i == 12345) {
                HardDNCameraLiveActivity hardDNCameraLiveActivity = HardDNCameraLiveActivity.this;
                long unused = hardDNCameraLiveActivity.oldSize = hardDNCameraLiveActivity.nowSize;
                HardDNCameraLiveActivity hardDNCameraLiveActivity2 = HardDNCameraLiveActivity.this;
                int unused2 = hardDNCameraLiveActivity2.oldFram = hardDNCameraLiveActivity2.nowFram;
                CommonUtil.Log(1, "ZHAOPLAY oldSize: " + (HardDNCameraLiveActivity.this.oldSize / 1024) + " K");
                if (HardDNCameraLiveActivity.this.p2pmode == 0) {
                    TextView access$1000 = HardDNCameraLiveActivity.this.tv_test;
                    access$1000.setText((HardDNCameraLiveActivity.this.oldSize / 1024) + " K  P2P:" + HardDNCameraLiveActivity.this.p2pmode + "   F:" + HardDNCameraLiveActivity.this.oldFram + "  " + HardDNCameraLiveActivity.this.nVideoWidth + "*" + HardDNCameraLiveActivity.this.nVideoHeight + " \n  " + HardDNCameraLiveActivity.this.testIp1 + "  " + HardDNCameraLiveActivity.this.testIp2 + "  " + HardDNCameraLiveActivity.this.testIp3);
                } else {
                    TextView access$10002 = HardDNCameraLiveActivity.this.tv_test;
                    access$10002.setText((HardDNCameraLiveActivity.this.oldSize / 1024) + " K  Relay:" + HardDNCameraLiveActivity.this.p2pmode + "   F:" + HardDNCameraLiveActivity.this.oldFram + "  " + HardDNCameraLiveActivity.this.nVideoWidth + "*" + HardDNCameraLiveActivity.this.nVideoHeight + " \n  " + HardDNCameraLiveActivity.this.testIp1 + "  " + HardDNCameraLiveActivity.this.testIp2 + "  " + HardDNCameraLiveActivity.this.testIp3);
                }
                long unused3 = HardDNCameraLiveActivity.this.nowSize = 0;
                int unused4 = HardDNCameraLiveActivity.this.nowFram = 0;
            }
        }
    };
    private Dialog restartDialog;
    int ret = 0;
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
    private StatFs stat;
    private String status = null;
    /* access modifiers changed from: private */
    public String strDID = null;
    /* access modifiers changed from: private */
    public String strName = null;
    private String strPwd = null;
    /* access modifiers changed from: private */
    public String strStrJson = "";
    /* access modifiers changed from: private */
    public String strUUID = "";
    private String strUser = null;
    public String strVideoName = "";
    private TakeVideoThread takeVideoThread = null;
    String testIp1;
    String testIp2;
    String testIp3;
    private int timeCount = 0;
    private long totalBlocks;
    TextView tvName;
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
    private TextView tv_audio_l;
    private TextView tv_more;
    private TextView tv_more_l;
    private TextView tv_pic;
    private TextView tv_pic_l;
    private TextView tv_talk;
    private TextView tv_talk_l;
    /* access modifiers changed from: private */
    public TextView tv_test;
    private TextView tv_video;
    private TextView tv_video_l;
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    /* access modifiers changed from: private */
    public int videoRes = 0;
    /* access modifiers changed from: private */
    public ImageView videoView;
    /* access modifiers changed from: private */
    public byte[] videodata = null;
    private long videotime = 0;
    private View viewSee_batmode;
    private View viewSee_videomode;
    /* access modifiers changed from: private */
    public View view_2k;
    /* access modifiers changed from: private */
    public View view_4k;
    public float width;
    int xlenOld;
    int ylenOld;

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

    static /* synthetic */ int access$1108(HardDNCameraLiveActivity hardDNCameraLiveActivity) {
        int i = hardDNCameraLiveActivity.recordTime;
        hardDNCameraLiveActivity.recordTime = i + 1;
        return i;
    }

    static /* synthetic */ int access$308(HardDNCameraLiveActivity hardDNCameraLiveActivity) {
        int i = hardDNCameraLiveActivity.checkCount;
        hardDNCameraLiveActivity.checkCount = i + 1;
        return i;
    }

    public void CallBack_Checkhandle(String str, String str2, String str3, String str4, int i) {
        this.testIp1 = str2;
        this.testIp2 = str3;
        this.testIp3 = str4;
        this.p2pmode = i;
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
            while (HardDNCameraLiveActivity.this.isCheckVideo) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                HardDNCameraLiveActivity.this.refreshUIHandler.sendEmptyMessage(12345);
                if (HardDNCameraLiveActivity.this.isCheckVideo) {
                    if (HardDNCameraLiveActivity.this.isOnpause) {
                        int unused = HardDNCameraLiveActivity.this.checkCount = 0;
                    } else {
                        HardDNCameraLiveActivity.access$308(HardDNCameraLiveActivity.this);
                        int access$300 = HardDNCameraLiveActivity.this.checkCount % 5;
                    }
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
        setContentView(R.layout.activity_camera_live_dn_hard);
        this.isDateComeOn = false;
        getDataFromOther();
        this.preRet = getSharedPreferences(ContentCommon.SHIX_SHARE_BAT, 0);
        this.audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.glVideo = (MyLiveViewGLMonitor) findViewById(R.id.glVideo);
        this.glVideo.setOnTouchListener(this);
        this.isFullscreen = false;
        this.isExitActivity = false;
        this.customVideoRecord = new CustomVideoRecord(this.strDID);
        this.hardVideoBuffer = new HardVideoBuffer();
        initView();
        initAnim();
        initExitPopupWindow_more_funtion();
        initExitPopupWindow_Hight();
        initExitPopupWindow_Icut();
        initListen();
        initExitDialog();
        NUIMainActivity.setP2PMpdeInterface(this);
        NUIMainActivity.setVideoTransInterface(this);
        NUIMainActivity.setPlayInterface(this);
        this.hardWidth = 640;
        this.hardHeight = 480;
        NativeCaller.StartPPPPLivestream(this.strDID, 4);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.SHIX_getSPKMICParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getCameraParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        NativeCaller.PPPPCheckHanle(this.strDID);
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
        this.isCheckVideo = true;
        new CheckThread().start();
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
            this.strUUID = intent.getStringExtra(ContentCommon.STR_APP_UUID);
            this.devType = intent.getIntExtra(ContentCommon.STR_CAMERA_DEVTYPE, 0);
            this.devMode = intent.getIntExtra(ContentCommon.STR_CAMERA_DEVMODE, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        finish();
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
        this.myGLSurfaceView = (SurfaceView) findViewById(R.id.hdsurfaceview1);
        this.tv_test = (TextView) findViewById(R.id.tv_test);
        this.videoView = (ImageView) findViewById(R.id.videoView);
        this.tvName = (TextView) findViewById(R.id.tvHeaderTitle);
        this.tvName.setText(this.strName);
        this.tvName.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                HardDNCameraLiveActivity.this.tv_test.setVisibility(0);
                return false;
            }
        });
        this.tv_Electricity = (TextView) findViewById(R.id.tv_Electricity);
        this.ivBattery = (ImageView) findViewById(R.id.ivBattery);
        this.ivBattery1 = (ImageView) findViewById(R.id.ivBattery1);
        this.ivBatterying = (ImageView) findViewById(R.id.ivBatterying);
        this.btnTouch = (Button) findViewById(R.id.btnTouch);
        this.btnTouch.setOnClickListener(this);
        this.ll_batstatus = (RelativeLayout) findViewById(R.id.ll_batstatus);
        this.llRecordTips = (LinearLayout) findViewById(R.id.llRecordTips);
        this.ivRecordTips = (ImageView) this.llRecordTips.findViewById(R.id.ivRecordTips);
        this.tvRecordTime = (TextView) this.llRecordTips.findViewById(R.id.tvRecordTime);
        this.shix_LL_buttom = (LinearLayout) findViewById(R.id.shix_LL_buttom);
        this.ll_landscreen_buttom = (LinearLayout) findViewById(R.id.ll_landscreen_buttom);
        this.ll_r_f = (LinearLayout) findViewById(R.id.ll_r_f);
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
        this.ll_video_l = (LinearLayout) findViewById(R.id.ll_video_l);
        this.ll_pic_l = (LinearLayout) findViewById(R.id.ll_pic_l);
        this.ll_talk_l = (LinearLayout) findViewById(R.id.ll_talk_l);
        this.ll_audio_l = (LinearLayout) findViewById(R.id.ll_audio_l);
        this.ll_more_l = (LinearLayout) findViewById(R.id.ll_more_l);
        this.im_video_l = (ImageView) findViewById(R.id.im_video_l);
        this.im_pic_l = (ImageView) findViewById(R.id.im_pic_l);
        this.im_talk_l = (ImageView) findViewById(R.id.im_talk_l);
        this.im_audio_l = (ImageView) findViewById(R.id.im_audio_l);
        this.im_more_l = (ImageView) findViewById(R.id.im_more_l);
        this.tv_video_l = (TextView) findViewById(R.id.tv_video_l);
        this.tv_pic_l = (TextView) findViewById(R.id.tv_pic_l);
        this.tv_talk_l = (TextView) findViewById(R.id.tv_talk_l);
        this.tv_audio_l = (TextView) findViewById(R.id.tv_audio_l);
        this.tv_more_l = (TextView) findViewById(R.id.tv_more_l);
        findViewById(R.id.ivOperator1).setOnClickListener(this);
        findViewById(R.id.ivOperator).setOnClickListener(this);
        this.btn_hl = (Button) findViewById(R.id.btn_hl);
        this.btn_full = (ImageButton) findViewById(R.id.btn_full);
        this.btn_full.setOnClickListener(this);
        this.btn_hl.setOnClickListener(this);
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
        this.ll_video_l.setOnTouchListener(this);
        this.ll_pic_l.setOnTouchListener(this);
        this.ll_talk_l.setOnTouchListener(this);
        this.ll_audio_l.setOnTouchListener(this);
        this.ll_more_l.setOnTouchListener(this);
        findViewById(R.id.ivBack).setOnClickListener(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.5625f));
        layoutParams.gravity = 17;
        this.myGLSurfaceView.setLayoutParams(layoutParams);
        this.btnTouch.setLayoutParams(layoutParams);
        this.ll_batstatus.setLayoutParams(layoutParams);
        this.btnTouch.setVisibility(8);
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
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.isCheckVideo = false;
        StopAudio();
        StopTalk();
        releaseTalk();
        CustomVideoRecord customVideoRecord2 = this.customVideoRecord;
        if (customVideoRecord2 != null) {
            customVideoRecord2.stopRecordVideo();
        }
        NativeCaller.StopPPPPLivestream(this.strDID);
        NUIMainActivity.setPlayInterface((NUIMainActivity.PlayInterface) null);
        NUIMainActivity.setVideoTransInterface((NUIMainActivity.VideoTransInterface) null);
        H264HardDecoder h264HardDecoder2 = this.h264HardDecoder;
        if (h264HardDecoder2 != null) {
            h264HardDecoder2.H264HardDesdoryDecoder();
            this.h264HardDecoder = null;
        }
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
            this.ll_landscreen_buttom.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.5625f));
            layoutParams.gravity = 17;
            if (this.strDID.startsWith("THPC")) {
                this.videoView.setLayoutParams(layoutParams);
            } else {
                this.myGLSurfaceView.setLayoutParams(layoutParams);
            }
            this.btnTouch.setLayoutParams(layoutParams);
            this.ll_batstatus.setLayoutParams(layoutParams);
            this.popupmore.setBackgroundColor(getResources().getColor(R.color.color_main));
            this.btnTouch.setVisibility(8);
            return;
        }
        this.isFullscreen = true;
        this.lyHeader.setVisibility(8);
        this.shix_LL_buttom.setVisibility(8);
        this.ll_landscreen_buttom.setVisibility(0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 49;
        if (this.strDID.startsWith("THPC")) {
            this.videoView.setLayoutParams(layoutParams2);
        } else {
            this.myGLSurfaceView.setLayoutParams(layoutParams2);
        }
        this.btnTouch.setLayoutParams(layoutParams2);
        this.btnTouch.setVisibility(8);
        this.popupmore.setBackgroundColor(getResources().getColor(R.color.color_main_90));
    }

    private void toggleFullscreen(boolean z) {
        if (z) {
            this.ivBattery.setVisibility(8);
            this.ivBattery1.setVisibility(0);
            setRequestedOrientation(0);
            return;
        }
        this.ivBattery.setVisibility(0);
        this.ivBattery1.setVisibility(8);
        setRequestedOrientation(1);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnTouch:
                if (this.shix_LL_buttom.isShown()) {
                    return;
                }
                if (this.ll_landscreen_buttom.isShown()) {
                    this.ll_landscreen_buttom.setVisibility(8);
                    return;
                } else {
                    this.ll_landscreen_buttom.setVisibility(0);
                    return;
                }
            case R.id.btn_full:
                if (!this.isFullscreen) {
                    toggleFullscreen(true);
                    this.isFullscreen = true;
                    return;
                }
                resetMonitorSize(false, 100000.0d);
                toggleFullscreen(false);
                this.isFullscreen = false;
                return;
            case R.id.btn_hl:
                if (this.isGQ) {
                    this.isGQ = false;
                    return;
                } else {
                    this.isGQ = true;
                    return;
                }
            case R.id.button_1080:
                this.popupWindow_hight.dismiss();
                if (!this.isFullscreen) {
                    if (this.cameraParmsModel.getIsShow4KMenu() == 0) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.5625f));
                        layoutParams.gravity = 17;
                        this.myGLSurfaceView.setLayoutParams(layoutParams);
                        this.btnTouch.setLayoutParams(layoutParams);
                        this.ll_batstatus.setLayoutParams(layoutParams);
                        this.btnTouch.setVisibility(8);
                    } else {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.5625f));
                        layoutParams2.gravity = 17;
                        this.myGLSurfaceView.setLayoutParams(layoutParams2);
                        this.btnTouch.setLayoutParams(layoutParams2);
                        this.ll_batstatus.setLayoutParams(layoutParams2);
                        this.btnTouch.setVisibility(8);
                    }
                }
                this.im_k.setImageResource(R.mipmap.n_playview_t_1080);
                if (this.videoRes != 1) {
                    new Thread() {
                        public void run() {
                            super.run();
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            NativeCaller.StopPPPPLivestream(HardDNCameraLiveActivity.this.strDID);
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            int unused = HardDNCameraLiveActivity.this.hardWidth = 1920;
                            int unused2 = HardDNCameraLiveActivity.this.hardHeight = 1080;
                            if (HardDNCameraLiveActivity.this.h264HardDecoder != null) {
                                HardDNCameraLiveActivity.this.h264HardDecoder.H264HardDesdoryDecoder();
                                H264HardDecoder unused3 = HardDNCameraLiveActivity.this.h264HardDecoder = null;
                            }
                            NativeCaller.StartPPPPLivestream(HardDNCameraLiveActivity.this.strDID, 3);
                            int unused4 = HardDNCameraLiveActivity.this.videoRes = 1;
                        }
                    }.start();
                    return;
                }
                return;
            case R.id.button_2k:
                this.popupWindow_hight.dismiss();
                if (!this.isFullscreen) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.625f));
                    layoutParams3.gravity = 17;
                    this.myGLSurfaceView.setLayoutParams(layoutParams3);
                    this.btnTouch.setLayoutParams(layoutParams3);
                    this.ll_batstatus.setLayoutParams(layoutParams3);
                    this.btnTouch.setVisibility(8);
                }
                this.im_k.setImageResource(R.mipmap.n_playview_t_2k);
                if (this.videoRes != 1) {
                    new Thread() {
                        public void run() {
                            super.run();
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            NativeCaller.StopPPPPLivestream(HardDNCameraLiveActivity.this.strDID);
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            int unused = HardDNCameraLiveActivity.this.hardWidth = 1920;
                            int unused2 = HardDNCameraLiveActivity.this.hardHeight = 1080;
                            if (HardDNCameraLiveActivity.this.h264HardDecoder != null) {
                                HardDNCameraLiveActivity.this.h264HardDecoder.H264HardDesdoryDecoder();
                                H264HardDecoder unused3 = HardDNCameraLiveActivity.this.h264HardDecoder = null;
                            }
                            NativeCaller.StartPPPPLivestream(HardDNCameraLiveActivity.this.strDID, 3);
                            int unused4 = HardDNCameraLiveActivity.this.videoRes = 1;
                        }
                    }.start();
                    return;
                }
                return;
            case R.id.button_4k:
                this.popupWindow_hight.dismiss();
                if (!this.isFullscreen) {
                    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.5625f));
                    layoutParams4.gravity = 17;
                    this.myGLSurfaceView.setLayoutParams(layoutParams4);
                    this.btnTouch.setLayoutParams(layoutParams4);
                    this.ll_batstatus.setLayoutParams(layoutParams4);
                    this.btnTouch.setVisibility(8);
                }
                this.im_k.setImageResource(R.mipmap.n_playview_t_4k);
                if (this.videoRes != 1) {
                    new Thread() {
                        public void run() {
                            super.run();
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            NativeCaller.StopPPPPLivestream(HardDNCameraLiveActivity.this.strDID);
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            if (HardDNCameraLiveActivity.this.h264HardDecoder != null) {
                                HardDNCameraLiveActivity.this.h264HardDecoder.H264HardDesdoryDecoder();
                                H264HardDecoder unused = HardDNCameraLiveActivity.this.h264HardDecoder = null;
                            }
                            int unused2 = HardDNCameraLiveActivity.this.hardWidth = 1920;
                            int unused3 = HardDNCameraLiveActivity.this.hardHeight = 1080;
                            NativeCaller.StartPPPPLivestream(HardDNCameraLiveActivity.this.strDID, 3);
                            int unused4 = HardDNCameraLiveActivity.this.videoRes = 1;
                        }
                    }.start();
                    return;
                }
                return;
            case R.id.button_720:
                this.popupWindow_hight.dismiss();
                if (!this.isFullscreen) {
                    if (this.cameraParmsModel.getIsShow4KMenu() == 0) {
                        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.625f));
                        layoutParams5.gravity = 17;
                        this.myGLSurfaceView.setLayoutParams(layoutParams5);
                        this.btnTouch.setLayoutParams(layoutParams5);
                        this.ll_batstatus.setLayoutParams(layoutParams5);
                        this.btnTouch.setVisibility(8);
                    } else {
                        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.75f));
                        layoutParams6.gravity = 17;
                        this.myGLSurfaceView.setLayoutParams(layoutParams6);
                        this.btnTouch.setLayoutParams(layoutParams6);
                        this.ll_batstatus.setLayoutParams(layoutParams6);
                        this.btnTouch.setVisibility(8);
                    }
                }
                this.im_k.setImageResource(R.mipmap.n_playview_t_720);
                if (this.videoRes != 2) {
                    new Thread() {
                        public void run() {
                            super.run();
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            NativeCaller.StopPPPPLivestream(HardDNCameraLiveActivity.this.strDID);
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            int unused = HardDNCameraLiveActivity.this.hardWidth = 640;
                            int unused2 = HardDNCameraLiveActivity.this.hardHeight = 480;
                            if (HardDNCameraLiveActivity.this.h264HardDecoder != null) {
                                HardDNCameraLiveActivity.this.h264HardDecoder.H264HardDesdoryDecoder();
                                H264HardDecoder unused3 = HardDNCameraLiveActivity.this.h264HardDecoder = null;
                            }
                            NativeCaller.StartPPPPLivestream(HardDNCameraLiveActivity.this.strDID, 4);
                            int unused4 = HardDNCameraLiveActivity.this.videoRes = 2;
                        }
                    }.start();
                    return;
                }
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
                this.popupWindow_Icut.showAsDropDown(this.im_ircut);
                return;
            case R.id.im_jx_rl:
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
            case R.id.im_jx_ud:
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
            case R.id.im_k:
                this.popupWindow_hight.showAsDropDown(this.im_k);
                return;
            case R.id.im_t:
                CameraParmsModel cameraParmsModel2 = this.cameraParmsModel;
                if (cameraParmsModel2 != null) {
                    if (cameraParmsModel2.getClockScreen() == 0) {
                        NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 1), 0);
                        this.cameraParmsModel.setClockScreen(1);
                        this.im_t.setImageResource(R.mipmap.n_playview_t_zsd_tclose);
                        return;
                    }
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 0), 0);
                    this.cameraParmsModel.setClockScreen(0);
                    this.im_t.setImageResource(R.mipmap.n_playview_t_zsd_topen);
                    return;
                }
                return;
            case R.id.im_zsd:
                CameraParmsModel cameraParmsModel3 = this.cameraParmsModel;
                if (cameraParmsModel3 != null) {
                    if (cameraParmsModel3.getLamp() == 0) {
                        NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 1), 0);
                        this.im_zsd.setImageResource(R.mipmap.n_playview_t_zsd_open);
                        this.cameraParmsModel.setLamp(1);
                        return;
                    }
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "lamp", 0), 0);
                    this.im_zsd.setImageResource(R.mipmap.n_playview_t_zsd);
                    this.cameraParmsModel.setLamp(0);
                    return;
                }
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
                Intent intent = new Intent(this, SettingActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
                startActivity(intent);
                finish();
                return;
            case R.id.tvCancel:
                this.dlgExit.dismiss();
                return;
            case R.id.tvExit:
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
            case R.id.ll_audio:
            case R.id.ll_audio_l:
                if (i == 0) {
                    if (!this.isAudio) {
                        StartAudio();
                        this.isAudioClick = true;
                        this.tv_audio.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                        this.tv_audio_l.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                        this.im_audio.setImageResource(R.mipmap.n_audios1);
                        this.im_audio_l.setImageResource(R.mipmap.n_audios1);
                        break;
                    } else {
                        StopAudio();
                        this.isAudioClick = false;
                        this.im_audio.setImageResource(R.mipmap.n_audios2);
                        this.im_audio_l.setImageResource(R.mipmap.n_audios2);
                        this.tv_audio.setTextColor(getResources().getColor(R.color.color_white));
                        this.tv_audio_l.setTextColor(getResources().getColor(R.color.color_white));
                        break;
                    }
                }
                break;
            case R.id.ll_more:
            case R.id.ll_more_l:
                if (i == 0) {
                    this.im_more.setImageResource(R.mipmap.n_play_buttom_more);
                    this.tv_more.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                    this.im_more_l.setImageResource(R.mipmap.n_play_buttom_more);
                    this.tv_more_l.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                } else {
                    this.im_more.setImageResource(R.mipmap.n_play_buttom_more);
                    this.tv_more.setTextColor(getResources().getColor(R.color.color_white));
                    this.im_more_l.setImageResource(R.mipmap.n_play_buttom_more);
                    this.tv_more_l.setTextColor(getResources().getColor(R.color.color_white));
                }
                PopupWindow popupWindow = this.popupWindow_more_funtion;
                if (popupWindow != null) {
                    popupWindow.showAtLocation(this.lyHeader, 80, 0, 0);
                    break;
                }
                break;
            case R.id.ll_pic:
            case R.id.ll_pic_l:
                if (i != 0) {
                    this.im_pic.setImageResource(R.mipmap.n_play_buttom_pic);
                    this.tv_pic.setTextColor(getResources().getColor(R.color.color_white));
                    this.im_pic_l.setImageResource(R.mipmap.n_play_buttom_pic);
                    this.tv_pic_l.setTextColor(getResources().getColor(R.color.color_white));
                    break;
                } else {
                    this.im_pic.setImageResource(R.mipmap.n_play_buttom_pic);
                    this.im_pic_l.setImageResource(R.mipmap.n_play_buttom_pic);
                    try {
                        MediaPlayer.create(this, R.raw.photoshutter).start();
                    } catch (Exception unused) {
                    }
                    if (this.h264byte != null) {
                        byte[] bArr = new byte[3110400];
                        int[] iArr = new int[2];
                        CommonUtil.Log(1, "zhaogenghuai 1111111111111");
                        byte[] bArr2 = this.h264byte;
                        int DecodeH264Frame = NativeCaller.DecodeH264Frame(bArr2, 1, bArr, bArr2.length, iArr);
                        CommonUtil.Log(1, "zhaogenghuai 2222222222222");
                        if (DecodeH264Frame > 0) {
                            int i2 = iArr[0];
                            int i3 = iArr[1];
                            Log.d("tag", "width:" + i2 + " height:" + i3);
                            byte[] bArr3 = new byte[(i2 * i3 * 2)];
                            NativeCaller.YUV4202RGB565(bArr, bArr3, i2, i3);
                            ByteBuffer wrap = ByteBuffer.wrap(bArr3);
                            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                            createBitmap.copyPixelsFromBuffer(wrap);
                            takePicture(createBitmap);
                            break;
                        }
                    } else {
                        return false;
                    }
                }
                break;
            case R.id.ll_talk:
            case R.id.ll_talk_l:
                if (this.devType == 101 || this.devMode == 1) {
                    if (i != 0) {
                        this.clickTimeUp = System.currentTimeMillis();
                        this.im_talk.setImageResource(R.mipmap.n_play_buttom_talk);
                        this.tv_talk.setTextColor(getResources().getColor(R.color.color_white));
                        this.im_talk_l.setImageResource(R.mipmap.n_play_buttom_talk);
                        this.tv_talk_l.setTextColor(getResources().getColor(R.color.color_white));
                        StopTalk();
                        if (this.isAudioClick) {
                            StartAudio();
                            this.tv_audio.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                            this.tv_audio_l.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                            this.im_audio.setImageResource(R.mipmap.n_audios1);
                            this.im_audio_l.setImageResource(R.mipmap.n_audios1);
                            break;
                        }
                    } else {
                        this.clickTimeDown = System.currentTimeMillis();
                        this.im_talk.setImageResource(R.mipmap.n_play_buttom_talking);
                        this.tv_talk.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                        this.im_talk_l.setImageResource(R.mipmap.n_play_buttom_talking);
                        this.tv_talk_l.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                        if (this.isAudioClick) {
                            StopAudio();
                            this.im_audio.setImageResource(R.mipmap.n_audios2);
                            this.im_audio_l.setImageResource(R.mipmap.n_audios2);
                            this.tv_audio.setTextColor(getResources().getColor(R.color.color_white));
                            this.tv_audio_l.setTextColor(getResources().getColor(R.color.color_white));
                        }
                        StartTalk();
                        break;
                    }
                } else {
                    showToast((int) R.string.n_play_mic_no_show);
                    return false;
                }
                break;
            case R.id.ll_video:
            case R.id.ll_video_l:
                if (i == 0) {
                    if (!this.isTakeVideo) {
                        this.im_video.setImageResource(R.mipmap.n_play_buttom_videoing);
                        this.tv_video.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
                        this.im_video_l.setImageResource(R.mipmap.n_play_buttom_videoing);
                        this.tv_video_l.setTextColor(getResources().getColor(R.color.color_qh_addtxt));
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
                                this.customVideoRecord.startRecordVideo(1, fileNameWithTime);
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
                        this.tv_video.setTextColor(getResources().getColor(R.color.color_white));
                        this.im_video_l.setImageResource(R.mipmap.n_play_buttom_video);
                        this.tv_video_l.setTextColor(getResources().getColor(R.color.color_white));
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
        CommonUtil.Log(1, "SHIXZ  onTouch");
        if (view.getId() == R.id.glVideo) {
            CommonUtil.Log(1, "SHIXZ  R.id.glVideo");
            if (this.isFullscreen) {
                ZoomonTouch(view, motionEvent);
            }
            return false;
        }
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
        if (str != null && str.length() > 5) {
            this.strVideoName = "IMG_" + str.replace("mp5", "jpg");
            new Thread() {
                public void run() {
                    if (HardDNCameraLiveActivity.this.h264byte != null) {
                        byte[] bArr = new byte[3110400];
                        int[] iArr = new int[2];
                        CommonUtil.Log(1, "zhaogenghuai 1111111111111");
                        int DecodeH264Frame = NativeCaller.DecodeH264Frame(HardDNCameraLiveActivity.this.h264byte, 1, bArr, HardDNCameraLiveActivity.this.h264byte.length, iArr);
                        CommonUtil.Log(1, "zhaogenghuai 2222222222222 result:" + DecodeH264Frame);
                        if (DecodeH264Frame >= 0) {
                            int unused = HardDNCameraLiveActivity.this.nVideoWidth = iArr[0];
                            int unused2 = HardDNCameraLiveActivity.this.nVideoHeight = iArr[1];
                            byte[] bArr2 = new byte[(HardDNCameraLiveActivity.this.nVideoWidth * HardDNCameraLiveActivity.this.nVideoHeight * 2)];
                            NativeCaller.YUV4202RGB565(bArr, bArr2, HardDNCameraLiveActivity.this.nVideoWidth, HardDNCameraLiveActivity.this.nVideoHeight);
                            ByteBuffer wrap = ByteBuffer.wrap(bArr2);
                            HardDNCameraLiveActivity hardDNCameraLiveActivity = HardDNCameraLiveActivity.this;
                            Bitmap unused3 = hardDNCameraLiveActivity.mBmp = Bitmap.createBitmap(hardDNCameraLiveActivity.nVideoWidth, HardDNCameraLiveActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                            HardDNCameraLiveActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                            if (HardDNCameraLiveActivity.this.mBmp != null) {
                                File sDFilePath = CommonUtil.getSDFilePath();
                                File file = new File(sDFilePath, "HDWiFiCam/videohead/" + HardDNCameraLiveActivity.this.strDID);
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(new File(file, HardDNCameraLiveActivity.this.strVideoName));
                                    if (HardDNCameraLiveActivity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }.start();
        }
    }

    private void returnLastBmp2Home() {
        if (this.h264byte != null) {
            new Thread() {
                public void run() {
                    if (HardDNCameraLiveActivity.this.h264byte != null) {
                        byte[] bArr = new byte[3110400];
                        int[] iArr = new int[2];
                        CommonUtil.Log(1, "zhaogenghuai 1111111111111");
                        int DecodeH264Frame = NativeCaller.DecodeH264Frame(HardDNCameraLiveActivity.this.h264byte, 1, bArr, HardDNCameraLiveActivity.this.h264byte.length, iArr);
                        CommonUtil.Log(1, "zhaogenghuai 2222222222222 result:" + DecodeH264Frame);
                        if (DecodeH264Frame >= 0) {
                            int unused = HardDNCameraLiveActivity.this.nVideoWidth = iArr[0];
                            int unused2 = HardDNCameraLiveActivity.this.nVideoHeight = iArr[1];
                            byte[] bArr2 = new byte[(HardDNCameraLiveActivity.this.nVideoWidth * HardDNCameraLiveActivity.this.nVideoHeight * 2)];
                            NativeCaller.YUV4202RGB565(bArr, bArr2, HardDNCameraLiveActivity.this.nVideoWidth, HardDNCameraLiveActivity.this.nVideoHeight);
                            ByteBuffer wrap = ByteBuffer.wrap(bArr2);
                            HardDNCameraLiveActivity hardDNCameraLiveActivity = HardDNCameraLiveActivity.this;
                            Bitmap unused3 = hardDNCameraLiveActivity.mBmp = Bitmap.createBitmap(hardDNCameraLiveActivity.nVideoWidth, HardDNCameraLiveActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                            HardDNCameraLiveActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                            if (HardDNCameraLiveActivity.this.mBmp != null) {
                                File file = new File(CommonUtil.getSDFilePath(), "HDWiFiCam/picid");
                                File file2 = new File(file, HardDNCameraLiveActivity.this.strDID + ".jpg");
                                if (file2.exists()) {
                                    Log.d("first_pic", file2.delete() + "");
                                }
                                HardDNCameraLiveActivity hardDNCameraLiveActivity2 = HardDNCameraLiveActivity.this;
                                hardDNCameraLiveActivity2.setBitMapToBean(hardDNCameraLiveActivity2.strDID, HardDNCameraLiveActivity.this.mBmp);
                                HardDNCameraLiveActivity hardDNCameraLiveActivity3 = HardDNCameraLiveActivity.this;
                                hardDNCameraLiveActivity3.saveBmpToSDcard(hardDNCameraLiveActivity3.strDID, HardDNCameraLiveActivity.this.mBmp);
                            }
                        }
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

    public void initExitPopupWindow_more_funtion() {
        this.popv_more_funtion = LayoutInflater.from(this).inflate(R.layout.popup_playmore_funtion, (ViewGroup) null);
        this.popupmore = this.popv_more_funtion.findViewById(R.id.popupmore);
        this.seekBar1 = (SeekBar) this.popv_more_funtion.findViewById(R.id.seekBar1);
        this.seekBar2 = (SeekBar) this.popv_more_funtion.findViewById(R.id.seekBar2);
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
                HardDNCameraLiveActivity.this.tvSee11.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(HardDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "contrast", seekBar.getProgress()), 0);
            }
        });
        this.seekBar12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                HardDNCameraLiveActivity.this.tvSee12.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(HardDNCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "bright", seekBar.getProgress()), 0);
            }
        });
        this.seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                HardDNCameraLiveActivity.this.tvSee1.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(HardDNCameraLiveActivity.this.strDID, CommonUtil.SHIX_setMIC(SystemValue.doorBellAdmin, SystemValue.doorBellPass, seekBar.getProgress()), 0);
            }
        });
        this.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                HardDNCameraLiveActivity.this.tvSee2.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(HardDNCameraLiveActivity.this.strDID, CommonUtil.SHIX_setSPK(SystemValue.doorBellAdmin, SystemValue.doorBellPass, seekBar.getProgress()), 0);
            }
        });
        this.popv_more_funtion.findViewById(R.id.buttonClose).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HardDNCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popv_more_funtion.findViewById(R.id.buttonSD).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HardDNCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
                Intent intent = new Intent(HardDNCameraLiveActivity.this, PlayBackTFActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, HardDNCameraLiveActivity.this.strName);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, HardDNCameraLiveActivity.this.strDID);
                HardDNCameraLiveActivity.this.startActivity(intent);
                HardDNCameraLiveActivity.this.finish();
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
                HardDNCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
                return false;
            }
        });
        this.popupWindow_more_funtion.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                HardDNCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popupWindow_more_funtion.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                HardDNCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
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
                HardDNCameraLiveActivity.this.popupWindow_Icut.dismiss();
                return false;
            }
        });
        this.popupWindow_Icut.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                HardDNCameraLiveActivity.this.popupWindow_Icut.dismiss();
            }
        });
        this.popupWindow_Icut.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                HardDNCameraLiveActivity.this.popupWindow_Icut.dismiss();
                return false;
            }
        });
    }

    public void initExitPopupWindow_Hight() {
        this.popv_hight = LayoutInflater.from(this).inflate(R.layout.popup_4k, (ViewGroup) null);
        this.button_4k = (Button) this.popv_hight.findViewById(R.id.button_4k);
        this.button_4k.setOnClickListener(this);
        this.button_2k = (Button) this.popv_hight.findViewById(R.id.button_2k);
        this.button_2k.setOnClickListener(this);
        this.view_4k = this.popv_hight.findViewById(R.id.view_4k);
        this.view_2k = this.popv_hight.findViewById(R.id.view_2k);
        this.popv_hight.findViewById(R.id.button_1080).setOnClickListener(this);
        this.popv_hight.findViewById(R.id.button_720).setOnClickListener(this);
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
                HardDNCameraLiveActivity.this.popupWindow_hight.dismiss();
                return false;
            }
        });
        this.popupWindow_hight.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                HardDNCameraLiveActivity.this.popupWindow_hight.dismiss();
            }
        });
        this.popupWindow_hight.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                HardDNCameraLiveActivity.this.popupWindow_hight.dismiss();
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
                    HardDNCameraLiveActivity.this.savePicToSDcard(bitmap);
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0089 A[SYNTHETIC, Splitter:B:30:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0095 A[SYNTHETIC, Splitter:B:38:0x0095] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0091=Splitter:B:35:0x0091, B:17:0x0053=Splitter:B:17:0x0053, B:12:0x004c=Splitter:B:12:0x004c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void savePicToSDcard(android.graphics.Bitmap r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = r7.getStrDate()     // Catch:{ all -> 0x009e }
            r1 = 10
            r2 = 0
            r0.substring(r2, r1)     // Catch:{ all -> 0x009e }
            r0 = 0
            java.lang.String r1 = com.shix.shixipc.utils.CommonUtil.getFileNameWithTime(r2)     // Catch:{ all -> 0x009e }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x005f }
            java.io.File r4 = com.shix.shixipc.utils.CommonUtil.getSDFilePath()     // Catch:{ Exception -> 0x005f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005f }
            r5.<init>()     // Catch:{ Exception -> 0x005f }
            java.lang.String r6 = "HDWiFiCam/Snapshot/"
            r5.append(r6)     // Catch:{ Exception -> 0x005f }
            java.lang.String r6 = r7.strDID     // Catch:{ Exception -> 0x005f }
            r5.append(r6)     // Catch:{ Exception -> 0x005f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x005f }
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x005f }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x005f }
            if (r4 != 0) goto L_0x0035
            r3.mkdirs()     // Catch:{ Exception -> 0x005f }
        L_0x0035:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x005f }
            r4.<init>(r3, r1)     // Catch:{ Exception -> 0x005f }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005f }
            r1.<init>(r4)     // Catch:{ Exception -> 0x005f }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r3 = 100
            boolean r8 = r8.compress(r0, r3, r1)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            if (r8 == 0) goto L_0x004c
            r1.flush()     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
        L_0x004c:
            r7.isPictSave = r2     // Catch:{ all -> 0x009e }
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x008f
        L_0x0052:
            r8 = move-exception
        L_0x0053:
            r8.printStackTrace()     // Catch:{ all -> 0x009e }
            goto L_0x008f
        L_0x0057:
            r8 = move-exception
            r0 = r1
            goto L_0x0091
        L_0x005a:
            r8 = move-exception
            r0 = r1
            goto L_0x0060
        L_0x005d:
            r8 = move-exception
            goto L_0x0091
        L_0x005f:
            r8 = move-exception
        L_0x0060:
            com.shix.shixipc.activity.HardDNCameraLiveActivity$25 r1 = new com.shix.shixipc.activity.HardDNCameraLiveActivity$25     // Catch:{ all -> 0x005d }
            r1.<init>()     // Catch:{ all -> 0x005d }
            r7.runOnUiThread(r1)     // Catch:{ all -> 0x005d }
            java.lang.String r1 = "tag"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r3.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = "exception:"
            r3.append(r4)     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r8.getMessage()     // Catch:{ all -> 0x005d }
            r3.append(r4)     // Catch:{ all -> 0x005d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x005d }
            android.util.Log.d(r1, r3)     // Catch:{ all -> 0x005d }
            r8.printStackTrace()     // Catch:{ all -> 0x005d }
            r7.isPictSave = r2     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x008f
            r0.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x008f
        L_0x008d:
            r8 = move-exception
            goto L_0x0053
        L_0x008f:
            monitor-exit(r7)
            return
        L_0x0091:
            r7.isPictSave = r2     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x009d
            r0.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x009d
        L_0x0099:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x009e }
        L_0x009d:
            throw r8     // Catch:{ all -> 0x009e }
        L_0x009e:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.HardDNCameraLiveActivity.savePicToSDcard(android.graphics.Bitmap):void");
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    public void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        TakeVideoThread takeVideoThread2;
        if (str.endsWith(this.strDID)) {
            if (!this.bDisplayFinished) {
                CommonUtil.Log(1, "SHIXNEWDOOR return bDisplayFinished");
                return;
            }
            CommonUtil.Log(1, "callBaceVideoData width:" + i3 + "  height:" + i4);
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
                    takePicture(this.mBmp);
                }
                message.what = 1;
            } else {
                if (this.isTakeVideo && (takeVideoThread2 = this.takeVideoThread) != null) {
                    takeVideoThread2.addVideo(bArr, 0, this.nVideoWidth, this.nVideoHeight);
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
            return;
        }
        this.nowSize += (long) bArr.length;
        this.nowFram++;
        this.nowLen = bArr.length;
        if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
            long time = new Date().getTime();
            int i3 = (int) (time - this.videotime);
            Log.d("tag", "play  tspan:" + i3);
            this.videotime = time;
            this.customVideoRecord.VideoRecordData(i, bArr, this.nVideoWidth, this.nVideoHeight, i3);
        }
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (str2.indexOf("101") > 0) {
            this.strStrJson = str2;
            new Thread() {
                public void run() {
                    super.run();
                    try {
                        HardDNCameraLiveActivity.this.cameraParmsModel = CameraParmsModel.jsonToModel(HardDNCameraLiveActivity.this.strStrJson);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HardDNCameraLiveActivity.this.mHandler.sendEmptyMessage(23);
                }
            }.start();
        }
    }

    public void AudioRecordData(byte[] bArr, int i) {
        if (this.bAudioRecordStart && i > 0) {
            NativeCaller.PPPPTalkAudioData(this.strDID, bArr, i);
        }
    }

    private boolean ZoomonTouch(View view, MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        if ((motionEvent.getAction() & 255) == 5 && 2 == pointerCount) {
            this.glVideo.setTouchMove(2);
            for (int i = 0; i < pointerCount; i++) {
                new Point((int) motionEvent.getX(i), (int) motionEvent.getY(i));
            }
            this.xlenOld = Math.abs(((int) motionEvent.getX(0)) - ((int) motionEvent.getX(1)));
            this.ylenOld = Math.abs(((int) motionEvent.getY(0)) - ((int) motionEvent.getY(1)));
            int i2 = this.xlenOld;
            double d = ((double) i2) * ((double) i2);
            int i3 = this.ylenOld;
            this.nLenStart = Math.sqrt(d + (((double) i3) * ((double) i3)));
        } else if ((motionEvent.getAction() & 255) == 2 && 2 == pointerCount) {
            this.glVideo.setTouchMove(2);
            for (int i4 = 0; i4 < pointerCount; i4++) {
                new Point((int) motionEvent.getX(i4), (int) motionEvent.getY(i4));
            }
            int abs = Math.abs(((int) motionEvent.getX(0)) - ((int) motionEvent.getX(1)));
            int abs2 = Math.abs(((int) motionEvent.getY(0)) - ((int) motionEvent.getY(1)));
            int abs3 = Math.abs(abs - this.xlenOld);
            int abs4 = Math.abs(abs2 - this.ylenOld);
            double d2 = (double) abs;
            double d3 = (double) abs2;
            double sqrt = Math.sqrt((d2 * d2) + (d3 * d3));
            if (abs3 < 20 && abs4 < 20) {
                return false;
            }
            CommonUtil.Log(1, "SHIXZ  ZoomonTouch ACTION_MOVE nLenEnd:" + sqrt + " nLenStart:" + this.nLenStart);
            if (sqrt > this.nLenStart) {
                resetMonitorSize(true, sqrt);
            } else {
                resetMonitorSize(false, sqrt);
            }
            this.xlenOld = abs;
            this.ylenOld = abs2;
            this.nLenStart = sqrt;
            return true;
        } else if (pointerCount == 1) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.action_down_x = motionEvent.getRawX();
                this.action_down_y = motionEvent.getRawY();
                this.lastX = this.action_down_x;
                this.lastY = this.action_down_y;
                this.glVideo.setTouchMove(0);
            } else if (action != 1) {
                if (action == 2 && this.glVideo.getTouchMove() == 0) {
                    this.move_x = motionEvent.getRawX();
                    this.move_y = motionEvent.getRawY();
                    if (Math.abs(this.move_x - this.action_down_x) > 40.0f || Math.abs(this.move_y - this.action_down_y) > 40.0f) {
                        this.glVideo.setTouchMove(1);
                    }
                }
            } else if (this.glVideo.getTouchMove() == 0 && this.isFullscreen && !this.shix_LL_buttom.isShown()) {
                if (this.ll_landscreen_buttom.isShown()) {
                    this.ll_landscreen_buttom.setVisibility(8);
                } else {
                    this.ll_landscreen_buttom.setVisibility(0);
                }
            }
        }
        return false;
    }

    private void resetMonitorSize(boolean z, double d) {
        if (this.glVideo.height == 0 && this.glVideo.width == 0) {
            initMatrix((int) this.glVideo.screen_width, (int) this.glVideo.screen_height);
        }
        this.moveX = (int) (d / 2.0d);
        this.moveY = (int) (((d * ((double) this.glVideo.screen_height)) / ((double) this.glVideo.screen_width)) / 2.0d);
        if (z) {
            CommonUtil.Log(1, "SHIXZ  ZoomonTouch ACTION_MOVE larger and larger ");
            if (((float) this.glVideo.width) <= this.glVideo.screen_width * 6.0f && ((float) this.glVideo.height) <= this.glVideo.screen_height * 6.0f) {
                this.glVideo.left -= this.moveX / 2;
                this.glVideo.bottom -= this.moveY / 2;
                this.glVideo.width += this.moveX;
                this.glVideo.height += this.moveY;
            }
        } else {
            CommonUtil.Log(1, "SHIXZ  ZoomonTouch ACTION_MOVE smaller and smaller ");
            this.glVideo.left += this.moveX / 2;
            this.glVideo.bottom += this.moveY / 2;
            this.glVideo.width -= this.moveX;
            this.glVideo.height -= this.moveY;
        }
        if (this.glVideo.left > 0 || this.glVideo.width < ((int) this.glVideo.screen_width) || this.glVideo.height < ((int) this.glVideo.screen_height) || this.glVideo.bottom > 0) {
            initMatrix((int) this.glVideo.screen_width, (int) this.glVideo.screen_height);
        }
        CommonUtil.Log(1, "SHIXZ  ZoomonTouch ACTION_MOVE mMonitor.left=" + this.glVideo.left + " mMonitor.bottom=" + this.glVideo.bottom + "\n mMonitor.width=" + this.glVideo.width + " mMonitor.height=" + this.glVideo.height);
        if (this.glVideo.width > ((int) this.glVideo.screen_width)) {
            this.glVideo.setState(1);
        } else {
            this.glVideo.setState(0);
        }
        MyLiveViewGLMonitor myLiveViewGLMonitor = this.glVideo;
        myLiveViewGLMonitor.setMatrix(myLiveViewGLMonitor.left, this.glVideo.bottom, this.glVideo.width, this.glVideo.height);
    }

    private void initMatrix(int i, int i2) {
        MyLiveViewGLMonitor myLiveViewGLMonitor = this.glVideo;
        myLiveViewGLMonitor.left = 0;
        myLiveViewGLMonitor.bottom = 0;
        myLiveViewGLMonitor.width = i;
        myLiveViewGLMonitor.height = i2;
    }

    public void VideoTrans_H264H265(String str, byte[] bArr, int i, int i2, int i3) {
        CustomVideoRecord customVideoRecord2;
        if (i2 == 2) {
            this.isH265 = true;
        } else {
            this.isH265 = false;
        }
        HardVideoBuffer hardVideoBuffer2 = this.hardVideoBuffer;
        if (hardVideoBuffer2 != null) {
            hardVideoBuffer2.addData(bArr, i);
        }
        this.mHandler.sendEmptyMessage(1239);
        this.nowSize += (long) bArr.length;
        this.nowFram++;
        this.nowLen = bArr.length;
        if (i == 0) {
            this.h264byte = bArr;
        }
        this.nVideoWidth = this.hardWidth;
        this.nVideoHeight = this.hardHeight;
        if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
            long time = new Date().getTime();
            int i4 = (int) (time - this.videotime);
            Log.d("tag", "play  tspan:" + i4);
            this.videotime = time;
            this.customVideoRecord.VideoRecordData(i + 5, bArr, this.nVideoWidth, this.nVideoHeight, i4);
        }
    }
}
