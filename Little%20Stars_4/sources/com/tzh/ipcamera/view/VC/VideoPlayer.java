package com.tzh.ipcamera.view.VC;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.presenter.utils.TimeUtils;
import com.tzh.ipcamera.presenter.utils.TimerUtils;
import com.tzh.ipcamera.view.SurfaceViews;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import object.p2pipcam.nativecaller.NativeCaller;

public class VideoPlayer extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    protected static final int HideTime = 2;
    private static final int MSG_VIDEO_GET_FRAME = 3;
    private static final int MSG_VIDEO_PLAY_NEXT = 1;
    private static final int MSG_VIDEO_PLAY_PAUSE = 0;
    private static final int MSG_VIDEO_PLAY_PRE = 2;
    private static final int MSG_VIDEO_UPDATE_TIME = 4;
    protected static final int Pause_Video = 11;
    protected static final int ShowTime = 3;
    protected static final int ShowVideo = 5;
    protected static final int UpdateTime = 1;
    protected static final int Update_Video = 9;
    private static Bitmap bitmap = null;
    private static int getFrameResult = 0;
    static ByteArrayInputStream inputStream = null;
    /* access modifiers changed from: private */
    public static boolean isPlay = false;
    private static boolean isSplite = false;
    static boolean isUsable = true;
    private static ImageView iv_pause;
    /* access modifiers changed from: private */
    public static LogUtils logEx = LogUtils.setLogger(VideoPlayer.class);
    private static List<String> mPathList = new ArrayList();
    /* access modifiers changed from: private */
    public static SurfaceViews mSurface = null;
    private static TimerUtils mTimeUtils = null;
    /* access modifiers changed from: private */
    public static SeekBar sb_time;
    /* access modifiers changed from: private */
    public static TextView tv_cur_time;
    private static TextView tv_left_time;
    private static int vIndex = 0;
    private static int videodur = 0;
    private Timer CM215_Top_Timer = null;
    private TimerTask CM215_Top_TimerTask = null;
    private String CurVideoPath = "";
    protected long LastMicroSecond;
    protected long Race_Current_Time;
    protected String TAG = "VideoPlayer";
    protected Thread ThreadTimeHide = null;
    protected Thread ThreadTimeShow = null;
    protected long TimeOffset = 0;
    private int bRoate = 0;
    private ImageView btnRoate180;
    private int curHideTime = 0;
    private int cur_frame = 0;
    /* access modifiers changed from: private */
    public double curtime = 0.0d;
    protected long curtime1 = 0;
    Handler handler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                VideoPlayer.tv_cur_time.post(new Runnable() {
                    public void run() {
                        int access$000 = (int) VideoPlayer.this.curtime;
                        VideoPlayer.sb_time.setProgress(access$000);
                        VideoPlayer.tv_cur_time.setText(String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(access$000 / 3600), Integer.valueOf((access$000 / 60) % 60), Integer.valueOf(access$000 % 60)}));
                    }
                });
            } else if (i == 2) {
                boolean unused = VideoPlayer.this.isHide = true;
            } else if (i == 3) {
                boolean unused2 = VideoPlayer.this.isHide = false;
            } else if (i == 11) {
                VideoPlayer.this.Pause();
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean isHide = false;
    protected boolean isOver = false;
    protected boolean isPause = true;
    private boolean isRunning = false;
    /* access modifiers changed from: private */
    public boolean isStop = false;
    protected boolean is_first = true;
    private ImageView iv_bg = null;
    private ImageView iv_next = null;
    private ImageView iv_prev = null;
    private ImageView iv_stop = null;
    private RelativeLayout ly_status = null;
    private RelativeLayout ly_time = null;
    /* access modifiers changed from: private */
    public Bitmap mBitmap = null;
    Runnable mRunnable = new Runnable() {
        public void run() {
            Date date = new Date(System.currentTimeMillis());
            VideoPlayer.this.oldtime = date.getTime();
            double unused = VideoPlayer.this.curtime = 0.0d;
            boolean unused2 = VideoPlayer.isPlay = true;
            boolean unused3 = VideoPlayer.this.isStop = false;
            int i = 0;
            while (!VideoPlayer.this.isStop) {
                Date date2 = new Date(System.currentTimeMillis());
                VideoPlayer.this.curtime1 = date2.getTime();
                VideoPlayer videoPlayer = VideoPlayer.this;
                double d = videoPlayer.offsettime;
                double d2 = (double) (VideoPlayer.this.curtime1 - VideoPlayer.this.oldtime);
                Double.isNaN(d2);
                double unused4 = videoPlayer.curtime = d + (d2 / 1000.0d);
                int access$000 = (int) VideoPlayer.this.curtime;
                if (access$000 != i) {
                    Message message = new Message();
                    message.what = 1;
                    VideoPlayer.this.handler.sendMessage(message);
                    i = access$000;
                }
                if (VideoPlayer.this.curtime >= ((double) VideoPlayer.this.totaltime)) {
                    VideoPlayer videoPlayer2 = VideoPlayer.this;
                    videoPlayer2.isOver = true;
                    boolean unused5 = videoPlayer2.isStop = true;
                    boolean unused6 = VideoPlayer.isPlay = false;
                    return;
                }
                byte[] iCameraGetOneSecond = NativeCaller.iCameraGetOneSecond(VideoPlayer.this.curtime);
                VideoPlayer.logEx.e("####### Player!");
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(iCameraGetOneSecond, 0, iCameraGetOneSecond.length);
                if (decodeByteArray != null) {
                    Bitmap unused7 = VideoPlayer.this.mBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), VideoPlayer.this.matrix, true);
                    VideoPlayer.mSurface.SetBitmap(VideoPlayer.this.mBitmap);
                    decodeByteArray.recycle();
                }
            }
        }
    };
    private Thread mThread = null;
    /* access modifiers changed from: private */
    public Matrix matrix = null;
    protected double offsettime = 0.0d;
    protected long oldtime = 0;
    private double pausetime = 0.0d;
    protected boolean recount_time = true;
    private SeekBar sb_voice = null;
    private int screenHeight = 0;
    private int screenWidth = 0;
    private String subName = "";
    private LinearLayout surfaceLayout = null;
    private SurfaceViews surfaceViews = null;
    private String timeString = "";
    private int totalframe = 0;
    /* access modifiers changed from: private */
    public int totaltime = 0;
    private TextView tvReturn = null;
    private RelativeLayout vpScreenLayout = null;

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getWindow().addFlags(128);
        super.onCreate(bundle);
        setContentView(R.layout.videoplayer);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        this.CurVideoPath = getIntent().getStringExtra("VideoPath");
        LogUtils logUtils = logEx;
        logUtils.e("total frame!" + this.CurVideoPath);
        this.matrix = new Matrix();
        widget_init();
        if (!new File(this.CurVideoPath).exists()) {
            logEx.e("total frame is not exist");
            return;
        }
        NativeCaller.iCameraOpenFile(this.CurVideoPath);
        this.totaltime = (int) NativeCaller.iCameraGetTotalTime();
        this.totalframe = NativeCaller.iCameraGetTotalFrame();
        Play();
        int iCameraGetTotalFrame = NativeCaller.iCameraGetTotalFrame();
        LogUtils logUtils2 = logEx;
        logUtils2.e("total frame!" + iCameraGetTotalFrame);
        sb_time.setMax(this.totaltime);
        sb_time.setProgress(0);
        tv_left_time.setText(String.format("/%02d:%02d:%02d", new Object[]{Integer.valueOf(this.totaltime / 3600), Integer.valueOf((this.totaltime / 60) % 60), Integer.valueOf(this.totaltime % 60)}));
        tv_cur_time.setText("00:00:00");
        this.isRunning = true;
    }

    private void widget_init() {
        mSurface = (SurfaceViews) findViewById(R.id.videoPlaySurface);
        this.surfaceLayout = (LinearLayout) findViewById(R.id.surfaceLayout);
        this.vpScreenLayout = (RelativeLayout) findViewById(R.id.vpscreenLayout);
        tv_cur_time = (TextView) findViewById(R.id.tv_cur_time_videoplayer);
        tv_left_time = (TextView) findViewById(R.id.tv_left_time_videoplayer);
        this.iv_stop = (ImageView) findViewById(R.id.iv_stop_videoplayer);
        this.iv_prev = (ImageView) findViewById(R.id.iv_prev_videoplayer);
        this.iv_next = (ImageView) findViewById(R.id.iv_next_videoplayer);
        this.tvReturn = (TextView) findViewById(R.id.back);
        iv_pause = (ImageView) findViewById(R.id.iv_pause_videoplayer);
        this.iv_bg = (ImageView) findViewById(R.id.iv_bg_videoplayer);
        sb_time = (SeekBar) findViewById(R.id.sb_timebar_videoplayer);
        this.sb_voice = (SeekBar) findViewById(R.id.sb_voice_control_videoplayer);
        this.iv_stop.setOnClickListener(this);
        iv_pause.setOnClickListener(this);
        this.iv_prev.setOnClickListener(this);
        this.iv_next.setOnClickListener(this);
        this.tvReturn.setOnClickListener(this);
        sb_time.setOnSeekBarChangeListener(this);
        this.sb_voice.setOnSeekBarChangeListener(this);
    }

    public void Play() {
        Thread thread = this.mThread;
        if (thread == null || !thread.isAlive()) {
            this.mThread = new Thread(this.mRunnable);
            this.mThread.start();
        }
    }

    private String transTime(String str) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            this.isStop = true;
            NativeCaller.iCameraCloseFile();
            onBackPressed();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r1 != 261) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            r5.getPointerCount()
            int r0 = r5.getAction()
            r1 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r1
            int r0 = r0 >>> 8
            int r1 = r5.getAction()
            r2 = 1
            if (r1 == 0) goto L_0x0021
            if (r1 == r2) goto L_0x001e
            r3 = 5
            if (r1 == r3) goto L_0x0021
            r3 = 261(0x105, float:3.66E-43)
            if (r1 == r3) goto L_0x0021
            goto L_0x005d
        L_0x001e:
            r4.recount_time = r2
            goto L_0x005d
        L_0x0021:
            r5.getX(r0)
            r5.getY(r0)
            boolean r5 = r4.isHide
            if (r5 != 0) goto L_0x0050
            r5 = 0
            r4.recount_time = r5
            boolean r0 = r4.isPause
            if (r0 == 0) goto L_0x0042
            isPlay = r2
            r4.isStop = r5
            r4.RePlay()
            long r0 = java.lang.System.currentTimeMillis()
            r4.LastMicroSecond = r0
            r4.isPause = r5
            goto L_0x005d
        L_0x0042:
            r4.Pause()
            r4.isStop = r2
            isPlay = r5
            long r0 = r4.Race_Current_Time
            r4.TimeOffset = r0
            r4.isPause = r2
            goto L_0x005d
        L_0x0050:
            android.os.Message r5 = new android.os.Message
            r5.<init>()
            r0 = 3
            r5.what = r0
            android.os.Handler r0 = r4.handler
            r0.sendMessage(r5)
        L_0x005d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tzh.ipcamera.view.VC.VideoPlayer.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void Pause() {
        double d = this.curtime;
        this.pausetime = d;
        this.offsettime = d;
        this.isStop = true;
        isPlay = false;
        Message message = new Message();
        message.what = 1;
        this.handler.sendMessage(message);
    }

    public void RePlay() {
        this.isStop = false;
        if (this.isOver) {
            this.isOver = false;
            this.offsettime = 0.0d;
            this.curtime = 0.0d;
            this.pausetime = 0.0d;
            sb_time.setProgress(0);
            tv_cur_time.setText("00:00:00");
        }
        Play();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.isStop = true;
        NativeCaller.iCameraCloseFile();
        Thread thread = this.mThread;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finish();
    }

    private class SeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        private SeekBarChangeListener() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            VideoPlayer videoPlayer = VideoPlayer.this;
            videoPlayer.oldtime = videoPlayer.curtime1;
            VideoPlayer videoPlayer2 = VideoPlayer.this;
            double d = (double) i;
            videoPlayer2.offsettime = d;
            if (videoPlayer2.isOver) {
                VideoPlayer videoPlayer3 = VideoPlayer.this;
                videoPlayer3.isOver = false;
                boolean unused = videoPlayer3.isStop = false;
                VideoPlayer videoPlayer4 = VideoPlayer.this;
                videoPlayer4.offsettime = d;
                videoPlayer4.Play();
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            int progress = seekBar.getProgress();
            NativeCaller.iCameraGetOneSecond((double) progress);
            VideoPlayer.tv_cur_time.setText(new TimeUtils((long) progress).getTime());
        }
    }
}
