package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzekl extends zzekg {
    private final zzcom zza;
    private final zzdck zzb;
    private final zzdim zzc;

    public zzekl(zzcom zzcom, zzdck zzdck, zzdim zzdim) {
        this.zza = zzcom;
        this.zzb = zzdck;
        this.zzc = zzdim;
    }

    /* access modifiers changed from: protected */
    public final zzfzp zzc(zzfef zzfef, Bundle bundle) {
        zzdug zzi = this.zza.zzi();
        zzdck zzdck = this.zzb;
        zzdck.zzf(zzfef);
        zzdck.zzd(bundle);
        zzi.zzd(zzdck.zzg());
        zzi.zzc(this.zzc);
        zzdah zzb2 = zzi.zze().zzb();
        return zzb2.zzh(zzb2.zzi());
    }
}
