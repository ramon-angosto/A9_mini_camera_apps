package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcyt implements zzdeo, zzbbq {
    private final zzfdk zza;
    private final zzdds zzb;
    private final zzdex zzc;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();

    public zzcyt(zzfdk zzfdk, zzdds zzdds, zzdex zzdex) {
        this.zza = zzfdk;
        this.zzb = zzdds;
        this.zzc = zzdex;
    }

    private final void zza() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    public final void zzc(zzbbp zzbbp) {
        if (this.zza.zzf == 1 && zzbbp.zzj) {
            zza();
        }
        if (zzbbp.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    public final synchronized void zzn() {
        if (this.zza.zzf != 1) {
            zza();
        }
    }
}
