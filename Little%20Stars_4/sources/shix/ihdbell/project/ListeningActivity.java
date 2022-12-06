package shix.ihdbell.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.io.IOException;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.DataBaseHelper;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

public class ListeningActivity extends BaseActivity implements BridgeService.SnapShotInterface, View.OnClickListener, BridgeService.DoorBellAlermPush {
    private Handler BitMapHandler = new Handler() {
        public void handleMessage(Message message) {
            ListeningActivity.this.imageView.setImageBitmap(ListeningActivity.this.bmp);
            ListeningActivity.this.takePicture();
        }
    };
    private final int OTHERLIST = 111;
    private final int TIMEOUT = 112;
    private final int TIMETAG = 110;
    /* access modifiers changed from: private */
    public Bitmap bmp;
    /* access modifiers changed from: private */
    public ImageButton btn_doorbell_no;
    /* access modifiers changed from: private */
    public ImageButton btn_doorbell_ok;
    private String doorbell_audio;
    private String doorbell_audio_alarm;
    private LinearLayout frameLayout;
    /* access modifiers changed from: private */
    public DataBaseHelper helper = null;
    /* access modifiers changed from: private */
    public ImageView imageView;
    private Intent intent;
    /* access modifiers changed from: private */
    public int isOtherList = 0;
    /* access modifiers changed from: private */
    public boolean isRunTime = false;
    /* access modifiers changed from: private */
    public int it_time = 0;
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout3;
    int[] location2;
    private String loginPwd;
    private String loginUser;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 110:
                    if (ListeningActivity.this.isRunTime) {
                        TextView access$700 = ListeningActivity.this.tv_doorbell_call_time;
                        ListeningActivity listeningActivity = ListeningActivity.this;
                        access$700.setText(listeningActivity.getTimeStr(listeningActivity.it_time));
                    }
                    if (ListeningActivity.this.it_time >= 59) {
                        if (ListeningActivity.this.pushIsAlerm == 11) {
                            DataBaseHelper access$300 = ListeningActivity.this.helper;
                            String access$100 = ListeningActivity.this.pushID;
                            access$300.insertAlarmLogToDB(access$100, ListeningActivity.this.pushIsAlerm + "3", ListeningActivity.this.pushTime, ListeningActivity.this.pushPic, 2);
                        } else {
                            DataBaseHelper access$3002 = ListeningActivity.this.helper;
                            String access$1002 = ListeningActivity.this.pushID;
                            access$3002.insertAlarmLogToDB(access$1002, ListeningActivity.this.pushIsAlerm + "3", ListeningActivity.this.pushTime, ListeningActivity.this.pushPic, 0);
                        }
                        boolean unused = ListeningActivity.this.isRunTime = false;
                        SystemValue.isStartRun = false;
                        if (ListeningActivity.this.pushID != null && ListeningActivity.this.pushID.length() > 4) {
                            NativeCaller.StartPPPPLivestream(ListeningActivity.this.pushID, 25, ListeningActivity.this.pushPic, SystemValue.videFram);
                        }
                        ListeningActivity.this.finish();
                        return;
                    }
                    return;
                case 111:
                    if (SystemValue.ISPLAY != 2) {
                        ListeningActivity.this.showToastLong(R.string.doorbell_listing_other);
                        if (ListeningActivity.this.mediaPlayer != null && ListeningActivity.this.mediaPlayer.isPlaying()) {
                            ListeningActivity.this.mediaPlayer.stop();
                            try {
                                ListeningActivity.this.mediaPlayer.prepare();
                            } catch (IllegalStateException e) {
                                e.printStackTrace();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        SystemValue.ISPLAY = 0;
                        SystemValue.isStartRun = false;
                        if (ListeningActivity.this.pushID != null && ListeningActivity.this.pushID.length() > 4) {
                            NativeCaller.StartPPPPLivestream(ListeningActivity.this.pushID, 25, ListeningActivity.this.pushPic, SystemValue.videFram);
                        }
                        if (ListeningActivity.this.pushIsAlerm == 11) {
                            DataBaseHelper access$3003 = ListeningActivity.this.helper;
                            String access$1003 = ListeningActivity.this.pushID;
                            access$3003.insertAlarmLogToDB(access$1003, ListeningActivity.this.pushIsAlerm + "4", ListeningActivity.this.pushTime, ListeningActivity.this.pushPic, 2);
                        } else {
                            DataBaseHelper access$3004 = ListeningActivity.this.helper;
                            String access$1004 = ListeningActivity.this.pushID;
                            access$3004.insertAlarmLogToDB(access$1004, ListeningActivity.this.pushIsAlerm + "4", ListeningActivity.this.pushTime, ListeningActivity.this.pushPic, 1);
                        }
                        ListeningActivity.this.sendBroadcast(new Intent("back"));
                        ListeningActivity.this.finish();
                        return;
                    }
                    return;
                case 112:
                    if (ListeningActivity.this.pushIsAlerm == 11) {
                        DataBaseHelper access$3005 = ListeningActivity.this.helper;
                        String access$1005 = ListeningActivity.this.pushID;
                        access$3005.insertAlarmLogToDB(access$1005, ListeningActivity.this.pushIsAlerm + "3", ListeningActivity.this.pushTime, ListeningActivity.this.pushPic, 2);
                    } else {
                        DataBaseHelper access$3006 = ListeningActivity.this.helper;
                        String access$1006 = ListeningActivity.this.pushID;
                        access$3006.insertAlarmLogToDB(access$1006, ListeningActivity.this.pushIsAlerm + "3", ListeningActivity.this.pushTime, ListeningActivity.this.pushPic, 0);
                    }
                    boolean unused2 = ListeningActivity.this.isRunTime = false;
                    SystemValue.isStartRun = false;
                    if (ListeningActivity.this.pushID != null && ListeningActivity.this.pushID.length() > 4) {
                        NativeCaller.StartPPPPLivestream(ListeningActivity.this.pushID, 25, ListeningActivity.this.pushPic, SystemValue.videFram);
                    }
                    ListeningActivity.this.finish();
                    return;
                default:
                    return;
            }
        }
    };
    PowerManager.WakeLock mWakelock;
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;
    private DisplayMetrics metric;
    private int padB;
    /* access modifiers changed from: private */
    public int padL;
    /* access modifiers changed from: private */
    public int padR;
    /* access modifiers changed from: private */
    public int padT;
    private SharedPreferences preAudio;
    private SharedPreferences preuser;
    /* access modifiers changed from: private */
    public String pushID;
    int pushIsAlerm = 0;
    /* access modifiers changed from: private */
    public String pushName;
    String pushPic;
    /* access modifiers changed from: private */
    public String pushTime;
    /* access modifiers changed from: private */
    public TextView tv_doorbell_call_time;
    private TextView tv_doorbell_name;
    private TextView tv_doorbell_type;
    /* access modifiers changed from: private */
    public int wh;
    int windowsHeight;
    int windowsWight;

    static /* synthetic */ int access$508(ListeningActivity listeningActivity) {
        int i = listeningActivity.it_time;
        listeningActivity.it_time = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    public String getTimeStr(int i) {
        if (i < 10) {
            return "00:0" + i;
        } else if (i < 60) {
            return "00:" + i;
        } else if (i >= 60 && i < 70) {
            return "01:0" + (i - 60);
        } else if (i < 70) {
            return "00:00";
        } else {
            return "01:" + (i - 60);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 1) {
            portPoint();
        } else {
            landPoint();
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:60:0x02d7=Splitter:B:60:0x02d7, B:22:0x01fa=Splitter:B:22:0x01fa, B:51:0x02ab=Splitter:B:51:0x02ab, B:89:0x036d=Splitter:B:89:0x036d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            super.onCreate(r9)
            r8.getDate()
            r9 = 1
            r8.requestWindowFeature(r9)
            r0 = 2131165209(0x7f070019, float:1.7944629E38)
            r8.setContentView(r0)
            r0 = 0
            r8.isOtherList = r0
            java.lang.String r1 = "shix_zhao_audio"
            android.content.SharedPreferences r1 = r8.getSharedPreferences(r1, r0)
            r8.preAudio = r1
            android.content.SharedPreferences r1 = r8.preAudio
            java.lang.String r2 = "default"
            java.lang.String r3 = "doorbell_audio"
            java.lang.String r1 = r1.getString(r3, r2)
            r8.doorbell_audio = r1
            android.content.SharedPreferences r1 = r8.preAudio
            java.lang.String r3 = "default_alarm"
            java.lang.String r4 = "doorbell_audio_alarm"
            java.lang.String r1 = r1.getString(r4, r3)
            r8.doorbell_audio_alarm = r1
            java.lang.String r1 = "power"
            java.lang.Object r1 = r8.getSystemService(r1)
            android.os.PowerManager r1 = (android.os.PowerManager) r1
            r4 = 268435466(0x1000000a, float:2.524358E-29)
            java.lang.String r5 = "SimpleTimer"
            android.os.PowerManager$WakeLock r1 = r1.newWakeLock(r4, r5)
            r8.mWakelock = r1
            r1 = 2131099894(0x7f0600f6, float:1.7812154E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r8.imageView = r1
            r1 = 2131099932(0x7f06011c, float:1.7812231E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r8.linearLayout1 = r1
            r1 = 2131099934(0x7f06011e, float:1.7812235E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r8.linearLayout3 = r1
            r1 = 2131099875(0x7f0600e3, float:1.7812116E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r8.frameLayout = r1
            r1 = 2131099726(0x7f06004e, float:1.7811813E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.ImageButton r1 = (android.widget.ImageButton) r1
            r8.btn_doorbell_ok = r1
            r1 = 2131099725(0x7f06004d, float:1.7811811E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.ImageButton r1 = (android.widget.ImageButton) r1
            r8.btn_doorbell_no = r1
            r1 = 2131100123(0x7f0601db, float:1.7812619E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r8.tv_doorbell_call_time = r1
            r1 = 2131100124(0x7f0601dc, float:1.781262E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r8.tv_doorbell_name = r1
            r1 = 2131100125(0x7f0601dd, float:1.7812623E38)
            android.view.View r1 = r8.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r8.tv_doorbell_type = r1
            android.widget.TextView r1 = r8.tv_doorbell_name
            java.lang.String r4 = r8.pushName
            r1.setText(r4)
            int r1 = r8.pushIsAlerm
            if (r1 != r9) goto L_0x00bd
            android.widget.TextView r1 = r8.tv_doorbell_type
            r4 = 2131296378(0x7f09007a, float:1.821067E38)
            r1.setText(r4)
            goto L_0x00d2
        L_0x00bd:
            r4 = 11
            if (r1 != r4) goto L_0x00ca
            android.widget.TextView r1 = r8.tv_doorbell_type
            r4 = 2131296374(0x7f090076, float:1.8210663E38)
            r1.setText(r4)
            goto L_0x00d2
        L_0x00ca:
            android.widget.TextView r1 = r8.tv_doorbell_type
            r4 = 2131296373(0x7f090075, float:1.821066E38)
            r1.setText(r4)
        L_0x00d2:
            java.lang.String r1 = "shix_zhao_wifi"
            android.content.SharedPreferences r1 = r8.getSharedPreferences(r1, r0)
            r8.preuser = r1
            android.content.SharedPreferences r1 = r8.preuser
            java.lang.String r4 = "user"
            java.lang.String r5 = "admin"
            java.lang.String r1 = r1.getString(r4, r5)
            r8.loginUser = r1
            android.content.SharedPreferences r1 = r8.preuser
            java.lang.String r4 = "pwd"
            java.lang.String r5 = "123456"
            java.lang.String r1 = r1.getString(r4, r5)
            r8.loginPwd = r1
            shix.ihdbell.project.BridgeService.setDoorBellAlermPush(r8)
            shix.ihdbell.project.BridgeService.setSnapShotInterface(r8)
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            r8.metric = r1
            android.view.WindowManager r1 = r8.getWindowManager()
            android.view.Display r1 = r1.getDefaultDisplay()
            android.util.DisplayMetrics r4 = r8.metric
            r1.getMetrics(r4)
            android.util.DisplayMetrics r1 = r8.metric
            int r1 = r1.heightPixels
            r8.windowsHeight = r1
            android.util.DisplayMetrics r1 = r8.metric
            int r1 = r1.widthPixels
            r8.windowsWight = r1
            android.util.DisplayMetrics r1 = r8.metric
            int r1 = r1.heightPixels
            android.util.DisplayMetrics r4 = r8.metric
            int r4 = r4.widthPixels
            if (r1 <= r4) goto L_0x012f
            android.util.DisplayMetrics r1 = r8.metric
            int r1 = r1.heightPixels
            r8.windowsHeight = r1
            android.util.DisplayMetrics r1 = r8.metric
            int r1 = r1.widthPixels
            r8.windowsWight = r1
            goto L_0x0133
        L_0x012f:
            r8.windowsHeight = r4
            r8.windowsWight = r1
        L_0x0133:
            int r1 = r8.windowsWight
            r4 = 480(0x1e0, float:6.73E-43)
            if (r1 >= r4) goto L_0x014d
            android.widget.ImageView r1 = r8.imageView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            r4 = 150(0x96, float:2.1E-43)
            r1.height = r4
            r4 = 200(0xc8, float:2.8E-43)
            r1.width = r4
            android.widget.ImageView r4 = r8.imageView
            r4.setLayoutParams(r1)
            goto L_0x0160
        L_0x014d:
            android.widget.ImageView r1 = r8.imageView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            int r4 = r8.windowsWight
            int r4 = r4 * 3
            int r4 = r4 / 4
            r1.height = r4
            android.widget.ImageView r4 = r8.imageView
            r4.setLayoutParams(r1)
        L_0x0160:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "shix-windowsHeight:"
            r1.append(r4)
            int r4 = r8.windowsHeight
            r1.append(r4)
            java.lang.String r4 = " windowsWight:"
            r1.append(r4)
            int r4 = r8.windowsWight
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r4 = "test"
            android.util.Log.d(r4, r1)
            r1 = 1117126656(0x42960000, float:75.0)
            android.util.DisplayMetrics r5 = r8.metric
            float r5 = r5.density
            float r5 = r5 * r1
            int r1 = (int) r5
            r8.wh = r1
            int r1 = r8.windowsHeight
            float r1 = (float) r1
            android.util.DisplayMetrics r5 = r8.metric
            float r5 = r5.density
            r6 = 1120403456(0x42c80000, float:100.0)
            float r5 = r5 * r6
            float r1 = r1 - r5
            int r5 = r8.wh
            float r5 = (float) r5
            float r1 = r1 - r5
            int r1 = (int) r1
            r8.padT = r1
            android.util.DisplayMetrics r1 = r8.metric
            float r1 = r1.density
            r5 = 1101004800(0x41a00000, float:20.0)
            float r1 = r1 * r5
            int r1 = (int) r1
            r8.padL = r1
            int r1 = r8.windowsWight
            int r7 = r8.wh
            int r1 = r1 - r7
            float r1 = (float) r1
            android.util.DisplayMetrics r7 = r8.metric
            float r7 = r7.density
            float r7 = r7 * r5
            float r1 = r1 - r7
            int r1 = (int) r1
            r8.padR = r1
            android.util.DisplayMetrics r1 = r8.metric
            float r1 = r1.density
            float r1 = r1 * r6
            int r1 = (int) r1
            r8.padB = r1
            object.p2pipcam.system.SystemValue.ISPLAY = r0
            android.widget.ImageButton r0 = r8.btn_doorbell_no
            shix.ihdbell.project.ListeningActivity$3 r1 = new shix.ihdbell.project.ListeningActivity$3
            r1.<init>()
            r0.setOnTouchListener(r1)
            android.widget.ImageButton r0 = r8.btn_doorbell_ok
            shix.ihdbell.project.ListeningActivity$4 r1 = new shix.ihdbell.project.ListeningActivity$4
            r1.<init>()
            r0.setOnTouchListener(r1)
            int r0 = r8.pushIsAlerm
            java.lang.String r1 = "audio"
            r5 = 2
            r6 = 2131230720(0x7f080000, float:1.80775E38)
            r7 = 0
            if (r0 != r9) goto L_0x02c1
            java.lang.String r0 = r8.doorbell_audio
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0210
            android.media.MediaPlayer r0 = r8.mediaPlayer
            if (r0 == 0) goto L_0x01fa
            r0.stop()
            android.media.MediaPlayer r0 = r8.mediaPlayer
            r0.release()
            r8.mediaPlayer = r7
        L_0x01fa:
            android.media.MediaPlayer r0 = android.media.MediaPlayer.create(r8, r6)     // Catch:{ Exception -> 0x0381 }
            r8.mediaPlayer = r0     // Catch:{ Exception -> 0x0381 }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            if (r0 == 0) goto L_0x0381
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            r0.start()     // Catch:{ Exception -> 0x0381 }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            r0.setLooping(r9)     // Catch:{ Exception -> 0x0381 }
            goto L_0x0381
        L_0x0210:
            java.lang.String r0 = r8.doorbell_audio
            java.lang.String r2 = "no"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x021c
            goto L_0x0381
        L_0x021c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "doorbell_audio:"
            r0.append(r2)
            java.lang.String r2 = r8.doorbell_audio
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r4, r0)
            java.io.File r0 = new java.io.File
            java.lang.String r2 = r8.doorbell_audio
            r0.<init>(r2)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x029d
            android.media.MediaPlayer r0 = r8.mediaPlayer
            if (r0 == 0) goto L_0x024d
            r0.stop()
            android.media.MediaPlayer r0 = r8.mediaPlayer
            r0.release()
            r8.mediaPlayer = r7
        L_0x024d:
            java.lang.String r0 = r8.doorbell_audio     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            android.media.MediaPlayer r2 = new android.media.MediaPlayer     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            r2.<init>()     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            r8.mediaPlayer = r2     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            android.media.MediaPlayer r2 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            if (r2 == 0) goto L_0x0381
            android.media.MediaPlayer r2 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            r2.setDataSource(r8, r0)     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            java.lang.Object r0 = r8.getSystemService(r1)     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            android.media.AudioManager r0 = (android.media.AudioManager) r0     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            int r0 = r0.getStreamVolume(r5)     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            if (r0 == 0) goto L_0x0279
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            r0.setAudioStreamType(r5)     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            r0.setLooping(r9)     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
        L_0x0279:
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            r0.prepare()     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            r0.start()     // Catch:{ IllegalArgumentException -> 0x0297, SecurityException -> 0x0291, IllegalStateException -> 0x028b, IOException -> 0x0285 }
            goto L_0x0381
        L_0x0285:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0381
        L_0x028b:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0381
        L_0x0291:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0381
        L_0x0297:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0381
        L_0x029d:
            android.media.MediaPlayer r0 = r8.mediaPlayer
            if (r0 == 0) goto L_0x02ab
            r0.stop()
            android.media.MediaPlayer r0 = r8.mediaPlayer
            r0.release()
            r8.mediaPlayer = r7
        L_0x02ab:
            android.media.MediaPlayer r0 = android.media.MediaPlayer.create(r8, r6)     // Catch:{ Exception -> 0x0381 }
            r8.mediaPlayer = r0     // Catch:{ Exception -> 0x0381 }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            if (r0 == 0) goto L_0x0381
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            r0.start()     // Catch:{ Exception -> 0x0381 }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            r0.setLooping(r9)     // Catch:{ Exception -> 0x0381 }
            goto L_0x0381
        L_0x02c1:
            java.lang.String r0 = r8.doorbell_audio_alarm
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x02ed
            android.media.MediaPlayer r0 = r8.mediaPlayer
            if (r0 == 0) goto L_0x02d7
            r0.stop()
            android.media.MediaPlayer r0 = r8.mediaPlayer
            r0.release()
            r8.mediaPlayer = r7
        L_0x02d7:
            android.media.MediaPlayer r0 = android.media.MediaPlayer.create(r8, r6)     // Catch:{ Exception -> 0x0381 }
            r8.mediaPlayer = r0     // Catch:{ Exception -> 0x0381 }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            if (r0 == 0) goto L_0x0381
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            r0.start()     // Catch:{ Exception -> 0x0381 }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            r0.setLooping(r9)     // Catch:{ Exception -> 0x0381 }
            goto L_0x0381
        L_0x02ed:
            java.lang.String r0 = r8.doorbell_audio_alarm
            java.lang.String r2 = "no_alarm"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x02f9
            goto L_0x0381
        L_0x02f9:
            java.io.File r0 = new java.io.File
            java.lang.String r2 = r8.doorbell_audio_alarm
            r0.<init>(r2)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x035f
            android.media.MediaPlayer r0 = r8.mediaPlayer
            if (r0 == 0) goto L_0x0314
            r0.stop()
            android.media.MediaPlayer r0 = r8.mediaPlayer
            r0.release()
            r8.mediaPlayer = r7
        L_0x0314:
            java.lang.String r0 = r8.doorbell_audio_alarm     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            android.media.MediaPlayer r2 = new android.media.MediaPlayer     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            r2.<init>()     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            r8.mediaPlayer = r2     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            android.media.MediaPlayer r2 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            if (r2 == 0) goto L_0x0381
            android.media.MediaPlayer r2 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            r2.setDataSource(r8, r0)     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            java.lang.Object r0 = r8.getSystemService(r1)     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            android.media.AudioManager r0 = (android.media.AudioManager) r0     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            int r0 = r0.getStreamVolume(r5)     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            if (r0 == 0) goto L_0x0340
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            r0.setAudioStreamType(r5)     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            r0.setLooping(r9)     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
        L_0x0340:
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            r0.prepare()     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            r0.start()     // Catch:{ IllegalArgumentException -> 0x035a, SecurityException -> 0x0355, IllegalStateException -> 0x0350, IOException -> 0x034b }
            goto L_0x0381
        L_0x034b:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0381
        L_0x0350:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0381
        L_0x0355:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0381
        L_0x035a:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0381
        L_0x035f:
            android.media.MediaPlayer r0 = r8.mediaPlayer
            if (r0 == 0) goto L_0x036d
            r0.stop()
            android.media.MediaPlayer r0 = r8.mediaPlayer
            r0.release()
            r8.mediaPlayer = r7
        L_0x036d:
            android.media.MediaPlayer r0 = android.media.MediaPlayer.create(r8, r6)     // Catch:{ Exception -> 0x0381 }
            r8.mediaPlayer = r0     // Catch:{ Exception -> 0x0381 }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            if (r0 == 0) goto L_0x0381
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            r0.start()     // Catch:{ Exception -> 0x0381 }
            android.media.MediaPlayer r0 = r8.mediaPlayer     // Catch:{ Exception -> 0x0381 }
            r0.setLooping(r9)     // Catch:{ Exception -> 0x0381 }
        L_0x0381:
            r8.isRunTime = r9
            shix.ihdbell.project.ListeningActivity$MyTimeThread r9 = new shix.ihdbell.project.ListeningActivity$MyTimeThread
            r9.<init>()
            r9.start()
            object.p2pipcam.utils.DataBaseHelper r9 = object.p2pipcam.utils.DataBaseHelper.getInstance(r8)
            r8.helper = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.ListeningActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public void takePicture() {
        new Thread() {
            public void run() {
                ListeningActivity.this.savePicToSDcard();
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087 A[SYNTHETIC, Splitter:B:29:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0091 A[SYNTHETIC, Splitter:B:35:0x0091] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void savePicToSDcard() {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            java.lang.String r1 = "test"
            java.lang.String r2 = "savePicToSDcard"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x009a }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x007a }
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x007a }
            java.lang.String r3 = "LittleStars/picVisitor"
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x007a }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x007a }
            if (r2 != 0) goto L_0x001d
            r1.mkdirs()     // Catch:{ Exception -> 0x007a }
        L_0x001d:
            java.lang.String r2 = r6.pushTime     // Catch:{ Exception -> 0x007a }
            java.lang.String r3 = " "
            java.lang.String r4 = "_"
            java.lang.String r2 = r2.replace(r3, r4)     // Catch:{ Exception -> 0x007a }
            java.lang.String r3 = "-"
            java.lang.String r4 = "_"
            java.lang.String r2 = r2.replace(r3, r4)     // Catch:{ Exception -> 0x007a }
            java.lang.String r3 = ":"
            java.lang.String r4 = "_"
            java.lang.String r2 = r2.replace(r3, r4)     // Catch:{ Exception -> 0x007a }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x007a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007a }
            r4.<init>()     // Catch:{ Exception -> 0x007a }
            r4.append(r2)     // Catch:{ Exception -> 0x007a }
            java.lang.String r2 = ".jpg"
            r4.append(r2)     // Catch:{ Exception -> 0x007a }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x007a }
            r3.<init>(r1, r2)     // Catch:{ Exception -> 0x007a }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x007a }
            r1.<init>(r3)     // Catch:{ Exception -> 0x007a }
            android.graphics.Bitmap r0 = r6.bmp     // Catch:{ Exception -> 0x0073, all -> 0x006e }
            if (r0 == 0) goto L_0x0065
            android.graphics.Bitmap r0 = r6.bmp     // Catch:{ Exception -> 0x0073, all -> 0x006e }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0073, all -> 0x006e }
            r3 = 60
            boolean r0 = r0.compress(r2, r3, r1)     // Catch:{ Exception -> 0x0073, all -> 0x006e }
            if (r0 == 0) goto L_0x0065
            r1.flush()     // Catch:{ Exception -> 0x0073, all -> 0x006e }
        L_0x0065:
            r1.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x008d
        L_0x0069:
            r0 = move-exception
        L_0x006a:
            r0.printStackTrace()     // Catch:{ all -> 0x009a }
            goto L_0x008d
        L_0x006e:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x008f
        L_0x0073:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x007b
        L_0x0078:
            r1 = move-exception
            goto L_0x008f
        L_0x007a:
            r1 = move-exception
        L_0x007b:
            r1.printStackTrace()     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = "test"
            java.lang.String r2 = "savePicToSDcard"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x008d
            r0.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008d
        L_0x008b:
            r0 = move-exception
            goto L_0x006a
        L_0x008d:
            monitor-exit(r6)
            return
        L_0x008f:
            if (r0 == 0) goto L_0x0099
            r0.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x009a }
        L_0x0099:
            throw r1     // Catch:{ all -> 0x009a }
        L_0x009a:
            r0 = move-exception
            monitor-exit(r6)
            goto L_0x009e
        L_0x009d:
            throw r0
        L_0x009e:
            goto L_0x009d
        */
        throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.ListeningActivity.savePicToSDcard():void");
    }

    /* access modifiers changed from: private */
    public String retrunUser(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDid())) {
                i++;
            } else {
                Log.d("tag", "testuser:" + SystemValue.arrayList.get(i).getUser());
                return SystemValue.arrayList.get(i).getUser();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String retrunUserPWD(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDid())) {
                i++;
            } else {
                Log.d("tag", "testuserpwd:" + SystemValue.arrayList.get(i).getPwd());
                return SystemValue.arrayList.get(i).getPwd();
            }
        }
        return null;
    }

    private void getDate() {
        String str;
        this.intent = getIntent();
        SystemValue.isStartRun = true;
        Intent intent2 = this.intent;
        if (intent2 != null) {
            this.pushID = intent2.getStringExtra(ContentCommon.STR_CAMERA_ID);
            this.pushName = this.intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
            this.pushTime = this.intent.getStringExtra("pushDate");
            this.pushIsAlerm = this.intent.getIntExtra("pushIsAlerm", 1);
            this.pushPic = this.intent.getStringExtra("pushPic");
            String str2 = this.pushID;
            if (str2 != null && str2.length() > 4 && (str = this.pushPic) != null && str.length() > 4) {
                NativeCaller.SnapShot(this.pushID, this.pushPic);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        StopHeat();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        portPoint();
        VibratorUtil.Vibrate(this, 1000);
        getWindow().getAttributes().flags |= 524288;
        this.mWakelock.acquire();
        if (MainActivity.keyguardLock != null) {
            MainActivity.keyguardLock.disableKeyguard();
        }
        StartHeat(this.pushID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
    }

    private void portPoint() {
        this.metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(this.metric);
        this.windowsHeight = this.metric.heightPixels;
        this.windowsWight = this.metric.widthPixels;
        int i = this.metric.heightPixels;
        int i2 = this.metric.widthPixels;
        if (i > i2) {
            this.windowsHeight = this.metric.heightPixels;
            this.windowsWight = this.metric.widthPixels;
        } else {
            this.windowsHeight = i2;
            this.windowsWight = i;
        }
        int i3 = this.windowsWight;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, (i3 * 3) / 4);
        layoutParams.gravity = 17;
        this.frameLayout.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.linearLayout3.getLayoutParams();
        layoutParams2.height = (this.windowsHeight / 7) * 3;
        layoutParams2.width = this.windowsWight;
        this.linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(this.windowsWight, ((this.metric.heightPixels - ((int) (this.metric.density * 117.0f))) - ((this.windowsWight * 3) / 4)) - ((int) (this.metric.density * 25.0f))));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) (this.metric.density * 75.0f), (int) (this.metric.density * 75.0f));
        if (getResources().getConfiguration().orientation == 1) {
            layoutParams3.leftMargin = this.padL;
            layoutParams3.rightMargin = this.padR;
            layoutParams3.topMargin = this.padT;
            layoutParams3.bottomMargin = this.padB - ((int) (this.metric.density * 25.0f));
            Log.d("test", "padL:" + this.padL + "  padT:" + this.padT + "  padR:" + this.padR + "  padB:" + this.padB);
        } else {
            layoutParams3.leftMargin = 10;
            layoutParams3.topMargin = this.windowsWight / 2;
        }
        this.btn_doorbell_ok.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (this.metric.density * 75.0f), (int) (this.metric.density * 75.0f));
        if (getResources().getConfiguration().orientation == 1) {
            layoutParams4.leftMargin = this.padR;
            layoutParams4.rightMargin = this.padL;
            layoutParams4.topMargin = this.padT;
            layoutParams4.bottomMargin = this.padB - ((int) (this.metric.density * 25.0f));
            layoutParams4.addRule(9);
        } else {
            layoutParams4.rightMargin = 10;
            layoutParams4.topMargin = this.windowsWight / 2;
            layoutParams4.addRule(11);
        }
        this.btn_doorbell_no.setLayoutParams(layoutParams4);
    }

    private void landPoint() {
        this.metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(this.metric);
        this.windowsHeight = this.metric.heightPixels;
        this.windowsWight = this.metric.widthPixels;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (this.metric.density * 75.0f), (int) (this.metric.density * 75.0f));
        layoutParams.leftMargin = 10;
        layoutParams.topMargin = this.windowsHeight / 2;
        layoutParams.addRule(9);
        this.btn_doorbell_ok.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (this.metric.density * 75.0f), (int) (this.metric.density * 75.0f));
        layoutParams2.rightMargin = 10;
        layoutParams2.topMargin = this.windowsHeight / 2;
        layoutParams2.addRule(11);
        this.btn_doorbell_no.setLayoutParams(layoutParams2);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BridgeService.setDoorBellAlermPush((BridgeService.DoorBellAlermPush) null);
        BridgeService.setSnapShotInterface((BridgeService.SnapShotInterface) null);
        this.isOtherList = 0;
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
            this.mediaPlayer.stop();
            try {
                this.mediaPlayer.prepare();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        Bitmap bitmap = this.bmp;
        if (bitmap != null) {
            bitmap.recycle();
            this.bmp = null;
        }
        MediaPlayer mediaPlayer3 = this.mediaPlayer;
        if (mediaPlayer3 != null) {
            mediaPlayer3.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        this.mWakelock.release();
        this.loginUser = this.preuser.getString(DataBaseHelper.KEY_USER, ContentCommon.DEFAULT_USER_NAME);
        this.loginPwd = this.preuser.getString(DataBaseHelper.KEY_PWD, "123456");
        this.isRunTime = false;
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void BSSnapshot(String str, byte[] bArr, int i) {
        Log.d("test", "shix-len:" + i);
        this.bmp = BitmapFactory.decodeByteArray(bArr, 0, i);
        this.BitMapHandler.sendEmptyMessage(110);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_doorbell_no) {
            this.location2 = new int[2];
            this.btn_doorbell_ok.getLocationOnScreen(this.location2);
            Log.d("test", "l:" + this.location2[0] + "   t1:" + this.location2[1] + "  r1:" + (this.location2[0] + this.btn_doorbell_ok.getWidth()) + "  b1" + (this.location2[1] + this.btn_doorbell_ok.getHeight()));
        }
    }

    public void CallBackAlermType(int i) {
        if (i == 3) {
            this.mHandler.sendEmptyMessage(111);
        } else if (i == 4) {
            this.mHandler.sendEmptyMessage(112);
        }
    }

    public void CallBackDoorbellType(String str, int i) {
        Log.d("test", "zhaogenghuais uuid:" + str + "   type:" + i);
        this.isOtherList = i;
        String str2 = this.pushID;
        if (str2 != null && str2.length() > 4) {
            NativeCaller.StartPPPPLivestream(this.pushID, 25, str, SystemValue.videFram);
        }
    }

    class MyTimeThread extends Thread {
        MyTimeThread() {
        }

        public void run() {
            while (ListeningActivity.this.isRunTime) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ListeningActivity.access$508(ListeningActivity.this);
                ListeningActivity.this.mHandler.sendEmptyMessage(110);
            }
            super.run();
        }
    }
}
