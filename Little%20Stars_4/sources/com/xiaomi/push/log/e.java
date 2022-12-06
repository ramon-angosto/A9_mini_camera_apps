package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

public class e implements LoggerInterface {
    private LoggerInterface a = null;
    private LoggerInterface b = null;

    public e(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.a = loggerInterface;
        this.b = loggerInterface2;
    }

    public void log(String str) {
        LoggerInterface loggerInterface = this.a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        LoggerInterface loggerInterface2 = this.b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }

    public void setTag(String str) {
    }
}
