package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class zzj {
    private static IntentFilter zzauf = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzaug;
    private static float zzauh = Float.NaN;

    @TargetApi(20)
    public static int zzaD(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, zzauf);
        int i = 0;
        if (((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0) {
            i = 1;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((zzb(powerManager) ? 1 : 0) << true) | i;
    }

    public static synchronized float zzaE(Context context) {
        synchronized (zzj.class) {
            if (SystemClock.elapsedRealtime() - zzaug >= 60000 || Float.isNaN(zzauh)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, zzauf);
                if (registerReceiver != null) {
                    zzauh = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzaug = SystemClock.elapsedRealtime();
                float f = zzauh;
                return f;
            }
            float f2 = zzauh;
            return f2;
        }
    }

    @TargetApi(20)
    public static boolean zzb(PowerManager powerManager) {
        return zzs.zzvf() ? powerManager.isInteractive() : powerManager.isScreenOn();
    }
}
