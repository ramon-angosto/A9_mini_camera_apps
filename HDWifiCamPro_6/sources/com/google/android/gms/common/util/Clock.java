package com.google.android.gms.common.util;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public interface Clock {

    /* renamed from: com.google.android.gms.common.util.Clock$-CC  reason: invalid class name */
    /* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
    public final /* synthetic */ class CC {
        public static long $default$currentThreadTimeMillis(Clock clock) {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    long currentThreadTimeMillis();

    long currentTimeMillis();

    long elapsedRealtime();

    long nanoTime();
}
