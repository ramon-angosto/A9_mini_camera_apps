package com.shix.shixipc.activity;

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
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.AudioMode;
import com.shix.shixipc.bean.VideoPlayBackMode;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.AudioCustomBuffer;
import com.shix.shixipc.utils.AudioPlayer;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.CustomBuffer;
import com.shix.shixipc.utils.CustomBufferData;
import com.shix.shixipc.utils.CustomBufferHead;
import com.shix.shixipc.utils.CustomVideoRecord;
import com.shix.shixipc.utils.TakeVideoThread;
import com.shix.shixipc.utils.VideoCustomBuffer;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import object.p2pipcam.nativecaller.MyRender;
import object.p2pipcam.nativecaller.NativeCaller;

public class PlayBackActivity extends BaseActivity implements NUIMainActivity.PlayBackInterface {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    /* access modifiers changed from: private */
    public CustomBuffer AudioBuffer = null;
    /* access modifiers changed from: private */
    public int PlayMode = 0;
    /* access modifiers changed from: private */
    public AudioCustomBuffer audioCustomBuffer = null;
    /* access modifiers changed from: private */
    public AudioPlayer audioPlayer = null;
    /* access modifiers changed from: private */
    public long audiotime = 0;
    /* access modifiers changed from: private */
    public Button btn_play;
    /* access modifiers changed from: private */
    public Button btn_quck;
    /* access modifiers changed from: private */
    public CustomVideoRecord customVideoRecord = null;
    boolean exit = false;
    /* access modifiers changed from: private */
    public int h264Data = 0;
    private int i1 = 0;
    private int i2 = 0;
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
    public boolean isCheckAudio = false;
    /* access modifiers changed from: private */
    public boolean isCheckVideo = false;
    /* access modifiers changed from: private */
    public boolean isFirstShow = false;
    private boolean isPictSave = false;
    /* access modifiers changed from: private */
    public boolean isPlayOrPause = false;
    private boolean isPlaySeekBar = true;
    /* access modifiers changed from: private */
    public boolean isSeek = false;
    /* access modifiers changed from: private */
    public boolean isTakeVideo = false;
    /* access modifiers changed from: private */
    public boolean isTakepic = false;
    /* access modifiers changed from: private */
    public LinearLayout layoutConnPrompt;
    /* access modifiers changed from: private */
    public Bitmap mBmp;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            PlayBackActivity.this.layoutConnPrompt.setVisibility(8);
            int i = message.what;
            if (i == 1) {
                if (!PlayBackActivity.this.isFirstShow) {
                    boolean unused = PlayBackActivity.this.isFirstShow = true;
                    PlayBackActivity.this.findViewById(R.id.ll_butoom).setVisibility(0);
                }
                PlayBackActivity.this.playSeekBar.setProgress(PlayBackActivity.this.size1);
                PlayBackActivity.this.textTimeStamp.setText(PlayBackActivity.this.timeShow);
                PlayBackActivity.this.myRender.writeSample(PlayBackActivity.this.videodata, PlayBackActivity.this.nVideoWidth, PlayBackActivity.this.nVideoHeight);
                PlayBackActivity.this.playImg.setVisibility(8);
            } else if (i == 2) {
                PlayBackActivity.this.textTimeStamp.setText(PlayBackActivity.this.timeShow);
                PlayBackActivity.this.playSeekBar.setProgress(PlayBackActivity.this.size1);
                try {
                    Bitmap unused2 = PlayBackActivity.this.mBmp = BitmapFactory.decodeByteArray(PlayBackActivity.this.videodata, 0, PlayBackActivity.this.videoDataLen);
                } catch (Exception unused3) {
                }
                if (PlayBackActivity.this.mBmp != null) {
                    int width = PlayBackActivity.this.getWindowManager().getDefaultDisplay().getWidth();
                    PlayBackActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, (width * 3) / 4);
                    layoutParams.gravity = 17;
                    PlayBackActivity.this.playImg.setLayoutParams(layoutParams);
                    PlayBackActivity.this.playImg.setVisibility(0);
                    PlayBackActivity.this.playImg.setImageBitmap(PlayBackActivity.this.mBmp);
                    if (PlayBackActivity.this.isTakepic) {
                        boolean unused4 = PlayBackActivity.this.isTakepic = false;
                        PlayBackActivity playBackActivity = PlayBackActivity.this;
                        playBackActivity.takePicture(playBackActivity.mBmp);
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
    /* access modifiers changed from: private */
    public VideoCustomBuffer videoCustomBuffer = null;
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    /* access modifiers changed from: private */
    public int videoTime = 0;
    /* access modifiers changed from: private */
    public byte[] videodata = null;
    /* access modifiers changed from: private */
    public long videotime = 0;

    public void callBackSetSystemParamsResult(String str, int i, int i3) {
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
        this.audioCustomBuffer = new AudioCustomBuffer();
        this.videoCustomBuffer = new VideoCustomBuffer();
        NUIMainActivity.setPlayBackInterface(this);
        NativeCaller.StartPlayBack(this.strDID, this.strFilePath, 0);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.playRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, this.strFilePath), 0);
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this.AudioBuffer);
        this.customVideoRecord = new CustomVideoRecord(this.strDID);
        this.isCheckVideo = true;
        new MyVideoThread().start();
        this.isCheckAudio = true;
        new MyAudioThread().start();
    }

    class MyAudioThread extends Thread {
        MyAudioThread() {
        }

        public void run() {
            while (PlayBackActivity.this.isCheckAudio) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                AudioMode RemoveData = PlayBackActivity.this.audioCustomBuffer.RemoveData();
                if (RemoveData == null) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } else if (!PlayBackActivity.this.isAudio) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                } else if (!PlayBackActivity.this.audioPlayer.isAudioPlaying()) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                } else {
                    long unused = PlayBackActivity.this.audiotime = (long) RemoveData.getSectime();
                    if (PlayBackActivity.this.isAudio) {
                        CustomBufferHead customBufferHead = new CustomBufferHead();
                        CustomBufferData customBufferData = new CustomBufferData();
                        customBufferHead.length = RemoveData.getLen();
                        customBufferHead.startcode = PlayBackActivity.AUDIO_BUFFER_START_CODE;
                        customBufferData.head = customBufferHead;
                        customBufferData.data = RemoveData.getAudio();
                        PlayBackActivity.this.AudioBuffer.addData(customBufferData);
                    }
                }
            }
            super.run();
        }
    }

    class MyVideoThread extends Thread {
        MyVideoThread() {
        }

        public void run() {
            while (PlayBackActivity.this.isCheckVideo) {
                if (PlayBackActivity.this.videoCustomBuffer.SIZE() > 60) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(66);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                VideoPlayBackMode RemoveData = PlayBackActivity.this.videoCustomBuffer.RemoveData();
                if (RemoveData == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    if (PlayBackActivity.this.isAudio) {
                        long sectime = (long) RemoveData.getSectime();
                        if (sectime > PlayBackActivity.this.audiotime + 300) {
                            while (sectime > PlayBackActivity.this.audiotime + 300 && PlayBackActivity.this.isAudio) {
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e4) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                    }
                    byte[] unused = PlayBackActivity.this.videodata = RemoveData.getVideo();
                    int unused2 = PlayBackActivity.this.videoDataLen = RemoveData.getLen();
                    int unused3 = PlayBackActivity.this.nVideoWidth = RemoveData.getWidth();
                    int unused4 = PlayBackActivity.this.nVideoHeight = RemoveData.getHeight();
                    int unused5 = PlayBackActivity.this.videoTime = RemoveData.getSectime();
                    CommonUtil.Log(1, "videoDataLen：" + PlayBackActivity.this.videoDataLen + "  nVideoWidth:" + PlayBackActivity.this.nVideoWidth + "  nVideoHeight:" + PlayBackActivity.this.nVideoHeight);
                    PlayBackActivity.this.mHandler.sendEmptyMessage(1);
                }
            }
            super.run();
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
        this.isSeek = false;
        this.playSeekBar.setMax(100);
        this.playSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!CommonUtil.isMJCamera(PlayBackActivity.this.strDID) && !CommonUtil.isMJCameraNewPro(PlayBackActivity.this.strDID)) {
                    NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.offsetRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath, seekBar.getProgress()), 0);
                    new Thread() {
                        public void run() {
                            super.run();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (PlayBackActivity.this.videoCustomBuffer != null) {
                                PlayBackActivity.this.videoCustomBuffer.ClearAll();
                            }
                            NativeCaller.StartPlayBack(PlayBackActivity.this.strDID, PlayBackActivity.this.strFilePath, 100);
                            if (PlayBackActivity.this.audioCustomBuffer != null) {
                                PlayBackActivity.this.audioCustomBuffer.ClearAll();
                            }
                            boolean unused = PlayBackActivity.this.isSeek = false;
                        }
                    }.start();
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                boolean unused = PlayBackActivity.this.isSeek = true;
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
        if (CommonUtil.isMJCamera(this.strDID) || CommonUtil.isMJCameraNewPro(this.strDID)) {
            findViewById(R.id.btn_play).setVisibility(8);
        }
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
                if (PlayBackActivity.this.audioCustomBuffer != null) {
                    PlayBackActivity.this.audioCustomBuffer.ClearAll();
                }
                if (PlayBackActivity.this.isAudio) {
                    PlayBackActivity.this.im_audio_l.setImageResource(R.mipmap.n_audios2);
                    PlayBackActivity.this.tv_audio_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_white));
                    if (!(SystemValue.sysDevType == 1000 || SystemValue.sysDevType == 1001)) {
                        NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.playRecordAudio(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath, 0), 0);
                    }
                } else {
                    PlayBackActivity.this.tv_audio_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_qh_addtxt));
                    PlayBackActivity.this.im_audio_l.setImageResource(R.mipmap.n_audios1);
                    if (!(SystemValue.sysDevType == 1000 || SystemValue.sysDevType == 1001)) {
                        NativeCaller.TransferMessage(PlayBackActivity.this.strDID, CommonUtil.playRecordAudio(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackActivity.this.strFilePath, 1), 0);
                    }
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
                    if (PlayBackActivity.this.customVideoRecord != null) {
                        PlayBackActivity.this.customVideoRecord.stopRecordVideo();
                        return;
                    }
                    return;
                }
                PlayBackActivity.this.im_video_l.setImageResource(R.mipmap.n_play_buttom_videoing);
                PlayBackActivity.this.tv_video_l.setTextColor(PlayBackActivity.this.getResources().getColor(R.color.color_qh_addtxt));
                boolean unused2 = PlayBackActivity.this.isTakeVideo = true;
                SystemValue.checkSDStatu = 1;
                if (!PlayBackActivity.this.customVideoRecord.isRecordVideo()) {
                    String fileNameWithTime = CommonUtil.getFileNameWithTime(2);
                    long unused3 = PlayBackActivity.this.videotime = new Date().getTime();
                    if (PlayBackActivity.this.h264Data == 1) {
                        PlayBackActivity.this.customVideoRecord.startRecordVideo(1, fileNameWithTime);
                    } else {
                        PlayBackActivity.this.customVideoRecord.startRecordVideo(2, fileNameWithTime);
                    }
                    PlayBackActivity.this.saveVideoHead(fileNameWithTime);
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
                    CommonUtil.Log(1, "ZHAOH265  h264Data start h264Data:" + PlayBackActivity.this.h264Data);
                    if (PlayBackActivity.this.h264Data == 1) {
                        byte[] bArr = new byte[(PlayBackActivity.this.nVideoWidth * PlayBackActivity.this.nVideoHeight * 2)];
                        NativeCaller.YUV4202RGB565(PlayBackActivity.this.videodata, bArr, PlayBackActivity.this.nVideoWidth, PlayBackActivity.this.nVideoHeight);
                        ByteBuffer wrap = ByteBuffer.wrap(bArr);
                        PlayBackActivity playBackActivity = PlayBackActivity.this;
                        Bitmap unused = playBackActivity.mBmp = Bitmap.createBitmap(playBackActivity.nVideoWidth, PlayBackActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                        PlayBackActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                        CommonUtil.Log(1, "ZHAOH265  h264Data = 1");
                    }
                    if (PlayBackActivity.this.mBmp != null) {
                        File sDFilePath = CommonUtil.getSDFilePath();
                        File file = new File(sDFilePath, "HDWiFiCam/videohead/" + PlayBackActivity.this.strDID);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        try {
                            CommonUtil.Log(1, "ZHAOH265  save");
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, PlayBackActivity.this.strVideoName));
                            if (PlayBackActivity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
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
        this.isCheckVideo = false;
        this.isCheckAudio = false;
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

    /* access modifiers changed from: private */
    public void takePicture(final Bitmap bitmap) {
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
            java.io.File r4 = com.shix.shixipc.utils.CommonUtil.getSDFilePath()     // Catch:{ Exception -> 0x0067 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067 }
            r5.<init>()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r6 = "HDWiFiCam/Snapshot/"
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
            com.shix.shixipc.activity.PlayBackActivity$11 r8 = new com.shix.shixipc.activity.PlayBackActivity$11     // Catch:{ Exception -> 0x0062, all -> 0x005f }
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
            com.shix.shixipc.activity.PlayBackActivity$12 r1 = new com.shix.shixipc.activity.PlayBackActivity$12     // Catch:{ all -> 0x0065 }
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
            throw r8
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
        int i3 = instance.get(2) + 1;
        int i4 = instance.get(5);
        int i5 = instance.get(11);
        int i6 = instance.get(12);
        int i7 = instance.get(13);
        if (i3 < 10) {
            str2 = MBridgeConstans.ENDCARD_URL_TYPE_PL + i3;
        } else {
            str2 = String.valueOf(i3);
        }
        if (i4 < 10) {
            str3 = MBridgeConstans.ENDCARD_URL_TYPE_PL + i4;
        } else {
            str3 = String.valueOf(i4);
        }
        if (i5 < 10) {
            str4 = MBridgeConstans.ENDCARD_URL_TYPE_PL + i5;
        } else {
            str4 = String.valueOf(i5);
        }
        if (i6 < 10) {
            str5 = MBridgeConstans.ENDCARD_URL_TYPE_PL + i6;
        } else {
            str5 = String.valueOf(i6);
        }
        if (i7 < 10) {
            str6 = MBridgeConstans.ENDCARD_URL_TYPE_PL + i7;
        } else {
            str6 = String.valueOf(i7);
        }
        return i + "-" + str2 + "-" + str3 + "   " + str4 + ":" + str5 + ":" + str6;
    }

    public void callBackPlaybackVideoData(byte[] bArr, int i, int i3, int i4, int i5, int i6, int i7, int i8) {
        String str;
        int i9;
        CustomVideoRecord customVideoRecord2;
        byte[] bArr2 = bArr;
        int i10 = i;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        this.i1++;
        Log.d("tag", "playback  len:" + i11 + " width:" + i12 + " height:" + i13 + " i1==" + this.i1 + "  framno:" + i15 + "   allfram:" + i16 + "  size1:" + this.size1);
        StringBuilder sb = new StringBuilder();
        sb.append("SHIXPLAYBACK视频 ：");
        sb.append(i14);
        sb.append("  SIZE:");
        sb.append(this.videoCustomBuffer.SIZE());
        sb.append("  isSeek:");
        sb.append(this.isSeek);
        CommonUtil.Log(1, sb.toString());
        if (!this.isSeek) {
            if (!this.exit) {
                this.exit = true;
            }
            if (i16 == 0) {
                i16 = 1;
            }
            if (CommonUtil.SHIX_isBkDid(this.strDID).booleanValue()) {
                this.size1 = (i15 * 100) / i16;
                i9 = 1;
                str = "tag";
            } else if (CommonUtil.isMJCamera(this.strDID)) {
                str = "tag";
                this.nowLen = this.nowLen + ((long) i11) + 32;
                this.size1 = (int) ((this.nowLen * 100) / ((long) i16));
                i9 = 1;
                CommonUtil.Log(1, "ZHAOPLAY size1:" + this.size1 + "  nowLen:" + this.nowLen + "  len:" + i11 + "  allfram:" + i16);
            } else {
                i9 = 1;
                str = "tag";
                this.size1 = (i15 * 100) / i16;
            }
            this.h264Data = i10;
            this.time = (long) i14;
            if (i10 != i9) {
                this.videodata = bArr2;
                this.videoDataLen = i11;
                this.nVideoWidth = i12;
                this.nVideoHeight = i13;
            }
            this.time1 = this.time * 1000;
            this.timeShow = setDeviceTime(this.time1, this.tzStr);
            if (this.h264Data == 1) {
                VideoCustomBuffer videoCustomBuffer2 = this.videoCustomBuffer;
                if (videoCustomBuffer2 != null) {
                    if (videoCustomBuffer2.SIZE() > 20) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    VideoPlayBackMode videoPlayBackMode = new VideoPlayBackMode();
                    videoPlayBackMode.setVideo(bArr2);
                    videoPlayBackMode.setHeight(i13);
                    videoPlayBackMode.setWidth(i12);
                    videoPlayBackMode.setLen(i11);
                    videoPlayBackMode.setSectime(i14);
                    this.videoCustomBuffer.addData(videoPlayBackMode);
                }
                if (this.isTakepic) {
                    this.isTakepic = false;
                    byte[] bArr3 = new byte[(i12 * i13 * 2)];
                    NativeCaller.YUV4202RGB565(bArr2, bArr3, i12, i13);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr3);
                    this.mBmp = Bitmap.createBitmap(i12, i13, Bitmap.Config.RGB_565);
                    this.mBmp.copyPixelsFromBuffer(wrap);
                    takePicture(this.mBmp);
                    return;
                }
                return;
            }
            if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
                long time2 = new Date().getTime();
                int i17 = (int) (time2 - this.videotime);
                Log.d(str, "play  tspan:" + i17);
                this.videotime = time2;
                this.customVideoRecord.VideoRecordData(3, bArr, 0, 0, i17);
            }
            this.mHandler.sendEmptyMessage(2);
        }
    }

    public void callBackDatetimeParams(String str, int i, int i3, int i4, String str2) {
        setTimeZone(i3);
        Log.d("tag", "timestr:" + this.tzStr + "  tz:" + i3);
    }

    public void callBackPlaybackAudioData(byte[] bArr, int i) {
        CustomVideoRecord customVideoRecord2;
        Log.d(ContentCommon.SERVER_STRING, "zhao_pcm_len:" + i);
        if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
            this.customVideoRecord.VideoRecordData(110, bArr, 0, 0, 0);
        }
        if (this.isAudio && this.audioPlayer.isAudioPlaying()) {
            CustomBufferHead customBufferHead = new CustomBufferHead();
            CustomBufferData customBufferData = new CustomBufferData();
            customBufferHead.length = i;
            customBufferHead.startcode = AUDIO_BUFFER_START_CODE;
            customBufferData.head = customBufferHead;
            customBufferData.data = bArr;
            this.AudioBuffer.addData(customBufferData);
        }
    }

    public void callBackH264Data(String str, byte[] bArr, int i, int i3) {
        CustomVideoRecord customVideoRecord2;
        if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
            long time2 = new Date().getTime();
            int i4 = (int) (time2 - this.videotime);
            Log.d("tag", "play  tspan:" + i4);
            this.videotime = time2;
            this.customVideoRecord.VideoRecordData(i, bArr, this.nVideoWidth, this.nVideoHeight, i4);
        }
    }

    public void AudioPCMDataPlayBack(byte[] bArr, int i, int i3) {
        CustomVideoRecord customVideoRecord2;
        CommonUtil.Log(1, "SHIXPLAYBACK音频 ：" + i3);
        if (this.isTakeVideo && (customVideoRecord2 = this.customVideoRecord) != null && customVideoRecord2.isRecordVideo()) {
            this.customVideoRecord.VideoRecordData(110, bArr, 0, 0, 0);
        }
        if (this.isAudio) {
            AudioMode audioMode = new AudioMode();
            audioMode.setAudio(bArr);
            audioMode.setSectime(i3);
            audioMode.setLen(i);
            this.audioCustomBuffer.addData(audioMode);
        }
    }
}
