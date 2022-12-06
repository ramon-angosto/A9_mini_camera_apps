package shix.ihdbell.project;

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
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.utils.DataBaseHelper;

public class ShowLocalVideoActivity extends BaseActivity implements View.OnClickListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnTouchListener {
    /* access modifiers changed from: private */
    public RelativeLayout bottomLayout;
    private Button btnBack;
    private Button btnLeft;
    /* access modifiers changed from: private */
    public Button btnPlay;
    private Button btnRight;
    /* access modifiers changed from: private */
    public long fileLen = 0;
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
            if (i == 0) {
                ShowLocalVideoActivity.this.seekBar.setMax(100);
            } else if (i == 1) {
                int access$200 = (int) (ShowLocalVideoActivity.this.processV * 100.0f);
                Log.d("test", "processV:" + ShowLocalVideoActivity.this.processV + "  test:" + access$200);
                ShowLocalVideoActivity.this.seekBar.setProgress(access$200);
            } else if (i == 2) {
                ShowLocalVideoActivity.this.imgPause.setVisibility(8);
                ShowLocalVideoActivity.this.btnPlay.setBackgroundResource(R.drawable.video_play_pause_selector);
                ShowLocalVideoActivity.this.finish();
            }
        }
    };
    private TextView mTv_Prompt;
    /* access modifiers changed from: private */
    public GLSurfaceView myGLSurfaceView;
    private Runnable myProRunnable = new Runnable() {
        public void run() {
        }
    };
    /* access modifiers changed from: private */
    public MyRender myRender;
    private PlayThread playThread;
    private int position;
    /* access modifiers changed from: private */
    public float processV;
    /* access modifiers changed from: private */
    public int progress = 0;
    /* access modifiers changed from: private */
    public long readLong = 0;
    /* access modifiers changed from: private */
    public ProgressBar seekBar;
    private String strCameraName;
    private int sum;
    /* access modifiers changed from: private */
    public int sumTime;
    /* access modifiers changed from: private */
    public RelativeLayout topLayout;
    private TextView tvCurrentTime;
    private TextView tvSumTime;
    private TextView tvTime;
    private TextView tvTitle;
    /* access modifiers changed from: private */
    public int videoSumTime;
    private int wh;
    private float x1 = 0.0f;
    private float x2 = 0.0f;
    private float y1 = 0.0f;
    private float y2 = 0.0f;

    public static byte intToOneByte(int i) {
        return (byte) i;
    }

    public static int onebyteToInt(byte b) {
        return b & 255;
    }

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

    static /* synthetic */ int access$1508(ShowLocalVideoActivity showLocalVideoActivity) {
        int i = showLocalVideoActivity.frameCout;
        showLocalVideoActivity.frameCout = i + 1;
        return i;
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

    public static int byteArrayToInt(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    public static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.showlocalvideo_activity);
        findView();
        setListener();
        this.tvTime.setText(getContent(this.filePath));
        this.mHandler.sendEmptyMessageDelayed(2, 500);
    }

    private void setListener() {
        this.btnPlay.setOnClickListener(this);
        this.btnLeft.setOnClickListener(this);
        this.btnRight.setOnClickListener(this);
        this.img.setOnTouchListener(this);
        this.topLayout.setOnTouchListener(this);
        this.bottomLayout.setOnTouchListener(this);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.filePath = intent.getStringExtra(DataBaseHelper.KEY_FILEPATH);
        this.strCameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.position = intent.getIntExtra(RequestParameters.POSITION, 0);
        Log.d("tag", "strDID:" + this.filePath);
    }

    private void findView() {
        this.wh = getWindowManager().getDefaultDisplay().getWidth();
        this.ht = getWindowManager().getDefaultDisplay().getHeight();
        this.btnBack = (Button) findViewById(R.id.back);
        this.btnBack.setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(R.id.takevideo_title);
        this.tvTitle.setText(this.strCameraName);
        this.tvTime = (TextView) findViewById(R.id.takevideo_time);
        this.img = (ImageView) findViewById(R.id.img_playvideo);
        this.imgPause = (ImageView) findViewById(R.id.img_pause);
        this.topLayout = (RelativeLayout) findViewById(R.id.top);
        this.bottomLayout = (RelativeLayout) findViewById(R.id.bottom);
        this.seekBar = (ProgressBar) findViewById(R.id.progressBar1);
        this.tvSumTime = (TextView) findViewById(R.id.sumtime);
        this.tvCurrentTime = (TextView) findViewById(R.id.currenttime);
        this.btnPlay = (Button) findViewById(R.id.btn_play);
        this.btnLeft = (Button) findViewById(R.id.btn_left);
        this.btnRight = (Button) findViewById(R.id.btn_right);
        this.myGLSurfaceView = (GLSurfaceView) findViewById(R.id.glsurfaceview);
        this.myRender = new MyRender(this.myGLSurfaceView);
        this.myGLSurfaceView.setRenderer(this.myRender);
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
        substring.substring(0, 10);
        String replace = substring.substring(11, 16).replace("_", ":");
        Log.d("tag", "result:" + replace);
        Log.d("tag", "sss:" + substring.substring(0, 16));
        return replace;
    }

    private String getTime(int i) {
        String str;
        String str2;
        String str3;
        int i2 = i % 60;
        int i3 = i / 60;
        int i4 = i3 / 60;
        if (i2 < 10) {
            str = PushConstants.PUSH_TYPE_NOTIFY + i2;
        } else {
            str = String.valueOf(i2);
        }
        if (i3 < 10) {
            str2 = PushConstants.PUSH_TYPE_NOTIFY + i3;
        } else {
            str2 = String.valueOf(i3);
        }
        if (i4 < 10) {
            str3 = PushConstants.PUSH_TYPE_NOTIFY + i4;
        } else {
            str3 = String.valueOf(i4);
        }
        return str3 + ":" + str2 + ":" + str;
    }

    private void pVideo() {
        synchronized (this) {
            notifyAll();
        }
    }

    private void firstPicture() {
        if (this.filePath != null) {
            new Thread() {
                /* JADX WARNING: Removed duplicated region for block: B:21:0x010f A[SYNTHETIC, Splitter:B:21:0x010f] */
                /* JADX WARNING: Removed duplicated region for block: B:26:0x011a A[SYNTHETIC, Splitter:B:26:0x011a] */
                /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r9 = this;
                        java.lang.String r0 = "tag"
                        java.io.File r1 = new java.io.File
                        shix.ihdbell.project.ShowLocalVideoActivity r2 = shix.ihdbell.project.ShowLocalVideoActivity.this
                        java.lang.String r2 = r2.filePath
                        r1.<init>(r2)
                        r2 = 0
                        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00f4 }
                        r3.<init>(r1)     // Catch:{ Exception -> 0x00f4 }
                        int r1 = r3.available()     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r2 = 4
                        byte[] r4 = new byte[r2]     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r3.read(r4)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        int r4 = shix.ihdbell.project.ShowLocalVideoActivity.byteToInt(r4)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r5.<init>()     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        java.lang.String r6 = "fType:"
                        r5.append(r6)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r5.append(r4)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        android.util.Log.d(r0, r5)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r5 = 1
                        r6 = 8
                        r7 = 2
                        if (r4 == r5) goto L_0x00b2
                        if (r4 == r7) goto L_0x003f
                        goto L_0x00e8
                    L_0x003f:
                        shix.ihdbell.project.ShowLocalVideoActivity r4 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        android.opengl.GLSurfaceView r4 = r4.myGLSurfaceView     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r4.setVisibility(r6)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        byte[] r4 = new byte[r2]     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        byte[] r5 = new byte[r2]     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r3.read(r4)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r3.read(r5)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        int r4 = shix.ihdbell.project.ShowLocalVideoActivity.byteToInt(r4)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        shix.ihdbell.project.ShowLocalVideoActivity.byteToInt(r5)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        byte[] r5 = new byte[r4]     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r3.read(r5)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r6 = 0
                        int r8 = r5.length     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeByteArray(r5, r6, r8)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        shix.ihdbell.project.ShowLocalVideoActivity r6 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        android.os.Handler r6 = r6.mPlayHandler     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        android.os.Message r6 = r6.obtainMessage()     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r6.obj = r5     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        shix.ihdbell.project.ShowLocalVideoActivity r5 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        android.os.Handler r5 = r5.mPlayHandler     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r5.sendMessage(r6)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        int r4 = r4 + 16
                        int r1 = r1 - r4
                        long r4 = (long) r1     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r3.skip(r4)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        byte[] r1 = new byte[r2]     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r3.read(r1)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        shix.ihdbell.project.ShowLocalVideoActivity r2 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        int r1 = shix.ihdbell.project.ShowLocalVideoActivity.byteToInt(r1)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        int unused = r2.videoSumTime = r1     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r1.<init>()     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        java.lang.String r2 = " videoSumTime:"
                        r1.append(r2)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        shix.ihdbell.project.ShowLocalVideoActivity r2 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        int r2 = r2.videoSumTime     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r1.append(r2)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        android.util.Log.d(r0, r1)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        shix.ihdbell.project.ShowLocalVideoActivity r1 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        android.os.Handler r1 = r1.mHandler     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r1.sendEmptyMessage(r7)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        goto L_0x00e8
                    L_0x00b2:
                        int r1 = r1 - r6
                        long r4 = (long) r1     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r3.skip(r4)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        byte[] r1 = new byte[r2]     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r3.read(r1)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        shix.ihdbell.project.ShowLocalVideoActivity r2 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        int r1 = shix.ihdbell.project.ShowLocalVideoActivity.byteToInt(r1)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        int unused = r2.videoSumTime = r1     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r1.<init>()     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        java.lang.String r2 = "videoSumTime:"
                        r1.append(r2)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        shix.ihdbell.project.ShowLocalVideoActivity r2 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        int r2 = r2.videoSumTime     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r1.append(r2)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        android.util.Log.d(r0, r1)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        shix.ihdbell.project.ShowLocalVideoActivity r1 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        android.os.Handler r1 = r1.mHandler     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                        r1.sendEmptyMessage(r7)     // Catch:{ Exception -> 0x00ee, all -> 0x00ec }
                    L_0x00e8:
                        r3.close()     // Catch:{ IOException -> 0x0113 }
                        goto L_0x0117
                    L_0x00ec:
                        r0 = move-exception
                        goto L_0x0118
                    L_0x00ee:
                        r1 = move-exception
                        r2 = r3
                        goto L_0x00f5
                    L_0x00f1:
                        r0 = move-exception
                        r3 = r2
                        goto L_0x0118
                    L_0x00f4:
                        r1 = move-exception
                    L_0x00f5:
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
                        r3.<init>()     // Catch:{ all -> 0x00f1 }
                        java.lang.String r4 = "###error 222"
                        r3.append(r4)     // Catch:{ all -> 0x00f1 }
                        java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00f1 }
                        r3.append(r1)     // Catch:{ all -> 0x00f1 }
                        java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00f1 }
                        android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00f1 }
                        if (r2 == 0) goto L_0x0117
                        r2.close()     // Catch:{ IOException -> 0x0113 }
                        goto L_0x0117
                    L_0x0113:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x0117:
                        return
                    L_0x0118:
                        if (r3 == 0) goto L_0x0122
                        r3.close()     // Catch:{ IOException -> 0x011e }
                        goto L_0x0122
                    L_0x011e:
                        r1 = move-exception
                        r1.printStackTrace()
                    L_0x0122:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.ShowLocalVideoActivity.AnonymousClass5.run():void");
                }
            }.start();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                this.flag = false;
                finish();
                return;
            case R.id.btn_play:
                if (this.isPlaying) {
                    this.btnPlay.setBackgroundResource(R.drawable.video_play_pause_selector);
                    this.imgPause.setVisibility(8);
                    Log.d("tag", "pause");
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
                return;
            default:
                return;
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

    private class PlayThread extends Thread {
        private PlayThread() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:69:0x01f7 A[SYNTHETIC, Splitter:B:69:0x01f7] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r13 = this;
                shix.ihdbell.project.ShowLocalVideoActivity r0 = shix.ihdbell.project.ShowLocalVideoActivity.this
                java.lang.String r0 = r0.filePath
                if (r0 == 0) goto L_0x0200
                java.io.File r0 = new java.io.File
                shix.ihdbell.project.ShowLocalVideoActivity r1 = shix.ihdbell.project.ShowLocalVideoActivity.this
                java.lang.String r1 = r1.filePath
                r0.<init>(r1)
                r1 = 0
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x01cf }
                r2.<init>(r0)     // Catch:{ Exception -> 0x01cf }
                shix.ihdbell.project.ShowLocalVideoActivity r0 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                r1 = 0
                int unused = r0.frameCout = r1     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                shix.ihdbell.project.ShowLocalVideoActivity r0 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                int unused = r0.sumTime = r1     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                shix.ihdbell.project.ShowLocalVideoActivity r0 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                r3 = 1
                boolean unused = r0.flag = r3     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                shix.ihdbell.project.ShowLocalVideoActivity r0 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                r4 = 0
                long unused = r0.readLong = r4     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                shix.ihdbell.project.ShowLocalVideoActivity r0 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                int r4 = r2.available()     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                long r4 = (long) r4     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                long unused = r0.fileLen = r4     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                java.lang.String r0 = "tag"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                r4.<init>()     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                java.lang.String r5 = "�ļ��ܳ�:"
                r4.append(r5)     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                shix.ihdbell.project.ShowLocalVideoActivity r5 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                int r5 = r5.progress     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                r4.append(r5)     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                android.util.Log.d(r0, r4)     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                shix.ihdbell.project.ShowLocalVideoActivity r0 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                android.os.Handler r0 = r0.mProgressHandler     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                r0.sendEmptyMessage(r1)     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
            L_0x0060:
                int r0 = r2.available()     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                if (r0 == 0) goto L_0x01c3
                shix.ihdbell.project.ShowLocalVideoActivity r0 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                boolean r0 = r0.flag     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                if (r0 == 0) goto L_0x01c3
                shix.ihdbell.project.ShowLocalVideoActivity r0 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                monitor-enter(r0)     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
                java.lang.String r4 = "tag"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c0 }
                r5.<init>()     // Catch:{ all -> 0x01c0 }
                java.lang.String r6 = "flag="
                r5.append(r6)     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r6 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                boolean r6 = r6.flag     // Catch:{ all -> 0x01c0 }
                r5.append(r6)     // Catch:{ all -> 0x01c0 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01c0 }
                android.util.Log.d(r4, r5)     // Catch:{ all -> 0x01c0 }
                r4 = 4
                byte[] r5 = new byte[r4]     // Catch:{ all -> 0x01c0 }
                byte[] r6 = new byte[r3]     // Catch:{ all -> 0x01c0 }
                r7 = 11
                byte[] r7 = new byte[r7]     // Catch:{ all -> 0x01c0 }
                byte[] r4 = new byte[r4]     // Catch:{ all -> 0x01c0 }
                r8 = 12
                byte[] r8 = new byte[r8]     // Catch:{ all -> 0x01c0 }
                r2.read(r5)     // Catch:{ all -> 0x01c0 }
                r2.read(r6)     // Catch:{ all -> 0x01c0 }
                r2.read(r7)     // Catch:{ all -> 0x01c0 }
                r2.read(r4)     // Catch:{ all -> 0x01c0 }
                r2.read(r8)     // Catch:{ all -> 0x01c0 }
                int r4 = shix.ihdbell.project.ShowLocalVideoActivity.byteToInt(r4)     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r5 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r7 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                long r7 = r7.readLong     // Catch:{ all -> 0x01c0 }
                r9 = 32
                long r7 = r7 + r9
                long r9 = (long) r4     // Catch:{ all -> 0x01c0 }
                long r7 = r7 + r9
                long unused = r5.readLong = r7     // Catch:{ all -> 0x01c0 }
                r5 = 2
                if (r4 != 0) goto L_0x00e6
                if (r4 != 0) goto L_0x00e6
                shix.ihdbell.project.ShowLocalVideoActivity r4 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                boolean unused = r4.flag = r1     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r4 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                boolean unused = r4.isStart = r3     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r3 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                boolean unused = r3.isPlaying = r1     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r1 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                android.os.Handler r1 = r1.mProgressHandler     // Catch:{ all -> 0x01c0 }
                r1.sendEmptyMessage(r5)     // Catch:{ all -> 0x01c0 }
                monitor-exit(r0)     // Catch:{ all -> 0x01c0 }
                r2.close()     // Catch:{ IOException -> 0x00e1 }
                goto L_0x00e5
            L_0x00e1:
                r0 = move-exception
                r0.printStackTrace()
            L_0x00e5:
                return
            L_0x00e6:
                byte r6 = r6[r1]     // Catch:{ all -> 0x01c0 }
                int r6 = shix.ihdbell.project.ShowLocalVideoActivity.onebyteToInt(r6)     // Catch:{ all -> 0x01c0 }
                byte[] r7 = new byte[r4]     // Catch:{ all -> 0x01c0 }
                r2.read(r7)     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r8 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r9 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                long r9 = r9.readLong     // Catch:{ all -> 0x01c0 }
                float r9 = (float) r9     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r10 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                long r10 = r10.fileLen     // Catch:{ all -> 0x01c0 }
                float r10 = (float) r10     // Catch:{ all -> 0x01c0 }
                float r9 = r9 / r10
                float unused = r8.processV = r9     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r8 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                android.os.Handler r8 = r8.mProgressHandler     // Catch:{ all -> 0x01c0 }
                r8.sendEmptyMessage(r3)     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r8 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                long r8 = r8.readLong     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r10 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                long r10 = r10.fileLen     // Catch:{ all -> 0x01c0 }
                int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r12 != 0) goto L_0x012a
                shix.ihdbell.project.ShowLocalVideoActivity r1 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                android.os.Handler r1 = r1.mProgressHandler     // Catch:{ all -> 0x01c0 }
                r1.sendEmptyMessage(r5)     // Catch:{ all -> 0x01c0 }
                monitor-exit(r0)     // Catch:{ all -> 0x01c0 }
                goto L_0x01c3
            L_0x012a:
                shix.ihdbell.project.ShowLocalVideoActivity r8 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                boolean r8 = r8.isPlaying     // Catch:{ all -> 0x01c0 }
                if (r8 == 0) goto L_0x01a0
                shix.ihdbell.project.ShowLocalVideoActivity r8 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity.access$1508(r8)     // Catch:{ all -> 0x01c0 }
                java.lang.String r8 = "tag"
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c0 }
                r9.<init>()     // Catch:{ all -> 0x01c0 }
                java.lang.String r10 = "isPlaying: "
                r9.append(r10)     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r10 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                int r10 = r10.frameCout     // Catch:{ all -> 0x01c0 }
                r9.append(r10)     // Catch:{ all -> 0x01c0 }
                java.lang.String r10 = " ֡"
                r9.append(r10)     // Catch:{ all -> 0x01c0 }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01c0 }
                android.util.Log.d(r8, r9)     // Catch:{ all -> 0x01c0 }
                r8 = 20
                if (r6 == 0) goto L_0x0182
                if (r6 == r3) goto L_0x0182
                r4 = 3
                if (r6 == r4) goto L_0x0162
                goto L_0x01bd
            L_0x0162:
                int r4 = r7.length     // Catch:{ all -> 0x01c0 }
                android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeByteArray(r7, r1, r4)     // Catch:{ all -> 0x01c0 }
                if (r4 == 0) goto L_0x017e
                shix.ihdbell.project.ShowLocalVideoActivity r5 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                android.os.Handler r5 = r5.mPlayHandler     // Catch:{ all -> 0x01c0 }
                android.os.Message r5 = r5.obtainMessage()     // Catch:{ all -> 0x01c0 }
                r5.obj = r4     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r4 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                android.os.Handler r4 = r4.mPlayHandler     // Catch:{ all -> 0x01c0 }
                r4.sendMessage(r5)     // Catch:{ all -> 0x01c0 }
            L_0x017e:
                sleep(r8)     // Catch:{ all -> 0x01c0 }
                goto L_0x01bd
            L_0x0182:
                r6 = 1382400(0x151800, float:1.937155E-39)
                byte[] r6 = new byte[r6]     // Catch:{ all -> 0x01c0 }
                int[] r5 = new int[r5]     // Catch:{ all -> 0x01c0 }
                int r4 = object.p2pipcam.nativecaller.NativeCaller.DecodeH264Frame(r7, r3, r6, r4, r5)     // Catch:{ all -> 0x01c0 }
                if (r4 <= 0) goto L_0x01bd
                r4 = r5[r1]     // Catch:{ all -> 0x01c0 }
                r5 = r5[r3]     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r7 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.MyRender r7 = r7.myRender     // Catch:{ all -> 0x01c0 }
                r7.writeSample(r6, r4, r5)     // Catch:{ all -> 0x01c0 }
                sleep(r8)     // Catch:{ all -> 0x01c0 }
                goto L_0x01bd
            L_0x01a0:
                java.lang.String r4 = "tag"
                java.lang.String r5 = "wait 1"
                android.util.Log.d(r4, r5)     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r4 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                boolean unused = r4.isPause = r3     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r4 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                r4.wait()     // Catch:{ all -> 0x01c0 }
                java.lang.String r4 = "tag"
                java.lang.String r5 = "wait 2"
                android.util.Log.d(r4, r5)     // Catch:{ all -> 0x01c0 }
                shix.ihdbell.project.ShowLocalVideoActivity r4 = shix.ihdbell.project.ShowLocalVideoActivity.this     // Catch:{ all -> 0x01c0 }
                boolean unused = r4.isPause = r1     // Catch:{ all -> 0x01c0 }
            L_0x01bd:
                monitor-exit(r0)     // Catch:{ all -> 0x01c0 }
                goto L_0x0060
            L_0x01c0:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x01c0 }
                throw r1     // Catch:{ Exception -> 0x01c9, all -> 0x01c7 }
            L_0x01c3:
                r2.close()     // Catch:{ IOException -> 0x01f0 }
                goto L_0x0200
            L_0x01c7:
                r0 = move-exception
                goto L_0x01f5
            L_0x01c9:
                r0 = move-exception
                r1 = r2
                goto L_0x01d0
            L_0x01cc:
                r0 = move-exception
                r2 = r1
                goto L_0x01f5
            L_0x01cf:
                r0 = move-exception
            L_0x01d0:
                java.lang.String r2 = "tag"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cc }
                r3.<init>()     // Catch:{ all -> 0x01cc }
                java.lang.String r4 = "###error11"
                r3.append(r4)     // Catch:{ all -> 0x01cc }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01cc }
                r3.append(r0)     // Catch:{ all -> 0x01cc }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01cc }
                android.util.Log.d(r2, r0)     // Catch:{ all -> 0x01cc }
                if (r1 == 0) goto L_0x0200
                r1.close()     // Catch:{ IOException -> 0x01f0 }
                goto L_0x0200
            L_0x01f0:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0200
            L_0x01f5:
                if (r2 == 0) goto L_0x01ff
                r2.close()     // Catch:{ IOException -> 0x01fb }
                goto L_0x01ff
            L_0x01fb:
                r1 = move-exception
                r1.printStackTrace()
            L_0x01ff:
                throw r0
            L_0x0200:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.ShowLocalVideoActivity.PlayThread.run():void");
        }
    }
}
