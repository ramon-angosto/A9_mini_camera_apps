package shix.ihdbell.project;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.widget.RemoteViews;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.view.delegate.IRecordFileInterface;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.DataBaseHelper;

public class BridgeService extends Service {
    private static AddCameraInterface addCameraInterface = null;
    private static AlarmInterface alarmInterface = null;
    private static CameraBatteryInterface cameraBatteryInterface = null;
    private static DateTimeInterface dateTimeInterface = null;
    private static DoorBellAlarmParmInterface doorBellAlarmParmInterface = null;
    private static DoorBellAlerm doorBellAlerm = null;
    private static DoorBellAlermPush doorBellAlermPush = null;
    private static DoorBellGETSTATU doorBellGETSTATU = null;
    private static DoorBellInterfaceParmInterface doorBellInterfaceParmInterface = null;
    private static DoorBellLockParmInterface doorBellLockParmInterface = null;
    private static DoorBellOneKey doorBellOneKey = null;
    private static DoorBellSystemParmInterface doorBellSystemParmInterface = null;
    private static DoorBellTimeDeLay doorBellTimeDeLay = null;
    private static DoorBellUserInterface doorBellUserInterface = null;
    private static FtpInterface ftpInterface = null;
    private static IPPlayInterface ipPlayInterface = null;
    private static IpcamClientInterface ipcamClientInterface = null;
    public static boolean isAppClose = true;
    private static LogsInterface logsInterface;
    private static MailInterface mailInterface;
    private static PictureInterface pictureInterface;
    private static PlayBackInterface playBackInterface;
    private static PlayBackTFInterface playBackTFInterface;
    private static PlayInterface playInterface;
    private static PushStatusInterface pushStatusInterface;
    private static IRecordFileInterface recordFileInterface;
    private static SDCardInterface sCardInterface;
    private static SnapShotInterface snapShotInterface;
    private static UserInterface userInterface;
    private static VideoInterface videoInterface;
    private static WifiInterface wifiInterface;
    private String Name;
    private String PicData;
    private int PicIsOne = 0;
    private String PicUuid;
    private String TAG = BridgeService.class.getSimpleName();
    private String Udid;
    private String alermType;
    private DataBaseHelper baseHelper = null;
    private String dateTime;
    private int i = 0;
    private NotificationManager mCustomMgr;
    private Notification mNotify2;
    private String picType;
    private String pushID;
    private int pushType;
    PowerManager.WakeLock wakeLock = null;

    public interface AddCameraInterface {
        void callBackResetResultData(int i);

        void callBackSearchResultData(int i, String str, String str2, String str3, String str4, int i2);
    }

    public interface AlarmInterface {
        void callBackAlarmParams(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33);

        void callBackSetSystemParamsResult(String str, int i, int i2);
    }

    public interface CameraBatteryInterface {
        void callBackBatteryResult(int i);
    }

    public interface DateTimeInterface {
        void callBackDatetimeParams(String str, int i, int i2, int i3, String str2);

        void callBackSetSystemParamsResult(String str, int i, int i2);
    }

    public interface DoorBellAlarmParmInterface {
        void callBackDoorBellAlarmParm(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);
    }

    public interface DoorBellAlerm {
        void DoorBeelAlerm(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

        void callBackSetSystemParamsResult(String str, int i, int i2);
    }

    public interface DoorBellAlermPush {
        void CallBackAlermType(int i);

        void CallBackDoorbellType(String str, int i);
    }

    public interface DoorBellGETSTATU {
        void CallBackSDStatu(String str, int i, int i2, int i3);

        void CallBackStatu(String str, String str2, String str3);
    }

    public interface DoorBellInterfaceParmInterface {
        void callBackDoorBellInterfaceParm(String str, int i, int i2, int i3, int i4);
    }

    public interface DoorBellLockParmInterface {
        void callBackDoorBellLockParm(String str, int i, int i2);
    }

    public interface DoorBellOneKey {
        void BSMsgNotifyData(String str, int i, int i2);
    }

    public interface DoorBellSystemParmInterface {
        void callBackDoorBellSystemParm(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7);
    }

    public interface DoorBellTimeDeLay {
        void CallBackTimeDelay(int i);
    }

    public interface DoorBellUserInterface {
        void CallBackUserParms(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);
    }

    public interface FtpInterface {
        void callBackFtpParams(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3);

        void callBackSetSystemParamsResult(String str, int i, int i2);
    }

    public interface IPPlayInterface {
        void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4);

        void callBackAudioData(byte[] bArr, int i);

        void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6);

        void callBackH264Data(byte[] bArr, int i, int i2);

