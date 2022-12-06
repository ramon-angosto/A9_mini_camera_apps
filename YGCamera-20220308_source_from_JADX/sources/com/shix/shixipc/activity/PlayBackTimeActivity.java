package com.shix.shixipc.activity;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.text.format.Formatter;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.hdl.ruler.RulerView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.glview.MyLiveViewGLMonitor;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.AudioPlayer;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.CustomBuffer;
import com.shix.shixipc.utils.CustomBufferData;
import com.shix.shixipc.utils.CustomBufferHead;
import com.shix.shixipc.utils.TakeVideoThread;
import com.shix.shixipc.widget.CalendarAdapter;
import com.shix.shixipc.widget.DateVo;
import com.shix.shixipc.widget.DialogForCalendar;
import com.shix.shixipc.widget.DialogLoading;
import com.shix.shixipc.widget.OnValueChangeListener;
import com.shix.shixipc.widget.RecordInfo;
import com.shix.shixipc.widget.VideoRulerView;
import com.shix.shixipc.widget.VideoVo;
import com.shix.shixipc.widget.VieoBean;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import object.p2pipcam.nativecaller.MyRender;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class PlayBackTimeActivity extends BaseActivity implements NUIMainActivity.PlayBackInterface, View.OnClickListener, View.OnTouchListener, MyLiveViewGLMonitor.OnfigCangeInterface, GestureDetector.OnGestureListener, CalendarAdapter.OnItemClickListenr, NUIMainActivity.SHIXCOMMONInterface {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    private CustomBuffer AudioBuffer = null;
    long BarMoveFinishCurrentTime = 0;
    private float action_down_x;
    private float action_down_y;
    private AudioPlayer audioPlayer = null;
    private long availableBlocks;
    /* access modifiers changed from: private */
    public boolean bDisplayFinished = true;
    private long blockSize;
    public float bottom;
    Calendar calendar;
    /* access modifiers changed from: private */
    public int countGet = 0;
    /* access modifiers changed from: private */
    public int countTime = 0;
    List<RecordInfo> data = new ArrayList();
    String dateStringEnd;
    String dateStringStart;
    Animation dismissAnim;
    long endTime;
    boolean exit = false;
    String fileName;
    int fileSize;
    DialogForCalendar forCalendar;
    FileOutputStream fos;

    /* renamed from: gt */
    private GestureDetector f1548gt = new GestureDetector(this);
    public float height;
    /* access modifiers changed from: private */

    /* renamed from: i1 */
    public int f1549i1 = 0;
    /* access modifiers changed from: private */

    /* renamed from: i2 */
    public int f1550i2 = 0;
    ImageButton ibVoice;
    boolean isAllVoice = false;
    boolean isBarMoving = false;
    private boolean isDown = false;
    boolean isFirstShowRule = true;
    boolean isH264 = false;
    boolean isHD = false;
    /* access modifiers changed from: private */
    public boolean isOffset = false;
    /* access modifiers changed from: private */
    public boolean isOneShow = true;
    private boolean isPlaySeekBar = true;
    boolean isPort = false;
    private boolean isSecondDown = false;
    boolean isShowRule = true;
    private boolean isTakeVideo = false;
    private boolean isZoom = false;
    /* access modifiers changed from: private */
    public String key;
    float lastX;
    float lastY;
    /* access modifiers changed from: private */
    public LinearLayout layoutConnPrompt;
    private boolean lefRitUpDowTag = false;
    public float left;
    int lenTimeI = 0;
    ConcurrentLinkedQueue<VieoBean> linkedQueue;
    Bitmap mBmp = null;
    private float mCurrentLength;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            Bitmap bitmap;
            int i = message.what;
            if (i == 1) {
                CommonUtil.Log(1, "SHIXDEV-----------show");
                if (PlayBackTimeActivity.this.isOneShow) {
                    PlayBackTimeActivity.this.setRequestedOrientation(0);
                    boolean unused = PlayBackTimeActivity.this.isOneShow = false;
                }
                int width = PlayBackTimeActivity.this.getWindowManager().getDefaultDisplay().getWidth();
                int height = PlayBackTimeActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                if (PlayBackTimeActivity.this.getResources().getConfiguration().orientation == 1) {
                    new FrameLayout.LayoutParams(width, (width * 3) / 4).gravity = 17;
                } else if (PlayBackTimeActivity.this.getResources().getConfiguration().orientation == 2) {
                    new FrameLayout.LayoutParams(width, height).gravity = 17;
                }
                boolean unused2 = PlayBackTimeActivity.this.bDisplayFinished = true;
            } else if (i == 2) {
                PlayBackTimeActivity.this.textTimeStamp.setText(PlayBackTimeActivity.this.timeShow);
                Bitmap bitmap2 = null;
                try {
                    bitmap = BitmapFactory.decodeByteArray(PlayBackTimeActivity.this.videodata, 0, PlayBackTimeActivity.this.videoDataLen);
                } catch (Exception unused3) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    if (PlayBackTimeActivity.this.isOneShow) {
                        PlayBackTimeActivity.this.setRequestedOrientation(0);
                        boolean unused4 = PlayBackTimeActivity.this.isOneShow = false;
                    }
                    int width2 = PlayBackTimeActivity.this.getWindowManager().getDefaultDisplay().getWidth();
                    int height2 = PlayBackTimeActivity.this.getWindowManager().getDefaultDisplay().getHeight();
                    int i2 = (width2 * 3) / 4;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width2, i2);
                    layoutParams.gravity = 17;
                    PlayBackTimeActivity.this.playImg.setLayoutParams(layoutParams);
                    if (PlayBackTimeActivity.this.getResources().getConfiguration().orientation == 1) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, width2, i2, true);
                    } else if (PlayBackTimeActivity.this.getResources().getConfiguration().orientation == 2) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, width2, height2, true);
                    }
                    PlayBackTimeActivity.this.playImg.setVisibility(0);
                    PlayBackTimeActivity.this.playImg.setImageBitmap(bitmap2);
                }
            } else if (i == 3) {
                PlayBackTimeActivity.this.layoutConnPrompt.setVisibility(8);
                PlayBackTimeActivity.access$308(PlayBackTimeActivity.this);
                int access$400 = PlayBackTimeActivity.this.newTime - PlayBackTimeActivity.this.timex;
                if (access$400 <= PlayBackTimeActivity.this.lenTimeI && !PlayBackTimeActivity.this.isOffset) {
                    PlayBackTimeActivity.this.playSeekBar.setProgress(access$400);
                }
                PlayBackTimeActivity.this.textViewStart.setText(access$400 + "S");
                if (PlayBackTimeActivity.this.countGet > 130) {
                    boolean unused5 = PlayBackTimeActivity.this.isOffset = false;
                    int unused6 = PlayBackTimeActivity.this.countGet = 0;
                }
                if (!PlayBackTimeActivity.this.isBarMoving && PlayBackTimeActivity.this.isShowRule) {
                    PlayBackTimeActivity.this.videoRulerView.setCurrentIime(((Long) message.obj).longValue());
                }
                if (Math.abs((PlayBackTimeActivity.this.BarMoveFinishCurrentTime / 10000) - (((Long) message.obj).longValue() / 10000)) < 2) {
                    DialogLoading.getInstance().onDismiss();
                }
                CommonUtil.Log(1, "SHIXDEV-----------countTime:" + PlayBackTimeActivity.this.countTime + "   lenTimeI:" + PlayBackTimeActivity.this.lenTimeI);
            } else if (i == 1024) {
                Log.e("key", "vo " + VideoVo.keys.contains(PlayBackTimeActivity.this.key) + "key = " + PlayBackTimeActivity.this.key);
                PlayBackTimeActivity.this.forCalendar.setDate();
            } else if (i == 1132) {
            } else {
                if (i == 4242) {
                    NUIMainActivity.setSHIXCOMMONInterface(PlayBackTimeActivity.this);
                    PlayBackTimeActivity playBackTimeActivity = PlayBackTimeActivity.this;
                    Toast.makeText(playBackTimeActivity, playBackTimeActivity.getResources().getString(R.string.device_has_no_record), 0).show();
                } else if (i == 5321) {
                    if (PlayBackTimeActivity.this.videoRulerView != null) {
                        PlayBackTimeActivity.this.videoRulerView.setSelectTime(PlayBackTimeActivity.this.f1551vo.getYear(), PlayBackTimeActivity.this.f1551vo.getMonth(), PlayBackTimeActivity.this.f1551vo.getDay());
                    }
                    PlayBackTimeActivity.this.startVideoFile();
                    PlayBackTimeActivity.this.setVideoTimeSlot();
                }
            }
        }
    };
    ImageButton mIbBack;
    ImageButton mIbCalendar;
    ImageButton mIbTakeVideo;
    private boolean mIsFirst = true;
    private float mOriginalLength;
    LinearLayout mRulerLayout;
    TextView mTvDay;
    TextView mTvTakeVideo;
    LinearLayout mVideoRulerLayout;
    int moveX;
    int moveY;
    float move_x;
    float move_y;
    private GLSurfaceView myGlSurfaceView;
    private MyRender myRender;
    double nLenStart = 0.0d;
    private int nVideoHeight = 0;
    private int nVideoWidth = 0;
    /* access modifiers changed from: private */
    public int newTime = 0;

    /* renamed from: object  reason: collision with root package name */
    JSONObject f3989object;
    private int oldTime = 0;
    private File path = null;
    /* access modifiers changed from: private */
    public ImageView playImg;
    /* access modifiers changed from: private */
    public SeekBar playSeekBar;
    private RelativeLayout rt_seekl;
    RulerView rulerView;
    private String sdAvail = null;
    private String sdSize = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SurfaceHolder sfvHolder;
    SurfaceView sfv_play;
    Animation showAnim;
    /* access modifiers changed from: private */
    public int startPlayTime = 0;
    long startTime;
    private StatFs stat;
    private String status = null;
    /* access modifiers changed from: private */
    public String strDID;
    /* access modifiers changed from: private */
    public String strFilePath;
    TakeVideoThread takeVideoThread;
    String tempStr = null;
    String[] tempStrs;
    /* access modifiers changed from: private */
    public TextView textTimeStamp;
    private TextView textViewLen;
    /* access modifiers changed from: private */
    public TextView textViewStart;
    private TextView textView_sdsize = null;
    private long time;
    private long time1;
    /* access modifiers changed from: private */
    public String timeShow = " ";
    int timex = 0;
    private long totalBlocks;
    private String tzStr = "GMT+08:00";
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    VideoRulerView videoRulerView;
    /* access modifiers changed from: private */
    public byte[] videodata = null;

    /* renamed from: vo */
    DateVo f1551vo;
    List<VideoVo> vos;
    public float width;

    /* renamed from: x1 */
    private float f1552x1 = 0.0f;

    /* renamed from: x2 */
    private float f1553x2 = 0.0f;
    int xlenOld;

    /* renamed from: y1 */
    private float f1554y1 = 0.0f;

    /* renamed from: y2 */
    private float f1555y2 = 0.0f;
    int ylenOld;

    private void initMatrix(int i, int i2) {
    }

    private void resetMonitorSize(boolean z, double d) {
    }

    public void CallBackOnfigStatu(int i) {
        if (i != 0 && i != 1 && i != 2) {
        }
    }

    public void callBackH264Data(String str, byte[] bArr, int i, int i2) {
    }

    public void callBackPlaybackVideoData(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
    }

    public boolean onDown(MotionEvent motionEvent) {
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

    static /* synthetic */ int access$308(PlayBackTimeActivity playBackTimeActivity) {
        int i = playBackTimeActivity.countGet;
        playBackTimeActivity.countGet = i + 1;
        return i;
    }

    class MyThread extends Thread {
        MyThread() {
        }

        public void run() {
            while (PlayBackTimeActivity.this.exit) {
                PlayBackTimeActivity playBackTimeActivity = PlayBackTimeActivity.this;
                int unused = playBackTimeActivity.f1550i2 = playBackTimeActivity.f1549i1;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (PlayBackTimeActivity.this.f1550i2 == PlayBackTimeActivity.this.f1549i1 && PlayBackTimeActivity.this.exit) {
                    PlayBackTimeActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            PlayBackTimeActivity.this.exit = false;
                            Log.e("playbackactivity", "this is where i do finish");
                            PlayBackTimeActivity.this.finish();
                            PlayBackTimeActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                        }
                    });
                }
            }
            super.run();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getDataFromOther();
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
        setContentView(R.layout.playbacktime);
        this.linkedQueue = new ConcurrentLinkedQueue<>();
        findView1();
        setListener();
        this.f1551vo = new DateVo();
        this.vos = new ArrayList();
        this.calendar = Calendar.getInstance();
        this.showAnim = AnimationUtils.loadAnimation(this, R.anim.ptz_otherset_anim_show);
        this.dismissAnim = AnimationUtils.loadAnimation(this, R.anim.ptz_otherset_anim_dismiss);
        NUIMainActivity.setPlayBackInterface(this);
        getVedioFile();
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this.AudioBuffer);
        ((Button) findViewById(R.id.date_cancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PlayBackTimeActivity.this.finish();
            }
        });
        this.status = Environment.getExternalStorageState();
        if (this.status.equals("mounted")) {
            try {
                this.path = Environment.getExternalStorageDirectory();
                this.stat = new StatFs(this.path.getPath());
                this.blockSize = (long) this.stat.getBlockSize();
                this.totalBlocks = (long) this.stat.getBlockCount();
                this.availableBlocks = (long) this.stat.getAvailableBlocks();
                this.sdSize = formatSize(this.totalBlocks * this.blockSize);
                this.sdAvail = formatSize(this.availableBlocks * this.blockSize);
            } catch (IllegalArgumentException unused) {
                this.status = "removed";
            }
        }
        initVideoRule();
    }

    private void getVedioFile() {
        Date date = new Date();
        this.calendar.setTime(date);
        this.f1551vo.setYear(this.calendar.get(1));
        this.f1551vo.setMonth(this.calendar.get(2) + 1);
        this.f1551vo.setDay(this.calendar.get(5));
        this.calendar.set(11, 0);
        this.calendar.set(12, 0);
        this.calendar.set(13, 0);
        this.startTime = this.calendar.getTimeInMillis();
        this.endTime = date.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dateStringStart = simpleDateFormat.format(Long.valueOf(this.startTime));
        this.dateStringEnd = simpleDateFormat.format(Long.valueOf(this.endTime));
        this.mTvDay.setText(this.dateStringEnd.substring(0, 10));
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.SHIX_Record_day(), 0);
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.SHIX_GetVideoFiles(SystemValue.doorBellAdmin, SystemValue.doorBellPass, this.dateStringStart, this.dateStringEnd), 0);
    }

    /* access modifiers changed from: package-private */
    public void initVideoRule() {
        this.videoRulerView = (VideoRulerView) findViewById(R.id.vrv_rule);
        this.videoRulerView.setSelectTime(this.calendar.get(1), this.calendar.get(2) + 1, this.calendar.get(5));
        this.videoRulerView.setmListener(new OnValueChangeListener() {
            public void onValueChange(float f) {
                PlayBackTimeActivity playBackTimeActivity = PlayBackTimeActivity.this;
                playBackTimeActivity.BarMoveFinishCurrentTime = playBackTimeActivity.getVideoStartTime(playBackTimeActivity.vos, PlayBackTimeActivity.this.videoRulerView.getTimeInMillis(f));
                if (PlayBackTimeActivity.this.BarMoveFinishCurrentTime > 0) {
                    Log.e("tag__", System.currentTimeMillis() + "          " + PlayBackTimeActivity.this.BarMoveFinishCurrentTime);
                    PlayBackTimeActivity.this.linkedQueue.clear();
                    NativeCaller.StartPlayBack(PlayBackTimeActivity.this.strDID, PlayBackTimeActivity.this.strFilePath, 100);
                    NativeCaller.TransferMessage(PlayBackTimeActivity.this.strDID, CommonUtil.SHIX_StartVideoOffset(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackTimeActivity.this.sdf.format(Long.valueOf(PlayBackTimeActivity.this.BarMoveFinishCurrentTime))), 0);
                    return;
                }
                DialogLoading.getInstance().onDismiss();
                PlayBackTimeActivity playBackTimeActivity2 = PlayBackTimeActivity.this;
                playBackTimeActivity2.isBarMoving = false;
                Toast.makeText(playBackTimeActivity2, playBackTimeActivity2.getResources().getString(R.string.current_has_no_video), 0).show();
            }

            public void onMoving() {
                PlayBackTimeActivity playBackTimeActivity = PlayBackTimeActivity.this;
                playBackTimeActivity.isBarMoving = true;
                NativeCaller.StartPlayBack(playBackTimeActivity.strDID, PlayBackTimeActivity.this.strFilePath, 100);
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
        this.data.clear();
        for (VideoVo next : this.vos) {
            RecordInfo recordInfo = new RecordInfo();
            recordInfo.setStartTime(next.getStartTime());
            recordInfo.setEndTime(next.getStartTime() + next.getDuration());
            if (next.isAlarm()) {
                recordInfo.setType(2);
            } else {
                recordInfo.setType(1);
            }
            this.data.add(recordInfo);
        }
        this.videoRulerView.setVedioArea(this.data);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() != R.id.back) {
            return this.f1548gt.onTouchEvent(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        if ((motionEvent.getAction() & 255) == 5 && 2 == pointerCount) {
            CommonUtil.Log(1, "SHIXNEW MotionEvent.ACTION_POINTER_DOWN ");
            for (int i = 0; i < pointerCount; i++) {
                new Point((int) motionEvent.getX(i), (int) motionEvent.getY(i));
            }
            this.xlenOld = Math.abs(((int) motionEvent.getX(0)) - ((int) motionEvent.getX(1)));
            this.ylenOld = Math.abs(((int) motionEvent.getY(0)) - ((int) motionEvent.getY(1)));
            int i2 = this.xlenOld;
            double d = (double) i2;
            double d2 = (double) i2;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = d * d2;
            int i3 = this.ylenOld;
            double d4 = (double) i3;
            double d5 = (double) i3;
            Double.isNaN(d4);
            Double.isNaN(d5);
            this.nLenStart = Math.sqrt(d3 + (d4 * d5));
        } else if ((motionEvent.getAction() & 255) == 2 && 2 == pointerCount) {
            CommonUtil.Log(1, "SHIXNEW MotionEvent.ACTION_MOVE ");
            for (int i4 = 0; i4 < pointerCount; i4++) {
                new Point((int) motionEvent.getX(i4), (int) motionEvent.getY(i4));
            }
            int abs = Math.abs(((int) motionEvent.getX(0)) - ((int) motionEvent.getX(1)));
            int abs2 = Math.abs(((int) motionEvent.getY(0)) - ((int) motionEvent.getY(1)));
            int abs3 = Math.abs(abs - this.xlenOld);
            int abs4 = Math.abs(abs2 - this.ylenOld);
            double d6 = (double) abs;
            Double.isNaN(d6);
            Double.isNaN(d6);
            double d7 = (double) abs2;
            Double.isNaN(d7);
            Double.isNaN(d7);
            double sqrt = Math.sqrt((d6 * d6) + (d7 * d7));
            if (abs3 >= 20 || abs4 >= 20) {
                if (!this.isPort) {
                    if (sqrt > this.nLenStart) {
                        resetMonitorSize(true, sqrt);
                        CommonUtil.Log(1, "SHIXPPPP  resetMonitorSize(true, nLenEnd)");
                    } else {
                        resetMonitorSize(false, sqrt);
                        CommonUtil.Log(1, "SHIXPPPP  resetMonitorSize(false, nLenEnd)");
                    }
                }
                this.xlenOld = abs;
                this.ylenOld = abs2;
                this.nLenStart = sqrt;
                return true;
            }
            CommonUtil.Log(1, "SHIXPPPP moveX < 20 && moveY < 20");
            return false;
        } else if (pointerCount == 1) {
            int action = motionEvent.getAction();
            if (action == 0) {
                CommonUtil.Log(1, "SHIXNEW ACTION_DOWN");
                this.action_down_x = motionEvent.getRawX();
                this.action_down_y = motionEvent.getRawY();
                this.lastX = this.action_down_x;
                this.lastY = this.action_down_y;
                this.f1552x1 = motionEvent.getX();
                this.f1554y1 = motionEvent.getY();
            } else if (action == 1) {
                this.f1553x2 = motionEvent.getX();
                this.f1555y2 = motionEvent.getY();
                CommonUtil.Log(1, "SHIX1111 Math.abs((x1 - x2)):" + Math.abs(this.f1552x1 - this.f1553x2) + "  Math.abs((y1 - y2)):" + Math.abs(this.f1554y1 - this.f1555y2));
                this.f1552x1 = 0.0f;
                this.f1553x2 = 0.0f;
                this.f1554y1 = 0.0f;
                this.f1555y2 = 0.0f;
                this.isDown = false;
                CommonUtil.Log(1, "SHIXNEW setViewVisible");
                this.mIsFirst = true;
                showBottom();
            } else if (action == 2) {
                if (!this.isDown) {
                    this.f1552x1 = motionEvent.getX();
                    this.f1554y1 = motionEvent.getY();
                    this.isDown = true;
                }
                this.f1553x2 = motionEvent.getX();
                this.f1555y2 = motionEvent.getY();
                CommonUtil.Log(1, "SHIXNEW ACTION_MOVE");
                this.move_x = motionEvent.getRawX();
                this.move_y = motionEvent.getRawY();
                if (Math.abs(this.move_x - this.action_down_x) > 40.0f || Math.abs(this.move_y - this.action_down_y) > 40.0f) {
                    CommonUtil.Log(1, "SHIXPPPP  mMonitor.setTouchMove(1)");
                }
            }
        }
        return false;
    }

    private String formatSize(long j) {
        return Formatter.formatFileSize(this, j);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ib_calendar) {
            this.forCalendar.showCalender();
        } else if (id == R.id.ptz_exit) {
            finish();
        }
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
        this.playSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                CommonUtil.Log(1, "SHIXPLAY_____ progress:" + progress);
                PlayBackTimeActivity playBackTimeActivity = PlayBackTimeActivity.this;
                int unused = playBackTimeActivity.startPlayTime = playBackTimeActivity.timex + progress;
                long access$2200 = ((long) PlayBackTimeActivity.this.startPlayTime) * 1000;
                String format = PlayBackTimeActivity.this.sdf.format(Long.valueOf(access$2200));
                Log.e("seekBar", access$2200 + " ---------");
                NativeCaller.StartPlayBack(PlayBackTimeActivity.this.strDID, PlayBackTimeActivity.this.strFilePath, 100);
                NativeCaller.TransferMessage(PlayBackTimeActivity.this.strDID, CommonUtil.SHIX_StartVideoOffset(SystemValue.doorBellAdmin, SystemValue.doorBellPass, format), 0);
                int unused2 = PlayBackTimeActivity.this.countGet = 0;
                boolean unused3 = PlayBackTimeActivity.this.isOffset = true;
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 8) {
                DialogLoading.getInstance().onDismiss();
            }
        } else if (!this.isTakeVideo) {
            if (this.isPlaySeekBar) {
                this.isPlaySeekBar = false;
                this.rt_seekl.setVisibility(8);
            } else {
                this.isPlaySeekBar = true;
                this.rt_seekl.setVisibility(0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void getDataFromOther() {
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.key = getKey();
    }

    private void findView1() {
        this.rt_seekl = (RelativeLayout) findViewById(R.id.rt_seek);
        this.textViewStart = (TextView) findViewById(R.id.textViewStart);
        this.textViewLen = (TextView) findViewById(R.id.textViewLen);
        this.playImg = (ImageView) findViewById(R.id.playback_img);
        this.layoutConnPrompt = (LinearLayout) findViewById(R.id.layout_connect_prompt);
        this.playSeekBar = (SeekBar) findViewById(R.id.playback_seekbar);
        this.textTimeStamp = (TextView) findViewById(R.id.textTimeStamp);
        this.myGlSurfaceView = (GLSurfaceView) findViewById(R.id.myhsurfaceview);
        this.mTvTakeVideo = (TextView) findViewById(R.id.tv_taking_video);
        this.mIbTakeVideo = (ImageButton) findViewById(R.id.ptz_takevideo);
        this.mIbBack = (ImageButton) findViewById(R.id.ptz_exit);
        this.mIbBack.setOnClickListener(this);
        this.mIbCalendar = (ImageButton) findViewById(R.id.ib_calendar);
        this.mIbCalendar.setOnClickListener(this);
        this.ibVoice = (ImageButton) findViewById(R.id.ptz_voice);
        this.ibVoice.setOnClickListener(this);
        this.mTvDay = (TextView) findViewById(R.id.tv_y_m_day);
        this.mIbTakeVideo.setOnClickListener(this);
        this.mRulerLayout = (LinearLayout) findViewById(R.id.lin_ruler_parent);
        this.mVideoRulerLayout = (LinearLayout) findViewById(R.id.lin_video_rule_parent);
        this.myRender = new MyRender(this.myGlSurfaceView);
        this.myGlSurfaceView.setRenderer(this.myRender);
        this.myGlSurfaceView.setVisibility(8);
        this.sfv_play = (SurfaceView) findViewById(R.id.sfv_playback);
        this.sfvHolder = this.sfv_play.getHolder();
        this.sfvHolder.addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        });
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void showBottom() {
        if (this.isShowRule) {
            this.isShowRule = false;
            this.mVideoRulerLayout.startAnimation(this.dismissAnim);
            this.dismissAnim.start();
            this.mVideoRulerLayout.setVisibility(8);
            return;
        }
        this.isShowRule = true;
        this.mVideoRulerLayout.startAnimation(this.showAnim);
        this.showAnim.start();
        this.mVideoRulerLayout.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        DialogLoading.getInstance().onDismiss();
        StopAudio();
        TakeVideoThread takeVideoThread2 = this.takeVideoThread;
        if (takeVideoThread2 != null) {
            takeVideoThread2.stopThread();
        }
        this.isTakeVideo = false;
        MyRender myRender2 = this.myRender;
        if (myRender2 != null) {
            myRender2.destroyShaders();
        }
        NUIMainActivity.setPlayBackInterface((NUIMainActivity.PlayBackInterface) null);
        NUIMainActivity.setSHIXCOMMONInterface((NUIMainActivity.SHIXCOMMONInterface) null);
        this.exit = false;
        NativeCaller.StopPlayBack(this.strDID);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.SHIX_StopVideoFiles(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        Log.d(RemoteMessageConst.Notification.TAG, "PlayBackActivity  onDestroy()");
    }

    public void onItemClick(DateVo dateVo) {
        if (dateVo.getYear() == this.f1551vo.getYear() && dateVo.getMonth() == this.f1551vo.getMonth() && dateVo.getDay() == this.f1551vo.getDay()) {
            this.forCalendar.dismiss();
        } else if (!dateVo.isHasVedio()) {
            Toast.makeText(this, getResources().getString(R.string.current_has_no_video), 0).show();
        } else {
            this.forCalendar.dismiss();
            this.key = dateVo.getYear() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.format("%02d", new Object[]{Integer.valueOf(dateVo.getMonth())}) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + dateVo.getDay();
            this.mTvDay.setText(this.key);
            this.f1551vo = dateVo;
            getVedioFile(dateVo);
        }
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

    public void callBackPlaybackVideoData(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        this.f1549i1++;
        Log.e("h264", "frametype  " + i4);
        VieoBean vieoBean = new VieoBean();
        vieoBean.setVideo(bArr);
        vieoBean.setHeigth(1080);
        vieoBean.setWidth(1920);
        vieoBean.setLen(i2);
        vieoBean.setiOrp(i4);
        this.linkedQueue.add(vieoBean);
    }

    public void callBackPlaybackAudioData(byte[] bArr, int i) {
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

    private void getVedioFile(DateVo dateVo) {
        this.calendar.set(1, dateVo.getYear());
        this.calendar.set(2, dateVo.getMonth() - 1);
        this.calendar.set(5, dateVo.getDay());
        this.calendar.set(11, 0);
        this.calendar.set(12, 0);
        this.calendar.set(13, 0);
        this.startTime = this.calendar.getTimeInMillis();
        this.calendar.set(11, 23);
        this.calendar.set(12, 59);
        this.calendar.set(13, 59);
        this.endTime = this.calendar.getTimeInMillis();
        CommonUtil.Log(1, "SHIX startTime:" + this.startTime + "  endTime:" + this.endTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(Long.valueOf(this.startTime));
        String format2 = simpleDateFormat.format(Long.valueOf(this.endTime));
        this.mTvDay.setText(format2.substring(0, 10));
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.SHIX_GetVideoFiles(SystemValue.doorBellAdmin, SystemValue.doorBellPass, format, format2), 0);
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        CommonUtil.Log(1, str2);
        try {
            this.f3989object = new JSONObject(str2);
            if (this.f3989object.has("cmd")) {
                if (this.f3989object.getString("cmd").equals("116")) {
                    JSONObject jSONObject = new JSONObject(str2);
                    Log.d("SHIX", "SHIXWIFI cmd:" + jSONObject.getInt("cmd"));
                    if (jSONObject.getInt("result") >= 0) {
                        int i = jSONObject.getInt("count");
                        if (i == 0) {
                            this.mHandler.sendEmptyMessage(4242);
                            return;
                        }
                        this.vos.clear();
                        for (int i2 = 0; i2 < i; i2++) {
                            String str3 = "name[" + i2 + "]";
                            this.tempStr = jSONObject.getString(str3);
                            this.tempStr = this.tempStr.substring(0, this.tempStr.indexOf("."));
                            this.tempStrs = this.tempStr.split("_");
                            VideoVo videoVo = new VideoVo();
                            this.tempStrs[0].substring(0, 4);
                            this.tempStrs[0].substring(4, 6);
                            this.tempStrs[0].substring(6, 8);
                            videoVo.setFileName(str3);
                            videoVo.setStartTime(VideoVo.str2TimeStamp(this.tempStrs[0], this.tempStrs[1]));
                            videoVo.setDuration(Long.parseLong(this.tempStrs[2]) * 1000);
                            if (this.tempStrs[4].equals("m")) {
                                videoVo.setAlarm(true);
                            } else {
                                videoVo.setAlarm(false);
                            }
                            this.vos.add(videoVo);
                        }
                        this.mHandler.sendEmptyMessage(5321);
                    }
                } else if (this.f3989object.getInt("cmd") == 211) {
                    this.fos = openFileOutput("", 0);
                    this.fileName = getFilesDir().getAbsolutePath() + File.separator + "";
                } else if (this.f3989object.getInt("cmd") == 115) {
                    int i3 = this.f3989object.getInt("count");
                    VideoVo.clearDate();
                    for (int i4 = 0; i4 < i3; i4++) {
                        this.tempStr = this.f3989object.getString("date[" + i4 + "]");
                        VideoVo.addDate(this.tempStr);
                    }
                    this.mHandler.sendEmptyMessage(1024);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    private String getKey() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /* access modifiers changed from: private */
    public void startVideoFile() {
        Log.e("play back", "calendar ---------");
        List<VideoVo> list = this.vos;
        if (list == null || list.size() <= 1) {
            Toast.makeText(this, getResources().getString(R.string.current_has_no_video), 0).show();
            return;
        }
        this.strFilePath = this.vos.get(1).getFileName();
        NativeCaller.StartPlayBack(this.strDID, this.strFilePath, 0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        NUIMainActivity.setPlayBackInterface(this);
        this.videoRulerView.setCurrentIime(this.vos.get(1).getStartTime());
        NativeCaller.TransferMessage(this.strDID, CommonUtil.SHIX_StartVideoFiles(SystemValue.doorBellAdmin, SystemValue.doorBellPass, simpleDateFormat.format(Long.valueOf(this.vos.get(1).getStartTime()))), 0);
    }
}
