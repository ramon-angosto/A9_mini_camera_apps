package com.shix.shixipc.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.huawei.agconnect.exception.AGCServerException;
import com.huawei.hms.adapter.internal.CommonCode;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;
import okhttp3.internal.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonUtil {
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final Boolean isLog = true;

    public static int do0(int i, int i2) {
        return i & ((1 << i2) ^ Integer.MAX_VALUE);
    }

    public static int do1(int i, int i2) {
        return i | (1 << i2);
    }

    public static boolean get(int i, int i2) {
        return (i & (1 << i2)) != 0;
    }

    public static boolean isFlyme() {
        return false;
    }

    public static final int oneByteToInteger(byte b) {
        return b & 255;
    }

    public static boolean isContainChinese(String str) {
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    public static boolean isCN(Context context) {
        String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
        return !TextUtils.isEmpty(simCountryIso) && simCountryIso.toUpperCase(Locale.US).contains("CN");
    }

    private static String getSimOperator(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean isOperatorEmpty(String str) {
        return str == null || str.equals("") || str.toLowerCase(Locale.US).contains("null");
    }

    public static boolean isChinaSimCard(Context context) {
        String simOperator = getSimOperator(context);
        if (isOperatorEmpty(simOperator)) {
            return false;
        }
        return simOperator.startsWith("460");
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
        return ((bArr[0] & 255) << 8) + (bArr[1] & 255);
    }

    public static final long fourBytesToLong(byte[] bArr) {
        int length = bArr.length;
        return (((long) (bArr[0] & 255)) << 24) + ((long) ((bArr[1] & 255) << 16)) + ((long) ((bArr[2] & 255) << 8)) + ((long) (bArr[3] & 255));
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
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
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
        return ((long) (bArr[0] & 255)) | (((long) (bArr[1] & 255)) << 8) | (((long) (bArr[2] & 255)) << 16) | (((long) (bArr[3] & 255)) << 24) | (((long) (bArr[4] & 255)) << 32) | (((long) (bArr[5] & 255)) << 40) | (((long) (bArr[6] & 255)) << 48) | (((long) (bArr[7] & 255)) << 56);
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
            jSONObject.put("cmd", 135);
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
            jSONObject.put("cmd", 135);
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
            jSONObject.put("cmd", 134);
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
        try {
            return jSONObject.getInt(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static final String jasonPaseString(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static final String getCameraParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_parms");
            jSONObject.put("cmd", 101);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String startTalk(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "start_talk");
            jSONObject.put("cmd", 300);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("isStart", i);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getVoiceParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_voice");
            jSONObject.put("cmd", 301);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setVoiceParms(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_voice");
            jSONObject.put("cmd", 302);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("voice", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String sendTrans(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "transMsg");
            jSONObject.put("cmd", 206);
            jSONObject.put("msg", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getUpdata(String str, String str2, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_upgrade_config");
            jSONObject.put("cmd", 130);
            jSONObject.put("check_version", i);
            jSONObject.put(CommonCode.MapKey.UPDATE_VERSION, i2);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getUpdataParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_upgrade_config");
            jSONObject.put("cmd", 140);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String playRecordFile(String str, String str2, String str3, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put("type", 1);
            jSONObject.put("video", 1);
            jSONObject.put("audio", 1);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("position", i);
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

    public static final String playRecordFile(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "play_record_file");
            jSONObject.put("cmd", 207);
            jSONObject.put("type", 1);
            jSONObject.put("video", 1);
            jSONObject.put("audio", 0);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
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
            jSONObject.put("audio", i);
            jSONObject.put(ImagePagerActivity.FILENAME, str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_CheckOTA(String str, String str2, String str3, String str4, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "check_ota");
            jSONObject.put("cmd", 406);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
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

    public static final String getWifiParms(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_wifi");
            jSONObject.put("cmd", 112);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String setBedtemp(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_bedtemp");
            jSONObject.put("cmd", 300);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("tempture", i);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getTemp(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_temp");
            jSONObject.put("cmd", 302);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String resetXYZ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_originxyz");
            jSONObject.put("cmd", 305);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String stopDJ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_stopmotors");
            jSONObject.put("cmd", StatusLine.HTTP_TEMP_REDIRECT);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String startFS(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_startfan");
            jSONObject.put("cmd", StatusLine.HTTP_PERM_REDIRECT);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_SetWifi(String str, String str2, String str3, String str4, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_wifi");
            jSONObject.put("cmd", 114);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("wifissid", str3);
            jSONObject.put("wifipwd", str4);
            jSONObject.put("encryption", i);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StartVideoFiles(String str, String str2, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "start_videofiles");
            jSONObject.put("cmd", 117);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("start_time", j);
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StartTalk(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "start_talk");
            jSONObject.put("cmd", 129);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("code", "g711a");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StopTalk(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "end_talk");
            jSONObject.put("cmd", 130);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("code", "g711a");
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_RegistPush(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7) {
        StringBuilder sb = new StringBuilder();
        sb.append("pustType:");
        int i2 = 0;
        sb.append(0);
        Log(1, sb.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "set_push");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("UserUUID", str4);
            jSONObject.put("validity", 120);
            jSONObject.put("enable", 1);
            jSONObject.put("pageName", "shix.cykj.camera");
            if (ContentCommon.XM_REGID != null && ContentCommon.XM_REGID.length() > 1) {
                i2 = do1(0, 4);
                jSONObject.put("xm_app_id", ContentCommon.XM_APP_ID);
                jSONObject.put("xm_app_key", ContentCommon.XM_APP_KEY);
                jSONObject.put("xm_app_secret", ContentCommon.XM_APP_Secret);
                jSONObject.put("xm_registid", ContentCommon.XM_REGID);
            }
            if (ContentCommon.HW_STRING != null && ContentCommon.HW_STRING.length() > 1) {
                i2 = do1(i2, 5);
                jSONObject.put("hw_app_id", ContentCommon.HW_APP_ID);
                jSONObject.put("hw_app_key", ContentCommon.HW_APP_KEY);
                jSONObject.put("hw_device_token", ContentCommon.HW_STRING);
            }
            if (str5 != null && str5.length() > 1) {
                i2 = do1(i2, 6);
                jSONObject.put("fcm_device_token", str5);
                jSONObject.put("fcm_apiKey", ContentCommon.FCM_SERVER_KEY);
            }
            jSONObject.put("pustType", i2);
            jSONObject.put("phonetype", 1);
            jSONObject.put("deviceName", str7);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_Record_day() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", 115);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StartVideoOffset(String str, String str2, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "start_videofilesOffset");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("seek_time", j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String SHIX_StartVideoOffset(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "start_videofilesOffset");
            jSONObject.put("cmd", 118);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
            jSONObject.put("seek_time", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final Boolean SHIX_isSupportPTZ() {
        return true;
    }

    public static final Boolean SHIX_isSupportTalk() {
        return true;
    }

    public static final Boolean SHIX_isSupportPrefix(String str) {
        if (str.startsWith("YSJ") || str.startsWith("IKB") || str.startsWith("EEE") || str.startsWith("XIAODOU")) {
            return true;
        }
        return false;
    }

    public static final Boolean SHIX_isBkDid(String str) {
        if (str == null || str.length() < 1) {
            return false;
        }
        if (str.startsWith("OEMAAA") || str.startsWith("DBG") || str.startsWith("HBW") || str.startsWith("EEE") || str.startsWith("YSJ") || str.startsWith("XIAODOU")) {
            return true;
        }
        return false;
    }

    public static final Boolean SHIX_is100WDev(String str) {
        if (str.startsWith("IKB") || str.startsWith(ContentCommon.SHIX_APPRE2)) {
            return true;
        }
        return false;
    }

    public static final String getRecordHourList(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_hour");
            jSONObject.put("cmd", AGCServerException.TOKEN_INVALID);
            jSONObject.put("ymd", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static final String getRecordMinList(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "get_record_min");
            jSONObject.put("cmd", 402);
            jSONObject.put("ymdh", str3);
            jSONObject.put("user", str);
            jSONObject.put("pwd", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
