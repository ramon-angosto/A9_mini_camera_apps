package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdtz implements zzbqk {
    private final zzdeh zza;
    private final zzcce zzb;
    private final String zzc;
    private final String zzd;

    public zzdtz(zzdeh zzdeh, zzfdk zzfdk) {
        this.zza = zzdeh;
        this.zzb = zzfdk.zzm;
        this.zzc = zzfdk.zzk;
        this.zzd = zzfdk.zzl;
    }

    @ParametersAreNonnullByDefault
    public final void zza(zzcce zzcce) {
        int i;
        String str;
        zzcce zzcce2 = this.zzb;
        if (zzcce2 != null) {
            zzcce = zzcce2;
        }
        if (zzcce != null) {
            str = zzcce.zza;
            i = zzcce.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zzd(new zzcbp(str, i), this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zza.zze();
    }

    public final void zzc() {
        this.zza.zzf();
    }
}
