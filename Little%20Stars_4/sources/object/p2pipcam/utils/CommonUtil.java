package object.p2pipcam.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UseValueOf", "ShowToast"})
public class CommonUtil {
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final Boolean isLog = true;

    public static final int oneByteToInteger(byte b) {
        return b & 255;
    }

    public static boolean isMIUI() {
        try {
            BuildProperties newInstance = BuildProperties.newInstance();
            if (newInstance.getProperty(KEY_MIUI_VERSION_CODE, (String) null) == null && newInstance.getProperty(KEY_MIUI_VERSION_NAME, (String) null) == null && newInstance.getProperty(KEY_MIUI_INTERNAL_STORAGE, (String) null) == null) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean isFlyme() {
        return MzSystemUtils.isBrandMeizu();
    }

    public static boolean isHW() {
        Class[] clsArr = {String.class};
        Object[] objArr = {"ro.build.version.emui"};
        try {
            Class<?> cls = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES);
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

    public static final String SHIX_Heat(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pro", "dev_control");
            jSONObject.put("cmd", 102);
            jSONObject.put(DataBaseHelper.KEY_USER, str);
            jSONObject.put(DataBaseHelper.KEY_PWD, str2);
            jSONObject.put("heart", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
