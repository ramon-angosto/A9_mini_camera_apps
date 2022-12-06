package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeke extends zzekg {
    private final zzcom zza;
    private final zzdmy zzb;
    private final zzdck zzc;
    private final zzdim zzd;

    public zzeke(zzcom zzcom, zzdmy zzdmy, zzdck zzdck, zzdim zzdim) {
        this.zza = zzcom;
        this.zzb = zzdmy;
        this.zzc = zzdck;
        this.zzd = zzdim;
    }

    /* access modifiers changed from: protected */
    public final zzfzp zzc(zzfef zzfef, Bundle bundle) {
        zzdnc zzh = this.zza.zzh();
        zzdck zzdck = this.zzc;
        zzdck.zzf(zzfef);
        zzdck.zzd(bundle);
        zzh.zzf(zzdck.zzg());
        zzh.zze(this.zzd);
        zzh.zzd(this.zzb);
        zzh.zzc(new zzcwz((ViewGroup) null));
        zzdah zza2 = zzh.zzg().zza();
        return zza2.zzh(zza2.zzi());
    }
}
