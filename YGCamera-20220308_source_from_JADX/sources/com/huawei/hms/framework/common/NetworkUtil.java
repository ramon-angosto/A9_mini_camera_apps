package com.huawei.hms.framework.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.UserManager;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.android.os.BuildEx;
import com.huawei.android.telephony.ServiceStateEx;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.LinkedList;

public class NetworkUtil {
    private static final int INVALID_RSSI = -127;
    private static final String TAG = NetworkUtil.class.getSimpleName();
    private static final int TYPE_WIFI_P2P = 13;

    public static final class NetType {
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_5G = 5;
        public static final int TYPE_NO_NETWORK = -1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (RuntimeException e) {
            String str = TAG;
            Logger.m474i(str, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName() + e.getMessage());
            return null;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        if (!ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static int getNetworkType(Context context) {
        if (context != null) {
            return getNetworkType(getNetworkInfo(context), context);
        }
        return 0;
    }

    private static int getHwNetworkType(Context context) {
        TelephonyManager telephonyManager;
        ServiceState serviceState;
        if (!ReflectionUtils.checkCompatible(EmuiUtil.BUILDEX_VERSION) || context == null || (telephonyManager = (TelephonyManager) ContextCompat.getSystemService(context, "phone")) == null) {
            return 0;
        }
        try {
            if (BuildEx.VERSION.EMUI_SDK_INT < 21 || (serviceState = telephonyManager.getServiceState()) == null) {
                return 0;
            }
            return ServiceStateEx.getConfigRadioTechnology(serviceState);
        } catch (SecurityException unused) {
            Logger.m478w(TAG, "requires permission maybe missing.");
            return 0;
        } catch (NoSuchMethodError unused2) {
            Logger.m478w(TAG, "NoSuchMethodError occur in method getHwNetworkType.");
            return 0;
        } catch (NoClassDefFoundError unused3) {
            Logger.m478w(TAG, "NoClassDefFoundError occur in method getHwNetworkType.");
            return 0;
        }
    }

    public static int getNetworkType(NetworkInfo networkInfo, Context context) {
        int i;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return -1;
        }
        int type = networkInfo.getType();
        if (1 == type || 13 == type) {
            return 1;
        }
        if (type == 0) {
            int hwNetworkType = getHwNetworkType(context);
            String str = TAG;
            Logger.m476v(str, "getHwNetworkType return is: " + hwNetworkType);
            if (hwNetworkType == 0) {
                hwNetworkType = networkInfo.getSubtype();
            }
            if (hwNetworkType != 20) {
                switch (hwNetworkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        i = 2;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        i = 3;
                        break;
                    case 13:
                        i = 4;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 5;
            }
            if (i != 0 || Build.VERSION.SDK_INT < 25) {
                return i;
            }
            if (hwNetworkType != 16) {
                return hwNetworkType != 17 ? 0 : 3;
            }
            return 2;
        }
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        return getNetworkType(networkInfo, (Context) null);
    }

    private static String[] getDnsServerIpsFromConnectionManager(Context context) {
        ConnectivityManager connectivityManager;
        LinkProperties linkProperties;
        LinkedList linkedList = new LinkedList();
        if (!(Build.VERSION.SDK_INT < 21 || context == null || (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, "connectivity")) == null)) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    for (Network network : connectivityManager.getAllNetworks()) {
                        if (network != null) {
                            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                            if (!(networkInfo == null || networkInfo.getType() != activeNetworkInfo.getType() || (linkProperties = connectivityManager.getLinkProperties(network)) == null)) {
                                for (InetAddress hostAddress : linkProperties.getDnsServers()) {
                                    linkedList.add(hostAddress.getHostAddress());
                                }
                            }
                        }
                    }
                }
            } catch (SecurityException e) {
                Logger.m474i(TAG, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName());
            } catch (RuntimeException e2) {
                Logger.m474i(TAG, "getActiveNetworkInfo failed, exception:" + e2.getClass().getSimpleName());
            }
        }
        return linkedList.isEmpty() ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public static String getDnsServerIps(Context context) {
        return Arrays.toString(getDnsServerIpsFromConnectionManager(context));
    }

