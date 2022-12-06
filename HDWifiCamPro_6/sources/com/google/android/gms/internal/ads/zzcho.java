package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzcho {
    private final zzchh zza = new zzchh();
    /* access modifiers changed from: private */
    public final AtomicInteger zzb = new AtomicInteger(0);

    public zzcho() {
        zzfzg.zzr(this.zza, new zzchm(this), zzchc.zzf);
    }

    @Deprecated
    public final int zze() {
        return this.zzb.get();
    }

    @Deprecated
    public final void zzg() {
        this.zza.zze(new Exception());
    }

    @Deprecated
    public final void zzh(Object obj) {
        this.zza.zzd(obj);
    }

    @Deprecated
    public final void zzi(zzchl zzchl, zzchj zzchj) {
        zzfzg.zzr(this.zza, new zzchn(this, zzchl, zzchj), zzchc.zzf);
    }
}
