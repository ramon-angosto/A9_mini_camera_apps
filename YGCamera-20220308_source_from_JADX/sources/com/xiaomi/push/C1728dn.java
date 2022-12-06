package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* renamed from: com.xiaomi.push.dn */
public class C1728dn implements LoggerInterface {

    /* renamed from: a */
    private LoggerInterface f2057a = null;

    /* renamed from: b */
    private LoggerInterface f2058b = null;

    public C1728dn(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f2057a = loggerInterface;
        this.f2058b = loggerInterface2;
    }

    public void log(String str) {
        LoggerInterface loggerInterface = this.f2057a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.f2058b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.f2057a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        LoggerInterface loggerInterface2 = this.f2058b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }

    public void setTag(String str) {
    }
}
