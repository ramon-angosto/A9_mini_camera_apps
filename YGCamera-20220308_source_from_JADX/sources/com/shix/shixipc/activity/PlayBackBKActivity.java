package com.shix.shixipc.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.AudioPlayer;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.CustomBuffer;
import com.shix.shixipc.utils.CustomBufferData;
import com.shix.shixipc.utils.CustomBufferHead;
import com.shix.shixipc.utils.CustomVideoRecord;
import com.shix.shixipc.utils.TakeVideoThread;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import object.p2pipcam.nativecaller.MyRender;
import object.p2pipcam.nativecaller.NativeCaller;
import shix.cykj.camera.R;

public class PlayBackBKActivity extends BaseActivity implements NUIMainActivity.PlayBackInterface {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    private CustomBuffer AudioBuffer = null;
    /* access modifiers changed from: private */
    public int PlayMode = 0;
    private AudioPlayer audioPlayer = null;
    /* access modifiers changed from: private */
    public Button btn_play;
    /* access modifiers changed from: private */
    public Button btn_quck;
    int childPosition = 0;
    /* access modifiers changed from: private */
    public CustomVideoRecord customVideoRecord = null;
    boolean exit = false;
    /* access modifiers changed from: private */
    public int h264Data = 0;

    /* renamed from: i1 */
    private int f1544i1 = 0;

