package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzczy implements zzo {
    private final zzdeh zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    public zzczy(zzdeh zzdeh) {
        this.zza = zzdeh;
    }

    private final void zzh() {
        if (!this.zzc.get()) {
            this.zzc.set(true);
            this.zza.zza();
        }
    }

    public final void zzb() {
        this.zza.zzc();
    }

    public final void zzbC() {
        zzh();
    }

    public final void zzbK() {
    }

    public final void zzbr() {
    }

    public final void zze() {
    }

    public final void zzf(int i) {
        this.zzb.set(true);
        zzh();
    }

    public final boolean zzg() {
        return this.zzb.get();
    }
}
