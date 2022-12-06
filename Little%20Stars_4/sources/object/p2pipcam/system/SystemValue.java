package object.p2pipcam.system;

import android.media.MediaPlayer;
import java.util.ArrayList;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.content.ContentCommon;

public class SystemValue {
    public static CameraParamsBean ApModelBean = new CameraParamsBean();
    public static String BELL_UDID = "";
    public static int ClickMessageValue = 0;
    public static String FCMTOKEN = "";
    public static int ISPLAY = 0;
    public static boolean ISRUN = false;
    public static int NOTI = 0;
    public static int PushAlarmCount = 0;
    public static String SystemSerVer = "EBGDEJBJKGJEGIJBEBHLFGEBHMNGHFNFHFFMBCCLANJCLJKNDOAKDMPLGEKKIFLBAGNMKPDEOPNPBNCGIO:hyWHzyhtzH";
    public static String SystemSerVer_ACCQ = "EBGJFNBCKJJBGNJCEOGOFMEAHAMOHANJGEFCBKCJAPJBLHKDDAAECNPFGOLMJCLOAPMMKADLOMMDBJCNJOMK:@@@@....";
    public static String SystemSerVer_ALK = "EDHNFBBKLMIBGEIEFDHFEFFKGMNKGGMJHOEIANDLBNIKKHKFCLBNDHPHHDKBIMLIBANFKBDJPFNJBNCJIB:ALKyanfa456";
    public static String SystemSerVer_AZQ = "EFGFFBBOKOIKGKIKFMHIFGFEGBNEHPMJHGFHBMDDAJJKLAKEDCABDHPLHPKOIDLFBNNPKKCOPENLADCR:@@@@....";
    public static String SystemSerVer_TZH = "EBGDEJBJKGJEGIJBEBHLFGEBHMNGHFNFHFFMBCCLANJCLJKNDOAKDMPLGEKKIFLBAGNMKPDEOPNPBNCGIO:hyWHzyhtzH";
    public static int TAG_CAMERLIST = 0;
    public static int Token = 5;
    public static int TopBg = -14499740;
    public static ArrayList<CameraParamsBean> arrayList = new ArrayList<>();
    public static int checkSDStatu = 0;
    public static String deviceId = null;
    public static String deviceName = null;
    public static String devicePass = null;
    public static String doorBellAdmin = ContentCommon.DEFAULT_USER_NAME;
    public static String doorBellPass = "";
    public static int isDeamon = 0;
    public static boolean isLitos = true;
    public static boolean isSoftRun = false;
    public static boolean isStartRun = false;
    public static MediaPlayer mPlayer;
    public static String nowPushDID = "";
    public static int pictChange = 0;
    public static int pustType = 48;
    public static String usrName = null;
    public static int videFram = 5;

    public static CameraParamsBean getCameraParamsBean(String str) {
        new CameraParamsBean();
        for (int i = 0; i < arrayList.size(); i++) {
            if (str.endsWith(arrayList.get(i).getDid())) {
                return arrayList.get(i);
            }
        }
        return null;
    }
}
