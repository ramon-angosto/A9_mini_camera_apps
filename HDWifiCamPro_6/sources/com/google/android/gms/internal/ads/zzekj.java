package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzekj extends zzekg {
    private final zzcom zza;
    private final zzdck zzb;
    private final zzemp zzc;
    private final zzdim zzd;

    public zzekj(zzcom zzcom, zzdck zzdck, zzemp zzemp, zzdim zzdim) {
        this.zza = zzcom;
        this.zzb = zzdck;
        this.zzc = zzemp;
        this.zzd = zzdim;
    }

    /* access modifiers changed from: protected */
    public final zzfzp zzc(zzfef zzfef, Bundle bundle) {
        zzdmg zzg = this.zza.zzg();
        zzdck zzdck = this.zzb;
        zzdck.zzf(zzfef);
        zzdck.zzd(bundle);
        zzg.zze(zzdck.zzg());
        zzg.zzd(this.zzd);
        zzg.zzc(this.zzc);
        zzdah zza2 = zzg.zzf().zza();
        return zza2.zzh(zza2.zzi());
    }
}
