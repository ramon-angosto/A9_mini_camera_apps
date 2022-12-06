package com.shix.shixipc.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.YearsModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.AudioPlayer;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.CustomBuffer;
import com.shix.shixipc.utils.CustomBufferData;
import com.shix.shixipc.utils.CustomBufferHead;
import com.shix.shixipc.utils.TakeVideoThread;
import com.shix.shixipc.viewpager.ImagePagerActivity;
import com.shix.shixipc.widget.DialogLoading;
import com.shix.shixipc.widget.OnValueChangeListener;
import com.shix.shixipc.widget.RecordInfo;
import com.shix.shixipc.widget.VideoRulerView;
import com.shix.shixipc.widget.VideoVo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import object.p2pipcam.nativecaller.MyRender;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class PlayBackActivity extends BaseActivity implements NUIMainActivity.PlayBackInterface {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    /* access modifiers changed from: private */
    public int AllTime = 0;
    private CustomBuffer AudioBuffer = null;
    long BarMoveFinishCurrentTime = 0;
    private final int HANDL_GETDAYS = 2;
    private final int HANDL_GETFILES = 12;
    private final int HANDL_GETFILESOVER = 14;
    /* access modifiers changed from: private */
    public int PlayMode = 0;
    /* access modifiers changed from: private */
    public int SeekTime = 0;
    /* access modifiers changed from: private */
    public int StartTime = 0;
    private AudioPlayer audioPlayer = null;
    /* access modifiers changed from: private */
    public Button btn_play;
    /* access modifiers changed from: private */
    public Button btn_quck;
    private Button btn_time;
    boolean exit = false;
    List<RecordInfo> filesData = new ArrayList();

    /* renamed from: i1 */
    private int f1542i1 = 0;

    /* renamed from: i2 */
    private int f1543i2 = 0;
    /* access modifiers changed from: private */
    public ImageView im_audio_l;
    private ImageView im_more_l;
    private ImageView im_pic_l;
    private ImageView im_talk_l;
    /* access modifiers changed from: private */
    public ImageView im_video_l;
    /* access modifiers changed from: private */
    public boolean isAudio = false;
    boolean isBarMoving = false;
    /* access modifiers changed from: private */
    public boolean isFirstShow = false;
    private boolean isGetStartTime = false;
    private boolean isPictSave = false;
    /* access modifiers changed from: private */
    public boolean isPlayOrPause = false;
    /* access modifiers changed from: private */
    public boolean isPlaySeekBar = true;
    /* access modifiers changed from: private */
    public boolean isTakeVideo = false;
    /* access modifiers changed from: private */
    public boolean isTakepic = false;
    /* access modifiers changed from: private */
    public LinearLayout layoutConnPrompt;
    /* access modifiers changed from: private */
    public ListPopupWindow listPopupWindow;
    /* access modifiers changed from: private */
    public Bitmap mBmp;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            PlayBackActivity.this.layoutConnPrompt.setVisibility(8);
            int i = message.what;
            if (i == 1) {
                if (!PlayBackActivity.this.isFirstShow) {
                    boolean unused = PlayBackActivity.this.isFirstShow = true;
                    PlayBackActivity.this.findViewById(R.id.ll_butoom).setVisibility(0);
                }
                if (PlayBackActivity.this.videoRulerView != null) {
                    long access$1100 = ((long) PlayBackActivity.this.nowTime) * 1000;
                    CommonUtil.Log(1, "timeShow:" + access$1100);
                    PlayBackActivity.this.videoRulerView.setCurrentIime(access$1100);
                }
                PlayBackActivity.this.playSeekBar.setProgress(PlayBackActivity.this.size1);
                PlayBackActivity.this.textTimeStamp.setText(PlayBackActivity.this.timeShow);
                PlayBackActivity.this.myRender.writeSample(PlayBackActivity.this.videodata, PlayBackActivity.this.nVideoWidth, PlayBackActivity.this.nVideoHeight);
                PlayBackActivity.this.playImg.setVisibility(8);
            } else if (i != 2) {
                if (i == 12) {
                    String string = message.getData().getString(ImagePagerActivity.FILENAME);
                    if (string.length() > 8) {
                        String substring = string.substring(string.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER));
                        String substring2 = substring.substring(1, 3);
                        substring.substring(3, 5);
                        PlayBackActivity.this.strNowYMD.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER) + "  " + substring2 + " : 00";
                    }
                } else if (i == 14) {
                    if (PlayBackActivity.this.videoRulerView != null) {
                        Calendar instance = Calendar.getInstance();
                        String[] split = PlayBackActivity.this.strNowYMD.split("_");
                        int i2 = instance.get(1);
                        int i3 = instance.get(2);
                        int i4 = instance.get(5);
                        if (split != null && split.length == 3) {
                            i2 = Integer.parseInt(split[0]);
                            i3 = Integer.parseInt(split[1]);
                            i4 = Integer.parseInt(split[2]);
                        }
                        CommonUtil.Log(1, "PlayBack1 y:" + i2 + "  m:" + i3 + "  d:" + i4);
                        PlayBackActivity.this.videoRulerView.setSelectTime(i2, i3, i4);
                    }
                    PlayBackActivity.this.startVideoFile();
                    PlayBackActivity.this.setVideoTimeSlot();
                    if (PlayBackActivity.this.progressDialog.isShowing()) {
                        PlayBackActivity.this.progressDialog.cancel();
                        boolean unused2 = PlayBackActivity.this.isPlaySeekBar = true;
                        PlayBackActivity.this.findViewById(R.id.ll_butoom).setVisibility(0);
                    }
                } else if (i == 119) {
                    PlayBackActivity.this.showToast("其它用户正在回放");
                    PlayBackActivity.this.finish();
                }
            } else if (PlayBackActivity.this.yearsModel != null) {
                if (PlayBackActivity.this.yearsModel.getDays().size() != 0) {
                    PlayBackActivity.this.selectBox();
                    PlayBackActivity.this.listPopupWindowListener();
                    PlayBackActivity.this.getYMD(0);
                } else if (PlayBackActivity.this.progressDialog.isShowing()) {
                    PlayBackActivity.this.progressDialog.cancel();
                }
            }
        }
    };
    private GLSurfaceView myGlSurfaceView;
    /* access modifiers changed from: private */
    public MyRender myRender;
    /* access modifiers changed from: private */
    public int nVideoHeight = 0;
    /* access modifiers changed from: private */
    public int nVideoWidth = 0;
    /* access modifiers changed from: private */
    public int nowTime = 0;
    /* access modifiers changed from: private */
    public ImageView playImg;
    /* access modifiers changed from: private */
    public SeekBar playSeekBar;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog = null;
    int result = 0;
    int size1 = 0;
    /* access modifiers changed from: private */
    public String strDID;
    /* access modifiers changed from: private */
    public String strFilePath;
    /* access modifiers changed from: private */
    public String strNowYMD = "2020_03_15";
    public String strVideoName = "";
    /* access modifiers changed from: private */
    public TakeVideoThread takeVideoThread = null;
    /* access modifiers changed from: private */
    public TextView textTimeStamp;
    private long time;
    private long time1;
    /* access modifiers changed from: private */
    public String timeShow = " ";
    /* access modifiers changed from: private */
    public TextView tv_audio_l;
    private TextView tv_more_l;
    private TextView tv_pic_l;
    private TextView tv_talk_l;
    /* access modifiers changed from: private */
    public TextView tv_video_l;
    private String tzStr = "GMT+08:00";
    private int videoDataLen = 0;
    List<VideoVo> videoFiles;
    VideoRulerView videoRulerView;
    /* access modifiers changed from: private */
    public byte[] videodata = null;
    /* access modifiers changed from: private */
    public YearsModel yearsModel;

    public void callBackSetSystemParamsResult(String str, int i, int i2) {
    }

    /* access modifiers changed from: private */
    public void selectBox() {
        this.listPopupWindow = new ListPopupWindow(this);
        this.listPopupWindow.setAdapter(new MyApader(this, this.yearsModel.getDays()));
        this.listPopupWindow.setAnchorView(this.btn_time);
        this.listPopupWindow.setWidth(-2);
        this.listPopupWindow.setHeight(-2);
        this.listPopupWindow.setModal(true);
    }

    /* access modifiers changed from: private */
    public void listPopupWindowListener() {
        this.listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PlayBackActivity.this.progressDialog != null && !PlayBackActivity.this.progressDialog.isShowing()) {
                    PlayBackActivity.this.progressDialog.show();
                }
                NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.stopRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
                PlayBackActivity.this.getYMD(i);
                PlayBackActivity.this.listPopupWindow.dismiss();
            }
        });
    }

    class MyApader extends BaseAdapter {
        private Context context;
        private List<String> mList;

        public long getItemId(int i) {
            return (long) i;
        }

        public MyApader(Context context2, List<String> list) {
            this.context = context2;
            this.mList = list;
        }

        public int getCount() {
            return this.mList.size();
        }

        public Object getItem(int i) {
            return this.mList.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(this.context, R.layout.drop_item, (ViewGroup) null);
            }
            ((TextView) view.findViewById(R.id.mText)).setText(this.mList.get(i));
            return view;
        }
    }

    /* access modifiers changed from: private */
    public void startVideoFile() {
        List<VideoVo> list = this.videoFiles;
        if (list == null || list.size() <= 1) {
            Toast.makeText(this, getResources().getString(R.string.current_has_no_video), 0).show();
            return;
        }
        this.strFilePath = this.videoFiles.get(0).getFileName();
        Log.e("play back", "strFilePath ---------:" + this.strFilePath);
        NativeCaller.StartPlayBack(this.strDID, this.strFilePath, 0);
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        NUIMainActivity.setPlayBackInterface(this);
        this.videoRulerView.setCurrentIime(this.videoFiles.get(0).getStartTime());
        Log.e("play back", "videoFiles.get(0).getStartTime() ---------:" + this.videoFiles.get(0).getStartTime());
        NativeCaller.TransferMessage(this.strDID, CommonUtil.SHIX_StartVideoFiles(SystemValue.doorBellAdmin, SystemValue.doorBellPass, this.videoFiles.get(0).getStartTime()), 0);
        CommonUtil.Log(1, "timeShow StartPlay:" + this.videoFiles.get(0).getStartTime());
    }

    /* access modifiers changed from: private */
    public void getYMD(int i) {
        this.strNowYMD = this.yearsModel.getDays().get(i);
        String replace = this.strNowYMD.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        Button button = this.btn_time;
        button.setText(replace + "");
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.getRecordList(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strNowYMD), 0);
                return null;
            }
        }.execute(new Void[0]);
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && !progressDialog2.isShowing()) {
            this.progressDialog.show();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(128, 128);
        setContentView(R.layout.playback);
        findView();
        setListener();
        this.videoFiles = new ArrayList();
        this.SeekTime = 0;
        NUIMainActivity.setPlayBackInterface(this);
        getDays();
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this.AudioBuffer);
        this.StartTime = 0;
        this.isGetStartTime = false;
        initVideoRule();
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.remote_video_getparams));
        this.progressDialog.show();
    }

    private void getDays() {
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getRecordDays(SystemValue.doorBellAdmin, SystemValue.doorBellPass, Calendar.getInstance().get(1)), 0);
    }

    /* access modifiers changed from: package-private */
    public void initVideoRule() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        this.videoRulerView = (VideoRulerView) findViewById(R.id.vrv_rule);
        this.videoRulerView.setSelectTime(i, i2, i3);
        this.videoRulerView.setmListener(new OnValueChangeListener() {
            public void onValueChange(float f) {
                PlayBackActivity playBackActivity = PlayBackActivity.this;
                playBackActivity.BarMoveFinishCurrentTime = playBackActivity.getVideoStartTime(playBackActivity.videoFiles, PlayBackActivity.this.videoRulerView.getTimeInMillis(f));
                if (PlayBackActivity.this.BarMoveFinishCurrentTime > 0) {
                    Log.e("tag__", System.currentTimeMillis() + "          " + PlayBackActivity.this.BarMoveFinishCurrentTime);
                    NativeCaller.StartPlayBack(PlayBackActivity.this.strDID, PlayBackActivity.this.strFilePath, 100);
                    NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.SHIX_StartVideoOffset(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.BarMoveFinishCurrentTime), 0);
                    PlayBackActivity.this.isBarMoving = true;
                    return;
                }
                DialogLoading.getInstance().onDismiss();
                PlayBackActivity playBackActivity2 = PlayBackActivity.this;
                playBackActivity2.isBarMoving = false;
                Toast.makeText(playBackActivity2, playBackActivity2.getResources().getString(R.string.current_has_no_video), 0).show();
            }

            public void onMoving() {
                PlayBackActivity playBackActivity = PlayBackActivity.this;
                playBackActivity.isBarMoving = true;
                NativeCaller.StartPlayBack(playBackActivity.strDID, PlayBackActivity.this.strFilePath, 100);
            }
        });
    }

    /* access modifiers changed from: private */
    public long getVideoStartTime(List<VideoVo> list, long j) {
        for (VideoVo next : list) {
            if (j >= next.getStartTime() && j < next.getStartTime() + next.getDuration()) {
                return j;
            }
        }
        for (VideoVo next2 : list) {
            if (next2.getStartTime() > j) {
                return next2.getStartTime() + 10000;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public void setVideoTimeSlot() {
        this.filesData.clear();
        for (VideoVo next : this.videoFiles) {
            RecordInfo recordInfo = new RecordInfo();
            recordInfo.setStartTime(next.getStartTime());
            recordInfo.setEndTime(next.getStartTime() + next.getDuration());
            if (next.isAlarm()) {
                recordInfo.setType(2);
            } else {
                recordInfo.setType(1);
            }
            this.filesData.add(recordInfo);
        }
        this.videoRulerView.setVedioArea(this.filesData);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        StartAudio();
        super.onResume();
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
        this.playSeekBar.setMax(100);
        this.playSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                PlayBackActivity playBackActivity = PlayBackActivity.this;
                int unused = playBackActivity.SeekTime = ((playBackActivity.AllTime * progress) / 100) + PlayBackActivity.this.StartTime;
                NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.offsetRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath, progress), 0);
                new Thread() {
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        NativeCaller.StartPlayBack(PlayBackActivity.this.strDID, PlayBackActivity.this.strFilePath, 100);
                    }
                }.start();
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.isPlaySeekBar) {
                this.isPlaySeekBar = false;
                findViewById(R.id.ll_butoom).setVisibility(8);
            } else {
                this.isPlaySeekBar = true;
                findViewById(R.id.ll_butoom).setVisibility(0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.strFilePath = intent.getStringExtra("filepath");
    }

    private void findView() {
        this.btn_time = (Button) findViewById(R.id.btn_time);
        this.playImg = (ImageView) findViewById(R.id.playback_img);
        this.layoutConnPrompt = (LinearLayout) findViewById(R.id.layout_connect_prompt);
        this.playSeekBar = (SeekBar) findViewById(R.id.playback_seekbar);
        this.textTimeStamp = (TextView) findViewById(R.id.textTimeStamp);
        this.myGlSurfaceView = (GLSurfaceView) findViewById(R.id.myhsurfaceview);
        this.myRender = new MyRender(this.myGlSurfaceView);
        this.myGlSurfaceView.setRenderer(this.myRender);
        this.im_video_l = (ImageView) findViewById(R.id.im_video_l);
        this.im_pic_l = (ImageView) findViewById(R.id.im_pic_l);
        this.im_audio_l = (ImageView) findViewById(R.id.im_audio_l);
        this.tv_video_l = (TextView) findViewById(R.id.tv_video_l);
        this.tv_pic_l = (TextView) findViewById(R.id.tv_pic_l);
        this.tv_audio_l = (TextView) findViewById(R.id.tv_audio_l);
        this.btn_time.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PlayBackActivity.this.listPopupWindow != null && !PlayBackActivity.this.listPopupWindow.isShowing()) {
                    PlayBackActivity.this.listPopupWindow.show();
                }
            }
        });
        findViewById(R.id.alerm_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackActivity.this, 10);
                }
                if (PlayBackActivity.this.isTakeVideo) {
                    PlayBackActivity.this.showToast((int) R.string.ptz_takevideo_show);
                } else {
                    PlayBackActivity.this.finish();
                }
            }
        });
        this.btn_play = (Button) findViewById(R.id.btn_play);
        this.btn_quck = (Button) findViewById(R.id.btn_quck);
        this.btn_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackActivity.this, 10);
                }
                if (PlayBackActivity.this.isPlayOrPause) {
                    PlayBackActivity.this.btn_play.setText(R.string.Pause);
                    NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.rePlayRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath), 0);
                } else {
                    PlayBackActivity.this.btn_play.setText(R.string.Play);
                    NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.pauseRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath), 0);
                }
                PlayBackActivity playBackActivity = PlayBackActivity.this;
                boolean unused = playBackActivity.isPlayOrPause = !playBackActivity.isPlayOrPause;
            }
        });
        this.btn_quck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackActivity.this, 10);
                }
                if (PlayBackActivity.this.PlayMode == 0) {
                    int unused = PlayBackActivity.this.PlayMode = 2;
                } else if (PlayBackActivity.this.PlayMode == 2) {
                    int unused2 = PlayBackActivity.this.PlayMode = 3;
                } else if (PlayBackActivity.this.PlayMode == 3) {
                    int unused3 = PlayBackActivity.this.PlayMode = 4;
                } else {
                    int unused4 = PlayBackActivity.this.PlayMode = 0;
                }
                NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "PlayMode", PlayBackActivity.this.PlayMode), 0);
                int access$3000 = PlayBackActivity.this.PlayMode;
                if (access$3000 == 0) {
                    PlayBackActivity.this.btn_quck.setText("× 1");
                } else if (access$3000 == 2) {
                    PlayBackActivity.this.btn_quck.setText("× 2");
                } else if (access$3000 == 3) {
                    PlayBackActivity.this.btn_quck.setText("× 4");
                } else if (access$3000 == 4) {
                    PlayBackActivity.this.btn_quck.setText("× 8");
                }
            }
        });
        findViewById(R.id.ll_pic_l).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackActivity.this, 10);
                }
                boolean unused = PlayBackActivity.this.isTakepic = true;
            }
        });
        findViewById(R.id.ll_audio_l).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackActivity.this, 10);
                }
                if (PlayBackActivity.this.isAudio) {
                    PlayBackActivity.this.im_audio_l.setImageResource(R.mipmap.n_audios2);
                    PlayBackActivity.this.tv_audio_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_white));
                    NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.playRecordAudio(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath, 0), 0);
                } else {
                    PlayBackActivity.this.tv_audio_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_qh_addtxt));
                    PlayBackActivity.this.im_audio_l.setImageResource(R.mipmap.n_audios1);
                    NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.playRecordAudio(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath, 1), 0);
                }
                PlayBackActivity playBackActivity = PlayBackActivity.this;
                boolean unused = playBackActivity.isAudio = true ^ playBackActivity.isAudio;
            }
        });
        findViewById(R.id.ll_video_l).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackActivity.this, 10);
                }
                if (PlayBackActivity.this.isTakeVideo) {
                    PlayBackActivity.this.im_video_l.setImageResource(R.mipmap.n_play_buttom_video);
                    PlayBackActivity.this.tv_video_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_white));
                    boolean unused = PlayBackActivity.this.isTakeVideo = false;
                    PlayBackActivity.this.takeVideoThread.stopThread();
                    return;
                }
                PlayBackActivity.this.im_video_l.setImageResource(R.mipmap.n_play_buttom_videoing);
                PlayBackActivity.this.tv_video_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_qh_addtxt));
                boolean unused2 = PlayBackActivity.this.isTakeVideo = true;
                SystemValue.checkSDStatu = 1;
                PlayBackActivity playBackActivity = PlayBackActivity.this;
                TakeVideoThread unused3 = playBackActivity.takeVideoThread = new TakeVideoThread(1, playBackActivity.strDID, 15, PlayBackActivity.this.nVideoWidth, PlayBackActivity.this.nVideoHeight);
                new AsyncTask<Void, Void, Void>() {
                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        super.onPreExecute();
                        PlayBackActivity.this.takeVideoThread.start();
                    }

                    /* access modifiers changed from: protected */
                    public Void doInBackground(Void... voidArr) {
                        try {
                            Thread.sleep(1500);
                            return null;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Void voidR) {
                        super.onPostExecute(voidR);
                        if (PlayBackActivity.this.takeVideoThread != null) {
                            PlayBackActivity.this.saveVideoHead(PlayBackActivity.this.takeVideoThread.GetAviName());
                        }
                    }
                }.execute(new Void[0]);
            }
        });
    }

    /* access modifiers changed from: private */
    public void saveVideoHead(String str) {
        if (this.videodata != null && str != null && str.length() > 5) {
            this.strVideoName = "IMG_" + str.replace("avi", "jpg");
            new Thread() {
                public void run() {
                    byte[] bArr = new byte[(PlayBackActivity.this.nVideoWidth * PlayBackActivity.this.nVideoHeight * 2)];
                    NativeCaller.YUV4202RGB565(PlayBackActivity.this.videodata, bArr, PlayBackActivity.this.nVideoWidth, PlayBackActivity.this.nVideoHeight);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    PlayBackActivity playBackActivity = PlayBackActivity.this;
                    Bitmap unused = playBackActivity.mBmp = Bitmap.createBitmap(playBackActivity.nVideoWidth, PlayBackActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                    PlayBackActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                    if (PlayBackActivity.this.mBmp != null) {
                        File externalStorageDirectory = Environment.getExternalStorageDirectory();
                        File file = new File(externalStorageDirectory, "YGCamera/videohead/" + PlayBackActivity.this.strDID);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, PlayBackActivity.this.strVideoName));
                            if (PlayBackActivity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
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
        NUIMainActivity.setPlayBackInterface((NUIMainActivity.PlayBackInterface) null);
        this.exit = false;
        if (this.result != -2) {
            NativeCaller.TransferMessage(this.strDID, CommonUtil.stopRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        }
        NativeCaller.StopPlayBack(this.strDID);
        Log.d(RemoteMessageConst.Notification.TAG, "PlayBackActivity  onDestroy()");
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

    private void takePicture(final Bitmap bitmap) {
        if (!this.isPictSave) {
            this.isPictSave = true;
            new Thread() {
                public void run() {
                    PlayBackActivity.this.savePicToSDcard(bitmap);
                }
            }.start();
        }
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093 A[SYNTHETIC, Splitter:B:30:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009b A[SYNTHETIC, Splitter:B:34:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a4 A[SYNTHETIC, Splitter:B:41:0x00a4] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x00a0=Splitter:B:38:0x00a0, B:12:0x0054=Splitter:B:12:0x0054, B:17:0x005b=Splitter:B:17:0x005b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void savePicToSDcard(android.graphics.Bitmap r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = r8.getStrDate()     // Catch:{ all -> 0x00ad }
            r1 = 10
            r2 = 0
            r0.substring(r2, r1)     // Catch:{ all -> 0x00ad }
            r0 = 0
            java.lang.String r1 = com.shix.shixipc.utils.CommonUtil.getFileNameWithTime(r2)     // Catch:{ all -> 0x00ad }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0069 }
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0069 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0069 }
            r5.<init>()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r6 = "YGCamera/Snapshot/"
            r5.append(r6)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r6 = r8.strDID     // Catch:{ Exception -> 0x0069 }
            r5.append(r6)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0069 }
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0069 }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0069 }
            if (r4 != 0) goto L_0x0035
            r3.mkdirs()     // Catch:{ Exception -> 0x0069 }
        L_0x0035:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0069 }
            r4.<init>(r3, r1)     // Catch:{ Exception -> 0x0069 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0069 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0069 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r3 = 100
            boolean r0 = r9.compress(r0, r3, r1)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            if (r0 == 0) goto L_0x0054
            r1.flush()     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            com.shix.shixipc.activity.PlayBackActivity$15 r0 = new com.shix.shixipc.activity.PlayBackActivity$15     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r0.<init>()     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r8.runOnUiThread(r0)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
        L_0x0054:
            r8.isPictSave = r2     // Catch:{ all -> 0x00ad }
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x0099
        L_0x005a:
            r0 = move-exception
        L_0x005b:
            r0.printStackTrace()     // Catch:{ all -> 0x00ad }
            goto L_0x0099
        L_0x005f:
            r9 = move-exception
            r0 = r1
            goto L_0x00a0
        L_0x0062:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x006a
        L_0x0067:
            r9 = move-exception
            goto L_0x00a0
        L_0x0069:
            r1 = move-exception
        L_0x006a:
            com.shix.shixipc.activity.PlayBackActivity$16 r3 = new com.shix.shixipc.activity.PlayBackActivity$16     // Catch:{ all -> 0x0067 }
            r3.<init>()     // Catch:{ all -> 0x0067 }
            r8.runOnUiThread(r3)     // Catch:{ all -> 0x0067 }
            java.lang.String r3 = "tag"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r4.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r5 = "exception:"
            r4.append(r5)     // Catch:{ all -> 0x0067 }
            java.lang.String r5 = r1.getMessage()     // Catch:{ all -> 0x0067 }
            r4.append(r5)     // Catch:{ all -> 0x0067 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0067 }
            android.util.Log.d(r3, r4)     // Catch:{ all -> 0x0067 }
            r1.printStackTrace()     // Catch:{ all -> 0x0067 }
            r8.isPictSave = r2     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x0099
            r0.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x0099
        L_0x0097:
            r0 = move-exception
            goto L_0x005b
        L_0x0099:
            if (r9 == 0) goto L_0x009e
            r9.recycle()     // Catch:{ all -> 0x00ad }
        L_0x009e:
            monitor-exit(r8)
            return
        L_0x00a0:
            r8.isPictSave = r2     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x00ac
            r0.close()     // Catch:{ IOException -> 0x00a8 }
            goto L_0x00ac
        L_0x00a8:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00ad }
        L_0x00ac:
            throw r9     // Catch:{ all -> 0x00ad }
        L_0x00ad:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x00b1
        L_0x00b0:
            throw r9
        L_0x00b1:
            goto L_0x00b0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.PlayBackActivity.savePicToSDcard(android.graphics.Bitmap):void");
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
        int i2 = instance.get(2) + 1;
        int i3 = instance.get(5);
        int i4 = instance.get(11);
        int i5 = instance.get(12);
        int i6 = instance.get(13);
        if (i2 < 10) {
            str2 = "0" + i2;
        } else {
            str2 = String.valueOf(i2);
        }
        if (i3 < 10) {
            str3 = "0" + i3;
        } else {
            str3 = String.valueOf(i3);
        }
        if (i4 < 10) {
            str4 = "0" + i4;
        } else {
            str4 = String.valueOf(i4);
        }
        if (i5 < 10) {
            str5 = "0" + i5;
        } else {
            str5 = String.valueOf(i5);
        }
        if (i6 < 10) {
            str6 = "0" + i6;
        } else {
            str6 = String.valueOf(i6);
        }
        return i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + "   " + str4 + Constants.COLON_SEPARATOR + str5 + Constants.COLON_SEPARATOR + str6;
    }

    public void callBackPlaybackVideoData(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f1542i1++;
        Log.d(RemoteMessageConst.Notification.TAG, "playback  len:" + i2 + " width:" + i3 + " height:" + i4 + "i1==" + this.f1542i1 + "  framno:" + i6 + "   allfram:" + i7 + "  time:" + i5);
        if (!this.exit) {
            this.exit = true;
        }
        if (!this.isGetStartTime) {
            this.isGetStartTime = true;
            this.StartTime = i5;
            this.nowTime = 0;
            this.AllTime = i7;
        }
        this.nowTime = i5;
        int i8 = this.nowTime;
        this.size1 = ((i8 - this.StartTime) * 100) / i7;
        if (i8 >= this.SeekTime) {
            this.time = (long) i5;
            this.videodata = bArr;
            this.videoDataLen = i2;
            this.nVideoWidth = i3;
            this.nVideoHeight = i4;
            this.time1 = this.time * 1000;
            this.timeShow = setDeviceTime(this.time1, this.tzStr);
            if (i == 1) {
                this.mHandler.sendEmptyMessage(1);
            } else {
                this.mHandler.sendEmptyMessage(2);
            }
            if (this.isTakepic) {
                this.isTakepic = false;
                byte[] bArr2 = new byte[(i3 * i4 * 2)];
                NativeCaller.YUV4202RGB565(bArr, bArr2, i3, i4);
                ByteBuffer wrap = ByteBuffer.wrap(bArr2);
                this.mBmp = Bitmap.createBitmap(i3, i4, Bitmap.Config.RGB_565);
                this.mBmp.copyPixelsFromBuffer(wrap);
                takePicture(this.mBmp);
            }
        }
    }

    public void callBackDatetimeParams(String str, int i, int i2, int i3, String str2) {
        setTimeZone(i2);
        Log.d(RemoteMessageConst.Notification.TAG, "timestr:" + this.tzStr + "  tz:" + i2);
    }

    public void callBackPlaybackAudioData(byte[] bArr, int i) {
        TakeVideoThread takeVideoThread2;
        if (this.isTakeVideo && (takeVideoThread2 = this.takeVideoThread) != null) {
            takeVideoThread2.addAudio(bArr);
        }
        if (this.audioPlayer.isAudioPlaying()) {
            Log.d(ContentCommon.SERVER_STRING, "zhao_pcm_len:" + i);
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
        if (this.isTakeVideo && (takeVideoThread2 = this.takeVideoThread) != null) {
            takeVideoThread2.addVideo(bArr, i, this.nVideoWidth, this.nVideoHeight);
        }
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        String str3;
        String str4 = str2;
        int i = 1;
        CommonUtil.Log(1, "PlayBack ----- CallBackSHIXJasonCommon:" + str4);
        try {
            JSONObject jSONObject = new JSONObject(str4);
            int i2 = jSONObject.getInt("cmd");
            if (i2 == 205) {
                try {
                    this.yearsModel = YearsModel.jsonToModel(str2);
                    this.mHandler.sendEmptyMessage(2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (i2 == 206) {
                this.videoFiles.clear();
                JSONObject jSONObject2 = new JSONObject(str4);
                int i3 = jSONObject2.getInt("record_num");
                int i4 = 0;
                int i5 = 0;
                while (i5 < i3) {
                    String string = jSONObject2.getString("record_name[" + i5 + "]");
                    VideoVo videoVo = new VideoVo();
                    if (string.indexOf("CYC_DV_") >= 0) {
                        str3 = string.replace("CYC_DV_", "");
                    } else {
                        str3 = string.replace("CYC_DV", "");
                    }
                    String replace = str3.replace(".mp4", "");
                    String replace2 = replace.substring(i4, replace.indexOf("@")).replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                    String substring = replace.substring(replace.indexOf("@") + i, replace.length());
                    videoVo.setFileName(string);
                    int i6 = i5;
                    videoVo.setStartTime(VideoVo.str2TimeStamp1(replace2));
                    videoVo.setDuration(Long.parseLong(substring));
                    videoVo.setAlarm(false);
                    if (string.indexOf(this.strNowYMD.replace("_", "")) > 0) {
                        this.videoFiles.add(videoVo);
                        CommonUtil.Log(1, "SHIXTIME 1 yyd:" + replace2 + "  strT:" + substring + "  fileName:" + string + "  strNowYMD:" + this.strNowYMD);
                    } else {
                        CommonUtil.Log(2, "SHIXTIME 2 yyd:" + replace2 + "  strT:" + substring + "  fileName:" + string + "  strNowYMD:" + this.strNowYMD);
                    }
                    i5 = i6 + 1;
                    i = 1;
                    i4 = 0;
                }
                this.mHandler.sendEmptyMessage(14);
            }
            if (i2 == 207) {
                this.result = jSONObject.getInt("result");
                if (this.result < 0) {
                    this.mHandler.sendEmptyMessage(119);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
