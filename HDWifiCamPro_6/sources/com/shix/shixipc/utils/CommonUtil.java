package com.shix.shixipc.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.shix.qhipc.R;
import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.io.File;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.UByte;
import ms.bd.o.Pgl.c;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonUtil {
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final Boolean isLog = true;

    public static byte[] charToByte(char c) {
        return new byte[]{(byte) ((65280 & c) >> 8), (byte) (c & 255)};
    }

    public static boolean get(int i, int i2) {
        return (i & (1 << i2)) != 0;
    }

    public static boolean isCN(Context context) {
        return false;
    }

    public static boolean isChinaMobile(Context context) {
        return false;
    }

    public static boolean isChinaSimCard(Context context) {
        return false;
    }

    public static boolean isChinaTelecom(Context context) {
        return false;
    }

    public static boolean isChinaUnicom(Context context) {
        return false;
    }

    public static boolean isFlyme() {
        return false;
    }

    public static final int oneByteToInteger(byte b) {
        return b & UByte.MAX_VALUE;
    }

    public static File getSDFilePath() {
        if (Build.VERSION.SDK_INT >= 30) {
            Log(1, "文件路径-------------------------1");
            return CrashApplication.getContext().getExternalFilesDir((String) null);
        }
        Log(1, "文件路径-------------------------2：" + Build.VERSION.SDK_INT + "  Build.VERSION_CODES.R:" + 30);
        return Environment.getExternalStorageDirectory();
    }

    public static boolean isHarmonyOs() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final void LogAPP(int i, String str) {
        if (!isLog.booleanValue()) {
            return;
        }
        if (i == 1) {
            Log.e("LOG", "SHIXAPP--" + str);
        } else if (i == 2) {
            Log.e("LOG", "SHIXAPP--" + str);
        }
    }

    public static void playAudioShow(Context context, int i) {
        if (SystemValue.arrayList == null || SystemValue.arrayList.size() == 0) {
            SystemTTS.getInstance(context).playText(context.getResources().getString(i));
        }
    }

    public static boolean isContainChinese(String str) {
        for (int i = 0; i < SystemValue.strCount.size(); i++) {
            if (str.indexOf(SystemValue.strCount.get(i)) >= 0) {
                Log(1, "CHANA : str:" + str + "  " + SystemValue.strCount.get(i));
                return true;
            }
        }
        return false;
    }

    public static String getCurrentTimeZone() {
        return createGmtOffsetString(true, true, TimeZone.getDefault().getRawOffset());
    }

    public static String createGmtOffsetString(boolean z, boolean z2, int i) {
        char c;
        int i2 = i / 60000;
        if (i2 < 0) {
            c = '-';
            i2 = -i2;
        } else {
            c = '+';
        }
        StringBuilder sb = new StringBuilder(9);
        if (z) {
            sb.append("GMT");
        }
        sb.append(c);
        appendNumber(sb, 2, i2 / 60);
        if (z2) {
            sb.append(':');
        }
        appendNumber(sb, 2, i2 % 60);
        return sb.toString();
    }

    private static void appendNumber(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i2);
        for (int i3 = 0; i3 < i - num.length(); i3++) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static boolean isOperatorEmpty(String str) {
        return str == null || str.equals("") || str.toLowerCase(Locale.US).contains("null");
    }

    public static boolean getDay(int i, int i2) {
        int i3 = i2 * 4;
        return get(i, i3 + 0) || get(i, i3 + 1) || get(i, i3 + 2) || get(i, i3 + 3);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String getFileNameWithTime(int i) {
        Calendar instance = Calendar.getInstance();
        int i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        int i4 = instance.get(5);
        int i5 = instance.get(11);
        int i6 = instance.get(12);
        int i7 = instance.get(13);
        StringBuffer stringBuffer = new StringBuffer();
        if (i == 0) {
            stringBuffer.append("IMG_");
        }
        stringBuffer.append(i2);
        if (i3 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i3);
        if (i4 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i4);
        stringBuffer.append('_');
        if (i5 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i5);
        if (i6 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i6);
        if (i7 < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i7);
        if (i == 0) {
            stringBuffer.append(".jpg");
        } else if (i == 1) {
            stringBuffer.append(".avi");
        } else if (i == 2) {
            stringBuffer.append(".mp5");
        } else if (i == 3) {
            stringBuffer.append(".mp6");
        }
        return stringBuffer.toString();
    }

    public static boolean isMJOldCamera(String str) {
        return str.startsWith("THPC") || str.startsWith("ACCQ") || str.startsWith("THC") || str.startsWith("TH") || str.startsWith("DGN");
    }

    public static boolean isMJCamera(String str) {
        return str.startsWith("HTM") || str.startsWith("HTY") || str.startsWith("OEMAAA") || str.startsWith("ACCQ") || str.startsWith("THPC") || str.startsWith("THC") || str.startsWith("TH") || str.startsWith("DGN");
    }

    public static boolean isMJCameraNewPro(String str) {
        return str.startsWith(ContentCommon.SHIX_APPRE2) || str.startsWith(ContentCommon.SHIX_APPRE1) || str.startsWith("HTM") || str.startsWith("HTY") || str.startsWith("OEMAAA");
    }

    public static String getVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean checkEnable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static String int2ip(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + 255;
    }

    public static String getLocalIpAddress(Context context) {
        try {
            return int2ip(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isHW() {
        Class[] clsArr = {String.class};
        Object[] objArr = {"ro.build.version.emui"};
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
            Log.d("", "HW_get EMUI version is:" + str);
            return !TextUtils.isEmpty(str) && str.length() > 2;
        } catch (ClassNotFoundException unused) {
            Log.e("", " getEmuiVersion wrong, ClassNotFoundException");
        } catch (LinkageError unused2) {
            Log.e("", " getEmuiVersion wrong, LinkageError");
        } catch (NoSuchMethodException unused3) {
            Log.e("", " getEmuiVersion wrong, NoSuchMethodException");
        } catch (NullPointerException unused4) {
            Log.e("", " getEmuiVersion wrong, NullPointerException");
        } catch (Exception unused5) {
            Log.e("", " getEmuiVersion wrong");
        }
    }

    public static void Vibrate(Activity activity, long j) {
        ((Vibrator) activity.getSystemService("vibrator")).vibrate(j);
    }

    public static void Vibrate(Activity activity, long[] jArr, int i) {
        ((Vibrator) activity.getSystemService("vibrator")).vibrate(jArr, i);
    }

    public static final void Log(int i, String str) {
        if (!isLog.booleanValue()) {
            return;
        }
        if (i == 1) {
            Log.e("LOG", "NNN--" + str);
        } else if (i == 2) {
            Log.e("LOG", "NNN--" + str);
        }
    }

    public static final byte integerToOneByte(int i) {
        int i2 = (((double) i) > Math.pow(2.0d, 15.0d) ? 1 : (((double) i) == Math.pow(2.0d, 15.0d) ? 0 : -1));
        return (byte) (i & 255);
    }

    public static final byte[] integerToTwoBytes(int i) {
        int i2 = (((double) i) > Math.pow(2.0d, 31.0d) ? 1 : (((double) i) == Math.pow(2.0d, 31.0d) ? 0 : -1));
        return new byte[]{(byte) ((i >>> 8) & 255), (byte) (i & 255)};
    }

    public static final byte[] integerToFourBytes(int i) {
        int i2 = (((double) i) > Math.pow(2.0d, 63.0d) ? 1 : (((double) i) == Math.pow(2.0d, 63.0d) ? 0 : -1));
        return new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)};
    }

    public static final int twoBytesToInteger(byte[] bArr) {
        int length = bArr.length;
        return ((bArr[0] & UByte.MAX_VALUE) << 8) + (bArr[1] & UByte.MAX_VALUE);
    }

    public static final long fourBytesToLong(byte[] bArr) {
        int length = bArr.length;
        return (((long) (bArr[0] & UByte.MAX_VALUE)) << 24) + ((long) ((bArr[1] & UByte.MAX_VALUE) << 16)) + ((long) ((bArr[2] & UByte.MAX_VALUE) << 8)) + ((long) (bArr[3] & UByte.MAX_VALUE));
    }

    public static final byte[] intToByte(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = new Integer(i & 255).byteValue();
            i >>= 8;
        }
        return bArr;
    }

    public static final int byteToInt(byte[] bArr) {
        byte b = bArr[0] & UByte.MAX_VALUE;
        byte b2 = bArr[1] & UByte.MAX_VALUE;
        return ((bArr[3] & UByte.MAX_VALUE) << 24) | b | (b2 << 8) | ((bArr[2] & UByte.MAX_VALUE) << 16);
    }

    public static byte[] getBytes(char[] cArr) {
        Charset forName = Charset.forName("UTF-8");
        CharBuffer allocate = CharBuffer.allocate(cArr.length);
        allocate.put(cArr);
        allocate.flip();
        return forName.encode(allocate).array();
    }

    public static final byte[] longToByte(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = new Long(255 & j).byteValue();
            j >>= 8;
        }
        return bArr;
    }

    public static final long byteToLong(byte[] bArr) {
        return ((long) (bArr[0] & UByte.MAX_VALUE)) | (((long) (bArr[1] & UByte.MAX_VALUE)) << 8) | (((long) (bArr[2] & UByte.MAX_VALUE)) << 16) | (((long) (bArr[3] & UByte.MAX_VALUE)) << 24) | (((long) (bArr[4] & UByte.MAX_VALUE)) << 32) | (((long) (bArr[5] & UByte.MAX_VALUE)) << 40) | (((long) (bArr[6] & UByte.MAX_VALUE)) << 48) | (((long) (bArr[7] & UByte.MAX_VALUE)) << 56);
    }

    public static int getAndroidVersion() {
        char[] charArray = Build.VERSION.RELEASE.toCharArray();
        String valueOf = (charArray == null || charArray.length < 1) ? null : String.valueOf(charArray[0]);
        if (valueOf == null) {
            return 0;
        }
        return Integer.valueOf(valueOf).intValue();
    }

    public static boolean checkPermission(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static void checkPermissionAll(Activity activity) {
        ArrayList arrayList = new ArrayList();
        if (!checkPermission(activity, "android.permission.READ_EXTERNAL_STORAGE")) {
            arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
        }
        if (!checkPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!checkPermission(activity, "android.permission.RECORD_AUDIO")) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (!checkPermission(activity, "android.permission.CAMERA")) {
            arrayList.add("android.permission.CAMERA");
        }
        if (!checkPermission(activity, "android.permission.ACCESS_WIFI_STATE")) {
            arrayList.add("android.permission.ACCESS_WIFI_STATE");
        }
        if (!checkPermission(activity, "android.permission.ACCESS_WIFI_STATE")) {
            arrayList.add("android.permission.ACCESS_WIFI_STATE");
        }
        if (!checkPermission(activity, "android.permission.ACCESS_NETWORK_STATE")) {
            arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        }
        if (!checkPermission(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if (!checkPermission(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        if (arrayList.size() > 0) {
            String[] strArr = new String[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                strArr[i] = (String) arrayList.get(i);
            }
            ActivityCompat.requestPermissions(activity, strArr, 0);
        }
    }

    public static final String SHIX_setSPK(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_vol");
            jSONObject.put("cmd", TsExtractor.TS_STREAM_TYPE_E_AC3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("outputvol", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_setMIC(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_vol");
            jSONObject.put("cmd", TsExtractor.TS_STREAM_TYPE_E_AC3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("inputvol", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_getSPKMICParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_vol");
            jSONObject.put("cmd", TsExtractor.TS_STREAM_TYPE_SPLICE_INFO);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static void SaveCommonShare(Context context, String str, String str2, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(ContentCommon.SHIX_SHARE_COMMON, 0).edit();
        if (i != -1) {
            edit.putInt(str, i);
        }
        if (str2 != null) {
            edit.putString(str, str2);
        }
        edit.commit();
    }

    public static int GetCommonShareIntValue(Context context, String str, int i) {
        return context.getSharedPreferences(ContentCommon.SHIX_SHARE_COMMON, 0).getInt(str, i);
    }

    public static String GetCommonShareStringValue(Context context, String str, String str2) {
        return context.getSharedPreferences(ContentCommon.SHIX_SHARE_COMMON, 0).getString(str, str2);
    }

    public static final float jasonPaseFloat(JSONObject jSONObject, String str, float f) {
        try {
            return (float) jSONObject.getDouble(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return f;
        }
    }

    public static final int jasonPaseInt(JSONObject jSONObject, String str, int i) {
        if (!jSONObject.has(str)) {
            return i;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static final String jasonPaseString(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static final String getCloudsupport(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_cloudsupport");
            jSONObject.put("cmd", 9000);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getCloudinfo(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_cloudinfo");
            jSONObject.put("cmd", 9002);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setCloudinfo(String str, String str2, String str3, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_cloudinfo");
            jSONObject.put("cmd", AdError.AD_PRESENTATION_ERROR_CODE);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("creatTime", str3);
            jSONObject.put("days", i);
            jSONObject.put("buyType", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String delCloudinfo(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "del_cloudinfo");
            jSONObject.put("cmd", 9003);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getCameraParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_parms");
            jSONObject.put("cmd", 101);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String CameraControl(String str, String str2, String str3, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "dev_control");
            jSONObject.put("cmd", 102);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put(str3, i);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log(1, "CameraControl:" + jSONObject.toString());
        return jSONObject.toString();
    }

    public static final String RebootCamera(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "dev_control");
            jSONObject.put("cmd", 102);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("reboot", 1);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log(1, "CameraControl:" + jSONObject.toString());
        return jSONObject.toString();
    }

    public static final String CutStream(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "stream");
            jSONObject.put("cmd", 111);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("video", i);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getSDParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_sd");
            jSONObject.put("cmd", 109);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getRDParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_param");
            jSONObject.put("cmd", 199);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String formatSDParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_sd");
            jSONObject.put("cmd", 110);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("format", 1);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getAlarmParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_alarm");
            jSONObject.put("cmd", 107);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getRecordDays(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_day");
            jSONObject.put("cmd", 205);
            jSONObject.put("year", i);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getRecordDays2020(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_day");
            jSONObject.put("cmd", 205);
            jSONObject.put("year", 2020);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getRecordList(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_list");
            jSONObject.put("cmd", 206);
            jSONObject.put("ymd", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getRecordHourList(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_hour");
            jSONObject.put("cmd", TTAdConstant.MATE_IS_NULL_CODE);
            jSONObject.put("ymd", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getRecordMinList(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_min");
            jSONObject.put("cmd", TTAdConstant.AD_ID_IS_NULL_CODE);
            jSONObject.put("ymdh", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String playRecordFile(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put("type", 1);
            jSONObject.put("video", 1);
            jSONObject.put(MimeTypes.BASE_TYPE_AUDIO, 1);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
            if (str3.indexOf(".av") > 0 && str3.length() > 8) {
                String substring = str3.substring(0, 4);
                String substring2 = str3.substring(4, 6);
                String substring3 = str3.substring(6, 8);
                jSONObject.put("date", substring + "_" + substring2 + "_" + substring3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String rePlayRecordFile(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put("suspend", 0);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String playRecordAudio(String str, String str2, String str3, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put(MimeTypes.BASE_TYPE_AUDIO, i);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String pauseRecordFile(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put("suspend", 1);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String startTalk(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "talk_send");
            jSONObject.put("cmd", c.COLLECT_MODE_FINANCE);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("isSend", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String offsetRecordFile(String str, String str2, String str3, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put("offset", i);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String stopRecordFile(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put("type", 0);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getWifiParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_wifi");
            jSONObject.put("cmd", 112);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String scanWifi(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "scan_wifi");
            jSONObject.put("cmd", 113);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setBedtemp(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_bedtemp");
            jSONObject.put("cmd", c.COLLECT_MODE_FINANCE);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("tempture", i);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setNoztemp(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_bedtemp");
            jSONObject.put("cmd", 301);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("tempture", i);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getTemp(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_temp");
            jSONObject.put("cmd", IronSourceConstants.OFFERWALL_AVAILABLE);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setX(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_xyz");
            jSONObject.put("cmd", 303);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("xpos", i);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setY(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_xyz");
            jSONObject.put("cmd", 303);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("ypos", i);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setZ(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_xyz");
            jSONObject.put("cmd", 303);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("zpos", i);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getXYZ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_xyz");
            jSONObject.put("cmd", 304);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String resetXYZ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_originxyz");
            jSONObject.put("cmd", IronSourceConstants.OFFERWALL_OPENED);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String startDJ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_startmotors");
            jSONObject.put("cmd", 306);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String stopDJ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_stopmotors");
            jSONObject.put("cmd", 307);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String startFS(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_startfan");
            jSONObject.put("cmd", 308);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String stopFS(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_stopfan");
            jSONObject.put("cmd", 309);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setConnet(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_connect");
            jSONObject.put("cmd", 310);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setDisConnet(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_disconnect");
            jSONObject.put("cmd", 311);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getConnetState(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_prconnectstate");
            jSONObject.put("cmd", 312);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String StartPrinf(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_start");
            jSONObject.put("cmd", 313);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String pausePrinf(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_pause");
            jSONObject.put("cmd", 314);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String resunmPrinf(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_resume");
            jSONObject.put("cmd", 315);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String restartPrinf(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_restart");
            jSONObject.put("cmd", 316);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String offPrinf(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "pr_off");
            jSONObject.put("cmd", 317);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getFiles(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_3dpr_file");
            jSONObject.put("cmd", 203);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String UpdateFileRequst(String str, String str2, String str3, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "upload_file_request");
            jSONObject.put("cmd", 201);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
            jSONObject.put("filesize", j);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String UpdateFile(String str, String str2, String str3, long j, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "upload_file");
            jSONObject.put("cmd", 202);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
            jSONObject.put("filesize", j);
            jSONObject.put("offset", j2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_SetWifi(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_wifi");
            jSONObject.put("cmd", 114);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("wifissid", str3);
            jSONObject.put("wifipwd", str4);
            jSONObject.put("encwifissid", str5);
            jSONObject.put("encwifipwd", str6);
            jSONObject.put("encryption", i);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getUsersParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_user");
            jSONObject.put("cmd", 103);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setSDVideoMode(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_sd");
            jSONObject.put("cmd", 110);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("format", 0);
            jSONObject.put("recMode", i);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String addUsersParms(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "add_user");
            jSONObject.put("cmd", 104);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("newuser", str3);
            jSONObject.put("newpwd", str4);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String editUsersParms(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "edit_user");
            jSONObject.put("cmd", 106);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("edituser", str3);
            jSONObject.put("newuser", str4);
            jSONObject.put("newpwd", str5);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String deleteUsersParms(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "del_user");
            jSONObject.put("cmd", 105);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("deluser", str3);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_GetVideoFiles(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_videofiles");
            jSONObject.put("cmd", 116);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("start_time", str3);
            jSONObject.put("end_time", str4);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_DelVideoFiles(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "del_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StopVideoFiles(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "stop_videofiles");
            jSONObject.put("cmd", 120);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StartVideoFiles(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "start_videofiles");
            jSONObject.put("cmd", 117);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("start_time", str3);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StartTalk(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "start_talk");
            jSONObject.put("cmd", TsExtractor.TS_STREAM_TYPE_AC3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("code", "g711a");
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StopTalk(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "end_talk");
            jSONObject.put("cmd", TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("code", "g711a");
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_GetDateParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_datetime");
            jSONObject.put("cmd", 125);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_SetDateParms(String str, String str2, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_datetime");
            jSONObject.put("cmd", 126);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("tz_offset_min", i);
            jSONObject.put("utc_date_time", i2);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_Heat(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "dev_control");
            jSONObject.put("cmd", 102);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("heart", 1);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_Delpush(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "del_push");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("UserUUID", str3);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_DownLoad(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "file_download");
            jSONObject.put("cmd", IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StopFileDownload(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "stop_download");
            jSONObject.put("cmd", 151);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_CheckOTA(String str, String str2, String str3, String str4, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "check_ota");
            jSONObject.put("cmd", TTAdConstant.LANDING_PAGE_TYPE_CODE);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("devmac", SystemValue.devMac);
            if (str3 != null && str3.length() > 2) {
                jSONObject.put("md5_path", str3);
            }
            if (str4 != null && str4.length() > 2) {
                jSONObject.put("bin_path", str4);
            }
            jSONObject.put("otaType", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_RegistCyPushCloud(String str, String str2, String str3) {
        String deuIp = CommonAppUtil.getDeuIp();
        int deuPort = CommonAppUtil.getDeuPort();
        LogAPP(2, "SHIX_RegistCyPushCloudVideo t_IP1:" + deuIp + "  t_Port1:" + deuPort);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_cypush");
            jSONObject.put("cmd", 1);
            jSONObject.put("user", str2);
            jSONObject.put("pwd", str3);
            jSONObject.put("pushIp", deuIp);
            jSONObject.put("pushPort", deuPort);
            jSONObject.put("pushInterval", 180);
            jSONObject.put("cyAdmin", "admin");
            jSONObject.put("cyPwd", "admin123");
            jSONObject.put("isPushPic", 1);
            jSONObject.put("isPushVideo", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_CloudCyPushCloud(String str, String str2, String str3) {
        String deuIp = CommonAppUtil.getDeuIp();
        int deuPort = CommonAppUtil.getDeuPort();
        LogAPP(2, "SHIX_RegistCyPushCloudVideo t_IP1:" + deuIp + "  t_Port1:" + deuPort);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_cypush");
            jSONObject.put("cmd", 1);
            jSONObject.put("user", str2);
            jSONObject.put("pwd", str3);
            jSONObject.put("pushIp", deuIp);
            jSONObject.put("pushPort", deuPort);
            jSONObject.put("pushInterval", 180);
            jSONObject.put("cyAdmin", "admin");
            jSONObject.put("cyPwd", "admin123");
            jSONObject.put("isPushPic", 0);
            jSONObject.put("isPushVideo", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_RegistCyPushCloudVideo(String str, String str2, String str3) {
        String deuIp = CommonAppUtil.getDeuIp();
        int deuPort = CommonAppUtil.getDeuPort();
        LogAPP(2, "SHIX_RegistCyPushCloudVideo t_IP1:" + deuIp + "  t_Port1:" + deuPort);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_cypush");
            jSONObject.put("cmd", 1);
            jSONObject.put("user", str2);
            jSONObject.put("pwd", str3);
            jSONObject.put("pushIp", deuIp);
            jSONObject.put("pushPort", deuPort);
            jSONObject.put("pushInterval", 180);
            jSONObject.put("cyAdmin", "admin");
            jSONObject.put("cyPwd", "admin123");
            jSONObject.put("isPushPic", 1);
            jSONObject.put("isPushVideo", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_RegistPush(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_push");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("UserUUID", str4);
            jSONObject.put("validity", 120);
            jSONObject.put("enable", 1);
            jSONObject.put("pageName", "com.shix.qhipc");
            jSONObject.put("xm_app_id", ContentCommon.XM_APP_ID);
            jSONObject.put("xm_app_key", ContentCommon.XM_APP_KEY);
            jSONObject.put("xm_app_secret", ContentCommon.XM_APP_Secret);
            jSONObject.put("xm_registid", ContentCommon.XM_REGID);
            jSONObject.put("xm_tips", str3);
            jSONObject.put("hw_app_id", ContentCommon.HW_APP_ID);
            jSONObject.put("hw_app_key", ContentCommon.HW_APPSECRET);
            jSONObject.put("hw_device_token", ContentCommon.HW_STRING);
            jSONObject.put("pustType", 48);
            jSONObject.put("phonetype", 1);
            jSONObject.put("fcm_device_token", str5);
            jSONObject.put("fcm_apiKey", "");
            jSONObject.put("deviceName", str6);
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_RegistPushFCM(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_push");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("account", str4);
            jSONObject.put("push_number", 2);
            jSONObject.put("valid_time", 120);
            jSONObject.put("enable", 1);
            jSONObject.put("app_pack_name", "com.shix.qhipc");
            jSONObject.put("update_time", i);
            jSONObject.put("alarm_bat_low_type", CrashApplication.getContext().getString(R.string.n_alarm_type_4));
            jSONObject.put("alarm_door_type", CrashApplication.getContext().getString(R.string.n_alarm_type_2));
            jSONObject.put("alarm_pir_type", CrashApplication.getContext().getString(R.string.n_alarm_type_3));
            jSONObject.put("alarm_motion_type", CrashApplication.getContext().getString(R.string.n_alarm_type_1));
            jSONObject.put("push_switch", 1);
            jSONObject.put("master", 1);
            if (RomUtil.isEmui()) {
                jSONObject.put("app_id[0]", ContentCommon.HW_APP_ID);
                jSONObject.put("app_key[0]", ContentCommon.HW_APPSECRET);
                jSONObject.put("app_secret[0]", ContentCommon.HW_APPSECRET);
                jSONObject.put("device_token[0]", ContentCommon.HW_STRING);
                jSONObject.put("push_type[0]", 5);
                jSONObject.put("ispush_current[0]", 1);
                jSONObject.put("push_title[0]", str6 + "");
            } else {
                jSONObject.put("app_id[0]", "");
                jSONObject.put("app_key[0]", "");
                jSONObject.put("app_secret[0]", "");
                jSONObject.put("device_token[0]", str5);
                jSONObject.put("push_type[0]", 3);
                jSONObject.put("ispush_current[0]", 1);
                jSONObject.put("push_title[0]", str6 + "");
            }
            jSONObject.put("app_id[1]", ContentCommon.XM_APP_ID);
            jSONObject.put("app_key[1]", ContentCommon.XM_APP_KEY);
            jSONObject.put("app_secret[1]", ContentCommon.XM_APP_Secret);
            jSONObject.put("device_token[1]", ContentCommon.XM_REGID);
            jSONObject.put("push_type[1]", 4);
            jSONObject.put("ispush_current[1]", 1);
            jSONObject.put("push_title[1]", str6 + "");
            jSONObject.put("devmac", SystemValue.devMac);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final Boolean SHIX_isBkDid(String str) {
        if (str == null || str.length() < 1) {
            return false;
        }
        if (str.startsWith("OEMAAA") || str.startsWith(ContentCommon.SHIX_APPRE2) || str.startsWith(ContentCommon.SHIX_APPRE1) || str.startsWith("HBW") || str.startsWith("EEE") || str.startsWith(ContentCommon.SHIX_APPRE3) || str.startsWith(ContentCommon.SHIX_APPRE4) || str.startsWith("DGB")) {
            return true;
        }
        return false;
    }

    public static final Boolean SHIX_isSupportFirstHight(int i) {
        if (i == 10 || i == 10) {
            return true;
        }
        return false;
    }

    public static final Boolean SHIX_isSupportHDOrSD(int i) {
        if (i == 3) {
            return true;
        }
        return false;
    }

    public static final String getSnapshot(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "snap_shot");
            jSONObject.put("cmd", 1001);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final Boolean SHIX_isSupportPrefix(String str) {
        if (str.startsWith("YSJ") || str.startsWith(ContentCommon.SHIX_APPRE) || str.startsWith("ABC") || str.startsWith("XIAODOU") || str.startsWith("IKB") || str.startsWith(ContentCommon.SHIX_APPRE2) || str.startsWith(ContentCommon.SHIX_APPRE1) || str.startsWith("DGB") || str.startsWith("EEE")) {
            return true;
        }
        return false;
    }
}