    /* renamed from: i2 */
    private int f1545i2 = 0;
    /* access modifiers changed from: private */
    public ImageView im_audio_l;
    private ImageView im_more_l;
    private ImageView im_pic_l;
    private ImageView im_talk_l;
    /* access modifiers changed from: private */
    public ImageView im_video_l;
    /* access modifiers changed from: private */
    public boolean isAudio = false;
    /* access modifiers changed from: private */
    public boolean isFirstShow = false;
    private boolean isPictSave = false;
    /* access modifiers changed from: private */
    public boolean isPlayOrPause = false;
    private boolean isPlaySeekBar = true;
    /* access modifiers changed from: private */
    public boolean isTakeVideo = false;
    /* access modifiers changed from: private */
    public boolean isTakepic = false;
    /* access modifiers changed from: private */
    public LinearLayout layoutConnPrompt;
    /* access modifiers changed from: private */
    public Bitmap mBmp;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            PlayBackBKActivity.this.layoutConnPrompt.setVisibility(8);
            int i = message.what;
            if (i == 1) {
                if (!PlayBackBKActivity.this.isFirstShow) {
                    boolean unused = PlayBackBKActivity.this.isFirstShow = true;
                    PlayBackBKActivity.this.findViewById(R.id.ll_butoom).setVisibility(0);
                }
                PlayBackBKActivity.this.playSeekBar.setProgress(PlayBackBKActivity.this.size1);
                PlayBackBKActivity.this.myRender.writeSample(PlayBackBKActivity.this.videodata, PlayBackBKActivity.this.nVideoWidth, PlayBackBKActivity.this.nVideoHeight);
                PlayBackBKActivity.this.playImg.setVisibility(8);
            } else if (i == 2) {
                PlayBackBKActivity.this.playSeekBar.setProgress(PlayBackBKActivity.this.size1);
                try {
                    Bitmap unused2 = PlayBackBKActivity.this.mBmp = BitmapFactory.decodeByteArray(PlayBackBKActivity.this.videodata, 0, PlayBackBKActivity.this.videoDataLen);
                } catch (Exception unused3) {
                }
                if (PlayBackBKActivity.this.mBmp != null) {
                    int width = PlayBackBKActivity.this.getWindowManager().getDefaultDisplay().getWidth();
                    PlayBackBKActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, (width * 3) / 4);
                    layoutParams.gravity = 17;
                    PlayBackBKActivity.this.playImg.setLayoutParams(layoutParams);
                    PlayBackBKActivity.this.playImg.setVisibility(0);
                    PlayBackBKActivity.this.playImg.setImageBitmap(PlayBackBKActivity.this.mBmp);
                    if (PlayBackBKActivity.this.isTakepic) {
                        boolean unused4 = PlayBackBKActivity.this.isTakepic = false;
                        PlayBackBKActivity playBackBKActivity = PlayBackBKActivity.this;
                        playBackBKActivity.takePicture(playBackBKActivity.mBmp);
                    }
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
    private long nowLen;
    /* access modifiers changed from: private */
    public ImageView playImg;
    /* access modifiers changed from: private */
    public SeekBar playSeekBar;
    int size1 = 0;
    /* access modifiers changed from: private */
    public String strDID;
    /* access modifiers changed from: private */
    public String strFilePath;
    public String strVideoName = "";
    private TakeVideoThread takeVideoThread = null;
    private TextView textTimeStamp;
    private long time;
    private long time1;
    private String timeShow = " ";
    /* access modifiers changed from: private */
    public TextView tv_audio_l;
    private TextView tv_more_l;
    private TextView tv_pic_l;
    private TextView tv_talk_l;
    /* access modifiers changed from: private */
    public TextView tv_video_l;
    private String tzStr = "GMT+08:00";
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    /* access modifiers changed from: private */
    public byte[] videodata = null;
    /* access modifiers changed from: private */
    public long videotime = 0;

    public void CallBackSHIXJasonCommon(String str, String str2) {
    }

    public void callBackSetSystemParamsResult(String str, int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.playbackbk);
        findView();
        setListener();
        NUIMainActivity.setPlayBackInterface(this);
        NativeCaller.StartPlayBack(this.strDID, this.strFilePath, 0);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.playRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, this.strFilePath, this.childPosition), 0);
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this.AudioBuffer);
        this.customVideoRecord = new CustomVideoRecord(this.strDID);
        CommonUtil.Log(1, "strFilePath:" + this.strFilePath);
        if (this.strFilePath.length() > 12) {
            TextView textView = this.textTimeStamp;
            textView.setText(this.strFilePath.substring(0, 4) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.strFilePath.substring(4, 6) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.strFilePath.substring(6, 8) + "   " + this.strFilePath.substring(8, 10) + Constants.COLON_SEPARATOR + this.strFilePath.substring(10, 12));
        }
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
        this.strDID = intent.getStringExtra("did");
        this.strFilePath = intent.getStringExtra("filepath");
        this.childPosition = intent.getIntExtra("childPosition", 0);
        this.childPosition++;
    }

    private void findView() {
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
        findViewById(R.id.ll_audio_l).setVisibility(8);
        findViewById(R.id.btn_play).setVisibility(8);
        findViewById(R.id.alerm_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackBKActivity.this, 10);
                }
                if (PlayBackBKActivity.this.isTakeVideo) {
                    PlayBackBKActivity.this.showToast((int) R.string.ptz_takevideo_show);
                } else {
                    PlayBackBKActivity.this.finish();
                }
            }
        });
        this.btn_play = (Button) findViewById(R.id.btn_play);
        this.btn_quck = (Button) findViewById(R.id.btn_quck);
        this.btn_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackBKActivity.this, 10);
                }
                if (PlayBackBKActivity.this.isPlayOrPause) {
                    PlayBackBKActivity.this.btn_play.setText(R.string.Pause);
                    NativeCaller.TransferMessage(PlayBackBKActivity.this.strDID, CommonUtil.rePlayRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackBKActivity.this.strFilePath), 0);
                } else {
                    PlayBackBKActivity.this.btn_play.setText(R.string.Play);
                    NativeCaller.TransferMessage(PlayBackBKActivity.this.strDID, CommonUtil.pauseRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackBKActivity.this.strFilePath), 0);
                }
                PlayBackBKActivity playBackBKActivity = PlayBackBKActivity.this;
                boolean unused = playBackBKActivity.isPlayOrPause = !playBackBKActivity.isPlayOrPause;
            }
        });
        this.btn_quck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackBKActivity.this, 10);
                }
                if (PlayBackBKActivity.this.PlayMode == 0) {
                    int unused = PlayBackBKActivity.this.PlayMode = 2;
                } else if (PlayBackBKActivity.this.PlayMode == 2) {
                    int unused2 = PlayBackBKActivity.this.PlayMode = 3;
                } else if (PlayBackBKActivity.this.PlayMode == 3) {
                    int unused3 = PlayBackBKActivity.this.PlayMode = 4;
                } else {
                    int unused4 = PlayBackBKActivity.this.PlayMode = 0;
                }
                int access$1700 = PlayBackBKActivity.this.PlayMode;
                if (access$1700 == 0) {
                    PlayBackBKActivity.this.btn_quck.setText("× 1");
                } else if (access$1700 == 2) {
                    PlayBackBKActivity.this.btn_quck.setText("× 2");
                } else if (access$1700 == 3) {
                    PlayBackBKActivity.this.btn_quck.setText("× 4");
                } else if (access$1700 == 4) {
                    PlayBackBKActivity.this.btn_quck.setText("× 8");
                }
            }
        });
        findViewById(R.id.ll_pic_l).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackBKActivity.this, 10);
                }
                boolean unused = PlayBackBKActivity.this.isTakepic = true;
            }
        });
        findViewById(R.id.ll_audio_l).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackBKActivity.this, 10);
                }
                if (PlayBackBKActivity.this.isAudio) {
                    PlayBackBKActivity.this.im_audio_l.setImageResource(R.mipmap.n_audios2);
                    PlayBackBKActivity.this.tv_audio_l.setTextColor(PlayBackBKActivity.this.getResources().getColor(R.color.color_white));
                } else {
                    PlayBackBKActivity.this.tv_audio_l.setTextColor(PlayBackBKActivity.this.getResources().getColor(R.color.color_qh_addtxt));
                    PlayBackBKActivity.this.im_audio_l.setImageResource(R.mipmap.n_audios1);
                }
                PlayBackBKActivity playBackBKActivity = PlayBackBKActivity.this;
                boolean unused = playBackBKActivity.isAudio = !playBackBKActivity.isAudio;
            }
        });
        findViewById(R.id.ll_video_l).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackBKActivity.this, 10);
                }
                if (PlayBackBKActivity.this.isTakeVideo) {
                    PlayBackBKActivity.this.im_video_l.setImageResource(R.mipmap.n_play_buttom_video);
                    PlayBackBKActivity.this.tv_video_l.setTextColor(PlayBackBKActivity.this.getResources().getColor(R.color.color_white));
                    boolean unused = PlayBackBKActivity.this.isTakeVideo = false;
                    if (PlayBackBKActivity.this.customVideoRecord != null) {
                        PlayBackBKActivity.this.customVideoRecord.stopRecordVideo();
                        return;
                    }
                    return;
                }
                PlayBackBKActivity.this.im_video_l.setImageResource(R.mipmap.n_play_buttom_videoing);
                PlayBackBKActivity.this.tv_video_l.setTextColor(PlayBackBKActivity.this.getResources().getColor(R.color.color_qh_addtxt));
                boolean unused2 = PlayBackBKActivity.this.isTakeVideo = true;
                SystemValue.checkSDStatu = 1;
                if (!PlayBackBKActivity.this.customVideoRecord.isRecordVideo()) {
                    String fileNameWithTime = CommonUtil.getFileNameWithTime(2);
                    long unused3 = PlayBackBKActivity.this.videotime = new Date().getTime();
                    if (PlayBackBKActivity.this.h264Data == 1) {
                        PlayBackBKActivity.this.customVideoRecord.startRecordVideo(1, fileNameWithTime);
                    } else {
                        PlayBackBKActivity.this.customVideoRecord.startRecordVideo(2, fileNameWithTime);
                    }
                    PlayBackBKActivity.this.saveVideoHead(fileNameWithTime);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void saveVideoHead(String str) {
        if (this.videodata == null) {
            CommonUtil.Log(1, "ZHAOH265  videodata==null");
        } else if (str == null || str.length() <= 5) {
            CommonUtil.Log(1, "ZHAOH265  name==null");
        } else {
            this.strVideoName = "IMG_" + str.replace("mp5", "jpg");
            new Thread() {
                public void run() {
                    CommonUtil.Log(1, "ZHAOH265  h264Data start h264Data:" + PlayBackBKActivity.this.h264Data);
                    if (PlayBackBKActivity.this.h264Data == 1) {
                        byte[] bArr = new byte[(PlayBackBKActivity.this.nVideoWidth * PlayBackBKActivity.this.nVideoHeight * 2)];
                        NativeCaller.YUV4202RGB565(PlayBackBKActivity.this.videodata, bArr, PlayBackBKActivity.this.nVideoWidth, PlayBackBKActivity.this.nVideoHeight);
                        ByteBuffer wrap = ByteBuffer.wrap(bArr);
                        PlayBackBKActivity playBackBKActivity = PlayBackBKActivity.this;
                        Bitmap unused = playBackBKActivity.mBmp = Bitmap.createBitmap(playBackBKActivity.nVideoWidth, PlayBackBKActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                        PlayBackBKActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                        CommonUtil.Log(1, "ZHAOH265  h264Data = 1");
                    }
                    if (PlayBackBKActivity.this.mBmp != null) {
                        File externalStorageDirectory = Environment.getExternalStorageDirectory();
                        File file = new File(externalStorageDirectory, "YGCamera/videohead/" + PlayBackBKActivity.this.strDID);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        try {
                            CommonUtil.Log(1, "ZHAOH265  save");
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, PlayBackBKActivity.this.strVideoName));
                            if (PlayBackBKActivity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            CommonUtil.Log(1, "ZHAOH265  er:" + e.toString());
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
        CustomVideoRecord customVideoRecord2 = this.customVideoRecord;
        if (customVideoRecord2 != null) {
            customVideoRecord2.stopRecordVideo();
        }
        StopAudio();
        MyRender myRender2 = this.myRender;
        if (myRender2 != null) {
            myRender2.destroyShaders();
        }
        this.exit = false;
        NativeCaller.TransferMessage(this.strDID, CommonUtil.stopRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
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

    /* access modifiers changed from: private */
    public void takePicture(final Bitmap bitmap) {
        if (!this.isPictSave) {
            this.isPictSave = true;
            new Thread() {
                public void run() {
                    PlayBackBKActivity.this.savePicToSDcard(bitmap);
                }
            }.start();
        }
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0091 A[SYNTHETIC, Splitter:B:30:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009d A[SYNTHETIC, Splitter:B:38:0x009d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:12:0x0054=Splitter:B:12:0x0054, B:35:0x0099=Splitter:B:35:0x0099, B:17:0x005b=Splitter:B:17:0x005b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void savePicToSDcard(android.graphics.Bitmap r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = r7.getStrDate()     // Catch:{ all -> 0x00a6 }
            r1 = 10
            r2 = 0
            r0.substring(r2, r1)     // Catch:{ all -> 0x00a6 }
            r0 = 0
            java.lang.String r1 = com.shix.shixipc.utils.CommonUtil.getFileNameWithTime(r2)     // Catch:{ all -> 0x00a6 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0067 }
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0067 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067 }
            r5.<init>()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r6 = "YGCamera/Snapshot/"
            r5.append(r6)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r6 = r7.strDID     // Catch:{ Exception -> 0x0067 }
            r5.append(r6)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0067 }
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0067 }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0067 }
            if (r4 != 0) goto L_0x0035
            r3.mkdirs()     // Catch:{ Exception -> 0x0067 }
        L_0x0035:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0067 }
            r4.<init>(r3, r1)     // Catch:{ Exception -> 0x0067 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0067 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0067 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r3 = 100
            boolean r8 = r8.compress(r0, r3, r1)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            if (r8 == 0) goto L_0x0054
            r1.flush()     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            com.shix.shixipc.activity.PlayBackBKActivity$11 r8 = new com.shix.shixipc.activity.PlayBackBKActivity$11     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r8.<init>()     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r7.runOnUiThread(r8)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
        L_0x0054:
            r7.isPictSave = r2     // Catch:{ all -> 0x00a6 }
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x0097
        L_0x005a:
            r8 = move-exception
        L_0x005b:
            r8.printStackTrace()     // Catch:{ all -> 0x00a6 }
            goto L_0x0097
        L_0x005f:
            r8 = move-exception
            r0 = r1
            goto L_0x0099
        L_0x0062:
            r8 = move-exception
            r0 = r1
            goto L_0x0068
        L_0x0065:
            r8 = move-exception
            goto L_0x0099
        L_0x0067:
            r8 = move-exception
        L_0x0068:
            com.shix.shixipc.activity.PlayBackBKActivity$12 r1 = new com.shix.shixipc.activity.PlayBackBKActivity$12     // Catch:{ all -> 0x0065 }
            r1.<init>()     // Catch:{ all -> 0x0065 }
            r7.runOnUiThread(r1)     // Catch:{ all -> 0x0065 }
            java.lang.String r1 = "tag"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r3.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = "exception:"
            r3.append(r4)     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = r8.getMessage()     // Catch:{ all -> 0x0065 }
            r3.append(r4)     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0065 }
            android.util.Log.d(r1, r3)     // Catch:{ all -> 0x0065 }
            r8.printStackTrace()     // Catch:{ all -> 0x0065 }
            r7.isPictSave = r2     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0097
            r0.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0097
        L_0x0095:
            r8 = move-exception
            goto L_0x005b
        L_0x0097:
            monitor-exit(r7)
            return
        L_0x0099:
            r7.isPictSave = r2     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x00a5
            r0.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00a5
        L_0x00a1:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00a6 }
        L_0x00a5:
            throw r8     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x00aa
        L_0x00a9:
            throw r8
        L_0x00aa:
            goto L_0x00a9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.PlayBackBKActivity.savePicToSDcard(android.graphics.Bitmap):void");
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
        CustomVideoRecord customVideoRecord2;
        byte[] bArr2 = bArr;
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i6;
        int i13 = i7;
        this.f1544i1++;
        Log.d(RemoteMessageConst.Notification.TAG, "playback  len:" + i2 + " width:" + i3 + " height:" + i11 + "i1==" + this.f1544i1 + "  framno:" + i12 + "   allfram:" + i13 + "  h264Data:" + i);
        if (!this.exit) {
            this.exit = true;
        }
        if (i13 == 0) {
            i13 = 1;
        }
        this.size1 = (i12 * 100) / i13;
        this.h264Data = i8;
        this.time = (long) i5;
        this.videodata = bArr2;
        this.videoDataLen = i9;
        this.nVideoWidth = i10;
        this.nVideoHeight = i11;
        this.time1 = this.time * 1000;
        this.timeShow = setDeviceTime(this.time1, this.tzStr);
        if (this.h264Data == 1) {
            this.mHandler.sendEmptyMessage(1);
            if (this.isTakepic) {
                this.isTakepic = false;
                byte[] bArr3 = new byte[(i10 * i11 * 2)];
                NativeCaller.YUV4202RGB565(bArr, bArr3, i3, i11);
                ByteBuffer wrap = ByteBuffer.wrap(bArr3);
                this.mBmp = Bitmap.createBitmap(i3, i11, Bitmap.Config.RGB_565);
                this.mBmp.copyPixelsFromBuffer(wrap);
                takePicture(this.mBmp);
                return;
            }
            return;
        }
        if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
            long time2 = new Date().getTime();
            int i14 = (int) (time2 - this.videotime);
            Log.d(RemoteMessageConst.Notification.TAG, "play  tspan:" + i14);
            this.videotime = time2;
            this.customVideoRecord.VideoRecordData(3, bArr, 0, 0, i14);
        }
        this.mHandler.sendEmptyMessage(2);
    }

    public void callBackDatetimeParams(String str, int i, int i2, int i3, String str2) {
        setTimeZone(i2);
        Log.d(RemoteMessageConst.Notification.TAG, "timestr:" + this.tzStr + "  tz:" + i2);
    }

    public void callBackPlaybackAudioData(byte[] bArr, int i) {
        CustomVideoRecord customVideoRecord2;
        if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
            this.customVideoRecord.VideoRecordData(110, bArr, 0, 0, 0);
        }
        if (this.isAudio && this.audioPlayer.isAudioPlaying()) {
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
        CustomVideoRecord customVideoRecord2;
        if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
            long time2 = new Date().getTime();
            int i3 = (int) (time2 - this.videotime);
            Log.d(RemoteMessageConst.Notification.TAG, "play  tspan:" + i3);
            this.videotime = time2;
            this.customVideoRecord.VideoRecordData(i, bArr, this.nVideoWidth, this.nVideoHeight, i3);
        }
    }
}
