package com.shix.shixipc.system;

import android.media.MediaPlayer;
import com.shix.shixipc.bean.CameraParamsBean;
import java.util.ArrayList;
import shix.cykj.camera.R;

public class SystemValue {
    public static int FourAddBg = R.mipmap.video_add;
    public static int FourStopBg = R.mipmap.video_pause;
    public static boolean ISRUN = false;
    public static int NOTI = 0;
    public static int SOFTSTYPE = 0;
    public static String SystemSerVer = "EFGBFFBJKDJBGNJBEBGMFOEIHPNF";
    public static int TAG_CAMERLIST = 0;
    public static ArrayList<CameraParamsBean> arrayList = new ArrayList<>();
    public static int checkSDStatu = 0;
    public static String deviceId = null;
    public static String deviceName = null;
    public static String devicePass = null;
    public static String doorBellAdmin = null;
    public static String doorBellPass = null;
    public static boolean isExitBackGoudExit = true;
    public static int isInCn = 0;
    public static boolean isOtherView = false;
    public static boolean isStartRun = false;
    public static MediaPlayer mPlayer = null;
    public static String nowPrintDid = "";
    public static int nowPrintState = 1;
    public static int pictChange = 0;
    public static int position = 0;
    public static String usrName = null;
    public static String wx_code = "";
}
