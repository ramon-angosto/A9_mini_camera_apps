package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzekh extends zzekg {
    private final zzcom zza;
    private final zzdck zzb;
    private final zzemp zzc;
    private final zzdim zzd;
    private final zzdmy zze;
    private final zzdfp zzf;
    private final ViewGroup zzg;
    private final zzdhv zzh;

    public zzekh(zzcom zzcom, zzdck zzdck, zzemp zzemp, zzdim zzdim, zzdmy zzdmy, zzdfp zzdfp, ViewGroup viewGroup, zzdhv zzdhv) {
        this.zza = zzcom;
        this.zzb = zzdck;
        this.zzc = zzemp;
        this.zzd = zzdim;
        this.zze = zzdmy;
        this.zzf = zzdfp;
        this.zzg = viewGroup;
        this.zzh = zzdhv;
    }

    /* access modifiers changed from: protected */
    public final zzfzp zzc(zzfef zzfef, Bundle bundle) {
        zzcxy zze2 = this.zza.zze();
        zzdck zzdck = this.zzb;
        zzdck.zzf(zzfef);
        zzdck.zzd(bundle);
        zze2.zzi(zzdck.zzg());
        zze2.zzf(this.zzd);
        zze2.zze(this.zzc);
        zze2.zzd(this.zze);
        zze2.zzg(new zzcyw(this.zzf, this.zzh));
        zze2.zzc(new zzcwz(this.zzg));
        zzdah zzd2 = zze2.zzj().zzd();
        return zzd2.zzh(zzd2.zzi());
    }
}
