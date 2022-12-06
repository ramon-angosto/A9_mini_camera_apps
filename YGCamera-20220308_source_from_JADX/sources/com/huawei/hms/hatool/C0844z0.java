package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import androidx.core.p003os.EnvironmentCompat;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.huawei.hms.hatool.z0 */
public class C0844z0 extends C0790f {
    /* renamed from: c */
    public static String m1110c() {
        String str;
        String str2;
        try {
            str = (String) Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke((Object) null, new Object[0]);
            try {
                C0841y.m1087c("hmsSdk", "getUDID success");
            } catch (ClassNotFoundException unused) {
            } catch (AndroidRuntimeException unused2) {
                str2 = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
                C0841y.m1092f("hmsSdk", str2);
                return str;
            } catch (NoSuchMethodException unused3) {
                str2 = "getUDID method invoke failed : NoSuchMethodException";
                C0841y.m1092f("hmsSdk", str2);
                return str;
            } catch (IllegalAccessException unused4) {
                str2 = "getUDID method invoke failed : Illegal AccessException";
                C0841y.m1092f("hmsSdk", str2);
                return str;
            } catch (IllegalArgumentException unused5) {
                str2 = "getUDID method invoke failed : Illegal ArgumentException";
                C0841y.m1092f("hmsSdk", str2);
                return str;
            } catch (InvocationTargetException unused6) {
                str2 = "getUDID method invoke failed : InvocationTargetException";
                C0841y.m1092f("hmsSdk", str2);
                return str;
            }
        } catch (ClassNotFoundException unused7) {
            str = "";
            str2 = "getUDID method invoke failed";
            C0841y.m1092f("hmsSdk", str2);
            return str;
        } catch (AndroidRuntimeException unused8) {
            str = "";
            str2 = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
            C0841y.m1092f("hmsSdk", str2);
            return str;
        } catch (NoSuchMethodException unused9) {
            str = "";
            str2 = "getUDID method invoke failed : NoSuchMethodException";
            C0841y.m1092f("hmsSdk", str2);
            return str;
        } catch (IllegalAccessException unused10) {
            str = "";
            str2 = "getUDID method invoke failed : Illegal AccessException";
            C0841y.m1092f("hmsSdk", str2);
            return str;
        } catch (IllegalArgumentException unused11) {
            str = "";
            str2 = "getUDID method invoke failed : Illegal ArgumentException";
            C0841y.m1092f("hmsSdk", str2);
            return str;
        } catch (InvocationTargetException unused12) {
            str = "";
            str2 = "getUDID method invoke failed : InvocationTargetException";
            C0841y.m1092f("hmsSdk", str2);
            return str;
        }
        return str;
    }

    /* renamed from: e */
    public static Pair<String, String> m1111e(Context context) {
        if (C0822p0.m988a(context, "android.permission.READ_PHONE_STATE")) {
            C0841y.m1092f("hmsSdk", "getMccAndMnc() Pair value is empty");
            return new Pair<>("", "");
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return new Pair<>("", "");
        }
        if (telephonyManager.getSimState() != 5) {
            return new Pair<>("", "");
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        return (TextUtils.isEmpty(networkOperator) || TextUtils.equals(networkOperator, "null")) ? new Pair<>("", "") : networkOperator.length() > 3 ? new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3)) : new Pair<>("", "");
    }

    /* renamed from: f */
    public static String m1112f(Context context) {
        if (C0822p0.m988a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getDeviceId() : "";
        } catch (SecurityException unused) {
            C0841y.m1084b("hmsSdk", "getDeviceID Incorrect permissions!");
            return "";
        }
    }

    /* renamed from: g */
    public static String m1113g(Context context) {
        C0841y.m1081a("hmsSdk", "getSerial : is executed.");
        if (context == null || C0822p0.m988a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : "";
        } catch (SecurityException unused) {
            C0841y.m1092f("hmsSdk", "getSerial() Incorrect permissions!");
            return "";
        }
    }

    /* renamed from: h */
    public static String m1114h(Context context) {
        String str = Build.SERIAL;
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase(EnvironmentCompat.MEDIA_UNKNOWN)) ? m1113g(context) : str;
    }
}
