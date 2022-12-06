package object.p2pipcam.nativecaller;

import android.content.Context;

public class NativeCaller {
    private static final String LOG_TAG = "NativeCaller";

    public static native int CloseAvi(String str);

    public static native int DEVPPPPInitial(String str);

    public static native int DEVPPPPLister(String str, String str2);

    public static native int DEVPPPPSetCallbackContext(Context context);

    public static native int DEVPPPPUnInitial();

    public static native void Free();

    public static native void Init();

    public static native int OpenAviFileName(String str, String str2, String str3, int i, int i2, int i3, int i4);

    public static native void PPPPInitial(String str);

    public static native int PPPPNetworkDetect();

    public static native int PPPPSetCallbackContext(Context context);

    public static native int PPPPStartAudio(String str);

    public static native int PPPPStartTalk(String str);

    public static native int PPPPStopAudio(String str);

    public static native int PPPPStopTalk(String str);

    public static native int PPPPTalkAudioData(String str, byte[] bArr, int i);

    public static native String SHIXClodeTest();

    public static native String SHIXGetAPPKey1(int i);

    public static native String SHIXGetAPPSer1(int i);

    public static native String SHIXTest();

    public static native int StartPPPP(String str, String str2, String str3, String str4);

    public static native int StartPPPPLivestream(String str, int i);

    public static native int StartPlayBack(String str, String str2, int i);

    public static native void StartSearch(String str);

    public static native int StopPPPP(String str);

    public static native int StopPPPPLivestream(String str);

    public static native int StopPlayBack(String str);

    public static native void StopSearch();

    public static native int TransferMessage(String str, String str2, int i);

    public static native int WriteAudioData(String str, byte[] bArr, int i);

    public static native int WriteData(String str, byte[] bArr, int i, int i2);

    public static native int YUV4202RGB565(byte[] bArr, byte[] bArr2, int i, int i2);

    static {
        System.loadLibrary("object_jni");
        System.loadLibrary("avi");
    }
}
