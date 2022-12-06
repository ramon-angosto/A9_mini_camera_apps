package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.C1728dn;
import com.xiaomi.push.C1729do;
import java.io.File;

public class Logger {
    private static boolean sDisablePushLog = false;
    private static LoggerInterface sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    @Deprecated
    public static File getLogFile(String str) {
        return null;
    }

    protected static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    private static boolean hasWritePermission(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String equals : strArr) {
                    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(equals)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    public static void setPushLog(Context context) {
        boolean z = false;
        boolean z2 = sUserLogger != null;
        if (sDisablePushLog) {
            z2 = false;
        } else if (hasWritePermission(context)) {
            z = true;
        }
        C1729do doVar = null;
        LoggerInterface loggerInterface = z2 ? sUserLogger : null;
        if (z) {
            doVar = C1729do.m3031a(context);
        }
        C1524b.m2150a((LoggerInterface) new C1728dn(loggerInterface, doVar));
    }

    @Deprecated
    public static void uploadLogFile(Context context, boolean z) {
    }
}
