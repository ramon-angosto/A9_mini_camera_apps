package com.shix.shixipc.system;

import com.shix.shixipc.bean.CameraListBean;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import org.json.JSONException;

public class ContentCommon {
    public static final int ADD_CAMERA = 1;
    public static final String APP_SOFTVERSION = "1.2";
    public static final String APP_SOFTVERSION_SELF = "V:1.2201.1115";
    public static int AP_ADD_OR_CON = 1;
    public static String AP_ADD_UID = "";
    public static final String CAMERA_OPTION = "camera_option";
    public static final int CAMERA_TYPE_H264 = 2;
    public static final int CAMERA_TYPE_MJPEG = 1;
    public static final int CAMERA_TYPE_UNKNOW = 0;
    public static final int CGI_IEGET_CAM_PARAMS = 24579;
    public static final int CHANGE_CAMERA_USER = 3;
    public static final String CLOUDBUCKET = "shixdev";
    public static final String CLOUDBUCKETHQ = "hdwificam";
    public static final String CLOUDTESETDID = "";
    public static final int CMD_PTZ_CENTER = 25;
    public static final int CMD_PTZ_DOWN = 2;
    public static final int CMD_PTZ_DOWN_STOP = 3;
    public static final int CMD_PTZ_HORIZONAL_MIRROR = 2;
    public static final int CMD_PTZ_LEFT = 4;
    public static final int CMD_PTZ_LEFT_RIGHT = 28;
    public static final int CMD_PTZ_LEFT_RIGHT_STOP = 29;
    public static final int CMD_PTZ_LEFT_STOP = 5;
    public static final int CMD_PTZ_ORIGINAL = 0;
    public static final int CMD_PTZ_PREFAB_BIT_RUN0 = 31;
    public static final int CMD_PTZ_PREFAB_BIT_RUN1 = 33;
    public static final int CMD_PTZ_PREFAB_BIT_RUN2 = 35;
    public static final int CMD_PTZ_PREFAB_BIT_RUN3 = 37;
    public static final int CMD_PTZ_PREFAB_BIT_RUN4 = 39;
    public static final int CMD_PTZ_PREFAB_BIT_RUN5 = 41;
    public static final int CMD_PTZ_PREFAB_BIT_RUN6 = 43;
    public static final int CMD_PTZ_PREFAB_BIT_RUN7 = 45;
    public static final int CMD_PTZ_PREFAB_BIT_RUN8 = 47;
    public static final int CMD_PTZ_PREFAB_BIT_RUN9 = 49;
    public static final int CMD_PTZ_PREFAB_BIT_RUNA = 51;
    public static final int CMD_PTZ_PREFAB_BIT_RUNB = 53;
    public static final int CMD_PTZ_PREFAB_BIT_RUNC = 55;
    public static final int CMD_PTZ_PREFAB_BIT_RUND = 57;
    public static final int CMD_PTZ_PREFAB_BIT_RUNE = 59;
    public static final int CMD_PTZ_PREFAB_BIT_RUNF = 61;
    public static final int CMD_PTZ_PREFAB_BIT_SET0 = 30;
    public static final int CMD_PTZ_PREFAB_BIT_SET1 = 32;
    public static final int CMD_PTZ_PREFAB_BIT_SET2 = 34;
    public static final int CMD_PTZ_PREFAB_BIT_SET3 = 36;
    public static final int CMD_PTZ_PREFAB_BIT_SET4 = 38;
    public static final int CMD_PTZ_PREFAB_BIT_SET5 = 40;
    public static final int CMD_PTZ_PREFAB_BIT_SET6 = 42;
    public static final int CMD_PTZ_PREFAB_BIT_SET7 = 44;
    public static final int CMD_PTZ_PREFAB_BIT_SET8 = 46;
    public static final int CMD_PTZ_PREFAB_BIT_SET9 = 48;
    public static final int CMD_PTZ_PREFAB_BIT_SETA = 50;
    public static final int CMD_PTZ_PREFAB_BIT_SETB = 52;
    public static final int CMD_PTZ_PREFAB_BIT_SETC = 54;
    public static final int CMD_PTZ_PREFAB_BIT_SETD = 56;
    public static final int CMD_PTZ_PREFAB_BIT_SETE = 58;
    public static final int CMD_PTZ_PREFAB_BIT_SETF = 60;
    public static final int CMD_PTZ_RIGHT = 6;
    public static final int CMD_PTZ_RIGHT_STOP = 7;
    public static final int CMD_PTZ_UP = 0;
    public static final int CMD_PTZ_UP_DOWN = 26;
    public static final int CMD_PTZ_UP_DOWN_STOP = 27;
    public static final int CMD_PTZ_UP_STOP = 1;
    public static final int CMD_PTZ_VERHOR_MIRROR = 3;
    public static final int CMD_PTZ_VERTICAL_MIRROR = 1;
    public static final int DEFAULT_PORT = 81;
    public static final String DEFAULT_USER_NAME = "admin";
    public static final String DEFAULT_USER_PWD = "";
    public static final int DEL_CAMERA = 4;
    public static final int EDIT_CAMERA = 2;
    public static final String FCM_SERVER_KEY = "";
    public static String FCM_TOKEN = "";
    public static final int GPIO_ALARM = 2;
    public static final int H264_MAIN_STREAM = 0;
    public static final int H264_SUB_STREAM = 1;
    public static String HW_APPSECRET = "ae6f4e2a00c6ec61812bcae460bf8e20b4ff872be6977fc739bf3036cdcb66f3";
    public static String HW_APP_ID = "103903377";
    public static String HW_APP_KEY = "CgB6e3x9RDGdyZ9P+zkQp0/IfNPY65/NUssv/M5HW0lj+5j3IupM5xAI711S3fY1fv9/v9SGA+/JegHGnjcZ8cBJ";
    public static String HW_STRING = "";
    public static final int INVALID_OPTION = 65535;
    public static final Boolean ISAUDIOSHOW = false;
    public static final Boolean ISVISI = true;
    public static final String MAIN_KEY_BACK = "key_back";
    public static final String MAIN_KEY_MENU = "key_menu";
    public static final int MJPEG_SUB_STREAM = 3;
    public static final int MOTION_ALARM = 1;
    public static final int MSG_TYPE_ALARM_PARAMS = 38;
    public static final int MSG_TYPE_CAMERA_CONTROL = 6;
    public static final int MSG_TYPE_CLEAR_ALARM_LOG = 29;
    public static final int MSG_TYPE_DATETIME_PARAMS = 37;
    public static final int MSG_TYPE_DDNS_PARAMS = 36;
    public static final int MSG_TYPE_DECODER_CONTROL = 3;
    public static final int MSG_TYPE_DEL_RECORD_FILE = 26;
    public static final int MSG_TYPE_FTP_PARAMS = 33;
    public static final int MSG_TYPE_GET_ALARM_LOG = 21;
    public static final int MSG_TYPE_GET_AP = 53;
    public static final int MSG_TYPE_GET_APP_VERSION = 56;
    public static final int MSG_TYPE_GET_CAMERA_PARAMS = 2;
    public static final int MSG_TYPE_GET_PARAMS = 4;
    public static final int MSG_TYPE_GET_PTZ_PARAMS = 14;
    public static final int MSG_TYPE_GET_RECORD = 22;
    public static final int MSG_TYPE_GET_RECORD_FILE = 23;
    public static final int MSG_TYPE_GET_STATUS = 13;
    public static final int MSG_TYPE_MAIL_PARAMS = 32;
    public static final int MSG_TYPE_NETWORK_PARAMS = 34;
    public static final int MSG_TYPE_REBOOT_DEVICE = 8;
    public static final int MSG_TYPE_RESTORE_FACTORY = 9;
    public static final int MSG_TYPE_SET_ALARM = 18;
    public static final int MSG_TYPE_SET_AP = 52;
    public static final int MSG_TYPE_SET_DATETIME = 12;
    public static final int MSG_TYPE_SET_DDNS = 15;
    public static final int MSG_TYPE_SET_DEVNAME = 39;
    public static final int MSG_TYPE_SET_FTP = 17;
    public static final int MSG_TYPE_SET_MAIL = 16;
    public static final int MSG_TYPE_SET_MEDIA = 27;
    public static final int MSG_TYPE_SET_NETWORK = 7;
    public static final int MSG_TYPE_SET_PPPOE = 24;
    public static final int MSG_TYPE_SET_PTZ = 19;
    public static final int MSG_TYPE_SET_RECORD_SCH = 28;
    public static final int MSG_TYPE_SET_UPNP = 25;
    public static final int MSG_TYPE_SET_USER = 10;
    public static final int MSG_TYPE_SET_WIFI = 11;
    public static final int MSG_TYPE_SNAPSHOT = 5;
    public static final int MSG_TYPE_USER_INFO = 35;
    public static final int MSG_TYPE_WIFI_PARAMS = 31;
    public static final int MSG_TYPE_WIFI_SCAN = 20;
    public static String MZ_APPSECRET = "0ca124c276764bc7b54e9e94cb91c003";
    public static String MZ_APP_ID = "110551";
    public static String MZ_APP_KEY = "62ea1f4f51e6455ba737a06d75d9e613";
    public static String MZ_STRING = "";
    public static final String PLAY_FOUR_FOUR = "play_four_4";
    public static final String PLAY_FOUR_ONE = "play_four_1";
    public static final String PLAY_FOUR_THREE = "play_four_3";
    public static final String PLAY_FOUR_TWO = "play_four_2";
    public static final int PPPP_DEV_TYPE_UNKNOWN = -1;
    public static final int PPPP_MODE_P2P_NORMAL = 1;
    public static final int PPPP_MODE_P2P_RELAY = 2;
    public static final int PPPP_MODE_UNKNOWN = -1;
    public static final int PPPP_MSG_TYPE_AND_MODE = 3;
    public static final int PPPP_MSG_TYPE_INVALID_MSG = -1;
    public static final int PPPP_MSG_TYPE_PPPP_MODE = 1;
    public static final int PPPP_MSG_TYPE_PPPP_STATUS = 0;
    public static final int PPPP_MSG_TYPE_STREAM = 2;
    public static final int PPPP_STATUS_CONNECTING = 0;
    public static final int PPPP_STATUS_CONNECT_ERRER = 8;
    public static final int PPPP_STATUS_CONNECT_FAILED = 3;
    public static final int PPPP_STATUS_CONNECT_TIMEOUT = 7;
    public static final int PPPP_STATUS_DEVICE_NOT_ON_LINE = 6;
    public static final int PPPP_STATUS_DISCONNECT = 4;
    public static final int PPPP_STATUS_INITIALING = 1;
    public static final int PPPP_STATUS_INVALID_ID = 5;
    public static final int PPPP_STATUS_ON_LINE = 2;
    public static final int PPPP_STATUS_UNKNOWN = -1;
    public static final int PPPP_STREAM_TYPE_H264 = 0;
    public static final int PPPP_STREAM_TYPE_JPEG = 1;
    public static final String PREDATA = "predata";
    public static final int REFRESH_CAMERA = 5;
    public static final String SDCARD_PATH = "HDWiFiCam";
    public static final String SERVER_STRING = "test";
    public static final int SHIXFINAL_ERRORINT = -110;
    public static final String SHIX_APPRE = "DGK";
    public static final String SHIX_APPRE1 = "DGO";
    public static final String SHIX_APPRE2 = "DBG";
    public static final String SHIX_APPRE3 = "DGOA";
    public static final String SHIX_APPRE4 = "DGOB";
    public static final String SHIX_DEFUALT_NAME = "Camera";
    public static final String SHIX_DEFUALT_PWD = "6666";
    public static final String SHIX_DEFUALT_USER = "admin";
    public static final int SHIX_ISTEST_APP = 0;
    public static final String SHIX_SAVE_DEVS = "SHIX_SAVE_DEVS";
    public static final String SHIX_SHARE_BAT = "SHIX_SHARE_BAT";
    public static final String SHIX_SHARE_COMMON = "shix.share.common";
    public static final String SHIX_SHARE_PRINT_DID = "shixprintdid";
    public static final int SHIX_TEST_APP_COUNT = 50;
    public static final int STREAM_TYPE = 10;
    public static final String STR_APP_UUID = "app_uuid";
    public static final String STR_CAMERA_ADDR = "camera_addr";
    public static final String STR_CAMERA_DEVMODE = "camera_devmode";
    public static final String STR_CAMERA_DEVTYPE = "camera_devtype";
    public static final String STR_CAMERA_ID = "cameraid";
    public static final String STR_CAMERA_INFO_RECEIVER = "object.newui.client.camerainforeceiver";
    public static final String STR_CAMERA_MAC = "camera_mac";
    public static final String STR_CAMERA_NAME = "camera_name";
    public static final String STR_CAMERA_OLD_ADDR = "camera_old_addr";
    public static final String STR_CAMERA_OLD_ID = "camera_old_id";
    public static final String STR_CAMERA_OLD_PORT = "camera_old_port";
    public static final String STR_CAMERA_PORT = "camera_port";
    public static final String STR_CAMERA_PWD = "camera_pwd";
    public static final String STR_CAMERA_SNAPSHOT = "camera_snapshot";
    public static final String STR_CAMERA_TYPE = "camera_type";
    public static final String STR_CAMERA_USER = "camera_user";
    public static final String STR_CAMERA_USER_AUTHORITY = "camera_user_authority";
    public static final String STR_CLOUD_DATE = "cloud_date";
    public static final String STR_CLOUD_ONEDAY = "cameraoneday";
    public static final String STR_H264_MAIN_STREAM = "h264_main_stream";
    public static final String STR_H264_SUB_STREAM = "h264_sub_stream";
    public static final String STR_MJPEG_SUB_STREAM = "mjpeg_sub_stream";
    public static final String STR_PPPP_STATUS = "pppp_status";
    public static final String STR_STREAM_TYPE = "stream_type";
    public static final String STYLEMENU = "style_menu";
    public static final String STYLEMENUBG = "style_menu_bg";
    public static final String STYLEPH = "style_pi_fu";
    public static final int VERSIONDEVLORP = 0;
    public static final int VISITIME = 10;
    public static final String XG_ACCESSID = "2100347780";
    public static final String XG_APPID = "2100347780";
    public static final String XG_SECRETKEY = "addad46d4cf8d4003eca482c3d624d92";
    public static String XG_TOKEN = "";
    public static final String XM_APP_ID = "2882303761518409548";
    public static final String XM_APP_KEY = "5791840937548";
    public static final String XM_APP_Secret = "kLM7yeKwGfz1+KVjbT32SQ==";
    public static String XM_REGID = "";

