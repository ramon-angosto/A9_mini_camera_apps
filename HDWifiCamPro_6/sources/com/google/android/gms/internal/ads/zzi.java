package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzi {
    public final AudioAttributes zza;

    /* synthetic */ zzi(zzk zzk, zzh zzh) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        if (zzen.zza >= 29) {
            zzf.zza(usage, 1);
        }
        if (zzen.zza >= 32) {
            zzg.zza(usage, 0);
        }
        this.zza = usage.build();
    }
}
