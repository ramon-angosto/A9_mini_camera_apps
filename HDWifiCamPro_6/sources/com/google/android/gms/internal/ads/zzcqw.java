package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcqw implements zzezx {
    private final Context zza;
    private final zzq zzb;
    private final String zzc;
    private final zzcpw zzd;
    private final zzcqw zze = this;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;
    private final zzgxv zzj;
    private final zzgxv zzk;

    /* synthetic */ zzcqw(zzcpw zzcpw, Context context, String str, zzq zzq, zzcqv zzcqv) {
        this.zzd = zzcpw;
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
        this.zzf = zzgxj.zza(context);
        this.zzg = zzgxj.zza(zzq);
        this.zzh = zzgxh.zzc(new zzeog(this.zzd.zzo));
        this.zzi = zzgxh.zzc(zzeol.zza());
        this.zzj = zzgxh.zzc(zzdhx.zza());
        zzgxv zzgxv = this.zzf;
        zzcpw zzcpw2 = this.zzd;
        this.zzk = zzgxh.zzc(new zzezv(zzgxv, zzcpw2.zzp, this.zzg, zzcpw2.zzR, this.zzh, this.zzi, zzfeh.zza(), this.zzj));
    }

    public final zzenm zza() {
        zzcgv zzd2 = this.zzd.zza.zzd();
        zzgxq.zzb(zzd2);
        return new zzenm(this.zza, this.zzb, this.zzc, (zzezu) this.zzk.zzb(), (zzeof) this.zzh.zzb(), zzd2);
    }
}
