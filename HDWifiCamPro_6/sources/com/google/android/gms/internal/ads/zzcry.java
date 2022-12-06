package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcry implements zzfde {
    private final zzcpw zza;
    private final zzcry zzb = this;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;
    private final zzgxv zzj;

    /* synthetic */ zzcry(zzcpw zzcpw, Context context, String str, zzcrx zzcrx) {
        this.zza = zzcpw;
        this.zzc = zzgxj.zza(context);
        zzgxv zzgxv = this.zzc;
        zzcpw zzcpw2 = this.zza;
        this.zzd = new zzfbe(zzgxv, zzcpw2.zzaz, zzcpw2.zzaA);
        this.zze = zzgxh.zzc(new zzfco(zzcpw2.zzaz));
        this.zzf = zzgxh.zzc(zzfec.zza());
        zzgxv zzgxv2 = this.zzc;
        zzcpw zzcpw3 = this.zza;
        this.zzg = zzgxh.zzc(new zzfcy(zzgxv2, zzcpw3.zzp, zzcpw3.zzR, this.zzd, this.zze, zzfeh.zza(), this.zzf));
        this.zzh = zzgxh.zzc(new zzfdi(this.zzg, this.zze, this.zzf));
        this.zzi = zzgxj.zzc(str);
        this.zzj = zzgxh.zzc(new zzfdc(this.zzi, this.zzg, this.zzc, this.zze, this.zzf, this.zza.zzi));
    }

    public final zzfdb zza() {
        return (zzfdb) this.zzj.zzb();
    }

    public final zzfdh zzb() {
        return (zzfdh) this.zzh.zzb();
    }
}
