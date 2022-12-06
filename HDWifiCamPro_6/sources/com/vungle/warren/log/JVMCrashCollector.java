package com.vungle.warren.log;

import android.util.Log;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.log.LogManager;
import java.lang.Thread;

class JVMCrashCollector implements Thread.UncaughtExceptionHandler {
    private String collectFilter = LogManager.sDefaultCollectFilter;
    private final Thread.UncaughtExceptionHandler defaultExceptionHandler;
    private LogManager.SdkLoggingEventListener sdkLoggingEventListener;

    JVMCrashCollector(LogManager.SdkLoggingEventListener sdkLoggingEventListener2) {
        this.sdkLoggingEventListener = sdkLoggingEventListener2;
        this.defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (!(!this.sdkLoggingEventListener.isCrashReportEnabled() || thread == null || th == null)) {
            boolean z = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                StackTraceElement[] stackTrace = th2.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (stackTrace[i].getClassName().startsWith(this.collectFilter)) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (z) {
                this.sdkLoggingEventListener.saveLog(VungleLogger.LoggerLevel.CRASH, "crash", Log.getStackTraceString(th), th.getClass().toString(), String.valueOf(thread.getId()));
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateConfig(String str) {
        this.collectFilter = str;
    }
}
