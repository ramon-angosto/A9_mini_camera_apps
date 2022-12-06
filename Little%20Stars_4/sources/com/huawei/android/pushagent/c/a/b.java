package com.huawei.android.pushagent.c.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.android.pushagent.plugin.tools.BLocation;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static int a() {
        String str;
        int i = 0;
        Class[] clsArr = {String.class, Integer.TYPE};
        Object[] objArr = {"ro.build.hw_emui_api_level", 0};
        try {
            Class<?> cls = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES);
            i = ((Integer) cls.getDeclaredMethod("getInt", clsArr).invoke(cls, objArr)).intValue();
            e.a(BLocation.TAG, "getEmuiLevel:" + i);
            return i;
        } catch (ClassNotFoundException unused) {
            str = " getEmuiLevel wrong, ClassNotFoundException";
        } catch (ExceptionInInitializerError unused2) {
            str = " getEmuiLevel wrong, ExceptionInInitializerError";
        } catch (LinkageError unused3) {
            str = " getEmuiLevel wrong, LinkageError";
        } catch (NoSuchMethodException unused4) {
            str = " getEmuiLevel wrong, NoSuchMethodException";
        } catch (NullPointerException unused5) {
            str = " getEmuiLevel wrong, NullPointerException";
        } catch (IllegalAccessException unused6) {
            str = " getEmuiLevel wrong, IllegalAccessException";
        } catch (IllegalArgumentException unused7) {
            str = " getEmuiLevel wrong, IllegalArgumentException";
        } catch (InvocationTargetException unused8) {
            str = " getEmuiLevel wrong, InvocationTargetException";
        }
        e.d(BLocation.TAG, str);
        return i;
    }

    public static int a(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
            return -1;
        }
        for (int i = 0; i < allNetworkInfo.length; i++) {
            if (allNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                return allNetworkInfo[i].getType();
            }
        }
        return -1;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = a;
            cArr[i2] = cArr2[(b & 240) >> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            e.a(BLocation.TAG, "jsonString is null");
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            e.c(BLocation.TAG, "cast jsonString to jsonObject error", e);
            return null;
        }
    }

    public static JSONArray b(String str) {
        if (TextUtils.isEmpty(str)) {
            e.a(BLocation.TAG, "jsonString is null");
            return null;
        }
        try {
            return new JSONArray(str);
        } catch (JSONException e) {
            e.c(BLocation.TAG, "cast jsonString to jsonArray error", e);
            return null;
        }
    }

    public static boolean b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null && telephonyManager.getSimState() == 5;
    }

    public static byte[] c(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        try {
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bArr.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("0x");
                int i2 = i * 2;
                sb.append(new String(new byte[]{bytes[i2]}, "UTF-8"));
                bArr[i] = (byte) (((byte) (Byte.decode(sb.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i2 + 1]}, "UTF-8")).byteValue());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bArr;
    }
}
