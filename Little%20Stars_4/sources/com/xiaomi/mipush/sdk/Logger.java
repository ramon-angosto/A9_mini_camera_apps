package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.log.e;
import com.xiaomi.push.log.f;

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

    private static void setPushLog(Context context) {
        LoggerInterface loggerInterface;
        boolean z = sUserLogger != null;
        f fVar = new f(context);
        if (!sDisablePushLog && hasWritePermission(context) && z) {
            loggerInterface = new e(sUserLogger, fVar);
        } else if (sDisablePushLog || !hasWritePermission(context)) {
            loggerInterface = z ? sUserLogger : new e((LoggerInterface) null, (LoggerInterface) null);
        } else {
            b.a((LoggerInterface) fVar);
            return;
        }
        b.a(loggerInterface);
    }
}
