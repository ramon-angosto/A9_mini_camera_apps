package com.shix.shixipc.activity.nativecaller;

import android.content.Context;

public class NativeCaller {
    private static final String LOG_TAG = "NativeCaller";

    public static native int AppLog(String str, String str2);

    public static native int BZDevDelet(String str);

    public static native int BZEditUserPwd(String str, String str2);

    public static native String BZGetVer(String str);

    public static native int BZInitial(String str, int i);

    public static native String BZMessageContenGet(int i);

    public static native int BZMessageListGet(int i, int i2, int i3, int i4, int i5);

    public static native int BZMessageNumberGet();

    public static native int BZMessagePush(String str, String str2, String str3);

    public static native int BZMessageSend(int i, int i2, int i3, String str, String str2, int i4, String str3, String str4);

    public static native int BZMessageTag(int i, int i2);

    public static native int BZUserDevAdd(String str, String str2, String str3, String str4, String str5);

    public static native int BZUserDevGet(String str);

    public static native int BZUserGroupAdd(String str, String str2);

    public static native int BZUserGroupGet();

    public static native int BZUserLogin(String str, String str2);

    public static native void BZUserLoginOut();

    public static native int BZUserLoginThree(String str);

    public static native int BZUserRegist(String str, String str2);

    public static native int CloseAvi(String str);

    public static native int DecodeH264Frame(byte[] bArr, int i, byte[] bArr2, int i2, int[] iArr);

    public static native int DeletFile(String str, String str2);

    public static native int FormatSD(String str);

    public static native void Free();

    public static native void Init();

    public static native int OpenAviFileName(String str, String str2, String str3, int i, int i2, int i3, int i4);

    public static native int PPPPAlarmOpenCloseSetting(String str, int i, int i2);

    public static native int PPPPAlarmSetting(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34);

    public static native int PPPPCameraControl(String str, int i, int i2);

    public static native int PPPPDDNSSetting(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3);

    public static native int PPPPDatetimeSetting(String str, int i, int i2, int i3, String str2, int i4);

    public static native int PPPPFtpSetting(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3);

    public static native int PPPPGetCGI(String str, int i);

    public static native int PPPPGetSDCardRecordFileList(String str, int i, int i2);

    public static native int PPPPGetSystemParams(String str, int i);

    public static native void PPPPInitial(String str);

    public static native int PPPPMailSetting(String str, String str2, int i, String str3, String str4, int i2, String str5, String str6, String str7, String str8, String str9);

    public static native int PPPPNetworkDetect();

    public static native int PPPPNetworkSetting(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3);

    public static native int PPPPPTZControl(String str, int i);

    public static native int PPPPPTZSetting(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public static native int PPPPRebootDevice(String str);

    public static native int PPPPRestorFactory(String str);

    public static native int PPPPSDRecordSetting(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26);

    public static native int PPPPSendFileData(String str, byte[] bArr, int i, int i2, int i3);

    public static native int PPPPSetBizCallbackContext(Context context);

    public static native int PPPPSetCallbackContext(Context context);

    public static native int PPPPStartAudio(String str);

    public static native int PPPPStartTalk(String str);

    public static native int PPPPStopAudio(String str);

    public static native int PPPPStopTalk(String str);

    public static native int PPPPTalkAudioData(String str, byte[] bArr, int i);

    public static native int PPPPUserSetting(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public static native int PPPPWifiSetting(String str, int i, String str2, int i2, int i3, int i4, int i5, int i6, int i7, String str3, String str4, String str5, String str6, int i8, int i9, int i10, int i11, String str7);

    public static native int SetAPParam(String str, String str2, String str3);

    public static native int StartPPPP(String str, String str2, String str3, String str4);

    public static native int StartPPPPLivestream(String str, int i);

    public static native int StartPlayBack(String str, String str2, int i);

    public static native void StartSearch();

    public static native int StopPPPP(String str);

    public static native int StopPPPPLivestream(String str);

    public static native int StopPlayBack(String str);

    public static native void StopSearch();

    public static native int TransferMessage(String str, String str2, int i);

    public static native int WriteAudioData(String str, byte[] bArr, int i);

    public static native int WriteData(String str, byte[] bArr, int i, int i2);

    public static native int YUV4202RGB565(byte[] bArr, byte[] bArr2, int i, int i2);

    static {
        System.loadLibrary("ffmpeg");
        System.loadLibrary("object_jni");
        System.loadLibrary("avi_utils");
    }
}
