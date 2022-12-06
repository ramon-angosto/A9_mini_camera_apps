package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcru implements zzfbq {
    private final zzcpw zza;
    private final zzcru zzb = this;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;

    /* synthetic */ zzcru(zzcpw zzcpw, Context context, String str, zzq zzq, zzcrt zzcrt) {
        this.zza = zzcpw;
        this.zzc = zzgxj.zza(context);
        this.zzd = zzgxj.zza(zzq);
        this.zze = zzgxj.zza(str);
        this.zzf = zzgxh.zzc(new zzeog(this.zza.zzo));
        this.zzg = zzgxh.zzc(new zzfco(this.zza.zzaz));
        zzgxv zzgxv = this.zzc;
        zzcpw zzcpw2 = this.zza;
        this.zzh = zzgxh.zzc(new zzfbo(zzgxv, zzcpw2.zzp, zzcpw2.zzR, this.zzf, this.zzg, zzfeh.zza()));
        this.zzi = zzgxh.zzc(new zzeoo(this.zzc, this.zzd, this.zze, this.zzh, this.zzf, this.zzg, this.zza.zzi));
    }

    public final zzeon zza() {
        return (zzeon) this.zzi.zzb();
    }
}