        void callBackMessageNotify(String str, int i, int i2);
    }

    public interface IpcamClientInterface {
        void BSMsgNotifyData(String str, int i, int i2);

        void BSSnapshotNotify(String str, byte[] bArr, int i);

        void CallBackDevType(String str, int i);

        void callBackDoorBellController(String str, int i);

        void callBackUserParams(String str, String str2, String str3, String str4, String str5, String str6, String str7);
    }

    public interface LogsInterface {
        void CallBack_DoorBell_Logs(String str, String str2, int i, int i2);
    }

    public interface MailInterface {
        void callBackMailParams(String str, String str2, int i, String str3, String str4, int i2, String str5, String str6, String str7, String str8, String str9);

        void callBackSetSystemParamsResult(String str, int i, int i2);
    }

    public interface PictureInterface {
        void BSMsgNotifyData(String str, int i, int i2);
    }

    public interface PlayBackInterface {
        void callBackPlaybackVideoData(byte[] bArr, int i, int i2, int i3, int i4, int i5);
    }

    public interface PlayBackTFInterface {
        void callBackRecordFileSearchResult(String str, String str2, int i, int i2, int i3);
    }

    public interface PlayInterface {
        void CallBackAlermType(String str, int i);

        void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5);

        void callBackAudioData(byte[] bArr, int i);

        void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void callBackH264Data(String str, byte[] bArr, int i, int i2);

        void callBackMessageNotify(String str, int i, int i2);
    }

    public interface PushStatusInterface {
        void callBackPushStatus(String str, int i, int i2);
    }

    public interface SDCardInterface {
        void callBackRecordSchParams(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28);

        void callBackSetSystemParamsResult(String str, int i, int i2);
    }

    public interface SnapShotInterface {
        void BSSnapshot(String str, byte[] bArr, int i);
    }

    public interface UserInterface {
        void callBackPPPPMsgNotifyData(String str, int i, int i2);

        void callBackSetSystemParamsResult(String str, int i, int i2);

        void callBackUserParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);
    }

    public interface VideoInterface {
        void BSMsgNotifyData(String str, int i, int i2);
    }

    public interface WifiInterface {
        void callBackPPPPMsgNotifyData(String str, int i, int i2);

        void callBackSetSystemParamsResult(String str, int i, int i2);

        void callBackWifiParams(String str, int i, String str2, int i2, int i3, int i4, int i5, int i6, int i7, String str3, String str4, String str5, String str6, int i8, int i9, int i10, int i11, String str7);

        void callBackWifiScanResult(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6);
    }

    public void CallBack_GetDBParm(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
    }

    public void CallBack_GetFourLockParm(String str, int i2, int i3, int i4, int i5, int i6, int i7) {
    }

    public void CallBack_getSDCardResult(String str, String str2) {
    }

    public static void setLogsInterface(LogsInterface logsInterface2) {
        logsInterface = logsInterface2;
    }

    public static void setDoorBellSystemParmInterface(DoorBellSystemParmInterface doorBellSystemParmInterface2) {
        doorBellSystemParmInterface = doorBellSystemParmInterface2;
    }

    public static void setDoorBellInterfaceParmInterface(DoorBellInterfaceParmInterface doorBellInterfaceParmInterface2) {
        doorBellInterfaceParmInterface = doorBellInterfaceParmInterface2;
    }

    public static void setDoorBellAlarmParmInterface(DoorBellAlarmParmInterface doorBellAlarmParmInterface2) {
        doorBellAlarmParmInterface = doorBellAlarmParmInterface2;
    }

    public static void setDoorBellLockParmInterface(DoorBellLockParmInterface doorBellLockParmInterface2) {
        doorBellLockParmInterface = doorBellLockParmInterface2;
    }

    public static void setRecordFileInterface(IRecordFileInterface iRecordFileInterface) {
        recordFileInterface = iRecordFileInterface;
    }

    public static void setIpcamClientInterface(IpcamClientInterface ipcamClientInterface2) {
        ipcamClientInterface = ipcamClientInterface2;
    }

    public static void setPictureInterface(PictureInterface pictureInterface2) {
        pictureInterface = pictureInterface2;
    }

    public static void setVideoInterface(VideoInterface videoInterface2) {
        videoInterface = videoInterface2;
    }

    public static void setWifiInterface(WifiInterface wifiInterface2) {
        wifiInterface = wifiInterface2;
    }

    public static void setUserInterface(UserInterface userInterface2) {
        userInterface = userInterface2;
    }

    public static void setAlarmInterface(AlarmInterface alarmInterface2) {
        alarmInterface = alarmInterface2;
    }

    public static void setDateTimeInterface(DateTimeInterface dateTimeInterface2) {
        dateTimeInterface = dateTimeInterface2;
    }

    public static void setMailInterface(MailInterface mailInterface2) {
        mailInterface = mailInterface2;
    }

    public static void setFtpInterface(FtpInterface ftpInterface2) {
        ftpInterface = ftpInterface2;
    }

    public static void setSDCardInterface(SDCardInterface sDCardInterface) {
        sCardInterface = sDCardInterface;
    }

    public static void setPlayInterface(PlayInterface playInterface2) {
        playInterface = playInterface2;
    }

    public static void setPlayBackTFInterface(PlayBackTFInterface playBackTFInterface2) {
        playBackTFInterface = playBackTFInterface2;
    }

    public static void setPlayBackInterface(PlayBackInterface playBackInterface2) {
        playBackInterface = playBackInterface2;
    }

    public static void setAddCameraInterface(AddCameraInterface addCameraInterface2) {
        addCameraInterface = addCameraInterface2;
    }

    public static void setIpPlayInterface(IPPlayInterface iPPlayInterface) {
        ipPlayInterface = iPPlayInterface;
    }

    public static void setCameraBatteryInterface(CameraBatteryInterface cameraBatteryInterface2) {
        cameraBatteryInterface = cameraBatteryInterface2;
    }

    public static void setSnapShotInterface(SnapShotInterface snapShotInterface2) {
        snapShotInterface = snapShotInterface2;
    }

    public static void setDoorBellAlerm(DoorBellAlerm doorBellAlerm2) {
        doorBellAlerm = doorBellAlerm2;
    }

    public static void setDoorBellOneKey(DoorBellOneKey doorBellOneKey2) {
        doorBellOneKey = doorBellOneKey2;
    }

    public static void setDoorBellTimeDeLay(DoorBellTimeDeLay doorBellTimeDeLay2) {
        doorBellTimeDeLay = doorBellTimeDeLay2;
    }

    public static void setDoorBellAlermPush(DoorBellAlermPush doorBellAlermPush2) {
        doorBellAlermPush = doorBellAlermPush2;
    }

    public static void setDoorBellUserInterface(DoorBellUserInterface doorBellUserInterface2) {
        doorBellUserInterface = doorBellUserInterface2;
    }

    public static void setPushStatusInterface(PushStatusInterface pushStatusInterface2) {
        pushStatusInterface = pushStatusInterface2;
    }

    public static void setDoorBellGETSTATU(DoorBellGETSTATU doorBellGETSTATU2) {
        doorBellGETSTATU = doorBellGETSTATU2;
    }

    private void acquireWakeLock() {
        if (this.wakeLock == null) {
            this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(536870913, "PostLocationService");
            PowerManager.WakeLock wakeLock2 = this.wakeLock;
            if (wakeLock2 != null) {
                wakeLock2.acquire();
            }
        }
    }

    private void releaseWakeLock() {
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.release();
            this.wakeLock = null;
        }
    }

    public IBinder onBind(Intent intent) {
        Log.d("tag", "BridgeService onBind()");
        return new ControllerBinder();
    }

    public void CallBack_DevType(String str, int i2) {
        CommonUtil.Log(1, "zhaogenghuai devtype:" + i2);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.CallBackDevType(str, i2);
        }
    }

    public void onCreate() {
        super.onCreate();
        Log.d("tag", "BridgeService onCreate()");
        this.baseHelper = DataBaseHelper.getInstance(this);
        this.mCustomMgr = (NotificationManager) getSystemService("notification");
        SystemValue.ISRUN = true;
        NativeCaller.PPPPSetCallbackContext(this);
        if (!isAppClose) {
            NativeCaller.iCameraInit();
        }
        acquireWakeLock();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        Log.e(BridgeService.class.getSimpleName(), "#### onStartCommand start");
        Log.e(BridgeService.class.getSimpleName(), "#### onStartCommand stop");
        return super.onStartCommand(intent, i2, i3);
    }

    private Notification getNotification(String str, String str2, boolean z) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String string = getResources().getString(R.string.app_name);
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClass(this, MainActivity.class);
        this.mNotify2 = new Notification(R.drawable.app, getResources().getString(R.string.app_name) + " " + str, System.currentTimeMillis());
        this.mNotify2.flags = 2;
        PendingIntent activity = PendingIntent.getActivity(this, R.drawable.app, intent, 134217728);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_layout);
        Notification notification = this.mNotify2;
        notification.contentIntent = activity;
        notification.contentView = remoteViews;
        notification.contentView.setTextViewText(R.id.no_title, string);
        this.mNotify2.contentView.setTextViewText(R.id.no_content, str);
        this.mNotify2.contentView.setTextViewText(R.id.no_time, format);
        this.mNotify2.contentView.setImageViewResource(R.id.no_img, R.drawable.app);
        return this.mNotify2;
    }

    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
        this.mCustomMgr.cancel(R.drawable.app);
        Log.e("test", "zhaogenghuai---onDestroy");
        SystemValue.ISRUN = false;
        releaseWakeLock();
    }

    public void CallBack_DoorBell_CallStatus(String str, String str2, int i2) {
        DoorBellAlermPush doorBellAlermPush2;
        CommonUtil.Log(1, "zhaogenghuai CallBack_DoorBell_CallStatus:" + i2 + "  did:" + str + "  udid:" + str2);
        if (str != null && str.length() >= 3) {
            String str3 = SystemValue.BELL_UDID;
            this.pushID = str.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toUpperCase();
            this.alermType = "1";
            if (str3 != null && str3.length() >= 21) {
                this.dateTime = str3.substring(0, 10) + "  " + str3.substring(15, 17) + ":" + str3.substring(18, 20) + ":" + str3.substring(21);
                StringBuilder sb = new StringBuilder();
                sb.append("CallBack_AlarmNotifyDoorBell dateTime:");
                sb.append(this.dateTime);
                Log.d("test", sb.toString());
            }
            String str4 = this.alermType;
            if (str4 != null && i2 == 0) {
                if (str4.equalsIgnoreCase("1") || this.alermType.equalsIgnoreCase("2")) {
                    if (SystemValue.isStartRun && (doorBellAlermPush2 = doorBellAlermPush) != null) {
                        doorBellAlermPush2.CallBackDoorbellType(str3, Integer.parseInt(this.alermType));
                    }
                    if (!SystemValue.isStartRun && doorBellAlermPush == null) {
                        SystemValue.isStartRun = true;
                        intentToStart(this.alermType, this.pushID, true, this.dateTime, str3);
                    } else if (this.alermType.equalsIgnoreCase("1")) {
                        getNotification1(getResources().getString(R.string.doorbell_fangke), this.pushID, this.alermType, this.dateTime, str3);
                    } else {
                        getNotification1(getResources().getString(R.string.doorbell_alerm), this.pushID, this.alermType, this.dateTime, str3);
                    }
                } else if (this.alermType.equalsIgnoreCase("3") || this.alermType.equalsIgnoreCase("6") || this.alermType.equalsIgnoreCase("7") || this.alermType.equalsIgnoreCase("5") || this.alermType.equalsIgnoreCase("4")) {
                    DoorBellAlermPush doorBellAlermPush3 = doorBellAlermPush;
                    if (doorBellAlermPush3 != null) {
                        doorBellAlermPush3.CallBackAlermType(Integer.parseInt(this.alermType));
                    }
                    PlayInterface playInterface2 = playInterface;
                    if (playInterface2 != null) {
                        playInterface2.CallBackAlermType(this.pushID, Integer.parseInt(this.alermType));
                    }
                }
            }
        }
    }

    public void CallBack_DoorBell_PushStatus(String str, int i2, int i3) {
        CommonUtil.Log(1, "zhaogenghuai CallBack_DoorBell_PushStatuse:" + i2 + "  validity:" + i3);
        PushStatusInterface pushStatusInterface2 = pushStatusInterface;
        if (pushStatusInterface2 != null) {
            pushStatusInterface2.callBackPushStatus(str, i2, i3);
        }
    }

    private void VideoData(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        IPPlayInterface iPPlayInterface = ipPlayInterface;
        if (iPPlayInterface != null) {
            iPPlayInterface.callBaceVideoData(str, bArr, i2, i3, i4, i5);
        }
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBaceVideoData(str, bArr, i2, i3, i4, i5, i6);
        }
    }

    public void DoorBellController(String str, int i2, int i3, int i4, int i5, int i6, int i7) {
        Log.d("test", "shix-doorbell did:" + str + "  index1=" + i2);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.callBackDoorBellController(str, i2);
        }
        DoorBellTimeDeLay doorBellTimeDeLay2 = doorBellTimeDeLay;
        if (doorBellTimeDeLay2 != null) {
            doorBellTimeDeLay2.CallBackTimeDelay(i5);
        }
    }

    public void DoorBellSetUp(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        StringBuilder sb = new StringBuilder();
        sb.append("shix-doorbell did:");
        String str2 = str;
        sb.append(str);
        sb.append("  result=");
        int i11 = i2;
        sb.append(i2);
        sb.append("  motion_enable=");
        sb.append(i3);
        sb.append("  motion_level=");
        sb.append(i4);
        sb.append("  pir_enable=");
        sb.append(i5);
        sb.append("  record_enable=");
        sb.append(i6);
        sb.append("  record_size=");
        sb.append(i7);
        sb.append("  on_delay_time=");
        sb.append(i8);
        sb.append("  alarm_delay_time=");
        sb.append(i9);
        sb.append("  record_cover=");
        sb.append(i10);
        Log.d("test", sb.toString());
        DoorBellAlerm doorBellAlerm2 = doorBellAlerm;
        if (doorBellAlerm2 != null) {
            doorBellAlerm2.DoorBeelAlerm(str, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }
    }

    private void MessageNotify(String str, int i2, int i3) {
        Log.d("test_four_2", "MessageNotify did: " + str + " msgType: " + i2 + " param: " + i3);
        PlayInterface playInterface2 = playInterface;
    }

    private void AudioData(byte[] bArr, int i2) {
        String str = this.TAG;
        Log.d(str, "AudioData: len :+ " + i2);
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBackAudioData(bArr, i2);
        }
    }

    private void PPPPMsgNotify(String str, int i2, int i3) {
        String str2 = this.TAG;
        Log.e(str2, "###PPPPMsgNotify did:" + str + " type:" + i2 + " param:" + i3);
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBackMessageNotify(str, i2, i3);
        }
        IPPlayInterface iPPlayInterface = ipPlayInterface;
        if (iPPlayInterface != null) {
            iPPlayInterface.callBackMessageNotify(str, i2, i3);
        }
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.BSMsgNotifyData(str, i2, i3);
        }
        WifiInterface wifiInterface2 = wifiInterface;
        if (wifiInterface2 != null) {
            wifiInterface2.callBackPPPPMsgNotifyData(str, i2, i3);
        }
        UserInterface userInterface2 = userInterface;
        if (userInterface2 != null) {
            userInterface2.callBackPPPPMsgNotifyData(str, i2, i3);
        }
        DoorBellOneKey doorBellOneKey2 = doorBellOneKey;
        if (doorBellOneKey2 != null) {
            doorBellOneKey2.BSMsgNotifyData(str, i2, i3);
        }
    }

    public void SearchResult(int i2, String str, String str2, String str3, String str4, int i3) {
        AddCameraInterface addCameraInterface2;
        String str5 = this.TAG;
        Log.d(str5, "SearchResult: " + str4 + " " + i3);
        if (str3.length() != 0 && (addCameraInterface2 = addCameraInterface) != null) {
            addCameraInterface2.callBackSearchResultData(i2, str, str2, str3, str4, i3);
        }
    }

    public void CallBack_getBatteryResult(String str, String str2) {
        int parseInt = Integer.parseInt(str2.substring(str2.indexOf("battband=") + 9, str2.indexOf(";")));
        Log.e("BridgeService", "### 当前电量为:" + str2 + " " + parseInt);
        CameraBatteryInterface cameraBatteryInterface2 = cameraBatteryInterface;
        if (cameraBatteryInterface2 != null) {
            cameraBatteryInterface2.callBackBatteryResult(parseInt);
        }
    }

    public void CallBack_SetSystemParamsResult(String str, int i2, int i3) {
        if (i2 == 28) {
            SDCardInterface sDCardInterface = sCardInterface;
            if (sDCardInterface != null) {
                sDCardInterface.callBackSetSystemParamsResult(str, i2, i3);
            }
        } else if (i2 == 57) {
            DoorBellAlerm doorBellAlerm2 = doorBellAlerm;
            if (doorBellAlerm2 != null) {
                doorBellAlerm2.callBackSetSystemParamsResult(str, i2, i3);
            }
        } else if (i2 != 65) {
            switch (i2) {
                case 10:
                    UserInterface userInterface2 = userInterface;
                    if (userInterface2 != null) {
                        userInterface2.callBackSetSystemParamsResult(str, i2, i3);
                        return;
                    }
                    return;
                case 11:
                    WifiInterface wifiInterface2 = wifiInterface;
                    if (wifiInterface2 != null) {
                        wifiInterface2.callBackSetSystemParamsResult(str, i2, i3);
                        return;
                    }
                    return;
                case 12:
                    if (dateTimeInterface != null) {
                        String str2 = this.TAG;
                        Log.d(str2, "user result:" + i3 + " paramType:" + i2);
                        dateTimeInterface.callBackSetSystemParamsResult(str, i2, i3);
                        return;
                    }
                    return;
                default:
                    switch (i2) {
                        case 16:
                            MailInterface mailInterface2 = mailInterface;
                            if (mailInterface2 != null) {
                                mailInterface2.callBackSetSystemParamsResult(str, i2, i3);
                                return;
                            }
                            return;
                        case 17:
                            FtpInterface ftpInterface2 = ftpInterface;
                            if (ftpInterface2 != null) {
                                ftpInterface2.callBackSetSystemParamsResult(str, i2, i3);
                                return;
                            }
                            return;
                        case 18:
                            AlarmInterface alarmInterface2 = alarmInterface;
                            if (alarmInterface2 != null) {
                                alarmInterface2.callBackSetSystemParamsResult(str, i2, i3);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
            }
        } else {
            Log.e("BridgeService", "###MSG_TYPE_RESET_USER_PARAM select!");
            AddCameraInterface addCameraInterface2 = addCameraInterface;
            if (addCameraInterface2 != null) {
                addCameraInterface2.callBackResetResultData(0);
            }
        }
    }

    public void CallBack_CameraParams(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Log.d("ddd", "CallBack_CameraParams fram==" + i8);
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBackCameraParamNotify(str, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    }

    public void CallBack_WifiParams(String str, int i2, String str2, int i3, int i4, int i5, int i6, int i7, int i8, String str3, String str4, String str5, String str6, int i9, int i10, int i11, int i12, String str7, int i13) {
        Log.d("ddd", "CallBack_WifiParams");
        WifiInterface wifiInterface2 = wifiInterface;
        if (wifiInterface2 != null) {
            wifiInterface2.callBackWifiParams(str, i2, str2, i3, i4, i5, i6, i7, i8, str3, str4, str5, str6, i9, i10, i11, i12, str7);
        }
    }

    public void CallBack_UserParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Log.d("ddd", "CallBack_UserParams");
        UserInterface userInterface2 = userInterface;
        if (userInterface2 != null) {
            userInterface2.callBackUserParams(str, str2, str3, str4, str5, str6, str7, str8, str9);
        }
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.callBackUserParams(str, str2, str3, str4, str5, str6, str7);
        }
    }

    public void CallBack_FtpParams(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4) {
        FtpInterface ftpInterface2 = ftpInterface;
        if (ftpInterface2 != null) {
            ftpInterface2.callBackFtpParams(str, str2, str3, str4, str5, i2, i3, i4);
        }
    }

    public void CallBack_DDNSParams(String str, int i2, String str2, String str3, String str4, String str5, int i3, int i4) {
        Log.d("ddd", "CallBack_DDNSParams");
    }

    public void CallBack_MailParams(String str, String str2, int i2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9) {
        MailInterface mailInterface2 = mailInterface;
        if (mailInterface2 != null) {
            mailInterface2.callBackMailParams(str, str2, i2, str3, str4, i3, str5, str6, str7, str8, str9);
        }
    }

    public void CallBack_DatetimeParams(String str, int i2, int i3, int i4, String str2) {
        DateTimeInterface dateTimeInterface2 = dateTimeInterface;
        if (dateTimeInterface2 != null) {
            dateTimeInterface2.callBackDatetimeParams(str, i2, i3, i4, str2);
        }
    }

    private void PPPPSnapshotNotify(String str, byte[] bArr, int i2) {
        String str2 = this.TAG;
        Log.d(str2, "did:" + str + " len:" + i2);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.BSSnapshotNotify(str, bArr, i2);
        }
    }

    public void CallBack_Snapshot(String str, byte[] bArr, int i2) {
        Log.d("ddd", "CallBack_Snapshot");
        if (this.PicIsOne == 1) {
            savePicToSDcard(BitmapFactory.decodeByteArray(bArr, 0, i2));
            return;
        }
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.BSSnapshotNotify(str, bArr, i2);
        }
        SnapShotInterface snapShotInterface2 = snapShotInterface;
        if (snapShotInterface2 != null) {
            snapShotInterface2.BSSnapshot(str, bArr, i2);
        }
    }

    public void CallBack_FileList(String str, int i2, byte[] bArr, int i3) {
        Log.e("CallBack_FileList", "#### you have get a video list:");
        IRecordFileInterface iRecordFileInterface = recordFileInterface;
        if (iRecordFileInterface != null) {
            iRecordFileInterface.onRecordFileNotify(str, i2, bArr, i3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0077 A[SYNTHETIC, Splitter:B:24:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A[SYNTHETIC, Splitter:B:27:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void savePicToSDcard(android.graphics.Bitmap r8) {
        /*
            r7 = this;
            java.lang.String r0 = "_"
            java.lang.String r1 = "savePicToSDcard"
            java.lang.String r2 = "test"
            android.util.Log.d(r2, r1)
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x006e }
            java.io.File r5 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x006e }
            java.lang.String r6 = "LittleStars/picVisitor"
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x006e }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x006e }
            if (r5 != 0) goto L_0x001e
            r4.mkdirs()     // Catch:{ Exception -> 0x006e }
        L_0x001e:
            java.lang.String r5 = r7.PicData     // Catch:{ Exception -> 0x006e }
            java.lang.String r6 = " "
            java.lang.String r5 = r5.replace(r6, r0)     // Catch:{ Exception -> 0x006e }
            java.lang.String r6 = "-"
            java.lang.String r5 = r5.replace(r6, r0)     // Catch:{ Exception -> 0x006e }
            java.lang.String r6 = ":"
            java.lang.String r0 = r5.replace(r6, r0)     // Catch:{ Exception -> 0x006e }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x006e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006e }
            r6.<init>()     // Catch:{ Exception -> 0x006e }
            r6.append(r0)     // Catch:{ Exception -> 0x006e }
            java.lang.String r0 = ".jpg"
            r6.append(r0)     // Catch:{ Exception -> 0x006e }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x006e }
            r5.<init>(r4, r0)     // Catch:{ Exception -> 0x006e }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x006e }
            r0.<init>(r5)     // Catch:{ Exception -> 0x006e }
            if (r8 == 0) goto L_0x0063
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0060, all -> 0x005d }
            r4 = 60
            boolean r8 = r8.compress(r3, r4, r0)     // Catch:{ Exception -> 0x0060, all -> 0x005d }
            if (r8 == 0) goto L_0x0063
            r0.flush()     // Catch:{ Exception -> 0x0060, all -> 0x005d }
            goto L_0x0063
        L_0x005d:
            r8 = move-exception
            r3 = r0
            goto L_0x007b
        L_0x0060:
            r8 = move-exception
            r3 = r0
            goto L_0x006f
        L_0x0063:
            r0.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x007a
        L_0x0067:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x007a
        L_0x006c:
            r8 = move-exception
            goto L_0x007b
        L_0x006e:
            r8 = move-exception
        L_0x006f:
            r8.printStackTrace()     // Catch:{ all -> 0x006c }
            android.util.Log.d(r2, r1)     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x007a
            r3.close()     // Catch:{ IOException -> 0x0067 }
        L_0x007a:
            return
        L_0x007b:
            if (r3 == 0) goto L_0x0085
            r3.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0085:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.BridgeService.savePicToSDcard(android.graphics.Bitmap):void");
    }

    public void CallBack_APParams(String str, String str2, String str3) {
        Log.d("shix", "CallBack_APParams---ssid=" + str2 + "pwd=" + str3);
    }

    public void CallBack_NetworkParams(String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, int i4) {
        Log.d("ddd", "CallBack_NetworkParams");
    }

    public void CallBack_CameraStatusParams(String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5) {
        Log.d("ddd", "CallBack_CameraStatusParams");
        DoorBellGETSTATU doorBellGETSTATU2 = doorBellGETSTATU;
        if (doorBellGETSTATU2 != null) {
            doorBellGETSTATU2.CallBackStatu(str, str2, str4);
            doorBellGETSTATU.CallBackSDStatu(str, i3, i4, i5);
        }
    }

    public void CallBack_PTZParams(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        Log.d("ddd", "CallBack_PTZParams");
    }

    public void CallBack_WifiScanResult(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, int i7) {
        Log.d("tag", "CallBack_WifiScanResult");
        WifiInterface wifiInterface2 = wifiInterface;
        if (wifiInterface2 != null) {
            wifiInterface2.callBackWifiScanResult(str, str2, str3, i2, i3, i4, i5, i6, i7);
        }
    }

    public void CallBack_AlarmParams(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34) {
        AlarmInterface alarmInterface2 = alarmInterface;
        if (alarmInterface2 != null) {
            alarmInterface2.callBackAlarmParams(str, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34);
        }
    }

    public void CallBack_GetDoorUserParm(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        Log.d("test", "CallBack_GetDoorUserParm did:" + str + " user1:" + str2 + "  pwd1:" + str3 + "   s1:" + i3 + "   alias:" + str18);
        DoorBellUserInterface doorBellUserInterface2 = doorBellUserInterface;
        if (doorBellUserInterface2 != null) {
            doorBellUserInterface2.CallBackUserParms(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date());
    }

    public void CallBack_DoorBell_Logs(String str, String str2, int i2, int i3) {
        LogsInterface logsInterface2 = logsInterface;
        if (logsInterface2 != null) {
            logsInterface2.CallBack_DoorBell_Logs(str, str2, i2, i3);
        }
        Log.d("test", "UUID:" + str + "  user:" + str2 + "  status:" + i2);
    }

    public void CallBack_AlarmNotifyDoorBell(String str, String str2, String str3, String str4) {
        DoorBellAlermPush doorBellAlermPush2;
        Log.e("test", "doorbell:db_did:" + str3 + "  db_type:" + str4 + "  db_time:" + str2);
        if (str3 != null && str3.length() >= 3) {
            this.pushID = str3.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toUpperCase();
            this.alermType = str4;
            this.dateTime = getStrDate();
            if (this.alermType.equalsIgnoreCase("20") || this.alermType.equalsIgnoreCase("21")) {
                this.alermType = "2";
            }
            if (this.alermType.equalsIgnoreCase("22")) {
                this.alermType = "11";
            }
            String str5 = this.alermType;
            if (str5 == null) {
                return;
            }
            if (str5.equalsIgnoreCase("1") || this.alermType.equalsIgnoreCase("2") || this.alermType.equalsIgnoreCase("11")) {
                this.PicData = this.dateTime;
                this.PicUuid = str2;
                this.picType = str4;
                this.PicIsOne = 0;
                if (this.alermType.equalsIgnoreCase("2")) {
                    getNotification1(getResources().getString(R.string.doorbell_alerm), this.pushID, this.alermType, this.dateTime, str2);
                    this.PicIsOne = 1;
                    NativeCaller.SnapShot(this.pushID, this.PicUuid);
                    return;
                }
                if (SystemValue.isStartRun && (doorBellAlermPush2 = doorBellAlermPush) != null) {
                    doorBellAlermPush2.CallBackDoorbellType(str2, Integer.parseInt(this.alermType));
                }
                if (SystemValue.isStartRun || doorBellAlermPush != null) {
                    if (this.alermType.equalsIgnoreCase("1")) {
                        getNotification1(getResources().getString(R.string.alerm_push_notify), this.pushID, this.alermType, this.dateTime, str2);
                    } else {
                        getNotification1(getResources().getString(R.string.alerm_push_notify), this.pushID, this.alermType, this.dateTime, str2);
                    }
                    this.PicIsOne = 1;
                    NativeCaller.SnapShot(this.pushID, this.PicUuid);
                    return;
                }
                SystemValue.isStartRun = true;
                intentToStart(this.alermType, this.pushID, true, this.dateTime, str2);
            } else if (this.alermType.equalsIgnoreCase("3") || this.alermType.equalsIgnoreCase("6") || this.alermType.equalsIgnoreCase("7") || this.alermType.equalsIgnoreCase("5") || this.alermType.equalsIgnoreCase("4")) {
                DoorBellAlermPush doorBellAlermPush3 = doorBellAlermPush;
                if (doorBellAlermPush3 != null) {
                    doorBellAlermPush3.CallBackAlermType(Integer.parseInt(this.alermType));
                }
                PlayInterface playInterface2 = playInterface;
                if (playInterface2 != null) {
                    playInterface2.CallBackAlermType(this.pushID, Integer.parseInt(this.alermType));
                }
            }
        }
    }

    private Notification getNotification1(String str, String str2, String str3, String str4, String str5) {
        Log.e("tag", "#####alarm did:" + str2);
        SystemValue.PushAlarmCount = SystemValue.PushAlarmCount + 1;
        DataBaseHelper dataBaseHelper = this.baseHelper;
        String str6 = this.pushID;
        dataBaseHelper.insertAlarmLogToDB(str6, str3 + "3", str4, str5, 2);
        String retrunUser = retrunUser(str2);
        String retrunUserPWD = retrunUserPWD(str2);
        String retrunName = retrunName(str2);
        Intent intent = new Intent(this, AlarmLogActivity.class);
        intent.putExtra(ContentCommon.STR_CAMERA_NAME, retrunName);
        intent.putExtra(ContentCommon.STR_CAMERA_ID, str2);
        intent.putExtra(ContentCommon.STR_CAMERA_USER, retrunUser);
        intent.putExtra(ContentCommon.STR_CAMERA_PWD, retrunUserPWD);
        SystemValue.doorBellAdmin = retrunUser;
        SystemValue.doorBellPass = retrunUserPWD;
        this.mNotify2 = new Notification(R.drawable.app, retrunName + " " + str, System.currentTimeMillis());
        this.mNotify2.flags = 2;
        PendingIntent activity = PendingIntent.getActivity(this, R.drawable.app, intent, 134217728);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_layout);
        Notification notification = this.mNotify2;
        notification.contentIntent = activity;
        notification.contentView = remoteViews;
        notification.contentView.setTextViewText(R.id.no_title, retrunName);
        RemoteViews remoteViews2 = this.mNotify2.contentView;
        remoteViews2.setTextViewText(R.id.no_content, str + " (" + SystemValue.PushAlarmCount + ")");
        this.mNotify2.contentView.setTextViewText(R.id.no_time, str4);
        this.mNotify2.contentView.setImageViewResource(R.id.no_img, R.drawable.app);
        Notification notification2 = this.mNotify2;
        notification2.defaults = -1;
        this.mCustomMgr.notify(110, notification2);
        return this.mNotify2;
    }

    private void intentToStart(String str, String str2, boolean z, String str3, String str4) {
        String str5;
        for (int i2 = 0; i2 < SystemValue.arrayList.size(); i2++) {
            if (SystemValue.arrayList.get(i2).getDid().equals(str2)) {
                this.Name = SystemValue.arrayList.get(i2).getName();
            }
        }
        if (str.equals("1")) {
            str5 = getResources().getString(R.string.doorbell_fangke);
            this.pushType = 1;
        } else if (str.equals("11")) {
            str5 = getResources().getString(R.string.doorbell_alerm11);
            this.pushType = 11;
        } else {
            str5 = getResources().getString(R.string.doorbell_alerm);
            this.pushType = 2;
        }
        Intent intent = new Intent(this, ListeningActivity.class);
        intent.putExtra(ContentCommon.STR_CAMERA_ID, str2);
        intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.Name);
        intent.putExtra("pushType", str5);
        intent.putExtra("pushIsAlerm", this.pushType);
        intent.putExtra("pushPic", str4);
        intent.putExtra("pushDate", str3);
        intent.putExtra(ContentCommon.STR_CAMERA_USER, retrunUser(str2));
        intent.putExtra(ContentCommon.STR_CAMERA_PWD, retrunUserPWD(str2));
        intent.putExtra(ContentCommon.STR_CAMERA_TYPE, 0);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    private String retrunUser(String str) {
        int i2 = 0;
        while (i2 < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i2).getDid())) {
                i2++;
            } else {
                Log.d("tag", "testuser:" + SystemValue.arrayList.get(i2).getUser());
                return SystemValue.arrayList.get(i2).getUser();
            }
        }
        return null;
    }

    private String retrunUserPWD(String str) {
        int i2 = 0;
        while (i2 < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i2).getDid())) {
                i2++;
            } else {
                Log.d("tag", "testuserpwd:" + SystemValue.arrayList.get(i2).getPwd());
                return SystemValue.arrayList.get(i2).getPwd();
            }
        }
        return null;
    }

    public void CallBack_AlarmNotify(String str, int i2) {
        Log.d("tag", "callBack_AlarmNotify did:" + str + " alarmtype:" + i2);
    }

    private void CallBack_RecordFileSearchResult(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7) {
        String str3 = this.TAG;
        Log.d(str3, "CallBack_RecordFileSearchResult did: " + str + " filename: " + str2 + " size: " + i2);
        PlayBackTFInterface playBackTFInterface2 = playBackTFInterface;
        if (playBackTFInterface2 != null) {
            playBackTFInterface2.callBackRecordFileSearchResult(str, str2, i2, i4, i7);
        }
    }

    private void CallBack_PlaybackVideoData(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        String str2 = this.TAG;
        Log.d(str2, "CallBack_PlaybackVideoData  len:" + i3 + " width:" + i4 + " height:" + i5 + "  time:" + i6);
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.callBackPlaybackVideoData(bArr, i2, i3, i4, i5, i6);
        }
    }

    private void CallBack_H264Data(String str, byte[] bArr, int i2, int i3) {
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBackH264Data(str, bArr, i2, i3);
        }
    }

    public void CallBack_RecordSchParams(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29) {
        Log.d("shix_sd", "shix_sd:record_cover_enable:" + i2);
        SDCardInterface sDCardInterface = sCardInterface;
        if (sDCardInterface != null) {
            sDCardInterface.callBackRecordSchParams(str, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29);
        }
    }

    public void CallBack_GetLockParm(String str, int i2, int i3) {
        DoorBellLockParmInterface doorBellLockParmInterface2 = doorBellLockParmInterface;
        if (doorBellLockParmInterface2 != null) {
            doorBellLockParmInterface2.callBackDoorBellLockParm(str, i2, i3);
        }
    }

    public void CallBack_GetAlarmParm(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        StringBuilder sb = new StringBuilder();
        sb.append("did:");
        String str2 = str;
        sb.append(str);
        sb.append("  alarm_on:");
        int i10 = i2;
        sb.append(i2);
        sb.append("  alarm_type:");
        int i11 = i3;
        sb.append(i3);
        sb.append("  alarm_level:");
        sb.append(i4);
        sb.append("  alarm_delay:");
        sb.append(i5);
        sb.append("  alarm_start_hour:");
        sb.append(i6);
        sb.append("  alarm_stop_hour:");
        sb.append(i7);
        sb.append("  alarm_start_minute:");
        sb.append(i8);
        sb.append("  alarm_stop_minute:");
        sb.append(i9);
        Log.e("test", sb.toString());
        DoorBellAlarmParmInterface doorBellAlarmParmInterface2 = doorBellAlarmParmInterface;
        if (doorBellAlarmParmInterface2 != null) {
            doorBellAlarmParmInterface2.callBackDoorBellAlarmParm(str, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    }

    public void CallBack_GetInterfaceParm(String str, int i2, int i3, int i4, int i5) {
        Log.e("test", "did:" + str + "  pin:" + i2 + "  pin_bind:" + i3 + "  pout:" + i4 + "  pout_bind:" + i5);
        DoorBellInterfaceParmInterface doorBellInterfaceParmInterface2 = doorBellInterfaceParmInterface;
        if (doorBellInterfaceParmInterface2 != null) {
            doorBellInterfaceParmInterface2.callBackDoorBellInterfaceParm(str, i2, i3, i4, i5);
        }
    }

    public void CallBack_GetDoorSystemParm(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        String str2 = str;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        Log.e("test", "did:" + str2 + "  bell_on:" + i9 + "  bell_audio:" + i10 + "  bell_mode:" + i11 + "  max_watch:" + i6 + "  max_talk:" + i7 + "  max_wait:" + i8);
        DoorBellSystemParmInterface doorBellSystemParmInterface2 = doorBellSystemParmInterface;
        if (doorBellSystemParmInterface2 != null) {
            doorBellSystemParmInterface2.callBackDoorBellSystemParm(str, i2, i3, i4, i5, i6, i7, i8);
            Log.e("test", "2did:" + str2 + "  bell_on:" + i9 + "  bell_audio:" + i10 + "  bell_mode:" + i11 + "  max_watch:" + i6 + "  max_talk:" + i7 + "  max_wait:" + i8);
        }
    }

    private String retrunName(String str) {
        for (int i2 = 0; i2 < SystemValue.arrayList.size(); i2++) {
            if (str != null && str.equals(SystemValue.arrayList.get(i2).getDid())) {
                return SystemValue.arrayList.get(i2).getName();
            }
        }
        return null;
    }

    class ControllerBinder extends Binder {
        ControllerBinder() {
        }

        public BridgeService getBridgeService() {
            return BridgeService.this;
        }
    }
}
