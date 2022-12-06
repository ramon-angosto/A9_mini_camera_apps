package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.reflect.a;
import com.xiaomi.channel.commonutils.string.d;

public class e {
    private static String a;
    private static String b;
    private static String c;

    public static String a() {
        if (Build.VERSION.SDK_INT > 8) {
            return Build.SERIAL;
        }
        return null;
    }

    public static String a(Context context) {
        if (b == null) {
            String c2 = c(context);
            String b2 = b(context);
            String a2 = a();
            StringBuilder sb = new StringBuilder();
            sb.append("a-");
            sb.append(d.b(c2 + b2 + a2));
            b = sb.toString();
        }
        return b;
    }

    @TargetApi(17)
    public static int b() {
        Object a2;
        if (Build.VERSION.SDK_INT >= 17 && (a2 = a.a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return Integer.class.cast(a2).intValue();
        }
        return -1;
    }

    public static String b(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static String c(Context context) {
        String d = d(context);
        int i = 10;
        while (d == null) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            d = d(context);
            if (d != null) {
                b.d("block Get imei success: " + d + " at cnt:" + i2);
            }
            i = i2;
        }
        return d;
    }

    public static String d(Context context) {
        String str;
        Object a2;
        String str2 = a;
        if (str2 != null) {
            return str2;
        }
        try {
            if (!f.a() || (a2 = a.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null) {
                str = null;
            } else {
                Object a3 = a.a(a2, "getMiuiDeviceId", new Object[0]);
                if (a3 == null || !(a3 instanceof String)) {
                    b.d("getMiuiDeviceId() failed, when Get imei.");
                    str = null;
                } else {
                    str = String.class.cast(a3);
                }
                if (str != null) {
                    b.a("Get imei by miui.telephony.TelephonyManager success, imei:" + str);
                }
            }
            if (str == null) {
                if (h(context)) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    str = telephonyManager.getDeviceId();
                    if (str != null) {
                        b.a("Get imei by " + telephonyManager.getClass().getName() + " success, imei: " + str);
                    }
                } else {
                    b.d("Get imei Failed, need permission android.permission.READ_PHONE_STATE");
                }
            }
            if (str != null) {
                a = str;
            }
            return str;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static synchronized String e(Context context) {
        synchronized (e.class) {
            if (c != null) {
                String str = c;
                return str;
            }
            String b2 = b(context);
            String a2 = a();
            c = d.b(b2 + a2);
            String str2 = c;
            return str2;
        }
    }

    public static String f(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static String g(Context context) {
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            b.a((Throwable) e);
            return null;
        }
    }

    private static boolean h(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }
}
