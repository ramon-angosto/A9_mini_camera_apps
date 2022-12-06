package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzsi;
import java.util.concurrent.Callable;

public class zzb {
    private static SharedPreferences zzaIQ;

    public static SharedPreferences zzn(final Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (zzaIQ == null) {
                zzaIQ = (SharedPreferences) zzsi.zzb(new Callable<SharedPreferences>() {
                    /* renamed from: zzyI */
                    public SharedPreferences call() {
                        return context.getSharedPreferences("google_sdk_flags", 1);
                    }
                });
            }
            sharedPreferences = zzaIQ;
        }
        return sharedPreferences;
    }
}
