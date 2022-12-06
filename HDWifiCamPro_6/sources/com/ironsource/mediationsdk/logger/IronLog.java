package com.ironsource.mediationsdk.logger;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

public enum IronLog {
    API(IronSourceLogger.IronSourceTag.API),
    CALLBACK(IronSourceLogger.IronSourceTag.CALLBACK),
    ADAPTER_API(IronSourceLogger.IronSourceTag.ADAPTER_API),
    ADAPTER_CALLBACK(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK),
    NETWORK(IronSourceLogger.IronSourceTag.NETWORK),
    INTERNAL(IronSourceLogger.IronSourceTag.INTERNAL),
    NATIVE(IronSourceLogger.IronSourceTag.NATIVE),
    EVENT(IronSourceLogger.IronSourceTag.EVENT);
    
    private IronSourceLogger.IronSourceTag a;

    private IronLog(IronSourceLogger.IronSourceTag ironSourceTag) {
        this.a = ironSourceTag;
    }

    private String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return String.format("%s %s", new Object[]{a(stackTrace, 5), b(stackTrace, 5)});
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return a();
        }
        return String.format("%s - %s", new Object[]{a(), str});
    }

    private static String a(StackTraceElement[] stackTraceElementArr, int i) {
        String[] split = stackTraceElementArr[5].getClassName().split("\\.");
        String str = split[split.length - 1];
        return str.contains("$") ? str.split("\\$")[0] : str;
    }

    private static String b(StackTraceElement[] stackTraceElementArr, int i) {
        StackTraceElement stackTraceElement;
        StringBuilder sb;
        StackTraceElement stackTraceElement2;
        String[] split = stackTraceElementArr[5].getClassName().split("\\.");
        String str = split[split.length - 1];
        if (str.contains("$")) {
            String[] split2 = str.split("\\$");
            sb = new StringBuilder();
            sb.append(split2[1]);
            sb.append(".");
            stackTraceElement2 = stackTraceElementArr[5];
        } else {
            if (stackTraceElementArr[5].getMethodName().contains("$")) {
                String[] split3 = stackTraceElementArr[6].getClassName().split("\\$");
                if (split3.length > 1) {
                    sb = new StringBuilder();
                    sb.append(split3[1]);
                    sb.append(".");
                    stackTraceElement2 = stackTraceElementArr[6];
                } else {
                    stackTraceElement = stackTraceElementArr[6];
                }
            } else {
                stackTraceElement = stackTraceElementArr[5];
            }
            return stackTraceElement.getMethodName();
        }
        sb.append(stackTraceElement2.getMethodName());
        return sb.toString();
    }

    public final void error(String str) {
        IronSourceLoggerManager.getLogger().log(this.a, a(str), 3);
    }

    public final void info(String str) {
        IronSourceLoggerManager.getLogger().log(this.a, a(str), 1);
    }

    public final void verbose(String str) {
        IronSourceLoggerManager.getLogger().log(this.a, a(str), 0);
    }

    public final void warning(String str) {
        IronSourceLoggerManager.getLogger().log(this.a, a(str), 2);
    }
}
