package com.meizu.cloud.pushsdk.common.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.common.b.e;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class b {
    private static String a = "";
    private static String b = "";

    public static boolean a() {
        e.c a2 = f.a("ro.target.product");
        if (!a2.a || TextUtils.isEmpty((CharSequence) a2.b)) {
            c.b("DeviceUtils", "current product is phone");
            return true;
        }
        c.b("DeviceUtils", "current product is " + ((String) a2.b));
        return false;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            if (a()) {
                b = h.a(context);
            } else if (TextUtils.isEmpty(b)) {
                StringBuilder sb = new StringBuilder();
                String str = Build.SERIAL;
                c.b("DeviceUtils", "device serial " + str);
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    String b2 = b(context);
                    c.d("DeviceUtils", "mac address " + b2);
                    if (!TextUtils.isEmpty(b2)) {
                        sb.append(b2.replace(":", "").toUpperCase());
                        b = sb.toString();
                    }
                }
                return null;
            }
        }
        return b;
    }

    public static String b(Context context) {
        WifiInfo connectionInfo;
        String macAddress;
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String str = null;
        if (Build.VERSION.SDK_INT >= 23) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    macAddress = a("wlan0");
                    if (TextUtils.isEmpty(macAddress)) {
                        macAddress = a("eth0");
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    macAddress = a("wlan0");
                } else if (activeNetworkInfo.getType() == 9) {
                    macAddress = a("eth0");
                }
            }
            a = str;
            return a;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (!(wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null)) {
            macAddress = connectionInfo.getMacAddress();
        }
        a = str;
        return a;
        str = macAddress;
        a = str;
        return a;
    }

    private static String a(String str) {
        String str2 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("/sys/class/net/" + str + "/address");
            Scanner scanner = new Scanner(fileInputStream);
            if (scanner.hasNextLine()) {
                str2 = scanner.nextLine().trim();
            }
            fileInputStream.close();
        } catch (FileNotFoundException unused) {
            c.d("DeviceUtils", "getMacAddressWithIfName File not found Exception");
        } catch (IOException unused2) {
            c.d("DeviceUtils", "getMacAddressWithIfName IOException");
        }
        return str2;
    }
}
