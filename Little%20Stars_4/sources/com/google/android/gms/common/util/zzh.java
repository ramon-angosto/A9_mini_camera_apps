package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class zzh implements zze {
    private static zzh zzaua;

    public static synchronized zze zzuW() {
        zzh zzh;
        synchronized (zzh.class) {
            if (zzaua == null) {
                zzaua = new zzh();
            }
            zzh = zzaua;
        }
        return zzh;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
