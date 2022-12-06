package com.apm.insight.l;

public final class x {
    public static Thread a(Runnable runnable, String str) {
        if (runnable == null) {
            return null;
        }
        Thread thread = str == null ? new Thread(runnable) : new Thread(runnable, str);
        thread.start();
        return thread;
    }
}
