package object.p2pipcam.nativecaller;

import android.content.Context;

public class NativeCaller {
    public static native int CloseAvi(String str);

    public static native int DecodeH264Frame(byte[] bArr, int i, byte[] bArr2, int i2, int[] iArr);

    public static native void DecoderFree();

    public static native void DecoderInit(int i);

    public static native void Free();

    public static native void Init();

    public static native int OpenAviFileName(String str, String str2, String str3, int i, int i2, int i3, int i4);

    public static native int PPPPCheckFileBuffer(String str);

    public static native int PPPPCheckHanle(String str);

    public static native void PPPPInitial(String str);

    public static native int PPPPNetworkDetect();

    public static native int PPPPSendFileData(String str, byte[] bArr, int i, int i2, int i3, int i4);

    public static native int PPPPSetCallbackContext(Context context);

    public static native int PPPPStartAudio(String str);

    public static native int PPPPStartTalk(String str);

    public static native int PPPPStopAudio(String str);

    public static native int PPPPStopTalk(String str);

    public static native int PPPPTalkAudioData(String str, byte[] bArr, int i);

    public static native String SHIXGetAPPKey();

    public static native String SHIXGetAPPKey1(int i);

    public static native String SHIXGetAPPPay(int i);

    public static native String SHIXGetAPPSer();

    public static native String SHIXGetAPPSer1(int i);

    public static native int SetDevMac(String str, String str2);

    public static native int StartPPPP(String str, String str2, String str3, String str4, int i);

    public static native int StartPPPP1(String str, String str2, String str3, String str4, int i, String str5);

    public static native int StartPPPPLivestream(String str, int i);

    public static native int StartPlayBack(String str, String str2, int i);

    public static native void StartSearch(String str);

    public static native void StartSearch1(byte[] bArr, int i);

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
