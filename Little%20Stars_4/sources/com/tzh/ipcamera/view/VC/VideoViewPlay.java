package com.tzh.ipcamera.view.VC;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.presenter.Upload;
import com.tzh.ipcamera.view.AblumUtils;
import com.tzh.ipcamera.view.BasePlayer;
import com.tzh.ipcamera.view.SurfaceViews;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import shix.ihdbell.project.VideoActivity;

public class VideoViewPlay extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    protected static final int HideTime = 2;
    private static final int MSG_UPLOAD_FILE = 2;
    protected static final int ShowTime = 3;
    protected static final int ShowVideo = 5;
    protected static final int UpdateTime = 1;
    /* access modifiers changed from: private */
    public static LogUtils logEx = LogUtils.setLogger(VideoActivity.class);
    private static List<String> mPathList = new ArrayList();
    private static SurfaceViews mSurface = null;
    /* access modifiers changed from: private */
    public static SeekBar sb_time;
    private static int vIndex = 0;
    private Timer CM215_Top_Timer = null;
    private TimerTask CM215_Top_TimerTask = null;
    /* access modifiers changed from: private */
    public String CurVideoPath = "";
    protected long LastMicroSecond;
    protected long Race_Current_Time;
    protected String TAG = "VideoPlayer";
    protected long TimeOffset = 0;
    private int cur_frame = 0;
    private double curtime = 0.0d;
    protected long curtime1 = 0;
    private boolean isHide = false;
    protected boolean isOver = false;
    protected boolean isPause = true;
    private boolean isRunning = false;
    /* access modifiers changed from: private */
    public boolean isStop = false;
    protected boolean is_first = true;
    private ImageView iv_bg = null;
    private ImageView iv_next = null;
    private ImageView iv_pause = null;
    private ImageView iv_prev = null;
    private ImageView iv_stop = null;
    private RelativeLayout ly_status = null;
    private RelativeLayout ly_time = null;
    private MediaController mController;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 2) {
                VideoViewPlay.this.mView.setVisibility(4);
                AblumUtils instance = AblumUtils.getInstance(VideoViewPlay.this);
                VideoViewPlay videoViewPlay = VideoViewPlay.this;
                instance.insertVideoToMediaStore(videoViewPlay, videoViewPlay.CurVideoPath, VideoViewPlay.this.startTime, 1920, 1080, System.currentTimeMillis() - VideoViewPlay.this.startTime);
                VideoViewPlay videoViewPlay2 = VideoViewPlay.this;
                videoViewPlay2.showToast(videoViewPlay2.getResources().getString(R.string.upload_file_success));
            }
        }
    };
    Runnable mRunnable = new Runnable() {
        public void run() {
            int currentPosition = VideoViewPlay.this.mVideoView.getCurrentPosition() / PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE;
            String format = String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(currentPosition / 3600), Integer.valueOf((currentPosition / 60) % 60), Integer.valueOf(currentPosition % 60)});
            LogUtils access$400 = VideoViewPlay.logEx;
            access$400.e("###current time is " + currentPosition);
            VideoViewPlay.this.tvCurTime.setText(format);
            VideoViewPlay.sb_time.setProgress(currentPosition);
            if (currentPosition < VideoViewPlay.this.totaltime && VideoViewPlay.this.totaltime != 0) {
                VideoViewPlay.this.mHandler.postDelayed(VideoViewPlay.this.mRunnable, 200);
            }
        }
    };
    private Thread mThread = null;
    private Upload mUpload;
    /* access modifiers changed from: private */
    public BasePlayer mVideoView = null;
    /* access modifiers changed from: private */
    public View mView = null;
    protected double offsettime = 0.0d;
    protected long oldtime = 0;
    private double pausetime = 0.0d;
    protected boolean recount_time = true;
    private int screenHeight = 0;
    private int screenWidth = 0;
    /* access modifiers changed from: private */
    public long startTime;
    private int totalframe = 0;
    /* access modifiers changed from: private */
    public int totaltime = 0;
    private TextView tvBackIcon = null;
    /* access modifiers changed from: private */
    public TextView tvCurTime = null;
    /* access modifiers changed from: private */
    public TextView tvTotalTime = null;

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getWindow().addFlags(128);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.color_all_bg));
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_play);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
        this.CurVideoPath = getIntent().getStringExtra("VideoPath");
        File file = new File(this.CurVideoPath);
        widget_init();
        this.startTime = System.currentTimeMillis();
        if (file.exists()) {
            AblumUtils.getInstance(this);
            this.mController = new MediaController(this);
            LogUtils logUtils = logEx;
            logUtils.e("####video:" + file.getAbsolutePath());
            this.mVideoView.setVideoPath(file.getAbsolutePath());
            this.mVideoView.setMediaController(this.mController);
            this.mController.setVisibility(4);
            this.mController.setMediaPlayer(this.mVideoView);
            this.mVideoView.start();
            this.mVideoView.setEnabled(false);
            this.mHandler.postDelayed(this.mRunnable, 200);
            this.mVideoView.setOnPreparedListener(new PrePareListener());
        }
    }

    private void widget_init() {
        this.mView = initView(R.layout.loading);
        this.mUpload = new Upload(this);
        this.mView.setVisibility(4);
        this.tvCurTime = (TextView) findViewById(R.id.tv_cur_time_videoplayer);
        this.tvTotalTime = (TextView) findViewById(R.id.tv_left_time_videoplayer);
        this.mVideoView = (BasePlayer) findViewById(R.id.videoPlay);
        this.iv_stop = (ImageView) findViewById(R.id.iv_stop_videoplayer);
        this.iv_prev = (ImageView) findViewById(R.id.iv_prev_videoplayer);
        this.iv_next = (ImageView) findViewById(R.id.iv_next_videoplayer);
        this.iv_pause = (ImageView) findViewById(R.id.iv_pause_videoplayer);
        this.iv_bg = (ImageView) findViewById(R.id.iv_bg_videoplayer);
        sb_time = (SeekBar) findViewById(R.id.sb_timebar_videoplayer);
        this.tvBackIcon = (TextView) findViewById(R.id.back);
        this.tvBackIcon.setOnClickListener(this);
        this.iv_stop.setOnClickListener(this);
        this.iv_pause.setOnClickListener(this);
        this.iv_prev.setOnClickListener(this);
        this.iv_next.setOnClickListener(this);
        sb_time.setOnSeekBarChangeListener(this);
    }

    public void showToast(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public View initView(int i) {
        View inflate = View.inflate(this, i, (ViewGroup) null);
        if (inflate == null) {
            return null;
        }
        addContentView(inflate, new FrameLayout.LayoutParams(-1, -1));
        return inflate;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.isStop = true;
                this.mHandler.removeCallbacks(this.mRunnable);
                finish();
                return;
            case R.id.btnUpload:
                LogUtils logUtils = logEx;
                logUtils.e("###upload file path:" + this.CurVideoPath);
                this.mView.setVisibility(0);
                this.mHandler.sendEmptyMessageDelayed(2, 800);
                return;
            case R.id.iv_pause_videoplayer:
                if (this.mVideoView.isPlaying()) {
                    this.mVideoView.pause();
                    this.iv_pause.setImageResource(R.drawable.alarm_pause_btn);
                    this.mHandler.removeCallbacks(this.mRunnable);
                    return;
                }
                this.mVideoView.start();
                this.iv_pause.setImageResource(R.drawable.alarm_play_btn);
                this.mHandler.postDelayed(this.mRunnable, 200);
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.isStop = true;
        this.mHandler.removeCallbacks(this.mRunnable);
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

    private class PrePareListener implements MediaPlayer.OnPreparedListener {
        private PrePareListener() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            int unused = VideoViewPlay.this.totaltime = mediaPlayer.getDuration() / PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE;
            LogUtils access$400 = VideoViewPlay.logEx;
            access$400.e("###video_time" + VideoViewPlay.this.totaltime);
            VideoViewPlay.this.tvTotalTime.setText(String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(VideoViewPlay.this.totaltime / 3600), Integer.valueOf((VideoViewPlay.this.totaltime / 60) % 60), Integer.valueOf(VideoViewPlay.this.totaltime % 60)}));
            VideoViewPlay.sb_time.setMax(VideoViewPlay.this.totaltime);
        }
    }

    private class SeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        private SeekBarChangeListener() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            VideoViewPlay videoViewPlay = VideoViewPlay.this;
            videoViewPlay.oldtime = videoViewPlay.curtime1;
            VideoViewPlay videoViewPlay2 = VideoViewPlay.this;
            double d = (double) i;
            videoViewPlay2.offsettime = d;
            if (videoViewPlay2.isOver) {
                VideoViewPlay videoViewPlay3 = VideoViewPlay.this;
                videoViewPlay3.isOver = false;
                boolean unused = videoViewPlay3.isStop = false;
                VideoViewPlay.this.offsettime = d;
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            seekBar.getProgress();
        }
    }
}
