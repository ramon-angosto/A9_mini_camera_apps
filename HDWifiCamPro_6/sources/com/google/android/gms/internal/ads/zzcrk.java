package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcrk implements zzdyz {
    /* access modifiers changed from: private */
    public final Context zza;
    private final zzbqr zzb;
    private final zzcpw zzc;
    private final zzcrk zzd = this;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;

    /* synthetic */ zzcrk(zzcpw zzcpw, Context context, zzbqr zzbqr, zzcrj zzcrj) {
        this.zzc = zzcpw;
        this.zza = context;
        this.zzb = zzbqr;
        this.zze = zzgxj.zza(this.zzd);
        this.zzf = zzgxj.zza(zzbqr);
        this.zzg = new zzdyv(this.zzf);
        this.zzh = zzgxh.zzc(new zzdyx(this.zze, this.zzg));
    }

    public final zzdyq zzb() {
        return new zzcre(this.zzc, this.zzd, (zzcrd) null);
    }

    public final zzdyw zzd() {
        return (zzdyw) this.zzh.zzb();
    }
}
