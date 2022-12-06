package shix.ihdbell.project;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.audiofx.AcousticEchoCanceler;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.MKEvent;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tzh.ipcamera.model.CustomBuffer;
import com.tzh.ipcamera.model.CustomBufferData;
import com.tzh.ipcamera.model.CustomBufferHead;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.AudioPlayer;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.CustomAudioRecorder;
import object.p2pipcam.utils.DataBaseHelper;
import object.p2pipcam.utils.TakeVideoThread;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

@SuppressLint({"Wakelock", "NewApi"})
public class ListeningPlayActivity extends BaseActivity implements GestureDetector.OnGestureListener, CustomAudioRecorder.AudioRecordResult, GestureDetector.OnDoubleTapListener, BridgeService.PlayInterface, BridgeService.DateTimeInterface, View.OnTouchListener, BridgeService.DoorBellSystemParmInterface, View.OnClickListener {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    private static final int DRAG = 1;
    private static final String LOG_TAG = "PlayActivity";
    private static final int NONE = 0;
    private static final int ZOOM = 2;
    private CustomBuffer AudioBuffer = null;
    /* access modifiers changed from: private */
    public int AudioOrTalkType = 2;
    private final int CANCELTIME = 1230;
    private final int CANCELTIMEFINISH = 1231;
    private int CLickType = 0;
    private final int MINLEN = 80;
    private Bitmap OneBitmap;
    private final int RESETTIME = 1232;
    private AnimationDrawable animationDrawable;
    private AudioPlayer audioPlayer = null;
    private long availableBlocks;
    private boolean bAudioRecordStart = false;
    private boolean bAudioStart = true;
    /* access modifiers changed from: private */
    public boolean bDisplayFinished = true;
    float baseValue;
    private boolean bl_doorbell_sound = false;
    private long blockSize;
    private Button btn_cancel;
    private Button btn_create;
    private ImageButton btn_doorbell_cancel;
    private ImageButton btn_doorbell_hz;
    private ImageButton btn_doorbell_pic;
    private ImageButton btn_doorbell_say;
    /* access modifiers changed from: private */
    public ImageButton btn_doorbell_video;
    private ImageButton btn_doorbell_vq;
    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_delet;
    /* access modifiers changed from: private */
    public Button button_mode_mic;
    /* access modifiers changed from: private */
    public Button button_mode_on;
    private Button button_reset;
    private LinearLayout button_say;
    /* access modifiers changed from: private */
    public int cancelTime = 60;
    private CustomAudioRecorder customAudioRecorder = null;
    float density;
    private EditText editText_GroupName_pass;
    private LinearLayout framLayout2;
    private FrameLayout framelayoutplay;
    private DataBaseHelper helper;
    /* access modifiers changed from: private */
    public int isAudioOne;
    /* access modifiers changed from: private */
    public boolean isCancel = false;
    private boolean isDown = false;
    /* access modifiers changed from: private */
    public boolean isH264 = false;
    /* access modifiers changed from: private */
    public int isH264Data = 0;
    private boolean isHigthVideo;
    /* access modifiers changed from: private */
    public boolean isOneShow = true;
    /* access modifiers changed from: private */
    public boolean isPictSave = false;
    private boolean isRunSendAudio = false;
    private boolean isSecondDown = false;
    /* access modifiers changed from: private */
    public boolean isTakeVideo = false;
    /* access modifiers changed from: private */
    public boolean isTakepic = false;
    private boolean isVGA = false;
    /* access modifiers changed from: private */
    public boolean istagShow = false;
    /* access modifiers changed from: private */
    public LinearLayout layout_videoing = null;
    private String lockPwd = "";
    private LinearLayout ly_doorbell_sound;
    protected Matrix mBaseMatrix = new Matrix();
    /* access modifiers changed from: private */
    public Bitmap mBmp;
    private Matrix mDisplayMatrix = new Matrix();
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date(System.currentTimeMillis()));
                if (ListeningPlayActivity.this.isOneShow) {
                    ListeningPlayActivity.this.progressView.setVisibility(4);
                    ListeningPlayActivity.this.osdView.setVisibility(0);
                    ListeningPlayActivity.this.vidoeView.setVisibility(8);
                    ListeningPlayActivity.this.myGlSurfaceView.setVisibility(0);
                    boolean unused = ListeningPlayActivity.this.isOneShow = false;
                }
                ListeningPlayActivity.this.textTimeStamp.setText(format);
                ListeningPlayActivity.this.myGlSurfaceView.setLayoutParams(new FrameLayout.LayoutParams(ListeningPlayActivity.this.width, (ListeningPlayActivity.this.width * 3) / 4));
                ListeningPlayActivity.this.myRender.writeSample(ListeningPlayActivity.this.videodata, ListeningPlayActivity.this.nVideoWidth, ListeningPlayActivity.this.nVideoHeight);
                boolean unused2 = ListeningPlayActivity.this.bDisplayFinished = true;
            } else if (i == 2) {
                String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date(System.currentTimeMillis()));
                if (ListeningPlayActivity.this.isOneShow) {
                    ListeningPlayActivity.this.progressView.setVisibility(4);
                    ListeningPlayActivity.this.osdView.setVisibility(0);
                    boolean unused3 = ListeningPlayActivity.this.isOneShow = false;
                }
                ListeningPlayActivity.this.textTimeStamp.setText(format2);
                ListeningPlayActivity listeningPlayActivity = ListeningPlayActivity.this;
                Bitmap unused4 = listeningPlayActivity.mBmp = BitmapFactory.decodeByteArray(listeningPlayActivity.videodata, 0, ListeningPlayActivity.this.videoDataLen);
                if (ListeningPlayActivity.this.mBmp == null) {
                    Log.d(ListeningPlayActivity.LOG_TAG, "bmp can't be decode...");
                    boolean unused5 = ListeningPlayActivity.this.bDisplayFinished = true;
                    return;
                }
                ListeningPlayActivity listeningPlayActivity2 = ListeningPlayActivity.this;
                int unused6 = listeningPlayActivity2.nVideoWidth = listeningPlayActivity2.mBmp.getWidth();
                ListeningPlayActivity listeningPlayActivity3 = ListeningPlayActivity.this;
                int unused7 = listeningPlayActivity3.nVideoHeight = listeningPlayActivity3.mBmp.getHeight();
                ListeningPlayActivity listeningPlayActivity4 = ListeningPlayActivity.this;
                Bitmap unused8 = listeningPlayActivity4.mBmp = Bitmap.createScaledBitmap(listeningPlayActivity4.mBmp, ListeningPlayActivity.this.width, (ListeningPlayActivity.this.width * 3) / 4, true);
                ListeningPlayActivity.this.vidoeView.setVisibility(0);
                ListeningPlayActivity.this.vidoeView.setImageBitmap(ListeningPlayActivity.this.mBmp);
                if (ListeningPlayActivity.this.isTakepic) {
                    boolean unused9 = ListeningPlayActivity.this.isTakepic = false;
                    ListeningPlayActivity listeningPlayActivity5 = ListeningPlayActivity.this;
                    listeningPlayActivity5.takePicture(listeningPlayActivity5.mBmp);
                }
                boolean unused10 = ListeningPlayActivity.this.bDisplayFinished = true;
            } else if (i != 3) {
                switch (i) {
                    case 1231:
                        boolean unused11 = ListeningPlayActivity.this.isCancel = false;
                        new AsyncTask<Void, Void, Void>() {
                            /* access modifiers changed from: protected */
                            public void onPreExecute() {
                                if (ListeningPlayActivity.this.pushTypeInt != 3) {
                                    ListeningPlayActivity.this.sendBroadcast(new Intent("back"));
                                }
                            }

                            /* access modifiers changed from: protected */
                            public Void doInBackground(Void... voidArr) {
                                if (ListeningPlayActivity.this.myRender != null) {
                                    ListeningPlayActivity.this.myRender.destroyShaders();
                                }
                                boolean unused = ListeningPlayActivity.this.isTakeVideo = false;
                                try {
                                    Thread.sleep(100);
                                    return null;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }

                            /* access modifiers changed from: protected */
                            public void onPostExecute(Void voidR) {
                                ListeningPlayActivity.this.finish();
                                ListeningPlayActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                            }
                        }.execute(new Void[0]);
                        return;
                    case 1232:
                        if (ListeningPlayActivity.this.resettime < 30) {
                            int unused12 = ListeningPlayActivity.this.resettime = 30;
                        }
                        ListeningPlayActivity listeningPlayActivity6 = ListeningPlayActivity.this;
                        int unused13 = listeningPlayActivity6.cancelTime = listeningPlayActivity6.resettime;
                        return;
                    default:
                        return;
                }
            } else if (ListeningPlayActivity.this.modeHz == 0) {
                ListeningPlayActivity.this.ptz_50_60.setText("50Hz");
            } else {
                ListeningPlayActivity.this.ptz_50_60.setText("60Hz");
            }
        }
    };
    private final float[] mMatrixValues = new float[9];
    float mMaxZoom = 2.0f;
    float mMinZoom = 0.3125f;
    protected Matrix mSuppMatrix = new Matrix();
    private Matrix matrix = new Matrix();
    /* access modifiers changed from: private */
    public int micType;
    private PointF mid = new PointF();
    private int mode = 0;
    /* access modifiers changed from: private */
    public int modeHz = 0;
    /* access modifiers changed from: private */
    public GLSurfaceView myGlSurfaceView = null;
    /* access modifiers changed from: private */
    public MyRender myRender = null;
    /* access modifiers changed from: private */
    public int nVideoHeight = 0;
    /* access modifiers changed from: private */
    public int nVideoWidth = 0;
    private float oldDist;
    float originalScale;
    /* access modifiers changed from: private */
    public View osdView = null;
    private int p2pMode = 1;
    private File path = null;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_group;
    private View popv_group;
    private int position = 0;
    private SharedPreferences preAudio;
    private SharedPreferences preuser;
    /* access modifiers changed from: private */
    public View progressView = null;
    private View ptzOtherSetAnimView;
    /* access modifiers changed from: private */
    public Button ptz_50_60;
    /* access modifiers changed from: private */
    public int pushTypeInt = 0;
    /* access modifiers changed from: private */
    public String pushUUID = PushConstants.PUSH_TYPE_NOTIFY;
    /* access modifiers changed from: private */
    public int resettime = 20;
    private int samper = 8000;
    private Matrix savedMatrix = new Matrix();
    Animation shake = null;
    private PointF start = new PointF();
    private StatFs stat;
    /* access modifiers changed from: private */
    public String strDID = null;
    private String strName = null;
    private StringBuffer stringBuffer;
    /* access modifiers changed from: private */
    public TakeVideoThread takeVideoThread = null;
    /* access modifiers changed from: private */
    public TextView textTimeStamp = null;
    private TextView textViewVideoing;
    private TextView textView_show;
    private TextView textosd = null;
    private long time;
    private long time1;
    private int timeCount = 0;
    private TextView tv_cancel_time = null;
    private TextView tv_show_talk;
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    /* access modifiers changed from: private */
    public byte[] videodata = null;
    /* access modifiers changed from: private */
    public ImageView vidoeView;
    PowerManager.WakeLock wakeLock = null;
    /* access modifiers changed from: private */
    public int width;
    private float x1 = 0.0f;
    private float x2 = 0.0f;
    private float y1 = 0.0f;
    private float y2 = 0.0f;

    public void callBackDatetimeParams(String str, int i, int i2, int i3, String str2) {
    }

    public void callBackSetSystemParamsResult(String str, int i, int i2) {
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
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

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    static /* synthetic */ int access$310(ListeningPlayActivity listeningPlayActivity) {
        int i = listeningPlayActivity.cancelTime;
        listeningPlayActivity.cancelTime = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    public void returnLastBmp2Home() {
        new Thread() {
            public void run() {
                if (ListeningPlayActivity.this.isH264) {
                    byte[] bArr = new byte[(ListeningPlayActivity.this.nVideoWidth * ListeningPlayActivity.this.nVideoHeight * 2)];
                    NativeCaller.YUV4202RGB565(ListeningPlayActivity.this.videodata, bArr, ListeningPlayActivity.this.nVideoWidth, ListeningPlayActivity.this.nVideoHeight);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    ListeningPlayActivity listeningPlayActivity = ListeningPlayActivity.this;
                    Bitmap unused = listeningPlayActivity.mBmp = Bitmap.createBitmap(listeningPlayActivity.nVideoWidth, ListeningPlayActivity.this.nVideoHeight, Bitmap.Config.RGB_565);
                    ListeningPlayActivity.this.mBmp.copyPixelsFromBuffer(wrap);
                }
                if (ListeningPlayActivity.this.mBmp != null) {
                    int width = ListeningPlayActivity.this.mBmp.getWidth();
                    int height = ListeningPlayActivity.this.mBmp.getHeight();
                    Matrix matrix = new Matrix();
                    matrix.postScale(100.0f / ((float) width), 80.0f / ((float) height));
                    Bitmap createBitmap = Bitmap.createBitmap(ListeningPlayActivity.this.mBmp, 0, 0, width, height, matrix, true);
                    File file = new File(Environment.getExternalStorageDirectory(), "LittleStars/picid");
                    File file2 = new File(file, ListeningPlayActivity.this.strDID + ".jpg");
                    if (file2.exists()) {
                        Log.d("first_pic", file2.delete() + "");
                    }
                    ListeningPlayActivity listeningPlayActivity2 = ListeningPlayActivity.this;
                    listeningPlayActivity2.UpdataBitmp(listeningPlayActivity2.strDID, createBitmap);
                    ListeningPlayActivity listeningPlayActivity3 = ListeningPlayActivity.this;
                    listeningPlayActivity3.saveBmpToSDcard(listeningPlayActivity3.strDID, createBitmap);
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void saveBmpToSDcard(String str, Bitmap bitmap) {
        File file = new File(Environment.getExternalStorageDirectory(), "LittleStars/picid");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            File file2 = new File(file, str + ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
                Cursor queryFirstpic = this.helper.queryFirstpic(str);
                if (queryFirstpic.getCount() <= 0) {
                    this.helper.addFirstpic(str, file2.getAbsolutePath());
                }
                if (queryFirstpic != null) {
                    queryFirstpic.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        boolean z = this.isTakeVideo;
        return true;
    }

    /* access modifiers changed from: private */
    public void takePicture(final Bitmap bitmap) {
        if (!this.isPictSave) {
            this.isPictSave = true;
            new Thread() {
                public void run() {
                    ListeningPlayActivity.this.savePicToSDcard(bitmap);
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0140 A[SYNTHETIC, Splitter:B:45:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0148 A[SYNTHETIC, Splitter:B:49:0x0148] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0151 A[SYNTHETIC, Splitter:B:56:0x0151] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0103=Splitter:B:27:0x0103, B:32:0x010a=Splitter:B:32:0x010a, B:53:0x014d=Splitter:B:53:0x014d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void savePicToSDcard(android.graphics.Bitmap r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = r9.getStrDate()     // Catch:{ all -> 0x015a }
            java.lang.String r1 = "savePicToSDcard"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            r2.<init>()     // Catch:{ all -> 0x015a }
            java.lang.String r3 = "genghuai savePicToSDcard11:"
            r2.append(r3)     // Catch:{ all -> 0x015a }
            r2.append(r0)     // Catch:{ all -> 0x015a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x015a }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x015a }
            r1 = 10
            r2 = 0
            java.lang.String r3 = r0.substring(r2, r1)     // Catch:{ all -> 0x015a }
            java.lang.String r4 = "savePicToSDcard"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            r5.<init>()     // Catch:{ all -> 0x015a }
            java.lang.String r6 = "genghuai savePicToSDcard22:"
            r5.append(r6)     // Catch:{ all -> 0x015a }
            r5.append(r3)     // Catch:{ all -> 0x015a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x015a }
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x015a }
            object.p2pipcam.utils.DataBaseHelper r4 = r9.helper     // Catch:{ all -> 0x015a }
            java.lang.String r5 = r9.strDID     // Catch:{ all -> 0x015a }
            android.database.Cursor r4 = r4.queryAllPicture(r5)     // Catch:{ all -> 0x015a }
            r5 = 0
        L_0x0041:
            boolean r6 = r4.moveToNext()     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x006e
            java.lang.String r6 = "filepath"
            int r6 = r4.getColumnIndex(r6)     // Catch:{ all -> 0x015a }
            java.lang.String r6 = r4.getString(r6)     // Catch:{ all -> 0x015a }
            java.lang.String r7 = "/"
            int r7 = r6.lastIndexOf(r7)     // Catch:{ all -> 0x015a }
            int r7 = r7 + 1
            java.lang.String r6 = r6.substring(r7)     // Catch:{ all -> 0x015a }
            java.lang.String r6 = r6.substring(r2, r1)     // Catch:{ all -> 0x015a }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x015a }
            boolean r6 = r6.equals(r3)     // Catch:{ all -> 0x015a }
            if (r6 == 0) goto L_0x0041
            int r5 = r5 + 1
            goto L_0x0041
        L_0x006e:
            r1 = 500(0x1f4, float:7.0E-43)
            if (r5 < r1) goto L_0x007c
            shix.ihdbell.project.ListeningPlayActivity$4 r10 = new shix.ihdbell.project.ListeningPlayActivity$4     // Catch:{ all -> 0x015a }
            r10.<init>()     // Catch:{ all -> 0x015a }
            r9.runOnUiThread(r10)     // Catch:{ all -> 0x015a }
            monitor-exit(r9)
            return
        L_0x007c:
            if (r4 == 0) goto L_0x0081
            r4.close()     // Catch:{ all -> 0x015a }
        L_0x0081:
            object.p2pipcam.utils.DataBaseHelper r1 = r9.helper     // Catch:{ all -> 0x015a }
            java.lang.String r3 = r9.strDID     // Catch:{ all -> 0x015a }
            java.lang.String r4 = "picture"
            android.database.Cursor r1 = r1.queryVideoOrPictureByDate(r3, r0, r4)     // Catch:{ all -> 0x015a }
            int r3 = r1.getCount()     // Catch:{ all -> 0x015a }
            int r3 = r3 + 1
            r4 = 0
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0116 }
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r7 = "LittleStars/LittleStars"
            r5.<init>(r6, r7)     // Catch:{ Exception -> 0x0116 }
            boolean r6 = r5.exists()     // Catch:{ Exception -> 0x0116 }
            if (r6 != 0) goto L_0x00a6
            r5.mkdirs()     // Catch:{ Exception -> 0x0116 }
        L_0x00a6:
            java.lang.String r6 = "test"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0116 }
            r7.<init>()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r8 = "savePicToSDcard playdiv:"
            r7.append(r8)     // Catch:{ Exception -> 0x0116 }
            r7.append(r5)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0116 }
            android.util.Log.d(r6, r7)     // Catch:{ Exception -> 0x0116 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0116 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0116 }
            r7.<init>()     // Catch:{ Exception -> 0x0116 }
            r7.append(r0)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r8 = "_="
            r7.append(r8)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r8 = r9.strDID     // Catch:{ Exception -> 0x0116 }
            r7.append(r8)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r8 = "!"
            r7.append(r8)     // Catch:{ Exception -> 0x0116 }
            r7.append(r3)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r3 = "_.jpg"
            r7.append(r3)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x0116 }
            r6.<init>(r5, r3)     // Catch:{ Exception -> 0x0116 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0116 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0116 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            r5 = 100
            boolean r10 = r10.compress(r4, r5, r3)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            if (r10 == 0) goto L_0x0103
            r3.flush()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            object.p2pipcam.utils.DataBaseHelper r10 = r9.helper     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.lang.String r4 = r9.strDID     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.lang.String r5 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x0111, all -> 0x010e }
            java.lang.String r6 = "picture"
            r10.createVideoOrPic(r4, r5, r6, r0)     // Catch:{ Exception -> 0x0111, all -> 0x010e }
        L_0x0103:
            r9.isPictSave = r2     // Catch:{ all -> 0x015a }
            r3.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x0146
        L_0x0109:
            r10 = move-exception
        L_0x010a:
            r10.printStackTrace()     // Catch:{ all -> 0x015a }
            goto L_0x0146
        L_0x010e:
            r10 = move-exception
            r4 = r3
            goto L_0x014d
        L_0x0111:
            r10 = move-exception
            r4 = r3
            goto L_0x0117
        L_0x0114:
            r10 = move-exception
            goto L_0x014d
        L_0x0116:
            r10 = move-exception
        L_0x0117:
            shix.ihdbell.project.ListeningPlayActivity$5 r0 = new shix.ihdbell.project.ListeningPlayActivity$5     // Catch:{ all -> 0x0114 }
            r0.<init>()     // Catch:{ all -> 0x0114 }
            r9.runOnUiThread(r0)     // Catch:{ all -> 0x0114 }
            java.lang.String r0 = "tag"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
            r3.<init>()     // Catch:{ all -> 0x0114 }
            java.lang.String r5 = "exception:"
            r3.append(r5)     // Catch:{ all -> 0x0114 }
            java.lang.String r5 = r10.getMessage()     // Catch:{ all -> 0x0114 }
            r3.append(r5)     // Catch:{ all -> 0x0114 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0114 }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x0114 }
            r10.printStackTrace()     // Catch:{ all -> 0x0114 }
            r9.isPictSave = r2     // Catch:{ all -> 0x015a }
            if (r4 == 0) goto L_0x0146
            r4.close()     // Catch:{ IOException -> 0x0144 }
            goto L_0x0146
        L_0x0144:
            r10 = move-exception
            goto L_0x010a
        L_0x0146:
            if (r1 == 0) goto L_0x014b
            r1.close()     // Catch:{ all -> 0x015a }
        L_0x014b:
            monitor-exit(r9)
            return
        L_0x014d:
            r9.isPictSave = r2     // Catch:{ all -> 0x015a }
            if (r4 == 0) goto L_0x0159
            r4.close()     // Catch:{ IOException -> 0x0155 }
            goto L_0x0159
        L_0x0155:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x015a }
        L_0x0159:
            throw r10     // Catch:{ all -> 0x015a }
        L_0x015a:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x015e
        L_0x015d:
            throw r10
        L_0x015e:
            goto L_0x015d
        */
        throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.ListeningPlayActivity.savePicToSDcard(android.graphics.Bitmap):void");
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(new Date());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        getWindow().getAttributes().flags |= 524288;
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.acquire();
        }
        if (MainActivity.keyguardLock != null) {
            MainActivity.keyguardLock.disableKeyguard();
        }
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public void onPreExecute() {
                if (ListeningPlayActivity.this.pushTypeInt != 3) {
                    ListeningPlayActivity.this.sendBroadcast(new Intent("back"));
                }
            }

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                if (ListeningPlayActivity.this.myRender != null) {
                    ListeningPlayActivity.this.myRender.destroyShaders();
                }
                boolean unused = ListeningPlayActivity.this.isTakeVideo = false;
                return null;
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Void voidR) {
                ListeningPlayActivity.this.finish();
                ListeningPlayActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        }.execute(new Void[0]);
        super.onPause();
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.preAudio = getSharedPreferences("shix_zhao_audio", 0);
        getDataFromOther();
        getWindow().setFlags(128, 128);
        requestWindowFeature(1);
        setContentView(R.layout.listening_play1111);
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(268435466, "MyWakeLock");
        this.helper = DataBaseHelper.getInstance(this);
        this.isHigthVideo = false;
        findView();
        InitParams();
        BridgeService.setDateTimeInterface(this);
        BridgeService.setPlayInterface(this);
        BridgeService.setDoorBellSystemParmInterface(this);
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this, this.AudioBuffer);
        this.customAudioRecorder = new CustomAudioRecorder(this);
        this.path = Environment.getExternalStorageDirectory();
        this.myRender = new MyRender(this.myGlSurfaceView);
        this.myGlSurfaceView.setRenderer(this.myRender);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.cancelTime = 60;
        this.resettime = 21;
        this.density = displayMetrics.density;
        this.width = displayMetrics.widthPixels;
        if (getResources().getConfiguration().orientation == 1) {
            if (this.width < 480) {
                ViewGroup.LayoutParams layoutParams = this.vidoeView.getLayoutParams();
                layoutParams.height = 150;
                layoutParams.width = MKEvent.ERROR_LOCATION_FAILED;
                this.vidoeView.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.vidoeView.getLayoutParams();
                layoutParams2.height = (this.width * 3) / 4;
                this.vidoeView.setLayoutParams(layoutParams2);
            }
        }
        Log.d("test", "----width:" + this.width);
        doorBellOtherView();
        this.bAudioRecordStart = true;
        this.bAudioStart = true;
        NativeCaller.PPPPGetSystemParams(this.strDID, 4);
        NativeCaller.PPPPGetSystemParams(this.strDID, 2);
        if (getResources().getConfiguration().orientation == 1) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            this.density = displayMetrics2.density;
            this.width = displayMetrics2.widthPixels;
            Log.d("test", "----width:" + this.width);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.addRule(3, R.id.framelayoutplay);
            this.ptzOtherSetAnimView.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.addRule(3, R.id.osdlayout);
            this.framelayoutplay.setPadding(0, 0, 0, 0);
            this.framelayoutplay.setLayoutParams(layoutParams4);
            int i = this.width;
            if (i < 480) {
                ViewGroup.LayoutParams layoutParams5 = this.vidoeView.getLayoutParams();
                layoutParams5.height = 150;
                layoutParams5.width = MKEvent.ERROR_LOCATION_FAILED;
                this.vidoeView.setLayoutParams(layoutParams5);
            } else {
                this.vidoeView.setLayoutParams(new FrameLayout.LayoutParams(-1, (i * 3) / 4));
            }
        } else {
            DisplayMetrics displayMetrics3 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics3);
            this.density = displayMetrics3.density;
            this.width = displayMetrics3.widthPixels;
            ViewGroup.LayoutParams layoutParams6 = this.framelayoutplay.getLayoutParams();
            layoutParams6.height = (((int) (((float) this.width) - (displayMetrics3.density * 300.0f))) * 3) / 4;
            layoutParams6.width = (int) (((float) this.width) - (displayMetrics3.density * 300.0f));
            this.framelayoutplay.setLayoutParams(layoutParams6);
            this.framelayoutplay.setPadding((int) (displayMetrics3.density * 10.0f), 0, 0, (int) (displayMetrics.density * 10.0f));
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams7.addRule(1, R.id.framelayoutplay);
            layoutParams7.addRule(3, R.id.osdlayout);
            this.ptzOtherSetAnimView.setLayoutParams(layoutParams7);
        }
        NativeCaller.TransferMessage(this.strDID, "get_bell_config.cgi?&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
        this.isCancel = true;
        if (this.isOneShow && this.OneBitmap != null) {
            this.vidoeView.setVisibility(0);
            this.vidoeView.setImageBitmap(this.OneBitmap);
        }
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        SharedPreferences sharedPreferences = this.preuser;
        this.lockPwd = sharedPreferences.getString(this.strDID + "lockpwd", "123456");
        initExitPopupWindow_Group();
        SharedPreferences sharedPreferences2 = this.preuser;
        this.CLickType = sharedPreferences2.getInt(this.strDID + "ClickType", 1);
        StartAudio();
        NativeCaller.StartPPPPLivestream(this.strDID, 41, this.pushUUID, SystemValue.videFram);
    }

    private void doorBellOtherView() {
        this.shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        this.btn_doorbell_pic = (ImageButton) findViewById(R.id.btn_doorbell_pic);
        this.btn_doorbell_pic.setOnTouchListener(this);
        this.btn_doorbell_vq = (ImageButton) findViewById(R.id.btn_doorbell_vq);
        this.btn_doorbell_vq.setOnTouchListener(this);
        this.btn_doorbell_say = (ImageButton) findViewById(R.id.btn_doorbell_say);
        this.btn_doorbell_say.setOnTouchListener(this);
        this.btn_doorbell_video = (ImageButton) findViewById(R.id.btn_doorbell_video);
        this.btn_doorbell_video.setOnTouchListener(this);
        this.btn_doorbell_hz = (ImageButton) findViewById(R.id.btn_doorbell_hz);
        this.btn_doorbell_hz.setOnTouchListener(this);
        this.btn_doorbell_cancel = (ImageButton) findViewById(R.id.btn_doorbell_cancel);
        this.btn_doorbell_cancel.setOnTouchListener(this);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        if (intent != null) {
            this.OneBitmap = (Bitmap) intent.getParcelableExtra(ContentCommon.STR_CAMERA_SNAPSHOT);
            this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
            this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
            this.pushTypeInt = intent.getIntExtra("pushTypeInt", 3);
            this.pushUUID = intent.getStringExtra("pushUUID");
            this.p2pMode = intent.getIntExtra("modep", 1);
            SharedPreferences sharedPreferences = this.preAudio;
            this.AudioOrTalkType = sharedPreferences.getInt(this.strDID + "audiotalktype", 2);
            this.samper = intent.getIntExtra("samper", 8000);
            CommonUtil.Log(1, "samper:" + this.samper);
            String str = this.pushUUID;
            if (str == null || str.length() < 1) {
                this.pushUUID = (((int) (Math.random() * 900.0d)) + 100) + "";
            }
            if (this.strDID.length() <= 3) {
                return;
            }
            if (this.pushTypeInt == 3) {
                NativeCaller.StartPPPPLivestream(this.strDID, 20, this.pushUUID, SystemValue.videFram);
            } else {
                NativeCaller.StartPPPPLivestream(this.strDID, 22, this.pushUUID, SystemValue.videFram);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        StopHeat();
        super.onStop();
    }

    private void InitParams() {
        this.textosd.setText(this.strName);
    }

    /* access modifiers changed from: private */
    public void StartAudio() {
        synchronized (this) {
            this.bAudioStart = true;
            this.AudioBuffer.ClearAll();
            if (this.audioPlayer != null) {
                Log.e(LOG_TAG, "###start play audio222");
                this.audioPlayer.AudioPlayStart();
            }
            NativeCaller.PPPPStartAudio(this.strDID);
        }
    }

    /* access modifiers changed from: private */
    public void StopAudio() {
        synchronized (this) {
            this.bAudioStart = false;
            if (this.audioPlayer != null) {
                Log.e(LOG_TAG, "###stop play audio222");
                this.audioPlayer.AudioPlayStop();
            }
            this.AudioBuffer.ClearAll();
            NativeCaller.PPPPStopAudio(this.strDID);
        }
    }

    /* access modifiers changed from: private */
    public void StartTalk() {
        int i = this.AudioOrTalkType;
        if (i == 0 || i == 1) {
            NativeCaller.PPPPStartTalk(this.strDID);
            return;
        }
        CustomAudioRecorder customAudioRecorder2 = this.customAudioRecorder;
        if (customAudioRecorder2 != null) {
            customAudioRecorder2.StartRecord();
            NativeCaller.PPPPStartTalk(this.strDID);
        }
    }

    private void releaseTalk() {
        CustomAudioRecorder customAudioRecorder2;
        int i = this.AudioOrTalkType;
        if (i != 0 && i != 1 && (customAudioRecorder2 = this.customAudioRecorder) != null) {
            customAudioRecorder2.releaseRecord();
        }
    }

    private void StopTalk() {
        int i = this.AudioOrTalkType;
        if (i == 0 || i == 1) {
            NativeCaller.PPPPStopTalk(this.strDID);
            return;
        }
        CustomAudioRecorder customAudioRecorder2 = this.customAudioRecorder;
        if (customAudioRecorder2 != null) {
            customAudioRecorder2.StopRecord();
            NativeCaller.PPPPStopTalk(this.strDID);
        }
    }

    /* access modifiers changed from: protected */
    public void setResolution(int i) {
        Log.d("tag", "setResolution resolution:" + i);
        NativeCaller.PPPPCameraControl(this.strDID, 0, i);
        NativeCaller.PPPPGetSystemParams(this.strDID, 2);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    private void findView() {
        this.micType = 1;
        this.ptz_50_60 = (Button) findViewById(R.id.button_mode_hz);
        this.ptz_50_60.setOnClickListener(this);
        this.layout_videoing = (LinearLayout) findViewById(R.id.video_lu_linear);
        this.myGlSurfaceView = (GLSurfaceView) findViewById(R.id.myhsurfaceview);
        this.textViewVideoing = (TextView) findViewById(R.id.textTimevideoing);
        this.ptzOtherSetAnimView = findViewById(R.id.ptz_othersetview_anim);
        this.button_say = (LinearLayout) findViewById(R.id.button_say);
        this.tv_show_talk = (TextView) findViewById(R.id.tv_show_talk);
        this.button_say.setOnTouchListener(this);
        this.button_say.setVisibility(0);
        this.vidoeView = (ImageView) findViewById(R.id.vedioview);
        this.progressView = findViewById(R.id.progressLayout);
        this.textosd = (TextView) findViewById(R.id.textosd);
        this.textTimeStamp = (TextView) findViewById(R.id.textTimeStamp);
        this.osdView = findViewById(R.id.osdlayout);
        this.tv_cancel_time = (TextView) findViewById(R.id.tv_cancel_time);
        this.tv_cancel_time.setVisibility(4);
        this.framelayoutplay = (FrameLayout) findViewById(R.id.framelayoutplay);
        this.button_mode_on = (Button) findViewById(R.id.button_mode_on);
        this.isAudioOne = 1;
        NativeCaller.PPPPCameraControl(this.strDID, 101, this.isAudioOne);
        this.button_mode_on.setText(R.string.play_mode_1);
        this.button_mode_mic = (Button) findViewById(R.id.button_mode_mic);
        this.button_mode_mic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ListeningPlayActivity.this.micType == 1) {
                    int unused = ListeningPlayActivity.this.micType = 2;
                    ListeningPlayActivity.this.button_mode_mic.setText("MIC 2");
                } else {
                    int unused2 = ListeningPlayActivity.this.micType = 1;
                    ListeningPlayActivity.this.button_mode_mic.setText("MIC 1");
                }
                ListeningPlayActivity.this.StopAudio();
                ListeningPlayActivity.this.StartAudio();
            }
        });
        this.button_mode_on.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ListeningPlayActivity.this.isAudioOne == 1) {
                    int unused = ListeningPlayActivity.this.isAudioOne = 3;
                    ListeningPlayActivity.this.button_mode_on.setText(R.string.play_mode_3);
                } else {
                    int unused2 = ListeningPlayActivity.this.isAudioOne = 1;
                    ListeningPlayActivity.this.button_mode_on.setText(R.string.play_mode_1);
                }
                NativeCaller.PPPPCameraControl(ListeningPlayActivity.this.strDID, 101, ListeningPlayActivity.this.isAudioOne);
            }
        });
    }

    private boolean isDevSupport() {
        return AcousticEchoCanceler.isAvailable();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 1) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.density = displayMetrics.density;
            this.width = displayMetrics.widthPixels;
            Log.d("test", "----width:" + this.width);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.framelayoutplay);
            this.ptzOtherSetAnimView.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(3, R.id.osdlayout);
            this.framelayoutplay.setPadding(0, 0, 0, 0);
            this.framelayoutplay.setLayoutParams(layoutParams2);
            int i = this.width;
            if (i < 480) {
                ViewGroup.LayoutParams layoutParams3 = this.vidoeView.getLayoutParams();
                layoutParams3.height = 150;
                layoutParams3.width = MKEvent.ERROR_LOCATION_FAILED;
                this.vidoeView.setLayoutParams(layoutParams3);
            } else {
                this.vidoeView.setLayoutParams(new FrameLayout.LayoutParams(-1, (i * 3) / 4));
            }
        } else {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            this.density = displayMetrics2.density;
            this.width = displayMetrics2.widthPixels;
            ViewGroup.LayoutParams layoutParams4 = this.framelayoutplay.getLayoutParams();
            layoutParams4.height = (((int) (((float) this.width) - (displayMetrics2.density * 300.0f))) * 3) / 4;
            layoutParams4.width = (int) (((float) this.width) - (displayMetrics2.density * 300.0f));
            this.framelayoutplay.setLayoutParams(layoutParams4);
            this.framelayoutplay.setPadding((int) (displayMetrics2.density * 10.0f), 0, 0, (int) (displayMetrics2.density * 10.0f));
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams5.addRule(1, R.id.framelayoutplay);
            layoutParams5.addRule(3, R.id.osdlayout);
            this.ptzOtherSetAnimView.setLayoutParams(layoutParams5);
        }
        if (this.isOneShow && this.OneBitmap != null) {
            this.vidoeView.setVisibility(0);
            this.vidoeView.setImageBitmap(this.OneBitmap);
        }
    }

    private boolean existSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* access modifiers changed from: protected */
    public void zoomTo(float f, float f2, float f3) {
        Log.d("zoomTo", "zoomTo scale:" + f);
        float f4 = this.mMaxZoom;
        if (f <= f4) {
            f4 = this.mMinZoom;
            if (f >= f4) {
                f4 = f;
            }
        }
        float scale = f4 / getScale();
        Log.d("deltaScale", "deltaScale:" + scale);
        this.mSuppMatrix.postScale(scale, scale, f2, f3);
    }

    /* access modifiers changed from: protected */
    public Matrix getImageViewMatrix() {
        this.mDisplayMatrix.set(this.mBaseMatrix);
        this.mDisplayMatrix.postConcat(this.mSuppMatrix);
        return this.mDisplayMatrix;
    }

    /* access modifiers changed from: protected */
    public float getScale(Matrix matrix2) {
        return getValue(matrix2, 0);
    }

    /* access modifiers changed from: protected */
    public float getScale() {
        return getScale(this.mSuppMatrix);
    }

    /* access modifiers changed from: protected */
    public float getValue(Matrix matrix2, int i) {
        matrix2.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    private float spacing(MotionEvent motionEvent) {
        try {
            float x = motionEvent.getX(0) - motionEvent.getX(1);
            float y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((double) ((x * x) + (y * y)));
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    private void midPoint(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    public boolean onDown(MotionEvent motionEvent) {
        Log.d("tag", "onDown");
        return false;
    }

    public void AudioRecordData(byte[] bArr, int i) {
        int i2;
        if (this.bAudioRecordStart && i > 0 && (i2 = this.AudioOrTalkType) != 0 && i2 != 1) {
            NativeCaller.PPPPTalkAudioData(this.strDID, bArr, i);
        }
    }

    private String getDateTime() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        Log.d("tag", "record strDate:" + format);
        return this.strDID + "!" + ContentCommon.SDCARD_PATH + "_" + format;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.isRunSendAudio = false;
        StopTalk();
        releaseTalk();
        this.isCancel = false;
        this.isOneShow = true;
        SystemValue.isStartRun = false;
        if (this.pushTypeInt == 3) {
            NativeCaller.StartPPPPLivestream(this.strDID, 21, this.pushUUID, SystemValue.videFram);
        } else {
            NativeCaller.StartPPPPLivestream(this.strDID, 24, this.pushUUID, SystemValue.videFram);
        }
        StopAudio();
        NativeCaller.StartPPPPLivestream(this.strDID, 42, this.pushUUID, SystemValue.videFram);
        TakeVideoThread takeVideoThread2 = this.takeVideoThread;
        if (takeVideoThread2 != null) {
            takeVideoThread2.stopThread();
        }
        BridgeService.setPlayInterface((BridgeService.PlayInterface) null);
        BridgeService.setDoorBellSystemParmInterface((BridgeService.DoorBellSystemParmInterface) null);
        SystemValue.ISPLAY = 0;
        Bitmap bitmap = this.mBmp;
        if (bitmap != null) {
            bitmap.recycle();
            this.mBmp = null;
        }
        ((NotificationManager) getSystemService("notification")).cancel(1514);
        super.onDestroy();
    }

    public void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.modeHz = i8;
        CommonUtil.Log(1, "zhaogenghuai hzMode:" + i8);
        Message message = new Message();
        message.what = 3;
        this.mHandler.sendMessage(message);
    }

    public void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        TakeVideoThread takeVideoThread2;
        Log.e(LOG_TAG, "Call VideoData...h264Data: " + i + " len: " + i2 + " videobuf len: " + bArr.length);
        if (str.endsWith(this.strDID) && this.bDisplayFinished) {
            this.isH264Data = i;
            this.time = (long) i5;
            this.time1 = this.time * 1000;
            this.bDisplayFinished = false;
            this.videodata = bArr;
            this.videoDataLen = i2;
            Message message = new Message();
            if (i == 1) {
                this.nVideoWidth = i3;
                this.nVideoHeight = i4;
                if (this.isTakepic) {
                    this.isTakepic = false;
                    byte[] bArr2 = new byte[(i3 * i4 * 2)];
                    NativeCaller.YUV4202RGB565(bArr, bArr2, i3, i4);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr2);
                    this.mBmp = Bitmap.createBitmap(i3, i4, Bitmap.Config.RGB_565);
                    this.mBmp.copyPixelsFromBuffer(wrap);
                    takePicture(this.mBmp);
                }
                this.isH264 = true;
                message.what = 1;
                this.isHigthVideo = true;
            } else {
                message.what = 2;
                if (this.isTakeVideo && (takeVideoThread2 = this.takeVideoThread) != null) {
                    takeVideoThread2.addVideo(bArr, 0, this.nVideoWidth, this.nVideoHeight);
                }
                this.isHigthVideo = false;
            }
            this.mHandler.sendMessage(message);
        }
    }

    public void callBackMessageNotify(String str, int i, int i2) {
        Log.d("tag", "MessageNotify did: " + str + " msgType: " + i + " param: " + i2);
        if (i == 0 && !str.equals(this.strDID)) {
        }
    }

    public void callBackAudioData(byte[] bArr, int i) {
        TakeVideoThread takeVideoThread2;
        Log.e(LOG_TAG, "AudioData: len :+ " + i);
        if (this.isTakeVideo && (takeVideoThread2 = this.takeVideoThread) != null) {
            takeVideoThread2.addAudio(bArr);
        }
        AudioPlayer audioPlayer2 = this.audioPlayer;
        if (audioPlayer2 == null || audioPlayer2.isAudioPlaying()) {
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
        if (!str.endsWith(this.strDID)) {
            Log.d("testTakeVideo", "!did.endsWith(strDID)   did:" + str + "  strDID:" + this.strDID);
        } else if (this.isTakeVideo && (takeVideoThread2 = this.takeVideoThread) != null) {
            takeVideoThread2.addVideo(bArr, i, this.nVideoWidth, this.nVideoHeight);
        }
    }

    public int getCameraParamsBean(String str) {
        new CameraParamsBean();
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            if (str.endsWith(SystemValue.arrayList.get(i).getDid())) {
                return i;
            }
        }
        return -1;
    }

    @SuppressLint({"ResourceType"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d("test", "MotionEvent:" + motionEvent.getAction());
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                Log.d("test", "zhaogenghuai1");
                switch (view.getId()) {
                    case R.id.btn_doorbell_hz:
                        this.btn_doorbell_hz.setBackgroundResource(R.drawable.doorbell_hz_50);
                        Log.d("test", "zhaogenghuai");
                        break;
                    case R.id.btn_doorbell_pic:
                        this.btn_doorbell_pic.setBackgroundResource(R.drawable.pic_normal);
                        Log.d("test", "zhaogenghuai");
                        break;
                    case R.id.btn_doorbell_say:
                        this.btn_doorbell_say.setImageResource(R.drawable.touming);
                        AnimationDrawable animationDrawable2 = this.animationDrawable;
                        if (animationDrawable2 != null) {
                            animationDrawable2.stop();
                        }
                        this.btn_doorbell_say.setBackgroundResource(R.drawable.listen_talk_noomal);
                        this.tv_show_talk.setText(R.string.door_play_talk_normal);
                        StopTalk();
                        new AsyncTask<Void, Void, Void>() {
                            /* access modifiers changed from: protected */
                            public void onPreExecute() {
                            }

                            /* access modifiers changed from: protected */
                            public Void doInBackground(Void... voidArr) {
                                try {
                                    Thread.sleep(200);
                                    return null;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }

                            /* access modifiers changed from: protected */
                            public void onPostExecute(Void voidR) {
                                ListeningPlayActivity.this.StartAudio();
                                NativeCaller.StartPPPPLivestream(ListeningPlayActivity.this.strDID, 41, ListeningPlayActivity.this.pushUUID, SystemValue.videFram);
                            }
                        }.execute(new Void[0]);
                        break;
                    case R.id.btn_doorbell_vq:
                        if (this.CLickType != 1) {
                            String str = this.strDID;
                            if (str != null && str.length() > 3) {
                                NativeCaller.StartPPPPLivestream(this.strDID, 23, this.pushUUID, 5);
                            }
                        } else if (this.popupWindow_group != null) {
                            StringBuffer stringBuffer2 = this.stringBuffer;
                            stringBuffer2.replace(0, stringBuffer2.length(), "");
                            this.editText_GroupName_pass.setText("");
                            this.popupWindow_group.showAtLocation(this.textTimeStamp, 17, 0, 0);
                        }
                        this.btn_doorbell_vq.setBackgroundResource(R.drawable.btn_doorbell_sou_normal);
                        Log.d("test", "zhao1");
                        break;
                }
            }
        } else {
            int id = view.getId();
            if (id != R.id.ly_doorbell_sound) {
                switch (id) {
                    case R.id.btn_doorbell_cancel:
                        this.isCancel = false;
                        VibratorUtil.Vibrate(this, 20);
                        new AsyncTask<Void, Void, Void>() {
                            /* access modifiers changed from: protected */
                            public void onPreExecute() {
                                ListeningPlayActivity.this.returnLastBmp2Home();
                                if (ListeningPlayActivity.this.pushTypeInt != 3) {
                                    ListeningPlayActivity.this.sendBroadcast(new Intent("back"));
                                }
                            }

                            /* access modifiers changed from: protected */
                            public Void doInBackground(Void... voidArr) {
                                if (ListeningPlayActivity.this.myRender != null) {
                                    ListeningPlayActivity.this.myRender.destroyShaders();
                                }
                                boolean unused = ListeningPlayActivity.this.isTakeVideo = false;
                                try {
                                    Thread.sleep(100);
                                    return null;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }

                            /* access modifiers changed from: protected */
                            public void onPostExecute(Void voidR) {
                                ListeningPlayActivity.this.finish();
                                ListeningPlayActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                            }
                        }.execute(new Void[0]);
                        break;
                    case R.id.btn_doorbell_hz:
                        VibratorUtil.Vibrate(this, 20);
                        this.btn_doorbell_hz.setBackgroundResource(R.drawable.doorbell_hz_50_press);
                        this.cancelTime = 60;
                        if (this.pushTypeInt == 3) {
                            NativeCaller.StartPPPPLivestream(this.strDID, 26, this.pushUUID, SystemValue.videFram);
                        } else {
                            NativeCaller.StartPPPPLivestream(this.strDID, 27, this.pushUUID, SystemValue.videFram);
                        }
                        Log.d("test", "zhao1");
                        break;
                    default:
                        switch (id) {
                            case R.id.btn_doorbell_pic:
                                VibratorUtil.Vibrate(this, 20);
                                this.btn_doorbell_pic.setBackgroundResource(R.drawable.pic_press);
                                if (hasSdcard()) {
                                    if (!existSdcard()) {
                                        showToast((int) R.string.ptz_takepic_save_fail);
                                        break;
                                    } else {
                                        this.isTakepic = true;
                                        break;
                                    }
                                } else {
                                    showToast((int) R.string.local_picture_show_sd);
                                    break;
                                }
                            case R.id.btn_doorbell_say:
                                Log.e(LOG_TAG, "###btn doorbell say " + this.AudioOrTalkType);
                                VibratorUtil.Vibrate(this, 80);
                                StopAudio();
                                NativeCaller.StartPPPPLivestream(this.strDID, 42, this.pushUUID, SystemValue.videFram);
                                StartTalk();
                                this.tv_show_talk.setText(R.string.door_play_talk_press);
                                this.btn_doorbell_say.setImageResource(R.drawable.doorbell_talk_anim);
                                this.btn_doorbell_say.setBackgroundResource(R.drawable.touming);
                                this.animationDrawable = (AnimationDrawable) this.btn_doorbell_say.getDrawable();
                                this.animationDrawable.start();
                                break;
                            case R.id.btn_doorbell_video:
                                VibratorUtil.Vibrate(this, 20);
                                Log.d("test", "zhao1");
                                if (hasSdcard()) {
                                    if (!this.isTakeVideo) {
                                        this.stat = new StatFs(this.path.getPath());
                                        this.blockSize = (long) this.stat.getBlockSize();
                                        this.availableBlocks = (long) this.stat.getAvailableBlocks();
                                        if ((this.availableBlocks * this.blockSize) / 1048576 >= 50) {
                                            this.isTakeVideo = true;
                                            this.layout_videoing.setVisibility(0);
                                            SystemValue.checkSDStatu = 1;
                                            new AsyncTask<Void, Void, Void>() {
                                                /* access modifiers changed from: protected */
                                                public void onPreExecute() {
                                                    ListeningPlayActivity listeningPlayActivity = ListeningPlayActivity.this;
                                                    TakeVideoThread unused = listeningPlayActivity.takeVideoThread = new TakeVideoThread(listeningPlayActivity.isH264Data, ListeningPlayActivity.this.strDID, 15, ListeningPlayActivity.this.nVideoWidth, ListeningPlayActivity.this.nVideoHeight, ListeningPlayActivity.this.nVideoWidth, ListeningPlayActivity.this.nVideoHeight);
                                                    ListeningPlayActivity.this.takeVideoThread.start();
                                                    super.onPreExecute();
                                                }

                                                /* access modifiers changed from: protected */
                                                public Void doInBackground(Void... voidArr) {
                                                    try {
                                                        Thread.sleep(1000);
                                                        return null;
                                                    } catch (InterruptedException e) {
                                                        e.printStackTrace();
                                                        return null;
                                                    }
                                                }

                                                /* access modifiers changed from: protected */
                                                public void onPostExecute(Void voidR) {
                                                    ListeningPlayActivity.this.btn_doorbell_video.setBackgroundResource(R.drawable.video_press);
                                                    super.onPostExecute(voidR);
                                                }
                                            }.execute(new Void[0]);
                                            break;
                                        } else {
                                            showToastLong(R.string.sd_card_size_show);
                                            break;
                                        }
                                    } else {
                                        this.isTakeVideo = false;
                                        new AsyncTask<Void, Void, Void>() {
                                            /* access modifiers changed from: protected */
                                            public void onPreExecute() {
                                                ListeningPlayActivity.this.takeVideoThread.stopThread();
                                                super.onPreExecute();
                                            }

                                            /* access modifiers changed from: protected */
                                            public Void doInBackground(Void... voidArr) {
                                                try {
                                                    Thread.sleep(500);
                                                    return null;
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                    return null;
                                                }
                                            }

                                            /* access modifiers changed from: protected */
                                            public void onPostExecute(Void voidR) {
                                                ListeningPlayActivity.this.btn_doorbell_video.setBackgroundResource(R.drawable.video_normal);
                                                ListeningPlayActivity.this.layout_videoing.setVisibility(4);
                                                ListeningPlayActivity.this.showToast("/mnt/sdcard/LDBELL/video");
                                                super.onPostExecute(voidR);
                                            }
                                        }.execute(new Void[0]);
                                        break;
                                    }
                                }
                                break;
                            case R.id.btn_doorbell_vq:
                                VibratorUtil.Vibrate(this, 20);
                                break;
                        }
                }
            } else {
                VibratorUtil.Vibrate(this, 100);
                Log.e(LOG_TAG, "doorbell sound click!");
                if (this.bAudioStart) {
                    StopAudio();
                    NativeCaller.StartPPPPLivestream(this.strDID, 42, this.pushUUID, SystemValue.videFram);
                } else {
                    showToast((int) R.string.play_talk_show);
                    StartAudio();
                    NativeCaller.StartPPPPLivestream(this.strDID, 41, this.pushUUID, SystemValue.videFram);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void UpdataBitmp(String str, Bitmap bitmap) {
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            if (str != null && str.equals(SystemValue.arrayList.get(i).getDid())) {
                SystemValue.arrayList.get(i).setBmp(bitmap);
                SystemValue.arrayList.get(i).setPlayBitmap(bitmap);
            }
        }
    }

    public void callBackDoorBellSystemParm(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Log.e("test", "callBackDoorBellSystemParm: did:" + str + "  bell_on:" + i2 + "   bell_audio:" + i3 + "  bell_mode:" + i4 + "  max_watch:" + i5 + "  max_talk:" + i6 + "  max_wait:" + i7);
        if (i5 != 0 || i6 != 0) {
            if (this.pushTypeInt == 3) {
                this.cancelTime = i5;
                this.resettime = i5;
                if (i5 < 20) {
                    this.cancelTime = 20;
                    this.resettime = 20;
                    return;
                }
                return;
            }
            this.cancelTime = i6;
            this.resettime = i6;
            if (i6 < 20) {
                this.cancelTime = 20;
                this.resettime = 20;
            }
        }
    }

    public void CallBackAlermType(String str, int i) {
        Log.e("test", "CallBackAlermType:" + i);
        if (i == 7) {
            this.mHandler.sendEmptyMessage(1232);
        }
    }

    public void initExitPopupWindow_Group() {
        this.stringBuffer = new StringBuffer();
        this.popv_group = LayoutInflater.from(this).inflate(R.layout.popup_create_did, (ViewGroup) null);
        this.btn_create = (Button) this.popv_group.findViewById(R.id.popup_create_group_create);
        this.btn_cancel = (Button) this.popv_group.findViewById(R.id.popup_create_group_cancel);
        this.editText_GroupName_pass = (EditText) this.popv_group.findViewById(R.id.popup_create_group_edittext_pass);
        this.button_1 = (Button) this.popv_group.findViewById(R.id.button_1);
        this.button_1.setOnClickListener(this);
        this.button_2 = (Button) this.popv_group.findViewById(R.id.button_2);
        this.button_2.setOnClickListener(this);
        this.button_3 = (Button) this.popv_group.findViewById(R.id.button_3);
        this.button_3.setOnClickListener(this);
        this.button_4 = (Button) this.popv_group.findViewById(R.id.button_4);
        this.button_4.setOnClickListener(this);
        this.button_5 = (Button) this.popv_group.findViewById(R.id.button_5);
        this.button_5.setOnClickListener(this);
        this.button_6 = (Button) this.popv_group.findViewById(R.id.button_6);
        this.button_6.setOnClickListener(this);
        this.button_7 = (Button) this.popv_group.findViewById(R.id.button_7);
        this.button_7.setOnClickListener(this);
        this.button_8 = (Button) this.popv_group.findViewById(R.id.button_8);
        this.button_8.setOnClickListener(this);
        this.button_9 = (Button) this.popv_group.findViewById(R.id.button_9);
        this.button_9.setOnClickListener(this);
        this.button_0 = (Button) this.popv_group.findViewById(R.id.button_0);
        this.button_0.setOnClickListener(this);
        this.button_reset = (Button) this.popv_group.findViewById(R.id.button_reset);
        this.button_reset.setOnClickListener(this);
        this.button_delet = (Button) this.popv_group.findViewById(R.id.button_delet);
        this.button_delet.setOnClickListener(this);
        this.btn_create.setOnClickListener(this);
        this.btn_cancel.setOnClickListener(this);
        this.popupWindow_group = new PopupWindow(this.popv_group, -1, -1);
        this.popupWindow_group.setFocusable(true);
        this.popupWindow_group.setInputMethodMode(1);
        this.popupWindow_group.setSoftInputMode(16);
        this.popupWindow_group.setOutsideTouchable(true);
        this.popupWindow_group.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_group.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                ListeningPlayActivity.this.popupWindow_group.dismiss();
            }
        });
        this.popupWindow_group.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                ListeningPlayActivity.this.popupWindow_group.dismiss();
                return false;
            }
        });
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 50);
        int id = view.getId();
        if (id != R.id.button_delet) {
            if (id != R.id.button_mode_hz) {
                if (id != R.id.button_reset) {
                    switch (id) {
                        case R.id.button_0:
                            if (this.stringBuffer.length() < 6) {
                                this.stringBuffer.append(PushConstants.PUSH_TYPE_NOTIFY);
                                this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                                return;
                            }
                            return;
                        case R.id.button_1:
                            if (this.stringBuffer.length() < 6) {
                                this.stringBuffer.append("1");
                                this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                                return;
                            }
                            return;
                        case R.id.button_2:
                            if (this.stringBuffer.length() < 6) {
                                this.stringBuffer.append("2");
                                this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                                return;
                            }
                            return;
                        case R.id.button_3:
                            if (this.stringBuffer.length() < 6) {
                                this.stringBuffer.append("3");
                                this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                                return;
                            }
                            return;
                        case R.id.button_4:
                            if (this.stringBuffer.length() < 6) {
                                this.stringBuffer.append("4");
                                this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                                return;
                            }
                            return;
                        case R.id.button_5:
                            if (this.stringBuffer.length() < 6) {
                                this.stringBuffer.append("5");
                                this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                                return;
                            }
                            return;
                        case R.id.button_6:
                            if (this.stringBuffer.length() < 6) {
                                this.stringBuffer.append("6");
                                this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                                return;
                            }
                            return;
                        case R.id.button_7:
                            if (this.stringBuffer.length() < 6) {
                                this.stringBuffer.append("7");
                                this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                                return;
                            }
                            return;
                        case R.id.button_8:
                            if (this.stringBuffer.length() < 6) {
                                this.stringBuffer.append("8");
                                this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                                return;
                            }
                            return;
                        case R.id.button_9:
                            if (this.stringBuffer.length() < 6) {
                                this.stringBuffer.append("9");
                                this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                                return;
                            }
                            return;
                        default:
                            switch (id) {
                                case R.id.popup_create_group_cancel:
                                    this.popupWindow_group.dismiss();
                                    return;
                                case R.id.popup_create_group_create:
                                    String trim = this.editText_GroupName_pass.getText().toString().trim();
                                    if (trim.length() < 6) {
                                        showToast((int) R.string.lock_pwd_setting_show4);
                                        return;
                                    } else if (!this.lockPwd.equals(trim)) {
                                        showToast((int) R.string.lock_pwd_setting_show7);
                                        return;
                                    } else {
                                        String str = this.strDID;
                                        if (str != null && str.length() > 3) {
                                            NativeCaller.StartPPPPLivestream(this.strDID, 23, this.pushUUID, 5);
                                        }
                                        this.popupWindow_group.dismiss();
                                        return;
                                    }
                                default:
                                    return;
                            }
                    }
                } else {
                    StringBuffer stringBuffer2 = this.stringBuffer;
                    stringBuffer2.replace(0, stringBuffer2.length(), "");
                    this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
                }
            } else if (this.modeHz == 0) {
                this.modeHz = 1;
                NativeCaller.PPPPCameraControl(this.strDID, 3, 1);
                this.ptz_50_60.setText("60Hz");
            } else {
                this.modeHz = 0;
                NativeCaller.PPPPCameraControl(this.strDID, 3, 0);
                this.ptz_50_60.setText("50Hz");
            }
        } else if (this.stringBuffer.length() - 1 >= 0) {
            StringBuffer stringBuffer3 = this.stringBuffer;
            stringBuffer3.delete(stringBuffer3.length() - 1, this.stringBuffer.length());
            this.editText_GroupName_pass.setText(this.stringBuffer.toString().trim());
        }
    }

    class MyCancelTimeThread extends Thread {
        MyCancelTimeThread() {
        }

        public void run() {
            boolean unused = ListeningPlayActivity.this.istagShow = false;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ListeningPlayActivity.this.isCancel) {
                ListeningPlayActivity.this.StartAudio();
                if (ListeningPlayActivity.this.AudioOrTalkType == 0) {
                    ListeningPlayActivity.this.StartTalk();
                } else if (ListeningPlayActivity.this.AudioOrTalkType == 1) {
                    ListeningPlayActivity.this.StartTalk();
                }
            }
            while (ListeningPlayActivity.this.isCancel) {
                try {
                    sleep(1000);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (ListeningPlayActivity.this.isCancel) {
                    ListeningPlayActivity.access$310(ListeningPlayActivity.this);
                    ListeningPlayActivity.this.mHandler.sendEmptyMessage(1230);
                }
                if ((ListeningPlayActivity.this.isCancel && ListeningPlayActivity.this.cancelTime == 1) || ListeningPlayActivity.this.cancelTime < 0) {
                    ListeningPlayActivity.this.mHandler.sendEmptyMessage(1231);
                }
            }
            super.run();
        }
    }
}
