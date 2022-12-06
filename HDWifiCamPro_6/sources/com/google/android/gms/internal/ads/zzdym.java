package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdym implements zzgxi {
    private final zzdyd zza;
    private final zzgxv zzb;
    private final zzgxv zzc;

    public zzdym(zzdyd zzdyd, zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzdyd;
        this.zzb = zzgxv;
        this.zzc = zzgxv2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        Set zzi = zzdyd.zzi((zzdyn) this.zzb.zzb(), zzfzq);
        zzgxq.zzb(zzi);
        return zzi;
    }
}
