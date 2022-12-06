package com.shix.shixipc.activity;

import android.app.Dialog;
import android.content.Context;
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
import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.CameraParmsModel;
import com.shix.shixipc.glview.MyLiveViewGLMonitor;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.AudioPlayer;
import com.shix.shixipc.utils.CommonAppUtil;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.CustomAudioRecorder;
import com.shix.shixipc.utils.CustomBuffer;
import com.shix.shixipc.utils.CustomBufferData;
import com.shix.shixipc.utils.CustomBufferHead;
import com.shix.shixipc.utils.CustomVideoRecord;
import com.shix.shixipc.utils.TakeVideoThread;
import com.shix.shixipc.utils.TimeUtil;
import com.shix.shixipc.view.Effectstype;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.nativecaller.MyRender;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;

public class MJCameraLiveActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener, NUIMainActivity.PlayInterface, NUIMainActivity.SHIXCOMMONInterface, CustomAudioRecorder.AudioRecordResult, NUIMainActivity.P2PMpdeInterface {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    private static final int CHECK_CLOUDSHOW = 10;
    private static final int QUERY_RECORD_FILE = 6;
    private static final int REFRESH_DEVICE_STATUS = 2;
    private static final int REFRESH_PLAY_STATUS = 1;
    private static final int REFRESH_PLAY_TIME = 0;
    private static final int REFRESH_RECORD_TIME = 4;
    private static final int REFRESH_TIMEBAR = 3;
    private static final int SHOW_CAMERA_DIRECTION = 5;
    private static final String TAG = "NDNCameraLiveActivity";
    private CustomBuffer AudioBuffer = null;
    /* access modifiers changed from: private */
    public int P2PSta = 0;
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
    private Button btn_config;
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
    private int connectCount = 0;
    /* access modifiers changed from: private */
    public String creatTime = "";
    private CustomAudioRecorder customAudioRecorder = null;
    private CustomVideoRecord customVideoRecord = null;
    /* access modifiers changed from: private */
    public int days = 0;
    private Dialog dlgExit;
    private String dnAccount = "";
    /* access modifiers changed from: private */
    public int flipping = 0;
    /* access modifiers changed from: private */
    public MyLiveViewGLMonitor glVideo;
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
    private int isExistTf = 0;
    private boolean isExitActivity = false;
    private boolean isFullscreen = false;
    private boolean isGQ = false;
    private int isH264Data = 0;
    /* access modifiers changed from: private */
    public boolean isInCloud = false;
    /* access modifiers changed from: private */
    public boolean isOneShow = true;
    /* access modifiers changed from: private */
    public boolean isOnpause = false;
    private boolean isPictSave = false;
    private boolean isPlayingAudio = false;
    private boolean isPlayingRecord = false;
    private boolean isPlayingVideo = false;
    private boolean isRecordVideo = false;
    private boolean isTakeHead = false;
    private boolean isTakeVideo = false;
    /* access modifiers changed from: private */
    public boolean isTakepic = false;
    private boolean isTakepicEnd = false;
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
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                if (MJCameraLiveActivity.this.isOneShow) {
                    boolean unused = MJCameraLiveActivity.this.isOneShow = false;
                    boolean unused2 = MJCameraLiveActivity.this.isDateComeOn = true;
                    MJCameraLiveActivity.this.findViewById(R.id.progressBar).setVisibility(8);
                }
                MJCameraLiveActivity.this.glVideo.setYuvFrameData(MJCameraLiveActivity.this.videodata, MJCameraLiveActivity.this.nVideoWidth, MJCameraLiveActivity.this.nVideoHeight);
            } else if (i == 2) {
                if (MJCameraLiveActivity.this.isOneShow) {
                    boolean unused3 = MJCameraLiveActivity.this.isDateComeOn = true;
                    boolean unused4 = MJCameraLiveActivity.this.isOneShow = false;
                    boolean unused5 = MJCameraLiveActivity.this.isDateComeOn = true;
                    MJCameraLiveActivity.this.findViewById(R.id.progressBar).setVisibility(8);
                    MJCameraLiveActivity.this.glVideo.setVisibility(8);
                    boolean unused6 = MJCameraLiveActivity.this.isOneShow = false;
                }
                MJCameraLiveActivity mJCameraLiveActivity = MJCameraLiveActivity.this;
                Bitmap unused7 = mJCameraLiveActivity.mBmp = BitmapFactory.decodeByteArray(mJCameraLiveActivity.videodata, 0, MJCameraLiveActivity.this.videoDataLen);
                if (MJCameraLiveActivity.this.mBmp == null) {
                    boolean unused8 = MJCameraLiveActivity.this.bDisplayFinished = true;
                    return;
                }
                MJCameraLiveActivity mJCameraLiveActivity2 = MJCameraLiveActivity.this;
                int unused9 = mJCameraLiveActivity2.nVideoWidth = mJCameraLiveActivity2.mBmp.getWidth();
                MJCameraLiveActivity mJCameraLiveActivity3 = MJCameraLiveActivity.this;
                int unused10 = mJCameraLiveActivity3.nVideoHeight = mJCameraLiveActivity3.mBmp.getHeight();
                CommonUtil.Log(1, "WWWW width:" + MJCameraLiveActivity.this.nVideoWidth + "  height:" + MJCameraLiveActivity.this.nVideoHeight);
                if (MJCameraLiveActivity.this.getResources().getConfiguration().orientation == 1) {
                    MJCameraLiveActivity.this.videoView.setVisibility(0);
                    MJCameraLiveActivity.this.videoView.setImageBitmap(MJCameraLiveActivity.this.mBmp);
                } else if (MJCameraLiveActivity.this.getResources().getConfiguration().orientation == 2) {
                    MJCameraLiveActivity.this.videoView.setVisibility(0);
                    MJCameraLiveActivity.this.videoView.setImageBitmap(MJCameraLiveActivity.this.mBmp);
                }
                if (MJCameraLiveActivity.this.isTakepic) {
                    boolean unused11 = MJCameraLiveActivity.this.isTakepic = false;
                    MJCameraLiveActivity mJCameraLiveActivity4 = MJCameraLiveActivity.this;
                    mJCameraLiveActivity4.takePicture(mJCameraLiveActivity4.mBmp);
                }
            } else if (i == 10) {
                final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(MJCameraLiveActivity.this);
                instance.setTv1(MJCameraLiveActivity.this.getResources().getString(R.string.check_cloud_cancel) + "");
                instance.setTv2(MJCameraLiveActivity.this.getResources().getString(R.string.check_cloud_ok) + "");
                instance.getMsg().setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        instance.dismiss();
                    }
                });
                instance.withTitle(MJCameraLiveActivity.this.getResources().getString(R.string.check_cloud_title)).withMessage((CharSequence) MJCameraLiveActivity.this.getResources().getString(R.string.check_cloud_msg)).withEffect(Effectstype.Slidetop).setButton1Click(new View.OnClickListener() {
                    public void onClick(View view) {
                        Context context = CrashApplication.getContext();
                        CommonUtil.SaveCommonShare(context, MJCameraLiveActivity.this.strDID + "isShowCloudMSG" + MJCameraLiveActivity.this.getCloudType(), (String) null, 0);
                        instance.dismiss();
                    }
                }).setButton2Click(new View.OnClickListener() {
                    public void onClick(View view) {
                        instance.dismiss();
                    }
                }).show();
            } else if (i != 123321) {
                if (i != 23) {
                    if (i == 24) {
                        if (MJCameraLiveActivity.this.creatTime == null || MJCameraLiveActivity.this.creatTime.length() <= 3 || MJCameraLiveActivity.this.days <= 0) {
                            boolean unused12 = MJCameraLiveActivity.this.isInCloud = false;
                        } else {
                            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                            int parseInt = Integer.parseInt(MJCameraLiveActivity.this.creatTime) + ((MJCameraLiveActivity.this.days - 5) * 86400);
                            if (currentTimeMillis < parseInt) {
                                boolean unused13 = MJCameraLiveActivity.this.isInCloud = true;
                            } else {
                                boolean unused14 = MJCameraLiveActivity.this.isInCloud = false;
                            }
                            CommonUtil.Log(1, "SaveCommonShare c:" + MJCameraLiveActivity.this.creatTime + " now:" + currentTimeMillis + " CD:" + parseInt + " isInCloud:" + MJCameraLiveActivity.this.isInCloud + " \n");
                        }
                    }
                } else if (MJCameraLiveActivity.this.cameraParmsModel != null) {
                    if (MJCameraLiveActivity.this.cameraParmsModel.getIsShow4KMenu() == 1) {
                        MJCameraLiveActivity.this.im_k.setImageResource(R.mipmap.n_playview_t_4k);
                        MJCameraLiveActivity.this.button_4k.setText("4K");
                        MJCameraLiveActivity.this.button_2k.setText("2K");
                    }
                    MJCameraLiveActivity.this.seekBar1.setProgress(MJCameraLiveActivity.this.cameraParmsModel.getMic());
                    MJCameraLiveActivity.this.seekBar2.setProgress(MJCameraLiveActivity.this.cameraParmsModel.getSpk());
                    MJCameraLiveActivity.this.tvSee1.setText(String.valueOf(MJCameraLiveActivity.this.cameraParmsModel.getMic()));
                    MJCameraLiveActivity.this.tvSee2.setText(String.valueOf(MJCameraLiveActivity.this.cameraParmsModel.getSpk()));
                    MJCameraLiveActivity mJCameraLiveActivity5 = MJCameraLiveActivity.this;
                    int unused15 = mJCameraLiveActivity5.batcapacity = mJCameraLiveActivity5.cameraParmsModel.getBatvalue();
                    MJCameraLiveActivity.this.batcapacity + "%";
                    MJCameraLiveActivity.this.ll_batstatus.setVisibility(0);
                    MJCameraLiveActivity.this.tv_Electricity.setText("");
                    ImageView access$5000 = MJCameraLiveActivity.this.ivBattery;
                    MJCameraLiveActivity mJCameraLiveActivity6 = MJCameraLiveActivity.this;
                    access$5000.setImageResource(mJCameraLiveActivity6.getBatteryRes(mJCameraLiveActivity6.batcapacity));
                    ImageView access$5100 = MJCameraLiveActivity.this.ivBattery1;
                    MJCameraLiveActivity mJCameraLiveActivity7 = MJCameraLiveActivity.this;
                    access$5100.setImageResource(mJCameraLiveActivity7.getBatteryRes(mJCameraLiveActivity7.batcapacity));
                    MJCameraLiveActivity.this.ivBatterying.setVisibility(4);
                    if (MJCameraLiveActivity.this.cameraParmsModel.getRotmir() == 0) {
                        int unused16 = MJCameraLiveActivity.this.mirror = 0;
                        int unused17 = MJCameraLiveActivity.this.flipping = 0;
                    } else if (MJCameraLiveActivity.this.cameraParmsModel.getRotmir() == 1) {
                        int unused18 = MJCameraLiveActivity.this.mirror = 1;
                        int unused19 = MJCameraLiveActivity.this.flipping = 0;
                    } else if (MJCameraLiveActivity.this.cameraParmsModel.getRotmir() == 2) {
                        int unused20 = MJCameraLiveActivity.this.mirror = 0;
                        int unused21 = MJCameraLiveActivity.this.flipping = 1;
                    } else if (MJCameraLiveActivity.this.cameraParmsModel.getRotmir() == 3) {
                        int unused22 = MJCameraLiveActivity.this.mirror = 1;
                        int unused23 = MJCameraLiveActivity.this.flipping = 1;
                    }
                    if (MJCameraLiveActivity.this.cameraParmsModel.getLamp() == 1) {
                        MJCameraLiveActivity.this.im_zsd.setImageResource(R.mipmap.n_playview_t_zsd_open);
                    } else {
                        MJCameraLiveActivity.this.im_zsd.setImageResource(R.mipmap.n_playview_t_zsd);
                    }
                    if (MJCameraLiveActivity.this.cameraParmsModel.getIcut() == 2) {
                        MJCameraLiveActivity.this.icut2.setTextColor(MJCameraLiveActivity.this.getResources().getColor(R.color.color_n_status_offline));
                        MJCameraLiveActivity.this.icut1.setTextColor(MJCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                        MJCameraLiveActivity.this.icut0.setTextColor(MJCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                    } else if (MJCameraLiveActivity.this.cameraParmsModel.getIcut() == 1) {
                        MJCameraLiveActivity.this.icut1.setTextColor(MJCameraLiveActivity.this.getResources().getColor(R.color.color_n_status_offline));
                        MJCameraLiveActivity.this.icut2.setTextColor(MJCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                        MJCameraLiveActivity.this.icut0.setTextColor(MJCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                    } else {
                        MJCameraLiveActivity.this.icut0.setTextColor(MJCameraLiveActivity.this.getResources().getColor(R.color.color_n_status_offline));
                        MJCameraLiveActivity.this.icut1.setTextColor(MJCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                        MJCameraLiveActivity.this.icut2.setTextColor(MJCameraLiveActivity.this.getResources().getColor(R.color.color_white));
                    }
                    if (MJCameraLiveActivity.this.cameraParmsModel.getClockScreen() == 1 || MJCameraLiveActivity.this.cameraParmsModel.getClockScreen() == 2) {
                        MJCameraLiveActivity.this.im_t.setImageResource(R.mipmap.n_playview_t_zsd_tclose);
                    } else {
                        MJCameraLiveActivity.this.im_t.setImageResource(R.mipmap.n_playview_t_zsd_topen);
                    }
                    if (MJCameraLiveActivity.this.cameraParmsModel.getIsShowIcutAuto() == 0 || MJCameraLiveActivity.this.cameraParmsModel.getIsShowIcutAuto() == -110) {
                        MJCameraLiveActivity.this.icut2.setVisibility(8);
                    } else {
                        MJCameraLiveActivity.this.icut2.setVisibility(0);
                    }
                    MJCameraLiveActivity.this.seekBar11.setProgress(MJCameraLiveActivity.this.cameraParmsModel.getBright());
                    MJCameraLiveActivity.this.seekBar12.setProgress(MJCameraLiveActivity.this.cameraParmsModel.getContrast());
                    MJCameraLiveActivity.this.tvSee11.setText(String.valueOf(MJCameraLiveActivity.this.cameraParmsModel.getBright()));
                    MJCameraLiveActivity.this.tvSee12.setText(String.valueOf(MJCameraLiveActivity.this.cameraParmsModel.getContrast()));
                }
            } else if (MJCameraLiveActivity.this.P2PSta == 2) {
                CommonUtil.Log(1, "ZHAOCONN   StopPPPPLivestream");
                NativeCaller.StopPPPPLivestream(MJCameraLiveActivity.this.strDID);
                NativeCaller.StartPPPPLivestream(MJCameraLiveActivity.this.strDID, 1);
                CommonUtil.Log(1, "ZHAOCONN   StartPPPPLivestream");
            } else if (MJCameraLiveActivity.this.P2PSta == 6 || MJCameraLiveActivity.this.P2PSta == 7) {
                CommonUtil.Log(1, "ZHAOCONN   StopPPPP");
                NativeCaller.StopPPPPLivestream(MJCameraLiveActivity.this.strDID);
                MJCameraLiveActivity mJCameraLiveActivity8 = MJCameraLiveActivity.this;
                mJCameraLiveActivity8.StopPPPP(mJCameraLiveActivity8.strDID);
                MJCameraLiveActivity mJCameraLiveActivity9 = MJCameraLiveActivity.this;
                mJCameraLiveActivity9.StartPPPP(mJCameraLiveActivity9.strDID, MJCameraLiveActivity.this.strUser, MJCameraLiveActivity.this.strPwd);
                CommonUtil.Log(1, "ZHAOCONN   StartPPPP");
            }
            if (message.what == 1 || message.what == 2) {
                boolean unused24 = MJCameraLiveActivity.this.bDisplayFinished = true;
                Date date = new Date(System.currentTimeMillis());
                MJCameraLiveActivity mJCameraLiveActivity10 = MJCameraLiveActivity.this;
                int unused25 = mJCameraLiveActivity10.oldLen = mJCameraLiveActivity10.nowLen;
                MJCameraLiveActivity.this.tv_time.setText("len:" + MJCameraLiveActivity.this.oldLen + "  " + MJCameraLiveActivity.this.simpleDateFormat.format(date));
                TextView access$6500 = MJCameraLiveActivity.this.tv_time1;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(MJCameraLiveActivity.this.simpleDateFormat.format(date));
                access$6500.setText(sb.toString());
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
                MJCameraLiveActivity.access$908(MJCameraLiveActivity.this);
                MJCameraLiveActivity.this.tvRecordTime.setText(TimeUtil.getTimeDesc(MJCameraLiveActivity.this.recordTime));
                MJCameraLiveActivity.this.refreshUIHandler.sendEmptyMessageDelayed(4, 1000);
            } else if (i == 12345) {
                MJCameraLiveActivity mJCameraLiveActivity = MJCameraLiveActivity.this;
                long unused = mJCameraLiveActivity.oldSize = mJCameraLiveActivity.nowSize;
                MJCameraLiveActivity mJCameraLiveActivity2 = MJCameraLiveActivity.this;
                int unused2 = mJCameraLiveActivity2.oldFram = mJCameraLiveActivity2.nowFram;
                CommonUtil.Log(1, "ZHAOPLAY oldSize: " + (MJCameraLiveActivity.this.oldSize / 1024) + " K");
                if (MJCameraLiveActivity.this.p2pmode == 0) {
                    TextView access$800 = MJCameraLiveActivity.this.tv_test;
                    access$800.setText((MJCameraLiveActivity.this.oldSize / 1024) + " K  P2P:" + MJCameraLiveActivity.this.p2pmode + "   F:" + MJCameraLiveActivity.this.oldFram + "   \n  " + MJCameraLiveActivity.this.testIp1 + "  " + MJCameraLiveActivity.this.testIp2 + "  " + MJCameraLiveActivity.this.testIp3);
                } else {
                    TextView access$8002 = MJCameraLiveActivity.this.tv_test;
                    access$8002.setText((MJCameraLiveActivity.this.oldSize / 1024) + " K  Relay:" + MJCameraLiveActivity.this.p2pmode + "   F:" + MJCameraLiveActivity.this.oldFram + "   \n  " + MJCameraLiveActivity.this.testIp1 + "  " + MJCameraLiveActivity.this.testIp2 + "  " + MJCameraLiveActivity.this.testIp3);
                }
                long unused3 = MJCameraLiveActivity.this.nowSize = 0;
                int unused4 = MJCameraLiveActivity.this.nowFram = 0;
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
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private StatFs stat;
    private String status = null;
    /* access modifiers changed from: private */
    public String strDID = null;
    /* access modifiers changed from: private */
    public String strName = null;
    /* access modifiers changed from: private */
    public String strPwd = null;
    private String strUUID = "";
    /* access modifiers changed from: private */
    public String strUser = null;
    public String strVideoName = "";
    private TakeVideoThread takeVideoThread = null;
    String testIp1;
    String testIp2;
    String testIp3;
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
    private TextView tv_audio_l;
    private TextView tv_more;
    private TextView tv_more_l;
    private TextView tv_pic;
    private TextView tv_pic_l;
    private TextView tv_talk;
    private TextView tv_talk_l;
    /* access modifiers changed from: private */
    public TextView tv_test;
    /* access modifiers changed from: private */
    public TextView tv_time;
    /* access modifiers changed from: private */
    public TextView tv_time1;
    private TextView tv_video;
    private TextView tv_video_l;
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    /* access modifiers changed from: private */
    public ImageView videoView;
    /* access modifiers changed from: private */
    public byte[] videodata = null;
    private long videotime = 0;
    private View viewSee_batmode;
    private View viewSee_videomode;
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

    static /* synthetic */ int access$308(MJCameraLiveActivity mJCameraLiveActivity) {
        int i = mJCameraLiveActivity.checkCount;
        mJCameraLiveActivity.checkCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$908(MJCameraLiveActivity mJCameraLiveActivity) {
        int i = mJCameraLiveActivity.recordTime;
        mJCameraLiveActivity.recordTime = i + 1;
        return i;
    }

    private void initExitDialog() {
        this.dlgExit = new Dialog(this, R.style.customDialog);
        this.dlgExit.setContentView(R.layout.dialog_exit_play);
        this.dlgExit.findViewById(R.id.tvCancel).setOnClickListener(this);
        this.dlgExit.findViewById(R.id.tvExit).setOnClickListener(this);
    }

    public void CallBack_Checkhandle(String str, String str2, String str3, String str4, int i) {
        this.testIp1 = str2;
        this.testIp2 = str3;
        this.testIp3 = str4;
        this.p2pmode = i;
    }

    class CheckThread extends Thread {
        CheckThread() {
        }

        public void run() {
            super.run();
            while (MJCameraLiveActivity.this.isCheckVideo) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MJCameraLiveActivity.this.refreshUIHandler.sendEmptyMessage(12345);
                if (MJCameraLiveActivity.this.isCheckVideo) {
                    if (MJCameraLiveActivity.this.isOnpause) {
                        int unused = MJCameraLiveActivity.this.checkCount = 0;
                    } else {
                        MJCameraLiveActivity.access$308(MJCameraLiveActivity.this);
                        int access$300 = MJCameraLiveActivity.this.checkCount % 5;
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
        setContentView(R.layout.activity_camera_live_mj);
        this.isDateComeOn = false;
        getDataFromOther();
        this.customVideoRecord = new CustomVideoRecord(this.strDID);
        this.preRet = getSharedPreferences(ContentCommon.SHIX_SHARE_BAT, 0);
        this.audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.glVideo = (MyLiveViewGLMonitor) findViewById(R.id.glVideo);
        this.glVideo.setOnTouchListener(this);
        this.isFullscreen = false;
        this.isExitActivity = false;
        this.isTakepicEnd = true;
        this.cameraParmsModel = new CameraParmsModel();
        initView();
        initAnim();
        initExitPopupWindow_more_funtion();
        initExitPopupWindow_Hight();
        initExitPopupWindow_Icut();
        initListen();
        initExitDialog();
        NUIMainActivity.setP2PMpdeInterface(this);
        NUIMainActivity.setPlayInterface(this);
        NativeCaller.StartPPPPLivestream(this.strDID, 1);
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
        }
    }

    /* access modifiers changed from: private */
    public int getCloudType() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        Context context = CrashApplication.getContext();
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(context, this.strDID + "addnow", 0);
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_ISCLOUDL, 0);
        int GetCommonShareIntValue3 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_CLOUDLDAYS, 1000);
        int i = 86400 * GetCommonShareIntValue3;
        CommonUtil.Log(2, "i_now:" + currentTimeMillis + "  t_now:" + GetCommonShareIntValue + "  p_now:" + i + "  t_isCloudL:" + GetCommonShareIntValue2 + "  t_cloudLDays:" + GetCommonShareIntValue3);
        if (GetCommonShareIntValue == 0) {
            try {
                Context context2 = CrashApplication.getContext();
                CommonUtil.SaveCommonShare(context2, this.strDID + "addnow", (String) null, currentTimeMillis);
            } catch (Exception unused) {
            }
            return 0;
        } else if (GetCommonShareIntValue3 == 1000) {
            return 0;
        } else {
            if (CommonUtil.GetCommonShareIntValue(this, this.strDID + "Cloud", 0) <= 0 && GetCommonShareIntValue2 == 1) {
                if (currentTimeMillis > (i * 2) + GetCommonShareIntValue) {
                    CommonUtil.Log(2, "i_now > p_now*2");
                    return 2;
                } else if (currentTimeMillis > GetCommonShareIntValue + i) {
                    CommonUtil.Log(2, "i_now > p_now");
                    return 1;
                }
            }
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (getResources().getConfiguration().orientation == 1) {
            this.isFullscreen = false;
            if (SystemValue.isApMode) {
                this.btn_config.setVisibility(0);
                this.btn_config.setText(R.string.n_play_config);
                return;
            }
            this.btn_config.setVisibility(8);
            NativeCaller.TransferMessage(this.strDID, CommonUtil.getCloudinfo(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
            Context context = CrashApplication.getContext();
            CommonUtil.GetCommonShareIntValue(context, this.strDID + "isShowCloudMSG" + getCloudType(), 1);
            return;
        }
        this.isFullscreen = true;
        this.btn_config.setVisibility(8);
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
        this.btn_config.setOnClickListener(this);
        this.tv_test = (TextView) findViewById(R.id.tv_test);
        this.tv_time = (TextView) findViewById(R.id.tv_time);
        this.tv_time1 = (TextView) findViewById(R.id.tv_time1);
        this.videoView = (ImageView) findViewById(R.id.videoView);
        this.tv_time.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                MJCameraLiveActivity.this.tv_test.setVisibility(0);
                return false;
            }
        });
        ((TextView) findViewById(R.id.tvHeaderTitle)).setText(this.strName);
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
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.75f));
        layoutParams.gravity = 17;
        this.glVideo.setLayoutParams(layoutParams);
        this.btnTouch.setLayoutParams(layoutParams);
        this.videoView.setLayoutParams(layoutParams);
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
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(this, "iszsd", 0);
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(this, "isircut", 0);
        if (GetCommonShareIntValue == 1) {
            this.iszsd = true;
        } else {
            this.iszsd = false;
        }
        if (GetCommonShareIntValue2 == 1) {
            this.isircut = false;
        } else {
            this.isircut = false;
        }
        if (this.iszsd) {
            this.im_zsd.setImageResource(R.mipmap.n_playview_t_zsd_open);
        }
        if (this.isircut) {
            this.im_ircut.setImageResource(R.mipmap.n_playview_t_zsd_ircutopen);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.dlgExit.isShowing()) {
            this.dlgExit.dismiss();
        }
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
            this.ll_landscreen_buttom.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.75f));
            layoutParams.gravity = 17;
            this.videoView.setLayoutParams(layoutParams);
            this.btnTouch.setLayoutParams(layoutParams);
            this.ll_batstatus.setLayoutParams(layoutParams);
            this.popupmore.setBackgroundColor(getResources().getColor(R.color.color_main));
            this.btnTouch.setVisibility(8);
            findViewById(R.id.tv_bg).setVisibility(8);
            return;
        }
        this.isFullscreen = true;
        this.lyHeader.setVisibility(8);
        this.shix_LL_buttom.setVisibility(8);
        this.ll_landscreen_buttom.setVisibility(0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.75f), -1);
        layoutParams2.gravity = 17;
        this.videoView.setLayoutParams(layoutParams2);
        this.btnTouch.setLayoutParams(layoutParams2);
        this.btnTouch.setVisibility(0);
        findViewById(R.id.tv_bg).setVisibility(0);
        this.popupmore.setBackgroundColor(getResources().getColor(R.color.color_main_90));
    }

    private void toggleFullscreen(boolean z) {
        if (z) {
            this.ivBattery.setVisibility(8);
            this.ivBattery1.setVisibility(8);
            this.tv_time.setVisibility(8);
            this.tv_time1.setVisibility(0);
            setRequestedOrientation(0);
            return;
        }
        this.ivBattery.setVisibility(8);
        this.ivBattery1.setVisibility(8);
        this.tv_time.setVisibility(0);
        this.tv_time1.setVisibility(8);
        setRequestedOrientation(1);
    }

    public void onClick(View view) {
        CameraParmsModel cameraParmsModel2;
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
            case R.id.btn_config:
                if (SystemValue.isApMode) {
                    Intent intent = new Intent(this, SettingWifiActivity.class);
                    intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                    intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
                    startActivity(intent);
                    finish();
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setClass(this, ClouDateActivity.class);
                intent2.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent2.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
                startActivity(intent2);
                finish();
                return;
            case R.id.btn_full:
                resetMonitorSize(false, 100000.0d);
                if (!this.isFullscreen) {
                    toggleFullscreen(true);
                    this.isFullscreen = true;
                    this.btn_config.setVisibility(8);
                    return;
                }
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
                this.im_k.setImageResource(R.mipmap.n_playview_t_1080);
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
                    this.btnTouch.setVisibility(8);
                    return;
                }
                return;
            case R.id.button_2k:
                this.popupWindow_hight.dismiss();
                if (!CommonUtil.isMJCameraNewPro(this.strDID)) {
                    NativeCaller.TransferMessage(this.strDID, "/decoder_control.cgi?command=12&onestep=1&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 0);
                } else if (this.p2pmode == 0) {
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.CutStream(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 2), 0);
                } else if (this.tv_test.isShown()) {
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.CutStream(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 2), 0);
                }
                CameraParmsModel cameraParmsModel3 = this.cameraParmsModel;
                if (cameraParmsModel3 == null || cameraParmsModel3.getIsShow4KMenu() != 1) {
                    this.im_k.setImageResource(R.mipmap.n_playview_t_720);
                } else {
                    this.im_k.setImageResource(R.mipmap.n_playview_t_2k);
                }
                if (!this.isFullscreen) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.75f));
                    layoutParams2.gravity = 17;
                    this.glVideo.setLayoutParams(layoutParams2);
                    this.btnTouch.setLayoutParams(layoutParams2);
                    this.ll_batstatus.setLayoutParams(layoutParams2);
                    this.videoView.setLayoutParams(layoutParams2);
                    this.btnTouch.setVisibility(8);
                    return;
                }
                return;
            case R.id.button_4k:
                this.popupWindow_hight.dismiss();
                CameraParmsModel cameraParmsModel4 = this.cameraParmsModel;
                if (cameraParmsModel4 == null || cameraParmsModel4.getIsShow4KMenu() != 1) {
                    this.im_k.setImageResource(R.mipmap.n_playview_t_1080);
                } else {
                    this.im_k.setImageResource(R.mipmap.n_playview_t_4k);
                }
                if (!CommonUtil.isMJCameraNewPro(this.strDID)) {
                    NativeCaller.TransferMessage(this.strDID, "/decoder_control.cgi?command=13&onestep=1&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 0);
                } else if (this.p2pmode == 0) {
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.CutStream(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 1), 0);
                } else if (this.tv_test.isShown()) {
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.CutStream(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 1), 0);
                }
                if (!this.isFullscreen) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.75f));
                    layoutParams3.gravity = 17;
                    this.videoView.setLayoutParams(layoutParams3);
                    this.glVideo.setLayoutParams(layoutParams3);
                    this.btnTouch.setLayoutParams(layoutParams3);
                    this.ll_batstatus.setLayoutParams(layoutParams3);
                    this.btnTouch.setVisibility(8);
                    return;
                }
                return;
            case R.id.button_720:
                this.popupWindow_hight.dismiss();
                this.im_k.setImageResource(R.mipmap.n_playview_t_720);
                NativeCaller.StopPPPPLivestream(this.strDID);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                NativeCaller.StartPPPPLivestream(this.strDID, 2);
                if (!this.isFullscreen) {
                    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.75f));
                    layoutParams4.gravity = 17;
                    this.glVideo.setLayoutParams(layoutParams4);
                    this.btnTouch.setLayoutParams(layoutParams4);
                    this.ll_batstatus.setLayoutParams(layoutParams4);
                    this.btnTouch.setVisibility(8);
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
                if (!this.isFullscreen) {
                    if (CommonUtil.isMJCameraNewPro(this.strDID)) {
                        this.popupWindow_Icut.showAsDropDown(this.im_ircut);
                        return;
                    }
                    if (!this.isircut) {
                        this.im_ircut.setImageResource(R.mipmap.n_playview_t_zsd_ircutopen);
                        NativeCaller.TransferMessage(this.strDID, "/decoder_control.cgi?command=15&onestep=1&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 0);
                        CommonUtil.SaveCommonShare(this, "isircut", (String) null, 1);
                    } else {
                        this.im_ircut.setImageResource(R.mipmap.n_playview_t_zsd_ircutclose);
                        CommonUtil.SaveCommonShare(this, "isircut", (String) null, 0);
                        NativeCaller.TransferMessage(this.strDID, "/decoder_control.cgi?command=15&onestep=0&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 0);
                    }
                    this.isircut = !this.isircut;
                    return;
                }
                return;
            case R.id.im_jx_rl:
                if (!this.isFullscreen) {
                    if (CommonUtil.isMJCameraNewPro(this.strDID)) {
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
                    }
                    NativeCaller.TransferMessage(this.strDID, "/decoder_control.cgi?command=8&onestep=1&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 0);
                    return;
                }
                return;
            case R.id.im_jx_ud:
                if (!this.isFullscreen) {
                    if (CommonUtil.isMJCameraNewPro(this.strDID)) {
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
                    }
                    NativeCaller.TransferMessage(this.strDID, "/decoder_control.cgi?command=10&onestep=1&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 0);
                    return;
                }
                return;
            case R.id.im_k:
                if (!this.isFullscreen) {
                    this.popupWindow_hight.showAsDropDown(this.im_k);
                    return;
                }
                return;
            case R.id.im_t:
                if (this.isFullscreen || (cameraParmsModel2 = this.cameraParmsModel) == null) {
                    return;
                }
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
            case R.id.im_zsd:
                if (!this.isFullscreen) {
                    if (CommonUtil.isMJCameraNewPro(this.strDID)) {
                        CameraParmsModel cameraParmsModel5 = this.cameraParmsModel;
                        if (cameraParmsModel5 != null) {
                            if (cameraParmsModel5.getLamp() == 0) {
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
                    }
                    if (!this.iszsd) {
                        this.im_zsd.setImageResource(R.mipmap.n_playview_t_zsd_open);
                        NativeCaller.TransferMessage(this.strDID, "/decoder_control.cgi?command=14&onestep=1&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 0);
                        CommonUtil.SaveCommonShare(this, "iszsd", (String) null, 1);
                    } else {
                        this.im_zsd.setImageResource(R.mipmap.n_playview_t_zsd);
                        NativeCaller.TransferMessage(this.strDID, "/decoder_control.cgi?command=14&onestep=0&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 0);
                        CommonUtil.SaveCommonShare(this, "iszsd", (String) null, 0);
                    }
                    this.iszsd = !this.iszsd;
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
                Intent intent3 = new Intent(this, SettingActivity.class);
                intent3.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID);
                intent3.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
                startActivity(intent3);
                finish();
                return;
            case R.id.tvCancel:
                this.dlgExit.dismiss();
                return;
            case R.id.tvExit:
                this.refreshUIHandler.removeCallbacksAndMessages((Object) null);
                this.dlgExit.dismiss();
                Intent intent4 = new Intent(this, NUIMainActivity.class);
                intent4.setFlags(67108864);
                startActivity(intent4);
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
                if (i == 0) {
                    if (this.isTakepicEnd) {
                        this.im_pic.setImageResource(R.mipmap.n_play_buttom_pic);
                        this.im_pic_l.setImageResource(R.mipmap.n_play_buttom_pic);
                        this.isTakepic = true;
                        this.isTakepicEnd = false;
                        try {
                            MediaPlayer.create(this, R.raw.photoshutter).start();
                            break;
                        } catch (Exception unused) {
                            break;
                        }
                    } else {
                        return false;
                    }
                } else {
                    this.im_pic.setImageResource(R.mipmap.n_play_buttom_pic);
                    this.tv_pic.setTextColor(getResources().getColor(R.color.color_white));
                    this.im_pic_l.setImageResource(R.mipmap.n_play_buttom_pic);
                    this.tv_pic_l.setTextColor(getResources().getColor(R.color.color_white));
                    break;
                }
            case R.id.ll_talk:
            case R.id.ll_talk_l:
                if (i != 0) {
                    this.clickTimeUp = System.currentTimeMillis();
                    this.im_talk.setImageResource(R.mipmap.n_play_buttom_talk);
                    this.tv_talk.setTextColor(getResources().getColor(R.color.color_white));
                    this.im_talk_l.setImageResource(R.mipmap.n_play_buttom_talk);
                    this.tv_talk_l.setTextColor(getResources().getColor(R.color.color_white));
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.startTalk(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 0), 0);
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
                    NativeCaller.TransferMessage(this.strDID, CommonUtil.startTalk(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 1), 0);
                    StartTalk();
                    break;
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
                                this.customVideoRecord.startRecordVideo(2, fileNameWithTime);
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
            ZoomonTouch(view, motionEvent);
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
        if (this.videodata != null && str != null && str.length() > 5) {
            this.strVideoName = "IMG_" + str.replace("mp5", "jpg");
            new Thread() {
                public void run() {
                    if (MJCameraLiveActivity.this.mBmp != null) {
                        File sDFilePath = CommonUtil.getSDFilePath();
                        File file = new File(sDFilePath, "HDWiFiCam/videohead/" + MJCameraLiveActivity.this.strDID);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, MJCameraLiveActivity.this.strVideoName));
                            if (MJCameraLiveActivity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
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
                    if (MJCameraLiveActivity.this.mBmp != null) {
                        File file = new File(CommonUtil.getSDFilePath(), "HDWiFiCam/picid");
                        File file2 = new File(file, MJCameraLiveActivity.this.strDID + ".jpg");
                        if (file2.exists()) {
                            Log.d("first_pic", file2.delete() + "");
                        }
                        MJCameraLiveActivity mJCameraLiveActivity = MJCameraLiveActivity.this;
                        mJCameraLiveActivity.setBitMapToBean(mJCameraLiveActivity.strDID, MJCameraLiveActivity.this.mBmp);
                        MJCameraLiveActivity mJCameraLiveActivity2 = MJCameraLiveActivity.this;
                        mJCameraLiveActivity2.saveBmpToSDcard(mJCameraLiveActivity2.strDID, MJCameraLiveActivity.this.mBmp);
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
                MJCameraLiveActivity.this.tvSee11.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(MJCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "contrast", seekBar.getProgress()), 0);
            }
        });
        this.seekBar12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MJCameraLiveActivity.this.tvSee12.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(MJCameraLiveActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "bright", seekBar.getProgress()), 0);
            }
        });
        this.seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MJCameraLiveActivity.this.tvSee1.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(MJCameraLiveActivity.this.strDID, CommonUtil.SHIX_setMIC(SystemValue.doorBellAdmin, SystemValue.doorBellPass, seekBar.getProgress()), 0);
            }
        });
        this.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MJCameraLiveActivity.this.tvSee2.setText(String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                NativeCaller.TransferMessage(MJCameraLiveActivity.this.strDID, CommonUtil.SHIX_setSPK(SystemValue.doorBellAdmin, SystemValue.doorBellPass, seekBar.getProgress()), 0);
            }
        });
        this.popv_more_funtion.findViewById(R.id.buttonClose).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MJCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popv_more_funtion.findViewById(R.id.buttonSD).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MJCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
                Intent intent = new Intent(MJCameraLiveActivity.this, PlayBackTFActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, MJCameraLiveActivity.this.strName);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, MJCameraLiveActivity.this.strDID);
                MJCameraLiveActivity.this.startActivity(intent);
                MJCameraLiveActivity.this.finish();
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
                MJCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
                return false;
            }
        });
        this.popupWindow_more_funtion.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                MJCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popupWindow_more_funtion.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                MJCameraLiveActivity.this.popupWindow_more_funtion.dismiss();
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
        this.icut2.setVisibility(8);
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
                MJCameraLiveActivity.this.popupWindow_Icut.dismiss();
                return false;
            }
        });
        this.popupWindow_Icut.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                MJCameraLiveActivity.this.popupWindow_Icut.dismiss();
            }
        });
        this.popupWindow_Icut.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                MJCameraLiveActivity.this.popupWindow_Icut.dismiss();
                return false;
            }
        });
    }

    public void initExitPopupWindow_Hight() {
        this.popv_hight = LayoutInflater.from(this).inflate(R.layout.popup_4k_mj, (ViewGroup) null);
        this.button_4k = (Button) this.popv_hight.findViewById(R.id.button_4k);
        this.button_4k.setOnClickListener(this);
        this.button_2k = (Button) this.popv_hight.findViewById(R.id.button_2k);
        this.button_2k.setOnClickListener(this);
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
                MJCameraLiveActivity.this.popupWindow_hight.dismiss();
                return false;
            }
        });
        this.popupWindow_hight.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                MJCameraLiveActivity.this.popupWindow_hight.dismiss();
            }
        });
        this.popupWindow_hight.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                MJCameraLiveActivity.this.popupWindow_hight.dismiss();
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
                    MJCameraLiveActivity.this.savePicToSDcard(bitmap);
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e A[SYNTHETIC, Splitter:B:31:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009c A[SYNTHETIC, Splitter:B:39:0x009c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:18:0x0056=Splitter:B:18:0x0056, B:36:0x0096=Splitter:B:36:0x0096, B:13:0x004d=Splitter:B:13:0x004d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void savePicToSDcard(android.graphics.Bitmap r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = r8.getStrDate()     // Catch:{ all -> 0x00a5 }
            r1 = 10
            r2 = 0
            r0.substring(r2, r1)     // Catch:{ all -> 0x00a5 }
            r0 = 0
            java.lang.String r1 = com.shix.shixipc.utils.CommonUtil.getFileNameWithTime(r2)     // Catch:{ all -> 0x00a5 }
            r3 = 1
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0062 }
            java.io.File r5 = com.shix.shixipc.utils.CommonUtil.getSDFilePath()     // Catch:{ Exception -> 0x0062 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0062 }
            r6.<init>()     // Catch:{ Exception -> 0x0062 }
            java.lang.String r7 = "HDWiFiCam/Snapshot/"
            r6.append(r7)     // Catch:{ Exception -> 0x0062 }
            java.lang.String r7 = r8.strDID     // Catch:{ Exception -> 0x0062 }
            r6.append(r7)     // Catch:{ Exception -> 0x0062 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0062 }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0062 }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x0062 }
            if (r5 != 0) goto L_0x0036
            r4.mkdirs()     // Catch:{ Exception -> 0x0062 }
        L_0x0036:
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0062 }
            r5.<init>(r4, r1)     // Catch:{ Exception -> 0x0062 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0062 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0062 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x005d, all -> 0x005a }
            r4 = 100
            boolean r9 = r9.compress(r0, r4, r1)     // Catch:{ Exception -> 0x005d, all -> 0x005a }
            if (r9 == 0) goto L_0x004d
            r1.flush()     // Catch:{ Exception -> 0x005d, all -> 0x005a }
        L_0x004d:
            r8.isPictSave = r2     // Catch:{ all -> 0x00a5 }
            r8.isTakepicEnd = r3     // Catch:{ all -> 0x00a5 }
            r1.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0094
        L_0x0055:
            r9 = move-exception
        L_0x0056:
            r9.printStackTrace()     // Catch:{ all -> 0x00a5 }
            goto L_0x0094
        L_0x005a:
            r9 = move-exception
            r0 = r1
            goto L_0x0096
        L_0x005d:
            r9 = move-exception
            r0 = r1
            goto L_0x0063
        L_0x0060:
            r9 = move-exception
            goto L_0x0096
        L_0x0062:
            r9 = move-exception
        L_0x0063:
            com.shix.shixipc.activity.MJCameraLiveActivity$21 r1 = new com.shix.shixipc.activity.MJCameraLiveActivity$21     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            r8.runOnUiThread(r1)     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = "tag"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r4.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = "exception:"
            r4.append(r5)     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = r9.getMessage()     // Catch:{ all -> 0x0060 }
            r4.append(r5)     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0060 }
            android.util.Log.d(r1, r4)     // Catch:{ all -> 0x0060 }
            r9.printStackTrace()     // Catch:{ all -> 0x0060 }
            r8.isPictSave = r2     // Catch:{ all -> 0x00a5 }
            r8.isTakepicEnd = r3     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x0094
            r0.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x0094
        L_0x0092:
            r9 = move-exception
            goto L_0x0056
        L_0x0094:
            monitor-exit(r8)
            return
        L_0x0096:
            r8.isPictSave = r2     // Catch:{ all -> 0x00a5 }
            r8.isTakepicEnd = r3     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x00a4
            r0.close()     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00a4
        L_0x00a0:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00a5 }
        L_0x00a4:
            throw r9     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.MJCameraLiveActivity.savePicToSDcard(android.graphics.Bitmap):void");
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    public void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        CustomVideoRecord customVideoRecord2;
        byte[] bArr2 = bArr;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        String str2 = str;
        if (str.endsWith(this.strDID)) {
            this.nowSize += (long) i6;
            this.nowFram++;
            this.nowLen = i6;
            if (!this.bDisplayFinished) {
                CommonUtil.Log(1, "SHIXNEWDOOR return bDisplayFinished");
                return;
            }
            this.bDisplayFinished = false;
            this.videodata = bArr2;
            this.videoDataLen = i6;
            Message message = new Message();
            if (i == 1) {
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
                    Log.d("tag", "play  tspan:" + i9);
                    this.videotime = time;
                    this.customVideoRecord.VideoRecordData(3, bArr, 0, 0, i9);
                }
                message.what = 2;
            }
            this.mHandler.sendMessage(message);
        }
    }

    public void callBackMessageNotify(String str, int i, int i2) {
        if (i == 0) {
            CommonUtil.Log(1, "callBackMessageNotify did:" + str);
            if (str.equalsIgnoreCase(this.strDID)) {
                this.P2PSta = i2;
                this.mHandler.sendEmptyMessage(123321);
            }
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
        TakeVideoThread takeVideoThread2;
        if (!str.endsWith(this.strDID)) {
            Log.d("testTakeVideo", "!did.endsWith(strDID)   did:" + str + "  strDID:" + this.strDID);
        } else if (this.isTakeVideo && (takeVideoThread2 = this.takeVideoThread) != null) {
            takeVideoThread2.addVideo(bArr, i, this.nVideoWidth, this.nVideoHeight);
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
        if (str2.indexOf("9002") > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT) == 9002) {
                    this.isExistTf = CommonUtil.jasonPaseInt(jSONObject, "isExistTf", ContentCommon.SHIXFINAL_ERRORINT);
                    this.creatTime = CommonUtil.jasonPaseString(jSONObject, "creatTime");
                    this.days = CommonUtil.jasonPaseInt(jSONObject, "days", ContentCommon.SHIXFINAL_ERRORINT);
                    this.mHandler.sendEmptyMessage(24);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void AudioRecordData(byte[] bArr, int i) {
        if (this.bAudioRecordStart && i > 0) {
            NativeCaller.PPPPTalkAudioData(this.strDID, bArr, i);
        }
    }

    private boolean ZoomonTouch(View view, MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        CommonUtil.Log(1, "SHIXZ  ZoomonTouch nCnt:" + pointerCount);
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
            CommonUtil.Log(1, " larger and larger ");
            if (((float) this.glVideo.width) <= this.glVideo.screen_width * 2.0f && ((float) this.glVideo.height) <= this.glVideo.screen_height * 2.0f) {
                this.glVideo.left -= this.moveX / 2;
                this.glVideo.bottom -= this.moveY / 2;
                this.glVideo.width += this.moveX;
                this.glVideo.height += this.moveY;
            }
        } else {
            CommonUtil.Log(1, " smaller and smaller ");
            this.glVideo.left += this.moveX / 2;
            this.glVideo.bottom += this.moveY / 2;
            this.glVideo.width -= this.moveX;
            this.glVideo.height -= this.moveY;
        }
        if (this.glVideo.left > 0 || this.glVideo.width < ((int) this.glVideo.screen_width) || this.glVideo.height < ((int) this.glVideo.screen_height) || this.glVideo.bottom > 0) {
            initMatrix((int) this.glVideo.screen_width, (int) this.glVideo.screen_height);
        }
        CommonUtil.Log(1, "mMonitor.left=" + this.glVideo.left + " mMonitor.bottom=" + this.glVideo.bottom + "\n mMonitor.width=" + this.glVideo.width + " mMonitor.height=" + this.glVideo.height);
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
}
