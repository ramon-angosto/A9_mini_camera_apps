package com.ironsource.mediationsdk.logger;

import com.ironsource.environment.e.c;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

public final class b extends IronSourceLogger {
    public LogListener c;

    private b() {
        super("publisher");
    }

    public b(LogListener logListener, int i) {
        super("publisher", 1);
        this.c = null;
    }

    public final synchronized void log(final IronSourceLogger.IronSourceTag ironSourceTag, final String str, final int i) {
        c.a.a(new Runnable() {
            public final void run() {
                if (b.this.c != null && str != null) {
                    b.this.c.onLog(ironSourceTag, str, i);
                }
            }
        });
    }

    public final void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th != null) {
            log(ironSourceTag, th.getMessage(), 3);
        }
    }
}
