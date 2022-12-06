package com.shix.shixipc.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.AudioPlayer;
import com.shix.shixipc.utils.CustomBuffer;
import com.shix.shixipc.utils.H264HardDecoder;
import com.xiaomi.mipush.sdk.Constants;
import shix.cykj.camera.R;

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

    /* renamed from: gt */
    private GestureDetector f1559gt = new GestureDetector(this);
    /* access modifiers changed from: private */
    public H264HardDecoder h264HardDecoder = null;

    /* renamed from: ht */
    private int f1560ht;
    /* access modifiers changed from: private */
    public ImageView img;
    /* access modifiers changed from: private */
    public ImageView imgPause;
    /* access modifiers changed from: private */
    public boolean isH265 = false;
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
            } else if (i == 2) {
                if (ShowLocalVideoActivity.this.videoSumTime < 0) {
                    ShowLocalVideoActivity.this.tvSumTime.setText(ShowLocalVideoActivity.this.getResources().getString(R.string.ptz_takevideo_time_show));
                    return;
                }
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
                Log.d(RemoteMessageConst.Notification.TAG, "play this picture failed");
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
                TextView access$2500 = ShowLocalVideoActivity.this.tvCurrentTime;
                ShowLocalVideoActivity showLocalVideoActivity = ShowLocalVideoActivity.this;
                access$2500.setText(showLocalVideoActivity.getTime(showLocalVideoActivity.progress));
            } else if (i == 2) {
                ShowLocalVideoActivity.this.imgPause.setVisibility(8);
                ShowLocalVideoActivity.this.btnPlay.setBackgroundResource(R.drawable.video_play_pause_selector);
                ShowLocalVideoActivity.this.showToast((int) R.string.local_video_play_over);
            }
        }
    };
    private TextView mTv_Prompt;
    /* access modifiers changed from: private */
    public SurfaceView myGLSurfaceView;
    /* access modifiers changed from: private */
    public Runnable myProRunnable = new Runnable() {
        public void run() {
            if (ShowLocalVideoActivity.this.seekBar.getProgress() != ShowLocalVideoActivity.this.seekBar.getMax()) {
                ShowLocalVideoActivity.this.seekBar.setProgress(ShowLocalVideoActivity.this.sumTime);
                TextView access$2500 = ShowLocalVideoActivity.this.tvCurrentTime;
                ShowLocalVideoActivity showLocalVideoActivity = ShowLocalVideoActivity.this;
                access$2500.setText(showLocalVideoActivity.getTime(showLocalVideoActivity.sumTime / 1000));
                ShowLocalVideoActivity.this.mProgressHandler.postDelayed(ShowLocalVideoActivity.this.myProRunnable, 300);
            }
        }
    };
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

    /* renamed from: wh */
    private int f1561wh;

    /* renamed from: x1 */
    private float f1562x1 = 0.0f;

    /* renamed from: x2 */
    private float f1563x2 = 0.0f;

    /* renamed from: y1 */
    private float f1564y1 = 0.0f;

    /* renamed from: y2 */
    private float f1565y2 = 0.0f;

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
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(128, 128);
        setContentView(R.layout.showlocalvideo_activity);
        findView();
        setListener();
        TextView textView = this.tvTime;
        textView.setText(getResources().getString(R.string.local_video_date) + getContent(this.filePath));
        firstPicture();
        this.mHandler.sendEmptyMessageDelayed(1, 3000);
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
        Log.d(RemoteMessageConst.Notification.TAG, "strDID:" + this.filePath);
    }

    private void findView() {
        this.f1561wh = getWindowManager().getDefaultDisplay().getWidth();
        this.f1560ht = getWindowManager().getDefaultDisplay().getHeight();
        this.btnBack = (Button) findViewById(R.id.back);
        this.btnBack.setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(R.id.takevideo_title);
        TextView textView = this.tvTitle;
        textView.setText(this.strCameraName + " " + getResources().getString(R.string.main_phone) + getResources().getString(R.string.main_vid));
        this.tvTime = (TextView) findViewById(R.id.takevideo_time);
        this.img = (ImageView) findViewById(R.id.img_playvideo);
        this.imgPause = (ImageView) findViewById(R.id.img_pause);
        this.topLayout = (RelativeLayout) findViewById(R.id.top);
        this.bottomLayout = (RelativeLayout) findViewById(R.id.bottom);
        this.seekBar = (ProgressBar) findViewById(R.id.progressBar1);
        this.tvSumTime = (TextView) findViewById(R.id.sumtime);
        this.tvCurrentTime = (TextView) findViewById(R.id.currenttime);
        this.btnPlay = (Button) findViewById(R.id.btn_play);
        this.myGLSurfaceView = (SurfaceView) findViewById(R.id.hdsurfaceview1);
        if (getResources().getConfiguration().orientation == 1) {
            int i = this.f1561wh;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 3) / 4);
            layoutParams.gravity = 17;
            this.myGLSurfaceView.setLayoutParams(layoutParams);
            this.img.setLayoutParams(layoutParams);
            this.tvTime.setVisibility(8);
        } else if (getResources().getConfiguration().orientation == 2) {
            this.tvTime.setVisibility(0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f1561wh, this.f1560ht);
            layoutParams2.gravity = 17;
            this.img.setLayoutParams(layoutParams2);
            this.myGLSurfaceView.setLayoutParams(layoutParams2);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1561wh = getWindowManager().getDefaultDisplay().getWidth();
        this.f1560ht = getWindowManager().getDefaultDisplay().getHeight();
        if (getResources().getConfiguration().orientation == 1) {
            int i = this.f1561wh;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, (i * 3) / 4);
            layoutParams.gravity = 17;
            this.myGLSurfaceView.setLayoutParams(layoutParams);
            this.img.setLayoutParams(layoutParams);
        } else if (getResources().getConfiguration().orientation == 2) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f1561wh, this.f1560ht);
            layoutParams2.gravity = 17;
            this.img.setLayoutParams(layoutParams2);
            this.myGLSurfaceView.setLayoutParams(layoutParams2);
        }
    }

    private String getContent(String str) {
        Log.d(RemoteMessageConst.Notification.TAG, "filePath:" + str);
        String substring = str.substring(str.lastIndexOf("/") + 1);
        Log.d(RemoteMessageConst.Notification.TAG, "filePath:" + substring);
        if (substring == null || substring.length() < 15) {
            return "";
        }
        String str2 = substring.substring(0, 4) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + substring.substring(4, 6) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + substring.substring(6, 8) + "  " + substring.substring(9, 11) + Constants.COLON_SEPARATOR + substring.substring(11, 13) + Constants.COLON_SEPARATOR + substring.substring(13, 15);
        Log.d(RemoteMessageConst.Notification.TAG, "result:" + str2);
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
            str = "0" + i2;
        } else {
            str = String.valueOf(i2);
        }
        if (i3 < 10) {
            str2 = "0" + i3;
        } else {
            str2 = String.valueOf(i3);
        }
        if (i4 < 10) {
            str3 = "0" + i4;
        } else {
            str3 = String.valueOf(i4);
        }
        return str3 + Constants.COLON_SEPARATOR + str2 + Constants.COLON_SEPARATOR + str;
    }

    private class PlayThread extends Thread {
        private PlayThread() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x03a6, code lost:
            r0 = 4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x028c, code lost:
            r0 = 4;
            r6 = false;
         */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x03b9 A[SYNTHETIC, Splitter:B:113:0x03b9] */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x02af A[Catch:{ Exception -> 0x03b2, all -> 0x03b0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x02ed A[Catch:{ Exception -> 0x03b2, all -> 0x03b0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x030d A[Catch:{ Exception -> 0x03b2, all -> 0x03b0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0367 A[Catch:{ Exception -> 0x03b2, all -> 0x03b0 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r22 = this;
                r1 = r22
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this
                java.lang.String r0 = r0.filePath
                if (r0 == 0) goto L_0x03cf
                java.io.File r0 = new java.io.File
                com.shix.shixipc.activity.ShowLocalVideoActivity r2 = com.shix.shixipc.activity.ShowLocalVideoActivity.this
                java.lang.String r2 = r2.filePath
                r0.<init>(r2)
                r2 = 0
                java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x03c3, all -> 0x03b4 }
                r3.<init>(r0)     // Catch:{ Exception -> 0x03c3, all -> 0x03b4 }
                r0 = 4
                byte[] r2 = new byte[r0]     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                r3.read(r2)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                int r2 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r2)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                java.lang.String r4 = "tag"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                r5.<init>()     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                java.lang.String r6 = "fType:"
                r5.append(r6)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                r5.append(r2)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                android.util.Log.d(r4, r5)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                r4.<init>()     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                java.lang.String r5 = "ZHAOPLAY fType:"
                r4.append(r5)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                r4.append(r2)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                java.lang.String r5 = "  flag:"
                r4.append(r5)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r5 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                boolean r5 = r5.flag     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                r4.append(r5)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                r5 = 1
                com.shix.shixipc.utils.CommonUtil.Log(r5, r4)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r4 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                r6 = 0
                int unused = r4.frameCout = r6     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r4 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                int unused = r4.sumTime = r6     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r4 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                boolean unused = r4.flag = r5     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r4 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                android.os.Handler r4 = r4.mProgressHandler     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r7 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                java.lang.Runnable r7 = r7.myProRunnable     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                r8 = 0
                r4.postDelayed(r7, r8)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
            L_0x007f:
                int r4 = r3.available()     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                if (r4 == 0) goto L_0x03ac
                com.shix.shixipc.activity.ShowLocalVideoActivity r4 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                boolean r4 = r4.flag     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                if (r4 == 0) goto L_0x03ac
                com.shix.shixipc.activity.ShowLocalVideoActivity r4 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                monitor-enter(r4)     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
                java.lang.String r7 = "tag"
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x03a9 }
                r10.<init>()     // Catch:{ all -> 0x03a9 }
                java.lang.String r11 = "flag="
                r10.append(r11)     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r11 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                boolean r11 = r11.flag     // Catch:{ all -> 0x03a9 }
                r10.append(r11)     // Catch:{ all -> 0x03a9 }
                java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x03a9 }
                android.util.Log.d(r7, r10)     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r7 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                boolean r7 = r7.isPlaying     // Catch:{ all -> 0x03a9 }
                if (r7 == 0) goto L_0x0376
                com.shix.shixipc.activity.ShowLocalVideoActivity r7 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity.access$1008(r7)     // Catch:{ all -> 0x03a9 }
                r10 = 10
                r7 = 16711935(0xff00ff, float:2.3418409E-38)
                r12 = 110(0x6e, float:1.54E-43)
                r13 = 2
                if (r2 == r5) goto L_0x01e4
                if (r2 == r13) goto L_0x00c7
                goto L_0x01bd
            L_0x00c7:
                java.util.Date r14 = new java.util.Date     // Catch:{ all -> 0x03a9 }
                r14.<init>()     // Catch:{ all -> 0x03a9 }
                long r14 = r14.getTime()     // Catch:{ all -> 0x03a9 }
                byte[] r8 = new byte[r0]     // Catch:{ all -> 0x03a9 }
                r3.read(r8)     // Catch:{ all -> 0x03a9 }
                int r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r8)     // Catch:{ all -> 0x03a9 }
                if (r8 == 0) goto L_0x01c1
                r9 = 200000(0x30d40, float:2.8026E-40)
                if (r8 <= r9) goto L_0x00e2
                goto L_0x01c1
            L_0x00e2:
                byte[] r9 = new byte[r0]     // Catch:{ all -> 0x03a9 }
                r3.read(r9)     // Catch:{ all -> 0x03a9 }
                int r9 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r9)     // Catch:{ all -> 0x03a9 }
                byte[] r13 = new byte[r0]     // Catch:{ all -> 0x03a9 }
                r3.read(r13)     // Catch:{ all -> 0x03a9 }
                int r13 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r13)     // Catch:{ all -> 0x03a9 }
                byte[] r0 = new byte[r8]     // Catch:{ all -> 0x03a9 }
                r3.read(r0)     // Catch:{ all -> 0x03a9 }
                if (r9 != r12) goto L_0x011c
                com.shix.shixipc.utils.CustomBufferHead r9 = new com.shix.shixipc.utils.CustomBufferHead     // Catch:{ all -> 0x03a9 }
                r9.<init>()     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.CustomBufferData r10 = new com.shix.shixipc.utils.CustomBufferData     // Catch:{ all -> 0x03a9 }
                r10.<init>()     // Catch:{ all -> 0x03a9 }
                r9.length = r8     // Catch:{ all -> 0x03a9 }
                r9.startcode = r7     // Catch:{ all -> 0x03a9 }
                r10.head = r9     // Catch:{ all -> 0x03a9 }
                r10.data = r0     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.CustomBuffer r0 = r0.AudioBuffer     // Catch:{ all -> 0x03a9 }
                r0.addData(r10)     // Catch:{ all -> 0x03a9 }
                monitor-exit(r4)     // Catch:{ all -> 0x03a9 }
            L_0x0117:
                r0 = 4
            L_0x0118:
                r8 = 0
                goto L_0x007f
            L_0x011c:
                int r7 = r0.length     // Catch:{ all -> 0x03a9 }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r6, r7)     // Catch:{ all -> 0x03a9 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x03a9 }
                r7.<init>()     // Catch:{ all -> 0x03a9 }
                java.lang.String r12 = "ZHAOPLAY length:"
                r7.append(r12)     // Catch:{ all -> 0x03a9 }
                r7.append(r8)     // Catch:{ all -> 0x03a9 }
                java.lang.String r8 = "  type:"
                r7.append(r8)     // Catch:{ all -> 0x03a9 }
                r7.append(r9)     // Catch:{ all -> 0x03a9 }
                java.lang.String r8 = "  time:"
                r7.append(r8)     // Catch:{ all -> 0x03a9 }
                r7.append(r13)     // Catch:{ all -> 0x03a9 }
                java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.CommonUtil.Log(r5, r7)     // Catch:{ all -> 0x03a9 }
                if (r0 == 0) goto L_0x015c
                com.shix.shixipc.activity.ShowLocalVideoActivity r7 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                android.os.Handler r7 = r7.mPlayHandler     // Catch:{ all -> 0x03a9 }
                android.os.Message r7 = r7.obtainMessage()     // Catch:{ all -> 0x03a9 }
                r7.obj = r0     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                android.os.Handler r0 = r0.mPlayHandler     // Catch:{ all -> 0x03a9 }
                r0.sendMessage(r7)     // Catch:{ all -> 0x03a9 }
            L_0x015c:
                r0 = 1000(0x3e8, float:1.401E-42)
                if (r13 <= r0) goto L_0x0167
                r7 = 100
                java.lang.Thread.sleep(r7)     // Catch:{ all -> 0x03a9 }
                monitor-exit(r4)     // Catch:{ all -> 0x03a9 }
                goto L_0x0117
            L_0x0167:
                java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x03a9 }
                r0.<init>()     // Catch:{ all -> 0x03a9 }
                long r7 = r0.getTime()     // Catch:{ all -> 0x03a9 }
                long r7 = r7 - r14
                int r0 = (int) r7     // Catch:{ all -> 0x03a9 }
                int r7 = r13 - r0
                if (r7 <= 0) goto L_0x01ad
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r9 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                int r9 = r9.sumTime     // Catch:{ all -> 0x03a9 }
                int r9 = r9 + r0
                int unused = r8.sumTime = r9     // Catch:{ all -> 0x03a9 }
                int r0 = r7 / 10
                int r7 = r7 % 10
                r8 = 0
            L_0x0187:
                if (r8 >= r0) goto L_0x019c
                com.shix.shixipc.activity.ShowLocalVideoActivity r9 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r12 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                int r12 = r12.sumTime     // Catch:{ all -> 0x03a9 }
                int r12 = r12 + 10
                int unused = r9.sumTime = r12     // Catch:{ all -> 0x03a9 }
                java.lang.Thread.sleep(r10)     // Catch:{ all -> 0x03a9 }
                int r8 = r8 + 1
                goto L_0x0187
            L_0x019c:
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                int r8 = r8.sumTime     // Catch:{ all -> 0x03a9 }
                int r8 = r8 + r7
                int unused = r0.sumTime = r8     // Catch:{ all -> 0x03a9 }
                long r7 = (long) r7     // Catch:{ all -> 0x03a9 }
                java.lang.Thread.sleep(r7)     // Catch:{ all -> 0x03a9 }
                goto L_0x01bd
            L_0x01ad:
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r7 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                int r7 = r7.sumTime     // Catch:{ all -> 0x03a9 }
                int r7 = r7 + r13
                int unused = r0.sumTime = r7     // Catch:{ all -> 0x03a9 }
                long r7 = (long) r13     // Catch:{ all -> 0x03a9 }
                java.lang.Thread.sleep(r7)     // Catch:{ all -> 0x03a9 }
            L_0x01bd:
                r8 = 0
                goto L_0x03a5
            L_0x01c1:
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                boolean unused = r0.flag = r6     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                boolean unused = r0.isStart = r5     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                boolean unused = r0.isPlaying = r6     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                android.os.Handler r0 = r0.mProgressHandler     // Catch:{ all -> 0x03a9 }
                r0.sendEmptyMessage(r13)     // Catch:{ all -> 0x03a9 }
                monitor-exit(r4)     // Catch:{ all -> 0x03a9 }
                r3.close()     // Catch:{ IOException -> 0x01de }
                goto L_0x01e3
            L_0x01de:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
            L_0x01e3:
                return
            L_0x01e4:
                java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x03a9 }
                r0.<init>()     // Catch:{ all -> 0x03a9 }
                long r8 = r0.getTime()     // Catch:{ all -> 0x03a9 }
                r0 = 4
                byte[] r14 = new byte[r0]     // Catch:{ all -> 0x03a9 }
                byte[] r15 = new byte[r0]     // Catch:{ all -> 0x03a9 }
                byte[] r10 = new byte[r0]     // Catch:{ all -> 0x03a9 }
                byte[] r11 = new byte[r0]     // Catch:{ all -> 0x03a9 }
                byte[] r7 = new byte[r0]     // Catch:{ all -> 0x03a9 }
                r3.read(r14)     // Catch:{ all -> 0x03a9 }
                r3.read(r15)     // Catch:{ all -> 0x03a9 }
                r3.read(r10)     // Catch:{ all -> 0x03a9 }
                r3.read(r11)     // Catch:{ all -> 0x03a9 }
                r3.read(r7)     // Catch:{ all -> 0x03a9 }
                int r14 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r14)     // Catch:{ all -> 0x03a9 }
                if (r14 != 0) goto L_0x0232
                if (r14 != 0) goto L_0x0232
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                boolean unused = r0.flag = r6     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                boolean unused = r0.isStart = r5     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                boolean unused = r0.isPlaying = r6     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                android.os.Handler r0 = r0.mProgressHandler     // Catch:{ all -> 0x03a9 }
                r0.sendEmptyMessage(r13)     // Catch:{ all -> 0x03a9 }
                monitor-exit(r4)     // Catch:{ all -> 0x03a9 }
                r3.close()     // Catch:{ IOException -> 0x022c }
                goto L_0x0231
            L_0x022c:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
            L_0x0231:
                return
            L_0x0232:
                int r13 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r15)     // Catch:{ all -> 0x03a9 }
                int r10 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r10)     // Catch:{ all -> 0x03a9 }
                int r11 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r11)     // Catch:{ all -> 0x03a9 }
                int r7 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r7)     // Catch:{ all -> 0x03a9 }
                byte[] r15 = new byte[r14]     // Catch:{ all -> 0x03a9 }
                r3.read(r15)     // Catch:{ all -> 0x03a9 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03a9 }
                r0.<init>()     // Catch:{ all -> 0x03a9 }
                java.lang.String r6 = "ZHAOPLAY length:"
                r0.append(r6)     // Catch:{ all -> 0x03a9 }
                r0.append(r14)     // Catch:{ all -> 0x03a9 }
                java.lang.String r6 = "  bIFrame:"
                r0.append(r6)     // Catch:{ all -> 0x03a9 }
                r0.append(r11)     // Catch:{ all -> 0x03a9 }
                java.lang.String r6 = "  time:"
                r0.append(r6)     // Catch:{ all -> 0x03a9 }
                r0.append(r7)     // Catch:{ all -> 0x03a9 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.CommonUtil.Log(r5, r0)     // Catch:{ all -> 0x03a9 }
                if (r11 != r12) goto L_0x0290
                com.shix.shixipc.utils.CustomBufferHead r0 = new com.shix.shixipc.utils.CustomBufferHead     // Catch:{ all -> 0x03a9 }
                r0.<init>()     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.CustomBufferData r6 = new com.shix.shixipc.utils.CustomBufferData     // Catch:{ all -> 0x03a9 }
                r6.<init>()     // Catch:{ all -> 0x03a9 }
                r0.length = r14     // Catch:{ all -> 0x03a9 }
                r7 = 16711935(0xff00ff, float:2.3418409E-38)
                r0.startcode = r7     // Catch:{ all -> 0x03a9 }
                r6.head = r0     // Catch:{ all -> 0x03a9 }
                r6.data = r15     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.CustomBuffer r0 = r0.AudioBuffer     // Catch:{ all -> 0x03a9 }
                r0.addData(r6)     // Catch:{ all -> 0x03a9 }
                monitor-exit(r4)     // Catch:{ all -> 0x03a9 }
                r0 = 4
                r6 = 0
                goto L_0x0118
            L_0x0290:
                r0 = 5
                if (r11 == r0) goto L_0x029e
                r0 = 6
                if (r11 != r0) goto L_0x0297
                goto L_0x029e
            L_0x0297:
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                r6 = 0
                boolean unused = r0.isH265 = r6     // Catch:{ all -> 0x03a9 }
                goto L_0x02a5
            L_0x029e:
                int r11 = r11 + -5
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                boolean unused = r0.isH265 = r5     // Catch:{ all -> 0x03a9 }
            L_0x02a5:
                r21 = r11
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.H264HardDecoder r0 = r0.h264HardDecoder     // Catch:{ all -> 0x03a9 }
                if (r0 != 0) goto L_0x02e5
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.H264HardDecoder r6 = new com.shix.shixipc.utils.H264HardDecoder     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r11 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                android.view.SurfaceView r11 = r11.myGLSurfaceView     // Catch:{ all -> 0x03a9 }
                android.view.SurfaceHolder r11 = r11.getHolder()     // Catch:{ all -> 0x03a9 }
                android.view.Surface r11 = r11.getSurface()     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r12 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                r6.<init>(r11, r12)     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.H264HardDecoder unused = r0.h264HardDecoder = r6     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                boolean r0 = r0.isH265     // Catch:{ all -> 0x03a9 }
                if (r0 == 0) goto L_0x02db
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.H264HardDecoder r0 = r0.h264HardDecoder     // Catch:{ all -> 0x03a9 }
                r0.H264HardStartDecoder(r13, r10, r5)     // Catch:{ all -> 0x03a9 }
                goto L_0x02e5
            L_0x02db:
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.H264HardDecoder r0 = r0.h264HardDecoder     // Catch:{ all -> 0x03a9 }
                r6 = 0
                r0.H264HardStartDecoder(r13, r10, r6)     // Catch:{ all -> 0x03a9 }
            L_0x02e5:
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.H264HardDecoder r0 = r0.h264HardDecoder     // Catch:{ all -> 0x03a9 }
                if (r0 == 0) goto L_0x02fe
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.H264HardDecoder r16 = r0.h264HardDecoder     // Catch:{ all -> 0x03a9 }
                r17 = r15
                r18 = r14
                r19 = r13
                r20 = r10
                r16.H264HardDecoderOneFram(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x03a9 }
            L_0x02fe:
                java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x03a9 }
                r0.<init>()     // Catch:{ all -> 0x03a9 }
                long r10 = r0.getTime()     // Catch:{ all -> 0x03a9 }
                long r10 = r10 - r8
                int r0 = (int) r10     // Catch:{ all -> 0x03a9 }
                int r6 = r7 - r0
                if (r6 <= 0) goto L_0x0367
                com.shix.shixipc.activity.ShowLocalVideoActivity r7 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                int r8 = r8.sumTime     // Catch:{ all -> 0x03a9 }
                int r8 = r8 + r0
                int unused = r7.sumTime = r8     // Catch:{ all -> 0x03a9 }
                int r0 = r6 / 10
                int r6 = r6 % 10
                r7 = 0
            L_0x031e:
                if (r7 >= r0) goto L_0x0335
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r9 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                int r9 = r9.sumTime     // Catch:{ all -> 0x03a9 }
                int r9 = r9 + 10
                int unused = r8.sumTime = r9     // Catch:{ all -> 0x03a9 }
                r8 = 10
                java.lang.Thread.sleep(r8)     // Catch:{ all -> 0x03a9 }
                int r7 = r7 + 1
                goto L_0x031e
            L_0x0335:
                r7 = 3
                if (r6 <= r7) goto L_0x033a
                int r6 = r6 + -3
            L_0x033a:
                com.shix.shixipc.activity.ShowLocalVideoActivity r7 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r8 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                int r8 = r8.sumTime     // Catch:{ all -> 0x03a9 }
                int r8 = r8 + r6
                int unused = r7.sumTime = r8     // Catch:{ all -> 0x03a9 }
                long r7 = (long) r6     // Catch:{ all -> 0x03a9 }
                java.lang.Thread.sleep(r7)     // Catch:{ all -> 0x03a9 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x03a9 }
                r7.<init>()     // Catch:{ all -> 0x03a9 }
                java.lang.String r8 = "remainTime:"
                r7.append(r8)     // Catch:{ all -> 0x03a9 }
                r7.append(r6)     // Catch:{ all -> 0x03a9 }
                java.lang.String r6 = "  count:"
                r7.append(r6)     // Catch:{ all -> 0x03a9 }
                r7.append(r0)     // Catch:{ all -> 0x03a9 }
                java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.utils.CommonUtil.Log(r5, r0)     // Catch:{ all -> 0x03a9 }
                goto L_0x0373
            L_0x0367:
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r6 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                int r6 = r6.sumTime     // Catch:{ all -> 0x03a9 }
                int r6 = r6 + r7
                int unused = r0.sumTime = r6     // Catch:{ all -> 0x03a9 }
            L_0x0373:
                r6 = 0
                goto L_0x01bd
            L_0x0376:
                java.lang.String r0 = "tag"
                java.lang.String r6 = "wait 1"
                android.util.Log.d(r0, r6)     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                boolean unused = r0.isPause = r5     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                r0.wait()     // Catch:{ all -> 0x03a9 }
                java.lang.String r0 = "tag"
                java.lang.String r6 = "wait 2"
                android.util.Log.d(r0, r6)     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                r6 = 0
                boolean unused = r0.isPause = r6     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                android.os.Handler r0 = r0.mProgressHandler     // Catch:{ all -> 0x03a9 }
                com.shix.shixipc.activity.ShowLocalVideoActivity r7 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ all -> 0x03a9 }
                java.lang.Runnable r7 = r7.myProRunnable     // Catch:{ all -> 0x03a9 }
                r8 = 0
                r0.postDelayed(r7, r8)     // Catch:{ all -> 0x03a9 }
            L_0x03a5:
                monitor-exit(r4)     // Catch:{ all -> 0x03a9 }
                r0 = 4
                goto L_0x007f
            L_0x03a9:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x03a9 }
                throw r0     // Catch:{ Exception -> 0x03b2, all -> 0x03b0 }
            L_0x03ac:
                r3.close()     // Catch:{ IOException -> 0x03ca }
                goto L_0x03cf
            L_0x03b0:
                r0 = move-exception
                goto L_0x03b6
            L_0x03b2:
                goto L_0x03c4
            L_0x03b4:
                r0 = move-exception
                r3 = r2
            L_0x03b6:
                r2 = r0
                if (r3 == 0) goto L_0x03c2
                r3.close()     // Catch:{ IOException -> 0x03bd }
                goto L_0x03c2
            L_0x03bd:
                r0 = move-exception
                r3 = r0
                r3.printStackTrace()
            L_0x03c2:
                throw r2
            L_0x03c3:
                r3 = r2
            L_0x03c4:
                if (r3 == 0) goto L_0x03cf
                r3.close()     // Catch:{ IOException -> 0x03ca }
                goto L_0x03cf
            L_0x03ca:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
            L_0x03cf:
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
                /* JADX WARNING: Removed duplicated region for block: B:17:0x00ac A[SYNTHETIC, Splitter:B:17:0x00ac] */
                /* JADX WARNING: Removed duplicated region for block: B:25:0x00b8 A[SYNTHETIC, Splitter:B:25:0x00b8] */
                /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r7 = this;
                        java.io.File r0 = new java.io.File
                        com.shix.shixipc.activity.ShowLocalVideoActivity r1 = com.shix.shixipc.activity.ShowLocalVideoActivity.this
                        java.lang.String r1 = r1.filePath
                        r0.<init>(r1)
                        r1 = 0
                        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b5, all -> 0x00a8 }
                        r2.<init>(r0)     // Catch:{ Exception -> 0x00b5, all -> 0x00a8 }
                        int r0 = r2.available()     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r1 = 4
                        byte[] r3 = new byte[r1]     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r2.read(r3)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        int r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r3)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r4.<init>()     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        java.lang.String r5 = "ZHAOPLAY fType:"
                        r4.append(r5)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r4.append(r3)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        java.lang.String r5 = " fileSumLength:"
                        r4.append(r5)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r4.append(r0)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r5 = 1
                        com.shix.shixipc.utils.CommonUtil.Log(r5, r4)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r4 = 8
                        r6 = 2
                        if (r3 == r5) goto L_0x0084
                        if (r3 == r6) goto L_0x0044
                        goto L_0x00a0
                    L_0x0044:
                        com.shix.shixipc.activity.ShowLocalVideoActivity r3 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        android.view.SurfaceView r3 = r3.myGLSurfaceView     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r3.setVisibility(r4)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        int r0 = r0 - r4
                        long r3 = (long) r0     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r2.skip(r3)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        byte[] r0 = new byte[r1]     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r2.read(r0)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        com.shix.shixipc.activity.ShowLocalVideoActivity r1 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        int r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r0)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        int unused = r1.videoSumTime = r0     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r0.<init>()     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        java.lang.String r1 = "ZHAOPLAY videoSumTime:"
                        r0.append(r1)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        com.shix.shixipc.activity.ShowLocalVideoActivity r1 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        int r1 = r1.videoSumTime     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r0.append(r1)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        com.shix.shixipc.utils.CommonUtil.Log(r5, r0)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r0.sendEmptyMessage(r6)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        goto L_0x00a0
                    L_0x0084:
                        int r0 = r0 - r4
                        long r3 = (long) r0     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r2.skip(r3)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        byte[] r0 = new byte[r1]     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r2.read(r0)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        com.shix.shixipc.activity.ShowLocalVideoActivity r1 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        int r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.byteToInt(r0)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        int unused = r1.videoSumTime = r0     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        com.shix.shixipc.activity.ShowLocalVideoActivity r0 = com.shix.shixipc.activity.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                        r0.sendEmptyMessage(r6)     // Catch:{ Exception -> 0x00a6, all -> 0x00a4 }
                    L_0x00a0:
                        r2.close()     // Catch:{ IOException -> 0x00bc }
                        goto L_0x00c0
                    L_0x00a4:
                        r0 = move-exception
                        goto L_0x00aa
                    L_0x00a6:
                        goto L_0x00b6
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
                    throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.ShowLocalVideoActivity.C14572.run():void");
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
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
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
        return ((long) (bArr[0] & 255)) | (((long) (bArr[1] & 255)) << 8) | (((long) (bArr[2] & 255)) << 16) | (((long) (bArr[3] & 255)) << 24) | (((long) (bArr[4] & 255)) << 32) | (((long) (bArr[5] & 255)) << 40) | (((long) (bArr[6] & 255)) << 48) | (((long) (bArr[7] & 255)) << 56);
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
                Log.d(RemoteMessageConst.Notification.TAG, "pause");
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
        return this.f1559gt.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.h264HardDecoder != null) {
                this.h264HardDecoder.H264HardDesdoryDecoder();
            }
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
        Log.d(RemoteMessageConst.Notification.TAG, "onDoubleTap");
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Log.d(RemoteMessageConst.Notification.TAG, "onSingleTapConfirmed");
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
