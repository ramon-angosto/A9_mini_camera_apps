package shix.ihdbell.project;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.mapapi.MKEvent;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.shix.fcmpush1.FcmPush;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import object.p2pipcam.adapter.CameraEditAdapter;
import object.p2pipcam.adapter.CameraListAdapter;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.gridview.SlidingMenu;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.DataBaseHelper;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;
import shix.ihdbell.project.MainActivity;

public class IpcamClientActivity extends BaseActivity implements View.OnClickListener, BridgeService.IpcamClientInterface, AdapterView.OnItemClickListener, MainActivity.MainEditInterface {
    private static final String STR_DID = "did";
    private static final String STR_MSG_PARAM = "msgparam";
    private static final String TAG = "IpcamClientActivity";
    private static int cameraStatus;
    public static KeyguardManager.KeyguardLock keyguardLock;
    public static CameraListAdapter listAdapter;
    /* access modifiers changed from: private */
    public Handler PPPPMsgHandler = new Handler() {
        public void handleMessage(Message message) {
            int i;
            Bundle data = message.getData();
            int i2 = data.getInt(IpcamClientActivity.STR_MSG_PARAM);
            int i3 = message.what;
            String unused = IpcamClientActivity.this.did = data.getString("did");
            Log.d("test", "did==" + IpcamClientActivity.this.did + "  msgType=" + i3);
            if (i3 == 0) {
                Intent intent = new Intent("camera_status_change");
                intent.putExtra(ContentCommon.STR_CAMERA_ID, IpcamClientActivity.this.did);
                intent.putExtra(ContentCommon.STR_PPPP_STATUS, i2);
                IpcamClientActivity.this.sendBroadcast(intent);
                if (IpcamClientActivity.listAdapter.UpdataCameraStatus(IpcamClientActivity.this.did, i2)) {
                    IpcamClientActivity.listAdapter.notifyDataSetChanged();
                    if (SystemValue.FCMTOKEN != null && SystemValue.FCMTOKEN.length() > 5) {
                        NativeCaller.TransferMessage(IpcamClientActivity.this.did, "fcm_register.cgi?token=" + SystemValue.FCMTOKEN + "&validity=" + 168 + "&apiKey=" + ContentCommon.SERVERKEY + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                    }
                    if (i2 == 2) {
                        if (SystemValue.FCMTOKEN == null || SystemValue.FCMTOKEN.length() < 3) {
                            SystemValue.FCMTOKEN = IpcamClientActivity.this.preAudio.getString("FCMdevToken", "");
                        } else {
                            SharedPreferences.Editor edit = IpcamClientActivity.this.preAudio.edit();
                            edit.putString("FCMdevToken", SystemValue.FCMTOKEN);
                            edit.commit();
                        }
                        IpcamClientActivity ipcamClientActivity = IpcamClientActivity.this;
                        SystemValue.doorBellAdmin = ipcamClientActivity.retrunUser(ipcamClientActivity.did);
                        IpcamClientActivity ipcamClientActivity2 = IpcamClientActivity.this;
                        SystemValue.doorBellPass = ipcamClientActivity2.retrunPwd(ipcamClientActivity2.did);
                        if (SystemValue.FCMTOKEN == null || SystemValue.FCMTOKEN.length() <= 5) {
                            i = 1;
                        } else {
                            i = 1;
                            NativeCaller.TransferMessage(IpcamClientActivity.this.did, "fcm_register.cgi?token=" + SystemValue.FCMTOKEN + "&validity=" + 168 + "&apiKey=" + ContentCommon.SERVERKEY + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                        }
                        CommonUtil.Log(i, "SystemValue.BELL_UDID:" + SystemValue.BELL_UDID);
                        if (SystemValue.BELL_UDID != null && SystemValue.BELL_UDID.length() > 5 && SystemValue.BELL_UDID.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length > i) {
                            SystemValue.BELL_UDID = SystemValue.BELL_UDID.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[i];
                        }
                        CommonUtil.Log(1, "SystemValue.BELL_UDID1:" + SystemValue.BELL_UDID);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (SystemValue.BELL_UDID != null && SystemValue.BELL_UDID.length() > 5) {
                            NativeCaller.TransferMessage(IpcamClientActivity.this.did, "check_session_state.cgi?&filename=" + SystemValue.BELL_UDID + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                        }
                        if (ContentCommon.MZ_STRING == null || ContentCommon.MZ_STRING.length() < 6) {
                            ContentCommon.MZ_STRING = PushManager.getPushId(IpcamClientActivity.this);
                        }
                        if (ContentCommon.XM_STRING == null || ContentCommon.XM_STRING.length() < 6) {
                            ContentCommon.XM_STRING = MiPushClient.getRegId(IpcamClientActivity.this);
                        }
                        if (ContentCommon.HW_STRING == null || ContentCommon.HW_STRING.length() < 6) {
                            ContentCommon.HW_STRING = IpcamClientActivity.this.preAudio.getString("HW_STRING", "");
                        } else {
                            SharedPreferences.Editor edit2 = IpcamClientActivity.this.preAudio.edit();
                            edit2.putString("HW_STRING", ContentCommon.HW_STRING);
                            edit2.commit();
                        }
                        if (ContentCommon.MZ_STRING == null || ContentCommon.MZ_STRING.length() < 6) {
                            ContentCommon.MZ_STRING = IpcamClientActivity.this.preAudio.getString("MZ_STRING", "");
                        } else {
                            SharedPreferences.Editor edit3 = IpcamClientActivity.this.preAudio.edit();
                            edit3.putString("MZ_STRING", ContentCommon.MZ_STRING);
                            edit3.commit();
                        }
                        if (ContentCommon.XM_STRING == null || ContentCommon.XM_STRING.length() < 6) {
                            ContentCommon.XM_STRING = IpcamClientActivity.this.preAudio.getString("XM_STRING", "");
                        } else {
                            SharedPreferences.Editor edit4 = IpcamClientActivity.this.preAudio.edit();
                            edit4.putString("XM_STRING", ContentCommon.XM_STRING);
                            edit4.commit();
                        }
                        IpcamClientActivity ipcamClientActivity3 = IpcamClientActivity.this;
                        String access$500 = ipcamClientActivity3.retrunName(ipcamClientActivity3.did);
                        NativeCaller.TransferMessage(IpcamClientActivity.this.did, "android_push_register.cgi?&validity=120&hw_device_token=" + ContentCommon.HW_STRING + "&hw_client_id=" + ContentCommon.HW_APP_ID + "&hw_client_secret=" + ContentCommon.HW_APP_KEY + "&xm_registration_id=" + ContentCommon.XM_STRING + "&xm_app_secret=" + ContentCommon.XM_APPSECRET + "&xm_package_name=" + ContentCommon.XM_PACKAGE_NAME + "&mz_push_id=" + ContentCommon.MZ_STRING + "&mz_app_id=" + ContentCommon.MZ_APP_ID + "&mz_app_secret=" + ContentCommon.MZ_APPSECRET + "&pushtype=" + IpcamClientActivity.this.pustType + "&phonetype=" + IpcamClientActivity.this.devType + "&devname=" + access$500 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                    }
                    if (i2 == 5 || i2 == 3 || i2 == 6 || i2 == 7 || i2 == 8 || i2 == 9 || i2 == 10) {
                        NativeCaller.StopPPPP(IpcamClientActivity.this.did);
                    }
                }
            } else if (i3 == 1) {
                Log.d("shix", "shix:" + i2);
                boolean UpdataCameraType = IpcamClientActivity.listAdapter.UpdataCameraType(IpcamClientActivity.this.did, i2);
            } else if (i3 == 200) {
                IpcamClientActivity.listAdapter.notifyDataSetChanged();
            } else if (i3 == 1021) {
                IpcamClientActivity.this.splash_img.setVisibility(8);
            } else if (i3 == 10234) {
                IpcamClientActivity.listAdapter.notifyDataSetChanged();
            }
        }
    };
    private final int SNAPSHOT = MKEvent.ERROR_LOCATION_FAILED;
    private LinearLayout addCameraListHeader;
    private Button btnDelCamera;
    private Button btnEdit;
    private Button btnSelectAll;
    private Button btnSelectReverse;
    private Button btn_menu;
    /* access modifiers changed from: private */
    public ListView cameraListView = null;
    private LinearLayout delBottomLayout;
    /* access modifiers changed from: private */
    public int devType;
    /* access modifiers changed from: private */
    public String did;
    /* access modifiers changed from: private */
    public CameraEditAdapter editAdapter;
    private DataBaseHelper helper = null;
    /* access modifiers changed from: private */
    public ImageButton imageButtonRefresh;
    private ImageButton imageButton_apphome;
    /* access modifiers changed from: private */
    public boolean isCheck = false;
    private boolean isEdited = false;
    private final BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            intent.getAction();
            Log.e("test", "zhaogenghuai --");
        }
    };
    private SlidingMenu mMenu;
    private BroadcastReceiver1 networkBroadcast = new BroadcastReceiver1();
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_more_funtion;
    private View popv_more_funtion;
    /* access modifiers changed from: private */
    public SharedPreferences preAudio;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog;
    /* access modifiers changed from: private */
    public int pustType;
    private CameraInfoReceiver receiver = null;
    /* access modifiers changed from: private */
    public int screen_height;
    /* access modifiers changed from: private */
    public int screen_width;
    /* access modifiers changed from: private */
    public RelativeLayout splash_img;
    private String strAlarmFolder = "/sdcard/music/alarms";
    private String strRingtoneFolder = "/sdcard/music/ringtone";
    private Set<String> tags;
    private TextView textView_show;
    private int timeOne = 0;
    private int timeTag = 0;
    private int timeTwo = 0;

    public void CallBackDevType(String str, int i) {
    }

    public static void changerCameraStatus(int i) {
        cameraStatus = i;
    }

    public static boolean isServiceWorked(Context context, String str) {
        ArrayList arrayList = (ArrayList) ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningServices(Integer.MAX_VALUE);
        for (int i = 0; i < arrayList.size(); i++) {
            if (((ActivityManager.RunningServiceInfo) arrayList.get(i)).service.getClassName().toString().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        Set<String> keySet;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.ipcamclient);
        this.preAudio = getSharedPreferences("shix_zhao_audio", 0);
        SystemValue.isDeamon = this.preAudio.getInt("deamontype", 0);
        this.screen_width = getWindowManager().getDefaultDisplay().getWidth();
        this.screen_height = getWindowManager().getDefaultDisplay().getHeight();
        ContentCommon.TIME_UTC = TimeZone.getDefault().getDisplayName(false, 0);
        Log.e("test", "ContentCommon.TIME_UTC333:" + ContentCommon.TIME_UTC);
        findView();
        setControlListener();
        listAdapter = new CameraListAdapter(this, this);
        this.editAdapter = new CameraEditAdapter(this);
        this.cameraListView.setAdapter(listAdapter);
        this.helper = DataBaseHelper.getInstance(this);
        Log.e(TAG, "### onCreate");
        initCameraList();
        BridgeService.setIpcamClientInterface(this);
        initExitPopupWindow_more_funtion();
        BridgeService.isAppClose = false;
        Intent intent = new Intent();
        intent.setClass(this, BridgeService.class);
        startService(intent);
        new Thread(new Runnable() {
            public void run() {
                try {
                    NativeCaller.PPPPInitial(SystemValue.SystemSerVer, SystemValue.SystemSerVer.length());
                    long time = new Date().getTime();
                    NativeCaller.PPPPNetworkDetect();
                    NativeCaller.Init();
                    Log.e(IpcamClientActivity.TAG, "run: NativeCaller init");
                    Thread.sleep(500);
                    IpcamClientActivity.this.StartCameraPPPP();
                    if (new Date().getTime() - time <= 3000) {
                        Thread.sleep(3000);
                    }
                    Message message = new Message();
                    message.what = 1021;
                    IpcamClientActivity.this.PPPPMsgHandler.sendMessage(message);
                } catch (Exception unused) {
                }
            }
        }).start();
        this.isCheck = true;
        new Thread() {
            public void run() {
                while (IpcamClientActivity.this.isCheck) {
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("test", "zhaogenghua0 isCheck");
                    int count = IpcamClientActivity.listAdapter.getCount();
                    for (int i = 0; i < count; i++) {
                        CameraParamsBean onItem = IpcamClientActivity.listAdapter.getOnItem(i);
                        if (!(onItem == null || onItem == null)) {
                            int status = onItem.getStatus();
                            String did = onItem.getDid();
                            String pwd = onItem.getPwd();
                            String user = onItem.getUser();
                            if (SystemValue.FCMTOKEN == null || SystemValue.FCMTOKEN.length() < 3) {
                                SystemValue.FCMTOKEN = FcmPush.getToken();
                                CommonUtil.Log(1, "zhaogenghuai--SystemValue.FCMTOKEN:" + SystemValue.FCMTOKEN);
                                if (status == 2 && SystemValue.FCMTOKEN != null && SystemValue.FCMTOKEN.length() > 5) {
                                    NativeCaller.TransferMessage(did, "fcm_register.cgi?token=" + SystemValue.FCMTOKEN + "&validity=" + 168 + "&apiKey=" + ContentCommon.SERVERKEY + "&loginuse=" + user + "&loginpas=" + pwd + "&user=" + user + "&pwd=" + pwd, 1);
                                }
                            }
                            if (!(status == 2 || status == 10 || status == 5 || status == 8)) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                                Log.d("test", "zhaogenghua2 did:" + did);
                                NativeCaller.StopPPPP(did);
                                IpcamClientActivity.this.StartPPPP(did, user, pwd, "test");
                            }
                        }
                    }
                }
            }
        }.start();
        new Thread() {
            public void run() {
                while (IpcamClientActivity.this.isCheck) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("test", "zhaogenghua0 isCheck12");
                }
            }
        }.start();
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.networkBroadcast, intentFilter);
        registerReceiver(this.mBatInfoReceiver, intentFilter);
        keyguardLock = ((KeyguardManager) getSystemService("keyguard")).newKeyguardLock("test");
        SystemValue.Token = this.preAudio.getInt(Constants.EXTRA_KEY_TOKEN, 0);
        if (SystemValue.Token == 0) {
            SystemValue.Token = (int) ((Math.random() * 9000.0d) + 1000.0d);
            SharedPreferences.Editor edit = this.preAudio.edit();
            edit.putInt(Constants.EXTRA_KEY_TOKEN, SystemValue.Token);
            edit.commit();
        }
        SystemValue.ClickMessageValue = 0;
        SystemValue.ClickMessageValue = getIntent().getIntExtra("zhaogenghuaiPush1", 0);
        CommonUtil.Log(1, "zhaogenghuaiPush1==" + SystemValue.ClickMessageValue + "  SystemValue.BELL_UDID:" + SystemValue.BELL_UDID);
        Bundle extras = getIntent().getExtras();
        if (!(extras == null || (keySet = extras.keySet()) == null)) {
            for (String str : keySet) {
                Log.d("test", "zhaogenghuai-----Intent :" + str + "  " + getIntent().getStringExtra(str));
            }
        }
        SystemValue.FCMTOKEN = FcmPush.getToken();
        if (SystemValue.mPlayer != null) {
            CommonUtil.Log(1, "zhao1234--NOTIFACTION_CLICKED_TYPE");
            SystemValue.mPlayer.stop();
            SystemValue.mPlayer.release();
            SystemValue.mPlayer = null;
        }
        SystemValue.isSoftRun = true;
        try {
            Boolean valueOf = Boolean.valueOf(CommonUtil.isFlyme());
            CommonUtil.Log(1, "MZ----ismz:" + valueOf);
            Boolean valueOf2 = Boolean.valueOf(CommonUtil.isHW());
            CommonUtil.Log(1, "HW----ishw:" + valueOf2);
            Boolean valueOf3 = Boolean.valueOf(CommonUtil.isMIUI());
            CommonUtil.Log(1, "HW----isxm:" + valueOf3);
            if (valueOf2.booleanValue()) {
                com.huawei.android.pushagent.api.PushManager.requestToken(this);
                if (shouldInit()) {
                    MiPushClient.registerPush(this, ContentCommon.XM_APP_ID, ContentCommon.XM_APP_KEY);
                }
                this.pustType = 48;
                this.devType = 1;
            }
            if (valueOf.booleanValue()) {
                PushManager.register(this, ContentCommon.MZ_APP_ID, ContentCommon.MZ_APP_KEY);
                if (shouldInit()) {
                    MiPushClient.registerPush(this, ContentCommon.XM_APP_ID, ContentCommon.XM_APP_KEY);
                }
                this.pustType = 24;
                this.devType = 3;
            }
            if (valueOf3.booleanValue()) {
                if (shouldInit()) {
                    MiPushClient.registerPush(this, ContentCommon.XM_APP_ID, ContentCommon.XM_APP_KEY);
                }
                com.huawei.android.pushagent.api.PushManager.requestToken(this);
                this.pustType = 48;
                this.devType = 2;
            }
            if (!valueOf2.booleanValue() && !valueOf.booleanValue() && !valueOf3.booleanValue()) {
                PushManager.register(this, ContentCommon.MZ_APP_ID, ContentCommon.MZ_APP_KEY);
                if (shouldInit()) {
                    MiPushClient.registerPush(this, ContentCommon.XM_APP_ID, ContentCommon.XM_APP_KEY);
                }
                this.pustType = 24;
                this.devType = 0;
            }
        } catch (Exception unused) {
        }
    }

