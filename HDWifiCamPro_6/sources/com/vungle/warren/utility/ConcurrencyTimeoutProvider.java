package com.vungle.warren.utility;

import java.util.concurrent.TimeUnit;

public class ConcurrencyTimeoutProvider implements TimeoutProvider {
    private static final long OPERATION_TIMEOUT = TimeUnit.SECONDS.toMillis(4);

    public long getTimeout() {
        if (ThreadUtil.isMainThread()) {
            return OPERATION_TIMEOUT;
        }
        return Long.MAX_VALUE;
    }
}
