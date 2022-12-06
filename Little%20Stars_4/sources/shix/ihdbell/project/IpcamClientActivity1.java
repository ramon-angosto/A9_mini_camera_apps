package shix.ihdbell.project;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.shix.fcmpush1.FcmPush;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.view.MyPreference;
import com.tzh.ipcamera.view.VC.CameraApAty;
import com.tzh.ipcamera.view.VC.CameraPlayAty;
import com.tzh.ipcamera.view.dialog.AlartDialog;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;
import object.p2pipcam.adapter.CameraEditAdapter;
import object.p2pipcam.adapter.CameraListAdapter1;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.DataBaseHelper;
import object.p2pipcam.utils.VibratorUtil;
import object.p2pipcam.zxingtwodimensioncode.Intents;
import shix.ihdbell.project.BridgeService;
import shix.ihdbell.project.MainActivity;

public class IpcamClientActivity1 extends BaseActivity implements View.OnClickListener, BridgeService.IpcamClientInterface, AdapterView.OnItemClickListener, MainActivity.MainEditInterface, BridgeService.DoorBellGETSTATU {
    private static final String STR_DID = "did";
    private static final String STR_MSG_PARAM = "msgparam";
    private static final String TAG = "IpcamClientActivity";
    private static int cameraStatus = 0;
    private static final String devName = "WIFI_FPV";
    public static KeyguardManager.KeyguardLock keyguardLock;
    public static CameraListAdapter1 listAdapter;
    /* access modifiers changed from: private */
    public Handler PPPPMsgHandler = new Handler() {
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            int i = data.getInt(IpcamClientActivity1.STR_MSG_PARAM);
            int i2 = message.what;
            String unused = IpcamClientActivity1.this.did = data.getString("did");
            Log.d("test", "did==" + IpcamClientActivity1.this.did + "  msgType=" + i2);
            if (i2 == 0) {
                Intent intent = new Intent("camera_status_change");
                intent.putExtra(ContentCommon.STR_CAMERA_ID, IpcamClientActivity1.this.did);
                intent.putExtra(ContentCommon.STR_PPPP_STATUS, i);
                IpcamClientActivity1.this.sendBroadcast(intent);
                if (IpcamClientActivity1.listAdapter.UpdataCameraStatus(IpcamClientActivity1.this.did, i)) {
                    IpcamClientActivity1.listAdapter.notifyDataSetChanged();
                    if (i == 2) {
                        NativeCaller.PPPPGetSystemParams(IpcamClientActivity1.this.did, 13);
                        IpcamClientActivity1 ipcamClientActivity1 = IpcamClientActivity1.this;
                        SystemValue.doorBellAdmin = ipcamClientActivity1.retrunUser(ipcamClientActivity1.did);
                        IpcamClientActivity1 ipcamClientActivity12 = IpcamClientActivity1.this;
                        SystemValue.doorBellPass = ipcamClientActivity12.retrunPwd(ipcamClientActivity12.did);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (i == 5 || i == 3 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 4) {
                        NativeCaller.StopPPPP(IpcamClientActivity1.this.did);
                    }
                }
            } else if (i2 == 1) {
                Log.d("shix", "shix:" + i);
                boolean UpdataCameraType = IpcamClientActivity1.listAdapter.UpdataCameraType(IpcamClientActivity1.this.did, i);
            } else if (i2 == 200) {
                IpcamClientActivity1.listAdapter.notifyDataSetChanged();
            } else if (i2 == 1021) {
                IpcamClientActivity1.this.splash_img.setVisibility(8);
            } else if (i2 == 10234) {
                IpcamClientActivity1.listAdapter.notifyDataSetChanged();
            }
        }
    };
    private final int SNAPSHOT = MKEvent.ERROR_LOCATION_FAILED;
    private LinearLayout addCameraListHeader;
    private AlartDialog alartDialog = null;
    private Button btnApModel;
    private Button btnDelCamera;
    private Button btnEdit;
    private Button btnSelectAll;
    private Button btnSelectReverse;
    private Button btn_edit;
    /* access modifiers changed from: private */
    public ListView cameraListView = null;
    private LinearLayout delBottomLayout;
    private int devType;
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
    /* access modifiers changed from: private */
    public boolean isRefresh = false;
    LogUtils logUtils = LogUtils.setLogger(IpcamClientActivity1.class);
    private final BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            intent.getAction();
            Log.e("test", "zhaogenghuai --���ֹ㲥");
        }
    };
    private final BroadcastReceiver mSetButtonEnReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("setButtonEn")) {
                IpcamClientActivity1.this.setButtonEn();
                boolean unused = IpcamClientActivity1.this.isRefresh = true;
            }
        }
    };
    private BroadcastReceiver1 networkBroadcast = new BroadcastReceiver1();
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_more_funtion;
    private View popv_more_funtion;
    private SharedPreferences preAudio;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog;
    private int pustType;
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

    public void CallBackSDStatu(String str, int i, int i2, int i3) {
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
        setContentView(R.layout.ipcamclient1);
        this.logUtils.e("oncreate IpcamClientActivity1");
        if (CommonUtil.getAndroidVersion() >= 6) {
            CommonUtil.checkPermissionAll(this);
        }
        this.preAudio = getSharedPreferences("shix_zhao_audio", 0);
        SystemValue.isDeamon = this.preAudio.getInt("deamontype", 0);
        this.screen_width = getWindowManager().getDefaultDisplay().getWidth();
        this.screen_height = getWindowManager().getDefaultDisplay().getHeight();
        ContentCommon.TIME_UTC = TimeZone.getDefault().getDisplayName(false, 0);
        Log.e("test", "ContentCommon.TIME_UTC111:" + ContentCommon.TIME_UTC);
        findView();
        setControlListener();
        listAdapter = new CameraListAdapter1(this, this);
        this.editAdapter = new CameraEditAdapter(this);
        this.cameraListView.setAdapter(listAdapter);
        this.helper = DataBaseHelper.getInstance(this);
        initCameraList();
        BridgeService.setDoorBellGETSTATU(this);
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
                    Log.d("test", "PPPPInitial run thread");
                    long time = new Date().getTime();
                    NativeCaller.PPPPNetworkDetect();
                    NativeCaller.Init();
                    Thread.sleep(500);
                    IpcamClientActivity1.this.StartCameraPPPP();
                    if (new Date().getTime() - time <= 3000) {
                        Thread.sleep(3000);
                    }
                    Message message = new Message();
                    message.what = 1021;
                    IpcamClientActivity1.this.PPPPMsgHandler.sendMessage(message);
                } catch (Exception unused) {
                }
            }
        }).start();
        this.isCheck = true;
        new Thread() {
            public void run() {
                while (IpcamClientActivity1.this.isCheck) {
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("test", "zhaogenghua0 isCheck");
                    int count = IpcamClientActivity1.listAdapter.getCount();
                    for (int i = 0; i < count; i++) {
                        CameraParamsBean onItem = IpcamClientActivity1.listAdapter.getOnItem(i);
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
                        }
                    }
                }
            }
        }.start();
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("setButtonEn");
        registerReceiver(this.networkBroadcast, intentFilter);
        registerReceiver(this.mBatInfoReceiver, intentFilter);
        registerReceiver(this.mSetButtonEnReceiver, intentFilter2);
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
                Log.d("test", "zhaogenghuai-----Intent ��:" + str + "  Я��ֵ��" + getIntent().getStringExtra(str));
            }
        }
        SystemValue.FCMTOKEN = FcmPush.getToken();
        if (SystemValue.mPlayer != null) {
            CommonUtil.Log(1, "zhao1234--�ͷ�-NOTIFACTION_CLICKED_TYPE");
            SystemValue.mPlayer.stop();
            SystemValue.mPlayer.release();
            SystemValue.mPlayer = null;
        }
        SystemValue.isSoftRun = true;
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
        this.btnApModel = (Button) findViewById(R.id.btnApModel);
        this.btnApModel.setOnClickListener(this);
        this.btn_edit = (Button) findViewById(R.id.btn_edit);
        this.btn_edit.setOnClickListener(this);
        this.splash_img = (RelativeLayout) findViewById(R.id.splash_img);
        this.cameraListView = (ListView) findViewById(R.id.listviewCamera);
        this.imageButton_apphome = (ImageButton) findViewById(R.id.app_home);
        this.addCameraListHeader = (LinearLayout) findViewById(R.id.addvidicon_listitem);
        this.imageButtonRefresh = (ImageButton) findViewById(R.id.refresh);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        this.addCameraListHeader.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.e(IpcamClientActivity1.class.getSimpleName(), "添加CamerList");
                VibratorUtil.Vibrate(IpcamClientActivity1.this, 20);
                IpcamClientActivity1.this.startActivity(new Intent(IpcamClientActivity1.this, AddCameraActivity.class));
                IpcamClientActivity1.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });
        this.imageButtonRefresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(IpcamClientActivity1.this, 20);
                SystemValue.TAG_CAMERLIST = 0;
                new GetDataTask().execute(new Void[0]);
            }
        });
        this.imageButton_apphome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("tag", "screen_width:" + IpcamClientActivity1.this.screen_width + "  screen_height:" + IpcamClientActivity1.this.screen_height);
            }
        });
        this.btnEdit = (Button) findViewById(R.id.btn_edit);
        this.btnSelectAll = (Button) findViewById(R.id.main_selectall);
        this.btnSelectReverse = (Button) findViewById(R.id.main_selectreverse);
        this.btnDelCamera = (Button) findViewById(R.id.main_delete_camera);
        this.delBottomLayout = (LinearLayout) findViewById(R.id.del_bottom_layout);
        if (!MyPreference.getInstance(this).isExistAgree().booleanValue()) {
            setButtonDis();
        } else if (!MyPreference.getInstance(this).getIsAgree().booleanValue()) {
            setButtonDis();
        }
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
        if (id == R.id.btnApModel) {
            startActivity(new Intent(this, CameraApAty.class));
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        } else if (id == R.id.btn_edit) {
            int count = listAdapter.getCount();
            if (this.isEdited) {
                this.isEdited = false;
                this.addCameraListHeader.setVisibility(0);
                Log.e("##EditOnclick", "btn_edit");
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
                                Log.i("iBtnRingtone", "�������������������ť");
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

    private class AlartClick implements AlartDialog.AlartDialogClick {
        public void OnCancelClick() {
        }

        private AlartClick() {
        }

        public void OnConfirmClick() {
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    ProgressDialog unused = IpcamClientActivity1.this.progressDialog = new ProgressDialog(IpcamClientActivity1.this);
                    IpcamClientActivity1.this.progressDialog.setMessage(IpcamClientActivity1.this.getResources().getString(R.string.main_show_delecting));
                    IpcamClientActivity1.this.progressDialog.setCancelable(false);
                    IpcamClientActivity1.this.progressDialog.show();
                }

                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    ArrayList<String> delCameraSize = IpcamClientActivity1.this.editAdapter.delCameraSize();
                    for (int i = 0; i < delCameraSize.size(); i++) {
                        String str = delCameraSize.get(i);
                        SystemValue.doorBellAdmin = IpcamClientActivity1.this.retrunUser(str);
                        SystemValue.doorBellPass = IpcamClientActivity1.this.retrunPwd(str);
                    }
                    ArrayList<String> delCamera = IpcamClientActivity1.this.editAdapter.delCamera();
                    Intent intent = new Intent("del_add_modify_camera");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i2 = 0; i2 < delCamera.size(); i2++) {
                        String str2 = delCamera.get(i2);
                        if (IpcamClientActivity1.this.delCameraFromdb(str2)) {
                            IpcamClientActivity1.listAdapter.delCamera(str2);
                            NativeCaller.StopPPPP(str2);
                            IpcamClientActivity1.listAdapter.notifyDataSetChanged();
                            intent.putExtra(ContentCommon.STR_CAMERA_ID, str2);
                            intent.putExtra(DataBaseHelper.KEY_TYPE, 4);
                            IpcamClientActivity1.this.sendBroadcast(intent);
                        }
                    }
                    return null;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    IpcamClientActivity1.this.progressDialog.cancel();
                    if (IpcamClientActivity1.this.editAdapter.getCount() == 0) {
                        IpcamClientActivity1.this.cameraListView.setVisibility(8);
                    }
                    IpcamClientActivity1.this.editAdapter.notifyDataSetChanged();
                }
            }.execute(new Void[0]);
        }
    }

    private void showDelSureDialog() {
        AlartDialog alartDialog2 = this.alartDialog;
        if (alartDialog2 == null || !alartDialog2.isShowing()) {
            this.alartDialog = new AlartDialog(this, R.style.dialog1);
            AlartDialog alartDialog3 = this.alartDialog;
            if (alartDialog3 != null) {
                alartDialog3.setAlartClickListener(new AlartClick());
            }
            this.alartDialog.show();
        }
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
        if (!MyPreference.getInstance(this).isExistAgree().booleanValue()) {
            return;
        }
        if (MyPreference.getInstance(this).getIsAgree().booleanValue() || this.isRefresh) {
            this.imageButtonRefresh.performClick();
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
        this.logUtils.e("onDestroy IpcamClientActivity1");
        DataBaseHelper dataBaseHelper = this.helper;
        if (dataBaseHelper != null) {
            dataBaseHelper.close();
            this.helper = null;
        }
        SystemValue.TAG_CAMERLIST = 0;
        unregisterReceiver(this.networkBroadcast);
        unregisterReceiver(this.mBatInfoReceiver);
        unregisterReceiver(this.mSetButtonEnReceiver);
        unregisterReceiver(this.receiver);
        Intent intent = new Intent();
        intent.setClass(this, BridgeService.class);
        stopService(intent);
        SystemValue.checkSDStatu = 0;
        SystemValue.isSoftRun = false;
    }

    private String retrunName(String str) {
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
            if (itemCamera.getDevType() == 51) {
                SystemValue.isLitos = true;
            } else {
                SystemValue.isLitos = false;
            }
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

    private String getConnectWifiSSID() {
        WifiInfo connectionInfo = ((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        Log.e("wifiInfo", connectionInfo.toString());
        Log.e(Intents.WifiConnect.SSID, connectionInfo.getSSID());
        return connectionInfo.getSSID();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = i;
        VibratorUtil.Vibrate(this, 20);
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
                ((App) getApplication()).connectSSid = did2;
                intent.putExtra(ContentCommon.STR_CAMERA_PWD, pwd);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            }
            return;
        }
        CameraParamsBean onItem = listAdapter.getOnItem(i2);
        Log.e("test", "00000000");
        if (onItem == null) {
            Log.e("test", "111111");
            return;
        }
        int status = onItem.getStatus();
        Log.e("test", "22222222");
        if (status == 5 || status == 7 || status == 6 || status == 3 || status == 9 || status == 10 || status == 4) {
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
            CommonUtil.Log(1, "devType:" + onItem.getDevType());
            String did4 = onItem.getDid();
            String name2 = onItem.getName();
            String user3 = onItem.getUser();
            String pwd3 = onItem.getPwd();
            int mode = onItem.getMode();
            Intent intent2 = new Intent(this, CameraPlayAty.class);
            intent2.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
            intent2.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
            intent2.putExtra(ContentCommon.STR_CAMERA_NAME, name2);
            intent2.putExtra(ContentCommon.STR_CAMERA_ID, did4);
            intent2.putExtra(ContentCommon.STR_CAMERA_USER, user3);
            intent2.putExtra(ContentCommon.STR_CAMERA_PWD, pwd3);
            intent2.putExtra(ContentCommon.STR_CAMERA_SNAPSHOT, onItem.getPlayBitmap());
            CommonUtil.Log(1, "bean.getDevType():" + onItem.getDevType());
            if (onItem.getDevType() == 51) {
                SystemValue.isLitos = true;
            } else {
                SystemValue.isLitos = false;
            }
            if (onItem.getDevType() == 111) {
                intent2.putExtra("samper", 16000);
            } else {
                intent2.putExtra("samper", 8000);
            }
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
            this.delBottomLayout.setVisibility(8);
            Log.e("EditOnclick", "onclick");
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
                IpcamClientActivity1.this.finish();
                IpcamClientActivity1.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popv_more_funtion.findViewById(R.id.button_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IpcamClientActivity1.this.popupWindow_more_funtion.dismiss();
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
                IpcamClientActivity1.this.popupWindow_more_funtion.dismiss();
            }
        });
        this.popupWindow_more_funtion.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                IpcamClientActivity1.this.popupWindow_more_funtion.dismiss();
                return false;
            }
        });
    }

    public void CallBackStatu(String str, String str2, String str3) {
        listAdapter.upadeUserServer(str, str2);
        CommonUtil.Log(1, "sysver:" + str2);
    }

    public void CallBackDevType(String str, int i) {
        listAdapter.UpdataCameraDevType(str, i);
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
                IpcamClientActivity1.this.StartCameraPPPP();
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
                IpcamClientActivity1.this.runOnUiThread(new Runnable() {
                    public void run() {
                        if (IpcamClientActivity1.listAdapter.UpdataCameraStatus(CamerStatuThread.this.id, 7)) {
                            IpcamClientActivity1.listAdapter.notifyDataSetChanged();
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
            IpcamClientActivity1.this.progressBar.setVisibility(0);
            IpcamClientActivity1.this.imageButtonRefresh.setVisibility(8);
            if (!SystemValue.ISRUN) {
                BridgeService.isAppClose = false;
                Intent intent = new Intent();
                intent.setClass(IpcamClientActivity1.this, BridgeService.class);
                IpcamClientActivity1.this.startService(intent);
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
                        Log.e("tagx", "GetDataTask  Init");
                    }
                }.start();
            }
        }

        /* access modifiers changed from: private */
        public void StopCameraPPPP() {
            int count = IpcamClientActivity1.listAdapter.getCount();
            for (int i = 0; i < count; i++) {
                CameraParamsBean onItem = IpcamClientActivity1.listAdapter.getOnItem(i);
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
                    IpcamClientActivity1.this.StartPPPP(onItem.getDid(), onItem.getUser(), onItem.getPwd(), "test");
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
            IpcamClientActivity1.listAdapter.notifyDataSetChanged();
            IpcamClientActivity1.this.progressBar.setVisibility(8);
            IpcamClientActivity1.this.imageButtonRefresh.setVisibility(0);
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
                IpcamClientActivity1.this.StopCameraPPPP();
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
                IpcamClientActivity1.listAdapter.sendCameraStatus();
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
                    if (IpcamClientActivity1.this.UpdataCamera2db(stringExtra5, stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                        if (IpcamClientActivity1.listAdapter.UpdateCamera(stringExtra5, stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                            NativeCaller.PPPPGetSystemParams(stringExtra2, 59);
                            NativeCaller.PPPPGetSystemParams(stringExtra2, 4);
                            IpcamClientActivity1.listAdapter.notifyDataSetChanged();
                            NativeCaller.StopPPPP(stringExtra2);
                            IpcamClientActivity1.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4, str);
                        }
                        IpcamClientActivity1.this.editAdapter.modifyCamera(stringExtra5, stringExtra2, stringExtra, stringExtra3, stringExtra4);
                        Intent intent3 = new Intent("del_add_modify_camera");
                        intent3.putExtra(DataBaseHelper.KEY_TYPE, 2);
                        intent3.putExtra(ContentCommon.STR_CAMERA_ID, stringExtra2);
                        intent3.putExtra("olddid", stringExtra5);
                        intent3.putExtra(DataBaseHelper.KEY_NAME, stringExtra);
                        IpcamClientActivity1.this.sendBroadcast(intent3);
                        return;
                    }
                    return;
                }
                String str2 = "test";
                if (intExtra == 3) {
                    String stringExtra6 = intent2.getStringExtra(ContentCommon.STR_CAMERA_OLD_ID);
                    if (IpcamClientActivity1.listAdapter.UpdateCamera(stringExtra6, stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                        NativeCaller.PPPPGetSystemParams(stringExtra2, 59);
                        IpcamClientActivity1.listAdapter.notifyDataSetChanged();
                        NativeCaller.StopPPPP(stringExtra2);
                        IpcamClientActivity1.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4, str2);
                        if (IpcamClientActivity1.this.editAdapter.modifyCamera(stringExtra6, stringExtra2, stringExtra, stringExtra3, stringExtra4)) {
                            IpcamClientActivity1.this.editAdapter.notifyDataSetChanged();
                        }
                    }
                } else if (IpcamClientActivity1.listAdapter.getCount() >= 10) {
                    IpcamClientActivity1.this.showToast((int) R.string.add_camer_no_add);
                } else if (IpcamClientActivity1.listAdapter.AddCamera(stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                    Log.d(str2, "zhao-guangbo");
                    IpcamClientActivity1.this.cameraListView.setVisibility(0);
                    IpcamClientActivity1.listAdapter.notifyDataSetChanged();
                    IpcamClientActivity1.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4, str2);
                    final String str3 = stringExtra;
                    final String str4 = stringExtra2;
                    final String str5 = stringExtra3;
                    final String str6 = stringExtra4;
                    new Thread() {
                        public void run() {
                            IpcamClientActivity1.this.addCamera2db(str3, str4, str5, str6);
                            IpcamClientActivity1.this.editAdapter.addCamera(str3, str4, str5, str6);
                            Intent intent = new Intent("del_add_modify_camera");
                            intent.putExtra(DataBaseHelper.KEY_TYPE, 1);
                            intent.putExtra(ContentCommon.STR_CAMERA_ID, str4);
                            intent.putExtra(DataBaseHelper.KEY_NAME, str3);
                            IpcamClientActivity1.this.sendBroadcast(intent);
                        }
                    }.start();
                }
            }
        }
    }

    public void setButtonDis() {
        this.btnApModel.setEnabled(false);
        this.btnEdit.setEnabled(false);
        this.addCameraListHeader.setEnabled(false);
        this.imageButtonRefresh.setEnabled(false);
        this.cameraListView.setEnabled(false);
    }

    public void setButtonEn() {
        this.btnApModel.setEnabled(true);
        this.btnEdit.setEnabled(true);
        this.addCameraListHeader.setEnabled(true);
        this.imageButtonRefresh.setEnabled(true);
        this.cameraListView.setEnabled(true);
    }
}