    public String getEmuiVersion() {
        Class[] clsArr = {String.class};
        Object[] objArr = {"ro.build.version.emui"};
        try {
            Class<?> cls = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES);
            String str = (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
            Log.d(TAG, "get EMUI version is:" + str);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return "";
        } catch (ClassNotFoundException unused) {
            Log.e(TAG, " getEmuiVersion wrong, ClassNotFoundException");
            return "";
        } catch (LinkageError unused2) {
            Log.e(TAG, " getEmuiVersion wrong, LinkageError");
            return "";
        } catch (NoSuchMethodException unused3) {
            Log.e(TAG, " getEmuiVersion wrong, NoSuchMethodException");
            return "";
        } catch (NullPointerException unused4) {
            Log.e(TAG, " getEmuiVersion wrong, NullPointerException");
            return "";
        } catch (Exception unused5) {
            Log.e(TAG, " getEmuiVersion wrong");
            return "";
        }
    }

    private boolean shouldInit() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        String packageName = getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid && packageName.equals(next.processName)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void StartCameraPPPP() {
        int count = listAdapter.getCount();
        for (int i = 0; i < count; i++) {
            CameraParamsBean onItem = listAdapter.getOnItem(i);
            try {
                Thread.sleep(10);
            } catch (Exception unused) {
            }
            StartPPPP(onItem.getDid(), onItem.getUser(), onItem.getPwd(), "test");
        }
    }

