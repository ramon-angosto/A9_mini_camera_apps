package object.p2pipcam.nativecaller;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.view.delegate.ICameraDataDelegate;

public class NativeCaller {
    private static final String LOG_TAG = "NativeCaller";
    public static final int WIFI_NOTIFY_PIC = 0;
    public static final int WIFI_NOTIFY_STATE = 1;
    public static final int WIFI_NOTIFY_VOICE = 3;
    public static final int WIFI_START_REC = 2;
    static LogUtils logUtils = LogUtils.setLogger(NativeCaller.class);
    private static ICameraDataDelegate mCameraDelegate;
    private static Handler mHandler;

    public static native int DecodeH264Frame(byte[] bArr, int i, byte[] bArr2, int i2, int[] iArr);

    public static native int FormatSD(String str);

    public static native void Free();

    public static native void Init();

    public static native int PPPPAlarmSetting(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33);

    public static native int PPPPCameraControl(String str, int i, int i2);

    public static native int PPPPDDNSSetting(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3);

    public static native int PPPPDatetimeSetting(String str, int i, int i2, int i3, String str2);

    public static native int PPPPFtpSetting(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3);

    public static native int PPPPGetCGI(String str, int i);

    public static native int PPPPGetSDCardRecordFileList(String str, int i, int i2);

    public static native int PPPPGetSystemParams(String str, int i);

    public static native void PPPPInitial(String str, int i);

    public static native int PPPPMailSetting(String str, String str2, int i, String str3, String str4, int i2, String str5, String str6, String str7, String str8, String str9);

    public static native int PPPPNetworkDetect();

    public static native int PPPPNetworkSetting(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3);

    public static native int PPPPPTZControl(String str, int i);

    public static native int PPPPPTZPlayPause(String str);

    public static native int PPPPPTZSetting(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public static native int PPPPRebootDevice(String str);

    public static native int PPPPRestorFactory(String str);

    public static native int PPPPSDRecordSetting(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26);

    public static native int PPPPSetCallbackContext(Context context);

    public static native int PPPPStartAudio(String str);

    public static native int PPPPStartTalk(String str);

    public static native int PPPPStopAudio(String str);

    public static native int PPPPStopTalk(String str);

    public static native int PPPPTalkAudioData(String str, byte[] bArr, int i);

    public static native int PPPPUserSetting(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public static native int PPPPWifiSetting(String str, int i, String str2, int i2, int i3, int i4, int i5, int i6, int i7, String str3, String str4, String str5, String str6, int i8, int i9, int i10, int i11, String str7);

    public static native int SetAPParam(String str, String str2, String str3);

    public static native int SnapShot(String str, String str2);

    public static native int StartPPPP(String str, String str2, String str3, String str4);

    public static native int StartPPPPLivestream(String str, int i, String str2, int i2);

    public static native int StartPlayBack(String str, String str2, int i);

    public static native void StartSearch();

    public static native int StopPPPP(String str);

    public static native int StopPPPPLivestream(String str);

    public static native int StopPlayBack(String str);

    public static native void StopSearch();

    public static native int TransferMessage(String str, String str2, int i);

    public static native int YUV4202RGB565(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void iCameraCloseFile();

    public static final native void iCameraDeinit();

    public static final native int iCameraEncodeStart(String str, int i);

    public static final native int iCameraEncodeStop();

    public static native byte[] iCameraGetOneFrame(int i);

    public static native byte[] iCameraGetOneSecond(double d);

    public static native int iCameraGetTotalFrame();

    public static native double iCameraGetTotalTime();

    public static final native int iCameraInit();

    public static native void iCameraOpenFile(String str);

    public static final native boolean iCameraOver();

    public static final native int iCameraRecSetParams(int i, int i2, int i3);

    public static final native int iCameraRecStart(String str);

    public static final native void iCameraRecStop();

    public static final native int iCameraRecWrite(byte[] bArr, int i);

    public static final native int iCameraRoate();

    public static final native int iCameraSetMode(int i);

    public static final native int iCameraStart();

    public static final native void iCameraStop();

    public static final native int iCameraSwitch();

    public static final native int iCameraWritePic(byte[] bArr, int i);

    public static final native void iCmdResume();

    public static final native int iCmdSend(byte[] bArr, int i);

    public static final native int iCmdStart();

    public static final native void iCmdStop();

    public static native int iNetWorkDistribution(byte[] bArr, int i);

    public static native void iNetworkCancel();

    public static native int iNetworkGetState();

    public static native int iYuanInit(int i, int i2, int i3, int i4, int i5, int i6, int i7, String str);

    public static native int iYuanProc(byte[] bArr, int i);

    public static native int iYuanRelease();

    public static final native int isEncodingVadio();

    static {
        System.loadLibrary("yuv");
        System.loadLibrary("jpeg");
        System.loadLibrary("turbojpeg");
        System.loadLibrary("avcodec");
        System.loadLibrary("avfilter");
        System.loadLibrary("avformat");
        System.loadLibrary("avutil");
        System.loadLibrary("swresample");
        System.loadLibrary("swscale");
        System.loadLibrary("avdevice");
        System.loadLibrary("c++_shared");
        System.loadLibrary("object_jni");
        System.loadLibrary("socketLib");
    }

    public NativeCaller(ICameraDataDelegate iCameraDataDelegate, Handler handler) {
        mCameraDelegate = iCameraDataDelegate;
        mHandler = handler;
    }

    public void clearHandler() {
        mHandler = null;
    }

    private static void sendMessage(int i, Object obj, int i2) {
        Handler handler = mHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = obj;
            obtainMessage.arg2 = i2;
            mHandler.sendMessage(obtainMessage);
        }
    }

    private static void sendStateMsg(int i, int i2) {
        Handler handler = mHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            mHandler.sendMessage(obtainMessage);
        }
    }

    public static void OnImageRecv(int i, byte[] bArr, int i2) {
        sendMessage(0, bArr, i2);
    }

    public static void OnVoiceRecv(byte[] bArr, int i) {
        LogUtils logUtils2 = logUtils;
        logUtils2.e("###recive a frame of voice:" + i);
        sendMessage(3, bArr, i);
    }

    public static void OnWiFiStateChange(int i) {
        sendStateMsg(1, i);
    }
}
