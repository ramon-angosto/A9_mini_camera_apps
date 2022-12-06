package com.huawei.hms.framework.common;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;

public class PowerUtils {
    private static final String TAG = "PowerUtils";

    public static final class PowerMode {
        static int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        static int POWER_SAVER_MODE = 4;
        static String SMART_MODE_STATUS = "SmartModeStatus";
    }

    public static boolean isInteractive(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            if (systemService instanceof PowerManager) {
                PowerManager powerManager = (PowerManager) systemService;
                if (Build.VERSION.SDK_INT >= 20) {
                    try {
                        return powerManager.isInteractive();
                    } catch (RuntimeException e) {
                        Logger.m474i(TAG, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName() + e.getMessage());
                    }
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: android.os.PowerManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int readPowerSaverMode(android.content.Context r4) {
        /*
            java.lang.String r0 = "PowerUtils"
            if (r4 == 0) goto L_0x0044
            android.content.ContentResolver r1 = r4.getContentResolver()
            java.lang.String r2 = com.huawei.hms.framework.common.PowerUtils.PowerMode.SMART_MODE_STATUS
            int r3 = com.huawei.hms.framework.common.PowerUtils.PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE
            int r1 = com.huawei.hms.framework.common.SettingUtil.getSystemInt(r1, r2, r3)
            int r2 = com.huawei.hms.framework.common.PowerUtils.PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE
            if (r1 != r2) goto L_0x004a
            r2 = 0
            java.lang.String r3 = "power"
            java.lang.Object r4 = com.huawei.hms.framework.common.ContextCompat.getSystemService(r4, r3)
            boolean r3 = r4 instanceof android.os.PowerManager
            if (r3 == 0) goto L_0x0022
            r2 = r4
            android.os.PowerManager r2 = (android.os.PowerManager) r2
        L_0x0022:
            if (r2 == 0) goto L_0x004a
            int r4 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r4 < r3) goto L_0x003e
            boolean r4 = r2.isPowerSaveMode()     // Catch:{ RuntimeException -> 0x0037 }
            if (r4 == 0) goto L_0x0033
            int r4 = com.huawei.hms.framework.common.PowerUtils.PowerMode.POWER_SAVER_MODE     // Catch:{ RuntimeException -> 0x0037 }
            goto L_0x0035
        L_0x0033:
            int r4 = com.huawei.hms.framework.common.PowerUtils.PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE     // Catch:{ RuntimeException -> 0x0037 }
        L_0x0035:
            r1 = r4
            goto L_0x004a
        L_0x0037:
            r4 = move-exception
            java.lang.String r2 = "dealType rethrowFromSystemServer:"
            com.huawei.hms.framework.common.Logger.m472e((java.lang.String) r0, (java.lang.String) r2, (java.lang.Throwable) r4)
            goto L_0x004a
        L_0x003e:
            java.lang.String r4 = "readPowerSaverMode is control by version!"
            com.huawei.hms.framework.common.Logger.m474i(r0, r4)
            goto L_0x004a
        L_0x0044:
            java.lang.String r4 = "readPowerSaverMode Context is null!"
            com.huawei.hms.framework.common.Logger.m474i(r0, r4)
            r1 = 0
        L_0x004a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.PowerUtils.readPowerSaverMode(android.content.Context):int");
    }

    public static boolean isWhilteList(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            String packageName = context.getPackageName();
            if (powerManager != null && Build.VERSION.SDK_INT >= 23) {
                try {
                    return powerManager.isIgnoringBatteryOptimizations(packageName);
                } catch (RuntimeException e) {
                    Logger.m472e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e);
                }
            }
        }
        return false;
    }

    public static boolean isDozeIdleMode(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            if (powerManager == null) {
                Logger.m474i(TAG, "isDozeIdleMode powerManager is null!");
                return false;
            } else if (Build.VERSION.SDK_INT >= 23) {
                try {
                    return powerManager.isDeviceIdleMode();
                } catch (RuntimeException e) {
                    Logger.m472e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e);
                    return false;
                }
            } else {
                Logger.m474i(TAG, "isDozeIdleMode is version control state!");
                return false;
            }
        } else {
            Logger.m474i(TAG, "isDozeIdleMode Context is null!");
            return false;
        }
    }
}