    private void findView() {
        findViewById(R.id.relative_1).setOnClickListener(this);
        findViewById(R.id.relative_2).setOnClickListener(this);
        findViewById(R.id.relative_3).setOnClickListener(this);
        findViewById(R.id.relative_4).setOnClickListener(this);
        findViewById(R.id.relative_5).setOnClickListener(this);
        findViewById(R.id.relative_6).setOnClickListener(this);
        findViewById(R.id.relative_7).setOnClickListener(this);
        findViewById(R.id.relative_10).setOnClickListener(this);
        this.mMenu = (SlidingMenu) findViewById(R.id.id_menu);
        this.btn_menu = (Button) findViewById(R.id.btn_menu);
        this.btn_menu.setOnClickListener(this);
        this.splash_img = (RelativeLayout) findViewById(R.id.splash_img);
        this.cameraListView = (ListView) findViewById(R.id.listviewCamera);
        this.imageButton_apphome = (ImageButton) findViewById(R.id.app_home);
        this.addCameraListHeader = (LinearLayout) findViewById(R.id.addvidicon_listitem);
        this.imageButtonRefresh = (ImageButton) findViewById(R.id.refresh);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        this.addCameraListHeader.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IpcamClientActivity.this.startActivity(new Intent(IpcamClientActivity.this, AddCameraActivity.class));
                IpcamClientActivity.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
        this.imageButtonRefresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(IpcamClientActivity.this, 20);
                SystemValue.TAG_CAMERLIST = 0;
                new GetDataTask().execute(new Void[0]);
            }
        });
        this.imageButton_apphome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("tag", "screen_width:" + IpcamClientActivity.this.screen_width + "  screen_height:" + IpcamClientActivity.this.screen_height);
            }
        });
        this.btnEdit = (Button) findViewById(R.id.btn_edit);
        this.btnSelectAll = (Button) findViewById(R.id.main_selectall);
        this.btnSelectReverse = (Button) findViewById(R.id.main_selectreverse);
        this.btnDelCamera = (Button) findViewById(R.id.main_delete_camera);
        this.delBottomLayout = (LinearLayout) findViewById(R.id.del_bottom_layout);
    }

    /* access modifiers changed from: private */
    public void StopCameraPPPP() {
        int count = listAdapter.getCount();
        for (int i = 0; i < count; i++) {
            CameraParamsBean onItem = listAdapter.getOnItem(i);
            NativeCaller.StopPPPP(onItem.getDid());
            try {
                Thread.sleep(300);
            } catch (Exception unused) {
            }
            StartPPPP(onItem.getDid(), onItem.getUser(), onItem.getPwd(), "test");
        }
    }

    private void setControlListener() {
        this.cameraListView.setOnItemClickListener(this);
        this.btnEdit.setOnClickListener(this);
        this.btnSelectAll.setOnClickListener(this);
        this.btnSelectReverse.setOnClickListener(this);
        this.btnDelCamera.setOnClickListener(this);
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        int id = view.getId();
        if (id == R.id.btn_edit) {
            int count = listAdapter.getCount();
            if (this.isEdited) {
                this.isEdited = false;
                this.addCameraListHeader.setVisibility(0);
                Log.e("###EditOnclick", "onclick");
                this.delBottomLayout.setVisibility(8);
                this.btnEdit.setText(getResources().getString(R.string.main_edit));
                this.cameraListView.setAdapter(listAdapter);
            } else if (count > 0) {
                this.addCameraListHeader.setVisibility(8);
                this.isEdited = true;
                this.delBottomLayout.setVisibility(0);
                this.btnEdit.setText(getResources().getString(R.string.done));
                this.cameraListView.setAdapter(this.editAdapter);
            } else {
                showToast((int) R.string.main_plea_addcam);
            }
        } else if (id == R.id.btn_menu) {
            this.mMenu.toggle();
        } else if (id != R.id.main_delete_camera) {
            switch (id) {
                case R.id.main_selectall:
                    this.editAdapter.selectAll(true);
                    this.editAdapter.notifyDataSetChanged();
                    return;
                case R.id.main_selectreverse:
                    this.editAdapter.reverseSelect(false);
                    this.editAdapter.notifyDataSetChanged();
                    return;
                default:
                    switch (id) {
                        case R.id.relative_1:
                            this.mMenu.toggle();
                            return;
                        case R.id.relative_10:
                            Intent intent = new Intent(this, AlarmActivity.class);
                            intent.putExtra(RequestParameters.POSITION, 1);
                            startActivity(intent);
                            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                            return;
                        case R.id.relative_2:
                            Intent intent2 = new Intent(this, AlarmActivity.class);
                            intent2.putExtra(RequestParameters.POSITION, 0);
                            startActivity(intent2);
                            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                            return;
                        case R.id.relative_3:
                            startActivity(new Intent(this, PictureActivity.class));
                            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                            return;
                        case R.id.relative_4:
                            startActivity(new Intent(this, VideoActivity.class));
                            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                            return;
                        case R.id.relative_5:
                            if (bFolder(this.strRingtoneFolder)) {
                                String string = this.preAudio.getString("doorbell_audio_id", "default");
                                Intent intent3 = new Intent("android.intent.action.RINGTONE_PICKER");
                                intent3.putExtra("android.intent.extra.ringtone.TYPE", 1);
                                intent3.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", false);
                                CommonUtil.Log(1, "doorbell_audio:" + string);
                                if (!string.equals("default")) {
                                    intent3.putExtra("android.intent.extra.ringtone.EXISTING_URI", Uri.parse(string));
                                }
                                intent3.putExtra("android.intent.extra.ringtone.TITLE", getResources().getString(R.string.soft_about_setting2));
                                startActivityForResult(intent3, 0);
                                return;
                            }
                            return;
                        case R.id.relative_6:
                            startActivity(new Intent(this, AboutActivity.class));
                            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                            return;
                        case R.id.relative_7:
                            if (this.popupWindow_more_funtion != null) {
                                this.textView_show.setText(R.string.menu_8_show);
                                this.popupWindow_more_funtion.showAtLocation(this.btnEdit, 80, 0, 0);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
            }
        } else if (this.editAdapter.hasSelect) {
            showDelSureDialog();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
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
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.soft_about_setting3), 1).show();
                    }
                } catch (Exception unused) {
                    SharedPreferences.Editor edit3 = this.preAudio.edit();
                    edit3.putString("doorbell_audio", "default");
                    edit3.commit();
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.soft_about_setting4), 1).show();
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
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.soft_about_setting5), 1).show();
                    }
                } catch (Exception unused2) {
                    SharedPreferences.Editor edit6 = this.preAudio.edit();
                    edit6.putString("doorbell_audio_alarm", "default_alarm");
                    edit6.commit();
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.soft_about_setting6), 1).show();
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

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            this.mMenu.toggle();
            return true;
        } else if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        } else {
            SystemValue.isStartRun = false;
            moveTaskToBack(true);
            return true;
        }
    }

    private void showDelSureDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.del_alert);
        builder.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                new AsyncTask<Void, Void, Void>() {
                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        ProgressDialog unused = IpcamClientActivity.this.progressDialog = new ProgressDialog(IpcamClientActivity.this);
                        IpcamClientActivity.this.progressDialog.setMessage(IpcamClientActivity.this.getResources().getString(R.string.main_show_delecting));
                        IpcamClientActivity.this.progressDialog.setCancelable(false);
                        IpcamClientActivity.this.progressDialog.show();
                    }

                    /* access modifiers changed from: protected */
                    public Void doInBackground(Void... voidArr) {
                        ArrayList<String> delCameraSize = IpcamClientActivity.this.editAdapter.delCameraSize();
                        for (int i = 0; i < delCameraSize.size(); i++) {
                            String str = delCameraSize.get(i);
                            SystemValue.doorBellAdmin = IpcamClientActivity.this.retrunUser(str);
                            SystemValue.doorBellPass = IpcamClientActivity.this.retrunPwd(str);
                            NativeCaller.TransferMessage(str, "fcm_delete.cgi?&token=" + SystemValue.FCMTOKEN + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                            NativeCaller.TransferMessage(str, "android_push_delete.cgi.cgi?&hw_device_token=" + ContentCommon.HW_STRING + "&xm_registration_id=" + ContentCommon.XM_STRING + "&mz_push_id=" + ContentCommon.MZ_STRING + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                        }
                        ArrayList<String> delCamera = IpcamClientActivity.this.editAdapter.delCamera();
                        Intent intent = new Intent("del_add_modify_camera");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        for (int i2 = 0; i2 < delCamera.size(); i2++) {
                            String str2 = delCamera.get(i2);
                            if (IpcamClientActivity.this.delCameraFromdb(str2)) {
                                IpcamClientActivity.listAdapter.delCamera(str2);
                                NativeCaller.StopPPPP(str2);
                                IpcamClientActivity.listAdapter.notifyDataSetChanged();
                                intent.putExtra(ContentCommon.STR_CAMERA_ID, str2);
                                intent.putExtra(DataBaseHelper.KEY_TYPE, 4);
                                IpcamClientActivity.this.sendBroadcast(intent);
                            }
                        }
                        return null;
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Void voidR) {
                        IpcamClientActivity.this.progressDialog.cancel();
                        if (IpcamClientActivity.this.editAdapter.getCount() == 0) {
                            IpcamClientActivity.this.cameraListView.setVisibility(8);
                        }
                        IpcamClientActivity.this.editAdapter.notifyDataSetChanged();
                    }
                }.execute(new Void[0]);
            }
        });
        builder.setNegativeButton(R.string.str_cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* access modifiers changed from: private */
    public synchronized boolean delCameraFromdb(String str) {
        return this.helper.deleteCamera(str);
    }

    /* access modifiers changed from: private */
    public synchronized boolean UpdataCamera2db(String str, String str2, String str3, String str4, String str5) {
        return this.helper.updateCamera(str, str2, str3, str4, str5);
    }

    /* access modifiers changed from: private */
    public synchronized void addCamera2db(String str, String str2, String str3, String str4) {
        this.helper.createCamera(str, str2, str3, str4);
    }

    private void initCameraList() {
        Cursor fetchAllCameras = this.helper.fetchAllCameras();
        if (fetchAllCameras != null) {
            if (fetchAllCameras.getCount() > 0) {
                this.cameraListView.setVisibility(0);
            } else {
                this.cameraListView.setVisibility(8);
            }
            while (fetchAllCameras.moveToNext()) {
                listAdapter.AddCamera(fetchAllCameras.getString(1), fetchAllCameras.getString(2), fetchAllCameras.getString(3), fetchAllCameras.getString(4));
            }
            listAdapter.notifyDataSetChanged();
        }
        if (fetchAllCameras != null) {
            fetchAllCameras.close();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Log.d(TAG, "onResume()");
        SystemValue.TAG_CAMERLIST = 0;
        super.onResume();
        SystemValue.TAG_CAMERLIST = 0;
        listAdapter.notifyDataSetChanged();
        this.editAdapter.notifyDataSetChanged();
        if (SystemValue.arrayList.size() > 0) {
            this.cameraListView.setVisibility(0);
        } else {
            this.cameraListView.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        Log.d(TAG, "zhao-onRestart():" + SystemValue.arrayList.size());
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        Log.d(TAG, "onStart()");
        super.onStart();
        if (this.receiver == null) {
            this.receiver = new CameraInfoReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ContentCommon.STR_CAMERA_INFO_RECEIVER);
            intentFilter.addAction("back");
            intentFilter.addAction("other");
            registerReceiver(this.receiver, intentFilter);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        SystemValue.isSoftRun = false;
        ((NotificationManager) getSystemService("notification")).cancelAll();
        KeyguardManager.KeyguardLock keyguardLock2 = keyguardLock;
        if (keyguardLock2 != null) {
            keyguardLock2.reenableKeyguard();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.isCheck = false;
        if (this.helper != null) {
            this.helper = null;
        }
        SystemValue.TAG_CAMERLIST = 0;
        unregisterReceiver(this.networkBroadcast);
        unregisterReceiver(this.mBatInfoReceiver);
        unregisterReceiver(this.receiver);
        Intent intent = new Intent();
        intent.setClass(this, BridgeService.class);
        stopService(intent);
        SystemValue.checkSDStatu = 0;
        SystemValue.isSoftRun = false;
        Log.e("test", "zhaogenghuai---����onDestroy");
    }

    /* access modifiers changed from: private */
    public String retrunName(String str) {
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            if (str != null && str.equals(SystemValue.arrayList.get(i).getDid())) {
                return SystemValue.arrayList.get(i).getName();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String retrunUser(String str) {
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            if (str != null && str.equals(SystemValue.arrayList.get(i).getDid())) {
                return SystemValue.arrayList.get(i).getUser();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String retrunPwd(String str) {
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            if (str != null && str.equals(SystemValue.arrayList.get(i).getDid())) {
                return SystemValue.arrayList.get(i).getPwd();
            }
        }
        return null;
    }

    public void showSetting(int i) {
        CameraParamsBean itemCamera = listAdapter.getItemCamera(i);
        int status = itemCamera.getStatus();
        SystemValue.doorBellAdmin = itemCamera.getUser();
        SystemValue.doorBellPass = itemCamera.getPwd();
        VibratorUtil.Vibrate(this, 20);
        if (status == 2) {
            Intent intent = new Intent(this, SettingActivity.class);
            intent.putExtra(ContentCommon.STR_CAMERA_ID, itemCamera.getDid());
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, itemCamera.getName());
            startActivity(intent);
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            return;
        }
        showToast((int) R.string.main_setting_prompt);
    }

    public void BSMsgNotifyData(String str, int i, int i2) {
        Log.d(TAG, "type:" + i + " param:" + i2);
        Bundle bundle = new Bundle();
        Message obtainMessage = this.PPPPMsgHandler.obtainMessage();
        obtainMessage.what = i;
        bundle.putInt(STR_MSG_PARAM, i2);
        bundle.putString("did", str);
        obtainMessage.setData(bundle);
        this.PPPPMsgHandler.sendMessage(obtainMessage);
    }

    public void BSSnapshotNotify(String str, byte[] bArr, int i) {
        CommonUtil.Log(1, "BSSnapshotNotify");
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, i);
        if (decodeByteArray == null) {
            Log.d(TAG, "bmp can't be decode...");
        } else if (listAdapter.UpdateCameraImage(str, decodeByteArray)) {
            this.PPPPMsgHandler.sendEmptyMessage(MKEvent.ERROR_LOCATION_FAILED);
        }
    }

    public void callBackUserParams(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Log.d(DataBaseHelper.KEY_USER, "user1:" + str2 + "   pwd1" + str3 + "\nuser2:" + str4 + "   pwd2" + str5 + "\nuser3:" + str6 + "   pwd3" + str7);
        listAdapter.upadeUserAuthority(str, str6, str7);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = i;
        if (this.isEdited) {
            CameraEditAdapter cameraEditAdapter = this.editAdapter;
            if (cameraEditAdapter != null) {
                CameraParamsBean itemCamera = cameraEditAdapter.getItemCamera(i2);
                String name = itemCamera.getName();
                String did2 = itemCamera.getDid();
                String user = itemCamera.getUser();
                String pwd = itemCamera.getPwd();
                Intent intent = new Intent(this, AddCameraActivity.class);
                intent.putExtra(ContentCommon.CAMERA_OPTION, 2);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, name);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, did2);
                intent.putExtra(ContentCommon.STR_CAMERA_USER, user);
                intent.putExtra(ContentCommon.STR_CAMERA_PWD, pwd);
                intent.putExtra("pushTypeInt", 3);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            }
            return;
        }
        CameraParamsBean onItem = listAdapter.getOnItem(i2);
        Log.d("test", "00000000");
        if (onItem == null) {
            Log.d("test", "111111");
            return;
        }
        int status = onItem.getStatus();
        Log.d("test", "22222222");
        if (status == 5 || status == 7 || status == 6 || status == 3 || status == 9 || status == 10) {
            Log.d("test", "33333333");
            Log.d("test", "55555555");
            String did3 = onItem.getDid();
            String user2 = onItem.getUser();
            String pwd2 = onItem.getPwd();
            NativeCaller.StopPPPP(did3);
            StartPPPP(did3, user2, pwd2, "test");
            return;
        }
        Log.d("test", "4444444444");
        if (status == 2) {
            String did4 = onItem.getDid();
            String name2 = onItem.getName();
            String user3 = onItem.getUser();
            String pwd3 = onItem.getPwd();
            int mode = onItem.getMode();
            Intent intent2 = new Intent(this, ListeningPlayActivity.class);
            intent2.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
            intent2.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
            intent2.putExtra(ContentCommon.STR_CAMERA_NAME, name2);
            intent2.putExtra(ContentCommon.STR_CAMERA_ID, did4);
            intent2.putExtra(ContentCommon.STR_CAMERA_USER, user3);
            intent2.putExtra(ContentCommon.STR_CAMERA_PWD, pwd3);
            intent2.putExtra(ContentCommon.STR_CAMERA_SNAPSHOT, onItem.getPlayBitmap());
            intent2.putExtra("modep", mode);
            SystemValue.doorBellAdmin = user3;
            SystemValue.doorBellPass = pwd3;
            SystemValue.ISPLAY = 0;
            startActivity(intent2);
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    public void callBackDoorBellController(String str, int i) {
        Log.d("test", "shix-doorbell-did1:" + str);
        for (int i2 = 0; i2 < SystemValue.arrayList.size(); i2++) {
            if (str.equals(SystemValue.arrayList.get(i2).getDid())) {
                SystemValue.arrayList.get(i2).setIndex1(i);
                Log.d("test", "shix-doorbell-index1" + SystemValue.arrayList.get(i2).getIndex1());
            }
        }
        this.PPPPMsgHandler.sendEmptyMessage(10234);
    }

    public boolean EditOnclick(Button button, boolean z) {
        int count = listAdapter.getCount();
        if (z) {
            this.addCameraListHeader.setVisibility(0);
            Log.e("####EditOnclick", "onclick");
            this.delBottomLayout.setVisibility(8);
            button.setText(getResources().getString(R.string.main_edit));
            this.cameraListView.setAdapter(listAdapter);
            z = false;
        } else if (count > 0) {
            this.addCameraListHeader.setVisibility(8);
            z = true;
            this.delBottomLayout.setVisibility(0);
            button.setText(getResources().getString(R.string.done));
            this.cameraListView.setAdapter(this.editAdapter);
        } else {
            showToast((int) R.string.main_plea_addcam);
        }
        this.isEdited = z;
        return z;
    }

    public void initExitPopupWindow_more_funtion() {
        this.popv_more_funtion = LayoutInflater.from(this).inflate(R.layout.popup_more_exit, (ViewGroup) null);
        this.popupWindow_more_funtion = new PopupWindow(this.popv_more_funtion, -1, -2);
        this.textView_show = (TextView) this.popv_more_funtion.findViewById(R.id.textView1);
        this.popv_more_funtion.findViewById(R.id.button_ok).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IpcamClientActivity.this.finish();
                IpcamClientActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popv_more_funtion.findViewById(R.id.button_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IpcamClientActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popupWindow_more_funtion.setAnimationStyle(R.style.MainAnimationPreview);
        this.popupWindow_more_funtion.setFocusable(true);
        this.popupWindow_more_funtion.setInputMethodMode(1);
        this.popupWindow_more_funtion.setSoftInputMode(16);
        this.popupWindow_more_funtion.setOutsideTouchable(true);
        this.popupWindow_more_funtion.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_more_funtion.setFocusableInTouchMode(true);
        this.popupWindow_more_funtion.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                IpcamClientActivity.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popupWindow_more_funtion.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                IpcamClientActivity.this.popupWindow_more_funtion.dismiss();
                return false;
            }
        });
    }

    public class BroadcastReceiver1 extends BroadcastReceiver {
        public BroadcastReceiver1() {
        }

        public void onReceive(Context context, Intent intent) {
            NetworkInfo.State state = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).getState();
            if (state == null || NetworkInfo.State.CONNECTED != state) {
                SystemValue.videFram = 5;
                Log.d("test", "------------------------------------videFram = 5-----------------------------");
                return;
            }
            Log.d("test", "------------------------------------videFram = 15-----------------------------");
            SystemValue.videFram = 15;
        }
    }

    class StartPPPPThread implements Runnable {
        StartPPPPThread() {
        }

        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                IpcamClientActivity.this.StartCameraPPPP();
            } catch (Exception unused) {
            }
        }
    }

    class CamerStatuThread extends Thread {
        CameraParamsBean bean1;
        String id;

        public CamerStatuThread(CameraParamsBean cameraParamsBean) {
            this.id = cameraParamsBean.getDid();
            this.bean1 = cameraParamsBean;
        }

        public void run() {
            super.run();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.bean1.getStatus() == 0) {
                IpcamClientActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        if (IpcamClientActivity.listAdapter.UpdataCameraStatus(CamerStatuThread.this.id, 7)) {
                            IpcamClientActivity.listAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
    }

    private class GetDataTask extends AsyncTask<Void, Void, Void> {
        private GetDataTask() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            IpcamClientActivity.this.progressBar.setVisibility(0);
            IpcamClientActivity.this.imageButtonRefresh.setVisibility(8);
            if (!SystemValue.ISRUN) {
                BridgeService.isAppClose = false;
                Intent intent = new Intent();
                intent.setClass(IpcamClientActivity.this, BridgeService.class);
                IpcamClientActivity.this.startService(intent);
                Log.d("tagx", "SystemValue.ISRUN == false--and--server is run to");
                new Thread() {
                    public void run() {
                        NativeCaller.PPPPInitial(SystemValue.SystemSerVer, SystemValue.SystemSerVer.length());
                        NativeCaller.PPPPNetworkDetect();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException unused) {
                        }
                        NativeCaller.Init();
                        Log.e("tagx", "#### GetDataTask  Init");
                    }
                }.start();
            }
        }

        /* access modifiers changed from: private */
        public void StopCameraPPPP() {
            int count = IpcamClientActivity.listAdapter.getCount();
            for (int i = 0; i < count; i++) {
                CameraParamsBean onItem = IpcamClientActivity.listAdapter.getOnItem(i);
                if (onItem.getStatus() != 2) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception unused) {
                    }
                    NativeCaller.StopPPPP(onItem.getDid());
                    try {
                        Thread.sleep(300);
                    } catch (Exception unused2) {
                    }
                    IpcamClientActivity.this.StartPPPP(onItem.getDid(), onItem.getUser(), onItem.getPwd(), "test");
                }
            }
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            new Thread(new StopPPPPThread()).start();
            try {
                Thread.sleep(1000);
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            IpcamClientActivity.listAdapter.notifyDataSetChanged();
            IpcamClientActivity.this.progressBar.setVisibility(8);
            IpcamClientActivity.this.imageButtonRefresh.setVisibility(0);
            super.onPostExecute(voidR);
        }

        class StopPPPPThread implements Runnable {
            StopPPPPThread() {
            }

            public void run() {
                try {
                    Thread.sleep(10);
                    GetDataTask.this.StopCameraPPPP();
                } catch (Exception unused) {
                }
            }
        }
    }

    class StopPPPPThread implements Runnable {
        StopPPPPThread() {
        }

        public void run() {
            try {
                Thread.sleep(10);
                IpcamClientActivity.this.StopCameraPPPP();
            } catch (Exception unused) {
            }
        }
    }

    class CameraInfoReceiver extends BroadcastReceiver {
        CameraInfoReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Intent intent2 = intent;
            if ("other".equals(intent.getAction())) {
                IpcamClientActivity.listAdapter.sendCameraStatus();
                return;
            }
            int intExtra = intent2.getIntExtra(ContentCommon.CAMERA_OPTION, 65535);
            if (intExtra != 65535) {
                String stringExtra = intent2.getStringExtra(ContentCommon.STR_CAMERA_NAME);
                String stringExtra2 = intent2.getStringExtra(ContentCommon.STR_CAMERA_ID);
                String stringExtra3 = intent2.getStringExtra(ContentCommon.STR_CAMERA_USER);
                String stringExtra4 = intent2.getStringExtra(ContentCommon.STR_CAMERA_PWD);
                if (intExtra == 2) {
                    String stringExtra5 = intent2.getStringExtra(ContentCommon.STR_CAMERA_OLD_ID);
                    String str = "test";
                    if (IpcamClientActivity.this.UpdataCamera2db(stringExtra5, stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                        if (IpcamClientActivity.listAdapter.UpdateCamera(stringExtra5, stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                            NativeCaller.PPPPGetSystemParams(stringExtra2, 59);
                            NativeCaller.PPPPGetSystemParams(stringExtra2, 4);
                            IpcamClientActivity.listAdapter.notifyDataSetChanged();
                            NativeCaller.StopPPPP(stringExtra2);
                            IpcamClientActivity.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4, str);
                        }
                        IpcamClientActivity.this.editAdapter.modifyCamera(stringExtra5, stringExtra2, stringExtra, stringExtra3, stringExtra4);
                        Intent intent3 = new Intent("del_add_modify_camera");
                        intent3.putExtra(DataBaseHelper.KEY_TYPE, 2);
                        intent3.putExtra(ContentCommon.STR_CAMERA_ID, stringExtra2);
                        intent3.putExtra("olddid", stringExtra5);
                        intent3.putExtra(DataBaseHelper.KEY_NAME, stringExtra);
                        IpcamClientActivity.this.sendBroadcast(intent3);
                        return;
                    }
                    return;
                }
                String str2 = "test";
                if (intExtra == 3) {
                    String stringExtra6 = intent2.getStringExtra(ContentCommon.STR_CAMERA_OLD_ID);
                    if (IpcamClientActivity.listAdapter.UpdateCamera(stringExtra6, stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                        NativeCaller.PPPPGetSystemParams(stringExtra2, 59);
                        IpcamClientActivity.listAdapter.notifyDataSetChanged();
                        NativeCaller.StopPPPP(stringExtra2);
                        IpcamClientActivity.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4, str2);
                        if (IpcamClientActivity.this.editAdapter.modifyCamera(stringExtra6, stringExtra2, stringExtra, stringExtra3, stringExtra4)) {
                            IpcamClientActivity.this.editAdapter.notifyDataSetChanged();
                        }
                    }
                } else if (IpcamClientActivity.listAdapter.getCount() >= 10) {
                    IpcamClientActivity.this.showToast((int) R.string.add_camer_no_add);
                } else if (IpcamClientActivity.listAdapter.AddCamera(stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                    Log.d(str2, "zhao-guangbo");
                    IpcamClientActivity.this.cameraListView.setVisibility(0);
                    IpcamClientActivity.listAdapter.notifyDataSetChanged();
                    IpcamClientActivity.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4, str2);
                    final String str3 = stringExtra;
                    final String str4 = stringExtra2;
                    final String str5 = stringExtra3;
                    final String str6 = stringExtra4;
                    new Thread() {
                        public void run() {
                            IpcamClientActivity.this.addCamera2db(str3, str4, str5, str6);
                            IpcamClientActivity.this.editAdapter.addCamera(str3, str4, str5, str6);
                            Intent intent = new Intent("del_add_modify_camera");
                            intent.putExtra(DataBaseHelper.KEY_TYPE, 1);
                            intent.putExtra(ContentCommon.STR_CAMERA_ID, str4);
                            intent.putExtra(DataBaseHelper.KEY_NAME, str3);
                            IpcamClientActivity.this.sendBroadcast(intent);
                        }
                    }.start();
                }
            }
        }
    }
}
