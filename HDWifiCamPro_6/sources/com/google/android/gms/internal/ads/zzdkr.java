package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdkr {
    private final List zza;
    private final zzfkm zzb;
    private boolean zzc;

    public zzdkr(zzfdk zzfdk, zzfkm zzfkm) {
        this.zza = zzfdk.zzq;
        this.zzb = zzfkm;
    }

    public final void zza() {
        if (!this.zzc) {
            this.zzb.zzd(this.zza);
            this.zzc = true;
        }
    }
}
