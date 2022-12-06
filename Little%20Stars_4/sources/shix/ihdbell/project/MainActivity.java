package shix.ihdbell.project;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.KeyguardManager;
import android.app.LocalActivityManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;
import com.jxl.app.littlestars.project.BuildConfig;
import com.jxl.app.littlestars.project.R;
import com.shix.fcmpush1.FcmPush;
import com.tzh.ipcamera.permission.PermissionHelper;
import com.tzh.ipcamera.permission.PermissionInterface;
import com.tzh.ipcamera.view.MyPreference;
import com.tzh.ipcamera.view.dialog.LocationAlartDialog;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Date;
import java.util.TimeZone;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.DataBaseHelper;
import object.p2pipcam.utils.VibratorUtil;

public class MainActivity extends ActivityGroup implements View.OnTouchListener, View.OnClickListener, PermissionInterface {
    public static KeyguardManager.KeyguardLock keyguardLock;
    private static MainEditInterface mainEditInterface;
    private LocationAlartDialog alartDialog = null;
    /* access modifiers changed from: private */
    public boolean bClicked = false;
    private ImageView btnDevice;
    private ImageView btnRecord;
    private ImageView btnSnap;
    private Button btn_edit;
    private Button btn_menu;
    private LinearLayout btn_more_about;
    private LinearLayout btn_more_setting;
    private LinearLayout btn_zhuxiao;
    private int colorNomal = -1778384897;
    private int colorPress = -1;
    private LinearLayout container;
    Handler handler = new Handler();
    /* access modifiers changed from: private */
    public RelativeLayout img;
    private ImageView img_bells;
    private ImageView img_logs;
    private ImageView img_pic;
    private ImageView img_video;
    private boolean isEdited;
    private LinearLayout layoutAlarm;
    private LinearLayout layoutPic;
    private LinearLayout layoutVid;
    private LinearLayout layoutVidicon;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Log.e(MainActivity.class.getSimpleName(), "消失");
                MainActivity.this.img.setVisibility(8);
            } else if (i == 3) {
                boolean unused = MainActivity.this.bClicked = false;
            }
        }
    };
    private SharedPreferences mPhoneSoundsPref;
    private TextView main_tv_alarm;
    private TextView main_tv_picture;
    private TextView main_tv_vid;
    private TextView main_tv_vidicon;
    private int nowSel = 0;
    /* access modifiers changed from: private */
    public PermissionHelper permissionHelper = null;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_more_funtion;
    private View popv_more_funtion;
    private SharedPreferences preAudio;
    private int prevSel = 0;
    /* access modifiers changed from: private */
    public MyBroadCast receiver;
    /* access modifiers changed from: private */
    public long startTime = 0;
    private String strAlarmFolder = "/sdcard/music/alarms";
    private String strRingtoneFolder = "/sdcard/music/ringtone";
    private int tabPosition = 1;
    /* access modifiers changed from: private */
    public int tap = 0;
    private TextView textView_title;

    public interface MainEditInterface {
        boolean EditOnclick(Button button, boolean z);
    }

    public int getPermissionsRequestCode() {
        return 0;
    }

    public void requestPermissionsFail() {
    }

    static /* synthetic */ int access$408(MainActivity mainActivity) {
        int i = mainActivity.tap;
        mainActivity.tap = i + 1;
        return i;
    }

    public static void setMainEditInterface(MainEditInterface mainEditInterface2) {
        mainEditInterface = mainEditInterface2;
    }

    public boolean checkPackage(String str) {
        if (str != null && !"".equals(str)) {
            try {
                getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f A[SYNTHETIC, Splitter:B:34:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0099 A[SYNTHETIC, Splitter:B:39:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a5 A[SYNTHETIC, Splitter:B:45:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00af A[SYNTHETIC, Splitter:B:50:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkTwoDimension() {
        /*
            r7 = this;
            java.lang.String r0 = "LQD-HBell-160524.apk"
            java.lang.String r1 = "com.icallbell.project"
            boolean r2 = r7.checkPackage(r1)
            if (r2 != 0) goto L_0x00b8
            r1 = 0
            android.content.res.AssetManager r2 = r7.getAssets()     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            java.io.InputStream r2 = r2.open(r0)     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0062, all -> 0x005d }
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ IOException -> 0x0062, all -> 0x005d }
            r3.<init>(r4, r0)     // Catch:{ IOException -> 0x0062, all -> 0x005d }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0062, all -> 0x005d }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0062, all -> 0x005d }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x005b }
        L_0x0025:
            int r4 = r2.read(r1)     // Catch:{ IOException -> 0x005b }
            r5 = -1
            if (r4 == r5) goto L_0x0031
            r5 = 0
            r0.write(r1, r5, r4)     // Catch:{ IOException -> 0x005b }
            goto L_0x0025
        L_0x0031:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ IOException -> 0x005b }
            r1.<init>()     // Catch:{ IOException -> 0x005b }
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r4)     // Catch:{ IOException -> 0x005b }
            java.lang.String r4 = "android.intent.action.VIEW"
            r1.setAction(r4)     // Catch:{ IOException -> 0x005b }
            android.net.Uri r3 = android.net.Uri.fromFile(r3)     // Catch:{ IOException -> 0x005b }
            java.lang.String r4 = "application/vnd.android.package-archive"
            r1.setDataAndType(r3, r4)     // Catch:{ IOException -> 0x005b }
            r7.startActivity(r1)     // Catch:{ IOException -> 0x005b }
            if (r2 == 0) goto L_0x0056
            r2.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0056:
            r0.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00d1
        L_0x005b:
            r1 = move-exception
            goto L_0x0070
        L_0x005d:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x00a3
        L_0x0062:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0070
        L_0x0067:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x00a3
        L_0x006c:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L_0x0070:
            java.lang.String r3 = "tag"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r4.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = "exception:"
            r4.append(r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r5 = r1.getMessage()     // Catch:{ all -> 0x00a2 }
            r4.append(r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00a2 }
            android.util.Log.d(r3, r4)     // Catch:{ all -> 0x00a2 }
            r1.printStackTrace()     // Catch:{ all -> 0x00a2 }
            if (r2 == 0) goto L_0x0097
            r2.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0097
        L_0x0093:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0097:
            if (r0 == 0) goto L_0x00d1
            r0.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00d1
        L_0x009d:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00d1
        L_0x00a2:
            r1 = move-exception
        L_0x00a3:
            if (r2 == 0) goto L_0x00ad
            r2.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00ad
        L_0x00a9:
            r2 = move-exception
            r2.printStackTrace()
        L_0x00ad:
            if (r0 == 0) goto L_0x00b7
            r0.close()     // Catch:{ IOException -> 0x00b3 }
            goto L_0x00b7
        L_0x00b3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b7:
            throw r1
        L_0x00b8:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r2 = "android.intent.action.MAIN"
            r0.<init>(r2)
            java.lang.String r2 = "android.intent.category.LAUNCHER"
            r0.addCategory(r2)
            android.content.ComponentName r2 = new android.content.ComponentName
            java.lang.String r3 = "ocom.icallbell.project.IpcamClientActivity1"
            r2.<init>(r1, r3)
            r0.setComponent(r2)
            r7.startActivity(r0)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.MainActivity.checkTwoDimension():void");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            sendBroadcast(new Intent(ContentCommon.MAIN_KEY_MENU));
            return false;
        } else if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        } else {
            sendBroadcast(new Intent(ContentCommon.MAIN_KEY_BACK));
            return true;
        }
    }

    public void requesetPermission() {
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this, "android.permission-group.STORAGE") == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 1);
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            int length = iArr.length;
            int i2 = 0;
            while (i2 < length && iArr[i2] == 0) {
                i2++;
            }
        }
    }

    public String[] getPermissions() {
        return new String[0];
    }

    public void requestPermissionsSuccess() {
        requesetPermission();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.main);
        getPackageManager().setComponentEnabledSetting(new ComponentName(BuildConfig.APPLICATION_ID, FirebaseInstanceIdInternalReceiver.class.getName()), 2, 1);
        if (!MyPreference.getInstance(this).isExistAgree().booleanValue()) {
            showDialog();
        } else if (!MyPreference.getInstance(this).getIsAgree().booleanValue()) {
            showDialog();
        }
        this.preAudio = getSharedPreferences("shix_zhao_audio", 0);
        ContentCommon.TIME_UTC = TimeZone.getDefault().getDisplayName(false, 0);
        Log.e("test", "ContentCommon.TIME_UTC222:" + ContentCommon.TIME_UTC);
        BridgeService.isAppClose = false;
        Intent intent = new Intent();
        intent.setClass(this, BridgeService.class);
        startService(intent);
        new Thread(new Runnable() {
            public void run() {
                try {
                    NativeCaller.PPPPInitial(SystemValue.SystemSerVer, SystemValue.SystemSerVer.length());
                    Log.e(MainActivity.class.getSimpleName(), "run: onCreate PPPPInitial");
                    long time = new Date().getTime();
                    NativeCaller.PPPPNetworkDetect();
                    long time2 = new Date().getTime();
                    Message message = new Message();
                    message.what = 0;
                    MainActivity.this.mHandler.sendMessage(message);
                    if (time2 - time <= 3000) {
                        Thread.sleep(3000);
                    }
                    Message message2 = new Message();
                    message2.what = 1;
                    MainActivity.this.mHandler.sendMessage(message2);
                } catch (Exception unused) {
                }
            }
        }).start();
        findView();
        setListener();
        ShowScreen(IpcamClientActivity1.class, 1);
        this.receiver = new MyBroadCast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ContentCommon.MAIN_KEY_MENU);
        intentFilter.addAction(ContentCommon.MAIN_KEY_BACK);
        registerReceiver(this.receiver, intentFilter);
        keyguardLock = ((KeyguardManager) getSystemService("keyguard")).newKeyguardLock("test");
        SystemValue.Token = this.preAudio.getInt(Constants.EXTRA_KEY_TOKEN, 0);
        if (SystemValue.Token == 0) {
            SystemValue.Token = (int) ((Math.random() * 9000.0d) + 1000.0d);
            SharedPreferences.Editor edit = this.preAudio.edit();
            edit.putInt(Constants.EXTRA_KEY_TOKEN, SystemValue.Token);
            edit.commit();
        }
        this.mPhoneSoundsPref = getSharedPreferences("pref_phone_ringtone", 0);
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(this, true);
        }
        SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
        systemBarTintManager.setStatusBarTintEnabled(true);
        systemBarTintManager.setStatusBarTintResource(R.color.color_mainxx);
    }

    @TargetApi(19)
    private void setTranslucentStatus(Activity activity, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        ((NotificationManager) getSystemService("notification")).cancelAll();
        KeyguardManager.KeyguardLock keyguardLock2 = keyguardLock;
        if (keyguardLock2 != null) {
            keyguardLock2.reenableKeyguard();
        }
        super.onStop();
    }

    private void setListener() {
        this.layoutVidicon.setOnTouchListener(this);
        this.layoutAlarm.setOnTouchListener(this);
        this.layoutPic.setOnTouchListener(this);
        this.layoutVid.setOnTouchListener(this);
        this.btnDevice = (ImageView) findViewById(R.id.btnDevice);
        this.btnRecord = (ImageView) findViewById(R.id.btnRecordFile);
        this.btnSnap = (ImageView) findViewById(R.id.btnSnapFile);
        this.btnDevice.setOnClickListener(this);
        this.btnRecord.setOnClickListener(this);
        this.btnSnap.setOnClickListener(this);
        if (!MyPreference.getInstance(this).isExistAgree().booleanValue()) {
            setButtonDis();
        } else if (!MyPreference.getInstance(this).getIsAgree().booleanValue()) {
            setButtonDis();
        }
    }

    private void findView() {
        this.btn_edit = (Button) findViewById(R.id.btn_edit);
        this.btn_menu = (Button) findViewById(R.id.btn_menu);
        this.btn_edit.setOnClickListener(this);
        this.btn_menu.setOnClickListener(this);
        this.main_tv_vidicon = (TextView) findViewById(R.id.main_tv_vidicon);
        this.main_tv_alarm = (TextView) findViewById(R.id.main_tv_alarm);
        this.main_tv_picture = (TextView) findViewById(R.id.main_tv_picture);
        this.main_tv_vid = (TextView) findViewById(R.id.main_tv_vid);
        this.textView_title = (TextView) findViewById(R.id.textView_title);
        this.layoutVidicon = (LinearLayout) findViewById(R.id.main_layout_vidicon);
        this.layoutAlarm = (LinearLayout) findViewById(R.id.main_layout_alarm);
        this.layoutPic = (LinearLayout) findViewById(R.id.main_layout_pic);
        this.layoutVid = (LinearLayout) findViewById(R.id.main_layout_vid);
        this.container = (LinearLayout) findViewById(R.id.container);
        this.img = (RelativeLayout) findViewById(R.id.img);
        this.img_bells = (ImageView) findViewById(R.id.img_bells);
        this.img_logs = (ImageView) findViewById(R.id.img_logs);
        this.img_pic = (ImageView) findViewById(R.id.img_pic);
        this.img_video = (ImageView) findViewById(R.id.img_video);
    }

    private void setTabDown(int i) {
        if (i == 0) {
            this.btnDevice.setImageResource(R.drawable.device_icon_green);
        } else if (i == 1) {
            this.btnSnap.setImageResource(R.drawable.snap_icon_green);
        } else if (i == 2) {
            this.btnRecord.setImageResource(R.drawable.record_file_icon_green);
        }
    }

    private void setTabUp(int i) {
        if (i == 0) {
            this.btnDevice.setImageResource(R.drawable.device_icon_black);
        } else if (i == 1) {
            this.btnSnap.setImageResource(R.drawable.snap_icon_black);
        } else if (i == 2) {
            this.btnRecord.setImageResource(R.drawable.record_file_icon_black);
        }
    }

    private void setOtherButton(int i, int i2) {
        setTabDown(i);
        setTabUp(i2);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            VibratorUtil.Vibrate(this, 20);
            switch (view.getId()) {
                case R.id.main_layout_alarm:
                    this.textView_title.setText(R.string.main_alarm);
                    this.main_tv_alarm.setTextColor(this.colorPress);
                    this.btn_edit.setVisibility(8);
                    this.img_logs.setImageResource(R.drawable.db_log_press);
                    int i = this.tabPosition;
                    if (i == 1) {
                        this.main_tv_vidicon.setTextColor(this.colorNomal);
                        this.img_bells.setImageResource(R.drawable.db_bell_normal);
                    } else if (i == 3) {
                        this.main_tv_picture.setTextColor(this.colorNomal);
                        this.img_pic.setImageResource(R.drawable.db_pic_normal);
                    } else if (i == 4) {
                        this.main_tv_vid.setTextColor(this.colorNomal);
                        this.img_video.setImageResource(R.drawable.db_video_normal);
                    }
                    this.tabPosition = 2;
                    ShowScreen(AlarmActivity.class, 2);
                    break;
                case R.id.main_layout_pic:
                    this.textView_title.setText(R.string.main_pic);
                    this.main_tv_picture.setTextColor(this.colorPress);
                    this.btn_edit.setVisibility(8);
                    this.img_pic.setImageResource(R.drawable.db_pic_press);
                    int i2 = this.tabPosition;
                    if (i2 == 1) {
                        this.main_tv_vidicon.setTextColor(this.colorNomal);
                        this.img_bells.setImageResource(R.drawable.db_bell_normal);
                    } else if (i2 == 2) {
                        this.main_tv_alarm.setTextColor(this.colorNomal);
                        this.img_logs.setImageResource(R.drawable.db_log_normal);
                    } else if (i2 == 4) {
                        this.main_tv_vid.setTextColor(this.colorNomal);
                        this.img_video.setImageResource(R.drawable.db_video_normal);
                    }
                    this.tabPosition = 3;
                    ShowScreen(PictureActivity.class, 3);
                    break;
                case R.id.main_layout_vid:
                    this.textView_title.setText(R.string.main_vid);
                    this.main_tv_vid.setTextColor(this.colorPress);
                    this.btn_edit.setVisibility(8);
                    this.img_video.setImageResource(R.drawable.db_video_press);
                    int i3 = this.tabPosition;
                    if (i3 == 1) {
                        this.main_tv_vidicon.setTextColor(this.colorNomal);
                        this.img_bells.setImageResource(R.drawable.db_bell_normal);
                    } else if (i3 == 2) {
                        this.main_tv_alarm.setTextColor(this.colorNomal);
                        this.img_logs.setImageResource(R.drawable.db_log_normal);
                    } else if (i3 == 3) {
                        this.main_tv_picture.setTextColor(this.colorNomal);
                        this.img_pic.setImageResource(R.drawable.db_pic_normal);
                    }
                    this.tabPosition = 4;
                    ShowScreen(VideoActivity.class, 4);
                    break;
                case R.id.main_layout_vidicon:
                    this.textView_title.setText(R.string.app_name1);
                    this.main_tv_vidicon.setTextColor(this.colorPress);
                    this.btn_edit.setVisibility(0);
                    this.img_bells.setImageResource(R.drawable.db_bell_press);
                    int i4 = this.tabPosition;
                    if (i4 == 2) {
                        this.main_tv_alarm.setTextColor(this.colorNomal);
                        this.img_logs.setImageResource(R.drawable.db_log_normal);
                    } else if (i4 == 3) {
                        this.main_tv_picture.setTextColor(this.colorNomal);
                        this.img_pic.setImageResource(R.drawable.db_pic_normal);
                    } else if (i4 == 4) {
                        this.main_tv_vid.setTextColor(this.colorNomal);
                        this.img_video.setImageResource(R.drawable.db_video_normal);
                    }
                    this.tabPosition = 1;
                    ShowScreen(IpcamClientActivity1.class, 1);
                    break;
            }
        }
        return false;
    }

    private void ShowScreen(Class cls, int i) {
        LocalActivityManager localActivityManager = getLocalActivityManager();
        String simpleName = cls.getSimpleName();
        Intent intent = new Intent(this, cls);
        if (i == 2) {
            intent.putExtra(RequestParameters.POSITION, 0);
        }
        if (i == 5) {
            intent.putExtra(RequestParameters.POSITION, 1);
        }
        View decorView = localActivityManager.startActivity(simpleName, intent).getDecorView();
        this.container.removeAllViews();
        this.container.setVisibility(0);
        this.container.addView(decorView, new ViewGroup.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.e("MainActivity", "onDestroy: ");
        super.onDestroy();
        BridgeService.isAppClose = true;
        NativeCaller.iCameraDeinit();
        unregisterReceiver(this.receiver);
        Intent intent = new Intent();
        intent.setClass(this, BridgeService.class);
        stopService(intent);
        if (DataBaseHelper.getInstance(this) != null) {
            DataBaseHelper.getInstance(this).close();
        }
        ((App) getApplication()).OnDestroy();
        SystemValue.checkSDStatu = 0;
        FcmPush.unRegister();
        getPackageManager().setComponentEnabledSetting(new ComponentName(BuildConfig.APPLICATION_ID, FirebaseInstanceIdInternalReceiver.class.getName()), 2, 1);
        NativeCaller.iCameraStop();
        this.mHandler.removeMessages(3);
        SystemValue.isStartRun = false;
        do {
        } while (!NativeCaller.iCameraOver());
        getLocalActivityManager().removeAllActivities();
    }

    public void initExitPopupWindow_more_funtion() {
        this.popv_more_funtion = LayoutInflater.from(this).inflate(R.layout.popup_more_funtion, (ViewGroup) null);
        this.btn_more_about = (LinearLayout) this.popv_more_funtion.findViewById(R.id.btn_more_about);
        this.btn_more_about.setOnClickListener(this);
        this.btn_more_setting = (LinearLayout) this.popv_more_funtion.findViewById(R.id.btn_more_setting);
        this.btn_more_setting.setOnClickListener(this);
        this.btn_zhuxiao = (LinearLayout) this.popv_more_funtion.findViewById(R.id.btn_zhuxiao);
        this.btn_zhuxiao.setOnClickListener(this);
        this.popupWindow_more_funtion = new PopupWindow(this.popv_more_funtion, -1, -2);
        this.popupWindow_more_funtion.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_more_funtion.setFocusable(true);
        this.popupWindow_more_funtion.setInputMethodMode(1);
        this.popupWindow_more_funtion.setSoftInputMode(16);
        this.popupWindow_more_funtion.setOutsideTouchable(true);
        this.popupWindow_more_funtion.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_more_funtion.setFocusableInTouchMode(true);
        this.popv_more_funtion.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                MainActivity.access$408(MainActivity.this);
                if (i == 82 && MainActivity.this.tap == 2) {
                    MainActivity.this.popupWindow_more_funtion.dismiss();
                    int unused = MainActivity.this.tap = 0;
                }
                return false;
            }
        });
        this.popupWindow_more_funtion.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                MainActivity.this.popupWindow_more_funtion.dismiss();
                int unused = MainActivity.this.tap = 0;
            }
        });
        this.popupWindow_more_funtion.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 4) {
                    MainActivity.this.popupWindow_more_funtion.dismiss();
                    int unused = MainActivity.this.tap = 0;
                }
                return false;
            }
        });
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        switch (view.getId()) {
            case R.id.btnDevice:
                this.nowSel = 0;
                String simpleName = MainActivity.class.getSimpleName();
                Log.e(simpleName, "table now " + this.nowSel);
                int i = this.prevSel;
                int i2 = this.nowSel;
                if (i != i2) {
                    setOtherButton(i2, i);
                    ShowScreen(IpcamClientActivity1.class, 1);
                    this.prevSel = this.nowSel;
                    return;
                }
                return;
            case R.id.btnRecordFile:
                this.nowSel = 2;
                String simpleName2 = MainActivity.class.getSimpleName();
                Log.e(simpleName2, "table now " + this.nowSel);
                int i3 = this.prevSel;
                int i4 = this.nowSel;
                if (i3 != i4) {
                    setOtherButton(i4, i3);
                    ShowScreen(VideoActivity.class, 4);
                    this.prevSel = this.nowSel;
                    return;
                }
                return;
            case R.id.btnSnapFile:
                this.nowSel = 1;
                String simpleName3 = MainActivity.class.getSimpleName();
                Log.e(simpleName3, "table now " + this.nowSel);
                int i5 = this.prevSel;
                int i6 = this.nowSel;
                if (i5 != i6) {
                    setOtherButton(i6, i5);
                    ShowScreen(PictureActivity.class, 3);
                    this.prevSel = this.nowSel;
                    return;
                }
                return;
            case R.id.btn_edit:
                MainEditInterface mainEditInterface2 = mainEditInterface;
                if (mainEditInterface2 != null) {
                    this.isEdited = mainEditInterface2.EditOnclick(this.btn_edit, this.isEdited);
                }
                Log.d("mainactivity", "isEdited:" + this.isEdited);
                return;
            case R.id.btn_more_about:
                moveTaskToBack(true);
                this.popupWindow_more_funtion.dismiss();
                return;
            case R.id.btn_more_setting:
                if (bFolder(this.strRingtoneFolder)) {
                    Log.i("iBtnRingtone", "�������������������ť");
                    String string = this.preAudio.getString("doorbell_audio_id", "default");
                    Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
                    intent.putExtra("android.intent.extra.ringtone.TYPE", 1);
                    intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", false);
                    CommonUtil.Log(1, "doorbell_audio:" + string);
                    if (!string.equals("default")) {
                        intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", Uri.parse(string));
                    }
                    intent.putExtra("android.intent.extra.ringtone.TITLE", getResources().getString(R.string.soft_about_setting2));
                    startActivityForResult(intent, 0);
                }
                this.popupWindow_more_funtion.dismiss();
                return;
            case R.id.btn_zhuxiao:
                SystemValue.isStartRun = false;
                finish();
                System.exit(0);
                this.popupWindow_more_funtion.dismiss();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            Log.e("test", "��������");
            if (i == 0) {
                try {
                    Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
                    if (uri != null) {
                        String realPathFromURI = getRealPathFromURI(uri);
                        Log.d("tets", "sounduri:" + realPathFromURI);
                        if (realPathFromURI != null) {
                            SharedPreferences.Editor edit = this.preAudio.edit();
                            edit.putString("doorbell_audio", realPathFromURI);
                            edit.putString("doorbell_audio_id", uri.toString());
                            edit.commit();
                        }
                    } else {
                        SharedPreferences.Editor edit2 = this.preAudio.edit();
                        edit2.putString("doorbell_audio", "no");
                        edit2.commit();
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.soft_about_setting3), 0).show();
                    }
                } catch (Exception unused) {
                    SharedPreferences.Editor edit3 = this.preAudio.edit();
                    edit3.putString("doorbell_audio", "default");
                    edit3.commit();
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.soft_about_setting4), 0).show();
                }
            } else if (i == 1) {
                try {
                    Uri uri2 = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
                    if (uri2 != null) {
                        String realPathFromURI2 = getRealPathFromURI(uri2);
                        Log.d("tets", "sounduri:" + realPathFromURI2);
                        if (realPathFromURI2 != null) {
                            SharedPreferences.Editor edit4 = this.preAudio.edit();
                            edit4.putString("doorbell_audio_alarm", realPathFromURI2);
                            edit4.commit();
                        }
                    } else {
                        SharedPreferences.Editor edit5 = this.preAudio.edit();
                        edit5.putString("doorbell_audio_alarm", "no_alarm");
                        edit5.commit();
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.soft_about_setting5), 0).show();
                    }
                } catch (Exception unused2) {
                    SharedPreferences.Editor edit6 = this.preAudio.edit();
                    edit6.putString("doorbell_audio_alarm", "default_alarm");
                    edit6.commit();
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.soft_about_setting6), 0).show();
                }
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private boolean bFolder(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        return false;
    }

    private String getRealPathFromURI(Uri uri) {
        Cursor managedQuery = managedQuery(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
        int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
        managedQuery.moveToFirst();
        return managedQuery.getString(columnIndexOrThrow);
    }

    private class MyBroadCast extends BroadcastReceiver {
        private MyBroadCast() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ContentCommon.MAIN_KEY_MENU)) {
                Log.e("test", "ContentCommon.MAIN_KEY_MENU");
                VibratorUtil.Vibrate(MainActivity.this, 20);
            } else if (intent.getAction().equals(ContentCommon.MAIN_KEY_BACK)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!MainActivity.this.bClicked) {
                    boolean unused = MainActivity.this.bClicked = true;
                    long unused2 = MainActivity.this.startTime = currentTimeMillis;
                    MainActivity mainActivity = MainActivity.this;
                    Toast.makeText(mainActivity, mainActivity.getString(R.string.click_again_exit), 0).show();
                    MainActivity.this.mHandler.sendEmptyMessageDelayed(3, 2000);
                } else if (currentTimeMillis - MainActivity.this.startTime <= 2000) {
                    FcmPush.unRegister();
                    if (DataBaseHelper.getInstance(MainActivity.this) != null) {
                        DataBaseHelper.getInstance(MainActivity.this).close();
                    }
                    MainActivity.this.getPackageManager().setComponentEnabledSetting(new ComponentName(BuildConfig.APPLICATION_ID, FirebaseInstanceIdInternalReceiver.class.getName()), 2, 1);
                    NativeCaller.iCameraStop();
                    MainActivity.this.mHandler.removeMessages(3);
                    SystemValue.isStartRun = false;
                    BridgeService.isAppClose = true;
                    MainActivity.this.finish();
                    do {
                    } while (!NativeCaller.iCameraOver());
                    NativeCaller.iCameraDeinit();
                    MainActivity mainActivity2 = MainActivity.this;
                    mainActivity2.unregisterReceiver(mainActivity2.receiver);
                    Intent intent2 = new Intent();
                    intent2.setClass(MainActivity.this, BridgeService.class);
                    MainActivity.this.stopService(intent2);
                    SystemValue.checkSDStatu = 0;
                    MainActivity.this.getLocalActivityManager().removeAllActivities();
                    System.exit(0);
                    long unused3 = MainActivity.this.startTime = currentTimeMillis;
                }
            }
        }
    }

    private class AlartClick implements LocationAlartDialog.AlartDialogClick {
        private AlartClick() {
        }

        public void OnConfirmClick() {
            MainActivity.this.sendBroadcast(new Intent("setButtonEn"));
            MainActivity.this.setButtonEn();
            MyPreference.getInstance(MainActivity.this).SetIsAgree(true);
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    return null;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                }

                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    PermissionHelper unused = MainActivity.this.permissionHelper = new PermissionHelper(MainActivity.this, MainActivity.this);
                    MainActivity.this.permissionHelper.requestPermissions();
                }
            }.execute(new Void[0]);
        }

        public void OnCancelClick() {
            MainActivity.this.sendBroadcast(new Intent("setButtonEn"));
            MainActivity.this.setButtonEn();
            MyPreference.getInstance(MainActivity.this).SetIsAgree(false);
            MainActivity mainActivity = MainActivity.this;
            Toast.makeText(mainActivity, mainActivity.getResources().getString(R.string.alart_disagree_txt), 1).show();
        }
    }

    private void showDialog() {
        LocationAlartDialog locationAlartDialog = this.alartDialog;
        if (locationAlartDialog == null || !locationAlartDialog.isShowing()) {
            this.alartDialog = new LocationAlartDialog(this, R.style.dialog1);
            this.alartDialog.setCancelable(false);
            this.alartDialog.setCanceledOnTouchOutside(false);
            LocationAlartDialog locationAlartDialog2 = this.alartDialog;
            if (locationAlartDialog2 != null) {
                locationAlartDialog2.setAlartClickListener(new AlartClick());
            }
            this.alartDialog.show();
        }
    }

    public void setButtonDis() {
        this.btnDevice.setEnabled(false);
        this.btnRecord.setEnabled(false);
        this.btnSnap.setEnabled(false);
    }

    public void setButtonEn() {
        this.btnDevice.setEnabled(true);
        this.btnRecord.setEnabled(true);
        this.btnSnap.setEnabled(true);
    }
}
