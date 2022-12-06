package com.shix.shixipc.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
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
import org.json.JSONException;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class PlayBackTime2Activity extends BaseActivity implements NUIMainActivity.PlayBackInterface {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    /* access modifiers changed from: private */
    public int AllTime = 0;
    private CustomBuffer AudioBuffer = null;
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
    boolean exit = false;

    /* renamed from: i1 */
    private int f1546i1 = 0;

    /* renamed from: i2 */
    private int f1547i2 = 0;
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
    private boolean isGetStartTime = false;
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
            Bitmap bitmap;
            PlayBackTime2Activity.this.layoutConnPrompt.setVisibility(8);
            int i = message.what;
            if (i == 1) {
                if (!PlayBackTime2Activity.this.isFirstShow) {
                    boolean unused = PlayBackTime2Activity.this.isFirstShow = true;
                    PlayBackTime2Activity.this.findViewById(R.id.ll_butoom).setVisibility(0);
                }
                PlayBackTime2Activity.this.playSeekBar.setProgress(PlayBackTime2Activity.this.size1);
                PlayBackTime2Activity.this.textTimeStamp.setText(PlayBackTime2Activity.this.timeShow);
                PlayBackTime2Activity.this.myRender.writeSample(PlayBackTime2Activity.this.videodata, PlayBackTime2Activity.this.nVideoWidth, PlayBackTime2Activity.this.nVideoHeight);
                PlayBackTime2Activity.this.playImg.setVisibility(8);
            } else if (i == 2) {
                PlayBackTime2Activity.this.textTimeStamp.setText(PlayBackTime2Activity.this.timeShow);
                Bitmap bitmap2 = null;
                try {
                    bitmap = BitmapFactory.decodeByteArray(PlayBackTime2Activity.this.videodata, 0, PlayBackTime2Activity.this.videoDataLen);
                } catch (Exception unused2) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    int width = PlayBackTime2Activity.this.getWindowManager().getDefaultDisplay().getWidth();
                    int height = PlayBackTime2Activity.this.getWindowManager().getDefaultDisplay().getHeight();
                    int i2 = (width * 3) / 4;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, i2);
                    layoutParams.gravity = 17;
                    PlayBackTime2Activity.this.playImg.setLayoutParams(layoutParams);
                    if (PlayBackTime2Activity.this.getResources().getConfiguration().orientation == 1) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, width, i2, true);
                    } else if (PlayBackTime2Activity.this.getResources().getConfiguration().orientation == 2) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, width, height, true);
                    }
                    PlayBackTime2Activity.this.playImg.setVisibility(0);
                    PlayBackTime2Activity.this.playImg.setImageBitmap(bitmap2);
                }
            } else if (i == 119) {
                PlayBackTime2Activity.this.showToast("其它用户正在回放");
                PlayBackTime2Activity.this.finish();
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
    private int nowTime = 0;
    /* access modifiers changed from: private */
    public ImageView playImg;
    /* access modifiers changed from: private */
    public SeekBar playSeekBar;
    int result = 0;
    int size1 = 0;
    /* access modifiers changed from: private */
    public String strDID;
    /* access modifiers changed from: private */
    public String strFilePath;
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
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    /* access modifiers changed from: private */
    public byte[] videodata = null;

    public void callBackSetSystemParamsResult(String str, int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(128, 128);
        setContentView(R.layout.playbacktime);
        findView();
        setListener();
        this.SeekTime = 0;
        NUIMainActivity.setPlayBackInterface(this);
        NativeCaller.StartPlayBack(this.strDID, this.strFilePath, 0);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.playRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, this.strFilePath), 0);
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this.AudioBuffer);
        this.StartTime = 0;
        this.isGetStartTime = false;
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
                PlayBackTime2Activity playBackTime2Activity = PlayBackTime2Activity.this;
                int unused = playBackTime2Activity.SeekTime = ((playBackTime2Activity.AllTime * progress) / 100) + PlayBackTime2Activity.this.StartTime;
                NativeCaller.TransferMessage(PlayBackTime2Activity.this.strDID, CommonUtil.offsetRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackTime2Activity.this.strFilePath, progress), 0);
                new Thread() {
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        NativeCaller.StartPlayBack(PlayBackTime2Activity.this.strDID, PlayBackTime2Activity.this.strFilePath, 100);
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
        findViewById(R.id.alerm_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackTime2Activity.this, 10);
                }
                if (PlayBackTime2Activity.this.isTakeVideo) {
                    PlayBackTime2Activity.this.showToast((int) R.string.ptz_takevideo_show);
                } else {
                    PlayBackTime2Activity.this.finish();
                }
            }
        });
        this.btn_play = (Button) findViewById(R.id.btn_play);
        this.btn_quck = (Button) findViewById(R.id.btn_quck);
        this.btn_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackTime2Activity.this, 10);
                }
                if (PlayBackTime2Activity.this.isPlayOrPause) {
                    PlayBackTime2Activity.this.btn_play.setText(R.string.Pause);
                    NativeCaller.TransferMessage(PlayBackTime2Activity.this.strDID, CommonUtil.rePlayRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackTime2Activity.this.strFilePath), 0);
                } else {
                    PlayBackTime2Activity.this.btn_play.setText(R.string.Play);
                    NativeCaller.TransferMessage(PlayBackTime2Activity.this.strDID, CommonUtil.pauseRecordFile(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackTime2Activity.this.strFilePath), 0);
                }
                PlayBackTime2Activity playBackTime2Activity = PlayBackTime2Activity.this;
                boolean unused = playBackTime2Activity.isPlayOrPause = !playBackTime2Activity.isPlayOrPause;
            }
        });
        this.btn_quck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackTime2Activity.this, 10);
                }
                if (PlayBackTime2Activity.this.PlayMode == 0) {
                    int unused = PlayBackTime2Activity.this.PlayMode = 2;
                } else if (PlayBackTime2Activity.this.PlayMode == 2) {
                    int unused2 = PlayBackTime2Activity.this.PlayMode = 3;
                } else if (PlayBackTime2Activity.this.PlayMode == 3) {
                    int unused3 = PlayBackTime2Activity.this.PlayMode = 4;
                } else {
                    int unused4 = PlayBackTime2Activity.this.PlayMode = 0;
                }
                int access$1900 = PlayBackTime2Activity.this.PlayMode;
                if (access$1900 == 0) {
                    PlayBackTime2Activity.this.btn_quck.setText("× 1");
                } else if (access$1900 == 2) {
                    PlayBackTime2Activity.this.btn_quck.setText("× 2");
                } else if (access$1900 == 3) {
                    PlayBackTime2Activity.this.btn_quck.setText("× 4");
                } else if (access$1900 == 4) {
                    PlayBackTime2Activity.this.btn_quck.setText("× 8");
                }
            }
        });
        findViewById(R.id.ll_pic_l).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackTime2Activity.this, 10);
                }
                boolean unused = PlayBackTime2Activity.this.isTakepic = true;
            }
        });
        findViewById(R.id.ll_audio_l).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackTime2Activity.this, 10);
                }
                if (PlayBackTime2Activity.this.isAudio) {
                    PlayBackTime2Activity.this.im_audio_l.setImageResource(R.mipmap.n_audios2);
                    PlayBackTime2Activity.this.tv_audio_l.setTextColor(PlayBackTime2Activity.this.getResources().getColor(R.color.color_white));
                    NativeCaller.TransferMessage(PlayBackTime2Activity.this.strDID, CommonUtil.playRecordAudio(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackTime2Activity.this.strFilePath, 0), 0);
                } else {
                    PlayBackTime2Activity.this.tv_audio_l.setTextColor(PlayBackTime2Activity.this.getResources().getColor(R.color.color_qh_addtxt));
                    PlayBackTime2Activity.this.im_audio_l.setImageResource(R.mipmap.n_audios1);
                    NativeCaller.TransferMessage(PlayBackTime2Activity.this.strDID, CommonUtil.playRecordAudio(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackTime2Activity.this.strFilePath, 1), 0);
                }
                PlayBackTime2Activity playBackTime2Activity = PlayBackTime2Activity.this;
                boolean unused = playBackTime2Activity.isAudio = true ^ playBackTime2Activity.isAudio;
            }
        });
        findViewById(R.id.ll_video_l).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(PlayBackTime2Activity.this, 10);
                }
                if (PlayBackTime2Activity.this.isTakeVideo) {
                    PlayBackTime2Activity.this.im_video_l.setImageResource(R.mipmap.n_play_buttom_video);
                    PlayBackTime2Activity.this.tv_video_l.setTextColor(PlayBackTime2Activity.this.getResources().getColor(R.color.color_white));
                    boolean unused = PlayBackTime2Activity.this.isTakeVideo = false;
                    PlayBackTime2Activity.this.takeVideoThread.stopThread();
                    return;
                }
                PlayBackTime2Activity.this.im_video_l.setImageResource(R.mipmap.n_play_buttom_videoing);
                PlayBackTime2Activity.this.tv_video_l.setTextColor(PlayBackTime2Activity.this.getResources().getColor(R.color.color_qh_addtxt));
                boolean unused2 = PlayBackTime2Activity.this.isTakeVideo = true;
                SystemValue.checkSDStatu = 1;
                PlayBackTime2Activity playBackTime2Activity = PlayBackTime2Activity.this;
                TakeVideoThread unused3 = playBackTime2Activity.takeVideoThread = new TakeVideoThread(1, playBackTime2Activity.strDID, 15, PlayBackTime2Activity.this.nVideoWidth, PlayBackTime2Activity.this.nVideoHeight);
                new AsyncTask<Void, Void, Void>() {
                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        super.onPreExecute();
                        PlayBackTime2Activity.this.takeVideoThread.start();
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
                        if (PlayBackTime2Activity.this.takeVideoThread != null) {
                            PlayBackTime2Activity.this.saveVideoHead(PlayBackTime2Activity.this.takeVideoThread.GetAviName());
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
                    byte[] bArr = new byte[(PlayBackTime2Activity.this.nVideoWidth * PlayBackTime2Activity.this.nVideoHeight * 2)];
                    NativeCaller.YUV4202RGB565(PlayBackTime2Activity.this.videodata, bArr, PlayBackTime2Activity.this.nVideoWidth, PlayBackTime2Activity.this.nVideoHeight);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    PlayBackTime2Activity playBackTime2Activity = PlayBackTime2Activity.this;
                    Bitmap unused = playBackTime2Activity.mBmp = Bitmap.createBitmap(playBackTime2Activity.nVideoWidth, PlayBackTime2Activity.this.nVideoHeight, Bitmap.Config.RGB_565);
                    PlayBackTime2Activity.this.mBmp.copyPixelsFromBuffer(wrap);
                    if (PlayBackTime2Activity.this.mBmp != null) {
                        File externalStorageDirectory = Environment.getExternalStorageDirectory();
                        File file = new File(externalStorageDirectory, "YGCamera/videohead/" + PlayBackTime2Activity.this.strDID);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, PlayBackTime2Activity.this.strVideoName));
                            if (PlayBackTime2Activity.this.mBmp.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
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
                    PlayBackTime2Activity.this.savePicToSDcard(bitmap);
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
            com.shix.shixipc.activity.PlayBackTime2Activity$11 r0 = new com.shix.shixipc.activity.PlayBackTime2Activity$11     // Catch:{ Exception -> 0x0062, all -> 0x005f }
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
            com.shix.shixipc.activity.PlayBackTime2Activity$12 r3 = new com.shix.shixipc.activity.PlayBackTime2Activity$12     // Catch:{ all -> 0x0067 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.PlayBackTime2Activity.savePicToSDcard(android.graphics.Bitmap):void");
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
        this.f1546i1++;
        Log.d(RemoteMessageConst.Notification.TAG, "playback  len:" + i2 + " width:" + i3 + " height:" + i4 + "i1==" + this.f1546i1 + "  framno:" + i6 + "   allfram:" + i7);
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
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.getInt("cmd") == 207) {
                this.result = jSONObject.getInt("result");
                if (this.result < 0) {
                    this.mHandler.sendEmptyMessage(119);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
