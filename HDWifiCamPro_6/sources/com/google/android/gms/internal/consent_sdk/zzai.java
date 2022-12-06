package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
final class zzai implements zzat {
    private final zzaj zza;
    private final zzai zzb = this;
    private final zzcl<zzbi> zzc;
    private final zzcl<zzbc> zzd;
    private final zzcl<zzay> zze;
    private final zzcl zzf;
    private final zzcl<zzbg> zzg;

    /* synthetic */ zzai(zzaj zzaj, zzbc zzbc, zzaf zzaf) {
        this.zza = zzaj;
        this.zzc = zzcg.zza(new zzbj(this.zza.zzb));
        this.zzd = zzci.zza(zzbc);
        this.zze = new zzcf();
        this.zzf = new zzbn(this.zza.zzb, this.zzc, zzao.zza, zzaq.zza, this.zza.zzi, this.zza.zzj, this.zze, this.zza.zzc);
        this.zzg = new zzbh(this.zzc, zzao.zza, this.zzf);
        zzcf.zza(this.zze, zzcg.zza(new zzaz(this.zza.zzb, this.zza.zzd, this.zzc, this.zza.zzc, this.zzd, this.zzg)));
    }

    public final zzay zza() {
        return this.zze.zzb();
    }
}
