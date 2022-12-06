package com.apm.insight.l;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.apm.insight.k.e;

public final class p {
    public static String a(Context context) {
        return a(c(context));
    }

    public static String a(e.b bVar) {
        String str;
        try {
            switch (bVar) {
                case WIFI:
                    str = "wifi";
                    break;
                case MOBILE_2G:
                    str = "2g";
                    break;
                case MOBILE_3G:
                    str = "3g";
                    break;
                case MOBILE_4G:
                    str = "4g";
                    break;
                case MOBILE:
                    str = "mobile";
                    break;
                case MOBILE_5G:
                    str = "5g";
                    break;
                default:
                    return "";
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r2 = r2.getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(android.content.Context r2) {
        /*
            r0 = 0
            java.lang.String r1 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r1)     // Catch:{ Exception -> 0x0019 }
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch:{ Exception -> 0x0019 }
            if (r2 != 0) goto L_0x000c
            return r0
        L_0x000c:
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x0019
            boolean r2 = r2.isAvailable()     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x0019
            r0 = 1
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.l.p.b(android.content.Context):boolean");
    }

    private static e.b c(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return e.b.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    int type = activeNetworkInfo.getType();
                    if (1 == type) {
                        return e.b.WIFI;
                    }
                    if (type != 0) {
                        return e.b.MOBILE;
                    }
                    int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                    if (networkType != 3) {
                        if (networkType == 20) {
                            return e.b.MOBILE_5G;
                        }
                        if (!(networkType == 5 || networkType == 6)) {
                            switch (networkType) {
                                case 8:
                                case 9:
                                case 10:
                                    break;
                                default:
                                    switch (networkType) {
                                        case 12:
                                        case 14:
                                        case 15:
                                            break;
                                        case 13:
                                            return e.b.MOBILE_4G;
                                        default:
                                            return e.b.MOBILE;
                                    }
                            }
                        }
                    }
                    return e.b.MOBILE_3G;
                }
            }
            return e.b.NONE;
        } catch (Throwable unused) {
            return e.b.MOBILE;
        }
    }
}
