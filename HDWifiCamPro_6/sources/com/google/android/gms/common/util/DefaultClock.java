package com.google.android.gms.common.util;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public class DefaultClock implements Clock {
    private static final DefaultClock zza = new DefaultClock();

    private DefaultClock() {
    }

    public static Clock getInstance() {
        return zza;
    }

    public final long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public final long nanoTime() {
        return System.nanoTime();
    }
}
