package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdld extends zzdij {
    private boolean zzb;

    protected zzdld(Set set) {
        super(set);
    }

    public final void zza() {
        zzo(zzdkz.zza);
    }

    public final void zzb() {
        zzo(zzdlb.zza);
    }

    public final synchronized void zzc() {
        if (!this.zzb) {
            zzo(zzdla.zza);
            this.zzb = true;
        }
        zzo(zzdlc.zza);
    }

    public final synchronized void zzd() {
        zzo(zzdla.zza);
        this.zzb = true;
    }
}
