package com.huawei.hms.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class NetWorkUtil {

    public static final class NetType {
        public static final int NET = -2;
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_5G = 5;
        public static final int TYPE_NEED_INIT = -1;
        public static final int TYPE_OTHER = 6;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
        public static final int WAP = -3;
    }

    /* renamed from: a */
    public static NetworkInfo m1414a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static int getNetworkType(Context context) {
        return m1413a(m1414a(context));
    }

    /* renamed from: a */
    public static int m1413a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == 1) {
                return 1;
            }
            if (networkInfo.getType() == 0) {
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 15:
                        return 3;
                    case 13:
                    case 14:
                        return 4;
                    default:
                        return 6;
                }
            }
        }
        return 0;
    }
}