    public static int getMobileRsrp(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return 0;
        }
        try {
            final Method declaredMethod = SignalStrength.class.getDeclaredMethod("getDbm", new Class[0]);
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    declaredMethod.setAccessible(true);
                    return null;
                }
            });
            return ((Integer) declaredMethod.invoke(signalStrength, new Object[0])).intValue();
        } catch (NoSuchMethodException unused) {
            Logger.m474i(TAG, "getDbm: function not found");
            return 0;
        } catch (IllegalAccessException unused2) {
            Logger.m474i(TAG, "getDbm: cannot access");
            return 0;
        } catch (InvocationTargetException unused3) {
            Logger.m474i(TAG, "getDbm: InvocationTargetException");
            return 0;
        }
    }

    private static SignalStrength getSignalStrength(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 28) {
            return null;
        }
        Object systemService = ContextCompat.getSystemService(context, "phone");
        if (systemService instanceof TelephonyManager) {
            return ((TelephonyManager) systemService).createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).getSignalStrength();
        }
        return null;
    }

    public static int getMobileRsrpLevel(Context context) {
        SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return 0;
        }
        try {
            final Method declaredMethod = SignalStrength.class.getDeclaredMethod("getLteLevel", new Class[0]);
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    declaredMethod.setAccessible(true);
                    return null;
                }
            });
            return ((Integer) declaredMethod.invoke(signalStrength, new Object[0])).intValue();
        } catch (NoSuchMethodException unused) {
            Logger.m474i(TAG, "getLteLevel: function not found");
            return 0;
        } catch (IllegalAccessException unused2) {
            Logger.m474i(TAG, "getLteLevel: cannot access");
            return 0;
        } catch (InvocationTargetException unused3) {
            Logger.m474i(TAG, "getLteLevel: InvocationTargetException");
            return 0;
        }
    }

    public static int getWifiRssi(Context context) {
        if (context == null) {
            return INVALID_RSSI;
        }
        Object systemService = ContextCompat.getSystemService(context.getApplicationContext(), "wifi");
        if (!(systemService instanceof WifiManager)) {
            return INVALID_RSSI;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
            if (connectionInfo == null || connectionInfo.getBSSID() == null) {
                return INVALID_RSSI;
            }
            return connectionInfo.getRssi();
        } catch (RuntimeException e) {
            String str = TAG;
            Logger.m474i(str, "getWifiRssiLevel did not has permission!" + e.getClass().getSimpleName() + e.getMessage());
            return INVALID_RSSI;
        }
    }

    public static int getWifiRssiLevel(Context context) {
        return WifiManager.calculateSignalLevel(getWifiRssi(context), 5);
    }

    public static String getWifiGatewayIp(Context context) {
        if (context == null) {
            return " ";
        }
        Object systemService = ContextCompat.getSystemService(context.getApplicationContext(), "wifi");
        if (!(systemService instanceof WifiManager)) {
            return " ";
        }
        try {
            int i = ((WifiManager) systemService).getDhcpInfo().gateway;
            return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)}).getHostAddress();
        } catch (RuntimeException | UnknownHostException e) {
            String str = TAG;
            Logger.m474i(str, "getWifiGatewayIp error!" + e.getClass().getSimpleName() + e.getMessage());
            return " ";
        }
    }

    public static NetworkInfo.DetailedState getNetworkStatus(Context context) {
        NetworkInfo.DetailedState detailedState = NetworkInfo.DetailedState.IDLE;
        if (context == null) {
            return detailedState;
        }
        Object systemService = ContextCompat.getSystemService(context, "connectivity");
        if (systemService instanceof ConnectivityManager) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.getDetailedState();
                }
                Logger.m474i(TAG, "getNetworkStatus networkIsConnected netInfo is null!");
                return detailedState;
            } catch (RuntimeException e) {
                String str = TAG;
                Logger.m474i(str, "getNetworkStatus exception" + e.getClass().getSimpleName() + e.getMessage());
                return detailedState;
            }
        } else {
            Logger.m474i(TAG, "getNetworkStatus ConnectivityManager is null!");
            return detailedState;
        }
    }

    public static int readDataSaverMode(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 24 || !ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return 0;
        }
        Object systemService = ContextCompat.getSystemService(context, "connectivity");
        if (!(systemService instanceof ConnectivityManager)) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        try {
            if (connectivityManager.isActiveNetworkMetered()) {
                return connectivityManager.getRestrictBackgroundStatus();
            }
            Logger.m476v(TAG, "ConnectType is not Mobile Network!");
            return 0;
        } catch (RuntimeException e) {
            Logger.m472e(TAG, "SystemServer error:", (Throwable) e);
            return 0;
        }
    }

    public static boolean isSimReady(Context context) {
        Object systemService = ContextCompat.getSystemService(context, "phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        return telephonyManager != null && telephonyManager.getSimState() == 5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.telephony.TelephonyManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMNC(android.content.Context r3) {
        /*
            java.lang.String r0 = "unknown"
            if (r3 != 0) goto L_0x0005
            return r0
        L_0x0005:
            boolean r1 = isSimReady(r3)
            if (r1 != 0) goto L_0x000c
            return r0
        L_0x000c:
            r1 = 0
            java.lang.String r2 = "phone"
            java.lang.Object r3 = com.huawei.hms.framework.common.ContextCompat.getSystemService(r3, r2)
            boolean r2 = r3 instanceof android.telephony.TelephonyManager
            if (r2 == 0) goto L_0x001a
            r1 = r3
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1
        L_0x001a:
            if (r1 != 0) goto L_0x0024
            java.lang.String r3 = TAG
            java.lang.String r1 = "getSubscriptionOperatorType: other error!"
            com.huawei.hms.framework.common.Logger.m471e(r3, r1)
            return r0
        L_0x0024:
            java.lang.String r3 = r1.getNetworkOperator()
            java.lang.String r0 = "46001"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0084
            java.lang.String r0 = "46006"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0084
            java.lang.String r0 = "46009"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0041
            goto L_0x0084
        L_0x0041:
            java.lang.String r0 = "46000"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0081
            java.lang.String r0 = "46002"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0081
            java.lang.String r0 = "46004"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0081
            java.lang.String r0 = "46007"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0062
            goto L_0x0081
        L_0x0062:
            java.lang.String r0 = "46003"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x007e
            java.lang.String r0 = "46005"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x007e
            java.lang.String r0 = "46011"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x007b
            goto L_0x007e
        L_0x007b:
            java.lang.String r3 = "other"
            goto L_0x0086
        L_0x007e:
            java.lang.String r3 = "China_Telecom"
            goto L_0x0086
        L_0x0081:
            java.lang.String r3 = "China_Mobile"
            goto L_0x0086
        L_0x0084:
            java.lang.String r3 = "China_Unicom"
        L_0x0086:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.NetworkUtil.getMNC(android.content.Context):java.lang.String");
    }

    public static String getHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            URI uri = new URI(str);
            if (uri.getPort() == -1) {
                return uri.getHost();
            }
            return uri.getHost() + Constants.COLON_SEPARATOR + uri.getPort();
        } catch (URISyntaxException e) {
            Logger.m478w(TAG, e.getClass().getSimpleName());
            return "";
        }
    }

    public static boolean isUserUnlocked(Context context) {
        UserManager userManager;
        if (Build.VERSION.SDK_INT < 24 || (userManager = (UserManager) ContextCompat.getSystemService(context, "user")) == null) {
            return true;
        }
        try {
            return userManager.isUserUnlocked();
        } catch (RuntimeException e) {
            Logger.m472e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e);
            return true;
        }
    }

    @Deprecated
    public static boolean isForeground(Context context) {
        return ActivityUtil.isForeground(context);
    }

    @Deprecated
    public static NetworkInfo.DetailedState networkStatus(Context context) {
        return getNetworkStatus(context);
    }
}