    public static void SHIX_saveDevList() {
        try {
            SharedPreferencesUtils.getInstance().putString(SHIX_SAVE_DEVS, CameraListBean.toJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|4|5|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0046, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0047, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean SHIX_saveDev(com.shix.shixipc.bean.CameraParamsBean r4) {
        /*
            if (r4 != 0) goto L_0x0004
            r4 = 0
            return r4
        L_0x0004:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0029 }
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            int r0 = (int) r0     // Catch:{ Exception -> 0x0029 }
            android.content.Context r1 = com.shix.shixipc.CrashApplication.getContext()     // Catch:{ Exception -> 0x0029 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0029 }
            r2.<init>()     // Catch:{ Exception -> 0x0029 }
            java.lang.String r3 = r4.getDev_Did()     // Catch:{ Exception -> 0x0029 }
            r2.append(r3)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r3 = "addnow"
            r2.append(r3)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0029 }
            r3 = 0
            com.shix.shixipc.utils.CommonUtil.SaveCommonShare(r1, r2, r3, r0)     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            com.shix.shixipc.utils.SharedPreferencesUtils r0 = com.shix.shixipc.utils.SharedPreferencesUtils.getInstance()     // Catch:{ JSONException -> 0x0046 }
            java.lang.String r1 = r4.getDev_Did()     // Catch:{ JSONException -> 0x0046 }
            java.lang.String r4 = com.shix.shixipc.bean.CameraParamsBean.toJson(r4)     // Catch:{ JSONException -> 0x0046 }
            r0.putString(r1, r4)     // Catch:{ JSONException -> 0x0046 }
            com.shix.shixipc.utils.SharedPreferencesUtils r4 = com.shix.shixipc.utils.SharedPreferencesUtils.getInstance()     // Catch:{ JSONException -> 0x0046 }
            java.lang.String r0 = "SHIX_SAVE_DEVS"
            java.lang.String r1 = com.shix.shixipc.bean.CameraListBean.toJson()     // Catch:{ JSONException -> 0x0046 }
            r4.putString(r0, r1)     // Catch:{ JSONException -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r4 = move-exception
            r4.printStackTrace()
        L_0x004a:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.system.ContentCommon.SHIX_saveDev(com.shix.shixipc.bean.CameraParamsBean):boolean");
    }

    public static boolean SHIX_delDev(CameraParamsBean cameraParamsBean) {
        if (cameraParamsBean == null) {
            return false;
        }
        SystemValue.arrayList.remove(cameraParamsBean);
        SharedPreferencesUtils.getInstance().remove(cameraParamsBean.getDev_Did());
        try {
            SharedPreferencesUtils.getInstance().putString(SHIX_SAVE_DEVS, CameraListBean.toJson());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean SHIX_getDevs() {
        try {
            CameraListBean jsonToModel = CameraListBean.jsonToModel(SharedPreferencesUtils.getInstance().getString(SHIX_SAVE_DEVS));
            if (jsonToModel != null) {
                SystemValue.arrayList.clear();
                for (int i = 0; i < jsonToModel.getDevCont(); i++) {
                    SystemValue.arrayList.add(CameraParamsBean.jsonToModel(SharedPreferencesUtils.getInstance().getString(jsonToModel.getDevS().get(i))));
                    CommonUtil.Log(1, "zhaogenghuai adddev i:" + i + " Did:" + jsonToModel.getDevS().get(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }
}
