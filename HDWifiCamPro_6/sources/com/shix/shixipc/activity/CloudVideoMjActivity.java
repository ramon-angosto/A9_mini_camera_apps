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
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.UByte;
import object.p2pipcam.nativecaller.MyRender;

public class CloudVideoMjActivity extends BaseActivity implements View.OnClickListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnTouchListener {
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
    public int fType = 2;
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
                boolean unused = CloudVideoMjActivity.this.isShowing = false;
                CloudVideoMjActivity.this.topLayout.setVisibility(8);
                CloudVideoMjActivity.this.bottomLayout.setVisibility(8);
            } else if (i != 2) {
                if (i == 3) {
                    CloudVideoMjActivity.this.seekBar.setProgress(27);
                }
            } else if (CloudVideoMjActivity.this.videoSumTime < 0) {
                CloudVideoMjActivity.this.tvSumTime.setText(CloudVideoMjActivity.this.getResources().getString(R.string.ptz_takevideo_time_show));
            } else {
                TextView access$400 = CloudVideoMjActivity.this.tvSumTime;
                CloudVideoMjActivity cloudVideoMjActivity = CloudVideoMjActivity.this;
                access$400.setText(cloudVideoMjActivity.getTime(cloudVideoMjActivity.videoSumTime / 1000));
                CloudVideoMjActivity.this.startVideo();
            }
        }
    };
    /* access modifiers changed from: private */
    public Handler mPlayHandler = new Handler() {
        public void handleMessage(Message message) {
            Bitmap bitmap = (Bitmap) message.obj;
            if (bitmap == null) {
                Log.d("tag", "play this picture failed");
                return;
            }
            CloudVideoMjActivity.this.img.setImageBitmap(bitmap);
            CloudVideoMjActivity cloudVideoMjActivity = CloudVideoMjActivity.this;
            long unused = cloudVideoMjActivity.time1 = ((long) cloudVideoMjActivity.timeTest) * 1000;
            CloudVideoMjActivity cloudVideoMjActivity2 = CloudVideoMjActivity.this;
            String unused2 = cloudVideoMjActivity2.timeShow = cloudVideoMjActivity2.setDeviceTime(cloudVideoMjActivity2.time1, CloudVideoMjActivity.this.tzStr);
            TextView access$3000 = CloudVideoMjActivity.this.tvCurrentTime;
            access$3000.setText(CloudVideoMjActivity.this.timeShow + "");
            CloudVideoMjActivity.this.seekBar.setProgress(CloudVideoMjActivity.this.progress + 1);
        }
    };
    /* access modifiers changed from: private */
    public Handler mProgressHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                return;
            }
            if (i == 2) {
                CloudVideoMjActivity.this.imgPause.setVisibility(8);
                CloudVideoMjActivity.this.btnPlay.setBackgroundResource(R.drawable.video_play_pause_selector);
                CloudVideoMjActivity.this.showToast((int) R.string.local_video_play_over);
                Log.d("tag", "ZHAOPLAY end");
            } else if (i == 120) {
                CloudVideoMjActivity.this.seekBar.setProgress(27);
            }
        }
    };
    private TextView mTv_Prompt;
    private GLSurfaceView myGLSurfaceView;
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
    public long time1;
    /* access modifiers changed from: private */
    public String timeShow;
    /* access modifiers changed from: private */
    public int timeTest;
    /* access modifiers changed from: private */
    public RelativeLayout topLayout;
    /* access modifiers changed from: private */
    public TextView tvCurrentTime;
    /* access modifiers changed from: private */
    public TextView tvSumTime;
    private TextView tvTime;
    private TextView tvTitle;
    /* access modifiers changed from: private */
    public String tzStr = "GMT+00:00";
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

    static /* synthetic */ int access$908(CloudVideoMjActivity cloudVideoMjActivity) {
        int i = cloudVideoMjActivity.frameCout;
        cloudVideoMjActivity.frameCout = i + 1;
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
        setContentView(R.layout.showcloudvideo_activity);
        findView();
        setListener();
        TextView textView = this.tvTime;
        textView.setText(getResources().getString(R.string.local_video_date) + getContent(this.filePath));
        this.mHandler.sendEmptyMessageDelayed(2, 1000);
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this.AudioBuffer);
        StartAudio();
        this.seekBar.setMax(27);
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
            this.tvTime.setVisibility(8);
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

        /* JADX WARNING: Code restructure failed: missing block: B:86:0x031e, code lost:
            r3 = 3;
         */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x038d A[SYNTHETIC, Splitter:B:112:0x038d] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x0278 A[Catch:{ Exception -> 0x033b, all -> 0x0339 }] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0299 A[Catch:{ Exception -> 0x033b, all -> 0x0339 }] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x02f3 A[Catch:{ Exception -> 0x033b, all -> 0x0339 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r16 = this;
                r1 = r16
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this
                java.lang.String r0 = r0.filePath
                if (r0 == 0) goto L_0x0397
                java.io.File r0 = new java.io.File
                com.shix.shixipc.activity.CloudVideoMjActivity r2 = com.shix.shixipc.activity.CloudVideoMjActivity.this
                java.lang.String r2 = r2.filePath
                r0.<init>(r2)
                r2 = 0
                r3 = 3
                java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0342 }
                r4.<init>(r0)     // Catch:{ Exception -> 0x0342 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
                r2 = 0
                int unused = r0.frameCout = r2     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
                int unused = r0.sumTime = r2     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
                r5 = 1
                boolean unused = r0.flag = r5     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
            L_0x002d:
                int r0 = r4.available()     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
                if (r0 == 0) goto L_0x0324
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
                boolean r0 = r0.flag     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
                if (r0 == 0) goto L_0x0324
                com.shix.shixipc.activity.CloudVideoMjActivity r6 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
                monitor-enter(r6)     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
                java.lang.String r0 = "tag"
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0321 }
                r7.<init>()     // Catch:{ all -> 0x0321 }
                java.lang.String r8 = "ZHAOPLAY flag="
                r7.append(r8)     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r8 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean r8 = r8.flag     // Catch:{ all -> 0x0321 }
                r7.append(r8)     // Catch:{ all -> 0x0321 }
                java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0321 }
                android.util.Log.d(r0, r7)     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean r0 = r0.isPlaying     // Catch:{ all -> 0x0321 }
                if (r0 == 0) goto L_0x0300
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity.access$908(r0)     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                int r0 = r0.fType     // Catch:{ all -> 0x0321 }
                r7 = 2
                r8 = 4
                if (r0 == r5) goto L_0x0137
                if (r0 == r7) goto L_0x0075
                goto L_0x031d
            L_0x0075:
                r0 = 8
                byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0321 }
                r4.read(r0)     // Catch:{ all -> 0x0321 }
                byte[] r0 = new byte[r8]     // Catch:{ all -> 0x0321 }
                r4.read(r0)     // Catch:{ all -> 0x0321 }
                int r0 = com.shix.shixipc.activity.CloudVideoMjActivity.byteToInt(r0)     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r9 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                int unused = r9.timeTest = r0     // Catch:{ all -> 0x0321 }
                java.util.Date r9 = new java.util.Date     // Catch:{ all -> 0x0321 }
                r9.<init>()     // Catch:{ all -> 0x0321 }
                r9.getTime()     // Catch:{ all -> 0x0321 }
                byte[] r9 = new byte[r8]     // Catch:{ all -> 0x0321 }
                r4.read(r9)     // Catch:{ all -> 0x0321 }
                int r9 = com.shix.shixipc.activity.CloudVideoMjActivity.byteToInt(r9)     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r10 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                int unused = r10.progress = r9     // Catch:{ all -> 0x0321 }
                byte[] r8 = new byte[r8]     // Catch:{ all -> 0x0321 }
                r4.read(r8)     // Catch:{ all -> 0x0321 }
                int r8 = com.shix.shixipc.activity.CloudVideoMjActivity.byteToInt(r8)     // Catch:{ all -> 0x0321 }
                if (r8 == 0) goto L_0x0104
                r10 = 200000(0x30d40, float:2.8026E-40)
                if (r8 <= r10) goto L_0x00b1
                goto L_0x0104
            L_0x00b1:
                r7 = 12
                byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0321 }
                r4.read(r7)     // Catch:{ all -> 0x0321 }
                byte[] r7 = new byte[r8]     // Catch:{ all -> 0x0321 }
                r4.read(r7)     // Catch:{ all -> 0x0321 }
                int r10 = r7.length     // Catch:{ all -> 0x0321 }
                android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeByteArray(r7, r2, r10)     // Catch:{ all -> 0x0321 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0321 }
                r10.<init>()     // Catch:{ all -> 0x0321 }
                java.lang.String r11 = "ZHAOPLAY length:"
                r10.append(r11)     // Catch:{ all -> 0x0321 }
                r10.append(r8)     // Catch:{ all -> 0x0321 }
                java.lang.String r8 = "  framno:"
                r10.append(r8)     // Catch:{ all -> 0x0321 }
                r10.append(r9)     // Catch:{ all -> 0x0321 }
                java.lang.String r8 = "  time:"
                r10.append(r8)     // Catch:{ all -> 0x0321 }
                r10.append(r0)     // Catch:{ all -> 0x0321 }
                java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.utils.CommonUtil.Log(r5, r0)     // Catch:{ all -> 0x0321 }
                if (r7 == 0) goto L_0x00fd
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                android.os.Handler r0 = r0.mPlayHandler     // Catch:{ all -> 0x0321 }
                android.os.Message r0 = r0.obtainMessage()     // Catch:{ all -> 0x0321 }
                r0.obj = r7     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r7 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                android.os.Handler r7 = r7.mPlayHandler     // Catch:{ all -> 0x0321 }
                r7.sendMessage(r0)     // Catch:{ all -> 0x0321 }
            L_0x00fd:
                r7 = 300(0x12c, double:1.48E-321)
                java.lang.Thread.sleep(r7)     // Catch:{ all -> 0x0321 }
                goto L_0x031d
            L_0x0104:
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r0.flag = r2     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r0.isStart = r5     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r0.isPlaying = r2     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                android.os.Handler r0 = r0.mProgressHandler     // Catch:{ all -> 0x0321 }
                r0.sendEmptyMessage(r7)     // Catch:{ all -> 0x0321 }
                monitor-exit(r6)     // Catch:{ all -> 0x0321 }
                java.lang.String r0 = "tag"
                java.lang.String r2 = "ZHAOPLAY finally"
                android.util.Log.d(r0, r2)
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this
                android.os.Handler r0 = r0.mHandler
                r0.sendEmptyMessage(r3)
                r4.close()     // Catch:{ IOException -> 0x0131 }
                goto L_0x0136
            L_0x0131:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
            L_0x0136:
                return
            L_0x0137:
                java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x0321 }
                r0.<init>()     // Catch:{ all -> 0x0321 }
                long r9 = r0.getTime()     // Catch:{ all -> 0x0321 }
                byte[] r0 = new byte[r8]     // Catch:{ all -> 0x0321 }
                byte[] r11 = new byte[r8]     // Catch:{ all -> 0x0321 }
                byte[] r12 = new byte[r8]     // Catch:{ all -> 0x0321 }
                byte[] r13 = new byte[r8]     // Catch:{ all -> 0x0321 }
                byte[] r8 = new byte[r8]     // Catch:{ all -> 0x0321 }
                r4.read(r0)     // Catch:{ all -> 0x0321 }
                r4.read(r11)     // Catch:{ all -> 0x0321 }
                r4.read(r12)     // Catch:{ all -> 0x0321 }
                r4.read(r13)     // Catch:{ all -> 0x0321 }
                r4.read(r8)     // Catch:{ all -> 0x0321 }
                int r0 = com.shix.shixipc.activity.CloudVideoMjActivity.byteToInt(r0)     // Catch:{ all -> 0x0321 }
                if (r0 != 0) goto L_0x019b
                if (r0 != 0) goto L_0x019b
                java.lang.String r0 = "tag"
                java.lang.String r8 = "ZHAOPLAY length == 0"
                android.util.Log.d(r0, r8)     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r0.flag = r2     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r0.isStart = r5     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r0.isPlaying = r2     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                android.os.Handler r0 = r0.mProgressHandler     // Catch:{ all -> 0x0321 }
                r0.sendEmptyMessage(r7)     // Catch:{ all -> 0x0321 }
                monitor-exit(r6)     // Catch:{ all -> 0x0321 }
                java.lang.String r0 = "tag"
                java.lang.String r2 = "ZHAOPLAY finally"
                android.util.Log.d(r0, r2)
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this
                android.os.Handler r0 = r0.mHandler
                r0.sendEmptyMessage(r3)
                r4.close()     // Catch:{ IOException -> 0x0195 }
                goto L_0x019a
            L_0x0195:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
            L_0x019a:
                return
            L_0x019b:
                int r11 = com.shix.shixipc.activity.CloudVideoMjActivity.byteToInt(r11)     // Catch:{ all -> 0x0321 }
                int r12 = com.shix.shixipc.activity.CloudVideoMjActivity.byteToInt(r12)     // Catch:{ all -> 0x0321 }
                int r13 = com.shix.shixipc.activity.CloudVideoMjActivity.byteToInt(r13)     // Catch:{ all -> 0x0321 }
                int r8 = com.shix.shixipc.activity.CloudVideoMjActivity.byteToInt(r8)     // Catch:{ all -> 0x0321 }
                byte[] r14 = new byte[r0]     // Catch:{ all -> 0x0321 }
                r4.read(r14)     // Catch:{ all -> 0x0321 }
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0321 }
                r15.<init>()     // Catch:{ all -> 0x0321 }
                java.lang.String r3 = "ZHAOPLAY length:"
                r15.append(r3)     // Catch:{ all -> 0x0321 }
                r15.append(r0)     // Catch:{ all -> 0x0321 }
                java.lang.String r3 = "  bIFrame:"
                r15.append(r3)     // Catch:{ all -> 0x0321 }
                r15.append(r13)     // Catch:{ all -> 0x0321 }
                java.lang.String r3 = "  time:"
                r15.append(r3)     // Catch:{ all -> 0x0321 }
                r15.append(r8)     // Catch:{ all -> 0x0321 }
                java.lang.String r3 = r15.toString()     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.utils.CommonUtil.Log(r5, r3)     // Catch:{ all -> 0x0321 }
                r3 = 110(0x6e, float:1.54E-43)
                if (r13 != r3) goto L_0x01f9
                com.shix.shixipc.utils.CustomBufferHead r3 = new com.shix.shixipc.utils.CustomBufferHead     // Catch:{ all -> 0x0321 }
                r3.<init>()     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.utils.CustomBufferData r7 = new com.shix.shixipc.utils.CustomBufferData     // Catch:{ all -> 0x0321 }
                r7.<init>()     // Catch:{ all -> 0x0321 }
                r3.length = r0     // Catch:{ all -> 0x0321 }
                r0 = 16711935(0xff00ff, float:2.3418409E-38)
                r3.startcode = r0     // Catch:{ all -> 0x0321 }
                r7.head = r3     // Catch:{ all -> 0x0321 }
                r7.data = r14     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.utils.CustomBuffer r0 = r0.AudioBuffer     // Catch:{ all -> 0x0321 }
                r0.addData(r7)     // Catch:{ all -> 0x0321 }
                monitor-exit(r6)     // Catch:{ all -> 0x0321 }
                goto L_0x031e
            L_0x01f9:
                r3 = 5
                if (r13 == r3) goto L_0x0206
                r3 = 6
                if (r13 != r3) goto L_0x0200
                goto L_0x0206
            L_0x0200:
                com.shix.shixipc.activity.CloudVideoMjActivity r3 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r3.isH265 = r2     // Catch:{ all -> 0x0321 }
                goto L_0x020b
            L_0x0206:
                com.shix.shixipc.activity.CloudVideoMjActivity r3 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r3.isH265 = r5     // Catch:{ all -> 0x0321 }
            L_0x020b:
                com.shix.shixipc.activity.CloudVideoMjActivity r3 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean r3 = r3.isH265     // Catch:{ all -> 0x0321 }
                if (r3 != r5) goto L_0x0226
                com.shix.shixipc.activity.CloudVideoMjActivity r3 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean r3 = r3.isInitH265     // Catch:{ all -> 0x0321 }
                if (r3 != 0) goto L_0x0226
                com.shix.shixipc.activity.CloudVideoMjActivity r3 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r3.isInitH265 = r5     // Catch:{ all -> 0x0321 }
                object.p2pipcam.nativecaller.NativeCaller.DecoderFree()     // Catch:{ all -> 0x0321 }
                object.p2pipcam.nativecaller.NativeCaller.DecoderInit(r5)     // Catch:{ all -> 0x0321 }
            L_0x0226:
                com.shix.shixipc.activity.CloudVideoMjActivity r3 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean r3 = r3.isH265     // Catch:{ all -> 0x0321 }
                if (r3 != 0) goto L_0x0241
                com.shix.shixipc.activity.CloudVideoMjActivity r3 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean r3 = r3.isInitH265     // Catch:{ all -> 0x0321 }
                if (r3 != 0) goto L_0x0241
                com.shix.shixipc.activity.CloudVideoMjActivity r3 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r3.isInitH265 = r5     // Catch:{ all -> 0x0321 }
                object.p2pipcam.nativecaller.NativeCaller.DecoderFree()     // Catch:{ all -> 0x0321 }
                object.p2pipcam.nativecaller.NativeCaller.DecoderInit(r5)     // Catch:{ all -> 0x0321 }
            L_0x0241:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0321 }
                r3.<init>()     // Catch:{ all -> 0x0321 }
                java.lang.String r13 = "ZHAOPLAY isH265:"
                r3.append(r13)     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r13 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean r13 = r13.isH265     // Catch:{ all -> 0x0321 }
                r3.append(r13)     // Catch:{ all -> 0x0321 }
                java.lang.String r13 = "  w:"
                r3.append(r13)     // Catch:{ all -> 0x0321 }
                r3.append(r11)     // Catch:{ all -> 0x0321 }
                java.lang.String r11 = " h:"
                r3.append(r11)     // Catch:{ all -> 0x0321 }
                r3.append(r12)     // Catch:{ all -> 0x0321 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.utils.CommonUtil.Log(r5, r3)     // Catch:{ all -> 0x0321 }
                r3 = 3110400(0x2f7600, float:4.358599E-39)
                byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0321 }
                int[] r7 = new int[r7]     // Catch:{ all -> 0x0321 }
                int r0 = object.p2pipcam.nativecaller.NativeCaller.DecodeH264Frame(r14, r5, r3, r0, r7)     // Catch:{ all -> 0x0321 }
                if (r0 <= 0) goto L_0x0285
                r0 = r7[r2]     // Catch:{ all -> 0x0321 }
                r7 = r7[r5]     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r11 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                object.p2pipcam.nativecaller.MyRender r11 = r11.myRender     // Catch:{ all -> 0x0321 }
                r11.writeSample(r3, r0, r7)     // Catch:{ all -> 0x0321 }
            L_0x0285:
                java.lang.String r0 = "ZHAOPLAY decoder end"
                com.shix.shixipc.utils.CommonUtil.Log(r5, r0)     // Catch:{ all -> 0x0321 }
                java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x0321 }
                r0.<init>()     // Catch:{ all -> 0x0321 }
                long r11 = r0.getTime()     // Catch:{ all -> 0x0321 }
                long r11 = r11 - r9
                int r0 = (int) r11     // Catch:{ all -> 0x0321 }
                int r3 = r8 - r0
                if (r3 <= 0) goto L_0x02f3
                com.shix.shixipc.activity.CloudVideoMjActivity r7 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r8 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                int r8 = r8.sumTime     // Catch:{ all -> 0x0321 }
                int r8 = r8 + r0
                int unused = r7.sumTime = r8     // Catch:{ all -> 0x0321 }
                int r0 = r3 / 10
                int r3 = r3 % 10
                r7 = r2
            L_0x02aa:
                if (r7 >= r0) goto L_0x02c1
                com.shix.shixipc.activity.CloudVideoMjActivity r8 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r9 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                int r9 = r9.sumTime     // Catch:{ all -> 0x0321 }
                int r9 = r9 + 10
                int unused = r8.sumTime = r9     // Catch:{ all -> 0x0321 }
                r8 = 10
                java.lang.Thread.sleep(r8)     // Catch:{ all -> 0x0321 }
                int r7 = r7 + 1
                goto L_0x02aa
            L_0x02c1:
                r7 = 3
                if (r3 <= r7) goto L_0x02c6
                int r3 = r3 + -3
            L_0x02c6:
                com.shix.shixipc.activity.CloudVideoMjActivity r7 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r8 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                int r8 = r8.sumTime     // Catch:{ all -> 0x0321 }
                int r8 = r8 + r3
                int unused = r7.sumTime = r8     // Catch:{ all -> 0x0321 }
                long r7 = (long) r3     // Catch:{ all -> 0x0321 }
                java.lang.Thread.sleep(r7)     // Catch:{ all -> 0x0321 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0321 }
                r7.<init>()     // Catch:{ all -> 0x0321 }
                java.lang.String r8 = "ZHAOPLAY remainTime:"
                r7.append(r8)     // Catch:{ all -> 0x0321 }
                r7.append(r3)     // Catch:{ all -> 0x0321 }
                java.lang.String r3 = "  count:"
                r7.append(r3)     // Catch:{ all -> 0x0321 }
                r7.append(r0)     // Catch:{ all -> 0x0321 }
                java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.utils.CommonUtil.Log(r5, r0)     // Catch:{ all -> 0x0321 }
                goto L_0x031d
            L_0x02f3:
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r3 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                int r3 = r3.sumTime     // Catch:{ all -> 0x0321 }
                int r3 = r3 + r8
                int unused = r0.sumTime = r3     // Catch:{ all -> 0x0321 }
                goto L_0x031d
            L_0x0300:
                java.lang.String r0 = "tag"
                java.lang.String r3 = "ZHAOPLAY wait 1"
                android.util.Log.d(r0, r3)     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r0.isPause = r5     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                r0.wait()     // Catch:{ all -> 0x0321 }
                java.lang.String r0 = "tag"
                java.lang.String r3 = "ZHAOPLAY wait 2"
                android.util.Log.d(r0, r3)     // Catch:{ all -> 0x0321 }
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this     // Catch:{ all -> 0x0321 }
                boolean unused = r0.isPause = r2     // Catch:{ all -> 0x0321 }
            L_0x031d:
                monitor-exit(r6)     // Catch:{ all -> 0x0321 }
            L_0x031e:
                r3 = 3
                goto L_0x002d
            L_0x0321:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0321 }
                throw r0     // Catch:{ Exception -> 0x033b, all -> 0x0339 }
            L_0x0324:
                java.lang.String r0 = "tag"
                java.lang.String r2 = "ZHAOPLAY finally"
                android.util.Log.d(r0, r2)
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this
                android.os.Handler r0 = r0.mHandler
                r2 = 3
                r0.sendEmptyMessage(r2)
                r4.close()     // Catch:{ IOException -> 0x0374 }
                goto L_0x0397
            L_0x0339:
                r0 = move-exception
                goto L_0x0340
            L_0x033b:
                r0 = move-exception
                r2 = r4
                goto L_0x0343
            L_0x033e:
                r0 = move-exception
                r4 = r2
            L_0x0340:
                r2 = r0
                goto L_0x037a
            L_0x0342:
                r0 = move-exception
            L_0x0343:
                java.lang.String r3 = "tag"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x033e }
                r4.<init>()     // Catch:{ all -> 0x033e }
                java.lang.String r5 = "ZHAOPLAY e:"
                r4.append(r5)     // Catch:{ all -> 0x033e }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x033e }
                r4.append(r0)     // Catch:{ all -> 0x033e }
                java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x033e }
                android.util.Log.d(r3, r0)     // Catch:{ all -> 0x033e }
                java.lang.String r0 = "tag"
                java.lang.String r3 = "ZHAOPLAY finally"
                android.util.Log.d(r0, r3)
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this
                android.os.Handler r0 = r0.mHandler
                r3 = 3
                r0.sendEmptyMessage(r3)
                if (r2 == 0) goto L_0x0397
                r2.close()     // Catch:{ IOException -> 0x0374 }
                goto L_0x0397
            L_0x0374:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
                goto L_0x0397
            L_0x037a:
                java.lang.String r0 = "tag"
                java.lang.String r3 = "ZHAOPLAY finally"
                android.util.Log.d(r0, r3)
                com.shix.shixipc.activity.CloudVideoMjActivity r0 = com.shix.shixipc.activity.CloudVideoMjActivity.this
                android.os.Handler r0 = r0.mHandler
                r3 = 3
                r0.sendEmptyMessage(r3)
                if (r4 == 0) goto L_0x0396
                r4.close()     // Catch:{ IOException -> 0x0391 }
                goto L_0x0396
            L_0x0391:
                r0 = move-exception
                r3 = r0
                r3.printStackTrace()
            L_0x0396:
                throw r2
            L_0x0397:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.CloudVideoMjActivity.PlayThread.run():void");
        }
    }

    private void pVideo() {
        synchronized (this) {
            notifyAll();
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

    /* access modifiers changed from: private */
    public String setDeviceTime(long j, String str) {
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
            str2 = MBridgeConstans.ENDCARD_URL_TYPE_PL + i2;
        } else {
            str2 = String.valueOf(i2);
        }
        if (i3 < 10) {
            str3 = MBridgeConstans.ENDCARD_URL_TYPE_PL + i3;
        } else {
            str3 = String.valueOf(i3);
        }
        if (i4 < 10) {
            str4 = MBridgeConstans.ENDCARD_URL_TYPE_PL + i4;
        } else {
            str4 = String.valueOf(i4);
        }
        if (i5 < 10) {
            str5 = MBridgeConstans.ENDCARD_URL_TYPE_PL + i5;
        } else {
            str5 = String.valueOf(i5);
        }
        if (i6 < 10) {
            str6 = MBridgeConstans.ENDCARD_URL_TYPE_PL + i6;
        } else {
            str6 = String.valueOf(i6);
        }
        return i + "-" + str2 + "-" + str3 + "   " + str4 + ":" + str5 + ":" + str6;
    }
}
