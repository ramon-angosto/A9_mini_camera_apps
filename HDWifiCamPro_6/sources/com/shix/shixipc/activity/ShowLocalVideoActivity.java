package com.shix.shixipc.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.AudioPlayer;
import com.shix.shixipc.utils.CustomBuffer;
import kotlin.UByte;
import object.p2pipcam.nativecaller.MyRender;

public class ShowLocalVideoActivity extends BaseActivity implements View.OnClickListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnTouchListener {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    /* access modifiers changed from: private */
    public CustomBuffer AudioBuffer = null;
    private AudioPlayer audioPlayer = null;
    /* access modifiers changed from: private */
    public RelativeLayout bottomLayout;
    private Button btnBack;
    /* access modifiers changed from: private */
    public Button btnPlay;
    /* access modifiers changed from: private */
    public String filePath = null;
    /* access modifiers changed from: private */
    public boolean flag = true;
    /* access modifiers changed from: private */
    public int frameCout = 0;
    private GestureDetector gt = new GestureDetector(this);
    private int ht;
    /* access modifiers changed from: private */
    public ImageView img;
    /* access modifiers changed from: private */
    public ImageView imgPause;
    /* access modifiers changed from: private */
    public boolean isH265 = false;
    /* access modifiers changed from: private */
    public boolean isInitH265 = false;
    /* access modifiers changed from: private */
    public boolean isPause = false;
    /* access modifiers changed from: private */
    public boolean isPlaying = false;
    /* access modifiers changed from: private */
    public boolean isShowing = false;
    /* access modifiers changed from: private */
    public boolean isStart = true;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                boolean unused = ShowLocalVideoActivity.this.isShowing = false;
                ShowLocalVideoActivity.this.topLayout.setVisibility(8);
                ShowLocalVideoActivity.this.bottomLayout.setVisibility(8);
            } else if (i != 2) {
                if (i == 3) {
                    ShowLocalVideoActivity.this.seekBar.setProgress(ShowLocalVideoActivity.this.videoSumTime);
                }
            } else if (ShowLocalVideoActivity.this.videoSumTime < 0) {
                ShowLocalVideoActivity.this.tvSumTime.setText(ShowLocalVideoActivity.this.getResources().getString(R.string.ptz_takevideo_time_show));
            } else {
                ShowLocalVideoActivity.this.seekBar.setMax(ShowLocalVideoActivity.this.videoSumTime);
                TextView access$400 = ShowLocalVideoActivity.this.tvSumTime;
                ShowLocalVideoActivity showLocalVideoActivity = ShowLocalVideoActivity.this;
                access$400.setText(showLocalVideoActivity.getTime(showLocalVideoActivity.videoSumTime / 1000));
                ShowLocalVideoActivity.this.startVideo();
            }
        }
    };
    /* access modifiers changed from: private */
    public Handler mPlayHandler = new Handler() {
        public void handleMessage(Message message) {
            Bitmap bitmap = (Bitmap) message.obj;
            if (bitmap == null) {
                Log.d("tag", "play this picture failed");
            } else {
                ShowLocalVideoActivity.this.img.setImageBitmap(bitmap);
            }
        }
    };
    /* access modifiers changed from: private */
    public Handler mProgressHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ShowLocalVideoActivity.this.seekBar.setProgress(ShowLocalVideoActivity.this.progress);
                TextView access$2600 = ShowLocalVideoActivity.this.tvCurrentTime;
                ShowLocalVideoActivity showLocalVideoActivity = ShowLocalVideoActivity.this;
                access$2600.setText(showLocalVideoActivity.getTime(showLocalVideoActivity.progress));
            } else if (i == 2) {
                ShowLocalVideoActivity.this.imgPause.setVisibility(8);
                ShowLocalVideoActivity.this.btnPlay.setBackgroundResource(R.drawable.video_play_pause_selector);
                ShowLocalVideoActivity.this.showToast((int) R.string.local_video_play_over);
                Log.d("tag", "ZHAOPLAY end");
            }
        }
    };
    private TextView mTv_Prompt;
    /* access modifiers changed from: private */
    public GLSurfaceView myGLSurfaceView;
    /* access modifiers changed from: private */
    public Runnable myProRunnable = new Runnable() {
        public void run() {
            if (ShowLocalVideoActivity.this.seekBar.getProgress() != ShowLocalVideoActivity.this.seekBar.getMax()) {
                ShowLocalVideoActivity.this.seekBar.setProgress(ShowLocalVideoActivity.this.sumTime);
                TextView access$2600 = ShowLocalVideoActivity.this.tvCurrentTime;
                ShowLocalVideoActivity showLocalVideoActivity = ShowLocalVideoActivity.this;
                access$2600.setText(showLocalVideoActivity.getTime(showLocalVideoActivity.sumTime / 1000));
                ShowLocalVideoActivity.this.mProgressHandler.postDelayed(ShowLocalVideoActivity.this.myProRunnable, 300);
            }
        }
    };
    /* access modifiers changed from: private */
    public MyRender myRender;
    private PlayThread playThread;
    /* access modifiers changed from: private */
    public int progress = 0;
    /* access modifiers changed from: private */
    public ProgressBar seekBar;
    private String strCameraName;
    private int sum;
    /* access modifiers changed from: private */
    public int sumTime;
    /* access modifiers changed from: private */
    public RelativeLayout topLayout;
    /* access modifiers changed from: private */
    public TextView tvCurrentTime;
    /* access modifiers changed from: private */
    public TextView tvSumTime;
    private TextView tvTime;
    private TextView tvTitle;
    /* access modifiers changed from: private */
    public int videoSumTime;
    private int wh;
    private float x1 = 0.0f;
    private float x2 = 0.0f;
    private float y1 = 0.0f;
    private float y2 = 0.0f;

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    static /* synthetic */ int access$1008(ShowLocalVideoActivity showLocalVideoActivity) {
        int i = showLocalVideoActivity.frameCout;
        showLocalVideoActivity.frameCout = i + 1;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        this.isInitH265 = false;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(128, 128);
        setContentView(R.layout.showlocalvideo_activity);
        findView();
        setListener();
        TextView textView = this.tvTime;
        textView.setText(getResources().getString(R.string.local_video_date) + getContent(this.filePath));
        firstPicture();
        this.mHandler.sendEmptyMessageDelayed(1, 1000);
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this.AudioBuffer);
        StartAudio();
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
        this.btnPlay.setOnClickListener(this);
        this.img.setOnTouchListener(this);
        this.topLayout.setOnTouchListener(this);
        this.bottomLayout.setOnTouchListener(this);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.filePath = intent.getStringExtra("filepath");
        this.strCameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        Log.d("tag", "strDID:" + this.filePath);
    }

    private void findView() {
        this.myGLSurfaceView = (GLSurfaceView) findViewById(R.id.glsurfaceview);
        this.myRender = new MyRender(this.myGLSurfaceView);
        this.myGLSurfaceView.setRenderer(this.myRender);
        this.wh = getWindowManager().getDefaultDisplay().getWidth();
        this.ht = getWindowManager().getDefaultDisplay().getHeight();
        this.btnBack = (Button) findViewById(R.id.back);
        this.btnBack.setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(R.id.takevideo_title);
        TextView textView = this.tvTitle;
        textView.setText(this.strCameraName + "");
        this.tvTime = (TextView) findViewById(R.id.takevideo_time);
        this.img = (ImageView) findViewById(R.id.img_playvideo);
        this.imgPause = (ImageView) findViewById(R.id.img_pause);
        this.topLayout = (RelativeLayout) findViewById(R.id.top);
        this.bottomLayout = (RelativeLayout) findViewById(R.id.bottom);
        this.seekBar = (ProgressBar) findViewById(R.id.progressBar1);
        this.tvSumTime = (TextView) findViewById(R.id.sumtime);
        this.tvCurrentTime = (TextView) findViewById(R.id.currenttime);
        this.btnPlay = (Button) findViewById(R.id.btn_play);
        if (getResources().getConfiguration().orientation == 1) {
            int i = this.wh;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 3) / 4);
            layoutParams.gravity = 17;
            this.myGLSurfaceView.setLayoutParams(layoutParams);
            this.img.setLayoutParams(layoutParams);
            this.tvTime.setVisibility(8);
        } else if (getResources().getConfiguration().orientation == 2) {
            this.tvTime.setVisibility(0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.wh, this.ht);
            layoutParams2.gravity = 17;
            this.img.setLayoutParams(layoutParams2);
            this.myGLSurfaceView.setLayoutParams(layoutParams2);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.wh = getWindowManager().getDefaultDisplay().getWidth();
        this.ht = getWindowManager().getDefaultDisplay().getHeight();
        if (getResources().getConfiguration().orientation == 1) {
            int i = this.wh;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 3) / 4);
            layoutParams.gravity = 17;
            this.myGLSurfaceView.setLayoutParams(layoutParams);
            this.img.setLayoutParams(layoutParams);
        } else if (getResources().getConfiguration().orientation == 2) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.wh, this.ht);
            layoutParams2.gravity = 17;
            this.img.setLayoutParams(layoutParams2);
            this.myGLSurfaceView.setLayoutParams(layoutParams2);
        }
    }

    private String getContent(String str) {
        Log.d("tag", "filePath:" + str);
        String substring = str.substring(str.lastIndexOf("/") + 1);
        Log.d("tag", "filePath:" + substring);
        if (substring == null || substring.length() < 15) {
            return "";
        }
        String str2 = substring.substring(0, 4) + "-" + substring.substring(4, 6) + "-" + substring.substring(6, 8) + "  " + substring.substring(9, 11) + ":" + substring.substring(11, 13) + ":" + substring.substring(13, 15);
        Log.d("tag", "result:" + str2);
        return str2;
    }

    /* access modifiers changed from: private */
    public String getTime(int i) {
        String str;
        String str2;
        String str3;
        int i2 = i % 60;
        int i3 = i / 60;
        int i4 = i3 / 60;
        if (i2 < 10) {
            str = MBridgeConstans.ENDCARD_URL_TYPE_PL + i2;
        } else {
            str = String.valueOf(i2);
        }
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
        return str3 + ":" + str2 + ":" + str;
    }

    private class PlayThread extends Thread {
        private PlayThread() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:105:0x03f4, code lost:
            r9 = r8;
            r0 = 4;
            r3 = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x02b6, code lost:
            r0 = 4;
            r3 = 3;
         */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x03b7 A[Catch:{ Exception -> 0x0413, all -> 0x0411 }] */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x0465 A[SYNTHETIC, Splitter:B:131:0x0465] */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x033b A[Catch:{ Exception -> 0x0413, all -> 0x0411 }] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x035c A[Catch:{ Exception -> 0x0413, all -> 0x0411 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r17 = this;
                r1 = r17
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this
                java.lang.String r0 = r0.filePath
                if (r0 == 0) goto L_0x046f
                java.io.File r0 = new java.io.File
                com.shix.shixipc.activity.ShowLocalVideoActivity r2 = com.shix.shixipc.activity.ShowLocalVideoActivity.this
                java.lang.String r2 = r2.filePath
                r0.<init>(r2)
                r2 = 0
                r3 = 3
                java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x041a }
                r4.<init>(r0)     // Catch:{ Exception -> 0x041a }
                r0 = 4
                byte[] r2 = new byte[r0]     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                r4.read(r2)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                int r2 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r2)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                java.lang.String r5 = "tag"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                r6.<init>()     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                java.lang.String r7 = "ZHAOPLAY fType:"
                r6.append(r7)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                r6.append(r2)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                android.util.Log.d(r5, r6)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                r5.<init>()     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                java.lang.String r6 = "ZHAOPLAY fType:"
                r5.append(r6)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                r5.append(r2)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                java.lang.String r6 = "  flag:"
                r5.append(r6)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r6 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                boolean r6 = r6.flag     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                r5.append(r6)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                r6 = 1
                com.shix.shixipc.utils.CommonUtil.Log(r6, r5)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r5 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                r7 = 0
                int unused = r5.frameCout = r7     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r5 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                int unused = r5.sumTime = r7     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r5 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                boolean unused = r5.flag = r6     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r5 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                android.os.Handler r5 = r5.mProgressHandler     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                java.lang.Runnable r8 = r8.myProRunnable     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                r9 = 0
                r5.postDelayed(r8, r9)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
            L_0x0080:
                int r5 = r4.available()     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                if (r5 == 0) goto L_0x03fc
                com.shix.shixipc.activity.ShowLocalVideoActivity r5 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                boolean r5 = r5.flag     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                if (r5 == 0) goto L_0x03fc
                com.shix.shixipc.activity.ShowLocalVideoActivity r5 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                monitor-enter(r5)     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
                java.lang.String r8 = "tag"
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f9 }
                r11.<init>()     // Catch:{ all -> 0x03f9 }
                java.lang.String r12 = "ZHAOPLAY flag="
                r11.append(r12)     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r12 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean r12 = r12.flag     // Catch:{ all -> 0x03f9 }
                r11.append(r12)     // Catch:{ all -> 0x03f9 }
                java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x03f9 }
                android.util.Log.d(r8, r11)     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean r8 = r8.isPlaying     // Catch:{ all -> 0x03f9 }
                if (r8 == 0) goto L_0x03c5
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity.access$1008(r8)     // Catch:{ all -> 0x03f9 }
                r11 = 10
                r8 = 16711935(0xff00ff, float:2.3418409E-38)
                r13 = 110(0x6e, float:1.54E-43)
                r14 = 2
                if (r2 == r6) goto L_0x01f5
                if (r2 == r14) goto L_0x00c8
                goto L_0x01be
            L_0x00c8:
                java.util.Date r15 = new java.util.Date     // Catch:{ all -> 0x03f9 }
                r15.<init>()     // Catch:{ all -> 0x03f9 }
                long r15 = r15.getTime()     // Catch:{ all -> 0x03f9 }
                byte[] r9 = new byte[r0]     // Catch:{ all -> 0x03f9 }
                r4.read(r9)     // Catch:{ all -> 0x03f9 }
                int r9 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r9)     // Catch:{ all -> 0x03f9 }
                if (r9 == 0) goto L_0x01c2
                r10 = 200000(0x30d40, float:2.8026E-40)
                if (r9 <= r10) goto L_0x00e3
                goto L_0x01c2
            L_0x00e3:
                byte[] r10 = new byte[r0]     // Catch:{ all -> 0x03f9 }
                r4.read(r10)     // Catch:{ all -> 0x03f9 }
                int r10 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r10)     // Catch:{ all -> 0x03f9 }
                byte[] r14 = new byte[r0]     // Catch:{ all -> 0x03f9 }
                r4.read(r14)     // Catch:{ all -> 0x03f9 }
                int r14 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r14)     // Catch:{ all -> 0x03f9 }
                byte[] r0 = new byte[r9]     // Catch:{ all -> 0x03f9 }
                r4.read(r0)     // Catch:{ all -> 0x03f9 }
                if (r10 != r13) goto L_0x011d
                com.shix.shixipc.utils.CustomBufferHead r10 = new com.shix.shixipc.utils.CustomBufferHead     // Catch:{ all -> 0x03f9 }
                r10.<init>()     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.utils.CustomBufferData r11 = new com.shix.shixipc.utils.CustomBufferData     // Catch:{ all -> 0x03f9 }
                r11.<init>()     // Catch:{ all -> 0x03f9 }
                r10.length = r9     // Catch:{ all -> 0x03f9 }
                r10.startcode = r8     // Catch:{ all -> 0x03f9 }
                r11.head = r10     // Catch:{ all -> 0x03f9 }
                r11.data = r0     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.utils.CustomBuffer r0 = r0.AudioBuffer     // Catch:{ all -> 0x03f9 }
                r0.addData(r11)     // Catch:{ all -> 0x03f9 }
                monitor-exit(r5)     // Catch:{ all -> 0x03f9 }
            L_0x0118:
                r0 = 4
            L_0x0119:
                r9 = 0
                goto L_0x0080
            L_0x011d:
                int r8 = r0.length     // Catch:{ all -> 0x03f9 }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r7, r8)     // Catch:{ all -> 0x03f9 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f9 }
                r8.<init>()     // Catch:{ all -> 0x03f9 }
                java.lang.String r13 = "ZHAOPLAY length:"
                r8.append(r13)     // Catch:{ all -> 0x03f9 }
                r8.append(r9)     // Catch:{ all -> 0x03f9 }
                java.lang.String r9 = "  type:"
                r8.append(r9)     // Catch:{ all -> 0x03f9 }
                r8.append(r10)     // Catch:{ all -> 0x03f9 }
                java.lang.String r9 = "  time:"
                r8.append(r9)     // Catch:{ all -> 0x03f9 }
                r8.append(r14)     // Catch:{ all -> 0x03f9 }
                java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.utils.CommonUtil.Log(r6, r8)     // Catch:{ all -> 0x03f9 }
                if (r0 == 0) goto L_0x015d
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                android.os.Handler r8 = r8.mPlayHandler     // Catch:{ all -> 0x03f9 }
                android.os.Message r8 = r8.obtainMessage()     // Catch:{ all -> 0x03f9 }
                r8.obj = r0     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                android.os.Handler r0 = r0.mPlayHandler     // Catch:{ all -> 0x03f9 }
                r0.sendMessage(r8)     // Catch:{ all -> 0x03f9 }
            L_0x015d:
                r0 = 1000(0x3e8, float:1.401E-42)
                if (r14 <= r0) goto L_0x0168
                r8 = 100
                java.lang.Thread.sleep(r8)     // Catch:{ all -> 0x03f9 }
                monitor-exit(r5)     // Catch:{ all -> 0x03f9 }
                goto L_0x0118
            L_0x0168:
                java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x03f9 }
                r0.<init>()     // Catch:{ all -> 0x03f9 }
                long r8 = r0.getTime()     // Catch:{ all -> 0x03f9 }
                long r8 = r8 - r15
                int r0 = (int) r8     // Catch:{ all -> 0x03f9 }
                int r8 = r14 - r0
                if (r8 <= 0) goto L_0x01ae
                com.shix.shixipc.activity.ShowLocalVideoActivity r9 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r10 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                int r10 = r10.sumTime     // Catch:{ all -> 0x03f9 }
                int r10 = r10 + r0
                int unused = r9.sumTime = r10     // Catch:{ all -> 0x03f9 }
                int r0 = r8 / 10
                int r8 = r8 % 10
                r9 = r7
            L_0x0188:
                if (r9 >= r0) goto L_0x019d
                com.shix.shixipc.activity.ShowLocalVideoActivity r10 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r13 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                int r13 = r13.sumTime     // Catch:{ all -> 0x03f9 }
                int r13 = r13 + 10
                int unused = r10.sumTime = r13     // Catch:{ all -> 0x03f9 }
                java.lang.Thread.sleep(r11)     // Catch:{ all -> 0x03f9 }
                int r9 = r9 + 1
                goto L_0x0188
            L_0x019d:
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r9 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                int r9 = r9.sumTime     // Catch:{ all -> 0x03f9 }
                int r9 = r9 + r8
                int unused = r0.sumTime = r9     // Catch:{ all -> 0x03f9 }
                long r8 = (long) r8     // Catch:{ all -> 0x03f9 }
                java.lang.Thread.sleep(r8)     // Catch:{ all -> 0x03f9 }
                goto L_0x01be
            L_0x01ae:
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                int r8 = r8.sumTime     // Catch:{ all -> 0x03f9 }
                int r8 = r8 + r14
                int unused = r0.sumTime = r8     // Catch:{ all -> 0x03f9 }
                long r8 = (long) r14     // Catch:{ all -> 0x03f9 }
                java.lang.Thread.sleep(r8)     // Catch:{ all -> 0x03f9 }
            L_0x01be:
                r8 = 0
                goto L_0x03f3
            L_0x01c2:
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r0.flag = r7     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r0.isStart = r6     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r0.isPlaying = r7     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                android.os.Handler r0 = r0.mProgressHandler     // Catch:{ all -> 0x03f9 }
                r0.sendEmptyMessage(r14)     // Catch:{ all -> 0x03f9 }
                monitor-exit(r5)     // Catch:{ all -> 0x03f9 }
                java.lang.String r0 = "tag"
                java.lang.String r2 = "ZHAOPLAY finally"
                android.util.Log.d(r0, r2)
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this
                android.os.Handler r0 = r0.mHandler
                r0.sendEmptyMessage(r3)
                r4.close()     // Catch:{ IOException -> 0x01ef }
                goto L_0x01f4
            L_0x01ef:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
            L_0x01f4:
                return
            L_0x01f5:
                java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x03f9 }
                r0.<init>()     // Catch:{ all -> 0x03f9 }
                long r9 = r0.getTime()     // Catch:{ all -> 0x03f9 }
                r0 = 4
                byte[] r15 = new byte[r0]     // Catch:{ all -> 0x03f9 }
                byte[] r11 = new byte[r0]     // Catch:{ all -> 0x03f9 }
                byte[] r12 = new byte[r0]     // Catch:{ all -> 0x03f9 }
                byte[] r8 = new byte[r0]     // Catch:{ all -> 0x03f9 }
                byte[] r13 = new byte[r0]     // Catch:{ all -> 0x03f9 }
                r4.read(r15)     // Catch:{ all -> 0x03f9 }
                r4.read(r11)     // Catch:{ all -> 0x03f9 }
                r4.read(r12)     // Catch:{ all -> 0x03f9 }
                r4.read(r8)     // Catch:{ all -> 0x03f9 }
                r4.read(r13)     // Catch:{ all -> 0x03f9 }
                int r15 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r15)     // Catch:{ all -> 0x03f9 }
                if (r15 != 0) goto L_0x025a
                if (r15 != 0) goto L_0x025a
                java.lang.String r0 = "tag"
                java.lang.String r2 = "ZHAOPLAY length == 0"
                android.util.Log.d(r0, r2)     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r0.flag = r7     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r0.isStart = r6     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r0.isPlaying = r7     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                android.os.Handler r0 = r0.mProgressHandler     // Catch:{ all -> 0x03f9 }
                r0.sendEmptyMessage(r14)     // Catch:{ all -> 0x03f9 }
                monitor-exit(r5)     // Catch:{ all -> 0x03f9 }
                java.lang.String r0 = "tag"
                java.lang.String r2 = "ZHAOPLAY finally"
                android.util.Log.d(r0, r2)
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this
                android.os.Handler r0 = r0.mHandler
                r0.sendEmptyMessage(r3)
                r4.close()     // Catch:{ IOException -> 0x0254 }
                goto L_0x0259
            L_0x0254:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
            L_0x0259:
                return
            L_0x025a:
                int r11 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r11)     // Catch:{ all -> 0x03f9 }
                int r12 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r12)     // Catch:{ all -> 0x03f9 }
                int r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r8)     // Catch:{ all -> 0x03f9 }
                int r13 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r13)     // Catch:{ all -> 0x03f9 }
                byte[] r0 = new byte[r15]     // Catch:{ all -> 0x03f9 }
                r4.read(r0)     // Catch:{ all -> 0x03f9 }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f9 }
                r14.<init>()     // Catch:{ all -> 0x03f9 }
                java.lang.String r3 = "ZHAOPLAY length:"
                r14.append(r3)     // Catch:{ all -> 0x03f9 }
                r14.append(r15)     // Catch:{ all -> 0x03f9 }
                java.lang.String r3 = "  bIFrame:"
                r14.append(r3)     // Catch:{ all -> 0x03f9 }
                r14.append(r8)     // Catch:{ all -> 0x03f9 }
                java.lang.String r3 = "  time:"
                r14.append(r3)     // Catch:{ all -> 0x03f9 }
                r14.append(r13)     // Catch:{ all -> 0x03f9 }
                java.lang.String r3 = r14.toString()     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.utils.CommonUtil.Log(r6, r3)     // Catch:{ all -> 0x03f9 }
                r3 = 110(0x6e, float:1.54E-43)
                if (r8 != r3) goto L_0x02ba
                com.shix.shixipc.utils.CustomBufferHead r3 = new com.shix.shixipc.utils.CustomBufferHead     // Catch:{ all -> 0x03f9 }
                r3.<init>()     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.utils.CustomBufferData r8 = new com.shix.shixipc.utils.CustomBufferData     // Catch:{ all -> 0x03f9 }
                r8.<init>()     // Catch:{ all -> 0x03f9 }
                r3.length = r15     // Catch:{ all -> 0x03f9 }
                r9 = 16711935(0xff00ff, float:2.3418409E-38)
                r3.startcode = r9     // Catch:{ all -> 0x03f9 }
                r8.head = r3     // Catch:{ all -> 0x03f9 }
                r8.data = r0     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.utils.CustomBuffer r0 = r0.AudioBuffer     // Catch:{ all -> 0x03f9 }
                r0.addData(r8)     // Catch:{ all -> 0x03f9 }
                monitor-exit(r5)     // Catch:{ all -> 0x03f9 }
                r0 = 4
                r3 = 3
                goto L_0x0119
            L_0x02ba:
                r3 = 5
                if (r8 == r3) goto L_0x02c7
                r3 = 6
                if (r8 != r3) goto L_0x02c1
                goto L_0x02c7
            L_0x02c1:
                com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r3.isH265 = r7     // Catch:{ all -> 0x03f9 }
                goto L_0x02cc
            L_0x02c7:
                com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r3.isH265 = r6     // Catch:{ all -> 0x03f9 }
            L_0x02cc:
                com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean r3 = r3.isH265     // Catch:{ all -> 0x03f9 }
                if (r3 != r6) goto L_0x02e7
                com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean r3 = r3.isInitH265     // Catch:{ all -> 0x03f9 }
                if (r3 != 0) goto L_0x02e7
                com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r3.isInitH265 = r6     // Catch:{ all -> 0x03f9 }
                object.p2pipcam.nativecaller.NativeCaller.DecoderFree()     // Catch:{ all -> 0x03f9 }
                object.p2pipcam.nativecaller.NativeCaller.DecoderInit(r6)     // Catch:{ all -> 0x03f9 }
            L_0x02e7:
                com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean r3 = r3.isH265     // Catch:{ all -> 0x03f9 }
                if (r3 != 0) goto L_0x0302
                com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean r3 = r3.isInitH265     // Catch:{ all -> 0x03f9 }
                if (r3 != 0) goto L_0x0302
                com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r3.isInitH265 = r6     // Catch:{ all -> 0x03f9 }
                object.p2pipcam.nativecaller.NativeCaller.DecoderFree()     // Catch:{ all -> 0x03f9 }
                object.p2pipcam.nativecaller.NativeCaller.DecoderInit(r7)     // Catch:{ all -> 0x03f9 }
            L_0x0302:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f9 }
                r3.<init>()     // Catch:{ all -> 0x03f9 }
                java.lang.String r8 = "ZHAOPLAY isH265:"
                r3.append(r8)     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean r8 = r8.isH265     // Catch:{ all -> 0x03f9 }
                r3.append(r8)     // Catch:{ all -> 0x03f9 }
                java.lang.String r8 = "  w:"
                r3.append(r8)     // Catch:{ all -> 0x03f9 }
                r3.append(r11)     // Catch:{ all -> 0x03f9 }
                java.lang.String r8 = " h:"
                r3.append(r8)     // Catch:{ all -> 0x03f9 }
                r3.append(r12)     // Catch:{ all -> 0x03f9 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.utils.CommonUtil.Log(r6, r3)     // Catch:{ all -> 0x03f9 }
                int r11 = r11 * r12
                r3 = 3
                int r11 = r11 * r3
                r3 = 2
                int r11 = r11 / r3
                byte[] r8 = new byte[r11]     // Catch:{ all -> 0x03f9 }
                int[] r3 = new int[r3]     // Catch:{ all -> 0x03f9 }
                int r0 = object.p2pipcam.nativecaller.NativeCaller.DecodeH264Frame(r0, r6, r8, r15, r3)     // Catch:{ all -> 0x03f9 }
                if (r0 <= 0) goto L_0x0348
                r0 = r3[r7]     // Catch:{ all -> 0x03f9 }
                r3 = r3[r6]     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r11 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                object.p2pipcam.nativecaller.MyRender r11 = r11.myRender     // Catch:{ all -> 0x03f9 }
                r11.writeSample(r8, r0, r3)     // Catch:{ all -> 0x03f9 }
            L_0x0348:
                java.lang.String r0 = "ZHAOPLAY decoder end"
                com.shix.shixipc.utils.CommonUtil.Log(r6, r0)     // Catch:{ all -> 0x03f9 }
                java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x03f9 }
                r0.<init>()     // Catch:{ all -> 0x03f9 }
                long r11 = r0.getTime()     // Catch:{ all -> 0x03f9 }
                long r11 = r11 - r9
                int r0 = (int) r11     // Catch:{ all -> 0x03f9 }
                int r3 = r13 - r0
                if (r3 <= 0) goto L_0x03b7
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r9 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                int r9 = r9.sumTime     // Catch:{ all -> 0x03f9 }
                int r9 = r9 + r0
                int unused = r8.sumTime = r9     // Catch:{ all -> 0x03f9 }
                int r0 = r3 / 10
                int r3 = r3 % 10
                r8 = r7
            L_0x036d:
                if (r8 >= r0) goto L_0x0384
                com.shix.shixipc.activity.ShowLocalVideoActivity r9 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r10 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                int r10 = r10.sumTime     // Catch:{ all -> 0x03f9 }
                int r10 = r10 + 10
                int unused = r9.sumTime = r10     // Catch:{ all -> 0x03f9 }
                r9 = 10
                java.lang.Thread.sleep(r9)     // Catch:{ all -> 0x03f9 }
                int r8 = r8 + 1
                goto L_0x036d
            L_0x0384:
                r8 = 3
                if (r3 <= r8) goto L_0x0389
                int r3 = r3 + -3
            L_0x0389:
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r9 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                int r9 = r9.sumTime     // Catch:{ all -> 0x03f9 }
                int r9 = r9 + r3
                int unused = r8.sumTime = r9     // Catch:{ all -> 0x03f9 }
                long r8 = (long) r3     // Catch:{ all -> 0x03f9 }
                java.lang.Thread.sleep(r8)     // Catch:{ all -> 0x03f9 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f9 }
                r8.<init>()     // Catch:{ all -> 0x03f9 }
                java.lang.String r9 = "ZHAOPLAY remainTime:"
                r8.append(r9)     // Catch:{ all -> 0x03f9 }
                r8.append(r3)     // Catch:{ all -> 0x03f9 }
                java.lang.String r3 = "  count:"
                r8.append(r3)     // Catch:{ all -> 0x03f9 }
                r8.append(r0)     // Catch:{ all -> 0x03f9 }
                java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.utils.CommonUtil.Log(r6, r0)     // Catch:{ all -> 0x03f9 }
                goto L_0x01be
            L_0x03b7:
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                int r3 = r3.sumTime     // Catch:{ all -> 0x03f9 }
                int r3 = r3 + r13
                int unused = r0.sumTime = r3     // Catch:{ all -> 0x03f9 }
                goto L_0x01be
            L_0x03c5:
                java.lang.String r0 = "tag"
                java.lang.String r3 = "ZHAOPLAY wait 1"
                android.util.Log.d(r0, r3)     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r0.isPause = r6     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                r0.wait()     // Catch:{ all -> 0x03f9 }
                java.lang.String r0 = "tag"
                java.lang.String r3 = "ZHAOPLAY wait 2"
                android.util.Log.d(r0, r3)     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                boolean unused = r0.isPause = r7     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                android.os.Handler r0 = r0.mProgressHandler     // Catch:{ all -> 0x03f9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03f9 }
                java.lang.Runnable r3 = r3.myProRunnable     // Catch:{ all -> 0x03f9 }
                r8 = 0
                r0.postDelayed(r3, r8)     // Catch:{ all -> 0x03f9 }
            L_0x03f3:
                monitor-exit(r5)     // Catch:{ all -> 0x03f9 }
                r9 = r8
                r0 = 4
                r3 = 3
                goto L_0x0080
            L_0x03f9:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x03f9 }
                throw r0     // Catch:{ Exception -> 0x0413, all -> 0x0411 }
            L_0x03fc:
                java.lang.String r0 = "tag"
                java.lang.String r2 = "ZHAOPLAY finally"
                android.util.Log.d(r0, r2)
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this
                android.os.Handler r0 = r0.mHandler
                r2 = 3
                r0.sendEmptyMessage(r2)
                r4.close()     // Catch:{ IOException -> 0x044c }
                goto L_0x046f
            L_0x0411:
                r0 = move-exception
                goto L_0x0418
            L_0x0413:
                r0 = move-exception
                r2 = r4
                goto L_0x041b
            L_0x0416:
                r0 = move-exception
                r4 = r2
            L_0x0418:
                r2 = r0
                goto L_0x0452
            L_0x041a:
                r0 = move-exception
            L_0x041b:
                java.lang.String r3 = "tag"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0416 }
                r4.<init>()     // Catch:{ all -> 0x0416 }
                java.lang.String r5 = "ZHAOPLAY e:"
                r4.append(r5)     // Catch:{ all -> 0x0416 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0416 }
                r4.append(r0)     // Catch:{ all -> 0x0416 }
                java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0416 }
                android.util.Log.d(r3, r0)     // Catch:{ all -> 0x0416 }
                java.lang.String r0 = "tag"
                java.lang.String r3 = "ZHAOPLAY finally"
                android.util.Log.d(r0, r3)
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this
                android.os.Handler r0 = r0.mHandler
                r3 = 3
                r0.sendEmptyMessage(r3)
                if (r2 == 0) goto L_0x046f
                r2.close()     // Catch:{ IOException -> 0x044c }
                goto L_0x046f
            L_0x044c:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
                goto L_0x046f
            L_0x0452:
                java.lang.String r0 = "tag"
                java.lang.String r3 = "ZHAOPLAY finally"
                android.util.Log.d(r0, r3)
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this
                android.os.Handler r0 = r0.mHandler
                r3 = 3
                r0.sendEmptyMessage(r3)
                if (r4 == 0) goto L_0x046e
                r4.close()     // Catch:{ IOException -> 0x0469 }
                goto L_0x046e
            L_0x0469:
                r0 = move-exception
                r3 = r0
                r3.printStackTrace()
            L_0x046e:
                throw r2
            L_0x046f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.ShowLocalVideoActivity.PlayThread.run():void");
        }
    }

    private void pVideo() {
        synchronized (this) {
            notifyAll();
        }
    }

    private void firstPicture() {
        if (this.filePath != null) {
            new Thread() {
                /* JADX WARNING: Removed duplicated region for block: B:16:0x00ac A[SYNTHETIC, Splitter:B:16:0x00ac] */
                /* JADX WARNING: Removed duplicated region for block: B:25:0x00b8 A[SYNTHETIC, Splitter:B:25:0x00b8] */
                /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r9 = this;
                        java.io.File r0 = new java.io.File
                        com.shix.shixipc.activity.ShowLocalVideoActivity r1 = com.shix.shixipc.activity.ShowLocalVideoActivity.this
                        java.lang.String r1 = r1.filePath
                        r0.<init>(r1)
                        r1 = 0
                        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b5, all -> 0x00a8 }
                        r2.<init>(r0)     // Catch:{ Exception -> 0x00b5, all -> 0x00a8 }
                        int r0 = r2.available()     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r1 = 4
                        byte[] r3 = new byte[r1]     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r2.read(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        int r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r4.<init>()     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        java.lang.String r5 = "ZHAOPLAY fType:"
                        r4.append(r5)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r4.append(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        java.lang.String r5 = " fileSumLength:"
                        r4.append(r5)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r4.append(r0)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r5 = 1
                        com.shix.shixipc.utils.CommonUtil.Log(r5, r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r6 = 1000(0x3e8, double:4.94E-321)
                        r4 = 8
                        r8 = 2
                        if (r3 == r5) goto L_0x0086
                        if (r3 == r8) goto L_0x0046
                        goto L_0x00a2
                    L_0x0046:
                        com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        android.opengl.GLSurfaceView r3 = r3.myGLSurfaceView     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r3.setVisibility(r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        int r0 = r0 - r4
                        long r3 = (long) r0     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r2.skip(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        byte[] r0 = new byte[r1]     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r2.read(r0)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        com.shix.shixipc.activity.ShowLocalVideoActivity r1 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        int r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r0)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        int unused = r1.videoSumTime = r0     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r0.<init>()     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        java.lang.String r1 = "ZHAOPLAY videoSumTime:"
                        r0.append(r1)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        com.shix.shixipc.activity.ShowLocalVideoActivity r1 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        int r1 = r1.videoSumTime     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r0.append(r1)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        com.shix.shixipc.utils.CommonUtil.Log(r5, r0)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r0.sendEmptyMessageDelayed(r8, r6)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        goto L_0x00a2
                    L_0x0086:
                        int r0 = r0 - r4
                        long r3 = (long) r0     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r2.skip(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        byte[] r0 = new byte[r1]     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r2.read(r0)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        com.shix.shixipc.activity.ShowLocalVideoActivity r1 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        int r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r0)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        int unused = r1.videoSumTime = r0     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                        r0.sendEmptyMessageDelayed(r8, r6)     // Catch:{ Exception -> 0x00b6, all -> 0x00a6 }
                    L_0x00a2:
                        r2.close()     // Catch:{ IOException -> 0x00bc }
                        goto L_0x00c0
                    L_0x00a6:
                        r0 = move-exception
                        goto L_0x00aa
                    L_0x00a8:
                        r0 = move-exception
                        r2 = r1
                    L_0x00aa:
                        if (r2 == 0) goto L_0x00b4
                        r2.close()     // Catch:{ IOException -> 0x00b0 }
                        goto L_0x00b4
                    L_0x00b0:
                        r1 = move-exception
                        r1.printStackTrace()
                    L_0x00b4:
                        throw r0
                    L_0x00b5:
                        r2 = r1
                    L_0x00b6:
                        if (r2 == 0) goto L_0x00c0
                        r2.close()     // Catch:{ IOException -> 0x00bc }
                        goto L_0x00c0
                    L_0x00bc:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x00c0:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.ShowLocalVideoActivity.AnonymousClass2.run():void");
                }
            }.start();
        }
    }

    public static byte[] intToByte(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = new Integer(i & 255).byteValue();
            i >>= 8;
        }
        return bArr;
    }

    public static int byteToInt(byte[] bArr) {
        byte b = bArr[0] & UByte.MAX_VALUE;
        byte b2 = bArr[1] & UByte.MAX_VALUE;
        return ((bArr[3] & UByte.MAX_VALUE) << 24) | b | (b2 << 8) | ((bArr[2] & UByte.MAX_VALUE) << 16);
    }

    public static byte[] longToByte(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = new Long(255 & j).byteValue();
            j >>= 8;
        }
        return bArr;
    }

    public static long byteToLong(byte[] bArr) {
        return ((long) (bArr[0] & UByte.MAX_VALUE)) | (((long) (bArr[1] & UByte.MAX_VALUE)) << 8) | (((long) (bArr[2] & UByte.MAX_VALUE)) << 16) | (((long) (bArr[3] & UByte.MAX_VALUE)) << 24) | (((long) (bArr[4] & UByte.MAX_VALUE)) << 32) | (((long) (bArr[5] & UByte.MAX_VALUE)) << 40) | (((long) (bArr[6] & UByte.MAX_VALUE)) << 48) | (((long) (bArr[7] & UByte.MAX_VALUE)) << 56);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            this.flag = false;
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        } else if (id == R.id.btn_play) {
            if (this.isPlaying) {
                this.btnPlay.setBackgroundResource(R.drawable.video_play_pause_selector);
                this.imgPause.setVisibility(8);
                Log.d("tag", CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
                this.isPlaying = false;
                return;
            }
            this.btnPlay.setBackgroundResource(R.drawable.video_play_play_selector);
            this.imgPause.setVisibility(8);
            if (this.isStart) {
                startVideo();
                return;
            }
            this.isPlaying = true;
            pVideo();
        }
    }

    /* access modifiers changed from: private */
    public void startVideo() {
        this.imgPause.setVisibility(8);
        this.isStart = false;
        this.isPlaying = true;
        this.progress = 0;
        this.seekBar.setProgress(this.progress);
        this.tvCurrentTime.setText(getTime(this.progress));
        this.playThread = new PlayThread();
        this.playThread.start();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.flag = false;
        finish();
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.gt.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            StopAudio();
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (this.isShowing) {
            this.isShowing = false;
            this.topLayout.setVisibility(8);
            this.bottomLayout.setVisibility(8);
        } else {
            this.isShowing = true;
            this.topLayout.setVisibility(0);
            this.bottomLayout.setVisibility(0);
        }
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        Log.d("tag", "onDoubleTap");
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Log.d("tag", "onSingleTapConfirmed");
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id != R.id.bottom) {
            if (id != R.id.img_playvideo) {
                return id == R.id.top;
            }
            if (motionEvent.getAction() == 0) {
                if (this.isShowing) {
                    this.isShowing = false;
                    this.topLayout.setVisibility(8);
                    this.bottomLayout.setVisibility(8);
                } else {
                    this.isShowing = true;
                    this.topLayout.setVisibility(0);
                    this.bottomLayout.setVisibility(0);
                }
            }
        }
        return true;
    }
}
