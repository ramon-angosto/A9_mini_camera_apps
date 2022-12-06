package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzm {
    private static final Object zzarP = new Object();
    private static zzm zzarQ;

    public static zzm zzav(Context context) {
        synchronized (zzarP) {
            if (zzarQ == null) {
                zzarQ = new zzn(context.getApplicationContext());
            }
        }
        return zzarQ;
    }

    public abstract boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void zzb(String str, String str2, ServiceConnection serviceConnection, String str3);
}
